<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${scripts}/base.js" type="text/javascript"></script>
<div class="col_left fl">
	<div class="content_second_nav">
			<div class="content_second_nav">
				<h3>产品与服务 </h3>
				<ul>
					<li>
						<c:choose>
							<c:when test="${(!empty categoryName) && ('定日达' eq categoryName|| '经济快运' eq categoryName || '专车达' eq categoryName || '易到家' eq categoryName)}">
								<div class="subNav currentDt">主营产品</div>
								<ul class="navContent" style="display: block;">
							</c:when>
							<c:otherwise>
								<div class="subNav">主营产品</div>
								<ul class="navContent" style="display: none;">
							</c:otherwise>
						</c:choose>

							<li><a href="drdIntroduction.action" <c:if test="${(!empty categoryName) && ('定日达' eq categoryName)}">class="active"</c:if>
							>定日达</a></li>
							<li><a href="highway.action" <c:if test="${(!empty categoryName) && ('经济快运' eq categoryName)}">class="active"</c:if>
							>经济快运</a></li>
                            <li><a href="easyHome.action" <c:if test="${(!empty categoryName) && ('易到家' eq categoryName)}">class="active"</c:if>
                            >易到家</a></li>
							<li><a href="vehicle.action" <c:if test="${(!empty categoryName) && ('专车达' eq categoryName)}">class="active"</c:if>
							>专车达</a></li>
						</ul>
					</li>
					<li>
						<c:choose>
							<c:when test="${(!empty categoryName) && ('安全包装' eq categoryName|| '保价运输' eq categoryName || '送货服务' eq categoryName || '代收货款' eq categoryName || '其他' eq categoryName)}">
								<div class="subNav currentDt">增值服务</div>
								<ul class="navContent" style="display: block;">
							</c:when>
							<c:otherwise>
								<div class="subNav">增值服务</div>
								<ul class="navContent" style="display: none;">
							</c:otherwise>
						</c:choose>
							<li><a href="collectingMoney.action" <c:if test="${(!empty categoryName) && ('代收货款' eq categoryName)}">class="active"</c:if>
							>代收货款</a></li>
							<li><a href="insuredTransport.action" <c:if test="${(!empty categoryName) && ('保价运输' eq categoryName)}">class="active"</c:if>
							>保价运输</a></li>
							<li><a href="safePackaging.action" <c:if test="${(!empty categoryName) && ('安全包装' eq categoryName)}">class="active"</c:if>
							>安全包装</a></li>
							<li><a href="deliveryService.action" <c:if test="${(!empty categoryName) && ('送货服务' eq categoryName)}">class="active"</c:if>
							>送货服务</a></li>
							<li><a href="others.action" <c:if test="${(!empty categoryName) && ('其他' eq categoryName)}">class="active"</c:if>
							>其他</a></li>
						</ul>
					</li>
					<li  <c:if test="${(!empty categoryName) && ('市场推广' eq categoryName)}">class="current"</c:if>><a href="marketActivity.action">市场活动</a></li>
				</ul>
			</div>
		<%@include file="../quickBox.jsp" %>
		</div>
</div>