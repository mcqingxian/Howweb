var initCityValue;

$(document).ready(function(){
	initCityControl();
});

function initCityControl(){
	// 公用focus blur 效果 (请在需要的控件上 加上 inputFocus 类， 并添加ov="原始的value"即可)
	$(function() {
		$.each($(".inputFocus"), function(index, input) {
			if ($(input).val() == $(input).attr("ov")) {
				$(input).addClass("grays");
			}
		});
	});
	$(".inputFocus").live("focus", function() {
		var ov = $.trim($(this).attr("ov"));
		var val = $.trim($(this).val());
		$(this).removeClass("grays");
		if (val == ov) {
			$(this).val("");
		}
	});
	$(".inputFocus").live("blur", function() {
		var ov = $.trim($(this).attr("ov"));
		var val = $.trim($(this).val());
		if (val == "") {
			$(this).val(ov).addClass("grays");
		}
	});
	
	$("html").click(function() {
		var reg1 = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
		var reg2 = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
		//获取输入框
		var cityValue = $("input.current2").val();
		var mold = $("input.current2").attr("mold");
		var initValue = $("input.current2").attr("ov");
		//只有省市 带有**属性
		if(cityValue != null && reg2.test(cityValue) && mold=="mold"){
			$(".provinceCityAll").hide();
		}else if(cityValue == null || cityValue == "" || cityValue==initValue){
			$(".provinceCityAll").hide();
		}else if(cityValue != null && reg1.test(cityValue)){
			$(".provinceCityAll").hide();
		}
	});
	
	/**
	 * 城市控件入口
	 */
	$(".proCitySelAll").click(function(event) {
		//获取城市数据
		if ($("body").data("allCities") == null) {
			sendAllCitiesAjax();
		}
		$(this).select();
		var mold = $("input.current2").attr("mold");
		if(mold=="mold"){
			$(this).val(null);
		}
		$(".provinceCityAll").hide();
		$("#dimCityQuery").hide();
		
		var o2 = $(this).offset();
		var l2 = o2.left;
		var t2 = o2.top;
		var h2 = $(this).height();
		$(".provinceCityAll").css("top", t2 + h2 - 1).css("left", l2).toggle();
		$(".provinceCityAll").click(function(event) {
			event.stopPropagation();
		});
		event.stopPropagation();
//		$("html").click(function() {
//			$(".provinceCityAll").hide();
//		});
		$("input.proCitySelAll").removeClass("current2");
		$(this).addClass("current2");
		$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
		$(".provinceCityAll").find(".tabs").find("a[tb=hotCityAll]").addClass("current");
		$(".provinceCityAll").find(".con").children().hide();
		$(".provinceCityAll").find(".con").find(".hotCityAll").show();
		//获取省市数据
		if ($("body").data("allProvinces") == null) {
			sendAllProvinceAjax();
		}
		//获取区县数据
		if ($("body").data("allCounties") == null) {
			sendAllCountiesAjax();
		}
		$(".provinceCityAll").find(".tabs").find("a").click(function() {
			//没有选择省市之前切换不到城市和区县
			if ($(this).attr("tb") == "cityAll" && $(".provinceAll .list .current").val() == null) {
				return;
			};
			if ($(this).attr("tb") == "countyAll" && $(".cityAll .list .current").val() == null && $(".hotCityAll .list .current").val() == null) {
				return;
			};
			$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
			$(this).addClass("current");
			var tb = $(this).attr("tb");
			$(".provinceCityAll").find(".con").children().hide();
			$(".provinceCityAll").find(".con").find("." + tb).show();
		});
	});
}

