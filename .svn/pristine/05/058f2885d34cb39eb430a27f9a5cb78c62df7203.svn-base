<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>验证方式</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/forgot/forgot.js"></script>
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
function changeCode(id,codeName){
	$(id).attr("src","genCheckCode.action?codeName="+codeName+"&d="+ new Date());
}
</script>
</head>
<body>
<%@include file="../top.jsp" %>
<div class="p_w content">
	<div class="news_detail">
		<h1 class="news_title">密码找回</h1>
		<div class="retrv_form">
			<div class="retrv_step">
				<span class="retrv_step1 retrv_step_active">验证方式</span>
				<span class="retrv_step2">身份验证</span>
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
						<form id="phoneForm" action="forgotAction!phoneRetrieve.action" method="post">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="90" align="right"><span class="f_f15a22">*</span>手机号：</td>
									<td>
										<input id="phone" name="phone" type="text"  maxlength="11"
											<s:if test="phone != null">class="input w250 inputFocus"</s:if>
											<s:else>class="input w250 inputFocus grays"</s:else> 
											<s:if test="phone != null">value='<s:property value="phone"/>' </s:if>
											<s:else>value="请输入11位手机号码"</s:else> ov="请输入11位手机号码" />
									</td>
									<td>
										<div class="tips" id="phone_tips">
											<s:if test="#request.type == \"phone\" && #request.errorType == \"phone\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>验证码：</td>
									<td>
										<input id="phoneCode" name="phoneCode" type="text" class="input w75 mr10" style="ime-mode:disabled"/>
										<img id="phoneValidateCode_img" src="genCheckCode.action?codeName=PHONE_VERCODE" width="90" class="mr10" style="vertical-align:middle;"/>
										<a href="javascript:changeCode('#phoneValidateCode_img','PHONE_VERCODE');">看不清，换一张</a>
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
									<td><a href="javascript:phoneNext();" class="xz1">下一步</a></td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="retrv_list">
					<div class="UserPass_mail">
						<form id="emailForm" action="forgotAction!emailRetrieve.action" method="post">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="90" align="right"><span class="f_f15a22">*</span>邮箱地址：</td>
									<td>
										<input id="email" name="email" type="text" 
											<s:if test="email != null">class="input w250 inputFocus"</s:if>
											<s:else>class="input w250 inputFocus grays"</s:else> 
											<s:if test="email != null"> value='<s:property value="email"/>' </s:if>
											<s:else>value="请输入绑定的邮箱地址"</s:else> ov="请输入绑定的邮箱地址" />
									</td>
									<td>
										<div class="tips" id="email_tips">
											<s:if test="#request.type == \"email\" && #request.errorType == \"email\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>验证码：</td>
									<td>
										<input id="emailCode" name="emailCode" type="text" class="input w75 mr10" style="ime-mode:disabled"/>
										<img id="emalValidateCode_img" src="genCheckCode.action?codeName=EMAIL_VERCODE" width="90" class="mr10" style="vertical-align:middle;" />
										<a href="javascript:changeCode('#emalValidateCode_img','EMAIL_VERCODE');">看不清，换一张</a>
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
									<td><a href="javascript:emailNext();" class="xz1">发送验证邮箱</a></td>
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
