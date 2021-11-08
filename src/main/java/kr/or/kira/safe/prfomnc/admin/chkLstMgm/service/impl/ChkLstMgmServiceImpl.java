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
package kr.or.kira.safe.prfomnc.admin.chkLstMgm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import kr.or.kira.safe.prfomnc.admin.chkLstMgm.service.ChkLstMgmService;

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

@Service("chkLstMgmService")
public class ChkLstMgmServiceImpl extends EgovAbstractServiceImpl implements ChkLstMgmService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChkLstMgmServiceImpl.class);

	/** chkLstMgmMapper */
	@Resource(name="chkLstMgmMapper")
	private ChkLstMgmMapper chkLstMgmMapper;
	
	/**
	 * 한국건축규정 체크리스트 항목관리 등록처리
	 */
	@Override
	public int insertKppLawordMgmExec(HashMap paramMap, HttpServletRequest request) throws Exception {
		//체크리스트 등록처리
		int resultCnt = chkLstMgmMapper.insertKppLawordMgmExec(paramMap);
		
		if(resultCnt > 0) {
			//건축물 용도
			if(request.getParameterValues("lawordBildPrpos") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordBildPrpos").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordBildPrpos = request.getParameterValues("lawordBildPrpos")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR002");
					commandMap.put("lawordFixesChklstCd", lawordBildPrpos);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			
			//지역
			if(request.getParameterValues("lawordArea") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordArea").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordArea = request.getParameterValues("lawordArea")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR003");
					commandMap.put("lawordFixesChklstCd", lawordArea);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			//지구
			if(request.getParameterValues("lawordDstrc") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordDstrc").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordDstrc = request.getParameterValues("lawordDstrc")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR004");
					commandMap.put("lawordFixesChklstCd", lawordDstrc);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			//구역
			if(request.getParameterValues("lawordZone") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordZone").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordZone = request.getParameterValues("lawordZone")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR005");
					commandMap.put("lawordFixesChklstCd", lawordZone);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			//층수, 층수 유형
			if(	(request.getParameter("inputLawordFloor") != null 	&&	!"".equals( (String)request.getParameter("inputLawordFloor") )) &&	 
				(request.getParameter("selectLawordFloorTy") != null 	&&	!"".equals( (String)request.getParameter("selectLawordFloorTy") ))) {
					HashMap commandMap = new HashMap();
					String inputLawordFloor = (String)request.getParameter("inputLawordFloor");
					String selectLawordFloorTy = (String)request.getParameter("selectLawordFloorTy");
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR006");
					commandMap.put("lawordFixesChklstCd", selectLawordFloorTy);
					commandMap.put("lawordFixesChklstScope", inputLawordFloor);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
			}
			
			//연면적, 연면적 유형
			if(	(request.getParameter("inputLawordTotar") != null 	&&	!"".equals( (String)request.getParameter("inputLawordTotar") )) &&	 
				(request.getParameter("selectLawordTotarTy") != null 	&&	!"".equals( (String)request.getParameter("selectLawordTotarTy") ))) {
					HashMap commandMap = new HashMap();
					String inputLawordTotar = (String)request.getParameter("inputLawordTotar");
					String selectLawordTotarTy = (String)request.getParameter("selectLawordTotarTy");
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR007");
					commandMap.put("lawordFixesChklstCd", selectLawordTotarTy);
					commandMap.put("lawordFixesChklstScope", inputLawordTotar);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
			}
			
			
			
		}
		
		return resultCnt;
	}
	
	/**
	 * 한국건축규정 체크리스트 항목관리 수정처리
	 */
	@Override
	public int updateKppLawordMgmExec(HashMap paramMap, HttpServletRequest request) throws Exception {
		int resultCnt = chkLstMgmMapper.updateKppLawordMgmExec(paramMap);
		
		if(resultCnt > 0) {
			chkLstMgmMapper.deleteKppLawordFixesChklstMgmExec(paramMap);
			
			//건축물 용도
			if(request.getParameterValues("lawordBildPrpos") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordBildPrpos").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordBildPrpos = request.getParameterValues("lawordBildPrpos")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR002");
					commandMap.put("lawordFixesChklstCd", lawordBildPrpos);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			
			//지역
			if(request.getParameterValues("lawordArea") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordArea").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordArea = request.getParameterValues("lawordArea")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR003");
					commandMap.put("lawordFixesChklstCd", lawordArea);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			//지구
			if(request.getParameterValues("lawordDstrc") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordDstrc").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordDstrc = request.getParameterValues("lawordDstrc")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR004");
					commandMap.put("lawordFixesChklstCd", lawordDstrc);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			//구역
			if(request.getParameterValues("lawordZone") != null) {
				for(int i=0 ; i < request.getParameterValues("lawordZone").length ; i++) {
					HashMap commandMap = new HashMap();
					String lawordZone = request.getParameterValues("lawordZone")[i];
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR005");
					commandMap.put("lawordFixesChklstCd", lawordZone);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
				}
			}
			
			//층수, 층수 유형
			if(	(request.getParameter("inputLawordFloor") != null 	&&	!"".equals( (String)request.getParameter("inputLawordFloor") )) &&	 
				(request.getParameter("selectLawordFloorTy") != null 	&&	!"".equals( (String)request.getParameter("selectLawordFloorTy") ))) {
					HashMap commandMap = new HashMap();
					String inputLawordFloor = (String)request.getParameter("inputLawordFloor");
					String selectLawordFloorTy = (String)request.getParameter("selectLawordFloorTy");
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR006");
					commandMap.put("lawordFixesChklstCd", selectLawordFloorTy);
					commandMap.put("lawordFixesChklstScope", inputLawordFloor);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
			}
			
			//연면적, 연면적 유형
			if(	(request.getParameter("inputLawordTotar") != null 	&&	!"".equals( (String)request.getParameter("inputLawordTotar") )) &&	 
				(request.getParameter("selectLawordTotarTy") != null 	&&	!"".equals( (String)request.getParameter("selectLawordTotarTy") ))) {
					HashMap commandMap = new HashMap();
					String inputLawordTotar = (String)request.getParameter("inputLawordTotar");
					String selectLawordTotarTy = (String)request.getParameter("selectLawordTotarTy");
					commandMap.put("lawordSeqNo", paramMap.get("lawordSeqNo") );
					commandMap.put("lawordFixesChklstTy", "KR007");
					commandMap.put("lawordFixesChklstCd", selectLawordTotarTy);
					commandMap.put("lawordFixesChklstScope", inputLawordTotar);
					commandMap.put("kppMembId", (String)paramMap.get("kppMembId") );
					//맞춤형 체크리스트 등록처리
					chkLstMgmMapper.insertKppLawordFixesChklstMgmExec(commandMap);
			}
			
			
			
		}
		
		return resultCnt;
	}
	
	/**
	 * 한국건축규정 체크리스트 항목관리 삭제처리
	 */
	@Override
	public int deleteKppLawordMgmExec(HashMap paramMap) throws Exception {
		int resultCnt = chkLstMgmMapper.deleteKppLawordMgmExec(paramMap);
						chkLstMgmMapper.deleteKppLawordFixesChklstMgmExec(paramMap);
		return resultCnt;
	}
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록조회
	 */
	@Override
	public List<?> selectKppLawordMgmListInfo(HashMap paramMap) throws Exception {
		return chkLstMgmMapper.selectKppLawordMgmListInfo(paramMap);
	}
	
	
	/**
	 * 한국건축규정 체크리스트 항목관리 목록 개수조회
	 */
	@Override
	public int selectKppLawordMgmListTotCnt(HashMap paramMap) throws Exception {
		return chkLstMgmMapper.selectKppLawordMgmListTotCnt(paramMap);
	}
	
	/**
	 * 한국건축규정 체크리스트 항목관리 상세조회
	 */
	@Override
	public EgovMap selectKppLawordMgmInfo(HashMap paramMap) throws Exception {
		return chkLstMgmMapper.selectKppLawordMgmInfo(paramMap);
	}
	
	/**
	 * 한국건축규정 맞춤형 체크리스트 항목 조회
	 */
	@Override
	public List<?> selectkppLawordFixesChkLst(HashMap paramMap) throws Exception {
		return chkLstMgmMapper.selectkppLawordFixesChkLst(paramMap);
	}
	
	
	
	
	

	 

}
