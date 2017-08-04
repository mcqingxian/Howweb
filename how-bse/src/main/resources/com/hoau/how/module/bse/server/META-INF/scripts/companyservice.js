//特许经营input状态
var sqqy_status = false;
var gsmc_status = false;
var gsdz_status = false;
var zczj_status = false;
var ygrs_status = false;
var lxr_status = false;
var lxfs_status = false;
var dzyj_status = false;
var cdmj_status = false;
var zycl_status = false;
//建议留言input状态
var titleStatus = false;
var msgStatus = false;
//投诉input状态
var tsName_status = false;
var tsWaybill_status = false;
var tsMsg_status = false;
var tsTel_status = false;
$(document).ready(function() {	
	var flag = true;
	//验证码输入框失去焦点 ajax 异步验证
	$("#validateCode_input").blur(function(){
		var validateCode =  $(this).val();
		if(validateCode.length > 0){
			$.get("codeCheck.action?code="+validateCode,function(data,status){
				if(data.success == false){
					$("#codeTips").show();
					$("#codeNotice").text(data.message).show();
					flag = false;
				}else{
					flag = true;
				}
			});
		}
	});
	// 验证码输入框得到焦点
	$("#validateCode_input").focus(function(){
		$("#codeTips").hide();
		$("#codeNotice").hide();
	});
	
	/**
	 * 特许经营报名输入js验证
	 */
	//申请区域得到失去焦点样式提醒
//	$("#selectProvince").blur(function(){checkSqqy();});
//	$("#selectCity").blur(function(){checkSqqy();});
//	$("#sqqy").blur(function(){checkSqqy();});
	$("#gsmc").blur(function(){checkGsmc();});
	$("#gsdz").blur(function(){checkGsdz();});
	$("#zczj").blur(function(){checkZczj();});
	$("#ygrs").blur(function(){checkYgrs();});
	$("#lxr").blur(function(){checkLxr();});
	$("#lxfs").blur(function(){checkLxfs();});
	$("#dzyj").blur(function(){checkDzyj();});
	$("#cdmj").blur(function(){checkCdmj();});
	$("#zycl").blur(function(){checkZycl();});

	/**
	 * 留言验证
	 */
	//标题得到失去焦点样式提醒
	$("#title_input").blur(function(){checkSugTitle();});
	//留言内容得到失去焦点样式提醒
	$("#msg_input").blur(function(){checkSugMsg();});
	
	//保存客户咨询建议留言信息
	$("#saveSupportComment_btn").click(function(){
		var title = $("#title_input").val();
		var type=$("input[name='type']:checked").val();
		var name=$("#name_input").val();
		var tel = $("#tel_input").val();
		var email = $("#email_input").val();
		var waybill = $("#waybillVale_input").val();
		var message = $("#msg_input").val();
		var validateCode = $("#validateCode_input").val();
		if(flag == false){
			$("#codeTips").show();
			$("#codeNotice").text("验证码输入有误").show();
			$("#validateCode_input").focus();
			return;
		}
		if(!titleStatus){
			$("#title_input").focus();
			return;
		}
		if(type==null){
			$("#typeTips").show();
			$("#typeNotice").text("请选择留言类型").show();
			return;
		}
		if(!msgStatus){
			$("#msg_input").focus();
			return;
		}
		if(validateCode == ""){
			$("#codeTips").show();
			$("#codeNotice").text("验证码不能为空").show();
			$("#validateCode_input").focus();
			return;
		}
		if(title.length>50 || name.length>10 || tel.length>20 ||email.length>40 || waybill.length>8 || message.length>500){
			return;
		}
		
		//异步提交
		$.ajax({
				type : "post",
				url : "addComment.action",
				dataType : "json",
				data :{
					vercode:validateCode,
					"commentEntity.topic":title,
					"commentEntity.type":type,
					"commentEntity.name":name,
					"commentEntity.tel":tel,
					"commentEntity.email":email,
					"commentEntity.wbnum":waybill,
					"commentEntity.message":message
				},
				success:function(data){
					if(data.success){
						alert("提交成功，谢谢！");
						clear();
					}else if("验证码错误！"==data.message){
						alert(data.message);
					}
				},
				error : function(data) {
					alert("对不起，系统繁忙,请稍后操作！");
				}
		});
	});

	/**
	 * 投诉
	 */
	$("#name_input_ts").blur(function(){checkTsName();});
	$("#tel_input_ts").blur(function(){checkTsTel();});
	//运单号只做了位数限制todo 还需验证每个运单号每天只允许投诉一次
	$("#waybillVale_input_ts").blur(function(){checkWaybill();});
	$("#msg_input_ts").blur(function(){checkTsMsg();});
	
	//保存客户投诉信息
	$("#saveComplaintComment_btn").click(function(){
		var title = $("#title_input").val();
		var type=$("input[name='type']:checked").val();
		var name=$("#name_input_ts").val();
		var tel = $("#tel_input_ts").val();
		var waybill = $("#waybillVale_input_ts").val();
		var message = $("#msg_input_ts").val();
		var validateCode = $("#validateCode_input").val();
		if(flag == false){
			$("#codeTips").show();
			$("#codeNotice").text("验证码输入有误").show();
			$("#validateCode_input").focus();
			return;
		}
		if(!titleStatus){
			$("#titleNotice").focus();
			return;
		}
		if(!tsName_status){
			$("#nameNotice_ts").focus();
			return;
		}
		if(type==null){
			$("#typeTips").show();
			$("#typeNotice").text("请选择客户类型").show();
			return;
		}
		if(!tsTel_status){
			$("#telNotice_ts").focus();
			return;
		}
		if(!tsWaybill_status){
			$("#waybillNotice_ts").focus();
			return;
		}
		if(!tsMsg_status){
			$("#messageNotice").focus();
			return;
		}
		if(validateCode == ""){
			$("#codeTips").show();
			$("#codeNotice").text("验证码不能为空").show();
			$("#validateCode_input").focus();
			return;
		}
		//这里只做了简单的长度验证 
		if(title.length>50 || name.length>10 || tel.length>20 || waybill.length!=8 || message.length>500){
			return;
		}
		
		//异步提交
		$.ajax({
				type : "post",
				url : "addComment.action",
				dataType : "json",
				data :{
					vercode:validateCode,
					"commentEntity.topic":title,
					"commentEntity.name":name,
					"commentEntity.customerType":type,
					"commentEntity.tel":tel,
					"commentEntity.wbnum":waybill,
					"commentEntity.message":message
				},
				success:function(data){
					if(data.success){
						alert("提交成功，我们会在第一时间处理您的投诉，谢谢！");
						//清空界面
						clear();
					}else if("验证码错误！"==data.message){
						alert(data.message);
					}
				},
				error : function(data) {
					alert("对不起，系统繁忙,请稍后操作！");
				}
		});
	});	
	
	$("#txtijiao").click(function(){
		var selectedPid = $('select[name="pid"]').val();
		var selectedCid = $('select[name="cid"]').val();
		var sqqy = $("#sqqy").val();
		var gsmc=$("#gsmc").val();
		var gsdz = $("#gsdz").val();
		var zczj = $("#zczj").val();
		var ygrs = $("#ygrs").val();
		var lxr = $("#lxr").val();
		var lxfs = $("#lxfs").val();
		var dzyj = $("#dzyj").val();
		var cdmj = $("#cdmj").val();
		var zycl = $("#zycl").val();
		var lynr = $("#lynr").val();
		var validateCode = $("#validateCode_input").val();
		if(flag == false){
			$("#codeTips").show();
			$("#codeNotice").text("验证码输入有误").show()
			$("#validateCode_input").focus();
			return;
		}
		if(selectedPid==""){
			$("#selectProvince").focus();
			return;
		}
		if(selectedCid==""){
			$("#selectCity").focus();
			return;
		}
	/*	if(!sqqy_status){
			checkSqqy();
			$("#sqqy").focus();
			return;
		}*/
		if(!gsmc_status){
			checkGsmc();
			$("#gsmc").focus();
			return;
		}
		if(!gsdz_status){
			checkGsdz();
			$("#gsdz").focus();
			return;
		}
		if(!zczj_status){
			checkZczj();
			$("#zczj").focus();
			return;
		}
		if(!ygrs_status){
			checkYgrs();
			$("#ygrs").focus();
			return ;
		}
		if(!lxr_status){
			checkLxr();
			$("#lxr").focus();
			return ;
		}
		if(!lxfs_status){
			checkLxfs();
			$("#lxfs").focus();
			return ;
		}
		if(!dzyj_status){
			checkDzyj();
			$("#dzyj").focus();
			return ;
		}
		if(!cdmj_status){
			checkCdmj();
			$("#cdmj").focus();
			return ;
		}
		if(!zycl_status){
			checkZycl();
			$("#zycl").focus();
			return ;
		}
		if(validateCode == ""){
			$("#codeTips").show();
			$("#codeNotice").text("验证码不能为空").show();
			$("#validateCode_input").focus();
			return;
		}
		//长度验证
		if(sqqy.length>50 || gsmc.length>20 || gsdz.length>200 || zczj.length>20 || ygrs.length>13
				|| lxr.length>10 || dzyj.length>20 || cdmj.length>20 || zycl.length>10
				|| lynr.length>1000){
			return;
		}
		
		$.ajax({
			type : "post",
			url : "saveRigistInfo.action",
			dataType : "json",
			data : {
				vercode:validateCode,
				"registrationVo.pid":selectedPid,
				"registrationVo.pname":$("#selectProvince").find("option:selected").text(),
				"registrationVo.cid":selectedCid,
				"registrationVo.cname":$("#selectCity").find("option:selected").text(),
				"registrationVo.district":sqqy,
				"registrationVo.name":gsmc,
				"registrationVo.address":gsdz,
				"registrationVo.money":zczj,
				"registrationVo.employeeno":ygrs,
				"registrationVo.contacts":lxr,
				"registrationVo.tel":lxfs,
				"registrationVo.email":dzyj,
				"registrationVo.area":cdmj,
				"registrationVo.car":zycl,
				"registrationVo.message":lynr
			},
			success : function(data){
				if (data.success){
					alert("报名成功，我们会尽快联系您，期待与您的合作！");	
					window.location.href = "franchise.action?newsId=12903";
				}else if("验证码错误！"==data.message){
					alert(data.message);
				}
			},
			error : function(data) {
				alert("对不起，系统繁忙,请稍后操作！");
			}
		});
	});
});


