<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大事记</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/dashiji.js"></script>
<script type="text/javascript">
$(function(){
	$(".Milestones").delegate(".Milestones_tit", "click",
	function() {
		var n;
		$(".Milestones_list").hide();
		$(".Milestones_tit").removeClass("font-org");
		$(".Milestones_tit i").removeClass("icon-arrow-left").addClass("icon-arrow-right");		
		return $(this).next().toggle(),
		$(this).toggleClass("font-org"),
		n = $(this).find("i"),
		n.hasClass("icon-arrow-left") ? n.removeClass("icon-arrow-left").addClass("icon-arrow-right") : n.removeClass("icon-arrow-right").addClass("icon-arrow-left")
	});    
		
})
</script>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/about_banner.jpg" width="770" /></div>
			<div class="news_detail">
				<h1 class="news_title">大事记</h1>
				<div class="year_events">
					<div id="paginate-syFocusThumb" class="pagination">
						<I id=prev class=prev></I>
						<div class=thumbWrap>
							<div class=holder>
							<c:if test="${!empty bigEventList}">
								<c:forEach var="eventList" items="${bigEventList}">
									<i class=toc><A href="javascript:void(0)">${eventList.year}</A></i>
								</c:forEach>
							</c:if>
							</div>
						</div>
						<I id=next class=next></I>
					</div>
					
					<div id="syFocusThumb" class="sliderwrapper">
						<c:if test="${!empty bigEventList}">
							<c:forEach var="eventList" items="${bigEventList}">
								<div class="Milestoneslist">
									<ul>
										<c:forEach var="eventEntity" items="${eventList.events}">
										<li>${eventEntity.month}月 ${eventEntity.description}</li>
										</c:forEach>
									</ul>
								</div>							
							</c:forEach>
						</c:if>
					</div>
				</div>		
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
<script type="text/javascript">

slider.init({
id: "syFocusThumb",
contentsource: ["inline", ""], 
toc: "scroll",
nextprev: ["", ""],
revealtype: "click",
enablefade: [false, 0.15], 
autorotate: [false,0], 
delay: 1, //事件延迟时间(默认值：0，单位：ms)
//playtab: 4, 默认的播放舌签
onChange: function(previndex, curindex){ }});
</script>
</body>
</html>
