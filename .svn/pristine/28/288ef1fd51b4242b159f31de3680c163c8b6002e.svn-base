<%@ page language="java" pageEncoding="utf-8"%>
<div class="quick_box" id="rightbar-ad" >
	<a href="traceTransByNo.action" class="quick_menu01"><i></i><span>货物追踪</span></a>
	<a href="companyMatchAction!index.action" class="quick_menu02"><i></i><span>网点查询</span></a>
	<a href="showPriceTime.action" class="quick_menu03"><i></i><span>价格时效</span></a>
</div>

<script type="text/javascript">

var bdAdTop;

if(jQuery('#rightbar-ad').length>0){
	bdAdTop=jQuery('#rightbar-ad').offset().top;
}

//返回顶部
jQuery(window).scroll(function(){
	
	if(jQuery('#rightbar-ad').length>0){
		if(jQuery(this).scrollTop()>bdAdTop){
			jQuery("#rightbar-ad").css({top:'20px',position:'fixed'})
		}else{
			jQuery("#rightbar-ad").css({top:'20px',position:'static'})
		}
	}
})


</script>