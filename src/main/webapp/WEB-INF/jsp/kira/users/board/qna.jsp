<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
</body>
</html>