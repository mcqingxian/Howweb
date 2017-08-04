<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp"%>
<head>
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/wechat/FindPartnerb.css" />
</head>

<body>

	<div data-role="page" style="height: inherit !important">
		<div id="wrapper" style="height: inherit;">
			<div id="wrapper-in" class="wrapper-in">
				<div id="main-page" class="main-page">
					<div class="header">
						<span class="btn-topl"> <a class="link-back"
							href="javascript:history.go(-1);"> <span
								class="ui-ico ui-ico-back"></span>
						</a>
						</span>
						<h1 class="innertitle">天地华宇销售合伙人</h1>
						<span class="btn-topr"> <a class="link-home"
							href="<%=request.getContextPath()%>/bse/index.action" title="主页"
							data-ajax='false'> <span class="ui-ico ui-ico-home"></span>
						</a> <a class="link-nav" href="javascript:void(0);"
							data-toggle="map-toggle"> <span class="ui-ico ui-ico-nav"></span>
						</a>
						</span>
					</div>

					<div class="container">
						<div class="btn_box">
							<!--            <p>合伙人收益等详细信息请点击<span>合伙人咨询</span>查看</p>-->
							<span id="btn">销售合伙人咨询</span>
						</div>
						<div class="first">
							<div class="img_box">
								<img src="../images/wechat/condition.png" class="bg" alt="">
								<p class="fontOne">市场环境</p>
								<img src="../images/wechat/striangle.png" class="triangle"
									alt="">
							</div>
							<div class="txt">
								<ul class="detail" style="list-style: inherit !important">
									<li>天地华宇优质的服务和品牌力量；</li>
									<li>有竞争力的价格；</li>
									<li>超高的性价比适用于物流市场98%的客户。</li>
								</ul>
							</div>
						</div>
						<div class="second">
							<div class="img_box">
								<img src="../images/wechat/mode.png" class="bg" alt="">
								<p class="fontTwo">合伙模式</p>
								<img src="../images/wechat/striangle.png" class="triangle"
									alt="">
							</div>
							<div class="txt">
								<ul class="detail" style="list-style: inherit !important">
									<li>前期不需要投入；</li>
									<li>注册后即是销售合伙人；</li>
									<li>发货享提成，推广得奖励；</li>
									<li>降低物流成本，还能享受收益。</li>
								</ul>
							</div>
						</div>
						<div class="three">
							<div class="img_box">
								<img src="../images/wechat/get.png" class="bg" alt="">
								<p class="fontThree">销售合伙人收益</p>
								<img src="../images/wechat/n8.png" class="triangle"
									alt="">
							</div>
						</div>
						<div class="four">
							<div class="first">
								<h3>1.提成奖</h3>
								<div class="box">
									<h4 style="margin:10px">提成奖=发货产值×提成比例</h4>
									<p style="margin:10px">* 按照产值予以奖励，产值越高，比例越高。</p>
									<p style="margin:10px">* 当折扣不同时，提成比例随之变化。</p>
									<div class="bg_box">
										<img src="../images/wechat/n1.png" alt="">
									</div>
								
								</div>
							</div>
							<div class="second">
								<h3>2.推广奖</h3>
								<div class="box">
									<h4 style="margin:10px">推广奖=推广总产值对应提成 — 个人提成之和</h4>
									<p style="margin:10px">* 推广所有合伙人的产值之和对应的提成，减去这些人的提成之和，差值即推广奖。</p>
									<div class="bg_box">
										<img src="../images/wechat/n2.png" alt="">
									</div>
								</div>
							</div>
							<!-- <div class="third">
								<h3>3.培养奖</h3>
								<div class="box">
									<h4 style="margin:10px">推广的销售合伙人达到一定标准后，可以获得额外的奖励</h4>
									<div class="award">
										<img src="../images/wechat/n3.png" alt="">
									</div>
									<p style="margin:10px">* 注：当月产值超过5000元即为活跃销售合伙人。</p>
									<div class="bg_box">
										<img src="../images/wechat/n4.png" alt="">
									</div>
								</div>
							</div>
							<div class="fourth">
								<h3>4.介绍奖</h3>
								<div class="box">
									<h4 style="margin:10px">给天地华宇介绍意向销售合伙人信息，销售合伙人推广成功后给予介绍奖。</h4>
									<div class="bg_box">
										<img src="../images/wechat/n5.png" alt="">
									</div>
								</div>
							</div> -->
						</div>


						<script type="text/javascript"
							src="<%=request.getContextPath()%>/scripts/wechat/partnerb.js"></script>
					</div>
					<div class="foot">
						<p>天地华宇期待与你合作</p>
					</div>
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