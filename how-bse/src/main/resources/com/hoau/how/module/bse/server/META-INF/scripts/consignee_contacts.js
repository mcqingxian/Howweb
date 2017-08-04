/**
 * 
 */
$(document).ready(function() {
	$("#search").click(function(){
		var queryKeyword = $(this).prev().val();
		if(queryKeyword == "搜索姓名或联系方式"){
			queryKeyword = '';
		}
		var encodeKey = encodeURI(queryKeyword);
		window.location.href = "contacts_consigneeManage.action?contactsType=consignee&queryKeyword="+encodeKey;
	});

	//省市区选择 输入框改变 加载 网点  （修改时）
	$("#shipper_update_dept_district").change(function(){
		var typeValue = $("#shipper_update_dept_district").val();
		if(typeValue == null || typeValue.indexOf("-") < 0) return;
		var url = "companyMatchAction!queryDeptByDistrictNameJson.action";
		$.post(url,{
			typeValue:typeValue
		},function(data,status){
	    	if(status == 'success' && data.success == false){
	    		update_errTips(data.message)
	    	}else{
	    		var array = data.departmentVos;
	    		$("#shipper_update_dept_name").empty();
	    		for(var i = 0; i < array.length; i++){
	    			var dept = array[i];
	    			var deptCode = dept.deptCode;
	    			var deptName = dept.deptName;
	    			$("<option value='"+dept.deptCode+"'>"+deptName+"</option>").appendTo("#shipper_update_dept_name")
	    		}
		    }
	    });
	});
	
	//新增联系人   发货
	$("#shipper_add_btn").click(function(){
		var shipper_name = $("#shipper_name").val();//发货人姓名
		
		if(shipper_name.length > 20){
			add_errTips("姓名最多为20个字符");return;
		}
		if($.trim(shipper_name) == ""){
			add_errTips("姓名不能为空");return;
		}
		var shipper_mobile = $("#shipper_mobile").val();//发货人手机号码
		var shipper_telephone_area_no = $("#shipper_telephone_area_no").val();//发货人座机区号
		var shipper_telephone = $("#shipper_telephone").val();//发货人座机
		
		//---------------------------------电话校验
		var tel = shipper_telephone_area_no +"-"+shipper_telephone;
		if(isBlank(shipper_mobile) && tel == "-"){
			add_errTips("手机和固定电话至少填一项");return;
		}
		if(!isBlank(tel) && tel != "-"){
			var reg = /^0\d{2,3}-\d{5,9}|0\d{2,3}-\d{5,9}$/;
			if(!reg.test(tel)){
				add_errTips("请输入正确固定电话号码");return;
			}
		}
		if(!isBlank(shipper_mobile)){
			var par=/^1[2,3,4,5,6,7,8,9]{1}[0-9]{1}[0-9]{8}$/;
			if(!par.test(shipper_mobile)){
				add_errTips("请输入正确的手机号码");return;
			}
		}
		//---------------------------------
		
		
		var shipper_district = $("#shipper_district").val();//发货人省市区
		if(shipper_district == "请选择城市名称" || isBlank(shipper_district)){
			add_errTips("发货地址省市区不能空");return;
		}
		
		var shipper_address_detail = $("#shipper_address_detail").val();// 发货人地址详细信息
		if(isBlank(shipper_address_detail)){
			add_errTips("详细地址不能为空");return;
		}
		if(shipper_address_detail.length > 100){
			add_errTips("详细地址最多为100个字符");return;
		}
		
		var pcd = shipper_district.split('-');
		$.post("addContacts.action",{
				    "contactsEntity.ebsaContact":shipper_name,
				    "contactsEntity.ebsaMobile":shipper_mobile,
				    "contactsEntity.ebsaContactAreaCode":shipper_telephone_area_no,
				    "contactsEntity.ebsaContactTel":shipper_telephone,
				    "contactsEntity.ebsaEbpvName":pcd[0],
				    "contactsEntity.ebsaEbplName":pcd[1],
				    "contactsEntity.ebsaEbcoName":pcd[2],
				    "contactsEntity.ebsaAddress":shipper_address_detail,
				    "contactsEntity.ebsaType":"consignee"
			  },
			  function(data,status){
				  if(status == 'success' && data.success == false){
					  add_errTips(data.message)
				  }else{
					  //TODO XUJUN
					  window.location.href = "contacts_consigneeManage.action";
				  }
			  });
	});
	
	
	$("#searchContacts").click(function(){
		var value = $("#searchContacts").val();
		window.location.href = "search.action?value="+value;
	});
	
	//修改联系人   发货
	$("#shipper_update_save_btn").click(function(){
		var shipper_name = $("#shipper_update_name").val();//发货人姓名
		if(shipper_name.length > 20){
			update_errTips("姓名最多为20个字符");return;
		}
		if($.trim(shipper_name) == ""){
			update_errTips("姓名不能为空");return;
		}
		
		var shipper_mobile = $("#shipper_update_mobile").val();//发货人手机号码
		var shipper_telephone_area_no = $("#shipper_update_telephone_area_no").val();//发货人座机区号
		var shipper_telephone = $("#shipper_update_telephone").val();//发货人座机
		//---------------------------------电话校验
		var tel = shipper_telephone_area_no +"-"+shipper_telephone;
		if(isBlank(shipper_mobile) && tel == "-"){
			update_errTips("手机和固定电话至少填一项");return;
		}
		if(!isBlank(tel) && tel != "-"){
			var reg = /^0\d{2,3}-\d{5,9}|0\d{2,3}-\d{5,9}$/;
			if(!reg.test(tel)){
				update_errTips("请输入正确固定电话号码");return;
			}
		}
		if(!isBlank(shipper_mobile)){
			var par=/^1[2,3,4,5,6,7,8,9]{1}[0-9]{1}[0-9]{8}$/;
			if(!par.test(shipper_mobile)){
				update_errTips("请输入正确的手机号码");return;
			}
		}
		//---------------------------------
		
		
		var shipper_district = $("#shipper_update_district").val();//发货人省市区
		var pcd = shipper_district.split('-');
		if(shipper_district == "请选择城市名称" || isBlank(shipper_district)){
			update_errTips("发货地址省市区不能空");return;
		}
		
		var shipper_address_detail = $("#shipper_update_address_detail").val();// 发货人地址详细信息
		if(isBlank(shipper_address_detail)){
			update_errTips("详细地址不能为空");return;
		}
		if(shipper_address_detail.length > 100){
			update_errTips("详细地址最多为100个字符");return;
		}
		
		var contactsId = $("#ebsa_id").text();
		$.post("updateContacts.action",{
				"contactsEntity.ebsaId":contactsId,
				"contactsEntity.ebsaContact":shipper_name,
			    "contactsEntity.ebsaMobile":shipper_mobile,
			    "contactsEntity.ebsaContactAreaCode":shipper_telephone_area_no,
			    "contactsEntity.ebsaContactTel":shipper_telephone,
			    "contactsEntity.ebsaEbpvName":pcd[0],
			    "contactsEntity.ebsaEbplName":pcd[1],
			    "contactsEntity.ebsaEbcoName":pcd[2],
			    "contactsEntity.ebsaAddress":shipper_address_detail,
			    "contactsEntity.ebsaType":"consignee"
			  },
			  function(data,status){
				  if(status == 'success' && data.success == false){
					  update_errTips(data.message)
				  }else{
					  //TODO XUJUN
					  window.location.href = "contacts_consigneeManage.action";
				  }
			  });
	});
	
	
	//全选
	$("#selectAll").change(function(){
		if($(this).attr("checked")){
			$("[name = checkItem]:checkbox").attr("checked", true);
		}else{
			$("[name = checkItem]:checkbox").attr("checked", false);
		}
	});			
	
	
	//删除所选
	$("#delQuery").click(function(){
		var array = getIdsArray();
		if(array.length == 0) return;
		delContacts(array.join(";"));
	});			
	
	//导出所有
	$("#exportAll").click(function(){
		var contactsIds = getIdsArray().join(";");
		var url = window.location.href;
		var contactsType;
		if(url.indexOf("shipperManage") > 0){
			contactsType = "shipper";
		}else{
			contactsType = "consignee"
		}
		window.location.href = "export.action?contactsIds=" + contactsIds + "&contactsType=" + contactsType;
	});	
		
	//设为默认联系人
	$(".btn-setdefault").click(function(){
		//判断是否已经是默认 如果是 就不进行任何操作//TODO XUJUN
		
		//如果选中的非默认 就进行默认设置
		var id = $(this).parent().find("span").text();
		var url = "setDefaultContacts.action?contactsIds=" + id +"&contactsType=consignee";
		$.get(url,function(data,status){
	    	if(status == 'success' && data.success == false){
	    		//TODO 异常处理
	    	}else{
	    		window.location.href = "contacts_consigneeManage.action";
		    }
	    });
	});
	//编辑联系人
	$(".btn-edite").click(function(){
		var id = $(this).parent().find("span").text();
		var url = "queryByIdContacts.action?contactsIds=" + id;
		$.get(url,function(data,status){
	    	if(status == 'success' && data.success == false){
	    		//TODO 异常处理
	    	}else{
	    		var contacts = data.contactsEntity;
	    		
	    		$("#ebsa_id").text(contacts.ebsaId);
	    		//给界面表单元素赋值
	    		$("#shipper_update_name").val(contacts.ebsaContact);//发货人姓名
	    		$("#shipper_update_mobile").val(contacts.ebsaMobile);//发货人手机号码
	    		$("#shipper_update_telephone_area_no").val(contacts.ebsaContactAreaCode);//发货人座机区号
	    		$("#shipper_update_telephone").val(contacts.ebsaContactTel);//发货人座机
	    		$("#shipper_update_district").val(contacts.ebsaEbpvName+"-"+contacts.ebsaEbplName+"-"+contacts.ebsaEbcoName);//发货人省市区
	    		$("#shipper_update_address_detail").val(contacts.ebsaAddress);// 发货人地址详细信息
	    		//TODO 网点对应省市区  待完善
	    		$("#shipper_update_dept_district").val(contacts.ebsaDeptDistrict);//发货网点所对应省市区
	    		//发货网点名称
	    		$("#shipper_update_dept_name").empty();
	    		$("<option value='"+contacts.ebsaEscoSecondCode+"'>"+contacts.ebsaEscoSecondName+"</option>").appendTo("#shipper_update_dept_name")
	    		//删除灰色字体样式
	    		$("#shipper_update_district").removeClass("grays");
		    }
	    });
		
		easyDialog.open({
			container : 'easyDialogWrapper_update',
			fixed : false
		});
	});
	
	//删除联系人
	$(".btn-delete").click(function(){
		var id = $(this).parent().find("span").text();
		delContacts(id);
	});
});

