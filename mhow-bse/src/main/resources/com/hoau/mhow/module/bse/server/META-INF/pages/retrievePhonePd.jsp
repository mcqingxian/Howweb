<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<script src="<%=request.getContextPath()%>/scripts/bse/retrievePhonePd.js"></script> 
<script>
	var system_bse_url = '<%=request.getContextPath()%>/bse/';
</script>  
<title>找回密码</title>
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
					<h1 class="innertitle">找回密码</h1>
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
									<label><span class="f_yellow">*</span>手机号</label>
									<input id="phoneNo" class="input-text-line" name="phoneNo" type="tel" data-role="none"  placeholder="请输入11位手机号码"/>
									<input id="userid" type="hidden"/>
								</li>
								<li class="fm-checkcode">
									<label>验证码</label>
									<input id="validateCode_regist" class="input-text-line" type="text" data-role="none" style="border:0px;width:50%" placeholder="请输入验证码">
									<span>
										<img id="validateCode_img"
										src="<%=request.getContextPath()%>/bse/genCheckCode.action?codeName=PHONE_VERCODE" width="30%" height="28"
										style="vertical-align: middle;" onclick="changeCode()" /> <a
										href="javascript:changeCode();">换一组</a>
									</span>
								</li>
								<li class="fm-checkcode">
									<label><span class="f_yellow">*</span>短信验证码</label>
									<input id="validateCode" class="input-text-line" type="tel" data-role="none" style="border:0px;width:100%" placeholder="请输入验证码">
									<span class="btn-r">
										<a href="javascript:void(0)" id="getValidateCode" class="ui-btn btn-normal" style="padding:0px;margin:0px;height:30px;line-height: 30px;color: #FFFFFF">获取验证码</a>
									</span>
								</li>
								<li class="fm-item item-pwd">
									<label><span class="f_yellow">*</span>新密码</label>
									<input type="password" class="input-text-line" id="password" name="password" size="15" placeholder="6-16位字符">
								</li>
							</ul>
							<div class="reg-action">
								<a id="confirmBinding" class="ui-btn btn-submit" href="#">保存并登录</a>
							</div>
							<p class="tc" style="padding:0.5em 0">
								<a href="<%=request.getContextPath()%>/bse/toRetrieveEmailPd.action" class="f_yellow" style="border-bottom:1px solid #f0572c" data-ajax='false'>邮箱验证找回密码</a>
							</p>
						</div>
					</div>
				</div>
				<%@ include file="footer.jsp" %> 
			</div>
			<div id="map-page">
	    		<%@ include file="nav-map.jsp" %>
	    	</div>
		</div>
	</div>
</div>
<!-- 弹出对话框 -->
<div data-role="dialog" id="retrievePhone_dialog" data-close-btn="right">
	<div data-role="header">
		<h1 id="retrievePhone_header"></h1>
	</div>
	<div data-role="content">
		<div align="center" id="retrievePhone_dialog_con"><s:property value='errorMsg'/></div>
	</div>
</div>
</body>
</html>
