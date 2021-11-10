<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자주묻는질문 전체조회</title>

<script>
function goFaqWrite(){
	location.href = "/user/board/faqWrite.do";
}

function goFaq(bppCmmnBoardSeqNo) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/user/board/faq.do");
    
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "bppCmmnBoardSeqNo");
    hiddenField.setAttribute("value", bppCmmnBoardSeqNo);
    
    form.appendChild(hiddenField);
    document.body.appendChild(form);
    form.submit();
}
</script>

</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          
          <h2 class="sub-header">자주묻는질문 전체조회   
          		<button onclick="goFaqWrite()" type="button" class="btn btn-success" style="float: right;">작성</button>
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
	                <tr onclick="goFaq('${egovMap.bppCmmnBoardSeqNo}')" style="cursor:pointer;">
	                  <td>${egovMap.bppCmmnBoardSeqNo}</td>
	                  <td>${egovMap.bppCmmnBoardSj}</td>
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