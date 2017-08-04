<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 ,user-scalable=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/goods_trace.js"></script>
<style>
* {
	padding: 0px;
	margin: 0px;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	/*border-left: 1px solid #888;
	border-top: 1px solid #888;*/
	background: #efefef;
}

th,td {
	/*border-right: 1px solid #888;
	border-bottom: 1px solid #888;*/
	padding: 5px 15px;
}

th {
	font-weight: bold;
	background: #ccc;
}
</style>
<title>货物追踪</title>
</head>
<body>

	<div data-role="page">
		<div data-role="content">
		<div style="text-align: center;width: auto;">
	        <img style="width: 100%;" src="<%=request.getContextPath()%>/images/inc_new_vi.jpg">
      	</div>
        <div style="width: auto;">
         	<div style="margin-top:20px;margin-bottom:20px;font-weight:700;">运单号：<s:property value="waybill"/></div>
	        <table cellspacing="0px">
	        	<s:iterator value="traceInfos" status="st" >
	        		<s:if test="#st.isFirst()">
	        		<tr><td ><img alt='信息:' src='img/01.png'   width='16px' height='48' /></td><td align=left style='padding:0px;margin；0px;width:100%;font-size:14px; color:red;'><s:property value="time"/><br/> <s:property value="traceInfo"/></td></tr>
	        		</s:if>
	        		<s:elseif test="#st.isLast()">
	        		<tr><td><img alt='信息:' src='img/03.png'   width='16px' height='38' /></td><td align=left style='padding:0px;margin；0px;width:100%;font-size:14px;'><s:property value="time"/><br/> <s:property value="traceInfo"/></td></tr>
	        		</s:elseif>
	        		<s:else>
	        		<tr><td ><img alt='信息:' src='img/02.png'  width='16px' height='38'/></td><td align=left style='padding:0px;margin；0px;width:100%;font-size:14px;' ><s:property value="time"/><br/> <s:property value="traceInfo"/></td></tr>
	        		</s:else>
	        	</s:iterator>
	        </table>
        </div>
		</div>
	</div>
</body>
</html>
