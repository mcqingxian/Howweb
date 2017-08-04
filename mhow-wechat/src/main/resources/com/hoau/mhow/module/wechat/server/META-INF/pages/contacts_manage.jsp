<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../bse/common.jsp" %>
<link rel="stylesheet" href="${styles}/public.css"/>
<script src="${scripts}/contacts_manage.js"></script>
<meta charset="utf-8">
<title>地址簿管理</title>
</head>
<body>
<!-- 地址簿管理 -->
<!-- 发货人信息 -->
<div data-role="page" id="sender">
	<div id="wrapper">
		<div id="wrapper-in">
			<div id="main-page">
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:history.go(-1);">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">地址簿</h1>
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
			          <li><a href="" data-transition="none" class="ui-btn-active ui-state-persist" style="font-size: 14px;">发货人信息</a></li>
			          <li id="receiver_li"><a href="#" data-transition="none" style="font-size: 14px;">收货人信息</a></li>
			        </ul>
		        </div>
			    <div class="tc add_senderPlus_btn">
			    	<a href="contactOperate.action?ebsaType=shipper" name="senderPlus" data-ajax='false'>新增地址</a>
			    </div>
			    <div data-role="content">
					 <ul class="add_senderPlus_list">
				  	   <s:if test="senderContactsList.size>0">
				             <s:iterator value="senderContactsList" status="st">
						  		<li>
						  			<div class="order_manager_list_info">
							  			<p><span id="<s:property value='#st.index'/>_default" name="<s:property value="ebsaId" />" class="fr"></span>姓名:<span><s:property value="ebsaContact" /></p>
							  			<p>联系电话:<s:property value="ebsaMobile" /></p>
							  			<p>所在区域:<s:property value="ebsaDeptDistrict"/>
							  			<p>详细地址:<s:property value="ebsaAddress" /></p></p><span style="display:none" name="ebsaIsDefault"><s:property value="ebsaIsDefault" /></span></p>
							  			<p>发货网点：<s:property value="ebsaEscoSecondName"/></p>
						  			</div>
						  			<div class="add_senderPlus_list_btn tc clearfix">
						  				<span class="add_senderPlus_order">
											<a href="javascript:void(0)" id="place_order_link">下单</a>
						  					<span style="display: none"><s:property value="ebsaId" /></span>
										</span>
										<span class="add_senderPlus_edit">
											<a href="javascript:void(0)" id="update_link">修改</a>
						  					<span style="display: none"><s:property value="ebsaId" /></span>
										</span>
										<span class="add_senderPlus_delete">
											<a href="javascript:void(0)" id="delete_link">删除</a>
						  					<span style="display: none"><s:property value="ebsaId" /></span>
										</span>
									</div>
						  		</li>
				  			</s:iterator>           
				       </s:if>
					</ul>
					   <s:else>
				             <p style="margin-top: 100px;text-align: center;">
				             	你还没有添加发货人地址，请点击上方的添加按钮，增加发货人地址！
				             </p>  	     
				       </s:else>
				  </div>
				  <%@ include file="../bse/footer.jsp" %>
			</div>
			<div id="map-page">
				<%@ include file="../bse/nav-map.jsp" %> 
			</div>
		</div>
	</div>  
</div> 

<!-- 收货人信息 -->
<div data-role="page" id="receiver">
	<div id="wrapper">
		<div id="wrapper-in">
			<div id="main-page">
				<div class="header">
					<span class="btn-topl">
						<a class="link-back" href="javascript:history.go(-1);">
							<span class="ui-ico ui-ico-back"></span>
						</a>
					</span>
					<h1 class="innertitle">地址簿</h1>
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
			          <li id="sender_li"><a href="#" data-transition="none" style="font-size: 14px;">发货人信息</a></li>
			          <li><a href="" data-transition="none" class="ui-btn-active ui-state-persist" style="font-size: 14px;">收货人信息</a></li>
			        </ul>
			    </div>
			    <!-- <a id="receiverPlus" data-transition="none" data-role="button"><img height=25 width=25 src="<%=request.getContextPath()%>/images/wechat/img/plus.png"></a> -->
			    <div class="tc add_senderPlus_btn">
			    	<a href="contactOperate.action?ebsaType=consignee" name="senderPlus" data-ajax='false'>新增地址</a>
			    </div>
			    <div data-role="content">
					<ul class="add_senderPlus_list">
				  		<s:if test="receivercontactsList.size>0">
				             <s:iterator value="receivercontactsList" status="st">
						  		<li> 
						  			<div class="order_manager_list_info">
							  			<p><span id="<s:property value='#st.index'/>_default" name="<s:property value="ebsaId" />" class="fr"></span>姓名:<span><s:property value="ebsaContact" /></p>
							  			<p>联系电话:<s:property value="ebsaMobile" /></p>
							  			<p>所在区域:<s:property value="ebsaDeptDistrict"/>
							  			<p>详细地址:<s:property value="ebsaAddress" /></p></p></p>
									</div>
									<div class="add_senderPlus_list_btn tc clearfix">
										<span class="add_senderPlus_order">
											<a href="javascript:void(0)" id="place_order_link" data-ajax='false'>快速下单</a>
											<span style="display: none"><s:property value="ebsaId" /></span>
										</span>
										<span class="add_senderPlus_edit">
											<a href="javascript:void(0)" id="update_link" data-ajax='false'>修改</a>
											<span style="display: none"><s:property value="ebsaId" /></span>
										</span>
										<span class="add_senderPlus_delete">
											<a href="javascript:void(0)" id="delete_link">删除</a>
						  					<span style="display: none"><s:property value="ebsaId" /></span>
										</span>
									</div>
						  		</li>
				  			</s:iterator>           
				       </s:if>
					</ul>
					   <s:else>
				             <p style="margin-top: 100px;text-align: center;">
				             	你还没有添加收货人地址，请点击上方的添加按钮，增加收货人地址！
				             </p>  	     
				       </s:else>
				  </div>
				  <%@ include file="../bse/footer.jsp" %>
			</div>
			<div id="map-page">
				<%@ include file="../bse/nav-map.jsp" %> 
			</div>
		</div>
	</div>
</div> 
<!-- 弹出对话框 -->
<div data-role="dialog" id="msg_dialog" data-close-btn="right">
	<div data-role="header">
		<h1 id="dialg_header">提示</h1>
	</div>
	<div data-role="content">
		<div align="center" id="msg_dialog_con"></div>
	</div>
</div>
</body>
	