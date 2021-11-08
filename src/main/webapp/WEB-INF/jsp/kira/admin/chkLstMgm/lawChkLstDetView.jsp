<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	EgovMap kppLawordMgmInfo	=	new EgovMap();
	if(request.getAttribute("kppLawordMgmInfo") != null){
		kppLawordMgmInfo	=	(EgovMap)request.getAttribute("kppLawordMgmInfo");
	}
	
	//한국건축규정 맞춤형 체크리스트 상세항목 목록조회
	List kppLawordFixesChkLst	=	null;
	if(request.getAttribute("kppLawordFixesChkLst") != null){
		kppLawordFixesChkLst	=	(List)request.getAttribute("kppLawordFixesChkLst");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한국건축규정 체크리스트 상세보기</title>

<script>
/**
 * 체크리스트 관리 수정버튼 클릭시 발생이벤트
 */
function updtLawChkLstFn(){
	$("#kppLawordMgmForm").attr("action"			,			"/admin/chkLstMgm/lawChkLstUpdt.do");
	$("#kppLawordMgmForm").submit();
}

/**
 * 체크리스트 관리 삭제버튼 클릭시 발생이벤트
 */
function deleteLawChkLstFn(){
	if(confirm("삭제하시겠습니까?")){
		$("#kppLawordMgmForm").attr("action"		,			"/admin/chkLstMgm/lawChkLstDeleteExec.do");
		$("#kppLawordMgmForm").submit();
	}
}

/**
 * 목록으로 이동 버튼 클릭시 발생이벤트
 */
function  backLawChkLstFn(){
	location.href	=	"/admin/chkLstMgm/lawChkLst.do";
}

</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
       	<h3 class="sub-header">한국건축규정 체크리스트 상세보기</h3>
		<form class="form-horizontal"		id="kppLawordMgmForm"		name="kppLawordMgmForm"		method="post"		>
			<input type="hidden"		id="lawordSeqNo"		name="lawordSeqNo"		value="<%=kppLawordMgmInfo.get("lawordSeqNo") %>"		/>
		  <div class="form-group">
		    <label for="lawordTy" class="col-sm-3 control-label">법령구분</label>
		    <div class="col-sm-9">
		    	<%=(String)kppLawordMgmInfo.get("lawordTyNm") %>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lawordNm" class="col-sm-3 control-label">법령명</label>
		    <div class="col-sm-9">
		      <%=(String)kppLawordMgmInfo.get("lawordNm") %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgNm" class="col-sm-3 control-label">조문명</label>
		    <div class="col-sm-9">
		      <%=(String)kppLawordMgmInfo.get("lawordLrgNm") %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-3 control-label">조문링크명</label>
		    <div class="col-sm-9">
		      <%=(String)kppLawordMgmInfo.get("lawordLrgLinkPath") %>
		    </div>
		  </div>
		  
		  <!-- 한국건축규정 맞춤형 체크리스트 상세항목 목록조회 -->
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-3 control-label">맞춤형 체크리스트 항목</label>
		    <div class="col-sm-9">
		    	
		    	<%if(kppLawordFixesChkLst != null){
		    		for(int i = 0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkMap = (EgovMap)kppLawordFixesChkLst.get(i);
		    			if( !"KR006".equals( (String)kppLawordFixesChkMap.get("lawordFixesChklstTy")  ) 	&& !"KR007".equals( (String)kppLawordFixesChkMap.get("lawordFixesChklstTy")  )	){
		    	%>
		      			<span class="label label-primary	chkLst-label"	style="padding : 0.7em;"	><%=(String)kppLawordFixesChkMap.get("lawordFixesChklstCdNm") %></span>
				<%
		    			}else{
		    				String unitNm = "";
		    				if(	"KR006".equals( (String)kppLawordFixesChkMap.get("lawordFixesChklstTy")  ) ){
		    					unitNm = "층";
		    				}else{
		    					unitNm = "㎡";
		    				}
		    	%>
		    			<span class="label label-primary	chkLst-label"	style="padding : 0.7em;">
		    				<%=(String)kppLawordFixesChkMap.get("lawordFixesChklstScope") %>
		    				<%=unitNm %>
		    				<%=(String)kppLawordFixesChkMap.get("lawordFixesChklstCdNm") %>
		    			</span>
		    	<%			
		    			}
		    		}
		    	}
				%>
				
		    </div>
		  </div>
		  
		 
		  <div class="form-group">
		    <div class="col-sm-offset-3 col-sm-9">
		    	<button type="button" 	onclick="updtLawChkLstFn();"	class="btn btn-success">수정</button>
		    	<button type="button" 	onclick="deleteLawChkLstFn();"	class="btn btn-danger">삭제</button>
		      	<button type="button" 	onclick="backLawChkLstFn();"	class="btn btn-default">뒤로</button>
		    </div>
		  </div>
		</form>          
    </div>
      
</body>
</html>