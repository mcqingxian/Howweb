function killErrors() {
	return true;
}
window.onerror = killErrors;
var map;
var opt_options = [[{
	url : '../images/bse/mapSign.png',
	height : 26,
	width : 84,
	opt_anchor : [ 11, 0 ],
	textColor : 'black',
	opt_textSize : 0
}],
[{
	url: '../images/bse/index_yellow.png',
	height : 33,
	width : 41,
	anchor : [ 0, 0 ],
	textColor : 'white',
	textSize : 0
}],
[{
	url: '../images/bse/index_red.png',
	height : 33,
	width : 41,
	anchor : [ 0, 0 ],
	textColor : 'white',
	textSize : 0
}],
[{
	url: '../images/bse/index_violet.png',
	height : 33,
	width : 41,
	anchor : [ 0, 0 ],
	textColor : 'white',
	textSize : 0
}],
    [{
        url: '../images/bse/index_orange.png',
        height: 33,
        width: 41,
        anchor: [0, 0],
        textColor: 'white',
        textSize: 0
    }]
];
//部门信息
var departmentVos;

$(window).load(function() {
	createMap();
	var $leaved = $("#leavedCityName");
	if($leaved.val() == $leaved.attr("ov")){
		loadHotCity();
		loadProvince();
	}else{
		loadHotCity();
		findDeptDistance();
	}
});
function createMap() {
	/** ***滚动地图缩放时，外部滚动条不会一起滚动**** */
	$('body').delegate('#map', 'mousewheel', function() {
		return false;
	});

	map = new BMap.Map("map");
	var point = new BMap.Point(106.45483, 34.321154);
	map.centerAndZoom(point, 5);
	map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
	map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
	map.addControl(new BMap.OverviewMapControl());
	map.enableScrollWheelZoom(); // 可以缩放
}

/**
 * 加载热门城市
 * @author 莫涛
 * @date 2015年7月8日
 * @update
 */
function loadHotCity(){
	$.post("companyMatchAction!queryHotCityJson.action", {
	}, function(data, status) {
		var $hotCity = $("#hot_cityList");
		for(var i = 0 ; i < data.districtVos.length; i ++){
			var vo = data.districtVos[i];
			$hotCity.append("<a href='javascript:$(\".provinceName\").html(\"\");loadCounty(\"cityCode\",\""+vo.districtCode+"\",\""+vo.districtName+"\")'>"+vo.districtName+"</a>");
		}
	});
}

function loadChina(){
	var point = new BMap.Point(106.45483, 34.321154);
	map.centerAndZoom(point, 5);
	map.clearOverlays();
	loadProvince();
	$("#province_div").show();
	$("#hotCity_div").show();
	$("#district_div").show();
	$("#city_div").hide();
	$("#deptList_div").hide();
	$("#screen_div").hide();
}

function loadProvince() {
	$.post("companyMatchAction!queryProvinceCountJson.action", {
	}, function(data, status) {
		var $province = $("#province_list_div");
		var $pinYin = $("#pinYin_list_div");
		$province.html("");
		$pinYin.html("");
		for(var i = 0 ; i < data.districtVos.length; i ++){
			var vo = data.districtVos[i];
			var provinceName = vo.districtName;
			if(provinceName=="内蒙古"){
				provinceName="内蒙古自治区";
			}else if(provinceName=="宁夏"){
				provinceName="宁夏回族自治区";
			}else if(provinceName=="广西"){
				provinceName="广西壮族自治区";
			}else if(provinceName=="新疆"){
				provinceName="新疆维吾尔自治区";
			}else if(provinceName=="西藏"){
				provinceName="西藏自治区";
			}else if(provinceName=="香港"){
				provinceName="香港特别行政区";
			}else if(provinceName=="澳门"){
				provinceName="澳门特别行政区";
			}
			var text = vo.districtName + "("+vo.total+")";
			//加载右边的省份列表
			$province.append("<a href='javascript:loadCity(\"districtCode\",\""+vo.districtCode+"\",\""+provinceName+"\",true)'>"+vo.districtName+"</a>");
			addMarker(vo.districtCode,provinceName,text,opt_options[0],null,"city");
		}
		for(var i = 0 ; i < data.pinYins.length;i++){
			var pinYin = data.pinYins[i];
			if(pinYin == "全部"){
				continue;
			}
			$pinYin.append("<a href='javascript:loadCity(\"pinyin\",\""+pinYin+"\",\""+pinYin+"\")'>"+pinYin+"</a>");
		}
	});
}


