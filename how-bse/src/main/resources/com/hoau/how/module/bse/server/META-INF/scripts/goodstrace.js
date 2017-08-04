/**
 * 
 */

var countDownPhoneNum = 0;
$(document).ready(function() {
	checkCountDownPhoneJson();
	initDate();
	searchType($("#searchType").val());
	billsId = $("#transNos").val();
	$("#indexQueryBill").click(function(){
		var waybill = $(this).prev().val();
        //新增地址文本校验 肖聪
		var reg = /^([a-zA-Z0-9]|\d{2})\d{7}$/;
		if(!reg.test(waybill)){
			errTips("运单号格式有误");
			return;
		}

		if(waybill == "在此输入运单号进行查询"){
			waybill = "";
		}
		if($(this).attr("ov") == waybill){
			errTips("请输入运单号！");
			return;
		}
		$("#traceTransForm").submit(); 
	});
	$("#phoneImg").click(function(){
		var waybill = $(this).prev().val();
		$("#traceTransForm").attr("action","tracePhoneByNo.action");
		if(waybill == "在此输入手机号进行查询"){
			waybill = "";
		}
		if($(this).attr("ov") == waybill){
			errTips("请输入手机号！");
			return;
		}
		$("#traceTransForm").submit(); 
	});
	
	$("#transNos").focus(function(){
		$("#phoneImg").hide();
		$("#indexQueryBill").show();
	});
	/**网点查询**/
	$("#queryDistrictBtn").click(function(){
		var $typeValue = $("#typeValue");
		if($typeValue.attr("ov") == $typeValue.val()){
			$typeValue.attr("style","border:1px solid #f15a22");
			return;
		}
		$("#districtForm").submit();
	});
	
	var flag = true;
	// 验证码输入框失去焦点 ajax 异步验证
	$("#validateCode_input").blur(function(){
		var validateCode =  $(this).val();
		if(validateCode.length > 0){
			$.get("codeCheck.action?code="+validateCode,function(data,status){
				if(data.success == false){
					$("#codeNotice").text(data.message).show();
					flag = false;
				}else{
					flag = true;
				}
			});
		}
	});
	
	// 验证码输入框失去焦点
	$("#validateCode_input").focus(function(){
		$("#codeNotice").hide();
	});
	
	// 查询货物跟踪信息
	$("#wayBillQuery_btn").click(function(){
		var waybills = $("#waybillVale_input").val();
		waybills = $.trim(waybills);
		var validateCode = $("#validateCode_input").val();
		
		waybills=waybills.replace(/\n/g, '_@').replace(/\r/g, '_#');		
		waybills = waybills.replace(/_#_@/g, '<br/>').replace(/_@/g, '<br/>');

		if(flag == false){
			$("#codeNotice").text("验证码输入有误").show()
			return;
		}
		
		if(waybills == "" || validateCode == ""){
			$("#codeNotice").text("运单号或者验证码不能为空").show()
			return;
		}
		
		var validValue = waybills.replace(new RegExp(/(\<br\/\>)/g),',');
		var validArr = validValue.split(',');
		if(validArr.length>10){
			$("#isOverMaxlength").show();
			return;
		}else{
			$("#isOverMaxlength").hide();
		}
		
		
		for(var i = 0; i < validArr.length; i++) {
			if($.trim(validArr[i])==""){
				$("#codeNotice").text("逗号或者换行直接不能出现空单号").show();
			}else if(!isWaybill(validArr[i])){
				$("#codeNotice").text(validArr[i]+"不是正确的单号").show();
				return;
			} 
		} 
		
		
		// cookie操作
		var w = getCookie('importList');
		var cookieValue;
		if(w == null || w == ''){
			cookieValue = waybills;
		}else{
			cookieValue = waybills + ',' + w;
		}
		cookieValue=cookieValue.replace(new RegExp(/(\<br\/\>)/g),',');
		var arr = cookieValue.split(',');
		// 去重复
		arr.sort();
		var re=[arr[0]];
		for(var i = 1; i < arr.length; i++)
		{
			if( arr[i] !== re[re.length-1])
			{
				if($.trim(arr[i])!=""){
					re.push(arr[i]);
				}
			}
		}
		

		// 过期时间 30天
		setCookie('importList',re.join(','),30);
		window.location.href = "traceTransByNo.action?vercode="+validateCode+"&transNos="+waybills+"#cxjg";
		
	});
	
	
	// 清空查询记录
	$("#clearQueryRecord").click(function(){
		$("#importList").text('');
		delCookie('importList');
	});
	
	// 清空查询记录
	$("#send_email_link").click(function(){
		var emailAddress = $("#emails_input").val();
		
		var waybills = $("#waybillVale_input").val();
		if(waybills == null || waybills.length == 0){
			alert("运单号不能为空");
			return;
		}
		
		if(isEmail(emailAddress) == false){
			alert("请输入正确的邮箱地址");
			return;
		}
		
		$.get("sendEmail.action?emailAddress="+emailAddress,function(data,status){
			if(data.success == true){
				alert("已发送，请查收");
			}
		});
	});
	
	//按订单查询 add huyuzhou 2016年3月3日15:03:40
	$("#orderBtn").click(function(){
		searchType(1);
	});
	//按手机查询 add huyuzhou 2016年3月3日15:03:40
	$("#phoneBtn").click(function(){
		searchType(2);
	}); 
	$("#ebccMobile").blur(function(){
		if(!checkMobile()){
			return;
		}
	}); 
	//手机查询货物跟踪信息 add huyuzhou 2016年3月8日09:54:05
	$("#wayPhoneQuery_btn").click(function(){
		var ebccMobile = $("#ebccMobile").val();
		var validateCode_search = $("#validateCode_search").val();
		var sendDate = $("#sendDate").val();
		ebccMobile = $.trim(ebccMobile);
		if(ebccMobile == "" || ebccMobile == "请输入运单上的手机号码"){
			$("#codePhoneNotice").text("手机号不能为空").show();
			$("#ebccMobile").focus();
			return;
		}
		if(!checkMobile()){
			$("#codePhoneNotice").text("请输入正确的手机号码").show();
			$("#ebccMobile").focus();
			return;
		}
		if(validateCode_search == ""){
			$("#codePhoneNotice").text("短信验证码不能为空").show()
			return;
		}
		$.post("checkInfo.action",{
			"ebccMobile" : ebccMobile,"vercode":validateCode_search},
			function(data, status) {
				if(data.errorMsg != ""){
					$("#codePhoneNotice").text(data.errorMsg).show();
					return;
				}else{
					$("#codePhoneNotice").text("").hide();
					$("#getPhoneVerCodeBtn").removeClass("btn_sub");
					$("#getPhoneVerCodeBtn").attr("disabled",false);
					window.location.href = "tracePhoneByNo.action?ebccMobile="+ebccMobile+"&sendDate="+sendDate+"&vercode="+validateCode_search+"&transNos="+billsId+"#cxjg";
				}
			}
		);
		
		
	});
	
	
});
var billsId = "";
/**
 * 发送短信验证码
 * @author 胡宇宙 huyuzhou
 * @date 2016年3月3日15:41:44
 * @update add
 */
function sendPhoneVerCode(){
	var mobile = checkMobile();
	if(!mobile){
		return;
	}
	sendValidate();
	
}

/**
 * 默认选中按钮
 * @author 胡宇宙 huyuzhou
 * @date 2016年3月3日15:41:44
 * @update add
 */
function searchType(type){
	var searchType = "1";
	if(type != ""){
		searchType = type;
	}
	if(searchType == "2"){
		$("#orderBtn").attr("class","");
		$("#phoneBtn").attr("class","current");
		$("#phoneDiv").show();
		$("#orderDiv").hide();
		$("#clearDiv").hide();
		$("#cxxzDiv").show();
	}else{
		$("#orderBtn").attr("class","current");
		$("#phoneBtn").attr("class","");
		$("#phoneDiv").hide();
		$("#orderDiv").show();
		$("#clearDiv").show();
		$("#cxxzDiv").hide();
	}
}

// 更改验证码
function changeCode(){  
	$("#validateCode_img").attr("src","genCheckCode.action?"+ new Date());
} 

function errTips(msg){
	$(".erro").show();
	$(".erro_msg").text(msg)
}

function initval(value){
	if(value==1){
		if($("#waybillVale_input").val()=="请输入单号,最多可同时查询10个运单,多单号间用回车或逗号隔开"){
			$("#waybillVale_input").val("");
		}
	}else{
		if(isEmpty($("#waybillVale_input").val())){
			$("#waybillVale_input").val("请输入单号,最多可同时查询10个运单,多单号间用回车或逗号隔开");
		}
	}
}
/**验证手机号码是否正确
* @author 胡宇宙 huyuzhou
* @date 2016年3月3日15:41:44
* @update add
*/
function checkMobile(){
	var $mobile = $("#ebccMobile");
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
 	return true;
}

/** 发送手机验证码
* @author 胡宇宙 huyuzhou
* @date 2016年3月3日15:41:44
* @update add
*/
function sendValidate(){
	/**
	 * 点击后，马上禁用按钮
	 */
	$("#getPhoneVerCodeBtn").attr("disabled","disabled");
	$("#getPhoneVerCodeBtn").addClass("btn_sub");
	var phone = $("#ebccMobile").val();
	var sendDate = $("#sendDate").val();
	var validateCode_search = $("#validateCode_search").val();
	$.post("ydTraceManagerAction!sendPhoneVerCodeJson.action",{
		"ebccMobile" : phone,
		"sendDate" : sendDate,
		"total" : 1
		},
		function(data, status) {
			$("#codePhoneNotice").html(data.errorMsg);
			countDownPhoneNum = data.countdown;
			phoneTimer = setInterval(phoneCountdown, "1000");
		}
	);
}

var phoneTimer;

/**验证码计时
* @author 胡宇宙 huyuzhou
* @date 2016年3月3日15:41:44
* @update add
*/
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
		$("#verCode_tips").html("");
		clearTimeout(phoneTimer);
	}
}

