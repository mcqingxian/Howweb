<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<title>天地华宇</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"	content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet"	href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script	src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/article/campus_article.js"></script>
<style type="text/css">
	h2{
		margin-top: 0px;
	}
	li{
		padding: 3px;
	}
</style>
</head>
<body onload="pop(0);">
	<div data-role="page" id="index">
		<input type="hidden" id="openid" value="${openid}">
		<input type="hidden" id="articleid" value="${articleid}">
		<input type="hidden" id="state" value="${state}">
		<div class="ui-content">
			<h2>致别青春校园，承运最美记忆</h2>
			<p><span style="color:#8C8C8C;">${today }</span>&nbsp;&nbsp;<span style="color:#608FC2;">天地华宇</span></p>
			<p><img alt="" src="images/title_img.png" style="width:100%;"></p>
			<p><img alt="" src="images/text_img.jpg" style="width:100%;"></p>
			<h5>一、托运时间：5月21日—7月15日</h5>
			<h5>二、托运价格：同省低至29元</h5>
			<p><img alt="" src="images/table_img.jpg" style="width:100%;"></p>
			<h5>三、优惠好礼：邀请好友关注微信，赢免费托运机会 </h5>
			<h5>活动流程： </h5>
			<ol style="font-size: 12px;">
				<li>扫描二维码或搜索微信号：Hoau4008086666</li>
				<li >关注天地华宇微信账号，转发本文章给好友，就有机会获得免费托运机会。</li>
				<li>每周一统计上周转发好友次数进行排名，前100名校园客户即可获得活动奖励。</li>
			</ol>
			<h5>奖项设置：</h5>
			<ul style="font-size: 12px;">
				<li>一等奖：1-10名，可获得运费全免优惠</li>
				<li>二等奖：11-30名，可获得运费5折优惠</li>
				<li>三等奖：31-100名，可获得运费7折优惠</li>
			</ul>
			<p style="font-size: 12px;">说明：运费金额200元以内优惠，超出200元部分，按校园价卡正常收取。</p>
			<p style="font-size: 12px;">详情请咨询天地华宇当地门店或<span style="color:red;">400-808-6666</span>。</p>
			<p><img alt="" src="images/bottom_img.png" style="width:100%;"></p>
		</div>
	</div>
</body>
</html>
