$(document).ready(function(){
	/**
	 * 初始化时间
	 */
	var startTime = $("#createTimeFrom").val();
	var endTime = $("#createTimeTo").val();
	if(isEmpty(startTime) && isEmpty(endTime)){
		$("#createTimeFrom").attr("value", getPreMonthDate());
		$("#createTimeTo").attr("value", getCurrentDate());
	}
	$("span.f_f15a22").click(function(){	
		$("#createTimeFrom").select();
	});

	if( isEmpty($("#keyValue").val())){
		init();
	}
	//关键字change
	$("#keyWord").change(function(){
		init();
	});
	
	 $("#keyValue").focus(function(){
		 var text = $(this).val();
		 if(text == '请输入订单号' || text == '请输入收货人' || text == '请输入货物名称'){
			 $("#keyValue").attr("value","")
		 }
	 });
	 
	 $("#keyValue").blur(function(){
		 var text = $(this).val();
		 if(isEmpty(text)){
			 init();
		 }
	 });
	
	/**
	 * 查询订单
	 */
	$("#queryOrders").click(function (){
		var keyWord = $("#keyWord").val();
		var KeyValue = $("#keyValue").val();
		if(KeyValue == null || KeyValue == ''){
			$("#orderNo").val('');
			$("#consignee").val('');
			$("#goodsName").val('');
		}else if(KeyValue == "请输入订单号" || KeyValue == "请输入收货人" || KeyValue == "请输入货物名称"){
			$("#orderNo").val('');
			$("#consignee").val('');
			$("#goodsName").val('');
		}else if(keyWord == 's_orderNo' && KeyValue != "请输入订单号" ) {
			$("#orderNo").val(KeyValue);
		}else if(keyWord == 's_consignee' && KeyValue != "请输入收货人" ) {
			$("#consignee").val(KeyValue);
	    }else if(keyWord == 's_goodsName' && KeyValue != "请输入货物名称" ) {
	    	$("#goodsName").val(KeyValue);
	    }
		$("#queryForm").submit();
	});
	
	/**
	 * 导出订单
	 */
	$("#exportAll").click(function(){
		var keyWord = $("#keyWord").val();
		var KeyValue = $("#keyValue").val();
		if(keyWord == 's_orderNo' && KeyValue != "请输入订单号" ) {
			$("#orderNo").val(KeyValue);
		}else if(keyWord == 's_consignee' && KeyValue != "请输入收货人" ) {
			$("#consignee").val(KeyValue);
	    }else if(keyWord == 's_goodsName' && KeyValue != "请输入货物名称" ) {
	    	$("#goodsName").val(KeyValue);
	    }
		var orderNo = $("#orderNo").val();
		var consignee = $("#consignee").val();
		var goodsName = $("#goodsName").val();
		var paymentWay =$("#paymentWay").val();
		var createTimeFrom = $("#createTimeFrom").val();
		var createTimeTo = $("#createTimeTo").val();
		var orderStatus = $("#orderStatus").val();
		
		window.location.href = "exportOrders.action?orderNo="+orderNo+"&consignee="+consignee
		+"&goodsName="+goodsName+"&paymentWay="+paymentWay+"&createTimeFrom="+createTimeFrom
		+"&createTimeTo="+createTimeTo+"&orderStatus="+orderStatus;
		
	});
	
	/**
	 * 批量打印
	 */
	$("#printAll").click(function(){
		if(orderIdList.length == 0){
			var inputs = $('input:checkbox');
			for (var i = 0; i < inputs.length; i++) {
				if (inputs[i].getAttribute("type") == "checkbox" && inputs[i].checked) {
					var orderId = inputs[i].getAttribute("id");
					if (validate(orderId)) {
						orderIdList += orderId + ",";
					}
				}
			}
		}
		if(orderIdList.length == 0){
			alert("请选择打印标签！");
		}
		//通过验证
		$.ajax({
			type : "post",
			url : "myOrdersAction!printOrders.action",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data : {
				"orderIdList":orderIdList,
			},
			success : function(data) {
				if (data.success) {
					//订单列表
					var orders = data.orders;
					//打印模型数组
					var models = new Array();
					for(var i=0;i<orders.length;i++){
						var order = orders[i];
						
						for(var j=0;j<order.labels.length;j++){
							//打印模型
							var model = {};
							//货号
							model.from_cargo =order.wayBill.substring(3)+"-"+order.labels.length;
							//运输方式  如果是定日达 条形码中第二个要为1，且图标要是D，字是“定日达”
							if(order.productType == "定日达"){
								model.from_drdchar="定日达";//定日达字
								//model.from_drdImg ="<img border='0' src='img/drd.png'>";//定日达图片
								model.from_drdD ="D";//定日达D图片
								//条形码第二位为1，货号从1到order.getEinoNumber()递增
								model.from_barImg = order.labels[j];
								//竖起的条形码
								model.from_barImg2 = order.labels[j];
								//隐藏掉条码值，下方条码文本代替
								model.from_code=order.labels[j].substring(1,7)+" "+ order.labels[j].substring(7,11)+" "+ order.labels[j].substring(11,15);
							}else{
								//条形码第二位为1，货号从1到order.getEinoNumber()递增
								model.from_barImg = order.labels[j];
								model.from_barImg2 = order.labels[j];
								//隐藏掉条码值，下方条码文本代替
								model.from_code=order.labels[j].substring(1,7)+" "+ order.labels[j].substring(7,11)+" "+ order.labels[j].substring(11,15);
							}
							//电商
							//model.from_dsImg="<img border='0' src='img/ds.png'>";
							model.from_ds="电商";
							
							//起运地
							model.from_shipperAddr = order.departure.substring(1);
							//箭头
//							model.from_arrowImg = "<img border='0' src='img/arrow.png'>";
							model.from_arrow ="=>";
							//目的地
							model.from_consigneeAddr = order.destination.substring(1); 
							//收货人姓名
							model.from_consignee = order.consigneeName;
							//收货人地址
							model.from_address = order.consigneeAddess;
							//收件人电话
							model.from_mobile =order.consigneePhone;
							//送货方式
							var sendCargoType = order.deliveryWay;
							if(sendCargoType=="DOORSTEP"){
								model.from_sendCargoType="送";
							}
							models.push(model);
						}
					 }
					//进行批量打印
					preview(models);
				} else {
					alert(data.message);
				}
			},
			serror : function(data) {
				alert("对不起，系统繁忙,请稍后操作！");
			}
		});
	});
	
});

