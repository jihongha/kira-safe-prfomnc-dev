<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질의응답 전체조회 </title>

<script>
function goQnaWrite(){
	location.href = "/user/board/qnaWrite.do";
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
           		<tr>
           			<td>
           				<c:if test="${egovMap.boardQuestOthbcAt eq '0'}">
           					<c:choose>
           						<c:when test="${egovMap.firstWrtrId eq 'lsy'}">
           							<a href="/user/board/qna.do?bppCmmnBoardSeqNo=${egovMap.bppCmmnBoardSeqNo}&boardQuestOthbcAt=${egovMap.boardQuestOthbcAt}">${egovMap.bppCmmnBoardSeqNo}</a>
           						</c:when>
           						<c:otherwise>
	                		${egovMap.bppCmmnBoardSeqNo}
           						</c:otherwise>
           					</c:choose>
		               	</c:if>
		               	<c:if test="${egovMap.boardQuestOthbcAt eq '1'}">
		               		<a href="/user/board/qna.do?bppCmmnBoardSeqNo=${egovMap.bppCmmnBoardSeqNo}&boardQuestOthbcAt=${egovMap.boardQuestOthbcAt}">${egovMap.bppCmmnBoardSeqNo}</a>
		               	</c:if>
           			</td>
           			<td>
           				<c:if test="${egovMap.boardQuestOthbcAt eq '0'}">
		               		비공개
		               	</c:if>
		               	<c:if test="${egovMap.boardQuestOthbcAt eq '1'}">
		               		공개
		               	</c:if>
           			</td>
           			<td>
           				<c:if test="${egovMap.boardQuestOthbcAt eq '0'}">
           					<c:choose>
           						<c:when test="${egovMap.firstWrtrId eq 'lsy'}">
           							<a href="/user/board/qna.do?bppCmmnBoardSeqNo=${egovMap.bppCmmnBoardSeqNo}&boardQuestOthbcAt=${egovMap.boardQuestOthbcAt}">${egovMap.bppCmmnBoardSj}</a>
           						</c:when>
           						<c:otherwise>
	                				${egovMap.bppCmmnBoardSeqNo}
           						</c:otherwise>
           					</c:choose>
		               	</c:if>
		               	<c:if test="${egovMap.boardQuestOthbcAt eq '1'}">
		               		<a href="/user/board/qna.do?bppCmmnBoardSeqNo=${egovMap.bppCmmnBoardSeqNo}&boardQuestOthbcAt=${egovMap.boardQuestOthbcAt}">${egovMap.bppCmmnBoardSj}</a>
		               	</c:if>
           			</td>
           			<td>${egovMap.firstWrtrId}</td>
           			<td>
           				<c:if test="${egovMap.boardAnswerComptAt eq '0'}">
		               		답변전
		               	</c:if>
		               	<c:if test="${egovMap.boardAnswerComptAt eq '1'}">
		               		답변완료
		               	</c:if>
           			</td>
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