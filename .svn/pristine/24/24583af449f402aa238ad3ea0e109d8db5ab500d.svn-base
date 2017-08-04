<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %> 
<title>附近门店列表</title>
<script src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script src="${scripts}/department_list.js"></script>
</head>
<body>
	<!-- 附近门店列表 -->
	<div data-role="page" id="nearbyDepartmentPage">
		<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">门店列表</h1>
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
						<div data-role="collapsible-set">
							<s:if test="departmentVos.size>0">
								<s:iterator value="departmentVos" status="st">
									<div class="department_list">
									<div data-role="collapsible" data-collapsed="false" data-collapsed-icon="chevron-circle-down" data-expanded-icon="chevron-circle-up" class="department_list_info">
										<!-- 标题 -->
										<h1 class="department_name">
											<s:property value="deptName" />
										</h1>
										<!-- 每一个部门信息 -->
										<table style="width:100%" class="collapsible_list_tab">
											<tr style="display: none;">
												<td id="position<s:property value="#st.index"/>" style="width:30%"><s:property value="lng" />-<s:property value="lat" />#<%=request.getParameter("llon") %>-<%=request.getParameter("llat") %>#<s:property value="deptName" />)</td>
												<td style="width:70%"></td>
											</tr>
											<tr>
												<td>
													<p>
														<span><img src="${images}/deptontime.png" width="24"></span>											
														<!-- <s:if test="DDAvailable">定日达</s:if>
														<s:else>零担</s:else> -->
														<s:property value="serviceName" />
							                    	</p>
												</td>
												<td>
													<p>
														<span><img src="${images}/deptaddr.png" width="24"></span>
														<s:property value="logistCode" />
													</p>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<p>
														<span><img src="${images}/deptphone.png" width="24"></span>
														<i style='display: none' id='<s:property value="#st.index" />_area'><s:property value="areaCode" /></i>
														<i style='display: none' id='<s:property value="#st.index" />_phone'><s:property value="phone" /></i>
														<tel id='<s:property value="#st.index" />_show_phone' ></tel>
													</p>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<p>
														<span><img src="${images}/deptaddr.png" width="24"></span>
														<s:property value="addressDetail" />
													</p>
												</td>
											</tr>
										</table>
										<div class="collapsible_list_tab02">
											<table style="text-align: center;width: 100%;">
												<tr>
													<td style="width:50%;">
														<div style="border-right:1px solid #9a9a9a">
															<img id="<s:property value='#st.index'/>" src="${images}/go.png" width="28" onclick="changePage(this)">
														</div>
													</td>
													<td  style="width:50%">
														<a id='<s:property value="#st.index" />_call'><img src="${images}/call.png" width="28"></a>
													</td>
												</tr>
											</table>
										</div>
									</div>
									</div>
								</s:iterator>
							</s:if>
						    <s:else>
						 		<div style="color:red; margin-bottom:20px;margin-top:10px;"><b>无网点信息</b></div> 
						    </s:else>
						    <script>
								(function($){
									$('i').each(function(i,v){
										var $area = $('#'+i+'_area').html()
										,$phone = $('#'+i+'_phone').html()
										,tel;
										if(($area!=''&&$phone!='')&&($area!=undefined&&$phone!=undefined)){
											if($phone.indexOf('/')>0){
												var p = $phone.split('/');
												if(p[0].length!=11){
													$('#'+i+'_call').prop('href','tel://'+$area+'-'+p[0]);
												}
											}else{
												if($phone.length==11){
													$('#'+i+'_call').prop('href','tel://'+$phone);
												}else{
													$('#'+i+'_call').prop('href','tel://'+$area+'-'+$phone);
												}
											}
											$('#'+i+'_show_phone').html($area+'-'+$phone)
										}else{
											if($phone!=undefined&&$phone.indexOf('/')>0){
												var s = $phone.split('/');
												$('#'+i+'_call').prop('href','tel://'+s[0]);
											}
											$('#'+i+'_show_phone').html($phone)
										}
									})
								})(jQuery);
							</script>
						</div>
					</div>
					<%@ include file="../bse/footer.jsp" %>
				</div>
				<div id="map-page">
					<%@ include file="../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>
	</div>
	<!-- 显示两个点之间的线路 -->
	<div data-role="page" id="linePage">
	  <!-- <div data-role="header">
	    <h1>线路</h1>
	  </div> -->
	  <div data-role="content">
		<div id="map" style="width:100%; height:500px;"></div>
	  </div>
	</div> 
</body>
