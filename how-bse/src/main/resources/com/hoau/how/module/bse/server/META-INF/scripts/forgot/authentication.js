function initData(type){
	if("phone" == type){
		checkCountDownPhoneJson();
	}else if("email" == type){
		checkCountDownEmailJson();
	}else{
		clearTimeout(phoneTimer);
		$("#getPhoneVerCodeBtn").val("获取验证码");
		$("#getPhoneVerCodeBtn").removeClass("btn_sub");
		$("#getPhoneVerCodeBtn").attr("disabled",false);
		
		clearTimeout(emailTimer);
		$("#getEmailVerCodeBtn").val("获取验证码");
		$("#getEmailVerCodeBtn").removeClass("btn_sub");
		$("#getEmailVerCodeBtn").attr("disabled",false);
	}
}

function checkCountDownPhoneJson(){
	$.post("forgotAction!checkCountDownPhoneJson.action",{
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
	/**
	 * 点击后，马上禁用按钮
	 */
	$("#getPhoneVerCodeBtn").attr("disabled","disabled");
	$("#getPhoneVerCodeBtn").addClass("btn_sub");
	var phone = $("#phone").val();
	$.post("forgotAction!sendPhoneVerCodeJson.action",{
		"phone" : phone
		},
		function(data, status) {
			countDownPhoneNum = data.countdown;
			timer = setInterval(phoneCountdown, "1000");
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
		clearTimeout(phoneTimer);
	}
}

function phoneNext(){
	var phone = $("#phone").val();
	var phoneCode = $("#phoneCode").val();
	if(phone == null || phone == ""){
		$("#phone_tips").html("<p class='erro'><span class='icon_del'></span>手机号码为空！</p>");
		return;
	}else if(!isMobile(phone)){
		$("#phone_tips").html("<p class='erro'><span class='icon_del'></span>请输入正确手机号码！</p>");
		return;
	}else if(phoneCode == null || phoneCode == ""){
		$("#phone_code_tips").html("<p class='erro'><span class='icon_del'></span>验证码不能为空！</p>");
		return;
	}else{
		$("#phoneNextForm").submit();
	}
}


var countDownEmailNum = 0;
var emailTimer;
function checkCountDownEmailJson(){
	$.post("forgotAction!checkCountDownEmailJson.action",{
		},
		function(data, status) {
			countDownEmailNum = data.countdown;
			if(countDownEmailNum != null){
				emailTimer = setInterval(emailCountdown, "1000");
			}else{
				clearTimeout(emailTimer);
				$("#getEmailVerCodeBtn").val("获取验证码");
				$("#getEmailVerCodeBtn").removeClass("btn_sub");
				$("#getEmailVerCodeBtn").attr("disabled",false);
			}
		}
	);
}

/**
 * 发送邮箱验证码
 * @author 莫涛
 * @date 2015年7月17日
 * @update
 */
function sendEmailVerCode(){
	/**
	 * 点击后，马上禁用按钮
	 */
	$("#getEmailVerCodeBtn").attr("disabled","disabled");
	$("#getEmailVerCodeBtn").addClass("btn_sub");
	var email = $("#email").val();
	$.post("forgotAction!sendEmailVerCodeJson.action",{
		"email" : email
		},
		function(data, status) {
			countDownEmailNum = data.countdown;
			timer = setInterval(emailCountdown, "1000");
		}
	);
}
var countDownEmailNum = 0;
var emailTimer;
function emailCountdown(){
	var name = "#getEmailVerCodeBtn";
	if(countDownEmailNum >= 0){
		$(name).attr("disabled","disabled");
		$(name).addClass("btn_sub");
		$(name).val("("+countDownEmailNum+")秒后重发");
		countDownEmailNum--;
	}else{
		$(name).val("获取验证码");
		$(name).removeClass("btn_sub");
		$(name).attr("disabled",false);
		clearTimeout(emailTimer);
	}
}

function emailNext(){
	var email = $("#email").val();
	var emailCode = $("#emailCode").val();
	var reg =/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/; 
	if(email == null || email == ""){
		$("#email_tips").html("<p class='erro'><span class='icon_del'></span>邮箱地址为空！</p>");
		return;
	}else if(!reg.test(email)){
		$("#email_tips").html("<p class='erro'><span class='icon_del'></span>请输入正确的邮箱！</p>");
        return; 
	}else if(phoneCode == null || phoneCode == ""){
		$("#email_code_tips").html("<p class='erro'><span class='icon_del'></span>验证码不能为空！</p>");
		return;
	}else{
		$("#emailNextForm").submit();
	}
}