function initCityControl2(){
	var dimCityDiv = "<div id='dimCityQuery' style='white-space:nowrap;z-index:100'><ul></ul></div>";
	$("body").append(dimCityDiv);
	$("body").delegate(".proCityQuery,.proCityQueryAll", ($.browser.opera ? "keypress": "keyup"),
	function(event) {
		
		$(".provinceCityAll").hide();
		if ($(this).hasClass("proCityQueryAll")){
			if ($("body").data("allProvinces") == null) {
				sendAllProvinceAjax();
			}
			if ($("body").data("allCities") == null) {
				sendAllCitiesAjax();
			}
			if ($("body").data("allCounties") == null) {
				sendAllCountiesAjax();
			}
			currentClass = "proCityQueryAll";
			clkIndex = $("body").find(".proCityQueryAll").index(this);//?
			cities = $("body").data("allCities");
			provinces = $("body").data("allProvinces");
			counties = $("body").data("allCounties");
			thisObj = $(this);
		}
		//获取键盘值
		var lastKeyPressCode = event.keyCode;
		switch (lastKeyPressCode) {
		case 40://方向键下
			$("#dimCityQuery").trigger("selNext");
			return false;
			break;
		case 38: //方向键上
			$("#dimCityQuery").trigger("selPrev");
			return false;
			break;
		case 13://确定键
			$("#dimCityQuery").trigger("enter");
			return false;
			break;
		}
		var v = $.trim($(this).val());
		if (v == "" || v == null) {
			return false;
		}
		//
		$(".provinceCity").hide();
		var o = $(this).offset();
		var l = o.left;
		var t = o.top;
		var w = $(this).width();
		var h = $(this).height();
		var htmlArr = [];
		var autoWidth = 0;
		//模糊匹配区县
		for (var i = 0; i < counties.length; i++) {
			if (v === counties[i].districtName.substring(0, v.length)) {
				var c = findCity(counties[i].parentDistrictCode);
				var p = findProvince(c.parentDistrictCode);
				htmlArr[htmlArr.length] = "<li><a class='allcityClass' href='javascript:'provinceId=" 
					+ p.districtCode + " cityId=" + c.districtCode + " countyId=" 
					+ counties[i].districtCode + ">" + c.districtName + "-" + counties[i].districtName 
					+ " (<span style='color:red'>" + counties[i].pinyin + "</span>"
					//+ " (<span style='color:red'>" + v + "</span>" 
					//+ counties[i].districtName.substring(v.length, counties[i].districtName.length) 
					+ ")</a></li>";
				
				if (htmlArr.length > 9) {
					break;
					return false;
				}
				autoWidth = autoWidth < (c.districtName + counties[i].districtName).length ? (c.districtName + counties[i].districtName).length : autoWidth;
				continue;
			};
			if (v.toLowerCase() === counties[i].pinyin.substring(0, v.length)) {
				var c = findCity(counties[i].parentDistrictCode);
				var p = findProvince(c.parentDistrictCode);
				htmlArr[htmlArr.length] = "<li><a class='allcityClass' href='javascript:' provinceId=" 
					+ p.districtCode + " cityId=" + c.districtCode + " countyId=" 
					+ counties[i].districtCode + ">" + c.districtName + "-" + "<span style='color:red'>" 
					+ v + "</span>" + counties[i].districtName.substring(v.length, counties[i].districtName.length) 
					+ " (" + counties[i].pinyin + ")</a></li>";
				if (htmlArr.length > 9) {
					break;
					return false;
				}
				autoWidth = autoWidth < (c.districtName + counties[i].districtName + counties[i].pinyin).length ? (c.districtName + counties[i].districtName + counties[i].pinyin).length : autoWidth;
				continue;
			};
		}
		for (i = 0; i < cities.length; i++) {
			if (v === cities[i].districtName.substring(0, v.length)) {
				var p = findProvince(cities[i].parentDistrictCode);
				htmlArr[htmlArr.length] = "<li><a class='allcityClass' href='javascript:'provinceId=" 
					+ p.districtCode + " cityId=" + cities[i].districtCode + ">" + p.districtName + "-" + cities[i].districtName + " (<span style='color:red'>" 
					+ cities[i].pinyin + "</span>" 
					//+ cities[i].districtName.substring(v.length, cities[i].districtName.length) 
					+ ")</a></li>";
				
				if (htmlArr.length > 9) {
					break;
					return false;
				}
				autoWidth = autoWidth < (p.districtName + cities[i].districtName + cities[i].districtName).length ? (p.districtName + cities[i].districtName + cities[i].districtName).length : autoWidth;
				continue;
			};
			if (v.toLowerCase() === cities[i].pinyin.substring(0, v.length)) {
				var p = findProvince(cities[i].parentDistrictCode);
				htmlArr[htmlArr.length] = "<li><a class='allcityClass' href='javascript:' provinceId=" 
					+ p.districtCode + " cityId=" + cities[i].districtCode + ">" + p.districtName + "-" + cities[i].districtName + "<span style='color:red'>" 
					+ v + "</span>" + cities[i].districtName.substring(v.length, cities[i].districtName.length) 
					+ " (" + cities[i].pinyin + ")</a></li>";
				if (htmlArr.length > 9) {
					break;
					return false;
				}
				autoWidth = autoWidth < (p.districtName + cities[i].districtName + cities[i].pinyin).length ? (p.districtName + cities[i].districtName + cities[i].pinyin).length : autoWidth;
				continue;
			};
		};
		if (htmlArr == "" || htmlArr == null) {
			$("#dimCityQuery ul").html("<li class='none'>对不起,没有找到该城市</li>");
			return false;
		} else {
			$("#dimCityQuery ul").html(htmlArr.join("")).find("li:first").addClass("current");
		};
		if (autoWidth < 15) {
			autoWidth = 200;
		}else if(autoWidth < 20){
			autoWidth = 300;
		}else if(autoWidth < 24){
			autoWidth = 320;
		}else{
			autoWidth = 375;
		}
		$("#dimCityQuery").css("width", autoWidth).css("top", t + h - 1).css("left", l).show();
		$(".backifname").show();
		$("html").click(function() {
			$("#dimCityQuery").hide();
			$(".backifname").hide();
		});
	});
	$("body").delegate("#dimCityQuery li", "hover",
	function() {
		$(this).addClass("current").siblings().removeClass("current");
	},
	function() {
		$(this).removeClass("current");
	});
	$("#dimCityQuery").delegate("", "selNext",
	function() {
		var next = $(this).find("li.current").next();
		if (next.size() > 0) {
			next.addClass("current").siblings().removeClass("current");
		}
		 else {
			$("#dimCityQuery li").removeClass("current").first().addClass("current");
		};
	});
	$("#dimCityQuery").delegate("", "selPrev",
	function() {
		var prev = $(this).find("li.current").prev();
		if (prev.size() > 0) {
			prev.addClass("current").siblings().removeClass("current");
		}
		 else {
			$("#dimCityQuery li").removeClass("current").last().addClass("current");
		};
	});
	$("#dimCityQuery").delegate("", "enter",
	function(event) {
		var cur = $(this).find("li.current");
		if (cur.size() > 0) {
			cur.find("a").trigger("click");
		};
	});
	$("body").delegate("#dimCityQuery li a.allcityClass", "click",
	function() {
		var vm = $(this).text();
		var provinceId = $(this).attr("provinceId");
		var cityId = $(this).attr("cityId");
		var countyId = $(this).attr("countyId");
		var provinceName = null;
		var cityName = null;
		var countyName = null;
		var rtn;
		for (var i = 0; i < provinces.length; i++) {
			if (provinces[i].districtCode == provinceId) {
				provinceName = provinces[i].districtName;
				break;
			};
		}
		for (i = 0; i < cities.length; i++) {
			if (cities[i].districtCode == cityId) {
				cityName = cities[i].districtName;
				break;
			}
		}
		//缓存 当前省市区id
		if (currentClass == "proCityQueryAll") {
			$("body").data("currProvinceId", provinceId);
			$("body").data("currCityId", cityId);
			$("body").data("currCountyId", countyId);
			$("body").data("currProvinceName", provinceName);
			$("body").data("currCityName", cityName);
		}
		
		vm = vm.split("(");
		//取出输入框的值
		countyName = $.trim(vm[0]);
		if (countyId == null || countyName == cityName){
			if (currentClass == "proCityQueryAll"){
				thisObj.trigger("click");
				countiesAll = [];
				var j = 0;
				$.each(allCounties,
				function(i, county) {
					if (county.parentDistrictCode == cityId) {
						countiesAll[j++] = county;
					}
				});
				$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
				$(".provinceCityAll .tabs").find("#countyAll").addClass("current");
				$(".con .cityAll .list a").removeClass("current");
				$(".provinceCityAll").find(".con").children().hide();
				$(".provinceCityAll").find(".con").find(".countyAll").show();
				$(".con .provinceAll .list a").removeClass("current");
				//显示区县到tab
				var start = 0;
				end = countiesAll.length;
				$(".countyAll .list ul li").empty();
				$(".countyAll .list ul li").remove();
				for (var i = start; i < end; i++) {
					var c_id = countiesAll[i].districtCode;
					var countyname = countiesAll[i].districtName.substr(0, 4);
					var li = $('<li><a href="javascript:onclick=addrInputAll(' + i + ')" id="' + c_id + '">' + countyname + '</a></li>');
					$(".countyAll .list ul").append(li);
				}
			}
		}else{
			rtn = provinceName + "-" + countyName;
			if (currentClass == "proCityQueryAll"){
				$("body").find(".proCityQueryAll").eq(clkIndex).val(rtn);
				$("body").find(".proCityQueryAll").eq(clkIndex).trigger("change");
				$(".provinceCityAll").find(".tabs").find("a").removeClass("current");
				$(".provinceCityAll").find(".tabs").find("a[tb=hotCityAll]").addClass("current");
				$(".provinceCityAll .con .list a").removeClass("current");
				$(".provinceCityAll .con .list a input").removeClass("current");
			}
		}
		$("#dimCityQuery").hide();
		return false;
	});
}