function init(){
	var text = $("#keyWord").val();
	 if (text == 's_orderNo') {
		 $("#keyValue").attr("ov","请输入订单号")
		 $("#keyValue").attr("value","请输入订单号")
	 }else if (text == 's_consignee') {
		 $("#keyValue").attr("ov","请输入收货人")
		 $("#keyValue").attr("value","请输入收货人")
	 }else if (text == 's_goodsName') {
		 $("#keyValue").attr("ov","请输入货物名称")
		 $("#keyValue").attr("value","请输入货物名称")
	 }
}


/**
 * 打印标签
 * @param orderId
 */
function printSingle(orderId){
	
	var orderStatus = $("#orderStatus"+orderId).val();
	if(orderStatus == null || orderStatus == "" || orderStatus == 'undefined' || !('CANVASSING' == orderStatus)){
		alert("订单状态不是已揽货，不可以打印标签！");
		return;
	}
	var wayBill = $("#wayBill"+orderId).val();
	if(wayBill == null || wayBill == "" || wayBill == 'undefined'){
		alert("运单号为空，不可以打印标签！");
		return;
	}
	var departure = $("#departure"+orderId).val();
	if(departure == null || departure == "" || departure == 'undefined'){
		alert("起运地为空，不可以打印标签！");
		return;
	}
	var destination = $("#destination"+orderId).val();
	if(destination == null || destination == "" || destination == 'undefined'){
		alert("目的地为空，不可以打印标签！");
		return;
	}
	var productType = $("#productType"+orderId).val();
	if(productType == null || productType == "" || productType == 'undefined'){
		alert("运输方式为空，不可以打印标签！");
		return;
	}
	//通过验证
	$.ajax({
		type : "post",
		url : "myOrdersAction!printOrders.action",
		dataType : "json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data : {
			"orderIdList":orderId,
		},
		success : function(data) {
			if (data.success) {
				//订单列表
				var orders = data.orders;
				//打印模型数组
				var models = new Array();
				for(var i=0;i<orders.length;i++){
					var order = orders[i];
					
					for(var j=0;j<order.labels.length;j++){
						//打印模型
						var model = {};
						//货号
						model.from_cargo =order.wayBill.substring(3)+"-"+order.labels.length;
						//运输方式  如果是定日达 条形码中第二个要为1，且图标要是D，字是“定日达”
						if(order.productType == "定日达"){
							model.from_drdchar="定日达";//定日达字
							//model.from_drdImg ="<img border='0' src='img/drd.png'>";//定日达图片
							model.from_drdD ="D";//定日达D图片
							//条形码第二位为1，货号从1到order.getEinoNumber()递增
							model.from_barImg = order.labels[j];
							//竖起的条形码
							model.from_barImg2 = order.labels[j];
							//隐藏掉条码值，下方条码文本代替
							model.from_code=order.labels[j].substring(1,7)+" "+ order.labels[j].substring(7,11)+" "+ order.labels[j].substring(11,15);
						}else{
							//条形码第二位为1，货号从1到order.getEinoNumber()递增
							model.from_barImg = order.labels[j];
							model.from_barImg2 = order.labels[j];
							//隐藏掉条码值，下方条码文本代替
							model.from_code=order.labels[j].substring(1,7)+" "+ order.labels[j].substring(7,11)+" "+ order.labels[j].substring(11,15);
						}
						//电商
						//model.from_dsImg="<img border='0' src='img/ds.png'>";
						model.from_ds="电商";
						
						//起运地
						model.from_shipperAddr = order.departure.substring(1);
						//箭头
//						model.from_arrowImg = "<img border='0' src='img/arrow.png'>";
						model.from_arrow ="=>";
						//目的地
						model.from_consigneeAddr = order.destination.substring(1); 
						//收货人姓名
						model.from_consignee = order.consigneeName;
						//收货人地址
						model.from_address = order.consigneeAddess;
						//收件人电话
						model.from_mobile =order.consigneePhone;
						//送货方式
						var sendCargoType = order.deliveryWay;
						if(sendCargoType=="DOORSTEP"){
							model.from_sendCargoType="送";
						}
						models.push(model);
					}
				 }
				//进行批量打印
				preview(models);
			} else {
				alert(data.message);
			}
		},
		serror : function(data) {
			alert("对不起，系统繁忙,请稍后操作！");
		}
	});
}


