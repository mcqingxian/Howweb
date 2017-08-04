<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>常见答疑</title>
<%@include file="../head.jsp" %>
<script type="text/javascript">
$(function(){
    $("#questions").delegate(".question", "click",
    function() {
        var n;
		$(".answers").hide();
		$(".question").removeClass("font-org");
		$(".question i").removeClass("icon-arrow-up").addClass("icon-arrow-down");		
        return $(this).next().toggle(),
        $(this).toggleClass("font-org"),
        n = $(this).find("i"),
        n.hasClass("icon-arrow-up") ? n.removeClass("icon-arrow-up").addClass("icon-arrow-down") : n.removeClass("icon-arrow-down").addClass("icon-arrow-up")
    });    
})

function searchCheck(){
	var key = $.trim($("#searchCondition_input").val());
	if(key == "" || key.length>50){
		return false;
	}else if(key == $.trim($("#searchCondition_input").attr("ov"))){
		$("#searchCondition_input").val("");
	}
	return true;
}
</script>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			
			<div class="news_detail pb20">
				<div class="drd_pic"><img src="${images}/help_banner.jpg" width="770" /></div>
				<h1 class="news_title">
				<form action="commonQuestions.action" method="post" onsubmit="return searchCheck()">
					<span class="fr mr15">
						<input id="searchCondition_input" name="questionKey" type="text" class="input w125 inputFocus grays" value="关键字..." ov="关键字..." />
						<input type="submit" value="搜索" class="tosnmiddle_btn" style="width:58px;"/>
					</span>
				</form>	
				常见答疑</h1>
				<div class="questions" id="questions">
					<c:if test="${!empty questionList}">
						<c:forEach items="${questionList}" var="qItem">
							<ul class="unstyled">
								<li>
									<div class="question">
										<i class="icon icon-arrow-down"></i>
										<strong>${qItem.question}</strong>
									</div>
									<div class="answers">${qItem.answer}</div>
								</li>
							</ul>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
