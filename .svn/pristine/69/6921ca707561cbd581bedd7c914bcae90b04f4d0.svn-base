jQuery(function($){
	$('a[name="order_a"]').click(function(){
		var url = window.location.href
				.substring(0, window.location.href
						.lastIndexOf("/") + 1)
				+ "order.action";
		window.location.href = url;
	});
	
	var pageNo = 1;
	//滚动到底部
	$(document).on('scroll',function() {
		if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
			$.mobile.loading('show');
			pageNo+=1;
			$.post('queryMyWaybills.action',{"pageNo":pageNo},function(data){
			},'json').done(function(data){
				var stautsTemplate = '',valiGoodsName = '',valiPieces='';
				if(data.waybills!=null){
					if(data.waybills.length!=0){
						$.each(data.waybills,function(i,v){
							if(v.orderStatus=='DELIVER'){
								stautsTemplate = '已取消';
							}else if(v.orderStatus=='SENDFAIL'){
								stautsTemplate = '签收失败';
							}else{
								stautsTemplate = '未签收';
							}
							if(v.goodsName!=null){
								valiGoodsName = v.goodsName;
							}
							if(v.pieces!=null){
								valiPieces = v.pieces;
							}
							$('.ui-content').append(queryMoreWaybill(v,valiGoodsName,valiPieces,stautsTemplate))
						});
					}else{
						$(document).unbind('scroll');
					}
				}
			}).fail(function(){
				
			}).always(function(){
				$.mobile.loading('hide');
			})
		}
	});
	
	function queryMoreWaybill(v,valiGoodsName,valiPieces,stautsTemplate){
		var wayBillsTemplate = '<div class="order_manager_list">'
			+'<div class="order_manager_list_info">'
			+'<p>订单号：<span id="orderNo">'+v.orderNo+'</span></p>'
			+'<p>运单号：<span>'+v.transNo+'</p>'
			+'<p>收货人：'+v.consignee+'</p>'
			+'<p>货物名称：'+valiGoodsName+'</p>'
			+'<p>件数：'+valiPieces+'</p>'
			+'<p>下单时间：'+v.orderDate+'</p>'
			+'<p>'
			+'订单状态：'+stautsTemplate
			+'</p>'
			+'</div>'
			+'<div class="order_manager_list_btn tc clearfix">'
			+'<a href="wayBillDetail.action?queryWaybillEntity.transNo='+v.transNo+'" data-ajax="false" data-inline="true" class="ui-link">查看运单信息</a>'
			+'</div>'
			+'</div>'
		return wayBillsTemplate;
	}
	
	$('a[name="getGoodsTrace"]').on('click',function(){
		var waybill = $(this).attr('id');
		//var url = "../goodsTrace.action?waybill=A6138483";
		var url = "../goodsTrace.action?waybill="+waybill;
		$.getJSON(url,function(result,status){
			$("#datatable").empty();
			if (status = "success") {
				$('#transNo').html('运单号：<font color="red">'+result.waybill+'</font>')
				if(result !=  null && result.traceInfos != null){
					var data = result.traceInfos;
					for (var i = 0; i < data.length; i++) {
						if(i == 0){
							$("#datatable").append("<li><div class='trace'><span class='hwzz_search_icon'></span><span class='status'>"+data[i].status+"</span></div><div class='trace'><span>"+data[i].time+"</span></br><span class='desc'>"+data[i].desc+"</span></div></li>");
						}else{
							if(i==data.length-1){
								$("#datatable").append("<li><div class='trace'><span class='hwzz_search_icon'></span><span class='status'>"+data[i].status+"</span></div><div class='trace'><span>"+data[i].time+"</span></br><span class='desc'>"+data[i].desc+"</span></div></li>");	
							}else{
								$("#datatable").append("<li><div class='trace'><span class='hwzz_search_icon'></span><span class='status'>"+data[i].status+"</span></div><div class='trace'><span>"+data[i].time+"</span></br><span class='desc'>"+data[i].desc+"</span></div></li>");
							}
						}
					}
					$("#datatable").find('span.status').each(function(){
						if($(this).text()==''){
							$(this).addClass('space');
						}
					})
				}else{
					$("#datatable").append("<p style='line-height:30px;text-align: center; font-size:1em;color:red;'>"+"暂无货物跟踪信息"+"</p>");
				}
			} else{
				$("#datatable").append("<p style='line-height:30px;text-align: center; font-size:1em;color:red;'>"+"系统异常"+"</p>");
			}
			$.mobile.changePage('#waybill_page', {transition:"none",changeHash : false}, false, false);
		});
	});
});

