<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="image/x-icon" rel="shortcut icon" href="<%=request.getContextPath()%>/images/logo.ico" />
<link type="text/css" href="<%=request.getContextPath()%>/styles/hc_place_order.css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/scripts/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/hc_place_order.js"></script>
<title>天地华宇下单</title>
</head>
<body > 
	<div id="header">
		<a href="https://www.hoau.net/">
			<img src="<%=request.getContextPath()%>/images/logo_name.png">
		</a>
	</div>
	<div id="content" style="background-color:" ><!--#EE9A49  -->
		<form action="<%=request.getContextPath()%>/hcSubmitOrder.action" method="post" onsubmit="return check();">
			<!-- 发货人信息-->
			<div id="shipper_info">
				<table cellspacing="0px;" id="tb1">
					<tr>
					  <td class="info" style="width:15%;">发货人信息</td>
					</tr>
					<tr>
						<td colspan="3" style="width:15%;" ><label style="color:red;">*</label>&nbsp;&nbsp;&nbsp;收货人：
						<input type="text" id="shipper_name" name="order.shipperName" onblur="check1();"/>
						<label class="label" id="shipper">50长度以内的中文或英文名</label>
						</td>
					</tr>
					<tr>
                      <td align="left" colspan="3" style="width:15%;"><label class="tip" style="color:red;">*</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机 ：
					  	<input type="text" id="shipper_mobile_phone" name="order.shipperMobile" onblur="check2();" />
						<label>电话：</label>
						<input type="text" style="width: 25%;" id="shipper_phone" name="order.shipperPhone" placeholder="021-12345678;0769-1234567" onblur="check2();"/>
					    <label class="label" id="shipper_mobile">手机和电话必须填写一项</label>
					  </td>
				  	</tr>
					<tr>
						<td colspan="3" >
							<label style="color:red;">*</label>发货地址：
							<select id="from_province" name="order.shipperProv">
								<option value="" >--选择省份--<option>
							</select>
							<select id="from_city" name="order.shipperCity">
								<option value="">--选择城市--<option>
							</select>
							<input type="text" id="from_detail_address" name="order.shipperAddress" style="width:40%;"  placeholder="详细地址：区县、街道" onblur="check3();"/>
							<label id="fh_address"></label>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="left">&nbsp;上门提货：
							<input type="radio"  name="order.shipperMethod" value="DOORSTEP"/>是（收费）
							<input type="radio"  name="order.shipperMethod" value="SELF_TAKE"  checked="checked"/>否
						</td>
					</tr>
					<tr> 
						<td style="width:15%;">
						</td>
						<td>
						    <span style="display:block; width:50px; text-align:center">
						   <!--  <input type="submit" value="保存发货人信息" class="" /> -->
							 <input type="button" value="重置信息" class="" onclick="reset1();"onmouseover="this.style.backgroundColor='#EEDC82';" onmouseout="this.style.backgroundColor='';"/> </span>
						 </td>
					</tr>
				</table>
			</div>
			<!-- 收货人信息-->
			<div id="consignee_info">
				<table  cellspacing="0px;" id="tb2">
					<tr>
					  <td class="info" style="width:15%;">收货人信息</td>
					</tr>
					<tr>
						<td colspan="3" style="width:15%;"><label style="color:red;">*</label>&nbsp;&nbsp;&nbsp;收货人：
						<input type="text" id="consignee_name" name="order.consigneeName" onblur="check4 ();"/>
						<label class="label" id="consignee">50长度以内的中文或英文名</label>
						</td>
					</tr>
					<tr>
                      <td colspan="3" style="width:15%;"><label class="tip" style="color:red;">*</label><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机 ：</label>
					  	<input type="text" id="consignee_mobile_phone" name="order.consigneeMobile" onblur="check5();"/>
						<label>电话：</label>
						<input type="text" style="width: 25%;" id="consignee_phone" name="order.consigneePhone" placeholder="021-12345678;0769-1234567" onblur="check5();" />
					    <label class="label" id="consignee_mobile">手机和电话必须填写一项</label>
				  	</tr>
					<tr>
						<td colspan="3" style="width:15%;"><label style="color:red;">*</label>收货地址：
							<select id="to_province" name="order.consigneeProv" >
								<option value="">--选择省份--<option>
							</select>
							<select id="to_city" name="order.consigneeCity">
								<option value="">--选择城市--<option>
							</select>
							<input type="text" id="to_detail_address" style="width:40%;" name="order.consigneeAddress" placeholder="详细地址：区县、街道" onblur="check6();"/>
							<label id="sh_address"></label>
						</td>
					</tr>
					<tr>
						<td style="width:15%;">
						</td>
						<td>
						    <span style="display:block; width:50px; text-align:center">
							  <input type="button" value="重置信息" class="" onclick="reset2();"onmouseover="this.style.backgroundColor='#EEDC82';" onmouseout="this.style.backgroundColor='';" /> </span>
						 </td>
					</tr>
				</table>
			</div>
			<!-- 货物信息-->
			<div id="goods_info">
				<table  cellspacing="0px;" id="tb3">
					<tr>
					  <td class="info">货物信息</td>
					
					</tr>
					<tr>
					  <td colspan="3">
					  	<label style="color:red;">*</label><label>货物名称：</label>
						<input type="text" id="goods_name" name="order.goods_name" onblur="check7();" />
						<label id="goods" class="label">100长度以内的货物名称</label>
					  </td>
					  <td colspan="3">
					  	<label>货物件数：</label>
						<input type="number" id="goods_pieces" name="order.goods_pieces" min="0" max="100000" />件
					  </td>
					</tr>
					<tr>
					  <td colspan="3">
					   <label>&nbsp;货物重量：</label>
						<input type="number" id="goods_weight" name="order.goods_weight"  min="0" max="100000"/>千克
					  </td>
					  <td colspan="3">
					  	<label>货物体积：</label>
						<input type="number" id="goods_volumn" name="order.goods_volumn"  min="0" max="100000"/>立方米
					  </td>
					</tr>
					<tr>
					  <td colspan="3">
					  	<label >&nbsp;货物包装：</label>
						<input type="number" id="goods_packing" name="order.goods_packing"  min="0" max="100000"/>件
					  </td>
					  <td colspan="3">
					  	<label>保价申明：</label>
						<input type="number" id="quotation_statement" name="order.quotation_statement"  min="0" max="100000"/>元
					  </td>
					</tr>
					<tr>
						<td style="width:15%;">
						</td>
						<td>
						    <span style="display:block; width:50px; text-align:center">
							  <input type="button" value="重置信息" class="" onclick="reset3();"onmouseover="this.style.backgroundColor='#EEDC82';" onmouseout="this.style.backgroundColor='';" /> </span>
						 </td>
					</tr>
					<tr>
						<td colspan="4">
							<div >
								<label class="info"  >备注</label><br/>
								<textarea id="order.remark" rows="2" style="width: 100%;margin-left: 5px;"></textarea>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="submit">
				<div><input type="checkbox" checked="checked"/><a href="javascript:void(0);" onclick="show('pop')">我已理解并同意遵守服务条款</a></div>
					<!--显示层:-->
						<div id="pop" class="pop" style="display:none">
						 	<div class="pop_head"><a href="javascript:void(0);" onclick="hide('pop')">关&nbsp;闭</a></div>
 							<textarea style="width:99%; height:100%;" readonly="readonly">1、托运人应准确填写本单，如实告知承运人所托运货物的名称、性质、重量、数量、价值等必要情况；托运人应对所托货物按照行业标准妥善包装，使其适合运输。

