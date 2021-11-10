<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h3>마이페이지~~~!!!!</h3>
	
	<table>
		<tr>
			<td>아이디</td>
			<td>${resultMap.bppMembId}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="bppMembPwd" name="bppMembPwd" maxlength="30"></td>
		</tr>
		<tr>
			<td>비밀번호 재확인: </td>
			<td><input type="text" id="bppMembPwdAgain" name="bppMembPwdAgain" maxlength="30"><span id="alertPwd"></span></td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${resultMap.bppMembNm}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${resultMap.bppMembBrthdy}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="bppMembEmailAdres" name="bppMembEmailAdres" value="${resultMap.bppMembEmailAdres}"></td>
		</tr>
		<tr>
			<td>전화번호: </td>
			<td><input type="text" id="bppMembTelno" name="bppMembTelno" maxlength="30" value="${resultMap.bppMembTelno}"></td>
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
				<input type="text" id="pwdChangAnsInfo" name="pwdChangAnsInfo" maxlength="500" value="${resultMap.bppMembId}">
			</td>
		</tr>
	</table>
	
	<button type="button">변경 완료</button>
</body>
</html>