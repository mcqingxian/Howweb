$(window).load(function() {
	checkCountDownPhoneJson();
	$("#entity\\.ebccMobile").blur(function(){ 
		checkMobile(true);
	});
	$("#entity\\.ebccNetLogin").blur(function(){ 
		checkNetLogin(true);
	});
	$("#entity\\.ebccEmail").blur(function(){ 
		checkEmail(true);
	});
	$("#entity\\.ebccContactName").blur(function(){ 
		checkContactName();
	});
	$("#entity\\.ebccSex").blur(function(){ 
		checkSex();
	});
	$("#entity\\.ebccCompany").blur(function(){ 
		checkCompany();
	});
	$("#entity\\.ebccTel").blur(function(){ 
		checkTel();
	});
	$("#entity\\.ebccDistrict").blur(function(){ 
		checkDistrict();
	});
	$("#entity\\.ebccAddress").blur(function(){ 
		checkAddress();
	});
	$("#entity\\.ebccRemark").blur(function(){ 
		checkRemark();
	});
});

function saveInfo(){
	if(!checkNetLogin()){
		return;
	}
	if(!checkContactName()){
		return;
	}
	if(!checkSex()){
		return;
	}
	if(!checkCompany()){
		return;
	}
	if(!checkTel()){
		return;
	}
	if(!checkMobile()){
		return;
	}
	if(!checkEmail()){
		return;
	}
	if(!checkDistrict()){
		return;
	}
	if(!checkAddress()){
		return;
	}
	if(!checkRemark()){
		return;
	}
	var $tel = $("#entity\\.ebccTel");
	if($tel.val()==$tel.attr('ov')){
		$tel.val("");
	}
	var $company = $("#entity\\.ebccCompany");
	if($company.val()==$company.attr('ov')){
		$company.val("");
	}
	var $remark = $("#entity\\.ebccRemark");
	if($remark.val()==$remark.attr('ov')){
		$remark.val("");
	}
	$("#personDataForm").submit();
}

function checkRemark(){
	var $remark = $("#entity\\.ebccRemark");
	if($remark.val().length > 200){
		setErrorMsg("#remark_tips","备注长度不能大于200位！");
		return false;
	}else{
		return true;
	}
}

function checkAddress(){
	var $address = $("#entity\\.ebccAddress");
	if($address.val().length > 200){
		setErrorMsg("#district_tips","详细地址长度不能大于200位！");
		return false;
	}else{
		return true;
	}
}

function checkDistrict(){
	var $district = $("#entity\\.ebccDistrict");
	if($district.val()==$district.attr('ov')){
		setErrorMsg("#district_tips","请选择所在省市！");
		return false;
	}else{
		$("#district_tips").html("<span class='icon_succ'></span>"); 
		return true;
	}
}

function checkTel(){
	var $tel = $("#entity\\.ebccTel");
	if($tel.val() != $tel.attr('ov')){
		var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		if(reg.test($tel.val())){
			$("#tel_tips").html("<span class='icon_succ'></span>"); 
			return true;
		}else{
			setErrorMsg("#tel_tips","请输入正确座机号！");
			return false;
		}
	}else{
		return true;
	}
}

function checkCompany(){
	var $company = $("#entity\\.ebccCompany");
	if($company.val().length > 50){
		setErrorMsg("#company_tips","公司全称长度不能大于50位！");
		return false;
	}else{
		$("#company_tips").html("<span class='icon_succ'></span>"); 
  		return true; 
	}
}

function checkSex(){
	var val=$('input:radio[name="entity.ebccSex"]:checked').val();
	if(null == val){
		setErrorMsg("#sex_tips","请选择性别！");
		return false;
	}else{
		$("#sex_tips").html("<span class='icon_succ'></span>"); 
  		return true;
	}
}

function checkContactName(){
	var $contactName = $("#entity\\.ebccContactName");
	if($contactName.val()==$contactName.attr('ov')){
		setErrorMsg("#contactName_tips","请输入姓名！");
		return false;
	}else if($contactName.val().length > 50){
		setErrorMsg("#contactName_tips","姓名长度不能大于50位！");
		return false;
	}else{
		$("#contactName_tips").html("<span class='icon_succ'></span>"); 
  		return true; 
	}
}

function checkMobile(check){
	var $mobile = $("#entity\\.ebccMobile");
	if($mobile.val()==$mobile.attr('ov')){
		setErrorMsg("#phone_tips","请输入手机号码！");
		return false;
	}
 	if(!isMobile($mobile.val())){
        setErrorMsg("#phone_tips","请输入正确手机号码！");
        return false; 
    }else{
		$("#phone_tips").html("<span class='icon_succ'></span>"); 
 	}
 	if(check){
	 	$.post("registAction!checkPhoneJson.action",{
			"entity.ebccMobile" : $mobile.val(),
			"total" : 2
	 		},
			function(data, status) {
				$("#phone_tips").html(data.errorMsg); 
			}
		);
 	}
 	return true; 
}
function checkNetLogin(check){
	var $ebccNetLogin = $("#entity\\.ebccNetLogin");
	if($ebccNetLogin.val()==$ebccNetLogin.attr('ov')){
		setErrorMsg("#loginName_tips","请输入用户名！");
		return false;
	}else if($ebccNetLogin.val().length > 50){
		setErrorMsg("#loginName_tips","用户名长度不能超过50位！");
		return false;
	}
	if(check){
	 	$.post("registAction!checkUserNameJson.action",{
			"entity.ebccNetLogin" : $ebccNetLogin.val(),
			"total" : 2
	 		},
			function(data, status) {
				$("#loginName_tips").html(data.errorMsg);
			}
		);
	}
	return true;
}
function checkEmail(check){
	var myemail=$("#entity\\.ebccEmail").val();
	var email = "";
 	if($("#entity\\.ebccEmail").val()!=$("#entity\\.ebccEmail").attr('ov')){
     	var reg =/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/; 
     	if(!reg.test(myemail)){
			setErrorMsg("#email_tips","请输入正确的邮箱！");
            return false;
        }else{
        	if(myemail.length > 50){
        		setErrorMsg("#email_tips","邮箱长度不能大于50位！");
                return false;
        	}else{
        		$("#email_tips").html("<span class='icon_succ'></span>");
        	}
     	}
     	email = myemail;
	}
 	if(check){
	 	$.post("registAction!checkEmailJson.action",{
			"entity.ebccEmail" : email,
			"total" : 2
	 		},
			function(data, status) {
				$("#email_tips").html(data.errorMsg);
			}
		);
 	}
 	return true;
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
	/**
	 * 点击后，马上禁用按钮
	 */
	$("#getPhoneVerCodeBtn").attr("disabled","disabled");
	$("#getPhoneVerCodeBtn").addClass("btn_sub");
	var phone = $("#entity\\.ebccMobile").val();
	$.post("registAction!sendPhoneVerCodeJson.action",{
		"entity.ebccMobile" : phone,
		"total" : 1,
		"registVerCode" : 'HOAU'
		},
		function(data, status) {
			if(data.errorType == ""){
				countDownPhoneNum = data.countdown;
				timer = setInterval(phoneCountdown, "1000");
			}else{
				$("#mobile_tips").html(data.errorMsg);
				$("#getPhoneVerCodeBtn").removeClass("btn_sub");
				$("#getPhoneVerCodeBtn").attr("disabled",false);
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
		clearTimeout(phoneTimer);
	}
}

function setErrorMsg(id,msg){
	var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	$(id).html(rs);
}