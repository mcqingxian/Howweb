function validate_form(form) {
	var rtn = validate_required(form.pro_city_cty, "位置信息不能为空");
	if (rtn == false) {
		pro_city_cty.focus();
		return false;
	}
}

function validate_required(field, msg) {
	if (field.value == null || field.value == "") {
		alert(msg);
		return false;
	} else {
		return true;
	}
}

var provinceSelected = "";
var provinceNameSelected = "";
$(document).ready(
		function(e) {
			/*
			 * $("form").submit(function(e){ //e.preventDefault(); var s =
			 * $("#pro_city_cty").val(); if(s.length ==0 ){ return false; }else{
			 * return true; } });
			 */

			/*
			 * 获取当前位置 省市区
			 * 
			 */
			var province = null;
			var city = null;
			var district = null;
			var lon = null;
			var lat =null;
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					lat = position.coords.latitude;
					lon = position.coords.longitude;
					var myGeo = new BMap.Geocoder();
					// 根据坐标得到地址描述
					var curPoint = new BMap.Point(lon, lat);
					myGeo.getLocation(curPoint, function(result) {
						if (result) {
							province = result.addressComponents.province;
							city = result.addressComponents.city;
							district = result.addressComponents.district;
						}
					});
				});
			} else {
				alert("Geolocation is not supported by this browser.");
			}
			//是否点击过获取位置
			var status = 0;
			// 向表单省市区设置值
			$("#getPosition").click(
				function() {
					if (province != null && city != null
							&& district != null) {
						status = 1;
						$("#pro_city_cty").val(
								province + " " + city + " " + district);
					}
				}
			);

			$("#departmentQueryBtn").click(
					function() {
						var pcc = $("#pro_city_cty").val();
						if (pcc == undefined) {
							alert("所在地区不能为空");
						}
						// 查询。。
						// 1）输入是否为空
						// 2）地址反向编码
						var city = pcc.split(" ")[1];
						var myGeo = new BMap.Geocoder();
						// 将地址解析结果显示在地图上，并调整地图视野
						myGeo.getPoint(pcc, function(point) {
							var url = window.location.href.substring(0,
									window.location.href.lastIndexOf("/") + 1)
									+ "companyMatchAction!queryDeptByDistrictName.action?pro_city_cty="
									+ pcc+"&lon="+point.lng+"&lat="+point.lat+"&llat="+lat+"&llon="+lon+"&status="+status;
							window.location.href = url;

						}, city);
						// 3）发送请求

					});

			// 校验手机号码：必须以数字开头，除数字外，可含有“-”
			function isMobile(s) {
				var reg = /^(13[0-9]|15[0-9]|15[0-9]|18[0-8])[0-9]{8}$/;
				var check = false;
				if (reg.test(s.trim()))
					check = true;
				return check;
			}

			function checkLength(valiCode, length) {
				var len = valiCode.trim().length;
				if (len > length) {
					return false;
				}
				return true;
			}

			$("#pro_city_cty").click(
					function() {
						queryProvince("depart_province_query",
								"depart_provinces", "depart_city_query",
								"depart_citys", "department_query",
								"pro_city_cty", "depart_county_query",
								"depart_countys");
					});
			$("#depart_province_back").click(function() {
				$.mobile.changePage("#department_query", {
					transition : "none",
					changeHash : false
				});
			});
			$("#depart_city_back").click(
					function() {
						queryProvince("depart_province_query",
								"depart_provinces", "depart_city_query",
								"depart_citys", "department_query",
								"pro_city_cty", "depart_county_query",
								"depart_countys");
					});
			// 出发区域返回按钮添加事件
			$("#depart_county_back").click(
					function() {
						queryCity(provinceSelected,provinceNameSelected, "depart_city_query",
								"depart_citys", "department_query",
								"pro_city_cty", "depart_county_query",
								"depart_countys", "departEndpointID");
					});

		});

