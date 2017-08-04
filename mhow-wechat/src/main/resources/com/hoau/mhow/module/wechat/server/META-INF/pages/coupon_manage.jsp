<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/icon-pack-custom.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/public.css"/> --%>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/scripts/coupon_manage.js"></script>
<meta charset="utf-8">
<title>我的优惠券</title>
<style type="text/css">
*{
	padding:0px;
	margin:0px;
}
.no_coupon_div span{
	font-weight: bold;
	color: #F25822;
}
.no_coupon_div p{
	text-align:center;
	margin-bottom: 10px;
}
.yhq_item{
	background:#de625a;
	-moz-border-radius:5px;      /* Gecko browsers */
    -webkit-border-radius:5px;   /* Webkit browsers */
    border-radius:5px;
	padding:0.5rem;
	margin:0.5rem;
	border:1px dotted #fafafa;
	
}
.yhq_item_box{
	border:1px solid #eca6a2;
	color:#fff;
	font-size:0.875rem;
	padding:10px 0;
}
.yhq_item_box:after{clear:both;content: '\20';display: block;}
.yhq_item_box .price_num{ font-size:2rem;}
.yhq_item_box dt{ float:left; width:50%; text-align:center;}
.yhq_item_box dd{float:left;width:50%; line-height:1.5rem; padding-top:0.45rem;}
.yhq_item_box dd .yhp_text{margin-bottom:0.4rem; font-size:1.4rem;}
</style>
</head>
<body>
	<!-- 未使用 -->
	<div data-role="page" id="coupon">
		<div data-role="header" style="background-color:#CD0000">
			<div data-role="navbar">
				<ul>
					<li><a class="ui-btn-active ui-state-persist" href="#"
						data-transition="none"  style="font-size: 18px;" >未使用</a></li>
					<li><a href="#pagetwo" data-transition="none"
						id="coupon_pagetwo"  style="font-size: 18px;" >已使用</a></li>
					<li><a href="#pagethree" data-transition="none"
						id="coupon_pagethree"  style="font-size: 18px;" >已过期</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<s:if test="unused.size>0">
			<s:iterator value="unused">
				<div class="yhq_item">
					<dl class="yhq_item_box">
						<dt>
							<p>￥<span class="price_num">${par }</span></p>
							<p>编号:${couponCode }</p>
						</dt>
						<dd>
							<p class="yhp_text">元&nbsp;优&nbsp;惠&nbsp;券</p>
							<p class="yhp_time">有效期:${validTime }截止</p>
						</dd>
					</dl>
				</div>
			</s:iterator>
			</s:if>
			<s:else>
				<div class="no_coupon_div">
					<div style="text-align: center;margin-top: 30%;">
				        <img src="<%=request.getContextPath()%>/images/nocoupon.png">
			      	</div>
					<p>
						<span>现在还没有优惠券</span>
					</p>
					<p>
						<span>赶快去看看天地华宇近期有什么活动吧！</span>
					</p>
				</div>
			</s:else>
		</div>
	</div>
	<!-- 已使用 -->
	<div data-role="page" id="pagetwo">
		<div data-role="header" style="background-color:#CD0000">
			<div data-role="navbar">
				<ul>
					<li><a href="#coupon" data-transition="none"  
						style="font-size: 18px;" >未使用</a></li>
					<li><a class="ui-btn-active ui-state-persist" href="#" data-transition="none"
						id="coupon_pagetwo"  style="font-size: 18px;" >已使用</a></li>
					<li><a href="#pagethree" data-transition="none"
						id="coupon_pagethree"  style="font-size: 18px;" >已过期</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<s:if test="beenUsed.size>0">
			<s:iterator value="beenUsed">
				<div class="yhq_item">
					<dl class="yhq_item_box">
						<dt>
							<p>￥<span class="price_num">${par }</span></p>
							<p>编号:${couponCode }</p>
						</dt>
						<dd>
							<p class="yhp_text">元&nbsp;优&nbsp;惠&nbsp;券</p>
							<p class="yhp_time">有效期:${validTime }截止</p>
						</dd>
					</dl>
				</div>
			</s:iterator>
			</s:if>
			<s:else>
				<div class="no_coupon_div">
					<div style="text-align: center;margin-top: 30%;">
				        <img src="<%=request.getContextPath()%>/images/nocoupon.png">
			      	</div>
					<p>
						<span>现在还没有优惠券</span>
					</p>
					<p>
						<span>赶快去看看天地华宇近期有什么活动吧！</span>
					</p>
				</div>
			</s:else>
		</div>
	</div>
	<div data-role="page" id="pagethree">
		<div data-role="header" style="background-color:#CD0000">
			<div data-role="navbar">
				<ul>
					<li><a href="#coupon"
						data-transition="none"  style="font-size: 18px;" >未使用</a></li>
					<li><a href="#pagetwo" data-transition="none"
						id="coupon_pagetwo"  style="font-size: 18px;" >已使用</a></li>
					<li><a href="#" class="ui-btn-active ui-state-persist" data-transition="none"
						id="coupon_pagethree"  style="font-size: 18px;" >已过期</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<s:if test="hasExpired.size>0">
			<s:iterator value="hasExpired">
				<div class="yhq_item">
					<dl class="yhq_item_box">
						<dt>
							<p>￥<span class="price_num">${par }</span></p>
							<p>编号:${couponCode }</p>
						</dt>
						<dd>
							<p class="yhp_text">元&nbsp;优&nbsp;惠&nbsp;券</p>
							<p class="yhp_time">有效期:${validTime }截止</p>
						</dd>
					</dl>
				</div>
			</s:iterator>
			</s:if>
			<s:else>
				<div class="no_coupon_div">
					<div style="text-align: center;margin-top: 30%;">
				        <img src="<%=request.getContextPath()%>/images/nocoupon.png">
			      	</div>
					<p>
						<span>现在还没有优惠券</span>
					</p>
					<p>
						<span>赶快去看看天地华宇近期有什么活动吧！</span>
					</p>
				</div>
			</s:else>
		</div>
	</div>	
