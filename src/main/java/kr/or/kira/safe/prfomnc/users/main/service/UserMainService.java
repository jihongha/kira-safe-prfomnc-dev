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
package kr.or.kira.safe.prfomnc.users.main.service;

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
 * @since 2021. 11.01
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface UserMainService {

	// 아이디 중복 체크
	HashMap<String, String> selectBppMembIdNotExists(HashMap<String, String> paramMap);
	
	// 로그인 처리
	HashMap<String, String> selectBppMembMgmExists(HashMap<String, String> paramMap);
	
	// 회원가입 처리
	HashMap<String, String> insertBppMembMgm(HashMap<String, String> paramMap);
	
	// 아이디 찾기 처리
	HashMap<String, String> selectBppMembId(HashMap<String, String> paramMap);
	
	// 아이디 리스트 찾기 처리
	List<EgovMap> selectBppMembIdList(HashMap<String, String> paramMap);
	
	// 비밀번호 찾기 처리
	HashMap<String, String> selectBppMembPwd(HashMap<String, String> paramMap);
	
	// 비밀번호 초기화 처리
	HashMap<String, String> updateBppMembPwd(HashMap<String, String> paramMap);
	
	// 마이페이지 진입 전 비번 재확인
	HashMap<String, String> selectAccountPwd(HashMap<String, String> paramMap);
	
	// 마이페이지 정보 조회
	HashMap<String, String> selectBppMembMgm(HashMap<String, String> paramMap);
}
