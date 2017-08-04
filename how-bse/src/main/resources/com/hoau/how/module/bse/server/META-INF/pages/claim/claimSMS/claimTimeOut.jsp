<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>理赔超时</title>
<link rel="stylesheet" href="${styles}/claimSMS/jquery.mobile-1.4.5.min.css">
<link href="${styles}/claimSMS/master.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${scripts}/claimSMS/jquery.min.js"></script>
<script type="text/javascript" src="${scripts}/claimSMS/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
<div id="wrapper">
	<div class="header">
		<h1><a href="#"><img src="${images}/hoaulogo.png" alt=""></a></h1>
	</div>
	<div class="claim_box">
		<div class="claim_error">
			<p>尊敬的客户：</p>
			<p>　　此链接已超时，如有疑问，请联系我司理赔负责人</p>			
		</div>
	</div>
</div>

</body>
</html>
