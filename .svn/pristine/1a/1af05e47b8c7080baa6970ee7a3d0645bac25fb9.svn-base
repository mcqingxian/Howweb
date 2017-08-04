var provinceSelected = "";
var provinceNameSelected = "";
var lon,lat = null;
//是否修改成功
var submitSuccess = false;
$(document).ready(function(){
	//-----------------------------------------------------
	/*
	 *  获取当前位置 省市区
	 * 
	 * */
	var province = null;
	var city = null;
	var district = null;
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position){
			
			lat = position.coords.latitude;
			lon = position.coords.longitude;
			var myGeo = new BMap.Geocoder();      
			// 根据坐标得到地址描述    
			var curPoint = new BMap.Point(lon, lat);
			myGeo.getLocation(curPoint, function(result){      
			                 if (result){
			                	 province = result.addressComponents.province;
			                	 city = result.addressComponents.city;
			                	 district = result.addressComponents.district;
			                  }      
			});
		});
	} else {
		alert("Geolocation is not supported by this browser.");
	}
	//--------------------------------------------------
	// 添加监听时间
	/*$("#order_a_pagetwo").click(function() {
		$.mobile.changePage("#pagetwo", {
			transition : "none",
			changeHash : false
		});
	});
	$("#pagetwo_a_order").click(function() {
		$.mobile.changePage("#order", {
			transition : "none",
			changeHash : false
		});
	});*/
	
	// 受理网点添加获取焦点监听事件
	$("#shipperSlwd").click(
			function() {
				queryListByAddress("shipper_branches_query",
						"shipper_branches","order");
			});

	// 省市添加获取焦点监听事件
	$("#shipperProv").click(
			function() {
				queryProvince("shipper_province_query",
						"shipper_provinces", "shipper_city_query",
						"shipper_citys", "order",
						"shipperProv","shipper_county_query",
						"shipper_countys");
			});
	$("#consigneeProv").click(
			function() {
				queryProvince("consignee_province_query",
						"consignee_provinces", "consignee_city_query",
						"consignee_citys", "order",
						"consigneeProv","consignee_county_query",
						"consignee_countys");
			});
	//发货人查询按钮添加事件
	$("#query_shipper").click(
			function() {
				$.mobile.changePage("#shipper_query", {
					transition : "none",
					changeHash : false
				});
			});
	//发货人返回按钮添加事件
	$("#shipper_back").click(
			function() {
				$.mobile.changePage("#order", {
					transition : "none",
					changeHash : false
				});
			});
	$("#shippers li").click(function(){
		var  index = $(this).attr("id").substring(0, $(this).attr("id").indexOf("_shipper_li"));
		 $("#shipperName").val($("#"+ index+"_shipper_name").val());
		 $("#shipperMobile").val($("#"+ index+"_shipper_phone").val());
		 $("#shipperProv").val($("#"+ index+"_shipper_pro_city_cty").val());
		 $("#shipperAddress").val($("#"+ index+"_shipper_detail_address").val());
		 $.mobile.changePage("#order", {
				transition : "none",
				changeHash : false
		});
	});
	
	
	//收货人查询按钮添加事件
	$("#query_consignee").click(
			function() {
				$.mobile.changePage("#consignee_query", {
					transition : "none",
					changeHash : false
				});
			});
	//收货人返回按钮添加事件
	$("#consignee_back").click(
			function() {
				$.mobile.changePage("#order", {
					transition : "none",
					changeHash : false
				});
			});
	$("#consignees li").click(function(){
		var  index = $(this).attr("id").substring(0, $(this).attr("id").indexOf("_consignee_li"));
		 $("#consigneeName").val($("#"+ index+"_consignee_name").val());
		 $("#consigneeMobile").val($("#"+ index+"_consignee_phone").val());
		 $("#consigneeProv").val($("#"+ index+"_consignee_pro_city_cty").val());
		 $("#consigneeAddress").val($("#"+ index+"_consignee_detail_address").val());
		 $.mobile.changePage("#order", {
				transition : "none",
				changeHash : false
		});
	});
	//省界面返回按钮
	$("#shipper_province_back").click(function(){
		$.mobile.changePage("#order", {
			transition : "none",
			changeHash : false
		});
	});
	//受理网点返回按钮
	$("#shipper_branches_back").click(function(){
		$.mobile.changePage("#order", {
			transition : "none",
			changeHash : false
		});
	});
	//省界面返回按钮
	$("#consignee_province_back").click(function(){
		$.mobile.changePage("#order", {
			transition : "none",
			changeHash : false
		});
	});
	$("#consignee_city_back").click(
			function() {
				queryProvince("consignee_province_query",
						"consignee_provinces", "consignee_city_query",
						"consignee_citys", "order",
						"consigneeProv","consignee_county_query",
						"consignee_countys");
			});
	//城市界面返回按钮
	$("#shipper_city_back").click(function(){
		queryProvince("shipper_province_query",
				"shipper_provinces", "shipper_city_query",
				"shipper_citys", "order",
				"shipperProv","shipper_county_query",
				"shipper_countys");
	});
	// 出发区域返回按钮添加事件
	$("#shipper_county_back").click(
			function() {
				queryCity(provinceSelected,provinceNameSelected, "shipper_city_query",
						"shipper_citys", "order",
						"shipperProv","shipper_county_query",
						"shipper_countys");
	});
	$("#consignee_county_back").click(
			function() {
				queryCity(provinceSelected,provinceNameSelected, "consignee_city_query",
						"consignee_citys", "order",
						"consigneeProv","consignee_county_query",
						"consignee_countys");
	});
	//提交按钮添加监听时间
	$("#submit_order_bt").click(function(){
		$(this).attr("disabled","disabled");
		var reg =/^(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$/;
		var shipperName = $("#shipperName").val();
		if(shipperName.length == 0){
			checkParams("请填写发货人");
			$(this).removeAttr("disabled");
			return;
		}
		var shipperMobile = $("#shipperMobile").val();
		if(shipperMobile.length == 0){
			checkParams("请填写发货人手机号");
			$(this).removeAttr("disabled");
			return;
		}
		if(!reg.test(shipperMobile)){
			checkParams("请填写正确的发货人手机号");
			$(this).removeAttr("disabled");
			return;
		}
		var shipperProv = $("#shipperProv").val();
		if(shipperProv.length == 0){
			checkParams("请选择发货人省市");
			$(this).removeAttr("disabled");
			return;
		}
		var shipperAddress = $("#shipperAddress").val();
		if(shipperAddress.length == 0){
			checkParams("请填写发货人详细地址");
			$(this).removeAttr("disabled");
			return;
		}
		var shipperprovs = shipperProv.split(' ');
		
		var consigneeName = $("#consigneeName").val();
		/*if(consigneeName.length == 0){
			checkParams("请填写收货人");
			$(this).removeAttr("disabled");
			return;
		}*/
		var consigneeMobile = $("#consigneeMobile").val();
		/*if(consigneeMobile.length == 0){
			checkParams("请填写收货人手机号");
			$(this).removeAttr("disabled");
			return;
		}*/
		if(consigneeMobile.length > 0 && !reg.test(consigneeMobile)){
			checkParams("请填写正确的收货人手机号");
			$(this).removeAttr("disabled");
			return;
		}
		var consigneeProv = $("#consigneeProv").val();
		/*if(consigneeProv.length == 0){
			checkParams("请选择收货人省市");
			$(this).removeAttr("disabled");
			return;
		}*/
		var consigneeAddress = $("#consigneeAddress").val();
		/*if(consigneeAddress.length == 0){
			checkParams("请填写收货人详细地址");
			$(this).removeAttr("disabled");
			return;
		}*/
		var consigneeProvs;
		var consigneeProvs0 = null;
		var consigneeProvs1 = null;
		var consigneeProvs2 = null;
		if(consigneeProv != null && consigneeProv.length > 0){
			consigneeProvs = consigneeProv.split(' ');
			consigneeProvs0 = consigneeProvs[0];
			consigneeProvs1 = consigneeProvs[1];
			consigneeProvs2 = consigneeProvs[2];
		}
		var shipperMethod = $("#shipperMethod").val();
		if(shipperMethod.length == 0){
			checkParams("请选择提货方式");
			$(this).removeAttr("disabled");
			return;
		}
		/**受理网点获取*/
		var shipper_branches_code = $("#shipperSlwd_code").val();
		var shipper_branches_name = $("#shipperSlwd").val();
		
		
		$.ajax({
			url:"submitOrder.action",
			type:"POST",
			dataType:"json",
			data:{
				"order.shipperName":shipperName,
				"order.shipperMobile":shipperMobile,
				"order.shipperProv":shipperprovs[0],
				"order.shipperCity":shipperprovs[1],
				"order.shipperEbrgNameCn":shipperprovs[2],
				"order.shipperAddress":shipperAddress,
				"order.consigneeName":consigneeName,
				"order.consigneeMobile":consigneeMobile,
				"order.consigneeProv":consigneeProvs0,
				"order.consigneeCity":consigneeProvs1,
				"order.consigneeEbrgNameCn":consigneeProvs2,
				"order.consigneeAddress":consigneeAddress,
				"order.shipperMethod":shipperMethod,
				"order.escoSecondCode":shipper_branches_code,
				"order.escoSecondName":shipper_branches_name
			},
			success:function(data,textStatus){
				$("#submit_order_bt").removeAttr("disabled");
				if(!data.exception){
					submitSuccess = true;
					$("#dialg_header").html("下单成功");
					$("#order_dialog_con").empty();
					$("#order_dialog_con").append("<h>订单号"+data.value+"</h>");
					
				}else{
					submitSuccess = false;
					$("#dialg_header").html("下单失败");
					$("#order_dialog_con").empty();
					$("#order_dialog_con").append("<h>"+data.errMsg+"</h>");
				}
				$.mobile.changePage('#order_dialog', 'flip', true, true);
			},
			error:function(){
				submitSuccess = false;
				$("#submit_order_bt").removeAttr("disabled");
				hideLoader();
				errorDialog();
			}
		});
	});
	$("#shipper_location").click(function(){
		if(province!=null&&city!=null){
			$("#shipperProv").val(province+" "+city+" "+ district);
		}
	});
	$("#consignee_location").click(function(){
		if(province!=null&&city!=null){
			$("#consigneeProv").val(province+" "+city+" "+ district);
		}
	});
	$(document).delegate('#order_dialog','pagehide', function (event) {
        if(submitSuccess){
        	var url = window.location.href.substring(0, window.location.href.lastIndexOf("/")+1)+"queryOrder.action?v="+new Date().getTime();
        	window.location.href = url;
        }
     });
});

