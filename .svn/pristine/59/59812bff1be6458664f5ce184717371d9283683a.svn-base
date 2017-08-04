$(function(){
	$("#demoBtn1").click(function(){
		$("#rdo_ld").siblings("option").attr("disabled",true);
		$("#rdo_ld").attr("selected",true);
		$("#entity\\.einoId").val("");
		$("#singleForm").attr("batchOrderAction!singleOrder.action");
		$("#submit_btn").html("新增");
		var html = $("#operation_order_div").html();
		$("#form_reset_btn").click();
		$("#operation_order_div").html(html.replace("修改","新增"));
		$("#entity\\.consigneeDistrict").addClass("grays");
		easyDialog.open({
			container : 'easyDialogPlxd',
			fixed : true
		});
	});
	
	//收货人下一页
	$("#consignee_NextPage").click(function(){
		var curent_page = $("#consignee_curent_page").text();
		var total_page = $("#consignee_total_page").text();
		if(curent_page >= total_page) return;
		var pageNo = Number(curent_page) + 1;
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(pageNo,key_word);
	});
	
	//收货人上一页
	$("#consignee_PrePage").click(function(){
		var curent_page = $("#consignee_curent_page").text();
		var total_page = $("#consignee_total_page").text();
		if(curent_page <= 1) return;
		var pageNo = Number(curent_page) - 1;
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(pageNo,key_word);
	});
	//到第几页
	$("#consignee_go").click(function(){
		var total_page = $("#consignee_total_page").text();
		var shipper_go_page_no = $("#consignee_go_page_no").val();
		if(isNaN(shipper_go_page_no)) return; //输入值不是数字
		if(shipper_go_page_no < 1 || shipper_go_page_no > total_page) return;
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(shipper_go_page_no,key_word);
	});
	
	//收货人搜索
	$("#search_btn").click(function(){
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(1,key_word);
	});
});

//显示收货人信息表格
function showConsigneeGrid(pageNo,key_word){
	var contactType = "consignee";
	var url = "pagingQueryContacts.action?contactsType="+contactType+"&pageNo="+pageNo+"&queryKeyword="+key_word;
	$.get(url,function(data,status){
		if(status == 'success' && data.success == false){
			window.location.href="login.action?dest=orderAction!index.action";
		}else{
			var table = $("#cons_data");
			table.empty();
			var head = $(
					'<tr>' +
					'<td width="15%">姓名</td>' +
					'<td width="20%">手机号</td>' +
					'<td width="20%">固话</td>' +
					'<td width="30%">收货地址</td>' +
					'<td width="15%">操作</td>' +
					'</tr>'
					);
			table.append(head);
			var pageCount = data.paging.pageCount;
			var pageNo = data.paging.pageNo;
			var pageSize = data.paging.pageSize;
			var rowsCount = data.paging.rowsCount;
			var dataArray = data.paging.data;
			
			$("#consignee_curent_page").text(pageNo);
			$("#consignee_total_page").text(pageCount);
			
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
						'<td><a href="#" onclick="loadConsigneeContacts('+dataArray[i].ebsaId+')">选择</a></td>' +
						'</tr>'
						);
				table.append(row);
			}
			
		}
	});
}

//加载收货人数据
function loadConsigneeContacts(id){
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
    		$("#entity\\.einoConsigneeEbsaContact").val(contacts.ebsaContact);//收货人姓名
    		$("#entity\\.einoConsigneeEbsaMobile").val(contacts.ebsaMobile);//发货人手机号码
    		$("#entity\\.einoConsigneeEbsaTel").val(tel);//发货人座机
    		$("#entity\\.consigneeDistrict").val(contacts.ebsaEbpvName+"-"+contacts.ebsaEbplName+"-"+contacts.ebsaEbcoName);//发货人省市区
    		$("#entity\\.einoConsigneeEbsaAddress").val(contacts.ebsaAddress);// 发货人地址详细信息
    		openOrCloseDialog();
	    }
    	$("#entity\\.consigneeDistrict").change();
    	$("#entity\\.consigneeDistrict").removeClass("grays");
    	$("#entity\\.einoConsigneeEbsaAddress").removeClass("grays");
    });
}

function showDialog(errorType){
	if(errorType == "cbos"){
		easyDialog.open({
			container : 'Dialog_tips02',
			fixed : true
		});
	}
}

