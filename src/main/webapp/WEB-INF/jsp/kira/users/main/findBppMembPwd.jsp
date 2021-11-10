<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>
<script type="text/javascript">
function goSelectBppMembPwd() {
	$.ajax({
		url: "/user/main/selectBppMembPwd.do",
		type: "POST",
		async: false,
		cache: false,
		data: {
			bppMembId: $("#bppMembId").val(),
			bppMembNm: $("#bppMembNm").val(),
			bppMembEmailAdres: $("#bppMembEmailAdres").val(),
			bppMembTelno: $("#bppMembTelno").val(),
			pwdChangQuesCd: $("#pwdChangQuesCd").val(),
			pwdChangAnsInfo: $("#pwdChangAnsInfo").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert(result.msg);
				location.href = "/user/main/resetBppMembPwd.do";
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
	$("#findBppMembPwdForm").on("submit", function(e){
		goSelectBppMembPwd();
	    e.preventDefault();
	});
})
</script>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	
	<form id="findBppMembPwdForm" name="findBppMembPwdForm" method="post">
		<label>아이디: </label>
		<input type="text" id="bppMembId" name="bppMembId"><br>
		
		<label>이름: </label>
		<input type="text" id="bppMembNm" name="bppMembNm"><br>
		
		<label>이메일: </label>
		<input type="text" id="bppMembEmailAdres" name="bppMembEmailAdres"><br>
		
		<label>전화번호: </label>
		<input type="text" id="bppMembTelno" name="bppMembTelno"><br>
		
		<label>비밀번호 변경 질문: </label>
		<select name="pwdChangQuesCd" id="pwdChangQuesCd">
			<option selected>선택
			<option value="q1">첫번째 질문
			<option value="q2">두번째 질문
			<option value="q3">세번째 질문
			<option value="q4">네번째 질문
			<option value="q5">다섯번째 질문
		</select>
		<input type="text" id="pwdChangAnsInfo" name="pwdChangAnsInfo" maxlength="500"><br><br>
		
		<button type="submit">비밀번호 찾기</button>
		<button type="reset">취소</button>
	</form><br><br>
	
</body>
</html>