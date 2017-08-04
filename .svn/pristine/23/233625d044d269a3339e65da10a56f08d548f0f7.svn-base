$(window).load(function() {
	//普通下单，选择网点，显示详情
	$("#mapBtn").click(function(){
		var val = $("#entity\\.einoEscoSecondCode").val();
		if(-1 == val){
			$("#companyMsg").html("请先选择网点！");
		}else{
			var sl = $("#entity\\.einoEscoSecondCode").find("option:selected");
			var code = sl.val();
			var path = "companyScreenAction!queryCompanyDetail.action?code="+code;
			window.open(path);
		}
	});
	
	//快速下单，选择网点，显示详情
	$("#quickMapBtn").click(function(){
		var val = $("#quickViewSecondCode").val();
		if(-1 == val){
			$("#quickCompanyMsg").html("请先选择网点！");
		}else{
			var sl = $("#quickViewSecondCode").find("option:selected");
			var code = sl.val();
			var path = "companyScreenAction!queryCompanyDetail.action?code="+code;
			window.open(path);
		}
	});
	
	//选择发货人加载数据
	$("#sel_consigner").click(function(){
		showShipperGrid(1);
	});
	//发货人下一页
	$("#shipper_next_page").click(function(){
		var curent_page = Number($("#shipper_curent_page").text());
		var total_page = Number($("#shipper_total_page").text());
		if(curent_page >= total_page) {
			return;
		}
		var pageNo = curent_page + 1;
		showShipperGrid(pageNo);
	});
	
	//发货人上一页
	$("#Shipper_PrePage").click(function(){
		var curent_page = Number($("#shipper_curent_page").text());
		var total_page = Number($("#shipper_total_page").text());
		if(curent_page <= 1) {
			return;
		}
		var pageNo = curent_page - 1;
		showShipperGrid(pageNo);
	});
	//到第几页
	$("#shipper_go").click(function(){
		var total_page = Number($("#shipper_total_page").text());
		var shipper_go_page_no = $("#shipper_go_page_no").val();
		if(isNaN(shipper_go_page_no)) {
			return; //输入值不是数字
		}
		if(Number(shipper_go_page_no) < 1 || Number(shipper_go_page_no) > total_page) return;
		showShipperGrid(shipper_go_page_no);
	});
	
	//选择收货人加载数据
	$("#sel_consignee").click(function(){
		showConsigneeGrid(1,'')
	});
	
	//收货人下一页
	$("#consignee_NextPage").click(function(){
		var curent_page = Number($("#consignee_curent_page").text());
		var total_page = Number($("#consignee_total_page").text());
		if(curent_page >= total_page) {
			return;
		}
		var pageNo = curent_page + 1;
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(pageNo,key_word);
	});
	
	//收货人上一页
	$("#consignee_PrePage").click(function(){
		var curent_page = Number($("#consignee_curent_page").text());
		var total_page = Number($("#consignee_total_page").text());
		if(curent_page <= 1) return;
		var pageNo = curent_page - 1;
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(pageNo,key_word);
	});
	//到第几页
	$("#consignee_go").click(function(){
		var total_page = Number($("#consignee_total_page").text());
		var shipper_go_page_no = $("#consignee_go_page_no").val();
		if(isNaN(shipper_go_page_no)) {
			return; //输入值不是数字
		}
		if(Number(shipper_go_page_no) < 1 || Number(shipper_go_page_no) > total_page) return;
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(shipper_go_page_no,key_word);
	});
	
	//收货人搜索
	$("#search_btn").click(function(){
		var key_word = $("#key_word_input").val();
		showConsigneeGrid(1,key_word);
	});
	
	//历史下单关键字
	$("#keyWord").change(function(){
		 var text = $(this).val();
		 if (text == 'consignee') {
			 $("#keyValue").attr("ov","请输入收货人")
			 $("#keyValue").attr("value","请输入收货人")
		 }else if (text == 'consigner') {
			 $("#keyValue").attr("ov","请输入发货人")
			 $("#keyValue").attr("value","请输入发货人")
		 }
	});
	
	//历史下单查询
	$("#query_order_template").click(function(){
		loadQuickOrder(1);
	});
	//历史下单弹窗
	$("#history_btn").click(function(){
		loadQuickOrder(1);
	});
	//历史下单下一页
	$("#quick_NextPage").click(function(){
		var curent_page = Number($("#quick_curent_page").text());
		var total_page = Number($("#quick_total_page").text());
		if(curent_page >= total_page) {
			return;
		}
		var pageNo = curent_page + 1;
		loadQuickOrder(pageNo);
	});
	
	//历史下单上一页
	$("#quick_PrePage").click(function(){
		var curent_page = Number($("#quick_curent_page").text());
		var total_page = Number($("#quick_total_page").text());
		if(curent_page <= 1) {
			return;
		}
		var pageNo = curent_page - 1;
		loadQuickOrder(pageNo);
	});
	//到第几页
	$("#quick_go").click(function(){
		var total_page = Number($("#quick_total_page").text());
		var quick_go_page_no = $("#quick_go_page_no").val();
		if(isNaN(quick_go_page_no)){
			return; //输入值不是数字
		}
		if(Number(quick_go_page_no) < 1 || Number(quick_go_page_no) > total_page) {
			return;
		}
		loadQuickOrder(quick_go_page_no);
	});
	//快速下单界面弹出
	$("#quick_order_btn").click(function(){
		easyDialog.open({
			container : 'dialog_quick_order',
			fixed : true
		});
	});
	//快速下单发货人选择界面显示
	$("#quick_sel_consigner").click(function(){
		showQuickShipperGrid(1);
	});
	//发货人下一页
	$("#quick_shipper_next_page").click(function(){
		var curent_page = Number($("#quick_shipper_curent_page").text());
		var total_page = Number($("#quick_shipper_total_page").text());
		if(curent_page >= total_page){
			return;
		}
		var pageNo = curent_page + 1;
		showQuickShipperGrid(pageNo);
	});
	
	//发货人上一页
	$("#quick_shipper_prepage").click(function(){
		var curent_page = Number($("#quick_shipper_curent_page").text());
		var total_page = Number($("#quick_shipper_total_page").text());
		if(curent_page <= 1){
			return;
		}
		var pageNo = curent_page - 1;
		showQuickShipperGrid(pageNo);
	});
	//到第几页
	$("#quick_shipper_go").click(function(){
		var total_page = Number($("#quick_shipper_total_page").text());
		var shipper_go_page_no = $("#quick_shipper_go_page_no").val();
		if(isNaN(shipper_go_page_no)){
			return; //输入值不是数字
		}
		if(Number(shipper_go_page_no) < 1 || Number(shipper_go_page_no) > total_page) return;
		showQuickShipperGrid(shipper_go_page_no);
	});
	
	//选择运输方式后触发，田育林，2016-05-06
	$("#productType_div2 input[name='entity.einoProductTypeName']").click(function(){
		changeShipperMethod(this.id)
	});
	$("#productType_div2").ready(function(){
		var ptId = $("#productType_div2 input[name='entity.einoProductTypeName']:checked").attr("id");
		changeShipperMethod(ptId);
		var esmn = $("input#einoShipperMethodNone").val();
		if(esmn!=null && esmn!=""){
			$("#entity\\.einoShipperMethod").val(esmn);
		}
	});
});

