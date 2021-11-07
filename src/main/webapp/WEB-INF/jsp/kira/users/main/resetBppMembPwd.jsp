<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String tempoBppMembId = (String)EgovSessionCookieUtil.getSessionAttribute(request, "tempoBppMembId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 초기화</title>
<script type="text/javascript">

function goUpdateBppMembPwd() {
	var tempoBppMembId = "<%= tempoBppMembId %>"
	
	$.ajax({
		url: "/user/main/updateBppMembPwd.do",
		type: "POST",
		cache: false,
		data: {
			bppMembId: tempoBppMembId,
			bppMembPwd: $("#bppMembPwd").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert(result.msg);
				location.href = "/user/main/userLogin.do";
			} else {
				alert(result.msg);
			}
		},
		error: function(request, status, error) {
	    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
	    }
	});
}

$(function() {
	$("#updateBppMembPwdForm").on("submit", function(e){
		goUpdateBppMembPwd();
	    e.preventDefault();
	});
	
	$("#bppMembPwdAgain").keyup(function() {
		var bppMembPwd = $("#bppMembPwd").val();
		var bppMembPwdAgain = $("#bppMembPwdAgain").val();
		
		if (bppMembPwdAgain != bppMembPwd) {
			$("#alertPwd").text("불일치");
		}
		else {
			$("#alertPwd").text("일치");
		}
	});
})
</script>
</head>
<body>
	<h3>비밀번호를 초기화합니다(아이디: <%= tempoBppMembId %>)</h3>
	
	<form id="updateBppMembPwdForm" name="updateBppMembPwdForm" method="post">
		<label>새 비밀번호:</label>
		<input type="text" id="bppMembPwd" name="bppMembPwd" maxlength="30"><br>
		
		<label>새 비밀번호 재확인:</label>
		<input type="text" id="bppMembPwdAgain" name="bppMembPwdAgain" maxlength="30"><span id="alertPwd"></span><br><br>

		<button type="submit">변경하기</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>