function loadCity(typeName,typeValue,districtName,hotCity){
	//显示城市和区域相关信息
	showCityCountyDiv();
	if(hotCity){
		$("#hotCity_div").show();
	}
	//显示目录
	showDirectory(typeName,typeValue,districtName, 1);
	$.post("companyMatchAction!queryCityCountJson.action",{
		"typeName" : typeName,
		"typeValue" : typeValue
		},
		function(data, status) {
			$("#cityTable").html("");
			var tab = $("#cityTable").get(0);
			var row;
			if(data.districtVos.length > 0){
				row = tab.insertRow();
			}
			map.clearOverlays();
			var zoom;
			for(var i = 0 ; i < data.districtVos.length; i ++){
				var vo = data.districtVos[i];
				if(row.cells.length >= 3){
					row = tab.insertRow();
				}
				var cell = row.insertCell();
				var text = vo.districtName + "("+vo.total+")";
				var innerHTML = "<a href='javascript:loadCounty(\"cityCode\",\""+vo.districtCode+"\",\""+vo.districtName+"\")'>"+text+"</a>";
				cell.innerHTML = innerHTML;
				if(i == data.districtVos.length - 1){
					zoom = true;
				}
				addMarker(vo.districtCode,vo.districtName,text,opt_options[0],zoom,"county");
			}
		}
	);
}

function loadCounty(typeName,typeValue,districtName){
	//显示城市和区域相关信息
	showCityCountyDiv();
	//显示目录
	showDirectory(typeName,typeValue,districtName, 2);
	/********查询下面的区域，各区门店数量*******/
	$.post("companyMatchAction!queryCountyCountJson.action",{
		"typeName" : typeName,
		"typeValue" : typeValue
		},
		function(data, status) {
			$("#cityTable").html("");
			var row;
			var tab = $("#cityTable").get(0);
			if(data.districtVos.length > 0){
				row = tab.insertRow();
			}
			for(var i = 0 ; i < data.districtVos.length; i ++){
				var vo = data.districtVos[i];
				var districtCode = vo.districtCode;
				if(row.cells.length >= 3){
					row = tab.insertRow();
				}
				var cell = row.insertCell();
				var text = vo.districtName + "("+vo.total+")";
				var innerHTML = "<a href='javascript:loadDept(\"countyCode\",\""+vo.districtCode+"\",\""+districtName+"\",\""+vo.districtName+"\",true)'>"+text+"</a>";
				cell.innerHTML = innerHTML;
			}
		}
	);
	//查询所有门店
	loadDept(typeName,typeValue,districtName);
}

function showCityCountyDiv(){
	//显示城市相关信息，隐藏省份相关信息
	$("#province_div").hide();
	$("#deptList_div").hide();
	$("#screen_div").hide();
	$("#city_div").show();
	$("#district_div").show();
}

function loadDept(typeName,typeValue,districtName,name,sd){
	//是否显示目录
	if(sd){
		$("#district_div").hide();
		showDirectory(typeName,typeValue,name, 3);
	}
	/*********查询部门和分页的*********/
	$.post("companyMatchAction!queryCounty.action",{
		"typeName" : typeName,
		"typeValue" : typeValue
		},
		function(data, status) {
			var row;
			//热门城市隐藏
			$("#hotCity_div").hide();
			$("#deptList_div").show();
			if(data.departmentVos.length > 0){
				//将其保存
				departmentVos = data.departmentVos;
				//将地图放大，并且定位到市区
				myGeo.getPoint(districtName, function(point){
					if (point) {
						var point = new BMap.Point(point.lng, point.lat);
						map.centerAndZoom(point, 10);
					}
				},districtName);
			}
			map.clearOverlays();
		    var tag = 0;
		    //分页查询部门信息
		    pageQuery(1,10);
			for(var i = 0 ; i < data.departmentVos.length; i ++){
				var vo = data.departmentVos[i];
				//只能发货
				if("Y" == vo.isShipment){
					tag = 2;
				}
				if("Y" == vo.isPickUp){
					tag = 3;
				}
				if("Y" == vo.isDelivery){
					tag = 1;
				}
				addDeptMarker(vo,opt_options[tag]);
			}
		}
	);
}

