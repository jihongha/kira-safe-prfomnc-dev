<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 재확인</title>
<script type="text/javascript">
function goMyPage() {
	var bppMembId = $("#bppMembId").val();
	var bppMembPwd = $("#bppMembPwd").val();
	var flag = true;
	
	if (bppMembId == "" || bppMembId == null) {
		alert("로그인 상태가 아닙니다!");
		flag = false;
	}
	
	if (bppMembPwd == "" || bppMembPwd == null) {
		alert("비밀번호를 기입해주세요!");
		flag = false;
	}
	
	if (flag) {
		$.ajax({
			url: "/user/main/selectAccountPwd.do",
			type: "POST",
			cache: false,
			data: {
				bppMembId: bppMembId,
				bppMembPwd: bppMembPwd
			},
			success: function(data) {
				var result = JSON.parse(data);
				
				if (result.isSucceeded == "Y") {
					alert(result.msg);
					location.href = "/user/main/myPage.do";
				}
				else {
					alert(result.msg);
					$("#bppMembPwd").val("");
				}
			},
			error: function(request, status, error) {
		    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
		    }
		});
	}
}
</script>
</head>
<body>
	<form id="checkLoginAccountPwdForm" name="checkLoginAccountPwdForm" method="post" action="">
		<h4>개인정보 조회 전 다시 한 번 비밀번호를 확인합니다.</h4>
		<br>
		<label>비밀번호</label>
		<input type="password" id="bppMembPwd" name="bppMembPwd">
		<input type="hidden" id="bppMembId" name="bppMembId" value="${loginId}">
		
		<button type="button" onclick="goMyPage()">확인</button>
	</form>
</body>
</html>