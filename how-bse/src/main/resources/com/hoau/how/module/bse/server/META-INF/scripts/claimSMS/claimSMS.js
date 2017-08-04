/**
* @Title: 
* @Description: TODO(短信理赔金额确认) 
* @param @param billNo    设定文件 
* @author huyuzhou 2016-01-18
* @throws
 */
function claimAmountConfirmSMS(billNo){
	$.post("amountConfirmSMS.action", {
		"claimSubmitEntity.billNo" : billNo // 理赔运单编号
	}, function(data, status) {
		if (status == 'success' && data.success == true) {
			easyDialog.open({
				container : 'dialog_ok',
				fixed : true
			});
		}
	});
	$("#btnDiv").hide();
}

//点击拒绝时调用的方法
function refuseClaimsAmount(billNo){
	$.post("refuseClaimsAmount.action", {
		"claimSubmitEntity.billNo" : billNo // 理赔运单编号
	}, function(data, status) {
		if (status == 'success' && data.success == true) {
			easyDialog.open({
				container : 'dialog_no',
				fixed : true
			});
		}
	});
	$("#btnDiv").hide();
}
/**
 * end
 */