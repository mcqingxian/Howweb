<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="Shortcut Icon" href="${images}/ico.png" type="image/x-icon"/>
<title>抱歉，找不到该页面</title>
<%
	String path = request.getContextPath();
	request.setAttribute("styles", path+"/styles/bse");
	request.setAttribute("scripts", path+"/scripts/bse");
	request.setAttribute("images", path+"/images/bse");
	System.out.println(path);
%>
<%@include file="../head.jsp" %>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<div class="wrong404 tc pt20" style="padding-bottom:200px;">
			<p style="font-size:80px;color:#d3d3d3">404</p>
			<p class="f16 f_f15a22">抱歉，找不到网页，请刷新重试！</p>
			<p class="f16 f_f15a22 mb30">还没恢复？请咨询在线客服或致电4008086666！</p>
			<p><img src="${images}/404.jpg" width="154" /></p>
			<p><a href="index.action" class="xz1 mr10">返回首页</a><a href="advisorySuggestion.action" class="xz1">问题反馈</a></p>
		</div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
