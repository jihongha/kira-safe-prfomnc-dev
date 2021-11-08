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
package kr.or.kira.safe.prfomnc.admin.chkLstMgm.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
 * @author 하지홍
 * @since 2021. 10.12
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface ChkLstMgmService {
	
	/**
	 * 한국건축규정 체크리스트 항목관리 등록처리
	 * @param paramMap
	 * @param request 
	 * @return
	 * @throws Exception
	 */
	int insertKppLawordMgmExec(HashMap paramMap, HttpServletRequest request) throws Exception;
	
	/**
	 * 한국건축규정 체크리스트 항목관리 수정처리
	 * @param paramMap
	 * @param request 
	 * @return
	 * @throws Exception
	 */
	int updateKppLawordMgmExec(HashMap paramMap, HttpServletRequest request) throws Exception;

	/**
	 * 한국건축규정 체크리스트 항목관리 삭제처리
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int deleteKppLawordMgmExec(HashMap paramMap) throws Exception;
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<?> selectKppLawordMgmListInfo(HashMap paramMap) throws Exception;
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록 개수조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int selectKppLawordMgmListTotCnt(HashMap paramMap) throws Exception;
	
	/**
	 * 한국건축규정 체크리스트 항목관리 상세조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	EgovMap selectKppLawordMgmInfo(HashMap paramMap) throws Exception;
	
	/**
	 * 한국건축규정 맞춤형 체크리스트 항목 조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<?> selectkppLawordFixesChkLst(HashMap paramMap) throws Exception;

	
	
	
	
	
	 
}
