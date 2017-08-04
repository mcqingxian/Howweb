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
		//请求发送验证码
        $.post("registAction!sendPhoneVerCodeJson.action",{
	    		"entity.ebccMobile" : phone,
	    		"total" : 1
    		},
    		function(data, status) {
    			if (data.errorMsg != '' && data.errorMsg != null && data.errorMsg.length != 0) {
    	    		checkParams(data.errorMsg);
    	    	} else {
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
			checkParams("请输入6位的验证码");
			return;
		}
    	$("#confirmBinding").attr("disabled","disabled");
    	var url = "personalDataAction!modifyPhone.action";
    	$.post(url,{
    		"entity.ebccMobile" : phone,
    		"phoneVerCode" : validateCode
		},
		function(data, status) {
			if (data.errorMsg != null) {
	    		checkParams(data.errorMsg);
	    	} else {
	    		window.location.href='myHoau.action';
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
	$("#mbile_binding_header").html();
	$("#mbile_binding_dialog_con").empty();
	$("#mbile_binding_dialog_con").append("<h>"+msg+"</h>");
	$.mobile.changePage('#mbile_binding_dialog', 'flip', true, true);
}