<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/icon-pack-custom.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/public.css"/>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/order_detail.js"></script>
<script
	src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<meta charset="utf-8">
<title>查看订单</title>
<style>
.ui-dialog-contain {
	width: 92.5%;
	max-width: 500px;
	margin: 30% auto auto auto;
	padding: 0;
	position: relative;
	top: -15px;
}
</style>
</head>
<body>
	<div data-role="page" id="order">
	
		<div data-role="header" style="background-color:#CD0000">
			<h1>查&nbsp;看&nbsp;订&nbsp;单</h1>
			<div data-role="navbar">
				<ul>
					<li><a class="ui-btn-active ui-state-persist" href="#"
						data-transition="none" style="font-size: 14px;">发货人信息</a></li>
					<li><a href="#pagetwo" data-transition="none"
						id="order_a_pagetwo" style="font-size: 14px;">收货人信息</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<table style="width: 100%">
				<tr>
					<td style="width: 30%;" align=right><p>
							<span style="color: red">*</span><b>发货人：</b>
						</p></td>
					<td><input type="hidden"
						value="<s:property value='order.orderNo'/>" id="orderNo" /> 
						<input type="text"  value="<s:property value='order.shipperName'/>"  
								data-role="none" style="border:0px;width:100%"
						id="shipperName" maxlength="20" /></td>
				</tr>
				<tr>
					<td style="width: 30%;" align=right><p>
							<span style="color: red">*</span><b>发货手机：</b>
						</p></td>
					<td colspan="2"><input type="number" id="shipperMobile"
						value="<s:property value='order.shipperMobile'/>" maxlength="30" data-role="none" 
							style="border:0px;width:100%"/></td>
				</tr>
				<tr>
					<td style="width: 30%;" align=right><p>
							<span style="color: red">*</span><b>发货省市区：</b>
						</p></td>
					<td><input type="text" id="shipperProv"  data-role="none" 
							style="border:0px;width:100%"
							value="<s:property value='order.shipperProv'/> <s:property value='order.shipperCity'/> <s:property value='order.shipperEbrgNameCn'/>"/>
					</td>
				</tr>
				<tr>
					<td align=right>
						<p>
							<span style="color: red">*</span><b>详细地址：</b>
						</p>
					</td>
					<td><input type="text" id="shipperAddress"  data-role="none"  style="border:0px;width:100%"
						value="<s:property value='order.shipperAddress'/>" maxlength="80" /></td>
				</tr>
				<tr>
						<td align=right>
							<span style="color: red">*</span><b>受理网点：</b>
						</td>
						<td>
							<input type="text" id="shipperSlwd" readonly="readonly" data-role="none" style="width:98%"
							placeholder="请点击" value="<s:property value='order.escoSecondName'/>" />
							<input type="hidden" id="shipperSlwd_code" readonly="readonly" value="<s:property value='order.escoSecondCode'/>" />
						</td>
					</tr>
				<tr>
					<td style="width: 30%;" align=right>
						<p>
							<span style="color: red">*</span><b>提货方式：</b>
						</p>
					</td>
					<td><s:if test='order.shipperMethod=="YES"'>
							<select id="shipperMethod" data-native-menu="false" data-role="none" style="width:100%" >
								<option value="YES" selected="selected">上门提货</option>
								<option value="NO">客户自送</option>
							</select>
						</s:if> <s:if test='order.shipperMethod=="NO"' >
							<select id="shipperMethod" data-native-menu="false" data-role="none" style="width:100%" >
								<option value="YES">上门提货</option>
								<option value="NO" selected="selected">客户自送</option>
							</select>
						</s:if>
				</tr>
			</table>
		</div>
	</div>
	<!-- 发货人查询 -->
	<div data-role="page" id="shipper_query">
		<div data-role="header" style="display: none">
			<h1>发货人</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="shipper_back" data-theme = "h">返回</button>
			<s:if test="shipperContacts!=null&&!shipperContacts.isEmpty()">
				<ul data-role="listview" data-inset="true" id="shippers">
					<s:iterator value="shipperContacts" status="status">
						<li id="<s:property value='#status.index'/>_shipper_li"><s:property
								value="name" />&nbsp;&nbsp;<s:property value="phone" /> <input
							type="hidden"
							id="<s:property value='#status.index'/>_shipper_name"
							value="<s:property value="name"/>" /> <input type="hidden"
							id="<s:property value='#status.index'/>_shipper_phone"
							value="<s:property value="phone"/>" /> <input type="hidden"
							id="<s:property value='#status.index'/>_shipper_detail_address"
							value="<s:property value="detail_address"/>" /> <input
							type="hidden"
							id="<s:property value='#status.index'/>_shipper_pro_city_cty"
							value="<s:property value="pro_city_cty"/>" /></li>
					</s:iterator>
				</ul>
			</s:if>
			<s:else>
				<p style="margin-top: 100px; text-align: center;">你还没有添加发货联系人</p>
			</s:else>
		</div>
	</div>
	<!-- 出发省份查询 -->
	<div data-role="page" id="shipper_province_query">
		<div data-role="header" style="background-color:#CD0000">
			<h1>选&nbsp;择&nbsp;省&nbsp;份</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="shipper_province_back" data-theme = "h">返回</button>
			<ul data-role="listview" data-inset="true" id="shipper_provinces">

			</ul>

		</div>
	</div>
	<!-- 出发城市查询 -->
	<div data-role="page" id="shipper_city_query">
		<div data-role="header" style="background-color:#CD0000">
			<h1>选&nbsp;择&nbsp;城&nbsp;市</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="shipper_city_back" data-theme = "h">返回</button>
			<ul data-role="listview" data-inset="true" id="shipper_citys">

			</ul>

		</div>
	</div>


	<div data-role="page" id="pagetwo">
		<div data-role="header" style="background-color:#CD0000">
			<h1>查&nbsp;看&nbsp;订&nbsp;单</h1>
			<div data-role="navbar">
				<ul>
					<li><a data-transition="none" href="#order"
						id="pagetwo_a_order" style="font-size: 14px;">发货人信息</a></li>
					<li><a data-transition="none"
						class="ui-btn-active ui-state-persist" style="font-size: 14px;">收货人信息</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<table style="width: 100%">
				<tr>
					<td style="width: 30%;" align=right>
						<p>
							<span style="color: red">*</span><b>收货人：</b>
						</p>
					</td>
					<td style="width: 70%;"><input type="text" id="consigneeName"
						value='<s:property value="order.consigneeName"/>' maxlength="20"  data-role="none" 
						style="border:0px;width:100%"/></td>
				</tr>
				<tr>
					<td align=right>
						<p>
							<span style="color: red">*</span><b>收货手机：</b>
						</p></td>
					<td><input type="number" id="consigneeMobile"
						value="<s:property value='order.consigneeMobile'/>" maxlength="30"   data-role="none" 
							style="border:0px;width:100%"/></td>
				</tr>
				<tr>
					<td align=right>
						<p>
							<span style="color: red">*</span><b>收货省市区：</b>
						</p>
					</td>
					<td><input type="text" id="consigneeProv" 
						value="<s:property value='order.consigneeProv'/> <s:property value='order.consigneeCity'/> <s:property value='order.consigneeEbrgNameCn'/>"   data-role="none" 
						style="border:0px;width:100%"/></td>
				</tr>
				<tr>
					<td style="width: 30%;" align=right>
						<p>
							<span style="color: red">*</span><b>详细地址：</b>
						</p>
					</td>
					<td>
						<input type="text" id="consigneeAddress"
							value="<s:property value='order.consigneeAddress'/>"
							maxlength="80"  data-role="none" style="border:0px;width:100%"/>
						<input type="hidden" id="waybillNo"
							value="<s:property value='order.waybillNo'/>"maxlength="80" />
					</td>
				</tr>
				<tr>
					<td style="width: 100%;" colspan="2">
						<div align="center">
							<s:if
								test="order.orderStatus=='ADD'||order.orderStatus=='SUBMIT'||order.orderStatus=='ACCEPT'">
								<button id="update_order_bt" data-inline="true"  data-theme = "h">修改</button>
								<button id="cancle_order_bt" data-inline="true"
									 data-theme = "h">撤销</button>
							</s:if>
							<s:if
								test="order.orderStatus=='DELIVER'||order.orderStatus=='CANVASSING'">
								<button id="query_waybill_bt" data-inline="true"
									data-theme = "h">运单跟踪</button>
							</s:if>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 收货人查询 -->
	<div data-role="page" id="consignee_query">
		<div data-role="header" style="display: none">
			<h1>收货人</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="consignee_back" data-theme = "h">返回</button>
			<s:if test="consigneeContacts!=null&&!consigneeContacts.isEmpty()">
				<ul data-role="listview" data-inset="true" id="consignees">
					<s:iterator value="consigneeContacts" status="status">
						<li id="<s:property value='#status.index'/>_consignee_li"><s:property
								value="name" />&nbsp;&nbsp;<s:property value="phone" /> <input
							type="hidden"
							id="<s:property value='#status.index'/>_consignee_name"
							value="<s:property value="name"/>" /> <input type="hidden"
							id="<s:property value='#status.index'/>_consignee_phone"
							value="<s:property value="phone"/>" /> <input type="hidden"
							id="<s:property value='#status.index'/>_consignee_detail_address"
							value="<s:property value="detail_address"/>" /> <input
							type="hidden"
							id="<s:property value='#status.index'/>_consignee_pro_city_cty"
							value="<s:property value="pro_city_cty"/>" /></li>
					</s:iterator>
				</ul>
			</s:if>
			<s:else>
				<p style="margin-top: 100px; text-align: center;">你还没有添加发货联系人</p>
			</s:else>
		</div>
	</div>
	<div data-role="page" id="consignee_province_query">
		<div data-role="header" style="background-color:#CD0000">
			<h1>选&nbsp;择&nbsp;省&nbsp;份</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="consignee_province_back" data-theme = "h">返回</button>
			<ul data-role="listview" data-inset="true" id="consignee_provinces">

			</ul>

		</div>
	</div>
	<!-- 出发城市查询 -->
	<div data-role="page" id="consignee_city_query">
		<div data-role="header" style="background-color:#CD0000">
			<h1>选&nbsp;择&nbsp;省&nbsp;份</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="consignee_city_back" data-theme = "h">返回</button>
			<ul data-role="listview" data-inset="true" id="consignee_citys">

			</ul>

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
			<h1 id="err_dialg_header">服务器异常</h1>
		</div>
		<div data-role="content">
			<div align="center" id="err__dialog_con">服务器内部错误，请稍后重试此请求。</div>
		</div>
	</div>
</body>
</html>
