// JavaScript Document
$(function() {
	$.get("/wechat/queryDistrictProvince.action", function(result, status) {
		var data = result.provinces;
		var province = document.getElementById("from_province");
		province.length = 1;
		var ops = province.options;
		for(var i = 0 ; i <data.length; i++){
			var option = new Option(data[i],data[i]);
			ops.add(option);
		}
		
		var provinceTo = document.getElementById("to_province");
		provinceTo.length = 1;
		var opsTo = provinceTo.options;
		for(var i = 0 ; i <data.length; i++){
			var option = new Option(data[i],data[i]);
			opsTo.add(option);
		}
	});

	$("#from_province").change(function() {
		var selValue = $(this).val();
		$("#from_city").empty();
		$.post("/wechat/queryCityInfo.action", 
		{
			province : selValue
		}, 
		function(result, status) {
			var data = result.citys;
			for (var i = 0; i < data.length; i++) {
				$("#from_city").append($("<option value="+data[i]+">"+data[i]+"</option>"));
			}
		});
	});

	$("#to_province").change(function() {
		var selValue = $(this).val();
		$("#to_city").empty();
		$.post("/wechat/queryCityInfo.action", 
		{
			province : selValue
		}, 
		function(result, status) {
			var data = result.citys;
			for (var i = 0; i < data.length; i++) {
				$("#to_city").append($("<option value="+data[i]+">"+data[i]+"</option>"));
			}
		});
	});
});

//显示服务条款
function show(o){
	 var o = document.getElementById(o);
	 o.style.display = "";
	}
function hide(o){
	 var o = document.getElementById(o);
	 o.style.display = "none";
	// window.location = url;
	}


//reset 重置按钮事件
function reset1(){
	$("#tb1 input[type='text']").val("");
}
function reset2(){
	$("#tb2 input[type='text']").val("");
}
function reset3(){
	$("#tb3 input[type='text']").val("");
	$("#tb3 input[type='number']").val("");
}

