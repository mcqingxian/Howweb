var flag = false; //校验验证码
var isEntrustFlag = false; //是否委托
var isdeleteImg = true;
var isUploadSuccess = false;
var picPiece = 3;

var map;//保存已经上传的图片名称或查看路径
//图片张数和图片id编号
var field01Number = 0;
var field01NameNo = 0;
var field02Number = 0;
var field02NameNo = 0;
var field03Number = 0;
var field03NameNo = 0;
var field04Number = 0;
var field04NameNo = 0;
var field05Number = 0;
var field05NameNo = 0;
var field06Number = 0;
var field06NameNo = 0;
var field07Number = 0;
var field07NameNo = 0;
var field08Number = 0;
var field08NameNo = 0;


var destCompanyAddr=null;
var departCompanyAddr=null;
var waybillPiece=0;
var CompanyAddr=null;
var wayBillNo;
$(document).ready(function() {
	
	map =  new Map();
	
	//修改理赔
	if($("#imgMapid").val()!=null && $("#imgMapid").val()!=""){
		validWaybill();
		var  imgStr = $("#imgMapString").val();
		loadImgMessage(iGetInnerText(imgStr));
		
		loadFileUpload();
		
		$("#first_step").attr("class", "hide");
		$("#second_step").attr("class", "show");
		//更改理赔导航样式
		$("#div_step1").attr("class","");
		$("#div_step2").attr("class","claim_step_active");
	}
	
	//隐藏提示
	$("#isEntrust_y").hide();
	$("#cusClaim_Money_1000").hide();
	$("#waybill_Money_1000").hide();
	$("#danger_Type_2").hide();
	
	//下一步
	$("#to_second").click(function(){
		if(validate()){
			loadFileUpload();
			$("#first_step").attr("class", "hide");
			$("#second_step").attr("class", "show");
			
			//更改理赔导航样式
			$("#div_step1").attr("class","");
			$("#div_step2").attr("class","claim_step_active");
			//赋值
			$("#showWaybillNo").html($("#waybillNo").val());		
			$("#showWaybillTel").html($("#waybillTel").val());
			//$("#showClaimAddress").html(CompanyAddr);
			//jQuery("#claimAddress1  option:selected").val()
			$("#showClaimAddress").html($("#claimAddress1").find("option:selected").text());
		}
	});
	//上一步
	$("#to_first").click(function(){
		$("#first_step").attr("class", "show");
		$("#second_step").attr("class", "hide");
		//更改理赔导航样式
		$("#div_step1").attr("class","claim_step_active");
		$("#div_step2").attr("class","");
		validWaybillTel();
	});
	
	//根据是否勾选协议控制下一步按钮是否失效
	$("#isReaded").click(function(){
		//是否已读协议
		if($("#isReaded").is(':checked')) {
			$("#to_second").attr("disabled",false);
			$("#to_second").css("background", "#f15a22");
		}else{
			$("#to_second").attr("disabled",true);
			$("#to_second").css("background", "#b4b4b4");
		}
		
	});
	
	$("#saveDraft").click(function(){
			//校验通过提交
			submit("UN_SUBMIT");
	});
	
	$("#saveSubmit").click(function(){
		if(validSubmit()) {
			//校验通过提交
			submit("SUBMIT");
		}
	});
	
	// 校验第一页输入框
	// 运单
	$("#waybillNo").blur(function(){validWaybill();validWaybillTel();});
	// 理赔方
	//$("#claimUser").blur(function(){validClaim();});
	// 运单联系人
	$("#waybillTel").blur(function(){validWaybillTel();});
	//验证码输入框失去焦点 ajax 异步验证
	$("#validCode").blur(function(){validValidCode();});
	//校验第二页输入框
    // 是否委托
	//$("#isEntrust").blur(function(){validIsEntrust();});
    // 索赔人姓名或公司名称
	$("#claimNameOrComp").blur(function(){validClaimNameOrComp();});
	//索赔人手机号
	$("#claimUserTel").blur(function(){validClaimUserTel();});
	//邮箱格式校验
	$("#claimEmail").blur(function(){validEmail();});
	//货物名称
	$("#cargoType").blur(function(){validCargoType();});
	//索赔金额
	$("#claimMoney").blur(function(){validClaimMoney();});
	//异常件数
	$("#exceptionPiece").blur(function(){validExceptionPiece();});
	//出险类型
	$("#dangerType").blur(function(){validDangerType();});
	//理赔原因及其他
	$("#claimReason").blur(function(){validClaimReason();});
	/**校验用户开户行信息输入框，田育林，2016-06-06**/
	//用户开户名
	$("#accountName").blur(function(){validAccountName();});
	//用户银行账号
	$("#accountCode").blur(function(){validAccountCode();});
	//开户行所在省市县
	$("#accountCity").blur(function(){validAccountCity();});
	//开户行名称
	$("#accountBank").blur(function(){validAccountBank();});
	
	$("#queryClaim").click(function(){
		var waybill = $("#queryBillNoId").val();
		var status = $("#queryStatusId option:selected").val();
		window.location.href = "queryclaim.action?claimSubmitEntity.billNo="+waybill+"&claimSubmitEntity.status="+status;
	});
	
	
	$("#claim_btn_del").click(function(){
		$.post("requestClaim!delete.action", {
			"claimSubmitEntity.billNo" : wayBillNo // 理赔运单编号
		}, function(data, status) {
			if (status == 'success' && data.success == true) {
				window.location.href = "queryclaim.action";
			} else {
				//TODO XUJUN 处理
				alert("服务器异常");
			}
		});
	});
	
	$("#claim_btn_confirm").click(function(){
			$.post("requestClaim!amountConfirm.action", {
				"claimSubmitEntity.billNo" : wayBillNo // 理赔运单编号
			}, function(data, status) {
				if (status == 'success' && data.success == true) {
					window.location.href = "queryclaim.action";
				} else {
					//TODO XUJUN 处理
					alert("服务器异常");
				}
			});
		});
});