/**
 * 选择可打印标签
 * @type Number
 */
var j = 1;//用于判断单击一次全选第二次全不选
var orderIdList = "";
function allSelected(einoStatus) {
	j++;
	var btn = 0;
	var orderId;
	var inputs = $('input:checkbox');
	//$("[name='checkbox']").removeAttr("checked");//取消全选     
	if (j % 2 == 0) {
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].getAttribute("type") == "checkbox") {
				orderId = inputs[i].getAttribute("id");
				if (einoStatus == 'CANVASSING' && validate(orderId)) {
					inputs[i].checked = true;
					orderIdList += orderId + ",";
					btn ++;
				}
			}
		}
	} else {
		for (var m = 0; m < inputs.length; m++) {
			if (inputs[m].getAttribute("type") == "checkbox") {
				orderId = inputs[m].getAttribute("id");
				if (einoStatus == "CANVASSING" && validate(orderId)) {
					inputs[m].checked = false;
				}
			}
		}
		btn = 0;
		orderIdList = "";
	}
	if (btn > 0) {
		$("#printAll").removeAttr("disabled");
		$("#printAll").removeClass("btn_sub");
	} else {
		$("#printAll").attr("disabled", true);
		$("#printAll").addClass("btn_sub");
	}
	
}

/**
 * 
 * @author 龙海仁
 * @date 2015年8月20日上午9:37:04
 * @update
 */
function checkPrint(){
	var k = 0;
	var inputs = $('input:checkbox');
	for (var i = 0; i < inputs.length; i++) {
		if (inputs[i].getAttribute("type") == "checkbox" && inputs[i].checked 
				&& "CANVASSING"==inputs[i].getAttribute("ver")) {
			k++;
		}
	}
	if(k==0){
		$("#printAll").attr("disabled", true);
		$("#printAll").addClass("btn_sub");
	}else if(k >= 1){
		$("#printAll").removeAttr("disabled");
		$("#printAll").removeClass("btn_sub");
	}
}

/**
 * 验证
 * @param orderId
 * @returns {Boolean}
 */
