<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>  
<title>我的账户</title>
</head>
<body>
<div id="wrapper">
	<div id="wrapper-in">
		<div id="main-page">
			<div class="header">
				<span class="btn-topl">
					<a class="link-back" href="javascript:history.go(-1);" data-ajax='false'>
						<span class="ui-ico ui-ico-back"></span>
					</a>
				</span>
				<h1 class="innertitle">我的账户</h1>
				<span class="btn-topr">
					<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
						<span class="ui-ico ui-ico-home"></span>
					</a>
					<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle" >
						<span class="ui-ico ui-ico-nav"></span>
					</a>
				</span>
			</div>
			<div class="grid-main">
				<form class="form-login">
					<div class="ui-collapsible" style="margin:0;">
						<ul class="func-link">
							<li class="fm-item">
								<span class="ui-ico ico-user"></span>
								<span class="fill-text">${sessionScope.USER_INFO.ebccNetLogin}</span>
							</li>
							<li class="fm-item">
								<span class="ui-ico ico-phone"></span>
								<a href="updatePhone.action" class="btn-right" data-ajax='false'>
									<span class="fill-text bind-phone clearfix">
										<span id="mobilemsg" class="txt">已绑定手机号:${sessionScope.USER_INFO.ebccMobile}</span>
										<span id="mobileaction" class="hot f_yellow">修改</span>
									</span>
									<span class="ui-ico ui-ico-right"></span>
								</a>
							</li>
							<li class="fm-item">
								<span class="ui-ico ico-pwd"></span>
								<a href="updatePassword.action" class="btn-right" data-ajax='false'>
									<span class="fill-text">修改账户密码</span>
									<span class="ui-ico ui-ico-right"></span>
								</a>
							</li>
						</ul>
					</div>
				</form>
			</div>
			<%@ include file="../footer.jsp" %> 
		</div>
		<div id="map-page">
    		<%@ include file="../nav-map.jsp" %>
    	</div>
	</div>
</div>
</body>
</html>
