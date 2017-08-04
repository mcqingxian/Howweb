<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col_left fl">
			<div class="content_second">
				<div class="content_second_nav">
					<h3>我的华宇</h3>
					<ul>
						<li  <c:if test="${(!empty categoryName) && ('网上下单' eq categoryName)}">class="current"</c:if>><a href="orderAction!index.action">网上下单</a></li>
						<li  <c:if test="${(!empty categoryName) && ('批量下单' eq categoryName)}">class="current"</c:if>><a href="batchOrderAction!index.action">批量下单</a></li>
						<li>
							<s:if test="controllType == \"ALL_ORDERS\" or controllType == \"MY_WAYBILLS\""> 
								<div class="subNav currentDt">我的订单</div>
								<ul class="navContent" style="display:block;">
							</s:if>
							<s:else>
								<div class="subNav">我的订单</div>
								<ul class="navContent" style="display:none;">
							</s:else>
								<li><a href="myOrdersAction!queryMyOrders.action" <s:if test="controllType == \"ALL_ORDERS\""> class="active"</s:if>>所有订单</a></li>
								<li><a href="myWaybillsAction!queryWaybillsByCondititons.action" <s:if test="controllType == \"MY_WAYBILLS\""> class="active"</s:if>>我的运单</a></li>
							</ul>
						</li>
						<li>
							<s:if test="controllType == \"CLAIM_REQUEST\" or controllType == \"CLAIM_QUERY\"">
								<div class="subNav currentDt">我的理赔</div>
								<ul class="navContent" style="display:block;">
							</s:if>
							<s:else>
								<div class="subNav">我的理赔</div>
								<ul class="navContent" style="display:none;">
							</s:else>
								<li><a href="requestclaim.action" <s:if test="controllType == \"CLAIM_REQUEST\""> class="active"</s:if>>理赔申请</a></li>
								<li><a href="queryclaim.action" <s:if test="controllType == \"CLAIM_QUERY\""> class="active"</s:if>>理赔查询</a></li>
								<%-- 
								<li><a href="http://online.hoau.net/THOMS/logining.do" target="_blank" <s:if test="controllType == \"CLAIM_REQUEST\""> class="active"</s:if>>理赔申请</a></li>
								<li><a href="http://online.hoau.net/THOMS/logining.do" target="_blank" <s:if test="controllType == \"CLAIM_QUERY\""> class="active"</s:if>>理赔查询</a></li>
								 --%>
							</ul>
						</li>
						<li>
							<s:if test="controllType == \"PERSONAL_DATA\" or controllType == \"ORDER_TEMPLATE\" or controllType == \"CONSIGNEE_MANAGE\" or controllType == \"SHIPPER_MANAGE\"">
								<div class="subNav currentDt">我的资料管理</div>
								<ul class="navContent" style="display:block;">
							</s:if>
							<s:else>
								<div class="subNav">我的资料管理</div>
								<ul class="navContent" style="display:none;">
							</s:else>
								<li><a href="personalDataAction!index.action" <s:if test="controllType == \"PERSONAL_DATA\""> class="active"</s:if>>个人资料管理</a></li>
								<!-- <li><a href="#" <s:if test="controllType == \"ORDER_TEMPLATE\""> class="active"</s:if>>订单模板管理</a></li> -->
								<li><a href="contacts_shipperManage.action" <s:if test="controllType == \"SHIPPER_MANAGE\""> class="active"</s:if>>发货人管理</a></li>
								<li><a href="contacts_consigneeManage.action" <s:if test="controllType == \"CONSIGNEE_MANAGE\""> class="active"</s:if> >收货人管理</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<%@include file="quickBox.jsp" %>
			</div>			
</div>