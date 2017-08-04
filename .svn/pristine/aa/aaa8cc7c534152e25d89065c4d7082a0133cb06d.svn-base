$(function(){
	var provinceId = "#selProvince";
	$.post("franchiseAction!queryFranchiseProvinceJson.action",{
		},
		function(data, status) {
			var provinces = data.franchiseInfoProvinces;
			if(provinces == null){
				return;
			}
			$(provinceId).html("");
			$("<option value='-1'>请选择省</option>").appendTo(provinceId);
			for(var i = 0 ;i < provinces.length ; i ++){
				$("<option value='"+provinces[i].pname+"'>"+provinces[i].pname+"</option>").appendTo(provinceId);
			}
		}
	);
});

function queryFranchiseInfo(){
	var province = $("#selProvince").val();
	var city = $("#selCity").val();
	if("" == province || "-1" == province){
		alert("请选择省");
		return;
	}
	if("" == city || "-1" == city){
		alert("请选择市");
		return;
	}
	
	$.post("franchiseAction!queryFranchiseInfoJson.action",{
		"franchiseInfoEntity.province": province,
		"franchiseInfoEntity.city":city
	},
	function(data, status) {
		var franchiseInfo = data.franchiseInfoEntity;
		if(franchiseInfo == null){
			$("#tdContacts").html("暂无区域负责人信息！");
			$("#tdPhone").html("");
			$("#tdEmail").html("");
			return;
		}
		$("#tdContacts").html("联系人："+franchiseInfo.contacts);
		$("#tdPhone").html("联系人手机："+franchiseInfo.phone);
		$("#tdEmail").html("联系人邮箱："+franchiseInfo.email);
	});
}

function changeProvince(obj){
	var province = $(obj).val();
	var cityId = "#selCity";
	$.post("franchiseAction!queryFranchiseCityJson.action",{
			"province": province
		},
		function(data, status) {
			var citys = data.franchiseInfoCitys;
			if(citys == null){
				return;
			}
			$(cityId).html("");
			$("<option value='-1'>请选择市</option>").appendTo(cityId);
			for(var i = 0 ;i < citys.length ; i ++){
				$("<option value='"+citys[i].cname+"'>"+citys[i].cname+"</option>").appendTo(cityId);
			}
		}
	);
}