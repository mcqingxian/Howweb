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
			<div class="drd_pic"><img src="${images}/150602_img02.jpg" width="796" /></div>
			<div class="hoau_news">
			<c:if test="${!empty newDetail}">
				<form action="queryNewsDetail.action" name="newsDetailForm" id="newsDetailForm" method="post">
					<div id="title">${newDetail.title}</div>
					<div id="time"><fmt:formatDate value="${newDetail.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/> </div>
					<div id="content">${newDetail.content}</div>
					<div class="news_pages">
						<span class="fr">
						<input name="rowNum" value="${rowNum}" style="display: none;"/>
						<input name="forJump" value="${forJump}" style="display: none;"/>
						<input name="keyPoint" id="keyPoint" style="display: none;"/>
						<s:if test='rowNum == 1'>
							<a href="javascript:void(0)" onclick="$('#keyPoint').val('next');$('#newsDetailForm').submit();">下一篇</a>
						</s:if>
						<s:elseif test="rowNum == recordCount">
							<a href="javascript:void(0)" onclick="$('#keyPoint').val('previous');$('#newsDetailForm').submit();">上一篇</a>
						</s:elseif>
						<s:else>
							<a href="javascript:void(0)" onclick="$('#keyPoint').val('previous');$('#newsDetailForm').submit();">上一篇</a>
							<a href="javascript:void(0)" onclick="$('#keyPoint').val('next');$('#newsDetailForm').submit();">下一篇</a>
						</s:else>
						</span>
						<a href="${backToListAction }">返回列表</a>
					</div>
				</form>
			</c:if>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
