/**
 * 
 */

//校验运单（多个）
function isWaybill(str){
//	var result = false;
//	var reg = /^([a-zA-Z0-9]{1,2}|\d{2})\d{7,15}$/;
//	result = reg.test(str);
//	return result; 
	return true;
}

//邮箱
function isEmail(str){ 
	var result = false;
	var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/; 
	result = reg.test(str);
	return result; 
}

//手机号校验
function isMobile(str){
	var result = false;
	var reg = /^1[2,3,4,5,6,7,8,9][0-9]{9}$/;
	result = reg.test(str);
	return result; 
}

//固定电话
function isTelephone(str){
	var result = false;
	var reg = /^$/; 
	result = reg.test(str);
	return result; 
}

//非负整数
function isUnMinusInteger(str){
	var result = false;
	var reg = /^\0|[1-9]d*$/;
	result = reg.test(str);
	return result; 
}

//保留2位小数的非负浮点数
function isUnMinusFloat2bit(str){
	var result = false;
	var reg =/^\+{0,1}\d+(\.\d{1,2})?$/;
	result = reg.test(str);
	return result; 
}


//设置cookie
function setCookie(c_name, value, expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie=c_name+ "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}
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
//删除cookie
function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
    document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
} 


/**********************Map******************/
function Map(){
	this.container = new Object();
	}


	Map.prototype.put = function(key, value){
	this.container[key] = value;
	}


	Map.prototype.get = function(key){
	return this.container[key];
	}


	Map.prototype.keySet = function() {
	var keyset = new Array();
	var count = 0;
	for (var key in this.container) {
	// 跳过object的extend函数
	if (key == 'extend') {
	continue;
	}
	keyset[count] = key;
	count++;
	}
	return keyset;
	}


	Map.prototype.size = function() {
	var count = 0;
	for (var key in this.container) {
	// 跳过object的extend函数
	if (key == 'extend'){
	continue;
	}
	count++;
	}
	return count;
	}


	Map.prototype.remove = function(key) {
	delete this.container[key];
	}

	Map.prototype.containsKey = function(key) {
    	        var bln = false;
    	         try {
    	        	 for (var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
    	        			 if (keys[i] == key) {
        	                     bln = true;
        	                 }
    	        	}
    	         } catch (e) {
    	             bln = false;
    	         }
    	         return bln;
     }
	
	Map.prototype.toString = function(){
	var str = "";
	for (var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
	str = str + keys[i] + "=" + this.container[keys[i]] + ";\n";
	}
	return str;
}
	

	