var myGeo = new BMap.Geocoder();
function addMarker(districtCode,address,text,opt_options,zoom,type){
	if(myGeo == null){
		myGeo = new BMap.Geocoder();
	}
	myGeo.getPoint(address, function(point){
		if (point) {
			var point = new BMap.Point(point.lng, point.lat);
			//创建标注
			var marker = new ClusterMarker(point, text, {
				styles : opt_options
			});  
			marker.addEventListener("click",function(){
				if("city" == type){
					//点击加载市区
					loadCity("districtCode",districtCode,address);
				}else if("county" == type){
					//加载区域
					loadCounty("cityCode",districtCode,address);
				}
			});
			map.addOverlay(marker);// 将标注添加到地图中
			if(zoom){
				map.centerAndZoom(point, 7);
			}
		}
	},address);
}

function addDeptMarker(departmentVo,opt_options){
	if(departmentVo.lng != null && departmentVo.lat != null){
		var point = new BMap.Point(departmentVo.lng,departmentVo.lat);
		var text = "&#160;&#160;&#160;&#160;&#160;"+departmentVo.rownumber;
		//创建标注
		var marker = new ClusterMarker(point, text, {
			styles : opt_options
		});
		map.addOverlay(marker);// 将标注添加到地图中
		marker.addEventListener("click",function(e){
			if(departmentVo.lng != null && departmentVo.lat != null){
				var infoWindow = createInfoWindow(departmentVo);  // 创建信息窗口对象 
				map.openInfoWindow(infoWindow,point); //开启信息窗口
			}
		});
	}
}

function createInfoWindow(departmentVo){
	var phone = departmentVo.phone;
	var areaCode = departmentVo.areaCode;
	if(areaCode != null && areaCode != ""){
		areaCode = areaCode + "-";
	}else{
		areaCode = "";
	}
	var p = areaCode + phone;
	var authCode = "";
	if(departmentVo.authCode != null){
		authCode = departmentVo.authCode;
	}
	var franchiseCompanyName = "";
	if(departmentVo.franchiseCompanyName != null){
		franchiseCompanyName = departmentVo.franchiseCompanyName;
	}
	var content = 
		'<p style="font-weight:500">网点代码：<span style="color:#808080;">'+ departmentVo.logistCode +'</span></p>'+
		'<p style="font-weight:500">授权编码：<span style="color:#808080;">'+ authCode +'</span></p>'+
		'<p style="font-weight:500">公司名称：<span style="color:#808080;">'+ franchiseCompanyName +'</span></p>'+
		'<p style="font-weight:500">地址：<span style="color:#808080;">'+
		departmentVo.addressDetail+'</span></p><p style="font-weight:500">电话：<span style="color:#808080;">'+
		p+'</span></p><p style="font-weight:500">业务范围：<span style="color:#808080;">'+
		departmentVo.serviceName+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></p>';
	var opts = {
		title : '<p style="font-weight:900">'+departmentVo.deptName+'</p>', // 信息窗口标题
		enableMessage:true//设置允许信息窗发送短息
    };
	return new BMap.InfoWindow(content,opts);
}

/**
 * 
 * 分页显示部门列表
 * @author 莫涛
 * @date 2015年7月3日
 * @update
 */
