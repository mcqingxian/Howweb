<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${scripts}/base.js" type="text/javascript"></script>
<%--监控客服 PV UV--%>
<script>
    //声明_czc对象:
    var _czc = _czc || [];
    //绑定siteid，请用您的siteid替换下方"XXXXXXXX"部分
    _czc.push(["_setAccount", "1262570488"]);
</script>
<div class="col_left fl">
	<div class="content_second">
		<div class="content_second_nav">
			<h3>帮助与支持</h3>
			<ul>
				<%-- <li <c:if test="${(!empty categoryName) && ('新手指南' eq categoryName)}">class="current"</c:if>><a href="" >新手指南</a></li> --%>
				<li <c:if test="${(!empty categoryName) && ('常见答疑' eq categoryName)}">class="current"</c:if>><a href="commonQuestions.action" >常见答疑</a></li>
				<li <c:if test="${(!empty categoryName) && ('资料下载中心' eq categoryName)}">class="current"</c:if>><a href="download.action" >资料下载中心</a></li>
				<li <c:if test="${(!empty categoryName) && ('咨询建议' eq categoryName || '投诉' eq categoryName )}">class="current"</c:if>><a href="advisorySuggestion.action">咨询/投诉/建议</a></li>
				<li <c:if test="${(!empty categoryName) && ('在线客服' eq categoryName)}">class="current"</c:if>><a href="http://chat32.live800.com/live800/chatClient/chatbox.jsp?companyID=131736&configID=16306&jid=3012363085&enterurl=http%3A%2F%2Fwww%2Ehoau%2Enet%2Fkhfw%2F&timestamp=1320893435803&pagereferrer=http%3A%2F%2Fwww%2Ehoau%2Enet%2F" target="__blank" onclick="_czc.push(['_trackPageview','在线客服','https://www.hoau.net'])" >在线客服</a></li>
				<li <c:if test="${(!empty categoryName) && ('禁运品' eq categoryName)}">class="current"</c:if>><a href="contraband.action">禁运品</a></li>
			</ul>
		</div>
	<%@include file="../quickBox.jsp" %>
	</div>
</div>