<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<script src="<%=request.getContextPath()%>/scripts/wechat/mobile_binding.js"></script>  
<title>更改绑定手机</title>
</head>
<body>
<div data-role="page" id="pageone">
<div id="wrapper">
	<div id="wrapper-in">
		<div id="main-page">
			<div class="header">
				<span class="btn-topl">
					<a class="link-back" href="javascript:history.go(-1);">
						<span class="ui-ico ui-ico-back"></span>
					</a>
				</span>
				<h1 class="innertitle">更改绑定手机</h1>
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
				<div class="grid-main">
					<div class="form-reg">
						<ul class="fm-list">
							<li>
								<label>旧手机号</label>
								<input type="tel" class="input-text-line" readonly="readonly" value="${sessionScope.USER_INFO.ebccMobile}">
							</li>
							<li class="fm-checkcode">
								<label>新手机号</label>
								<input id="phoneNo" class="input-text-line" name="phoneNo" type="tel" data-role="none"  placeholder="请输入11位手机号码"/>
							</li>
							<li class="fm-checkcode">
								<label>验证码</label>
								<input id="validateCode" class="input-text-line" type="tel" data-role="none" style="border:0px;width:100%" placeholder="请输入验证码">
								<span class="btn-r">
									<a href="javascript:void(0)" id="getValidateCode" class="ui-btn btn-normal" style="padding:0px;margin:0px;height:30px;line-height: 30px;color: #FFFFFF">获取验证码</a>
									<span id="countdown" style="display: none"></span>
								</span>
							</li>
						</ul>
						<div class="reg-action">
							<a id="confirmBinding" class="ui-btn btn-submit" data-ajax='false'>提交</a>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="../footer.jsp" %> 
		</div>
		<div id="map-page">
    		<%@ include file="../nav-map.jsp" %>
    	</div>
	</div>
</div>
</div>
<!-- 弹出对话框 -->
<div data-role="dialog" id="mbile_binding_dialog" data-close-btn="right">
	<div data-role="header">
		<h1 id="mbile_binding_header"></h1>
	</div>
	<div data-role="content">
		<div align="center" id="mbile_binding_dialog_con"><s:property value='errorMsg'/></div>
	</div>
</div>
</body>
</html>
