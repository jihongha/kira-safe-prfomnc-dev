<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%
	//상위메뉴코드
	String topMenuCd 	=	"";
	if(request.getAttribute("topMenuCd") != null){
		topMenuCd 		=	(String)request.getAttribute("topMenuCd");
	}
	
	//하위메뉴코드
	String subMenuCd 	=	"";
	if(request.getAttribute("subMenuCd") != null){
		subMenuCd 		=	(String)request.getAttribute("subMenuCd");;
	}
%>
<!DOCTYPE html>
<html>
        <div class="col-sm-3 col-md-2 sidebar">
        	<%
        	if("intrcn".equals(topMenuCd) ){
        	%>
	          <ul class="nav nav-sidebar">
	            <li <%if("intrcn".equals(subMenuCd) ){ %> class="active" <%} %>>
	            	<a href="/user/intrcn/intrcn.do">건안성소개</a>
	            </li>
	          </ul>
	        <%
        	}
	        %>
	        
	        
	        <%
        	if("board".equals(topMenuCd) ){
        	%>
	          <ul class="nav nav-sidebar">
	            <li <%if("notice".equals(subMenuCd) ){ %> class="active" <%} %>>
	            	<a href="/user/board/noticeList.do">공지사항</a>
	            </li>
	            <li <%if("dataRoom".equals(subMenuCd) ){ %> class="active" <%} %>>
	            	<a href="/user/board/dataRoomList.do">공개자료실</a>
	            </li>
	            <li <%if("newsData".equals(subMenuCd) ){ %> class="active" <%} %>>
	            	<a href="/user/board/newsDataList.do">보도자료</a>
	            </li>
	            <li <%if("faq".equals(subMenuCd) ){ %> class="active" <%} %>>
	            	<a href="/user/board/faqList.do">FAQ</a>
	            </li>
	            <li <%if("qna".equals(subMenuCd) ){ %> class="active" <%} %>>
	            	<a href="/user/board/qnaList.do">Q&A</a>
	            </li>
	          </ul>
	        <%
        	}
	        %>
          
        </div>

</html>
