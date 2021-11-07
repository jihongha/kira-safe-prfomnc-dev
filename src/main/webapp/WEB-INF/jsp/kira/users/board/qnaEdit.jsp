<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질의응답 수정</title>
<script type="text/javascript">

function checkNull(bppCmmnBoardSj, bppCmmnBoardCn, bppCmmnBoardAnswer) {
	var flag = true;
	
	if (bppCmmnBoardSj == null || bppCmmnBoardSj == "") {
		flag = false;
	}
	if (bppCmmnBoardCn == null || bppCmmnBoardCn == "") {
		flag = false;
	}
	return flag;
}

function updateBppCmmnBoardQna() {
	var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn);
	
	if (flag) {
		$.ajax({
			url: "/user/board/updateBppCmmnBoardQna.do",
			type: "POST",
			cache: false,
			data: {
				bppCmmnBoardSeqNo: bppCmmnBoardSeqNo,				
				bppCmmnBoardSj: bppCmmnBoardSj,				
				bppCmmnBoardCn: bppCmmnBoardCn,
				boardQuestOthbcAt: $("#boardQuestOthbcAt").val()
			},
			success: function(data) {
				var result = JSON.parse(data);
				console.log(result);
				
				if (result.isSucceeded == "Y") {
					alert("수정 성공: " + result.msg);
					location.href = "/user/board/qna.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
				}
				else {
					alert("수정 실패: " + result.msg);
				}
		    },
		    error: function(request, status, error){
		    	console.log("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
		    }
		});
	    
	    return true;
	}
	else {
		alert("다 입력해주세요!");
		return false;
	}
}

function goQnaList(){
	location.href = "/user/board/qnaList.do";
}

function isChecked() {
	var check = $("input:checkbox[id='boardQuestOthbcAt']").prop("checked");
	
	if(check == true) {
		$("input:checkbox[id='boardQuestOthbcAt']").val("1");

	} else {
		$("input:checkbox[id='boardQuestOthbcAt']").val("0");
	}
}

$(function() {
	$("#bppCnnmBoardQnaForm").on("submit", function(e){
		updateBppCmmnBoardQna();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<form id="bppCnnmBoardQnaForm" name="bppCnnmBoardQnaForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj" value="${resultMap.bppCmmnBoardSj}"><br>
		
		<label for="bppCmmnBoardCn">내용</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn">${resultMap.bppCmmnBoardCn}</textarea><br>
		
		<label for="bppCmmnBoardSj">첨부파일</label>
		<input type="file" id="" name=""><br>
		
		<label for="boardQuestOthbcAt">글 공개 여부</label>
		<input type="checkbox" id="boardQuestOthbcAt" name="boardQuestOthbcAt" value="${resultMap.boardQuestOthbcAt}" onclick="isChecked()"><br>
		
		
		<button type="submit">수정 완료</button>
		<button type="reset" onclick="goQnaList()">취소</button>
	</form>
</body>
</html>