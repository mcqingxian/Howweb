<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/survey.js"></script>
<title>问卷调研</title>
</head>
<body>
	<div data-role="page" id="pageone">
		<div data-role="header" style="color:#ffffff;background-color:#f15a22">
		  <h1>天地华宇问卷调查</h1>
		</div>
		<div data-role="content">
	        <table cellpadding="0" cellspacing="0" width="100%">
		  		<tr>
		  			<td align="right">3/3题</td>
		  		</tr>
		  		<tr>
		  			<td align="center">
		  				3.诗句“每逢佳节倍思亲”中的“佳节”原意是指:
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="center">
		  				A.元宵节 B.重阳节 C.中秋节 D.端午节
		  			</td>
		  		</tr>
		  	</table>
		  	<button id="confirmA" value="A" onclick="toPage(this,3,-1)" data-theme="h">A</button>
		  	<button id="confirmB" value="B" onclick="toPage(this,3,-1)" data-theme="h">B</button>
		  	<button id="confirmC" value="C" onclick="toPage(this,3,-1)" data-theme="h">C</button>
		  	<button id="confirmD" value="D" onclick="toPage(this,3,-1)" data-theme="h">D</button>
		  	<%
		  		String codes = request.getParameter("codes");
		  		String values = request.getParameter("values");
			%>
		  	<button id="values" value="<%=values %>" style="display:none;"></button>
		  	<button id="codes" value="<%=codes %>" style="display:none;"></button>
	  	</div>
	</div> 
</body>
</html>