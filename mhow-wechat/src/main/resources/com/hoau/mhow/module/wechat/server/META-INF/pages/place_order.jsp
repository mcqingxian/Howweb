<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %>  
<link rel="stylesheet" href="${styles}/public.css"/>	
<script src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="${scripts}/place_order.js"></script>
<meta charset="utf-8">
<title>我要下单</title>
</head>
<body>
<div data-role="page" id="order">
<div id="wrapper">
	<div id="wrapper-in">
		<div id="main-page">	
			<div class="header">
				<span class="btn-topl">
					<a class="link-back" href="javascript:history.go(-1);">
						<span class="ui-ico ui-ico-back"></span>
					</a>
				</span>
				<h1 class="innertitle">订单填写</h1>
				<span class="btn-topr">
					<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
						<span class="ui-ico ui-ico-home"></span>
					</a>
					<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
						<span class="ui-ico ui-ico-nav"></span>
					</a>
				</span>
			</div>
			
			<!--主要内容-->
			<div data-role="content" data-inset="true">
			<div data-role="collapsible" data-collapsed="false" data-inset="true" style="width: 100%">
    			<h4>发货人信息</h4>
				<table style="width: 100%">
					<tr>
						<td align=right style="width: 30%;">
							<span style="color: red">*</span>发货人：
						</td>
						<td style="width: 60%;">
							<input type="text" id="shipperName" data-role="none"
							maxlength="20" value='<s:property value='shipperContact.name'/>' />
						</td>
						<td style="width: 10%;">
							<a id="query_shipper" ><img height=28 width=28 src="${images}/person.png"></a>
						</td>
					</tr>
					<tr>
						<td align=right>
							<span style="color: red">*</span>发货手机：
						</td>
						<td colspan="2">
							<input type="number" id="shipperMobile" data-role="none"
							maxlength="30" value="<s:property value='shipperContact.phone'/>" />
						</td>
					</tr>
					<tr>
						<td align=right>
							<span style="color: red">*</span>发货省市区：
						</td>
						<td>
							<input type="text" id="shipperProv" readonly="readonly" data-role="none"
							placeholder="请点击" value="<s:property value='shipperContact.pro_city_cty'/>" />
						</td>
						<td>
							<a id="shipper_location" ><img height=28 width=28 src="${images}/position.png"></a>
						</td>
					</tr>
					<tr>
						<td align=right>
							<span style="color: red">*</span>详细地址：
						</td>
						<td colspan="2">
							<input type="text" id="shipperAddress" data-role="none" 
							value="<s:property value='shipperContact.detail_address'/>" placeholder="请填写所在街道及详细地址" />
						</td>
					</tr>
					<tr>
						<td align=right>
							<span style="color: red">*</span>受理网点：
						</td>
						<td colspan="2">
							<input type="text" id="shipperSlwd" readonly="readonly" data-role="none" 
							placeholder="请点击" value="<s:property value='shipperContact.acc_branches'/>" />
							<input type="hidden" id="shipperSlwd_code" readonly="readonly" value="<s:property value='shipperContact.acc_branches_code'/>" />							
						</td>
					</tr>
					<tr>
						<td align=right>
							<span style="color: red">*</span>提货方式：
						</td>
						<td colspan="2">
							<select id="shipperMethod" data-role="none" data-native-menu="false" >
								<option value="YES">上门提货</option>
								<option value="NO">客户自送</option>
							</select>
						</td>
					</tr>
					<!-- <tr>
						<td colspan="3" style="text-align: center;border:0px;">
							<p><a href="http://a.app.qq.com/o/simple.jsp?pkgname=net.hoau" target="_balank" style="color: #CD0000;">下载华宇官方APP，一键查询、下单</a></p>
						</td>
					</tr> -->
				</table>
			</div>
			
			<!-- 收货人信息 -->
			<div data-role="collapsible" data-inset="true">
    			<h4>收货人信息</h4>
				<table style="width: 100%">
					<tr>
						<td align=right>
							收货人：
						</td>
						<td>
							<input type="text" id="consigneeName" data-role="none"
							maxlength="20" value="<s:property value='consigneeContact.name'/>"/><!--  style="width:95%" -->
						</td>
						<td>
							<a id="query_consignee" ><img height=28 width=28 src="${images}/person.png"></a>
						</td>
					</tr>
					<tr>
						<td align=right>
							收货手机：
						</td>
						<td colspan="2">
							<input type="number" id="consigneeMobile" data-role="none"
							maxlength="30" value="<s:property value='consigneeContact.phone'/>"/>
						</td>
					</tr>
					<tr>
						<td align=right>
							收货省市区：
						</td>
						<td>
							<input type="text" id="consigneeProv" readonly="readonly" data-role="none"
								placeholder="请点击" value="<s:property value='consigneeContact.pro_city_cty'/>" />
						</td>
						<td>
							<a id="consignee_location" ><img height=28 width=28 src="${images}/position.png"></a>
						</td>
					</tr>
					<tr>
						<td align=right>
							详细地址：
						</td>
						<td colspan="2">
							<input type="text" id="consigneeAddress" data-role="none" placeholder="请填写所在街道及详细地址"
								 value="<s:property value='consigneeContact.detail_address'/>" />
						</td>
					</tr>
					<tr>
						<td colspan="3" >
							<div style="background-color:#757575;text-align: center;">
								<font color="#FFFFFF">我们将第一时间与您取得联系！</font>
							</div>
						</td>
					</tr>
					<!-- <tr>
						<td style="width: 100%;border:0px;" colspan="3">
							<button id="submit_order_bt" data-theme = "h" style="color: #FFFFFF">提交订单</button>
						</td>
					</tr> -->
				</table>
			</div>
			<div>
				<button id="submit_order_bt" data-theme = "h" style="color: #FFFFFF">提交订单</button>
			</div>
			<p style="margin-top:25px;width:100%;text-align:center;">
				<a href="http://a.app.qq.com/o/simple.jsp?pkgname=net.hoau" target="_balank" style="color: #CD0000;">下载华宇官方APP，一键查询、下单</a>
			</p>
		</div>
			<!-- 主要内容end -->
			<%@ include file="../bse/footer.jsp" %>
		</div>
		<div id="map-page">
			<%@ include file="../bse/nav-map.jsp" %>
		</div>
	</div>
