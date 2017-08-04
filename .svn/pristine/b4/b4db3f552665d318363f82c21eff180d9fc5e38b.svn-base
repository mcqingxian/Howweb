<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>市场活动</title>
<%@include file="../head.jsp" %>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/150602_img02.jpg" width="796" /></div>
			<div class="news_detail">
				<h1 class="news_title">市场活动</h1>
				<div class="event_list">
					<div class="promotion_list">
						<ul>
						<c:if test="${!empty marketList}">
							<c:forEach var="market" items="${marketList}">
							<li>
								<a href="queryNewsDetail.action?newsId=${market.id}&rowNum=${market.rowNum}&forJump=${categoryName}" class="go-dynamic">
									<span class="promotion_pic">
									<c:choose>
											<c:when test="${market.isDisable==true}"><img src="${market.sltSrc}" class="finished"/></c:when>
											<c:otherwise><img src="${market.sltSrc }"/></c:otherwise>
									</c:choose>
									</span>
									<div class="event_content">
									<h5 class="promotion-title">${market.shortTitile }</h5>
									<c:choose>
										<c:when test="${market.isDisable==false}">
											<span class="promotion_status_label hot_in">进行中</span></c:when>
										<c:otherwise><span class="promotion_status_label finished">已结束</span></c:otherwise>
									</c:choose>
									<div class="date">
										<c:choose>
											<c:when test="${empty market.validityPeriod}">&nbsp;</c:when>
											<c:otherwise>${market.validityPeriod}</c:otherwise>
										</c:choose>
									</div>
									<div class="range">全国所有网点　适用</div>
								</div>
								</a>
							</li>
						</c:forEach>
						</c:if>
						</ul>
						<div class="clearfix"></div>
					</div>
					<w:pager pageSize="${pageSize}" pageNo="${pageIndex}" url="marketActivity.action"
		recordCount="${recordCount}" />
				</div>
				
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
