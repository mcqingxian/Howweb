<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${newDetail.shortTitile}</title>
<%@include file="../head.jsp" %>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/busin_banner.jpg" width="770" /></div>
			<div class="hoau_news">
			<c:if test="${!empty newDetail}">
				<div id="title">${newDetail.title}</div>
				<div id="time"><fmt:formatDate value="${newDetail.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/> </div>
				<div id="content">${newDetail.content}</div>
			</c:if>
			</div>
		</div> 
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
