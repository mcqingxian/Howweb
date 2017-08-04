var cancelSuccess = false;
$(document).ready(function() {
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
					$(document).delegate('#order_dialog',
							'pagehide',
							function(event) {
								if (cancelSuccess) {
									var date = $('#date').val();
									var url = window.location.href
											.substring(0, window.location.href
													.lastIndexOf("/") + 1)
											+ "queryOrder.action?date=" + date+"&v="+new Date().getTime();
									window.location.href = url;
								}
							});
					
					$('#order_a').click(function(){
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
										+ "queryOrder.action?date=" + date+"&v="+new Date().getTime();
								window.location.href = url;
							});
					$("#queryOrder_bt").click(
									function() {
										$("#queryOrder_div").empty();
										var orderNo = $("#queryOrderNo").val();
										if (orderNo.length == 0) {
											return;
										}
										$.ajax({
													url : "queryOrderByNo.action",
													type : "POST",
													dataType : "json",
													data : {
														"order.orderNo" : orderNo
													},
													success : function(data,
															textStatus) {
														var order = data.order;
														if (!data.exception) {
															var orderStatus = "";
															var buttonHtml = "";
															var waybillNoHtml = "";
															if (data.order.orderStatus == "ADD") {
																orderStatus = "待受理";
																buttonHtml = "<div align='center'><button id = 'queryOrder_cancel_bt' data-inline='true' data-theme = 'h'>撤销</button> <button  id = 'queryOrder_edit_bt' data-inline='true' data-theme = 'h'>修改</button></div>";
															} else if (data.order.orderStatus == "SUBMIT"
																	|| data.order.orderStatus == "ACCEPT") {
																orderStatus = "已处理";
																buttonHtml = "<div align='center'><button id = 'queryOrder_cancel_bt' data-inline='true' data-theme = 'h'>撤销</button> <button  id = 'queryOrder_edit_bt' data-inline='true' data-theme = 'h'>修改</button></div>";
															} else if (data.order.orderStatus == "CANVASSING") {
																orderStatus = "已揽收";
																buttonHtml = "<div align='center'><button  id = 'queryOrder_trace_bt' data-inline='true' data-theme = 'h'>运单跟踪</button></div>";
																waybillNoHtml = "运单号："
																		+ data.order.waybillNo
																		+ "</br>";
															} else if (data.order.orderStatus == "DELIVER") {
																buttonHtml = "<div align='center'><button id = 'queryOrder_trace_bt' data-inline='true' data-theme = 'h'>运单跟踪</button></div>";
																waybillNoHtml = "运单号："
																		+ data.order.waybillNo
																		+ "</br>";
																orderStatus = "已签收";
															} else if (data.order.orderStatus == "VOID") {
																orderStatus = "已取消";
															}
															$("#queryOrder_div")
																	.append(
																			" <div data-role='collapsible' data-collapsed-icon='chevron-circle-down' data-expanded-icon='chevron-circle-up'><h1>收货人："
																					+ order.consigneeName
																					+ "  订单号："
																					+ order.orderNo
																					+ "</h1><ul data-role='listview' id = 'queryOrder_listview'><li>订单号："
																					+ order.orderNo
																					+ "<span>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' id = 'queryOrder_detail_a'>详情</a></span><br />收货人："
																					+ order.consigneeName
																					+ "<br /> 收货人地址："
																					+ order.consigneeAddress
																					+ "<br /> 下单时间："
																					+ order.orderTime
																					+ "<br /> 订单状态："
																					+ orderStatus
																					+ "<br />"
																					+ waybillNoHtml
																					+ buttonHtml
																					+ "</li></ul></div>");
															$("#queryOrder_div").trigger("create");
															$("#queryOrder_detail_a").click(
																			function() {
																				var url = window.location.href
																						.substring(
																								0,
																								window.location.href
																										.lastIndexOf("/") + 1)
																						+ "orderDetail.action?order.orderNo="
																						+ order.orderNo;
																				window.location.href = url;

																			});
															// 撤消按钮添加事件
															$("#queryOrder_cancel_bt").click(
																			function() {
																				cancelOrderByOrderNo(order.orderNo);
																			});
															// 修改按钮添加事件
															$("#queryOrder_edit_bt").click(
																			function() {
																				var url = window.location.href
																						.substring(
																								0,
																								window.location.href
																										.lastIndexOf("/") + 1)
																						+ "modifyOrder.action?order.orderNo="
																						+ order.orderNo;
																				window.location.href = url;
																			});

															// 运单跟踪按钮添加事件
															$("#queryOrder_trace_bt").click(
																			function() {
																				var url = window.location.href
																						.substring(
																								0,
																								window.location.href
																										.lastIndexOf("/") + 1)
																						+ "toGoodsTracePage.action?waybill="
																						+ order.waybillNo;
																				window.location.href = url;
																			});

														} else {
															$("#dialg_header").html("查询失败");
															$("#order_dialog_con").empty();
															$("#order_dialog_con").append(
																			"<h>"
																					+ data.errMsg
																					+ "</h>");
															$.mobile.changePage(
																			'#order_dialog',
																			'flip',
																			true,
																			true);
														}

													},
													error : function() {
														cancelSuccess = false;
														errorDialog();
													}
												});
									});
				});
