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
package kr.or.kira.safe.prfomnc.admin.sysMgm.service.impl;

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
@Mapper("sysMgmMapper")
public interface SysMgmMapper {
	
	/**
	 * 시스템관리 사용자관리 목록조회
	 * @param paramMap
	 * @return
	 */
	List<?> selectkppIntraMembListInfo(HashMap paramMap);
	
	/**
	 * 시스템관리 사용자관리 목록 개수조회
	 * @param paramMap
	 * @return
	 */
	int selectkppIntraMembListTotCnt(HashMap paramMap);
	
	/**
	 * 시스템관리 사용자관리 상세조회
	 * @param paramMap
	 * @return
	 */
	EgovMap selectKppIntraMembDetViewInfo(HashMap paramMap);
	
	/**
	 * 시스템관리 사용자 관리 가입승인, 반려처리
	 * @param paramMap
	 * @return
	 */
	int saveKppIntraSbscrbUpdtExec(HashMap paramMap);
	
	

}
