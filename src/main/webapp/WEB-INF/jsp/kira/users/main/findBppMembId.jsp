<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<script type="text/javascript">

function goSelectBppMembId() {
	$.ajax({
		url: "/user/main/selectBppMembId.do",
		type: "POST",
		cache: false,
		data: {
			bppMembNm: $("#bppMembNm").val(),
			bppMembBrthdy: $("#bppMembBrthdy").val(),
			bppMembEmailAdres: $("#bppMembEmailAdres").val()
		},
		success: function(data) {
			var result = JSON.parse(data);
			
			if (result.isSucceeded == "Y") {
				alert(result.msg);
				goSuccessFindBppMembId(result.bppMembId);
			} else {
				alert(result.msg);
			}
		},
		error: function(request, status, error) {
	    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
	    }
	});
}

function goSuccessFindBppMembId(param) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/user/main/successFindBppMembId.do");
    
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bppMembId");
    hiddenField.setAttribute("id", "bppMembId");
    hiddenField.setAttribute("value", param);
    
    form.appendChild(hiddenField);
    
    document.body.appendChild(form);
    form.submit();
}

$(function() {
	$("#findBppMembIdForm").on("submit", function(e){
		goSelectBppMembId();
	    e.preventDefault();
	});
})
</script>
</head>
<body>
	<h1>여기는 아이디 찾기 화면!</h1>
	
	<form id="findBppMembIdForm" name="findBppMembIdForm" method="post">
		<label>이름: </label>
		<input type="text" id="bppMembNm" name="bppMembNm"><br>
		<label>생년월일: </label>
		<input type="text" id="bppMembBrthdy" name="bppMembBrthdy"><br>
		<label>이메일: </label>
		<input type="text" id="bppMembEmailAdres" name="bppMembEmailAdres"><br>
		
		<button type="submit">아이디 찾기</button>
	</form><br><br>
</body>
</html>