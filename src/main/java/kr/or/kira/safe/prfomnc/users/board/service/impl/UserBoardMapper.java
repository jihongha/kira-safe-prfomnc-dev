/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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
package kr.or.kira.safe.prfomnc.users.board.service.impl;

import java.util.HashMap;
import java.util.List;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * userMain에 관한 데이터처리 매퍼 클래스
 *
 * @author  하지홍
 * @since 2021.10.12
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 * </pre>
 */
@Mapper("userBoardMapper")
public interface UserBoardMapper {
	
	// 생성
	// 공통 게시글 생성
	int insertBppCmmnBoard(HashMap<String, String> paramMap);
	
	
	// 조회
	// 공통 게시글 리스트 조회
	List<EgovMap> selectBppCmmnBoardList(HashMap<String, String> paramMap);
	
	// 공통 게시글 개수 조회
	int selectBppCmmnBoardCnt(HashMap<String, String> paramMap);
	
	// 공통 게시글 상세 조회
	EgovMap selectBppCmmnBoard(HashMap<String, String> paramMap);
	
	// 질의응답 게시글 상세 조회(본인만)
	EgovMap selectBppCmmnBoardQna(HashMap<String, String> paramMap);
	

	// 수정
	// 공통 게시글 수정
	int updateBppCmmnBoard(HashMap<String, String> paramMap);
	
	// 공통 게시글 수정
	int updateBppCmmnBoardQna(HashMap<String, String> paramMap);
	
	
	// 삭제
	// 공통 게시글 삭제(노출여부만)
	int deleteBppCmmnBoard(HashMap<String, String> paramMap);
	
	// 공통 게시글 삭제(일단 보류)
	int deleteBppCmmnBoard2(HashMap<String, String> paramMap);
	
	
	// 기타
	// 조회수 올리기
	void updateBppCmmnBoardRdcnt(int bppCmmnBoardSeqNo);

}
