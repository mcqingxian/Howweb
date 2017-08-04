<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>  
<title>修改密码</title>
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
				<h1 class="innertitle">修改密码</h1>
				<span class="btn-topr">
					<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
						<span class="ui-ico ui-ico-home"></span>
					</a>
					<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
						<span class="ui-ico ui-ico-nav"></span>
					</a>
				</span>
			</div>
			<div class="grid-main">
				<form action="resetPassword.action" method="post" data-ajax='false' id="updatepwd">
					<div class="form-reg">
						<ul class="fm-list">
							<li>
								<label>旧密码</label>
								<input type="password" class="input-text-line" id="oldPassword" name="oldPassword" size="15" placeholder="9-11位字符">
							</li>
							<li>
								<label>新密码</label>
								<input type="text" class="input-text-line" id="newPassword" name="newPassword" size="15" placeholder="9-11位字符">
							</li>
						</ul>
						<p style="color: red">${errorMsg}</p>
						<div class="reg-action">
							<a class="ui-btn btn-submit" name="updatePassword" data-ajax='false'>更改密码</a>
						</div>
						<s:token></s:token>
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
<script type="text/javascript">
	$('a[name="updatePassword"]').on('click',function(){
		$('#updatepwd').submit();
	});
</script>
</html>

