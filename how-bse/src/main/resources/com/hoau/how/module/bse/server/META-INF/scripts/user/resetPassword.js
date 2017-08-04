$(window).load(function() {
	$("#oldPassword").blur(function(){ 
		checkOldPwd();
	});
	$("#newPassword").blur(function(){	
		checkNewPwd1();
	});
	$("#newPassword2").blur(function(){ 
		checkNewPwd2();
	});
	$("#oldPassword").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#newPassword").focus();
	    }
	});
	$("#newPassword").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#newPassword2").focus();
	    }
	});
	$("#newPassword2").keypress(function(e){ 
		if (e.keyCode == 13){
			updatePwd();
	    }
	});
});

function updatePwd(){
	if(!checkOldPwd()){
		return;
	}
	if(!checkNewPwd1()){
		return;
	}
	if(!checkNewPwd2()){
		return;
	}
	$("#repwdForm").submit();
}

function checkOldPwd(){
	var pw1 = $("#oldPassword").val(); 
 	if(pw1!=""){ 
 		$("#oldpwd_tips").show();
		$("#oldpwd_tips").html("<span class='icon_succ'></span>");
		return true;
	}else{
		$("#oldpwd_tips").show();
		setErrorMsg("#oldpwd_tips","请输入原始密码！");
		return false; 	
	}
}

function checkNewPwd1(){  //验证密码 
	var pw1 = $("#newPassword").val(); 
 	if(pw1!=""){
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw1)){
			$("#newpwd_tips").show();
			setErrorMsg("#newpwd_tips","新密码长度应在6-16位！");
            return false; 
        }else{
			$("#newpwd_tips").show();
			$("#newpwd_tips").html("<span class='icon_succ'></span>");
      		return true; 
     	} 
	}else{
		$("#newpwd_tips").show();
		setErrorMsg("#newpwd_tips","请输入新密码！");
		return false; 	
	}
}

function checkNewPwd2(){  //验证密码
	var pw1 = $("#newPassword").val(); 
	var pw2 = $("#newPassword2").val(); 	
 	if(pw2!=""){
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw2)){
			$("#newpwd2_tips").show();
			setErrorMsg("#newpwd2_tips","密码必须为6-16个字符！");
            return false; 
        }else{
			if(pw1 == pw2) {
				$("#newpwd2_tips").show();
				$("#newpwd2_tips").html("<span class='icon_succ'></span>");
				return true;
			}else {
				$("#newpwd2_tips").show();
				setErrorMsg("#newpwd2_tips","确认密码和密码不一致！");
      			return false;
			}
     	} 
	}else{
		$("#newpwd2_tips").show();
		setErrorMsg("#newpwd2_tips","请输入确认密码！");
		return false; 	
	}
}

function setErrorMsg(id,msg){
	var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	$(id).html(rs);
}