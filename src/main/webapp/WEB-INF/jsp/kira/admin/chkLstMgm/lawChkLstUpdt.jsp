<%@page import="egovframework.rte.psl.dataaccess.util.EgovMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List commCdKR001Lst	=	null;
	if(request.getAttribute("commCdKR001Lst") != null){
		commCdKR001Lst	=	(List)request.getAttribute("commCdKR001Lst");
	}
	
	EgovMap kppLawordMgmInfo	=	new EgovMap();
	if(request.getAttribute("kppLawordMgmInfo") != null){
		kppLawordMgmInfo	=	(EgovMap)request.getAttribute("kppLawordMgmInfo");
	}
	
	//한국건축규정 맞춤형 체크리스트 상세항목 목록조회
	List kppLawordFixesChkLst	=	null;
	if(request.getAttribute("kppLawordFixesChkLst") != null){
		kppLawordFixesChkLst	=	(List)request.getAttribute("kppLawordFixesChkLst");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>한국건축규정 체크리스트 수정</title>

<script>

$( document ).ready(function() {
	//건축물용도
	$('#searchLawordBildPrpos').autocomplete({
        source : function(reuqest, response) {
            $.ajax({
                type : 'POST',
                url: '/admin/chkLstMgm/selectComCdAutoComplInfo.ajax',
                data:{
                	searchKeyword 	: 	$("#searchLawordBildPrpos").val(),
                	lgrpCd			:	"KR002"
		    	},
                dataType : 'json',
                success : function(data) {
                	
                	console.log(data);
                	data = JSON.parse(JSON.stringify(data.comCdAutoComplLst));
                	
                    // 서버에서 json 데이터 response 후 목록 추가
                    response(
                        $.map(data, function(item) {
                        	console.log(item);
                            return {
                            	sgrpCd : item.sgrpCd,
                                label : item.cdDesc,
                            }
                        })
                    );
                }
            });
        },
        select : function(event, ui) {
        	
        	var dupLawordBildPrposFlag = false;
        	
        	$("input[name='lawordBildPrpos']").each(function (i) {
        		if(ui.item.sgrpCd == $("input[name='lawordBildPrpos']").eq(i).attr("value")){
        			dupLawordBildPrposFlag = true;      			
        		}
           	});
        	
        	if(dupLawordBildPrposFlag){
        		alert("이미 등록된 건축물 용도 정보가 존재합니다.");	
        	}else{
        		var str 	= 	"";
				str		+=	"<span id='lawordBildPrpos_span_"+ui.item.sgrpCd+"'	class='label label-primary	chkLst-label'	>";
				str		+=	ui.item.label;
				str		+=	"<span 	onclick=\"removeLawordBildPrpos('"+ui.item.sgrpCd+"')\"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>";
				str		+=	"<input type='hidden'	name='lawordBildPrpos'	value='"+ui.item.sgrpCd+"'	/>";
				str		+=	"</span>";
			
				$("#lawordBildPrposLabel").append(str);
        	}
			
        },
        focus : function(event, ui) {
            return false;
        },
        minLength : 1,
        autoFocus : true,
        height	:	500,
        classes : {
            'ui-autocomplete': 'highlight'
        },
        delay : 100,
        position : { my : 'right top', at : 'right bottom' },
        close : function(event) {
            //console.log(event);
        	//검색필드 초기화
        	if(event.handleObj.type == "menuselect"){
        		$("#searchLawordBildPrpos").val("");	
        	}
        }
    });
	
	
	//지역
	$('#searchLawordArea').autocomplete({
        source : function(reuqest, response) {
            $.ajax({
                type : 'POST',
                url: '/admin/chkLstMgm/selectComCdAutoComplInfo.ajax',
                data:{
                	searchKeyword 	: 	$("#searchLawordArea").val(),
                	lgrpCd			:	"KR003"
		    	},
                dataType : 'json',
                success : function(data) {
                	
                	console.log(data);
                	data = JSON.parse(JSON.stringify(data.comCdAutoComplLst));
                	
                    // 서버에서 json 데이터 response 후 목록 추가
                    response(
                        $.map(data, function(item) {
                        	console.log(item);
                            return {
                            	sgrpCd : item.sgrpCd,
                                label : item.cdDesc,
                            }
                        })
                    );
                }
            });
        },
        select : function(event, ui) {
        	
        	var dupLawordAreaFlag = false;
        	
        	$("input[name='lawordArea']").each(function (i) {
        		if(ui.item.sgrpCd == $("input[name='lawordArea']").eq(i).attr("value")){
        			dupLawordAreaFlag = true;      			
        		}
           	});
        	
        	if(dupLawordAreaFlag){
        		alert("이미 등록된 지역 정보가 존재합니다.");	
        	}else{
        		var str 	= 	"";
				str		+=	"<span id='lawordArea_span_"+ui.item.sgrpCd+"'	class='label label-primary	chkLst-label'	>";
				str		+=	ui.item.label;
				str		+=	"<span 	onclick=\"removeLawordArea('"+ui.item.sgrpCd+"')\"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>";
				str		+=	"<input type='hidden'	name='lawordArea'	value='"+ui.item.sgrpCd+"'	/>";
				str		+=	"</span>";
			
				$("#lawordAreaLabel").append(str);
        	}
			
        },
        focus : function(event, ui) {
            return false;
        },
        minLength : 1,
        autoFocus : true,
        height	:	500,
        classes : {
            'ui-autocomplete': 'highlight'
        },
        delay : 100,
        position : { my : 'right top', at : 'right bottom' },
        close : function(event) {
            //console.log(event);
        	//검색필드 초기화
        	if(event.handleObj.type == "menuselect"){
        		$("#searchLawordArea").val("");	
        	}
        }
    });
	
	
	
	//지구
	$('#searchLawordDstrc').autocomplete({
        source : function(reuqest, response) {
            $.ajax({
                type : 'POST',
                url: '/admin/chkLstMgm/selectComCdAutoComplInfo.ajax',
                data:{
                	searchKeyword 	: 	$("#searchLawordDstrc").val(),
                	lgrpCd			:	"KR004"
		    	},
                dataType : 'json',
                success : function(data) {
                	
                	console.log(data);
                	data = JSON.parse(JSON.stringify(data.comCdAutoComplLst));
                	
                    // 서버에서 json 데이터 response 후 목록 추가
                    response(
                        $.map(data, function(item) {
                        	console.log(item);
                            return {
                            	sgrpCd : item.sgrpCd,
                                label : item.cdDesc,
                            }
                        })
                    );
                }
            });
        },
        select : function(event, ui) {
        	
        	var dupLawordDstrcFlag = false;
        	
        	$("input[name='lawordDstrc']").each(function (i) {
        		if(ui.item.sgrpCd == $("input[name='lawordDstrc']").eq(i).attr("value")){
        			dupLawordDstrcFlag = true;      			
        		}
           	});
        	
        	if(dupLawordDstrcFlag){
        		alert("이미 등록된 지구 정보가 존재합니다.");	
        	}else{
        		var str 	= 	"";
				str		+=	"<span id='lawordDstrc_span_"+ui.item.sgrpCd+"'	class='label label-primary	chkLst-label'	>";
				str		+=	ui.item.label;
				str		+=	"<span 	onclick=\"removeLawordDstrc('"+ui.item.sgrpCd+"')\"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>";
				str		+=	"<input type='hidden'	name='lawordDstrc'	value='"+ui.item.sgrpCd+"'	/>";
				str		+=	"</span>";
			
				$("#lawordDstrcLabel").append(str);
        	}
			
        },
        focus : function(event, ui) {
            return false;
        },
        minLength : 1,
        autoFocus : true,
        height	:	500,
        classes : {
            'ui-autocomplete': 'highlight'
        },
        delay : 100,
        position : { my : 'right top', at : 'right bottom' },
        close : function(event) {
            //console.log(event);
        	//검색필드 초기화
        	if(event.handleObj.type == "menuselect"){
        		$("#searchLawordDstrc").val("");	
        	}
        }
    });
	
	
	
	//구역
	$('#searchLawordZone').autocomplete({
        source : function(reuqest, response) {
            $.ajax({
                type : 'POST',
                url: '/admin/chkLstMgm/selectComCdAutoComplInfo.ajax',
                data:{
                	searchKeyword 	: 	$("#searchLawordZone").val(),
                	lgrpCd			:	"KR005"
		    	},
                dataType : 'json',
                success : function(data) {
                	
                	console.log(data);
                	data = JSON.parse(JSON.stringify(data.comCdAutoComplLst));
                	
                    // 서버에서 json 데이터 response 후 목록 추가
                    response(
                        $.map(data, function(item) {
                        	console.log(item);
                            return {
                            	sgrpCd : item.sgrpCd,
                                label : item.cdDesc,
                            }
                        })
                    );
                }
            });
        },
        select : function(event, ui) {
        	
        	var dupLawordZoneFlag = false;
        	
        	$("input[name='lawordZone']").each(function (i) {
        		if(ui.item.sgrpCd == $("input[name='lawordZone']").eq(i).attr("value")){
        			dupLawordZoneFlag = true;      			
        		}
           	});
        	
        	if(dupLawordZoneFlag){
        		alert("이미 등록된 구역 정보가 존재합니다.");	
        	}else{
        		var str 	= 	"";
				str		+=	"<span id='lawordZone_span_"+ui.item.sgrpCd+"'	class='label label-primary	chkLst-label'	>";
				str		+=	ui.item.label;
				str		+=	"<span 	onclick=\"removeLawordZone('"+ui.item.sgrpCd+"')\"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>";
				str		+=	"<input type='hidden'	name='lawordZone'	value='"+ui.item.sgrpCd+"'	/>";
				str		+=	"</span>";
			
				$("#lawordZoneLabel").append(str);
        	}
			
        },
        focus : function(event, ui) {
            return false;
        },
        minLength : 1,
        autoFocus : true,
        height	:	500,
        classes : {
            'ui-autocomplete': 'highlight'
        },
        delay : 100,
        position : { my : 'right top', at : 'right bottom' },
        close : function(event) {
            //console.log(event);
        	//검색필드 초기화
        	if(event.handleObj.type == "menuselect"){
        		$("#searchLawordZone").val("");	
        	}
        }
    });
});


/**
 * 건축물 용도 삭제처리
 */
function removeLawordBildPrpos(sgrpCd){
	$("#lawordBildPrpos_span_"+sgrpCd).remove();
}

/**
 * 지역 삭제처리
 */
function removeLawordArea(sgrpCd){
	$("#lawordArea_span_"+sgrpCd).remove();
}

/**
 * 지구 삭제처리
 */
function removeLawordDstrc(sgrpCd){
	$("#lawordDstrc_span_"+sgrpCd).remove();
}

/**
 * 구역 삭제처리
 */
function removeLawordZone(sgrpCd){
	$("#lawordZone_span_"+sgrpCd).remove();
}

/**
 * 한국건축규정 맞춤형 체크리스트 수정처리
 */
function updtKppLawordMgmExec(){
	if(validation()){
		$("#kppLawordMgmForm").attr("action", "/admin/chkLstMgm/lawChkLstUpdtExec.do");
		$("#kppLawordMgmForm").submit();	
	}else{
		return false;
	}
}

/**
 * 유효성 체크
 */
function validation(){
	
	//법령구분
	if($("#lawordTy").val() == null || $("#lawordTy").val() == ""){
		alert("법령구분을 선택해주시길 바랍니다.");
		return false;
	}
	
	
	//법령명
	if($("#lawordNm").val() == null || $("#lawordNm").val() == ""){
		alert("법령명을 입력해주시길 바랍니다.");
		return false;
	}
	
	
	//조문명
	if($("#lawordLrgNm").val() == null || $("#lawordLrgNm").val() == ""){
		alert("조문명을 입력해주시길 바랍니다.");
		return false;
	}
	
	//층수
	if($("#inputLawordFloor").val() != null && $("#inputLawordFloor").val() != ""){
		if($("#selectLawordFloorTy").val() == null || $("#selectLawordFloorTy").val() == "" ){
			alert("입력하신 층수의 이상/이하를 선택하여 주십시오.");
			return false;
		}
	}
	
	//연면적
	if($("#inputLawordTotar").val() != null && $("#inputLawordTotar").val() != ""){
		if($("#selectLawordTotarTy").val() == null || $("#selectLawordTotarTy").val() == "" ){
			alert("입력하신 연면적의 이상/이하를 선택하여 주십시오.");
			return false;
		}
	}
	
	return true;
} 


/**
 * 목록으로 이동 버튼 클릭시 발생이벤트
 */
function  backLawChkLstFn(){
	location.href	=	"/admin/chkLstMgm/lawChkLst.do";
}
</script>

</head>
<body>
	<div class="col-md-8 col-md-offset-2" style="padding-left : 40px; padding-right : 30px; margin-top: 80px;">
       	<h3 class="sub-header">한국건축규정 체크리스트 수정</h3>
		<form class="form-horizontal"		id="kppLawordMgmForm"		name="kppLawordMgmForm"		method="post"		onsubmit="return updtKppLawordMgmExec();"		>
			<input type="hidden"		id="lawordSeqNo"		name="lawordSeqNo"		value="<%=kppLawordMgmInfo.get("lawordSeqNo") %>"		/>
		  <div class="form-group">
		    <label for="lawordTy" class="col-sm-2 control-label">법령구분</label>
		    <div class="col-sm-10">
		    	<select		id="lawordTy"		name="lawordTy"		class="form-control"		required autofocus>
		    		<option	value="">-선택-</option>
		    		<%for(int i=0 ; i < commCdKR001Lst.size() ; i++){
		    			EgovMap commCdMgm = (EgovMap)commCdKR001Lst.get(i);
		    		%>
		    		<option	value="<%=(String)commCdMgm.get("sgrpCd")%>"	<%if( commCdMgm.get("sgrpCd").toString().equals( (String)kppLawordMgmInfo.get("lawordTy")) ){ %> selected="selected" <%} %>	><%=(String)commCdMgm.get("cdDesc")%></option>
		    		<%} %>
		    	</select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="lawordNm" class="col-sm-2 control-label">법령명</label>
		    <div class="col-sm-10">
		      <input type="text"  id="lawordNm" 	name="lawordNm"	class="form-control"		placeholder="법령명을 입력하세요"		value="<%=(String)kppLawordMgmInfo.get("lawordNm") %>"		required>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgNm" class="col-sm-2 control-label">조문명</label>
		    <div class="col-sm-10">
		      <input type="text"  id="lawordLrgNm" 	name="lawordLrgNm"	class="form-control"		placeholder="조문명을 입력하세요"		value="<%=(String)kppLawordMgmInfo.get("lawordLrgNm") %>"		required>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lawordLrgLinkPath" class="col-sm-2 control-label">조문링크명</label>
		    <div class="col-sm-10">
		      <input type="text"  id="lawordLrgLinkPath" 	name="lawordLrgLinkPath"	class="form-control"		placeholder="조문링크명을 입력하세요"		value="<%=(String)kppLawordMgmInfo.get("lawordLrgLinkPath") %>">
		    </div>
		  </div>
		 
		 
		 <div class="form-group">
		    <label for="" class="col-sm-2 control-label">
		    	건축물용도
		    </label>
		    <div class="col-sm-10">
		      <input type="text"  id="searchLawordBildPrpos" 	name="searchLawordBildPrpos"	class="form-control"		placeholder="건축물 용도를 검색하세요">
		    </div>
		    <!-- 건축물용도 조회 결과 영역 -->
		    <div id="lawordBildPrposLabel"	class="col-sm-offset-2 col-sm-10">
		    	
		    	<%if(kppLawordFixesChkLst != null && kppLawordFixesChkLst.size() > 0){
		    		for(int i=0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkInfo = (EgovMap)kppLawordFixesChkLst.get(i);
		    			//건축물 용도일 경우
		    			if("KR002".equals( (String)kppLawordFixesChkInfo.get("lawordFixesChklstTy") ) ){
		    	%>
				    	<span id='lawordBildPrpos_span_<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	class='label label-primary	chkLst-label'	>
				    		<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCdNm") %>
				    		<span 	onclick="removeLawordBildPrpos('<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>')"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>
				    		<input type='hidden'	name='lawordBildPrpos'	value='<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	/>
				    	</span>
		    	<%
		    			}
		    		}
		    	} 
		    	%>	
				
		    </div>
		     <!-- 건축물용도 조회 결과 영역 -->
		  </div>
		  
		  
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">
		    	지역
		    </label>
		    <div class="col-sm-10">
		      <input type="text"  id="searchLawordArea" 	name="searchLawordArea"	class="form-control"		placeholder="지역을 검색하세요">
		    </div>
		    
		    <!-- 지역 조회 결과 영역 -->
		    <div id="lawordAreaLabel"	class="col-sm-offset-2 col-sm-10">
		    	
		    	<%if(kppLawordFixesChkLst != null && kppLawordFixesChkLst.size() > 0){
		    		for(int i=0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkInfo = (EgovMap)kppLawordFixesChkLst.get(i);
		    			//지역일 경우
		    			if("KR003".equals( (String)kppLawordFixesChkInfo.get("lawordFixesChklstTy") ) ){
		    	%>
				    	<span id='lawordArea_span_<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	class='label label-primary	chkLst-label'	>
				    		<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCdNm") %>
				    		<span 	onclick="removeLawordArea('<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>')"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>
				    		<input type='hidden'	name='lawordArea'	value='<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	/>
				    	</span>
		    	<%
		    			}
		    		}
		    	} 
		    	%>	
		    	
		    </div>
		     <!-- 지역 조회 결과 영역 -->
		  </div>
		  
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">
		    	지구
		    </label>
		    <div 	class="col-sm-10">
		      <input type="text"  id="searchLawordDstrc" 	name="searchLawordDstrc"	class="form-control"		placeholder="지구를 검색하세요">
		    </div>
		    
		     <!-- 지역 조회 결과 영역 -->
		    <div id="lawordDstrcLabel"	class="col-sm-offset-2 col-sm-10">
		    	
		    	<%if(kppLawordFixesChkLst != null && kppLawordFixesChkLst.size() > 0){
		    		for(int i=0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkInfo = (EgovMap)kppLawordFixesChkLst.get(i);
		    			//지구일 경우
		    			if("KR004".equals( (String)kppLawordFixesChkInfo.get("lawordFixesChklstTy") ) ){
		    	%>
				    	<span id='lawordDstrc_span_<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	class='label label-primary	chkLst-label'	>
				    		<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCdNm") %>
				    		<span 	onclick="removeLawordDstrc('<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>')"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>
				    		<input type='hidden'	name='lawordDstrc'	value='<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	/>
				    	</span>
		    	<%
		    			}
		    		}
		    	} 
		    	%>	
		    
		    </div>
		     <!-- 지역 조회 결과 영역 -->
		  </div>
		  
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">
		    	구역
		    </label>
		    <div id=""	class="col-sm-10">
		      <input type="text"  id="searchLawordZone" 	name="searchLawordZone"	class="form-control"		placeholder="구역을 검색하세요">
		    </div>
		    
		     <!-- 구역 조회 결과 영역 -->
		    <div id="lawordZoneLabel"	class="col-sm-offset-2 col-sm-10">
		    	<%if(kppLawordFixesChkLst != null && kppLawordFixesChkLst.size() > 0){
		    		for(int i=0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkInfo = (EgovMap)kppLawordFixesChkLst.get(i);
		    			//구역일 경우
		    			if("KR005".equals( (String)kppLawordFixesChkInfo.get("lawordFixesChklstTy") ) ){
		    	%>
				    	<span id='lawordZone_span_<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	class='label label-primary	chkLst-label'	>
				    		<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCdNm") %>
				    		<span 	onclick="removeLawordZone('<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>')"	class='glyphicon glyphicon-remove label-remove-btn' aria-hidden='true'></span>
				    		<input type='hidden'	name='lawordZone'	value='<%=(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd") %>'	/>
				    	</span>
		    	<%
		    			}
		    		}
		    	} 
		    	%>	
		    </div>
		     <!-- 구역 조회 결과 영역 -->
		     
		  </div>
		  
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">
		    	층수
		    </label>
		    <div id=""	class="col-sm-10">
		    	<%
		    	String inputLawordFloor 		= 		"";
		    	String selectLawordFloorTy 		= 		"";	
		    	if(kppLawordFixesChkLst != null && kppLawordFixesChkLst.size() > 0){
		    		for(int i=0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkInfo = (EgovMap)kppLawordFixesChkLst.get(i);
		    			//층수일 경우
		    			if("KR006".equals( (String)kppLawordFixesChkInfo.get("lawordFixesChklstTy") ) ){
		    				inputLawordFloor	=	(String)kppLawordFixesChkInfo.get("lawordFixesChklstScope");
		    				selectLawordFloorTy	=	(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd");
		    			}
		    		}
		    	} 
		    	%>	
		    	
		      <input type="text"  id="inputLawordFloor" 	name="inputLawordFloor"	class="form-control"		value="<%=inputLawordFloor %>"	placeholder="층수를 입력하세요"	style="width: 50%; display: inline-block;">
		      <select	id="selectLawordFloorTy"	name="selectLawordFloorTy"	class="form-control"	style="width: 25%; display: inline-block;">
		      	<option		value=""		<%if( "".equals(selectLawordFloorTy) ){ %>	selected="selected"	<%} %>>-선택-</option>
		      	<option		value="00001"	<%if( "00001".equals(selectLawordFloorTy) ){ %>	selected="selected"	<%} %>>이상</option>
		      	<option		value="00002"	<%if( "00002".equals(selectLawordFloorTy) ){ %>	selected="selected"	<%} %>>이하</option>
		      </select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">
		    	연면적(㎡)
		    </label>
		    <div id=""	class="col-sm-10">
		    	<%
		    	String inputLawordTotar 		= 		"";
		    	String selectLawordTotarTy 		= 		"";	
		    	if(kppLawordFixesChkLst != null && kppLawordFixesChkLst.size() > 0){
		    		for(int i=0 ; i < kppLawordFixesChkLst.size() ; i++){
		    			EgovMap kppLawordFixesChkInfo = (EgovMap)kppLawordFixesChkLst.get(i);
		    			//연면적일 경우
		    			if("KR007".equals( (String)kppLawordFixesChkInfo.get("lawordFixesChklstTy") ) ){
		    				inputLawordTotar	=	(String)kppLawordFixesChkInfo.get("lawordFixesChklstScope");
		    				selectLawordTotarTy	=	(String)kppLawordFixesChkInfo.get("lawordFixesChklstCd");
		    			}
		    		}
		    	} 
		    	%>	
		    	
		      <input type="text"  id="inputLawordTotar" 	name="inputLawordTotar"	class="form-control"		value="<%=inputLawordTotar %>"	placeholder="연면적(㎡)을 입력하세요"		style="width: 50%; display: inline-block;">
		      <select	id="selectLawordTotarTy"	name="selectLawordTotarTy"	class="form-control"	style="width: 25%; display: inline-block;">
		      	<option		value=""		<%if( "".equals(selectLawordTotarTy) ){ %>	selected="selected"	<%} %>>-선택-</option>
		      	<option		value="00001"	<%if( "00001".equals(selectLawordTotarTy) ){ %>	selected="selected"	<%} %>>이상</option>
		      	<option		value="00002"	<%if( "00002".equals(selectLawordTotarTy) ){ %>	selected="selected"	<%} %>>이하</option>
		      </select>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-success">수정</button>
		      <button type="button" class="btn btn-default"		onclick="backLawChkLstFn();">뒤로</button>
		    </div>
		  </div>
		</form>          
    </div>
      
</body>
</html>