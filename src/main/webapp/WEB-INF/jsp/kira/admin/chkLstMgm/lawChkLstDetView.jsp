<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	EgovMap kppLawordMgmInfo	=	new EgovMap();
	if(request.getAttribute("kppLawordMgmInfo") != null){
		kppLawordMgmInfo	=	(EgovMap)request.getAttribute("kppLawordMgmInfo");
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
function  backLawChkLstFn(){
	location.href	=	"/admin/chkLstMgm/lawChkLst.do";
}

</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
       	<h3 class="sub-header">한국건축규정 체크리스트 상세보기</h3>
		<form class="form-horizontal"		id="kppLawordMgmForm"		name="kppLawordMgmForm"		method="post"		onsubmit="return regKppLawordMgmExec();"		>
		  <div class="form-group">
		    <label for="lawordTy" class="col-sm-2 control-label">법령구분</label>
		    <div class="col-sm-10">
		    	<%=(String)kppLawordMgmInfo.get("lawordTyNm") %>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lawordNm" class="col-sm-2 control-label">법령명</label>
		    <div class="col-sm-10">
		      <%=(String)kppLawordMgmInfo.get("lawordNm") %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgNm" class="col-sm-2 control-label">조문명</label>
		    <div class="col-sm-10">
		      <%=(String)kppLawordMgmInfo.get("lawordLrgNm") %>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-2 control-label">조문링크명</label>
		    <div class="col-sm-10">
		      <%=(String)kppLawordMgmInfo.get("lawordLrgLinkPath") %>
		    </div>
		  </div>
		 
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="button" 	onclick="backLawChkLstFn();"	class="btn btn-default">뒤로</button>
		    </div>
		  </div>
		</form>          
    </div>
      
</body>
</html>