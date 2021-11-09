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
package kr.or.kira.safe.prfomnc.users.main.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.fdl.property.EgovPropertyService;
import kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil;
import kr.or.kira.safe.prfomnc.users.main.service.UserMainService;

/**
 * @Class Name : UserMainController.java
 * @Description : UserMainController Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021.10.12           최초생성
 *
 * @author 이승연
 * @since 2021. 10.31
 * @version 1.0
 * @see
 *
 */

@Controller
public class UserMainController {

	/** EgovSampleService */
	@Resource(name = "userMainService")
	private UserMainService userMainService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	final String USER = "USER";
	final String CHCKER = "CHCKER";
	final String YES = "Y";
	final String NO = "N";
	
	/**
	 * 로그인
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/userLogin.do")
	public String userLogin(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("로그인창 화면 조회 시작");
		
		return "users/main/userLogin.bppTiles";
	}
	
	/**
	 * 로그인 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/user/main/selectBppMembMgmExists.do", method=RequestMethod.POST)
	public HashMap<String, String> selectBppMembMgmExists(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		HashMap<String, String> resultMap = userMainService.selectBppMembMgmExists(paramMap);
		System.out.println("로긴결과: " + resultMap.toString());
		if (resultMap.get("isSucceeded") == YES) {
			EgovSessionCookieUtil.setSessionAttribute(request, "loginId", resultMap.get("bppMembId"));
			EgovSessionCookieUtil.setSessionAttribute(request, "loginNm", resultMap.get("bppMembNm"));
			EgovSessionCookieUtil.setSessionAttribute(request, "loginTy", resultMap.get("bppMembTy"));
		}
		
		System.out.println("로그인 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 회원가입 성공 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/successRegister.do")
	public String successRegister(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("회원가입 성공 화면 조회 시작");
		
		return "users/main/successRegister.bppTiles";
	}
	
	/**
	 * 사용자 이용약관
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/useTerms.do")
	public String userTerms(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("이용약관 화면 조회 시작");
		
		return "users/main/useTerms.bppTiles";
	}
	
	/**
	 * 회원가입 유형 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/registerType.do")
	public String registerType(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("회원가입 유형 화면 조회 시작");
		
		return "users/main/registerType.bppTiles";
	}
	
	/**
	 * 일반사용자 회원가입 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/userRegister.do")
	public String userRegister(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("일반사용자 화면 조회 시작");
		
		return "users/main/userRegister.bppTiles";
	}
	
	/**
	 * 일반사용자 회원가입 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/user/main/insertBppMembMgmUser.do", method = RequestMethod.POST)
	public HashMap<String, String> insertBppMembMgmUser(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		paramMap.put("bppMembTy", USER);
		paramMap.put("useStplatAgreAt", YES);
		paramMap.put("indvInfoAgreAt", YES);
		
		HashMap<String, String> resultMap = userMainService.insertBppMembMgm(paramMap);
		
		System.out.println("일반사용자 회원가입 처리 완료--->" + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 검토자 회원가입 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/chckerRegister.do")
	public String chckerRegister(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("검토자 회원가입 화면 조회 시작");
		
		return "users/main/chckerRegister.bppTiles";
	}
	
	/**
	 * 검토자 회원가입 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/user/main/insertBppMembMgmChcker.do", method = RequestMethod.POST)
	public HashMap<String, String> insertBppMembMgmChcker(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		paramMap.put("bppMembTy", CHCKER);
		paramMap.put("useStplatAgreAt", YES);
		paramMap.put("indvInfoAgreAt", YES);
		
		HashMap<String, String> resultMap = userMainService.insertBppMembMgm(paramMap);
		
		System.out.println("검토자 회원가입 처리 완료--->" + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 아이디 중복체크
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/user/main/selectBppMembIdNotExists.do", method = RequestMethod.POST)
	public HashMap<String, String> selectBppMembIdNotExists(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		HashMap<String, String> resultMap = userMainService.selectBppMembIdNotExists(paramMap);
		
		System.out.println("아이디 중복체크 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 아이디 찾기 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/findBppMembId.do")
	public String findBppMembId(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("아이디 찾기 화면 조회 시작");
		
		return "users/main/findBppMembId.bppTiles";
	}
	
	/**
	 * 아이디 찾기 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/selectBppMembId.do")
	@ResponseBody
	public HashMap<String, String> selectBppMembId(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		HashMap<String, String> resultMap = userMainService.selectBppMembId(paramMap);
		
		System.out.println("아이디 찾기 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 아이디 찾기 성공 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/successFindBppMembId.do", method=RequestMethod.POST)
	public String successFindBppMembId(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		System.out.println("아이디 찾기 성공 화면 시작---> " + paramMap.toString());
		
		model.addAttribute("bppMembId", paramMap.get("bppMembId"));
		
		return "users/main/successFindBppMembId.bppTiles";
	}
	
	/**
	 * 비밀번호 찾기 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/findBppMembPwd.do")
	public String findBppMembPwd(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("비밀번호 찾기 화면 조회 시작");
		
		return "users/main/findBppMembPwd.bppTiles";
	}
	
	/**
	 * 비밀번호 찾기 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/selectBppMembPwd.do")
	@ResponseBody
	public HashMap<String, String> selectBppMembPwd(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		System.out.println("비밀번호 찾기 처리 시작---> " + paramMap.toString());
		
		HashMap<String, String> resultMap = userMainService.selectBppMembPwd(paramMap);
		
		if (resultMap.get("isSucceeded") == YES) {
			EgovSessionCookieUtil.setSessionAttribute(request, "tempoBppMembId", resultMap.get("bppMembId"));
		}
		
		System.out.println("비밀번호 찾기 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 비밀번호 초기화 화면
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/resetBppMembPwd.do")
	public String resetBppMembPwd(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "intrcn");
		model.addAttribute("subMenuCd", "intrcn");
		
		System.out.println("비밀번호 찾기 화면 조회 시작");
		System.out.println("session: " + EgovSessionCookieUtil.getSessionValuesString(request));
		
		return "users/main/resetBppMembPwd.bppTiles";
	}
	
	/**
	 * 비밀번호 초기화 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/updateBppMembPwd.do")
	@ResponseBody
	public HashMap<String, String> updateBppMembPwd(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		System.out.println("비밀번호 초기화 처리 시작---> " + paramMap.toString());
		
		HashMap<String, String> resultMap = userMainService.updateBppMembPwd(paramMap);
		
		EgovSessionCookieUtil.removeSessionAttribute(request, "tempoBppMembId");
		
		System.out.println("비밀번호 초기화 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 로그아웃 처리
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/main/userLogout.do")
	public String userLogout(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		System.out.println("로그아웃 처리 시작");
		
		EgovSessionCookieUtil.removeSessionAttribute(request, "loginId");
		EgovSessionCookieUtil.removeSessionAttribute(request, "loginNm");
		EgovSessionCookieUtil.removeSessionAttribute(request, "loginTy");
		
		System.out.println("로그아웃 처리 완료");
		
		return "users/main/userLogin.bppTiles";
	}
	  
}