//提交
function submit(status) {
	
	$("#to_first").attr('disabled',"true");
	$("#saveDraft").attr('disabled',"true");
	$("#saveSubmit").attr('disabled',"true");
	$("#to_first").css("background", "#b4b4b4");
	$("#saveDraft").css("background", "#b4b4b4");
	$("#saveSubmit").css("background", "#b4b4b4");
	 $("#errorMessageId").html("");
	var contactName = ($("#claimNameOrComp").val() == null || $("#claimNameOrComp").val()=="" || $("#claimNameOrComp").val()=="需与收款人保持一致")?"":$("#claimNameOrComp").val();
	var contactTel = ($("#claimUserTel").val() == null || $("#claimUserTel").val()=="" || $("#claimUserTel").val()=="请输入手机号")?"":$("#claimUserTel").val();
	var money = ($("#claimMoney").val()==null||$("#claimMoney").val()=="" || $("#claimMoney").val()=="金额不得超过3000元")?"0":$("#claimMoney").val();
	var piece = ($("#exceptionPiece").val()==null||$("#exceptionPiece").val()=="" ||$("#exceptionPiece").val()=="不得大于运单实际件数")?"0":$("#exceptionPiece").val();
	//var claimCompanyAddr=$("#showClaimAddress").html();
	var claimCompanyAddr=$.trim($("#showClaimAddress").html());
	$.post("requestClaim!submit.action",{
	    "claimSubmitEntity.billNo":$("#waybillNo").val(), //理赔运单编号
	   // "claimSubmitEntity.claimParty":$("#claimUser").val(),//理赔方
	    "claimSubmitEntity.billTel":$("#waybillTel").val(),//运单上联系电话
	   // "claimSubmitEntity.claimCompanyAddr":$("#claimAddress1").find("option:selected").text(),//理赔公司所在地CompanyAddr
	    "claimSubmitEntity.claimCompanyAddr":claimCompanyAddr,//理赔公司所在地CompanyAddr
	   // "claimSubmitEntity.isEntrust":$("#isEntrust").val(),//是否委托办理
	    "claimSubmitEntity.contactName":contactName,//索赔人姓名或公司名称
	    "claimSubmitEntity.contactTel":contactTel,//索赔人手机号
	    "claimSubmitEntity.contactMail":$("#claimEmail").val(),//索赔人邮箱
	    "claimSubmitEntity.claimsAmount":money,//理赔金额
	    "claimSubmitEntity.cargoType":$("#cargoType").val(),//货物类型
	    "claimSubmitEntity.exceptionCount":piece,//异常件数
	    "claimSubmitEntity.accidentType":$("#dangerType").val(),//出险类型
	    "claimSubmitEntity.reason":$("#claimReason").val(),//理赔原因及其他
	    "claimSubmitEntity.imgMapString":map.toString(),//图片保存
	    "claimSubmitEntity.status":status,// 草稿 DRAFT,已提交  SUBMIT，
	    /**增加用户银行卡开户行的信息，田育林，2016-06-06**/
	    "claimSubmitEntity.accountName":$("#accountName").val(),//银行卡开户名
	    "claimSubmitEntity.accountCode":$("#accountCode").val(),//银行卡账号
	    "claimSubmitEntity.accountCity":$("#accountCity").val(),//开户行所在省市县
	    "claimSubmitEntity.accountBank":$("#accountBank").val(),//开户行名称
  },
  function(data,status){
	  if(status == 'success' && data.staute == false){
		  $("#errorMessageId").html(data.message);
	  }else if(data.staute == true ){ 
		  window.location.href = "queryclaim.action";
	  }else{
		  $("#errorMessageId").html("提交失败");
	  }
	  
	    $("#to_first").attr('disabled',"false");
		$("#saveDraft").attr('disabled',"false");
		$("#saveSubmit").attr('disabled',"false");
		$("#to_first").css("background", "#f15a22");
		$("#saveDraft").css("background", "#f15a22");
		$("#saveSubmit").css("background", "#f15a22");

  });
}

//后台获取数据加载图片
function loadImgMessage(value){
	var imgs=value.split(";"); //字符分割 
	for (i=0;i<imgs.length ;i++ ) 
	{ 
	   var img = imgs[i].split("=");
	   if(img[0]!="" && img[1]!="" ){
		   loadImg(img[0],img[1]);
	   }

	} 
}

//加载上传插件
function loadFileUpload(){
	 var iframe = false;
     if($.browser.msie  && $.browser.version < 10){ 
         iframe = true;
     }
	$("#fileField_01").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    //formData:{param1:"p1",param2:"p2"},
	    formData:{"imagePath":$("#waybillNo").val()+"/01"},
	    //如果需要额外添加参数可以在这里添加
	    done:function(e,result){
	        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
	        //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息
	        //返回的数据在result.result中，假设我们服务器返回了一个json对象
	      //  console.log(JSON.stringify(result.result)); 		    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield01").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
	
	$("#fileField_02").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/02"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield02").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
	
	$("#fileField_03").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/03"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield03").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
	
	$("#fileField_04").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/04"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield04").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
	
	$("#fileField_05").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/05"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield05").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
	
	/*	$("#fileField_06").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/06"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield06").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) */
		$("#fileField_07").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/07"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield07").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
	
	$("#fileField_08").fileupload({
	    url:"uploadClaim.action",
	    iframe: iframe,
	    dataType: 'json',
	    autoUpload: true,
	    formData:{"imagePath":$("#waybillNo").val()+"/08"},
	    done:function(e,result){	    	
	        var data = result.result;
        	if(data.staute==false && (data.uploadFileName == "" || data.uploadFileName == null || map.containsKey(data.uploadFileName))){
        		$("#erroTextfield08").html("<span class='icon_del'></span>"+data.message);
        	}else{
        		loadImg(data.uploadFileName,data.imagePath);	
        	}
	        
	    }
	}) 
}


/**
 * No 序号
 * nameNo 名称编号对应
 * url 访问图片url
 * del 删除需要的文件名
 */
