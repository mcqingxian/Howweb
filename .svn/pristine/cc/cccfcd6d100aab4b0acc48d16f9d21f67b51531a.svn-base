<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/redPacket.css" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimun-scale=1.0,maximum-scale=1.0">

<script
	src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<style type="text/css">
.tb {
	width: 100%;
	margin: 0px;
	font-family: '微软雅黑', "宋体";
	font-size: 10px;
	color: white;
	border: solid white 0px;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".con").css("height", $(window).height() * 0.9);
				document.addEventListener('WeixinJSBridgeReady',
						function onBridgeReady() {
							WeixinJSBridge.call('hideToolbar'); //隐藏微信界面下方导航栏
							/* 		WeixinJSBridge.call('hideOptionMenu');//隐藏微信界面右上方分享按钮 */
						});
			});
</script>
<title>天地华宇</title>
</head>
<body style="background-size: 100% 130%;">
	<div id="main1">
	 <div class="title"><span>天地华宇-易到家</span></div>
		<%-- <div class="back" onclick="window.history.go(-1)">
			<!-- 返回按钮 -->
			<img src="<%=request.getContextPath()%>/img/back_03.png">
		</div> --%>
	 	<div class="con" > 
		<div >
			<s:if test="voucher.status==0">
				<div id="code">恭喜您获得优惠券<br/>
			<s:property value='voucher.vouchersCode' />
			</div>	
			<div id="name"> 
				&nbsp;&nbsp;<s:property value='voucher.vouchersName' />
				<span id="yuan">元</span>
			</div>	
			</s:if>
			<s:else>
			<div id="code">您领取过优惠券啦<br/>
			<s:property value='voucher.vouchersCode' />
			</div>	
			<div id="name"> 
				&nbsp;&nbsp;<s:property value='voucher.vouchersName' />
				<span id="yuan">元</span>
			</div>	
			</s:else>
			
				
		</div> 
			
		</div>
	</div>
</body>
</html>