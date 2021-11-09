<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 생성</title>
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

function insertBppCmmnBoardNotice() {
	var bppCmmnBoardSj = $("#bppCmmnBoardSj").val();
	var bppCmmnBoardCn = $("#bppCmmnBoardCn").val();
	var flag = checkNull(bppCmmnBoardSj, bppCmmnBoardCn);
	
	if (flag) {
		$.ajax({
			url: "/user/board/insertBppCmmnBoardNotice.do",
			type: "POST",
			cache: false,
			data: {
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
					alert(result.msg);
					location.href = "/user/board/notice.do?bppCmmnBoardSeqNo=" + result.bppCmmnBoardSeqNo;
				}
				else {
					alert(result.msg);
				}
		    },
		    error: function(request, status, error) {
		    	alert("code: " + request.status + "\n" + "error: " + error + "\n" + "message: " + request.responseText);
		    }
		})
	    
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
		insertBppCmmnBoardNotice();
	    e.preventDefault();
	});
})

</script>
</head>
<body>
	<form id="bppCnnmBoardnoticeForm" name="bppCnnmBoardnoticeForm" method="post">
		<label for="bppCmmnBoardSj">제목</label>
		<input type="text" id="bppCmmnBoardSj" name="bppCmmnBoardSj"><br>
		
		<label for="bppCmmnBoardCn">내용</label>
		<textarea id="bppCmmnBoardCn" name="bppCmmnBoardCn"></textarea><br>
		
		<label for="bppCmmnBoardSj">첨부파일</label>
		<input type="file" id="" name=""><br>
		
		<label for="popupExpsrAt">팝업 노출 여부</label>
		<input type="checkbox" id="popupExpsrAt" name="popupExpsrAt" value="N" onclick="isChecked()"><br>
		
		<label for="popupExpsrBgnde">팝업 노출 시작일</label>
		<input type="date" id="popupExpsrBgnde" class="pickData" name="popupExpsrBgnde" disabled="disabled"><br>
		
		<label for="popupExpsrEndde">팝업 노출 종료일</label>
		<input type="date" id="popupExpsrEndde" class="pickData" name="popupExpsrEndde" disabled="disabled"><br><br>
		
		<button type="submit">작성</button>
		<button type="reset" onclick="goNoticeList()">취소</button>
	</form>
</body>
</html>