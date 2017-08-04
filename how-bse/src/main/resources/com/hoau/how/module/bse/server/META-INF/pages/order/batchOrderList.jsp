<%@page language="java" import="java.net.URLDecoder" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>批量下单</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/order/batchOrderList.js"></script>
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
</head>
<body onload="showDialog('${param.errorType}');">
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/order_banner.jpg" width="770" /></div>
			<div class="news_detail pb20">
				<h1 class="news_title">批量下单</h1>
				<div class="consignor_Mess">
					<div class="pl35 ">
						<p>可根据您的需要选择下载批量下单模板   （请使用最新模板）</p>
						<a href="https://www.hoau.net:9080/download/%cc%ec%b5%d8%bb%aa%d3%ee%c5%fa%c1%bf%cf%c2%b5%a5%c4%a3%b0%e5.xls" target="_blank" class="f_f15a22">批量下单模板.xls</a>
						| <a href="https://www.hoau.net:9080/download/%cc%ec%c3%a8%c5%fa%c1%bf%cf%c2%b5%a5%c4%a3%b0%e5.xls" target="_blank" class="f_f15a22">天猫批量下单模板.xls</a>
						| <a href="https://www.hoau.net:9080/download/%cb%b3%b7%e1%c5%fa%c1%bf%cf%c2%b5%a5%c4%a3%b0%e5.xls" target="_blank" class="f_f15a22">顺丰批量下单模板.xls</a>
						<input id="entity.einoId" name="entity.einoId" value="<s:property value="#request.entity.einoId"/>" style="display:none;"/>
					</div>
				</div>
				<div class="consignor_tit f16">发货人信息</div>
				<div class="consignor_Mess f12">
					<ul>
						<li>
							<label class="zt_widthlabel">发货人：</label>
							<span>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaContact"/>
							</span>
						</li>
						<li>
					   		<label class="zt_widthlabel">手机：</label>
							<span>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaMobile"/>
							</span>
							<label class="zt_widthlabel">固定电话：</label>
							<span>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaTel"/>
							</span>
						</li>
						<li>
							<label class="zt_widthlabel">公司名称：</label>
							<span>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbspNameCn"/>
							</span>							
						</li>					
						<li>
							<label class="zt_widthlabel">发货地址：</label>
							<span>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict"/>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaAddress"/>
							</span>							
						</li>
						<li>
							<label class="zt_widthlabel">发货网点：</label>
							<span>
								<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoEscoSecondName"/>
							</span>
						</li>
					</ul>
				</div>
				
				<div class="consignor_tit f16 mb10">收货人信息</div>
				<div class="plxd_box pb20">
					<div class="pl35 mb10">
						<span class="fr">
							<input type="button" class="xz1 mr10" id="demoBtn1" style="padding:0 10px;" value="逐个新增"/>
							<input type="button" class="xz1" id="btn_pldr" style="padding:0 10px;" value="批量导入"/>
						</span>
						最多可导入100条数据，请尽量使用最新模板，如果<span style="color:red">标红</span>请点击修改，或者修改模板后重新导入，天猫订单模板名称请保持为<span style="color:red">天猫批量下单模板.xls</span>，请勿修改！
						<div class="plxd_box_Import fl hide" id="progress">
							<span style="vertical-align: middle;">导入中：</span>
							<div class="progress" style="width:200px;display:inline-block;vertical-align: middle;">
								<div class="progress-bar progress-bar-success"  
									role="progressbar" 
									aria-valuenow="0" 
									aria-valuemin="0" 
									aria-valuemax="100" 
									style="width:0%">0%</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="7%">序号</td>
							<td width="11%">收货人姓名</td>
							<td width="14%">联系方式</td>
							<td width="30%">地址</td>
							<td width="10%">付款方式</td>
							<td width="13%">货物名称</td>
							<td width="15%">操作</td>
						</tr>
						<s:iterator id="item" value="#request.paging.data">
							<tr <s:if test="#item.validate == \"ERROR\"">class="red"</s:if>>
								<td><s:property value="#item.number"/></td>
								<td><s:property value="#item.einoConsigneeEbsaContact"/></td>
								<td>
									<s:if test="#item.einoConsigneeEbsaMobile != null and #item.einoConsigneeEbsaMobile != \"\"">
										<s:property value="#item.einoConsigneeEbsaMobile"/>
									</s:if>
									<s:else>
										<s:property value="#item.einoConsigneeEbsaTel"/>
									</s:else>
								</td>
								<td><s:property value="#item.einoConsigneeEbsaAddress"/></td>
								<td>
									<s:if test="#item.einoPaymentMethod == \"ARRIVE_PAYMENT\"">
										到付
									</s:if>
									<s:elseif test="#item.einoPaymentMethod == \"CASH\"">
										现付
									</s:elseif>
									<s:elseif test="#item.einoPaymentMethod == \"Monthly_Statement\"">
										月结
									</s:elseif>
									<s:else>
										<s:property value="#item.einoPaymentMethod"/>
									</s:else>
								</td>
								<td><s:property value="#item.einoCargoName"/></td>
								<td>
									<a href="javascript:void(0);" onclick="showDetail('<s:property value="#item.einoId"/>');">详情</a>
									<a href="javascript:void(0);" onclick="findOrderById('<s:property value="#item.einoId"/>');">修改</a>
									<a href="javascript:void(0);" onclick="removeOrder('<s:property value="#item.einoId"/>');">删除</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="scott mt15">
						<!--<span class="pageBox-info">共<s:property value="paging.rowsCount"/>条 <s:property value="paging.pageSize"/>条/页</span>-->
						<w:pager pageSize="${paging.pageSize}" pageNo="${paging.pageNo}" url="batchOrderAction!pagingQuery.action" recordCount="${paging.rowsCount}" />
					</div>
				</div>
				
				<div class="saveM">
					<div><label><input id="accept" type="checkbox" checked="checked"/><a href="javascript:void(0);" id="user_agreement" class="f_f15a22">我已理解并同意遵守服务条款</a></label></div>
					<div class="tips mb10" id="success_tips">
						<%
							String msg = "";
							try{
								Object obj = request.getAttribute("errorMsg");
								if(obj != null){
									String errorMsg = obj.toString();
									msg = URLDecoder.decode(errorMsg);
								}
							}catch(Exception ex){
								ex.printStackTrace();
							}
						%>
						<%= msg %>
					</div>
					<div>
						<input type="button" class="tosnmiddle_btn" value="立刻下单" onclick="createOrder('${sessionScope.LOGIN_TYPE}',this)"/>
               		 	<input type="button" class="tosnmiddle_btn" value="返回" onclick="returnPage();"/>
					</div>
              	</div>
			</div>
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
<%@include file="../bottom.jsp" %>
<div class="easyDialog_wrapper Plxd_layer" id="easyDialogPlxd" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t" id="operation_order_div">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>新增
		</div>
    	<div class="consigner_layer">
			<div class="consignor_Mess f12" style="border:0; padding:0;">
				<form action="batchOrderAction!singleOrder.action" method="post" id="singleForm">
					<ul>
						<li>
							<input style="display:none;" id="entity.einoId" name="entity.einoId" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoId"/>"/>
							<input style="display:none;" id="entity.shipperDistrict" name="entity.shipperDistrict" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict"/>"/>
							<input style="display:none;" id="entity.einoShipperEbsaContact" name="entity.einoShipperEbsaContact" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaContact"/>"/>
							<input style="display:none;" id="entity.einoShipperEbsaMobile" name="entity.einoShipperEbsaMobile" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaMobile"/>"/>
							<input style="display:none;" id="entity.einoShipperEbsaTel" name="entity.einoShipperEbsaTel" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaTel"/>"/>
							<input style="display:none;" id="entity.einoShipperEbsaAddress" name="entity.einoShipperEbsaAddress" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaAddress"/>"/>
							<input style="display:none;" id="entity.einoEscoSecondName" name="entity.einoEscoSecondName" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoEscoSecondName"/>"/>
							<input style="display:none;" id="entity.einoEscoSecondCode" name="entity.einoEscoSecondCode" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoEscoSecondCode"/>"/>
							<input style="display:none;" id="entity.validate" name="entity.validate" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.validate"/>"/>
							<label class="zt_widthlabel"><b>*</b>收货人：</label>
							<input type="text" id="entity.einoConsigneeEbsaContact" name="entity.einoConsigneeEbsaContact" class="input" style="width:266px;" maxlength="50"/>
							<a href="javascript:void(0)" class="f_f15a22" onclick="openOrCloseDialog();showConsigneeGrid(1,'');">选择收货人</a>
						</li>
						<li>
							<label class="zt_widthlabel">手机：</label>
							<input type="text" id="entity.einoConsigneeEbsaMobile" name="entity.einoConsigneeEbsaMobile" class="input w135" maxlength="11"/>
							<label class="zt_widthlabel">固定电话：</label>
							<input type="text" id="entity.einoConsigneeEbsaTel" name="entity.einoConsigneeEbsaTel" class="input w135" />
						</li>
						<li>
							<label class="zt_widthlabel"></label>
							<b class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
						</li>
						<li>
							<label class="zt_widthlabel"><b>*</b>收货地址：</label>
							<label class="newprocitySel">
								<input id="entity.consigneeDistrict" onchange="loadPriceTime();" readonly="readonly" autocomplete="off" type="text"  maxlength="200"
									class="w135 input grays send_input proCityQueryAll proCitySelAll inputFocus" 
									name="entity.consigneeDistrict" ov="请选择所在省市" value="请选择所在省市"
									/>
							</label>
							<input id="entity.einoConsigneeEbsaAddress" name="entity.einoConsigneeEbsaAddress" type="text" class="input" style="width:240px;" />
						</li>
						<li class="zt_addmore clearfix">
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel"><b>*</b>上门取货：</label>
								<label class="mr5"><input type="radio" name="entity.einoDoorCanvass" value="Y" checked="checked"/>是</label>
								<label><input type="radio" name="entity.einoDoorCanvass" value="N"/>否</label>
							</div>
							<div class="input_float zt_addwidth">
								<!-- 田育林，2016-4-28修改，新增三种运输方式 -->
								<label class="zt_widthlabel"><b>*</b>运输方式：</label>
								<select name="entity.einoProductTypeName" onchange="changeShipperMethod(this.value)" style="width:140px;height:22px;">
									<option id="rdo_ld" value="经济快运" selected="selected">经济快运</option>
									<option id="rdo_drd" value="定日达" disabled="disabled">定日达</option>
									<option id="rdo_rh" value="易入户" disabled="disabled">易入户</option>
									<option id="rdo_az" value="易安装" disabled="disabled">易安装</option>
									<option id="rdo_bg" value="易包裹" disabled="disabled">易包裹</option>
								</select>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel zt_rightlabel"><b>*</b>付款方式：</label>
								<select id="entity.einoPaymentMethod" name="entity.einoPaymentMethod">
									<option value="ARRIVE_PAYMENT">到付</option>
									<option value="CASH">现付</option>
									<option value="Monthly_Statement">月结</option>
								</select>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel"><b>*</b>送货方式：</label> <select
									id="entity.einoShipperMethod" name="entity.einoShipperMethod">
									<option value="SELF_TAKE">客户自提</option>
									<option value="DOORSTEP">送货上门</option>
									<option value="UPSTAIR">送货上楼</option>
									<!-- 新增“安装”送货方式，田育林 -->
									<option value="INSTALL" style="display:none;">安装</option>
								</select>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel"><b>*</b>货物名称：</label>
								<input id="entity.einoCargoName" name="entity.einoCargoName" type="text" class="input w135"/>
								<span class="embargo"><a href="contraband.action" class="f_f15a22" target="_blank">禁运说明</a></span>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel zt_rightlabel"><b>*</b>签收单：</label>
								<select id="entity.einoSignBack" name="entity.einoSignBack" style="width:140px;height:22px;">
									<option value="NOBACK">无需返单</option>
									<option value="CUSTORIGINAL">客户出库单原件返回</option>
									<option value="CUSTCOPY">客户出库单传真返回</option>
									<option value="SIGNCOPY">客户签收单传真返回</option>
									<option value="SIGNORIGINAL">客户签收单原件返回</option>
								</select>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel">货物包装：</label>
								<input id="entity.einoPackage" name="entity.einoPackage" type="text" class="input w135"/>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel"><b>*</b>保价声明：</label>
								<input id="entity.einoInsurance" name="entity.einoInsurance" type="text" class="input w135"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')" class="input w135" maxlength="10"
									value=""/>元
								<div class="question_tips pr">
									<a href="#"><img id="insuraceImg" src="${images}/150602_icon11.png" style="margin-top: -3px;vertical-align: middle;" /></a>
									<div class="qus-img pa"></div>
									<div class="qus-info pa" style="left: -120px;">
										<p class="f12">声明托运货物的实际价值，若货物出险，即可获相应赔偿，一般货物保价金额按照货物声明保险价值的一定费率收取。</p>
									</div>
								</div>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel">货物重量：</label>
								<input id="entity.einoTotalWeight" name="entity.einoTotalWeight" onblur="loadPriceTime();" type="text" class="input w135"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')" class="input w135" maxlength="10"
									value=""
								/> 千克
							</div>
							<div class="input_float zt_addwidth zt_clearfix">
								<label class="zt_widthlabel"><b>*</b>货物件数：</label>
								<input id="entity.einoNumber" name="entity.einoNumber" type="text" maxlength="10"
									onkeyup="this.value=this.value.replace(/\D/g,'')" 
									onafterpaste="this.value=this.value.replace(/\D/g,'')" class="input w135"
									value=""
								/> 件
							</div>						
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel zt_rightlabel">代收货款：</label>
								<input id="entity.einoCollDeliveryAmount" name="entity.einoCollDeliveryAmount" type="text" class="input w135"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')" class="input w135" maxlength="10"
									value=""
								/>
							</div>
							<div class="input_float zt_addwidth">
								<label class="zt_widthlabel">货物体积：</label>
								<input id="entity.einoTotalVolume" name="entity.einoTotalVolume" onblur="loadPriceTime();" type="text" class="input w135"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')" class="input w135" maxlength="10"
									value=""
								/> 立方米
							</div>
							<div class="clearfix"></div>
						</li>
						<li class="ts-font-vaglin">
							<label class="zt_widthlabel">备注：</label>
							<textarea id="entity.einoRemark" name="entity.einoRemark" class="textarea inputFocus grays" style="height:44px;" ov="输入内容不得大于80个字符">输入内容不得大于80个字符</textarea>
							<input id="form_reset_btn" type="reset" style="display:none;"/>
						</li>
					</ul>
				</form>
				<div class="tips mt5" style="display:block;padding-left:130px;" id="single_success_tips">
				</div>
			</div>			
		</div>
		<div class="easyDialog_footer">
			<a href="javascript:void(0);" class="btn_highlight" onclick="singleOrder();" id="submit_btn">新增</a>
			<a href="javascript:void(0);" class="btn_highlight" onclick="easyDialog.close();">取消</a>
		</div>
	</div>
