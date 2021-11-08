<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공개자료실 하나</title>
<script type="text/javascript">
var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};

function goDataRoomList(){
	location.href = "/user/board/dataRoomList.do";
}

function updateBppCmmnBoard(){
	location.href = "/user/board/dataRoomEdit.do?bppCmmnBoardSeqNo="+bppCmmnBoardSeqNo;
}

function deleteBppCmmnBoard(){
	if (confirm("삭제하시겠습니까?") == true) {
		location.href = "/user/board/deleteBppCmmnBoardDataRoom.do?bppCmmnBoardSeqNo="+bppCmmnBoardSeqNo;
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
	<button type="reset" onclick="goDataRoomList()">목록</button>
	<button onclick="updateBppCmmnBoard()">수정</button>
	<button onclick="deleteBppCmmnBoard()">삭제</button>
</body>
</html>