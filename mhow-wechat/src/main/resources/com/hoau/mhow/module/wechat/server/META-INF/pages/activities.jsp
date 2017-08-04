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
<script>
        var imgUrl = "http://apsw.hoau.net/apsw/images/logo.jpg";
        var lineLink = "http://apsw.hoau.net/apsw/pages/activities.jsp";
        var descContent = '话费电影票，送送送不停！';
        var shareTitle = '天地华宇';
        var appid = '';
         /*
        function shareFriend() {
            WeixinJSBridge.invoke('sendAppMessage',{
                "appid": appid,
                "img_url": imgUrl,
                "img_width": "200",
                "img_height": "200",
                "link": lineLink,
                "desc": descContent,
                "title": shareTitle
            }, function(res) {
                _report('send_msg', res.err_msg);
            	var msg = document.getElementById("msg");
                msg.value = "发送给好友成功！";
            });
        }
        */
        function shareTimeline() {
            WeixinJSBridge.invoke('shareTimeline',{
                "img_url": imgUrl,
                "img_width": "200",
                "img_height": "200",
                "link": lineLink,
                "desc": descContent,
                "title": shareTitle
            }, function(res) {
                //_report('timeline', res.err_msg);
                //记录分享
            	shareSuccess();
            });
        }
        
        function shareWeibo() {
            WeixinJSBridge.invoke('shareWeibo',{
                "content": descContent,
                "url": lineLink,
            }, function(res) {
            	//_report('weibo', res.err_msg);
            	//记录分享
            	shareSuccess();
            });
        }
        
        // 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。
        document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
            /*
        	// 发送给好友
            WeixinJSBridge.on('menu:share:appmessage', function(argv){
                shareFriend();
            });
            */
            // 分享到朋友圈
            WeixinJSBridge.on('menu:share:timeline', function(argv){
                shareTimeline();
            });
            
            // 分享到微博
            WeixinJSBridge.on('menu:share:weibo', function(argv){
                shareWeibo();
            });
        }, false);
        
        //后台记录该用户的分享记录
        function shareSuccess(){
        	<%
        		String openid = request.getParameter("openid");
        	%>
        	$.post("/apsw/shareRecord.action",
      			  {
      				"openid":<%=openid%>
      			  },
      			  function(data,status){
      			    if(status == "success"){
      			    	if("1" == data){
      			    		alert("已经分享过！");
      			    	}else{
      			    		alert("恭喜你额外获得一次抽奖机会！");
      			    	}
      			    }else{
      			    	var dialog = document.getElementById("dialog");
      			    	dialog.innerHTML = "网络异常";
      			    }
      			}
      		);
       }
</script>
<style>
	td{
		<%--color:#f15a22;--%>
		color:#182428;
		font-size:13px;
	}
	
	span{
		color:#f15a22;
	}
</style>
<title>抽奖活动页面</title>
</head>
<body>
	<input id="msg" />
	<table align=center>
		<tr>
			<td style="color:#182428;font-size:16px;"><b>活动流程：</b></td>
		</tr>
		<tr>
			<td>
				<span>
					1：先绑定 再抽奖<br/>
				</span>
				&nbsp;&nbsp;关注天地华宇微信再绑定手机号码即可参与抽奖，分享<b style="color:red">朋友圈</b>、<b style="color:red">腾讯微博</b>、可以额外获得一次抽奖机会喔！
			</td>
		</tr>
		<tr>
			<td>
				<img src="<%=request.getContextPath()%>/images/code.jpg">
			</td>
		</tr>
		<tr>
			<td>
				<span>
					2：拼人品 中大奖<br/>
				</span>
				&nbsp;&nbsp;动动手指，就有机会赢得<b>30元话费</b>、<b>3D电影票</b>、<b>5-50元天地华宇抵用券</b>、<b>U盘和车模</b>喔！
			</td>
		</tr>
		<tr>
			<td>
				<span>
					<br/>
					<b>奖品说明： <br/></b>
				</span>
				&nbsp;&nbsp;中奖后请及时通过微信与我们联系喔~
			</td>
		</tr>
		<tr>
			<td>
				1：话费将于24小时内发送充值卡号及密码至您的微信中
			</td>
		</tr>
		<tr>
			<td>
				2：电影票（2D/3D通用）会于3个工作日内发送格瓦拉兑换券至您的微信中<br/>
				<span>
					&nbsp;&nbsp;电影票有效期：1年
				</span>
			</td>
		</tr>
		<tr>
			<td>
				3：天地华宇运费抵用券会于工作时间的3个小时内发送折扣代码和验证码至您的微信中<br/>
				<span>
					&nbsp;&nbsp;使用时间：2014.7.31-2014.9.15
				</span>
			</td>
		</tr>
		<tr>
			<td>
				4：U盘和车模请通过微信将您的联系方式和地址发给我们，我们会在第一时间寄出
			</td>
		</tr>
		<tr>
			<td>
				<br/>
				基于公平公正的原则，活动结束后我们将在下一期公布获奖名单。<br/><br/>
				注：最终解释权归天地华宇所有。
			</td>
		</tr>
		<tr>
			<td>
				*若您有其他的疑问，可与我们联系：<span style="color:blue">mail:qianqian1.zhu@hoau.net</span>
			</td>
		</tr>
	</table>
</body>
</html>