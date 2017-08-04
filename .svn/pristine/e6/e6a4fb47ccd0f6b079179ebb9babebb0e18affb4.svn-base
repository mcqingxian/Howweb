var setLeavedCityName = "出发城市";
var setArrivedCityName = "到达城市";
var setWeight = "货物总重量";
var setVolumn = "货物总体积:长*宽*高(CM)";
var setInsurance = "请输入货物实际价值进行保价";
var setCollDeliveryAmount = "如您需要代收货款服务则填写";

$(document).ready(function(){
	
	$("#queryPricTime").click(function(){
		var leavedPriceTimeCityName = $("#leavedCityName").val(); 								
		var arrivedPriceTimeCityName = $("#arrivedCityName").val(); 
		var reg = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
		if(!reg.test(leavedPriceTimeCityName) && !reg.test(arrivedPriceTimeCityName)){
			return ;
		}else{
			$("#priceTimeForm").submit();
		}
	});
	
	$(function(){
		var leavedCityName = $("#leavedCityName").val();
		var arrivedCityName = $("#arrivedCityName").val();
		var reg = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
		if(leavedCityName != null && reg.test(leavedCityName) && arrivedCityName != null && reg.test(arrivedCityName)){
			showPriceTime();
		}
	});
	
	/**
	 * 查询价格时效
	 */
	$("#queryPrice").click(function (){
		showPriceTime();
	});
	
	/**
	 * 初始化禁用计算button
	 */
	/*$(function(){
		$("#priceCale").attr({"disabled":"disabled"});
	});*/
	
	/**
	 * 计算价格
	 */
	$("#priceCale").click(function (){
		var leavedCityName = $("#leavedCityName").val();
		//没有选择出发城市
		if(setLeavedCityName == leavedCityName){
			$("#routeMsg").removeClass("hide");
			return;
		}
		var shippers = leavedCityName.split("-");
		var shipperCity = shippers[1];
		var shipperCounty = shippers[2];
		
		var arrivedCityName = $("#arrivedCityName").val();
		//没有选择出发城市
		if(setArrivedCityName == arrivedCityName){
			$("#routeMsg").removeClass("hide");
			return;
		}
		var con = arrivedCityName.split("-");
		var conCity = con[1];
		var conCounty = con[2];
		
		//二次选择正确路线
		$("#routeMsg").addClass("hide");
		
		//重量
		var weight = $("#weight").val();
		if (setWeight == weight || weight == "") {
			$("#tips").text("请输入货物重量!");
			return;
		}else if(weight == 0){
			$("#tips").text("货物重量不能为零!");
			return;
		}else if(isNaN(weight)){
			$("#tips").text("请输入正确的货物重量!");
			return;
		}
		//体积
		var volumn = $("#volumn").val();
		if (setVolumn == volumn || volumn == "") {
			$("#tips").text("请输入货物体积!");
			return;
		}else if(volumn == 0){
			$("#tips").text("货物体积不能为零!");
			return ;
		}else if(isNaN(volumn)){
			$("#tips").text("请输入正确的货物体积!");
			return ;
		}
		//保价
		var insurance = $("#insurance").val();
		if (setInsurance == insurance || insurance == "") {
			$("#tips").text("请输入货物保价!");
			return;
		}else if(isNaN(insurance)){
			$("#tips").text("请输入正确的保价金额!");
			return;
		}
		$("#tips").text("");
		
		//代收货款
		var collDeliveryAmount = $("#collDeliveryAmount").val();
		/*if(collDeliveryAmount != null && collDeliveryAmount != '' 
			&& setCollDeliveryAmount != collDeliveryAmount && Number(collDeliveryAmount) > 100){
			$("#tips").text("代收货款最大只能输入100!");
			return;
		}*/
		if(setCollDeliveryAmount == collDeliveryAmount || collDeliveryAmount == ""){
			collDeliveryAmount = 0;
		}
		
		
		$.ajax({
			type : "post",
			url : "priceCalc.action",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data : {
				"priceQueryVo.conCity":conCity,
				"priceQueryVo.conCounty":conCounty,
				"priceQueryVo.shipperCity":shipperCity,
				"priceQueryVo.shipperCounty":shipperCounty,
//				"priceQueryVo.productTypeId":productTypeId,
				"priceQueryVo.weight":weight,
				"priceQueryVo.volumn":volumn,
				"priceQueryVo.insurance":insurance,
				"priceQueryVo.collDeliveryAmount":collDeliveryAmount
			},
			success : function(data) {
				if (data.success) {
					var prices = data.priceCalcVos;
					var tail = 0;
					var objModel = new Array();
					for(var i=0;i<prices.length;i++){
						if(prices[i].transType == "ONTIME"){
							tail = 0;
						}else if(prices[i].transType == "LESSLOADED"){
							tail = 1;
						}else if(prices[i].transType == "INHOME"){
							tail = 2;
							if(prices[i].exist == 1){
								objModel.push('price_calc_inhome_title');
								objModel.push('price_calc_inhome_div');
							}
						}else if(prices[i].transType == "INSTALL"){
							tail = 3;
							if(prices[i].exist == 1){
								objModel.push('price_calc_install_title');
								objModel.push('price_calc_install_div');
							}
						}else if(prices[i].transType == "PACKAGE"){
							tail = 4;
							if(prices[i].exist == 1){
								objModel.push('price_calc_package_title');
								objModel.push('price_calc_package_div');
							}
						}
						$("#goodsType"+tail).text(prices[i].goodsType);
						$("#transAging"+tail).text(prices[i].transAging);
						$("#transCost"+tail).text(prices[i].transCost+" 元");
						$("#insuredCost"+tail).text(prices[i].insuredCost+" 元");
						$("#fuelCost"+tail).text(prices[i].fuelCost+" 元");
						$("#laborCost"+tail).text(prices[i].laborCost+" 元");
						$("#messageCost"+tail).text(prices[i].messageCost+" 元");
						$("#collProceCost"+tail).text(prices[i].collProceCost+" 元");
						$("#totalCost"+tail).text(prices[i].totalCost+" 元");
					}
					$("#price_cale").removeClass("hide");
					$("#explain_div").removeClass("hide");
					for(var i = 0 ;i < objModel.length ; i ++){
						$("#price_cale").find("#"+objModel[i]).css("display","none");
					}
				} else {
					alert(data.message);
				}
			},
			error : function(data) {
				alert("对不起，系统繁忙,请稍后操作！");
			}
		});
	});
	
	
});

