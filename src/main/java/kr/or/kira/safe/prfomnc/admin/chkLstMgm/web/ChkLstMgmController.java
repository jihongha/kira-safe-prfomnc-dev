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
package kr.or.kira.safe.prfomnc.admin.chkLstMgm.web;

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
import kr.or.kira.safe.prfomnc.admin.board.service.AdminBoardService;
import kr.or.kira.safe.prfomnc.admin.chkLstMgm.service.ChkLstMgmService;
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
public class ChkLstMgmController {

	/** chkLstMgmService */
	@Resource(name = "chkLstMgmService")
	private ChkLstMgmService chkLstMgmService;
	
	/** commMgmService */
	@Resource(name = "commMgmService")
	private CommMgmService commMgmService;  

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록조회
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/chkLstMgm/lawChkLst.do")
	public String lawChkLst(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		//한국건축규정 체크리스트 항목관리 목록조회
		List<?> kppLawordMgmLst = chkLstMgmService.selectKppLawordMgmListInfo(paramMap);
		
		model.addAttribute("kppLawordMgmLst", kppLawordMgmLst);
		model.addAttribute("topMenuCd", "chkLstMgm");
		model.addAttribute("subMenuCd", "lawChkLst");
		
		return "admin/chkLstMgm/lawChkLst.kppTiles";
	}
	
	
	
	@RequestMapping(value = "/admin/chkLstMgm/lawChkLstDetView.do")
	public String lawChkLstDetView(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		//한국건축규정 체크리스트 항목관리 상세조회
		EgovMap kppLawordMgmInfo = chkLstMgmService.selectKppLawordMgmInfo(paramMap);
		
		model.addAttribute("kppLawordMgmInfo", kppLawordMgmInfo);
		model.addAttribute("topMenuCd", "chkLstMgm");
		model.addAttribute("subMenuCd", "lawChkLst");
		
		return "admin/chkLstMgm/lawChkLstDetView.kppTiles";
	}	
	
	
	/**
	 * 한국건축규정 체크리스트 항목관리 등록
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/chkLstMgm/lawChkLstRegist.do")
	public String lawChkLstRegist(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		//공통코드 조회
		List<?> commCdKR001Lst = commMgmService.selectCommCdMgmInfo("KR001");
		
		
		model.addAttribute("commCdKR001Lst", commCdKR001Lst);
		model.addAttribute("topMenuCd", "chkLstMgm");
		model.addAttribute("subMenuCd", "lawChkLst");
		
		return "admin/chkLstMgm/lawChkLstRegist.kppTiles";
	}
	
	
	
	
	/**
	 * 한국건축규정 체크리스트 항목관리 등록처리	
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/chkLstMgm/lawChkLstRegistExec.do")
	public String lawChkLstRegistExec(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		int		registResultCnt			=	0;
		
		//한국건축규정 체크리스트 항목관리 등록처리
		registResultCnt = chkLstMgmService.insertKppLawordMgmExec(paramMap);
		
		model.addAttribute("topMenuCd", "chkLstMgm");
		model.addAttribute("subMenuCd", "lawChkLst");
		
		return "forward:/admin/chkLstMgm/lawChkLst.do";
	}
	
	
	 
}
