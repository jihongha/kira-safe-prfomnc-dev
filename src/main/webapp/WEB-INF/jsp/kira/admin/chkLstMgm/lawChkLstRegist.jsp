<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List commCdKR001Lst	=	null;
	if(request.getAttribute("commCdKR001Lst") != null){
		commCdKR001Lst	=	(List)request.getAttribute("commCdKR001Lst");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한국건축규정 체크리스트 등록</title>

<script>
/**
 * 한국건축규정 맞춤형 체크리스트 등록처리
 */
function regKppLawordMgmExec(){
	if(validation()){
		$("#kppLawordMgmForm").attr("action", "/admin/chkLstMgm/lawChkLstRegistExec.do");
		$("#kppLawordMgmForm").submit();	
	}else{
		return false;
	}
}

/**
 * 유효성 체크
 */
function validation(){
	
	//법령구분
	if($("#lawordTy").val() == null || $("#lawordTy").val() == ""){
		alert("법령구분을 선택해주시길 바랍니다.");
		return false;
	}
	
	
	//법령명
	if($("#lawordNm").val() == null || $("#lawordNm").val() == ""){
		alert("법령명을 입력해주시길 바랍니다.");
		return false;
	}
	
	
	//조문명
	if($("#lawordLrgNm").val() == null || $("#lawordLrgNm").val() == ""){
		alert("조문명을 입력해주시길 바랍니다.");
		return false;
	}
	
	return true;
} 
</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
       	<h3 class="sub-header">한국건축규정 체크리스트 등록</h3>
		<form class="form-horizontal"		id="kppLawordMgmForm"		name="kppLawordMgmForm"		method="post"		onsubmit="return regKppLawordMgmExec();"		>
		  <div class="form-group">
		    <label for="lawordTy" class="col-sm-2 control-label">법령구분</label>
		    <div class="col-sm-10">
		    	<select		id="lawordTy"		name="lawordTy"		class="form-control"		required autofocus>
		    		<option	value="">-선택-</option>
		    		<%for(int i=0 ; i < commCdKR001Lst.size() ; i++){
		    			EgovMap commCdMgm = (EgovMap)commCdKR001Lst.get(i);
		    		%>
		    		<option	value="<%=(String)commCdMgm.get("sgrpCd")%>"><%=(String)commCdMgm.get("cdDesc")%></option>
		    		<%} %>
		    	</select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lawordNm" class="col-sm-2 control-label">법령명</label>
		    <div class="col-sm-10">
		      <input type="text"  id="lawordNm" 	name="lawordNm"	class="form-control"		placeholder="법령명을 입력하세요"		required>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgNm" class="col-sm-2 control-label">조문명</label>
		    <div class="col-sm-10">
		      <input type="text"  id="lawordLrgNm" 	name="lawordLrgNm"	class="form-control"		placeholder="조문명을 입력하세요"		required>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-2 control-label">조문링크명</label>
		    <div class="col-sm-10">
		      <input type="text"  id="lawordLrgLinkPath" 	name="lawordLrgLinkPath"	class="form-control"		placeholder="조문링크명을 입력하세요">
		    </div>
		  </div>
		 
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">등록</button>
		    </div>
		  </div>
		</form>          
    </div>
      
</body>
</html>