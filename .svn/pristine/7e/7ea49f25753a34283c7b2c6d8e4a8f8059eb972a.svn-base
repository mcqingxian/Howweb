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
		var cur = window.location.href;
		if(cur.indexOf("dest") > 0){
			var curAction = $("#loginForm").attr("action");
			var position = cur.lastIndexOf("?");
			var dest = cur.substr(position);
			var newAction = curAction+dest;
			$("#loginForm").attr("action",newAction);
		}
		$("#loginForm").submit();
	}
}

function checkInfo(){
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	if(loginName == $("#loginName").attr("ov")){
		setErrorMsg("#loginName_tips","登陆账号不能为空！");
		return false;
	}else{
		$("#loginName_tips").html("<span class='icon_succ'></span>");
	}
	if(password == ""){
		setErrorMsg("#loginPwd_tips","登陆密码不能为空！");
		return false;
	}else{
		$("#loginPwd_tips").html("<span class='icon_succ'></span>");
	}
	return true;
}

function setErrorMsg(id,msg){
	var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	$(id).html(rs);
}