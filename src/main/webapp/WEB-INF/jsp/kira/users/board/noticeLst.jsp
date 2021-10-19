<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>

<script>
/**
 * 공지사항 등록 버튼 발생이벤트
 */
function regBoardFn(){
	location.href = "/user/board/noticeWrite.do";
}
</script>

</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          
          <h2 class="sub-header">공지사항 TEST   
          		<button 	onclick="regBoardFn();"	type="button" class="btn btn-success"	style="float : right;">작성</button>
          </h2>
          
          <div class="table-responsive">
            <table class="table table-hover">
            	<colgroup>
            		<col width="10%" />
            		<col width="60%" />
            		<col width="15%" />
            		<col width="15%" />
            	</colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>등록일</th>
                  <th>조회수</th>
                </tr>
              </thead>
              <tbody>
              	<%for(int i=0 ; i <100; i++){ %>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>ipsum</td>
                </tr>
                <%} %>
              </tbody>
            </table>
          </div>
        </div>
      
</body>
</html>