function validate(orderId){
	var orderStatus = $("#orderStatus"+orderId).val();
	if(orderStatus == null || orderStatus == "" || orderStatus == 'undefined' || !('CANVASSING' == orderStatus)){
		return false;
	}
	var wayBill = $("#wayBill"+orderId).val();
	if(wayBill == null || wayBill == "" || wayBill == 'undefined'){
		return false;
	}
	var departure = $("#departure"+orderId).val();
	if(departure == null || departure == "" || departure == 'undefined'){
		return false;
	}
	var destination = $("#destination"+orderId).val();
	if(destination == null || destination == "" || destination == 'undefined'){
		return false;
	}
	var productType = $("#productType"+orderId).val();
	if(productType == null || productType == "" || productType == 'undefined'){
		return false;
	}
	
	return true;
}

/**
 * 
 * @returns
 */
function selectAll(){
	var inputs = $('input:checkbox');
	if ($('input:checkbox').first().attr("checked")) {
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].getAttribute("type") == "checkbox") {
				inputs[i].checked = true;
			}
		}
	} else {
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].getAttribute("type") == "checkbox") {
				inputs[i].checked = false;
			}
		}
	}
}

/**
 * 删除未提交订单
 * @param orderId
 */
function deleteOrder(orderId){
	var orderNo = $("#OrderNum"+orderId).text();
	if($("#orderStatus"+orderId).val()=='DRAFT'){
		var r = confirm("确定删除"+$("#OrderNum"+orderId).text()+"订单吗?");
		if(r){
			$.ajax({
				type : "post",
				url : "myOrdersAction!deleteOrder.action",
				dataType : "json",
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data : {
					"orderId":orderId,
				},
				success : function(data) {
					if (data.success) {
						alert("删除订单"+orderNo+"成功！");
						history.go(0) ;
					} else {
						alert(data.message);
					}
				},
				serror : function(data) {
					alert("对不起，系统繁忙,请稍后操作！");
				}
			});
		}
		
	}else{
		alert("只能删除未提交订单！");
	}
}

/**
 * 取消未处理交订单
 * @param orderId
 */
function cancelOrder(orderId){
	var orderNo = $("#OrderNum"+orderId).text();
	if($("#orderStatus"+orderId).val()=='ADD'){
		var r = confirm("确定撤销"+$("#OrderNum"+orderId).text()+"订单吗?");
		if(r){
			$.ajax({
				type : "post",
				url : "myOrdersAction!cancelOrder.action",
				dataType : "json",
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data : {
					"orderId":orderId,
				},
				success : function(data) {
					if (data.success) {
						alert("撤销订单"+orderNo+"成功！");
						history.go(0) ;
					} else {
						alert(data.message);
					}
				},
				serror : function(data) {
					alert("对不起，系统繁忙,请稍后操作！");
				}
			});
		}
		
	}else{
		alert("只能撤销未处理订单！");
	}
}

