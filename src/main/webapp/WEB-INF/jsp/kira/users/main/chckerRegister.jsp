<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검토자 회원가입</title>
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
	})
}

// 이메일 형식 체크

// 비밀번호 길이 체크

// 모두 입력했는지 체크

// 특수문자 안 들어가게 체크??
		
function goChckerRegister() {
	$.ajax({
		url: "/user/main/insertBppMembMgmChcker.do",
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
			pwdChangAnsInfo: $("#pwdChangAnsInfo").val(),
			chckerChrgSigunguCd: $("#chckerChrgSigunguCd").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert("검토자 회원가입 성공");
				location.href = "/user/main/successRegister.do";
			} else {
				alert("응답은 성공했으나 무언가 문제가 있었나봄");
			}
		},
		error: function(request, status, error) {
	    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
	    }
	});
}

$(function() {
	$("#chckerRegisterForm").on("submit", function(e){
		goChckerRegister();
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
	<h1>여기는 검토자 회원가입</h1>
	
	<form id="chckerRegisterForm" name="chckerRegisterForm" method="post">
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
				<td><input type="date" id="bppMembBrthdy" name="bppMembBrthdy" maxlength="10"></td>
			</tr>
			<tr>
				<td>이메일: </td>
				<td><input type="text" id="bppMembEmailAdres" name="bppMembEmailAdres" maxlength="100"></td>
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
			<tr>
				<td>검토 담당 시군구: </td>
				<td>
					<input type="text" id="chckerChrgSigunguCd" name="chckerChrgSigunguCd" maxlength="500">
					<input type="button" id="" name="" onclick="" value="담당 지자체">
				</td>
			</tr>			
		</table>
		<button type="submit">가입하기</button>
		<button type="reset">취소</button>
	</form>
	
</body>
</html>