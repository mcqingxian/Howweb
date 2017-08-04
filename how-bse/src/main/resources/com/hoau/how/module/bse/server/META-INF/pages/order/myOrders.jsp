<%@page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有订单</title>
<%@include file="../head.jsp" %>
<script language="javascript" type="text/javascript" src="${scripts}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${scripts}/print/LodopFuncs.js"></script>
<script type="text/javascript" src="${scripts}/print/printLabel.js"></script>

<object id="LODOP_OB"	classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0
		pluginspage="${scripts}/print/install_lodop.exe"></embed>
</object>
<script type="text/javascript" src="${scripts}/order/myOrders.js"></script>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".subNav").click(function(){		
		$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
		// 修改数字控制速度， slideUp(500)控制卷起速度
		$(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
	})	
});

</script>
</head>
<body>
<%@include file="../top.jsp" %>

<div class="content">
	<div class="p_w">
	<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/my_banner.jpg" width="770" /></div>
			<div class="news_detail pb20">
				<h1 class="news_title">所有订单</h1>
				
				<div class="order_search01">
					<form action="myOrdersAction!queryMyOrders.action" method="post" id="queryForm">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="100" align="right">关键字：</td> 
							<td width="278">
								<select name="queryVo.keyWord" id="keyWord">
									<option value="s_orderNo" <s:if test="queryVo.keyWord == 's_orderNo'">selected="selected"</s:if>>订单号</option>
									<option value="s_consignee" <s:if test="queryVo.keyWord == 's_consignee'">selected="selected"</s:if>>收货人</option>
									<option value="s_goodsName" <s:if test="queryVo.keyWord == 's_goodsName'">selected="selected"</s:if>>货物名称</option>
								</select>
								<input name="" id="keyValue" type="text" class="input w125 grays" ov="请输入订单号"
								<s:if test="queryVo.orderNo != null and queryVo.orderNo != ''" >value="${queryVo.orderNo }"</s:if>
								<s:elseif test="queryVo.consignee != null and queryVo.consignee != ''">value="${queryVo.consignee }"</s:elseif>
								<s:elseif test="queryVo.goodsName != null and queryVo.goodsName != ''">value="${queryVo.goodsName }"</s:elseif>
								<s:elseif test="queryVo.keyWord == 's_orderNo'">value="请输入订单号"</s:elseif>
								<s:elseif test="queryVo.keyWord == 's_consignee'">value="请输入收货人"</s:elseif>
								<s:elseif test="queryVo.keyWord == 's_goodsName'">value="请输入货物名称"</s:elseif>
								/>
								<input name="queryVo.orderNo" id="orderNo" type="hidden" />
								<input name="queryVo.consignee" id="consignee" type="hidden" />
								<input name="queryVo.goodsName" id="goodsName" type="hidden" />
							</td>
							<td width="100" align="right">付款方式：</td>
							<td>
								<select name="queryVo.paymentWay" id="paymentWay" >
									<option value="">全部</option>
									<option value="CASH" <s:if test="queryVo.paymentWay=='CASH'">selected="selected"</s:if>>现付</option>
									<option value="ARRIVE_PAYMENT" <s:if test="queryVo.paymentWay=='ARRIVE_PAYMENT'">selected="selected"</s:if>>到付</option>
									<option value="Monthly_Statement" <s:if test="queryVo.paymentWay=='Monthly_Statement'">selected="selected"</s:if>>月结</option>
									<!-- <option>第三方结算</option> -->
								</select>
							</td>
							<td></td>
						</tr>
						<tr>
							<td align="right"> 时间范围：</td>
							<td>
								<input type="text" id="createTimeFrom" readonly="readonly" name="queryVo.startQueryTime" class="input w125 sel_time_input" value="${queryVo.startQueryTime}"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd', onpicked:function(){createTimeTo.focus();},maxDate:'#F{$dp.$D(\'createTimeTo\')||\'%y-%M-%d\'}'})"/>
								-
								<input type="text" id="createTimeTo" readonly="readonly" name="queryVo.endQueryTime" class="input w125 sel_time_input" value="${queryVo.endQueryTime }" 
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'#F{$dp.$D(\'createTimeFrom\')}',maxDate:getCurrentDate()})"/>
							</td>
							<td align="right">订单状态：</td>
							<td>
								<select name="queryVo.logisticsStatus" id="orderStatus">
										<option value="">全部</option>
										<option value="DRAFT" <s:if test="queryVo.logisticsStatus=='DRAFT'">selected="selected"</s:if>>未提交</option>
										<option value="ADD" <s:if test="queryVo.logisticsStatus=='ADD'">selected="selected"</s:if>>待受理</option>
										<option value="SUBMIT" <s:if test="queryVo.logisticsStatus=='SUBMIT'">selected="selected"</s:if>>已受理</option>
										<!-- <option value="ACCEPT" <s:if test="queryVo.logisticsStatus=='ACCEPT'">selected="selected"</s:if>>已接收</option> -->
										<option value="DISPATCH" <s:if test="queryVo.logisticsStatus=='DISPATCH'">selected="selected"</s:if>>已派车</option>
										<option value="CANVASSING" <s:if test="queryVo.logisticsStatus=='CANVASSING'">selected="selected"</s:if>>已开单</option>
										<!-- <option value="DELIVER" <s:if test="queryVo.logisticsStatus=='DELIVER'">selected="selected"</s:if>>已签收</option> -->
										<option value="VOID" <s:if test="queryVo.logisticsStatus=='VOID'">selected="selected"</s:if>>已撤销</option>
								</select>
							</td>
							<td><input id="queryOrders" name="" type="button" value="查询" class="xz1" /></td>
						</tr>
					</table>
					</form>
					<p style="padding-left: 30px;">默认加载最近一个月的订单，如需查看<span class="f_f15a22" style="cursor: pointer;">一个月前的订单</span>，请使用时间范围搜索</p>
				</div>
				<s:if test="orders != null and orders.size>0">
					<div class="order_none">
						<h3>
							<span class="fr">
								<input id="exportAll" type="button" class="tosnmiddle_btn" value="导出所有"/>
								<input id="selectPrintable" onclick="allSelected('CANVASSING')" type="button" class="tosnmiddle_btn" value="全选可打印订单" style="width: 97px;"/>
								<input id="printAll" type="button" class="tosnmiddle_btn btn_sub" value="批量打印标签"  disabled="disabled"/>
							</span>
							<span class="f16">订单信息：</span>
						</h3>
					</div>
				
					<div class="consignee_list pt20">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td width="4%"><input name="" type="checkbox" value="" onchange="selectAll();"/></td>
								<td width="18%">订单号</td>
								<td width="18%">下单日期</td>
								<td width="12%">收货人</td>
								<td width="18%">货物名称</td>
								<td width="10%">订单状态</td>
								<td width="10%">付款方式</td>
								<td width="10%">操 作</td>
							</tr>
							<s:iterator value="orders">
								<tr>
									<td><input name="" type="checkbox" id="${orderId }" value="${orderId }" ver="${orderStatus }" onchange="checkPrint();"/></td>
									<td width="16%">
										<!-- <a id="orderNo${orderId }" href="myOrdersAction!qeuryOrderDetail.action?orderId=${orderId }">${orderNo }</a> -->
										<a id="OrderNum${orderId }" href="javascript:showOrderDetail('${orderId }');">${contractNo }</a>
										<input type="hidden" id="wayBill${orderId }" value="${wayBill }"/>
										<input type="hidden" id="departure${orderId }" value="${departure}"/>
										<input type="hidden" id="destination${orderId }" value="${destination }"/>
										<input type="hidden" id="productType${orderId }" value="${productType }"/>
									</td>
									<td>${orderDate }</td>
									<td>${consigneeName }</td>
									<td>${goodsName }</td>
									<td>
										<input type="hidden" id="orderStatus${orderId }" value="${orderStatus }"/>
										<s:if test="orderStatus == 'ADD'">待受理</s:if>
										<s:elseif test="orderStatus == 'SUBMIT'">已受理</s:elseif>
										<s:elseif test="orderStatus == 'ACCEPT'">已接收</s:elseif>
										<s:elseif test="orderStatus == 'DISPATCH'">已派车</s:elseif>
										<s:elseif test="orderStatus == 'CANVASSING'">已开单</s:elseif>
										<s:elseif test="orderStatus == 'DELIVER'">已签收</s:elseif>
										<s:elseif test="orderStatus == 'VOID'">已撤销</s:elseif>
										<s:if test="orderStatus == 'DRAFT'">未提交</s:if>
									</td>
									<td>
										<s:if test="paymentWay == 'ARRIVE_PAYMENT'">到付</s:if>
										<s:elseif test="paymentWay == 'CASH'">现付</s:elseif>
										<s:elseif test="paymentWay == 'Monthly_Statement'">月结</s:elseif>
										<s:else>其他</s:else>
									</td>
									<td>
										<s:if test="orderStatus == 'DRAFT'">
											<a href="myOrdersAction!modifyOrder.action?orderId=${orderId }">修改</a>
											<a href="javascript:deleteOrder('${orderId }');">删除</a>
										</s:if>
										<s:if test="orderStatus == 'ADD'">
											<a href="myOrdersAction!modifyOrder.action?orderId=${orderId }">修改</a>
											<a href="javascript:cancelOrder('${orderId }');">撤销</a>
										</s:if>
										<s:elseif test="orderStatus == 'SUBMIT'">
											<a href="javascript:showOrderDetail('${orderId }');">查看</a>
										</s:elseif>
										<s:elseif test="orderStatus == 'ACCEPT'">
											<a href="javascript:showOrderDetail('${orderId }');">查看</a>
										</s:elseif>
										<s:elseif test="orderStatus == 'CANVASSING'">
											<a href="javascript:printSingle('${orderId }');">标签打印</a><br/>
										</s:elseif>
										<s:elseif test="orderStatus == 'DELIVER'">
											<a href="javascript:showOrderDetail('${orderId }');">查看</a>
										</s:elseif>
										<s:elseif test="orderStatus == 'VOID'">
											<a href="javascript:showOrderDetail('${orderId }');">查看</a>
										</s:elseif>
									</td>
								</tr>
							</s:iterator>
						</table>
						<w:pager pageSize="${pageSize}" pageNo="${pageNo}" url="myOrdersAction!queryMyOrders.action"
						recordCount="${totalCount}" />
					</div>
				</s:if>
				<s:else>
					<div class="order_none">
						<h3>
							<span class="fr">
								<!-- <input id="printAll" type="button" class="tosnmiddle_btn btn_sub" disabled="disabled" value="导出选中"/> -->
								<input id="printAll" type="button" class="tosnmiddle_btn btn_sub" disabled="disabled" value="导出所有"/>
								<input id="printAll" type="button" class="tosnmiddle_btn btn_sub" disabled="disabled" value="标签打印选中"/>
								<input id="printAll" type="button" class="tosnmiddle_btn btn_sub" disabled="disabled" value="标签打印所有"/>
							</span>
							<span class="f16">订单信息：</span>
						</h3>
						<p>您好,暂无查询记录,是否<a href="orderAction!index.action" class="f_f15a22">立即下单</a>?</p>
					</div>
				</s:else>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>

