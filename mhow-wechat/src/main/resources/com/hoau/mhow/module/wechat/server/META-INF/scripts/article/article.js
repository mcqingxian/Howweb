 $(document).ready(function(){
	var url = location.href;
	openid = $("#openid").val();
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
			    wx.onMenuShareAppMessage({
			      title: '致别青春校园，承运最美记忆',
			      desc: '在长大的过程中，我才慢慢发现，我身边的所有事，别人跟我说的所有事，那些所谓本来如此，注定如此的事，它们其实没有非得如此，事情是可以改变的。更重要的是，有些事既然错了，那就该做出改变。',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://testoms.hoau.net/wechat/toArticle.action?response_type=code&scope=snsapi_base&state=1#wechat_redirect',
			      imgUrl: 'http://testoms.hoau.net/wechat/images/nocoupon.png',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
			        sendCoupons();
			      },
			      cancel: function (res) {
//			        alert('已取消');
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
			    });
			 // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
		      wx.onMenuShareTimeline({
		    	  title: '致别青春校园，承运最美记忆',
			      desc: '在长大的过程中，我才慢慢发现，我身边的所有事，别人跟我说的所有事，那些所谓本来如此，注定如此的事，它们其实没有非得如此，事情是可以改变的。更重要的是，有些事既然错了，那就该做出改变。',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://testoms.hoau.net/wechat/toArticle.action?response_type=code&scope=snsapi_base&state=1#wechat_redirect',
			      imgUrl: 'http://testoms.hoau.net/wechat/images/nocoupon.png',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
			        sendCoupons();
			      },
			      cancel: function (res) {
//			        alert('已取消');
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
		      });
			   // 2.3 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口
		      wx.onMenuShareQQ({
		    	  title: '致别青春校园，承运最美记忆',
			      desc: '在长大的过程中，我才慢慢发现，我身边的所有事，别人跟我说的所有事，那些所谓本来如此，注定如此的事，它们其实没有非得如此，事情是可以改变的。更重要的是，有些事既然错了，那就该做出改变。',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://testoms.hoau.net/wechat/toArticle.action?response_type=code&scope=snsapi_base&state=1#wechat_redirect',
			      imgUrl: 'http://testoms.hoau.net/wechat/images/nocoupon.png',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
			        sendCoupons();
			      },
			      cancel: function (res) {
//			        alert('已取消');
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
		      });
			   // 2.4 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口
		      wx.onMenuShareWeibo({
		    	  title: '致别青春校园，承运最美记忆',
			      desc: '在长大的过程中，我才慢慢发现，我身边的所有事，别人跟我说的所有事，那些所谓本来如此，注定如此的事，它们其实没有非得如此，事情是可以改变的。更重要的是，有些事既然错了，那就该做出改变。',
			      link: 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://testoms.hoau.net/wechat/toArticle.action?response_type=code&scope=snsapi_base&state=1#wechat_redirect',
			      imgUrl: 'http://testoms.hoau.net/wechat/images/nocoupon.png',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
			        sendCoupons();
			      },
			      cancel: function (res) {
//			        alert('已取消');
			      },
			      fail: function (res) {
			        alert(JSON.stringify(res));
			      }
		      });
		});//wx.ready
	 }//success
   });//ajax
});//ready
 
 function sendCoupons(){
	 var openid = $("#openid").val();
	 var articleid  = $("#articleid").val();
		$.ajax({
			type: "post",
			url: "sendCoupons.action",
			dataType: "json",
			data: {"openid":openid,"type":articleid},
			success: function (data) {
				$("#pop-content").text(data);
				pop(5000);
			}
		});
 }
 
function pop(time){
	easyDialog.open({
		container : 'Box',
		autoClose : time,
		drag : false
	});
 }
 
 