function pageQuery(page,pageSize){
	$("#deptList").html("");
	if(departmentVos == null || departmentVos.length == 0){
		return;
	}
	var start = (page - 1) * pageSize;
	var end = page * pageSize;
	if(start >= departmentVos.length){
		return;
	}
	if(end >= departmentVos.length){
		end = departmentVos.length;
	}
	var discription = "第"+(start+1)+"-"+end+"条,共"+departmentVos.length+"条";
	$(".zt_changered").html(discription);
	//上一页
	var $deptPrev = $("#deptPrev");
	//下一页
	var $downPage = $("#downPage");
	//class="current" 
	/*****上一页****/
	$deptPrev.removeAttr("onclick");
	if(start == 0){
		$deptPrev.removeClass("current");
	}else{
		$deptPrev.addClass("current");
		$deptPrev.attr("onclick","pageQuery("+(page-1)+","+pageSize+")");
	}
	/*****下一页*****/
	$downPage.removeAttr("onclick");
	if(end < departmentVos.length){
		$downPage.addClass("current");
		$downPage.attr("onclick","pageQuery("+(page+1)+","+pageSize+")");
	}else{
		$downPage.removeClass("current");
	}
	
	var totalPage = Math.ceil(departmentVos.length / pageSize);
	var thisPage = page+"/"+totalPage;
	$(".thisPage").html(thisPage);
	
	for(var i = start ; i < end ; i ++){
		var vo = departmentVos[i];
		var distance = "";
		if(vo.distance != null){
			//过滤返回公里数为 NaN 的值....肖聪
			distance = vo.distance + "公里";
			if(distance == "NaN公里"){
                distance = 0 + "公里";
            }
		}
		var phone = vo.phone;
		var areaCode = vo.areaCode;
		if(areaCode != null && areaCode != ""){
			areaCode = areaCode + "-";
		}else{
			areaCode = "";
		}
		var p = areaCode + phone;
		var authCode = "";
		if(vo.authCode != null){
			authCode = vo.authCode;
		}
		var franchiseCompanyName = "";
		if(vo.franchiseCompanyName != null){
			franchiseCompanyName = vo.franchiseCompanyName;
		}
		var a = "<a href='javascript:toggleDeptDescript("+i+")' class='zt_letterint'>" + vo.rownumber + " " + vo.deptName + "  <span style='color:#000000'>"+distance+"</span>" + "</a>";
		var ul = "<ul id='dept"+vo.rownumber+"' class='deptAllUlCls' style='display:none'><p>网点代码："+vo.logistCode+"</p><p>授权编码："+authCode+"</p><p>公司名称："+franchiseCompanyName+"</p><li class='zt_letterint'><p>地址："+vo.addressDetail+"</p><p>电话："+p+"</p></li></ul>"
		$("#deptList").append(a).append(ul);
	}
}

function toggleDeptDescript(index){
	var departmentVo = departmentVos[index];
	$(".deptAllUlCls").hide();
	$("#dept"+departmentVo.rownumber).show();
	if(departmentVo.lng != null && departmentVo.lat != null){
		var point = new BMap.Point(departmentVo.lng,departmentVo.lat);
		var infoWindow = createInfoWindow(departmentVo);  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}
}

/**
 * 显示目录，中国 > 省 > 市 > 区
 * @author 莫涛
 * @date 2015年7月3日
 * @update
 */
