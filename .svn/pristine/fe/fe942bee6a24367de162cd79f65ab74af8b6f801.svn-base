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
		window.location.href = "contacts_shipperManage.action?contactsType=shipper&queryKeyword="+encodeKey;
	});
	
	//省市区选择 输入框改变 加载 网点  （新增时）
	$("#shipper_district").change(function(){
		$("#shipper_dept_district").val($(this).val()).removeClass("grays");
		$("#shipper_dept_district").change();
	});
	
	$("#shipper_update_district").change(function(){
		$("#shipper_update_dept_district").val($("#shipper_update_district").val());
		$("#shipper_update_dept_district").change()
	});
	
	//新增联系人   发货
	$("#shipper_add_btn").click(function(){
		//校验待收货款信息中是否有空值
		var rootClass = $("#append-out .receivables_info_box");
		var num=rootClass.length;
		if($("#unpayment_message").is(':checked')&&num==1){
			var payeeName = rootClass.eq(0).find(".payee_name1").find("option:selected").text();
			var payeeAccount = rootClass.eq(0).find(".shipper_account1").val();
			var bank = rootClass.eq(0).find(".bank_name1").val();
			var branchMessageCode = rootClass.eq(0).find(".branch_message1")[0].code;
			var branchMessageName = rootClass.eq(0).find(".branch_message1").val();
			if(branchMessageCode == "" || branchMessageName == ""){
				add_errTips("请选择预选开户行信息");
		    	return;
			}
			var ascriptionCity = rootClass.eq(0).find(".ascriptionCity1");
		    if(payeeName == "" || payeeAccount == "" || bank == "" || ascriptionCity.val() == ascriptionCity.attr("ov")){
		    	add_errTips("待收货款信息不能有空值");
		    	return;
		    }
		}
		
		for(var i=1;i<num;i++){
			var payeeName = rootClass.eq(i).find(".payee_name1").find("option:selected").text();
			var payeeAccount = rootClass.eq(i).find(".shipper_account1").val();
			var bank = rootClass.eq(i).find(".bank_name1").val();
			var branchMessageCode = rootClass.eq(i).find(".branch_message1")[0].code;
			var branchMessageName = rootClass.eq(i).find(".branch_message1").val();
			if(branchMessageCode == "" || branchMessageName == ""){
				add_errTips("请选择预选开户行信息");
		    	return;
			}
			var ascriptionCity = rootClass.eq(i).find(".ascriptionCity1");
		    if(payeeName == "" || payeeAccount == "" || bank == "" || ascriptionCity.val() == ascriptionCity.attr("ov")){
		    	add_errTips("待收货款信息不能有空值");
		    	return;
		    }
		 }
		
		var shipper_name = $("#shipper_name").val();//发货人姓名
		if(shipper_name.length > 20){
			add_errTips("姓名最多为20个字符");
			return;
		}
		if($.trim(shipper_name) == ""){
			add_errTips("姓名不能为空");
			return;
		}
		var shipper_mobile = $("#shipper_mobile").val();//发货人手机号码
		var shipper_telephone_area_no = $("#shipper_telephone_area_no").val();//发货人座机区号
		var shipper_telephone = $("#shipper_telephone").val();//发货人座机
		
		//---------------------------------电话校验
		var tel = shipper_telephone_area_no +"-"+shipper_telephone;
		if(isBlank(shipper_mobile) && tel == "-"){
			add_errTips("手机和固定电话至少填一项");
			return;
		}
		if(!isBlank(tel) && tel != "-"){
			var reg = /^0\d{2,3}-\d{5,9}|0\d{2,3}-\d{5,9}$/;
			if(!reg.test(tel)){
				add_errTips("请输入正确固定电话号码");
				return;
			}
		}
		if(!isBlank(shipper_mobile)){
			var par=/^1[2,3,4,5,6,7,8,9]{1}[0-9]{1}[0-9]{8}$/;
			if(!par.test(shipper_mobile)){
				add_errTips("请输入正确的手机号码");
				return;
			}
		}
		//---------------------------------
		
		var shipper_district = $("#shipper_district").val();//发货人省市区
		if(shipper_district == "请选择城市名称" || isBlank(shipper_district)){
			add_errTips("发货地址省市区不能空");
			return;
		}
		
		var shipper_address_detail = $("#shipper_address_detail").val();// 发货人地址详细信息
		if(isBlank(shipper_address_detail)){
			add_errTips("详细地址不能为空");
			return;
		}
		if(shipper_address_detail.length > 100){
			add_errTips("详细地址最多为100个字符");
			return;
		}
		
		
		var shipper_dept_district = $("#shipper_dept_district").val();//发货网点所对应省市区
		if(shipper_district == "请选择城市名称" || isBlank(shipper_district)){
			shipper_district = "";
		}
		
		var shipper_dept_name = $("#shipper_dept_name option:selected").text();//发货网点名称
		
		//获取opetion Value  物流编码
		var logisticCode=$("#shipper_dept_name").val(); 
		var pcd = shipper_district.split('-');
		var shipper_company = $("#shipper_company").val();
		if($("#shipper_company").val() == $("#shipper_company").attr("ov")){
			shipper_company = "";
		}
		
		var list = new Array();
		//获取待收货款信息
		for(var i=0;i<num;i++){
			var UnpayMentEntity ={};
			UnpayMentEntity.payeeName = rootClass.eq(i).find(".payee_name1").find("option:selected").text();
			UnpayMentEntity.payeeAccount = rootClass.eq(i).find(".shipper_account1").val();
			UnpayMentEntity.bank = rootClass.eq(i).find(".bank_name1").val();
			UnpayMentEntity.branchMessageCode = rootClass.eq(i).find(".branch_message1")[0].code;
			UnpayMentEntity.branchMessageName = rootClass.eq(i).find(".branch_message1").val();
			UnpayMentEntity.district = rootClass.eq(i).find(".ascriptionCity1").val();
			list.push(UnpayMentEntity);
		}
		var str = JSON.stringify(list);
		$.post("addContacts.action",{
				    "contactsEntity.ebsaContact":shipper_name,
				    "contactsEntity.ebsaMobile":shipper_mobile,
				    "contactsEntity.ebsaContactAreaCode":shipper_telephone_area_no,
				    "contactsEntity.ebsaContactTel":shipper_telephone,
				    "contactsEntity.ebsaEbpvName":pcd[0],
				    "contactsEntity.ebsaEbplName":pcd[1],
				    "contactsEntity.ebsaEbcoName":pcd[2],
				    "contactsEntity.ebsaAddress":shipper_address_detail,
				    "contactsEntity.ebsaType":"shipper",
				    "contactsEntity.ebsaDeptDistrict":shipper_dept_district,
				    "contactsEntity.ebsaEscoSecondCode":logisticCode,
				    "contactsEntity.ebsaEscoSecondName":shipper_dept_name,
				    "contactsEntity.ebsaCompany":shipper_company,
				    "unpayMentString":str
			  },
			  function(data,status){
				  if(status == 'success' && data.success == false){
					  add_errTips(data.message)
				  }else{
					  //TODO XUJUN
					  window.location.href = "contacts_shipperManage.action";
				  }
			  });
	});
	
	//判断发货人信息中，发货人手机号或者固定电话是否已填
	$("#unpayment_message").click(function(){
		if($("#unpayment_message").is(':checked')){
			$("#append-out .receivables_info_box").eq(0).find(".easyDialog_footer").show();
			var shipper_mobile=$("#shipper_mobile").val();
			if(shipper_mobile==""){
				$(".unpayment_message_error1").text("此项需输入手机号").css("color","red");
				$("#unpayment_message").attr("checked",false);
			}else if(shipper_mobile!=""){
				$(".unpayment_message_error1").text("");
				$("#unpayment_message_checked").css("display","block");
				var array=new Array();
				var shipper_name=$("#shipper_name").val();
				var shipper_company=$("#shipper_company").val();
				if(shipper_name!=null && shipper_name!=""){
					array[0]=shipper_name;
				}
				if(shipper_company!=null && shipper_company!="" && shipper_company!="若需开票，需必填，与开票公司抬头保持一致"){
					array[1]=shipper_company;
				}
				$(".payee_name1").empty();
				$.each(array,function(n,value){
					$(".payee_name1").append("<option value='"+n+"'>"+value+"</option>"); 
				});
			}
		  }else{
			    $("#easyDialogWrapper .erro").hide();
				$("#easyDialogWrapper .erro_msg").text("");
			    var num=$("#append-out .receivables_info_box").length;	
	    		for(var i=num-1;i>=0;i--){
	    			if(i==0){
	    				payeeName=$("#append-out .receivables_info_box").eq(i).find(".payee_name1").find("option:selected").text("");
	        			payeeAccount=$("#append-out .receivables_info_box").eq(i).find(".shipper_account1").val("");
	        			bank=$("#append-out .receivables_info_box").eq(i).find(".bank_name1").val("");
	        			branchMessage=$("#append-out .receivables_info_box").eq(i).find(".branch_message1").val("");
	        			$("#append-out .receivables_info_box").eq(i).hide();
	    			}else{
	    				$("#append-out .receivables_info_box").eq(i).remove();
	    			}
	           }
			  
		}
	});
	
	//手机号text的离焦事件
	$("#shipper_mobile").blur(function(event){
        if($(this).val()==""||$(this).val()==null){
        	$(".unpayment_message_error1").text("此项需输入手机号").css("color","red");
        	$("#unpayment_message").attr("checked",false);
    		var num=$("#append-out .receivables_info_box").length;	
    		for(var i=num-1;i>=0;i--){
    			if(i==0){
    				payeeName=$("#append-out .receivables_info_box").eq(i).find(".payee_name1").find("option:selected").text("");
        			payeeAccount=$("#append-out .receivables_info_box").eq(i).find(".shipper_account1").val("");
        			bank=$("#append-out .receivables_info_box").eq(i).find(".bank_name1").val("");
        			branchMessage=$("#append-out .receivables_info_box").eq(i).find(".branch_message1").val("");
        			$("#append-out .receivables_info_box").eq(i).hide();
    			}else{
    				$("#append-out .receivables_info_box").eq(i).remove();
    			}
           }
        }
    });
	
	//继续添加待收货款信息
	var inner1=$("#unpayment_message_checked").html();
	$("#append-out .receivables_info_box .btn_highlight").live('click',function(event){	  //继续添加
		var fatherBox = $(this).parent().parent();
		$("#append-out").append('<div class="receivables_info_box border-all">'+inner1+'<div>');
		var num=$("#append-out .receivables_info_box").length;
		if(num>=2){
			for(var i=0;i<num-1;i++){
				//移除继续添加和取消按钮
				$("#append-out .receivables_info_box").eq(i).find(".easyDialog_footer").hide();
				//设置上面的数据不能被修改
			}
		}
	
		var array=new Array();
		var shipper_name=$("#shipper_name").val();
		var shipper_company=$("#shipper_company").val();
		if(shipper_name!=null && shipper_name!=""){
			array[0]=shipper_name;
		}
		if(shipper_company!=null && shipper_company!="" && shipper_company!="若需开票，需必填，与开票公司抬头保持一致"){
			array[1]=shipper_company;
		}
		$.each(array,function(n,value){
			$("#append-out .receivables_info_box").eq(num-1).find(".payee_name1").append("<option value='"+n+"'>"+value+"</option>"); 
		});				
		
		$("#easyDialogWrapper .erro").css("display","none");
		$("#easyDialogWrapper .erro_msg").empty();
		
		//重新初始化选择省市区控件
		initCityControl();
		initCityControl2();
	});
	
	//取消	
	$(".receivables_info_box .btn_normal").live('click',function(event){	  
		var n=$("#append-out .receivables_info_box").length;
		if(n==1){
			$(this).parent().parent().hide();
			 $('#unpayment_message').attr("checked",false);
		}else{
			$(this).parent().parent().remove();
		}				
		var num=$("#append-out .receivables_info_box").length;	
		if(num>=2){
			for(var i=0;i<num-1;i++){
			//移除继续添加和取消按钮
			$("#append-out .receivables_info_box").eq(i).find(".easyDialog_footer").hide();
			}
			$("#append-out .receivables_info_box").eq(num-1).find(".easyDialog_footer").show();
		}else {
			$("#append-out .receivables_info_box").eq(0).find(".easyDialog_footer").show();
		}
	});

	//新增时发货人或者公司名称修改离焦，下拉框的值改变
	$("#shipper_name").live('blur',function(event){
		var array=new Array();
		var shipper_name=$("#shipper_name").val();
		var shipper_company=$("#shipper_company").val();
		if(shipper_name!=null && shipper_name!=""){
			array[0]=shipper_name;
		}
		if(shipper_company!=null && shipper_company!="" && shipper_company!="若需开票，需必填，与开票公司抬头保持一致"){
			array[1]=shipper_company;
		}
		var num=$("#append-out .receivables_info_box").length;	
		for(var i=0;i<num;i++){
			$("#append-out .receivables_info_box").eq(i).find(".payee_name1").empty();
			$.each(array,function(n,value){
				$("#append-out .receivables_info_box").eq(i).find(".payee_name1").append("<option value='"+n+"'>"+value+"</option>"); 
			});
		}
	});
	
	//新增时发货人或者公司名称修改离焦，下拉框的值改变
	$("#shipper_company").live('blur',function(event){
		var array=new Array();
		var shipper_name=$("#shipper_name").val();
		var shipper_company=$("#shipper_company").val();
		if(shipper_name!=null && shipper_name!=""){
			array[0]=shipper_name;
		}
		if(shipper_company!=null && shipper_company!="" && shipper_company!="若需开票，需必填，与开票公司抬头保持一致"){
			array[1]=shipper_company;
		}
		var num=$("#append-out .receivables_info_box").length;	
		for(var i=0;i<num;i++){
			$("#append-out .receivables_info_box").eq(i).find(".payee_name1").empty();
			$.each(array,function(n,value){
				$("#append-out .receivables_info_box").eq(i).find(".payee_name1").append("<option value='"+n+"'>"+value+"</option>"); 
			});
		}
	});
	
	//根据银行卡号得到银行名称
	$(".shipper_account1").live('blur',function(event){
			var num=$(this).val();
			if(isNaN(num)){
				add_errTips("银行卡号输入有误，请重新输入！");
				$(this).parent().siblings().find(".bank_name1").val("");
				return;
			}
			/*
			if(num.length<16||num.length>19){
				add_errTips("银行卡号输入有误，请重新输入！");
				$(this).parent().siblings().find(".bank_name1").val("");
				return;
			}
			*/
			var $this=$(this);
			param={"idCard":num};
			$.post("queryBank.action",param,
					  function(data,status){
				  if(status == 'success'  && data.bankName != null && data.bankName !=""){
					  $this.parent().siblings().find(".bank_name1").val(data.bankName);
					  $this.parent().siblings().find(".bank_name1").attr("readonly",true);
					  $("#easyDialogWrapper .erro").css("display","none");
					  $("#easyDialogWrapper .erro_msg").empty();
				  }else{
					  $this.parent().siblings().find(".bank_name1").val("");
					  $this.parent().siblings().find(".bank_name1").attr("readonly",false);
//					  add_errTips("银行卡号输入有误，请重新输入！");
				  }
			  }
		);
	});
	
	//手机号text框的聚焦事件
	$("#append-out .bank_name1").focus(function(event){
		     add_errTips("输入正确银行卡号后，自动显示银行");
			});
	
	//修改联系人   发货
	$("#shipper_update_save_btn").click(function(){
		//校验是否有修改时的错误信息
		if($("#easyDialogWrapper_update .erro_msg").text()!="")return;
		//校验待收货款信息中是否有空值
		var rootClass = $("#append_update .receivables_info_box");
		var num = rootClass.length;
		if($("#unpayment_message2").is(':checked')&&num==1){
			var payeeName = rootClass.eq(0).find(".payee_name2").find("option:selected").text();
			var payeeAccount = rootClass.eq(0).find(".shipper_account2").val();
			var bank = rootClass.eq(0).find(".bank_name2").val();
			var branchMessageCode = rootClass.eq(0).find(".branch_message2")[0].code;
			var branchMessageName = rootClass.eq(0).find(".branch_message2").val();
			
			if(branchMessageCode == null || branchMessageCode == "" || branchMessageName == ""){
				add_errTips("请选择预选开户行信息");
		    	return;
			}
			
			var ascriptionCity = rootClass.eq(0).find(".ascriptionCity2");
		    if(payeeName == "" || payeeAccount == "" || bank == "" || ascriptionCity.val() == ascriptionCity.attr("ov")){
		    	update_errTips("待收货款信息不能有空值");
		    	return;
		     }
		}
		
		for(var i=1;i<num;i++){
			var payeeName = rootClass.eq(i).find(".payee_name2").find("option:selected").text();
			var payeeAccount = rootClass.eq(i).find(".shipper_account2").val();
			var bank = rootClass.eq(i).find(".bank_name2").val();
			var branchMessageCode = rootClass.eq(i).find(".branch_message2")[0].code;
			var branchMessageName = rootClass.eq(i).find(".branch_message2").val();
			
			if(branchMessageCode == null || branchMessageCode == "" || branchMessageName == ""){
				add_errTips("请选择预选开户行信息");
		    	return;
			}
			var ascriptionCity = rootClass.eq(i).find(".ascriptionCity2");
		    if(payeeName == "" || payeeAccount == "" || bank == "" || ascriptionCity.val() == ascriptionCity.attr("ov")){
		    	update_errTips("待收货款信息不能有空值");return;
		     }
		  }
		
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
		
		var shipper_dept_district = $("#shipper_update_dept_district").val();//发货网点所对应省市区
		if(shipper_district == "请选择城市名称" || isBlank(shipper_district)){
			shipper_district = "";
		}
		var shipper_dept_name = $("#shipper_update_dept_name option:selected").text();//发货网点名称
		var contactsId = $("#ebsa_id").text();
		var logisticCode=$("#shipper_update_dept_name").val(); 
		var shipper_update_company = $("#shipper_update_company").val();
		if($("#shipper_update_company").val() == $("#shipper_update_company").attr("ov")){
			shipper_update_company = "";
		}
		
		var list = new Array();
		//获取待收货款信息
		for(var i=0;i<num;i++){
			var UnpayMentEntity ={};
			UnpayMentEntity.payeeName=rootClass.eq(i).find(".payee_name2").find("option:selected").text();
			UnpayMentEntity.payeeAccount=rootClass.eq(i).find(".shipper_account2").val();
			UnpayMentEntity.bank=rootClass.eq(i).find(".bank_name2").val();
			UnpayMentEntity.branchMessageCode = rootClass.eq(i).find(".branch_message2")[0].code;
			UnpayMentEntity.branchMessageName = rootClass.eq(i).find(".branch_message2").val();
			UnpayMentEntity.district = rootClass.eq(i).find(".ascriptionCity2").val();
			UnpayMentEntity.oldEsuId=rootClass.eq(i).find(".ebsa_id2").text();
			UnpayMentEntity.ebuEbsaId=$("#ebsa_id").text();
			list.push(UnpayMentEntity);
		}
		var str = JSON.stringify(list);
		var param = {
			"contactsEntity.ebsaId":contactsId,
			"contactsEntity.ebsaContact":shipper_name,
		    "contactsEntity.ebsaMobile":shipper_mobile,
		    "contactsEntity.ebsaContactAreaCode":shipper_telephone_area_no,
		    "contactsEntity.ebsaContactTel":shipper_telephone,
		    "contactsEntity.ebsaEbpvName":pcd[0],
		    "contactsEntity.ebsaEbplName":pcd[1],
		    "contactsEntity.ebsaEbcoName":pcd[2],
		    "contactsEntity.ebsaAddress":shipper_address_detail,
		    "contactsEntity.ebsaType":"shipper",
		    "contactsEntity.ebsaDeptDistrict":shipper_dept_district,
		    "contactsEntity.ebsaEscoSecondCode":logisticCode,
		    "contactsEntity.ebsaEscoSecondName":shipper_dept_name,
		    "contactsEntity.ebsaCompany":shipper_update_company,
		    "unpayMentString":str
		};
		$.post("updateContacts.action",param,
			  function(data,status){
				  if(status == 'success' && data.success == false){
					  update_errTips(data.message)
				  }else{
					  //TODO XUJUN
					  window.location.href = "contacts_shipperManage.action";
				  }
			  }
		);
	});

	//修改连续人时继续添加待收货款信息
	var inner2=$("#unpayment_message_checked2").html();
	$("#append_update .receivables_info_box .btn_highlight").live('click',function(event){	  //继续添加
		var fatherBox = $(this).parent().parent();
		$("#append_update").append('<div class="receivables_info_box border-all">'+inner2+'<div>');
		
		var num=$("#append_update .receivables_info_box").length;
		if(num>=2){
			for(var i=0;i<num-1;i++){
			//移除继续添加和取消按钮
			$("#append_update .receivables_info_box").eq(i).find(".easyDialog_footer").hide();
			}
		}
		var array=new Array();
		var shipper_update_name=$("#shipper_update_name").val();
		var shipper_update_company=$("#shipper_update_company").val();
		if(shipper_update_name!=null && shipper_update_name!=""){
			array[0]=shipper_update_name;
		}
		if(shipper_update_company!=null && shipper_update_company!="" && shipper_update_company!="若需开票，需必填，与开票公司抬头保持一致"){
			array[1]=shipper_update_company;
		}
		$.each(array,function(n,value){
			$("#append_update .receivables_info_box").eq(num-1).find(".payee_name2").append("<option value='"+n+"'>"+value+"</option>"); 
		});
		$("#easyDialogWrapper_update .erro").css("display","none");
		$("#easyDialogWrapper_update .erro_msg").empty();
	});
	
	//修改待收货款信息时取消	
	$(".receivables_info_box .btn_normal").live('click',function(event){	  
		var n=$("#append_update .receivables_info_box").length;
		if(n==1){
			$(this).parent().parent().hide();
			 $('#unpayment_message2').attr("checked",false);
		}else{
			$(this).parent().parent().remove();
		}				
		var num=$("#append_update .receivables_info_box").length;	
		if(num>=2){
			for(var i=0;i<num-1;i++){
			//移除继续添加和取消按钮
			$("#append_update .receivables_info_box").eq(i).find(".easyDialog_footer").hide();
			}
			$("#append_update .receivables_info_box").eq(num-1).find(".easyDialog_footer").show();
			
		}else {
			$("#append_update .receivables_info_box").eq(0).find(".easyDialog_footer").show();
			
		}
	});
	
	//修改时根据银行卡号得到银行名称
	$(".shipper_account2").live('blur',function(event){
			var num=$(this).val();
			if(isNaN(num)){
				update_errTips("银行卡号输入有误，请重新输入！");
				$(this).parent().siblings().find(".bank_name2").val("");
				return;
			}
			/*
			if(num.length<16||num.length>19){
				update_errTips("银行卡号输入有误，请重新输入！");
				$(this).parent().siblings().find(".bank_name2").val("");
				return;
			}
			*/
			var $this=$(this);
			param={"idCard":num};
			$.post("queryBank.action",param,
					  function(data,status){
				  if(status == 'success' && data.bankName != null && data.bankName !=""){
					  $this.parent().siblings().find(".bank_name2").val(data.bankName);
					  $this.parent().siblings().find(".bank_name2").attr("readonly",true);
					  $("#easyDialogWrapper .erro").css("display","none");
					  $("#easyDialogWrapper .erro_msg").empty();
				  }else{
					  $this.parent().siblings().find(".bank_name2").val("");
					  $this.parent().siblings().find(".bank_name2").attr("readonly",false);
//					  update_errTips("银行卡号输入有误，请重新输入！");
				  }
			  }
		);
		
	});
	
	//修改时发货人或者公司名称修改离焦，下拉框的值改变
	$("#shipper_update_name").live('blur',function(event){
		var array=new Array();
		var shipper_update_name=$("#shipper_update_name").val();
		var shipper_update_company=$("#shipper_update_company").val();
		if(shipper_update_name!=null && shipper_update_name!=""){
			array[0]=shipper_update_name;
		}
		if(shipper_update_company!=null && shipper_update_company!="" && shipper_update_company!="若需开票，需必填，与开票公司抬头保持一致"){
			array[1]=shipper_update_company;
		}
		var num=$("#append_update .receivables_info_box").length;	
		for(var i=0;i<num;i++){
			$("#append_update .receivables_info_box").eq(i).find(".payee_name2").empty();
			$.each(array,function(n,value){
				$("#append_update .receivables_info_box").eq(i).find(".payee_name2").append("<option value='"+n+"'>"+value+"</option>"); 
			});
		}
	});
	//修改时发货人或者公司名称修改离焦，下拉框的值改变
	$("#shipper_update_company").live('blur',function(event){
		var array=new Array();
		var shipper_update_name=$("#shipper_update_name").val();
		var shipper_update_company=$("#shipper_update_company").val();
		if(shipper_update_name!=null && shipper_update_name!=""){
			array[0]=shipper_update_name;
		}
		if(shipper_update_company!=null && shipper_update_company!="" && shipper_update_company!="若需开票，需必填，与开票公司抬头保持一致"){
			array[1]=shipper_update_company;
		}
		var num=$("#append_update .receivables_info_box").length;	
		for(var i=0;i<num;i++){
			$("#append_update .receivables_info_box").eq(i).find(".payee_name2").empty();
			$.each(array,function(n,value){
				$("#append_update .receivables_info_box").eq(i).find(".payee_name2").append("<option value='"+n+"'>"+value+"</option>"); 
			});
		}
	});
	
	//修改时判断发货人信息中，发货人手机号或者固定电话是否已填
	$("#unpayment_message2").click(function(){
		if($("#unpayment_message2").is(':checked')){
			$("#append_update .receivables_info_box").eq(0).find(".easyDialog_footer").show();
			var shipper_update_mobile=$("#shipper_update_mobile").val();
			if(shipper_update_mobile==""){
				$(".unpayment_message_error2").text("此项需输入手机号").css("color","red");
				$("#unpayment_message2").attr("checked",false);
			}else if(shipper_update_mobile!=""){
				$(".unpayment_message_error2").text("");
				$("#unpayment_message_checked2").css("display","block");
				var array=new Array();
				var shipper_update_name=$("#shipper_update_name").val();
				var shipper_update_company=$("#shipper_update_company").val();
				if(shipper_update_name!=null && shipper_update_name!=""){
					array[0]=shipper_update_name;
				}
				if(shipper_update_company!=null && shipper_update_company!="" && shipper_update_company!="若需开票，需必填，与开票公司抬头保持一致"){
					array[1]=shipper_update_company;
				}
				$(".payee_name2").empty();
				$.each(array,function(n,value){
					$(".payee_name2").append("<option value='"+n+"'>"+value+"</option>"); 
				});
			}
		  }else{
			  $("#easyDialogWrapper_update .erro").hide();
			  $("#easyDialogWrapper_update .erro_msg").text("");
			  var num=$("#append_update .receivables_info_box").length;	
	    	  for(var i=num-1;i>=0;i--){
	    			if(i==0){
	    				payeeName=$("#append_update .receivables_info_box").eq(i).find(".payee_name2").find("option:selected").text("");
	        			payeeAccount=$("#append_update .receivables_info_box").eq(i).find(".shipper_account2").val("");
	        			bank=$("#append_update .receivables_info_box").eq(i).find(".bank_name2").val("");
	        			branchMessage=$("#append_update .receivables_info_box").eq(i).find(".branch_message2").val("");
	        			$("#append_update .receivables_info_box").eq(i).hide();
	    			}else{
	    				$("#append_update .receivables_info_box").eq(i).remove();
	    			}
	           }
		}
	});
	

	//修改时手机号text的离焦事件
	$("#shipper_update_mobile").blur(function(event){
        if($(this).val()==""||$(this).val()==null){
        	$(".unpayment_message_error2").text("此项需输入手机号").css("color","red");
        	$("#unpayment_message2").attr("checked",false);
    		var num=$("#append_update .receivables_info_box").length;	
    		for(var i=num-1;i>=0;i--){
    			if(i==0){
    				payeeName=$("#append_update .receivables_info_box").eq(i).find(".payee_name2").find("option:selected").text("");
        			payeeAccount=$("#append_update .receivables_info_box").eq(i).find(".shipper_account2").val("");
        			bank=$("#append_update .receivables_info_box").eq(i).find(".bank_name2").val("");
        			branchMessage=$("#append_update .receivables_info_box").eq(i).find(".branch_message2").val("");
        			$("#append_update .receivables_info_box").eq(i).hide();
    			}else{
    				$("#append_update .receivables_info_box").eq(i).remove();
    			}
           }
        }
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
		var url = "setDefaultContacts.action?contactsIds=" + id +"&contactsType=shipper";
		$.get(url,function(data,status){
	    	if(status == 'success' && data.success == false){
	    		//TODO 异常处理
	    	}else{
	    		window.location.href = "contacts_shipperManage.action";
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
	    		loadUpdateShapperContacts(contacts.ebsaEscoSecondCode);
	    		$("#shipper_update_company").val(contacts.ebsaCompany);
	    		$("#shipper_update_company").removeClass("grays");
	    		//删除灰色字体样式
	    		$("#shipper_update_district").removeClass("grays");
	    		$("#shipper_update_dept_district").removeClass("grays");
	    		$("#easyDialogWrapper_update .erro").hide();
	    		$("#easyDialogWrapper_update .erro_msg").text("");
	    		//将待收货款信息加载之前先删除上传添加的数据
	    		var first=$("#append_update .receivables_info_box").length;
	    		if(first>=2){
	    			for(var j=1;j<first;j++){
	    				$("#append_update .receivables_info_box").eq(j).remove();
	    				$("#append_update .receivables_info_box").eq(j-1).find(".easyDialog_footer").show();
	    			}
	    		}
	    		
	    		$("#append_update .receivables_info_box").eq(0).find(".payee_name2").empty();
	    		$("#append_update .receivables_info_box").eq(0).find(".shipper_account2").val("");
	    		$("#append_update .receivables_info_box").eq(0).find(".bank_name2").val("");
	    		$("#append_update .receivables_info_box").eq(0).find(".branch_message2").val("");
	    		$("#append_update .receivables_info_box").eq(0).find(".branch_message2")[0].code = "";
	    		$("#append_update .receivables_info_box").eq(0).find(".ascriptionCity2").val("请选择城市名称");
	    		$("#append_update .receivables_info_box").eq(0).find(".ascriptionCity2").removeClass("grays");
	    		$("#append_update .receivables_info_box").eq(0).find(".ebsa_id2").text("");
	    		
	    		$('#unpayment_message2').attr("checked",false);
	    		$('#unpayment_message_checked2').css("display","none");
	    		//拿到待收货款数据到unpayMentList集合
	    		var inner2=$("#unpayment_message_checked2").html();
	    		var unpayMentList=new Array();
	    		unpayMentList=data.unpayMentList;
	    		//待收货款有几条数据，添加几条回显框,并将数据添加到里面
	    		if(unpayMentList.length!=0){
	    			 $('#unpayment_message2').attr("checked",true);
	    			 $('#unpayment_message_checked2').css("display","block");
	    			 for(var i=0;i<unpayMentList.length-1;i++){
	    				 $("#append_update").append('<div class="receivables_info_box border-all">'+inner2+'<div>');
	    				//移除继续添加和取消按钮
	    				 $("#append_update .receivables_info_box").eq(i).find(".easyDialog_footer").hide();
	    			 }
	    			 var num=$("#append_update .receivables_info_box").length;
	    			 for(var i=0;i<num;i++){
	    				var g=unpayMentList[i].payeeName;
	    				var m=unpayMentList[i].payeeAccount;
	    				var k=unpayMentList[i].bank;
	    				var branchMessageCode=unpayMentList[i].branchMessageCode;
	    				var branchMessageName=unpayMentList[i].branchMessageName;
	    				var district=unpayMentList[i].district;
	    				var h=unpayMentList[i].ebuEbsaId;
	    				$("#append_update .receivables_info_box").eq(i).find(".shipper_account2").val(m);
	    				$("#append_update .receivables_info_box").eq(i).find(".bank_name2").val(k);
	    				$("#append_update .receivables_info_box").eq(i).find(".ascriptionCity2").val(district);
	    				$("#append_update .receivables_info_box").eq(i).find(".ascriptionCity2").removeClass("grays");
	    				$("#append_update .receivables_info_box").eq(i).find(".branch_message2").val(branchMessageName);
	    				$("#append_update .receivables_info_box").eq(i).find(".branch_message2")[0].code = branchMessageCode;
	    				$("#append_update .receivables_info_box").eq(i).find(".ebsa_id2").text(h);
	    				var array=new Array();
	    				var shipper_update_name=$("#shipper_update_name").val();
	    				var shipper_update_company=$("#shipper_update_company").val();
	    				if(shipper_update_name!=null && shipper_update_name!=""){
	    					array[0]=shipper_update_name;
	    				}
	    				if(shipper_update_company!=null && shipper_update_company!="" && shipper_update_company!="若需开票，需必填，与开票公司抬头保持一致"){
	    					array[1]=shipper_update_company;
	    				}
	    				$("#append_update .receivables_info_box").eq(i).find(".payee_name2").empty();
	    				$.each(array,function(n,value){
	    					if(value==g){
	    						$("#append_update .receivables_info_box").eq(i).find(".payee_name2").append("<option value='"+n+"' selected='selected'>"+value+"</option>");
	    					}else{
	    						$("#append_update .receivables_info_box").eq(i).find(".payee_name2").append("<option value='"+n+"'>"+value+"</option>");
	    					}
	    				});
	    			 }
	    		}
	    		//重新初始化选择省市区控件
	    		initCityControl();
	    		initCityControl2();
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

function loadUpdateShapperContacts(logistCode){
	var attr;
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
    			if(logistCode != null && logistCode == array[i].logistCode){
					attr = "selected='selected'";
				}else{
					attr = "";
				}
    			var dept = array[i];
    			var deptCode = dept.logistCode;
    			var deptName = dept.deptName;
    			$("<option value='"+dept.logistCode+"' " + attr + ">"+deptName+"</option>").appendTo("#shipper_update_dept_name")
    		}
	    }
    });
}

/**
 * 加载发货人网点
 * @author 龙海仁
 * @date 2015年9月7日上午11:19:13
 * @update
 */
function loadShapperContacts(){
	var typeValue = $("#shipper_dept_district").val();
	if(typeValue == null || typeValue.indexOf("-") < 0) return;
	var url = "companyMatchAction!queryDeptByDistrictNameJson.action";
	$.post(url,{
		typeValue:typeValue
	},function(data,status){
    	if(status == 'success' && data.success == false){
    		add_errTips(data.message)
    	}else{
    		var array = data.departmentVos;
    		$("#shipper_dept_name").empty();
    		for(var i = 0; i < array.length; i++){
    			var dept = array[i];
    			var logistCode = dept.logistCode;
    			var deptName = dept.deptName;
    			$("<option value='"+logistCode+"'>"+deptName+"</option>").appendTo("#shipper_dept_name")
    		}
	    }
    });
}

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
	    		window.location.href = "contacts_shipperManage.action";
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
    		window.location.href = "contacts_shipperManage.action";
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

/*
通用: 自动补全(仿百度搜索框)
*/
var Bind = function(object, fun) {
    return function() {
        return fun.apply(object, arguments);
    }
}
function AutoComplete(obj,divId){
    this.obj=obj;        //输入框
    this.autoObj = $(this.obj).parent().find("div")[0];
    this.shipperDiv=document.getElementById(divId);
    var autoCom = this;
    $(this.shipperDiv).scroll(
    	function(){
    		autoCom.init();
    	}
    );
    this.index=-1;          //当前选中的DIV的索引
    this.search_value="";   //保存当前搜索的字符
}
function startComplete(input,shipperDivId,event){
	new AutoComplete(input,shipperDivId).start(event);
}
AutoComplete.prototype={
    //初始化DIV的位置
    init: function(){
        this.autoObj.style.left = this.obj.offsetLeft + "px";
        this.autoObj.style.top  = this.obj.offsetTop + this.obj.offsetHeight - this.shipperDiv.scrollTop + "px";
        this.autoObj.style.width= this.obj.offsetWidth - 2 + "px";//减去边框的长度2px
    },
    //删除自动完成需要的所有DIV
    deleteDIV: function(){
        while(this.autoObj.hasChildNodes()){
            this.autoObj.removeChild(this.autoObj.firstChild);
        }
        this.autoObj.className="auto_hidden";
    },
    //设置值
    setValue: function(_this){
        return function(){
            _this.obj.value=this.seq;
            _this.obj.code=this.code;
            _this.autoObj.className="auto_hidden";
        }       
    },
    //模拟鼠标移动至DIV时，DIV高亮
    autoOnmouseover: function(_this,_div_index){
        return function(){
            _this.index=_div_index;
            var length = _this.autoObj.children.length;
            for(var j=0;j<length;j++){
                if(j!=_this.index ){       
                    _this.autoObj.childNodes[j].className='auto_onmouseout';
                }else{
                    _this.autoObj.childNodes[j].className='auto_onmouseover';
                }
            }
        }
    },
    //更改classname
    changeClassname: function(length){
        for(var i=0;i<length;i++){
            if(i!=this.index ){       
                this.autoObj.childNodes[i].className='auto_onmouseout';
            }else{
                this.autoObj.childNodes[i].className='auto_onmouseover';
                this.obj.value=this.autoObj.childNodes[i].seq;
                this.obj.code=this.autoObj.childNodes[i].code;
            }
        }
    }
    ,
    //响应键盘
    pressKey: function(event){
        var length = this.autoObj.children.length;
        //光标键"↓"
        if(event.keyCode==40){
            ++this.index;
            if(this.index>length){
                this.index=0;
            }else if(this.index==length){
                this.obj.value=this.search_value;
            }
            this.changeClassname(length);
        }
        //光标键"↑"
        else if(event.keyCode==38){
            this.index--;
            if(this.index<-1){
                this.index=length - 1;
            }else if(this.index==-1){
                this.obj.value=this.search_value;
            }
            this.changeClassname(length);
        }
        //回车键
        else if(event.keyCode==13){
            this.autoObj.className="auto_hidden";
            this.index=-1;
        }else{
            this.index=-1;
        }
    },
    //程序入口
    start: function(event){
        if(event.keyCode!=13&&event.keyCode!=38&&event.keyCode!=40){
            this.init();
            //将当前所有层清空
            this.deleteDIV();
            this.search_value=this.obj.value;
            if(this.obj.value.replace(/(^\s*)|(\s*$)/g,'')==""){ return; }//值为空，退出
            try{ var reg = new RegExp("(" + this.obj.value + ")","i");}
            catch (e){ return; }
            var div_index=0;//记录创建的DIV的索引
            var currentObj = this;
            $.post("bankInfoAction!queryBankInfoJson.action",{
            	bankName:this.search_value
        	},function(data,status){
        		var list = data.bankInfoList;
        		if(list == null || list.length == 0){
        			return;
        		}
        		//这里需要再删除一次，因为有异步情况
        		while(currentObj.autoObj.hasChildNodes()){
        			currentObj.autoObj.removeChild(currentObj.autoObj.firstChild);
                }
        		//这里要清空一次code
        		currentObj.obj.code = "";
        		for(var i = 0 ; i < list.length; i++){
	        		var div = document.createElement("div");
	                div.className="auto_onmouseout";
	                div.seq=list[i].name;
	                div.code=list[i].code;
	                div.onclick=currentObj.setValue(currentObj);
	                div.onmouseover=currentObj.autoOnmouseover(currentObj,div_index);
	                div.innerHTML=list[i].name.replace(reg,"<strong>$1</strong>");//搜索到的字符粗体显示
	                currentObj.autoObj.appendChild(div);
	                currentObj.autoObj.className="auto_show";
	                div_index++;
        		}
            });
        }
        this.pressKey(event);
        window.onresize=Bind(this,function(){this.init();});
    }
}

