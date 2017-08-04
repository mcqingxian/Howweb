<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %> 
<script type="text/javascript" src="${scripts}/goods_trace.js"></script>
</head>
<body>
<div data-role="page">
	<div id="wrapper">
		<div id="wrapper-in">
			<div id="main-page">	
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:history.go(-1);">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">货物追踪</h1>
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
					
					<label for="waybill">运单查询历史记录</label> 
					<select id="his_waybills" name="his_waybills">
					</select>
					<%--  <s:if test="waybills.size>0">
						<select id="his_waybills" name="his_waybills">
							<s:iterator value="waybills" status="st" var="wbill">
			                	<option value="<s:property value="wbill" />"><s:property value="wbill" /></option>
			               	</s:iterator>
						</select>
					 </s:if>
					 <s:else>
					 	<div style="color:red; margin-bottom:20px;margin-top:10px;"><b>无历史记录</b></div> 
					 </s:else>--%>
					<div class="grid-main">
						<ul class="fm-list hwzz_search">
							<li>
								<label><font class="f_yellow">*</font>运单编号</label>
								<input type="text" data-role="none" class="input-text-line" id="waybill" name="waybill" size="15" placeholder="请输入运单号">
							</li>
						</ul>
						<div class="login-action">
							<a href="javascript:void(0)" id="data_btn" class="ui-btn btn-submit">查询</a>
						</div>				
						<ul id="datatable" class="hwzz_search_list">
							
						</ul>
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
	<div data-role="dialog" id="dialog">
		<div data-role="header">
			<h1>提示</h1>
		</div>
		<div data-role="content">
			<p>无该运单跟踪信息，请检查运单是否输入有误！</p>
		</div>
	</div>
	<!-- 弹出对话框 -->
	<div data-role="dialog" id="err_dialog" data-close-btn="right">
		<div data-role="header">
			<h1 id="err_dialg_header">服务器异常</h1>
		</div>
		<div data-role="content">
			<div align="center" id="err_dialog_con">服务器内部错误，请稍后重试此请求。</div>
		</div>
	</div>
</body>
</html>