</div>
<div class="easyDialog_wrapper" id="easyDialogPlxd_de" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>收货人信息
		</div>
    	<div class="consignee_info pl35 pt20 pb20">
			<p>
				<span class="w205">收货人：<span id="detail_consigneeEbsaContact"></span></span>
				<span class="w205">固话：<span id="detail_consigneeEbsaTel"></span></span>
				<span class="w205">手机号：<span id="detail_consigneeEbsaMobile"></span></span>
			</p>
			<p>收货人地址：<span id="detail_consigneeEbsaAddress"></span></p>
			<p>
				<span class="w205">是否上门取货：<span id="detail_doorCanvass"></span></span>
				<span class="w205">送货方式：<span id="detail_shipperMethod"></span></span>
				<span class="w205">付款方式：<span id="detail_paymentMethod"></span></span>
			</p>
			<p>
				<span class="w205">货物名称：<span id="detail_cargoName"></span></span>
				<span class="w205">货物件数：<span id="detail_number"></span>件</span>
				<span class="w205">保价声明：<span id="detail_insurance"></span>元</span>
			</p>
			<p>
				<span class="w205">货物重量：<span id="detail_totalWeight"></span>公斤</span>
				<span class="w205">货物体积：<span id="detail_totalVolume"></span>立方米</span>
				<span class="w205">货物包装：<span id="detail_package"></span></span>
			</p>
			<p>
				<span class="w205">代收货款：<span id="detail_collDeliveryAmount"></span></span>
				<span class="w205">签收单：<span id="detail_signBack"></span></span>
			</p>
			<p>备注：<span id="detail_remark"></span></p>
		</div>
	</div>
