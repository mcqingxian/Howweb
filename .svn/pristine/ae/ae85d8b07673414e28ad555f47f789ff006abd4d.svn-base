<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>招商区域</title>
<script type="text/javascript" src="${scripts}/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${scripts}/franchise.js"></script>
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
				<h1 class="news_title">特许招商区域</h1>
				<div>
					特许经营区域选择：<br/>
					<table>
						<tr>
							<td colspan="3">
								<select id="selProvince" onchange="changeProvince(this);">
									<option value="-1">请选择省</option>
								</select>
								<select id="selCity">
									<option value="-1">请选择市</option>
								</select>
								<a href="javascript:queryFranchiseInfo();" class="xz1 mr10">查询</a>
							</td>
						</tr>
						<tr>
							<td id="tdContacts" >
								
							</td>
							<td id="tdPhone" style="padding-left:20px;">
								
							</td>
							<td id="tdEmail" style="padding-left:20px;">
								
							</td>
						</tr>
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
