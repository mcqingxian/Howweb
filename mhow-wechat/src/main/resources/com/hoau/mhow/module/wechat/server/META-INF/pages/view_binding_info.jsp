<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/view_binding_info.js"></script>
<meta charset="utf-8">
<title>查看绑定信息</title>
<style>
	p{
		text-align:center;
	}
</style>
</head> 
<body>
<div data-role="page">
  <div data-role="content">
	<p>已绑定手机</p>
    <p><s:property value="star_phone" /></p>
    <span id="phone" style="display:none;"><s:property value="phone" /></span>
    <p>如果你在华宇官网和掌上华宇上建立过用户，现在你的订单信息可以共享了！</p>
	<button id="placeOrder" data-theme="h">直接下单</button>
	<button id="changeBind" data-theme="h">变更绑定</button>
  </div>
</div> 

</body>
</html>
