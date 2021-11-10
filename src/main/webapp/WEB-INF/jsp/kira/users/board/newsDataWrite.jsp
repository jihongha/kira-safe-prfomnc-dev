<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보도자료 생성</title>
<script type="text/javascript">

function checkNull(bppCmmnBoardSj, bppCmmnBoardCn) {
	var flag = true;
	
	if (bppCmmnBoardSj == null || bppCmmnBoardSj == "") {
		flag = false;
	}
	if (bppCmmnBoardCn == null || bppCmmnBoardCn == "") {
		flag = false;
	}
	return flag;
}

function insertBppCmmnBoardNewsData() {
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn);
	
	if (flag) {
		$.ajax({
			url: "/user/board/insertBppCmmnBoardNewsData.do",
			type: "POST",
			cache: false,
			data: {
				bppCmmnBoardSj: bppCmmnBoardSj,
				bppCmmnBoardCn: bppCmmnBoardCn
			},
			success: function(data) {
				var result = JSON.parse(data);
				console.log(result);
				
				if (result.isSucceeded == "Y") {
					alert(result.msg);
					location.href = "/user/board/newsData.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
				}
				else {
					alert(result.msg);
				}
		    },
		    error: function(request, status, error){
		    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
		    }
		});
	    
	    return true;
	}
	else {
		alert("다 입력해주세요!");
		return false;
	}
}

function goNewsDataList(){
	location.href = "/user/board/newsDataList.do";
}

$(function() {
<%
	String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
	
	if (loginId == null) { %>
		alert("로그인 후 작성 가능합니다!");
		history.back();
<% } %>
	
	$("#bppCnnmBoardNewsDataForm").on("submit", function(e){
		insertBppCmmnBoardNewsData();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<form id="bppCnnmBoardNewsDataForm" name="bppCnnmBoardNewsDataForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj"><br>
		
		<label for="bppCmmnBoardCn">내용</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn"></textarea><br>
		
		<label for="bppCmmnBoardSj">첨부파일</label>
		<input type="file" id="" name=""><br>
		
		<button type="submit">작성</button>
		<button type="reset" onclick="goNewsDataList()">취소</button>
	</form>
</body>
</html>