// 查询省
function queryProvince(provincePage, provinces, cityPage, citys, finishPage,
		finalCity, countyPage, countys) {
	showLoader();
	$("#" + provinces).empty();
	$.ajax({
		url : "queryProvinceInfo.action",
		async : true,
		type : "POST",
		dataType : "json",
		success : function(result) {
			hideLoader();
			var data = result.provinces;
			$("#" + provinces).empty();
			$.mobile.changePage("#" + provincePage, {
				transition : "none",
				changeHash : false
			});
			
			$.each(data, function(i, value) {
				$("#" + provinces).append("<li p="+value+">" + value + "</li>");
				$("#" + provinces).listview('refresh');
			});
			// 添加点击大区监听事件：跳转至城市界面
			$("#" + provinces + " li").click(
					function() {
						//var province = $(this).html();
						/**
						 * 2015-10-26 修改获取省份为编码
						 */
						var province = $(this).attr("p");
						var provinceName = $(this).html();
						provinceSelected = province;
						provinceNameSelected = provinceName;
						queryCity(province,provinceName, cityPage, citys, finishPage,
								finalCity, countyPage, countys);
					});

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			hideLoader();
			errorDialog();
		}
	});

}
// 查询城市
function queryCity(province,provinceName, cityPage, citys, finishPage, finalCity,
		countyPage, countys) {
	showLoader();
	$("#" + citys).empty();
	$.ajax({
		url : "queryCityInfo.action",
		type : "POST",
		async : true,
		data : {
			province : province
		},
		dataType : "json",
		success : function(result) {
			hideLoader();
			var data = result.citys;
			$("#" + citys).empty();
			$.mobile.changePage("#" + cityPage, {
				transition : "none",
				changeHash : false
			});
			$.each(data, function(i, value) {
				$("#" + citys).append("<li p="+value+">" + value + "</li>");
				$("#" + citys).listview('refresh');
			});
			$("#" + citys + " li").click(
					function() {
//						var city = $(this).html();
						/**
						 * 2015-10-26 修改获取城市为编码
						 */
						var city = $(this).attr("p");
						var cityName = $(this).html();
						queryCounty(provinceName, cityPage, citys, city,cityName,
								finishPage, finalCity, countyPage, countys);
					});
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			hideLoader();
			errorDialog();
		}
	});

}
// 查询区县
function queryCounty(provinceName, cityPage, citys, city,cityName, finishPage, finalCity,
		countyPage, countys) {
	showLoader();
	$("#" + countys).empty();
	$.ajax({
		url : "queryCountyInfoByProvinceCity.action",
		type : "POST",
		async : true,
		data : {
			province : provinceName,
			city : city
		},
		dataType : "json",
		success : function(result) {
			hideLoader();
			var data = result.countys;
			$("#" + countys).empty();
			$.mobile.changePage("#" + countyPage, {
				transition : "none",
				changeHash : false
			});
			$.each(data, function(i, value) {
				$("#" + countys).append("<li>" + value + "</li>");
				$("#" + countys).listview('refresh');
			});
			$("#" + countys + " li").click(
					function() {
						$.mobile.changePage("#" + finishPage, {
							transition : "none",
							changeHash : false
						});
						$("#" + finalCity).val(
								provinceName + " " + cityName + " " + $(this).html());
					});

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			hideLoader();
			errorDialog();
		}
	});

}
function errorDialog() {
	// $.mobile.changePage('#err_dialog', 'flip', true, true);
	/* alert("error"); */
}

function showLoader() {
	// 显示加载器.for jQuery Mobile 1.2.0
	/*
	 * $.mobile.loading('show', { text: '加载中...', //加载器中显示的文字 textVisible: true,
	 * //是否显示文字 textonly: false, //是否只显示文字 html: "" //要显示的html内容，如图片等 });
	 */
}

// 隐藏加载器.for jQuery Mobile 1.2.0
function hideLoader() {
	// 隐藏加载器
	// $.mobile.loading('hide');
}

function checkParams(msg) {
	$("#dialg_header").html();
	$("#order_dialog_con").empty();
	$("#order_dialog_con").append("<h>" + msg + "</h>");
	$.mobile.changePage('#order_dialog', 'flip', true, true);
}