//查询省
function queryProvince(provincePage, provinces, cityPage, citys, finishPage,
		finalCity, countyPage, countys) {
	showLoader();
	$("#" + provinces).empty();
	$.ajax({
		url:"queryDistrictProvince.action",
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
				$("#" + provinces).append("<li p="+value.districtCode+">" + value.districtName + "</li>");
				$("#" + provinces).listview('refresh');
			});
			// 添加点击大区监听事件：跳转至城市界面
			$("#" + provinces + " li").click(
					function() {
//						var province = $(this).html();
						/**
						 * 2015-10-26 修改获取省份为编码
						 */
						var province = $(this).attr("p");
						var provinceName = $(this).html();
						provinceSelected = province;
						provinceNameSelected = provinceName;
						queryCity(province,provinceName, cityPage, citys, finishPage, finalCity,countyPage, countys);
					});
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	
	
}
// 查询城市
function queryCity(province,provinceName, cityPage, citys, finishPage, finalCity, countyPage, countys) {
	showLoader();
	$("#" + citys).empty();
	$.ajax({
		url:"queryDistrictCity.action",
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
				$("#" + citys).append("<li p="+value.districtCode+">" + value.districtName + "</li>");
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
						queryCounty(provinceName, cityPage, citys, city,cityName, finishPage,
								finalCity, countyPage, countys);
//						$("#" + finalCity).val(
//								province + " " + city);
//						$.mobile.changePage("#" + finishPage, {
//							transition : "none",
//							changeHash : false
//						});
					});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	
}

