<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资料下载中心</title>
<%@include file="../head.jsp" %>
<script type="text/javascript">
$(function(){
    $("#questions").delegate(".question", "click",
    function() {
        var n;
        return $(this).next().toggle(),
        $(this).toggleClass("font-org"),
        n = $(this).find("i"),
        n.hasClass("icon-arrow-up") ? n.removeClass("icon-arrow-up").addClass("icon-arrow-down") : n.removeClass("icon-arrow-down").addClass("icon-arrow-up")
    });    
})
</script>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="news_detail pb20">
				<div class="drd_pic"><img src="${images}/help_banner.jpg" width="770" /></div>
				<h1 class="news_title">资料下载中心</h1>
				<div class="datadown">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<c:if test="${!empty downLoadResList}">
						<c:forEach var="resources" items="${downLoadResList}">
						<tr>
							<td width="65%">${resources.name}</td>
							<td width="20%"><fmt:formatDate value="${resources.createdAt}" pattern="yyyy-MM-dd"/></td>
							<td width="15%"><a href="${resources.url}">下载</a></td>
						</tr>
						</c:forEach>
					</c:if>
					</table>
				</div>
				
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