/**
 * 修改订单 显示货物信息
 */
$(document).ready(function() {
	var shipperDistrict = $("#entity\\.shipperDistrict").val();
	var consigneeDistrict = $("#entity\\.consigneeDistrict").val();
	if(shipperDistrict != null && shipperDistrict != "" && consigneeDistrict != null && consigneeDistrict != ""){
		loadPriceTime();
	}
	var einoSecondDistrict = $("#entity\\.einoSecondDistrict").val();
	var einoEscoSecondCode = $("#einoEscoSecondCode").val();
	if(einoSecondDistrict != "" && einoSecondDistrict != $("#entity\\.einoSecondDistrict").attr("ov")){
		loadSecondDistrict("#entity\\.einoEscoSecondCode","#entity\\.einoSecondDistrict",einoEscoSecondCode);
	}
});

//加载显示历史下单
function loadQuickOrder(pageNo){
	var keyWord = $("#keyWord").val();
	var keyValue= $("#keyValue").val();
	var consignee = "";
	var consigner = "";
	if (keyWord == 'consignee' && keyValue != "请输入收货人") {
		consignee = keyValue;
	} else if (keyWord == 'consigner' && keyValue != "请输入发货人") {
		consigner = keyValue;
	}
	var url = "orderAction!queryQuickOrders.action?consignee="+consignee+"&consigner"+consigner+"&pageNo="+pageNo;
	$.get(url,function(data,status){
		if(status == 'success' && data.success == false){
			window.location.href="login.action?dest=orderAction!index.action";
		}else{
			
			$("#quick_curent_page").text(data.pageNo);
			$("#quick_total_page").text(data.pageCount);
			var orders = data.quickOrders;
			
			var table = $("#quick_orders_content");
			table.empty();
			var head = $(
					 '<tr>'
					+'<td width="8%">序 号</td>'
					+'<td width="10%">发货人</td>'
					+'<td width="10%">收货人</td>'
					+'<td width="10%">货物名称</td>'
					+'<td width="15%">运输方式</td>'
					+'<td width="18%">到达城市</td>'
					+'<td width="15%">服务信息</td>'
					+'<td width="14%">操 作</td>'
					+'</tr>'
					);
			table.append(head);
			
			var row = "";
			for(var i=0;i<orders.length;i++){
				//付款方式
				var payment;
				if(orders[i].paymentWay=='ARRIVE_PAYMENT'){
					payment = '到付';
				}else if(orders[i].paymentWay=='CASH'){
					payment = '现付';
				}else if(orders[i].paymentWay=='Monthly_Statement'){
					payment = '月结';
				}
				//送货方式
				var delivery;
				if(orders[i].deliveryWay=='SELF_TAKE'){
					delivery = '客户自提';
				}else if(orders[i].deliveryWay=='DOORSTEP'){
					delivery = '送货上门';
				}else if(orders[i].deliveryWay=='UPSTAIR'){
					delivery = '送货上楼';
				}else if(orders[i].deliveryWay=='INSTALL'){
					delivery = '安装';
				}
				row = $("<tr><td width='8%'>"+(i+1)+"</td>"
				+ "<td width='10%'>"+orders[i].consignerName+"</td>"
				+ "<td width='10%'>"+orders[i].consigneeName+"</td>"
				+ "<td width='10%'>"+orders[i].goodsName+"</td>"
				+ "<td width='15%'>"+orders[i].productType+"</td>"
				+ "<td width='18%'>"+orders[i].consigneeProvince+"-"+orders[i].consigneeCity+"</td>"
				+ "<td width='15%'>"+payment+"|"+delivery+"</td>"
				+ "<td width='14%'><a href='orderAction!quickOrder.action?orderId="+orders[i].orderId+"'>选择</a></td></tr>"
				);
				table.append(row);
			}
			easyDialog.open({
				container : 'quick_order_m',
				fixed : true
			});
		}
	});
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
					'<td width="13%">姓名</td>' +
					'<td width="15%">手机号</td>' +
					'<td width="15%">固话</td>' +
					'<td width="22%">发货地址</td>' +
					'<td width="25%">发货网点</td>' +
					'<td width="10%">操作</td>' +
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

//显示快速下单发货人信息表格
function showQuickShipperGrid(pageNo){
	var contactType = "shipper";
	var url = "pagingQueryContacts.action?contactsType="+contactType+"&pageNo="+pageNo;
	$.get(url,function(data,status){
		if(status == 'success' && data.success == false){
			window.location.href="login.action?dest=orderAction!index.action";
		}else{
			var table = $("#quick_shipper_data");
			table.empty();
			var head = $(
					'<tr>' +
					'<td width="13%">姓名</td>' +
					'<td width="15%">手机号</td>' +
					'<td width="15%">固话</td>' +
					'<td width="22%">发货地址</td>' +
					'<td width="25%">发货网点</td>' +
					'<td width="10%">操作</td>' +
					'</tr>'
					);
			table.append(head);
			var pageCount = data.paging.pageCount;
			var pageNo = data.paging.pageNo;
			var pageSize = data.paging.pageSize;
			var rowsCount = data.paging.rowsCount;
			var dataArray = data.paging.data;
			$("#quick_shipper_curent_page").text(pageNo);
			$("#quick_shipper_total_page").text(pageCount);
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
						'<td><a href="javascript:void(0)" onclick="loadQuickShipperContacts('+dataArray[i].ebsaId+')">选择</a></td>' +
						'</tr>'
						);
				table.append(row);
			}
			$("#share_from01").show();
		}
	});
}

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
						'<td><a href="javascript:void(0)" onclick="loadConsigneeContacts('+dataArray[i].ebsaId+')">选择</a></td>' +
						'</tr>'
						);
				table.append(row);
			}
			easyDialog.open({
				container : 'easyDialogSel_cons02',
				fixed : true
			});
		}
	});
}