function checkCountDownPhoneJson(){
	$.post("ydTraceManagerAction!checkCountDownPhoneJson.action",{
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
/**初始化时间
* @author 胡宇宙 huyuzhou
* @date 2016年3月3日15:41:44
* @update add
*/
function initDate(){
	var sendDateValue = $("#sendDateValue").val();
	for (var i = 1; i <=7; i++) {
		if(sendDateValue != null && sendDateValue != "" && sendDateValue != undefined && sendDateValue == addDate(getCurrentDate(),-i)){
			$("#sendDate").append("<option selected='selected' value='"+addDate(getCurrentDate(),-i)+"'>"+addDate(getCurrentDate(),-i)+"</option>");
		}else{
			$("#sendDate").append("<option value='"+addDate(getCurrentDate(),-i)+"'>"+addDate(getCurrentDate(),-i)+"</option>");
		}
	}
}

/**时间加减
* @author 胡宇宙 huyuzhou
* @date 2016年3月3日15:41:44
* @update add
*/
function addDate(date,days){ 
	var d = parseDate(date); 
	d.setDate(d.getDate()+days); 
	var month=d.getMonth()+1; 
	var day = d.getDate(); 
	if(month<10){ 
		month = "0"+month; 
	} 
	if(day<10){ 
		day = "0"+day; 
	} 
	var val = d.getFullYear()+"-"+month+"-"+day; 
	return val; 
}
/**
 * 解决IENewDate()带参数不识别问题
 * @param str
 * @returns {Date}
 */
function parseDate(str) { 
	str=str.split('-'); 
	var date=new Date(); 
	date.setUTCFullYear(str[0], str[1] - 1, str[2]); 
	date.setUTCHours(0, 0, 0, 0); 
	return date; 
} 
/**
 * 当前日期
 * @author 胡宇宙 huyuzhou
 * @date 2016年3月3日17:54:09
 * @update
 */
function getCurrentDate(){
	 var currentDate = new Date();
	    var year = currentDate.getFullYear();
	    var month = currentDate.getMonth() + 1;
	    var day = currentDate.getDate();
	    return year+"-"+month+"-"+day;	
}

function isEmpty(str){
	if($.trim(str) == '' || str == null){
		return true;
	}
	return false;
}
function setErrorMsg(id,msg){
	var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	$(id).html(rs);
}
