$(window).load(function() {
	$("#phone").blur(function(){ 
		checktelephone();
	});
	$("#phone").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#phoneCode").focus();
	    }
	});
	$("#email").blur(function(){ 
		checkemail();
	});
	$("#email").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#emailCode").focus();
	    }
	});
	$("#phoneCode").keypress(function (e) {
	    if (e.keyCode == 13){
	    	phoneNext();
	    }
	});
	$("#emailCode").keypress(function (e) {
	    if (e.keyCode == 13){
	    	emailNext();
	    }
	});
});
//手机填写完验证码后的下一步
function phoneNext(){
	var phone = $("#phone").val(); //获取手机号
	var phoneCode = $("#phoneCode").val();	//获取用户输入的验证码
	//手机号是否为空，验证码
	var bool = checktelephone();
	//手机号码通过验证
	if(bool == true){
		if(phoneCode == ""){
			$("#phone_code_tips").html("<p class='erro'><span class='icon_del'></span>请输入验证码！</p>");
		}else{
			$("#phoneForm").submit();
		}
	}
}
//邮箱填写完验证码后的下一步
function emailNext(){
	var email = $("#email").val(); //获取邮箱地址
	var emailCode = $("#emailCode").val();
	var bool = checkemail();
    if(bool == true){
    	if(emailCode == ""){
    		$("#email_code_tips").html("<p class='erro'><span class='icon_del'></span>请输入验证码！</p>");
    	}else{
    		$("#emailForm").submit();
    	}
    }
}

function checktelephone(){  //检查电话号码
	var mytelephone = $("#phone").val();
	if($("#phone").val()==$("#phone").attr('ov')){
		$("#phone_tips").html("<p class='erro'><span class='icon_del'></span>请输入手机号码！</p>");
		return false;
	}if(mytelephone!=""){
     	if(!isMobile(mytelephone)){
            $("#phone_tips").html("<p class='erro'><span class='icon_del'></span>请输入正确手机号码！</p>");
            return false; 
        }else{
			$("#phone_tips").html("<span class='icon_succ'></span>"); 
      		return true; 
     	}
	}
}
function checkemail(){  //检查电话号码 
	var myemail=$("#email").val(); 
	if($("#email").val()==$("#email").attr('ov')){
		$("#email_tips").html("<p class='erro'><span class='icon_del'></span>请输入邮箱！</p>");
		return false;
	}
 	if(myemail!="") 
 	{ 
     	var reg =/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/; 
     	if(!reg.test(myemail)){
			$("#email_tips").html("<p class='erro'><span class='icon_del'></span>请输入正确的邮箱！</p>");
            return false; 
        }else{
			$("#email_tips").html("<span class='icon_succ'></span>");
      		return true;
     	} 
	}
}