<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %>  
<script src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="${scripts}/price_time.js"></script>
<meta charset="utf-8">
<title>价格时效</title>
</head>
<body>
	<div data-role="page" id="price_cal_query">
	<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">时效查询</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content" style="padding:1em 0;">
						<ul class="fm-list hwzz_search">
							<li>
								<label><font class="f_yellow">*</font>起运地</label>								
								<input type="text" class="input-text-line" name="depart" id="priceDepartCity" placeholder="请选择起运地" readonly="readonly" data-role="none" style="border:0px;"/>
								<input type="hidden" id="priceDepartEndpointID" />
								<input type="hidden" id="citypriceDepartEndpointID" />
								<a id="getDepartCity" class="location_icon"><img width="28" src="${images}/position.png"></a>
							</li>
							<li>
								<label><font class="f_yellow">*</font>目的地</label>
								<input type="text" class="input-text-line" name="arrive" id="priceDestCity" placeholder="请选择目的地" readonly="readonly" data-role="none" style="border:0px;"/>
								<input type="hidden" id="priceDestEndpointID" />
								<input type="hidden" id="citypriceDestEndpointID" />
								<a id="getDestCity" class="location_icon"><img width="28" src="${images}/position.png"></a>
							</li>
						</ul>
						<div class="login-action tc" style="margin-top: 10px;">
							<a href="javascript:void(0)" id="price_time_query_bt" data-inline="true" class="ui-btn btn-submit" data-ajax="false" style="width:35%;">查&nbsp;&nbsp;询</a>
							<a href="javascript:void(0)" id="price_cal_weight_bt" data-inline="true" class="ui-btn btn-submit" data-ajax="false" style="width:35%;">价格计算</a>
						</div>
						<ul data-role="listview" data-inset="true" id="price_cal_query_ul" class="price_cal_result">
						
						</ul>
						<div class="price_remark">
							<p>注:此价格时效仅供参考,</p>
							<p>详情请致电<a href="tel:400-808-6666" class="f_yellow"><span class="tel">400-808-6666</span></a></p>
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



	<!-- 价格计算出发省份查询 -->
	<div data-role="page" id="price_depart_province_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="price_depart_province_back">
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
						<ul data-role="listview" data-inset="true" id="price_depart_provinces">
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
		
	</div>
	<!-- 价格计算出发城市查询 -->
	<div data-role="page" id="price_depart_city_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="price_depart_city_back">
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
						<ul data-role="listview" data-inset="true" id="price_depart_citys">
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>
	
	<div data-role="page" id="price_depart_county_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="price_depart_county_back">
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
						<ul data-role="listview" data-inset="true" id="price_depart_countys">
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>
	<!-- 到达省份查询 -->
	<div data-role="page" id="price_dest_province_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="price_dest_province_back">
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
						<ul data-role="listview" data-inset="true" id="price_dest_provinces">
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>
	<!-- 价格计算到达城市查询 -->
	<div data-role="page" id="price_dest_city_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="price_dest_city_back">
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
						<ul data-role="listview" data-inset="true" id="price_dest_citys">
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>
	<!-- 价格计算到达区域查询 -->
	<div data-role="page" id="price_dest_county_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:void(0);" id="price_dest_county_back">
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
						<ul data-role="listview" data-inset="true" id="price_dest_countys">
						</ul>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>

	<!--重量体积输入 -->
	<div data-role="dialog" id="price_weight_volume_page" data-close-btn="right">
		<div data-role="header">
			<h1>重量体积</h1>
			<div data-role="navbar"></div>
		</div>
		<div data-role="content" class="price_time_dialog" style="padding:10px;">
			<table style="width: 100%">
				<tr>
					<td style="width:38%" align="right"><label for="weight"><span class="f_yellow">*</span>重量(公斤)</label></td>
					<td><input type="tel" name="weight" id="weight" placeholder="货物总重量" min="0" max="999999999" /></td>					
				</tr>
				<tr>
					<td align="right"><label for="volum"><span class="f_yellow">*</span>体积(m³)</label></td>
					<td><input type="tel" name="volum" id="volume" placeholder="货物总体积" min="0" max="999999999" /></td>
				</tr>	
				<tr>
					<td align="right"><label for="insurance"> <span class="f_yellow">*</span>保价(元)</label></td>
					<td><input type="tel" name="insurance" id="insurance" placeholder="" min="0" max="999999999" /></td>
				</tr>
				<tr>					
					<td align="right"><label for="collDeliveryAmount">代收货款(元)</label></td>
					<td><input type="tel" name="collDeliveryAmount" id="collDeliveryAmount" placeholder="" min="0" max="999999999" /></td>
				</tr>
				
			</table>
			<div style="color: #808080;">备注：重量与体积不输入默认为零</div>
			
			<div class="login-action tc">
				<a href="javascript:void(0)" id="price_cal_query_bt" data-inline="true" class="ui-btn btn-submit" data-ajax="false">价格计算</a>
			</div>
		</div>
	</div>

	<!-- 错误提示对话框 -->
	<div data-role="dialog" id="price_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="dialg_header"></h1>
		</div>
		<div data-role="content">
			<div align="center" id="price_dialog_con"></div>
		</div>
	</div>

	<!-- 弹出对话框 -->
	<div data-role="dialog" id="err_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="dialg_header">服务器异常</h1>
		</div>
		<div data-role="content">
			<div align="center" id="order_dialog_con">服务器内部错误，请稍后重试此请求。</div>
		</div>
	</div>
</body>
</html>