function removeOrder(id){
	if (confirm("确认要删除？")) {
		$.post("batchOrderAction!removeOrderJson.action",{
			"entity.einoId" : id
			},
			function(data, status) {
				var msg = encodeURI(data.errorMsg);
				window.location.href = "batchOrderAction!pagingQuery.action?errorMsg="+msg;
			}
		);
    }
}
function findOrderById(id){
	$("#singleForm").attr("action","batchOrderAction!modifyOrder.action");
	$("#submit_btn").html("修改");
	var html = $("#operation_order_div").html();
	$("#operation_order_div").html(html.replace("新增","修改"));
	$("#entity\\.consigneeDistrict").removeClass("grays");
	$.post("batchOrderAction!findOrderByIdJson.action",{
		"entity.einoId" : id
		},
		function(data, status) {
			var vo = data.entity;
			$("#entity\\.einoId").val(id);
			$("#entity\\.einoConsigneeEbsaContact").val(vo.einoConsigneeEbsaContact);
			$("#entity\\.einoConsigneeEbsaMobile").val(vo.einoConsigneeEbsaMobile);
			$("#entity\\.einoConsigneeEbsaTel").val(vo.einoConsigneeEbsaTel);
			$("#entity\\.consigneeDistrict").val(vo.consigneeDistrict);
			$("#entity\\.einoConsigneeEbsaAddress").val(vo.einoConsigneeEbsaAddress);
			$("input[name='entity\\.einoDoorCanvass']").each(function(i,val){
				if(this.value == vo.einoDoorCanvass){
					$(this).attr('checked',true);
				}
			});
			$("#entity\\.einoPaymentMethod").val(vo.einoPaymentMethod);
			$("#entity\\.einoInsurance").val(vo.einoInsurance);
			$("#entity\\.einoCargoName").val(vo.einoCargoName);
			$("#entity\\.einoNumber").val(vo.einoNumber);
			$("#entity\\.einoTotalWeight").val(vo.einoTotalWeight);
			$("#entity\\.einoTotalVolume").val(vo.einoTotalVolume);
			$("#entity\\.einoPackage").val(vo.einoPackage);
			$("#entity\\.einoCollDeliveryAmount").val(vo.einoCollDeliveryAmount);
			$("#entity\\.einoSignBack").val(vo.einoSignBack);
			$("#entity\\.einoRemark").val(vo.einoRemark);
			$("#entity\\.einoRemark").removeClass("grays");
			$("#entity\\.consigneeDistrict").change();
			//选择运输方式之后，送货方式发生联动改变，田育林，2016-05-10
			$("select[name='entity\\.einoProductTypeName']").val(vo.einoProductTypeName);
			changeShipperMethod(vo.einoProductTypeName);
			$("#entity\\.einoShipperMethod").val(vo.einoShipperMethod);
			easyDialog.open({
				container : 'easyDialogPlxd',
				fixed : true
			});
		}
	);
}
function showDetail(id){
	$.post("batchOrderAction!findOrderByIdJson.action",{
		"entity.einoId" : id
		},
		function(data, status) {
			var vo = data.entity;
			$("#detail_consigneeEbsaContact").html(vo.einoConsigneeEbsaContact);
			$("#detail_consigneeEbsaTel").html(vo.einoConsigneeEbsaTel);
			$("#detail_consigneeEbsaMobile").html(vo.einoConsigneeEbsaMobile);
			$("#detail_consigneeEbsaAddress").html(vo.consigneeDistrict + "  " +vo.einoConsigneeEbsaAddress);
			$("#detail_doorCanvass").html(vo.einoDoorCanvass == "Y" ? "是" : "否");
			var shipperMethod = vo.einoShipperMethod;
			if(shipperMethod == "SELF_TAKE"){
				shipperMethod = "客户自提";
			}else if(shipperMethod == "DOORSTEP"){
				shipperMethod = "送货上门";
			}else if(shipperMethod == "UPSTAIR"){
				shipperMethod = "送货上楼";
			}else if(shipperMethod == "INSTALL"){
				shipperMethod = "安装";
			}
			$("#detail_shipperMethod").html(shipperMethod);
			if(vo.einoPaymentMethod == "ARRIVE_PAYMENT"){
				$("#detail_paymentMethod").html("到付");
			}else if(vo.einoPaymentMethod == "CASH"){
				$("#detail_paymentMethod").html("现付");
			}else if(vo.einoPaymentMethod == "Monthly_Statement"){
				$("#detail_paymentMethod").html("月结");
			}
			$("#detail_cargoName").html(vo.einoCargoName);
			$("#detail_number").html(vo.einoNumber);
			$("#detail_insurance").html(vo.einoInsurance);
			$("#detail_totalWeight").html(vo.einoTotalWeight);
			$("#detail_totalVolume").html(vo.einoTotalVolume);
			$("#detail_package").html(vo.einoPackage);
			$("#detail_collDeliveryAmount").html(vo.einoCollDeliveryAmount);
			var cda = vo.einoSignBack;
			if(cda == "NOBACK"){
				cda = "无需返单";
			}else if(cda == "CUSTORIGINAL"){
				cda = "客户出库单原件返回";
			}else if(cda == "CUSTCOPY"){
				cda = "客户出库单传真返回";
			}else if(cda == "SIGNCOPY"){
				cda = "客户签收单传真返回";
			}else if(cda == "SIGNORIGINAL"){
				cda = "客户签收单原件返回";
			}
			$("#detail_signBack").html(cda);
			$("#detail_remark").html(vo.einoRemark);
		}
	);
	easyDialog.open({
		container : 'easyDialogPlxd_de',
		fixed : true
	});
}