//加载快速下单发货人数据
function loadQuickShipperContacts(id){
	var ebsaEscoSecondCode;
	var url = "queryByIdContacts.action?contactsIds=" + id +"&date="+new Date();
	$.get(url,function(data,status){
    	if(status == 'success' && data.success == false){
    		
    	}else{
    		var contacts = data.contactsEntity;
    		var tel='';
			if(!isBlank(contacts.ebsaContactAreaCode)){
				tel = contacts.ebsaContactAreaCode + '-' + contacts.ebsaContactTel;
			}
    		//给界面表单元素赋值
    		$("#einoShipperEbsaContact").val(contacts.ebsaContact);//收货人姓名
    		$("#einoShipperEbsaMobile").val(contacts.ebsaMobile);//发货人手机号码
    		$("#einoShipperEbsaTel").val(tel);//发货人座机
    		$("#shipperDistrict").val(contacts.ebsaEbpvName+"-"+contacts.ebsaEbplName+"-"+contacts.ebsaEbcoName);//发货人省市区
    		$("#einoShipperEbsaAddress").val(contacts.ebsaAddress);// 发货人地址详细信息
    		//TODO 网点对应省市区  待完善
    		$("#einoSecondDistrict").val(contacts.ebsaDeptDistrict);//发货网点所对应省市区
    		$("#einoSecondDistrict").removeClass("grays");
    		//公司名称
    		$("#einoShipperEbspNameCn").val(contacts.ebsaCompany);
    		$("#einoShipperEbspNameCn").removeClass("grays");
    		ebsaEscoSecondCode = contacts.ebsaEscoSecondCode;
    		$("#share_from01").hide();
	    }
    	$("#shipperDistrict").removeClass("grays");
    	$("#einoShipperEbsaAddress").removeClass("grays");
    	loadSecondDistrict("#quickViewSecondCode","#einoSecondDistrict",ebsaEscoSecondCode);
    });
}

