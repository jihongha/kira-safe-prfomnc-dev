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
package kr.or.kira.safe.prfomnc.users.main.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.users.main.service.UserMainService;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021.11.01           최초생성
 *
 * @author 이승연
 * @since 2021.11.01
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("userMainService")
public class UserMainServiceImpl extends EgovAbstractServiceImpl implements UserMainService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserMainServiceImpl.class);

	/** userMainMapper */
	@Resource(name="userMainMapper")
	private UserMainMapper userMainMapper;
	
	final String USER = "USER";
	final String CHCKER = "CHCKER";
	final String YES = "Y";
	final String NO = "N";

	// 회원가입 시 아이디 중복체크
	@Override
	public HashMap<String, String> selectBppMembIdNotExists(HashMap<String, String> paramMap) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		int row = userMainMapper.selectBppMembIdNotExists(paramMap);
		
		if (row == 0) { // 중복체크라 결과 있으면 안 됨
			resultMap.put("isSucceeded", YES);
		}
		else {
			resultMap.put("isSucceeded", NO);
		}
		
		return resultMap;
	}

	// 회원가입 처리
	@Override
	public HashMap<String, String> insertBppMembMgm(HashMap<String, String> paramMap) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		int row = userMainMapper.insertBppMembMgm(paramMap);
		
		if (row == 1) {
			resultMap.put("isSucceeded", YES);
		}
		else {
			resultMap.put("isSucceeded", NO);
		}
		
		return resultMap;
	}

	// 로그인 처리
	@Override
	public HashMap<String, String> selectBppMembMgmExists(HashMap<String, String> paramMap) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		EgovMap result = userMainMapper.selectBppMembMgmExists(paramMap);
		
		if (result != null) {
			resultMap.putAll(result);
			return checkUser(resultMap);
		} else {
			resultMap.put("isSucceeded", NO);
			resultMap.put("msg", "아이디 또는 비밀번호를 확인해주세요");
			return resultMap;
		}
	}

	// 정상사용자인지 확인
	public HashMap<String, String> checkUser(HashMap<String, String> paramMap) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		String bppMembTy = paramMap.get("bppMembTy");
		String useAt = paramMap.get("useAt");
		String chckerSbscrbConfmAt = paramMap.get("chckerSbscrbConfmAt");
		
		// 사용여부가 0인 사람 == 탈퇴한 사람
		if (useAt.equals(NO)) {
			resultMap.put("msg", "사용 정지된 아이디입니다.");
			resultMap.put("isSucceeded", NO);
			return resultMap;
		}
		
		// 검토자인데 승인여부가 0인 사람 == 승인 나지 않은 검토자
		if (bppMembTy.equals(CHCKER) && chckerSbscrbConfmAt.equals(NO)) {
			resultMap.put("msg", "담당자의 검토 승인이 필요한 아이디입니다.");
			resultMap.put("isSucceeded", NO);
			return resultMap;
		}
		
		resultMap.putAll(paramMap);
		resultMap.put("isSucceeded", YES);
		resultMap.put("msg", "문제없이 정상 로그인!");
		
		return resultMap;
	}

	// 아이디 찾기
	@Override
	public HashMap<String, String> selectBppMembId(HashMap<String, String> paramMap) {
		EgovMap result = userMainMapper.selectBppMembId(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (result != null) {
			resultMap.putAll(result);
			resultMap.put("isSucceeded", YES);
			resultMap.put("msg", "아이디 찾기 성공");
		} else {
			resultMap.put("isSucceeded", NO);
			resultMap.put("msg", "입력하신 정보와 일치하는 회원정보가 존재하지 않습니다.");
		}
		
		return resultMap;
	}
	
	// 아이디 리스트 찾기
	@Override
	public List<EgovMap> selectBppMembIdList(HashMap<String, String> paramMap) {
		return userMainMapper.selectBppMembIdList(paramMap);
	}

	// 비밀번호 찾기
	@Override
	public HashMap<String, String> selectBppMembPwd(HashMap<String, String> paramMap) {
		EgovMap result = userMainMapper.selectBppMembPwd(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (result != null) {
			resultMap.putAll(result);
			resultMap.put("isSucceeded", YES);
			resultMap.put("msg", "비밀번호 찾기 성공");
		} else {
			resultMap.put("isSucceeded", NO);
			resultMap.put("msg", "입력하신 정보와 일치하는 회원정보가 존재하지 않습니다.");
		}
		
		return resultMap;
	}

	// 비밀번호 초기화
	@Override
	public HashMap<String, String> updateBppMembPwd(HashMap<String, String> paramMap) {
		int row = userMainMapper.updateBppMembPwd(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row == 1) {
			resultMap.put("isSucceeded", YES);
			resultMap.put("msg", "비밀번호 초기화 성공");
		} else {
			resultMap.put("isSucceeded", NO);
			resultMap.put("msg", "비밀번호 초기화에 실패하였습니다.");
		}
		
		return resultMap;
	}

	// 마이페이지 진입 전 비번 재확인
	@Override
	public HashMap<String, String> selectAccountPwd(HashMap<String, String> paramMap) {
		int row = userMainMapper.selectAccountPwd(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (row == 1) {
			resultMap.put("isSucceeded", YES);
			resultMap.put("msg", "본인 확인 완료");
		} else {
			resultMap.put("isSucceeded", NO);
			resultMap.put("msg", "본인 확인 실패");
		}
		
		return resultMap;
	}

	// 마이페이지 정보 조회
	@Override
	public HashMap<String, String> selectBppMembMgm(HashMap<String, String> paramMap) {
		EgovMap result = userMainMapper.selectBppMembMgm(paramMap);
		
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		if (result != null) {
			resultMap.putAll(result);
			resultMap.put("isSucceeded", YES);
			resultMap.put("msg", "마이페이지 조회 성공");
		} else {
			resultMap.put("isSucceeded", NO);
			resultMap.put("msg", "마이페이지 조회 실패");
		}
		
		return resultMap;
	}
}
