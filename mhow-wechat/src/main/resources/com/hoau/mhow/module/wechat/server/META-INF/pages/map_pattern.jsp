<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script
	src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/map_pattern.js"></script>
<title>地图模式</title>
<style>
p {
	text-align: center;
}
td {
	white-space:nowrap;
    text-overflow:ellipsis;
    overflow: hidden;
}
</style>
</head>
<body>
	<!-- 地图模式 -->
	<div data-role="page" id="mapPattern">
		<div data-role="content">
			<div style="width: auto; text-align: center;" id="nav">
				<fieldset data-role="controlgroup" data-type="horizontal">
					<!-- <button onclick="lodeSupport()">我的位置</button> -->
					<button id="nearbyDepartments" data-theme="h">附近门店</button>
					<button id="departmentList" data-theme="h">门店列表</button>
				</fieldset>
			</div>
			<div id="l-map" style="height: 500px;"></div>
		</div>
	</div>
	
</body>
</html>


