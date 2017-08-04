var cancelSuccess = false;
$(document).ready(function() {
	var date = $('#date').attr('name');
	if(date!='null'){
		$.mobile.changePage("#doneOrder", {
			transition : "none",
			changeHash : false
		});
	}
	$("#doneOrder_li1").click(function() {
		$.mobile.changePage("#doneOrder", {
			transition : "none",
			changeHash : false
		});
	});
	$("#undoneOrder_li1").click(function() {
		$.mobile.changePage("#undoneOrder", {
			transition : "none",
			changeHash : false
		});
	});

	$("#orderQuery_li1").click(function() {
		$.mobile.changePage("#orderQuery", {
			transition : "none",
			changeHash : false
		});
	});
	$("#doneOrder_li2").click(function() {
		$.mobile.changePage("#doneOrder", {
			transition : "none",
			changeHash : false
		});
	});
	$("#undoneOrder_li2").click(function() {
		$.mobile.changePage("#undoneOrder", {
			transition : "none",
			changeHash : false
		});
	});

	$("#orderQuery_li2").click(function() {
		$.mobile.changePage("#orderQuery", {
			transition : "none",
			changeHash : false
		});
	});
	
	//详情返回按钮添加事件
	$("#detail_back").click(function() {
		$.mobile.changePage("#undoneOrder", {
			transition : "none",
			changeHash : false
		});
	});
	$(document).delegate('#order_dialog',
			'pagehide',
			function(event) {
				if (cancelSuccess) {
					var date = $('#date').val();
					var param = window.location.href.indexOf("?");
					if(param>0){
						var url = window.location.href
						.substring(0, window.location.href
								.lastIndexOf("/") + 1)
						+ "queryMyOrders.action?queryVo.startQueryTime=" + date;
						window.location.href = url;
					}else{
						window.location.href="queryMyOrders.action";
						
					}
				}
			});
	
	$('a[name="order_a"]').click(function(){
				var url = window.location.href
						.substring(0, window.location.href
								.lastIndexOf("/") + 1)
						+ "order.action";
				window.location.href = url;
	});
	$('#date').change(
			function() {
				var date = $('#date').val();
				var url = window.location.href
						.substring(0, window.location.href
								.lastIndexOf("/") + 1)
						+ "queryMyOrders.action?queryVo.startQueryTime=" + date;
				window.location.href = url;
			});
	$("#queryOrder_bt").click(function() {
						$("#queryOrder_div").empty();
						var orderNo = $("#queryOrderNo").val();
						if (orderNo.length == 0||orderNo==''){
							$("#queryOrder_div").append("<p style='line-height:30px;text-align: center; font-size:1em;color:red;'>请输入订单号</p>");
							return;
						}
						$.ajax({
							url : "myOrdersMgtAction!queryOrderByOrderNo.action",
							type : "POST",
							dataType : "json",
							data : {
								"queryVo.orderNo":orderNo
							},
							success : function(data,textStatus) {
								var orderVo = data.orderVo;
								if (data.success&&orderVo!=null) {
									var orderStatus = "";
									var buttonHtml = "";
									var waybillNoHtml = "";
									if (orderVo.orderStatus == "ADD") {
										orderStatus = "待受理";
										buttonHtml = "<div class='tc'><button id = 'queryOrder_cancel_bt' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>撤销</button> <button  id = 'queryOrder_edit_bt' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>修改</button><button name='queryDetail' id='"+orderVo.orderId+"' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>查看</button></div>";
									} else if (orderVo.orderStatus == "SUBMIT"
											|| orderVo.orderStatus == "ACCEPT") {
										orderStatus = "已处理";
										buttonHtml = "<div class='tc'><button id = 'queryOrder_cancel_bt' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>撤销</button> <button  id = 'queryOrder_edit_bt' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>修改</button><button name='queryDetail' id='"+orderVo.orderId+"' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>查看</button></div>";
									} else if (orderVo.orderStatus == "CANVASSING") {
										orderStatus = "已揽收";
										buttonHtml = "<div class='tc'><button  id = 'queryOrder_trace_bt' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>运单跟踪</button><button name='queryDetail' id='"+orderVo.orderId+"' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>查看</button></div>";
										waybillNoHtml = "运单号："
												+ orderVo.wayBill
												+ "</br>";
									} else if (orderVo.orderStatus == "DELIVER") {
										buttonHtml = "<div class='tc'><button id = 'queryOrder_trace_bt' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>运单跟踪</button><button name='queryDetail' id='"+orderVo.orderId+"' data-inline='true' data-theme = 'h' style='color:#fff;width:20%;'>查看</button></div>";
										waybillNoHtml = "运单号："
												+ orderVo.wayBill
												+ "</br>";
										orderStatus = "已签收";
									} else if (orderVo.orderStatus == "VOID") {
										orderStatus = "已取消";
									}
									
									$("#queryOrder_div").append(
													" <div class='order_manager_list'><div clsss='order_manager_list_info' id = 'queryOrder_listview'>订单号："
													+ orderVo.contractNo
													+ "&nbsp;&nbsp;&nbsp;收货人："
													+ "<span>"+orderVo.consigneeName+"</span>"
													+ "<br /> 收货人地址："
													+ "<span>"+orderVo.consigneeAddess+"</span>"
													+ "<br /> 下单时间："
													+ orderVo.orderDate
													+ "<br /> 订单状态："
													+ orderStatus
													+ "<br />"
													+ waybillNoHtml
													+ buttonHtml
													+ "</div></div>");
									$("#queryOrder_div").trigger("create");
									//详情
									$("button[name='queryDetail']").click(function() {
										$.get('myOrdersMgtAction!queryMyOrderByOrderId.action?orderId='+ $(this).attr('id'),function(data){
										},'json').done(function(data){
											initDeatil(data);
										}).fail(function(){
											errorDialog();
										})
										$.mobile.changePage("#detail_page", {
											transition : "none",
											changeHash : false
										});
									});
									// 撤消按钮添加事件
									$("#queryOrder_cancel_bt").click(
													function() {
														cancelOrderByOrderNo(orderVo.orderId,orderVo.contractNo);
													});
									// 修改按钮添加事件
									$("#queryOrder_edit_bt").click(
													function() {
														var url = window.location.href.substring(0,window.location.href.lastIndexOf("/") + 1)+ "order.action?orderId="+ orderVo.orderId;
														window.location.href = url;
													});

									// 运单跟踪按钮添加事件
									$("#queryOrder_trace_bt").click(
													function() {
														var url = window.location.href
																.substring(0,window.location.href.lastIndexOf("/") + 1)
																+ "../toGoodsTracePage.action?waybill="+orderVo.wayBill
														window.location.href = url;
													});

								} else {
									$("#queryOrder_div").append("<p style='line-height:30px;text-align: center; font-size:1em;color:red;'>查询不到您输入的订单信息,检查是否输入有误</p>")
								}

							},
							error : function() {
								cancelSuccess = false;
								errorDialog();
							}
						});
					});
	//查看详情
	$('a[name="orderDetail"]').on('click',function(){
		var orderId = $(this).attr('id');
		$.get('myOrdersMgtAction!queryMyOrderByOrderId.action?orderId='+ orderId,function(data){
		},'json').done(function(data){
			initDeatil(data);
		}).fail(function(){
			errorDialog();
		})
		$.mobile.changePage("#detail_page", {
			transition : "none",
			changeHash : false
		});
	});
	
	var undoneNo = 1;
	var doneNo = 1;
	//滚动到底部
	$(document).on('scroll',function() {
		if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
			var $more = $('.ui-page-active')
			,$pageid = $more.attr('id')
			,$doneType;
			$doneType =$pageid.substring(0,$pageid.indexOf('Order'));
			if($doneType=='undone'){
				undoneNo+=1;
				ajaxRequestData(undoneNo,$doneType);
			}else if($doneType=='done'){
				doneNo+=1;
				ajaxRequestData(doneNo,$doneType);
			}
		}
	});
	
	//公共请求
	function ajaxRequestData(no,$doneType){
		$.mobile.loading('show');
		$.post('queryMyOrders.action',{"doneType":$doneType,"pageNo":no},function(data){
		},'json').done(function(data){
//			$('#'+$doneType+'_more').find('font').html('正在加载');
//			$('#'+$doneType+'_more').fadeIn(1000);
			var stautsTemplate = '',wayBillTemplate = '',buttonTemplate = '';
			if(data.undoneOrders!=null){
				if(data.undoneOrders.length!=0){
					$.each(data.undoneOrders,function(i,v){
						if(v.orderStatus=='ADD'){
							stautsTemplate = '待受理';
							buttonTemplate = '<a href="javascript:void(0)"id="'+v.orderId+'" data-inline="true" onclick="cancelOrder(this)">撤销</a>'
								+'<a href="javascript:void(0)" id="'+v.orderId+'" data-inline="true" onclick="modifyOrder(this)">修改</a>'
						}else if(v.orderStatus=='ACCEPT'||v.orderStatus=='SUBMIT'){
							stautsTemplate = '已受理';
						}else if(v.orderStatus=='CANVASSING'){
							stautsTemplate = '已开单';
							buttonTemplate='<a href="wayBillDetail.action?queryWaybillEntity.transNo='+v.wayBill+'" data-ajax="false" data-inline="true" class="ui-link">查看运单信息</a>'
						}
						if(v.wayBill!=null&&v.wayBill!=''){
							wayBillTemplate = "运单号:"+v.wayBill;
						}
						$('#'+$doneType+'_more').before(queryMoreOrder(v,stautsTemplate,wayBillTemplate,buttonTemplate))
					});
				}else{
					
				}
			}else if(data.doneOrders!=null){
				if(data.doneOrders.length!=0) {
					$.each(data.doneOrders,function(i,v){
						if(v.orderStatus=='VOID'){
							stautsTemplate = '已取消';
						}else if(v.orderStatus=='DELIVER'){
							stautsTemplate = '已签收';
							buttonTemplate='<a href="wayBillDetail.action?queryWaybillEntity.transNo='+v.wayBill+'" data-ajax="false" data-inline="true" class="ui-link">查看运单信息</a>'
						}
						if(v.wayBill!=null&&v.wayBill!=''){
							wayBillTemplate = '运单号：'+v.wayBill;
						}
						$('#'+$doneType+'_more').before(queryMoreOrder(v,stautsTemplate,wayBillTemplate,buttonTemplate))
					});
				}else{
				}
			}
		}).fail(function(){
			
		}).always(function(){
			$.mobile.loading('hide');
		})
	};
	
	//加载更多订单列表模板
	function queryMoreOrder(value,stautsTemplate,wayBillTemplate,buttonTemplate){
		var orderTemplate = '<div class="order_manager_list">'
			+'<div class="order_manager_list_info">'
			+'<p>订单号：<span id="contractNo">'+value.contractNo+'</p>'
			+'<p>收货人：'+value.consigneeName+'</p>'
			+'<p>收货人地址：'+value.consigneeAddess+'</p>'
			+'<p>下单时间：'+value.orderDate+'</p>'
			+'<p>'
			+'订单状态：'+stautsTemplate+'</br>'
			+wayBillTemplate
			+'</p>'
			+'</div>'
			+'<div class="order_manager_list_btn tc clearfix">'
			+buttonTemplate
			+'<a href="javascript:void(0)" name="orderDetail"id="'+value.orderId+'" data-inline="true" data-theme = "h" >查看</a>'
			+'</div>'
			+'</div>'
			//绑定查看详情
			$('a[name="orderDetail"]').on('click',function(){
				var orderId = $(this).attr('id');
				$.get('myOrdersMgtAction!queryMyOrderByOrderId.action?orderId='+ orderId,function(data){
				},'json').done(function(data){
					initDeatil(data);
				}).fail(function(){
					errorDialog();
				})
				$.mobile.changePage("#detail_page", {
					transition : "none",
					changeHash : false
				});
			});
		return orderTemplate;
	};
	
	function initDeatil(data){
		$('#detail_con').find('h4>span,li>span,td>span').each(function(){
			var $name = $(this).attr('name');
			var orderDetail = data.order;
			if (orderDetail.hasOwnProperty($name)) {
				if($name=='einoStatus'){
					var status;
					if(orderDetail[$name]=='ADD'){
						status = '待受理';
					}else if(orderDetail[$name]=='SUBMIT'){
						status = '已受理';
					}else if(orderDetail[$name]=='ACCEPT'){
						status = '已接收';
					}else if(orderDetail[$name]=='CANVASSING'){
						status = '已开单';
					}else if(orderDetail[$name]=='DELIVER'){
						status = '已签收';
					}else if(orderDetail[$name]=='VOID'){
						status = '已撤销';
					}else if(orderDetail[$name]=='DRAFT'){
						status = '未提交';
					}
					$(this).html("<font color='red'>"+status+"</font>");
				}else if($name=='einoPaymentMethod'){
					//付款方式
					var payment;
					if(orderDetail[$name]=='ARRIVE_PAYMENT'){
						payment = '到付';
					}else if(orderDetail[$name]=='CASH'){
						payment = '现付';
					}else if(orderDetail[$name]=='Monthly_Statement'){
						payment = '月结';
					}
					$(this).html(payment);
				}else if($name=="einoShipperMethod"){
					//送货方式
					var delivery;
					if(orderDetail[$name]=='SELF_TAKE'){
						delivery = '客户自提';
					}else if(orderDetail[$name]=='DOORSTEP'){
						delivery = '送货上门';
					}else if(orderDetail[$name]=='UPSTAIR'){
						delivery = '送货上楼';
					}
					$(this).html(delivery);
				}else if($name=='einoSmsNotif'){
					//短信
					$(this).html(orderDetail[$name]=='YES'?'是':'否');
				}else if($name=='einoShipperEbsaTel'){
					if((orderDetail.einoShipperEbsaAreaCode!=null&&orderDetail.einoShipperEbsaAreaCode.length!=0)&&(orderDetail.einoShipperEbsaTel!=null&&orderDetail.einoShipperEbsaTel.length!=0)){
						//发货人固话
						$(this).html(orderDetail.einoShipperEbsaAreaCode+'-'+orderDetail.einoShipperEbsaTel);
					}else{
						$(this).html('')
					}
				}else if($name=='einoConsigneeEbsaTel'){
					if((orderDetail.einoConsigneeEbsaAreaCode!=null&&orderDetail.einoConsigneeEbsaAreaCode.length!=0)&&(orderDetail.einoConsigneeEbsaTel!=null&&orderDetail.einoConsigneeEbsaTel.length!=0)){
						//收货人固话
						$(this).html(orderDetail.einoConsigneeEbsaAreaCode+'-'+orderDetail.einoConsigneeEbsaTel);
					}else{
						$(this).html('')
					}
				}else if($name=='einoSignBack'){
					//签单返回信息
					var cda;
					if(orderDetail[$name] == "NOBACK"){
						cda = "无需返单";
					}else if(orderDetail[$name] == "CUSTORIGINAL"){
						cda = "客户出库单原件返回";
					}else if(orderDetail[$name] == "CUSTCOPY"){
						cda = "客户出库单传真返回";
					}else if(orderDetail[$name] == "SIGNCOPY"){
						cda = "客户签收单传真返回";
					}else if(orderDetail[$name] == "SIGNORIGINAL"){
						cda = "客户签收单原件返回";
					}
					$(this).html(cda);
				}else if($name=='einoInsurance'){
					$(this).html(orderDetail[$name]+"元");
				}else if($name=='einoNumber'){
					$(this).html(orderDetail[$name]+"件");
				}else if($name=='einoTotalWeight'){
					$(this).html(orderDetail[$name]+"千克");
				}else if($name=='einoTotalVolume'){
					$(this).html(orderDetail[$name]+"立方米");
				}else if($name=='einoCollDeliveryAmount'){
					$(this).html(orderDetail[$name]+"元");
				}else{
					$(this).html(orderDetail[$name]);
				}
			}
			$('span[name="shipperAddress"]').html(orderDetail.einoShipperEbpvName+orderDetail.einoShipperEbplNameCn+orderDetail.einoShipperAreaName+orderDetail.einoShipperEbsaAddress)
			$('span[name="consigneeAddress"]').html(orderDetail.einoConsigneeEbpvName+orderDetail.einoConsigneeEbplNameCn+orderDetail.einoConsigneeEbrgNameCn+orderDetail.einoConsigneeEbsaAddress)
		})
	}
});
// 取消订单事件
function cancelOrder(e) {
	var orderId = e.getAttribute("id");
	var contractNo = $('#contractNo').text();
	$("#dialg_header").html("撤销订单");
	$("#order_dialog_con").empty();
	$("#order_dialog_con").append("<h>是否要撤销订单号："
							+ contractNo
							+ "?</h><p  style='color: red;'>此操作不可恢复</p>"
							+ "<div align='center'>"
							/*
							 * <button id='' data-inline='true'
							 * data-icon='delete'>取消</button>
							 */
							+ "<button data-inline='true' data-theme ='h' id='sure_cancel_order' style='color:#fff;'>确认</button></div>");
	$("#order_dialog_con").trigger("create");
	$("#sure_cancel_order").click(function() {
		$.ajax({
			url : "myOrdersMgtAction!cancelOrder.action",
			type : "POST",
			dataType : "json",
			data : {
				"orderId" : orderId
			},
			success : function(data, textStatus) {
				$("#order_dialog_con").empty();
				if (data.success) {
					cancelSuccess = true;
					$("#dialg_header").html("撤消成功");
					$("#order_dialog_con").append(
							"<h>撤销订单号:" +contractNo+ "成功</h>");
				} else {
					cancelSuccess = false;
					$("#dialg_header").html("撤消失败");
					$("#order_dialog_con").append("<h>" + data.message+ "</h>");
				}
				$.mobile.changePage('#order_dialog','flip', true, true);
			},
			error : function() {
				cancelSuccess = false;
				errorDialog();
			}
		});
	});
	$.mobile.changePage('#order_dialog', 'flip', true, true);

}
// 按单号查询订单号界面撤销订单
function cancelOrderByOrderNo(orderId,contractNo) {
	$("#dialg_header").html("撤销订单");
	$("#order_dialog_con").empty();
	$("#order_dialog_con").append("<h>是否要撤销订单号："
							+ contractNo
							+ "?</h><p  style='color: red;'>此操作不可恢复</p>"
							+ "<div align='center'>"
							/*
							 * <button id='' data-inline='true'
							 * data-icon='delete'>取消</button>
							 */
							+ "<button data-inline='true' data-theme = 'h'  id='sure_cancel_order' style='color:#fff;'>确认</button></div>");
	$("#order_dialog_con").trigger("create");
	$("#sure_cancel_order").click(function() {
		$.ajax({
			url : "myOrdersMgtAction!cancelOrder.action",
			type : "POST",
			dataType : "json",
			data : {
				"orderId" : orderId
			},
			success : function(data, textStatus) {
				$("#order_dialog_con").empty();
				if (data.success) {
					cancelSuccess = true;
					$("#dialg_header").html("撤消成功");
					$("#order_dialog_con").append(
							"<h>撤销订单号:" +contractNo+ "成功</h>");
				} else {
					cancelSuccess = false;
					$("#dialg_header").html("撤消失败");
					$("#order_dialog_con").append("<h>" + data.message+ "</h>");
				}
				$.mobile.changePage('#order_dialog','flip', true, true);
			},
			error : function() {
				cancelSuccess = false;
				errorDialog();
			}
		});
	});
	$.mobile.changePage('#order_dialog', 'flip', true, true);

}
// 修改订单事件
function modifyOrder(e) {
	var orderId = e.getAttribute("id");
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "order.action?orderId=" + orderId;
	window.location.href = url;
}
// 未完成订单列表中订单明细事件
function orderDetail(e) {
	var orderId = e.getAttribute("id");
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "orderDetail.action?orderId=" + orderId;
	window.location.href = url;
}
// 已完成订单列表中订单明细事件
function doneOrderDetail(e) {
	var id = e.getAttribute("id");
	var index = id.substring(0, id.lastIndexOf("_done_order_detail"));
	var orderNo = $("#" + index + "done_orderNo_sp").text();
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "orderDetail.action?order.orderNo=" + orderNo;
	window.location.href = url;
}
//订单列表中运单跟踪按钮事件
function searchWaybill(e) {
	var waybillNo = e.getAttribute("id");
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "../toGoodsTracePage.action?waybill=" + waybillNo;
	window.location.href = url;
}
function errorDialog() {
	//$.mobile.changePage('#err_dialog', 'flip', true, true);
	/* alert("error"); */
}