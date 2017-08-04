//所选省份
var provinceSelected = "";
//是否修改成功
var modifySuccess = false;

var cancelSuccess = false;
$(document).ready(function(){
	//-----------------------------------------------------
	/*
	 *  获取当前位置 省市区
	 * 
	 * */
	var province = null;
	var city = null;
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position){
			var lon,lat;
			lat = position.coords.latitude;
			lon = position.coords.longitude;
			var myGeo = new BMap.Geocoder();      
			// 根据坐标得到地址描述    
			var curPoint = new BMap.Point(lon, lat);
			myGeo.getLocation(curPoint, function(result){      
			                 if (result){
			                	 province = result.addressComponents.province;
			                	 city = result.addressComponents.city;
			                  }      
			});
		});
	} else {
		alert("Geolocation is not supported by this browser.");
	}
	// 添加监听时间
	$("#order_a_pagetwo").click(function() {
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
				$.mobile.changePage("#pagetwo", {
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
		 $.mobile.changePage("#pagetwo", {
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
	//省界面返回按钮
	$("#consignee_province_back").click(function(){
		$.mobile.changePage("#pagetwo", {
			transition : "none",
			changeHash : false
		});
	});
	$("#consignee_city_back").click(
			function() {
				queryProvince("consignee_province_query",
						"consignee_provinces", "consignee_city_query",
						"consignee_citys", "pagetwo",
						"consigneeProv");
			});
	//城市界面返回按钮
	$("#shipper_city_back").click(function(){
		queryProvince("shipper_province_query",
				"shipper_provinces", "shipper_city_query",
				"shipper_citys", "order",
				"shipperProv");
	});
	$(document).delegate('#order_dialog','pagehide', function (event) {
        if(modifySuccess){
        	var url = window.location.href.substring(0, window.location.href.lastIndexOf("/")+1)+"queryOrder.action?v="+new Date().getTime();
        	window.location.href = url;
        }
     });
	$("#shipper_location").click(function(){
		if(province!=null&&city!=null){
			$("#shipperProv").val(province+" "+city);
		}
	});
	$("#consignee_location").click(function(){
		if(province!=null&&city!=null){
			$("#consigneeProv").val(province+" "+city);
		}
	});
	//修改按钮事件
	$("#update_order_bt").click(function(){
		$(this).attr("disabled","disabled");
		var reg =/^(13[0-9]|15[0-9]|18[0-9])[0-9]{8}$/;
		var shipperName = $("#shipperName").val();
		var orderNo = $("#orderNo").val();
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
		if(consigneeName.length == 0){
			checkParams("请填写收货人");
			$(this).removeAttr("disabled");
			return;
		}
		var consigneeMobile = $("#consigneeMobile").val();
		if(consigneeMobile.length == 0){
			checkParams("请填写收货人手机号");
			$(this).removeAttr("disabled");
			return;
		}
		if(!reg.test(consigneeMobile)){
			checkParams("请填写正确的收货人手机号");
			$(this).removeAttr("disabled");
			return;
		}
		var consigneeProv = $("#consigneeProv").val();
		if(consigneeProv.length == 0){
			checkParams("请选择收货人省市");
			$(this).removeAttr("disabled");
			return;
		}
		var consigneeAddress = $("#consigneeAddress").val();
		if(consigneeAddress.length == 0){
			checkParams("请填写收货人详细地址");
			$(this).removeAttr("disabled");
			return;
		}
		var consigneeProvs = consigneeProv.split(' ');
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
			url:"modifyOrderDetail.action",
			type:"POST",
			dataType:"json",
			data:{
				"order.orderNo":orderNo,
				"order.shipperName":shipperName,
				"order.shipperMobile":shipperMobile,
				"order.shipperProv":shipperprovs[0],
				"order.shipperCity":shipperprovs[1],
				"order.shipperEbrgNameCn":shipperprovs[2],
				"order.shipperAddress":shipperAddress,
				"order.consigneeName":consigneeName,
				"order.consigneeMobile":consigneeMobile,
				"order.consigneeProv":consigneeProvs[0],
				"order.consigneeCity":consigneeProvs[1],
				"order.consigneeEbrgNameCn":consigneeProvs[2],
				"order.consigneeAddress":consigneeAddress,
				"order.shipperMethod":shipperMethod,
				"order.escoSecondCode":shipper_branches_code,
				"order.escoSecondName":shipper_branches_name
			},
			success:function(data,textStatus){
				$("#submit_order_bt").removeAttr("disabled");
				if(!data.exception){
					modifySuccess = true;
					$("#dialg_header").html("修改订单成功");
					$("#order_dialog_con").empty();
					$("#order_dialog_con").append("<h>订单号"+data.value+"</h>");
					
				}else{
					modifySuccess = false;
					$("#dialg_header").html("修改订单失败");
					$("#order_dialog_con").empty();
					$("#order_dialog_con").append("<h>"+data.errMsg+"</h>");
				}
				$.mobile.changePage('#order_dialog', 'flip', true, true);
			},
			error:function(){
				modifySuccess = false;
				$("#submit_order_bt").removeAttr("disabled");
				hideLoader();
				errorDialog();
			}
		});
	});
	
	$("#cancle_order_bt").click(function(){
		var orderNo =  $("#orderNo").val();;
		$("#dialg_header").html("撤销订单");
		$("#order_dialog_con").empty();
		$("#order_dialog_con")
				.append(
						"<h>是否要撤销订单号："
								+ orderNo
								+ "?</h><p  style='color: red;'>此操作不可恢复</p>"
								+ "<div align='center'>"
								/*
								 * <button id='' data-inline='true'
								 * data-icon='delete'>取消</button>
								 */
								+ "<button data-inline='true' data-theme = 'h' id='sure_cancel_order'>确认</button></div>");
		$("#order_dialog_con").trigger("create");
		$("#sure_cancel_order").click(function() {
			$.ajax({
				url : "cancelOrder.action",
				type : "POST",
				dataType : "json",
				data : {
					"order.orderNo" : orderNo
				},
				success : function(data, textStatus) {
					if (!data.exception) {
						cancelSuccess = true;
						$("#dialg_header").html("撤消成功");
						$("#order_dialog_con").empty();
						$("#order_dialog_con").append(
								"<h>撤销订单号" + data.value + "成功</h>");
					} else {
						cancelSuccess = false;
						$("#dialg_header").html("撤消失败");
						$("#order_dialog_con").empty();
						$("#order_dialog_con").append("<h>" + data.errMsg + "</h>");
					}
					$.mobile.changePage('#order_dialog', 'flip', true, true);
				},
				error : function() {
					cancelSuccess = false;
					errorDialog();
				}
			});
		});
		$.mobile.changePage('#order_dialog', 'flip', true, true);
	});
	$(document).delegate('#order_dialog','pagehide', function (event) {
        if(modifySuccess||cancelSuccess){
        	var url = window.location.href.substring(0, window.location.href.lastIndexOf("/")+1)+"queryOrder.action?v="+new Date().getTime();
        	window.location.href = url;
        }
     });
	$("#query_waybill_bt").click(function(){
		var waybillNo = $("#waybillNo").val();
		if(waybillNo.length > 0){
			var url = window.location.href.substring(0, window.location.href
					.lastIndexOf("/") + 1)
					+ "toGoodsTracePage.action?waybill=" + waybillNo;
			window.location.href = url;
		}
	});
});

//查询省
function queryProvince(provincePage, provinces, cityPage, citys, finishPage,
		finalCity) {
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
						queryCity(province, cityPage, citys, finishPage, finalCity);
					});
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	
	
}
// 查询城市
function queryCity(province, cityPage, citys, finishPage, finalCity) {
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
						$("#" + finalCity).val(
								province + " " + city);
						$.mobile.changePage("#" + finishPage, {
							transition : "none",
							changeHash : false
						});
					});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
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
  


