<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/wechat/public.css"/>
<script type="text/javascript" src="${scripts}/order/myWaybills.js"></script>
<title>天地华宇</title>
</head>
<style>
	#datatable>li>div.trace{
		float: left;
	}
	#datatable>li>div>span.status{
		margin-right: .5rem;
	}
	#datatable>li>div>span.space{
		margin-left: 3rem;
	}
	#datatable>li>span.desc{
		margin-left: 3.5rem;
	}
</style>
<body>
	<!-- 运单管理 -->
	<div data-role="page" id="waybills">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">运单列表</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content">
						<s:if test="waybills!=null&&waybills.size()>0">
							<s:iterator value="waybills" status="status">
								<div class="order_manager_list">
									<div class="order_manager_list_info">
										<p>订单号：<span id='orderNo'><s:property value='orderNo' /></span></p>
										<p>运单号：<span><s:property value='transNo'/></p>
										<p>收货人：<s:property value='consignee' /></p>
										<p>货物名称：<s:property value='goodsName' /></p>
										<p>件数：<s:property value='pieces' /></p>
										<p>下单时间：<s:property value='orderDate' /></p>
										<p>
											订单状态：<s:if test="status == 'DELIVER'">已签收</s:if>
												 <s:elseif test="paymentWay == 'SENDFAIL'">签收失败</s:elseif>
												 <s:else>未签收</s:else>
										</p>
									</div>
									<div class="order_manager_list_btn tc clearfix">
										<%-- <a href="javascript:void(0)" id="<s:property value='transNo'/>" name="getGoodsTrace" data-inline="true" class="ui-link">运单跟踪</a>	 --%>					
										<a href="wayBillDetail.action?queryWaybillEntity.transNo=<s:property value='transNo'/>" data-ajax="false" data-inline="true" class="ui-link">查看运单信息</a>
										<%-- <a href="../waybillDetail.action?waybill=<s:property value='transNo'/>" id="<s:property value='transNo'/>" data-ajax="false" data-inline="true" class="ui-link">测试</a> --%>
									</div>
								</div>
							</s:iterator>
						</s:if>
						<s:else>
							<p style="margin-top: 100px; text-align: center;">
								您还没有运单，点击<a href="#" name="order_a" style="color: red;">我要下单</a>
							</p>
						</s:else>
					</div>
					<%@ include file="../footer.jsp" %>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %> 
				</div>
			</div>
		</div>
	</div>
	
	<!-- 运单详情对话框
	<div data-role="page" id="waybill_page">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">运单跟踪</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
						</span>
					</div>
					<div data-role="content" >
						<div id="waybill_page_con">
							<h2 id="transNo" style="margin-left: 20px;"></h2>
							<ul id="datatable" class="hwzz_search_list">
										
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	
</body>