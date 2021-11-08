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
package kr.or.kira.safe.prfomnc.cmmn.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.or.kira.safe.prfomnc.cmmn.service.CommMgmService;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("commMgmService")
public class CommMgmServiceImpl extends EgovAbstractServiceImpl implements CommMgmService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommMgmServiceImpl.class);

	/** CommMgmMapper */
	@Resource(name="commMgmMapper")
	private CommMgmMapper commMgmMapper;
	
	/**
	 * 공통코드 조회
	 */
	@Override
	public List<?> selectCommCdMgmInfo(String lgrpCd) throws Exception {
		return commMgmMapper.selectCommCdMgmInfo(lgrpCd);
	}
	
	/**
	 * 검색 자동완성 텍스트별 검색항목 조회
	 */
	@Override
	public List<?> selectcomCdAutoComplList(HashMap<String, String> paramMap) throws Exception {
		return commMgmMapper.selectcomCdAutoComplList(paramMap);
	}


	 

}
