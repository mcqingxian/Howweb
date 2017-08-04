/**
 * 
 * 改变当前选定查询类型样式
 * @param objA
 * @author 莫涛
 * @date 2015年6月26日
 * @update
 */
function changeQueryType(objA){
	jQuery(".queryType").removeClass("active");
	jQuery(".queryType").removeClass("queryTypeActive");
	jQuery(objA).addClass("active");
	jQuery(objA).addClass("queryTypeActive");
}

/**
 * 
 * 进行查询
 * @author 莫涛
 * @date 2015年6月26日
 * @update
 */
function queryCompany(){
	var typeName = jQuery(".queryTypeActive").attr("id");
	var typeValue = jQuery("#typeValue").val();
    //新增地址文本校验 肖聪
    var reg = /^[\u4E00-\u9FA5A-Za-z0-9?[-]+$/;
    if(!reg.test(typeValue) && typeValue != ""){
        alert("提示:输入格式有误");
        return false;
    }
    // 创建Form
    var form = $("<form></form>");  
    // 设置属性  
    form.attr("action", "companyScreenAction!pageQueryScreen.action");  
    form.attr("method", "post");  
    // form的target属性决定form在哪个页面提交  
    // _self -> 当前页面 _blank -> 新页面  
    form.attr("target", "_self");
    // 创建Input  
    var input_typeName = $("<input type='text' name='typeName' />");
    input_typeName.attr("value", typeName);
    // 创建Input  
    var input_typeValue = $("<input type='text' name='typeValue' />");
    input_typeValue.attr("value", typeValue);
    // 创建Input  
    var input_districtName = $("<input type='text' name='districtName' />");

    // 附加到Form
        form.append(input_typeName);
        form.append(input_typeValue);
        form.append(input_districtName);

    console.log(input_typeName,input_typeValue,input_districtName);
    // 提交表单
    form.appendTo(document.body).submit();
}