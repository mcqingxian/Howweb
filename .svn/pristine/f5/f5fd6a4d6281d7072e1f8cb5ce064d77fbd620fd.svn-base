$(document).ready(function(e) {
	// 获取验证码
	$("#getValidateCode").click(function() {
    	//1) 验证手机号是否正确
		//2) 发送短信
		var phone = $("#phoneNo").val();
		if(!validatePhone(phone)){
			$("#notice").text("请输入正确的手机号");
			return;
		}
		$("#notice").hide();
		//倒计时
		var time = 29;
		var interval = 0;
		$("#getValidateCode").attr("disabled","disabled");
		$("#getValidateCode").text(30+"秒后重试");
        interval = setInterval(function(){
			$("#getValidateCode").text(time+"秒后重试");
			time--;
			if(time == 0){
				clearTimeout(interval);
				$("#getValidateCode").text("获取验证码");
				$("#getValidateCode").removeAttr("disabled");
				time = 29;
			}	
		}, 1000);
		
		var url = "/wechat/getValiteCode.action?phone="+phone;
		$.get(url,function(data,status){
		  			    if(status == "success"){
//		  			    	alert(data);
		  			    }else{
		  			    }
	  			  });
    });
	
    //绑定手机号
    $("#changeBind").click(function(e) {
    	//1) 获取手机号码
    	var phoneNo = $("#phoneNo").val();
		if(!validatePhone(phoneNo)){
			$("#notice").text("请输入正确的新手机号");
			return;
		}
		
    	//2) 获取验证码
    	var validateCode = $("#validateCode").val();
    	if(!validateValiCode(validateCode)){
			$("#notice").text("请输入6位的验证码");
			return;
		}
		//3) 判断验证码是否为空
    	var url = "/wechat/changeBind.action?phone="+phoneNo+"&validateCode="+validateCode;
    	$("#changeBind").attr("disabled","disabled");
    	$.get(url,function(data,status){
			    if(status == "success"){
			    	if(data == "validateCode_error"){
			    		alert("验证码输入有误");
			    	}else{
			    		var url = "/wechat/bindSuccess.action?phone="+phoneNo;
  			    		window.location.href=url;
			    	}
			    }
			    $("#changeBind").removeAttr("disabled");
		});
    });

	function validatePhone(phone){
		var len = phone.length;
		if(len != 11){
			return false;
		}
		return true;
	}
	
	function validateValiCode(valiCode){
		var len = valiCode.length;
		if(len != 6){
			return false;
		}
		return true;
	}
});