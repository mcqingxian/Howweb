<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page language="java" import="java.io.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>价格/时效查询</title>
<%@include file="../head.jsp" %>
<script src="${scripts}/public.js" type="text/javascript" ></script>
<script src="${scripts}/queryDistrict.js" type="text/javascript" ></script>
<script src="${scripts}/jquery.jtabs.js" type="text/javascript" ></script>
<script src="${scripts}/queryPriceTime.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$(".subNav").click(function(){		
		$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
		// 修改数字控制速度， slideUp(500)控制卷起速度
		$(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
	})	
	$('.cost_tab').jtabs('.cost_list', {fx: 'fade', activeClass: 'active', event: 'click', initIdx: 0});
})
</script>
</head>
<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<div class="col_left fl">
			<div class="content_second_nav">
				<h3>自助服务</h3>
				<ul>
					<li><a href="traceTransByNo.action">货物追踪</a></li>
					<li><a href="companyMatchAction!index.action">网点查询</a></li>					
					<li class="current"><a href="#">价格/时效查询</a></li>
				</ul>
			</div>
			
		</div>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/order_banner.jpg" width="770" alt="价格/时效查询"/></div>
			<div class="news_detail">
				<h1 class="news_title">价格/时效查询</h1>
				<div class="query-form clearfix">
					<p>	
						<input name="" id="leavedCityName" autocomplete="off" type="text" <s:if test="leavedCityName != null and leavedCityName != ''">value="<s:property value='leavedCityName'/>"</s:if><s:else>value="出发城市"</s:else> class="grays send_input proCityQueryAll proCitySelAll inputFocus" ov="出发城市"/>
						<span class="arrow"></span>
						<input name="" id="arrivedCityName" autocomplete="off" type="text" <s:if test="arrivedCityName != null and arrivedCityName != ''">value="<s:property value='arrivedCityName'/>"</s:if><s:else>value="到达城市"</s:else> class="grays send_input proCityQueryAll proCitySelAll inputFocus" ov="到达城市"/>
						<input id="queryPrice" type="button" class="submit tosnmiddle_btn" value="查询"/>
						<span id="routeMsg" class="hide" style="color:red;">请选择城市!</span>
					</p>
				</div>
			</div>
			<!-- 价格时效 -->
			<div class="mastery show" id="trans_illustrate">
				<div class="mastery_title">运输方式</div>
				<table class="change_mode" border="0" cellspacing="0" cellpadding="0" width="100%">
					<!-- 定日达 -->
					<tr>
						<td width="24%">
							<label class="change_mode_sel">								
								<img src="${images}/150602_img09.png" width="133" alt="定日达"/>
							</label>
						</td>
						<td>
							<p>定日达的每辆运输车辆上都安装了GPS全球定位系统，实现车辆在运输过程中全程追踪;</p>
							<p>严格控制发车时间、车辆在途时间，以确保客户的货物准点到达;</p>
							<p>"定日达"专车从发车至到达全程封闭，全程GPS监控，确保客户的货物安全抵达;</p>
							<p>定日达通过专业的客服团队及全国统一的400客服电话，为客户提供一对一的贴心服务;</p>
						</td>
					</tr>
					<!-- 经济快运（原来的公路零担） -->
					<tr>
						<td>
							<label class="change_mode_sel">								
								<img src="${images}/150602_img10.png" width="133" alt="经济快运"/>
							</label>
						</td>
						<td>
							<p>拥有覆盖全国的公路快运网络;</p>
							<p>以站到站的运输方式，在全国600个城市的1500家网点提供取送货服务;</p>
							<p>经济实惠，为客户提供经济实用的全国性标准零担公路运输服务;</p>
							<p>运输快捷，主要中心城市之间的运输时间为2-4天，市县级城市则为3-6天;</p>
						</td>
					</tr>
					<!-- 易入户（新增） -->
					<tr>
						<td>
							<label class="change_mode_sel">								
								<img src="${images}/150602_img10_1.png" width="133" alt="易入户"/>
							</label>
						</td>
						<td>
							<p>提供所有公斤段重量的上楼入户，从发货仓库上门提货到末端上楼入户，提供全链条物流方案，全程信息系统可视化;</p>
							<p>让大件上楼不再成为电商平台卖家的痛点，是易入户产品的核心;</p>
							<p>对于C端买家客户提供个性化预约送货，按买家指定日期送货入户;</p>
							<p>并且对天猫、淘宝平台的卖家，免费提供平台所要求的喵师傅签收核销。</p>
						</td>
					</tr>
					<!-- 易安装（新增） -->
					<tr>
						<td>
							<label class="change_mode_sel">								
								<img src="${images}/150602_img10_2.png" width="133" alt="易安装"/>
							</label>
						</td>
						<td>
							<p>为家居、建材、健身器材、体育器材等需要入户后再服务行业提供的专属物流产品，从上门提货、干线运输、支线送货、上楼入户、拆包安装、售后服务提供六包一体化服务。</p>
							<p>解决物流运输与安装不能一体化的难点。并且对天猫、淘宝平台的卖家，免费提供平台所要求的喵师傅签收核销。</p>
						</td>
					</tr>
					<!-- 易包裹（新增） -->
					<tr>
						<td>
							<label class="change_mode_sel">								
								<img src="${images}/150602_img10_3.png" width="133" alt="易包裹"/>
							</label>
						</td>
						<td>
							<p>提供30Kg以下物流运输服务，以快运的价格享受快递的时效、快运的服务;</p>
							<p>以易包裹的0-30Kg定位，配合现有天地华宇全产品线物流产品：整车、定日达、经济快运、易入户、易安装，搭建形成全公斤段货物解决体系，为客户提供不区分重量段的最优解决方案。</p>
						</td>
					</tr>
				</table>
			</div>
			<div id="price_time" class="mastery hide">
				<table class="change_mode" border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr class="first">
						<td width="24%">运输方式</td>
						<td width="28%">时效（从发货次日算起）</td>
						<td width="12%">起步价（元/票）</td>
						<td width="12%">重货（元/公斤）</td>
						<td width="12%">轻货（元/立方米）</td>
						<td width="12%">备注</td>
					</tr>
					<!-- 定日达 -->
					<tr id="price0" class="hide">
						<td>
							<label class="change_mode_sel">
								<input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_0" />
								<img src="${images}/150602_img09.png" width="133" alt="定日达"/>
							</label>
						</td>
						<td>
							<p>预计客户自提时间：<span id="pickup0"></span></p>
							<p>预计送货上门时间：<span id="delivery0"></span></p>
						</td>
						<td align="center"><span id="startPrice0"></span></td>
						<td align="center"><span id="heavyPrice0"></span></td>
						<td align="center"><span id="lightPrice0"></span></td>
						<td align="center"><span id="remark0"></span></td>
					</tr>
					<!-- 经济快运（公路零担） -->
					<tr id="price1" class="hide">
						<td>
							<label class="change_mode_sel">
								<input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
								<img src="${images}/150602_img10.png" width="133" alt="经济快运"/>
							</label>
						</td>
						<td>
							<p>预计客户自提时间：<span id="pickup1"></span></p>
							<p>预计送货上门时间：<span id="delivery1"></span></p>
						</td>
						<td align="center"><span id="startPrice1"></span></td>
						<td align="center"><span id="heavyPrice1"></span></td>
						<td align="center"><span id="lightPrice1"></span></td>
						<td align="center"><span id="remark1"></span></td>
					</tr>
				</table>
				<table class="change_mode" border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr class="first">
						<td width="24%">运输方式</td>
						<td width="28%">时效（从发货次日算起）</td>
						<td width="12%">首重金额(元)</td>
						<td width="12%">首重重量(公斤)</td>
						<td width="12%">续重单价(元/公斤)</td>
						<td width="12%">备注</td>
					</tr>
					<!-- 易入户  -->
					<tr id="price2" class="hide">
						<td>
							<label class="change_mode_sel">
								<input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_2" />
								<img src="${images}/150602_img10_1.png" width="133" alt="易入户 "/>
							</label>
						</td>
						<td>
							<p>预计客户自提时间：<span id="pickup2"></span></p>
							<p>预计送货上门时间：<span id="delivery2"></span></p>
						</td>
						<td align="center"><span id="heavyPrice2"></span></td>
						<td align="center"><span id="startPrice2"></span></td>
						<td align="center"><span id="lightPrice2"></span></td>
						<td align="center"><span id="remark2"></span></td>
					</tr>
					<!-- 易安装 -->
					<tr id="price3" class="hide">
						<td>
							<label class="change_mode_sel">
								<input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_3" />
								<img src="${images}/150602_img10_2.png" width="133" alt="易安装"/>
							</label>
						</td>
						<td>
							<p>预计客户自提时间：<span id="pickup3"></span></p>
							<p>预计送货上门时间：<span id="delivery3"></span></p>
						</td>
						<td align="center"><span id="heavyPrice3"></span></td>
						<td align="center"><span id="startPrice3"></span></td>
						<td align="center"><span id="lightPrice3"></span></td>
						<td align="center"><span id="remark3"></span></td>
					</tr>
					<!-- 易包裹 -->
					<tr id="price4" class="hide">
						<td>
							<label class="change_mode_sel">
								<input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_4" />
								<img src="${images}/150602_img10_3.png" width="133" alt="易包裹"/>
							</label>
						</td>
						<td>
							<p>预计客户自提时间：<span id="pickup4"></span></p>
							<p>预计送货上门时间：<span id="delivery4"></span></p>
						</td>
						<td align="center"><span id="heavyPrice4"></span></td>
						<td align="center"><span id="startPrice4"></span></td>
						<td align="center"><span id="lightPrice4"></span></td>
						<td align="center"><span id="remark4"></span></td>
					</tr>
				</table>
				<div class="ask_tips">
					<div class="ask">
						【提示】：
						<a href="collectingMoney.action" target="_Blank"><img id="insuraceImg" src="${images}/150602_icon11.png" style="margin-top: -3px; vertical-align: middle;margin-right:10px">增值服务说明</a>
						<div class="question_tips pr">
							<a href="#"><img id="insuraceImg" src="${images}/150602_icon11.png" style="margin-top: -3px; vertical-align: middle;"></a>重货与轻货说明
							<div class="qus-img pa" style="top: 24px;"></div>
							<div class="qus-info pa" style="top:30px;">
								<p class="f12">货物的总重量（KG）和总体积（m3）的比值大于或等于220为重货，按重量计费；若比值低于220为轻货，按体积计费。如有疑问请联系当地网点咨询。</p>
							</div>
						</div>
						<div class="question_tips pr">
							<a href="#"><img id="insuraceImg" src="${images}/150602_icon11.png" style="margin-top: -3px; vertical-align: middle;"></a>自提与派送说明
							<div class="qus-img pa" style="top: 24px;"></div>
							<div class="qus-info pa" style="top:30px;">
								<p class="f12">自提：就是您需要亲自去华宇的营业网点领取货物。</p>
								<p class="f12">派送：就是华宇会派专门的送货人员将您的货物送到您指定的地方。派送分为送货（不含上楼）和送货上楼两种。</p>
							</div>
						</div>
					</div>
					<p>【说明】： <span style="color:red;">部分偏远区县价格略高于公布价，此价格与时效仅供参考</span>，普通客户准确报价应以华宇门店电话咨询为准，签约客户应以合同协议中的报价为准。</p>
					<p style="padding-left: 75px;">以上报价均不包含送货、保价等增值服务收费，相关费用请查看增值服务收费标准。</p>
					<p style="padding-left: 75px;" class="tips_btn tr">
						<span class="fl">如果您了解货物的重量与体积，可计算总价预估费用。也可直接</span><a href="orderAction!index.action" class="tips_btn_one">我要下单发货</a><a href="companyMatchAction!index.action" class="tips_btn_two">查询网点咨询</a></p>
				</div>
				<div class="clamode">
					<div class="mastery_title">运费计算条件</div>
					<div class="cla_info">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="166" align="right"><span class="f_f15a22">*</span>重量（公斤）：</td>
								<td width="200"><input id="weight" name="" type="text" class="nomarl grays" onfocus="initval('weight',1,2)" onblur="initval('weight',2,2)" value="货物总重量"/></td>
								<td width="166" align="right"><span class="f_f15a22">*</span>体积（立方米）：</td>
								<td width="200"><input id="volumn" name="" type="text" class="nomarl grays" onfocus="initval('volumn',1,3)" onblur="initval('volumn',2,3)" value="货物总体积:长*宽*高(CM)"/></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>保价（元）：</td>
								<td><input id="insurance" name="" type="text" class="nomarl grays" onfocus="initval('insurance',1,4)" onblur="initval('insurance',2,4)" value="请输入货物实际价值进行保价"/></td>
								<td align="right">代收货款（元）：</td>
								<td><input id="collDeliveryAmount" name="" type="text" class="nomarl grays" onfocus="initval('collDeliveryAmount',1,5)" onblur="initval('collDeliveryAmount',2,5)" value="如您需要代收货款服务则填写"/></td>
							</tr>
						</table>
						<p class="tr cla_info_btn">
							<span class="tips" id="tips" style="color:red;"></span>
							<input id="priceCale" type="button" class="tosnmiddle_btn" value="计算总价"/>
						</p>
					</div>
				</div>
				<!-- 计算运费 -->
				<div id="price_cale" class="cost hide">
					<div class="mastery_title">运费计算结果</div>
					<div class="cost_tab">
						<a href="#" class="active">定日达</a>
						<a href="#">经济快运</a>
						<a href="#" id="price_calc_inhome_title">易入户</a>
						<a href="#" id="price_calc_install_title">易安装</a>
						<a href="#" id="price_calc_package_title">易包裹</a>
					</div>
					<div class="cost_list">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>货物类型</td>
								<td id="goodsType0"></td>
								<td>运输时效</td>
								<td id="transAging0"></td>
							</tr>
							<tr>
								<td>交通运输费</td>
								<td id="transCost0"></td>
								<td>保价费</td>
								<td id="insuredCost0"></td>
							</tr>
							<tr>
								<td>燃油服务费</td>
								<td id="fuelCost0"></td>
								<td>工本费</td>
								<td id="laborCost0"></td>
							</tr>
							<tr>
								<td>信息费</td>
								<td id="messageCost0"></td>
								<td>代收货款手续费</td>
								<td id="collProceCost0"></td>
							</tr>
						</table>
						<div class="cost_price">合计：<span id="totalCost0"></span></div>
					</div>
					<div class="cost_list">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>货物类型</td>
								<td id="goodsType1"></td>
								<td>运输时效</td>
								<td id="transAging1"></td>
							</tr>
							<tr>
								<td>交通运输费</td>
								<td id="transCost1"></td>
								<td>保价费</td>
								<td id="insuredCost1"></td>
							</tr>
							<tr>
								<td>燃油服务费</td>
								<td id="fuelCost1"></td>
								<td>工本费</td>
								<td id="laborCost1"></td>
							</tr>
							<tr>
								<td>信息费</td>
								<td id="messageCost1"></td>
								<td>代收货款手续费</td>
								<td id="collProceCost1"></td>
							</tr>
						</table>
						<div class="cost_price">合计：<span id="totalCost1"></span></div>
					</div>
					<!-- 易入户 -->
					<div class="cost_list" id="price_calc_inhome_div">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>货物类型</td>
								<td id="goodsType2"></td>
								<td>运输时效</td>
								<td id="transAging2"></td>
							</tr>
							<tr>
								<td>交通运输费</td>
								<td id="transCost2"></td>
								<td>保价费</td>
								<td id="insuredCost2"></td>
							</tr>
							<tr>
								<td>燃油服务费</td>
								<td id="fuelCost2"></td>
								<td>工本费</td>
								<td id="laborCost2"></td>
							</tr>
							<tr>
								<td>信息费</td>
								<td id="messageCost2"></td>
								<td>代收货款手续费</td>
								<td id="collProceCost2"></td>
							</tr>
						</table>
						<div class="cost_price">合计：<span id="totalCost2"></span></div>
					</div>
					<!-- 易安装 -->
					<div class="cost_list" id="price_calc_install_div">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>货物类型</td>
								<td id="goodsType3"></td>
								<td>运输时效</td>
								<td id="transAging3"></td>
							</tr>
							<tr>
								<td>交通运输费</td>
								<td id="transCost3"></td>
								<td>保价费</td>
								<td id="insuredCost3"></td>
							</tr>
							<tr>
								<td>燃油服务费</td>
								<td id="fuelCost3"></td>
								<td>工本费</td>
								<td id="laborCost3"></td>
							</tr>
							<tr>
								<td>信息费</td>
								<td id="messageCost3"></td>
								<td>代收货款手续费</td>
								<td id="collProceCost3"></td>
							</tr>
						</table>
						<div class="cost_price">合计：<span id="totalCost3"></span></div>
					</div>
					<!-- 易包裹 -->
					<div class="cost_list" id="price_calc_package_div">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>货物类型</td>
								<td id="goodsType4"></td>
								<td>运输时效</td>
								<td id="transAging4"></td>
							</tr>
							<tr>
								<td>交通运输费</td>
								<td id="transCost4"></td>
								<td>保价费</td>
								<td id="insuredCost4"></td>
							</tr>
							<tr>
								<td>燃油服务费</td>
								<td id="fuelCost4"></td>
								<td>工本费</td>
								<td id="laborCost4"></td>
							</tr>
							<tr>
								<td>信息费</td>
								<td id="messageCost4"></td>
								<td>代收货款手续费</td>
								<td id="collProceCost4"></td>
							</tr>
						</table>
						<div class="cost_price">合计：<span id="totalCost4"></span></div>
					</div>
				</div>
				<div id="explain_div" class="hide">
					<p>【说明】：此运费与时效仅供参考，以上运费中不包含接送货费，相关费用请查看<a href="#" class="f_f15a22">增值服务</a>中的接送货收费标准。</p>
					<p class="tr tips_btn"><a href="orderAction!index.action" class="tips_btn_one">我要下单发货</a><a href="companyMatchAction!index.action" class="tips_btn_two">查询网点咨询</a></p>
				</div>
				
			</div>
			
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>

<%@include file="../bottom.jsp" %>

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
</body>
</html>
