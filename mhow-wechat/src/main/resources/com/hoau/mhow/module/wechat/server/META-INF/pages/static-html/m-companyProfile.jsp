<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp" %> 
<title>公司概述</title> 
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
						<h1 class="innertitle">公司概述</h1>
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
							<p>　　天地华宇是中信产业投资基金管理有限公司（简称中信产业基金）旗下的全资公司，也是国家第一批"AAAAA"级资质的物流企业,包含苏州万隆物流有限公司、上海华振物流有限公司等天地华宇的前身华宇物流1995年成立于广州，总部设在上海，拥有中国最大的公路快运网络之一。截止2015年1月，天地华宇在全国600个大中城市拥有54个货物转运中心、1500家营业网点和16000名员工。</p>
							<p>　　天地华宇为中国公路快运行业的领先企业，其服务产品有"定日达"、"零担运输"和"整车特运"等，并提供代收货款等多种增值服务。"定日达"是天地华宇面向企业客户推出高端公路快运服务产品，以"准时、安全、优质服务"的特性，让客户以不到航空货运1/3的价格，享受堪比航空货运的高性价比服务，成为包括全球财富500强在内的众多企业级客户首选的公路快运产品之一。</p>
							<p>　　在中信产业基金强有力的领导与支持下，天地华宇致力于打造成为国内领先和最值得信赖的高效物流服务提供商，将继续加大运营（门店、大型分拨中心及线路优化）、IT系统、员工培训及车辆采购等方面的投入，巩固其在定日公路快运市场的领先地位。</p>
							<p>　　天地华宇遵循"以人为本"的人才战略，拥有较为完善的员工管理与福利制度，不断加强员工的培训与职业规划，为全体员工提供良好的职业发展环境和广阔的发展平台，为客户提供最佳的服务体验。</p>
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