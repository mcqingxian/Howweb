<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="<%=request.getContextPath()%>/styles/hc_place_order.css" rel="stylesheet" />
</head>
<body>
	<div id="header">
		<a href="https://www.hoau.net/">
			<img src="<%=request.getContextPath()%>/images/logo_name.png">
		</a>
	</div>
	<div id="content">
		<div id="result">
			<s:if test="orderResult.errMsg != null">
				<s:property value='orderResult.errMsg'/>
			</s:if>
			<s:else>
				下单成功，订单号为：<s:property value='orderResult.value'/>，我们会尽快与您联系！
			</s:else>			
		</div>
	</div>
	<div id="code_img"></div>
</body>
</html>