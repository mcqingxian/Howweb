<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%String date = request.getParameter("queryVo.startQueryTime");%>
<%@ include file="../common.jsp" %>	
<script src="${scripts}/order/order_manager.js"></script>
<title>订单管理</title>
</head>
<body>
	<!-- 未完成订单 -->
	<div data-role="page" id="undoneOrder">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">订单管理</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="navbar" class="order_manager_tab">
						<ul>
							<li><a href="" data-transition="none" class="ui-btn-active ui-state-persist">未完成订单</a></li>
							<li id="doneOrder_li1"><a href="#" data-transition="none">已完成订单</a></li>
							<li id="orderQuery_li1"><a href="#" data-transition="none">订单号查询</a></li>
						</ul>
					</div>
					<div data-role="content">
						<s:if test="undoneOrders!=null&&!undoneOrders.isEmpty()">
							<s:iterator value="undoneOrders" status="status">
								<div class="order_manager_list">
									<div class="order_manager_list_info">								
										<p>订单号：<span id="contractNo"><s:property value='contractNo' /></p>
										<p>收货人：<s:property value='consigneeName' /></p>
										<p>收货人地址：<s:property value='consigneeAddess' /></p>
										<p>下单时间：<s:property value='orderDate' /></p>
										<p>
											订单状态：<s:if test='orderStatus=="ADD"'>
												待受理
											 </s:if> 
											 <s:if test='orderStatus=="SUBMIT"||orderStatus=="ACCEPT"'>
												已受理
											 </s:if> 
											 <s:if test='orderStatus=="CANVASSING"'>
												已开单
											 </s:if> <br /> 
											 <s:if test="wayBill!=null">
												运单号：<span><s:property value='wayBill' /></span><br />
											</s:if>
										</p>
									</div>
									<div class="order_manager_list_btn tc clearfix">
										<s:if test='orderStatus=="ADD"'>
											<a href="javascript:void(0)" id='<s:property value='orderId'/>' data-inline="true" onclick="cancelOrder(this)">撤销</a>
											<a href="javascript:void(0)" id='<s:property value='orderId'/>' data-inline="true" onclick="modifyOrder(this)">修改</a>
										</s:if>
										<s:if test='orderStatus=="CANVASSING"'>
											<a href="wayBillDetail.action?queryWaybillEntity.transNo=<s:property value='wayBill'/>" data-ajax="false" data-inline="true" class="ui-link">查看运单信息</a>
										</s:if>
										<a href="javascript:void(0)" name="orderDetail"id='<s:property value='orderId'/>' data-inline="true" data-theme = "h" >查看</a>
									</div>
								</div>
							</s:iterator>
							<span id="undone_more" style="display: none;"><img src="${images}/loading.gif" ><font color="red"></font></span>
						</s:if>
						<s:else>
							<p style="margin-top: 100px; text-align: center;">
								您还没有未完成订单，点击<a href="#" name="order_a" style="color: red;">我要下单</a>
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
	<!-- 完成订单 -->
	<div data-role="page" id="doneOrder">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">订单管理</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="navbar" class="order_manager_tab">
						<ul>
							<li id="undoneOrder_li1"><a href="#" data-transition="none">未完成订单</a></li>
							<li><a href="#" data-transition="none" class="ui-btn-active ui-state-persist">已完成订单</a></li>
							<li id="orderQuery_li2"><a href="#" data-transition="none">订单号查询</a></li>
						</ul>
					</div>
					<div data-role="content">
						<select id="date" name="<%=date%>">
							<s:if test="queryVo.startQueryTime=='oneWeek'">
								<option value="oneWeek" selected="selected">最近一周</option>
								<option value="oneMonth">最近一个月</option>
								<option value="threeMonth">最近三个月</option>
							</s:if>
							<s:if test="queryVo.startQueryTime==null||queryVo.startQueryTime=='oneMonth'">
								<option value="oneWeek" >最近一周</option>
								<option value="oneMonth" selected="selected">最近一个月</option>
								<option value="threeMonth">最近三个月</option>
							</s:if>
							<s:if test="queryVo.startQueryTime=='threeMonth'">
								<option value="oneWeek">最近一周</option>
								<option value="oneMonth">最近一个月</option>
								<option value="threeMonth" selected="selected">最近三个月</option>
							</s:if>
						</select>
						<s:if test="doneOrders!=null&&!doneOrders.isEmpty()">
							<s:iterator value="doneOrders" status="status">							
								<div class="order_manager_list">
									<div class="order_manager_list_info">
										<p>订单号：<span><s:property value='contractNo' /></span></p>
										<s:if test=""></s:if>
										<p>收货人：<s:property value='consigneeName' /></p>
										<p>收货人地址：<s:property value='consigneeAddess' /></p>
										<p>下单时间：<s:property value='orderDate' /></p>
										<p>
											订单状态： <s:if test='orderStatus=="VOID"'>已取消</s:if>
													<s:if test='orderStatus=="DELIVER"'>已签收</s:if> <br />
											 
										</p>
										<p>
											<s:if test="wayBill!=null">
												运单号：<span><s:property value='wayBill' /></span><br />
											</s:if>
										</p>
									</div>
									<div class="order_manager_list_btn tc clearfix">
										<s:if test='orderStatus=="DELIVER"'>
											<a href="wayBillDetail.action?queryWaybillEntity.transNo=<s:property value='wayBill'/>" data-ajax="false" data-inline="true" class="ui-link">查看运单信息</a>
										</s:if>
										<a href="javascript:void(0)" name="orderDetail" id='<s:property value='orderId'/>' data-inline="true">查看</a>
									</div>
								</div>
							</s:iterator>
							<span id="done_more" style="display: none;"><img src="${images}/loading.gif" ><font color="red"></font></span>
						</s:if>
						<s:else>
								<p style="margin-top: 100px; text-align: center;">
									您还没有已完成订单，点击<a href="#" name="order_a" style="color: red;">我要下单</a>
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
	
	<!--订单查询  -->
	<div data-role="page" id="orderQuery">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">订单管理</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="navbar" class="order_manager_tab">
						<ul>
							<li id="undoneOrder_li2"><a href="#" data-transition="none">未完成订单</a></li>
							<li id="doneOrder_li2"><a href="#" data-transition="none">已完成订单</a></li>
							<li><a href="javascript:void(0)" data-transition="none" class="ui-btn-active ui-state-persist">订单号查询</a></li>
						</ul>
					</div>
					<div data-role="content">
						<ul class="fm-list hwzz_search">
							<li>
								<label><font class="f_yellow">*</font>订单号:</label>								
								<input type="text" name="orderNo" id="queryOrderNo" class="input-text-line" data-role="none" style="border:0px;width:100%"/>
							</li>
						</ul>
						<div class="login-action">
							<a href="javascript:void(0)" id="queryOrder_bt" class="ui-btn btn-submit" data-ajax="false">查询</a>
			            </div>
						<div id="queryOrder_div"></div>
					</div>
					<%@ include file="../footer.jsp" %>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %> 
				</div>
			</div>
		</div>
	</div>

	
	<!-- 详情页面 -->
	<div data-role="page" id="detail_page">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" id="detail_back">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">订单详情</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div data-role="content" style="padding:0;">
						<div id="detail_con">
							<div class="order_detail_info01">
								<h4><span name="einoStatus" class="fr"></span>订单号：<span name="einoContractNo"></span></h4>
							</div>
							
							<div class="order_detail_info02">
								<h4>发货人信息</h4>
								<div>
									<ul>
										<li>发货人：<span name="einoShipperEbsaContact"></span></li>
										<li>手机号：<span name="einoShipperEbsaMobile"></span></li>
										<li>固话：<span name="einoShipperEbsaTel"></span></li>
										<li>公司名称：<span name="einoShipperEbspNameCn"></span></li>
										<li>发货人地址：<span name="shipperAddress"></span></li>
										<li>发货网点：<span name="einoEscoSecondName"></span></li>
										<li>网点信息：<span name="companyMsg"></span></li>
									</ul>
								</div>
								<h4>收货人信息</h4>
								<div>
									<ul>
										<li>收货人：<span name="einoConsigneeEbsaContact"></span></li>
										<li>手机号： <span name="einoConsigneeEbsaMobile"></span></li>
										<li>固话：<span name="einoConsigneeEbsaTel"></span></li>
										<li>收货人地址：<span name="consigneeAddress"></span></li>
									</ul>
								</div>
								<h4>货物信息</h4>
								<div>
									<ul>
										<li>
											<table width="100%">
												<tr>
													<td>货物名称：<span name="einoCargoName"></span></td>
													<td>保价声明：<span name="einoInsurance"></span></td>
												</tr>
												<tr>
													<td>货物包装：<span name="einoPackage"></span></td>
													<td>货物件数：<span name="einoNumber"></span></td>
												</tr>
												<tr>
													<td>货物重量：<span name="einoTotalWeight"></span></td>
													<td>货物体积：<span name="einoTotalVolume"></span></td>
												</tr>
											</table>
										</li>
									</ul>
								</div>
								<h4>服务信息</h4>
								<div>
									<ul>
										<li>
											<table width="100%">
												<tr>
													<td>运输方式：<span name="einoProductTypeName"></span></td>
													<td>付款方式：<span name="einoPaymentMethod"></span></td>
												</tr>
												<tr>
													<td>送货方式：<span name="einoShipperMethod"></span></td>
													<td>短信通知：<span name="einoSmsNotif"></span></td>
												</tr>
												<tr>
													<td>代收货款：<span name="einoCollDeliveryAmount"></span></td>
													<td>签单返回：<span name="einoSignBack"></span></td>
												</tr>
												<tr>
													<td></td>
													<td></td>
												</tr>
											</table>
										</li>
										<li>备注：<span name="einoRemark"></span></li>
									</ul>
								</div>
							</div>							
						</div>
					</div>
				</div>
				<div id="map-page">
					<%@ include file="../nav-map.jsp" %> 
				</div>
			</div>
		</div>
	</div>
	
	<!-- 弹出对话框 -->
	<div data-role="dialog" id="order_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="dialg_header"></h1>
		</div>
		<div data-role="content">
			<div align="center" id="order_dialog_con"></div>
		</div>
	</div>
	
	<!-- 弹出对话框 -->
	<div data-role="dialog" id="err_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="err_header">服务器异常</h1>
		</div>
		<div data-role="content">
			<div align="center" id="err_dialog_con">服务器内部错误，请稍后重试此请求。</div>
		</div>
	</div>
</body>
