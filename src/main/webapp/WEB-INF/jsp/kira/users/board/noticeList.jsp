<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 전체조회</title>

<script>
function goNoticeWrite(){
	location.href = "/user/board/noticeWrite.do";
}
</script>

</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          
          <h2 class="sub-header">공지사항 전체조회   
          		<button onclick="goNoticeWrite()" type="button" class="btn btn-success" style="float: right;">작성</button>
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
                <c:forEach items="${resultMap}" var="egovMap">
	                <tr>
	                  <td><a href="/user/board/notice.do?bppCmmnBoardSeqNo=${egovMap.bppCmmnBoardSeqNo}">${egovMap.bppCmmnBoardSeqNo}</a></td>
	                  <td><a href="/user/board/notice.do?bppCmmnBoardSeqNo=${egovMap.bppCmmnBoardSeqNo}">${egovMap.bppCmmnBoardSj}</a></td>
	                  <td>${egovMap.lastUpdtDt}</td>
	                  <td>${egovMap.bppCmmnBoardRdcnt}</td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      
</body>
</html>