function setErrorMsg(msg){
	if(msg == ""){
		$("#single_success_tips").html("");
	}else{
		var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
		$("#single_success_tips").html(rs);
	}
}

/**
 * 逐个下订单
 * @author 莫涛
 * @date 2015年7月29日
 * @update
 */
function singleOrder(){
	//收货人
	if(!checkConsigneeEbsaContact()){
		return;
	}
	
	if(checkMobileAndPhone("#entity\\.einoConsigneeEbsaMobile","#entity\\.einoConsigneeEbsaTel","收货人")){
		//单独验证手机
		if(!checkMobile("#entity\\.einoConsigneeEbsaMobile","收货人")){
			return;
		}
		//单独验证座机
		if(!checkPhone("#entity\\.einoConsigneeEbsaTel","收货人")){
			return;
		}
	}else{
		return;
	}
	
	if(!checkConsigneeDistrict()){
		return;
	}

	if(!checkConsigneeEbsaAddress()){
		return;
	}
	
	if(!checkCargoName()){
		return;
	}
	
	if(!checkNumber()){
		return;
	}
	
	//提交订单前，处理一些数据
	var $secondDistrict = $("#entity\\.einoSecondDistrict");
	if($secondDistrict.val() == $secondDistrict.attr("ov")){
		$secondDistrict.val("");
	}
	var $remark = $("#entity\\.einoRemark");
	if($remark.val() == $remark.attr("ov")){
		$remark.val("");
	}
	
	if($("#entity\\.einoInsurance").val() == ""){
		$("#entity\\.einoInsurance").val("0");
	}
	if($("#entity\\.einoNumber").val() == ""){
		$("#entity\\.einoNumber").val("0");
	}
	if($("#entity\\.einoTotalWeight").val() == ""){
		$("#entity\\.einoTotalWeight").val("0");
	}
	if($("#entity\\.einoTotalVolume").val() == ""){
		$("#entity\\.einoTotalVolume").val("0");
	}
	if($("#entity\\.einoCollDeliveryAmount").val() == ""){
		$("#entity\\.einoCollDeliveryAmount").val("0");
	}
	
	$("#singleForm").submit();
}

function returnPage(){
	window.location.href = "batchOrderAction!index.action";
}

function synSecondDistrict(input){
	$("#entity\\.einoSecondDistrict").removeClass("grays");
	$("#entity\\.einoSecondDistrict").val($(input).val());
	$("#entity\\.einoSecondDistrict").change();
}

function createOrder(loginType,obj){
	if(loginType == ""){
		setErrorMsg("#success_tips","未登陆不能保存草稿！");
		return;
	}
	var accept = $("#accept");
	if(accept.attr("checked") != "checked"){
		setErrorMsg("#success_tips","请先阅读服务条款！");
		return;
	}
	$(obj).attr("disabled","disabled");
	window.location.href="batchOrderAction!createBatchOrder.action";
}

function loadPriceTime(){
	var $shipperDistrict = $("#entity\\.shipperDistrict");
	if($shipperDistrict.val() == $shipperDistrict.attr("ov") || $shipperDistrict.val().split("-").length < 3){
		return;
	}
	var $consigneeDistrict = $("#entity\\.consigneeDistrict");
	if($consigneeDistrict.val() == $consigneeDistrict.attr("ov") || $consigneeDistrict.val().split("-").length < 3){
		return;
	}
	var einoTotalVolume = $("#entity.einoTotalVolume").val();
	var einoTotalWeight = $("#entity.einoTotalWeight").val();
	$("#rdo_ld").attr("selected",true);
	/*********查询附近部门和分页的********/
	$.post("orderAction!queryPriceTimeJson.action",{
		"entity.shipperDistrict" : $shipperDistrict.val(),
		"entity.consigneeDistrict" : $consigneeDistrict.val(),
		"entity.einoTotalVolume" : einoTotalVolume,
		"entity.einoTotalWeight" : einoTotalWeight
		},
		//新增易入户，易安装，易包裹三种运输方式，田育林修改，2016-4-28
		function(data, status) {
			var priceList = data.priceList;
			for(var i = 0; i < priceList.length;i++){
				if(priceList[i].transportType == "ONTIME"){//定日达
					$("#rdo_drd").attr("disabled",false);
				}else if(priceList[i].transportType == "LESSLOADED"){//经济快运(普通零担)
					$("#rdo_ld").attr("disabled",false);
				}else if(priceList[i].transportType == "INHOME"){//易入户
					$("#rdo_rh").attr("disabled",false);
				}else if(priceList[i].transportType == "INSTALL"){//易安装
					$("#rdo_az").attr("disabled",false);
				}else if(priceList[i].transportType == "PACKAGE"){//易包裹
					$("#rdo_bg").attr("disabled",false);
				}
			}
		}
	);
}

