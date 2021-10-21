<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>

<script>
/**
 * 로그인 버튼 클릭시 발생이벤트
 */
function loginExecFn(){
	var kppMembId 		=  		$("#kppMembId").val();
	var kppMembPwd 		= 		$("#kppMembPwd").val();
	
	if(	 (kppMembId != null 	&& 		kppMembId != "") && 
		 (kppMembPwd != null 	&& 		kppMembPwd != "") 	){
		
			$.ajax({
			    url:"/admin/login/operatorExec.ajax",
			    data:{
			    		kppMembId 	: $("#kppMembId").val(),
			    		kppMembPwd 	: $("#kppMembPwd").val()
			    	},
			    type:'POST',
			    success: function(data){
			    	
			    } 
				
			    ,complete:function(){
			    }
			    ,error:function(e){
			    	alert("오류가 발생하였습니다.");
			    	
			    }
			});

	}
}



</script>

</head>
<body>
	<div class="col-md-6 col-md-offset-3">
        <form 	id="kppLoginForm"		name="kppLoginForm"		class="form-signin"	method="post"	onsubmit="loginExecFn();">
	        <h2 class="form-signin-heading">관리자 로그인</h2>
	        <label for="kppMembId" class="sr-only">kppMembId</label>
	        <input type="text" id="kppMembId" 		name="kppMembId"	class="form-control" placeholder="아이디를 입력하세요" required autofocus>
	        
	        <div style="margin-top: 15px;"></div>
	        
	        <label for="kppMembPwd" class="sr-only">kppMembPwd</label>
	        <input type="password" id="kppMembPwd"	name="kppMembPwd" 	class="form-control" placeholder="비밀번호를 입력하세요" required>
	        
	        <div style="margin-top: 15px;"></div>
	        
	        <button class="btn btn-lg btn-primary btn-block" type="submit" 	>로그인</button>
      	</form>  
    </div>
</body>
</html>