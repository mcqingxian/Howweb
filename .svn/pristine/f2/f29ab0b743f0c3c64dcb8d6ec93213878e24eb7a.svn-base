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
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script
	src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/hc_place_order.js"></script>
<meta charset="utf-8">
<title>我要下单</title>
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
		<div data-role="header">
			<div data-role="navbar">
				<img src="/wechat/images/logo_name.png">
				<ul>
					<li><a class="ui-btn-active ui-state-persist" href="#"
						data-transition="none">发货人信息</a></li>
					<li><a href="#pagetwo" data-transition="none"
						id="order_a_pagetwo">收货人信息</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<table style="width: 100%">
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>发货人</b>
						</p></td>
					<td style="width: 68%;"><input type="text" id="shipperName"
						maxlength="20" value='<s:property value='shipperContact.name'/>' /></td>
					<td style="width: 1%;"><button data-icon="user"
							data-iconpos="notext" data-inline="true" id="query_shipper"></button></td>
				</tr>
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>发货人手机</b>
						</p></td>
					<td colspan="2"><input type="number" id="shipperMobile"
						maxlength="30" value="<s:property value='shipperContact.phone'/>" /></td>
				</tr>
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>发货人省市</b>
						</p></td>
					<td><input type="text" id="shipperProv" readonly="readonly"
						placeholder="请点击"
						value="<s:property value='shipperContact.pro_city_cty'/>" /></td>
					<td>
						<%-- <div id="shipper_location"
							style="width: 40px; height: 30px; border-radius: 10px; line-height: 30px; text-align: center; background-color: #939393;">
							<img src="<%=request.getContextPath()%>/images/currLocation.png">
						</div> --%>
						<button id="shipper_location" data-icon="location-arrow"
							data-iconpos="notext" data-inline="true"></button>
					</td>
				</tr>
				<tr>
					<td><p>
							<span style="color: red">*</span><b>详细地址</b>
						</p></td>
					<td colspan="2"><input type="text" id="shipperAddress"
						maxlength="80"
						value="<s:property value='shipperContact.detail_address'/>" /></td>
				</tr>

				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>提货方式</b>
						</p></td>
					<td colspan="2"><select id="shipperMethod"
						data-native-menu="false">

							<option value="YES">上门提货</option>
							<option value="NO">客户自送</option>

					</select> <%-- <s:select list="shipperMethodMap" ></s:select> --%></td>
				</tr>

			</table>
		</div>
	</div>
	<!-- 发货人查询 -->
	<div data-role="page" id="shipper_query" >
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
		<div data-role="header" style="display: none">
			<h1>选择省份</h1>
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
		<div data-role="header" style="display: none">
			<h1>选择城市</h1>
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
		<div data-role="header">
			<img src="/wechat/images/logo_name.png">
			<div data-role="navbar">
				<ul>
					<li><a data-transition="none" href="#order"
						id="pagetwo_a_order">发货人信息</a></li>
					<li><a data-transition="none"
						class="ui-btn-active ui-state-persist">收货人信息</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<table style="width: 100%">
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>收货人</b>
						</p></td>
					<td style="width: 68%;"><input type="text" id="consigneeName"
						maxlength="20" value="<s:property value='consigneeContact.name'/>" /></td>
					<td style="width: 1%;"><button data-icon="user"
							data-iconpos="notext" data-inline="true" id="query_consignee"></button></td>
				</tr>
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>收货人手机</b>
						</p></td>
					<td colspan="2"><input type="number" id="consigneeMobile"
						maxlength="30"
						value="<s:property value='consigneeContact.phone'/>" /></td>
				</tr>
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>收货人省市</b>
						</p></td>
					<td><input type="text" id="consigneeProv" readonly="readonly"
						placeholder="请点击"
						value="<s:property value='consigneeContact.pro_city_cty'/>" /></td>
					<td>
						<%-- <div id="consignee_location"
							style="width: 40px; height: 30px; border-radius: 10px; line-height: 30px; text-align: center; background-color: #939393;">
							<img src="<%=request.getContextPath()%>/images/currLocation.png"></div> --%>
						<button id="consignee_location" data-icon="location-arrow"
							data-iconpos="notext" data-inline="true"></button>
					</td>
				</tr>
				<tr>
					<td style="width: 10%;"><p>
							<span style="color: red">*</span><b>详细地址</b>
						</p></td>
					<td colspan="2"><input type="text" id="consigneeAddress"
						maxlength="80"
						value="<s:property value='consigneeContact.detail_address'/>" /></td>
				</tr>
				<tr>
					<td style="width: 100%;" colspan="3"><button
							id="submit_order_bt" data-theme = "h">提交订单</button></td>
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
				<p style="margin-top: 100px; text-align: center;">你还没有添加收货联系人</p>
			</s:else>
		</div>
	</div>
	<div data-role="page" id="consignee_province_query">
		<div data-role="header" style="display: none">
			<h1>选择省份</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" data-inline="true"
				id="consignee_province_back" data-theme = "h">返回</button>
			<ul data-role="listview" data-inset="true" id="consignee_provinces">

			</ul>

		</div>
	</div>
	<!-- 出发城市查询 -->
	<div data-role="page" id="consignee_city_query">
		<div data-role="header" style="display: none">
			<h1>选择城市</h1>
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
			<div align="center" id="err_dialog_con">服务器内部错误，请稍后重试此请求。</div>
		</div>
	</div>
</body>
</html>
