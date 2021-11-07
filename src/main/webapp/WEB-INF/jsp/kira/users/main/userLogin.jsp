<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript">

function goLogin() {
	$.ajax({
		url: "/user/main/selectBppMembMgmExists.do",
		type: "POST",
		cache: false,
		data: {
			bppMembId: $("#bppMembId").val(),
			bppMembPwd: $("#bppMembPwd").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert(result.msg);
				location.href = "/user/intrcn/intrcn.do";
			}
			else {
				alert(result.msg);
			}
		},
		error: function(request, status, error) {
	    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
	    }
	});
}

function goFindBppMembId() {
	location.href = "/user/main/findBppMembId.do";
}

function goFindBppMembPwd() {
	location.href = "/user/main/findBppMembPwd.do";
}

function goRegister() {
	location.href = "/user/main/useTerms.do";
}

$(function() {
	$("#loginForm").on("submit", function(e){
		goLogin();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<h1>여기는 로그인창</h1>
	
	<form id="loginForm" name="loginForm" method="post">
		<label>아이디: </label>
		<input type="text" id="bppMembId" name="bppMembId"><br>
		
		<label>패스워드: </label>
		<input type="text" id="bppMembPwd" name="bppMembPwd"><br>
		
		<button type="submit">로그인</button>
	</form><br><br>
	
	<p>아직 회원이 아니신가요?
	<button onclick="goRegister()">회원가입</button><br>
	
	<p>내 정보 찾기
	<button onclick="goFindBppMembId()">아이디 찾기</button>
	<button onclick="goFindBppMembPwd()">비밀번호 찾기</button>
</body>
</html>