//加载发货人数据
function loadShipperContacts(id){
	var ebsaEscoSecondCode;
	var url = "queryByIdContacts.action?contactsIds=" + id +"&date="+new Date();
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
    		$("#entity\\.einoSecondDistrict").removeClass("grays");
    		//公司名称
    		$("#entity\\.einoShipperEbspNameCn").val(contacts.ebsaCompany);
    		$("#entity\\.einoShipperEbspNameCn").removeClass("grays");
    		ebsaEscoSecondCode = contacts.ebsaEscoSecondCode;
    		easyDialog.close();
	    }
    	$("#entity\\.shipperDistrict").removeClass("grays");
    	$("#entity\\.einoShipperEbsaAddress").removeClass("grays");
    	loadSecondDistrict("#entity\\.einoEscoSecondCode","#entity\\.einoSecondDistrict",ebsaEscoSecondCode);
    });
}

//加载收货人数据
function loadConsigneeContacts(id){
	var url = "queryByIdContacts.action?contactsIds=" + id +"&date="+new Date();
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
    		easyDialog.close();
	    }
    	$("#entity\\.consigneeDistrict").change();
    	$("#entity\\.consigneeDistrict").removeClass("grays");
    	$("#entity\\.einoConsigneeEbsaAddress").removeClass("grays");
    });
}


