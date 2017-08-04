$(document).ready(function(e) {
	// 获取验证码
	$("#getValidateCode").click(function() {
    	//1) 验证手机号是否正确
		//2) 发送短信
		var phone = $("#phoneNo").val();
		if(!validatePhone(phone)){
			checkParams("请输入正确的手机号");
			return;
		}
		var validateCode = $("#validateCode_regist").val()
		if(validateCode == ''){
			//刷新验证码
			changeCode();
			checkParams("请输入验证码");
			return;
		}
		checkValidate(phone)
    });
	
    //绑定手机号
    $("#confirmBinding").click(function(e) {
    	//1) 获取手机号码
    	var phone = $("#phoneNo").val();
		if(!validatePhone(phone)){
			checkParams("请输入正确的手机号");
			return;
		}
    	//2) 获取验证码
    	var validateCode = $("#validateCode").val();
    	//3) 判断验证码是否为空
    	if(!validateValiCode(validateCode)){
			checkParams("请输入6位的短信验证码");
			return;
		}
    	// 判断密码
    	if(!checkPassword1()){
    		return;
    	}
    	$("#confirmBinding").attr("disabled","disabled");
    	var ebccNetPassword = $("#password").val(); 
    	var url = "forgotAction!modifyUserPwdByPhone.action";
    	var ebccId = $("#userid").val();
    	$.post(url,{
    		"phone" : phone,
    		"phonePassword" : ebccNetPassword,
    		"phoneCode" : validateCode,
    		"ebccId" : ebccId
		},
		function(data, status) {
			if(data.errorMsg && data.errorMsg == '修改成功！'){
				window.location.href='index.action';
			} else if (data.errorMsg != null) {
	    		checkParams(data.errorMsg);
	    	}
		    $("#confirmBinding").removeAttr("disabled");
		}
	);
    });

    // 进入下单界面
	$("#placeOrder").click(function(e) {
		var url = "/wechat/order.action";
		window.location.href = url;
	});
	
	
	function validatePhone(phone){
		/*/^(13[0-9]|15[0-9]|15[0-9]|18[0-8])[0-9]{8}$/;*/
		 var reg =/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/; 
	        var check=false;
	        if (reg.test(phone))
	        	check=true;
	        return check;
	}
	
	function validateValiCode(valiCode){
		var len = valiCode.length;
		if(len != 6){
			return false;
		}
		return true;
	}
});

function checkParams(msg){
	$("#retrievePhone_header").html();
	$("#retrievePhone_dialog_con").empty();
	$("#retrievePhone_dialog_con").append("<h>"+msg+"</h>");
	$.mobile.changePage('#retrievePhone_dialog', 'flip', true, true);
}

function checkPassword1(){
	var pw1 = $("#password").val(); 
	if(pw1!=""){ 
     	var pwd=/^(?=.{6,16}$)/;
     	if(!pwd.test(pw1)){
     		checkParams("密码必须为6-16个字符！");
            return false; 
        }else{
      		return true;
     	}
	}else{
		checkParams("请输入密码！");
		return false; 	
	}
}

function checkValidate(phone){
	//请求发送验证码
    $.post("forgotAction!sendNewPhoneVerCodeJson.action",{
    		"phone" : phone,
    		"registVerCode" : $("#validateCode_regist").val()
		},
		function(data, status) {
			if (data.errorMsg != '' && data.errorMsg != null && data.errorMsg.length != 0) {
				//刷新验证码
				changeCode();
	    		checkParams(data.errorMsg);
	    	} else {
	    		//刷新验证码
	    		$("#validateCode_regist").val(null);
				changeCode();
	    		$("#userid").attr("value", data.ebccId);
	    		//倒计时
	    		var time = 60;
	    		var interval = 0;
	    		$("#getValidateCode").attr("disabled","disabled");
	    		$("#getValidateCode").text(60+"秒后重试");
	            interval = setInterval(function(){
	    			$("#getValidateCode").text(time+"秒后重试");
	    			time--;
	    			if(time == 0){
	    				clearTimeout(interval);
	    				$("#getValidateCode").text("获取验证码");
	    				$("#getValidateCode").removeAttr("disabled");
	    				time = 60;
	    			}	
	    		}, 1000);
	    	}
		}
	);
}

//更改验证码
function changeCode(){  
	$("#validateCode_img").attr("src",system_bse_url + "genCheckCode.action?codeName=PHONE_VERCODE&"+ new Date());
}