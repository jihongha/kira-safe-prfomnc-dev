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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public ModelAndView operatorExec(@RequestParam HashMap<String , String> paramMap) throws Exception {
        
		System.out.println("paramMap to String :::::::: " + paramMap.toString());
		
		int		kppMembExstCnt	=	0;
		EgovMap kppMembInfo 	= 	new EgovMap();
		
		//관리자 계정정보 존재여부 확인
		kppMembExstCnt = adminMainService.selectKppIntraOpeMembExstCnt(paramMap);
		
		//관리자 계정정보가 존재할 경우
		if(kppMembExstCnt > 0) {
			//관리자 정보 조회
			kppMembInfo = adminMainService.selectKppIntraOpeMembInfo(paramMap);
			System.out.println("kppMembInfo to String :::::" + kppMembInfo.toString());
			
		}
		
        HashMap hashMap = new HashMap();
        //hashMap.put("collectHistList", collectHistList);
        
        ModelAndView modelAndView = new ModelAndView("jsonView",hashMap);
        return modelAndView;
    }
	
}
