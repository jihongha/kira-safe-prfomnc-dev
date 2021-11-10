<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<script type="text/javascript">

function checkNull() {
	var bppMembNm = $("#bppMembNm").val();
	var bppMembBrthdy = $("#bppMembBrthdy").val();
	var bppMembEmailAdres = $("#bppMembEmailAdres").val();
	var bppMembTelno = $("#bppMembTelno").val();
	
	var valueList = [bppMembNm, bppMembBrthdy, bppMembEmailAdres, bppMembTelno];
	for (var i in valueList) {
		if (valueList[i] == "" || valueList[i] == null) {
			return false;
		}
	}
	
	return true;
}

function goSuccessFindBppMembId() {
	var flag = checkNull();
	
	if (flag) {
		var findBppMembIdForm = document.findBppMembIdForm;
		findBppMembIdForm.submit();
	}
	else {
		alert("빈칸 없이 기입해주세요!");
	}
}

</script>
</head>
<body>
	<h1>아이디 찾기</h1>
	
	<form id="findBppMembIdForm" name="findBppMembIdForm" method="post" action="/user/main/successFindBppMembId.do">
		<label>이름: </label>
		<input type="text" id="bppMembNm" name="bppMembNm"><br>
		<label>생년월일: </label>
		<input type="text" id="bppMembBrthdy" name="bppMembBrthdy"><br>
		<label>이메일: </label>
		<input type="text" id="bppMembEmailAdres" name="bppMembEmailAdres"><br>
		<label>전화번호: </label>
		<input type="text" id="bppMembTelno" name="bppMembTelno"><br>
		
		<button type="button" onclick="goSuccessFindBppMembId()">아이디 찾기</button>
	</form><br><br>
</body>
</html>