/**
 * 
 * @author 龙海仁
 * @date 2015年8月21日下午2:07:52
 * @update
 */
function showPriceTime(){
	var leavedCityName = $("#leavedCityName").val();
	//没有选择出发城市
	if(setLeavedCityName == leavedCityName){
		$("#routeMsg").removeClass("hide");
		return;
	}
	//匹配格式
	var reg = /^[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}-[\u4E00-\u9FA5]{2,}$/;
	if(!reg.test(leavedCityName)){
		$("#routeMsg").removeClass("hide");
		return;
	}
	var shippers = leavedCityName.split("-");
	var shipperCity = shippers[1];
	var shipperCounty = shippers[2];
	
	//到达城市
	var arrivedCityName = $("#arrivedCityName").val();
	//没有选择出发城市
	if(setArrivedCityName == arrivedCityName){
		$("#routeMsg").removeClass("hide");
		return;
	}
	if(!reg.test(arrivedCityName)){
		$("#routeMsg").removeClass("hide");
		return;
	}
	var con = arrivedCityName.split("-");
	var conCity = con[1];
	var conCounty = con[2];
	
	//二次选择正确路线
	$("#routeMsg").addClass("hide");
	
	$.ajax({
		type : "post",
		url : "queryPriceTime.action",
		dataType : "json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data : {
			"priceQueryVo.conCity":conCity,
			"priceQueryVo.conCounty":conCounty,
			"priceQueryVo.shipperCity":shipperCity,
			"priceQueryVo.shipperCounty":shipperCounty,
//			"priceQueryVo.productTypeId":productTypeId,
//			"priceQueryVo.weight":weight,
//			"priceQueryVo.volumn":volu/*
		},
		success : function(data) {
			if (data.success) {
				var prices = data.priceTimeVos;
				var tail = 0;
				for(var i=0;i<prices.length;i++){
					if(prices[i].transportType == "ONTIME"){
						tail = 0;
					}else if(prices[i].transportType == "LESSLOADED"){
						tail = 1;
					}else if(prices[i].transportType == "INHOME"){
						tail = 2;
					}else if(prices[i].transportType == "INSTALL"){
						tail = 3;
					}else if(prices[i].transportType == "PACKAGE"){
						tail = 4;
					}
					$("#pickup"+tail).text("第"+prices[i].pickTime+"天");
					$("#delivery"+tail).text("第"+prices[i].deliveryTime+"天");
					$("#startPrice"+tail).text(prices[i].startPrice);
					$("#heavyPrice"+tail).text(prices[i].heavyPrice);
					$("#lightPrice"+tail).text(prices[i].lightPrice);
					$("#remark"+tail).text(prices[i].reamrk);
					//如果有这个数据，才显示
					if(prices[i].exist == 0){
						$("#price"+tail).removeClass("hide");
					}
				}
				$("#price_time").removeClass("hide");
				$("#price_cale").removeClass("show").addClass("hide");
				$("#trans_illustrate").removeClass("show").addClass("hide");
			} else {
				alert(data.message);
			}
		},
		serror : function(data) {
			alert("对不起，系统繁忙,请稍后操作！");
		}
	});
}

