var provinceSelected = "";
$(document).ready(
		function() {
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
			// 向表单省市区设置值
			$("#getDepartCity").click(
				function() {
					if (province != null && city != null
							&& district != null) {
						status = 1;
						$("#priceDepartCity").val(
								province + " " + city + " " + district);
						$("#priceDepartEndpointID").val(district);
						$("#citypriceDepartEndpointID").val(city);
					}
				}
			);
			// 向表单省市区设置值
			$("#getDestCity").click(
				function() {
					if (province != null && city != null
							&& district != null) {
						status = 1;
						$("#priceDestCity").val(
								province + " " + city + " " + district);
						$("#priceDestEndpointID").val(district);
						$("#citypriceDestEndpointID").val(city);
					}
				}
			);
			
			// 添加监听时间
			$("#price_time_li").click(function() {
				$.mobile.changePage("#price_time_query", {
					transition : "none",
					changeHash : false
				});
			});
			$("#price_cal_li").click(function() {
				$.mobile.changePage("#price_cal_query", {
					transition : "none",
					changeHash : false
				});
			});

			$("#price_time_li_").click(function() {
				$.mobile.changePage("#price_time_query", {
					transition : "none",
					changeHash : false
				});
			});
			$("#price_cal_li_").click(function() {
				$.mobile.changePage("#price_cal_query", {
					transition : "none",
					changeHash : false
				});
			});
			// -----------------------------添加时效查询监听开始----------------------------
			// 起始地添加获取焦点监听事件
			$("#departCity").click(
					function() {
						queryProvince("depart_province_query",
								"depart_provinces", "depart_city_query",
								"depart_citys", "price_time_query",
								"departCity", "depart_county_query",
								"depart_countys", "departEndpointID");
					});

			// 目的站添加获取焦点监听事件
			$("#destCity").click(
					function() {
						queryProvince("dest_province_query", "dest_provinces",
								"dest_city_query", "dest_citys",
								"price_time_query", "destCity",
								"dest_county_query", "dest_countys",
								"destEndpointID");
					});
			// 时效查询界面查询按钮添加监听时间

			// 出发省界面返回按钮添加事件
			$("#depart_province_back").click(provinceBack);
			// 到达省界面返回按钮添加事件
			$("#dest_province_back").click(provinceBack);
			// 出发城市界面返回按钮添加事件
			$("#depart_city_back").click(
					function() {
						queryProvince("depart_province_query",
								"depart_provinces", "depart_city_query",
								"depart_citys", "price_time_query",
								"departCity", "depart_county_query",
								"depart_countys", "departEndpointID");
					});
			// 到达城市界面返回按钮添加事件
			$("#dest_city_back").click(
					function() {
						queryProvince("dest_province_query", "dest_provinces",
								"dest_city_query", "dest_citys",
								"price_time_query", "destCity",
								"dest_county_query", "dest_countys",
								"destEndpointID");
					});
			// 出发区域返回按钮添加事件
			$("#depart_county_back").click(
					function() {
						queryCity(provinceSelected, "depart_city_query",
								"depart_citys", "price_time_query",
								"departCity", "depart_county_query",
								"depart_countys", "departEndpointID");
					});
			// 到达区域返回按钮添加事件
			$("#dest_county_back").click(
					function() {
						queryCity(provinceSelected, "dest_city_query",
								"dest_citys", "price_time_query", "destCity",
								"dest_county_query", "dest_countys",
								"destEndpointID");
					});
			$("#price_time_query_bt").click(
					function() {
						var departArea = $("#priceDepartEndpointID").val();
						var departCity = $("#citypriceDepartEndpointID").val();
						var destArea = $("#priceDestEndpointID").val();
						var destCity = $("#citypriceDestEndpointID").val();
						if(departArea.length==0||departArea.length == 0){
							checkParams("请填写起始地与目的地");
							return;
						}
						showLoader();
						$("#price_cal_query_ul").empty();
						if(destArea.length==0||destArea.length == 0){
							checkParams("请填写起始地与目的地");
							return;
						}
						showLoader();
						$.ajax({
							url:"queryPriceTime.action",
							async:true,
							type:"POST",
							dataType:"json",
							data:{
								"priceQueryVo.conCity" : destCity,
								"priceQueryVo.conCounty" : destArea,
								"priceQueryVo.shipperCity" : departCity,
								"priceQueryVo.shipperCounty" : departArea
							},
							success:function(result) {
								hideLoader();
								var data = result.priceTimeVos;
								$("#price_cal_query_ul").empty();
								if(data == null || data.length == 0){
									$("#price_cal_query_ul").append('<div style="color:red; margin-bottom:20px;margin-top:10px;"><b>无此线路时效信息</b></div>');
								}else{
									$.each(data, function(i, value) {
										$("#price_cal_query_ul").append("<li data-role='list-divider'>"+value.transportTypeName+"</li>");
										if(value.priceType == "0"){
											$("#price_cal_query_ul").append("<li>重货(元/公斤): "+value.weightPrice+"元 </br>"+
											"轻货(元/立方米): "+value.volumePrice+"元 <br/>"+
											"起步价(元): "+value.minFreightFee+"元<br/>"+
											"预计客户自提时间: 第"+value.pickTime+"天<br/>"+
											"预计送货上门时间: 第"+value.deliveryTime+"天<br/>"+
											"备注："+(value.reamrk == null ? "" : value.reamrk)+"</li>");
										}else if(value.priceType == "1"){
											$("#price_cal_query_ul").append("<li>首重重量(公斤): "+value.firstSectionWeight+"公斤 </br>"+
											"首重金额(元): "+value.firstSectionPrice+"元 <br/>"+
											"续重单价(元/公斤): "+value.addPrice+"元 <br/>"+
											"备注: "+(value.reamrk == null ? "" : value.reamrk)+"</li>");
										}
										$("#price_cal_query_ul").listview('refresh');
									});
								}
								

							},
							error:function(XMLHttpRequest, textStatus, errorThrown){
								hideLoader();
								errorDialog();
							}
						});
					});
			// -----------------------------添加时效查询监听结束----------------------------

			// -----------------------------添加价格计算监听开始----------------------------
			$("#weight").bind("input", function() { 
				var value = $(this).val();
				$(this).val(value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'));
			}); 
			$("#volume").bind("input", function() { 
				var value = $(this).val();
				$(this).val(value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'));
			});
			// 计算价格始发地添加监听时间
			$("#priceDepartCity")
					.focus(
							function() {
								queryProvince("price_depart_province_query",
										"price_depart_provinces",
										"price_depart_city_query",
										"price_depart_citys",
										"price_cal_query", "priceDepartCity",
										"price_depart_county_query",
										"price_depart_countys",
										"priceDepartEndpointID");
							});
			// 计算价格目的站添加获取焦点监听事件
			$("#priceDestCity").focus(
					function() {
						queryProvince("price_dest_province_query",
								"price_dest_provinces",
								"price_dest_city_query", "price_dest_citys",
								"price_cal_query", "priceDestCity",
								"price_dest_county_query",
								"price_dest_countys", "priceDestEndpointID");
					});
			// 时效查询界面查询按钮添加监听时间
			// 计算价格出发省界面返回按钮添加事件
			$("#price_depart_province_back").click(priceProvinceBack);
			// 计算价格到达省界面返回按钮添加事件
			$("#price_dest_province_back").click(priceProvinceBack);
			// 计算价格出发城市界面返回按钮添加事件
			$("#price_depart_city_back")
					.click(
							function() {
								queryProvince("price_depart_province_query",
										"price_depart_provinces",
										"price_depart_city_query",
										"price_depart_citys",
										"price_cal_query", "priceDepartCity",
										"price_depart_county_query",
										"price_depart_countys",
										"priceDepartEndpointID");
							});
			// 计算价格到达城市界面返回按钮添加事件
			$("#price_dest_city_back").click(
					function() {
						queryProvince("price_dest_province_query",
								"price_dest_provinces",
								"price_dest_city_query", "price_dest_citys",
								"price_cal_query", "priceDestCity",
								"price_dest_county_query",
								"price_dest_countys", "priceDestEndpointID");
					});
			// 计算价格出发区域返回按钮添加事件
			$("#price_depart_county_back")
					.click(
							function() {
								queryCity(provinceSelected,
										"price_depart_city_query",
										"price_depart_citys",
										"price_cal_query", "priceDepartCity",
										"price_depart_county_query",
										"price_depart_countys",
										"priceDepartEndpointID");
							});
			// 计算价格 到达区域返回按钮添加事件
			$("#price_dest_county_back").click(
					function() {
						queryCity(provinceSelected, "price_dest_city_query",
								"price_dest_citys", "price_cal_query",
								"priceDestCity", "price_dest_county_query",
								"price_dest_countys", "priceDestEndpointID");
					});
			
			$("#price_cal_weight_bt").click(
					function(){
						var departCity = $("#priceDepartEndpointID").val();
						var destCity = $("#priceDestEndpointID").val();
						if(departCity.length==0||destCity.length == 0){
							checkParams("请填写起始地与目的地");
							return;
						}
						$.mobile.changePage('#price_weight_volume_page', 'flip', true, true);
					}
			);
			$("#price_cal_query_bt").click(
					function() {
						var departArea = $("#priceDepartEndpointID").val();
						var departCity = $("#citypriceDepartEndpointID").val();
						var destArea = $("#priceDestEndpointID").val();
						var destCity = $("#citypriceDestEndpointID").val();
						var weight = $("#weight").val();
						var volume = $("#volume").val();
						var insurance = $("#insurance").val();
						var collDeliveryAmount = $("#collDeliveryAmount").val();
						if(departCity.length==0||destCity.length == 0){
							return;
						}
						if(weight.length==0||volume.length == 0||insurance.length == 0){
							checkParams("请填写重量、体积与保价信息");
							return;
						}
						if(weight==0){
							checkParams("重量不能为0");
							return;
						}
						if(volume == 0){
							checkParams("体积不能为0");
							return;
						}
						if(isNaN(weight)){
							checkParams("请填写正确的重量信息");
							return;
						}
						if(isNaN(volume)){
							checkParams("请填写正确的体积信息");
							return;
						}
						if(isNaN(insurance)){
							checkParams("请填写正确的保价信息");
							return;
						}
						if(collDeliveryAmount.length!=0 && isNaN(collDeliveryAmount)){
							checkParams("请填写正确的代收货款信息");
							return;
						}
						showLoader();
						$("#price_cal_query_ul").empty();
						$.ajax({
							url:"priceCalc.action",
							async:true,
							type:"POST",
							dataType:"json",
							data: {
								"priceQueryVo.conCity" : destCity,
								"priceQueryVo.conCounty" : destArea,
								"priceQueryVo.shipperCity" : departCity,
								"priceQueryVo.shipperCounty" : departArea,
								"priceQueryVo.volumn" : volume,
								"priceQueryVo.weight" : weight,
								"priceQueryVo.insurance" : insurance,
								"priceQueryVo.collDeliveryAmount" : collDeliveryAmount.length == 0 ? 0 : collDeliveryAmount
							},
							success:function(result) {
								hideLoader();
								var data = result.priceCalcVos;
								$("#price_cal_query_ul").empty();
								var transName = "";
								if(data == null || data.length == 0){
									$("#price_cal_query_ul").append('<div style="color:red; margin-bottom:20px;margin-top:10px;"><b>无此线路价格信息</b></div>');
								} else {
									$.each(data, function(i, value) {
										if(value.transType == "ONTIME"){
											transName = '定日达';
										}else if (value.transType == "LESSLOADED"){
											transName = '经济快运';
										} else {
											transName = "";
										}
										$("#price_cal_query_ul").append("<li data-role='list-divider'>"+ transName +"</li>"+
												"<li>货物类型: "+ value.goodsType + 
												"<br/>运输时效: "+ value.transAging + 
												"<br/>交通运输费: "+ value.transCost + '元' + 
												"<br/>保价费: "+ value.insuredCost + '元' + 
												"<br/>燃油服务费: "+ value.fuelCost + '元' + 
												"<br/>工本费: "+ value.laborCost + '元' + 
												"<br/>信息费: "+ value.messageCost + '元' + 
												"<br/>代收货款手续费: "+ value.collProceCost + '元' + 
												"<br/>合计: "+ value.totalCost + '元' + 
										"</li>");
										$("#price_cal_query_ul").listview('refresh');
									});
								}
								$.mobile.changePage("#price_cal_query", {
									transition : "none",
									changeHash : false
								});
							},
							error:function(XMLHttpRequest, textStatus, errorThrown){
								hideLoader();
								errorDialog();
							}
						});
					});
		});

// 返回至时效查询界面
function provinceBack() {
	$.mobile.changePage("#price_time_query", {
		transition : "none",
		changeHash : false
	});
};
// 返回至价格计算页面
function priceProvinceBack() {
	$.mobile.changePage("#price_cal_query", {
		transition : "none",
		changeHash : false
	});
};
// 查询省
function queryProvince(provincePage, provinces, cityPage, citys, finishPage,
		finalCity, countyPage, countys, endpointID) {
	showLoader();
	$("#" + provinces).empty();
	$.ajax({
		url:"queryProvinceInfo.action",
		async:true,
		type:"POST",
		dataType:"json",
		success:function(result) {
			hideLoader();
			var data = result.provinces;
			$("#" + provinces).empty();
			$.mobile.changePage("#" + provincePage, {
				transition : "none",
				changeHash : false
			});
			$.each(data, function(i, value) {
				$("#" + provinces).append("<li>" + value + "</li>");
				$("#" + provinces).listview('refresh');
			});
			// 添加点击大区监听事件：跳转至城市界面
			$("#" + provinces + " li").click(
					function() {
						var province = $(this).html();
						provinceSelected = province;
						queryCity(province, cityPage, citys, finishPage, finalCity,
								countyPage, countys, endpointID);
					});
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	
	
}
// 查询城市
function queryCity(province, cityPage, citys, finishPage, finalCity,
		countyPage, countys, endpointID) {
	showLoader();
	$("#" + citys).empty();
	$.ajax({
		url:"queryCityInfo.action",
		type:"POST",
		async:true,
		data:{
			province : province
		},
		dataType:"json",
		success:function(result) {
			hideLoader();
			var data = result.citys;
			$("#" + citys).empty();
			$.mobile.changePage("#" + cityPage, {
				transition : "none",
				changeHash : false
			});
			$.each(data, function(i, value) {
				$("#" + citys).append("<li>" + value + "</li>");
				$("#" + citys).listview('refresh');
			});
			$("#" + citys + " li").click(
					function() {
						var city = $(this).html();
						queryCounty(province, cityPage, citys, city, finishPage,
								finalCity, countyPage, countys, endpointID);
					});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	
}
// 查询区县
function queryCounty(province, cityPage, citys, city, finishPage, finalCity,
		countyPage, countys, endpointID) {
	showLoader();
	$("#" + countys).empty();
	$.ajax({
		url:"queryCountyInfoByProvinceCity.action",
		type:"POST",
		async:true,
		data:{
			province : province,
			city : city
		},
		dataType:"json",
		success:function(result) {
			hideLoader();
			var data = result.countys;
			$("#" + countys).empty();
			$.mobile.changePage("#" + countyPage, {
				transition : "none",
				changeHash : false
			});
			$.each(data, function(i, value) {
				if (value !== null && value !== undefined
						&& value.countyName !== '') {
					$("#" + countys).append("<li>" + value + "</li>");
					$("#" + countys).listview('refresh');
				} /*else {
					$("#" + countys).append("<li>" + value.endpointName + "</li>");
					$("#" + countys).listview('refresh');
				}*/
				
			});
			$("#" + countys + " li").click(
					function() {
						var county =  $(this).html();
						var endpoint = county;
						/*$.each(data, function(i, value) {
							if (value !== null && value !== undefined
									&& value.countyName !== '' && county==value.countyName) {
								endpoint = value.endpointID;
							}else if(county == value.endpointName){
								endpoint = value.endpointID;
							}
						});*/
						$.mobile.changePage("#" + finishPage, {
							transition : "none",
							changeHash : false
						});
						$("#" + finalCity).val(
								province + " " + city + " " + $(this).html());
						$("#" + endpointID).val(endpoint);
						$("#" + 'city' + endpointID).val(city);
					});

		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	

}
function errorDialog(){
	$.mobile.changePage('#err_dialog', 'flip', true, true);
	/*alert("error");*/
}

function showLoader() {  
    //显示加载器.for jQuery Mobile 1.2.0  
   /* $.mobile.loading('show', {  
        text: '加载中...', //加载器中显示的文字  
        textVisible: true, //是否显示文字  
        textonly: false,   //是否只显示文字  
        html: ""           //要显示的html内容，如图片等  
    }); */ 
}  
  
//隐藏加载器.for jQuery Mobile 1.2.0  
function hideLoader()  
{  
    //隐藏加载器  
    //$.mobile.loading('hide');  
}  

function checkParams(msg){
	$("#dialg_header").html();
	$("#price_dialog_con").empty();
	$("#price_dialog_con").append("<h>"+msg+"</h>");
	$.mobile.changePage('#price_dialog', 'flip', true, true);
}

  