<!-- 详情 -->
<div class="easyDialog_wrapper" id="easyDialogWrapper" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>订单详情

		</div>
    	<div class="Order_layer" id="Order_layer_m">
			<div class="Order_layer_box">
				<p><b>订单号：</b><span id="d_orderNo"></span></p>
			</div>
			<div class="Order_layer_box">
				<p><b>发货人信息</b></p>
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="120" align="right">发货人：</td>
						<td id="d_consignor"></td>
					</tr>
					<tr>
						<td align="right">手机号：</td>
						<td><span id="d_consignor_phone"></span></td>
					</tr>
					<tr>
						<td align="right">固话：</td>
						<td><span id="d_consignor_tel"></span></td>
					</tr>
					<tr>
						<td align="right" valign="top">公司名称：</td>
						<td id="d_shipper_ebspNameCn"></td>
					</tr>
					<tr>
						<td align="right" valign="top">发货人地址：</td>
						<td id="d_consignor_address"></td>
					</tr>
					<tr>
						<td align="right">发货网点：</td>
						<td id="d_consignor_dot"></td>
					</tr>
					<tr>
						<td align="right">网点信息：</td>
						<td id="d_consignor_dot_info"></td>
					</tr>
				</table>
			</div>
			<div class="Order_layer_box">
				<p><b>收货人信息</b></p>
			
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="120" align="right">收货人：</td>
						<td id="d_consignee"></td>
					</tr>
					<tr>
						<td align="right">手机号：</td>
						<td id="d_consignee_phone"></td>
					</tr>
					<tr>
						<td align="right">固话：</td>
						<td id="d_consignee_tel"></td>
					</tr>
					<tr>
						<td align="right" valign="top">收货人地址：</td>
						<td id="d_consignee_address"></td>
					</tr>
				</table>
			</div>
			<div class="Order_layer_box">
				<p><b>货物信息</b></p>
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="120" align="right">货物名称：</td>
						<td width="150" id="d_goodsName"></td>
						<td width="100" align="right">保价声明：</td>
						<td id="d_insured"></td>
					</tr>
					<tr>
						<td align="right">货物包装：</td>
						<td id="d_package"></td>
						<td align="right">货物件数：</td>
						<td id="d_goods_count"></td>
					</tr>
					<tr>
						<td align="right">货物重量：</td>
						<td id="d_goods_wight"></td>
						<td align="right">货物体积：</td>
						<td id="d_goods_Volume"></td>
					</tr>
				</table>
			</div>
			<div class="Order_layer_box">
				<p><b>服务信息</b></p>
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="120" align="right">运输方式：</td>
						<td width="150" id="d_product_type"></td>
						<td width="100" align="right">付款方式：</td>
						<td id="d_payment_way"></td>
					</tr>
					<tr>
						<td align="right">送货方式：</td>
						<td id="d_delivery_way"></td>
						<td align="right">短信通知：</td>
						<td id="d_dotice"></td>
					</tr>
					<tr>
						<td align="right">代收货款：</td>
						<td id="d_coll_amount"></td>
						<td align="right">签单返回：</td>
						<td id="d_signBack"></td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td colspan="3" id="d_remark"></td>
					</tr>
				</table>
			</div>
			<div class="Order_layer_box" style="border:0;">
				<p><b>当前状态</b></p>
				<p style="padding-left:40px;">
					<span id="d_order_status"></span>
					<%-- （司机：<span id="d_driver"></span>，联系方式：<span id="d_driver_phone"></span>） --%>
				</p>
			</div>
		</div>
		<!-- <div class="easyDialog_footer">
			<a href="#" class="btn_highlight">新增</a>
			<a href="#" class="btn_normal" onclick="easyDialog.close();"></a>
		</div> -->
	</div>
</div>
</body>
</html>