var clkIndex = null;
var currentClass = null;
var cities = null;
var provinces = null;
var counties = null;
var thisObj = null;

//输入匹配
$(document).ready(function(){
	initCityControl2();
});

function findProvince(cityParentCode) {
	var province = null;
	$.each(allProvinces, function(i, pro) {
		if (pro.districtCode == cityParentCode) {
			province = pro;
			return false;
		}
	});
	return province;
}

function findCity(countyParentCode) {
	var city = null;
	$.each(allCities, function(i, ci) {
		if (ci.districtCode == countyParentCode) {
			city = ci;
			return false;
		}
	});
	return city;
}

function addFavorite() 
{ 
	var sURL="http://www.hoau.net";
	var sTitle="天地华宇官方网站";
    try{ 
        window.external.addFavorite(sURL, sTitle); 
    }catch(e){ 
        try{
            window.sidebar.addPanel(sTitle, sURL, ""); 
        }catch(e){
            alert("加入收藏失败，请使用Ctrl+D进行添加"); 
        } 
    } 
}
//重写鼠标滚轮事件阻止滚动条冒泡
(function($){
    $.fn.preventScroll = function(){
        var _this = this.get(0);
        if($.browser.mozilla){
            _this.addEventListener('DOMMouseScroll',function(e){
                _this.scrollTop += e.detail > 0 ? 60 : -60;  
                e.preventDefault();
            },false);
        }else{
            _this.onmousewheel = function(e){  
                e = e || window.event;  
                _this.scrollTop += e.wheelDelta > 0 ? -60 : 60;  
                e.returnValue = false 
            };
        }
        return this;
    };
})(jQuery);

function isBlank(str){
	if($.trim(str) == "" || str == null) return true;
	return false;
}