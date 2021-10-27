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
package kr.or.kira.safe.prfomnc.admin.sysMgm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.admin.chkLstMgm.service.ChkLstMgmService;
import kr.or.kira.safe.prfomnc.admin.sysMgm.service.SysMgmService;

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

@Service("sysMgmService")
public class SysMgmServiceImpl extends EgovAbstractServiceImpl implements SysMgmService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysMgmServiceImpl.class);

	/** sysMgmMapper */
	@Resource(name="sysMgmMapper")
	private SysMgmMapper sysMgmMapper;
	
	/**
	 * 시스템관리 사용자관리 목록조회
	 */
	@Override
	public List<?> selectkppIntraMembListInfo(HashMap paramMap) throws Exception {
		return sysMgmMapper.selectkppIntraMembListInfo(paramMap) ;
	}
	
	/**
	 * 시스템관리 사용자관리 상세조회
	 */
	@Override
	public EgovMap selectKppIntraMembDetViewInfo(HashMap paramMap) throws Exception {
		return sysMgmMapper.selectKppIntraMembDetViewInfo(paramMap) ;
	}
	
	/**
	 * 시스템관리 사용자 관리 가입승인, 반려처리
	 */
	@Override
	public int saveKppIntraSbscrbUpdtExec(HashMap paramMap) throws Exception {
		return sysMgmMapper.saveKppIntraSbscrbUpdtExec(paramMap) ;
	}
	 

}