function showOrderDetail(orderId) {
	//滚动鼠标
	$("#Order_layer_m").preventScroll();
	if(orderId == null || isNaN(orderId)){
		return ;
	}
	$.ajax({
		type : "post",
		url : "myOrdersAction!qeuryOrderDetail.action",
		dataType : "json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data : {
			"orderId":orderId,
		},
		success : function(data) {
			if (data.success) {
				var orderDetail = data.entity;
				//状态
				var status;
				if(orderDetail.einoStatus=='ADD'){
					status = '待受理';
				}else if(orderDetail.einoStatus=='SUBMIT'){
					status = '已受理';
				}else if(orderDetail.einoStatus=='ACCEPT'){
					status = '已接收';
				}else if(orderDetail.einoStatus=='CANVASSING'){
					status = '已开单';
				}else if(orderDetail.einoStatus=='DELIVER'){
					status = '已签收';
				}else if(orderDetail.einoStatus=='VOID'){
					status = '已撤销';
				}else if(orderDetail.einoStatus=='DRAFT'){
					status = '未提交';
				}
				//付款方式
				var payment;
				if(orderDetail.einoPaymentMethod=='ARRIVE_PAYMENT'){
					payment = '到付';
				}else if(orderDetail.einoPaymentMethod=='CASH'){
					payment = '现付';
				}else if(orderDetail.einoPaymentMethod=='Monthly_Statement'){
					payment = '月结';
				}
				//送货方式
				var delivery;
				if(orderDetail.einoShipperMethod=='SELF_TAKE'){
					delivery = '客户自提';
				}else if(orderDetail.einoShipperMethod=='DOORSTEP'){
					delivery = '送货上门';
				}else if(orderDetail.einoShipperMethod=='UPSTAIR'){
					delivery = '送货上楼';
				}else if(orderDetail.einoShipperMethod=='INSTALL'){
					delivery = '安装';
				}
				
				//show
				$("#d_orderNo").text(orderDetail.einoContractNo);
				//发货人信息
				$("#d_consignor").text(orderDetail.einoShipperEbsaContact);
				$("#d_consignor_phone").text(orderDetail.einoShipperEbsaMobile);
				$("#d_consignor_tel").text(orderDetail.einoShipperEbsaTel);
				$("#d_consignor_address").text(orderDetail.einoShipperEbpvName+orderDetail.einoShipperEbplNameCn+orderDetail.einoShipperAreaName+orderDetail.einoShipperEbsaAddress);
				$("#d_consignor_dot").text(orderDetail.einoEscoSecondName);
				//TODO
				$("#d_consignor_dot_info").text(orderDetail.companyMsg);
				//收货人信息
				$("#d_consignee").text(orderDetail.einoConsigneeEbsaContact);
				$("#d_consignee_phone").text(orderDetail.einoConsigneeEbsaMobile);
				$("#d_consignee_tel").text(orderDetail.einoConsigneeEbsaTel);
				$("#d_consignee_address").text(orderDetail.einoConsigneeEbpvName+orderDetail.einoConsigneeEbplNameCn+orderDetail.einoConsigneeEbrgNameCn+orderDetail.einoConsigneeEbsaAddress);
				//货物信息
				$("#d_goodsName").text(orderDetail.einoCargoName);
				$("#d_insured").text(orderDetail.einoInsurance + " 元");
				$("#d_package").text(orderDetail.einoPackage);
				$("#d_goods_count").text(orderDetail.einoNumber + " 件");
				$("#d_goods_wight").text(orderDetail.einoTotalWeight + " 千克");
				$("#d_goods_Volume").text(orderDetail.einoTotalVolume + " 立方米");
				//服务信息
				$("#d_product_type").text(orderDetail.einoProductTypeName);
				$("#d_payment_way").text(payment);
				$("#d_delivery_way").text(delivery);
				$("#d_dotice").text(orderDetail.einoSmsNotif=='Y'?'是':'否');
				$("#d_coll_amount").text(orderDetail.einoCollDeliveryAmount + " 元");
				$("#d_shipper_ebspNameCn").text(orderDetail.einoShipperEbspNameCn);
				$("#d_remark").text(orderDetail.einoRemark);
				//当前状态
				$("#d_order_status").text(status);
				//TODO
				/*$("#d_driver").text();
				$("#d_driver_phone").text();*/
				
				//签单返回信息
				var cda = orderDetail.einoSignBack;
				if(cda == "NOBACK"){
					cda = "无需返单";
				}else if(cda == "CUSTORIGINAL"){
					cda = "客户出库单原件返回";
				}else if(cda == "CUSTCOPY"){
					cda = "客户出库单传真返回";
				}else if(cda == "SIGNCOPY"){
					cda = "客户签收单传真返回";
				}else if(cda == "SIGNORIGINAL"){
					cda = "客户签收单原件返回";
				}
				$("#d_signBack").text(cda);
				
				//弹出层
				easyDialog.open({
					container : 'easyDialogWrapper',
					fixed : true
				});
			} else {
				alert(data.message);
			}
		},
		serror : function(data) {
			alert("对不起，系统繁忙,请稍后操作！");
		}
	});
	
}

/**
 * 当前日期
 * @author 龙海仁
 * @date 2015年8月14日上午10:07:23
 * @update
 */
function getCurrentDate(){
	 var currentDate = new Date();
	    var year = currentDate.getFullYear();
	    var month = currentDate.getMonth() + 1;
	    var day = currentDate.getDate();
	    return year+"-"+month+"-"+day;	
}
/**
 * 前一个月日期
 * @author 龙海仁
 * @date 2015年8月14日上午10:08:20
 * @update
 */
function getPreMonthDate(){
	var currentDate = new Date();
    var year = currentDate.getFullYear(); 
    var month = currentDate.getMonth();
    var day = currentDate.getDate();
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