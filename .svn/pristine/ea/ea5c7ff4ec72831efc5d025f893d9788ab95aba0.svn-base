<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %>
<link rel="stylesheet" href="${styles}/public.css"/>	
<script src="${scripts}/order_manager.js"></script>
<title>天地华宇</title>
<style>
p {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 未完成订单 -->
	<div data-role="page" id="undoneOrder">
		<div data-role="header" style="background-color:#CD0000">
			<h1>订&nbsp;单&nbsp;管&nbsp;理</h1>
			<div data-role="navbar">
				<ul>
					<li><a href="" data-transition="none"
						class="ui-btn-active ui-state-persist">未完成订单</a></li>
					<li id="doneOrder_li1"><a href="#" data-transition="none">已完成订单</a></li>
					<li id="orderQuery_li1"><a href="#" data-transition="none">订单号查询</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<s:if test="undoneOrders!=null&&!undoneOrders.isEmpty()">
				<s:iterator value="undoneOrders" status="status">

					<div data-role="collapsible" data-collapsed-icon="chevron-circle-down" data-expanded-icon="chevron-circle-up">
						<h1>
							收货人：
							<s:property value='consigneeName' />
							&nbsp;&nbsp;订单号：
							<s:property value='orderNo' />
						</h1>
						<ul data-role="listview">
							<li>订单号：<span
								id='<s:property value='#status.index'/>_orderNo_sp'><s:property
										value='orderNo' /></span><span>&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="#" id="<s:property value='#status.index'/>_order_detail"
									onclick="orderDetail(this)">详情</a></span> <br /> 收货人：<s:property
									value='consigneeName' /> <br /> 收货人地址：<s:property
									value='consigneeAddress' /> <br /> 下单时间：<s:property
									value='orderTime' /> <br /> 订单状态： <s:if
									test='orderStatus=="ADD"'>
									待受理
								</s:if> <s:if test='orderStatus=="SUBMIT"||orderStatus=="ACCEPT"'>
									已处理
								</s:if> <s:if test='orderStatus=="CANVASSING"'>
									已揽收
								</s:if> <br /> <s:if test="waybillNo!=null">
									运单号：<span id="<s:property value='#status.index'/>_waybillNo_sp">
										<s:property value='waybillNo' />
									</span>
									<br />
								</s:if> <br />
								<div align="center">
									<s:if
										test='orderStatus=="ADD"||orderStatus=="SUBMIT"||orderStatus=="ACCEPT"'>
										<button id='<s:property value='#status.index'/>_cancel_bt'
											data-inline="true" data-theme = "h"
											onclick="cancelOrder(this)">撤销</button>
										<button data-inline="true" data-theme = "h"
											id='<s:property value='#status.index'/>_edit_bt'
											onclick="modifyOrder(this)">修改</button>
									</s:if>
									<s:if test='orderStatus=="CANVASSING"'>
										<button data-inline="true" data-theme = "h"
											id='<s:property value='#status.index'/>_waybillNoSearch_bt'
											onclick="searchWaybill(this)">运单跟踪</button>
									</s:if>
								</div>
							</li>
						</ul>
					</div>
				</s:iterator>
			</s:if>
			<s:else>
				<p style="margin-top: 100px; text-align: center;">
					您还没有未完成订单，点击<a href="#" id="order_a" style="color: red;">我要下单</a>
				</p>
			</s:else>
		</div>
	</div>
	<!-- 完成订单 -->
	<div data-role="page" id="doneOrder">
		<div data-role="header" style="background-color:#CD0000">
			<h1>订&nbsp;单&nbsp;管&nbsp;理</h1>
			<div data-role="navbar">
				<ul>
					<li id="undoneOrder_li1"><a href="#" data-transition="none">未完成订单</a></li>
					<li><a href="#" data-transition="none"
						class="ui-btn-active ui-state-persist">已完成订单</a></li>
					<li id="orderQuery_li2"><a href="#" data-transition="none">订单号查询</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<select name="date" id="date">
				<s:if test="date=='oneWeek'">
					<option value="oneWeek" selected="selected">最近一周</option>
					<option value="oneMonth">最近一个月</option>
					<option value="threeMonth">最近三个月</option>
				</s:if>
				<s:if test="date==null||date=='oneMonth'">
					<option value="oneWeek" >最近一周</option>
					<option value="oneMonth" selected="selected">最近一个月</option>
					<option value="threeMonth">最近三个月</option>
				</s:if>
				<s:if test="date=='threeMonth'">
					<option value="oneWeek">最近一周</option>
					<option value="oneMonth">最近一个月</option>
					<option value="threeMonth" selected="selected">最近三个月</option>
				</s:if>
			</select>
			<s:iterator value="doneOrders" status="status">
				<div data-role="collapsible" data-collapsed-icon="chevron-circle-down" data-expanded-icon="chevron-circle-up">

					<h1>
						收货人：
						<s:property value='consigneeName' />
						&nbsp;&nbsp;订单号：
						<s:property value='orderNo' />
					</h1>
					<ul data-role="listview">
						<li>订单号：<span
							id="<s:property value='#status.index'/>done_orderNo_sp"><s:property
									value='orderNo' /></span><span>&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="#"
								id="<s:property value='#status.index'/>_done_order_detail"
								onclick="doneOrderDetail(this)">详情</a></span> <br /> 收货人：<s:property
								value='consigneeName' /> <br /> 收货人地址：<s:property
								value='consigneeAddress' /> <br /> 下单时间：<s:property
								value='orderTime' /> <br /> 订单状态： <s:if
								test='orderStatus=="VOID"'>
									已取消
								</s:if> <s:if test='orderStatus=="DELIVER"'>
									已签收
								</s:if> <br /> <s:if test="waybillNo!=null">
									运单号：<span
									id='<s:property value='#status.index'/>_done_waybillNo_sp'>
									<s:property value='waybillNo' />
								</span>
								<br />
							</s:if> <br />
							<div align="center">
								<s:if test='orderStatus=="DELIVER"'>
									<button
										id='<s:property value='#status.index'/>_done_waybillNoSearch_bt'
										data-inline="true" data-theme = "h"
										onclick="doneSearchWaybill(this)">运单跟踪</button>
								</s:if>
							</div>



						</li>
					</ul>
				</div>
			</s:iterator>

		</div>
	</div>

	<!-- 订单查询 -->
	<div data-role="page" id="orderQuery">
	<div data-role="header" style="background-color:#CD0000">
			<h1>订&nbsp;单&nbsp;管&nbsp;理</h1>
			<div data-role="navbar">
				<ul>
					<li id="undoneOrder_li2"><a href="#" data-transition="none">未完成订单</a></li>
					<li id="doneOrder_li2"><a href="#" data-transition="none">已完成订单</a></li>
					<li><a href="#" data-transition="none" class="ui-btn-active ui-state-persist">订单号查询</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<table style="width: 100%">
				<tr>
					<td>
						订单号：
					</td>
					<td>
						<input type="text" name="orderNo" id="queryOrderNo" data-role="none" style="border:0px;width:100%"/>
					</td>
					<td>
						<button id="queryOrder_bt" data-theme = "h" style="padding:5px;margin:5px;color: #FFFFFF">查询</button>
					</td>
				</tr>
			</table>
			<div id="queryOrder_div"></div>
		</div>
	</div>


	<!-- 弹出对话框 -->
	<div data-role="dialog" id="order_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="dialg_header"></h1>
		</div>
		<div data-role="content">
			<div align="center" id="order_dialog_con"></div>
		</div>
	</div>

	<!-- 弹出对话框 -->
	<div data-role="dialog" id="err_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="err_header">服务器异常</h1>
		</div>
		<div data-role="content">
			<div align="center" id="err_dialog_con">服务器内部错误，请稍后重试此请求。</div>
		</div>
	</div>
</body>