//更改验证码
function changeCode(){  
	$("#validateCode_img").attr("src","genCheckCode.action?"+ new Date());
} 

//验证类型单选按钮
function typechanged(){
	if($("input[name='type']:checked").val() !=null){
		$("#typeTips").hide();
		$("#typeNotice").hide();
	}
}

//清空界面
function clear(){
	$(".sug_msg input").val("");
	$("input[name='type']").removeAttr("checked"); 
	$(".sug_msg textarea").val("");
}

//留言搜索条件验证
function searchCheck(){
	var key = $.trim($("#searchCondition_input").val());
	if(key == "" || key == $.trim($("#searchCondition_input").attr("ov")) || key.length>50){
		/**
		 * 关键字为空显示所有记录
		 * @author 275688
		 * @update
		 */
		$("#searchCondition_input").val("");
		
//		return false;
	}
	return true;
}


//显示城市
function showCitys(){
	$("#selectCity").empty();//清空 
	$("#selectCity").append("<option value=''>请选择市</option>");
	var selectedId = $('select[name="pid"]').val();
	if(selectedId != ""){
		$.ajax({
			type : "post",
			url : "getCity.action",
			dataType : "json",
			data : {
				pid:selectedId
			},
			success :function(data){
				if (data.success){
					var citys = data.citys;
					for(var i=0;i<citys.length;i++){
						var cid=citys[i].cid;
						var cname=citys[i].cname;
						$("#selectCity").append("<option id='"+cid+"' value='"+cid+"'>"+cname+"</option>");
					}
				}
			},
			error : function(data) {
				alert("对不起，系统繁忙,请稍后操作！");
			}
		});
	}
}