//删除联系人
function delContacts(id){
	easyDialog.open({
		container : 'DelWrapper',
		fixed : true
	});
	$("#shipper_add_btn_confirm").click(function(){
		$.post("deleteContacts.action",{
			contactsIds:id,
	    },
	    function(data,status){
	    	if(status == 'success' && data.success == false){
	    	}else{
	    		window.location.href = "contacts_consigneeManage.action";
		    }
	    });
	});
}

//导出联系人  //TODO  XUJUN	完善
function exportContacts(id){
	$.post("exportContacts.action",{
		contactsIds:id,
    },
    function(data,status){
    	if(status == 'success' && data.success == false){
    	}else{
    		window.location.href = "contacts_consigneeManage.action";
	    }
    });
}

//获得选中的checkbox所对应的ID 数组
function getIdsArray(){
	var $chk = $("[name = checkItem]:checkbox");
	var array = new Array();
	
	$chk.each(function(){
		var cur = this;
		if($(cur).attr("checked")){
			var id = $(cur).parent().find("span").text();
			array.push(id);
		}
	});
	return array;
}

function add_errTips(msg){
	$("#easyDialogWrapper .erro").show();
	$("#easyDialogWrapper .erro_msg").text(msg)
}

function update_errTips(msg){
	$("#easyDialogWrapper_update .erro").show();
	$("#easyDialogWrapper_update .erro_msg").text(msg)
}
function isBlank(str){
	if($.trim(str) == "" || str == null) return true;
	return false;
}

