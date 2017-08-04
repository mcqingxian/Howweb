$(document).ready(function(e) {
    

    // 进入下单界面
	$("#placeOrder").click(function(e) {
		var phone = $("#phone").text();
		var url = "/wechat/order.action?shipperContact.phone="+phone;
		window.location.href = url;
	});
	
	// 进入抽奖页面
	$("#lottery").click(function(e) {
		var url = "/wechat/getLotteryInfo.action";
		window.location.href = url;
	});
	
	//变更绑定
    $("#changeBind").click(function(e) {
    	var url = "/wechat/toChangeBindPage.action";
		window.location.href = url;
    });
});