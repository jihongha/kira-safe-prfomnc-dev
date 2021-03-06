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
package kr.or.kira.safe.prfomnc.admin.sysMgm.service;

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
 * @author 하지홍
 * @since 2021. 10.12
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public interface SysMgmService {
	
	/**
	 * 시스템관리 사용자관리 목록조회
	 * @param paramMap
	 * @return
	 */
	List<?> selectkppIntraMembListInfo(HashMap paramMap) throws Exception;
	
	/**
	 * 시스템관리 사용자관리 목록 개수조회 
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int selectkppIntraMembListTotCnt(HashMap paramMap) throws Exception;
	
	/**
	 * 시스템관리 사용자관리 상세조회
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	EgovMap selectKppIntraMembDetViewInfo(HashMap paramMap) throws Exception;
	
	/**
	 * 시스템관리 사용자 관리 가입승인, 반려처리
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	int saveKppIntraSbscrbUpdtExec(HashMap paramMap) throws Exception;

	
	
	 
}
