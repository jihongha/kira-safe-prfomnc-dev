<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	EgovMap kppIntraMembInfo	=	new EgovMap();
	if(request.getAttribute("kppIntraMembInfo") != null){
		kppIntraMembInfo	=	(EgovMap)request.getAttribute("kppIntraMembInfo");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한국건축규정 체크리스트 상세보기</title>

<script>

/**
 * 목록으로 이동 버튼 클릭시 발생이벤트
 */
function  backKppIntraMembLstFn(){
	location.href	=	"/admin/sysMgm/kppIntraMembLst.do";
}


/**
 * 가입승인, 반려 이벤트
 */
function confirmSbscrbConfmAtFn(kppSbscrbConfmAt){
	$("#kppSbscrbConfmAt").val(kppSbscrbConfmAt);
	
	var kppSbscrbConfmAtTxt		=		"";
	if(kppSbscrbConfmAt == "Y"){
		kppSbscrbConfmAtTxt		=		"승인";
	}else{
		kppSbscrbConfmAtTxt		=		"반려";
	}
	
	if(confirm("[" + kppSbscrbConfmAtTxt + "] 하시겠습니까?")){
		$("#kppIntraMembForm").attr("action"	,		"/admin/sysMgm/kppIntraSbscrbUpdtExec.do");
		$("#kppIntraMembForm").submit();
	}
	 	
}

</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
       	<h3 class="sub-header">관리자관리 상세보기</h3>
		<form class="form-horizontal"		id="kppIntraMembForm"		name="kppIntraMembForm"		method="post"	>
			<input type="hidden"			id="kppIntraOpeMembSeqNo"	name="kppIntraOpeMembSeqNo"			value="<%=kppIntraMembInfo.get("kppIntraOpeMembSeqNo") %>"		/>
			<input type="hidden"			id="kppSbscrbConfmAt"		name="kppSbscrbConfmAt"				value=""		/>
			
			
		  <div class="form-group">
		    <label for="lawordTy" class="col-sm-2 control-label">아이디</label>
		    <div class="col-sm-10">
		    	<%=(String)kppIntraMembInfo.get("kppMembId") %>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lawordNm" class="col-sm-2 control-label">이름</label>
		    <div class="col-sm-10">
		      <%=(String)kppIntraMembInfo.get("kppMembNm") %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgNm" class="col-sm-2 control-label">부서</label>
		    <div class="col-sm-10">
		      <%=(String)kppIntraMembInfo.get("kppDeptNm") %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-2 control-label">승인여부</label>
		    <div class="col-sm-10">
		    <%if("S".equals((String)kppIntraMembInfo.get("kppSbscrbConfmAt"))	){ %>
				승인대기              				
          	<%}else if("Y".equals((String)kppIntraMembInfo.get("kppSbscrbConfmAt"))	){ %>
				승인완료              				
          	<%}else{ %>
          		반려
          	<%} %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-2 control-label">가입일</label>
		    <div class="col-sm-10">
		      <%=(String)kppIntraMembInfo.get("firstCrtnDate") %>
		    </div>
		  </div>
		 
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		    	<button type="button" 	onclick="confirmSbscrbConfmAtFn('Y');"	class="btn btn-success">가입승인</button>
		    	<button type="button" 	onclick="confirmSbscrbConfmAtFn('N');"	class="btn btn-danger">가입반려</button>
		      	<button type="button" 	onclick="backKppIntraMembLstFn();"	class="btn btn-default">뒤로</button>
		    </div>
		  </div>
		</form>          
    </div>
      
</body>
</html>