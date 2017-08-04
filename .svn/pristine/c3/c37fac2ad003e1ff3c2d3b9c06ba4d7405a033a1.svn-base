var deleteSuccess=false;
$(document).ready(function(e) {
	$("#sender_li").click(function() {
		$.mobile.changePage("#sender", {
			transition : "none",
			changeHash : false
		});
	});
	
	$("#receiver_li").click(function() {
		$.mobile.changePage("#receiver", {
			transition : "none",
			changeHash : false
		});
	});
	
    $(".add_senderPlus_list_btn span > a").click(function(){
    	var id = $(this).attr("id");
    	var contactsId = $(this).next().text();
    	//修改
    	if(id == "update_link"){
    		var url = "contactOperate.action?contactsEntity.ebsaId="+contactsId;
    		window.location.href = url;
    	}
    	//下单
    	if(id == "place_order_link"){
    		var url = "bse/order.action?ebsaId="+contactsId;
    		window.location.href = url;
    	}
    	//删除
    	if(id == "delete_link"){
    		var ids = [];
    		ids.push(contactsId)
    		var url = "addressMgtAction!deleteContacts.action?contactIds="+ids;
    		$.get(url,function(data){
    			$("#msg_dialog_con").empty();
    		},'json').done(function(data){
    			deleteSuccess = true;
    			$("#msg_dialog_con").append("<h>"+data.message+"</h>");
    		}).fail(function(data){
    			$("#msg_dialog_con").append("<h>系统异常</h>");
    		})
    		$.mobile.changePage('#msg_dialog', 'flip', true, true);
    	}
    });
    $('span[name="ebsaIsDefault"]').each(function(i,v){
    	var isdefault = $(this).html();
    	if(isdefault=="Y"){
        	//$('#'+i+'_default').html('默认联系人11');
        	$('#'+i+'_default').addClass('default_contacts_user');
        }else if(isdefault=="N"){
        	$('#'+i+'_default').html('<a href="javascript:void(0)" name="setDefault"></a>');
        	$('#'+i+'_default').addClass('contacts_user');
        }
    })
    
    $('a[name="setDefault"]').on('click',function(){
    	var ids = [];
    	var contactId = $(this).parent('span').attr('name');
    	ids.push(contactId);
    	var url = "addressMgtAction!setDefault.action?contactIds="+ids
    	$.get(url,function(data){
    		$("#msg_dialog_con").empty();
		},'json').done(function(data){
			deleteSuccess = true;
			$("#msg_dialog_con").append("<h>"+data.message+"</h>");
		}).fail(function(data){
			$("#msg_dialog_con").append("<h>系统异常</h>");
		})
		$.mobile.changePage('#msg_dialog', 'flip', true, true);
	});
    
    $(document).on('pagehide','#msg_dialog',function(){
    	if(deleteSuccess){
    		window.location.href = "addressBookManage.action";
    	}
    })
});