2、对于国家规定限制运输的物品，托运人应在交货前完成或委托承运人完成有关法律、行政法规规定的手续，并附有效凭证。

3、托运人不得托运或在所托运货物中夹带国家禁止运输的物品；因违背此约定造成承运人的一切损失托运人须双倍赔偿。

4、对已接受委托，后发现属于承运人不能安全、合法运送的物品（包括但不限于危险品、违禁品），承运人保留拒绝运送的权利，并由托运人承担违约责任。

5、委托承运人货物重量计量单位为千克，不足1千克按照1千克计算。若体积重量大于实际重量，按体积重量计算。

6、货运价格一般按照承运人的公布价。依该价格计算得出的费用不包含接送货费、税金、政府规费以及由于托运人或收货人的原因而增加的其他费用。

7、收货人在收到提货通知后最迟应在三日内提货；收货人在此期限内未提货的应支付超出天数的仓储费和保管费。到货后三个月无人提货且承运人无法退回货物的，承运人对该货有权处置，在处置所得中优先扣除相关费用。

8、托运人或收货人不得无故拒付任何服务费用；收货人拒绝支付费用的，托运人承担支付与托运物品有关费用的连带责任。托运人或收货人无故不支付费用的，承运人可以对承运货物行使处置权、留置权及其他补救性权利，由此而产生的后果由托运人或收货人承担。