/**
 * 加载网点
 * @param input
 * @author 莫涛
 * @date 2015年7月28日
 * @update
 */
function loadSecondDistrict(id,input,logistCode){
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
			$(id).html("");
			$("<option value='-1'>请选择网点</option>").appendTo(id);
			for(var i = 0 ;i < departmentVos.length ; i ++){
				if(logistCode != null && logistCode == departmentVos[i].logistCode){
					attr = "selected='selected'";
				}else{
					attr = "";
				}
				$("<option address='"+departmentVos[i].addressDetail+
						"' areaCode='"+departmentVos[i].areaCode+
						"' phone='"+departmentVos[i].phone+
						"' id='"+departmentVos[i].id+
						"' "+attr+" value='"+departmentVos[i].logistCode+
						"'>"+departmentVos[i].deptName+"</option>")
				.appendTo(id);
			}
			if(logistCode != null){
				$(id).change();
			}
		}
	);
}

function changeCompany(sel,cmId,esnId){
	var sl = $(sel).find("option:selected");
	var address = sl.attr("address");
	var phone = sl.attr("phone");
	var areaCode = sl.attr("areaCode");
	if(address != null && phone != null){
		if(areaCode != null && areaCode != ""){
			areaCode = areaCode + "-";
		}else{
			areaCode = "";
		}
		$(cmId).html(address + " | " + (areaCode+phone) );
		$(esnId).val(sl.html());
	}else{
		$(cmId).html("");
		$(esnId).val("");
	}
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
	clearPriceTime("#drd_");
	clearPriceTime("#ld_");
	//清理易入户、易安装、易包裹的数据，田育林，2016-05-05
	clearPriceTime("#rh_");
	clearPriceTime("#az_");
	clearPriceTime("#bg_");
	/*********查询附近部门和分页的********/
	$.post("orderAction!queryPriceTimeJson.action",{
		"entity.shipperDistrict" : $shipperDistrict.val(),
		"entity.consigneeDistrict" : $consigneeDistrict.val(),
		"entity.einoTotalVolume" : einoTotalVolume,
		"entity.einoTotalWeight" : einoTotalWeight
		},
		function(data, status) {
			var priceList = data.priceList;
			var id = "";
			//新增易入户，易安装，易包裹三种运输方式，田育林修改，2016-4-28
			for(var i = 0; i < priceList.length;i++){
				if(priceList[i].transportType == "ONTIME"){//定日达
					id = "#drd_";
					$("#rdo_drd").attr("disabled",false);
				}else if(priceList[i].transportType == "LESSLOADED"){//经济快运(普通零担)
					id = "#ld_";
				}else if(priceList[i].transportType == "INHOME"){//易入户
					id = "#rh_";
					$("#rdo_rh").attr("disabled",false);
				}else if(priceList[i].transportType == "INSTALL"){//易安装
					id = "#az_";
					$("#rdo_az").attr("disabled",false);
				}else if(priceList[i].transportType == "PACKAGE"){//易包裹
					id = "#bg_";
					$("#rdo_bg").attr("disabled",false);
				}
				var time = "<p>预计客户自提时间：第"+priceList[i].pickTime+"天</p><p>预计送货上门时间：第"+priceList[i].deliveryTime+"天</p>";
				$(id+"deliveryTime_td").html(time);
				$(id+"startPrice_td").html(priceList[i].startPrice);
				$(id+"heavyPrice_td").html(priceList[i].heavyPrice);
				$(id+"lightPrice_td").html(priceList[i].lightPrice);
			}
			showCargoInfo();
		}
	);
}

function showCargoInfo(errorType,reqErrorType){
	if(errorType == null || errorType == "systemError" || reqErrorType == "systemError"){
		$("#productType_div").show();
		$("#productType_div2").show();
		$("#cargoInfo_div").show();
		$("#cargoInfo_div2").show();
	}
	if(errorType == "saveDraftSuccess"){
		easyDialog.open({
			container : 'Dialog_tips',
			fixed : true
		});
	}
	if(errorType == "createOrderSuccess"){
		easyDialog.open({
			container : 'Dialog_tips02',
			fixed : true
		});
	}
}