function buildHtm(No,nameNo,url,del){
	map.put(del,url);
	//map[del] = url;
	$("#erroTextfield0"+No).html("");
	var input=" <li id=\"img_textfield0"+No+"_"+nameNo+"\">"+
	"<img src=\""+url+"\" width=\"66\" height=\"44\" />"+
		"<a href=\"javascript:removeLi0"+No+"(\'img_textfield0"+No+"_"+nameNo+"\',\'"+del+"\');\" class=\"btn_closed\"></a>"+
		"<div class=\"optype\">"+
			"<a href=\""+url+"\" class=\"makeup_lk makeUpPic\" target=\"_blank\" >查看</a>"+
		"</div>"+
	"</li>"
	$("#fileField_0"+No+"_showImg").append(input);
}

//待提交加载数据
function loadImg(name,url){
	
	var vNumber = "01";
	var position =name.indexOf("/");
	if( position !=-1){
		vNumber = name.substr(position+1,2);
	}
	switch(vNumber) {
	case "01":
		buildHtm("1",field01NameNo,url,name);
		field01Numberfunc();
		break;
	case "02":
		buildHtm("2",field02NameNo,url,name);
		field02Numberfunc();
		break;
	case "03":
		buildHtm("3",field03NameNo,url,name);
		field03Numberfunc();
		break;
	case "04":
		buildHtm("4",field04NameNo,url,name);
		field04Numberfunc();
		break;
	case "05":
		buildHtm("5",field05NameNo,url,name);
		field05Numberfunc();
		break;
/*	case "06":
		buildHtm("6",field06NameNo,url,name);
		field06Numberfunc();
		break;*/
	case "07":
		buildHtm("7",field07NameNo,url,name);
		field07Numberfunc();
		break;
	case "08":
		buildHtm("8",field08NameNo,url,name);
		field08Numberfunc();
		break;
	default:
	}
	
	
	
}



function field01Numberfunc(){
	if(field01Number==0){
		  field01NameNo = 0;
	}
	field01Number+=1;
	field01NameNo+=1;	
	if(field01Number>=picPiece){
 	      $('#fileField_01').attr("disabled",true);	
 	}
}

function field02Numberfunc(){
	if(field02Number==0){
		  field02NameNo = 0;
	}
	field02Number+=1;
	field02NameNo+=1;	
	if(field02Number>=picPiece){
 	      $('#fileField_02').attr("disabled",true);	
 	}
}

function field03Numberfunc(){
	if(field03Number==0){
		  field03NameNo = 0;
	}
	field03Number+=1;
	field03NameNo+=1;	
	if(field03Number>=picPiece){
 	      $('#fileField_03').attr("disabled",true);	
 	}
}

function field04Numberfunc(){
	if(field04Number==0){
		  field04NameNo = 0;
	}
	field04Number+=1;
	field04NameNo+=1;	
	if(field04Number>=picPiece){
 	      $('#fileField_04').attr("disabled",true);	
 	}
}

function field05Numberfunc(){
	if(field05Number==0){
		  field05NameNo = 0;
	}
	field05Number+=1;
	field05NameNo+=1;	
	if(field05Number>=picPiece){
 	      $('#fileField_05').attr("disabled",true);	
 	}
}

/*function field06Numberfunc(){
	if(field06Number==0){
		  field06NameNo = 0;
	}
	field06Number+=1;
	field06NameNo+=1;	
	if(field06Number>=picPiece){
 	      $('#fileField_06').attr("disabled",true);	
 	}
}*/

function field07Numberfunc(){
	if(field07Number==0){
		  field07NameNo = 0;
	}
	field07Number+=1;
	field07NameNo+=1;	
	if(field07Number>=picPiece){
 	      $('#fileField_07').attr("disabled",true);	
 	}
}

function field08Numberfunc(){
	if(field08Number==0){
		  field08NameNo = 0;
	}
	field08Number+=1;
	field08NameNo+=1;	
	if(field08Number>=picPiece){
 	      $('#fileField_08').attr("disabled",true);	
 	}
}



function deleteImg(path){

	$.get("requestClaim!deleteImg.action?imagePath="+path,function(data,status){
		if(data.isDeleted == false){
			isdeleteImg = false;
		}else{	
			//delete map[path]; 
			map.remove(path);
			isdeleteImg = true;
		}
	});
	
}


function removeLi01(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field01Number=field01Number-1;
		$('#fileField_01').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield01').val("");
	}
	
}

function removeLi02(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field02Number=field02Number-1;
		$('#fileField_btn_02').attr("disabled",false);
		$('#fileField_02').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield02').val("");
	}
	
}

function removeLi03(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field03Number=field03Number-1;
		$('#fileField_03').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield03').val("");
	}
	
}

function removeLi04(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field04Number=field04Number-1;
		$('#fileField_04').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield04').val("");
	}
	
}
function removeLi05(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field05Number=field05Number-1;
		$('#fileField_05').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield05').val("");
	}
	
}

/*function removeLi06(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field06Number=field06Number-1;
		$('#fileField_06').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield06').val("");
	}
	
}*/
function removeLi07(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field07Number=field07Number-1;
		$('#fileField_07').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield07').val("");
	}
	
}

function removeLi08(value,path){
	deleteImg(path);
	if(isdeleteImg){
		field08Number=field08Number-1;
		$('#fileField_08').attr("disabled",false);
		$("#"+value).remove();
		$('#textfield08').val("");
	}
	
}

//更改验证码
function changeCode(){  
	$("#validateCode_img").attr("src","genCheckCode.action?"+ new Date());
	$("#validCode").focus();
	flag = false;
	$("#erroValidCode").html(""); 
} 

