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
package kr.or.kira.safe.prfomnc.users.main.service.impl;

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
@Mapper("userMainMapper")
public interface UserMainMapper {

	// 아이디 중복 체크
	int selectBppMembIdNotExists(HashMap<String, String> paramMap);
	
	// 로그인 처리
	EgovMap selectBppMembMgmExists(HashMap<String, String> paramMap);

	// 회원가입 처리
	int insertBppMembMgm(HashMap<String, String> paramMap);
	
	// 아이디 찾기 처리
	EgovMap selectBppMembId(HashMap<String, String> paramMap);
	
	// 아이디 찾기 리스트 처리
	List<EgovMap> selectBppMembIdList(HashMap<String, String> paramMap);
	
	// 비밀번호 찾기 처리
	EgovMap selectBppMembPwd(HashMap<String, String> paramMap);
	
	// 비밀번호 초기화 처리
	int updateBppMembPwd(HashMap<String, String> paramMap);
	
	// 마이페이지 진입 전 비번 재확인
	int selectAccountPwd(HashMap<String, String> paramMap);
	
	// 마이페이지 정보 조회
	EgovMap selectBppMembMgm(HashMap<String, String> paramMap);
}