//查询区县
function queryCounty(provinceName, cityPage, citys, city,cityName, finishPage, finalCity,
		countyPage, countys) {
	showLoader();
	$("#" + countys).empty();
	$.ajax({
		url : "queryDistrictCounty.action",
		type : "POST",
		async : true,
		data : {
//			province : province,
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
				$("#" + countys).append("<li>" + value.districtName + "</li>");
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

function checkParams(msg){
	$("#dialg_header").html();
	$("#order_dialog_con").empty();
	$("#order_dialog_con").append("<h>"+msg+"</h>");
	$.mobile.changePage('#order_dialog', 'flip', true, true);
}

function errorDialog(){
	//$.mobile.changePage('#err_dialog', 'flip', true, true);
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

function queryListByAddress(shipper_branches_query,shipper_branches,finishPage) {
	var pcc = $("#shipperProv").val();
	$("#" + shipper_branches).empty();
	if (pcc == undefined || pcc == "" || pcc == null) {
		checkParams("发货省市区不能为空");
		return;
	}
	
	var city = pcc.split(" ")[1];
	var myGeo = new BMap.Geocoder();
//	var lon = null;
//	var lat = null;
	var addresss = $("#shipperAddress").val();
	// 将地址解析结果显示在地图上，并调整地图视野
	myGeo.getPoint(pcc+addresss, function(point) {
//		alert(point.lng);
//		alert(point.lat);
//		if(lon == null || lat == null){
			lon = point.lng;
			lat = point.lat;
//		}
		$.ajax({
			url : "getBranchesAddress.action",
			type : "POST",
			async : true,
			data : {
				pro_city_cty : pcc,
				lon:lon,
				lat:lat,
				llon:lon,
				llat:lat,
				status:"1"//默认为已定位
			},
			dataType : "json",
			success : function(data) {
				hideLoader();
				$("#" + shipper_branches).empty();
				$.mobile.changePage("#" + shipper_branches_query, {
					transition : "none",
					changeHash : false
				});
				$.each(data, function(i, value) {
					$("#" + shipper_branches).append(setShipperSlwdTable(i,value));
					$("#" + shipper_branches).listview('refresh');
//					$("#" + shipper_branches).append(setShipperSlwdTable(i,value)).trigger('create');
//					$("#" + shipper_branches).trigger('create');
//					$("#" + shipper_branches).collapsibleset('refresh');
				});
				
				$("#" + shipper_branches + " li").click(
					function() {
						$.mobile.changePage("#" + finishPage, {
							transition : "none",
							changeHash : false
						});
						 $("#shipperSlwd").val(data[$(this).attr("p")].name);
						 $("#shipperSlwd_code").val(data[$(this).attr("p")].logistCode);
				});
				
				
//				 $("input[type='radio']").click(function(){
//					$.mobile.changePage("#" + finishPage, {
//						transition : "none",
//						changeHash : false
//					});
//					 $("#shipperSlwd").val(data[$(this).val()].name);
//					 $("#shipperSlwd_code").val(data[$(this).val()].logistCode);
//				});
//				 $("input[type='radio']").bind("change",function(event,ui){
//					 if($(".radio-choice").attr("checked") == "checked"){
//						alert("dsd");
//					}
//				});

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				hideLoader();
				errorDialog();
			}
		});
	}, city);
	

}

function setShipperSlwdTable(i,value){
	var ywfw = "";
	if(value.shipment)
		ywfw = ywfw + "可发货、";
	if(value.pickUp)
		ywfw = ywfw + "可自提、";
	if(value.delivery)
		ywfw = ywfw + "可送货、";
	ywfw = ywfw.substring(0,(ywfw.length-1));
	var data =  '<li p="'+i+'" style="border:1px solid white;">'+ 
				'<span><h3>'+value.name+'</h3> </span> <br />'+
				'<span>网点代码：'+value.logistCode+'</span> <br />'+
				'<span>业务范围：'+ywfw+'</span> <br />'+
				'<span>门店地址：'+value.address+'</span> <br />'+
				'<span>电话：'+value.telephone+'</span> <br />'+
				'<span>距离：'+value.directDistance+'千米</span>'+
				'</li>';
//	var data = '<div data-role="collapsible" data-collapsed-icon="chevron-circle-down" data-expanded-icon="chevron-circle-up">' +
//			'<input type="radio" name="radio-choice" id="radio-choice-'+i+'" value="'+i+'" />' + 
////			'<label for="radio-choice-'+i+'">' + 
//			'<h1>'+value.name+'</h1>'+
////			'</label>'+
//			'<table style="width:100%">'+
//			'<tr>'+
//			'<td style="width:30%">网点代码：</td>'+
//			'<td style="width:70%">'+value.logistCode+'</td>'+
//			'</tr>'+
//			'<tr>'+
//				'<td style="width:30%">业务范围：</td>'+
//				'<td style="width:70%">'+ywfw+'</td>'+
//			'</tr>'+
//			'<tr>'+
//				'<td  style="width:30%">门店地址：</td>'+
//				'<td style="width:70%">'+value.address+'</td>'+
//			'</tr>'+
//			'<tr>'+
//				'<td  style="width:30%">电话：</td>'+
//				'<td style="width:70%">'+value.telephone+'</td>'+
//			'</tr>'+
//			'<tr>'+
//				'<td  style="width:30%">距离：</td>'+
//				'<td style="width:70%">'+value.directDistance+'千米</td>'+
//			'</tr>'+
//			'</table>'+
//			'</div>';
	return data;
}
  