//校验运单
function validWaybill(){
	if (isBlank($("#waybillNo").val()) || $.trim($("#waybillNo").val()) == $("#waybillNo").attr('ov')) {
		$("#erroWaybillNo").html("<span class='icon_del'></span>请输入理赔运单编号");
		return false;
	} else {
		var isupdate = false; 
		//修改不校验
        if($("#imgMapid").val()!=null && $("#imgMapid").val()!=""){
        	isupdate = true;
        }
		
        $.ajaxSetup({ 
			  async: true 
			  }); 
        
        var result = false;
		$.post("requestClaim!validBillNo.action", {
			/*"staute": isupdate,*/
			"claimValidEntity.billNo" : $("#waybillNo").val() // 理赔运单编号
		}, function(data, status) {
			if (status == 'success' && data.success == false) {
				$("#erroWaybillNo").html(data.message);
			}else if(data.success == null){
				$("#erroWaybillNo").html("运单号数据匹配");
			}else { 
				if(data.claimValidEntity != null && data.claimValidEntity.status=="FAIL"){
					$("#erroWaybillNo").html(data.claimValidEntity.errroInfo);
				}else{
					/*destCompanyAddr=data.claimValidEntity.destCompanyAddr;
					departCompanyAddr=data.claimValidEntity.departCompanyAddr;*/
				    waybillPiece = data.claimValidEntity.pieces;
					$("#erroWaybillNo").html("");
					result = true;
				}
			}
		});
		
		$.ajaxSetup({ 
			  async: true
			  });
		
		return result;
	}
	
}

//点击下一步的时候，进行验证时使用，田育林、2016-05-13
function validWaybill_next(){
	if (isBlank($("#waybillNo").val()) || $.trim($("#waybillNo").val()) == $("#waybillNo").attr('ov')) {
		$("#erroWaybillNo").html("<span class='icon_del'></span>请输入理赔运单编号");
		return false;
	} else {
		var isupdate = false; 
		//修改不校验
        if($("#imgMapid").val()!=null && $("#imgMapid").val()!=""){
        	isupdate = true;
        }
		
        $.ajaxSetup({ 
			  async: false 
			  }); 
        
        var result = false;
		$.post("requestClaim!validBillNo.action", {
			/*"staute": isupdate,*/
			"claimValidEntity.billNo" : $("#waybillNo").val() // 理赔运单编号
		}, function(data, status) {
			if (status == 'success' && data.success == false) {
				$("#erroWaybillNo").html(data.message);
			}else if(data.success == null){
				$("#erroWaybillNo").html("运单号数据匹配");
			}else { 
				if(data.claimValidEntity != null && data.claimValidEntity.status=="FAIL"){
					$("#erroWaybillNo").html(data.claimValidEntity.errroInfo);
				}else{
					/*destCompanyAddr=data.claimValidEntity.destCompanyAddr;
					departCompanyAddr=data.claimValidEntity.departCompanyAddr;*/
				    waybillPiece = data.claimValidEntity.pieces;
					$("#erroWaybillNo").html("");
					result = true;
				}
			}
		});

		$.ajaxSetup({ 
			  async: true
			  });
		
		return result;
	}
	
}

// 校验理赔方
/*function validClaim(){
	if(isBlank($("#claimUser").val())){
		$("#erroClaimUser").html("<span class='icon_del'></span>请选择理赔方");
		return false;
	}else{
		
		if($("#claimUser").val()=="DEPART") {
			$("#claimAddress").html(departCompanyAddr);
		}else{
			$("#claimAddress").html(destCompanyAddr);
		}
		
		$("#erroClaimUser").html("");
		return true;
	}
}*/

//校验运单联系人
function validWaybillTel(){
	if(validWaybill() && (isBlank($("#waybillTel").val()) || $.trim($("#waybillTel").val())==$("#waybillTel").attr('ov'))){
		$("#erroWaybillTel").html("<span class='icon_del'></span>请输入运单上联系电话");
		return false;
	}else{
		$.ajaxSetup({ 
			  async: false 
			  }); 
		var isTel = false;
		$.post("requestClaim!validClaimTel.action", {
			"claimValidEntity.billNo" : $("#waybillNo").val(), // 理赔运单编号
			"claimValidEntity.billTel" : $("#waybillTel").val() // 运单上联系电话
		}, function(data, status) {
			if (status == 'success' && data.success == false) {
				$("#erroWaybillTel").html(data.message);
			}else if(data.success == null){
				$("#erroWaybillTel").html("手机号码与运单号不匹配");
			}else {
				isTel = true;
				if(data.claimValidEntity.status == "1"){
					$("#claimAddress1").empty()
					CompanyAddr = data.claimValidEntity.departCompanyAddr;
					if(CompanyAddr.indexOf(",")!=-1){
						var obj1=CompanyAddr.split(',');
						$.each(obj1,function(n,value){
							$("#claimAddress1").append("<option value='"+n+"'>"+value+"</option>"); 
						});
					}
					if(CompanyAddr.indexOf(",")==-1){
				        //添加一个选项  
						$("#claimAddress1").append("<option value='"+CompanyAddr+"'>"+CompanyAddr+"</option>"); 
					}
					/*if(data.claimValidEntity.claimParty =="DEPART") {
						CompanyAddr=departCompanyAddr;
					}else{
						CompanyAddr=destCompanyAddr;
					}*/
					/*$("#claimAddress").html(CompanyAddr);*/
					$("#erroWaybillTel").html("");	
				}else{
					$("#erroWaybillTel").html(data.claimValidEntity.errroInfo);
					isTel = false;
				}
				
				/*if(data.staute == true){
					$("#erroWaybillTel").html("");
				}else{
					$("#erroWaybillTel").html("运单上联系电话不匹配");
					
				}*/
			}
		});
		
		$.ajaxSetup({ 
			  async: true 
			  }); 
		
		return isTel;
	}

}

//点击下一步校验运单联系人
function validWaybillTelNext(){
	if(validWaybill() && (isBlank($("#waybillTel").val()) || $.trim($("#waybillTel").val())==$("#waybillTel").attr('ov'))){
		$("#erroWaybillTel").html("<span class='icon_del'></span>请输入运单上联系电话");
		return false;
	}else{
		$.ajaxSetup({ 
			  async: false 
			  }); 
		var isTel = false;
		$.post("requestClaim!validClaimTel.action", {
			"claimValidEntity.billNo" : $("#waybillNo").val(), // 理赔运单编号
			"claimValidEntity.billTel" : $("#waybillTel").val() // 运单上联系电话
		}, function(data, status) {
			if (status == 'success' && data.success == false) {
				$("#erroWaybillTel").html(data.message);
			}else if(data.success == null){
				$("#erroWaybillTel").html("手机号码不匹配");
			}else {
				isTel = true;
				if(data.claimValidEntity.status == "1"){
					$("#erroWaybillTel").html("");	
				}else{
					$("#erroWaybillTel").html(data.claimValidEntity.errroInfo);
					isTel = false;
				}
			
			}
		});
		
		$.ajaxSetup({ 
			  async: true 
			  }); 
		
		return isTel;
	}

}