</div>
		
</div>
	<!-- 发货人查询 -->
	<div data-role="page" id="shipper_query" >
		<div data-role="header" style="background-color: #CD0000;" >
			<h1 >发&nbsp;货&nbsp;人</h1>
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
		<div data-role="header"  style="background-color: #CD0000;">
			<h1 >选&nbsp;择&nbsp;省&nbsp;份</h1>
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
		<div data-role="header" style="background-color: #CD0000;">
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
	<!-- 出发区域查询 -->
	<div data-role="page" id="shipper_county_query">
		<div data-role="header" style="background-color: #CD0000;">
			<h1>选&nbsp;择&nbsp;区&nbsp;域</h1>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="shipper_county_back" data-theme="h">返回</button>
			<ul data-role="listview" data-inset="true" id="shipper_countys">
			</ul>

		</div>
	</div>
	
	
	<!-- 受理网点查询 -->
	<div data-role="page" id="shipper_branches_query">
		<div data-role="header"  style="background-color: #CD0000;">
			<h1 >选&nbsp;择&nbsp;网&nbsp;点</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="shipper_branches_back" data-theme = "h">返回</button>
			 <ul data-role="listview" data-inset="true" id="shipper_branches">

			</ul>
			<!--<div data-role="collapsible-set" id="shipper_branches">
					<div data-role="listview" data-inset="true" id="shipper_branches"></div>
		  <ul data-role="listview" data-inset="true" id="shipper_branches">

			</ul>
			<div data-role="collapsible" data-collapsed-icon="chevron-circle-down" data-expanded-icon="chevron-circle-up"><h1>fdfdfd</h1><table style="width:100%"><tbody><tr><td style="width:30%">服务类型：</td><td style="width:70%"></td></tr><tr><td style="width:30%">门店地址：</td><td style="width:70%"></td></tr><tr><td style="width:30%">电话：</td><td style="width:70%"></td></tr><tr><td style="width:30%">距离：</td><td style="width:70%"></td></tr></tbody></table></div>

			</div> -->
		</div>
	</div>

	<%-- <div data-role="page" id="pagetwo">
		<div data-role="header" style="background-color:#CD0000">
			<h1>订&nbsp;单&nbsp;填&nbsp;写</h1>
			<div data-role="navbar">
				<ul>
					<li><a data-transition="none" href="#order"
						id="pagetwo_a_order"  style="font-size: 14px;">发货人信息：</a></li>
					<li><a data-transition="none"
						class="ui-btn-active ui-state-persist"  style="font-size: 14px;">收货人信息</a></li>
				</ul>
			</div>
		</div>

		<div data-role="content">
			<table style="width: 100%">
				<tr>
					<td align=right>
						收货人：
					</td>
					<td>
						<input type="text" id="consigneeName" data-role="none"
						maxlength="20" value="<s:property value='consigneeContact.name'/>" style="width:100%"/>
					</td>
					<td>
						<a id="query_consignee" ><img height=28 width=28 src="${images}/person.png"></a>
					</td>
				</tr>
				<tr>
					<td align=right>
						收货手机：
					</td>
					<td colspan="2">
						<input type="number" id="consigneeMobile" data-role="none"
						maxlength="30" value="<s:property value='consigneeContact.phone'/>" style="width:100%"/>
					</td>
				</tr>
				<tr>
					<td align=right>
						收货省市：
					</td>
					<td>
						<input type="text" id="consigneeProv" readonly="readonly" data-role="none"
							placeholder="请点击" value="<s:property value='consigneeContact.pro_city_cty'/>" />
					</td>
					<td>
						<a id="consignee_location" ><img height=28 width=28 src="${images}/position.png"></a>
					</td>
				</tr>
				<tr>
					<td align=right>
						详细地址：
					</td>
					<td colspan="2">
						<input type="text" id="consigneeAddress" data-role="none" placeholder="请填写所在街道及详细地址"
							style="width:100%" value="<s:property value='consigneeContact.detail_address'/>" />
					</td>
				</tr>
				<tr>
					<td colspan="3" >
						<div style="background-color:#757575;text-align: center;">
							<font color="#FFFFFF">我们将第一时间与您取得联系！</font>
						</div>
					</td>
				</tr>
				<tr>
					<td style="width: 100%;border:0px;" colspan="3">
						<button id="submit_order_bt" data-theme = "h" style="color: #FFFFFF">提交订单</button>
					</td>
				</tr>
			</table>
		</div>
	</div> --%>
	<!-- 收货人查询 -->
	<div data-role="page" id="consignee_query">
		<div data-role="header" style="background-color: #CD0000;">
			<h1>收&nbsp;货&nbsp;人</h1>
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
		<div data-role="header" style="background-color: #CD0000;"> 
			<h1 >选&nbsp;择&nbsp;省&nbsp;份</h1>
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
		<div data-role="header" style="background-color: #CD0000;">
			<h1>选&nbsp;择&nbsp;城&nbsp;市</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="consignee_city_back" data-theme = "h">返回</button>
			<ul data-role="listview" data-inset="true" id="consignee_citys">

			</ul>

		</div>
	</div>
	
	<!-- 出发区域查询 -->
	<div data-role="page" id="consignee_county_query">
		<div data-role="header" style="background-color: #CD0000;">
			<h1>选&nbsp;择&nbsp;区&nbsp;域</h1>
		</div>
		<div data-role="content">
			<button data-icon="arrow-l" value="返回" data-inline="true"
				id="consignee_county_back" data-theme="h">返回</button>
			<ul data-role="listview" data-inset="true" id="consignee_countys">
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
