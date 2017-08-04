<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>华宇新闻</title>
<%@include file="../head.jsp" %>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/about_banner.jpg" width="796" /></div>
			<div class="hoau_news">
				<div class="hoau_news_tab">			
					<a href="hoauDynamic.action">华宇动态</a>		
					<a href="javascript:void(0)" class="active">华宇公告</a>
					<a href="mediaReports.action">媒体报道</a>
					<a href="logisticsInfo.action">物流资讯</a>
				</div>
				<c:if test="${!empty newsList}">
					<div class="hoau_news_list">
						<ul class="newselect">
						<c:forEach var="news" items="${newsList}">
							<li><span class="fr">
							<fmt:formatDate value="${news.createAt}" pattern="[yyyy-MM-dd HH:mm:ss]"/> 
							</span><a href="queryNewsDetail.action?newsId=${news.id}&rowNum=${news.rowNum}&forJump=${categoryName}" target="_blank">${news.title}</a></li>
						</c:forEach>
						</ul>
					</div>
				</c:if>
				<w:pager pageSize="${pageSize}" pageNo="${pageNo}" url="hoauNotice.action"
		recordCount="${recordCount}" />
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
