<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${scripts}/base.js" type="text/javascript"></script>
<div class="col_left fl">
	<div class="content_second">
		<div class="content_second_nav">
			<h3>关于华宇</h3>
			<ul>
				<li>
					<c:choose>
						<c:when test="${(!empty categoryName) && ('公司简介' eq categoryName|| '大事记' eq categoryName || '资质荣誉' eq categoryName || '社会责任' eq categoryName)}">
							<div class="subNav currentDt">华宇概述</div>
							<ul class="navContent" style="display: block;">
						</c:when>
						<c:otherwise>
							<div class="subNav">华宇概述</div>
							<ul class="navContent" style="display: none;">
						</c:otherwise>
					</c:choose>
						<li><a href="companyProfile.action" <c:if test="${(!empty categoryName) && ('公司简介' eq categoryName)}">class="active"</c:if>>公司简介</a></li>
						<li><a href="companyBigEvent.action" <c:if test="${(!empty categoryName) && ('大事记' eq categoryName)}">class="active"</c:if>>大事记</a></li>
						<li><a href="honor.action" <c:if test="${(!empty categoryName) && ('资质荣誉' eq categoryName)}">class="active"</c:if>>资质荣誉</a></li>
						<li><a href="socialResponsibility.action" <c:if test="${(!empty categoryName) && ('社会责任' eq categoryName)}">class="active"</c:if>>社会责任</a></li>
					</ul>
				</li>

				<%--<li>--%>
					<%--<c:choose>--%>
					<%--<c:when test="${(!empty categoryName) && ('华宇动态' eq categoryName || '华宇公告' eq categoryName || '媒体报道' eq categoryName || '物流资讯' eq categoryName)}">--%>
					<%--<div class="subNav currentDt">华宇新闻</div>--%>
					<%--<ul class="navContent" style="display: block;">--%>
						<%--</c:when>--%>
						<%--<c:otherwise>--%>
						<%--<div class="subNav">华宇新闻</div>--%>
						<%--<ul class="navContent" style="display: none;">--%>
							<%--</c:otherwise>--%>
					<%--</c:choose>--%>
							<%--<li><a href="hoauDynamic.action" <c:if test="${(!empty categoryName) && ('华宇动态' eq categoryName)}">class="active"</c:if>>华宇动态</a></li>--%>
							<%--<li><a href="hoauNotice.action" <c:if test="${(!empty categoryName) && ('华宇公告' eq categoryName)}">class="active"</c:if>>华宇公告</a></li>--%>
							<%--<li><a href="mediaReports.action" <c:if test="${(!empty categoryName) && ('媒体报道' eq categoryName)}">class="active"</c:if>>媒体报道</a></li>--%>
							<%--<li><a href="logisticsInfo.action" <c:if test="${(!empty categoryName) && ('物流资讯' eq categoryName)}">class="active"</c:if>>物流资讯</a></li>--%>
						<%--</ul>--%>
				<%--</li>--%>
				<li <c:if test="${(!empty categoryName) && ('华宇新闻' eq categoryName || '天地华宇动态' eq categoryName || '华宇公告' eq categoryName || '媒体报道' eq categoryName || '物流资讯' eq categoryName )}">class="current"</c:if>><a href="hoauDynamic.action" >华宇新闻</a></li>
				<li <c:if test="${(!empty categoryName) && ('人才招聘' eq categoryName)}">class="current"</c:if>><a href="http://zhaopin.hoau.net" target="_blank">人才招聘</a></li>
				<li <c:if test="${(!empty categoryName) && ('联系我们' eq categoryName)}">class="current"</c:if>><a href="contactUs.action" >联系我们</a></li>
				
			</ul>
		</div>
		<%@include file="../quickBox.jsp" %>
	</div>
</div>