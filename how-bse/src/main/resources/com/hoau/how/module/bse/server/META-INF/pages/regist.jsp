<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<%@include file="head.jsp" %>
<script type="text/javascript" src="${scripts}/user/regist.js?version=0.0.1"></script>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
</head>

<body>
<%@include file="top.jsp" %>
<div class="p_w content">
	<div class="news_detail">
		<h1 class="news_title">用户注册</h1>
		<div class="reg_info">
			<div class="reg_form fl">
				<form action="registAction!regist.action" method="post" id="registForm">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="150"><label class="tit"><span class="f_f15a22">*</span>手机号：</label></td>
							<td width="212">
								<input id="entity.ebccMobile" name="mobile" type="text" ov="请输入11位手机号码" maxlength="11"
									<s:if test="#request.entity.ebccMobile != null and #request.entity.ebccMobile != \"\""> class="input w205 inputFocus" value="<s:property value="#request.entity.ebccMobile"/>" </s:if>
										<s:else> value="请输入11位手机号码" class="input w205 inputFocus grays" </s:else>
								/>
							</td>
							<td>
								<div class="tips" id="phone_tips">
									<c:if test="${errorType eq 'phone'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td><label class="tit"><span class="f_f15a22">*</span>密码：</label></td>
							<td>
								<input id="entity.ebccNetPassword" name="entity.ebccNetPassword" type="password" class="input w205 inputFocus grays"/>
							</td>
							<td>
								<div class="tips" id="password_tips">
									<c:if test="${errorType eq 'password'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td><label class="tit"><span class="f_f15a22">*</span>确认密码：</label></td>
							<td><input id="password2" name="password2" type="password" class="input w205 inputFocus grays"/></td>
							<td>
								<div class="tips" id="password2_tips">
								</div>
							</td>
						</tr>
						<tr>
							<td><label class="tit">用户名：</label></td>
							<td>
								<input id="entity.ebccNetLogin" name="loginName" type="text" ov="可作为登录账号"
									<s:if test="#request.entity.ebccNetLogin != null and #request.entity.ebccNetLogin != \"\""> class="input w205 inputFocus" value="<s:property value="#request.entity.ebccNetLogin"/>" </s:if>
										<s:else> value="可作为登录账号" class="input w205 inputFocus grays"</s:else>
								/>
							</td>
							<td>
								<div class="tips" id="userName_tips">
									<c:if test="${errorType eq 'userName'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td><label class="tit">邮箱地址：</label></td>
							<td>
								<input id="entity.ebccEmail" name="email" type="text" class="input w205 inputFocus grays" ov="可作为登录账号和密码找回凭证"
									<s:if test="#request.entity.ebccEmail != null and #request.entity.ebccEmail != \"\""> class="input w205 inputFocus" value="<s:property value="#request.entity.ebccEmail"/>" </s:if>
										<s:else> value="可作为登录账号和密码找回凭证"  class="input w205 inputFocus grays"</s:else>
								/>
							</td>
							<td>
								<div class="tips" id="email_tips">
									<c:if test="${errorType eq 'email'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td><label class="tit"><span class="f_f15a22">*</span>验证码：</label></td>
							<td>
								<input id="validateCode_regist" name="" type="text"	class="input w95 inputFocus grays" value="请输入验证码" ov="请输入验证码" />
								<span>
									<img id="validateCode_img"
									src="genCheckCode.action?codeName=USER_REGIST_VERCODE" width="60" height="28"
									style="vertical-align: middle;" onclick="changeCode()" /> <a
									href="javascript:changeCode();">换一组</a>
								</span>
							</td>
							<td>
								<div class="tips" id="validCode_msg" style="display:none;">
									<p class="erro"><span class="icon_del"></span>请输入正确验证码</p>
								</div>
							</td>
							
						</tr>
						<tr>
							<td><label class="tit"><span class="f_f15a22">*</span>短信验证码：</label></td>
							<td>
								<input id="registVerCode" name="registVerCode" type="text" class="input w95 inputFocus grays" value="请输入验证码" ov="请输入验证码" />
								<input type="button" id="getPhoneVerCodeBtn" disabled="disabled" class="btn_sub xz1" style="padding:0 10px;" value="获取验证码" onclick="sendPhoneVerCode()"/>
							</td>
							<td>
								<div class="tips" id="verCode_tips">
									<c:if test="${errorType eq 'verCode'}">
										${errorMsg}
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input id="accept" name="accept" type="checkbox" checked="checked"/>已阅读<a href="javascript:void(0);" class="f_f15a22" id="user_agreement">华宇网上营业厅服务协议</a></td>
							<td>
								<div class="tips" id="accept_tips">
								</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><a href="javascript:regist();" class="xz1">立即注册</a></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="reg_aside fl">
				<p class="have_ac">已有帐号，<a href="login.action" class="f_f15a22">直接登录 &gt;&gt;</a></p>
				<div class="reg_service">
					<p>注册成为<strong class="f16">华宇会员</strong>，您可以享受更多的服务</p>
					<ul>
						<li>账号一体化</li>
						<li>快捷下单</li>
						<li>在线理赔</li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<%@include file="bottom.jsp" %>

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
