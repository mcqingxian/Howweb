<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp"%>
<head>
<title></title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/wechat/counsel.css" />
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
						<h1 class="innertitle">天地华宇合伙人</h1>
						<span class="btn-topr"> <a class="link-home"
							href="<%=request.getContextPath()%>/bse/index.action" title="主页"
							data-ajax='false'> <span class="ui-ico ui-ico-home"></span>
						</a> <a class="link-nav" href="javascript:void(0);"
							data-toggle="map-toggle"> <span class="ui-ico ui-ico-nav"></span>
						</a>
						</span>
					</div>


					<div class="imgBox">
						<img src="../images/wechat/partner_qr_code.png" alt="">
						<p>合伙人公众号</p>
					</div>
					<div class="telBox">
						<div style="float:left;margin-left: 15%;margin-top: 7px;">
						咨询电话：
						</div>
						<div style="float: left;margin-left: 2%;">
						<p>
							  17317386169（马经理)
							 </p>
							 <p>021-62636142（固定电话）</p>

 
						</div>
					</div>
					<div class="mask" style="display: none"></div>
					<div class="container-mask" style="display: none">
						<p>
							<a href="tel:18271927608">17317386169（马经理）</a>
						</p>
						<p>
							<a href="tel:021-62636120">021-62636142（固定电话）</a>
						</p>
					</div>

					<script type="text/javascript"
						src="<%=request.getContextPath()%>/scripts/wechat/partner.js"></script>
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