<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${scripts}/base.js" type="text/javascript"></script>
<div class="col_left fl">
	<div class="content_second">
		<div class="content_second_nav">
			<h3>企业服务</h3>
			<ul>
				<li  <c:if test="${(!empty categoryName) && ('电商合作' eq categoryName)}">class="current"</c:if>><a href="e-commerce.action">电商合作</a></li>
				<li  <c:if test="${(!empty categoryName) && ('开放平台' eq categoryName)}">class="current"</c:if>><a href="terrace.action">开放平台</a></li>
				<li><a href="http://sou.hoau.net" target="_blank">采购平台</a></li>
				<li><a href="http://114.141.133.241:8080/bid/toLogin.do" target="_blank">投标报名</a></li>
			</ul>
		</div>
		<%@include file="../quickBox.jsp" %>
	</div>
</div>