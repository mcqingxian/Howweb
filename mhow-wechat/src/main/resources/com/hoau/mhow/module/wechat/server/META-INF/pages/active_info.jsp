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
span{
	font-weight: bold;
	color: #F25822;
}
p   {   text-indent:2em;} 

h3{
	margin-top: 20px;
	margin-bottom: 10px;
	color: #F25822;
}
p{
	margin-bottom: 10px;
}
</style>
<title>公司活动信息</title>
</head>
	
<body>
 
    <div data-role="page">
      <div data-role="content">
      	<div style="text-align: center;">
	        <img src="<%=request.getContextPath()%>/images/active_info.jpg">
      	</div>
        <div style="width: auto;">
	        <h3>万“粽”巨惠服务加倍——保护膜免费加，送货费更加省</h3>
        </div>
        <p>
        	<span>活动时间：</span>2014.4.20——2014.5.31
        </p>
        <p>
        	<span>活动范围：</span>仅限以下城市发定日达客户
        	嘉兴、杭州、金华、无锡、广州、东莞、深圳、佛山、阳江、中山、南宁、成都、重庆、北京、上海、西安、长沙
        </p>
        
        <p>
        	<span>活动内容：</span>活动期间，发粽子类货物（粽子、粽叶、糯米等粽子原材料），即可免费加膜，同时单票发货满200元还可以立减送货费30元（送货费不包含送货上楼及进仓费），偏远城市不参与此次活动。
        </p>
        
        <div id="footer" style="font-size: 15px;margin-top: 20px;">
        	详情请登陆天地华宇官方网站（www.hoau.net）查看，或咨询400-800-6666及当地营业部
        </div>
      </div>
    </div> 
</body>
</html>
