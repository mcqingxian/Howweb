$(window).load(function() {
	$("#mapBtn").click(function(){
		var val = $("#entity\\.einoEscoSecondCode").val();
		if(-1 == val){
			$("#companyMsg").html("请先选择网点！");
		}else{
			var sl = $("#entity\\.einoEscoSecondCode").find("option:selected");
			var code = sl.val();
			if(code == null || code == "null"){
				$("#companyMsg").html("请先选择网点！");
			}else{
				var path = "companyScreenAction!queryCompanyDetail.action?code="+code;
				window.open(path);
			}
		}
	});
	
	//选择发货人加载数据
	$("#sel_consigner").click(function(){
		showShipperGrid(1);
	});
	//发货人下一页
	$("#shipper_next_page").click(function(){
		var curent_page = $("#shipper_curent_page").text();
		var total_page = $("#shipper_total_page").text();
		if(curent_page >= total_page) return;
		var pageNo = Number(curent_page) + 1;
		showShipperGrid(pageNo);
	});
	//发货人上一页
	$("#Shipper_PrePage").click(function(){
		var curent_page = $("#shipper_curent_page").text();
		var total_page = $("#shipper_total_page").text();
		if(curent_page <= 1) return;
		var pageNo = Number(curent_page) - 1;
		showShipperGrid(pageNo);
	});
	//到第几页
	$("#shipper_go").click(function(){
		var total_page = $("#shipper_total_page").text();
		var shipper_go_page_no = $("#shipper_go_page_no").val();
		if(isNaN(shipper_go_page_no)) return; //输入值不是数字
		if(shipper_go_page_no < 1 || shipper_go_page_no > total_page) return;
		showShipperGrid(shipper_go_page_no);
	});
});

$(document).ready(function() {
	var einoSecondDistrict = $("#entity\\.einoSecondDistrict").val();
	var einoEscoSecondCode = $("#einoEscoSecondCode").val();
	if(einoSecondDistrict != "" && einoSecondDistrict != $("#entity\\.einoSecondDistrict").attr("ov")){
		loadSecondDistrict("#entity\\.einoSecondDistrict",einoEscoSecondCode);
	}
});

function synSecondDistrict(input){
	$("#entity\\.einoSecondDistrict").removeClass("grays");
	$("#entity\\.einoSecondDistrict").val($(input).val());
	$("#entity\\.einoSecondDistrict").change();
}

/**
 * 加载网点
 * @param input
 * @author 莫涛
 * @date 2015年7月28日
 * @update
 */
function loadSecondDistrict(input,logistCode){
	var val = input.value;
	var attr = "";
	if(logistCode != null){
		val = $(input).val();
	}
	/*********查询附近部门和分页的********/
	$.post("companyMatchAction!queryDeptByDistrictNameJson.action",{
		"typeValue" : val
		},
		function(data, status) {
			var departmentVos = data.departmentVos;
			if(departmentVos == null){
				return;
			}
			$("#entity\\.einoEscoSecondCode").html("");
			$("<option value='-1'>请选择网点</option>").appendTo("#entity\\.einoEscoSecondCode");
			for(var i = 0 ;i < departmentVos.length ; i ++){
				if(logistCode != null && logistCode == departmentVos[i].logistCode){
					attr = "selected='selected'";
				}else{
					attr = "";
				}
				$("<option address='"+departmentVos[i].addressDetail+
						"' phone='"+departmentVos[i].phone+
						"' id='"+departmentVos[i].id+
						"' "+attr+" value='"+departmentVos[i].logistCode+
						"'>"+departmentVos[i].deptName+"</option>")
				.appendTo("#entity\\.einoEscoSecondCode");
			}
			if(logistCode != null){
				$("#entity\\.einoEscoSecondCode").change();
			}
				
		}
	);
}

function changeCompany(sel){
	var sl = $(sel).find("option:selected");
	var address = sl.attr("address");
	var phone = sl.attr("phone");
	if(address != null && phone != null){
		$("#companyMsg").html(address + " | " + phone );
		$("#entity\\.einoEscoSecondName").val(sl.html());
	}else{
		$("#companyMsg").html("");
		$("#entity\\.einoEscoSecondName").val("");
	}
}

/**
 * 存为草稿
 * @author 莫涛
 * @date 2015年7月29日
 * @update
 */
