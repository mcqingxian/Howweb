$(document).ready(function(e) {
	$("#map_pattern").click(function(){
		var url = "/wechat/toDepartMentPage.action";
		window.location.href = url;
	});
});

var param;
function changePage(e){
	var a = e.getAttribute("id");
	var hideId = "position"+a;
	var td = document.getElementById(hideId);
	param = td.innerHTML;
	$.mobile.changePage("#linePage", {
		transition : "none",
		changeHash : false
	});
}

$(document).on("pageinit","#linePage",function() {
	//当前点，目标点经纬度，和部门名称
	var array = param.split('#');
	var curLon = array[1].split('-')[0];
	var curLat = array[1].split('-')[1];
	
	var destLon = array[0].split('-')[0];
	var destLat = array[0].split('-')[1];
	
	var departmentName = array[2];
	
	//初始化地图，以及将线路画在地图上
	var map = new BMap.Map("map");      
	map.centerAndZoom(new BMap.Point(curLon, curLat), 14);      
	
	//信息窗口

	var routeSearch=new BMap.RouteSearch();  
	var start = {  
	      latlng:new BMap.Point(curLon, curLat),  
	      name:"--"  
	  };  
	var end = {  
	     latlng:new BMap.Point(destLon,destLat),  
	     name:departmentName 
	  };
	var opts = {  
	     mode:BMAP_MODE_DRIVING,//公交、驾车、导航均修改该参数  
	     region:"上海市" 
	};

	routeSearch.routeCall(start,end,opts); 
	
	var opts = {      
		    width : 100,     // 信息窗口宽度      
		    height: 50/*,     // 信息窗口高度      
		    title : "Hello"  // 信息窗口标题     
*/	};
	var infoWindow = new BMap.InfoWindow("加载中...", opts);  // 创建信息窗口对象      
	map.openInfoWindow(infoWindow, new BMap.Point(destLon, destLat));
});