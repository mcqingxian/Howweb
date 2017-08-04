<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %> 
<script src="<%=request.getContextPath()%>/scripts/bse/regist.js"></script>
<script>
	var system_bse_url = '<%=request.getContextPath()%>/bse/';
</script>  
<title>注册</title>
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
					<h1 class="innertitle">用户注册</h1>
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
								</li>
								<li class="fm-checkcode">
									<label>用户名</label>
									<input id="entity.ebccNetLogin" class="input-text-line" name="loginName" type="text" data-role="none" placeholder="可作为登录账号"/>
								</li>
								<li class="fm-checkcode">
									<label>邮箱地址</label>
									<input id="entity.ebccEmail"  class="input-text-line" name="email" type="text" data-role="none" placeholder="可作为登录账号和密码找回凭证"/>
								</li>
								<li class="fm-item item-pwd">
									<label><span class="f_yellow">*</span>密码</label>
									<input type="password" class="input-text-line" id="password" name="password" size="15" placeholder="6-16位字符">
								</li>
								<li class="fm-checkcode">
									<label>验证码</label>
									<input id="validateCode_regist" class="input-text-line" type="text" data-role="none" style="border:0px;width:50%" placeholder="请输入验证码">
									<span>
										<img id="validateCode_img"
										src="<%=request.getContextPath()%>/bse/genCheckCode.action?codeName=USER_REGIST_VERCODE" width="30%" height="28"
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
							</ul>
							<div class="reg-action">
								<a id="confirmBinding" class="ui-btn btn-submit" href="#">注册</a>
							</div>
							
							
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
<div data-role="dialog" id="regist_dialog" data-close-btn="right">
	<div data-role="header">
		<h1 id="regist_header"></h1>
	</div>
	<div data-role="content">
		<div align="center" id="regist_dialog_con"><s:property value='errorMsg'/></div>
	</div>
</div>
</body>
</html>
