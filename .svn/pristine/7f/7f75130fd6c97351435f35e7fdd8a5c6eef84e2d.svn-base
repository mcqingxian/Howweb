<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common.jsp" %>
<title>官网首页</title>
</head>
<body>
<div id="wrapper">
	<div id="wrapper-in">
		<div id="main-page">
			<div class="header">
				<h1>
					<a href="index.action" data-ajax='false'><img src="${images}/hoaulogo.png" alt="" data-ajax="false"/></a>
				</h1>
				<span class="btn-topr">
					<a class="link-user" href="myHoau.action" title="用户中心" data-ajax="false">
						<span class="ui-ico ui-ico-user"></span>
					</a>
					<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle" data-ajax="false">
						<span class="ui-ico ui-ico-nav"></span>
					</a>
				</span>
			</div>
			<div class="grid-nav">
				<div class="banner">
					<img class="index-lazy" src="${images}/thumb_banner_mb.jpg" style="display: inline;">
				</div>
				<div class="navbar">
					<ul class="ui-navbar clearfix">
						<li><a href="<%=request.getContextPath()%>/bse/order.action" data-ajax='false'><span class="ui-ico ui-ico-ship"></span><span class="name">下单</span></a></li>
						<li><a href="<%=request.getContextPath()%>/toGoodsTracePage.action" data-ajax='false'><span class="ui-ico ui-ico-orderq"></span><span class="name">货物追踪</span></a></li>
						<li><a href="<%=request.getContextPath()%>/priceTime.action" data-ajax='false'><span class="ui-ico ui-ico-ageingq"></span><span class="name">时效价格</span></a></li>
						<li><a href="<%=request.getContextPath()%>/toDpartQueryPage.action" data-ajax='false'><span class="ui-ico ui-ico-servicepoint"></span><span class="name">网点查询</span></a></li>                
					</ul>
				</div>
			</div>
			<s:if test="#session.USER_INFO!=null">
				<div class="grid-con">
					<div class="title title2 clearfix">
						<h2 id="memmodelTitle">欢迎您，
							<span>
								<s:if test="#session.USER_INFO.ebccContactName!=null && #session.USER_INFO.ebccContactName!=''">
									<s:property  value="#session.USER_INFO.ebccContactName"/>
								</s:if>
								<s:elseif test="#session.USER_INFO.ebccNetLogin!=null && #session.USER_INFO.ebccNetLogin!=''">
									<s:property  value="#session.USER_INFO.ebccNetLogin"/>
								</s:elseif>
								<s:else>
									<s:property  value="#session.USER_INFO.ebccMobile"/>
								</s:else>
							</span>
						</h2>
						<a href="loginAction!exit.action" class="hard" data-ajax="false">[退出]</a>			
					</div>
					<div class="member-index clearfix">
						<ul>
							<li>
								<a class="box" href="queryMyOrders.action" data-ajax='false'>
									<span id="myRecNum" class="num">${sessionScope.USER_INFO.countOrders}</span>
									<span class="name">所有订单</span>
								</a>
							</li>
							<li>
								<a class="box" href="queryMyWaybills.action" data-ajax='false'>
									<span id="mySendNum" class="num">${sessionScope.USER_INFO.countWaybill}</span><span class="name">我的运单</span></a>
							</li>
							<li>
								<a class="box" href="../addressBookManage.action" data-ajax="false"><span id="myAddrNum" class="num">${sessionScope.USER_INFO.countContacts}</span><span class="name">我的地址簿</span></a>
							</li>
						</ul>
					</div>
				</div>
			</s:if>
			<div class="grid-con">
				<div class="title clearfix">
					<h2>产品业务</h2>
				</div>
				<div class="service-promotion clearfix">
					<ul>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-drdIntroduction.action" data-ajax="false">
								<i class="ui-ico in_product_icon01"></i>
								<b>定日达</b>
								<span>说到做到、定日必达</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-highway.action" data-ajax="false">
								<i class="ui-ico in_product_icon02"></i>
								<b>经济快运</b>
								<span>运输快捷，经济实用</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-vehicle.action" data-ajax="false">
								<i class="ui-ico in_product_icon03"></i>
								<b>专车达</b>
								<span>专车保运，放心承运</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-collectingMoney.action" data-ajax="false">
								<i class="ui-ico in_product_icon04"></i>
								<b>代收货款</b>
								<span>货款回收，便捷安全</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-insuredTransport.action" data-ajax="false">
								<i class="ui-ico in_product_icon05"></i>
								<b>保价运输</b>
								<span>安全保价，放心托运</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-safePackaging.action" data-ajax="false">
								<i class="ui-ico in_product_icon06"></i>
								<b>安全包装</b>
								<span>专业打包，暖心服务</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-deliveryService.action" data-ajax="false">
								<i class="ui-ico in_product_icon07"></i>
								<b>送货服务</b>
								<span>定时定点，足不出户</span>
							</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/bse/topage_m-others.action" data-ajax="false">
								<i class="ui-ico in_product_icon08"></i>
								<b>其他增值服务</b>
								<span>更多服务，查看详情</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="grid-con" style="margin-bottom:1.125em">
				<div class="title clearfix">
					<h2>市场活动</h2>
					<!-- <a class="ar" href="#"><span class="ui-ico ui-ico-more"></span></a> -->
				</div>
				<div class="swiper-container">
					<c:choose>
						<c:when test="${!empty marketList}">
							<div class="swiper-wrapper">
									<c:forEach var="market" items="${marketList}">
										<c:if test="${market.isDisable!=true}">
											<a class="swiper-slide" href="queryNewsDetail.action?newsId=${market.id}&rowNum=${market.rowNum}&forJump=${market.categoryName}" data-ajax="false">
												<img src="${images}/market/${market.sltSrc }" width="100%" />
											</a>
										</c:if>
									</c:forEach>
							</div>
							<div class="swiper-pagination"></div>
						</c:when>
						<c:otherwise>
							<img src="${images}/market/default.jpg" width="100%" />
							<div class="event_end">
								<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td align="center">目前没有活动！</td>
									</tr>
								</table>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				
			</div>
			<%@ include file="indexFooter.jsp" %> 
		</div>
		<div id="map-page">
			<%@ include file="nav-map.jsp" %>
		</div>
	</div>
</div>
<script type="text/javascript"> 
 (function($){
	 var mySwiper = new Swiper('.swiper-container', {
			autoplay: 5000,//可选选项，自动滑动
			pagination : '.swiper-pagination',
	 })
 })(jQuery);
</script>
</body>
