 $(document).ready(function(){
	var url = location.href;
	var openid = $("#openid").val();
	
	$.ajax({
	type: "post",
	url: "signature.action",
	dataType: "json",
	data: {"targetUrl":url,"openid":openid},
	success: function (data) {
		msg	= $.parseJSON(data);
		//test
		$("#openid").val(msg.openid);
//		alert("appid: "+msg.appId+"; timestamp:" + msg.timestamp+" ; nonceStr:" + msg.nonceStr+"; signature:" + msg.signature + ",openid:"+msg.openid);
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
			 // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
				var openid = $.trim($("#openid").val());
			    wx.onMenuShareAppMessage({
			      title: '致别青春校园，承运最美记忆',
			      desc: '托运时间：5月21日—7月15日,托运价格：同省低至29元',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/toCompusArticle.action?response_type=code&scope=snsapi_base&state='+openid+'#wechat_redirect',
			      imgUrl: 'http://wechat.hoau.net/wechat/images/top_img.jpg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			      },
			      success: function (res) {
			        recordShared();
			      },
			      cancel: function (res) {
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
			    });
			 // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
		      wx.onMenuShareTimeline({
			      title: '致别青春校园，承运最美记忆',
			      desc: '托运时间：5月21日—7月15日,托运价格：同省低至29元',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/toCompusArticle.action?response_type=code&scope=snsapi_base&state='+openid+'#wechat_redirect',
			      imgUrl: 'http://wechat.hoau.net/wechat/images/top_img.jpg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			      },
			      success: function (res) {
			        recordShared();
			      },
			      cancel: function (res) {
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
		      });
			   // 2.3 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口
		      wx.onMenuShareQQ({
		    	  title: '致别青春校园，承运最美记忆',
			      desc: '托运时间：5月21日—7月15日,托运价格：同省低至29元',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/toCompusArticle.action?response_type=code&scope=snsapi_base&state='+openid+'#wechat_redirect',
			      imgUrl: 'http://wechat.hoau.net/wechat/images/top_img.jpg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			      },
			      success: function (res) {
			        recordShared();
			      },
			      cancel: function (res) {
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
		      });
			   // 2.4 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口
		      wx.onMenuShareWeibo({
		    	  title: '致别青春校园，承运最美记忆',
			      desc: '托运时间：5月21日—7月15日,托运价格：同省低至29元',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/toCompusArticle.action?response_type=code&scope=snsapi_base&state='+openid+'#wechat_redirect',
			      imgUrl: 'http://wechat.hoau.net/wechat/images/top_img.jpg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			      },
			      success: function (res) {
			        recordShared();
			      },
			      cancel: function (res) {
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
		      });
		});//wx.ready
	 }//success
   });//ajax
});//ready
 
 function recordShared(){
	 var openid = $("#openid").val();
	 var articleid  = $("#articleid").val();
	 var state = $("#state").val();
		$.ajax({
			type: "post",
			url: "recordShared.action",
			dataType: "json",
			data: {
				"shareRecode.openid":openid,
				"shareRecode.articleid":articleid,
				"shareRecode.state":state
			},
			success: function (data) {
			}
		});
 }
 
 