<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp" %> 
<title>定日达</title> 
</head>

<body>
<div data-role="page">
	<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">定日达</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div class="hoau_news">
						<div class="drd_pic"><img src="../images/wechat/150602_img02.jpg" width="100%"></div>
						<div class="news_content">
							<p><strong style="color:#000">定日达基本介绍</strong></p>
							<p>　　"定日达"是天地华宇2009年2月推出面向企业客户提供高端公路快运服务的产品，它以"准时、安全、优质服务"作为核心价值，高度的时效性和安全性成为中国公路快运服务的领先品牌。1/3的航空货运价格享受堪比航空货运的服务，超高的性价比成为全球财富500强在内众多企业级客户的首选公路快运产品。截止2015年8月，天地华宇拥有3000余条"定日达"运营线路，1600余个"定日达"服务网点，涵盖环渤海湾、长江三角洲、珠江三角洲、东北三省以及中西部经济活跃地区</p>
							<br>
							<p><img src="../images/wechat/drd_img04.jpg" width="100%" alt="定日达"></p>
							<br>
							<p><strong style="color:#000">定日达三大核心价值</strong></p>					
							<p>　　<strong>准时：</strong>定日达车辆统一安装GPS全球定位系统，实现运输过程全程追踪与时效实时监控，确保客户货物准点到达。</p>
							<p>　　<strong>安全：</strong>定日达车辆封闭式车厢从发车至到达全程封闭，全程GPS监控，确保客户货物安全抵达。</p>
							<p>　　<strong>优质服务：</strong>更专业的客服团队给客户提供一对一的贴心服务，免费提供到货通知，确保客户高枕无忧。</p>
							
						</div>
					</div>
					<%@ include file="../../bse/footer.jsp" %> 			
				</div>
				<div id="map-page">
					<%@ include file="../../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>

</div>
</body>
</html>