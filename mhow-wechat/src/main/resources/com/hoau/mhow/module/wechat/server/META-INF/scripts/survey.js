function surveyFun(){
	var url = "survey/survey_1.jsp";
	window.location.href = url;
}

/**
 * v 当前按钮
 * code 当前题目编号
 * target 目标页面
 */
function toPage(v,code,targetCode){
	var values = jQuery("#values").val();
	var codes = jQuery("#codes").val();
	if(null != values){
		values = values + "," +v.value;
	}
	
	if(null != codes){
		codes = codes + "," + code;
	}
	
	if(targetCode != -1){
		var url = "survey_"+targetCode+".jsp?codes="+codes+"&values="+values;
		window.location.href = url;
	}else{
		var url = "/wechat/surveyAction!submitSurvey.action?codes="+codes+"&values="+values;
		window.location.href = url;
	}
}