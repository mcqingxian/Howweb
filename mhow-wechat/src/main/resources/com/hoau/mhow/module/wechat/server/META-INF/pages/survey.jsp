<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		  			<td align="right">本调研共3题</td>
		  		</tr>
		  		<tr>
		  			<td align="center">
		  				<image src="<%=request.getContextPath()%>/images/getimgdata.jpg"></image>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="center">
		  				问卷调查，调查问卷，问卷调查，调查问卷，问卷调查，调查问卷，
		  			</td>
		  		</tr>
		  	</table>
		  	<button onclick="surveyFun()" data-theme="h">开始调研</button>
	  	</div>
	</div> 
</body>
</html>