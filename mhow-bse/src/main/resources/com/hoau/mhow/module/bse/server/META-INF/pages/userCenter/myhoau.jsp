<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>  
<title>我的华宇</title>
</head>
<body>
<div id="wrapper">
	<div id="wrapper-in">
		<div id="main-page">
			<div class="header">
				<span class="btn-topl">
					<a class="link-back" href="javascript:history.go(-1);">
						<span class="ui-ico ui-ico-back"></span>
					</a>
				</span>
				<h1 class="innertitle">我的华宇</h1>
				<span class="btn-topr">
					<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
						<span class="ui-ico ui-ico-home"></span>
					</a>
					<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
						<span class="ui-ico ui-ico-nav"></span>
					</a>
				</span>
			</div>
			<div class="grid-member">
				<span class="ui-ico grid-member-pic">
					
				</span>
				<span class="btn-right">
						<span class="text" id="mobile">${sessionScope.USER_INFO.ebccMobile}</span>
						<a href="myAccount.action" data-ajax='false'><span class="ui-ico ui-ico-right"></span></a>
				</span>
			</div>
			<div class="grid-main">
				<ul class="func-link">
					<li>
						<a class="func-item" href="queryMyOrders.action" data-ajax='false'>
							<span class="ui-ico ui-ico-m-receive"></span>
							<span class="btn-right"><span class="text">所有订单</span><span class="ui-ico ui-ico-right"></span></span>
						</a>
					</li>
					<li>
						<a class="func-item" href="queryMyWaybills.action" data-ajax='false'>
							<span class="ui-ico ui-ico-m-ship"></span>
							<span class="btn-right"><span class="text">我的运单</span><span class="ui-ico ui-ico-right"></span></span>
						</a>
					</li>
					<li>
						<a class="func-item" href="../addressBookManage.action" data-ajax='false'>
							<span class="ui-ico ui-ico-m-address"></span>
							<span class="btn-right"><span class="text">我的地址簿</span><span class="ui-ico ui-ico-right"></span></span>
						</a>
					</li>
				</ul>
			</div>
			<div class="grid-btn">
				<a class="ui-btn btn-ship-primary" href="order.action" data-ajax='false'>我要下单</a>
			</div>	
			<%@ include file="../footer.jsp" %> 
		</div>
		<div id="map-page">
    		<%@ include file="../nav-map.jsp" %>
    	</div>
	</div>
</div>
</body>
<script type="text/javascript">
	(function($){
		var tel = $('#mobile').text();
		$('#mobile').html(tel.replace(tel.substring(4,7),'****'));
	})(jQuery);
</script>

