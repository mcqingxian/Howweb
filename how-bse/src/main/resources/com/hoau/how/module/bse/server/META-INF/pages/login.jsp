<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${scripts}/user/login.js"></script>
<title>用户登陆</title>
<%@include file="head.jsp" %>
</head>

<body onload="initData();">
<%@include file="top.jsp" %>
<div class="p_w content">
	<div class="news_detail">
		<h1 class="news_title">用户登录</h1>
		<div class="reg_info">
			<div class="reg_form fl">
				<div class="action_title">
					→ 请输入您的账号信息，用于登录华宇会员系统
				</div>
				<form action="loginAction!login.action${dest}" method="post" id="loginForm">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><label class="tit">登录名：</label></td>
							<td>
								<input id="loginName" name="loginName" type="text" 
								<s:if test="loginName != null">class="input w205 inputFocus"</s:if>
								<s:else>class="input w205 inputFocus grays"</s:else> 
								<s:if test="loginName != null">value='<s:property value="loginName"/>' </s:if>
								<s:else>value="手机号/邮箱/登录账号"</s:else> ov="手机号/邮箱/登录账号" />
							</td>
							<td>
								<div class="tips" id="loginName_tips">
									<c:if test="${errorType eq 'loginName'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td><label class="tit">登录密码：</label></td>
							<td><input id="password" name="password" type="password" class="input w205 inputFocus"/></td>
							<td>
								<div class="tips" id="loginPwd_tips">
									<c:if test="${errorType eq 'password'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<div class="inputacc">
									<a href="forgot.action" class="f_f15a22 fr">忘记密码</a>
									<%--
									<span>
										<input id="remLoginName" checked="checked" name="" type="checkbox"/>
										<label for="remLoginName">下次自动登录</label>
									</span>
									 --%>
								</div>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><a href="javascript:login();" class="xz1 mr10">登录</a><a href="regist.action" class="xz1">注册</a></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="reg_aside fl">
				<p class="have_ac">还没有帐号，<a href="regist.action" class="f_f15a22">立即去注册 &gt;&gt;</a></p>
				<div class="reg_service">
					<p>注册成为<strong class="f16">华宇会员</strong>，您可以享受更多的服务</p>
					<ul>
						<li>账号一体化</li>
						<li>快捷下单</li>
						<li>在线理赔</li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<%@include file="bottom.jsp" %>
</body>
</html>
