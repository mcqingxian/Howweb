<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp"%>
<head>
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/wechat/FindPartner.css" />
</head>

<body>
 
	<div data-role="page" style="height:inherit !important">
		 <div id="wrapper" style="height: inherit;">
			<div id="wrapper-in" class="wrapper-in">
				<div id="main-page" class="main-page">
					<div class="header">
						<span class="btn-topl"> <a class="link-back"
							href="javascript:history.go(-1);"> <span
								class="ui-ico ui-ico-back"></span>
						</a>
						</span>
						<h1 class="innertitle">寻找销售合伙人</h1>
						<span class="btn-topr"> <a class="link-home"
							href="<%=request.getContextPath()%>/bse/index.action" title="主页"
							data-ajax='false'> <span class="ui-ico ui-ico-home"></span>
						</a> <a class="link-nav" href="javascript:void(0);"
							data-toggle="map-toggle"> <span class="ui-ico ui-ico-nav"></span>
						</a>
						</span>
					</div>
					<div class="container" style="height: 100%">
						<div class="detailOne">点击了解详情>></div>
        				<div class="detailTwo">点击了解详情>></div>
						<div class="btn_box">
							<span id="btn">销售合伙人咨询</span>
						</div>
	</div>
					
					<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/wechat/jquery-1.11.1.min.js"></script>
					<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/wechat/partner.js"></script>
				<%@ include file="../../bse/indexFooter.jsp"%>
				 </div>
				<div id="map-page">
					<%@ include file="../../bse/nav-map.jsp"%>
				</div>
		 	</div>
		</div>

	</div> 
	
</body>
</html>