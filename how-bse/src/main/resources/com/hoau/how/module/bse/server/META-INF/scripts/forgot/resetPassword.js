$(window).load(function() {
	$("#phone_pw1").blur(function(){ 
		checkphonepwd();
	});
	$("#phonePassword").blur(function(){	
		checkphonepwd02();
	});
	$("#mail_pw1").blur(function(){ 
		checkmailpwd();
	});
	$("#emailPassword").blur(function(){	
		checkmailpwd02();
	});
	$("#phone_pw1").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#phonePassword").focus();
	    }
	});
	$("#phonePassword").keypress(function(e){ 
		if (e.keyCode == 13){
			phoneSaveAndLogin();
	    }
	});
	$("#mail_pw1").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#emailPassword").focus();
	    }
	});
	$("#emailPassword").keypress(function(e){ 
		if (e.keyCode == 13){
			emailSaveAndLogin();
	    }
	});
});

function phoneSaveAndLogin(){
	var checkedPwd1 = checkphonepwd();
	if(checkedPwd1 == false){
		return;
	}
	var checkedPwd2 = checkphonepwd02();
	//验证成功，则提交并且修改密码
	if(checkedPwd2 == true){
		$("#phonePwdForm").submit();
	}
}

function emailSaveAndLogin(){
	var checkedPwd1 = checkmailpwd();
	if(checkedPwd1 == false){
		return;
	}
	var checkedPwd2 = checkmailpwd02();
	//验证成功，则提交并且修改密码
	if(checkedPwd2 == true){
		$("#emailPwdForm").submit();
	}
}

function checkphonepwd(){  //验证密码 
	var pw1 = $("#phone_pw1").val(); 
 	if(pw1!=""){
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw1)){
			$("#user_pw1_tips").show();
			$("#user_pw1_tips").html("<p class='erro'><span class='icon_del'></span>请输入6位以上密码</p>");
            return false; 
        }else{
			$("#user_pw1_tips").show();
			$("#user_pw1_tips").html("<span class='icon_succ'></span>");
      		return true; 
     	} 
	}else{
		$("#user_pw1_tips").show();
		$("#user_pw1_tips").html("<p class='erro'><span class='icon_del'></span>请输入密码</p>");
		return false; 	
	}
}
function checkphonepwd02(){  //验证密码
	var pw1 = $("#phone_pw1").val(); 
	var pw2 = $("#phonePassword").val(); 	
 	if(pw2!=""){
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw2)){
			$("#user_pw2_tips").show();
			$("#user_pw2_tips").html("<p class='erro'><span class='icon_del'></span>确认密码和密码不一致</p>");
            return false; 
        }else{
			if(pw1 == pw2) {
				$("#user_pw2_tips").show();
				$("#user_pw2_tips").html("<span class='icon_succ'></span>");
				return true;
			}else{
				$("#user_pw2_tips").show();
				$("#user_pw2_tips").html("<p class='erro'><span class='icon_del'></span>确认密码和密码不一致</p>");
      			return false;
			}
     	} 
	}else{
		$("#user_pw2_tips").show();
		$("#user_pw2_tips").html("<p class='erro'><span class='icon_del'></span>请输入确认密码</p>");
		return false; 	
	}
}

function checkmailpwd(){  //验证密码 
	var pw1 = $("#mail_pw1").val(); 
 	if(pw1!=""){ 
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw1)){
			$("#mail_pw1_tips").show();
			$("#mail_pw1_tips").html("<p class='erro'><span class='icon_del'></span>密码必须为6-16个字符</p>");
            return false; 
        }else{
			$("#mail_pw1_tips").show();
			$("#mail_pw1_tips").html("<span class='icon_succ'></span>");
      		return true; 
     	} 
	}else{
		$("#mail_pw1_tips").show();
		$("#mail_pw1_tips").html("<p class='erro'><span class='icon_del'></span>请输入密码</p>");
		return false; 	
	}
}
function checkmailpwd02(){  //验证密码
	var pw1 = $("#mail_pw1").val(); 
	var pw2 = $("#emailPassword").val(); 	
 	if(pw2!=""){
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw2)){
			$("#mail_pw2_tips").show();
			$("#mail_pw2_tips").html("<p class='erro'><span class='icon_del'></span>密码必须为6-16个字符</p>");
            return false; 
        }else{
			if(pw1 == pw2) {
				$("#mail_pw2_tips").show();
				$("#mail_pw2_tips").html("<span class='icon_succ'></span>");
				return true;
			}else {
				$("#mail_pw2_tips").show();
				$("#mail_pw2_tips").html("<p class='erro'><span class='icon_del'></span>确认密码和密码不一致</p>");
      			return false;
			}
			 
     	} 
	}else{
		$("#mail_pw2_tips").show();
		$("#mail_pw2_tips").html("<p class='erro'><span class='icon_del'></span>请输入确认密码</p>");
		return false; 	
	}
}