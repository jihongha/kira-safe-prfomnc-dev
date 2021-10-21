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
package kr.or.kira.safe.prfomnc.admin.main.service.impl;

import java.util.HashMap;
import java.util.List;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.admin.main.service.AdminMainService;
import kr.or.kira.safe.prfomnc.users.main.service.UserMainService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

@Service("adminMainService")
public class AdminMainServiceImpl extends EgovAbstractServiceImpl implements AdminMainService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMainServiceImpl.class);

	/** adminMainMapper */
	@Resource(name="adminMainMapper")
	private AdminMainMapper adminMainMapper;
	
	
	/**
	 * 관리자 계정정보 존재여부 확인
	 */
	@Override
	public int selectKppIntraOpeMembExstCnt(HashMap<String, String> paramMap) throws Exception {
		return adminMainMapper.selectKppIntraOpeMembExstCnt(paramMap);
	}
	
	/**
	 * 관리자 정보 조회
	 */
	@Override
	public EgovMap selectKppIntraOpeMembInfo(HashMap<String, String> paramMap) throws Exception {
		return adminMainMapper.selectKppIntraOpeMembInfo(paramMap);
	}



	 

}
