<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨询建议</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/companyservice.js"></script>
<style>
<!--
.tips {
  display: none;
}
-->
</style>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/help_banner.jpg" width="770" /></div>
			<h3 class="position-title">咨询/投诉/建议</h3>
			<p class="sug_ad">将您对华宇的任何疑问或对服务的任何不满告诉我们，也可以直接拨打我们的客户服务热线:400-808-6666.</p>　
			
			<div class="cost_tab" style="margin:0;">
				<a href="#" class="active">咨询/建议</a>
				<a href="complaint.action">投诉</a>
			</div>
			<div class="news_detail">
				<div class="sug_msg">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="230" align="right"><span class="f_f15a22">*</span>标题：</td>
							<td>
								<input id="title_input" name="topic" type="text" class="input" />
							</td>
							<td><div class="tips" id="titleTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="titleNotice"></span>
										</p>
									</div>
							</td>
						</tr>
						<tr>
							<td align="right"><span class="f_f15a22">*</span>留言类型：</td>
							<td>
								<label class="mr15">
									<input type="radio" name="type" value="2.0" id="RadioGroup1_0" onchange="javascript:typechanged();"  /> 建议</label>
								<label class="mr15">
									<input type="radio" name="type" value="1.0" id="RadioGroup1_1" onchange="javascript:typechanged();"/> 咨询</label>
								<td><div class="tips" id="typeTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="typeNotice"></span>
										</p>
									</div></td>
							</td>
						</tr>
						<tr>
							<td align="right">留言人：</td>
							<td><input id="name_input" name="name" type="text" class="input" /></td>
						</tr>
						<tr>
							<td align="right">联系电话：</td>
							<td><input id="tel_input" name="tel" type="text" class="input" /></td>
						</tr>
						<tr>
							<td align="right">电子邮箱：</td>
							<td><input id="email_input" name="email" type="text" class="input" /></td>
						</tr>
						<tr>
							<td align="right">运单号：</td>
							<td><input id="waybillVale_input" name="wbnum" type="text" class="input" /></td>
						</tr>
						<tr>
							<td align="right" valign="top"><span class="f_f15a22">*</span>留言内容：</td>
							<td><textarea id="msg_input" class="msg_enter" name="message"></textarea></td>
							<td><div class="tips" id="msgTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="messageNotice"></span>
										</p>
									</div></td>
						</tr>
						<tr>
							<td align="right">验证码：</td>
							<td><input id="validateCode_input" name="" type="text" class="Codeinput" />
							<img id="validateCode_img" src="genCheckCode.action"  width="90" style="vertical-align: middle;" />
							<a href="javascript:changeCode();">看不清，换一张？</a>
							</td>
							<td><div class="tips" id="codeTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="codeNotice"></span>
										</p>
									</div>
							</td>
						</tr>
						<tr>
							<td align="right">&nbsp;</td>
							<td><input name="" id="saveSupportComment_btn" type="button" class="submit xz1" value="确认，并反馈给华宇" /></td>
						</tr>
					</table>

				</div>
				<form action="advisorySuggestion.action" method="post" onsubmit="return searchCheck()">
				<h3 class="position-title">
					<span class="fr">
						<input id="searchCondition_input" name="commentQueryVo.key" type="text"  class="d_text inputFocus grays" value="关键字..." ov="关键字..." />
						<input type="submit" value="搜索" class="tosnmiddle_btn msg_search"/>
					</span>
					留言记录
				</h3></form>
				<div class="msg">
				<c:if test="${!empty commentList}">
				<c:forEach var="comments" items="${commentList}">
					<div class="comment_box">
						
						<div class="info">
							<span class="c_info fr"><fmt:formatDate value="${comments.time}" pattern="yyyy-MM-dd"/></span>
							<div>
								<span class="mr40">姓名：${comments.name}</span>
								<span class="mr40">运单号：${comments.wbnum}</span>
								<span class="mr40">状态：
									<c:choose>
										<c:when test="${comments.status==1.0}">未处理</c:when>
										<c:when test="${comments.status==3.0}">处理中</c:when>
										<c:otherwise>已处理</c:otherwise>
									</c:choose>
								</span>
							</div>
						</div>
						
						<div class="c_cont">${comments.message}</div>
						<div class="reply_box">							
							<div class="reply">回复：${comments.reply}</div>
							<div class="date"><fmt:formatDate value="${comments.replytime}" pattern="yyyy-MM-dd"/></div>
						</div>
					</div>
				</c:forEach>
				</c:if>
				</div>	
			</div>
			<w:pager pageSize="${pageSize}" pageNo="${pageNo}" url="advisorySuggestion.action"
		recordCount="${recordCount}" />
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