function saveDraft(loginType){
	if(loginType == ""){
		setErrorMsg("#success_tips","未登陆不能保存草稿！");
		return;
	}
	$("#orderForm").attr("action","orderAction!saveDraft.action");
	$("#orderForm").submit();
}

function setErrorMsg(id,msg){
	if(msg == ""){
		$(id).html("");
	}else{
		var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
		$(id).html(rs);
	}
}

/**
 * 下一步
 * @author 莫涛
 * @date 2015年7月29日
 * @update
 */
function next(){
	if(!checkShipperEbsaContact()){
		return;
	}
	if(checkMobileAndPhone("#entity\\.einoShipperEbsaMobile","#entity\\.einoShipperEbsaTel","发货人","#shipperEbsaMobile_tips")){
		//单独验证手机
		if(!checkMobile("#entity\\.einoShipperEbsaMobile","发货人","#shipperEbsaMobile_tips")){
			return;
		}
		//单独验证座机
		if(!checkPhone("#entity\\.einoShipperEbsaTel","发货人","#shipperEbsaMobile_tips")){
			return;
		}
	}else{
		return;
	}
	
	if(!checkSecondDistrict()){
		return;
	}

	if(!checkShipperEbsaAddress()){
		return;
	}
	
	//提交订单前，处理一些数据
	var $secondDistrict = $("#entity\\.einoSecondDistrict");
	if($secondDistrict.val() == $secondDistrict.attr("ov")){
		$secondDistrict.val("");
	}
	var $einoShipperEbspNameCn = $("#entity\\.einoShipperEbspNameCn");
	if($einoShipperEbspNameCn.val() == $einoShipperEbspNameCn.attr("ov")){
		$einoShipperEbspNameCn.val("");
	}
	var $remark = $("#entity\\.einoRemark");
	if($remark.val() == $remark.attr("ov")){
		$remark.val("");
	}
	$("#orderForm").submit();
}

function checkShipperEbsaContact(){
	var $shipperContact = $("#entity\\.einoShipperEbsaContact");
	if($shipperContact.val() == ""){
		setErrorMsg("#shipperEbsaContact_tips","发货人不能为空！");
		return false;
	}else{
		setErrorMsg("#shipperEbsaContact_tips","");
	}
	return true;
}

function checkSecondDistrict(){
	var $shipperDistrict = $("#entity\\.shipperDistrict");
	if($shipperDistrict.val() == $shipperDistrict.attr("ov")){
		setErrorMsg("#shipperDistrict_tips","请选择发货人所在省市！");
		return false;
	}else{
		setErrorMsg("#shipperDistrict_tips","");
	}
	return true;
}

function checkShipperEbsaAddress(){
	var $shipperEbsaAddress = $("#entity\\.einoShipperEbsaAddress");
	if($shipperEbsaAddress.val() == $shipperEbsaAddress.attr("ov")){
		setErrorMsg("#shipperDistrict_tips","请输入发货人地址！");
		return false;
	}else{
		setErrorMsg("#shipperDistrict_tips","");
	}
	return true;
}

function checkMobile(id,msg,tipsId){
	var $mobile = $(id);
	if($mobile.val() != ""){
	 	if(!isMobile($mobile.val())){
	        setErrorMsg(tipsId,"请输入正确"+msg+"手机号码！");
	        return false;
	    }else{
	    	setErrorMsg(tipsId,"");
	    }
	}
 	return true;
}

function checkPhone(id,msg,tipsId){
	var $tel = $(id);
	if($tel.val() != ""){
		var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		if(reg.test($tel.val())){
			setErrorMsg(tipsId,"");
			return true;
		}else{
			setErrorMsg(tipsId,"请输入正确"+msg+"座机号！");
			return false;
		}
	}else{
		return true;
	}
}

function checkMobileAndPhone(mobileId,phoneId,msg,tipsId){
	var mobile = $(mobileId).val();
	var phone = $(phoneId).val();
	if(mobile == "" && phone == ""){
		setErrorMsg(tipsId,msg+"手机号与座机号，必须填写一项！");
		return false;
	}else{
		setErrorMsg(tipsId,"");
	}
	return true;
}

