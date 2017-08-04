function initData() {
	$("#loginName").keypress(function(e){ 
		if (e.keyCode == 13){
			$("#password").focus();
	    }
	});
	$("#password").keypress(function(e){ 
		if (e.keyCode == 13){
			login();
	    }
	});
};
function login(){
	if(checkInfo()){
		$.post("loginAction!loginJson.action",{
			"loginName" : $("#loginName").val(),
			"password" : $("#password").val()
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
}

function checkInfo(){
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	if(loginName == $("#loginName").attr("ov")){
		setLoginErrorMsg("#login_tips","登陆账号不能为空！");
		return false;
	}else{
		$("#login_tips").html("<span class='icon_succ'></span>");
	}
	if(password == ""){
		setLoginErrorMsg("#login_tips","登陆密码不能为空！");
		return false;
	}else{
		$("#login_tips").html("<span class='icon_succ'></span>");
	}
	return true;
}

function setLoginErrorMsg(id,msg){
	var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	$(id).html(rs);
}