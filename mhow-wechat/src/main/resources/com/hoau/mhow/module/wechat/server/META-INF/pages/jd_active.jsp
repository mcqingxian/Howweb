<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet"	href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet"	href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<link rel="stylesheet"	href="${styles}/anniversary.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script	src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<title>京东家装节</title>
</head>
<body>
	<div data-role="page" id="index" class="body_background">
		<div class="ui-content">
			<div class="top">天地华宇</div><br/><br/>
			<div class="title">京东家装节</div>
			<div class="div-content">
				<s:if test="vouchers.status==0">
					<p>恭喜您获得一张优惠券</p><br/>
					<p style="font-size:16px;">编号:<s:property value='vouchers.vouchersCode'/></p><br/><br/>
					<p><span><s:property value='vouchers.vouchersName'/>.00</span>元</p>
				</s:if>
				<s:else>
					<p><s:property value='vouchers.vouchersName'/></p>
				</s:else>
			</div>
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