// 取消订单事件
function cancelOrder(e) {
	var btId = e.getAttribute("id");
	var index = btId.substring(0, btId.length - 10);
	var orderNo = $("#" + index + "_orderNo_sp").text();
	$("#dialg_header").html("撤销订单");
	$("#order_dialog_con").empty();
	$("#order_dialog_con")
			.append(
					"<h>是否要撤销订单号："
							+ orderNo
							+ "?</h><p  style='color: red;'>此操作不可恢复</p>"
							+ "<div align='center'>"
							/*
							 * <button id='' data-inline='true'
							 * data-icon='delete'>取消</button>
							 */
							+ "<button data-inline='true' data-theme = 'h' id='sure_cancel_order'>确认</button></div>");
	$("#order_dialog_con").trigger("create");
	$("#sure_cancel_order")
			.click(
					function() {
						$
								.ajax({
									url : "cancelOrder.action",
									type : "POST",
									dataType : "json",
									data : {
										"order.orderNo" : orderNo
									},
									success : function(data, textStatus) {
										if (!data.exception) {
											cancelSuccess = true;
											$("#dialg_header").html("撤消成功");
											$("#order_dialog_con").empty();
											$("#order_dialog_con").append(
													"<h>撤销订单号" + data.value
															+ "成功</h>");
										} else {
											cancelSuccess = false;
											$("#dialg_header").html("撤消失败");
											$("#order_dialog_con").empty();
											$("#order_dialog_con").append(
													"<h>" + data.errMsg
															+ "</h>");
										}
										$.mobile.changePage('#order_dialog',
												'flip', true, true);
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
function cancelOrderByOrderNo(orderNo) {
	$("#dialg_header").html("撤销订单");
	$("#order_dialog_con").empty();
	$("#order_dialog_con")
			.append(
					"<h>是否要撤销订单号："
							+ orderNo
							+ "?</h><p  style='color: red;'>此操作不可恢复</p>"
							+ "<div align='center'>"
							/*
							 * <button id='' data-inline='true'
							 * data-icon='delete'>取消</button>
							 */
							+ "<button data-inline='true' data-theme = 'h'  id='sure_cancel_order'>确认</button></div>");
	$("#order_dialog_con").trigger("create");
	$("#sure_cancel_order")
			.click(
					function() {
						$
								.ajax({
									url : "cancelOrder.action",
									type : "POST",
									dataType : "json",
									data : {
										"order.orderNo" : orderNo
									},
									success : function(data, textStatus) {
										if (!data.exception) {
											cancelSuccess = true;
											$("#dialg_header").html("撤消成功");
											$("#order_dialog_con").empty();
											$("#order_dialog_con").append(
													"<h>撤销订单号" + data.value
															+ "成功</h>");
										} else {
											cancelSuccess = false;
											$("#dialg_header").html("撤消失败");
											$("#order_dialog_con").empty();
											$("#order_dialog_con").append(
													"<h>" + data.errMsg
															+ "</h>");
										}
										$.mobile.changePage('#order_dialog',
												'flip', true, true);
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
	var btId = e.getAttribute("id");
	var index = btId.substring(0, btId.length - 8);
	var orderNo = $("#" + index + "_orderNo_sp").text();
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "modifyOrder.action?order.orderNo=" + orderNo;
	window.location.href = url;
}
// 未完成订单列表中订单明细事件
function orderDetail(e) {
	var id = e.getAttribute("id");
	var index = id.substring(0, id.lastIndexOf("_order_detail"));
	var orderNo = $("#" + index + "_orderNo_sp").text();
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "orderDetail.action?order.orderNo=" + orderNo;
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
// 已完成订单列表中运单跟踪按钮事件
function doneSearchWaybill(e) {
	var btId = e.getAttribute("id");
	var index = btId.substring(0, btId.indexOf("_done_waybillNoSearch_bt"));
	var waybillNo = $("#" + index + "_done_waybillNo_sp").text();
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "toGoodsTracePage.action?waybill=" + waybillNo;
	window.location.href = url;
}
// 未完成订单列表中运单跟踪按钮事件
function searchWaybill(e) {
	var btId = e.getAttribute("id");
	var index = btId.substring(0, btId.indexOf("_waybillNoSearch_bt"));
	var waybillNo = $("#" + index + "_waybillNo_sp").text();
	var url = window.location.href.substring(0, window.location.href
			.lastIndexOf("/") + 1)
			+ "toGoodsTracePage.action?waybill=" + waybillNo;
	window.location.href = url;
}
function errorDialog() {
	//$.mobile.changePage('#err_dialog', 'flip', true, true);
	/* alert("error"); */
}