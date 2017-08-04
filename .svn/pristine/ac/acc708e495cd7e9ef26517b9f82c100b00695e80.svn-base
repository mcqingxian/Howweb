$(document).ready(function(e) {
	
	$("#waybill").val($("#his_waybills  option:selected").text());
	
	$("#his_waybills").change(function(e){
		var text = $("#his_waybills  option:selected").text();
		$("#waybill").val(text);
	});
	
    $("#data_btn").click(function(e) {
    	$(this).attr("disabled","disabled");
    	$("#datatable").empty();
    	var waybill = $("#waybill").val();
    	
    	var reg = /^([0-9]{8}|[a-zA-Z][0-9]{7}|[0-9]{9})$/;
    	if(!reg.test(waybill)){
    		$("#datatable").append("<p style='line-height:30px;text-align: center; font-size:1em;color:red;'>"+"请输入8位或者9位纯数字的运单<br />或者首位是字母的8位的运单"+"</p>");
    		$("#data_btn").removeAttr("disabled");
    		return;
    	}
    	var url = "goodsTrace.action?waybill="+waybill;
    	
    	// cookie操作
		var w = getCookie('importList');
		var cookieValue;
		if(w == null || w == ''){
			cookieValue = waybill;
		}else{
			cookieValue = waybill + ',' + w;
		}
		cookieValue=cookieValue.replace(new RegExp(/(\<br\/\>)/g),',');
		var arr = cookieValue.split(',');
		// 去重复
		arr.sort();
		var re=[arr[0]];
		for(var i = 1; i < arr.length; i++)
		{
			if( arr[i] !== re[re.length-1])
			{
				if($.trim(arr[i])!=""){
					re.push(arr[i]);
				}
			}
		}
		// 过期时间 30天
		setCookie('importList',re.join(','),30);
		// 刷新页面列表
		jsAddItemToSelect(re);
    	
    	$.getJSON(url,function(result,status){
    		if (status = "success") {
				if(result !=  null && result.traceInfos != null){
					var data = result.traceInfos;
					for (var i = 0; i < data.length; i++) {
						if(i == 0){
							$("#datatable").append("<li><span class='hwzz_search_icon'></span><span>"+data[i].time+"</span></br><span>"+data[i].desc+"</span></li>");
						}else{
							if(i==data.length-1){
								$("#datatable").append("<li><span class='hwzz_search_icon'></span><span>"+data[i].time+"</span></br><span>"+data[i].desc+"</span></li>");	
							}else{
								$("#datatable").append("<li><span class='hwzz_search_icon'></span><span>"+data[i].time+"</span></br><span>"+data[i].desc+"</span></li>");
							}
						}
					}
					$("#datatable").find('span.status').each(function(){
						if($(this).text()==''){
							$(this).addClass('space');
						}
					})
				}else{
//					$.mobile.changePage('#dialog', 'pop', true, true);
					$("#datatable").append("<p style='line-height:30px;text-align: center; font-size:1em;color:red;'>"+"您输入的运单没有跟踪信息,查看是否输入有误"+"</p>");
				}
			} else{
				
			}
    		$("#data_btn").removeAttr("disabled");
		});
    	
    });
    
    // 查询历史初始化
    var w = getCookie('importList');
    var warr = [];
    if(w != null && w != ''){
    	warr = w.split(',');
    }
    jsAddItemToSelect(warr);
    $("#waybill").val($("#his_waybills  option:selected").text());
});

//获得cookie
function getCookie(c_name){
	if (document.cookie.length>0){　　//先查询cookie是否为空，为空就return ""
		c_start=document.cookie.indexOf(c_name + "=")　　//通过String对象的indexOf()来检查这个cookie是否存在，不存在就为 -1　　
		if (c_start!=-1){ 
			c_start=c_start + c_name.length+1　　//最后这个+1其实就是表示"="号啦，这样就获取到了cookie值的开始位置
			c_end=document.cookie.indexOf(";",c_start)　　//其实我刚看见indexOf()第二个参数的时候猛然有点晕，后来想起来表示指定的开始索引的位置...这句是为了得到值的结束位置。因为需要考虑是否是最后一项，所以通过";"号是否存在来判断
		if (c_end==-1) c_end=document.cookie.length　　
			return unescape(document.cookie.substring(c_start,c_end))　　//通过substring()得到了值。想了解unescape()得先知道escape()是做什么的，都是很重要的基础，想了解的可以搜索下，在文章结尾处也会进行讲解cookie编码细节
		} 
	}
	return ""
}　

//设置cookie
function setCookie(c_name, value, expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie=c_name+ "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}


//2.向select选项中 加入一个Item
function jsAddItemToSelect(objItemList) {
	$("#his_waybills option").each(function(){ 
		$(this).remove(); 
	}); 
	$("#his_waybills").append("<option value=''></option>");
	for(var i = 0; i < objItemList.length; i++){
		var item = objItemList[i];
		$("#his_waybills").append("<option value='"+item+"'>"+item+"</option>");
	}
}
