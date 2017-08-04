 $(document).ready(function(){
	var url = location.href;
	$.ajax({
	type: "post",
	url: "/wechat/signature.action",
	dataType: "json",
	data: {"targetUrl":url},
	success: function (data) {
		msg	= $.parseJSON(data);
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
				'onMenuShareQZone',
				'hideMenuItems',
				'showMenuItems',
				'hideAllNonBaseMenuItem',
				'showAllNonBaseMenuItem',
				'translateVoice',
				'startRecord',
				'stopRecord',
				'onVoiceRecordEnd',
				'playVoice',
				'onVoicePlayEnd',
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
			      title: '天地华宇手机壁纸',
			      desc: '天地华宇手机壁纸下载，长按壁纸，保存壁纸到手机！',
			      link: 'http://wechat.hoau.net/wechat/wallpaper/pages/index.html',
			      imgUrl: 'https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsgUPYQsrz5EJlFdFWSTYZvIEmTkNqXmwuck5NTRXjUfXvicHWP1rOVnOMhZcgUKgOoKwib8U47Ex6VA/0?wx_fmt=jpeg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
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
		    	  title: '天地华宇手机壁纸',
			      link: 'http://wechat.hoau.net/wechat/wallpaper/pages/index.html',
			      imgUrl: 'https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsgUPYQsrz5EJlFdFWSTYZvIEmTkNqXmwuck5NTRXjUfXvicHWP1rOVnOMhZcgUKgOoKwib8U47Ex6VA/0?wx_fmt=jpeg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
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
		    	  title: '天地华宇手机壁纸',
			      desc: '天地华宇手机壁纸下载，长按壁纸，保存壁纸到手机！',
			      link: 'http://wechat.hoau.net/wechat/wallpaper/pages/index.html',
			      imgUrl: 'https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsgUPYQsrz5EJlFdFWSTYZvIEmTkNqXmwuck5NTRXjUfXvicHWP1rOVnOMhZcgUKgOoKwib8U47Ex6VA/0?wx_fmt=jpeg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
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
		    	  title: '天地华宇手机壁纸',
			      desc: '天地华宇手机壁纸下载，长按壁纸，保存壁纸到手机！',
			      link: 'http://wechat.hoau.net/wechat/wallpaper/pages/index.html',
			      imgUrl: 'https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsgUPYQsrz5EJlFdFWSTYZvIEmTkNqXmwuck5NTRXjUfXvicHWP1rOVnOMhZcgUKgOoKwib8U47Ex6VA/0?wx_fmt=jpeg',
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//			        alert('用户点击发送给朋友');
			      },
			      success: function (res) {
//			        alert('已分享');
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
 