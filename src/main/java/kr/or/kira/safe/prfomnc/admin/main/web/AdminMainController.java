/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.or.kira.safe.prfomnc.admin.main.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.admin.main.service.AdminMainService;
import kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil;

/**
 * @Class Name : AdminMainController.java
 * @Description : AdminMainController Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021.10.12           최초생성
 *
 * @author 하지홍
 * @since 2021. 10.12
 * @version 1.0
 * @see
 *
 */

@Controller
public class AdminMainController {

	/** adminMainService */
	@Resource(name = "adminMainService")
	private AdminMainService adminMainService; 

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	 
	
	/**
	 * 관리자 로그인 페이지
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login/operator.do")
	public String operator(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		return "admin/login/operator.noTiles";
	}
	
	/**
	 * 관리자 로그인 처리
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login/operatorExec.ajax")
    public ModelAndView operatorExec(@RequestParam HashMap<String , String> paramMap, HttpServletRequest request) throws Exception {
        
		
		int		kppMembExstCnt	=	0;
		String	loginSuccAt		=	"N";
		EgovMap kppMembInfo 	= 	new EgovMap();
		
		//관리자 계정정보 존재여부 확인
		kppMembExstCnt = adminMainService.selectKppIntraOpeMembExstCnt(paramMap);
		
		//관리자 계정정보가 존재할 경우
		if(kppMembExstCnt > 0) {
			//관리자 정보 조회
			kppMembInfo = adminMainService.selectKppIntraOpeMembInfo(paramMap);
			
			/**
			 * kppSbscrbConfmAt
			 * S : 가입승인전
			 * Y : 가입승인완료
			 * N : 가입승인거절
			 */
			loginSuccAt	=	(String)kppMembInfo.get("kppSbscrbConfmAt");
			
			if("Y".equals(loginSuccAt)) {
				// 세션 정보 저장
				EgovSessionCookieUtil.setSessionAttribute(request, "kppMembInfo", kppMembInfo);
			}
			// 세션 정보 출력 (모든 세션 정보 표시)
			System.out.println("Session Infos : " + EgovSessionCookieUtil.getSessionValuesString(request));
			// 특정 세션 정보 취득
			//String userId = (String)EgovSessionCookieUtil.getSessionAttribute(request, "USER_ID");
		}else {
			loginSuccAt	=	"N";
		}
		
        HashMap hashMap = new HashMap();
        hashMap.put("loginSuccAt", loginSuccAt);
        
        ModelAndView modelAndView = new ModelAndView("jsonView",hashMap);
        return modelAndView;
    }
	
	
	/**
	 * 관리자 회원가입 페이지 
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login/join.do")
	public String join(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		return "admin/login/join.noTiles";
	}
	
	/**
	 * 관리자 아이디 유효성 체크
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login/dupKppMembIdChk.ajax")
    public ModelAndView dupKppMembIdChk(@RequestParam HashMap<String , String> paramMap, HttpServletRequest request) throws Exception {
        
		
		int		kppMembIdDupCnt			=	0;
		String	dupKppMembIdChkAt		=	"N";
		
		//관리자 계정 아이디 존재여부 확인
		kppMembIdDupCnt = adminMainService.selectKppIntraOpeMembDupCnt(paramMap);
		
		//관리자 계정 아이디가 존재할 경우
		if(kppMembIdDupCnt > 0) {
			dupKppMembIdChkAt		=		"Y";  
		}else {
			dupKppMembIdChkAt		=		"N";
		}
		
        HashMap hashMap = new HashMap();
        hashMap.put("dupKppMembIdChkAt", dupKppMembIdChkAt);
        
        ModelAndView modelAndView = new ModelAndView("jsonView",hashMap);
        return modelAndView;
    }
	
	
	/**
	 * 관리자 회원가입 처리
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login/joinExec.ajax")
    public ModelAndView joinExec(@RequestParam HashMap<String , String> paramMap, HttpServletRequest request) throws Exception {
        
		
		int		kppMembJoinCnt	=	0;
		String	joinSuccAt		=	"N";
		
		//관리자 회원가입 처리
		kppMembJoinCnt = adminMainService.insertKppIntraOpeMembExec(paramMap);
		if(kppMembJoinCnt > 0) {
			joinSuccAt		=		"Y";
		}
		
        HashMap hashMap = new HashMap();
        hashMap.put("joinSuccAt", joinSuccAt);
        
        ModelAndView modelAndView = new ModelAndView("jsonView",hashMap);
        return modelAndView;
    }
	
	
	/**
	 * 로그아웃 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/login/logout.do")
	public String logout(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		//세션삭제처리
		EgovSessionCookieUtil.removeSessionAttribute(request, "kppMembInfo");
		
		return "admin/login/operator.noTiles";
	}
}
