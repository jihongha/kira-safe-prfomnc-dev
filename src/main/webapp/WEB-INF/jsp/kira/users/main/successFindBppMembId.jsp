<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기 성공</title>
<script type="text/javascript">
function goLogin() {
	location.href = "/user/main/userLogin.do";
}

function goFindBppMembPwd() {
	location.href = "/user/main/findBppMembPwd.do";
}

</script>
</head>
<body>

<h3>아이디 찾기 결과</h3><br>

<div>
	<c:if test="${empty resultList}">
		<p>해당 정보의 아이디가 존재하지 않습니다. <br>
	</c:if>
	<c:if test="${not empty resultList}">
		<c:forEach items="${resultList}" var="egovMap">
			<p>아이디: <b>${egovMap.bppMembId}</b>
		</c:forEach>
	</c:if>
	
</div>

<button onclick="goLogin()">로그인 하기</button>
<button onclick="goFindBppMembPwd()">비밀번호 찾기</button>

</body>
</html>