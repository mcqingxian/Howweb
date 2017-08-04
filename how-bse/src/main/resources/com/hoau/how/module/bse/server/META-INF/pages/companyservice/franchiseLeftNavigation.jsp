<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${scripts}/base.js" type="text/javascript"></script>
<div class="col_left fl">
	<div class="content_second">
		<div class="content_second_nav">
			<h3>特许经营</h3>
			<ul>
				<li>
					<c:choose>
						<c:when test="${(!empty categoryName) && ('经营资质' eq categoryName|| '招商区域' eq categoryName || '特许动态' eq categoryName || '在线报名' eq categoryName)}">
							<div class="subNav currentDt">特许经营</div>
							<ul class="navContent" style="display: block;">
						</c:when>
						<c:otherwise>
							<div class="subNav">特许经营</div>
							<ul class="navContent" style="display: none;">
						</c:otherwise>
					</c:choose>
						<li><a href="franchise.action?newsId=12903" <c:if test="${(!empty categoryName) && ('经营资质' eq categoryName)}">class="active"</c:if>>经营资质</a></li>
						<li><a href="franchiseArea.action" <c:if test="${(!empty categoryName) && ('招商区域' eq categoryName)}">class="active"</c:if>>招商区域</a></li>
						<li><a href="franchiseDynamic.action" <c:if test="${(!empty categoryName) && ('特许动态' eq categoryName)}">class="active"</c:if>>特许动态</a></li>
						<li><a href="franchiseRegist.action" <c:if test="${(!empty categoryName) && ('在线报名' eq categoryName)}">class="active"</c:if>>在线报名</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<%@include file="../quickBox.jsp" %>
	</div>
</div>