<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질의응답 하나</title>
<script type="text/javascript">
var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};

function goQnaList(){
	location.href = "/user/board/qnaList.do";
}

function updateBppCmmnBoard(){
	location.href = "/user/board/qnaEdit.do?bppCmmnBoardSeqNo="+bppCmmnBoardSeqNo;
}

function deleteBppCmmnBoard(){
	if (confirm("삭제하시겠습니까?") == true) {
		location.href = "/user/board/deleteBppCmmnBoardQna.do?bppCmmnBoardSeqNo="+bppCmmnBoardSeqNo;
	}
	else {
		return;
	}
}

function updateBppCmmnBoardQnaAnswer() {
	var bppCmmnBoardAnswer = $("#bppCmmnBoardAnswer").val();
	var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};
	
	if (bppCmmnBoardAnswer != "" && bppCmmnBoardAnswer != null) {
		$.ajax({
			url: "/user/board/updateBppCmmnBoardQnaAnswer.do",
			type: "POST",
			cache: false,
			data: {
				bppCmmnBoardAnswer: bppCmmnBoardAnswer,				
				bppCmmnBoardSeqNo: bppCmmnBoardSeqNo
			},
			success: function(data) {
				var result = JSON.parse(data);
				console.log(result);
				
				if (result.isSucceeded == "Y") {
					alert(result.msg);
					location.href = "/user/board/qnaAnswer.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
				}
				else {
					alert(result.msg);
				}
		    },
		    error: function(request, status, error){
		    	console.log("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
		    }
		})
	    
	    return true;
	}
	else {
		alert("답변을 입력해주세요!");
		return false;
	}
}

$(function() {
	$("#updateBppCmmnBoardQnaAnswerForm").on("submit", function(e){
		updateBppCmmnBoardQnaAnswer();
	    e.preventDefault();
	});
})
</script>
</head>
<body>
	<h4>글 번호: ${resultMap.bppCmmnBoardSeqNo}</h4>
	<table border = "1">
		<tr>
			<td><a href="#"></a>제목</td>
			<td class="second" colspan="3">${resultMap.bppCmmnBoardSj}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td class="second">${resultMap.firstWrtrId}</td>
			<td>조회수</td>
			<td class="second">${resultMap.bppCmmnBoardRdcnt}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td class="second" colspan="3">${resultMap.bppCmmnBoardCn}</td>
		</tr>
	</table>
	<button type="reset" onclick="goQnaList()">목록</button>
	
	<c:if test="${resultMap.boardAnswerComptAt eq 'N'}">
		<button onclick="updateBppCmmnBoard()">수정</button>
		<button onclick="deleteBppCmmnBoard()">삭제</button>
	</c:if>
	
	<c:if test="${resultMap.boardAnswerComptAt eq 'Y'}">
		<br><br>
		<table border="1">
			<tr>
				<td>답변</td>
				<td>${resultMap.bppCmmnBoardAnswer}</td>
			</tr>
			<tr>
				<td>답변일</td>
				<td>${resultMap.lastUpdtDt}</td>
			</tr>
		</table>
	</c:if>
	
	<br><br>
	<c:if test="${resultMap.boardAnswerComptAt eq 'N'}">
		<form id="updateBppCmmnBoardQnaAnswerForm" name="updateBppCmmnBoardQnaAnswerForm" method="post">
			<label>답변</label>
			<input type="text" id="bppCmmnBoardAnswer" name="bppCmmnBoardAnswer"><br>
			<button type="submit">답변 완료</button>
			<button type="reset">취소</button>
		</form>
	</c:if>
	<br><hr>
	
</body>
</html>