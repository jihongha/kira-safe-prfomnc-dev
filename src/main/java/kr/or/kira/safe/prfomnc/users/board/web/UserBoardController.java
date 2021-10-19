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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.kira.safe.prfomnc.users.board.service.UserBoardService;
import kr.or.kira.safe.prfomnc.users.main.service.UserMainService;

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
public class UserBoardController {

	/** UserBoardService */
	@Resource(name = "userBoardService")
	private UserBoardService userBoardService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	
	/**
	 * 공지사항 목록조회
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/noticeLst.do")
	public String noticeLst(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		return "users/board/noticeLst.tiles";
	}
	
	
	/**
	 * 공지사항 등록/수정 페이지 호출
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/noticeWrite.do")
	public String noticeWrite(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "notice");
		
		return "users/board/noticeWrite.tiles";
	}
	
	
	/**
	 * 공개자료실 목록조회
	 * @param paramMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/dataRoomLst.do")
	public String dataRoomLst(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "dataRoom");
		
		return "users/board/dataRoomLst.tiles";
	}
	
	
	/**
	 * 보도자료 목록조회
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/nesDtaLst.do")
	public String nesDtaLst(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "nesDta");
		
		return "users/board/nesDtaLst.tiles";
	}
	
	
	/**
	 * Q&A 목록조회
	 * @param paramMap
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/board/qnaLst.do")
	public String qnaLst(@RequestParam HashMap paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		model.addAttribute("topMenuCd", "board");
		model.addAttribute("subMenuCd", "qna");
		
		return "users/board/qnaLst.tiles";
	}
	
}
