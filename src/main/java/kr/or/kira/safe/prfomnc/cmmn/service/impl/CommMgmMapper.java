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
package kr.or.kira.safe.prfomnc.cmmn.service.impl;

import java.util.HashMap;
import java.util.List;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

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
@Mapper("commMgmMapper")
public interface CommMgmMapper {
	
	/**
	 * 공통코드 조회처리
	 * @param lgrpCd
	 * @return
	 */
	List<?> selectCommCdMgmInfo(String lgrpCd);
	
	/**
	 * 검색 자동완성 텍스트별 검색항목 조회
	 * @param paramMap
	 * @return
	 */
	List<?> selectcomCdAutoComplList(HashMap<String, String> paramMap);

	 

}