//验证码
function validValidCode(){
	if(isBlank($("#validCode").val())){
		$("#erroValidCode").html("<span class='icon_del'></span>请输入验证码");
		flag = false;
	}else{
		$.ajaxSetup({  
			    async : false  
			});
		$.get("codeCheck.action?code="+$("#validCode").val(),function(data,status){
			if(data.success == false){
				$("#erroValidCode").html("<span class='icon_del'></span>"+data.message);
				flag = false;
			}else{
				$("#erroValidCode").html("<span class='icon_succ'>"); 
				flag = true;
			}
			$.ajaxSetup({  
			    async : true  
			});
		});
	}		
}

//点击下一步校验
function validate(){
	validValidCode();
	return (validWaybill_next() && validWaybillTelNext() && flag);
}

//校验是否委托代理
/*function validIsEntrust(){
	var value = $("#isEntrust").val();
	if(isBlank(value)){
		$("#erroIsEntrust").html("<span class='icon_del'></span>请选择是否委托办理理赔");
		return false;
	}else{
		//非空时，判断是否委托，更改 isEntrustFlag状态，校验其他的
		if(value=='YES'){
			$("#isEntrust_y").show();
		}else{
			$("#isEntrust_y").hide();
		}
		$("#erroTextfield06").html("");
		$("#erroIsEntrust").html("");
		return true;
	}
}*/
//索赔人姓名或公司名称 
function validClaimNameOrComp(){
	if(isBlank($("#claimNameOrComp").val()) || $.trim($("#claimNameOrComp").val())==$("#claimNameOrComp").attr('ov')){
		$("#erroClaimNameOrComp").html("<span class='icon_del'></span>请输入索赔人姓名或公司名称");
		return false;
	}else if($("#claimNameOrComp").val().length > 200){
		$("#erroClaimNameOrComp").html("<span class='icon_del'></span>输入的长度超过限制");
		return false;
	}else{
		$("#erroClaimNameOrComp").html("");
		return true;
	}
}

//索赔人手机号
function validClaimUserTel(){
	var value = $("#claimUserTel").val();
	if(isBlank(value) || $.trim(value)==$("#claimUserTel").attr('ov')){
		$("#erroClaimUserTel").html("<span class='icon_del'></span>请输入索赔人手机号");
		return false;
	}else{
		if(!isMobile(value)){
			$("#erroClaimUserTel").html("<span class='icon_del'></span>请输入正确的手机号码");
			return false;
		}	
		$("#erroClaimUserTel").html("");
		return true;
	}
}

//邮箱格式校验
function validEmail(){
	var value = $("#claimEmail").val();
	if(!isBlank(value)){
		if(!isEmail(value)){
			$("#erroClaimEmail").html("<span class='icon_del'></span>请输入正确的邮箱格式");
			return false;
		}else{
			$("#erroClaimEmail").html("");
		}
		
	}
	return true;
}

//索赔金额
function validClaimMoney(){
	var value = $("#claimMoney").val();
	var r = /^[0-9]*[1-9][0-9]*$/;
	if(isBlank(value) || $.trim(value)==$("#claimMoney").attr('ov')){
		$("#erroClaimMoney").html("<span class='icon_del'></span>请输入索赔金额");
		return false;
	}else{
		//var reg = /^\+{0,1}\d+(\.\d{1,2})?$/;
		//if(!isUnMinusFloat2bit(value)){
		//	$("#erroClaimMoney").html("<span class='icon_del'></span>请输入正确的金额(保留两位小数)");
		//	return false;
		//}else 
		if(Number(value) == 0){
			$("#erroClaimMoney").html("<span class='icon_del'></span>金额不得为0元");
			return false;
		}else if(!r.test(Number(value))){
			$("#erroClaimMoney").html("<span class='icon_del'></span>金额不得有小数");
			return false;
		}else if(Number(value) > 3000){
			$("#erroClaimMoney").html("<span class='icon_del'></span>金额不得超过3000元");
			return false;
		}else if(Number(value) > 1000){
			$("#cusClaim_Money_1000").show();
			$("#waybill_Money_1000").show();
		}else{
			$("#cusClaim_Money_1000").hide();
			$("#waybill_Money_1000").hide();
		}
		$("#erroTextfield07").html("");
		$("#erroTextfield08").html("");
		$("#erroClaimMoney").html("");
		return true;
	}
}

//校验货物名称
function validCargoType(){
	var value = $("#cargoType").val();
	if(isBlank(value)){
		$("#erroCargoType").html("<span class='icon_del'></span>请选择货物名称");
		return false;
	}else{
		$("#erroCargoType").html("");
		return true;
	}
}


//异常件数
function validExceptionPiece(){
	var i=$("#waybillNo").val();
	var r = /^[0-9]*[1-9][0-9]*$/;
	$.post("requestClaim!validBillNo.action", {
		"claimValidEntity.billNo" : $("#waybillNo").val() // 理赔运单编号
	}, function(data, status) {
		
	}).done(function(data, status){
		waybillPiece = data.claimValidEntity.pieces;
		var value = $("#exceptionPiece").val();
		if(isBlank(value) || $.trim(value)==$("#exceptionPiece").attr('ov')){
			$("#erroExceptionPiece").html("<span class='icon_del'></span>请输入异常件数");
			return false;
		}else{
			//非负整数校验
			if(Number(value) == 0){
				$("#erroExceptionPiece").html("<span class='icon_del'></span>件数不得为0元");
				return false;
			}else if(!r.test(Number(value))){
				$("#erroExceptionPiece").html("<span class='icon_del'></span>件数不得有小数");
				return false;
			}else if(Number(value) > waybillPiece){
				$("#erroExceptionPiece").html("<span class='icon_del'></span>件数不能多余运单实际件数");
				return false;
			}else{
				$("#erroExceptionPiece").html("");
			}		
		}
	});
	return true;
}