function checkCargoName(){
	var $cargoName = $("#entity\\.einoCargoName");
	if($cargoName.val() == ""){
		setErrorMsg("#success_tips","货物名称不能为空！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
	}
	return true;
}

//显示发货人信息表格
function showShipperGrid(pageNo){
	var contactType = "shipper";
	var url = "pagingQueryContacts.action?contactsType="+contactType+"&pageNo="+pageNo;
	$.get(url,function(data,status){
		if(status == 'success' && data.success == false){
			window.location.href="login.action?dest=orderAction!index.action";
		}else{
			var table = $("#shipper_data");
			table.empty();
			var head = $(
					'<tr>' +
					'<td width="12%">姓名</td>' +
					'<td width="15%">手机号</td>' +
					'<td width="15%">固话</td>' +
					'<td width="23%">发货地址</td>' +
					'<td width="23%">发货网点</td>' +
					'<td width="12%">操作</td>' +
					'</tr>'
					);
			table.append(head);

			var pageCount = data.paging.pageCount;
			var pageNo = data.paging.pageNo;
			var pageSize = data.paging.pageSize;
			var rowsCount = data.paging.rowsCount;
			var dataArray = data.paging.data;
			
			$("#shipper_curent_page").text(pageNo);
			$("#shipper_total_page").text(pageCount);
			
			var row;
			for(var i = 0; i < dataArray.length; i++){
				var tel='';
				if(!isBlank(dataArray[i].ebsaContactAreaCode)){
					tel = dataArray[i].ebsaContactAreaCode + '-' + dataArray[i].ebsaContactTel;
				}
				row = $(
						'<tr>' +
						'<td>'+dataArray[i].ebsaContact+'</td>' +
						'<td>'+dataArray[i].ebsaMobile+'</td>' +
						'<td>'+tel+'</td>' +
						'<td>'+dataArray[i].ebsaAddress+'</td>' +
						'<td>'+dataArray[i].ebsaEscoSecondName+'</td>' +
						'<td><a href="javascript:void(0)" onclick="loadShipperContacts('+dataArray[i].ebsaId+')">选择</a></td>' +
						'</tr>'
						);
				table.append(row);
			}
			easyDialog.open({
				container : 'easyDialogSel_cons',
				fixed : true
			});
		}
	});
}


//点击选择时，加载发货人数据
function loadShipperContacts(id){
	var url = "queryByIdContacts.action?contactsIds=" + id;
	$.get(url,function(data,status){
    	if(status == 'success' && data.success == false){
    		
    	}else{
    		var contacts = data.contactsEntity;
    		var tel='';
			if(!isBlank(contacts.ebsaContactAreaCode)){
				tel = contacts.ebsaContactAreaCode + '-' + contacts.ebsaContactTel;
			}
    		//给界面表单元素赋值
    		$("#entity\\.einoShipperEbsaContact").val(contacts.ebsaContact);//收货人姓名
    		$("#entity\\.einoShipperEbsaMobile").val(contacts.ebsaMobile);//发货人手机号码
    		$("#entity\\.einoShipperEbsaTel").val(tel);//发货人座机
    		$("#entity\\.shipperDistrict").val(contacts.ebsaEbpvName+"-"+contacts.ebsaEbplName+"-"+contacts.ebsaEbcoName);//发货人省市区
    		$("#entity\\.einoShipperEbsaAddress").val(contacts.ebsaAddress);// 发货人地址详细信息
    		
    		//TODO 网点对应省市区  待完善
    		$("#entity\\.einoSecondDistrict").val(contacts.ebsaDeptDistrict);//发货网点所对应省市区
    		//公司名称
    		$("#entity\\.einoShipperEbspNameCn").val(contacts.ebsaCompany);
    		$("#entity\\.einoShipperEbspNameCn").removeClass("grays");
    		//发货网点名称
    		$("#entity\\.einoEscoSecondCode").empty();
    		$("<option value='"+contacts.ebsaEscoSecondCode+"'>"+contacts.ebsaEscoSecondName+"</option>").appendTo("#entity\\.einoEscoSecondCode");
    		$("#entity\\.einoShipperEbsaAddress").removeClass("grays");
    		$("#entity\\.shipperDistrict").removeClass("grays");
    		$("#entity\\.einoSecondDistrict").removeClass("grays");
    		loadSecondDistrict("#entity\\.einoSecondDistrict",contacts.ebsaEscoSecondCode);
    		easyDialog.close();
	    }
    });
}