function clearPriceTime(id){
	$(id+"deliveryTime_td").html("");
	$(id+"startPrice_td").html("");
	$(id+"heavyPrice_td").html("");
	$(id+"lightPrice_td").html("");
}
/**
 * 存为草稿
 * @author 莫涛
 * @date 2015年7月29日
 * @update
 */
function saveDraft(loginType,obj){
	if(loginType == ""){
		setErrorMsg("#success_tips","未登陆不能保存草稿！");
		return;
	}
	if(!nonNullVerification()){
		$(obj).attr("disabled","disabled");
		$("#orderForm").attr("action","orderAction!saveDraft.action");
		$("#orderForm").submit();
	}else{
		setErrorMsg("#success_tips","未修改新增数据不能保存草稿！");
	}
}

function nonNullVerification(){
	if($("#entity\\.einoShipperEbsaContact").val() != ""){
		return false;
	}
	if($("#entity\\.einoShipperEbsaMobile").val() != ""){
		return false;
	}
	if($("#entity\\.einoShipperEbsaTel").val() != ""){
		return false;
	}
	if($("#entity\\.shipperDistrict").val() != $("#entity\\.shipperDistrict").attr("ov")){
		return false;
	}
	if($("#entity\\.einoShipperEbsaAddress").val() != $("#entity\\.einoShipperEbsaAddress").attr("ov")){
		return false;
	}
	if($("#entity\\.einoSecondDistrict").val() != $("#entity\\.einoSecondDistrict").attr("ov")){
		return false;
	}
	if($("#entity\\.einoConsigneeEbsaContact").val() != ""){
		return false;
	}
	if($("#entity\\.einoConsigneeEbsaMobile").val() != ""){
		return false;
	}
	if($("#entity\\.einoConsigneeEbsaTel").val() != ""){
		return false;
	}
	if($("#entity\\.consigneeDistrict").val() != $("#entity\\.consigneeDistrict").attr("ov")){
		return false;
	}
	if($("#entity\\.einoConsigneeEbsaAddress").val() != $("#entity\\.einoConsigneeEbsaAddress").attr("ov")){
		return false;
	}
	return true;
}

function setErrorMsg(id,msg){
	if(msg == ""){
		$(id).html("");
	}else{
		var rs = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
		$(id).html(rs);
	}
}
//处理发货区域
function synSecondDistrict(input){
	$("#entity\\.einoSecondDistrict").removeClass("grays");
	$("#entity\\.einoSecondDistrict").val($(input).val());
	$("#entity\\.einoSecondDistrict").change();
}
//快速下单处理发货区域
function synQuickSecondDistrict(input){
	$("#einoSecondDistrict").removeClass("grays");
	$("#einoSecondDistrict").val($(input).val());
	$("#einoSecondDistrict").change();
}

/**
 * 快速下单
 * @author 莫涛
 * @date 2015年9月23日
 * @update
 */