function checkSqqy(){
	var value=$.trim($("#sqqy").val());
	var ov=$.trim($("#sqqy").attr("ov"));
	if(value.length <= 0 || value==ov || $('select[name="pid"]').val()==""||$('select[name="cid"]').val()==""){
		$("#sqqyTips").show();
		$("#sqqyWarning").text("请填写申请区域").show();
		sqqy_status = false;
	}else{
		$("#sqqyTips").hide();
		$("#sqqyWarning").hide();
		sqqy_status = true;
	}
}
function checkGsmc(){
	var value=$.trim($("#gsmc").val());
	var ov=$.trim($("#gsmc").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#gsmcTips").show();
		$("#gsmcWarning").text("请填写公司/个人名称").show();
		gsmc_status = false;
	}else{
		$("#gsmcTips").hide();
		$("#gsmcWarning").hide();
		gsmc_status = true;
		}
}

function checkGsdz(){
	var value=$.trim($("#gsdz").val());
	var ov=$.trim($("#gsdz").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#gsdzTips").show();
		$("#gsdzWarning").text("请填写公司/个人地址").show();
		gsdz_status = false;
	}else{
		$("#gsdzTips").hide();
		$("#gsdzWarning").hide();
		gsdz_status = true;
	}
}
function checkZczj(){
	var value=$.trim($("#zczj").val());
	var ov=$.trim($("#zczj").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#zczjTips").show();
		$("#zczjWarning").text("请填写注册资金").show();
		zczj_status = false;
	}else if(!isTwoDecimal(value)){
		$("#zczjTips").show();
		$("#zczjWarning").text("请填写正确的资金").show();
		zczj_status = false;
	}else{
		$("#zczjTips").hide();
		$("#zczjWarning").hide();
		zczj_status = true;
	}
}
function checkYgrs(){
	var value=$.trim($("#ygrs").val());
	var ov=$.trim($("#ygrs").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#ygrsTips").show();
		$("#ygrsWarning").text("请填写员工人数").show();
		ygrs_status = false;
	}else if(!isInteger(value)){
		$("#ygrsTips").show();
		$("#ygrsWarning").text("请填写正确的人数").show();
		ygrs_status = false;
	}else{
		$("#ygrsTips").hide();
		$("#ygrsWarning").hide();
		ygrs_status = true;
	}
}
function checkLxr(){
	var value=$.trim($("#lxr").val());
	var ov=$.trim($("#lxr").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#lxrTips").show();
		$("#lxrWarning").text("请填写联系人").show();
		lxr_status = false;
	}else if(!isCharacter(value)){
		$("#lxrTips").show();
		$("#lxrWarning").text("请填写正确姓名").show();
		lxr_status = false;
	}else{
		$("#lxrTips").hide();
		$("#lxrWarning").hide();
		lxr_status = true;
	}
}
function checkLxfs(){
	var value=$.trim($("#lxfs").val());
	var ov=$.trim($("#lxfs").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#lxfsTips").show();
		$("#lxfsWarning").text("请填写联系方式").show();
		lxfs_status = false;
	}else if(!isTellNo(value)){
		$("#lxfsTips").show();
		$("#lxfsWarning").text("请填写正确的联系方式").show();
		lxfs_status = false;
	}else{
		$("#lxfsTips").hide();
		$("#lxfsWarning").hide();
		lxfs_status = true;
	}
}
function checkDzyj(){
	var value=$.trim($("#dzyj").val());
	var ov=$.trim($("#dzyj").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#dzyjTips").show();
		$("#dzyjWarning").text("请填写电子邮件").show();
		dzyj_status = false;
	}else if(!isEmail(value)){
		$("#dzyjTips").show();
		$("#dzyjWarning").text("请填写正确的电子邮件").show();
		dzyj_status = false;
	}else{
		$("#dzyjTips").hide();
		$("#dzyjWarning").hide();
		dzyj_status = true;
	}
}
function checkCdmj(){
	var value=$.trim($("#cdmj").val());
	var ov=$.trim($("#cdmj").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#cdmjTips").show();
		$("#cdmjWarning").text("请填写场地面积").show();
		cdmj_status = false;
	}else if(!isTwoDecimal(value)){
		$("#cdmjTips").show();
		$("#cdmjWarning").text("请填写正确的面积").show();
		cdmj_status = false;
	}else{
		$("#cdmjTips").hide();
		$("#cdmjWarning").hide();
		cdmj_status = true;
	}
}
function checkZycl(){
	var value=$.trim($("#zycl").val());
	var ov=$.trim($("#zycl").attr("ov"));
	if(value.length <= 0 || value == ov){
		$("#zyclTips").show();
		$("#zyclWarning").text("请输入自有车辆").show();
		zycl_status = false;
	}else if(!isInteger(value)){
		$("#zyclTips").show();
		$("#zyclWarning").text("请输入正确车辆数").show();
		zycl_status = false;
	}else{
		$("#zyclTips").hide();
		$("#zyclWarning").hide();
		zycl_status = true;
	}
}
function checkSugTitle(){
	var title =  $("#title_input").val();
	if(title.length <= 0){
		$("#titleTips").show();
		$("#titleNotice").text("请填写标题").show();
		titleStatus = false;
	}else{
		$("#titleTips").hide();
		$("#titleNotice").hide();
		titleStatus = true;
	}
}
function checkSugMsg(){
	var msg =  $("#msg_input").val();
	if(msg.length <= 0){
		$("#msgTips").show();
		$("#messageNotice").text("请填写留言内容").show();
		msgStatus = false;
	}else{
		$("#msgTips").hide();
		$("#messageNotice").hide();
		msgStatus = true;
	}
}


