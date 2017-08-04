<%@page language="java" pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${newDetail.shortTitile}</title>
</head>
<body>
<div data-role="page">
	<div id="wrapper">
		<div id="wrapper-in">
			<div id="main-page">
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:history.go(-1);">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">市场活动</h1>
					<span class="btn-topr">
						<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
							<span class="ui-ico ui-ico-home"></span>
						</a>
						<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
							<span class="ui-ico ui-ico-nav"></span>
						</a>
					</span>
				</div>
				<div data-role="content">
					<div class="content">
						<div class="p_w">
							<div class="col_right fr">
								<%-- <div class="drd_pic"><img src="${images}/150602_img02.jpg" width="796" /></div> --%>
								<div class="hoau_news">
								<c:if test="${!empty newDetail}">
									<div class="tc" style="color:#000;font-size: 16px;margin-bottom:10px;">${newDetail.title}</div>
									<div class="news_content">${newDetail.content}</div>
								</c:if>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<%@ include file="../bse/footer.jsp" %> 
			</div>
			<div id="map-page">
				<%@ include file="../bse/nav-map.jsp" %>  
	    	</div>
	    </div>
	 </div>
</div>
</body>
</html>