/**
 * 输入框验证
 * @param id
 * @param operation
 * @param whichOne
 */
function initval(id, operation, whichOne) {
	var vs = $("#"+id).val();
	var setv;
	switch(whichOne){
	case 0:
		setv = setLeavedCityName;
		break;
	case 1:
		setv = setArrivedCityName;
		break;
	case 2:
		if(operation == 2){
			validateParam() ;
		}
		setv = setWeight;
		break;
	case 3:
		if(operation == 2){
			//体积
			validateParam() ;
		}
		setv = setVolumn;
		break;
	case 4:
		if(operation == 2){
			//保价
			validateParam() ;
		}
		setv = setInsurance;
		break;
	case 5:
		/*if(operation == 2){
			//代收货款
			validateParam() ;
		}*/
		setv = setCollDeliveryAmount;
		break;
	}
	if(operation==1){
		if(vs==setv){
			$('#'+id).val("");
			$('#'+id).removeClass("grays");
		}
	}
	if(operation==2){
		if(vs.length==0){
			$('#'+id).val(setv);
			$('#'+id).addClass("grays");
		}
	}
}

function validateParam() {
	//重量
	var weight = $("#weight").val();
	if (setWeight == weight || weight == "") {
		$("#tips").text("请输入货物重量!");
		return;
	}else if(weight == 0){
		$("#tips").text("货物重量不能为零!");
		return;
	}else if(isNaN(weight)){
		$("#tips").text("请输入正确的货物重量!");
		return;
	}
	//体积
	var volumn = $("#volumn").val();
	if (setVolumn == volumn || volumn == "") {
		$("#tips").text("请输入货物体积!");
		return;
	}else if(volumn == 0){
		$("#tips").text("货物体积不能为零!");
		return ;
	}else if(isNaN(volumn)){
		$("#tips").text("请输入正确的货物体积!");
		return ;
	}
	//保价
	var insurance = $("#insurance").val();
	if (setInsurance == insurance || insurance == "") {
		$("#tips").text("请输入货物保价!");
		return;
	}else if(isNaN(insurance)){
		$("#tips").text("请输入正确的保价金额!");
		return;
	}
	//代收货款
/*	var collDeliveryAmount = $("#collDeliveryAmount").val();
	if(collDeliveryAmount != null && collDeliveryAmount != '' && Number(collDeliveryAmount) > 100){
		$("#tips").text("代收货款最大只能输入100!");
		return;
	}*/
	
	$("#tips").text("");
	 
}