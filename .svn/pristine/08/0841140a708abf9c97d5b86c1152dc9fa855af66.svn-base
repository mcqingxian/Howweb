<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>  
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/wechat/public.css"/>	
<script src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="${scripts}/order/place_order.js"></script>
<meta charset="utf-8">
<title></title>
<style>
.ui-select span{text-align:left;}
.ui-select{margin-top: .3em;}
</style>
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
						<h1 id="pageTitle" class="innertitle"></h1>
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
					<div data-role="collapsible" data-collapsed="false" data-inset="true" class="order_box_manager" style="width: 100%; padding:.5em 0">
		    			<h4>发货人信息</h4>
						<input type="hidden" id="orderId" value="<s:property value='order.einoId '/>">
						<input type="hidden" id="einoContractNo" value="<s:property value='order.einoContractNo'/>">
						<ul class="fm-list consignee_info">
							<li>
								<label><span class="f_yellow">*</span>发货人:</label>
								<input type="text" id="shipperName" class="input-text-line" data-role="none" maxlength="20" value='<s:property value='order.einoShipperEbsaContact'/>' />
								<a id="query_shipper" class="location_icon"><img height=28 width=28 src="<%=request.getContextPath()%>/images/wechat/person.png"></a>
							</li>
							<li>
								<label><span class="f_yellow">*</span>发货手机:</label>
								<input type="tel" id="shipperMobile" class="input-text-line" data-role="none"
									maxlength="30" value="<s:property value='order.einoShipperEbsaMobile'/>" />
							</li>
							<li>
								<label>固定电话:</label>
								<input type="tel" id="shipperAreaCode" class="input-text-line" data-role="none" data-inline="true" placeholder="区号" style="width:20%" maxlength="30" value="<s:property value='order.einoShipperEbsaAreaCode'/>" />-- 
								<input type="tel" id="shipperTel" class="input-text-line" data-role="none" data-inline="true" placeholder="请输入固话号码" style="width:70%" maxlength="30" value="<s:property value='order.einoShipperEbsaTel'/>" />
							</li>
							<li>
								<label>公司名称:</label>
								<input type="text" id="einoShipperEbspNameCn" class="input-text-line" data-role="none"
									maxlength="30" value="<s:property value='order.einoShipperEbspNameCn'/>" />
							</li>
							<li>
								<label><span class="f_yellow">*</span>发货省市区:</label>
								<input type="text" id="shipperProv" class="input-text-line" readonly="readonly" data-role="none"
									placeholder="请点击" value="<s:property value='order.shipperDistrict'/>" />
								<a id="shipper_location" class="location_icon"><img height=28 width=28 src="<%=request.getContextPath()%>/images/wechat/position.png"></a>
							</li>
							<li>
								<label><span class="f_yellow">*</span>详细地址:</label>
								<input type="text" id="shipperAddress" class="input-text-line" data-role="none" 
									value="<s:property value='order.einoShipperEbsaAddress'/>" placeholder="请填写所在街道及详细地址" />
							</li>
							<li>
								<label><span class="f_yellow">*</span>受理网点:</label>
								<input type="text" id="shipperSlwd" class="input-text-line" readonly="readonly" data-role="none" 
									placeholder="请点击" value="<s:property value='order.einoEscoSecondName'/>" />
								<input type="hidden" id="shipperSlwd_code" readonly="readonly" value="<s:property value='order.einoEscoSecondCode'/>" />
							</li>
							<li>
								<label>网点信息:</label>
								<input type="text" id="einoSecondDistrict" class="input-text-line" readonly="readonly" data-role="none" readOnly="readonly" value='<s:property value="order.companyMsg"/>'/>
							</li>
							<li>
								<label><span class="f_yellow">*</span>提货方式:</label>
								<select id="einoDoorCanvass"  data-shadow="false" >
										<option value="Y" <s:if test="order.einoDoorCanvass==\"Y\"">selected="selected"</s:if>>上门提货</option>
										<option value="N" <s:if test="order.einoDoorCanvass==\"N\"">selected="selected"</s:if>>客户自送</option>
								</select>
							</li>
						</ul>	
					</div>
					
					<!-- 收货人信息 -->
					<div data-role="collapsible" data-inset="true" class="order_box_manager" style="padding:.5em 0">
		    			<h4>收货人信息</h4>
						<ul class="fm-list consignee_info">
							<li>
								<label><span class="f_yellow">*</span>收货人:</label>
								<input type="text" id="consigneeName" class="input-text-line" data-role="none" maxlength="20" value="<s:property value='order.einoConsigneeEbsaContact'/>"/>
								<a id="query_consignee" class="location_icon"><img height=28 width=28 src="<%=request.getContextPath()%>/images/wechat/person.png"></a>
							</li>
							<li>
								<label><span class="f_yellow">*</span>收货手机:</label>
								<input type="tel" id="consigneeMobile" class="input-text-line" data-role="none" maxlength="30" value="<s:property value='order.einoConsigneeEbsaMobile'/>"/>
							</li>
							<li>
								<label>固定电话:</label>
								<input id="consigneeAreaCode" class="input-text-line" data-role="none" data-inline="true" placeholder="区号" style="width:20%" maxlength="30" value="<s:property value='order.einoConsigneeEbsaAreaCode'/>"/>-- 
								<input type="tel" id="consigneeTel" class="input-text-line" data-role="none" data-inline="true" placeholder="请输入固话号码" style="width:70%" maxlength="30" value="<s:property value='order.einoConsigneeEbsaTel'/>"/>
							</li>
							<li>
								<label><span class="f_yellow">*</span>收货省市区:</label>
								<input type="text" id="consigneeProv" class="input-text-line" readonly="readonly" data-role="none" placeholder="请点击" value="<s:property value='order.consigneeDistrict'/>" />
								<a id="consignee_location" class="location_icon"><img height=28 width=28 src="<%=request.getContextPath()%>/images/wechat/position.png"></a>
							</li>
							<li>
								<label><span class="f_yellow">*</span>详细地址:</label>
								<input type="text" id="consigneeAddress" class="input-text-line" data-role="none" placeholder="请填写所在街道及详细地址" value="<s:property value='order.einoConsigneeEbsaAddress'/>" />
							</li>
						</ul>
					</div>
					<div class="grid-btn">
						<div class="login-action tc" style="margin-top: 10px;">
							<a href="javascript:void(0)" id="submit_order_bt" data-inline="true" class="ui-btn btn-submit" data-ajax="false"></a>
						</div>
					</div>
					<p style="margin-top:25px;width:100%;text-align:center;">
						<a href="http://a.app.qq.com/o/simple.jsp?pkgname=net.hoau" target="_balank" style="color: #CD0000;">下载华宇官方APP，一键查询、下单</a>
					</p>
				</div>
					<!-- 主要内容end -->
					<%@ include file="../footer.jsp" %>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 发货人查询 -->
	<div data-role="page" id="shipper_query" >
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="shipper_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">发货人</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<s:if test="shipperContacts!=null&&!shipperContacts.isEmpty()">
							<ul data-role="listview" data-inset="true" id="shippers" class="shipper_branches">
								<s:iterator value="shipperContacts" status="status">
									<li id="<s:property value='#status.index'/>_shipper_li">
										<span>姓名：<s:property value="ebsaContact" /></span><br />
										<span>联系电话：<s:property value="ebsaMobile" /></span><br />
										<span>所在区域：<s:property value="ebsaAddress" /></span><br />
										<span>发货网点：<s:property value="ebsaEscoSecondName" /></span>											
											<input type="hidden"
											id="<s:property value='#status.index'/>_shipper_name"
											value="<s:property value="ebsaContact"/>" /> <input type="hidden"
											id="<s:property value='#status.index'/>_shipper_phone"
											value="<s:property value="ebsaMobile"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_shipper_tel"
											value="<s:property value="ebsaContactTel"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_shipper_company"
											value="<s:property value="ebsaCompany"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_shipper_detail_address"
											value="<s:property value="ebsaAddress"/>" /> <input type="hidden"
											id="<s:property value='#status.index'/>_shipper_pro_city_cty"
											value="<s:property value="ebsaDeptDistrict"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_shipperSlwd"
											value="<s:property value="ebsaEscoSecondName"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_shipperSlwd_code"
											value="<s:property value="ebsaEscoSecondCode"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_shipper_area_code"
											value="<s:property value="ebsaContactAreaCode"/>" />
											</li>
								</s:iterator>
							</ul>
						</s:if>
						<s:else>
							<p style="margin-top: 100px; text-align: center;">你还没有添加发货联系人</p>
						</s:else>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>		
	</div>
	<!-- 出发省份查询 -->
	<div data-role="page" id="shipper_province_query">		
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="shipper_province_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择省份</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="shipper_provinces">
			
						</ul>	
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>		
	</div>
	<!-- 出发城市查询 -->
	<div data-role="page" id="shipper_city_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="shipper_city_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择城市</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="shipper_citys">

						</ul>	
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>		
	</div>
	<!-- 出发区域查询 -->
	<div data-role="page" id="shipper_county_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="shipper_county_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择区域</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="shipper_countys">

						</ul>	
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>
	</div>
	
	
	<!-- 受理网点查询 -->
	<div data-role="page" id="shipper_branches_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="shipper_branches_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择网点</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="shipper_branches" class="shipper_branches" style="margin:1em 0;">

						</ul>	
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>		
	</div>

	<!-- 收货人查询 -->
	<div data-role="page" id="consignee_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="consignee_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">收货人</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<s:if test="consigneeContacts!=null&&!consigneeContacts.isEmpty()">
							<ul data-role="listview" data-inset="true" id="consignees" class="shipper_branches">
								<s:iterator value="consigneeContacts" status="status">
									<li id="<s:property value='#status.index'/>_consignee_li">
										<span>姓名：<s:property value="ebsaContact" /></span><br />
										<span>联系电话：<s:property value="ebsaMobile" /></span><br />
										<span>详细地址：<s:property value="ebsaAddress" /></span><br /> 
											<input type="hidden"
										id="<s:property value='#status.index'/>_consignee_name"
										value="<s:property value="ebsaContact"/>" /> <input type="hidden"
										id="<s:property value='#status.index'/>_consignee_phone"
										value="<s:property value="ebsaMobile"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_consignee_tel"
											value="<s:property value="ebsaContactTel"/>" /> <input type="hidden"
										id="<s:property value='#status.index'/>_consignee_detail_address"
										value="<s:property value="ebsaAddress"/>" /> <input type="hidden"
										id="<s:property value='#status.index'/>_consignee_pro_city_cty"
										value="<s:property value="ebsaDeptDistrict"/>" /><input type="hidden"
											id="<s:property value='#status.index'/>_consignee_area_code"
											value="<s:property value="ebsaContactAreaCode"/>" />
										</li>
								</s:iterator>
							</ul>
						</s:if>
						<s:else>
							<p style="margin-top: 100px; text-align: center;">你还没有添加收货联系人</p>
						</s:else>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>		
	</div>
	
	<!-- 出发省市查询 -->
	<div data-role="page" id="consignee_province_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="consignee_province_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择省份</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="consignee_provinces">
						
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>		
	</div>
	
	<!-- 出发城市查询 -->
	<div data-role="page" id="consignee_city_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="consignee_city_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择城市</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="consignee_citys">
						
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
		</div>
	</div>
	
	<!-- 出发区域查询 -->
	<div data-role="page" id="consignee_county_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="consignee_county_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">选择区域</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<ul data-role="listview" data-inset="true" id="consignee_countys">
						
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %>
				</div>
			</div>	
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
