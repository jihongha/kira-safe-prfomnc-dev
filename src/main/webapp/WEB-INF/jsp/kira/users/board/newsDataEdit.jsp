<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보도자료 수정</title>
<script type="text/javascript">
<% String bppCmmnBoardSeqNo = request.getParameter("bppCmmnBoardSeqNo"); %>

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

function updateBppCmmnBoardNewsData() {
	var bppCmmnBoardSeqNo = ${param.bppCmmnBoardSeqNo};
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn);
	
	if (flag) {
		$.ajax({
			url: "/user/board/updateBppCmmnBoardNewsData.do",
			data: {
				bppCmmnBoardSeqNo: bppCmmnBoardSeqNo,
				bppCmmnBoardSj: bppCmmnBoardSj,				
				bppCmmnBoardCn: bppCmmnBoardCn	
			},
			cache: false,
			type: "POST",
			success: function (data) {
				alert("수정 완료"+ data);
				location.href = "/user/board/newsData.do?bppCmmnBoardSeqNo="+bppCmmnBoardSeqNo;
			},
			error: function(request, status, error){
		        alert("code: "+request.status+"\n"+"error: "+error+"\n"+"message: "+request.responseText);
	       	}
		});
	    
	    return true;
	}
	else {
		alert("다 입력해주세요!");
		return false;
	}
}

function goNesDtaLst(){
	location.href = "/user/board/nesDtaLst.do";
}

$(function() {
	$("#bppCnnmBoardNesForm").on("submit", function(e){
		updateBppCmmnBoardNewsData();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<form id="bppCnnmBoardNesForm" name="bppCnnmBoardNesForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj" value="${resultMap.bppCmmnBoardSj}"><br>
		
		<label for="bppCmmnBoardCn">내용</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn">${resultMap.bppCmmnBoardCn}</textarea><br>
		
		<button type="submit">수정완료</button>
		<button type="reset" onclick="goNesDtaLst()">취소</button>
	</form>
</body>
</html>