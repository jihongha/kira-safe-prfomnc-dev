<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>

<script>
/**
 * 회원가입 버튼 클릭시 발생이벤트
 */
function regKppMembFn(){
	location.href="/admin/login/join.do";
}

/**
 * 회원가입 시 아이디 유효성 체크
 */
function dupKppMembIdChk(obj){
	
	if(obj.value.length <= 0){
		$("#dupKppMembIdTxt").html("");
		$("#dupKppMembIdVal").val("");
	}else{
		$.ajax({
		    url:"/admin/login/dupKppMembIdChk.ajax",
		    data:{
		    		kppMembId 	: obj.value,
		    	},
		    type:'POST',
		    success: function(data){
		    	 
		    	var str = "";
		    	
		    	if(data.dupKppMembIdChkAt == "Y"){
		    		str += "<span class='dup-memb-id'>";
		    		str += "등록된 아이디가 존재합니다.";
		    		str += "</span>";
		    		
		    		$("#dupKppMembIdVal").val("Y");
		    	}else{
		    		str = "<span class='diff-memb-id'>";
		    		str += "등록가능한 아이디입니다.";
		    		str += "</span>";
		    		
		    		$("#dupKppMembIdVal").val("N");
		    	}
		    	
		    	$("#dupKppMembIdTxt").html(str);
		    } 
			
		    ,complete:function(){
		    }
		    ,error:function(e){
		    	alert("오류가 발생하였습니다.");
		    	
		    }
		});
	}
	
	
}

/**
 * 회원가입 버튼 클릭시 발생이벤트
 */
function regKppMembExecFn(){
	
	if(validation()){
		$.ajax({
		    url:"/admin/login/joinExec.ajax",
		    data:{
		    		kppMembId 	: $("#kppMembId").val(),
		    		kppMembPwd 	: $("#kppMembPwd").val(),
		    		kppMembNm 	: $("#kppMembNm").val(),
		    		kppDeptNm 	: $("#kppDeptNm").val()
		    	},
		    type:'POST',
		    success: function(data){
		    	
		    	if(data.joinSuccAt == "Y"){
		    		alert("회원가입신청이 정상적으로 처리되었습니다.\n가입승인대기 이후 정상로그인 가능합니다.");
		    		location.href="/admin/login/operator.do";
		    	}
		    } 
			
		    ,complete:function(){
		    }
		    ,error:function(e){
		    	alert("오류가 발생하였습니다.");
		    	
		    }
		});
	}else{
		return false;
	}
	 
}


/**
 * 유효성 체크
 */
function validation(){
	var kppMembId 			=  		$("#kppMembId").val();
	var kppMembPwd 			= 		$("#kppMembPwd").val();
	var kppMembPwdChk 		= 		$("#kppMembPwdChk").val();
	var kppMembNm 			= 		$("#kppMembNm").val();
	var kppDeptNm			=		$("#kppDeptNm").val();
	var dupKppMembIdVal		=		$("#dupKppMembIdVal").val();
	
	
	
	if(	 kppMembId == null 	||	kppMembId == ""  ){
		alert("아이디를 입력하세요.");
		$("#kppMembId").focus();
		return false;
	} 
	
	if(	 dupKppMembIdVal == "Y" ){
		alert("등록된 아이디가 존재합니다.");
		$("#kppMembId").focus();
		return false;
	}
	
	
	if(	 kppMembPwd == null 	||	kppMembPwd == ""  ){
		alert("비밀번호를 입력하세요.");
		$("#kppMembPwd").focus();
		return false;
	}
	
	
	if(	 kppMembPwdChk == null 	||	kppMembPwdChk == ""  ){
		alert("비밀번호 확인을 입력하세요.");
		$("#kppMembPwdChk").focus();
		return false;
	}
	
	
	if(	 kppMembPwd != kppMembPwdChk  ){
		alert("입력한 비밀번호가 일치하지 않습니다.");
		$("#kppMembPwdChk").focus();
		return false;
	}
	
	if(	  kppMembNm == null 	||	kppMembNm == ""  ){
		alert("이름을 입력하세요.");
		$("#kppMembNm").focus();
		return false;
	}
	
	return true;
	
}



</script>

</head>
<body>
	<div class="col-md-4 col-md-offset-4"	style="margin-top : 10%;">
        <form 	id="kppJoinForm"		name="kppJoinForm"		class="form-signin"	method="post"	onsubmit="return regKppMembExecFn();">
        	<input type="hidden"		id="dupKppMembIdVal"		name="dupKppMembIdVal"			value=""/>
        	
	        <h2 class="form-signin-heading">
	        	관리자 회원가입
	        </h2>
	        <label for="kppMembId" class="sr-only">kppMembId</label>
	        <input type="text" id="kppMembId" 		name="kppMembId"	class="form-control" placeholder="아이디를 입력하세요" 	onkeyup="dupKppMembIdChk(this);"		required autofocus	>
	        <p id="dupKppMembIdTxt"></p>
	        
	        <div style="margin-top: 15px;"></div>
	        
	        <label for="kppMembPwd" class="sr-only">kppMembPwd</label>
	        <input type="password" id="kppMembPwd"	name="kppMembPwd" 	class="form-control" placeholder="비밀번호를 입력하세요" required>
	        
	        <div style="margin-top: 15px;"></div>
	        
	        
	        <label for="kppMembPwdChk" class="sr-only">kppMembPwdChk</label>
	        <input type="password" id="kppMembPwdChk"	name="kppMembPwdChk" 	class="form-control" placeholder="동일한 비밀번호를 입력하세요" required>
	        
	        <div style="margin-top: 15px;"></div>
	        
	        <label for="kppMembNm" class="sr-only">kppMembNm</label>
	        <input type="text" id="kppMembNm" 		name="kppMembNm"	class="form-control" placeholder="이름을 입력하세요" required>
	        
	        <div style="margin-top: 15px;"></div>
	        
	        <label for="kppDeptNm" class="sr-only">kppDeptNm</label>
	        <input type="text" id="kppDeptNm" 		name="kppDeptNm"	class="form-control" placeholder="부서명을 입력하세요" >
	        
	        <div style="margin-top: 15px;"></div>
	        
	        <button class="btn btn-lg btn-warning btn-block" type="submit" 	>가입</button>
      	</form>  
    </div>
</body>
</html>