</div>
<div class="easyDialog_wrapper" id="pldr_layer" style="width:480px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>批量导入
		</div>
    	<div style="padding:60px 0 100px 100px;">
    		<form action="batchOrderAction!batchUploadOrder.action" method="post" enctype="multipart/form-data" name="uploadForm">
				<div class="file_box mb30">
						<input type="text" id="textfield01" class="file_txt" readonly="readonly" />
						<input type="button" class="file_btn" value="浏览..." />
						<input type="file" style="width:260px; left:0; right:0;" name="uploadFile" class="file_input" id="fileField" size="28" onchange="document.getElementById('textfield01').value=this.value" /> 
				</div>
				<div style="padding-left: 60px;">
					<input type="submit" class="tosnmiddle_btn" value="提交"/>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="easyDialog_wrapper" id="Dialog_tips02">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>批量下单
		</div>
    	<div class="del_consignee tc" style="width:420px;">
			<div class="aui_icon aui_icon_ok"></div>
			<div class="aui_content" style="padding: 20px;">
				<p>下单成功！</p>
				<p class="f999">如需查看订单，请进入<a href="myOrdersAction!queryMyOrders.action" class="f_f15a22">所有订单</a>页面</p>
			</div>
		</div>
		<div class="easyDialog_footer">
			<a href="batchOrderAction!index.action" id="shipper_add_btn_confirm" class="btn_highlight">继续下单</a> 
			<a href="myOrdersAction!queryMyOrders.action" class="btn_highlight">所有订单</a>
		</div>
	</div>
</div>

<!-- 收货人选择 -->

<div class="share_from" id="easyDialogSel_cons02" style="display:none;width: 680px;">	
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" class="from_close" onclick="openOrCloseDialog();"></a>收货人选择
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

<div class="easyDialog_wrapper" id="signupagreement" style="width:650px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>用户协议
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
			<p>D、托运人自行包装，到达时外包装完好而内件缺少或损坏；
			<p>E、承运人包装的非新品运输，外包装完好而内件缺少或损坏；</p>
			<p>F、由于托运人故意或过失导致损失；</p>
			<p>G、承运过程中发生的一切间接损失（包括但不限于对所托运货物的收益、利润、实际用途、特殊商业价值）。</p>
			<p>16、凡因本单或与本单有关的争议，当事人可以通过协商或调解解决，协商或调解不成，任何一方均应向承运人总部所在地人民法院提起诉讼。</p>
			<p>17、本单于托运人和承运人双方签章之时起生效。</p>		
		</div>
	</div>
</div>
<div id="fade" class="black_overlay"></div>
<script>
$(function(){	
	$("#user_agreement").click(function(){
		easyDialog.open({
			container : 'signupagreement',
			fixed : true
		});
	});
});
</script>
</body>
</html>
