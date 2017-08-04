//标识新增的货物信息索引
var index = 0;
var counterVos = new Array();
//初始加载clone单条
var intiSingle=null;
$(window).load(function() {
	intiSingle=$(".add_totalnum").find("#frist_div").html();
	//单项添加
	$(".singleAdd").click(function(){
		$("#frist_div").append(intiSingle);
	});
});
/** 
*删除数组指定下标或指定对象 
*/ 
Array.prototype.remove=function(obj){
	for(var i =0;i <this.length;i++){
		var temp = this[i];
		if(!isNaN(obj)){
			temp=i;
		}
		if(temp == obj){
			for(var j = i;j <this.length;j++){
				this[j]=this[j+1];
			}
			this.length = this.length-1;
		}
	}
}
function closeCounter(obj){
	var text = $(obj).html();
	var index = text.indexOf("打开");
	if(index >= 0){
		$(obj).html(text.replace("打开","关闭"));
		$(".add_totalnum").show();
	}else{
		$(obj).html(text.replace("关闭","打开"));
		$(".add_totalnum").hide();
	}
}

function contraction(obj){
	var div = $(obj).parent().parent().parent().find(".laction");
	var o = $(obj).html();
	if(o == "收起"){
		$(div).hide();
		$(obj).html("修改");
	}else{
		$(div).show();
		$(obj).html("收起");
	}
}

function deleteCounter(obj){
	var $parentDiv = $(obj).parent().parent();
	removeCounterById($parentDiv.parent().find("#counterId").val());
	//计算总数
	countSingle();
	$parentDiv.parent().remove();
}

function checkCounter(obj,tipId,msg){
	var defaultValue = $(obj).attr("ov");
	if(defaultValue == null){
		defaultValue = "";
	}
	if(obj.value == defaultValue || obj.value == "0"){
		var tips = $(obj).parent().find("#"+tipId);
		tips.html("<p class='erro'><span class='icon_del'></span>请输入正确"+msg+"！</p>");
		return false;
	}else{
		var tips = $(obj).parent().find("#"+tipId);
		tips.html("");
		return true;
	}
}
function confirm(obj){
	var $parentDiv = $(obj).parent().parent();
	var weight = $parentDiv.find("#weight").get(0);
	if(!checkCounter(weight,"weight_tips","重量")){
		return;
	}
	var long = $parentDiv.find("#long").get(0);
	if(!checkCounter(long,"volumn_tips","长度")){
		return;
	}
	var wide = $parentDiv.find("#wide").get(0);
	if(!checkCounter(wide,"volumn_tips","宽度")){
		return;
	}
	var height = $parentDiv.find("#height").get(0);
	if(!checkCounter(height,"volumn_tips","高度")){
		return;
	}
	var number = $parentDiv.find("#number").get(0);
	if(!checkCounter(number,"number_tips","件数")){
		return;
	}
	var totalVolume = long.value*wide.value*height.value*0.000001*number.value;
	if(totalVolume < 0.01){
		totalVolume = 0.01;
	}
	var $counterId = $parentDiv.parent().find("#counterId");
	if($counterId.val() != ""){
		removeCounterById($counterId.val());
	}
	index++;
	$counterId.val(index);
	var vo = {
		id : $counterId.val(),
		totalWeight : weight.value,
		totalVolume : totalVolume.toFixed(3),
		totalNumber : number.value
	};
	counterVos.push(vo);
	var totalWeight = weight.value * number.value;
	//计算总数
	countSingle();
	//隐藏填写明细界面
	$parentDiv.parent().find("#contractionBtn").click();
	//设置总体积
	$parentDiv.parent().find("#totalVolumn").html(totalVolume.toFixed(3));
	//设置总件数
	$parentDiv.parent().find("#totalNumber").html(number.value);
	//设置总重量
	$parentDiv.parent().find("#totalWeight").html(totalWeight);
}

function removeCounterById(id){
	for(var i = 0 ; i < counterVos.length ; i++){
		if(counterVos[i].id == id){
			counterVos.remove(i);
			return;
		}
	}
}

function countSingle(){
	var totalWeight = 0;
	var totalVolume = 0;
	var totalNumber = 0;
	var totalW = 0;
	for(var i = 0 ; i < counterVos.length ; i++){
		totalVolume = totalVolume + parseFloat(counterVos[i].totalVolume);
		totalNumber = totalNumber + parseFloat(counterVos[i].totalNumber);
		totalW = parseFloat(counterVos[i].totalWeight) * parseFloat(counterVos[i].totalNumber);
		totalWeight = totalWeight + totalW;
	}
	$("#entity\\.einoNumber").val(totalNumber);
	$("#entity\\.einoTotalWeight").val(totalWeight);
	$("#entity\\.einoTotalVolume").val(totalVolume);
}

function calcVolume(obj){
	var $parentDiv = $(obj).parent().parent();
	var long = $parentDiv.find("#long").get(0);
	if(!checkCounter(long,"volumn_tips","长度")){
		return;
	}
	var wide = $parentDiv.find("#wide").get(0);
	if(!checkCounter(wide,"volumn_tips","宽度")){
		return;
	}
	var height = $parentDiv.find("#height").get(0);
	if(!checkCounter(height,"volumn_tips","高度")){
		return;
	}
	var totalVolume = long.value*wide.value*height.value*0.000001;
	$parentDiv.find(".singleVolume").html(totalVolume.toFixed(3));
}