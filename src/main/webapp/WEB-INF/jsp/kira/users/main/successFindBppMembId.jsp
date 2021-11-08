<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h3>회원님의 아이디 찾기 결과는 다음과 같습니다.</h3><br>

<div>
	<p>아이디: <b>${bppMembId}</b>
</div>

<button onclick="goLogin()">로그인 하기</button>
<button onclick="goFindBppMembPwd()">비밀번호 찾기</button>

</body>
</html>