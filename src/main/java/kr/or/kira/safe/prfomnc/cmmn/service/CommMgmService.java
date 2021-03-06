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
package kr.or.kira.safe.prfomnc.cmmn.service;

import java.util.HashMap;
import java.util.List;

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
public interface CommMgmService {
	
	/**
	 * 공통코드 조회
	 * @param lgrpCd
	 * @return
	 */
	List<?> selectCommCdMgmInfo(String lgrpCd) throws Exception;
	
	/**
	 * 검색 자동완성 텍스트별 검색항목 조회
	 * @param paramMap
	 * @return
	 */
	List<?> selectcomCdAutoComplList(HashMap<String, String> paramMap) throws Exception;

	 
}
