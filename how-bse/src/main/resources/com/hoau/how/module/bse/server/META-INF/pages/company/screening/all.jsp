<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
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
				<a id="addressDetail" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType queryTypeActive <s:if test="typeName == \"addressDetail\""> active </s:if><s:elseif test="typeName == null || typeName == \"cityCode\""> active </s:elseif>">网点地址</a>|
				<a id="deptName" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType<s:if test="typeName == \"deptName\""> active </s:if>">网点名称</a>|
				<a id="logistCode" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType<s:if test="typeName == \"logistCode\""> active </s:if>">网点代码</a>|
				<a id="phone" href="javascript:void(0)" onclick="changeQueryType(this);" class="queryType<s:if test="typeName == \"phone\""> active </s:if>">网点电话</a>
				<input id="typeValue" type="text" class="inputFocus" value="<s:property value="typeValue"/>"/>
				<input type="button" onclick="queryCompany();" class="submit tosnmiddle_btn" value="查询" />
			</div>
			<div class="letters">
				<ul>
					<s:iterator id="item" value="#request.pinYins">
						<s:if test="#item != '全部'">
							<li>
								<a <s:if test="#item == #request.pinYin"> class="current" </s:if> 
								href="companyScreenAction!queryAll.action?pinYin=<s:property value='#item'/>" ><s:property value="#item"/></a>
							</li>
						</s:if>
						<s:else>
							<li>
								<a href="companyScreenAction!queryAll.action?pinYin=" <s:if test="'' == #request.pinYin"> class="current" </s:if> >全部</a>
							</li>
						</s:else>
					</s:iterator>
				</ul>
			</div>
			<div class="cityByLetter">
				<dl>
					<s:iterator value="#request.districtMap">
						<dd id="<s:property value="key"/>" class="ddTop">
							<span class="deWidth"><s:property value="key"/></span>
							<div class="listA_Z">
								<s:iterator id="item" value="value">
									<form style="float:left;" action="companyScreenAction!pageQueryScreen.action" method="post" id="pageQueryScreen<s:property value="#item.districtCode"/>" name="pageQueryScreen<s:property value="#item.districtCode"/>">
										<input style="display: none;" name="typeValue" value="<s:property value="#item.districtCode"/>"/>
										<input style="display: none;" name="typeName" value="cityCode"/>
										<input style="display: none;" name="districtName" value="<s:property value="#item.districtName"/>"/>
										<a href="javascript:void(0)" onclick="$('#pageQueryScreen<s:property value="#item.districtCode"/>').submit();" class="city_padding <s:if test="#item.hotCity == \"Y\"">hot_city</s:if>"><s:property value="#item.districtName"/></a>
									</form>
								</s:iterator>
							</div>
						</dd>
					</s:iterator>
				</dl>
				<div class="clearfix"></div>
			</div>
		</div>
		</div>
	</div>
</div>
<%@include file="../../bottom.jsp" %>
</body>
</html>
