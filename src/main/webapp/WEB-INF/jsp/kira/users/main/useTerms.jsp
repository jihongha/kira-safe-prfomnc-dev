<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이용약관</title>
<script type="text/javascript">
// 확인 버튼 누르면 약관 모두 체크되었는지 확인
function isChecked() {
	var checkUseStplatAgreAt = $("input:checkbox[id='useStplatAgreAt']").prop("checked");
	var checkIndvInfoAgreAt = $("input:checkbox[id='indvInfoAgreAt']").prop("checked");
	
	if (checkUseStplatAgreAt && checkIndvInfoAgreAt) {
		location.href = "/user/main/registerType.do";
	} else {
		alert("모든 약관에 동의하지 않으면 회원가입이 불가합니다.");
	}

}

// 모두 동의 버튼 누르면 체크박스 두개에 다 체크해주기
function selectCheckbox() {
	if ($("input:checkbox[id='allAgree']").prop("checked")) {
		$("input[type=checkbox]").prop("checked", true);
	}
	else {
		$("input[type=checkbox]").prop("checked", false);
	}
}
</script>
</head>
<body>
	<h1>여기는 약관 동의창! 동의 안 하면 가입 ㄴㄴ</h1><br><br><br>
	
	<input type="checkbox" id="allAgree" name="allAgree" onclick="selectCheckbox()"><span>건안성 이용약관, 개인정보 수집 및 이용에 모두 동의합니다.</span>
		
	<h5><b>1. 건안성 이용약관 동의(필수)</b></h5>
	<textarea rows="5" cols="80" readonly="readonly">이용약관이 들어가는 자리입니다.</textarea><br>
	<input type="checkbox" id="useStplatAgreAt" name="useStplatAgreAt"><span>건안성 이용약관에 동의합니다.</span>
	<br><br>
	<h5><b>2. 개인정보 수집 및 이용 동의(필수)</b></h5>
	<textarea rows="5" cols="80" readonly="readonly">개인정보수집및이용내역 들어가는 자리입니다.</textarea><br>
	<input type="checkbox" id="indvInfoAgreAt" name="indvInfoAgreAt"><span>개인정보 수집 및 이용에 동의합니다.</span>
	<br><br>
	<input type="button" value="확인" onclick="isChecked()">
	<input type="button" value="취소">
</body>
</html>