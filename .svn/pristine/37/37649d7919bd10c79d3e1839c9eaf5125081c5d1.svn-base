var LODOP; //声明为全局变量 
function preview(models) {	
	LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
	//打印初始化
	LODOP.PRINT_INIT("天地华宇网厅标签打印");
	LODOP.PRINT_INITA(0,0,302,249,"天地华宇标签打印");
	//套打分页 设置纸张打印方向，大小，宽高,第三个参数设定连续打印时纸张高度
	LODOP.SET_PRINT_PAGESIZE(1,800,660,"");
	LODOP.SET_PRINT_STYLE("FontSize",10);
	//LODOP.SET_PRINT_STYLE(2,"FontName","黑体");
	LODOP.SET_PRINT_STYLE("Bold",2);
	for(var i = 0 ; i <models.length ; i ++){
		LODOP.ADD_PRINT_SETUP_BKIMG("<img border='0' src='/how/images/bse/label.png'>");
		LODOP.SET_SHOW_MODE("BKIMG_IN_PREVIEW",1); //注："BKIMG_IN_PREVIEW"-预览包含背景图 "BKIMG_IN_FIRSTPAGE"- 仅首页包含背景图
		LODOP.SET_SAVE_MODE("QUICK_SAVE",true);
		//ADD语句及SET语句
		createOnePage(models[i]);
	}
	//打印预览
	LODOP.PREVIEW();
	//打印设计 开发人员用
	//LODOP.PRINT_DESIGN();
	//打印维护 给最终用户用
	//LODOP.PRINT_SETUP();
}

function createOnePage(model){	
	LODOP.NewPage();
	//收货人
	/*********货号**********/
	LODOP.ADD_PRINT_TEXTA("text01",54,54,151,26,model.from_cargo);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",19);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	/*********定日达字**********/
	LODOP.ADD_PRINT_TEXTA("text02",49,184,60,20,model.from_drdchar);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	
	/*********电商字**********/
//	LODOP.ADD_PRINT_IMAGE(57,188,46,25,model.from_dsImg);
//	LODOP.SET_PRINT_STYLEA(0,"FontSize",13);
	LODOP.ADD_PRINT_TEXTA("text03",71,196,42,17,model.from_ds);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	
	/*********定日达D**********/
//	if(model.from_drdImg != null || model.from_drdImg != ""){
//		LODOP.ADD_PRINT_IMAGE(21,236,61,75,model.from_drdImg);
//		LODOP.SET_PRINT_STYLEA(0,"FontSize",13);
//	}
	
	LODOP.ADD_PRINT_TEXTA("text04",20,236,62,67,model.from_drdD);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",70);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	
	
	
	/*********起运地，箭头图片，目的地************/
	LODOP.ADD_PRINT_TEXTA("text05",83,54,105,25,model.from_shipperAddr);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.SET_PRINT_STYLEA(0,"Italic",1);
	
//	LODOP.ADD_PRINT_IMAGE(86,125,37,19,model.from_arrowImg);
//	LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
	LODOP.ADD_PRINT_TEXTA("text06",105,56,49,27,model.from_arrow);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
	LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
//	LODOP.ADD_PRINT_TEXTA("text12",106,54,49,27,model.from_arrow);
//	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
//	LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
//	LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
//	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	
	LODOP.ADD_PRINT_TEXTA("text07",103,102,195,25,model.from_consigneeAddr);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",21);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	/*********收货人************/
	LODOP.ADD_PRINT_TEXTA("text08",135,101,69,14,model.from_consignee);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
	
	/*********收货人地址************/
	LODOP.ADD_PRINT_TEXTA("text09",162,56,240,30,model.from_address);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
	
	/*********送货方式**********/
	LODOP.ADD_PRINT_TEXTA("text10",202,268,25,25,model.from_sendCargoType);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	
	/*********横着的条形码**********/
	LODOP.ADD_PRINT_BARCODE(189,56,214,34,"128A",model.from_barImg);
	LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
	LODOP.SET_PRINT_STYLEA(0,"NotOnlyHighPrecision",true);
	
	/*********竖着的条形码**********/
	LODOP.ADD_PRINT_BARCODE(64,4,42,200,"128Auto",model.from_barImg2);
	LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
	LODOP.SET_PRINT_STYLEA(0,"NotOnlyHighPrecision",true);
	LODOP.SET_PRINT_STYLEA(0,"Angle",270);
	
	/*********条形码下方文本**********/
	LODOP.ADD_PRINT_TEXTA("text11",223,89,161,15,model.from_code);
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
	
	/*********收件人，收件人地址**********/
	LODOP.ADD_PRINT_TEXT(135,56,52,14,"收货人：");
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
	LODOP.ADD_PRINT_TEXT(149,56,62,14,"收货地址：");
	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
	
	/*********收件人电话**********/
//	LODOP.ADD_PRINT_TEXT(135,223,103,14,model.from_mobile);
//	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
//	LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
//	
//	LODOP.ADD_PRINT_TEXT(135,170,67,14,"联系方式：");
//	LODOP.SET_PRINT_STYLEA(0,"FontName","黑体");
//	LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
};