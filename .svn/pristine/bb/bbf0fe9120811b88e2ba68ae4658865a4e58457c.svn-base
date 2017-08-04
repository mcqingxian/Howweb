var submitSuccess = false;
var provinceSelected = "";
jQuery(function($){
	/*
	 *  获取当前位置 省市区
	 * 
	 * */
	var province = null;
	var city = null;
	var district = null;
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
			                	 district = result.addressComponents.district;
			                  }      
			});
		});
	} else {
		alert("Geolocation is not supported by this browser.");
	}
	
	/**------------------------------------------------------------------------------------------
	 * 新增联系人相关操作
	 */
	//获取联系人类型
	var type;
	//获取id
	var id = $('#ebsaId').html();
	if(id!=''){
		$('title').html('修改联系人')
		$('#pageTitle').html('修改联系人')
		type = $('#type').data('update');
	}else{
		$('title').html('新增地址')
		$('#pageTitle').html('新增地址')
		type = $('#type').data('add');
	}
	if(type=='shipper'){
		$("#type").val('发货联系人');
		$("#contactName").html('<span class="f_yellow">*</span>发货人:')
		$('#address').html('<span class="f_yellow">*</span>发货地址:')
	}else{
		$('#shipperSlwd_text').hide();
		$('#company_text').hide();
		$("#type").val('收货联系人');
		$("#contactName").html('<span class="f_yellow">*</span>收货人:');
		$('#address').html('<span class="f_yellow">*</span>收货地址:')
	}
	 
	// 受理网点添加获取焦点监听事件
	$("#shipperSlwd").click(
			function() {
				queryListByAddress("shipper_branches_query",
						"shipper_branches","add");
	});
	//受理网点返回按钮
	$("#shipper_branches_back").click(function(){
		$.mobile.changePage("#add", {
			transition : "none",
			changeHash : false
		});
	});
	// 向表单省市区设置值
	$("#getPosition").click(function(){
		if(province!=null&&city!=null){
			$("#pro_city_cty").val(province+"-"+city+"-"+district);
		}
	});
	
	// 取消
	$("#cancel").click(function() {
		window.location.href="addressBookManage.action";
    });
	//重置
	$('#reset').on('click',function(){
		$('#submitparam').find('li>input').each(function(){
			$(this).val('');
		});
	});
    // 新增联系人
    $("#addOrUpdate").click(function() {
    	var name = $("#name").val();
    	if(name==''||name.length==0){
    		checkParams('联系人不能为空');
			return;
		}else if(name.length>20){
			checkParams('姓名大于20个字符');
			return;
		}
    	var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
    	var phone = $.trim($("#phone").val());
    	//联系人地址区号
    	var contactareacode = $('#areacode').val();
    	var telphone = $('#tel').val();
    	var tel = '';
    	if(contactareacode!=''||telphone!=''){
    		tel = $.trim(contactareacode+'-'+telphone);
    	}
    	
    	if(phone.length==0&&tel.length==0){
    		checkParams('手机号和固定电话至少填一项');
			return;
    	}else if(phone.length!=0&&(tel.length!=0&&tel!='-')){
			if(!isMobile(phone)){
        		checkParams('手机号输入有误');
    			return;
    		}
			if(!reg.test(tel)){
				checkParams("请输入正确固定电话号码");
				return;
			}
    	}else if(phone.length!=0&&tel.length==0){
    		if(!isMobile(phone)){
        		checkParams('手机号输入有误');
    			return;
    		}
    	}else if(phone.length==0&&(tel.length!=0&&tel!='-')){
    		if(!reg.test(tel)){
				checkParams("请输入正确固定电话号码");
				return;
			}
    	}
    	var pcc = $("#pro_city_cty").val();
    	var pccsplit = pcc.split('-');
    	if(pcc==''||pcc.length==0){
    		checkParams('发货地址不能为空');
			return;
		}
    	var address = $.trim($("#detail_address").val());
    	if(address.length==0){
    		checkParams('详细地址不能为空');
			return;
		}else if(address.length>100){
			checkParams('地址不能大于100个字符');
    		return;
		}
    	
    	var company = $('#company').val();
    	var ebsaEscoSecondCode = $('#shipperSlwd_code').val();
    	var ebsaEscoSecondName = $('#shipperSlwd').val();
    	
    	var params = {
    			"contactsEntity.ebsaId":id,
				"contactsEntity.ebsaType":type,
				"contactsEntity.ebsaContact":name,
				"contactsEntity.ebsaMobile":phone,
				"contactsEntity.ebsaContactAreaCode":contactareacode,
				"contactsEntity.ebsaContactTel":telphone,
				"contactsEntity.ebsaCompany":company,
				"contactsEntity.ebsaEbpvName":pccsplit[0],
				"contactsEntity.ebsaEbplName":pccsplit[1],
				"contactsEntity.ebsaEbcoName":pccsplit[2],
				"contactsEntity.ebsaAddress":address,
				"contactsEntity.ebsaDeptDistrict":pcc,
				"contactsEntity.ebsaEscoSecondCode":ebsaEscoSecondCode,
				"contactsEntity.ebsaEscoSecondName":ebsaEscoSecondName
		 }
    	$.post("addressMgtAction!addOrUpdateContacts.action",params,function(data,status){
    	 },'json').done(function(data){
			    $("#msg_dialog_con").empty();
    		 	submitSuccess = true;
    		 	$("#addOrUpdate").removeAttr("disabled");
    		 	$("#msg_dialog_con").append(data.message);
    	 }).fail(function(data){
    		 $("#msg_dialog_con").empty();
    		 submitSuccess = false;
    		 $("#msg_dialog_con").append("保存失败");
    	 });
    	 $.mobile.changePage('#msg_dialog', 'flip', true, true);
	});
    
    $(document).on('pagehide','#msg_dialog',function(){
    	if(submitSuccess){
    		if(type=="shipper"){
    			window.location.href="addressBookManage.action";
    		}else{
    			window.location.href = "addressBookManage.action#receiver";
    		}
    		
    	}
    });
    
    
    $("#pro_city_cty").click(function(){
    	queryProvince("depart_province_query",
				"depart_provinces", "depart_city_query",
				"depart_citys", "add",
				"pro_city_cty", "depart_county_query",
				"depart_countys");
    });
    
	$("#depart_province_back").click(function(){
		$.mobile.changePage("#add", {
			transition : "fip",
			changeHash : false
		});
	});
	$("#depart_city_back").click(function(){
		queryProvince("depart_province_query",
				"depart_provinces", "depart_city_query",
				"depart_citys", "add",
				"pro_city_cty", "depart_county_query",
				"depart_countys");
	});
	// 出发区域返回按钮添加事件
	$("#depart_county_back").click(
			function() {
				queryCity(provinceSelected,provinceNameSelected, "depart_city_query",
						"depart_citys", "add",
						"pro_city_cty", "depart_county_query",
						"depart_countys", "departEndpointID");
	});
	
	 //校验手机号码：必须以数字开头，除数字外，可含有“-”
    function isMobile(s){
        var reg =/^(13[0-9]|15[0-9]|15[0-9]|18[0-8])[0-9]{8}$/;
        var check=false;
        if (reg.test(s.trim()))
        	check=true;
        return check;
    }
});


