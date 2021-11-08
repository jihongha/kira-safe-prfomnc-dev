<%@page import="java.io.PrintWriter"%>
<%@page import="kr.or.kira.safe.prfomnc.cmmn.utl.EgovSessionCookieUtil"%>
<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
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
	
	
	EgovMap kppMembInfo 	= 	null;
	kppMembInfo = (EgovMap)EgovSessionCookieUtil.getSessionAttribute(request, "kppMembInfo");
	if(kppMembInfo == null  ){
		String PageUrl = "/admin/login/operator.do";
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter writer = response.getWriter(); 
		writer.println("<script>alert('비정상 접근입니다.'); location.href='"+PageUrl+"';</script>"); 
		writer.close();
	}
	
%>
<!DOCTYPE html>
<html>
	<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div  class="col-md-8 col-md-offset-2" style="padding-left : 20px; padding-right : 30px;">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/admin/board/noticeLst.do">건축물 안전 및 성능향상(관리자)</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">정보 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li <%if("notice".equals(subMenuCd) ){ %> class="active" <%} %> ><a href="/admin/board/noticeLst.do">공지사항</a></li>
                <li <%if("dataRoom".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/admin/board/dataRoomLst.do">공개자료실</a></li>
                <li <%if("nesDta".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/admin/board/nesDtaLst.do">보도자료</a></li>
                <li <%if("qna".equals(subMenuCd) ){ %> class="active" <%} %>><a href="/admin/board/qnaLst.do">Q&A</a></li>
              </ul>
            </li>
            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">체크리스트 관리 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li <%if("lawChkLst".equals(subMenuCd) ){ %> class="active" <%} %> ><a href="/admin/chkLstMgm/lawChkLst.do">한국건축규정 체크리스트</a></li>
              </ul>
            </li>
            
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">시스템 관리 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li <%if("kppIntraMemb".equals(subMenuCd) ){ %> class="active" <%} %> ><a href="/admin/sysMgm/kppIntraMembLst.do">관리자 관리</a></li>
              </ul>
            </li>
            
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li style="line-height: 50px; margin-right: 15px;">
          		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
          		<span	style="color: #4374D9; font-weight: 700">
          			<%=(String)kppMembInfo.get("kppMembNm") %>
          		</span>님 환영합니다.
          	</li>
          	
            <li style="line-height: 50px;">
            	<button type="button" class="btn btn-default"	onclick="kppMembLogout();"	>로그아웃</button>
            </li>
            
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


</html>

<script>
function kppMembLogout(){
	if(confirm("로그아웃 하시겠습니까?")){
		location.href="/admin/login/logout.do"		
	}
}
</script>

