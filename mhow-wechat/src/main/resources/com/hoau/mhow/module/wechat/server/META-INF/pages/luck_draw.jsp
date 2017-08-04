<%@ page language="java" import="com.hoau.wechat.vo.LotteryDrawResult" contentType="text/html; charset=UTF-8"
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
<script src="<%=request.getContextPath()%>/scripts/activities.js"></script>
<style type="text/css">
	body{
		background-color:#CCC;
	}
	
	td{
		color:#f15a22;
	}
</style>
<script type="text/javascript">
	/************************分享相关内容****************************/
	var imgUrl = "http://wechat.hoau.net/wechat/images/logo.jpg";
	var lineLink = "http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200473357&idx=1&sn=b3693362cfd9a55fe64ba4a4efbafc26#rd";
	var descContent = '话费电影票，送送送不停！';
	var shareTitle = '【天地华宇】，话费电影票，送送送不停！';
	var appid = '';
	function shareTimeline() {
	    WeixinJSBridge.invoke('shareTimeline',{
	        "img_url": imgUrl,
	        "img_width": "200",
	        "img_height": "200",
	        "link": lineLink,
	        "desc": descContent,
	        "title": shareTitle
	    }, function(res) {
	        //记录分享
			shareSuccess();
	    });
	}
	 
	function shareWeibo() {
	    WeixinJSBridge.invoke('shareWeibo',{
	        "content": descContent,
	        "url": lineLink,
	    }, function(res) {
	     	//记录分享
	     	shareSuccess();
	    });
	}
	 
	//后台记录该用户的分享记录
	function shareSuccess(){
	 	$.post("/wechat/shareRecord.action",
			  {},
			  function(data,status){
			    if(status == "success"){
			    	if(data.shareStatus== 0){
			    		alert("你已经分享过！");
			    	}else{
			    		alert("恭喜你额外获得一次抽奖机会！");
			    	}
			    }else{
			    	alert("网络异常");
			    }
			}
		);
	}
	
	// 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	    // 分享到朋友圈
	    WeixinJSBridge.on('menu:share:timeline', function(argv){
	        shareTimeline();
	    });
	    
	    // 分享到微博
	    WeixinJSBridge.on('menu:share:weibo', function(argv){
	        shareWeibo();
	    });
	}, false);
</script>
<title>天地华宇抽奖</title>
</head>
<body onload="onload(document.body.style,<s:property value="drawResult.qualification"/>,'<%=request.getContextPath()%>/img/<s:property value="drawResult.imageName"/>');">
	<div data-role="page1">
		<table align=center width=260 id="canvasTable_tmp">
		</table>
		<table align=center id="canvasTable">
			<tr>
				<td><b>快刮开图层,试试手气吧！</b></td>
			</tr>
			<tr>
				<td><canvas id="myCanvas"></canvas></td>
			</tr>
		</table>
		<s:if test="drawResult.qualification">
		</s:if>
		<s:else>
			<div style="text-align:center;color:red"><b>请绑定手机、或分享该页再抽奖！</b></div>
		</s:else>
		<div data-role="content" id="winningDiv">
			<button data-theme = "h" onclick="lookupFun('lotteryRecord_ul')">【查看中奖纪录】</button>
			<ul data-role="listview" data-inset="true" id="lotteryRecord_ul" style="display:none;">
				<s:iterator id="vo" value="records">
					<li style="color:#f15a22;text-align:center"><s:property value="#vo.detail"/></li>
				</s:iterator>
			</ul>
			<ul data-role="listview" data-inset="true">
				<li data-role='list-divider'>近期得奖用户信息</li>
				<s:iterator id="vo" value="lotteryRecordVos">
					<li style="color:#f15a22;text-align:center">
						<s:property value="#vo.phone"/>&nbsp;&nbsp;<s:property value="#vo.detail"/>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>
</body>
</html>