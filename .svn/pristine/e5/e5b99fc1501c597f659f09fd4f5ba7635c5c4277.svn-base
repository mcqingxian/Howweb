<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/wechat/public.css"/>
<title>天地华宇</title>
</head>
<style>
	#datatable>li>div.trace{
		float: left;
	}
	#datatable>li>div>span.status{
		margin-right: .5rem;
	}
</style>
<body>
	<!-- 运单详情对话框 -->
	<div data-role="page" id="waybill_detail">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">运单信息</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
						</span>
					</div>
					<div data-role="content" style="padding:0;">
						<div id="waybill_detail_con">
							<div id="<s:property value='goodsTraceResult.waybillNo'/>">
								 <s:if test="goodsTraceResult.goodsName == null or goodsTraceResult.goodsName ==''">
						             <div>
						             	<p>您好,暂无该运单详细信息</p>
						             </div>
							     </s:if>
							     <s:else>
							     <div class="order_detail_info01">
							    	 <h4 id="transNo">运单号：<font color="red"><s:property value='goodsTraceResult.waybillNo'/></font></h4>
							    </div>
							        <div class="order_detail_info02" style="border-bottom:0;">
							        	<h4>货物基本信息：</h4>
										<div>	
											<p>
												<span>出发城市：<s:property value="goodsTraceResult.fromCity"/></span>
												<span>到达城市：<s:property value="goodsTraceResult.toCity"/></span>
											</p>
											<p>
												<span>运输方式：<s:property value="goodsTraceResult.transMethod"/></span>
												<span>取货方式：<s:property value="goodsTraceResult.pickUpMethod"/></span>
											</p>
											<p>
												<span>货物名称：<s:property value="goodsTraceResult.goodsName"/></span>
												<span>件数：<s:property value="goodsTraceResult.pieces"/></span>
											</p>
											<p>
												<span>重量：<s:property value="goodsTraceResult.weight"/> </span>
												<span>体积：<s:property value="goodsTraceResult.volume"/></span>
											</p>
										</div>
										<h4>提货公司信息：</h4>
										<div>
											<p>提货公司名称： <s:property value="goodsTraceResult.pickUpCompanyName"/></p> 
											<p>提货公司电话： <s:property value="goodsTraceResult.pickUpCompanyPhone"/></p> 
											<p>提货公司地址：<s:property value="goodsTraceResult.pickUpCompanyAddress"/></p>
											<p>提货公司客服电话： <s:property value="goodsTraceResult.customerServicePhone"/></p> 
										</div>
									</div>
							     </s:else>
							</div>
							<div data-role="content" style="padding:0;">
								<div id="waybill_page_con">
										
									
										<s:if test="goodsTraceResult.traceInfos!=null&&goodsTraceResult.traceInfos.size()>0">
											<h4 style="margin: 0 1em;color: #000;">运单追踪</h4>		
											<ul id="datatable" class="hwzz_search_list">								
											<s:iterator value="goodsTraceResult.traceInfos" var="traceinfo" status="s">
												<s:if test="#s.index==0">
													<li>
														<span class='hwzz_search_icon'></span>
														<!-- <span class='status'><s:property value="status"/></span> -->
														<span><s:property value="time"/></span></br>
														<span class='desc'><s:property value="desc"/></span>
													</li>
												</s:if>
												<s:else>
													<li>
														<span class='hwzz_search_icon'></span>
														<!-- <span class='status'><s:property value="status"/></span> -->
														<span><s:property value="time"/></span></span></br>
														<span class='desc'><s:property value="desc"/></span>
													</li>
												</s:else>
											</s:iterator>
											</ul>
										</s:if>
									
								</div>
							</div>
						</div>
					</div>
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
<script>
	(function($){
		$("#datatable").find('span.status').each(function(){
			if($(this).text()==''){
				$(this).addClass('space');
			}
		})
	})(jQuery);
</script>
