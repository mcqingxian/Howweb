<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网点筛选</title>
<meta name="Keywords" content="公路快运,物流货运,天地华宇,天地华宇物流,天地华宇物流查询,华宇物流,华宇物流查询,天地华宇俱乐部,华宇俱乐部，中信产业基金" />
<meta name="Description" content='天地华宇是中信产业投资基金管理有限公司（简称中信产业基金）旗下的全资公司，也是国家第一批"AAAAA"级资质的物流企业。天地华宇的前身华宇物流1995年成立于广州，总部设在上海，拥有中国最大的公路快运网络之一。截止2013年10月，天地华宇在全国600个大中城市拥有56个货物转运中心、1500家营业网点和16000名员工,全国客服热线400-808-6666' />
<link rel="Shortcut Icon" href="${images}/ico.png" type="image/x-icon"/>
<link href="${styles}/base.css" rel="stylesheet" type="text/css" />
<link href="${styles}/master.css" rel="stylesheet" type="text/css" />
<link href="${styles}/addition.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${scripts}/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
<script type="text/javascript" src="${scripts}/company/common.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=gxSAG68UUZLhitwDESGTtRkAaHWELT7j&s=1"></script>
</head>
<body>
<%@include file="../../top.jsp" %>
<div class="content">
	<div class="p_w">
		<div class="map_box">
			<div class="map_top">
				<div class="map_t_tab fr">
					<a href="javascript:void(0)" class="map_t_tab_one active">网点筛选</a>
					<a href="companyMatchAction!index.action" class="map_t_tab_two">网点匹配</a>
					<%--<a href="companyBatchQueryAction!index.action" class="map_t_tab_three">批量到货网点匹配</a>--%>
					<a href="companyQueryAction!index.action" class="map_t_tab_fove">到货网点匹配</a>
				</div>
				<span class="map_top_tit">
					网点筛选
				</span>
				<div class="clearfix"></div>
			</div>
		<div class="map_main">
			<div class="selectType">
				<a id="addressDetail" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType <s:if test="typeName == \"addressDetail\""> queryTypeActive active </s:if><s:elseif test="typeName == null || typeName == \"cityCode\""> queryTypeActive active </s:elseif>">网点地址</a>|
				<a id="deptName" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType<s:if test="typeName == \"deptName\""> queryTypeActive active </s:if>">网点名称</a>|
				<a id="logistCode" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType<s:if test="typeName == \"logistCode\""> queryTypeActive active </s:if>">网点代码</a>|
				<a id="phone" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType<s:if test="typeName == \"phone\""> queryTypeActive active </s:if>">网点电话</a>
				<input id="typeValue" type="text" class="inputFocus" value="<s:property value="typeValue"/>"/>
				<input type="button" onclick="queryCompany();" class="submit tosnmiddle_btn" value="查询" />
			</div>
			<div class="resultTit">
				<a href="companyScreenAction!queryAll.action">全部</a>  &nbsp;&gt;&nbsp; <s:property value="districtName"/> ( 共<span><s:property value="recordCount"/></span>个网点 )
			</div>
			<div class="resultList">
				<s:if test="#request.departmentList != null">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="16%">网点名称</td>
							<td width="8%">网点代码</td>
							<td width="9%">授权编码</td>
							<td width="8%">公司名称</td>
							<td width="20%">网点地址</td>
							<td width="12%">网点电话</td>
							<td width="9%">服务方式</td>
							<td width="9%">可提货网点</td>
							<td width="9%">地图详情</td>
						</tr>
						<s:iterator id="item" value="#request.departmentList">
							<tr>
								<td style="word-wrap: break-word;"><s:property value="#item.deptName"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.logistCode"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.authCode"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.franchiseCompanyName"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.addressDetail"/></td>
								<td style="word-wrap: break-word;"><s:if test="#item.areaCode != null and #item.areaCode != \"\""><s:property value="#item.areaCode"/>-</s:if><s:property value="#item.phone"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.serviceName"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.takeSelfDependLogistCode"/></td>
								<td style="word-wrap: break-word;">
									<form id="detailForm<s:property value="#item.rownumber"/>" name="detailForm<s:property value="#item.rownumber"/>" action="companyScreenAction!queryCompanyDetail.action" method="post">
										<input name="code" id="code" value="<s:property value="#item.logistCode"/>" style="display:none"/>
										<a href="javascript:void(0)" onclick="$('#detailForm<s:property value="#item.rownumber"/>').submit();" class="f_f15a22">更多详情</a>
									</form>
								</td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
				<w:pager pageSize="${pageSize}" pageNo="${pageNo}" url="companyScreenAction!pageQueryScreen.action" recordCount="${recordCount}" />
			</div>
		</div>
		</div>
	</div>
</div>
<%@include file="../../bottom.jsp" %>
</body>
</html>