function showDirectory(typeName,typeValue,districtName,index){
	var name;
	if(typeName.indexOf("Code") > 0){
		name = districtName;
	}else{
		name = typeValue;
	}
	$(".screeningName").html(name);
	switch(index){
		case 1:
			$(".provinceName").html("&gt; "+name);
			$(".provinceName").attr("onclick","loadCity('"+typeName+"','"+typeValue+"','"+districtName+"',true)");
			$(".cityName").html("");
			$(".areaName").html("");
			break;
		case 2:
			$(".cityName").html("&gt; "+name);
			$(".cityName").attr("onclick","loadCounty('"+typeName+"','"+typeValue+"','"+districtName+"')");
			$(".areaName").html("");
			break;
		case 3:
			$(".areaName").html("&gt; "+name);
			break;
	}
}
var timerCalcNum = 0;
var timer;
var timerCityName;
/**定时刷新，判断是否将所有地址距离匹配完毕**/
function timedCount(){
	if(timerCalcNum == 0 || departmentVos.length == 0){
		return;
	}
	if(timerCalcNum == departmentVos.length){
		//根据距离进行排序
		sortData();
		var pointVo = departmentVos[0];
		var $leaved = $("#leavedCityName");
		var $arrived = $("#arrivedCityName");
		var districtNames = $leaved.val().split("-");
		var cityName = districtNames[1];
		myGeo.getPoint($arrived.val(), function(point){
			if (point) {
				var transit = new BMap.DrivingRoute(map, {renderOptions: {map: map}});
				transit.search(point, new BMap.Point(pointVo.lng, pointVo.lat));
			}
		}, cityName);
		
		//分页查询部门信息
	    pageQuery(1,10);
	  //如果没有输入详细地址，则直接标记各个网点信息
	    var tag = 0;
		for(var i = 0 ; i < departmentVos.length; i ++){
			var vo = departmentVos[i];
			//只能发货
			if("Y" == vo.isShipment){
				tag = 2;
			}
			if("Y" == vo.isPickUp){
				tag = 3;
			}
			if("Y" == vo.isDelivery){
				tag = 1;
			}
			addDeptMarker(vo,opt_options[tag]);
			if(vo.provinceCode != null && vo.cityCode != null && vo.countyCode != null){
				provinceCode = vo.provinceCode;
				cityCode = vo.cityCode;
				countyCode = vo.countyCode;
			}
		}
	    clearTimeout(timer);
	}
}
function findDeptDistance(){
	var $leaved = $("#leavedCityName");
	var $arrived = $("#arrivedCityName");
	var $msg_span = $("#msg_span");
	//街道名称
	var arrivedCityName = "";
	var district = $arrived.val() == $arrived.attr("ov");
	var provinceName,cityName,countyName;
	var provinceCode,cityCode,countyCode;
	$msg_span.hide();
	if($leaved.val() == $leaved.attr("ov")){
		$msg_span.show();
		return;
	}
	var districtNames = $leaved.val().split("-");
	provinceName = districtNames[0];
	cityName = districtNames[1];
	if($leaved.val().split("-").length > 2){
		countyName = districtNames[2];
	}
	if(district){
		//显示城市相关信息，隐藏省份相关信息
		$("#province_div").hide();
		$("#deptList_div").show();
		$("#screen_div").hide();
		$("#city_div").show();
		if($leaved.val().split("-").length > 2){
			$("#district_div").hide();
		}else{
			$("#district_div").show();
		}
		$("#hotCity_div").hide();
	}else{
		$("#province_div").hide();
		$("#hotCity_div").hide();
		$("#city_div").hide();
		$("#deptList_div").show();
		$("#screen_div").show();
		$("#keyword_span").html($leaved.val());
		arrivedCityName = $arrived.val();
        //新增地址文本校验 肖聪
        var reg = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
        if(!reg.test(arrivedCityName) && arrivedCityName != ""){
            alert("提示:输入格式有误");
            return;
        }
	}
	
	/*********查询附近部门和分页的********/
	$.post("companyMatchAction!queryDeptByDistrictNameJson.action",{
		"typeValue" : $leaved.val(),
		"arrivedCityName" : arrivedCityName
		},
		function(data, status) {
			var row;
			if(data.departmentVos.length > 0){
				//将其保存
				departmentVos = data.departmentVos;
				if(myGeo == null){
					myGeo = new BMap.Geocoder();
				}
				//将地图放大，并且定位到市区
				myGeo.getPoint(cityName, function(point){
					if (point) {
						var point = new BMap.Point(point.lng, point.lat);
						map.centerAndZoom(point, 10);
					}
				},cityName);
				//如果有填写具体区域，则获取网点与之距离,并且定位最近的一个网点，供其参考
				map.clearOverlays();
				if(!district){
					calcDistance(cityName,$arrived.val());
					timerCalcNum = 0;
					timer = setInterval(timedCount, "500");
				}else{
					pageQuery(1,10);
					//如果没有输入详细地址，则直接标记各个网点信息
				    var tag = 0;
					for(var i = 0 ; i < data.departmentVos.length; i ++){
						var vo = data.departmentVos[i];
						// //只能发货
						// if("Y" == vo.isShipment){
						// 	tag = 2;
						// }
						// if("Y" == vo.isPickUp){
						// 	tag = 3;
						// }
						// if("Y" == vo.isDelivery){
						// 	tag = 1;
						// }

                        if("Y" == vo.isShipment && "Y" == vo.isPickUp && "Y" == vo.isDelivery  ){
                            //发货/提货/送货
                        	tag = 1;
                        }else if("Y" == vo.isShipment && "Y" == vo.isPickUp && "Y" != vo.isDelivery ){
                            //发货自提
                            tag = 3;
						}else if("Y" == vo.isShipment && "Y" != vo.isPickUp && "Y" == vo.isDelivery){
                            //发货送货
                        	tag = 4;
                        }else if("Y" == vo.isShipment && "Y" != vo.isPickUp && "Y" != vo.isDelivery){
                            //只能发货
							tag = 2;
                        }

						addDeptMarker(vo,opt_options[tag]);
						if(vo.provinceCode != null && vo.cityCode != null && vo.countyCode != null){
							provinceCode = vo.provinceCode;
							cityCode = vo.cityCode;
							countyCode = vo.countyCode;
						}
					}
				}
			}else{
				return;
			}
			
			showDirectory("districtCode",provinceCode,provinceName, 1);
			showDirectory("cityCode",cityCode,cityName, 2);
			if($leaved.val().split("-").length > 2){
				showDirectory("countyCode",countyCode,countyName, 3);
			}else{
				/********查询下面的区域，各区门店数量*******/
				$.post("companyMatchAction!queryCountyCountJson.action",{
					"typeName" : "cityCode",
					"typeValue" : cityCode
					},
					function(data, status) {
						$("#cityTable").html("");
						var row;
						var tab = $("#cityTable").get(0);
						if(data.districtVos.length > 0){
							row = tab.insertRow();
						}
						for(var i = 0 ; i < data.districtVos.length; i ++){
							var vo = data.districtVos[i];
							var districtCode = vo.districtCode;
							if(row.cells.length >= 3){
								row = tab.insertRow();
							}
							var cell = row.insertCell();
							var text = vo.districtName + "("+vo.total+")";
							var innerHTML = "<a href='javascript:loadDept(\"countyCode\",\""+vo.districtCode+"\",\""+cityName+"\",\""+vo.districtName+"\",true)'>"+text+"</a>";
							cell.innerHTML = innerHTML;
						}
					}
				);
			}
		}
	);
}