//-----------------------------------------------
function check1(){
	//发货人
	var val = $("#shipper_name");
	if("" == val.val()){
		//alert("发货人不能为空!");
		$("#shipper").text("发货人不能为空!");
		$("#shipper").addClass("error_msg");
		//val.focus();
		//return false;
	}else{
		if(val.val().length>50){
			$("#shipper").text("请输入50长度以内的中文或英文名字");
			$("#shipper").addClass("error_msg");
			//val.focus();
			//return false;
		}else{
			$("#shipper").text("");
			$("#shipper").removeClass("error_msg");
			//return true;
		}
	}	
}
function check2(){
	//发货人手机电话
	var mobileReg =/^(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$/; 
	var mobile = $("#shipper_mobile_phone");
	var phone = $("#shipper_phone");
	if("" == mobile.val() && "" == phone.val()){
		$("#shipper_mobile").text("手机与电话必须填写一项");
		$("#shipper_mobile").addClass("error_msg");
		//alert("发货人手机和电话不能同时为空!");
		//mobile.focus();
		//return false;
	}else{
		if("" != mobile.val()){
			if(!mobileReg.test(mobile.val())){
				//alert("手机格式不正确!");
				$("#shipper_mobile").text("手机格式不正确!");
				$("#shipper_mobile").addClass("error_msg");
				//mobile.focus();
				//return false;
			}else{//用户格式正确后移除错误样式
				$("#shipper_mobile").text("");
				$("#shipper_mobile").removeClass("error_msg");
			}
		}
		if("" != phone.val()){
			var result=phone.val().match(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/);
			if(null == result){
				//alert("电话号码格式不正确!");
				$("#shipper_mobile").text("电话号码格式不正确!");
				$("#shipper_mobile").addClass("error_msg");
				//phone.focus();
				//return false;
			}else{
				$("#shipper_mobile").text("");
				$("#shipper_mobile").removeClass("error_msg");
			}
		}
	}
}

function check3(){
	//发货地址
	val = $("#from_detail_address");
	if("" == val.val()){
		//alert("发货地址不能为空！");
		$("#fh_address").text("发货地址不能为空！");
		$("#fh_address").addClass("error_msg");
		//val.focus();
		//return false;
	}else{
		$("#fh_address").text("");
		$("#fh_address").removeClass("error_msg");
	}
	
}
function check4(){
	//收货人
	val = $("#consignee_name");
	if("" == val.val()){
		//alert("收货人不能为空！");
		$("#consignee").text("收货人不能为空！");
		$("#consignee").addClass("error_msg");
		//val.focus();
		//return false;
	}else{
		if(val.val().length>50){
			$("#consignee").text("请输入50长度以内的中文或英文名字");
			$("#consignee").addClass("error_msg");
			//val.focus();
			//return false;
		}else{
			$("#consignee").text("");
			$("#consignee").removeClass("error_msg");
		}
	}
}

function check5(){
	//收货人手机电话
	var mobileReg =/^(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$/; 
	var mobile = $("#consignee_mobile_phone");
	var phone = $("#consignee_phone");
	if("" == mobile.val() && "" == phone.val()){
		//alert("收货人手机和电话不能同时为空!");
		$("#consignee_mobile").text("收货人手机和电话不能同时为空!");
		$("#consignee_mobile").addClass("error_msg");
		//mobile.focus();
	//	return false;
	}else{
		if("" != mobile.val()){
			if(!mobileReg.test(mobile.val())){
				//alert("手机格式不正确!");
				$("#consignee_mobile").text("手机格式不正确!");
				$("#consignee_mobile").addClass("error_msg");
			//	mobile.focus();
			//	return false;
			}else{
				$("#consignee_mobile").text("");
				$("#consignee_mobile").removeClass("error_msg");
			}
		}
		if("" != phone.val()){ 
			//\d{3}-\d{8}|\d{4}-\d{7
			var result=phone.val().match(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/);
			if(null == result){
				//alert("电话号码格式不正确!");
				$("#consignee_mobile").text("电话号码格式不正确!");
				$("#consignee_mobile").addClass("error_msg");
			//	phone.focus();
				//return false;
			}else{
				$("#consignee_mobile").text("");
				$("#consignee_mobile").removeClass("error_msg");
			}
		}
	}
}

function check6(){
	//收货地址
	val = $("#to_detail_address");
	if("" == val.val()){
		//alert("收货地址不能为空！");
		$("#sh_address").text("收货地址不能为空！");
		$("#sh_address").addClass("error_msg");
		//val.focus();
		//return false;
	}else{
		$("#sh_address").text("");
		$("#sh_address").removeClass("error_msg");
	}
}

function check7(){
	//货物名称非空提示
	val = $("#goods_name");
	if("" == val.val()){
		//alert("货物名称不能为空！");
		$("#goods").text("货物名称不能为空！");
		$("#goods").addClass("error_msg"); 
		//val.focus();
		//return false;
	}else{
		if(val.val().length>100){
			$("#goods").text("请填写100以内长度货物名称");
			$("#goods").addClass("error_msg");
			//val.focus();
			//return false;
		}else{
			$("#goods").text("");
			$("#goods").removeClass("error_msg");
		}
		$("#goods").text("");
		$("#goods").removeClass("error_msg");
	}
	
}

//提交时 全局信息校验
function check(){
	//手机正则
	var mobileReg =/^(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$/;
	var val = $("#shipper_name");
	if("" == val.val()){
		alert("发货人不能为空!");
		val.focus();
		return false;
	}
	var mobile = $("#shipper_mobile_phone");
	var phone = $("#shipper_phone");
	if("" == mobile.val() && "" == phone.val()){
		alert("发货人手机和电话不能同时为空!");
		mobile.focus();
		return false;
	}else{
		if("" != mobile.val()){
			if(!mobileReg.test(mobile.val())){
				alert("手机格式不正确!");
				mobile.focus();
				return false;
			}
		}
		if("" != phone.val()){
			var result=phone.val().match(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/);
			if(null == result){
				alert("电话号码格式不正确!");
				phone.focus();
				return false;
			}
		}
	}
	
	val = $("#from_province");
	if("" == val.val()){
		alert("发货地址省份未选择！");
		val.focus();
		return false;
	}
	
	val = $("#from_city");
	if("" == val.val()){
		alert("发货地址城市未选择！");
		val.focus();
		return false;
	}
	val = $("#from_detail_address");
	if("" == val.val()){
		alert("发货地址不能为空！");
		val.focus();
		return false;
	}
	
	
	val = $("#consignee_name");
	if("" == val.val()){
		alert("收货人不能为空！");
		val.focus();
		return false;
	}
	var mobile = $("#consignee_mobile_phone");
	var phone = $("#consignee_phone");
	if("" == mobile.val() && "" == phone.val()){
		alert("发货人手机和电话不能同时为空!");
		mobile.focus();
		return false;
	}else{
		if("" != mobile.val()){
			if(!mobileReg.test(mobile.val())){
				alert("手机格式不正确!");
				mobile.focus();
				return false;
			}
		}
		if("" != phone.val()){
			var result=phone.val().match(/(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/);
			if(null == result){
				alert("电话号码格式不正确!");
				phone.focus();
				return false;
			}
		}
	}
	
	val = $("#to_province");
	if("" == val.val()){
		alert("收货地址省份未选择！");
		val.focus();
		return false;
	}
	val = $("#to_city");
	if("" == val.val()){
		alert("收货地址城市未选择！");
		val.focus();
		return false;
	}
	val = $("#to_detail_address");
	if("" == val.val()){
		alert("收货地址不能为空！");
		val.focus();
		return false;
	}
	
	val = $("#goods_name");
	if("" == val.val()){
		alert("货物名称不能为空！");
		val.focus();
		return false;
	}
	
	val = $("#from_detail_address");
	if("" == val.val()){
		alert("发货地址不能为空！");
		val.focus();
		return false;
	}
	
	val = $("#to_detail_address");
	if("" == val.val()){
		alert("收货地址不能为空！");
		val.focus();
		return false;
	}
	
	//货物件数验证
	var goods = $("#goods_pieces");
	if("" != goods.val()){
		var result=goods.val().match(/^[0-9]+$/);
		if(null == result){
			alert("货物件数只能是数字");
			goods.focus();
			return false;
		}
	}
	//货物重量的验证
	var weight = $("#goods_weight");
	if(""!= weight.val()){
		var result = weight.val().match(/^\d+$/);
		if(null == result){
			alert("货物重量只能为数字");
			weight.focus();
			return false;
		}
	}
	//货物体积的验证
	var volumn = $("#goods_volumn");
	if(""!= volumn.val()){
		var result = volumn.val().match(/^\d+$/);
		if(null == result){
			alert("货物体积只能为数字");
			volumn.focus();
			return false;
		}
	}
	//货物包装件数的验证
	var pack = $("#goods_packing");
	if(""!= pack.val()){
		var result = pack.val().match(/^[0-9]+$/);
		if(null == result){
			alert("货物包装件数只能为数字");
			pack.focus();
			return false;
		}
	}
	//货物保价的验证
	var quotation = $("#quotation_statement");
	if(""!= quotation.val()){
		var result = quotation.val().match(/^\d+$/);
		if(null == result){
			alert("货物保价只能为数字");
			quotation.focus();
			return false;
		}
	}
	return true;
	
}