function quickCreateOrder(loginType,obj){
	if(loginType == ""){
		easyDialog.open({
			container : 'reg_Dialog',
			fixed : true
		});
		return;
	}
	
	var $shipperContact = $("#einoShipperEbsaContact");
	if($shipperContact.val() == ""){
		setErrorMsg("#quick_order_tips","发货人不能为空！");
		return;
	}else{
		setErrorMsg("#quick_order_tips","");
	}
	
	if(checkMobileAndPhone("#einoShipperEbsaMobile","#einoShipperEbsaTel","发货人","#quick_order_tips")){
		//单独验证手机
		if(!checkOrderMobile("#einoShipperEbsaMobile","发货人","#quick_order_tips")){
			return;
		}
		//单独验证座机
		if(!checkPhone("#einoShipperEbsaTel","发货人","#quick_order_tips")){
			return;
		}
	}else{
		return;
	}
	
	var $shipperDistrict = $("#shipperDistrict");
	if($shipperDistrict.val() == $shipperDistrict.attr("ov")){
		setErrorMsg("#quick_order_tips","请选择发货人所在省市！");
		return;
	}else{
		setErrorMsg("#quick_order_tips","");
	}
	
	var $shipperEbsaAddress = $("#einoShipperEbsaAddress");
	if($shipperEbsaAddress.val() == $shipperEbsaAddress.attr("ov")){
		setErrorMsg("#quick_order_tips","请输入发货人地址！");
		return;
	}else{
		setErrorMsg("#quick_order_tips","");
	}
	//先禁用按钮
	$(obj).attr("disabled","disabled");
	$.post("orderAction!createQuickOrder.action",{
		"entity.einoShipperEbsaContact" : $shipperContact.val(),
		"entity.einoShipperEbsaMobile" : $("#einoShipperEbsaMobile").val(),
		"entity.einoShipperEbsaTel" : $("#einoShipperEbsaTel").val(),
		"entity.einoShipperEbspNameCn" : $("#einoShipperEbspNameCn").val(),
		"entity.shipperDistrict" : $("#shipperDistrict").val(),
		"entity.einoShipperEbsaAddress" : $("#einoShipperEbsaAddress").val(),
		"entity.einoSecondDistrict" : $("#einoSecondDistrict").val(),
		"entity.einoEscoSecondCode" : $("#quickViewSecondCode").val(),
		"entity.einoEscoSecondName" : $("#einoEscoSecondName").val(),
		"entity.einoLuoji" : $("#einoLuoji").val()
		},
		function(data, status) {
			showCargoInfo(data.errorType,data.reqErrorType);
		}
	);
}

/**
 * 下订单
 * @author 莫涛
 * @date 2015年7月29日
 * @update
 */
