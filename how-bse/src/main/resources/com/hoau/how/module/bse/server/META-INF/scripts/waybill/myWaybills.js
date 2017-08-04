
$(document).ready(function() {
	//首次加载
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	
	if(isEmpty(startTime) && isEmpty(endTime)){
		$("#startTime").attr("value", fmtPreMonth());
		$("#endTime").attr("value", fmtzCurDate());
	}
	
	if( isEmpty($("#fieldValue").val())){
		init();
	}
	
	//监听关键字。根据选择更新提示信息
	$("#fieldType").change(function(){
		init();
	});
	
    	
	 $("#fieldValue").focus(function(){
		 var text = $(this).val();
		 if(text == '请输入运单号' || text == '请输入收货人' || text == '请输入货物名称'){
			 $("#fieldValue").attr("value","")
		 }
	 });
	 
	 $("#fieldValue").blur(function(){
		 var text = $(this).val();
		 if(isEmpty(text)){
			 init();
		 }
	 });
	 
	$("#queryWaybill").click(function(){
		$("#queryForm").submit();	
	});
	
	$("span.f_f15a22").click(function(){	
		$("#startTime").select();
	});
	

});

function init(){
	 var text = $("#fieldType").val();
	 if (text == 'TRANS_NO') {
		 $("#fieldValue").attr("ov","请输入运单号")
		 $("#fieldValue").attr("value","请输入运单号")
	 }else if (text == 'CONSIGNEE') {
		 $("#fieldValue").attr("ov","请输入收货人")
		 $("#fieldValue").attr("value","请输入收货人")
	 }else if (text == 'CARGO_NAME') {
		 $("#fieldValue").attr("ov","请输入货物名称")
		 $("#fieldValue").attr("value","请输入货物名称")
	 }
}

//显示运单明细
function showWaybill(value){
	$(".hwzz_b_list").css("display","none");
	$("#"+value).css("display","block");
	easyDialog.open({
		container : 'easyDialogWrapper',
		fixed : true
	});
};

//当天
function fmtzCurDate(){
	 var currentDate = new Date();// 当前日期 
	    var year = currentDate.getFullYear();// 当前年份 
	    var month = currentDate.getMonth() + 1;// 当前月份 
	    var day = currentDate.getDate();// 当前天数 
	    return year+"-"+month+"-"+day;	
}
//前一个月
function fmtPreMonth(){
	var currentDate = new Date();// 当前日期 
    var year = currentDate.getFullYear();// 当前年份 
    var month = currentDate.getMonth();// 当前月份 
    var day = currentDate.getDate();// 当前天数 
    if(month == 0) {
    	year = year -1;
    	month = 12;
    }     
    d = new Date(Date.parse( month + "/" + day + "/" +year) + (86400000)); 	
    return d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();   
}

function isEmpty(str){
	if($.trim(str) == '' || str == null){
		return true;
	}
	return false;
}

