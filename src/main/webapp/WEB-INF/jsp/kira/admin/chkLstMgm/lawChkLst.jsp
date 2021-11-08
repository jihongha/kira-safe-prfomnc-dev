<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List kppLawordMgmLst	=	null;
	if(request.getAttribute("kppLawordMgmLst") != null){
		kppLawordMgmLst	=	(List)request.getAttribute("kppLawordMgmLst");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한국건축규정 체크리스트 관리</title>
<script>
/**
 * 한국건축규정 맞춤형 체크리스트 등록
 */
function regLawChkLstFn(){
	location.href = "/admin/chkLstMgm/lawChkLstRegist.do";
}

/**
 * 한국건축규정 맞춤형 체크리스트 상세페이지 이동
 */
function detLawChkLstInfoFn(lawordSeqNo){
	 var 	form = $('<form></form>');
		    form.attr('action', "/admin/chkLstMgm/lawChkLstDetView.do");
		    form.attr('method', 'post');
		    form.appendTo('body');
		    form.append($('<input type="hidden" value="' + lawordSeqNo + '" name=lawordSeqNo>'));
		    form.submit();
}


/* pagination 페이지 링크 function */
function pageMoveFn(pageNo){
	$("#pageIndex").val(pageNo);
	$("#lawordLstForm").attr("action"	,		"/admin/chkLstMgm/lawChkLst.do");
	$("#lawordLstForm").submit();
}



</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
          
          <h3 class="sub-header">한국건축규정 체크리스트 관리   
          		<button 	onclick="regLawChkLstFn();"	type="button" class="btn btn-default"	style="float : right;">등록</button>
          </h3>
          
          <div class="table-responsive">
          	<form	id="lawordLstForm"	name="lawordLstForm"	method="post">
          	<input type="hidden"	id="pageIndex"		name="pageIndex"		value="${pageIndex}"		/>
            <table class="table table-hover">
            	<colgroup>
            		<col width="8%" />
            		<col width="10%" />
            		<col width="52%" />
            		<col width="20%" />
            		<col width="10%" />
            	</colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>법령구분</th>
                  <th>법령명</th>
                  <th>조문명</th>
                  <th>등록일</th>
                </tr>
              </thead>
              <tbody>
	           	<%
	           		for(int i=0 ; i < kppLawordMgmLst.size() ; i++){
	           			EgovMap kppLawordMgmInfo	=		(EgovMap)kppLawordMgmLst.get(i);
	           	%>
	           		<tr		onclick="detLawChkLstInfoFn('<%=kppLawordMgmInfo.get("lawordSeqNo") %>');"		style="cursor: pointer;">
	           			<td>
	           				<%=i+1 %>
	           			</td>
	           			
	           			<td>
	           				<%=(String)kppLawordMgmInfo.get("lawordTyNm") %>
	           			</td>
	           			
	           			<td>
	           				<%=(String)kppLawordMgmInfo.get("lawordNm") %>
	           			</td>
	           			
	           			<td>
	           				<%=(String)kppLawordMgmInfo.get("lawordLrgNm") %>
	           			</td>
	           			
	           			<td>
	           				<%=(String)kppLawordMgmInfo.get("firstCrtnDate") %>
	           			</td>
	           		</tr>	
	           	<%		
	           		}
	           	%>	
              </tbody>
            </table>
            
            <div id="paging">
        		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="pageMoveFn" />
        	</div>

	        </form>
	        	
          </div>
        </div>
      
</body>
</html>