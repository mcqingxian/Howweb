<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网上下单</title>
<%@include file="../head.jsp"%>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/order/order.js"></script>
<script type="text/javascript" src="${scripts}/order/orderCounter.js"></script>
<script type="text/javascript" src="${scripts}/order/orderRegist.js"></script>
<script type="text/javascript" src="${scripts}/order/orderLogin.js"></script>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
<script type="text/javascript">
$(function(){
	$(".subNav").click(function(){
		$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
		// 修改数字控制速度， slideUp(500)控制卷起速度
		$(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
	})
})
</script>
<style>

.chang_sel{display: inline-block;}
.chang_sel .select_ui{ width:256px;}

.aa{color:#F00;}
</style>
</head>
<body onload="showCargoInfo('${param.errorType}','${errorType}');">
	<%@include file="../top.jsp"%>
	<div class="content">
		<div class="p_w">
			<%@include file="../obh_nav.jsp" %>
			<div class="col_right fr">
				<div class="drd_pic"><img src="${images}/order_banner.jpg" width="770" alt="网上下单"/></div>
				<form action="" method="post" id="orderForm">
					<div class="news_detail pb20 pr">
						<input name="entity.einoLuoji" id="entity.einoLuoji" value="${param.p}" style="display:none;"/>
						<s:if test="fromPage == 'modify'">
							<h1 class="news_title">修改订单</h1>
						</s:if>
						<s:else>
							<h1 class="news_title">
								<a href="#" class="xz1 fr mr15" id="history_btn"
									style="padding: 0 10px; margin-top: 7px;">历史下单</a>
								<a href="#" class="xz1 fr mr15" id="quick_order_btn"
								style="padding: 0 10px; margin-top: 7px;">快速下单</a>网上下单
							</h1>
						</s:else>
						<input type="hidden" id="fromPage" name="fromPage"
							value="${fromPage }" /> <input id="entity.einoId"
							name="entity.einoId"
							value='<s:property value="#request.entity.einoId"/>'
							style="display: none;" />
						<s:if test="fromPage == 'modify'">
							<input id="entity.einoEbccId" name="entity.einoEbccId"
								value='<s:property value="#request.entity.einoEbccId"/>'
								style="display: none;" />
							<input id="entity.einoStatus" name="entity.einoStatus"
								value='<s:property value="#request.entity.einoStatus"/>'
								style="display: none;" />
							<input id="entity.einoContractNo" name="entity.einoContractNo"
								value='<s:property value="#request.entity.einoContractNo"/>'
								style="display: none;" />
						</s:if>
						<c:if test="${sessionScope.USER_INFO == null}">
							<div class="pa f333" style="line-height: 25px; top: -35px;" id="noLoginDiv">
								&gt;&gt; 15秒即可完成注册，尽享更多优惠和便捷。 <a href="regist.action"
									class="f_f15a22">立即注册</a> | 已有帐号？ <a href="login.action"
									class="f_f15a22">现在登录</a>
							</div>
						</c:if>
						<div class="consignor_tit f16">发货人信息</div>
						<div class="consignor_Mess f12">
							<ul>
								<li><label class="zt_widthlabel"><b>*</b>发货人：</label> <input
									type="text" id="entity.einoShipperEbsaContact"
									name="entity.einoShipperEbsaContact" maxlength="50"
									<s:if test="#request.entity.einoShipperEbsaContact != null and #request.entity.einoShipperEbsaContact != \"\"">value='<s:property value="#request.entity.einoShipperEbsaContact"/>'</s:if>
									class="input w170" /> <a href="javascript:void(0)"
									class="f_f15a22" id="sel_consigner">选择发货人</a>
									<div class="tips" id="shipperEbsaContact_tips"></div></li>
								<li><label class="zt_widthlabel">手机：</label> <input
									type="text" id="entity.einoShipperEbsaMobile"
									name="entity.einoShipperEbsaMobile" class="input w170"
									maxlength="11"
									<s:if test="#request.entity.einoShipperEbsaMobile != null and #request.entity.einoShipperEbsaMobile != \"\"">value='<s:property value="#request.entity.einoShipperEbsaMobile"/>'</s:if> />
									<label class="zt_widthlabel">固定电话：</label> <input type="text"
									name="entity.einoShipperEbsaTel" id="entity.einoShipperEbsaTel"
									class="input w170"
									<s:if test="#request.entity.einoShipperEbsaTel != null and #request.entity.einoShipperEbsaTel != \"\"">value='<s:property value="#request.entity.einoShipperEbsaTel"/>'</s:if> />
									<div class="tips" id="shipperEbsaMobile_tips"></div></li>
								<li><label class="zt_widthlabel"></label><b
									class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
								</li>
								<li>
									<label class="zt_widthlabel">公司名称：</label> <input
									type="text" id="entity.einoShipperEbspNameCn"
									name="entity.einoShipperEbspNameCn" maxlength="50"
									<s:if test="#request.entity.einoShipperEbspNameCn != null and #request.entity.einoShipperEbspNameCn != \"\"">value='<s:property value="#request.entity.einoShipperEbspNameCn"/>' class="input"</s:if>
									<s:else>value="若需开票，需必填，与开票公司抬头保持一致" class="input inputFocus"</s:else>
									ov="若需开票，需必填，与开票公司抬头保持一致"
									class="input" style="width:432px;"/>
								</li>
								<li><label class="zt_widthlabel"><b>*</b>发货地址：</label> <label
									class="newprocitySel"> <input
										id="entity.shipperDistrict"
										onchange="loadPriceTime();synSecondDistrict(this);"
										autocomplete="off" type="text" readonly="readonly"
										maxlength="200"
										<s:if test="#request.entity.shipperDistrict == null or #request.entity.shipperDistrict == \"\"">class="w170 input grays send_input proCityQueryAll proCitySelAll inputFocus" </s:if>
										<s:else>class="w170 input send_input proCityQueryAll proCitySelAll inputFocus" </s:else>
										name="entity.shipperDistrict" ov="请选择所在省市"
										<s:if test="#request.entity.shipperDistrict != null and #request.entity.shipperDistrict != \"\""> value="<s:property value="#request.entity.shipperDistrict"/>" </s:if>
										<s:else> value="请选择所在省市"</s:else> />
								</label> <input id="entity.einoShipperEbsaAddress"
									name="entity.einoShipperEbsaAddress" ov="请输入街道、路名..."
									<s:if test="#request.entity.einoShipperEbsaAddress != null and #request.entity.einoShipperEbsaAddress != \"\""> 
										value="<s:property value="#request.entity.einoShipperEbsaAddress"/>" class="input w205 inputFocus" 
									</s:if>
									<s:else> 
										value="请输入街道、路名..." class="input w205 inputFocus grays"
									</s:else>
									class="input" style="width: 253px;" maxlength="200" />
									<div class="tips" id="shipperDistrict_tips"></div> <!-- <input type="button" value="匹配网点" class="tosnmiddle_btn " /> -->
								</li>
								<li class="chang_sel"><label class="zt_widthlabel">发货网点：</label> <label
									class="newprocitySel"> <input
										id="entity.einoSecondDistrict"
										onchange="loadSecondDistrict('#entity\\.einoEscoSecondCode',this);"
										autocomplete="off" type="text" readonly="readonly"
										<s:if test="#request.entity.einoSecondDistrict == null or #request.entity.einoSecondDistrict == \"\"">class="w170 input grays send_input proCityQueryAll proCitySelAll inputFocus" </s:if>
										<s:else>class="w170 input send_input proCityQueryAll proCitySelAll inputFocus" </s:else>
										name="entity.einoSecondDistrict" ov="请选择所在省市"
										<s:if test="#request.entity.einoSecondDistrict != null and #request.entity.einoSecondDistrict != \"\""> value="<s:property value="#request.entity.einoSecondDistrict"/>" </s:if>
										<s:else>value="请选择所在省市"</s:else> />
								</label> <select id="entity.einoEscoSecondCode"
									name="entity.einoEscoSecondCode"
									onchange="changeCompany(this,'#companyMsg','#entity\\.einoEscoSecondName');">
										<option value="-1">请选择网点</option>
								</select>
								<input id="entity.einoEscoSecondName"
									name="entity.einoEscoSecondName"
									value="<s:property value="#request.entity.einoEscoSecondName"/>"
									style="display: none;" />
									<input id="einoEscoSecondCode"
									name="einoEscoSecondCode"
									value="<s:property value="#request.entity.einoEscoSecondCode"/>"
									style="display: none;" />
									<div class="tips" id="secondDistrict_tips"></div></li>
								<li><label class="zt_widthlabel">网点信息：</label> <span
									class="mr15" id="companyMsg"></span><a href="#"
									class="f_f15a22" id="mapBtn">查看地图</a></li>
							</ul>
						</div>

<%--收货人信息--%>
						<div class="consignor_tit f16">收货人信息</div>
						<div class="consignor_Mess f12">
							<ul>
								<li><label class="zt_widthlabel"><b>*</b>收货人：</label> <input
									type="text" id="entity.einoConsigneeEbsaContact"
									name="entity.einoConsigneeEbsaContact"
									value="<s:property value="#request.entity.einoConsigneeEbsaContact"/>"
									class="input w170" maxlength="50" /> <a
									href="javascript:void(0)" class="f_f15a22" id="sel_consignee">选择收货人</a>
									<div class="tips" id="consigneeEbsaContact_tips"></div></li>
								<li><label class="zt_widthlabel">手机：</label> <input
									type="text" id="entity.einoConsigneeEbsaMobile"
									name="entity.einoConsigneeEbsaMobile"
									value="<s:property value="#request.entity.einoConsigneeEbsaMobile"/>"
									class="input w170" maxlength="11" /> <label
									class="zt_widthlabel">固定电话：</label> <input type="text"
									value="<s:property value="#request.entity.einoConsigneeEbsaTel"/>"
									id="entity.einoConsigneeEbsaTel"
									name="entity.einoConsigneeEbsaTel" class="input w170"
									value="<s:property value="#request.entity.einoConsigneeEbsaTel"/>" />
									<div class="tips" id="consigneeEbsaMobile_tips"></div></li>
								<li><label class="zt_widthlabel"></label><b
									class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
								</li>
<%--公司名称 肖聪-新增 --%>
								<li>
									<label class="zt_widthlabel">公司名称：</label> <input
										type="text" id="entity.einoConsigneeEbspNameCn"
										name="entity.einoConsigneeEbspNameCn" maxlength="50"
										<s:if test="#request.entity.einoConsigneeEbspNameCn != null and #request.entity.einoConsigneeEbspNameCn != \"\"">value='<s:property value="#request.entity.einoConsigneeEbspNameCn"/>' class="input"</s:if>
										<s:else>value="若需开票，需必填，与开票公司抬头保持一致" class="input inputFocus"</s:else>
										ov="若需开票，需必填，与开票公司抬头保持一致"
										class="input" style="width:432px;"/>
								</li>
								<li>
									<label class="zt_widthlabel"><b>*</b>收货地址：</label> <label class="newprocitySel"> <input id="entity.consigneeDistrict" onchange="loadPriceTime();"
										autocomplete="off" type="text"
										maxlength="200" readonly="readonly"
										<s:if test="#request.entity.consigneeDistrict == null or #request.entity.consigneeDistrict == \"\"">class="w170 input grays send_input proCityQueryAll proCitySelAll inputFocus" </s:if>
										<s:else>class="w170 input send_input proCityQueryAll proCitySelAll inputFocus" </s:else>
										name="entity.consigneeDistrict" ov="请选择所在省市"
										<s:if test="#request.entity.consigneeDistrict != null and #request.entity.consigneeDistrict != \"\""> value="<s:property value="#request.entity.consigneeDistrict"/>" </s:if>
										<s:else> value="请选择所在省市"</s:else> />
								</label> <input id="entity.einoConsigneeEbsaAddress"
									name="entity.einoConsigneeEbsaAddress" ov="请输入街道、路名..."
									<s:if test="#request.entity.einoConsigneeEbsaAddress != null and #request.entity.einoConsigneeEbsaAddress != \"\"">
									value="<s:property value="#request.entity.einoConsigneeEbsaAddress"/>" class="input w205 inputFocus"
								</s:if>
									<s:else>
									value="请输入街道、路名..." class="input w205 inputFocus grays"
								</s:else>
									class="input" style="width: 253px;" />
									<div class="tips" id="consigneeDistrict_tips"></div></li>
							</ul>
						</div>
						<%--<br>--%>
						<%--<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>--%>
						<%--<br>--%>



						<div class="consignor_tit f16" style="display: none;"
							id="productType_div">运输方式</div>
						<div class="consignor_Mess f12" style="display: none;"
							id="productType_div2">
							<table class="change_mode" border="0" cellspacing="0"
								cellpadding="0" width="100%">
								<tr class="first">
									<td width="24%">运输方式</td>
									<td width="28%">时效</td>
									<td width="16%">起步价（元/票)</td>
									<td width="16%">重货(元/公斤)</td>
									<td width="16%">轻货(元/立方米)</td>
								</tr>
								<tr>
									<td><label class="change_mode_sel"> <input
											type="radio" id="rdo_ld" name="entity.einoProductTypeName"
											value="经济快运"
											<s:if test="#request.entity == null or #request.entity.einoProductTypeName == null or #request.entity.einoProductTypeName == '经济快运'">checked="checked"</s:if> />经济快运
									</label></td>
									<td id="ld_deliveryTime_td"></td>
									<td id="ld_startPrice_td"></td>
									<td id="ld_heavyPrice_td"></td>
									<td id="ld_lightPrice_td"></td>
								</tr>
								<tr>
									<td><label class="change_mode_sel"> <input
											type="radio" id="rdo_drd" name="entity.einoProductTypeName"
											value="定日达"
											<s:if test="#request.entity.einoProductTypeName != null and #request.entity.einoProductTypeName == '定日达'">checked="checked"</s:if>
											<s:else>disabled="disabled"</s:else> />定日达
									</label></td>
									<td id="drd_deliveryTime_td"></td>
									<td id="drd_startPrice_td"></td>
									<td id="drd_heavyPrice_td"></td>
									<td id="drd_lightPrice_td"></td>
								</tr>
								<!-- 新增易入户，易安装，易包裹三种运输方式，田育林修改，2016-4-28 -->
								<tr>
									<td><label class="change_mode_sel"> <input
											type="radio" id="rdo_rh" name="entity.einoProductTypeName"
											value="易入户"
											<s:if test="#request.entity.einoProductTypeName != null and #request.entity.einoProductTypeName == '易入户'">checked="checked"</s:if> 
											<s:else>disabled="disabled"</s:else> />易入户
									</label></td>
									<td id="rh_deliveryTime_td"></td>
									<td id="rh_startPrice_td"></td>
									<td id="rh_heavyPrice_td"></td>
									<td id="rh_lightPrice_td"></td>
								</tr>
								<tr>
									<td><label class="change_mode_sel"> <input
											type="radio" id="rdo_az" name="entity.einoProductTypeName"
											value="易安装"
											<s:if test="#request.entity.einoProductTypeName != null and #request.entity.einoProductTypeName == '易安装'">checked="checked"</s:if> 
											<s:else>disabled="disabled"</s:else> />易安装
									</label></td>
									<td id="az_deliveryTime_td"></td>
									<td id="az_startPrice_td"></td>
									<td id="az_heavyPrice_td"></td>
									<td id="az_lightPrice_td"></td>
								</tr>
								<tr>
									<td><label class="change_mode_sel"> <input
											type="radio" id="rdo_bg" name="entity.einoProductTypeName"
											value="易包裹"
											<s:if test="#request.entity.einoProductTypeName != null and #request.entity.einoProductTypeName == '易包裹'">checked="checked"</s:if> 
											<s:else>disabled="disabled"</s:else> />易包裹
									</label></td>
									<td id="bg_deliveryTime_td"></td>
									<td id="bg_startPrice_td"></td>
									<td id="bg_heavyPrice_td"></td>
									<td id="bg_lightPrice_td"></td>
								</tr>
							</table>
						</div>
						<div class="consignor_tit f16" style="display: none;" id="cargoInfo_div">
							<span class="zt_addnum fr"><a class="font-org f12 aDown" href="javascript:void(0)" onclick="closeCounter(this)">打开辅助计算器</a></span>货物信息
						</div>
						<div class="consignor_Mess f12" style="border: 0; display: none;" id="cargoInfo_div2">
							<div class="add_totalnum hide">
								<div id="frist_div">
									<div class="tosn_middlebg mt10">
										<p class="dataTitle" style="padding-left:30px;">
											<span class="fr mr15">
												<a class="font-org ml30" href="javascript:void(0);" id="contractionBtn" onclick="contraction(this);">收起</a>
												<a class="font-org ml30" href="javascript:void(0)" id="deleteCounterBtn" onclick="deleteCounter(this)">删除</a> 
											</span> <span class="maright">重量： <span class="kg" id="totalWeight"></span> 千克</span>
											<span class="maright">体积： <span class="m3" id="totalVolumn"></span> 立方米</span>
											<span class="maright">件数：<span class="sz" id="totalNumber"></span> 件</span>
										</p>
										<div class="laction">
											<div class="laction_row">
												<label>单件重量：</label>
												<input id="weight" type="text" class="nomarl singleWeight iGrays" 
												onkeyup="if(isNaN(value))execCommand('undo')"
												onafterpaste="if(isNaN(value))execCommand('undo')"
												maxlength="6" modifylength="8" onblur="checkCounter(this,'weight_tips','重量');"/>
												<span>千克</span>
												<div class="tips" id="weight_tips">
												</div>
											</div>
											<div class="org laction_row">
												<label>单件体积：</label>
												<input id="long" type="text" class="nomarl inputFocus iGrays" 
												onkeyup="if(isNaN(value))execCommand('undo')"
												onafterpaste="if(isNaN(value))execCommand('undo')"  onblur="checkCounter(this,'volumn_tips','长度');calcVolume(this);"
												value="长(cm)" ov="长(cm)" maxlength="5" modifylength="6" /><span class="report">×</span>
												<input id="wide" type="text" class="nomarl inputFocus iGrays" 
												onkeyup="if(isNaN(value))execCommand('undo')"
												onafterpaste="if(isNaN(value))execCommand('undo')"  onblur="checkCounter(this,'volumn_tips','宽度');calcVolume(this);"
												value="宽(cm)" ov="宽(cm)" maxlength="5" modifylength="6" /><span class="report">×</span>
												<input id="height" type="text" class="nomarl inputFocus iGrays" 
												onkeyup="if(isNaN(value))execCommand('undo')"
												onafterpaste="if(isNaN(value))execCommand('undo')"  onblur="checkCounter(this,'volumn_tips','高度');calcVolume(this);"
												value="高(cm)" ov="高(cm)" maxlength="5" modifylength="6" /><span class="report">＝</span>
												<span class="singleVolume"></span>
												<span>立方米</span>
												<div class="tips" id="volumn_tips">
												</div>
											</div>
											<div class="laction_row">
												<label>件数：</label>
												<input id="number" type="text" class="nomarl singleSize iGrays" 
												onkeyup="this.value=this.value.replace(/\D/g,'')"
												onafterpaste="this.value=this.value.replace(/\D/g,'')" onblur="checkCounter(this,'number_tips','件数');"
												value="" maxlength="4" />
												&nbsp;<a href="javascript:void(0)" class="tosnmiddle_btn" onclick="confirm(this);">确认</a>
												<input type="text" id="counterId" style="display:none;"/>
												<div class="tips" id="number_tips">
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tf_addbtn pt10 mb10">
									<a href="javascript:void(0)" class="singleAdd"></a> 
								</div>
							</div>
							<ul>
								<li class="zt_addmore clearfix">
									<input id="einoShipperMethodNone" value="<s:property value="#request.entity.einoShipperMethod"/>" style="display: none;"/>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel"><b>*</b>上门取货：</label>
										<label class="mr5"><input type="radio" name="entity.einoDoorCanvass" value="Y" <s:if test="#request.entity == null or #request.entity.einoDoorCanvass == null or #request.entity.einoDoorCanvass == \"Y\"">checked="checked"</s:if>/>是</label>
										<label><input type="radio" name="entity.einoDoorCanvass" value="N" <s:if test="#request.entity.einoDoorCanvass == \"N\"">checked="checked"</s:if>/>否</label>
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel"><b>*</b>送货方式：</label> 
										<select id="entity.einoShipperMethod" name="entity.einoShipperMethod">
											<option id="SELF_TAKE" value="SELF_TAKE" <s:if test="#request.entity.einoShipperMethod == \"SELF_TAKE\"">selected="selected"</s:if>>客户自提</option>
											<option id="DOORSTEP" value="DOORSTEP" <s:if test="#request.entity.einoShipperMethod == \"DOORSTEP\"">selected="selected"</s:if>>送货上门</option>
											<option id="UPSTAIR" value="UPSTAIR" <s:if test="#request.entity.einoShipperMethod == \"UPSTAIR\"">selected="selected"</s:if>>送货上楼</option>
											<!-- 新增送货方式，田育林，2016-05-05 -->
											<option id="INSTALL" value="INSTALL" style="display:none;" <s:if test="#request.entity.einoShipperMethod == \"INSTALL\"">selected="selected"</s:if>>安装</option>
										</select>
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel zt_rightlabel"><b>*</b>付款方式：</label>
										<select id="entity.einoPaymentMethod"
											name="entity.einoPaymentMethod"
											style="width: 140px; height: 30px;">
											<option value="ARRIVE_PAYMENT"
												<s:if test="#request.entity.einoPaymentMethod == \"ARRIVE_PAYMENT\"">selected="selected"</s:if>>到付</option>
											<option value="CASH"
												<s:if test="#request.entity.einoPaymentMethod == \"CASH\"">selected="selected"</s:if>>现付</option>
											<option value="Monthly_Statement"
												<s:if test="#request.entity.einoPaymentMethod == \"Monthly_Statement\"">selected="selected"</s:if>>月结</option>
										</select>
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel zt_rightlabel"><b>*</b>签收单：</label>
										<select id="entity.einoSignBack" name="entity.einoSignBack"
											style="width: 140px; height: 22px;">
											<option value="NOBACK"
												<s:if test="#request.entity.einoSignBack == \"NOBACK\"">selected="selected"</s:if>>无需返单</option>
											<option value="CUSTORIGINAL"
												<s:if test="#request.entity.einoSignBack == \"CUSTORIGINAL\"">selected="selected"</s:if>>客户出库单原件返回</option>
											<option value="CUSTCOPY"
												<s:if test="#request.entity.einoSignBack == \"CUSTCOPY\"">selected="selected"</s:if>>客户出库单传真返回</option>
											<option value="SIGNCOPY"
												<s:if test="#request.entity.einoSignBack == \"SIGNCOPY\"">selected="selected"</s:if>>客户签收单传真返回</option>
											<option value="SIGNORIGINAL"
												<s:if test="#request.entity.einoSignBack == \"SIGNORIGINAL\"">selected="selected"</s:if>>客户签收单原件返回</option>
										</select>
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel"><b>*</b>货物名称：</label> <input
											id="entity.einoCargoName" name="entity.einoCargoName"
											type="text" class="input w135"
											value="<s:property value="#request.entity.einoCargoName"/>" />
										<span class="embargo"><a href="contraband.action"
											target="_blank" class="f_f15a22">禁运说明</a></span>
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel"><b>*</b>保价声明：</label> <input
											id="entity.einoInsurance" name="entity.einoInsurance"
											type="text" class="input w135"
											onkeyup="if(isNaN(value))execCommand('undo')"
											onafterpaste="if(isNaN(value))execCommand('undo')"
											class="input w135" maxlength="10"
											<s:if test="#request.entity.einoInsurance != null and #request.entity.einoInsurance != \"\"">value="<s:property value="#request.entity.einoInsurance"/>"</s:if>
											<s:else>value=""</s:else> /> 元
										<div class="question_tips pr">
											<a href="#"><img id="insuraceImg"
												src="${images}/150602_icon11.png"
												style="margin-top: -3px; vertical-align: middle;" alt="问号"/></a>
											<div class="qus-img pa"></div>
											<div class="qus-info pa">
												<p class="f12">声明托运货物的实际价值，若货物出险，即可获相应赔偿，一般货物保价金额按照货物声明保险价值的一定费率收取。</p>
											</div>
										</div>
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel">货物包装：</label> <input
											id="entity.einoPackage" name="entity.einoPackage" type="text"
											class="input w135"
											value="<s:property value="#request.entity.einoPackage"/>" />
									</div>
									<div class="input_float zt_addwidth zt_clearfix">
										<label class="zt_widthlabel"><b>*</b>货物件数：</label> <input
											id="entity.einoNumber" name="entity.einoNumber" type="text"
											maxlength="10"
											onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')"
											class="input w135"
											<s:if test="#request.entity.einoNumber != null and #request.entity.einoNumber != \"\"">value="<s:property value="#request.entity.einoNumber"/>"</s:if>
											<s:else>value=""</s:else> /> 件
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel">货物重量：</label> <input
											id="entity.einoTotalWeight" name="entity.einoTotalWeight"
											type="text" class="input w135"
											onkeyup="if(isNaN(value))execCommand('undo')"
											onafterpaste="if(isNaN(value))execCommand('undo')"
											class="input w135" maxlength="10"
											<s:if test="#request.entity.einoTotalWeight != null and #request.entity.einoTotalWeight != \"\"">value="<s:property value="#request.entity.einoTotalWeight"/>"</s:if>
											<s:else>value=""</s:else> /> 千克
									</div>

									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel">货物体积：</label> <input
											id="entity.einoTotalVolume" name="entity.einoTotalVolume"
											type="text" class="input w135"
											onkeyup="if(isNaN(value))execCommand('undo')"
											onafterpaste="if(isNaN(value))execCommand('undo')"
											class="input w135" maxlength="10"
											<s:if test="#request.entity.einoTotalVolume != null and #request.entity.einoTotalVolume != \"\"">value="<s:property value="#request.entity.einoTotalVolume"/>"</s:if>
											<s:else>value=""</s:else> /> 立方米
									</div>
									<div class="input_float zt_addwidth">
										<label class="zt_widthlabel zt_rightlabel">代收货款：</label> <input
											id="entity.einoCollDeliveryAmount"
											name="entity.einoCollDeliveryAmount" type="text"
											class="input w135"
											onkeyup="if(isNaN(value))execCommand('undo')"
											onafterpaste="if(isNaN(value))execCommand('undo')"
											class="input w135" maxlength="10"
											<s:if test="#request.entity.einoCollDeliveryAmount != null and #request.entity.einoCollDeliveryAmount != \"\"">value="<s:property value="#request.entity.einoCollDeliveryAmount"/>"</s:if>
											<s:else>value=""</s:else> />
									</div>

									<div class="clearfix"></div>
								</li>
								<li class="ts-font-vaglin"><label class="zt_widthlabel">备注：</label>
									<textarea id="entity.einoRemark" name="entity.einoRemark"
										<s:if test="#request.entity.einoRemark != \"\" or #request.entity.einoRemark != null">class="textarea inputFocus"</s:if><s:else>class="textarea inputFocus grays"</s:else>
										 ov="输入内容不得大于80个字符"><s:if test="#request.entity.einoRemark != \"\" or #request.entity.einoRemark != null"><s:property value="#request.entity.einoRemark" /></s:if><s:else>输入内容不得大于80个字符</s:else></textarea>
								</li>
								<li><label class="zt_widthlabel"></label><input
									type="checkbox" class="agreeTk" checked="checked" id="accept" /><a
									href="javascript:void()" onclick="FromShow('share_from')"  class="f_f15a22">
										我已理解并同意遵守服务条款</a></li>
							</ul>
						</div>
						<div class="tips mb10" id="success_tips"
							style="padding-left: 150px;">
							<c:if test="${errorType eq 'success' or errorType eq 'systemError'}">
								${errorMsg}
							</c:if>
						</div>
						<div class="saveM">
							<s:if
								test="fromPage == 'modify' and #request.entity.einoStatus != 'DRAFT'">
								<input type="button" class="tosnmiddle_btn createOrder" value="保存订单"
									onclick="createOrder('${sessionScope.LOGIN_TYPE}');" />
								<input type="button" class="tosnmiddle_btn" value="取消修改"
									onclick="cancelUpdateOrder();" />									
							</s:if>
							<s:else>
								<input type="button" class="tosnmiddle_btn createOrder" value="立刻下单"
									onclick="createOrder('${sessionScope.LOGIN_TYPE}',this)" id="createOrder01" />
								<input type="button" class="tosnmiddle_btn saveDraft" value="存为草稿"
									onclick="saveDraft('${sessionScope.LOGIN_TYPE}',this)"/>
							</s:else>
						</div>
					</div>
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--弹出省省市-->
	<div class="provinceCityAll">
		<div class="tabs clearfix">
			<ul class="">
				<li><a href="javascript:" class="current" tb="hotCityAll">热门城市</a></li>
				<li><a href="javascript:" tb="provinceAll">省份</a></li>
				<li><a href="javascript:" tb="cityAll" id="cityAll">城市</a></li>
				<li><a href="javascript:" tb="countyAll" id="countyAll">区县</a></li>
			</ul>
		</div>
		<div class="con">
			<div class="hotCityAll invis">
				<div class="list">
					<ul>
					</ul>
				</div>
			</div>
			<div class="provinceAll invis">
				<div class="list">
					<ul>
					</ul>
				</div>
			</div>
			<div class="cityAll invis">
				<div class="list">
					<ul>
					</ul>
				</div>
			</div>
			<div class="countyAll invis">
				<div class="list">
					<ul>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../bottom.jsp"%>

	<!-- 发货人选择 -->
	<div class="easyDialog_wrapper" id="easyDialogSel_cons" style="width: 680px;">
		<div class="from_wrapper">
			<div class="from_wrapper_t">
				<a href="javascript:void(0)" title="关闭窗口"
					onclick="easyDialog.close()" class="from_close"></a>发货人选择
			</div>
			<div class="plxd_box p20">
				<div style="height: 280px;">
					<table id="shipper_data" border="0" cellspacing="0" cellpadding="0" width="100%">
					</table>
				</div>
				<div class="scott mt15">
					<a href="#" id="Shipper_PrePage">&lt;上一页</a> <span
						id="shipper_curent_page">0</span> / <span id="shipper_total_page">0</span>
					<a href="#" id="shipper_next_page">下一页&gt;</a> <span
						class="scott_sel"> 到<input name="" id="shipper_go_page_no"
						type="text" />页
					</span> <input type="button" id="shipper_go" class="submit tosnmiddle_btn"
						value="确定" style="width: 60px;" />
				</div>
			</div>
		</div>
	</div>

	<!-- 收货人选择 -->
	<div class="easyDialog_wrapper" id="easyDialogSel_cons02"
		style="width: 680px;">
		<div class="from_wrapper">
			<div class="from_wrapper_t">
				<a href="javascript:void(0)" title="关闭窗口"
					onclick="easyDialog.close()" class="from_close"></a>收货人选择
			</div>
			<div class="plxd_box p20">
				<div class="mb10">
					姓名或电话： <input id="key_word_input" type="text" name="" value=""
						class="input w135 mr5" /> <input id="search_btn" type="button"
						class="submit tosnmiddle_btn" value="确定" style="width: 60px;" />
				</div>
				<div style="height: 280px;">
					<table id="cons_data" border="0" cellspacing="0" cellpadding="0"
						width="100%">
					</table>
				</div>
				<div class="scott mt15">
					<a href="#" id="consignee_PrePage">&lt;上一页</a> <span
						id="consignee_curent_page">0</span> / <span
						id="consignee_total_page">0</span> <a href="#"
						id="consignee_NextPage">下一页&gt;</a> <span class="scott_sel">
						到<input name="" id="consignee_go_page_no" type="text" />页
					</span> <input type="button" id="consignee_go"
						class="submit tosnmiddle_btn" value="确定" style="width: 60px;" />
				</div>
			</div>
		</div>
	</div>
	<div class="easyDialog_wrapper" id="dialog_quick_order">
		<div class="from_wrapper">
			<div class="from_wrapper_t">
				<a href="javascript:void(0)" title="关闭窗口"
					onclick="easyDialog.close()" class="from_close"></a>快速下单
			</div>
			<div class="consignor_tit f16">发货人信息</div>
			<div class="consignor_Mess f12" style="border-bottom:0;">
				<ul>
					<li><label class="zt_widthlabel"><b>*</b>发货人：</label> <input
						type="text" id="einoShipperEbsaContact"
						name="einoShipperEbsaContact" maxlength="50"
						class="input w170" /> <a href="javascript:void(0)"
						class="f_f15a22" id="quick_sel_consigner">选择发货人</a>
						<div class="tips" id="shipperEbsaContact_tips"></div></li>
					<li><label class="zt_widthlabel">手机：</label> <input
						type="text" id="einoShipperEbsaMobile"
						name="einoShipperEbsaMobile" class="input w170"
						maxlength="11"/>
						<label class="zt_widthlabel">固定电话：</label> <input type="text"
						name="einoShipperEbsaTel" id="einoShipperEbsaTel"
						class="input w170"/>
						<div class="tips" id="shipperEbsaMobile_tips"></div></li>
					<li><label class="zt_widthlabel"></label><b
						class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
					</li>
					<li>
						<label class="zt_widthlabel">公司名称：</label> <input
						type="text" id="einoShipperEbspNameCn"
						name="einoShipperEbspNameCn" maxlength="50" value="若需开票，需必填，与开票公司抬头保持一致" class="input inputFocus"
						ov="若需开票，需必填，与开票公司抬头保持一致"
						class="input" style="width:432px;"/>
					</li>
					<li><label class="zt_widthlabel"><b>*</b>发货地址：</label> <label
						class="newprocitySel"> <input
							id="shipperDistrict"
							onchange="synQuickSecondDistrict(this);"
							autocomplete="off" type="text" readonly="readonly"
							maxlength="200"
							class="w170 input send_input proCityQueryAll proCitySelAll inputFocus"
							name="shipperDistrict" ov="请选择所在省市" value="请选择所在省市"/>
					</label> <input id="einoShipperEbsaAddress"
						name="einoShipperEbsaAddress" ov="请输入街道、路名..."
						value="请输入街道、路名..." class="input w205 inputFocus grays"
						class="input" style="width: 253px;" maxlength="200" />
						<div class="tips" id="shipperDistrict_tips"></div>
					</li>
					<li class="chang_sel"><label class="zt_widthlabel">发货网点：</label> <label
						class="newprocitySel"> <input
							id="einoSecondDistrict"
							onchange="loadSecondDistrict('#quickViewSecondCode',this);"
							autocomplete="off" type="text" readonly="readonly"
							class="w170 input send_input proCityQueryAll proCitySelAll inputFocus" 
							name="einoSecondDistrict" ov="请选择所在省市"
							value="请选择所在省市" />
					</label> <select id="quickViewSecondCode"
						name="quickViewSecondCode"
						onchange="changeCompany(this,'#quickCompanyMsg','#einoEscoSecondName');">
							<option value="-1">请选择网点</option>
					</select>
					<input id="einoEscoSecondName"
						name="einoEscoSecondName"
						style="display: none;" />
						<div class="tips" id="secondDistrict_tips"></div></li>
					<li><label class="zt_widthlabel">网点信息：</label> <span
						class="mr15" id="quickCompanyMsg"></span><a href="#" class="f_f15a22" id="quickMapBtn">查看地图</a></li>
					<li style="padding-left: 155px;">
						<div class="tips" id="quick_order_tips"></div>
					</li>
					<li style="padding-left: 155px;">
						<input name="einoLuoji" id="einoLuoji" value="${param.p}" style="display:none;"/>
						<input type="button" class="tosnmiddle_btn createOrder" value="立刻下单"
									onclick="quickCreateOrder('${sessionScope.LOGIN_TYPE}',this)" id="createOrder01" />
						<input type="button" style="margin-left:50px;" class="tosnmiddle_btn createOrder" value="关&nbsp;&nbsp;闭"
									onclick="easyDialog.close()"/>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="easyDialog_wrapper" id="Dialog_tips">
		<div class="from_wrapper">
			<div class="from_wrapper_t">
				<a href="javascript:void(0)" title="关闭窗口"
					onclick="easyDialog.close()" class="from_close"></a>网上下单
			</div>
			<div class="del_consignee tc" style="width: 420px;">
				<div class="aui_icon aui_icon_ok"></div>
				<div class="aui_content" style="padding: 20px;">
					<p>您的订单草稿已保存！</p>
					<p class="f999">
						如需提交草稿，请进入<a href="myOrdersAction!queryMyOrders.action"
							class="f_f15a22">所有订单</a>页面
					</p>
				</div>
			</div>
			<div class="easyDialog_footer">
				<a href="orderAction!index.action" id="shipper_add_btn_confirm"
					class="btn_highlight">继续下单</a> <a
					href="myOrdersAction!queryMyOrders.action" class="btn_highlight"
					onclick="easyDialog.close();">所有订单</a>
			</div>
		</div>
	</div>

	<div class="easyDialog_wrapper" id="Dialog_tips02">
		<div class="from_wrapper">
			<div class="from_wrapper_t">
				<a href="javascript:void(0)" title="关闭窗口"
					onclick="easyDialog.close()" class="from_close"></a>网上下单
			</div>
			<div class="del_consignee tc" style="width: 420px;">
				<div class="aui_icon aui_icon_ok"></div>
				<div class="aui_content" style="padding: 20px;">
					<p>下单成功！</p>
					<p class="f999">
						如需查看订单，请进入<a href="myOrdersAction!queryMyOrders.action"
							class="f_f15a22">所有订单</a>页面
					</p>
				</div>
			</div>
			<div class="easyDialog_footer">
				<a href="orderAction!index.action" id="shipper_add_btn_confirm"
					class="btn_highlight">继续下单</a> <a
					href="myOrdersAction!queryMyOrders.action" class="btn_highlight"
					onclick="easyDialog.close();">所有订单</a>
			</div>
		</div>
	</div>

	<div class="easyDialog_wrapper" id="quick_order_m">
		<div class="from_wrapper">
			<div class="from_wrapper_t">
				<a href="javascript:void(0)" title="关闭窗口"
					onclick="easyDialog.close()" class="from_close"></a>下单模板选择
			</div>
			<div style="width: 700px;" class="pb20">
				<div class="order_search">
					<label class="tr">关键字：</label> <select name="" id="keyWord">
						<option value="consignee">收货人</option>
						<option value="consigner">发货人</option>
					</select> <input id="keyValue" name="" type="text"
						class="input w135 mr40 inputFocus grays" ov="请输入收货人"
						value="请输入收货人" /> <input id="query_order_template" name=""
						type="button" value="查询" class="xz1" />
				</div>
				<div class="consignee_list p10"
					style="min-height: 300px; _height: 300px; overflow: visible;">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tbody id="quick_orders_content">
						</tbody>
					</table>
				</div>
				<div class="scott mt15">
					<a href="#" id="quick_PrePage">&lt;上一页</a> <span
						id="quick_curent_page">0</span> / <span id="quick_total_page">0</span>
					<a href="#" id="quick_NextPage">下一页&gt;</a> <span class="scott_sel">
						到<input name="" id="quick_go_page_no" type="text" />页
					</span> <input type="button" id="quick_go" class="submit tosnmiddle_btn"
						value="确定" style="width: 60px;" />
				</div>
			</div>
		</div>
	</div>
	<div class="easyDialog_wrapper" id="reg_Dialog">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>网上下单
		</div>
		<div class="quick_reg_layer" style="width:710px;">
			<div class="layer_reg_box fl">
				<div class="quick_reg_layer_tit mb15">注册</div>
				<form action="registAction!regist.action" method="post" id="registForm">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tbody>
							<tr>
								<td width="110" align="right"><span class="f_f15a22">*</span>手机号：</td>
								<td>
									<input id="entity.ebccMobile" name="mobile" type="text" ov="请输入11位手机号码" value="请输入11位手机号码" class="input w205 inputFocus grays" />
								</td>
							</tr>
							<tr>
								<td align="right"><label class="tit"><span class="f_f15a22">*</span>密码：</label></td>
								<td>
									<input id="entity.ebccNetPassword" name="entity.ebccNetPassword" type="password" class="input w205 inputFocus grays" />
								</td>
							</tr>
							<tr>
								<td align="right"><label class="tit"><span class="f_f15a22">*</span>确认密码：</label></td>
								<td><input id="password2" name="password2" type="password" class="input w205 inputFocus grays" /></td>
							</tr>
							<tr>
								<td align="right"><label class="tit">用户名：</label></td>
								<td>
									<input id="entity.ebccNetLogin" name="loginName" type="text" ov="可作为登陆账号" value="可作为登陆账号" class="input w205 inputFocus grays" />
								</td>
							</tr>
							<tr>
								<td align="right"><label class="tit">邮箱地址：</label></td>
								<td>
									<input id="entity.ebccEmail" name="email" type="text" class="input w205 inputFocus grays" ov="可作为登陆账号和密码找回凭证" value="可作为登陆账号和密码找回凭证" />
								</td>
							</tr>
							<tr>
								<td align="right"><label class="tit"><span class="f_f15a22">*</span>验证码：</label></td>
								<td>
									<input id="validateCode_regist" name="" type="text"	class="input w95 inputFocus grays" value="请输入验证码" ov="请输入验证码" />
									<span>
										<img id="validateCode_img"
										src="genCheckCode.action?codeName=USER_REGIST_VERCODE" width="60" height="28"
										style="vertical-align: middle;" onclick="changeCode()" /> <a
										href="javascript:changeCode();">换一组</a>
									</span>
								</td>
							</tr>
							<tr>
								<td align="right"><label class="tit"><span class="f_f15a22">*</span>短信验证码：</label></td>
								<td>
									<input id="registVerCode" name="registVerCode" type="text" class="input w95 inputFocus grays" value="请输入验证码" ov="请输入验证码" />
									<input type="button" id="getPhoneVerCodeBtn" disabled="disabled" class="btn_sub xz1" style="padding:0 10px;" value="获取验证码" onclick="sendPhoneVerCode()"/>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><input id="accept" name="accept" type="checkbox" checked="checked" />已阅读<a href="javascript:void(0);" class="f_f15a22" onclick="FromShow('share_from')" >华宇网上营业厅服务协议</a></td>							
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
									<div class="tips" id="regist_tips"></div>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><a href="javascript:regist();" class="xz1">立即注册</a></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="layer_login_box fl">
				<div class="quick_reg_layer_tit mb60">登录</div>
				<form action="loginAction!login.action" method="post" id="loginForm">
					<table border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td width="110" align="right">登录名：</td>
								<td>
									<input id="loginName" name="loginName" type="text" class="input w205 inputFocus grays" value="手机号/邮箱/登陆账号" ov="手机号/邮箱/登陆账号" />
								</td>
							</tr>
							<tr>
								<td align="right">登录密码：</td>
								<td><input id="password" name="password" type="password" class="input w205 inputFocus" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
									<div class="tips" id="login_tips"></div>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><a href="javascript:login();" class="xz1 mr10">登录</a></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
									<a href="forgot.action" class="f_f15a22 fr" target="_blank">忘记密码</a>
								</td>
							</tr>
							
						</tbody>
					</table>
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
		
	</div>
</div>


<div id="share_from01" class="share_from" style="display:none">		
	<div class="from_wrapper_t">
		<a href="javascript:void(0)" title="关闭窗口" onclick="FromShow('share_from01')" class="from_close"></a>发货人选择
	</div>
	<div>
		<div class="plxd_box p20">
			<div style="height: 280px;">
				<table id="quick_shipper_data" border="0" cellspacing="0" cellpadding="0" width="100%">
				</table>
			</div>
			<div class="scott mt15">
				<a href="#" id="quick_shipper_prepage">&lt;上一页</a> <span
					id="quick_shipper_curent_page">0</span> / <span id="quick_shipper_total_page">0</span>
				<a href="#" id="quick_shipper_next_page">下一页&gt;</a> <span
					class="scott_sel"> 到<input name="" id="quick_shipper_go_page_no"
					type="text" />页
				</span> <input type="button" id="quick_shipper_go" class="submit tosnmiddle_btn"
					value="确定" style="width: 60px;" />
			</div>
		</div>
	</div>
</div>

<div id="share_from" class="share_from" style="display:none">		
	<div class="from_wrapper_t">
		<a href="javascript:void(0)" title="关闭窗口" onclick="FromShow('share_from')" class="from_close"></a>用户协议
	</div>
	<div class="useragree_layer f12">
			<p><strong>本公司服务条款的确认和接纳</strong></p>
<p>1、托运人应准确填写本单，如实告知承运人所托运货物的名称、性质、重量、数量、价值等必要情况；托运人应对所托货物按照行业标准妥善包装，使其适合运输。</p>
<p>2、对于国家规定限制运输的物品，托运人应在交货前完成或委托承运人完成有关法律、行政法规规定的手续，并附有效凭证。</p>
<p>3、托运人不得托运或在所托运货物中夹带国家禁止运输的物品；因违背此约定造成承运人的一切损失托运人须双倍赔偿。</p>
<p>4、对已接受委托，后发现属于承运人不能安全、合法运送的物品（包括但不限于危险品、违禁品），承运人保留拒绝运送的权利，并由托运人承担违约责任。</p>
<p>5、委托承运人货物重量计量单位为千克，不足1千克按照1千克计算。若体积重量大于实际重量，按体积重量计算。</p>
<p>6、货运价格一般按照承运人的公布价。依该价格计算得出的费用不包含接送货费、税金、政府规费以及由于托运人或收货人的原因而增加的其他费用。</p>
<p>7、收货人在收到提货通知后最迟应在三日内提货；收货人在此期限内未提货的应支付超出天数的仓储费和保管费。到货后三个月无人提货且承运人无法退回货物的，承运人对该货有权处置，在处置所得中优先扣除相关费用。</p>
<p>8、托运人或收货人不得无故拒付任何服务费用；收货人拒绝支付费用的，托运人承担支付与托运物品有关费用的连带责任。托运人或收货人无故不支付费用的，承运人可以对承运货物行使处置权、留置权及其他补救性权利，由此而产生的后果由托运人或收货人承担。</p>
<p>9、承运人从货物收运时起到交付时止承担安全运输责任，在此期间若发生货物损坏、短缺、灭失、污染，承运人负赔偿责任。</p>
<p>10、承运人建议托运人办理货物保价运输，声明保价并支付相应保价费。托运人声明保价并支付保价费，发生货物丢损，承运人按如下规则赔偿：货物全部灭失，按货物保价声明价值赔偿；货物部分毁损或灭失，按声明价值和损失比例赔偿，最高不超过声明价值。声明价值高于实际价值的，按实际价值赔偿。</p>
<p>11、未办理保价而发生货物丢损，承运人对空运货物依照实际损失最高按20元（人民币）/千克赔偿，对汽运货物按照实际损失在丢损货物所对应运费的3倍以内赔偿。按以上方式计算得出的赔偿额超过货物实际价值的部分无效。</p>
<p>12、托运人委托承运人代收货款不代表该次货物的实际价值；如果运输货物在运输途中出现损坏或灭失赔偿额按照本条款第10、11条约定赔偿与代收货款无关。收货人签名后因货物品名、性质、型号等原因而不支付代收货款，承运人不承担代收货款无法收回的责任。</p>
<p>13、以下物品不予托运：发票、有价证券、国家禁运的刊物、首饰、护照、私人证件、单证、合同、现金、私人信函、毒品、珠宝、玉器、古玩、字画、邮票、艺术品、稀有金属、液体物品、产地来源不正确的物品、有腐蚀性或放射性、易燃易爆品、白色粉末及一切有关法律禁止及难以客观确定价值的货物。</p>
<p>14、货运时效一般按照承运人的公布时效。时效不影响其他费用的结算和不可抗力免责权。</p>
<p>15、承运人对如下损失不承担责任：</p>
<p>A、因不可抗力（包括但不限于自然灾害、政府行为、战争等社会异常事件）造成货物损坏、短缺、灭失、污染、变质或迟延交付；</p>
<p>B、因货物本身的自然性质、质量瑕疵或缺陷、合理损耗等造成的损失；</p>
<p>C、托运人自行包装或容器不良，但从外部无法发现；</p>
<p>D、托运人自行包装，到达时外包装完好而内件缺少或损坏；</p>
<p>E、承运人包装的非新品运输，外包装完好而内件缺少或损坏；</p>
<p>F、由于托运人故意或过失导致损失；</p>
<p>G、承运过程中发生的一切间接损失（包括但不限于对所托运货物的收益、利润、实际用途、特殊商业价值）。</p>
<p>16、凡因本单或与本单有关的争议，当事人可以通过协商或调解解决，协商或调解不成，任何一方均应向承运人总部所在地人民法院提起诉讼。</p>
<p>17、本单于托运人和承运人双方签章之时起生效。</p>		
	</div>
</div> 
<div id="fade" class="black_overlay"></div>
	<script>
		function FromShow(i){
			if(document.getElementById(i).style.display=='none')
			{			
				document.getElementById(i).style.display = 'block';
				document.getElementById('fade').style.display = 'block';
			}
			else
			{
				document.getElementById(i).style.display = 'none';
				document.getElementById('fade').style.display = 'none';
			}
		}
		
		$(function() {
			$("#user_agreement").click(function() {
				easyDialog.open({
					container : 'signupagreement',
					fixed : true
				});
			});
		});
	</script>
</body>
</html>
