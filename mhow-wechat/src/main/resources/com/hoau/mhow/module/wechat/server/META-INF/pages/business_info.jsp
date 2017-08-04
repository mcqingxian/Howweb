<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/business_info.js"></script>
<meta charset="utf-8">
<style>
*{
	padding:0px;
	margin:0px;
	}
</style>
<title>业务信息</title>
</head>
	
<body>
 
    <div data-role="page">
      <div data-role="header">
      	<h1>业务信息</h1>
      </div>
      <div data-role="content">
        <div style="width:100%; text-align:center; margin-top:0px;">
            <img style="width:100%; height:100px;" src="../images/business_info_banner.png" />
        </div>
        <div style="width:100%; margin-top:10px;">
        	<div style="width:50%; background-color:#C00000; height:70px; line-height:70px; float:left; text-align:center;">
            	公司介绍
            </div>
        	<div style="width:50%; background-color:#45A2E6; height:70px; line-height:70px; float:left; text-align:center;">
            	产品服务
            </div>
            <div style="float:none;"></div>
        	<a>
        	
        	</a>
        	<div id="mapPattern" style="width:50%; background-color:#9AA304; height:70px; line-height:70px; float:left; text-align:center;">
            	门店查询
            </div>
        	<div id= "priceTime" style="width:50%; background-color:#7030A0; height:70px; line-height:70px; float:left; text-align:center;">
            	价格时效查询
            </div>
        </div>
      </div>
    </div> 
</body>
</html>
