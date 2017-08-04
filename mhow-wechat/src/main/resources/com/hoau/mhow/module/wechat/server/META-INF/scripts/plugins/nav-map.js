$(document).ready(function(){
	$("[data-toggle='map-toggle']").each(function(i){
	var window_w;
	var w_mainpage;
	var w_mappage;
	var wrapper = $('[id=wrapper]').eq(i);//$("#wrapper");
	var wrapperIn = $('[id=wrapper-in]').eq(i);//$("#wrapper-in");
	var mainp = $('[id=main-page]').eq(i);//$("#main-page");
	var mapp = $('[id=map-page]').eq(i);//$("#map-page");
	var $mainMask = $("<div id='main-page-mask'></div>");
	initial();
	$(window).resize(function(){initial();});
	
	$(this).click(function(e){
		e.stopPropagation();
		if(!wrapper.hasClass("map-open")){
			showWebSite();
			mainp.append($mainMask);
			$mainMask.show();
		}else{
			hideWebSite();
			$mainMask.hide();
		}
	});

	$mainMask.click(function(e){
		e.stopPropagation();
		hideWebSite();
		$mainMask.hide();
	});


	function initial(){
		window_w = $(window).width();
		if(window_w  > 640){window_w = 640;}
		w_mainpage = 50;
		if(wrapper.hasClass("map-open")){
			wrapperIn.css({"margin-left":-window_w + w_mainpage});
			wrapper.width(window_w);
			wrapperIn.width(window_w * 2 - w_mainpage );
			mainp.css({width:window_w});
			mapp.css({width:window_w - w_mainpage});
		}else{
			wrapperIn.css({"margin-left":0});
			wrapper.removeAttr("style");
			wrapperIn.removeAttr("style");
			mainp.removeAttr("style");
			mapp.removeAttr("style");
		}
	}

	//显示站点地图
	function showWebSite(){
		$(".dot-menu-wrapper").hide();
		wrapper.width(window_w);
		wrapperIn.width(window_w * 2 - w_mainpage );
		mainp.css({width:window_w});
		mapp.css({width:window_w - w_mainpage});
		$('[id=wrapper]').eq(i).addClass("map-open");
		wrapperIn.animate({"margin-left":-window_w + w_mainpage},300);
	}
	//隐藏站点地图
	function hideWebSite(){
		wrapperIn.animate({"margin-left":0},300,function(){
			$('[id=wrapper]').eq(i).removeClass("map-open");
			wrapper.removeAttr("style");
			wrapperIn.removeAttr("style");
			mainp.removeAttr("style");
			mapp.removeAttr("style");
			$(".dot-menu-wrapper").show();
			});
	}

});

//站点地图中列表展开或隐藏
$("[data-toggle='webmap-link-toggle']").click(function(e){
		var obj = $(this);
		var toggleC = obj.nextAll("ul");
		e.stopPropagation();
		if(toggleC.is(":visible")){
			toggleC.slideUp("fast").hide();
			obj.find(".ui-ico").removeClass("ui-ico-up").addClass("ui-ico-down");
		}	else{
			toggleC.slideDown("fast").show();
			obj.find(".ui-ico").removeClass("ui-ico-down").addClass("ui-ico-up");
		}
});




});
