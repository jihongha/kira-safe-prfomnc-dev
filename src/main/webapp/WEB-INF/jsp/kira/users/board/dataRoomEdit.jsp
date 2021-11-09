<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공개자료실 수정</title>
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

function updateBppCmmnBoardDataRoom() {
	var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn);
	
	if (flag) {
		alert("간다간다쑝간다");
		$.ajax({
			url: "/user/board/updateBppCmmnBoardDataRoom.do",
			type: "POST",
			cache: false,
			data: {
				bppCmmnBoardSeqNo: bppCmmnBoardSeqNo,
				bppCmmnBoardSj: bppCmmnBoardSj,				
				bppCmmnBoardCn: bppCmmnBoardCn
			},
			success: function(data) {
				var result = JSON.parse(data);
				console.log(result);
				
				if (result.isSucceeded == "Y") {
					alert(result.msg);
					location.href = "/user/board/dataRoom.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
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

function goDataRoomList(){
	location.href = "/user/board/dataRoomList.do";
}

$(function() {
	$("#bppCnnmBoardDataRoomForm").on("submit", function(e){
		updateBppCmmnBoardDataRoom();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<h4>글번호:  ${resultMap.bppCmmnBoardSeqNo}</h4>
	<form id="bppCnnmBoardDataRoomForm" name="bppCnnmBoardDataRoomForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj" value="${resultMap.bppCmmnBoardSj}"><br>
		
		<label for="bppCmmnBoardCn">내용</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn">${resultMap.bppCmmnBoardCn}</textarea><br>
		
		<label for="bppCmmnBoardSj">첨부파일</label>
		<input type="file" id="" name=""><br>
		
		<button type="submit">수정완료</button>
		<button type="reset" onclick="goDataRoomList()">취소</button>
	</form>
</body>
</html>