<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자주묻는질문 수정</title>
<script type="text/javascript">

function checkNull(bppCmmnBoardSj, bppCmmnBoardCn, bppCmmnBoardAnswer) {
	var flag = true;
	
	if (bppCmmnBoardSj == null || bppCmmnBoardSj == "") {
		flag = false;
	}
	if (bppCmmnBoardCn == null || bppCmmnBoardCn == "") {
		flag = false;
	}
	if (bppCmmnBoardAnswer == null || bppCmmnBoardAnswer == "") {
		flag = false;
	}
	return flag;
}

function updateBppCmmnBoardFaq() {
	var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn, bppCmmnBoardAnswer);
	
	if (flag) {
		$.ajax({
			url: "/user/board/updateBppCmmnBoardFaq.do",
			type: "POST",
			cache: false,
			data: {
				bppCmmnBoardSeqNo: bppCmmnBoardSeqNo,
				bppCmmnBoardSj: bppCmmnBoardSj,				
				bppCmmnBoardCn: bppCmmnBoardCn,
				bppCmmnBoardAnswer: $("#bppCmmnBoardAnswer").val()	
			},
			success: function(data) {
				var result = JSON.parse(data);
				console.log(result);
				
				if (result.isSucceeded == "Y") {
					alert(result.msg);
					location.href = "/user/board/faq.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
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

function goFaqList(){
	location.href = "/user/board/faqList.do";
}

$(function() {
<%
	String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
	
	if (loginId == null) { %>
		alert("로그인 후 작성 가능합니다!");
		history.back();
<% } %>

	$("#bppCnnmBoardFaqForm").on("submit", function(e){
		updateBppCmmnBoardFaq();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<h4>글번호:  ${resultMap.bppCmmnBoardSeqNo}</h4>
	<form id="bppCnnmBoardFaqForm" name="bppCnnmBoardFaqForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj" value="${resultMap.bppCmmnBoardSj}"><br>
		
		<label for="bppCmmnBoardCn">Q. 질문</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn">${resultMap.bppCmmnBoardCn}</textarea><br>
		
		<label for="bppCmmnBoardAnswer">A. 답변</label>
		<textarea id="bppCmmnBoardAnswer" name="bppCmmnBoardAnswer">${resultMap.bppCmmnBoardAnswer}</textarea><br>
		
		<label for="bppCmmnBoardSj">첨부파일</label>
		<input type="file" id="" name=""><br>
		
		<button type="submit">작성</button>
		<button type="reset" onclick="goFaqList()">취소</button>
	</form>
</body>
</html>