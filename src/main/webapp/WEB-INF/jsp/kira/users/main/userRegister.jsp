<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반사용자 회원가입</title>
<script type="text/javascript">

// 아이디 중복체크
function checkId() {
	$.ajax({
		url: "/user/main/selectBppMembIdNotExists.do",
		type: "POST",
		cache: false,
		data: {
			bppMembId: $("#bppMembId").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert("사용 가능한 아이디입니다");
				$("#bppMembId").attr("disabled", "disabled");
			} else {
				alert("이미 존재하는 아이디입니다. 다시 입력해주세요. ");
				document.getElementById("bppMembId").value ='';
			}
		},
		error: function(request, status, error) {
	    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
	    }
	});
}

// 이메일 형식 체크

// 이메일 중복 체크

// 비밀번호 길이 체크

// 모두 입력했는지 체크

// 특수문자 안 들어가게 체크??
		
//로그인 처리
function goUserRegister() {
	$.ajax({
		url: "/user/main/insertBppMembMgmUser.do",
		type: "POST",
		cache: false,
		data: {
			bppMembId: $("#bppMembId").val(),
			bppMembPwd: $("#bppMembPwd").val(),
			bppMembNm: $("#bppMembNm").val(),
			bppMembBrthdy: $("#bppMembBrthdy").val(),
			bppMembEmailAdres: $("#bppMembEmailAdres").val(),
			bppMembTelno: $("#bppMembTelno").val(),
			pwdChangQuesCd: $("#pwdChangQuesCd").val(),
			pwdChangAnsInfo: $("#pwdChangAnsInfo").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert("사용자 회원가입 성공");
				location.href = "/user/main/successRegister.do";
			} else {
				alert("회원가입 실패");
			}
		},
		error: function(request, status, error) {
	    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
	    }
	});
}

$(function() {
	$("#userRegisterForm").on("submit", function(e){
		goUserRegister();
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
	})
})

</script>
</head>
<body>
	<h1>여기는 일반사용자 회원가입</h1>
	
	<form id="userRegisterForm" name="userRegisterForm" method="post">
		<table border="1">
			<tr>
				<td>아이디: </td>
				<td><input type="text" id="bppMembId" name="bppMembId" maxlength="30"><input type="button" value="중복확인" onclick="checkId()"></td>
			</tr>
			<tr>
				<td>비밀번호: </td>
				<td><input type="password" id="bppMembPwd" name="bppMembPwd" maxlength="30"></td>
			</tr>
			<tr>
				<td>비밀번호 재확인: </td>
				<td><input type="password" id="bppMembPwdAgain" name="bppMembPwdAgain" maxlength="30"><span id="alertPwd"></span></td>
			</tr>
			<tr>
				<td>이름: </td>
				<td><input type="text" id="bppMembNm" name="bppMembNm" maxlength="100"></td>
			</tr>
			<tr>
				<td>생년월일: </td>
				<td><input type="date" id="bppMembBrthdy" name="bppMembBrthdy"></td>
			</tr>
			<tr>
				<td>이메일: </td>
				<td><input type="text" id="bppMembEmailAdres" name="bppMembEmailAdres"></td>
			</tr>
			<tr>
				<td>전화번호: </td>
				<td><input type="text" id="bppMembTelno" name="bppMembTelno" maxlength="30"></td>
			</tr>
			<tr>
				<td>비밀번호 변경 질문: </td>
				<td>
					<select name="pwdChangQuesCd" id="pwdChangQuesCd">
						<option selected>선택
						<option value="q1">첫번째 질문
						<option value="q2">두번째 질문
						<option value="q3">세번째 질문
						<option value="q4">네번째 질문
						<option value="q5">다섯번째 질문
					</select>
					<input type="text" id="pwdChangAnsInfo" name="pwdChangAnsInfo" maxlength="500">
				</td>
			</tr>
		</table>
		<button type="submit">가입하기</button>
		<button type="reset">취소</button>
	</form>
	
</body>
</html>