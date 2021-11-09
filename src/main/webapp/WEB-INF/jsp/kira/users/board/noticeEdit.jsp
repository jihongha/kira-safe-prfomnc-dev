<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정</title>
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

function updateBppCmmnBoardNotice() {
	var bppCmmnBoardSeqNo = ${resultMap.bppCmmnBoardSeqNo};
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn);
	
	if (flag) {
		$.ajax({
			url: "/user/board/updateBppCmmnBoardNotice.do",
			type: "POST",
			cache: false,
			data: {
				bppCmmnBoardSeqNo: bppCmmnBoardSeqNo,
				bppCmmnBoardSj: bppCmmnBoardSj,
				bppCmmnBoardCn: bppCmmnBoardCn,
				popupExpsrAt: $("#popupExpsrAt").val(),
				popupExpsrBgnde: $("#popupExpsrBgnde").val(),
				popupExpsrEndde: $("#popupExpsrEndde").val()
			},
			success: function(data) {
				var result = JSON.parse(data);
				console.log(result);
				
				if (result.isSucceeded == "Y") {
					alert("수정 성공: " + result.msg);
					location.href = "/user/board/notice.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
				}
				else {
					alert("수정 실패: " + result.msg);
				}
		    },
		    error: function(request, status, error) {
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

function goNoticeList(){
	location.href = "/user/board/noticeList.do";
}

function isChecked() {
	var check = $("input:checkbox[id='popupExpsrAt']").prop("checked");
	
	if(check == true) {
		$(".pickData").attr("disabled", false);
		$("input:checkbox[id='popupExpsrAt']").val("Y");

	} else {
	    $(".pickData").attr("disabled", true);
		$("input:checkbox[id='popupExpsrAt']").val("N");
	}
}

$(function() {
	$("#bppCnnmBoardnoticeForm").on("submit", function(e){
		updateBppCmmnBoardNotice();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<h4>글번호:  ${resultMap.bppCmmnBoardSeqNo}</h4>
	<form id="bppCnnmBoardnoticeForm" name="bppCnnmBoardnoticeForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj" value="${resultMap.bppCmmnBoardSj}"><br>
		
		<label for="bppCmmnBoardCn">내용</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn">${resultMap.bppCmmnBoardCn}</textarea><br>
		
		<label for="bppCmmnBoardSj">첨부파일</label>
		<input type="file" id="" name=""><br>
		
		<label for="popupExpsrAt">팝업 노출 여부</label>
		<input type="checkbox" id="popupExpsrAt" name="popupExpsrAt" value="${resultMap.popupExpsrAt}" onclick="isChecked()"><br>
		
		<label for="popupExpsrBgnde">팝업 노출 시작일</label>
		<input type="date" id="popupExpsrBgnde" class="pickData" value="${resultMap.popupExpsrBgnde}" name="popupExpsrBgnde" disabled="disabled"><br>
		
		<label for="popupExpsrEndde">팝업 노출 종료일</label>
		<input type="date" id="popupExpsrEndde" class="pickData" value="${resultMap.popupExpsrEndde}" name="popupExpsrEndde" disabled="disabled"><br><br>
		
		<button type="submit">수정 완료</button>
		<button type="reset" onclick="goNoticeList()">취소</button>
	</form>
</body>
</html>