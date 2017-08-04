<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <title>运单跟踪</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/themes/default.min-1.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/themes/jquery.mobile.icons.min.css" />
    <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.2/jquery.mobile.structure-1.4.2.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/themes/hoau-icon.css" />
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="https://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/goods_trace.js"></script>
</head>

<body>
    <div data-role="page">
        <div data-role="header">
            <h1>运单状态</h1>
        </div>
        <div role="main" class="ui-content">

            <div class="ui-body ui-body-a ui-corner-all custom-corners" data-theme="c">
	             <label for="waybill">最近查询</label> 
				 <s:if test="waybills.size>0">
					<select id="his_waybills" name="his_waybills" data-mini="true">
						<s:iterator value="waybills" status="st" var="wbill">
		                	<option value="<s:property value="wbill" />"><s:property value="wbill" /></option>
		               	</s:iterator>
					</select>
				 </s:if>
				 <s:else>
				 	<div style="color:red; margin-bottom:20px;margin-top:10px;">无历史记录</div>
				 </s:else>
				
				<hr/>
				<label for="waybill"><span style="color:red;">*</span>运单编号</label> 
				<table style="width: 100%;">
					<tr>
						<td style="width: 90%;">
							<input type="text" name="waybill" id="waybill" placeholder="运单编号" data-mini="true"/>
						</td>
						<td style="width: 10%;">
		                	<input id="data_btn" type="button" data-icon="search" data-iconpos="notext">
						</td>
					</tr>
				</table>

                <ul id="datatable" data-role="listview" data-split-icon="phone" data-mini="true" data-split-theme="a" data-inset="true" class="ui-corner-none ui-alt-icon">
                    
                </ul>
            </div>

        </div>

    </div>
</body>

</html>
