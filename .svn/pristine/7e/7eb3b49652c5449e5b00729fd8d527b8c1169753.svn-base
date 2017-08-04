<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>  
<title>登录</title>
</head>
<body>
<div data-role="page" id="login">
	<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">用户登录</h1>
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
							<div class="form-login">
								<ul class="fm-list">
									<li>
										<span class="ui-ico ico-user"></span>
										<input type="text" class="input-text-line" id="loginName" name="loginName" value="" size="15" placeholder="手机号/邮箱/用户名" autocomplete="off">
									</li>
									<li>
										<span class="ui-ico ico-pwd"></span>
										<input type="password" class="input-text-line" id="password" name="password" value="" size="15" placeholder="密码" autocomplete="off">
									</li>
									<li class="fm-checkcode">
										<span class="ui-ico ico-pwd"></span>
										<input id="validateCode_regist" class="input-text-line" type="text" data-role="none" style="border:0px;width:50%;padding-left:.4em;" placeholder="请输入验证码">
										<span>
											<img id="validateCode_img"
											src="<%=request.getContextPath()%>/bse/genCheckCode.action?codeName=LOGIN_VERCODE" width="30%" height="28"
											style="vertical-align: middle;" onclick="changeCode()" /> <a
											href="javascript:changeCode();">换一组</a>
										</span>
									</li>
								</ul>
								<div class="login-action">
									<a class="ui-btn btn-submit" name="login">登录</a>
								</div>
								<div class="login-other clearfix">
									<a class="fr" href="<%=request.getContextPath()%>/bse/toRetrievePhonePd.action" data-ajax='false'>忘记密码？</a>
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
<div data-role="dialog" id="login_dialog" data-close-btn="right">
	<div data-role="header">
		<h1 id="dialg_header"></h1>
	</div>
	<div data-role="content">
		<div align="center" id="order_dialog_con"><s:property value='errorMsg'/></div>
	</div>
</div>
</body>
<script type="text/javascript">
	//更改验证码
	function changeCode(){  
		$("#validateCode_img").attr("src", "<%=request.getContextPath()%>/bse/genCheckCode.action?codeName=LOGIN_VERCODE&"+ new Date());
	}

	(function($){
		$(document).keypress(function(e){ 
			if (e.keyCode == 13){
				$('a[name="login"]').click();
		    }
		});
		$("#loginName").keypress(function(e){ 
			if (e.keyCode == 13){
				$("#password").focus();
		    }
		});
		/* $("#password").keypress(function(e){ 
			if (e.keyCode == 13){
				$('a[name="login"]').click();
		    }
		}); */
		
		$('a[name="login"]').on({
			'click':function(){
				var loginName = $.trim($("#loginName").val());
				var password = $.trim($("#password").val());
				var verCode = $.trim($("#validateCode_regist").val());
				$.post('<%=request.getContextPath()%>/bse/loginAction!userLogin.action',{"loginName":loginName,"password":password,"verCode":verCode},function(){
					
				},'json').done(function(data){
					if(data.errorMsg!=undefined&&data.errorMsg!=''){
						// 更新验证码
						changeCode();
						$("#order_dialog_con").empty();
						$("#order_dialog_con").append("<h>"+data.errorMsg+"</h>");
						$.mobile.changePage('#login_dialog', 'flip', true, true);
					}else{
						var dest = '<%=request.getAttribute("dest")%>';
						if(dest!='null'){
							window.location.href=dest;
						}else{
							window.location.href='index.action';
						}
					}
				}).fail(function(data){
					$("#order_dialog_con").empty();
					$("#order_dialog_con").append('<h>登录失败</h>');
					$.mobile.changePage('#login_dialog', 'flip', true, true);
				})
			}
		});
		
		$('a[name="index"]').on('click',function(){
			$.get('bseAction!notLogin.action',function(data){
				$("#order_dialog_con").empty();
				$("#order_dialog_con").append("<h>"+data.errorMsg+"</h>");
				$.mobile.changePage('#login_dialog', 'flip', true, true);
			},'json')
		})
	})(jQuery)
</script>
