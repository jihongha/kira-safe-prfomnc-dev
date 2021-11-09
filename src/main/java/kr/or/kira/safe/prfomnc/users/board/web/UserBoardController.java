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
package kr.or.kira.safe.prfomnc.users.board.web;

import java.util.HashMap;
import java.util.List;

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
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil;
import kr.or.kira.safe.prfomnc.users.board.service.UserBoardService;

/**
 * @Class Name : UserBoardController.java
 * @Description : UserBoardController Class
 * @Modification Information
 * @
 * @  수정일     	       수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021.10.12         이승연      	       최초생성
 *
 * @author 이승연
 * @since 2021. 10.12
 * @version 1.0
 * @see
 *
 */

@Controller
public class UserBoardController {

	/** UserBoardService */
	@Resource(name = "userBoardService")
	private UserBoardService userBoardService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	// 임시 변수
	final static String NOTICE = "ctgr1";
	final static String DATA_ROOM = "ctgr2";
	final static String NEWS_DATA = "ctgr3";
	final static String FAQ = "ctgr4";
	final static String QNA = "ctgr5";
	
	
	//-------------------------------------------------------------
	// 공지사항 게시판 CRUD
	//-------------------------------------------------------------
	
	/**
	 * 공지사항 리스트 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/noticeList.do")
	public String noticeList(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		paramMap.put("bppCmmnBoardFntp", NOTICE);
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		model.addAttribute("resultMap", resultMap);
		
		System.out.println("키키: 공지사항 리스트 조회 완료---> " + resultMap.toString());
		
		return "users/board/noticeList.bppTiles";
	}
	
	/**
	 * 공지사항 생성 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/noticeWrite.do")
	public String noticeWrite(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		System.out.println("키키: 공지사항 생성 화면---> " + paramMap.toString());
		
		return "users/board/noticeWrite.bppTiles";
	}
	
	/**
	 * 공지사항 생성 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/insertBppCmmnBoardNotice.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> insertBppCmmnBoardNotice(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		paramMap.put("bppCmmnBoardFntp", NOTICE);
		
		HashMap<String, String> resultMap = userBoardService.insertBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공지사항 생성 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 공지사항 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/notice.do")
	public String notice(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공지사항 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/notice.bppTiles";
	}
	
	/**
	 * 공지사항 수정 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/noticeEdit.do")
	public String noticeEdit(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공지사항 수정 화면 조회 시작---> " + resultMap.toString());

		model.addAttribute("resultMap", resultMap);
		
		return "users/board/noticeEdit.bppTiles";
	}
	
	/**
	 * 공지사항 수정 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/updateBppCmmnBoardNotice.do")
	@ResponseBody
	public HashMap<String, String> updateBppCmmnBoard(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.updateBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공지사항 수정 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 공지사항 삭제 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/deleteBppCmmnBoardNotice.do")
	public String deleteBppCmmnBoard(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.deleteBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공지사항 삭제 시작---> " + resultMap.toString());
		
		return "redirect:/user/board/noticeList.do";
	}
	
	
	//-------------------------------------------------------------
	// 공개자료실 게시판 CRUD
	//-------------------------------------------------------------
	
	/**
	 * 공개자료실 리스트 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/dataRoomList.do")
	public String dataRoomList(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "dataRoom");
		
		paramMap.put("bppCmmnBoardFntp", DATA_ROOM);
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		System.out.println("키키: 공개자료실 리스트 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/dataRoomList.bppTiles";
	}
	
	/**
	 * 공개자료실 생성 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/dataRoomWrite.do")
	public String dataRoomWrite(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "dataRoom");
		
		System.out.println("키키: 공개자료실 생성 화면---> " + paramMap.toString());
		
		return "users/board/dataRoomWrite.bppTiles";
	}
	
	/**
	 * 공개자료실 생성 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/insertBppCmmnBoardDataRoom.do")
	@ResponseBody
	public HashMap<String, String> insertBppCmmnBoardDataRoom(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		paramMap.put("bppCmmnBoardFntp", DATA_ROOM);
		
		HashMap<String, String> resultMap = userBoardService.insertBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공개자료실 생성 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 공개자료실 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/dataRoom.do")
	public String dataRoom(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "dataRoom");
		
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공개자료실 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/dataRoom.bppTiles";
	}
	
	/**
	 * 공개자료실 수정 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/dataRoomEdit.do")
	public String dataRoomEdit(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "dataRoom");
		
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공개자료실 수정 화면 조회 시작---> " + resultMap.toString());

		model.addAttribute("resultMap", resultMap);
		
		return "users/board/dataRoomEdit.bppTiles";
	}
	
	/**
	 * 공개자료실 수정 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/updateBppCmmnBoardDataRoom.do")
	@ResponseBody
	public HashMap<String, String> updateBppCmmnBoardDataRoom(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.updateBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공지사항 수정 시작---> " + resultMap.toString());

		return resultMap;
	}
	
	/**
	 * 공개자료실 삭제 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/deleteBppCmmnBoardDataRoom.do")
	public String deleteBppCmmnBoardDataRoom(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.deleteBppCmmnBoard(paramMap);
		
		System.out.println("키키: 공개자료실 삭제 시작---> " + resultMap.toString());

		return "redirect:/user/board/dataRoomList.do";
	}
	
	
	
	//-------------------------------------------------------------
	// 보도자료 게시판 CRUD
	//-------------------------------------------------------------
	
	/**
	 * 보도자료 리스트 조회
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/newsDataList.do")
	public String nesDtaLst(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		paramMap.put("bppCmmnBoardFntp", NEWS_DATA);
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		System.out.println("키키: 보도자료 리스트 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/newsDataList.bppTiles";
	}
	
	/**
	 * 보도자료 생성 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/newsDataWrite.do")
	public String nesDtaWrite(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		System.out.println("키키: 보도자료 생성 화면---> " + paramMap.toString());
		
		return "users/board/newsDataWrite.bppTiles";
	}
	
	/**
	 * 보도자료 생성 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/insertBppCmmnBoardNewsData.do")
	@ResponseBody
	public HashMap<String, String> insertBppCmmnBoardNewsData(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		paramMap.put("bppCmmnBoardFntp", NEWS_DATA);
		
		HashMap<String, String> resultMap = userBoardService.insertBppCmmnBoard(paramMap);
		
		System.out.println("키키: 보도자료 생성 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 보도자료 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/newsData.do", method=RequestMethod.GET)
	public String nesDta(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 보도자료 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/newsData.bppTiles";
	}
	
	/**
	 * 보도자료 수정 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/newsDataEdit.do")
	public String nesDtaUpdate(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 보도자료 수정 화면 조회 시작---> " + resultMap.toString());

		model.addAttribute("resultMap", resultMap);
		
		return "users/board/newsDataEdit.bppTiles";
	}
	
	/**
	 * 보도자료 수정 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/updateBppCmmnBoardNewsData.do")
	@ResponseBody
	public HashMap<String, String> updateBppCmmnBoardNewsData(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.updateBppCmmnBoard(paramMap);
		
		System.out.println("키키: 보도자료 수정 완료---> " + resultMap);
		
		return resultMap;
	}
	
	/**
	 * 보도자료 삭제 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/deleteBppCmmnBoardNewsData.do")
	public String deleteBppCmmnBoardNewsData(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.deleteBppCmmnBoard(paramMap);
		
		System.out.println("키키: 보도자료 삭제 시작---> " + resultMap.toString());
		
		return "redirect:/user/board/newsDataList.do";
	}
	
	
	
	
	//-------------------------------------------------------------
	// FAQ 게시판 CRUD
	//-------------------------------------------------------------
	
	/**
	 * 자주묻는질문 리스트 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/faqList.do")
	public String faqList(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "faq");
		
		paramMap.put("bppCmmnBoardFntp", FAQ);
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		System.out.println("키키: 자주묻는질문 리스트 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/faqList.bppTiles";
	}
	
	/**
	 * 자주묻는질문 생성 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/faqWrite.do")
	public String faqWrite(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "faq");
		
		System.out.println("키키: 자주묻는질문 생성 화면---> " + paramMap.toString());
		
		return "users/board/faqWrite.bppTiles";
	}
	
	/**
	 * 자주묻는질문 생성 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/insertBppCmmnBoardFaq.do")
	@ResponseBody
	public HashMap<String, String> insertBppCmmnBoardFaq(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		paramMap.put("bppCmmnBoardFntp", FAQ);
		
		HashMap<String, String> resultMap = userBoardService.insertBppCmmnBoard(paramMap);
		
		System.out.println("키키: 자주묻는질문 생성 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 자주묻는질문 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/faq.do")
	public String faq(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "faq");
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 자주묻는질문 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/faq.bppTiles";
	}
	
	/**
	 * 자주묻는질문 수정 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/faqEdit.do")
	public String faqEdit(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 자주묻는질문 수정 화면 조회 시작---> " + resultMap.toString());

		model.addAttribute("resultMap", resultMap);
		
		return "users/board/faqEdit.bppTiles";
	}
	
	/**
	 * 자주묻는질문 수정 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/updateBppCmmnBoardFaq.do")
	@ResponseBody
	public HashMap<String, String> updateBppCmmnBoardFaq(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.updateBppCmmnBoard(paramMap);
		
		System.out.println("키키: 자주묻는질문 수정 시작---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 자주묻는질문 삭제 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/deleteBppCmmnBoardFaq.do")
	public String deleteBppCmmnBoardFaq(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.deleteBppCmmnBoard(paramMap);
		
		System.out.println("키키: 자주묻는질문 삭제 시작---> " + resultMap.toString());
		
		return "redirect:/user/board/faqList.do";
	}
	
	
	
	//-------------------------------------------------------------
	// QnA 게시판 CRUD
	//-------------------------------------------------------------

	/**
	 * 질의응답 리스트 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qnaList.do")
	public String qnaList(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		paramMap.put("bppCmmnBoardFntp", QNA);
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		System.out.println("키키: 질의응답 리스트 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qnaList.bppTiles";
	}
	
	/**
	 * 질의응답 리스트 조회 화면(관리자)
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qnaAnswerList.do")
	public String qnaAnswerList(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		paramMap.put("bppCmmnBoardFntp", QNA);
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		System.out.println("키키: 질의응답 리스트 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qnaAnswerList.bppTiles";
	}
	
	/**
	 * 질의응답 생성 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qnaWrite.do")
	public String qnaWrite(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		System.out.println("키키: 질의응답 생성 화면---> " + paramMap.toString());
		
		return "users/board/qnaWrite.bppTiles";
	}
	
	/**
	 * 질의응답 생성 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/insertBppCmmnBoardQna.do")
	@ResponseBody
	public HashMap<String, String> insertBppCmmnBoardQna(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		paramMap.put("bppCmmnBoardFntp", QNA);
		
		HashMap<String, String> resultMap = userBoardService.insertBppCmmnBoardQna(paramMap);
		
		System.out.println("키키: 질의응답 생성 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 질의응답 조회 화면
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qna.do")
	public String qna(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
//		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
//		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoardQna(paramMap);
		
		System.out.println("키키: 질의응답 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qna.bppTiles";
	}
	
	/**
	 * 질의응답 조회 화면(관리자)
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qnaAnswer.do")
	public String qnaAnswer(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
//		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
//		paramMap.put("loginId", loginId);
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoardQna(paramMap);
		
		System.out.println("키키: 질의응답 관리자 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qnaAnswer.bppTiles";
	}
	
	/**
	 * 질의응답 수정 처리 --> 관리자가 업데이트
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/updateBppCmmnBoardQnaAnswer.do")
	@ResponseBody
	public HashMap<String, String> updateBppCmmnBoardQnaAnswer(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
		
		System.out.println("키키: 질의응답 관리자 답변 처리 시작---> " + paramMap.toString());
		
		HashMap<String, String> resultMap =  userBoardService.updateBppCmmnBoardQna(paramMap);
		
		System.out.println("키키: 질의응답 관리자 답변 처리 완료---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 질의응답 수정 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/updateBppCmmnBoardQna.do")
	@ResponseBody
	public HashMap<String, String> updateBppCmmnBoardQna(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.updateBppCmmnBoard(paramMap);
		
		System.out.println("키키: 질의응답 수정 시작---> " + resultMap.toString());
		
		return resultMap;
	}
	
	/**
	 * 질의응답 삭제 처리
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/deleteBppCmmnBoardQna.do")
	public String deleteBppCmmnBoardQna(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
		paramMap.put("loginId", loginId);
				
		HashMap<String, String> resultMap = userBoardService.deleteBppCmmnBoard(paramMap);
		
		System.out.println("키키: 질의응답 삭제 시작---> " + resultMap.toString());
		
		return "redirect:/user/board/qnaList.do";
	}
	
}
