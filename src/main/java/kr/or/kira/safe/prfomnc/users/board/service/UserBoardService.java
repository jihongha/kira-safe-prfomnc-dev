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
package kr.or.kira.safe.prfomnc.users.board.service;

import java.util.HashMap;
import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : UserMainService.java
 * @Description : UserMainService Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021.10.12           최초생성
 *
 * @author 이승연
 * @since 2021. 10.12
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface UserBoardService {

	// 생성
	// 공통 게시글 생성
	HashMap<String, String> insertBppCmmnBoard(HashMap<String, String> paramMap) throws Exception;
	
	// 질의응답 게시글 생성(사용자질문-관리자답변 기능)
	HashMap<String, String> insertBppCmmnBoardQna(HashMap<String, String> paramMap) throws Exception;
	
	
	// 조회
	// 공통 게시글 리스트 조회
	List<EgovMap> selectBppCmmnBoardList(HashMap<String, String> paramMap) throws Exception;
	
	// 공통 게시글 개수 조회
	int selectBppCmmnBoardCnt(HashMap<String, String> paramMap) throws Exception;
	
	// 공통 게시글 상세 조회
	HashMap<String, String> selectBppCmmnBoard(HashMap<String, String> paramMap) throws Exception;
	
	// 질의응답 게시글 상세 조회(본인만)
	HashMap<String, String> selectBppCmmnBoardQna(HashMap<String, String> paramMap) throws Exception;
		
	
	// 수정
	// 공통 게시글 수정
	HashMap<String, String> updateBppCmmnBoard(HashMap<String, String> paramMap) throws Exception;
	
	// 공통 게시글 수정
	HashMap<String, String> updateBppCmmnBoardQna(HashMap<String, String> paramMap) throws Exception;
	
	
	// 삭제
	// 공통 게시글 삭제(노출여부만)
	HashMap<String, String> deleteBppCmmnBoard(HashMap<String, String> paramMap) throws Exception;
	
	// 공통 게시글 삭제(일단 보류)
	HashMap<String, String> deleteBppCmmnBoard2(HashMap<String, String> paramMap) throws Exception;
}
