//所有省市
var allProvinces = null;
//所有城市
var allCities = null;
//所有区县
var allCounties = null;

var currProvinceId = null;//当前省市id
var currCityId = null;//当前城市id
var currCountyId = null;//当前区县id

//省市下城市
var allCitys = null;
var countiesAll = null;

/**
 * 查询所有省市
 */
function sendAllProvinceAjax() {
	$.ajax({
		type: "get",
		url: "queryProvincesFormMDM.action",
//		url: '/how-web/scripts/bse/queryProvinces.js',
		async: false,
		dataType: "json",
		success: function(data) {
			allProvinces = data.areas;
			$("body").data("allProvinces", allProvinces);
			viewAllProvince();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown)
		 {
			alert("对不起，系统繁忙,请稍后操作！");
		}
	});
}
/**
 * 查询所有城市
 */
function sendAllCitiesAjax() {
	$.ajax({
		type: "get",
		url: "queryCitysFormMDM.action",
//		url: '/how-web/scripts/bse/queryCitys.js',
		async: false,
		dataType: "json",
		success: function(data) {
			allCities = data.areas;
			$("body").data("allCities", allCities);
			viewAllHotCities();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown)
		 {
			alert("对不起，系统繁忙,请稍后操作！");
		}
	});
}
/**
 * 查询区县
 */
function sendAllCountiesAjax(){
	$.ajax({
		type: "get",
		url: "queryCountycesFormMDM.action",
//		url: "/how-web/scripts/bse/queryCountsyces.js",
		async: false,
		dataType: "json",
		success: function(data) {
			allCounties = data.areas;
			$("body").data("allCounties", allCounties);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown)
		 {
			alert("对不起，系统繁忙,请稍后操作！");
		}
	});
}
/**
 * 显示省市
 */
function viewAllProvince() {
	$(".provinceAll .list ul li").remove();
	var start = 0;
	var end = allProvinces.length;
	for (var i = start; i < end; i++) {
		var p_id = allProvinces[i].districtCode;
		var p_name = allProvinces[i].districtName;
		if (allProvinces[i].districtName == '内蒙古自治区') {
			p_name = '内蒙古';
		} else if (allProvinces[i].districtName == '黑龙江省') {
			p_name = '黑龙江';
		} else {
			p_name = allProvinces[i].districtName.substr(0, 2);
		}
		var li = $('<li><a style="background: none repeat scroll 0% 0% transparent; border: 0px none;" href="javascript:onclick=viewAllCities(' + i + ');" id="' + p_id + '">' + p_name + '</a></li>');
		$(".provinceAll .list ul").append(li);
	}
}
/**
 * 单击省市
 * @param i
 */
function viewAllCities(i) {
	currProvinceId = allProvinces[i].districtCode;
	$("body").data("currProvinceName", allProvinces[i].districtName);
	$("body").data("currProvinceId", currProvinceId);
	allCitys = [];
	var j = 0;
	$.each(allCities,
	function(i, city) {
		if (city.parentDistrictCode == currProvinceId) {
			allCitys[j++] = city;
		}
	});
	$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
	$(".provinceCityAll .tabs").find("#cityAll").addClass("current");
	$(".con .provinceAll .list a").removeClass("current");
	$(".con .provinceAll .list a[id='" + currProvinceId + "']").addClass("current");
	$(".provinceCityAll").find(".con").children().hide();
	$(".provinceCityAll").find(".con").find(".cityAll").show();
	//显示城市
	$(".cityAll .list ul li").empty();
	$(".cityAll .list ul li").remove();
	var start = 0;
	var end = allCitys.length;
	for (var i = start; i < end; i++) {
		var c_id = allCitys[i].districtCode;
		var cityName = allCitys[i].districtName.substr(0, 4);
		var li = $('<li><a href="javascript:onclick=viewAllCounties(' + i + ')" id="' + c_id + '">' + cityName + '</a></li>');
		$(".cityAll .list ul").append(li);
	}
}
/**
 * 单击城市
 * @param i
 */
function viewAllCounties(i) {
	currCityId = allCitys[i].districtCode;
	$("body").data("currCityId", currCityId);
	var cityname = $.trim(allCitys[i].districtName);
	$("body").data("currCityName", cityname);
	countiesAll = [];
	var j = 0;
	$.each(allCounties,
	function(i, countys) {
		if (countys.parentDistrictCode == currCityId) {
			countiesAll[j++] = countys;
		}
	});
	$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
	$(".provinceCityAll .tabs").find("#countyAll").addClass("current");
	$(".con .cityAll .list a").removeClass("current");
	$(".con .cityAll .list a[id='" + currCityId + "']").addClass("current");
	$(".provinceCityAll").find(".con").children().hide();
	$(".provinceCityAll").find(".con").find(".countyAll").show();
	//显示省市-城市
	var currProvinceName = $("body").data("currProvinceName");
	var currCityName = $("body").data("currCityName");

	var mold = $("input.current2").attr("mold");
	//只有省市 带有**属性
	if(mold !=null && mold=="mold"){
		$("input.current2").removeClass("grays");
		$("input.current2").val(currProvinceName + "-" + currCityName);
	}
	var inputValue = $("input.current2").val();
	if(inputValue != null && inputValue != '' && inputValue != $("input.current2").attr("ov")){
		$("input.current2").change();
	}
	$(".countyAll .list ul li").remove();
	var start = 0;
	var end = countiesAll.length;
	for (var i = start; i < end; i++) {
		var c_id = countiesAll[i].districtCode;
		var countyName = countiesAll[i].districtName.substr(0, 4);
		var li = $('<li><a href="javascript:onclick=addrInputAll(' + i + ')" id="' + c_id + '">' + countyName + '</a></li>');
		$(".countyAll .list ul").append(li);
	}
}

