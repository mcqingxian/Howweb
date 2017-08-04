$(window).load(function() {
	checkCountDownPhoneJson();
	$("#entity\\.ebccMobile").blur(function(){ 
		checkMobile(true);
	});
	$("#entity\\.ebccNetPassword").blur(function(){ 
		checkPassword1();
	});
	$("#password2").blur(function(){ 
		checkPassword2();
	});
	$("#entity\\.ebccNetLogin").blur(function(){ 
		checkNetLogin(true);
	});
	$("#entity\\.ebccEmail").blur(function(){ 
		checkEmail(true);
	});
	$("#registVerCode").blur(function(){ 
		checkVerCode();
	});
	
	$("#entity\\.ebccMobile").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#entity\\.ebccNetPassword").focus();
	    }
	});
	$("#entity\\.ebccNetPassword").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#password2").focus();
	    }
	});
	$("#password2").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#entity\\.ebccNetLogin").focus();
	    }
	});
	$("#entity\\.ebccNetLogin").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#entity\\.ebccEmail").focus();
	    }
	});
	$("#entity\\.ebccEmail").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#registVerCode").focus();
	    }
	});
	$("#registVerCode").keypress(function(e){ 
		if (e.keyCode == 13){
			emailSaveAndLogin();
	    }
	});
});

$(document).ready(function(){
	$("#validateCode_regist").focus(function(){
		$("#validCode_msg").hide();
	});
});

function regist(){
	var mobile = checkMobile();
	if(!mobile){
		return;
	}
	var password1 = checkPassword1();
	if(!password1){
		return;
	}
	var password2 = checkPassword2();
	if(!password2){
		return;
	}
	var netLogin = checkNetLogin();
	if(!netLogin){
		return;
	}
	var email = checkEmail();
	if(!email){
		return;
	}
	var verCode = checkVerCode();
	if(!verCode){
		return;
	}
	var accept = $("#accept");
	if(accept.attr("checked") != "checked"){
		setErrorMsg("#regist_tips","请先阅读华宇网厅服务协议！");
		return;
	}
	var $netLogin = $("#entity\\.ebccNetLogin");
	if($netLogin.val() == $netLogin.attr("ov")){
		$netLogin.val("");
	}
	var $email = $("#entity\\.ebccEmail");
	if($email.val() == $email.attr("ov")){
		$email.val("");
	}
	
	$.post("registAction!registJson.action",{
		"entity.ebccMobile" : $("#entity\\.ebccMobile").val(),
		"entity.ebccNetPassword" : $("#entity\\.ebccNetPassword").val(),
		"entity.ebccNetLogin" : $("#entity\\.ebccNetLogin").val(),
		"entity.ebccEmail" : $("#entity\\.ebccEmail").val(),
		"registVerCode" : $("#registVerCode").val()
 		},
		function(data, status) {
 			if(data.errorType == "success"){
 				$(".tosnmiddle_btn.createOrder").attr("onclick","createOrder('success')");
 				$(".tosnmiddle_btn.saveDraft").attr("onclick","saveDraft('success')");
 				$("#noLoginDiv").hide();
 				var loginName = "";
 				if(data.entity.ebccContactName != null && data.entity.ebccContactName != ""){
 					loginName = data.entity.ebccContactName;
 				}else if(data.entity.ebccNetLogin != null && data.entity.ebccNetLogin != ""){
 					loginName = data.entity.ebccNetLogin;
 				}else if(data.entity.ebccMobile != null && data.entity.ebccMobile != ""){
 					loginName = data.entity.ebccMobile;
 				}
 				$(".login").html("欢迎您：<a href='personalDataAction!index.action'>"+loginName+"</a>");
 				$(".registOrExit").html("<a href='loginAction!exit.action'>退出</a>");
 				easyDialog.close();
 			}
			$("#login_tips").html(data.errorMsg); 
		}
	);
}