function checkShipperEbsaContact(){
	var $shipperContact = $("#entity\\.einoShipperEbsaContact");
	if($shipperContact.val() == ""){
		setErrorMsg("发货人不能为空！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkSecondDistrict(){
	var $shipperDistrict = $("#entity\\.shipperDistrict");
	if($shipperDistrict.val() == $shipperDistrict.attr("ov")){
		setErrorMsg("请选择发货人所在省市！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkShipperEbsaAddress(){
	var $shipperEbsaAddress = $("#entity\\.einoShipperEbsaAddress");
	if($shipperEbsaAddress.val() == ""){
		setErrorMsg("请输入发货人地址！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkConsigneeEbsaContact(){
	var $consigneeContact = $("#entity\\.einoConsigneeEbsaContact");
	if($consigneeContact.val() == ""){
		setErrorMsg("收货人不能为空！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkConsigneeDistrict(){
	var $consigneeDistrict = $("#entity\\.consigneeDistrict");
	if($consigneeDistrict.val() == $consigneeDistrict.attr("ov")){
		setErrorMsg("请选择收货人省市区！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkConsigneeEbsaAddress(){
	var $consigneeEbsaAddress = $("#entity\\.einoConsigneeEbsaAddress");
	if($consigneeEbsaAddress.val() == ""){
		setErrorMsg("请输入收货人地址！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkMobile(id,msg){
	var $mobile = $(id);
	if($mobile.val() != ""){
	 	if(!isMobile($mobile.val())){
	        setErrorMsg("请输入正确"+msg+"手机号码！");
	        return false;
	    }else{
	    	setErrorMsg("");
	    }
	}
 	return true;
}

function checkPhone(id,msg){
	var $tel = $(id);
	if($tel.val() != ""){
		var reg = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		if(reg.test($tel.val())){
			setErrorMsg("");
			return true;
		}else{
			setErrorMsg("请输入正确"+msg+"座机号！");
			return false;
		}
	}else{
		return true;
	}
}

function checkMobileAndPhone(mobileId,phoneId,msg){
	var mobile = $(mobileId).val();
	var phone = $(phoneId).val();
	if(mobile == "" && phone == ""){
		setErrorMsg(msg+"手机号与座机号，必须填写一项！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkCargoName(){
	var $cargoName = $("#entity\\.einoCargoName");
	if($cargoName.val() == ""){
		setErrorMsg("货物名称不能为空！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}

function checkNumber(){
	var $number = $("#entity\\.einoNumber");
	if($number.val() == "0"){
		setErrorMsg("货物件数不能为空/不能小于等于零！");
		return false;
	}else{
		setErrorMsg("");
	}
	return true;
}
$(function(){
	$("#btn_pldr").click(function(){		
		easyDialog.open({
			container : 'pldr_layer',
			fixed : true
		});
	});
});

function openOrCloseDialog(){
	var windowId = "easyDialogSel_cons02";
	if(document.getElementById(windowId).style.display=='none'){			
		document.getElementById(windowId).style.display = 'block';
		document.getElementById('fade').style.display = 'block';
	}else{
		document.getElementById(windowId).style.display = 'none';
		document.getElementById('fade').style.display = 'none';
	}
}

//当选择不同的运输方式时，送货方式跟着发生变化，田育林，2016-05-06
function changeShipperMethod(productTypeVal){
	if(productTypeVal!=null && productTypeVal!=""){
		$("#entity\\.einoShipperMethod option").hide();
		if(productTypeVal=="易入户"){
			$("#entity\\.einoShipperMethod>option[value='UPSTAIR']").show().attr("selected",true);
		}else if(productTypeVal=="易安装"){
			$("#entity\\.einoShipperMethod>option[value='INSTALL']").show().attr("selected",true);
		}else{
			$("#entity\\.einoShipperMethod>option[value='SELF_TAKE']").show();
			$("#entity\\.einoShipperMethod>option[value='DOORSTEP']").show();
			$("#entity\\.einoShipperMethod>option[value='UPSTAIR']").show();
			$("#entity\\.einoShipperMethod>option[value='SELF_TAKE']").attr("selected",true);
		}
	}
}