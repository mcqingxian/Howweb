<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>到货网点匹配</title>
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
<script type="text/javascript" src="${scripts}/company/screening.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="https://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="https://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
</head>
<body onload="createMap('<s:property value="departmentEntity.lng"/>','<s:property value="departmentEntity.lat"/>','<s:property value="departmentEntity.deptName"/>','<s:property value="departmentEntity.phone"/>','<s:property value="departmentEntity.addressDetail"/>','<s:property value="departmentEntity.serviceName"/>','<s:property value="departmentEntity.bounds"/>','<s:property value="departmentEntity.color"/>');">
<%@include file="../../top.jsp" %>
<div class="content">
	<div class="p_w">
		
		<div class="map_box">
			<div class="map_top">
				<div class="map_t_tab fr">
					<a href="companyScreenAction!queryAll.action" class="map_t_tab_one">网点筛选</a>
					<a href="companyMatchAction!index.action" class="map_t_tab_two">网点匹配</a>
					<%--<a href="companyBatchQueryAction!index.action" class="map_t_tab_three">批量到货网点匹配</a>--%>
					<a href="javascript:void(0)" class="map_t_tab_fove active">到货网点匹配</a>
				</div>
				<span class="map_top_tit">
					到货网点匹配
				</span>
				<div class="clearfix"></div>
			</div>
		<div class="map_main">
			<div class="resultTit">
					<a href="javascript:history.back();">公司列表</a>  &nbsp;&gt;&nbsp; <s:property value="departmentEntity.deptName"/>
			</div>
			<div class="resultDe">	
				<div class="resultDe_t"><a href="javascript:history.back();" class="result_close fr"></a>网点详细信息</div>
				<div class="resultDe_m">
					<div class="resultMap fl" id="map">
						
					</div>
					<div class="result_info fl">
						<ul>
							<li>网点名称：<s:property value="departmentEntity.deptName"/></li>
							<li>网点代码：<s:property value="departmentEntity.logistCode"/></li>
							<li>网点地址：<s:property value="departmentEntity.addressDetail"/></li>
							<li>联系电话：<s:property value="departmentEntity.areaCode"/>-<s:property value="departmentEntity.phone"/></li>
							<li>传真号码：<s:property value="departmentEntity.fax"/></li>
							<li>所属省市：<s:property value="departmentEntity.province"/>-<s:property value="departmentEntity.city"/></li>
							<li>可提货网点：<s:property value="departmentEntity.takeSelfDependLogistCode"/></li>
							<li>是否服务定日达：<s:property value="departmentEntity.isSpecifiedTime"/></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
<%@include file="../../bottom.jsp" %>
</body>
</html>