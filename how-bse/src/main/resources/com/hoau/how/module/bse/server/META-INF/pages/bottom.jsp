<%@ page pageEncoding="utf-8"%>
<div class="footer">
	<div class="p_w">
		<div class="footer_info fl">
			<div class="footer_link_list"><a href="statement.action">法律声明</a><a href="download.action">资料下载</a><a href="http://weibo.com/tntchinahoau" target="_blank">官方微博</a></div>
			<div class="copy_right f12">
				Copyright©2015 天地华宇-上海华振物流有限公司. All Rights Reserved. 沪ICP备10220061号-2
				<div style="display:none;">
					<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1262570488'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1262570488%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));</script>

				</div>
				<div style="width:300px;margin:0 auto; padding:20px 0;">
					<a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011202001017" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="${images}/ghs.png" style="float:left;"/><p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">沪公网安备 31011202001017号</p></a>
                </div>
			</div>
		</div>
		<ul class="footer_list fr">
			<li>			
				<img src="${images }/wechat.jpg" width="130" />
				关注微信 立减10元
			</li>
			<li>
				<img src="${images }/HOAUAPP.jpg" width="130" />
				扫描下载官方APP
			</li>
		</ul>
		<div class="clearfix"></div>
	</div>
</div>

<div class="bottom_tools">
  <a id="scrollUp" href="javascript:void(0);" title="返回顶部"></a>
</div>
<script  type="text/javascript" src="${scripts}/toolbar.js"></script> 

<script  type="text/javascript">

$(function(){
	var $bottomTools = $('.bottom_tools');	
	$(window).scroll(function () {
		var scrollHeight = $(document).height();
		var scrollTop = $(window).scrollTop();
		var $footerHeight = $('.footer').outerHeight(true);
		var $windowHeight = $(window).height();
		scrollTop > 50 ? $("#scrollUp").fadeIn(200).css("display","block") : $("#scrollUp").fadeOut(200);			
		$bottomTools.css("bottom", scrollHeight - scrollTop - $footerHeight > $windowHeight ? 25 : $windowHeight + scrollTop + $footerHeight + 25 - scrollHeight);
	});
	$('#scrollUp').click(function (e) {
		e.preventDefault();
		$('html,body').animate({ scrollTop:0});
	});
		
});

$(function(){
	$(function(){
		$.each($(".inputFocus"),function(index,input){
			   if($(input).val()==$(input).attr("ov")){
				   $(input).addClass("grays");		
			   }
		});
	});
	$(".inputFocus").live("focus",function(){
		var ov=$.trim($(this).attr("ov"));
		var val=$.trim($(this).val());
		$(this).removeClass("grays");
		if(val==ov){
			$(this).val("");
		}

	});
 	$(".inputFocus").live("blur",function(){
		var ov=$.trim($(this).attr("ov"));
		var val=$.trim($(this).val());
		if(val==""){
			$(this).val(ov).addClass("grays");
		}
	 });
});
</script>