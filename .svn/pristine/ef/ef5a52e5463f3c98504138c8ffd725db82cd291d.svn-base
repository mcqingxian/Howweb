<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %> 
<title>网点查询</title>
<script src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="${scripts}/department_query.js"></script>
</head>
<body>
	<!-- 附近门店列表 -->
	<div data-role="page" id="department_query">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">网点查询</h1>
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
								<label><font class="f_yellow">*</font>所在地区:</label>								
								<input id="pro_city_cty" class="input-text-line" placeholder="请选择起运地" data-role="none" name="pro_city_cty" type="text" readonly="readonly" value=""/>
								<a id="getPosition" class="location_icon"><img height=28 width=28 src="${images}/position.png"></a>
							</li>
						</ul>
			           	<div class="login-action">							
							<a href="javascript:void(0)" id ="departmentQueryBtn" class="ui-btn btn-submit">查询</a>
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
	
	<!-- 出发省份查询 -->
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
</body>
</html>
