<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>特许经营动态</title>
<%@include file="../head.jsp" %>
</head>
<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="franchiseLeftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/busin_banner.jpg" width="770" /></div>
			<div class="news_detail">
				<h1 class="news_title">特许经营动态</h1>
				<c:if test="${!empty newsList}">
					<div class="hoau_news_list">
						<ul class="newselect">
						<c:forEach var="news" items="${newsList}">
							<li><span class="fr">
							<fmt:formatDate value="${news.createAt}" pattern="[yyyy-MM-dd HH:mm:ss]"/> 
							</span><a href="queryNewsDetail.action?newsId=${news.id}&rowNum=2&forJump=特许经营动态">${news.title}</a></li>
						</c:forEach>
						</ul>
					</div>
				</c:if>
				<w:pager pageSize="${pageSize}" pageNo="${pageNo}" url="hoauDynamic.action"
							recordCount="${recordCount}" />
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
