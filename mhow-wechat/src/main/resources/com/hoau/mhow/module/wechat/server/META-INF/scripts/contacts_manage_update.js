$(document).ready(function(e) {
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
	 * 修改联系人相关操作
	 * 
	 * 
	 */
    // 向表单省市区设置值
	$("#getPosition").click(function(){
		$("#pro_city_cty").val(province+" "+city+" "+district);
	});
	// 删除
	$("#delete_btn").click(function() {
		if(confirm("删除是不可恢复的，你确认要删除吗？")){
			var ids = [];
			ids.push($("#delete_id").text());
			$(this).attr("disabled","disabled");
			$.post('addressMgtAction!deleteContacts.action',{"contactIds":ids},function(){
	  			  
			},'json').done(function(data){
				  $("#delete_btn").removeAttr("disabled");
				  $("#msg_dialog_con").empty();
				  $("#msg_dialog_con").append("<h>"+data.message+"</h>");
				  $.mobile.changePage('#msg_dialog', 'flip', true, true);
				  $("#dialogClose").click(function() {
						$('#msg_dialog').dialog('close');
				  });
			}).fail(function(data){
				
			});
		}
    });

    // 更新联系人
    $("#update_btn").click(function() {
    	//获取联系人类型
    	var contact_id = $("#update_id").text();
    	var name = $("#name").val();
    	if(!checkLength(name,20)){
			checkParams('姓名小于20个字符且不能为空');
			return;
		}
    	var phone = $("#phone").val();
    	if(!isMobile(phone)){
    		checkParams('手机号不能为空');
			return;
		}
    	var detail_address = $("#detail_address").val();
    	if(!checkLength(detail_address,100)){
    		checkParams('地址小于100个字符且不能为空');
			return;
		}
    	
    	var pcc = $("#pro_city_cty").val().split(' ');
    	$("#update_btn").attr("disabled","disabled");
    	$.post("addressMgtAction!updateContacts.action",
    			  {
		    		"contactsEntity.ebsaId":contact_id,
					"contactsEntity.ebsaContact":name,
					"contactsEntity.ebsaMobile":phone,
					"contactsEntity.ebsaEbpvName":pcc[0],
    				"contactsEntity.ebsaEbplName":pcc[1],
    				"contactsEntity.ebsaEbcoName":pcc[2],
					"contactsEntity.ebsaAddress":detail_address
    			  },
    			  function(data,status){
    				  $("#delete_btn").removeAttr("disabled");
    				  $("#msg_dialog_con").empty();
    				  $("#msg_dialog_con").append("<h>"+data.message+"</h>");
    				  $.mobile.changePage('#msg_dialog', 'flip', true, true);
    				  $("#dialogClose").click(function() {
    						$('#msg_dialog').dialog('close');
    				  });
    			    $("#update_btn").removeAttr("disabled");
    			  });
    });
    
  //校验手机号码：必须以数字开头，除数字外，可含有“-”
    function isMobile(s){
        var reg =/^(13[0-9]|15[0-9]|15[0-9]|18[0-8])[0-9]{8}$/;
        var check=false;
        if (reg.test(s.trim()))
        	check=true;
        return check;
    }
    
    function checkLength(valiCode,length){
		var len = valiCode.trim().length;
		if(len > length){
			return false;
		}
		return true;
	}
    
    $("#pro_city_cty").click(function(){
    	queryProvince("depart_province_query",
				"depart_provinces", "depart_city_query",
				"depart_citys", "update",
				"pro_city_cty", "depart_county_query",
				"depart_countys");
    });
	$("#depart_province_back").click(function(){
		$.mobile.changePage("#update", {
			transition : "none",
			changeHash : false
		});
	});
	$("#depart_city_back").click(function(){
		queryProvince("depart_province_query",
				"depart_provinces", "depart_city_query",
				"depart_citys", "update",
				"pro_city_cty", "depart_county_query",
				"depart_countys");
	});
	// 出发区域返回按钮添加事件
	$("#depart_county_back").click(
			function() {
				queryCity(provinceSelected, "depart_city_query",
						"depart_citys", "update",
						"pro_city_cty", "depart_county_query",
						"depart_countys");
			});
});
//查询省
function queryProvince(provincePage, provinces, cityPage, citys, finishPage,
		finalCity, countyPage, countys) {
	showLoader();
	$("#" + provinces).empty();
	$.ajax({
		url:"getRegion.action",
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
								countyPage, countys);
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
		countyPage, countys) {
	showLoader();
	$("#" + citys).empty();
	$.ajax({
		url:"queryCity.action",
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
								finalCity, countyPage, countys);
					});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	  $("#pro_city_cty").click(function(){
	    	queryProvince("depart_province_query",
					"depart_provinces", "depart_city_query",
					"depart_citys", "update",
					"pro_city_cty", "depart_county_query",
					"depart_countys");
	    });
	  $("#depart_province_back").click(function(){
			$.mobile.changePage("#update", {
				transition : "none",
				changeHash : false
			});
		});
		$("#depart_city_back").click(function(){
			queryProvince("depart_province_query",
					"depart_provinces", "depart_city_query",
					"depart_citys", "update",
					"pro_city_cty", "depart_county_query",
					"depart_countys");
		});
		// 出发区域返回按钮添加事件
		$("#depart_county_back").click(
				function() {
					queryCity(provinceSelected, "depart_city_query",
							"depart_citys", "update",
							"pro_city_cty", "depart_county_query",
							"depart_countys", "departEndpointID");
				});
}
// 查询区县
function queryCounty(province, cityPage, citys, city, finishPage, finalCity,
		countyPage, countys) {
	showLoader();
	$("#" + countys).empty();
	$.ajax({
		url:"queryCounty.action",
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
				if (value.countyName !== null && value.countyName !== undefined
						&& value.countyName !== '') {
					$("#" + countys).append("<li>" + value.countyName + "</li>");
					$("#" + countys).listview('refresh');
				} else {
					$("#" + countys).append("<li>" + value.endpointName + "</li>");
					$("#" + countys).listview('refresh');
				}
				
			});
			$("#" + countys + " li").click(
					function() {
						$.mobile.changePage("#" + finishPage, {
							transition : "none",
							changeHash : false
						});
						$("#" + finalCity).val(
								province + " " + city + " " + $(this).html());
					});

		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			hideLoader();
			errorDialog();
		}
	});
	
	

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

function checkParams(msg){
	 $("#dialg_header").html();
	 $("#msg_dialog_con").empty();
	 $("#msg_dialog_con").append("<h>"+msg+"</h>");
	 $.mobile.changePage('#msg_dialog', 'flip', true, true);
}