/**
 * 显示热点城市
 */
function viewAllHotCities() {
	$(".hotCityAll .list ul li").remove();
	$.each(allCities,
	function(i, city) {
		if (city.hotCity) {
			$(".hotCityAll .list ul").append("<li><a><input type='button' style='background:none;border:0px;cursor: pointer;' onclick=hotCityAddrInputAll(\'" + city.parentDistrictCode + "," + city.districtCode + "," + city.districtName + "\') id='" + city.districtCode + "' value='" + city.districtName + "'></a></li>");
		}
	});
}
/**
 * 单击热点城市
 * @param proCityId
 */
function hotCityAddrInputAll(proCityId) {
	currProvinceId = proCityId.split(",")[0];//当前城市 省市id
	currCityId = proCityId.split(",")[1]; //当前城市id
	var currCityName = proCityId.split(",")[2];//当前城市名字
	$("body").data("currCityName", currCityName);
	$("body").data("currProvinceId", currProvinceId);
	$("body").data("currCityId", currCityId);
	//获取省市
	$.each(allProvinces,
	function(i, pro) {
		if (pro.districtCode == currProvinceId) {
			$("body").data("currProvinceName", pro.districtName);
		}
	});
	countiesAll = [];
	var j = 0;
	//获取区县
	$.each(allCounties,
	function(i, county) {
		if (county.parentDistrictCode == currCityId) {
			countiesAll[j++] = county;
		}
	});
	$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
	$(".provinceCityAll .tabs").find("#countyAll").addClass("current");
	$(".con .cityAll .list a").removeClass("current");
	$(".con .cityAll .list a[id='" + currCityId + "']").addClass("current");
	$(".provinceCityAll").find(".con").children().hide();
	$(".provinceCityAll").find(".con").find(".countyAll").show();
	$(".con .provinceAll .list a").removeClass("current");
	//显示省市和城市 到输入框
	var currProvinceName = $("body").data("currProvinceName"); 
	
	//判断省市区
	var mold = $("input.current2").attr("mold");
	//只有省市 带有**属性
	if(mold !=null && mold=="mold"){
		$("input.current2").removeClass("grays");
		$("input.current2").val(currProvinceName + "-" + currCityName);
	}
	var inputValue = $("input.current2").val();
	if(inputValue != null && inputValue != '' && inputValue != $("input.current2").attr("ov")){
		$("input.current2").change();
	}
	
	$(".countyAll .list ul li").remove();
	//显示区县到tab
	var start = 0;
	end = countiesAll.length;
	for (var i = start; i < end; i++) {
		var c_id = countiesAll[i].districtCode;
		var countyName = countiesAll[i].districtName.substr(0, 4);
		var li = $('<li><a href="javascript:onclick=addrInputAll(' + i + ')" id="' + c_id + '">' + countyName + '</a></li>');
		$(".countyAll .list ul").append(li);
	}
}
/**
 * 单击区县
 */
function addrInputAll(i) {
	//显示城市
	$(".countyAll .list ul li").empty();
	$(".countyAll .list ul li").remove();
	var countyId = $.trim(countiesAll[i].districtCode);
	$(".con .hotCityAll .list a input").removeClass("current");
	$(".con .hotCityAll .list a input[id='" + currCityId + "']").addClass("current");
	$(".con .countyAll .list a").removeClass("current");
	$(".con .countyAll .list a[id='" + countyId + "']").addClass("current");
	currProvinceId = $("body").data("currProvinceId");
	currCityId = $("body").data("currCityId");
	var p = null;
	$.each(allProvinces,
	function(i, province) {
		if (province.districtCode == currProvinceId) {
			p = province.districtName;
			return false;
		}
	});
	var c = null;
	$.each(allCities,
	function(i, city) {
		if (city.districtCode == currCityId) {
			c = city.districtName;
			return false;
		}
	});
	var a = null;
	$.each(countiesAll,
	function(i, county) {
		if (county.districtCode == countyId) {
			a = county.districtName;
			return false;
		}
	});
	var nameValue = $("input.current2");
	nameValue.removeClass("grays");
	$(".provinceCityAll").hide();
	var rtn = p + "-" + c + "-" + a;
	$("input.current2").val(rtn);
	var inputValue = $("input.current2").val();
	if(inputValue != null && inputValue != '' && inputValue != $("input.current2").attr("ov")){
		$("input.current2").change();
	}
}