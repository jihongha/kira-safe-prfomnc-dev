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
package kr.or.kira.safe.prfomnc.admin.chkLstMgm.service.impl;

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
@Mapper("chkLstMgmMapper")
public interface ChkLstMgmMapper {
	
	/**
	 * 한국건축규정 체크리스트 항목관리 등록처리
	 * @param paramMap
	 * @return
	 */
	int insertKppLawordMgmExec(HashMap paramMap);
	
	/**
	 * 한국건축규정 체크리스트 항목관리 수정처리
	 * @param paramMap
	 * @return
	 */
	int updateKppLawordMgmExec(HashMap paramMap);
	
	/**
	 * 한국건축규정 체크리스트 항목관리 삭제처리
	 * @param paramMap
	 * @return
	 */
	int deleteKppLawordMgmExec(HashMap paramMap);
	
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록조회
	 * @param paramMap
	 * @return
	 */
	List<?> selectKppLawordMgmListInfo(HashMap paramMap);
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록 개수조회
	 * @param paramMap
	 * @return
	 */
	int selectKppLawordMgmListTotCnt(HashMap paramMap);
	
	/**
	 * 한국건축규정 체크리스트 항목관리 상세조회
	 * @param paramMap
	 * @return
	 */
	EgovMap selectKppLawordMgmInfo(HashMap paramMap);
	
	/**
	 * 맞춤형 체크리스트 등록처리
	 * @param paramMap
	 */
	void insertKppLawordFixesChklstMgmExec(HashMap paramMap);
	
	/**
	 * 맞춤형 체크리스트 삭제처리
	 * @param paramMap
	 */
	void deleteKppLawordFixesChklstMgmExec(HashMap paramMap);
	
	/**
	 * 한국건축규정 맞춤형 체크리스트 항목 조회
	 * @param paramMap
	 * @return
	 */
	List<?> selectkppLawordFixesChkLst(HashMap paramMap);
	
	
	 

}