//出险类型
function validDangerType(){
	if(isBlank($("#dangerType").val())){
		$("#erroDangerType").html("<span class='icon_del'></span>请选择出险类型");
		return false;
	}else{
		$("#erroDangerType").html("");
		//如果出险类型是“破损”，货损图片为必填项，田育林
		var dt = $("#dangerType").val();
		if(dt!="" && dt=="2"){ //出险类型为破损
			$("#danger_Type_2").show();
		}else{
			$("#danger_Type_2").hide();
		}
		return true;
	}
}
/**
*update huyuzhou 2016年1月27日10:43:07 
*理赔原因及其他 修改长度不能大于200且显示提示
*/
function validClaimReason(){
	var claimReasonValue = $("#claimReason").val();
	if(isBlank(claimReasonValue) || claimReasonValue == "字数不得超过200字"){
		$("#erroClaimReason").html("<span class='icon_del'></span>请输入理赔原因及其他");
		$("#claimReason").attr("class","textarea-no w250");
		$("#claimReason").val("字数不得超过200字");
		return false;
	//update huyuzhou 20160126 修改长度限制为200 原为2000
	}else if($("#claimReason").val().length > 200){
		$("#erroClaimReason").html("<span class='icon_del'></span>输入的长度超过限制");
		return false;
	}else{
		$("#claimReason").attr("class","w250");
		$("#erroClaimReason").html("");
		return true;
	}
}
/**
 * end
 */

//校验附件上传
function validUpload(){
	isUploadSuccess = true;
	validUploadisNull(field01Number,"erroTextfield01","请上传身份证扫描件");
	if(isUploadSuccess){
		validUploadisNull(field02Number,"erroTextfield02","请上传银行卡复印件");
	}
	if(isUploadSuccess){
		validUploadisNull(field03Number,"erroTextfield03","请上传到货签收凭证图");
	}
	if(isUploadSuccess){
		validUploadisNull(field04Number,"erroTextfield04","请上传发票复印件图片");
	}	
	var value = $("#claimMoney").val();
	if($("#isEntrust").val()=='Y' && isUploadSuccess){
		validUploadisNull(field06Number,"erroTextfield06","请上传客户委托授权证明");		
	}
	if(Number(value)>1000) {
		if(isUploadSuccess){
			validUploadisNull(field07Number,"erroTextfield07","请上传客户索赔函");
		}	
		if(isUploadSuccess){
			validUploadisNull(field08Number,"erroTextfield08","请上传发货运单图片");
		}	
	}
	//校验货损图片，田育林
	var dt = $("#dangerType").val();
	if(dt!="" && dt=="2"){
		if(isUploadSuccess){
			validUploadisNull(field05Number,"erroTextfield05","请上传货物破损图片");
		}
	}
	return isUploadSuccess;
}

function validUploadisNull(fieldNumber,erroId,erroInfo){
	if(fieldNumber==0){
		$("#"+erroId).html("<span class='icon_del'></span>"+erroInfo);
		isUploadSuccess = false;
	}else{
		$("#"+erroId).html("");
		isUploadSuccess = true;
	}
}

//校验用户开户名，田育林，2016-06-06
function validAccountName(){
	var accountName = $("#accountName").val();
	if(isBlank(accountName) || $.trim(accountName)==$("#accountName").attr('ov')){
		$("#errorAccountName").html("<span class='icon_del'></span>请输入银行卡开户人姓名");
		return false;
	}else if(accountName.length > 30){
		$("#errorAccountName").html("<span class='icon_del'></span>输入的开户名长度超过限制");
		return false;
	}else{
		$("#errorAccountName").html("");
		return true;
	}
}
//校验用户银行账号，田育林，2016-06-06
function validAccountCode(){
	var accountCode = $("#accountCode").val();
	var r = /^[0-9]\d{11,24}$/;           
	if(isBlank(accountCode) || $.trim(accountCode)==$("#accountCode").attr('ov')){
		$("#errorAccountCode").html("<span class='icon_del'></span>请输入银行卡卡号");
		return false;
	}else if(accountCode.length > 25){
		$("#errorAccountCode").html("<span class='icon_del'></span>输入的卡号长度不能超过25位");
		return false;
	}else if(!r.test(accountCode)){
		$("#errorAccountCode").html("<span class='icon_del'></span>请输入正确的银行卡卡号");
		return false;
	}else{
		$("#errorAccountCode").html("");
		return true;
	}
}
//校验开户行所在省市县，田育林，2016-06-06
function validAccountCity(){
	var accountCity = $("#accountCity").val();
	if(isBlank(accountCity) || $.trim(accountCity)==$("#accountCity").attr('ov')){
		$("#errorAccountCity").html("<span class='icon_del'></span>请选择开户行所在的省市区（县）");
		return false;
	}else{
		$("#errorAccountCity").html("");
		return true;
	}
}
//校验开户行名称，田育林，2016-06-06
function validAccountBank(){
	var accountBank = $("#accountBank").val();
	if(isBlank(accountBank) || $.trim(accountBank)==$("#accountBank").attr('ov')){
		$("#errorAccountBank").html("<span class='icon_del'></span>请输入开户行名称");
		return false;
	}else{
		$("#errorAccountBank").html("");
		return true;
	}
}

//提交校验
function validSubmit(){
	/*if(!validIsEntrust()){
		$("#isEntrust").focus();
		return false
	}else */if(!validClaimNameOrComp()){
		$("#claimNameOrComp").focus();
		return false
	}else if(!validClaimUserTel()){
		$("#claimUserTel").focus();
		return false
	}else if(!validEmail()){
		$("#claimEmail").focus();
		return false
	}else if(!validClaimMoney()){
		$("#claimMoney").focus();
		return false
	}else if(!validCargoType()){
		$("#cargoType").focus();
		return false
	}else if(!validExceptionPiece()){
		$("#exceptionPiece").focus();
		return false
	}else if(!validDangerType()){
		$("#dangerType").focus();
		return false
	}else if(!validClaimReason()){
		$("#claimReason").focus();
		return false
	//校验用户银行卡开户行信息，田育林，2016-06-06
	}else if(!validAccountName()){
		$("#accountName").focus();
		return false
	}else if(!validAccountCode()){
		$("#accountCode").focus();
		return false
	}else if(!validAccountCity()){
		$("#accountCity").focus();
		return false
	}else if(!validAccountBank()){
		$("#accountBank").focus();
		return false
	}
	return validUpload();
}



