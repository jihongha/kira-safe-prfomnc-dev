<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String loginId = (String) EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질의응답 전체조회 </title>

<script>
function goQnaWrite(){
	location.href = "/user/board/qnaWrite.do";
}

function goQna(bppCmmnBoardSeqNo) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/user/board/qna.do");
    
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
       <h2 class="sub-header">질의응답 전체조회   
       		<button onclick="goQnaWrite()" type="button" class="btn btn-success" style="float: right;">작성</button>
       </h2>
       <div class="table-responsive">
         <table class="table table-hover">
         	<colgroup>
         		<col width="10%" />
         		<col width="10%" />
         		<col width="40%" />
         		<col width="10%" />
         		<col width="10%" />
         		<col width="10%" />
         		<col width="10%" />
         	</colgroup>
           <thead>
             <tr>
               <th>번호</th>
               <th>공개여부</th>
               <th>제목</th>
               <th>작성자</th>
               <th>답변여부</th>
               <th>등록일</th>
               <th>조회수</th>
             </tr>
           </thead>
           
           <tbody>
           	<c:forEach items="${resultMap}" var="egovMap">
           		<c:if test="${egovMap.boardQuestOthbcAt eq 'N'}">
  					<c:choose>
   						<c:when test="${egovMap.firstWrtrId eq loginId}">
   							<tr onclick="goQna('${egovMap.bppCmmnBoardSeqNo}')" style="cursor:pointer;">
		           				<td>${egovMap.bppCmmnBoardSeqNo}</td>
		           				<td>공개</td>
		           				<td>${egovMap.bppCmmnBoardSj}</td>
		           				<td>${egovMap.firstWrtrId}</td>
		           				<td>
			           				<c:if test="${egovMap.boardAnswerComptAt eq 'N'}">
					               		답변대기
					               	</c:if>
					               	<c:if test="${egovMap.boardAnswerComptAt eq 'Y'}">
					               		답변완료
					               	</c:if>
			           			</td>
		           				<td>${egovMap.lastUpdtDt}</td>
		           				<td>${egovMap.bppCmmnBoardRdcnt}</td>
           					</tr>
   						</c:when>
   						<c:otherwise>
   							<tr>
		           				<td>${egovMap.bppCmmnBoardSeqNo}</td>
		           				<td>비공개</td>
		           				<td>비공개 게시글입니다</td>
		           				<td>${egovMap.firstWrtrId}</td>
		           				<td>
			           				<c:if test="${egovMap.boardAnswerComptAt eq 'N'}">
					               		답변대기
					               	</c:if>
					               	<c:if test="${egovMap.boardAnswerComptAt eq 'Y'}">
					               		답변완료
					               	</c:if>
			           			</td>
		           				<td>${egovMap.lastUpdtDt}</td>
		           				<td>${egovMap.bppCmmnBoardRdcnt}</td>
		           			</tr>
   						</c:otherwise>
   					</c:choose>
               	</c:if>
           		<c:if test="${egovMap.boardQuestOthbcAt eq 'Y'}">
           			<tr onclick="goQna('${egovMap.bppCmmnBoardSeqNo}')" style="cursor:pointer;">
           				<td>${egovMap.bppCmmnBoardSeqNo}</td>
           				<td>공개</td>
           				<td>${egovMap.bppCmmnBoardSj}</td>
           				<td>${egovMap.firstWrtrId}</td>
           				<td>
	           				<c:if test="${egovMap.boardAnswerComptAt eq 'N'}">
			               		답변대기
			               	</c:if>
			               	<c:if test="${egovMap.boardAnswerComptAt eq 'Y'}">
			               		답변완료
			               	</c:if>
	           			</td>
           				<td>${egovMap.lastUpdtDt}</td>
           				<td>${egovMap.bppCmmnBoardRdcnt}</td>
           			</tr>
               	</c:if>
           	</c:forEach>
           </tbody>
         </table>
       </div>
     </div>
</body>
</html>