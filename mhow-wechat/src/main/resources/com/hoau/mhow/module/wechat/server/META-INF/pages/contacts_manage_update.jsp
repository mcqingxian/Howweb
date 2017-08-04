<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %>
<link rel="stylesheet" href="${styles}/public.css"/>	
<script src="${scripts}/contacts_manage_update.js"></script>
<script src="${scripts}/regex_test.js"></script>
<meta charset="utf-8">
<title>修改联系人</title>
</head>
<body>
<!-- 修改联系人信息 -->
<div data-role="page" id="update">
	<div id="wrapper">
		<div id="wrapper-in">
			<div id="main-page">
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:history.go(-1);">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">修改联系人</h1>
					<span class="btn-topr">
						<a class="link-home" href="bse/index.action" title="用户名" data-ajax='false'>
							<span class="ui-ico ui-ico-home"></span>
						</a>
						<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
							<span class="ui-ico ui-ico-nav"></span>
						</a>
					</span>
				</div>
				<div data-role="content">
					<ul class="fm-list hwzz_search">
						<li>
							<label>姓名:</label>
							<input id="name" class="input-text-line" name="" value='<s:property value="contactsEntity.ebsaContact" />' data-role="none"/>
						</li>
						<li>
							<label>手机号:</label>
							<input id="phone" class="input-text-line" name="" type="tel" value='<s:property value="contactsEntity.ebsaMobile" />' data-role="none"/>
						</li>
						<li>
							<label>省市区:</label>
							<input id="pro_city_cty" class="input-text-line" name="" value='${contactsEntity.ebsaEbpvName} ${contactsEntity.ebsaEbplName} ${contactsEntity.ebsaEbcoName}' data-role="none" />
							<a id="getPosition" class="location_icon ui-link"><img height="28" width="28" src="/mhow/images/wechat/position.png"></a>
						</li>
						<li>
							<label>详细地址:</label>
							<input id="detail_address" class="input-text-line" name="detail_address" value='<s:property value="contactsEntity.ebsaAddress" />' data-role="none" />
						</li>
					</ul>					
					<div id="notice" style="text-align: center; font-size:24px;color:red;margin-top: 50px;"></div>					
					<div class="order_manager_list_btn tc clearfix" style="border-top:0;">
						<a href="javascript:void(0)" id="delete_btn">删除</button><span id="delete_id" style="display: none;"><s:property value="contactsEntity.ebsaId" /></span>	
						<a href="javascript:void(0)" id="update_btn">修改</button><span id="update_id" style="display: none;"><s:property value="contactsEntity.ebsaId" /></span>
					</div>
				  </div>
				<%@ include file="../bse/footer.jsp" %>
			</div>
			<div id="main-page">
				<%@ include file="../bse/nav-map.jsp" %> 
			</div>
		</div>
	</div>
</div> 
<!-- 出发省份查询 -->
	<div data-role="page" id="depart_province_query">
		<div id="wrapper">		
			<div id="main-page">
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:void(0);" id="depart_province_back">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">选择省份</h1>	
					<span class="btn-topr">
						<a class="link-home" href="bse/index.action" title="用户名" data-ajax='false'>
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
			<div id="main-page">
				<%@ include file="../bse/nav-map.jsp" %> 
			</div>
		</div>
	</div>
	<!-- 出发城市查询 -->
	<div data-role="page" id="depart_city_query">
		<div id="wrapper">	
			<div id="main-page">	
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:void(0);" id="depart_city_back">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">选择城市</h1>		
					<span class="btn-topr">
						<a class="link-home" href="bse/index.action" title="用户名" data-ajax='false'>
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
			<div id="main-page">
				<%@ include file="../bse/nav-map.jsp" %> 
			</div>
		</div>
	</div>
	<!-- 出发区域查询 -->
	<div data-role="page" id="depart_county_query">
		<div id="wrapper">		
			<div id="main-page">
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:void(0);" id="depart_county_back">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">选择区域</h1>			
					<span class="btn-topr">
						<a class="link-home" href="bse/index.action" title="用户名" data-ajax='false'>
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
			<div id="main-page">
				<%@ include file="../bse/nav-map.jsp" %> 
			</div>
		</div>
	</div>
	
	<!-- 弹出对话框 -->
	<div data-role="dialog" id="msg_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="dialg_header"></h1>
		</div>
		<div data-role="content">
			<div align="center" id="msg_dialog_con"></div>
		</div>
	</div>
</body>
	