function errTips(msg){
	$("#easyDialogWrapper .erro").show();
	$("#easyDialogWrapper .erro_msg").text(msg)
}

function isBlank(str){
	if($.trim(str) == "" || str == null) return true;
	return false;
}

//更新理赔记录
function updateClaimRecord(billNo){
	window.location.href = "updateClaim.action?claimSubmitEntity.billNo="+billNo;
}
//删除理赔记录
function delClaimRecord(billNo){
	wayBillNo = billNo;
	easyDialog.open({
		container : 'calimDel',
		fixed : true
	});

}

//查看未提交理赔信息:20151117
function viewUnSubmit(billNo){
	var url="requestClaim!viewUnSubmit.action?claimSubmitEntity.billNo="+billNo;
	$.get(url,function(data,status){
		var claimSubmitEntity = data.claimSubmitEntity;
		$("#claimSubmitEntity\\.billNo").text(claimSubmitEntity.billNo);//理赔运单编号
		$("#claimSubmitEntity\\.claimParty").text(claimSubmitEntity.claimParty);//理赔方：
		$("#claimSubmitEntity\\.billTel").text(claimSubmitEntity.billTel);//运单上联系电话
		$("#claimSubmitEntity\\.claimCompanyAddr").text(claimSubmitEntity.claimCompanyAddr);//理赔公司所在地
		$("#claimSubmitEntity\\.contactName").text(claimSubmitEntity.contactName);//索赔人姓名或公司名称
		$("#claimSubmitEntity\\.contactTel").text(claimSubmitEntity.contactTel);//索赔人联系电话：
		$("#claimSubmitEntity\\.contactMail").text(claimSubmitEntity.contactMail);//索赔人邮箱：
		$("#claimSubmitEntity\\.claimsAmount").text(claimSubmitEntity.claimsAmount);//索赔金额
		$("#claimSubmitEntity\\.cargoType").text(claimSubmitEntity.cargoType);//货物类型
		$("#claimSubmitEntity\\.exceptionCount").text(claimSubmitEntity.exceptionCount);//异常件数
		$("#claimSubmitEntity\\.accidentType").text(claimSubmitEntity.accidentType);//出险类型
		$("#claimSubmitEntity\\.reason").text(claimSubmitEntity.reason);//理赔原因及其他
		/**开户行信息，田育林，2016-06-13**/
		$("#claimSubmitEntity\\.accountName").text(claimSubmitEntity.accountName);//开户名
		$("#claimSubmitEntity\\.accountCode").text(claimSubmitEntity.accountCode);//卡号
		$("#claimSubmitEntity\\.accountCity").text(claimSubmitEntity.accountCity);//开户行所在城市
		$("#claimSubmitEntity\\.accountBank").text(claimSubmitEntity.accountBank);//开户行名称
		
		var images = claimSubmitEntity.imgMapString.split(";");
		//移除所有子标签
		$("#allImage").empty();
		for(var i = 0; i < images.length; i++){
			var li = $("<li><a href='"+images[i]+"'><img src='"+images[i]+"' width='72' alt='' /></a></li>"); 
			$("#allImage").append(li);
		}
		
		$('#gallery a').lightBox();
		// 操作记录
		$("#operationRecord").empty();
		
		if(claimSubmitEntity.claimsTrackList !=null && claimSubmitEntity.claimsTrackList.length>0){
			//$("#operationRecord").append($('<table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td width="16%">日期</td><td width="14%">时间</td><td width="35%">状态</td><td width="35%">操作说明</td></tr>'));
			var content = '<table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td width="16%">日期</td><td width="14%">时间</td><td width="35%">状态</td><td width="35%">操作说明</td></tr>';
			
			for(var i = 0; i < claimSubmitEntity.claimsTrackList.length; i++){
    		    content += '<tr><td>'+claimSubmitEntity.claimsTrackList[i].oprDay
    					+'</td><td>'+claimSubmitEntity.claimsTrackList[i].oprTime
    					+'</td><td style = "WORD-WRAP: break-word">'+claimSubmitEntity.claimsTrackList[i].oprRemark
    					+'</td><td><span class="mr5">'+claimSubmitEntity.claimsTrackList[i].oprTypeDesc
    					+'</span></td></tr>'; 
    			
    		}
			content += '</table>';
			$("#operationRecord").append($(content));
			
		}else{
			$("#operationRecord").append($("<p>暂无任何历史记录</p>"));
		}
		
		//附件 TODO  XUJUN
		easyDialog.open({
			container : 'easyDialogWrapper',
			fixed : true
		});
	});
}

