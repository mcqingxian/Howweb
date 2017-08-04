<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.util.*"%>
<%@page import="com.hoau.how.module.bse.api.shared.domain.NewsEntity"%>
<html>
<head>
<meta
	http-equiv="User-Agent:Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)" />
<meta http-equiv="X-UA-Compatible" content="IE=8,IE=10,edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天地华宇欢迎您</title>
<script type="text/javascript" src="../scripts/jquery.js"></script>
<script type="text/javascript" src="../scripts/trace_trans.js"></script>
</head>
<body>
	
<s:form  action="queryNewsList.action" method="post" name="form1" theme="simple">
	类目<s:textfield name="categoryName"></s:textfield><br/>
	<s:submit value="提交"></s:submit><br/>
</s:form>
	<s:if test="newsList==null ||newsList.size()<1">
	newsList为空,或大小为0
	</s:if>
	<s:else>
		<s:iterator  id="news" value="newsList">
		新闻列表：<br/>
			<s:property value="#news.id"/><br/>
			<s:property value="#news.shortTitile"/><br/>
			<s:property value="#news.createdAt"/><br/>
			<s:property value="#news.title"/><br/>
			<s:property value="#news.clickCount"/><br/>
		</s:iterator>
	
	</s:else>
	
	<s:if test="newDetail == null || newDetail.size()<1">
		newDetail为空
	</s:if>
	<s:iterator id="newDetail" value="newDetail">
		newDetail<br/>
		<s:property value="#newDetail.id"/><br/>
		<s:property value="#newDetail.shortTitile"/><br/>
		<s:property value="#newDetail.createdAt"/><br/>
		<s:property value="#newDetail.title"/><br/>
		<s:property value="#newDetail.content"/><br/>
		<s:property value="#newDetail.clickCount"/><br/>
	</s:iterator>
	
</body>
</html>