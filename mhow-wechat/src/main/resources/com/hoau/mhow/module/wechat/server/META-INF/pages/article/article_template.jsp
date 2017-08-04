<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"	content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet"	href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script	src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/article/article.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/article/article.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/easydialog.min.js"></script>
</head>
<body onload="pop(0);">
	<div data-role="page" id="index">
		<input type="hidden" id="openid" value='<s:property value="openid"/> '>
		<input type="hidden" id="articleid" value="artcleid20150527">
		<div class="ui-content">
			<h2>签名算法:</h2>
			<p>
				签名生成规则如下：参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）,
				 url（当前网页的URL，不包含#及其后面部分） 。对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，
				 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。这里需要注意的是所有参数名均为小写字符。
				 对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。 
				 
			</p>
		</div>
		<div class="easyDialog_wrapper" id="Box">
			<div class="easyDialog_content">
		    	<div class="easyDialog_text"><span id="pop-content"></span></div>
			</div>
		</div>
	</div>
</body>
</html>
