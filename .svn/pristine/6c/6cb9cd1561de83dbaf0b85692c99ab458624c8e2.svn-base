<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>批量下单</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/order/batchOrder.js"></script>
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
.select_ui{width: 256px;}
</style>
</head>
<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/order_banner.jpg" width="770" /></div>
			<div class="news_detail pb20 pr">
				<h1 class="news_title">批量下单</h1>
				<c:if test="${sessionScope.USER_INFO == null}">
					<div class="pa f333" style="line-height:25px;top: -35px;">
					&gt;&gt; 15秒即可完成注册，尽享更多优惠和便捷。 <a href="regist.action" class="f_f15a22">立即注册</a>     |     已有帐号？  <a href="login.action" class="f_f15a22">现在登录</a>
					</div>
				</c:if>
				<div class="consignor_tit f16">发货人信息</div>
				<div class="consignor_Mess f12" style="border:0;">
					<form action="batchOrderAction!next.action" method="post" id="orderForm">
						<ul>
							<li>
								<label class="zt_widthlabel"><b>*</b>发货人：</label>
								<input type="text" id="entity.einoShipperEbsaContact" name="entity.einoShipperEbsaContact" maxlength="50"
									<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaContact != null and #session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaContact != \"\"">value='<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaContact"/>'</s:if> class="input w170" />
									<a href="javascript:void(0)" class="f_f15a22" id="sel_consigner">选择发货人</a>
								<div class="tips" id="shipperEbsaContact_tips">
								</div>
							</li>
							<li>
						   		<label class="zt_widthlabel">手机：</label>
								<input type="text" id="entity.einoShipperEbsaMobile" name="entity.einoShipperEbsaMobile" class="input w170" maxlength="11"
									<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaMobile != null and #session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaMobile != \"\"">value='<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaMobile"/>'</s:if>/>
								<label class="zt_widthlabel">固定电话：</label>
								<input type="text" name="entity.einoShipperEbsaTel" id="entity.einoShipperEbsaTel" class="input w170"
									<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaTel != null and #session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaTel != \"\"">value='<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaTel"/>'</s:if>/>
								<div class="tips" id="shipperEbsaMobile_tips">
								</div>
							</li>
							<li>
								<label class="zt_widthlabel"></label><b class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
							</li>
							<li>
								<label class="zt_widthlabel">公司名称：</label> <input
								type="text" id="entity.einoShipperEbspNameCn"
								name="entity.einoShipperEbspNameCn" maxlength="50"
								<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbspNameCn != null and #session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbspNameCn != \"\"">value='<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbspNameCn"/>' class="input"</s:if>
								<s:else>value="若需开票，需必填，与开票公司抬头保持一致" class="input inputFocus"</s:else>
								ov="若需开票，需必填，与开票公司抬头保持一致"
								style="width:432px;"/>
							</li>
							<li>
								<label class="zt_widthlabel"><b>*</b>发货地址：</label>
								<label class="newprocitySel">
									<input id="entity.shipperDistrict" onchange="synSecondDistrict(this);" autocomplete="off" type="text" readonly="readonly"  maxlength="200"
										<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict == null or #session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict == \"\"">class="w170 input grays send_input proCityQueryAll proCitySelAll inputFocus" </s:if>
										<s:else>class="w170 input send_input proCityQueryAll proCitySelAll inputFocus" </s:else> 
										name="entity.shipperDistrict" ov="请选择所在省市" <s:if test="#session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict != null and #session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict != \"\""> value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.shipperDistrict"/>" </s:if>
										<s:else> value="请选择所在省市"</s:else> />
								</label>
								<input id="entity.einoShipperEbsaAddress" 
								name="entity.einoShipperEbsaAddress" 
								ov="请输入街道、路名..."
								<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaAddress != null and #session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaAddress != \"\""> 
									value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoShipperEbsaAddress"/>" class="input w205 inputFocus" 
								</s:if>
								<s:else> 
									value="请输入街道、路名..." class="input w205 inputFocus grays"
								</s:else>
								class="input" style="width:253px;" maxlength="200"/>
								<div class="tips" id="shipperDistrict_tips">
								</div>
								<!-- <input type="button" value="匹配网点" class="tosnmiddle_btn " /> -->
							</li>
							<li>
								<label class="zt_widthlabel">发货网点：</label>
								<label class="newprocitySel"> 
									<input id="entity.einoSecondDistrict" onchange="loadSecondDistrict(this);" autocomplete="off" readonly="readonly" type="text" 
										<s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoSecondDistrict == null or #session.BATCH_SHIPPER_ORDER_INFO.einoSecondDistrict == \"\"">class="w170 input grays send_input proCityQueryAll proCitySelAll inputFocus" </s:if>
										<s:else>class="w170 input send_input proCityQueryAll proCitySelAll inputFocus" </s:else> 
										name="entity.einoSecondDistrict" ov="请选择所在省市" <s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoSecondDistrict != null and #session.BATCH_SHIPPER_ORDER_INFO.einoSecondDistrict != \"\""> value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoSecondDistrict"/>" </s:if><s:else>value="请选择所在省市"</s:else> />
								</label>
								<select id="entity.einoEscoSecondCode" name="entity.einoEscoSecondCode" onchange="changeCompany(this);">
									<option value="-1">请选择网点</option>
								</select>
								<input id="einoEscoSecondCode" name="einoEscoSecondCode" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoEscoSecondCode"/>" style="display: none;" />
								<input id="entity.einoEscoSecondName" name="entity.einoEscoSecondName" value="<s:property value="#session.BATCH_SHIPPER_ORDER_INFO.einoEscoSecondName"/>" style="display:none;"/>
								<div class="tips" id="secondDistrict_tips">
								</div>
							</li>
							<li>
								<label class="zt_widthlabel"><b>*</b>上门取货：</label>
								<label class="mr5"><input type="radio" name="entity.einoDoorCanvass" value="Y" <s:if test="#session.BATCH_SHIPPER_ORDER_INFO == null or #session.BATCH_SHIPPER_ORDER_INFO.einoDoorCanvass == null or #session.BATCH_SHIPPER_ORDER_INFO.einoDoorCanvass == \"Y\"">checked="checked"</s:if>/>是</label>
								<label><input type="radio" name="entity.einoDoorCanvass" value="N" <s:if test="#session.BATCH_SHIPPER_ORDER_INFO.einoDoorCanvass == \"N\"">checked="checked"</s:if>/>否</label>
							</li>
							<li>
								<label class="zt_widthlabel">网点信息：</label>
								<span class="mr15" id="companyMsg"></span><a href="#" class="f_f15a22" id="mapBtn">查看地图</a>
							</li>
						</ul>
					</form>
				</div>
				<div class="tips mb10" id="success_tips" style="padding-left:150px;">
					<c:if test="${errorType eq 'success' or errorType eq 'systemError'}">
						${errorMsg}
					</c:if>
				</div>
				<div class="saveM">             		 
               		 <input type="button" class="tosnmiddle_btn" value="下一步" onclick="next();"/>
              	</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>

<!-- 发货人选择 -->
<div class="easyDialog_wrapper" id="easyDialogSel_cons" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>发货人选择
		</div>
    	<div class="plxd_box p20">
			<div style="height:280px;">
				<table id="shipper_data" border="0" cellspacing="0" cellpadding="0" width="100%">
				</table>
			</div>
			<div class="scott mt15">
				<a href="#" id="Shipper_PrePage">&lt;上一页</a>
				<span id="shipper_curent_page">0</span>
				/
				<span id="shipper_total_page">0</span>
				<a href="#" id="shipper_next_page">下一页&gt;</a>
				<span class="scott_sel">
					到<input name="" id="shipper_go_page_no" type="text"/>页
				</span>
				<input type="button" id="shipper_go" class="submit tosnmiddle_btn" value="确定" style="width:60px;"/>
			</div>
		</div>
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
<script>
$(function(){	
	$("#sel_consigner").click(function(){
		easyDialog.open({
			container : 'easyDialogSel_cons',
			fixed : true
		});
	});
	$("#sel_consignee").click(function(){
		easyDialog.open({
			container : 'easyDialogSel_cons02',
			fixed : true
		});
	});
	
})
</script>
</body>
</html>
