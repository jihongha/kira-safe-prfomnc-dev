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
	final static String USE_AT_1 = "1";
	final static String USE_AT_0 = "0";
	final static String LOGINID = "lsy";
	final static String LOGINID2 = "aaa";
	final static String BOARD_ANSWER_COMPT_AT_0 = "0";
	final static String BOARD_QUEST_OTHBC_AT_0 = "0";
	final static String BOARD_ANSWER_COMPT_AT_1 = "1";
	final static String BOARD_QUEST_OTHBC_AT_1 = "1";
	
	
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
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 공지사항 리스트 조회 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("bppCmmnBoardFntp", NOTICE);
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 공지사항 생성 처리 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 공지사항 조회 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 공지사항 수정 화면 조회 시작---> " + paramMap.toString());
		
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		paramMap.put("loginId", LOGINID);
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 공지사항 수정 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_0);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 공지사항 삭제 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_1);

		System.out.println("키키: 공개자료실 리스트 조회 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("bppCmmnBoardFntp", DATA_ROOM);
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 공개자료실 생성 처리 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 공개자료실 조회 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 공개자료실 수정 화면 조회 시작---> " + paramMap.toString());
		
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		paramMap.put("loginId", LOGINID);
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 공지사항 수정 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_0);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 공개자료실 삭제 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 보도자료 리스트 조회 시작---> " + paramMap.toString());
		
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		paramMap.put("bppCmmnBoardFntp", NEWS_DATA);
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 보도자료 생성 처리 시작---> " + paramMap.toString());
		
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
		//rttr.addFlashAttribute("bppCmmnBoardSeqNo", paramMap.get("bppCmmnBoardSeqNo")); // 나중에 파라메터 숨길거면 사용  RedirectAttributes rttr,
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 보도자료 조회 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 보도자료 수정 화면 조회 시작---> " + paramMap.toString());
		
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "newsData");
		
		paramMap.put("loginId", LOGINID);
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 보도자료 수정 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_0);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 보도자료 삭제 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 자주묻는질문 리스트 조회 시작---> " + paramMap.toString());
		
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
		System.out.println("키키: 자주묻는질문 생성 처리 시작---> " + paramMap.toString());

		paramMap.put("bppCmmnBoardFntp", FAQ);
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
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
		
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 자주묻는질문 조회 시작---> " + paramMap.toString());
		
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "faq");
		
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 자주묻는질문 수정 화면 조회 시작---> " + paramMap.toString());
		
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		paramMap.put("loginId", LOGINID);
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 자주묻는질문 수정 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_0);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 자주묻는질문 삭제 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 질의응답 리스트 조회 시작---> " + paramMap.toString());
		
		List<EgovMap> resultMap = userBoardService.selectBppCmmnBoardList(paramMap);
		
		System.out.println("키키: 질의응답 리스트 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qnaList.bppTiles";
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
		paramMap.put("bppCmmnBoardFntp", QNA);
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		paramMap.put("boardAnswerComptAt", BOARD_ANSWER_COMPT_AT_0);
		
		System.out.println("키키: 질의응답 생성 처리 시작---> " + paramMap.toString());
		
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
		
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 질의응답 조회 시작---> " + paramMap.toString());
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoardQna(paramMap);
		
		System.out.println("키키: 질의응답 조회 완료---> " + resultMap.toString());
		
		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qna.bppTiles";
	}
	
	/**
	 * 질의응답 수정 화면 --> 관리자가 업데이트
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qnaEdit.do")
	public String qnaEdit(@RequestParam HashMap<String, String> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		paramMap.put("useAt", USE_AT_1);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 질의응답 수정 화면 조회 시작---> " + paramMap.toString());
		
		HashMap<String, String> resultMap =  userBoardService.selectBppCmmnBoard(paramMap);
		
		System.out.println("키키: 질의응답 수정 화면 조회 시작---> " + resultMap.toString());

		model.addAttribute("resultMap", resultMap);
		
		return "users/board/qnaEdit.bppTiles";
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
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		paramMap.put("loginId", LOGINID);
		paramMap.put("useAt", USE_AT_1);
		
		System.out.println("키키: 질의응답 수정 시작---> " + paramMap.toString());
		
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
		paramMap.put("useAt", USE_AT_0);
		paramMap.put("loginId", LOGINID);
		
		System.out.println("키키: 질의응답 삭제 시작---> " + paramMap.toString());
		
		HashMap<String, String> resultMap = userBoardService.deleteBppCmmnBoard(paramMap);
		
		System.out.println("키키: 질의응답 삭제 시작---> " + resultMap.toString());
		
		return "redirect:/user/board/qnaList.do";
	}
	
}
