<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>身份验证</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/forgot/authentication.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
<script type="text/javascript">
$(function(){
	var type = '${type}';
	var index = 0;
	if(type == "email"){
		index = 1;
	}else{
		index = 0;
	}
	$('.retrv_tab').jtabs('.retrv_list', {fx: 'fade', activeClass: 'active', event: 'click', initIdx: index});
});
</script>
</head>
<body onload="initData('${type}');">
<%@include file="../top.jsp" %>
<div class="p_w content">
	<div class="news_detail">
		<h1 class="news_title">密码找回</h1>
		<div class="retrv_form">
			<div class="retrv_step">
				<span class="retrv_step1">验证方式</span>
				<span class="retrv_step2 retrv_step_active">身份验证</span>
				<span class="retrv_step3">重置密码</span>
			</div>
			<div class="retrv_main">				
				<div class="retrv_tab">
					<a href="#">通过注册/登录手机号找回密码</a>
					<a href="#">通过登录/绑定邮箱找回密码</a>
					<a href="#">其他找回方式</a>
				</div>
				<div class="retrv_list">
					<div class="UserPass_mobile">
						<form action="forgotAction!toSetNewPwdByPhone.action" method="post" id="phoneNextForm">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="120" align="right"><span class="f_f15a22">*</span>您的手机号是：</td>
									<td><span><s:property value="phone"/></span><input name="phone" id="phone"  maxlength="11" value="<s:property value="phone"/>" style="display:none;"/></td>
									<td>
										<input id="ebccId" name="ebccId" style="display:none;" value="<s:property value="ebccId"/>" />
										<div class="tips" id="phone_tips">
											<s:if test="#request.type == \"phone\" && #request.errorType == \"phone\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>短信验证码：</td>
									<td>
										<input id="phoneCode" name="phoneCode" type="text" class="input w95 mr10" />
										<input type="button" id="getPhoneVerCodeBtn" disabled="disabled" 
											class="btn_sub xz1" style="padding:0 10px;" value="获取验证码" onclick="sendPhoneVerCode()"/>
									</td>
									<td>
										<div class="tips" id="phone_code_tips">
											<s:if test="#request.type == \"phone\" && #request.errorType == \"verCode\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>
										<a href="javascript:phoneNext();" class="xz1">下一步</a>
									</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="retrv_list">
					<div class="UserPass_mail">
						<form action="forgotAction!toSetNewPwdByEmail.action" method="post" id="emailNextForm">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="140" align="right"><span class="f_f15a22">*</span>您的邮箱地址是：</td>
									<td><span><s:property value="email"/></span><input id="email" name="email" value="<s:property value="email"/>" style="display:none;"/></td>
									<td>
										<input id="ebccId" name="ebccId" style="display:none;" value="<s:property value="ebccId"/>" />
										<div class="tips" id="email_tips">
											<s:if test="#request.type == \"email\" && #request.errorType == \"email\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>邮箱验证码：</td>
									<td>
										<input id="emailCode" name="emailCode" type="text" class="input w150 mr10" />
										<input type="button" id="getEmailVerCodeBtn" disabled="disabled" 
											class="btn_sub xz1" style="padding:0 10px;" value="获取验证码" onclick="sendEmailVerCode()"/>
									</td>
									<td>
										<div class="tips" id="email_code_tips">
											<s:if test="#request.type == \"email\" && #request.errorType == \"verCode\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><a href="javascript:emailNext();" class="xz1">下一步</a></td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="retrv_list">
					<div class="retrv_tips tc">
						<i></i>
						可联系<strong class="f16 f_f15a22">在线客服</strong>或直接拨打<strong class="f16 f_f15a22">4008086666</strong>协助处理
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
