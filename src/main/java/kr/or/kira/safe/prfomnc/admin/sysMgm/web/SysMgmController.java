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
package kr.or.kira.safe.prfomnc.admin.sysMgm.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.admin.sysMgm.service.SysMgmService;
import kr.or.kira.safe.prfomnc.cmmn.service.CommMgmService;

/**
 * @Class Name : UserBoardController.java
 * @Description : UserBoardController Class
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
public class SysMgmController {

	/** sysMgmService */
	@Resource(name = "sysMgmService")
	private SysMgmService sysMgmService;
	
	/** commMgmService */
	@Resource(name = "commMgmService")
	private CommMgmService commMgmService;  

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	
	/**
	 * 시스템관리 사용자관리 목록조회
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/sysMgm/kppIntraMembLst.do")
	public String kppIntraMembLst(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		//시스템관리 사용자관리 목록조회
		List<?> kppIntraMembLst = sysMgmService.selectkppIntraMembListInfo(paramMap);
		
		model.addAttribute("kppIntraMembLst", kppIntraMembLst);
		model.addAttribute("topMenuCd", "sysMgm");
		model.addAttribute("subMenuCd", "kppIntraMemb");
		
		return "admin/sysMgm/kppIntraMembLst.kppTiles";
	}
	
	 
	
	/**
	 * 시스템관리 사용자관리 상세조회
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/sysMgm/kppIntraMembDetView.do")
	public String kppIntraMembDetView(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		//시스템관리 사용자관리 상세조회
		EgovMap kppIntraMembInfo = sysMgmService.selectKppIntraMembDetViewInfo(paramMap);
		
		model.addAttribute("kppIntraMembInfo"		, kppIntraMembInfo);
		model.addAttribute("topMenuCd"				, "sysMgm");
		model.addAttribute("subMenuCd"				, "kppIntraMemb");
		
		return "admin/sysMgm/kppIntraMembDetView.kppTiles";
	}	
	
	
	/**
	 * 시스템관리 사용자 관리 가입승인, 반려처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/sysMgm/kppIntraSbscrbUpdtExec.do")
	public String kppIntraSbscrbUpdtExec(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		int		updtResultCnt			=	0;
		
		//시스템관리 사용자 관리 가입승인, 반려처리
		updtResultCnt = sysMgmService.saveKppIntraSbscrbUpdtExec(paramMap);
		
		model.addAttribute("topMenuCd", "sysMgm");
		model.addAttribute("subMenuCd", "kppIntraMemb");
		
		return "redirect:/admin/sysMgm/kppIntraMembLst.do";
	}	
		
		
		
}
