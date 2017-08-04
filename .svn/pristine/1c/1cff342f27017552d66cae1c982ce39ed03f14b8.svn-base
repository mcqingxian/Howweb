<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重置密码</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/forgot/resetPassword.js"></script>
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

<body>
<%@include file="../top.jsp" %>
<div class="p_w content">
	<div class="news_detail">
		<h1 class="news_title">密码找回</h1>
		<div class="retrv_form">
			<div class="retrv_step">
				<span class="retrv_step1">验证方式</span>
				<span class="retrv_step2">身份验证</span>
				<span class="retrv_step3 retrv_step_active">重置密码</span>
			</div>
			<div class="retrv_main">				
				<div class="retrv_tab">
					<a href="#">通过注册/登录手机号找回密码</a>
					<a href="#">通过登录/绑定邮箱找回密码</a>
					<a href="#">其他找回方式</a>
				</div>
				<div class="retrv_list">
					<div class="UserPass_mobile">
						<form action="forgotAction!modifyUserPwdByPhone.action" method="post" id="phonePwdForm" name="phonePwdForm">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="140" align="right"><span class="f_f15a22">*</span>您的手机号是：</td>
									<td><span><s:property value="phone"/></span><input id="phone" name="phone" value="<s:property value="phone"/>" style="display:none;"/></td>
									<td>
										<input id="ebccId" name="ebccId" style="display:none;" value="<s:property value="ebccId"/>" />
										<input id="phoneMd5Code" name="phoneMd5Code" style="display:none;" value="<s:property value="phoneMd5Code"/>" />
									</td>
								</tr>
								<tr>
									<td width="120" align="right"><span class="f_f15a22">*</span>新密码：</td>
									<td><input id="phone_pw1" name="phone_pw1" type="password" class="input w250" /></td>
									<td>
										<div class="tips" id="user_pw1_tips">
											
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>确认密码：</td>
									<td><input id="phonePassword" name="phonePassword" type="password" class="input w250" /></td>
									<td>
										<div class="tips" id="user_pw2_tips">
											<s:if test="#request.type == \"phone\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><a href="javascript:phoneSaveAndLogin();" class="xz1">保存并登录</a></td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="retrv_list">
					<div class="UserPass_mail">
						<form action="forgotAction!modifyUserPwdByEmail.action" method="post" id="emailPwdForm" name="emailPwdForm">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="140" align="right"><span class="f_f15a22">*</span>您的邮箱地址是：</td>
									<td><span><s:property value="email"/></span><input id="email" name="email" value="<s:property value="email"/>" style="display:none;"/></td>
									<td>
										<input id="ebccId" name="ebccId" style="display:none;" value="<s:property value="ebccId"/>" />
										<input id="emailMd5Code" name="emailMd5Code" style="display:none;" value="<s:property value="emailMd5Code"/>" />
									</td>
								</tr>
								<tr>
									<td width="120" align="right"><span class="f_f15a22">*</span>新密码：</td>
									<td><input id="mail_pw1" name="mail_pw1" type="password" class="input w250" /></td>
									<td>
										<div class="tips" id="mail_pw1_tips">
											
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>确认密码：</td>
									<td><input id="emailPassword" name="emailPassword" type="password" class="input w250" /></td>
									<td>
										<div class="tips" id="mail_pw2_tips">
											<s:if test="#request.type == \"email\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><a href="javascript:emailSaveAndLogin();" class="xz1">保存并登录</a></td>
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