//查看
function view(billNo,claimNo){
	var url = "requestClaim!view.action?claimSubmitEntity.billNo=" + billNo +"&claimSubmitEntity.claimNo="+claimNo;
	$.get(url,function(data,status){
    	if(status == 'success' && data.success == false){
    		//TODO 异常处理 XUJUN
    	}else{
    		var claimSubmitEntity = data.claimSubmitEntity;
    		$("#claimSubmitEntity\\.billNo").text(claimSubmitEntity.billNo);//理赔运单编号
    		$("#claimSubmitEntity\\.claimParty").text(claimSubmitEntity.claimParty);//理赔方：
    		$("#claimSubmitEntity\\.billTel").text(claimSubmitEntity.billTel);//运单上联系电话
    		$("#claimSubmitEntity\\.claimCompanyAddr").text(claimSubmitEntity.claimCompanyAddr);//理赔公司所在地
    		$("#claimSubmitEntity\\.contactName").text(claimSubmitEntity.contactName);//索赔人姓名或公司名称
    		$("#claimSubmitEntity\\.contactTel").text(claimSubmitEntity.contactTel);//索赔人联系电话：
    		$("#claimSubmitEntity\\.contactMail").text(claimSubmitEntity.contactMail);//索赔人邮箱：
    		$("#claimSubmitEntity\\.claimsAmount").text(claimSubmitEntity.claimsAmount);//索赔金额
    		$("#claimSubmitEntity\\.cargoType").text(claimSubmitEntity.cargoType);//货物类型
    		$("#claimSubmitEntity\\.exceptionCount").text(claimSubmitEntity.exceptionCount);//异常件数
    		$("#claimSubmitEntity\\.accidentType").text(claimSubmitEntity.accidentType);//出险类型
    		$("#claimSubmitEntity\\.reason").text(claimSubmitEntity.reason);//理赔原因及其他
    		/**开户行信息，田育林，2016-06-13**/
    		$("#claimSubmitEntity\\.accountName").text(claimSubmitEntity.accountName);//开户名
    		$("#claimSubmitEntity\\.accountCode").text(claimSubmitEntity.accountCode);//卡号
    		$("#claimSubmitEntity\\.accountCity").text(claimSubmitEntity.accountCity);//开户行所在城市
    		$("#claimSubmitEntity\\.accountBank").text(claimSubmitEntity.accountBank);//开户行名称
    		
    		var images = claimSubmitEntity.imgMapString.split(";");
    		//移除所有子标签
    		$("#allImage").empty();
    		for(var i = 0; i < images.length; i++){
    			var li = $("<li><a href='"+images[i]+"'><img src='"+images[i]+"' width='72' alt='' /></a></li>"); 
    			$("#allImage").append(li);
    		}
    		$('#gallery a').lightBox();
    		// 操作记录
    		$("#operationRecord").empty()
    		if(claimSubmitEntity.claimsTrackList !=null && claimSubmitEntity.claimsTrackList.length>0){
    			//$("#operationRecord").append($('<table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td width="16%">日期</td><td width="14%">时间</td><td width="35%">状态</td><td width="35%">操作说明</td></tr>'));
    			var content = '<table border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td width="16%">日期</td><td width="14%">时间</td><td width="35%">状态</td><td width="35%">操作说明</td></tr>';
    			
    			for(var i = 0; i < claimSubmitEntity.claimsTrackList.length; i++){
        		    content += '<tr><td>'+claimSubmitEntity.claimsTrackList[i].oprDay
        					+'</td><td>'+claimSubmitEntity.claimsTrackList[i].oprTime
        					+'</td><td style = "WORD-WRAP: break-word">'+claimSubmitEntity.claimsTrackList[i].oprRemark
        					+'</td><td><span class="mr5">'+claimSubmitEntity.claimsTrackList[i].oprTypeDesc
        					+'</span></td></tr>'; 
        			
        		}
    			content += '</table>';
    			$("#operationRecord").append($(content));
    			
    		}else{
    			$("#operationRecord").append($("<p>暂无任何历史记录</p>"));
    		}
    		//附件 TODO  XUJUN
    		easyDialog.open({
    			container : 'easyDialogWrapper',
    			fixed : true
    		});
	    }
	});
}

//理赔金额确认
function claimAmountConfirm(billNo){
	wayBillNo = billNo;
	easyDialog.open({
		container : 'calimAmount',
		fixed : true
	});

}

//退回重新修改提交
function remodify(billNo,claimNo){
	window.location.href = "updateClaim.action?claimSubmitEntity.billNo="+billNo +"&claimSubmitEntity.claimNo="+claimNo;
}
/**
* @Title: add
* @Description: TODO(默认显示理赔原因及其他值，聚焦删除) 
* @date:2016年1月26日17:35:49 
* @author huyuzhou
 */
function initval(value){
	if($("#claimReason").val()=="字数不得超过200字"){
		$("#claimReason").attr("class","w250");
		$("#claimReason").val("");
	}
}
/**
 *end 
 */

//区掉空格回车换行
function iGetInnerText(testStr) {
    var resultStr = testStr.replace(/\ +/g, ""); //去掉空格
    resultStr = testStr.replace(/[ ]/g, "");    //去掉空格
    resultStr = testStr.replace(/[\r\n]/g, ""); //去掉回车换行
    return resultStr;
}

//根据银行卡号查询银行名称，田育林，2016-06-10
function getBankName(){
	var accountCode = $("#accountCode").val();
	var accountBank = $("#accountBank").val();
	if(!isBlank(accountCode) && $.trim(accountCode)!=$("#accountCode").attr('ov')){
		var url = "queryBank.action?idCard=" + accountCode;
		$.get(url,function(data){
	    	if(data!=null){
	    		var bankName = data.bankName;
	    		$("#accountBank").val(bankName);
	    	}else{
	    		$("#accountBank").val("");
	    	}
		});
	}
}

//根据关键字查询开户行名称，田育林，2016-06-29
function showBankInfo(){
	$("#errorAccountBank").html("");
	$("#bankInfo_ul").html("");
	$("#bankInfo_ul").hide();
	var key = $("#accountBank").val();
	var ov = $("#accountBank").attr("ov");
	if(key!=null && key!="" && key!=ov){
		$.post("queryBankInfoAction.action", {"bankKey" : key},
				function(data, status) {
			if(status=="success"){
				var bankInfos = data.bankInfos;
				if(bankInfos!=undefined && bankInfos!=null && bankInfos.length>0){
					for(var i=0; i<bankInfos.length; i++){
						$('#bankInfo_ul').append('<li onclick="selectBank(this)" ov='+bankInfos[i].bankInfoName+'>'+bankInfos[i].bankInfoName+'</li>');
					}
					$("#bankInfo_ul").show();
				}else{
					$("#errorAccountBank").html("<span class='icon_del'></span>没有搜索到开户行信息，请重新输入关键字");
				}
			}else{
				$("#bankInfo_ul").hide();
			}
		});
	}
}

//选择开户行名称，田育林，2016-06-29
function selectBank(bli){
	$("#errorAccountBank").html("");
	var bank = $(bli).attr("ov");
	if(bank!=null && bank!=""){
		$("#accountBank").val(bank);
	}
	$("#bankInfo_ul").hide();
}