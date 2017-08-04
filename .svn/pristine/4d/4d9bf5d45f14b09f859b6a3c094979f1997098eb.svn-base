<%@ page language="java" import="com.hoau.wechat.vo.LotteryDrawResult" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
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
	.tab{
		width: 100%;
		padding: 15px;
		margin: 0 auto;
		text-align: center;
	}
	.tab td{padding: 5px;}
	td{
		color:#f15a22;
	}
</style>
<script type="text/javascript">
</script>
<title>天地华宇抽奖</title>
</head>
<body onload="onload(document.body.style,<s:property value="hasQualifications"/>,'<%=request.getContextPath()%>/img/<s:property value="drawResult.imageName"/>');">
	<div data-role="page1">
		<img alt="校园托运" src="<%=request.getContextPath()%>/images/compus_activity.jpg" style="width: 100%;">
		<table align="center" width="260px" id="canvasTable_tmp">
		</table>
		<table  align="center" id="canvasTable">
			<tr>
				<td style="text-align: center;"><b>快刮开图层,试试手气吧！</b></td>
			</tr>
			<tr>
				<td><canvas id="myCanvas"></canvas></td>
			</tr>
		</table>
		<s:if test="hasQualifications">
		</s:if>
		<s:else>
			<div style="width:90%;margin:5px auto;text-align:center;color:red"><b>请先回复“天地华宇校园托运”获取幸运码,邀请三位好友关注天地华宇微信,并回复您的幸运码即可参与抽奖！</b></div>
		</s:else>
		<div data-role="content" id="winningDiv">
			<s:if test="tipMsg != null">
				<div style="width:90%;margin:5px auto;text-align:center;color:red"><b>${tipMsg }</b></div>
			</s:if>
			<button data-theme = "h" onclick="lookupFun('lotteryRecord_ul')">【查看中奖纪录】</button>
			<ul data-role="listview" data-inset="true" id="lotteryRecord_ul" style="display:none;">
				<s:if test="voucherRecords.size == 0">	
					<li style="color:#f15a22;text-align:center">您还没中过奖!</li>
				</s:if>
				<s:else>
					<s:iterator id="vo" value="voucherRecords">
						<li style="color:#f15a22;text-align:center">
							<table class="tab">
								<tr>
									<td><s:property value="#vo.vouchersName"/></td>
									<td><s:property value="#vo.vouchersCode"/></td>
									<td>
										<s:if test="#vo.expiry==0">未使用</s:if>
										<s:elseif test="#vo.expiry==1">已使用</s:elseif>
									</td>
								</tr>
							</table>
						</li>
					</s:iterator>
				</s:else>
			</ul>
			<ul data-role="listview" data-inset="true" >
				<li data-role='list-divider' style="text-align: center;">近期得奖用户信息</li>
			</ul>
			<table class="tab">
				<tr>
					<td>昵称</td>
					<td>省市</td>
					<td>城市</td>
				</tr>
				<s:iterator id="vo" value="lastRecords">
				<tr>
					<td><s:property value="#vo.nickname"/></td>
					<td><s:property value="#vo.province"/></td>
					<td><s:property value="#vo.city"/></td>
				</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>