function createOrder(loginType,obj){
	if(loginType == ""){
		easyDialog.open({
			container : 'reg_Dialog',
			fixed : true
		});
		return;
	}
	var status = $("#entity\\.einoStatus").val();
	if($("#fromPage").val()=="modify" && status != null && status != 'DRAFT'){
		$("#orderForm").attr("action","orderAction!updateOrder.action");
	}else{
		$("#orderForm").attr("action","orderAction!createOrder.action");
		if($("#entity\\.einoId").val() != ""  && status != null && status != 'DRAFT'){
			setErrorMsg("#success_tips","请勿重复提交订单！");
			return;
		};
	}
	if(!checkShipperEbsaContact()){
		return;
	}
	if(checkMobileAndPhone("#entity\\.einoShipperEbsaMobile","#entity\\.einoShipperEbsaTel","发货人","#shipperEbsaMobile_tips")){
		//单独验证手机
		if(!checkOrderMobile("#entity\\.einoShipperEbsaMobile","发货人","#shipperEbsaMobile_tips")){
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
	
	//收货人
	if(!checkConsigneeEbsaContact()){
		return;
	}
	
	if(checkMobileAndPhone("#entity\\.einoConsigneeEbsaMobile","#entity\\.einoConsigneeEbsaTel","收货人","#consigneeEbsaMobile_tips")){
		//单独验证手机
		if(!checkOrderMobile("#entity\\.einoConsigneeEbsaMobile","收货人","#consigneeEbsaMobile_tips")){
			return;
		}
		//单独验证座机
		if(!checkPhone("#entity\\.einoConsigneeEbsaTel","收货人","#consigneeEbsaMobile_tips")){
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
	
	if(!checkInsurance()){
		return;
	}
	
	var accept = $("#accept");
	if(accept.attr("checked") != "checked"){
		setErrorMsg("#success_tips","请先阅读服务条款！");
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
	$(obj).attr("disabled","disabled");
	$("#orderForm").submit();
}


/**
 * 取消修改订单 返回订单列表
 */
function cancelUpdateOrder(){
	window.location.href="myOrdersAction!queryMyOrders.action";
}

function checkShipperEbsaContact(){
	var $shipperContact = $("#entity\\.einoShipperEbsaContact");
	if($shipperContact.val() == ""){
		setErrorMsg("#success_tips","发货人不能为空！");
		setErrorMsg("#shipperEbsaContact_tips","发货人不能为空！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
		setErrorMsg("#shipperEbsaContact_tips","");
	}
	return true;
}

function checkSecondDistrict(){
	var $shipperDistrict = $("#entity\\.shipperDistrict");
	if($shipperDistrict.val() == $shipperDistrict.attr("ov")){
		setErrorMsg("#success_tips","请选择发货人所在省市！");
		setErrorMsg("#shipperDistrict_tips","请选择发货人所在省市！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
		setErrorMsg("#shipperDistrict_tips","");
	}
	return true;
}

function checkShipperEbsaAddress(){
	var $shipperEbsaAddress = $("#entity\\.einoShipperEbsaAddress");
	if($shipperEbsaAddress.val() == $shipperEbsaAddress.attr("ov")){
		setErrorMsg("#success_tips","请输入发货人地址！");
		setErrorMsg("#shipperDistrict_tips","请输入发货人地址！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
		setErrorMsg("#shipperDistrict_tips","");
	}
	return true;
}

function checkConsigneeEbsaContact(){
	var $consigneeContact = $("#entity\\.einoConsigneeEbsaContact");
	if($consigneeContact.val() == ""){
		setErrorMsg("#success_tips","收货人不能为空！");
		setErrorMsg("#consigneeEbsaContact_tips","收货人不能为空！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
		setErrorMsg("#consigneeEbsaContact_tips","");
	}
	return true;
}

function checkConsigneeDistrict(){
	var $consigneeDistrict = $("#entity\\.consigneeDistrict");
	if($consigneeDistrict.val() == $consigneeDistrict.attr("ov")){
		setErrorMsg("#success_tips","请选择收货人省市区！");
		setErrorMsg("#consigneeDistrict_tips","请选择收货人省市区！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
		setErrorMsg("#consigneeDistrict_tips","");
	}
	return true;
}

function checkConsigneeEbsaAddress(){
	var $consigneeEbsaAddress = $("#entity\\.einoConsigneeEbsaAddress");
	if($consigneeEbsaAddress.val() == $consigneeEbsaAddress.attr("ov")){
		setErrorMsg("#success_tips","请输入收货人地址！");
		setErrorMsg("#consigneeDistrict_tips","请输入收货人地址！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
		setErrorMsg("#consigneeDistrict_tips","");
	}
	return true;
}

function checkOrderMobile(id,msg,tipsId){
	var $mobile = $(id);
	if($mobile.val() != ""){
	 	if(!isMobile($mobile.val())){
	 		setErrorMsg("#success_tips","请输入正确"+msg+"手机号码！");
	        setErrorMsg(tipsId,"请输入正确"+msg+"手机号码！");
	        return false;
	    }else{
	    	setErrorMsg("#success_tips","");
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
			setErrorMsg("#success_tips","");
			setErrorMsg(tipsId,"");
			return true;
		}else{
			setErrorMsg("#success_tips","请输入正确"+msg+"座机号！");
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
		setErrorMsg("#success_tips",msg+"手机号与座机号，必须填写一项！");
		setErrorMsg(tipsId,msg+"手机号与座机号，必须填写一项！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
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

function checkNumber(){
	var $number = $("#entity\\.einoNumber");
	if($number.val() == "" || $number.val() == 0){
		setErrorMsg("#success_tips","货物件数不能为空/不能小于等于零！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
	}
	return true;
}

function checkInsurance(){
	var $insurance = $("#entity\\.einoInsurance");
	if($insurance.val() == "" || $insurance.val() == 0){
		setErrorMsg("#success_tips","保价声明不能为空/不能小于等于零！");
		return false;
	}else{
		setErrorMsg("#success_tips","");
	}
	return true;
}

//当选择不同的运输方式时，送货方式跟着发生变化，田育林，2016-05-06
function changeShipperMethod(productTypeId){
	if(productTypeId!=null && productTypeId!=""){
		$("#entity\\.einoShipperMethod option").hide();
		if(productTypeId=="rdo_rh"){
			$("option#UPSTAIR").show().attr("selected",true);
		}else if(productTypeId=="rdo_az"){
			$("option#INSTALL").show().attr("selected",true);
		}else{
			$("option#SELF_TAKE,option#DOORSTEP,option#UPSTAIR").show();
			$("#entity\\.einoShipperMethod").val("SELF_TAKE");
		}
	}
}