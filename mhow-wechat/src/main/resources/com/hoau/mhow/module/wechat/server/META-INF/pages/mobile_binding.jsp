<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/public.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/mobile_binding.js"></script>
</head>
<body>
<div data-role="page" id="pageone">
	<div data-role="header" style="background-color:#CD0000">
		<h1>手&nbsp;机&nbsp;绑&nbsp;定</h1>
	</div>
	<div data-role="content">
		<table style="width:100%">
			<tr>
				<td align=right style="width:30%">
					手机号：
				</td>
				<td colspan=2 style="width:70%">
					<input id="phoneNo" name="phoneNo" type="number" data-role="none" style="border:0px;width:100%"/>
				</td>
			</tr>
			<tr>
				<td align=right>
					验证码：
				</td>
				<td>
					<input id="validateCode" id="validateCode" type="number" data-role="none" style="border:0px;width:100%">
				</td>
				<td>
					<button id="getValidateCode" data-theme="h" style="padding:0px;margin:0px;height:30px;color: #FFFFFF">获取验证码</button>
					<span id="countdown" style="display: none"></span>
				</td>
			</tr>
		</table>
		<table style="width:100%;">
		<tr>
			<td style="width:50%;border:0px;"><button id="confirmBinding" data-theme="h" style="color: #FFFFFF">确认绑定</button></td>
			<td style="width:50%;border:0px;"><button id="placeOrder" data-theme="h" style="color: #FFFFFF">直接下单</button></td>
			</tr>
		</table>
		<div id="notice" style="text-align: center; font-size:24px;color:red;margin-top: 50px;"></div>
		<div style="margin-top:50px;">
			<p style="text-align:center;">说明：绑定手机后，你的订单信息将可以在华宇官网和掌上华宇共享</p>
	    </div>
		</div>
	</div> 
</body>
</html>
