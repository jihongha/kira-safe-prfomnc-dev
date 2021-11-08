<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List kppIntraMembLst	=	null;
	if(request.getAttribute("kppIntraMembLst") != null){
		kppIntraMembLst	=	(List)request.getAttribute("kppIntraMembLst");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한국건축규정 체크리스트 관리</title>

<script>
/**
 * 관리자 관리 상세페이지 이동처리
 */
function detKppIntraOpeMembFn(kppIntraOpeMembSeqNo){
	 var 	form = $('<form></form>');
		    form.attr('action', "/admin/sysMgm/kppIntraMembDetView.do");
		    form.attr('method', 'post');
		    form.appendTo('body');
		    form.append($('<input type="hidden" value="' + kppIntraOpeMembSeqNo + '" name=kppIntraOpeMembSeqNo>'));
		    form.submit();
}



/* pagination 페이지 링크 function */
function pageMoveFn(pageNo){
	$("#pageIndex").val(pageNo);
	$("#kppIntraMembLstForm").attr("action"	,		"/admin/sysMgm/kppIntraMembLst.do");
	$("#kppIntraMembLstForm").submit();
}


</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
          
          <h3 class="sub-header">관리자 관리</h3>
          
          <div class="table-responsive">
          	<form	id="kppIntraMembLstForm"	name="kppIntraMembLstForm"	method="post">
          	<input type="hidden"	id="pageIndex"		name="pageIndex"		value="${pageIndex}"		/>
            <table class="table table-hover">
            	<colgroup>
            		<col width="10%" />
            		<col width="20%" />
            		<col width="20%" />
            		<col width="20%" />
            		<col width="15%" />
            		<col width="15%" />
            	</colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>아이디</th>
                  <th>이름</th>
                  <th>부서</th>
                  <th>승인여부</th>
                  <th>가입일</th>
                </tr>
              </thead>
              <tbody>
              	<%
              		for(int i=0 ; i < kppIntraMembLst.size() ; i++){
              			EgovMap kppIntraMembInfo	=		(EgovMap)kppIntraMembLst.get(i);
              	%>
              		<tr		onclick="detKppIntraOpeMembFn('<%=kppIntraMembInfo.get("kppIntraOpeMembSeqNo") %>');"		style="cursor: pointer;">
              			<td>
              				<%=i+1 %>
              			</td>
              			
              			<td>
              				<%=(String)kppIntraMembInfo.get("kppMembId") %>
              			</td>
              			
              			<td>
              				<%=(String)kppIntraMembInfo.get("kppMembNm") %>
              			</td>
              			
              			<td>
              				<%=(String)kppIntraMembInfo.get("kppDeptNm") %>
              			</td>
              			
              			<td>
              				<%if("S".equals((String)kppIntraMembInfo.get("kppSbscrbConfmAt"))	){ %>
								<span class="label label-default">승인대기</span>
              				<%}else if("Y".equals((String)kppIntraMembInfo.get("kppSbscrbConfmAt"))	){ %>
								<span class="label label-success">승인완료</span>              				
              				<%}else{ %>
              					<span class="label label-danger">반려</span>
              				<%} %>
              			</td>
              			
              			<td>
              				<%=(String)kppIntraMembInfo.get("firstCrtnDate") %>
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