<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%String type = request.getParameter("ebsaType"); %>
<%@ include file="../bse/common.jsp" %>
<link rel="stylesheet" href="${styles}/public.css"/>
<script src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script src="${scripts}/contact_curd.js"></script>
<script src="${scripts}/regex_test.js"></script>
<meta charset="utf-8">
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="imagetoolbar" content="no">
<title></title>
</head>
<body>
	<!-- 新增联系人 -->
	<div data-role="page" id="add">
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
					<div data-role="content">
						<ul class="fm-list hwzz_search" id="submitparam">
							<li>
								<label>联系人类型:</label>
									<input id="type" data-add="<%=type%>" readonly="readonly" data-update="<s:property value='contactsEntity.ebsaType'/>"  class="input-text-line" />
							</li>
							<li>
								<label id="contactName"></label>
								<input id="name" class="input-text-line" name="add_name" data-role="none" value="<s:property value='contactsEntity.ebsaContact'/>" />
								<span id="ebsaId" style="display: none"><s:property value='contactsEntity.ebsaId'/></span>
							</li>
							<li>
								<label>手机号码:</label>
								<input id="phone" class="input-text-line" name="add_phone" type="number" data-role="none" value="<s:property value='contactsEntity.ebsaMobile'/>" />
							</li>
							<li>
								<label>固定电话:</label>
								<input id="areacode" class="input-text-line" name="add_area" data-role="none" data-inline="true" placeholder="区号" style="width:20%" value="<s:property value='contactsEntity.ebsaContactAreaCode'/>"/>
								-- <input id="tel" class="input-text-line" name="add_tel" data-role="none" data-inline="true" placeholder="请输入固话号码" style="width:70%" value="<s:property value='contactsEntity.ebsaContactTel'/>"/>
							</li>
							<li id="company_text">
								<label>公司名称:</label>
								<input id="company" class="input-text-line" name="add_company"data-role="none" value="<s:property value='contactsEntity.ebsaCompany'/>" />
							</li>
							<li>
								<label id="address"></label>
								<input id="pro_city_cty" class="input-text-line" name="add_pro_city_cty" data-role="none" value="<s:property value='contactsEntity.ebsaDeptDistrict'/>" 	/>
								<a id="getPosition" class="location_icon"><img height=28 width=28 src="<%=request.getContextPath()%>/images/wechat/position.png"></a>
							</li>
							<li>
								<label><span class="f_yellow">*</span>详细地址:</label>
								<input id="detail_address" class="input-text-line" name="add_detail_address" data-role="none" placeholder="请填写所在街道及详细地址" value="<s:property value='contactsEntity.ebsaAddress'/>"/>
							</li>
							<li id="shipperSlwd_text">
								<label>发货网点:</label>
								<input type="text" id="shipperSlwd" class="input-text-line" readonly="readonly" data-role="none" 
									placeholder="请点击" value="<s:property value='contactsEntity.ebsaEscoSecondName'/>" />
								<input type="hidden" id="shipperSlwd_code" readonly="readonly" value="<s:property value='contactsEntity.ebsaEscoSecondCode'/>" />
							</li>
						</ul>
						<div class="login-action tc">							
							<a href="javascript:void(0)" id="addOrUpdate" data-inline="true" class="ui-btn btn-submit" data-ajax="false" style="width:25%;">保存</a>
							<a href="javascript:void(0)" id="cancel" data-inline="true" class="ui-btn btn-submit" data-ajax="false" style="width:25%;">取消</a>
							<a href="javascript:void(0)" id="reset" data-inline="true" class="ui-btn btn-submit" data-ajax="false" style="width:25%;">重置</a>
						</div>	
						</div>
						<%@ include file="../bse/footer.jsp" %> 			
					</div>
					<div id="map-page">
						<%@ include file="../bse/nav-map.jsp" %>  
			    	</div>
				</div>
			</div>
	</div> 
	
	<!-- 出发省市查询 -->
	<div data-role="page" id="depart_province_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="depart_province_back">
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
						<ul data-role="listview" data-inset="true" id="depart_provinces">
						
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>	
		</div>		
	</div>
	
	<!-- 出发城市查询 -->
	<div data-role="page" id="depart_city_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="depart_city_back">
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
						<ul data-role="listview" data-inset="true" id="depart_citys">
						
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>	
		</div>
	</div>
	
	<!-- 出发区域查询 -->
	<div data-role="page" id="depart_county_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">	
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="depart_county_back">
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
						<ul data-role="listview" data-inset="true" id="depart_countys">
						
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
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
						<ul data-role="listview" data-inset="true" id="shipper_branches" class="shipper_branches">
		
						</ul>	
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>
	
	<!-- 弹出对话框 -->
	<div data-role="dialog" id="msg_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="dialg_header">提示</h1>
		</div>
		<div data-role="content">
			<div align="center" id="msg_dialog_con"></div>
		</div>
	</div>
</body>
