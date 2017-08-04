<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/user/resetPassword.js"></script>
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
<div class="content">
	<div class="p_w">
		<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/my_banner.jpg" width="770" /></div>
			<div class="news_detail pb20">
				<h1 class="news_title">个人资料管理</h1>
				<div class="pt30">								
					<div class="profile_info" style="border:0;">
						<form action="personalDataAction!resetPassword.action" method="post" id="repwdForm">
							<table border="0" cellspacing="0" cellpadding="0" width="100%">
								<tr>
									<td width="138" align="right"><span class="f_f15a22">*</span>原始密码：</td>
									<td width="260"><input id="oldPassword" name="oldPassword" type="password" class="w250 input inputFocus grays" /></td>
									<td>
										<div class="tips" id="oldpwd_tips">
											<s:if test="#request.errorType == \"oldPassword\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>新密码：</td>
									<td><input id="newPassword" name="newPassword" type="password" class="w250 input inputFocus grays" /></td>
									<td>
										<div class="tips" id="newpwd_tips">
											<s:if test="#request.errorType == \"newPassword\"">
												${errorMsg}
											</s:if>
										</div>
									</td>
								</tr>
								<tr>
									<td align="right"><span class="f_f15a22">*</span>确认密码：</td>
									<td>
										<input id="newPassword2" name="newPassword2" type="password" class="w250 input inputFocus grays" />
									</td>
									<td>
										<div class="tips" id="newpwd2_tips">
										</div>
									</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<div class="tips" id="success_tips">
											<c:if test="${errorType eq 'success' or errorType eq 'error'}">
												${errorMsg}
											</c:if>
										</div>
									</td>
									<td></td>
								</tr>
								<tr>
									<td align="right"></td>
									<td>
										<input onclick="updatePwd();" type="button" class="xz1" value="保 存"/>
									</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
