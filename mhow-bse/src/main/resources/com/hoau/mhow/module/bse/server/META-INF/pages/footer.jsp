<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<div class="footer">
	<div class="footer-menu">
		<span id="footer-menu-content"> 
			<s:if test="#session.USER_INFO!=null">
				<a href="<%=request.getContextPath()%>/bse/loginAction!exit.action" data-ajax='false'>退出</a>
			</s:if> 
			<s:else>
				<a href="<%=request.getContextPath()%>/bse/login.action" data-ajax='false'>登录</a>
				<a href="<%=request.getContextPath()%>/bse/toRegist.action" data-ajax='false'>注册</a>
			</s:else>
		</span> <a class="returntop" href="javascript:scroll(0,0);"><!-- <i class="ui-ico"></i> -->TOP</a>
	</div>
	<!-- <div class="service-tel">
		<span class="service-phone"> 客服专线 <a href="tel:400-808-6666" data-ajax='false'><span
				class="tel">400-808-6666</span></a>
		</span>
	</div>
	<div class="copyright">
		<p>Copyright©2015 天地华宇. All Rights Reserved.</p>
		<p>沪ICP备10220061号-2</p>
	</div> -->
</div>

<script type="text/javascript">
$(function() {
	$(".returntop").hide();
	$(window).scroll(function() {       //页面滚动显示元素。
		if($(window).scrollTop()>=100){
			$(".returntop").show();
		}else{
			$(".returntop").hide();
		}
	}); 
});
</script>