</body>
<script type="text/javascript">
$(document).ready(function(){
	var url = location.href;
	$.ajax({
	type: "post",
	url: "signature.action",
	dataType: "json",
	data: {"targetUrl":url,"openid":openid},
	success: function (data) {
		msg	= $.parseJSON(data);
		//test
		//通过config接口注入权限验证配置
		wx.config({
		      debug: false,
		      appId: msg.appId,
		      timestamp: msg.timestamp,
		      nonceStr: msg.nonceStr,
		      signature: msg.signature,
		      jsApiList: [
		        'checkJsApi',
		        'onMenuShareTimeline',
		        'onMenuShareAppMessage',
		        'onMenuShareQQ',
		        'onMenuShareWeibo',
		        'hideMenuItems',
		        'showMenuItems',
		        'hideAllNonBaseMenuItem',
		        'showAllNonBaseMenuItem',
		        'translateVoice',
		        'startRecord',
		        'stopRecord',
		        'onRecordEnd',
		        'playVoice',
		        'pauseVoice',
		        'stopVoice',
		        'uploadVoice',
		        'downloadVoice',
		        'chooseImage',
		        'previewImage',
		        'uploadImage',
		        'downloadImage',
		        'getNetworkType',
		        'openLocation',
		        'getLocation',
		        'hideOptionMenu',
		        'showOptionMenu',
		        'closeWindow',
		        'scanQRCode',
		        'chooseWXPay',
		        'openProductSpecificView',
		        'addCard',
		        'chooseCard',
		        'openCard'
		      ]
		  });
		
		wx.ready(function(){
		    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
		    //隐藏右上角菜单
			wx.hideOptionMenu();
		});//wx.ready
	 }//success
   });//ajax
});//ready
</script>
</html>