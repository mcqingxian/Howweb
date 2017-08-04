<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联系我们</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=5YgLbKiB9FHiMCITPb4LZy5B&s=1"></script>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
	<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/about_banner.jpg" width="770" /></div>
			<div class="news_detail">
				<h1 class="news_title">联系我们</h1>
				<div class="contact">
					<div style="width:730px;height:350px; margin-bottom:20px;" id="map"></div>
					<p class="f000 mb10">全国客服热线</p>					
					<p>全国客服热线:400-808-6666</p>
					<p>服务时间：8：00-20：00（人工服务，全年无休）20：00-8：00（语音自助查询）</p>
					<br />
					<p class="f000 mb10">集团总部联系方式</p>					
					<p>集团总机：021-62636666</p>
					<p>服务质量监督邮箱：service@hoau.net</p>
					<p>媒体公关：李小姐  021-62636311 hoau.pr@hoau.net</p>
					<p>地址：上海市闵行区华翔路2239号 天地华宇集团大楼</p> 
					<p>邮编：201107</p>
				</div>			
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
<script type="text/javascript">

$('body').delegate('#map', 'mousewheel', function() {
	return false;
});
$('body').delegate('#map', 'DOMMouseScroll', function() {
	return false;
});
    //创建和初始化地图函数：
    function initMap(){
      createMap();//创建地图
      setMapEvent();//设置地图事件
      addMapControl();//向地图添加控件
      addMapOverlay();//向地图添加覆盖物
    }
    function createMap(){ 
      map = new BMap.Map("map"); 
      map.centerAndZoom(new BMap.Point(121.309628,31.210514),16);
    }
    function setMapEvent(){
      map.enableScrollWheelZoom();
      map.enableKeyboard();
      map.enableDragging();
      map.enableDoubleClickZoom()
    }
    function addClickHandler(target,window){
      target.addEventListener("click",function(){
        target.openInfoWindow(window);
      });
    }
    function addMapOverlay(){
      var markers = [
        {content:"<hr/>全国客服热线:400-808-6666</br>服务时间：8：00-20：00（人工服务，全年无休）20：00-8：00（语音自助查询）",title:"<h3>联系方式</h3>",imageOffset: {width:-46,height:-21},position:{lat:31.21073,lng:121.30963}}
      ];
      for(var index = 0; index < markers.length; index++ ){
        var point = new BMap.Point(markers[index].position.lng,markers[index].position.lat);
        var marker = new BMap.Marker(point,{icon:new BMap.Icon("https://api.map.baidu.com/lbsapi/createmap/images/icon.png",new BMap.Size(20,25),{
          imageOffset: new BMap.Size(markers[index].imageOffset.width,markers[index].imageOffset.height)
        })});
        var opts = {
          width: 200,
          title: markers[index].title,
          enableMessage: false
        };
        var infoWindow = new BMap.InfoWindow(markers[index].content,opts);
        addClickHandler(marker,infoWindow);
        map.addOverlay(marker);
      };
    }
    //向地图添加控件
    function addMapControl(){
      var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
      map.addControl(navControl);
    }
    var map;
	initMap();
	
	
</script>
</body>
</html>