function checkMobile(check){
	var $mobile = $("#entity\\.ebccMobile");
	if($mobile.val()==$mobile.attr('ov')){
		setErrorMsg("#regist_tips","请输入手机号码！");
		return false;
	}
 	if(!isMobile($mobile.val())){
        setErrorMsg("#regist_tips","请输入正确手机号码！");
        return false; 
    }else{
		$("#regist_tips").html("<span class='icon_succ'></span>"); 
 	}
 	if(check){
	 	$.post("registAction!checkPhoneJson.action",{
			"entity.ebccMobile" : $mobile.val(),
			"total" : 1
	 		},
			function(data, status) {
				$("#regist_tips").html(data.errorMsg); 
			}
		);
 	}
 	return true;
}
function checkPassword1(){
	var pw1 = $("#entity\\.ebccNetPassword").val(); 
	if(pw1!=""){ 
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw1)){
			setErrorMsg("#regist_tips","密码必须为6-16个字符！");
            return false; 
        }else{
			$("#regist_tips").html("<span class='icon_succ'></span>");
      		return true;
     	}
	}else{
		setErrorMsg("#regist_tips","请输入密码！");
		return false; 	
	}
}
function checkPassword2(){
	var pw1 = $("#entity\\.ebccNetPassword").val(); 
	var pw2 = $("#password2").val();
 	if(pw2!=""){
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw2)){
			setErrorMsg("#regist_tips","密码必须为6-16个字符！");
            return false; 
        }else{
			if(pw1 == pw2) {
				$("#regist_tips").html("<span class='icon_succ'></span>");
				return true;
			}else {
				setErrorMsg("#regist_tips","确认密码和密码不一致！");
      			return false;
			}
     	} 
	}else{
		setErrorMsg("#regist_tips","请输入确认密码！");
		return false; 	
	}
}
function checkNetLogin(check){
	var $ebccNetLogin = $("#entity\\.ebccNetLogin");
	var loginName = "";
	if($ebccNetLogin.val()==$ebccNetLogin.attr('ov')){
		loginName = "";
		return true;
	}else{
		if($ebccNetLogin.val().length > 50){
			setErrorMsg("#regist_tips","用户名长度不能超过50位！");
			return false;
		}else{
			loginName = $ebccNetLogin.val();
		}
	}
	if(check){
	 	$.post("registAction!checkUserNameJson.action",{
			"entity.ebccNetLogin" : loginName,
			"total" : 1
	 		},
			function(data, status) {
				$("#regist_tips").html(data.errorMsg);
			}
		);
	}
	return true;
}
function checkEmail(check){
	var myemail=$("#entity\\.ebccEmail").val();
	var email = "";
	if($("#entity\\.ebccEmail").val()==$("#entity\\.ebccEmail").attr('ov')){
		email = "";
	}else{
		email = myemail;
	}
 	if(email!=""){
     	var reg =/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/; 
     	if(!reg.test(email)){
			setErrorMsg("#regist_tips","请输入正确的邮箱！");
            return false;
        }else{
        	if(email.length > 50){
        		setErrorMsg("#regist_tips","邮箱长度不能大于50位！");
                return false;
        	}else{
        		$("#regist_tips").html("<span class='icon_succ'></span>");
        	}
     	}
	}
 	if(check){
	 	$.post("registAction!checkEmailJson.action",{
			"entity.ebccEmail" : email,
			"total" : 1
	 		},
			function(data, status) {
				$("#regist_tips").html(data.errorMsg);
			}
		);
 	}
 	return true;
}
function checkVerCode(){
	var $registVerCode=$("#registVerCode");
	if($registVerCode.val() == $registVerCode.attr("ov")){
		setErrorMsg("#regist_tips","请输入验证码！");
        return false; 
	}else{
		return true;
	}
}
function checkCountDownPhoneJson(){
	$.post("registAction!checkCountDownPhoneJson.action",{
		},
		function(data, status) {
			countDownPhoneNum = data.countdown;
			if(countDownPhoneNum != null){
				phoneTimer = setInterval(phoneCountdown, "1000");
			}else{
				clearTimeout(phoneTimer);
				$("#getPhoneVerCodeBtn").val("获取验证码");
				$("#getPhoneVerCodeBtn").removeClass("btn_sub");
				$("#getPhoneVerCodeBtn").attr("disabled",false);
			}
		}
	);
}

/**
 * 发送短信验证码
 * @author 莫涛
 * @date 2015年7月17日
 * @update
 */
function sendPhoneVerCode(){
	var mobile = checkMobile();
	if(!mobile){
		return;
	}
	var password = checkPassword2();
	if(!password){
		return ;
	}
	checkValidate();
	
}

function checkValidate(){
	$("#validCode_msg").hide();
	$.ajaxSetup({
		async : false
	});
	$.get("registCodeCheck.action?registVerCode=" + $("#validateCode_regist").val(), function(data,
			status) {
		if (data.success == false) {
			setErrorMsg("#regist_tips","请输入正确验证码！");
			return false;
		} else {
			sendValidate();
		}
		$.ajaxSetup({
			async : true
		});
	});
}

function sendValidate(){
	/**
	 * 点击后，马上禁用按钮
	 */
	$("#getPhoneVerCodeBtn").attr("disabled","disabled");
	$("#getPhoneVerCodeBtn").addClass("btn_sub");
	var phone = $("#entity\\.ebccMobile").val();
	var validateCode_regist = $("#validateCode_regist").val();
	$.post("registAction!sendPhoneVerCodeJson.action",{
		"entity.ebccMobile" : phone,
		"registVerCode" : validateCode_regist,
		"total" : 1
		},
		function(data, status) {
			if(data.errorType == "phone"){
				$("#regist_tips").html(data.errorMsg);
			}else if(data.errorType == "verCodeError"){
				$("#getPhoneVerCodeBtn").removeClass("btn_sub");
				$("#getPhoneVerCodeBtn").attr("disabled",false);
				//刷新验证码
				changeCode();
				$("#validCode_msg").show();
			}else{
				$("#regist_tips").html(data.errorMsg);
				countDownPhoneNum = data.countdown;
				phoneTimer = setInterval(phoneCountdown, "1000");
			}
		}
	);
}

var countDownPhoneNum = 0;
var phoneTimer;
function phoneCountdown(){
	var name = "#getPhoneVerCodeBtn";
	if(countDownPhoneNum >= 0){
		$(name).attr("disabled","disabled");
		$(name).addClass("btn_sub");
		$(name).val("("+countDownPhoneNum+")秒后重发");
		countDownPhoneNum--;
	}else{
		$(name).val("获取验证码");
		$(name).removeClass("btn_sub");
		$(name).attr("disabled",false);
		$("#regist_tips").html("");
		clearTimeout(phoneTimer);
	}
}

//更改验证码
function changeCode(){  
	$("#validateCode_img").attr("src","genCheckCode.action?codeName=USER_REGIST_VERCODE&"+ new Date());
}

function setErrorMsg(id,msg){
	var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	$(id).html(rs);
}