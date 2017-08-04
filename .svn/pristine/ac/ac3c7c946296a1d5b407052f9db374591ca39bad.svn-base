var map;
function createMap(lng,lat,deptName,phone,addressDetail,serviceName,bounds,color){
	/*****滚动地图缩放时，外部滚动条不会一起滚动*****/
	$('body').delegate('#map','mousewheel',function(){
	  return false;
	});
	
	map = new BMap.Map("map");
	if(lng != "" && lat != ""){
		var point = new BMap.Point(lng,lat);
		map.centerAndZoom(point, 12);
		var marker = new BMap.Marker(point);// 创建标注
		map.addOverlay(marker);             // 将标注添加到地图中
		marker.disableDragging();           // 不可拖拽
		map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
		map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
		map.addControl(new BMap.OverviewMapControl());
		map.enableScrollWheelZoom();		//可以缩放

		/**
		 * @author 唐征征
		 * @date 2017/7/26 下午2:22
		 * @description //目的站服务范围
		 */
        // var polygonMap = new Ext.util.HashMap();//派送范围
        var points = new Array();
        // var bounds = eval(bounds);
        bounds=bounds.replace("[","");
        bounds=bounds.replace("]","");

        bounds=bounds.split(',')

        if (bounds != null) {
            for (var j = 0; j < bounds.length; j++) {
                var latlng = bounds[j];
                var latlngArray = latlng.split("_");
                points[j] = new BMap.Point(latlngArray[0], latlngArray[1]);
            }
            var polygon = new BMap.Polygon(points, {
                strokeColor: "blue",
                strokeWeight: 2,
                strokeOpacity: 0.5
            });
            polygon.setFillColor(color);
            // polygonMap.add(destination.code,polygon);
            map.addOverlay(polygon);

        }




		//------------------
		
		var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
			'联系电话：' + phone + '<br/>'+
			'地址：' + addressDetail + '<br/>'+
			'服务方式：' + serviceName + '<br/>'+ 
			'</div>';
		
		var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
			title  : deptName,      //标题
			width  : 290,             //宽度
			height : 105,              //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes  :[
	        	BMAPLIB_TAB_TO_HERE,  //到这里去
				BMAPLIB_TAB_SEARCH   //周边检索
			]
		});
		marker.addEventListener("click", function(e){
		    searchInfoWindow.open(marker);
	    })
	}else{
		var point = new BMap.Point(106.45483, 34.321154);
		map.centerAndZoom(point, 5);
		map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
		map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
		map.addControl(new BMap.OverviewMapControl());
		map.enableScrollWheelZoom(); // 可以缩放
	}
}