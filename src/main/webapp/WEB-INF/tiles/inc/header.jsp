<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	// 로그인 세션
	String loginId = (String)EgovSessionCookieUtil.getSessionAttribute(request, "loginId");
	String loginNm = (String)EgovSessionCookieUtil.getSessionAttribute(request, "loginNm");
%>
<!DOCTYPE html>
<html>
	<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div style="padding-left : 20px; padding-right : 30px;">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">건축물 안전 및 성능향상</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li <%if("intrcn".equals(subMenuCd) ){ %> class="active" <%} %>>
            	<a href="/user/intrcn/intrcn.do">건안성 소개</a>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">정보 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li <%if("notice".equals(subMenuCd) ){ %> class="active" <%} %> ><a href="/user/board/noticeList.do">공지사항</a></li>
                <li <%if("dataRoom".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/user/board/dataRoomList.do">공개자료실</a></li>
                <li <%if("newsData".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/user/board/newsDataList.do">보도자료</a></li>
                <li <%if("faq".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/user/board/faqList.do">FAQ</a></li>
                <li <%if("qna".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/user/board/qnaList.do">Q&A</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
			<li><c:if test="${not empty loginNm}"><%=loginNm %>님</c:if></li>
			
            <li style="line-height: 50px; margin-right: 15px;">
            	<c:if test="${empty loginId}">
            		<button type="button" class="btn btn-default" onclick="location='/user/main/userLogin.do'">로그인</button>
            	</c:if>
            	
            	<c:if test="${not empty loginId}">
	            	<button type="button" class="btn btn-default" onclick="location='/user/main/userLogout.do'">로그아웃</button>
	            	<button type="button" class="btn btn-default" onclick="location='/user/main/checkAccountPwd.do'">마이페이지</button>
            	</c:if>
            </li>
            <li style="line-height: 50px;">
            	<c:if test="${empty loginId}">
	            	<button type="button" class="btn btn-primary" onclick="location='/user/main/useTerms.do'">회원가입</button>
            	</c:if>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
</html>