9、承运人从货物收运时起到交付时止承担安全运输责任，在此期间若发生货物损坏、短缺、灭失、污染，承运人负赔偿责任。 

10、承运人建议托运人办理货物保价运输，声明保价并支付相应保价费。托运人声明保价并支付保价费，发生货物丢损，承运人按如下规则赔偿：货物全部灭失，按货物保价声明价值赔偿；货物部分毁损或灭失，按声明价值和损失比例赔偿，最高不超过声明价值。声明价值高于实际价值的，按实际价值赔偿。

11、未办理保价而发生货物丢损，承运人对空运货物依照实际损失最高按20元（人民币）/千克赔偿，对汽运货物按照实际损失在丢损货物所对应运费的3倍以内赔偿。按以上方式计算得出的赔偿额超过货物实际价值的部分无效。 

12、托运人委托承运人代收货款不代表该次货物的实际价值；如果运输货物在运输途中出现损坏或灭失赔偿额按照本条款第10、11条约定赔偿与代收货款无关。收货人签名后因货物品名、性质、型号等原因而不支付代收货款，承运人不承担代收货款无法收回的责任。

13、以下物品不予托运：发票、有价证券、国家禁运的刊物、首饰、护照、私人证件、单证、合同、现金、私人信函、毒品、珠宝、玉器、古玩、字画、邮票、艺术品、稀有金属、液体物品、产地来源不正确的物品、有腐蚀性或放射性、易燃易爆品、白色粉末及一切有关法律禁止及难以客观确定价值的货物。

14、货运时效一般按照承运人的公布时效。时效不影响其他费用的结算和不可抗力免责权。 

15、承运人对如下损失不承担责任：    
	A.因不可抗力（包括但不限于自然灾害、政府行为、战争等社会异常事件）造成货物损坏、短缺、灭失、污染、变质或迟延交付；
	B.因货物本身的自然性质、质量瑕疵或缺陷、合理损耗等造成的损失；
	C.托运人自行包装或容器不良，但从外部无法发现；
	D.托运人自行包装，到达时外包装完好而内件缺少或损坏；
	E.承运人包装的非新品运输，外包装完好而内件缺少或损坏；
	F.由于托运人故意或过失导致损失；
	G.承运过程中发生的一切间接损失（包括但不限于对所托运货物的收益、利润、实际用途、特殊商业价值）。

16、凡因本单或与本单有关的争议，当事人可以通过协商或调解解决，协商或调解不成，任何一方均应向承运人总部所在地人民法院提起诉讼。

17、当托运人现场发货因需求发生变化而填写纸质运单，且填写内容与网单不符时，双方确认以运单填写内容为准。 

18、本单于托运人和承运人双方签章之时起生效。
														天地华宇物流有限公司</textarea>
						</div>	
			
				<div style="margin-top:30px; margin-bottom:80px;">
				<!-- <input type="submit" id="place_order" value="立刻下单" style="width:40%;color:white; font-size:20px; font-weight:bold;background-color:#FF3030;"/>   -->
			 <input type="image" name="submit" value="立刻下单" src="<%=request.getContextPath()%>/img/xd2.png" style="width:150pt;height:24pt" onmousemove="this.src='<%=request.getContextPath()%>/img/xd3.png'" onmouseout="this.src='<%=request.getContextPath()%>/img/xd2.png'" onclick="document.formName.submit()"> 
				</div>
			</div>
		</form>	
	</div>
	<div id="code_img"></div>
</body>
</html>
