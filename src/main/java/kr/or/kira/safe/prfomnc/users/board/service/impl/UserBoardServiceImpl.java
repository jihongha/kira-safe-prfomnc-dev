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
package kr.or.kira.safe.prfomnc.users.board.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.users.board.service.UserBoardService;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @    수정일              수정자              	수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021. 10.23      이승연               	최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2021. 10.23
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("userBoardService")
public class UserBoardServiceImpl extends EgovAbstractServiceImpl implements UserBoardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserBoardServiceImpl.class);

	/** UserBoardMapper */
	@Resource(name="userBoardMapper")
	private UserBoardMapper userBoardMapper;

	// 생성
	@Override
	public HashMap<String, String> insertBppCmmnBoard(HashMap<String, String> paramMap) throws Exception {
		int row = userBoardMapper.insertBppCmmnBoard(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row > 0) {
			resultMap.put("bppCmmnBoardSeqNo", String.valueOf(paramMap.get("bppCmmnBoardSeqNo")));
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "작성 완료");
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "작성 실패");
		}
		
		return resultMap;
	}

	@Override
	public HashMap<String, String> insertBppCmmnBoardQna(HashMap<String, String> paramMap) throws Exception {
		int row = userBoardMapper.insertBppCmmnBoardQna(paramMap);

		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row > 0) {
			resultMap.put("bppCmmnBoardSeqNo", String.valueOf(paramMap.get("bppCmmnBoardSeqNo")));
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "작성 완료");
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "작성 실패");
		}
		
		return resultMap;
	}

	
	// 조회
	@Override
	public List<EgovMap> selectBppCmmnBoardList(HashMap<String, String> paramMap) throws Exception {
		return userBoardMapper.selectBppCmmnBoardList(paramMap);
	}

	@Override
	public int selectBppCmmnBoardCnt(HashMap<String, String> paramMap) throws Exception {
		return userBoardMapper.selectBppCmmnBoardCnt(paramMap);
	}
	
	@Override
	public HashMap<String, String> selectBppCmmnBoard(HashMap<String, String> paramMap) throws Exception {
		EgovMap result = userBoardMapper.selectBppCmmnBoard(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (result != null) {
			resultMap.putAll(result);
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "상세 조회 완료");
			
			updateBppCmmnBoardRdcnt(Integer.valueOf(paramMap.get("bppCmmnBoardSeqNo")));
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "상세 조회 실패");
		}
		
		return resultMap;
	}

	@Override
	public HashMap<String, String> selectBppCmmnBoardQna(HashMap<String, String> paramMap) throws Exception {
		EgovMap result = userBoardMapper.selectBppCmmnBoardQna(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (result != null) {
			resultMap.putAll(result);
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "상세 조회 완료");
			
			updateBppCmmnBoardRdcnt(Integer.valueOf(paramMap.get("bppCmmnBoardSeqNo")));
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "상세 조회 실패");
		}
		
		return resultMap;
	}

	
	// 수정
	@Override
	public HashMap<String, String> updateBppCmmnBoard(HashMap<String, String> paramMap) throws Exception {
		int row = userBoardMapper.updateBppCmmnBoard(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row > 0) {
			resultMap.put("bppCmmnBoardSeqNo", paramMap.get("bppCmmnBoardSeqNo"));
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "수정 완료");
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "수정 실패");
		}
		
		return resultMap;
	}

	@Override
	public HashMap<String, String> updateBppCmmnBoardQna(HashMap<String, String> paramMap) throws Exception {
		int row = userBoardMapper.updateBppCmmnBoardQna(paramMap);

		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row > 0) {
			resultMap.put("bppCmmnBoardSeqNo", paramMap.get("bppCmmnBoardSeqNo"));
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "수정 완료");
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "수정 실패");
		}
		
		return resultMap;
	}

	
	// 삭제
	@Override
	public HashMap<String, String> deleteBppCmmnBoard(HashMap<String, String> paramMap) throws Exception {
		int row = userBoardMapper.deleteBppCmmnBoard(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row > 0) {
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "삭제 완료");
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "삭제 실패");
		}
		
		return resultMap;
	}

	@Override
	public HashMap<String, String> deleteBppCmmnBoard2(HashMap<String, String> paramMap) throws Exception {
		int row = userBoardMapper.deleteBppCmmnBoard2(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();

		if (row > 0) {
			resultMap.put("isSucceeded", "Y");
			resultMap.put("msg", "삭제 완료");
		} else {
			resultMap.put("isSucceeded", "N");
			resultMap.put("msg", "삭제 실패");
		}
		
		return resultMap;
	}

	// 조회 수 카운트
	public void updateBppCmmnBoardRdcnt(int bppCmmnBoardSeqNo) throws Exception {
		// 일단 본인여부 안 따짐
		userBoardMapper.updateBppCmmnBoardRdcnt(bppCmmnBoardSeqNo);
	}
	
	// 세션 체크
	public boolean checkSessionExists() {
		
		return false;
	}
	
}