//查询省
function queryProvince(provincePage, provinces, cityPage, citys, finishPage,
		finalCity, countyPage, countys) {
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
				$("#" + provinces).append("<li p="+value+">" + value + "</li>");
				$("#" + provinces).listview('refresh');
			});
			// 添加点击大区监听事件：跳转至城市界面
			$("#" + provinces + " li").click(function() {
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
function queryCity(province,provinceName, cityPage, citys, finishPage, finalCity,countyPage, countys){
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
				$("#" + citys).append("<li p="+value+">" + value + "</li>");
				$("#" + citys).listview('refresh');
			});
			$("#" + citys + " li").click(function() {
						var city = $(this).attr("p");
						var cityName = $(this).html();
						queryCounty(provinceName, cityPage, citys, city,cityName, finishPage,
								finalCity, countyPage, countys);
			});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
}
// 查询区县
function queryCounty(provinceName, cityPage, citys, city,cityName, finishPage,
		finalCity, countyPage, countys) {
	showLoader();
	$("#" + countys).empty();
	$.ajax({
		url:"queryCountyInfoByProvinceCity.action",
		type:"POST",
		async:true,
		data:{
			province : provinceName,
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
								provinceName + "-" + cityName + "-" + $(this).html());
					});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
}

function queryListByAddress(shipper_branches_query,shipper_branches,finishPage) {
	var pcc = $("#pro_city_cty").val();
	$("#" + shipper_branches).empty();
	if (pcc == undefined || pcc == "" || pcc == null) {
		checkParams("发货地址不能为空");
		return;
	}
	var newpcc = pcc.split("-")[0]+' '+pcc.split("-")[1]+' '+pcc.split("-")[2]
	var city = newpcc[1];
	var myGeo = new BMap.Geocoder();
	var addresss = $("#detail_address").val();
	// 将地址解析结果显示在地图上，并调整地图视野
	myGeo.getPoint(newpcc+addresss, function(point) {
			lon = point.lng;
			lat = point.lat;
		$.ajax({
			url : "companyMatchAction!queryDeptByDistrictNameJson.action",
			type : "POST",
			async : true,
			data : {
				pro_city_cty : newpcc,
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
				$.each(data.departmentVos, function(i, value) {
					$("#" + shipper_branches).append(setShipperSlwdTable(i,value));
					$("#" + shipper_branches).listview('refresh');
				});
				
				$("#" + shipper_branches + "> li").click(
					function() {
						$.mobile.changePage("#" + finishPage, {
							transition : "none",
							changeHash : false
						});
						 $("#shipperSlwd").val(data.departmentVos[$(this).attr("p")].deptName);
						 $("#shipperSlwd_code").val(data.departmentVos[$(this).attr("p")].logistCode);
				});
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				hideLoader();
				errorDialog();
			}
		});
	}, city);
}

function setShipperSlwdTable(i,value){
	/*var ywfw = "";
	if(value.shipment)
		ywfw = ywfw + "可发货、";
	if(value.pickUp)
		ywfw = ywfw + "可自提、";
	if(value.delivery)
		ywfw = ywfw + "可送货、";
	ywfw = ywfw.substring(0,(ywfw.length-1));*/
	var phone = value.phone;
	var areaCode = value.areaCode;
	if(areaCode != null && areaCode != ""){
		areaCode = areaCode + "-";
	}else{
		areaCode = "";
	}
	phone = areaCode + phone;
	var data =  '<li p="'+i+'">'+ 
				'<h3>'+value.deptName+'</h3>'+
				'<span>网点代码：'+value.logistCode+'</span> <br />'+
				'<span>业务范围：'+value.serviceName+'</span> <br />'+
				'<span>门店地址：'+value.addressDetail+'</span> <br />'+
				'<span>电话：'+phone+'</span> <br />'+
				/*'<span>距离：'+value.directDistance+'千米</span>'+*/
				'</li>';
	return data;
}


function checkParams(msg){
	 $("#msg_dialog_con").empty();
	 $("#msg_dialog_con").append("<h>"+msg+"</h>");
	 $.mobile.changePage('#msg_dialog', 'flip', true, true);
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