function checkTsName(){
	var name =  $("#name_input_ts").val();
	if(name.length <= 0){
		$("#ts_nameTips").show();
		$("#nameNotice_ts").text("请填写姓名").show();
		tsName_status = false;
	}else if(!isCharacter(name)){
		$("#ts_nameTips").show();
		$("#nameNotice_ts").text("姓名只能包含字符格式").show();
		tsName_status = false;
	}else{
		$("#ts_nameTips").hide();
		$("#nameNotice_ts").hide();
		tsName_status = true;
	}
}
function checkTsTel(){
	var tel =  $("#tel_input_ts").val();
	if(tel.length <= 0){
		$("#ts_telTips").show();
		$("#telNotice_ts").text("请填写联系方式").show();
		tsTel_status = false;
	}else if(!isTellNo(tel) || tel.length>20){
		$("#ts_telTips").show();
		$("#telNotice_ts").text("请填写正确的联系方式").show();
		tsTel_status = false;
	}else{
		$("#ts_telTips").hide();
		$("#telNotice_ts").hide();
		tsTel_status = true;
	}
}
function checkWaybill(){
	var waybill =  $("#waybillVale_input_ts").val();
	if(waybill.length <= 0){
		$("#ts_waybillTips").show();
		$("#waybillNotice_ts").text("请填写运单号").show();
		tsWaybill_status = false;
	}else if(waybill.length !=8 && waybill.length !=9){
		$("#ts_waybillTips").show();
		$("#waybillNotice_ts").text("请填写正确的运单号").show();
		tsWaybill_status = false;
	}else{
		$("#ts_waybillTips").hide();
		$("#waybillNotice_ts").hide();
		tsWaybill_status = true;
	}
}
function checkTsMsg(){
	var msg =  $("#msg_input_ts").val();
	if(msg.length <= 0){
		$("#ts_messageTips").show();
		$("#messageNotice_ts").text("请填写投诉内容").show();
		tsMsg_status = false;
	}else{
		$("#ts_messageTips").hide();
		$("#messageNotice_ts").hide();
		tsMsg_status = true;
	}
}
//是否为空并给出提示
function isNotNull(value,id,warning){
	if(value==""){
		$(id+"Warning").text(warning).show();
		$(id).focus();
		return false;
	}
	return true; 
}

//匹配电子邮箱
function isEmail( str ){ 
	var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
	if(myReg.test(str)) return true; 
	return false; 
} 
//匹配电话号码
function isTellNo(str){
	var myReg =/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
	if(myReg.test(str)) return true; 
	return false;
}
//匹配正的两位小数
function isTwoDecimal(str){
	var myReg =/^([1-9]\d*|0)(\.\d?[1-9])?$/;
	if(myReg.test(str)) return true; 
	return false;
}
//匹配数字
function isInteger(str){
	var myReg =/^\d+$/;
	if(myReg.test(str)) return true; 
	return false;
}
//匹配字符串
function isCharacter(str){
	var myReg =/^\D+$/;
	if(myReg.test(str)) return true; 
	return false;
}
//特许报名取消
function txregistCancel(){
	$(".txjy_layer_tab input").val("");
	$("#selectProvince").get(0).selectedIndex=0;
	$("#selectCity").get(0).selectedIndex=0;
	$(".txjy_layer_tab textarea").val("");
}