function calcDistance(cityName,address){
	if(departmentVos == null || departmentVos.length == 0){
		return;
	}
	myGeo.getPoint(address, function(point){
		if (point) {
			$("#address_span").html(address);
			for(var i = 0 ; i < departmentVos.length ; i ++){
				var vo = departmentVos[i];
				calcDis(point,vo);
			}
		}else{
			$("#address_span").html("地址解析错误，请确认地址是否正确!");
			//分页查询部门信息
		    pageQuery(1,10);
		}
	}, cityName);
}

function calcDis(point,vo){
	var searchComplete = function (results){
		timerCalcNum ++;
		if (transit.getStatus() != BMAP_STATUS_SUCCESS){
			return ;
		}
		var plan = results.getPlan(0);
		vo.distance = plan.getDistance(true);	//获取距离
		vo.distance = vo.distance.replace("公里","");
	}
	var transit = new BMap.DrivingRoute(map, {renderOptions: {map: null},
		onSearchComplete: searchComplete});
	transit.search(point, new BMap.Point(vo.lng, vo.lat));
}

function sortData(){
	//先处理异常数据。。。
	for(var i = 0 ; i < departmentVos.length ; i ++){
		if(departmentVos[i].distance == null){
    		departmentVos[i].distance = 0;
    	}else{
    		departmentVos[i].distance = departmentVos[i].distance * 1;
    	}
	}
	var size = departmentVos.length, temp;
	/**选择排序**/
    for (var i = 0; i < size; i++) {
        var k = i;   
        for (var j = size - 1; j >i; j--)  {
            if (departmentVos[j].distance < departmentVos[k].distance)  k = j;   
        }   
        temp = departmentVos[i];
        departmentVos[i] = departmentVos[k];   
        departmentVos[k] = temp;
    }
    
    for(var i = 0;i<departmentVos.length;i++){
    	var vo = departmentVos[i];
    	vo.rownumber = i + 1;
    }
}