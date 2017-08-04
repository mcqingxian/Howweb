<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>理赔申请</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${scripts}/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${scripts}/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="${scripts}/jquery.fileupload.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
<script type="text/javascript" src="${scripts}/claim.js"></script>
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
.select_ui{width:255px;}
#bankInfo_ul{display:none;position:absolute;z-index:100;background-color:#FFFFFF;border:1px solid #bfbfbf;width:300px;}
#bankInfo_ul li{padding:0 15px;line-height:26px;color:#777777;}
#bankInfo_ul li:HOVER {background-color:#ff6c00;color:#FFFFFF;cursor:pointer;}
#accountBank{background:url(../images/bse/150602_icon08.png) no-repeat 186px 5px;}
</style>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/my_banner.jpg" width="770" /></div>
			<div class="news_detail pb20">
				<h1 class="news_title">理赔申请</h1>
				<div class="claim_step">
					<ul>
						<li><div id="div_step1" class="claim_step_active"><i></i><span>1、理赔单申请</span></div></li>
						<li><div id="div_step2"><i></i><span>2、理赔基础<br />　&nbsp; 信息录入</span></div></li>
						<li><div><i></i><span>3、受理审核</span></div></li>
						<li class="last_claim_step"><div><i></i><span>4、理赔成功</span></div></li>
					</ul>					
				</div>
				<div id="first_step" class="show">
					<div class="claim_info f12 pt30">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td align="right" width="220"><span class="f_f15a22">*</span>理赔运单编号:</td>
								<td width="250">
									<input id="waybillNo" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test="claimSubmitEntity.billNo != null and claimSubmitEntity.billNo !=''">value="${claimSubmitEntity.billNo}"  readonly="readonly" </s:if>
										<s:else>value="请输入12个月以内的运单编号"</s:else>  ov="请输入12个月以内的运单编号" />
									<input id="imgMapid" type="hidden"  value="<s:property value="claimSubmitEntity.id"/>"/>
									<input id="imgMapString" type="hidden" value="<s:property value="claimSubmitEntity.imgMapString"/>"/>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroWaybillNo" class="erro"></p>
									</div>
								</td>
							</tr>
						<%-- 	<tr>
								<td align="right"><span class="f_f15a22">*</span>理赔方:</td>
								<td>
									<select id="claimUser" name="">
										<option value="">请选择理赔方</option>
										<option value="DEPART" <s:if test="claimSubmitEntity.claimParty == 'DEPART'">selected="selected"</s:if>>发货方</option>
										<option value="DEST" <s:if test="claimSubmitEntity.claimParty == 'DEST'">selected="selected"</s:if>>收货方</option>
									</select>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroClaimUser" class="erro"></p>
									</div>
								</td>
							</tr> --%>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>运单上联系电话:</td>
								<td>
									<div class="pr" onmouseover="mtrmove(this);" onmouseout="mtrout();">
										<input id="waybillTel" name="" type="text" class="input w250 inputFocus grays" 
								<s:if test="claimSubmitEntity.billTel != null and claimSubmitEntity.billTel !=''">value="${claimSubmitEntity.billTel}"</s:if>
								<s:else>value="请输入运单上联系电话"</s:else> ov="请输入运单上联系电话" />
										<div id="ts" style="width:240px;position:absolute; background-color:#FFFFE6; font-size:12px;line-height:20px; right:-260px; top:-20px; color:#f00; padding:3px; border:1px solid #FFCC99; display:none"></div>
									</div>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroWaybillTel" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">理赔公司所在地:</td>
								<td id="claimAddress">
								  <%-- <s:if test="claimSubmitEntity.claimCompanyAddr == 'null'"></s:if>
								  <s:else><s:property value="claimSubmitEntity.claimCompanyAddr"/></s:else> --%>
								  <select id="claimAddress1">
								  </select>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>验证码:</td>
								<td><input id="validCode" name="" type="text" class="input w95 mr10" /><img id="validateCode_img" src="genCheckCode.action" width="90" class="mr10" style="vertical-align:middle;"><a href="javascript:changeCode();">换一组</a></td>
								<td valign="top">
									<div class="tips">
										<p id="erroValidCode" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td colspan="2">
									<p class="mb10"><label><input id="isReaded" checked="checked" name="" type="checkbox">本人已经认真阅读<a href="#" class="f_f15a22" id="demoBtn1">理赔协议</a>,清楚协议内容并同意遵守</label></p>
									<p><input id="to_second" name="" type="button" value="下一步" class="xz1" /></p>
								</td>
							</tr>
						</table>
					</div>
				</div>
				
				<!-- 下一步显示的内容 -->
				<div id="second_step" class="hide">
					<div class="claim_step_tips f12">
						<div>
							<h3><b class="f14">理赔录入说明：</b></h3>
							<!-- <p>1、理赔申请人或经办人必须与理赔收款人为同一人，即"理赔人姓名或公司"需与附件银行卡号复印件信 息（包括开户行信息）的持卡人姓名保持一致，建议使用工商银行卡号，便于及时到账。</p> -->
							<p>1、申请理赔金发放的银行卡建议使用工商银行卡号，便于及时到账。</p>
							<p>2、委托办理理赔需出具客户委托授权证明，若企业委托个人办理，则需要企业出具证明并盖公章。</p>
							<p>3、理赔金额≤1000元，需上传身份证扫描件图片、银行卡号复印件、到货签收凭证图、发票复印件图片、货物破损照片(出险类型为“破损”时上传)；1000元＜理赔金额≤3000元，需上传身份证扫描件图片、银行卡号复印件、到货签收凭证图、发票复印件图片、货物破损照片(出险类型为“破损”时上传)、客户索赔函、发货运单图片。</p>
						</div>
					</div>
					<div class="claim_info claim_info_m">
						<h3><b>理赔单申请信息：</b></h3>
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td align="right" width="220">理赔运单编号:</td>
								<td><span id="showWaybillNo" >
									<s:property value="claimSubmitEntity.billNo"/>
								</span></td>							
							</tr>
							<%-- <tr>
								<td align="right">理赔方:</td>
								<td><span id="showClaimUser">
								   <s:if test="claimSubmitEntity.claimParty == 'DEPART'">发货方</s:if>
								   <s:if test="claimSubmitEntity.claimParty == 'DEST'">收货方</s:if>
								</span></td>
							</tr> --%>
							<tr>
								<td align="right">运单上联系电话:</td>
								<td><span id="showWaybillTel">
									<s:property value="claimSubmitEntity.billTel"/>
								</span></td>
								
							</tr>
							<tr>
								<td align="right">理赔公司所在地:</td>
								<td><span id="showClaimAddress">
									<s:property value="claimSubmitEntity.claimCompanyAddr"/>
								</span></td>
							</tr>
						</table>
					</div>
					<div class="claim_info claim_info_m">
						<h3><b>理赔基础信息：</b></h3>
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<%-- 	<tr>
								<td align="right" width="220"><span class="f_f15a22">*</span>是否委托办理理赔:</td>
								<td>
									<select id="isEntrust" name="" style="width:255px; height:28px;">
										<option value="">请选择</option>
										<option value="YES" <s:if test="claimSubmitEntity.isEntrust == 'YES'">selected="selected"</s:if>>是</option>
										<option value="NO" <s:if test="claimSubmitEntity.isEntrust == 'NO'">selected="selected"</s:if>>否</option>
									</select>
								</td>
								<td>
									<div class="tips" >
										<p id="erroIsEntrust" class="erro"></p>
									</div>
								</td>						
							</tr> --%>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>索赔人姓名或公司名称:</td>
								<td>
									<input id="claimNameOrComp" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test="claimSubmitEntity.contactName != null and claimSubmitEntity.contactName !=''">value="${claimSubmitEntity.contactName}"</s:if>
								        <s:else>value="需与收款人保持一致"</s:else> ov="需与收款人保持一致" />
								</td>
								<td>
									<div class="tips" >
										<p id="erroClaimNameOrComp" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>索赔人手机号:</td>
								<td><input id="claimUserTel" name="" type="text" class="input w250 inputFocus grays"  maxlength="11"
										<s:if test="claimSubmitEntity.contactTel != null and claimSubmitEntity.contactTel !=''">value="${claimSubmitEntity.contactTel}"</s:if>
								        <s:else>value="请输入手机号"</s:else>  ov="请输入手机号" /></td>
								<td>
									<div class="tips" >
										<p id="erroClaimUserTel" class="erro"></p>
									</div>
								</td>								
							</tr>
							<tr>	
								<td align="right">索赔人邮箱:</td>
								<td><input id="claimEmail" name="" type="text" class="input w250 inputFocus grays"  maxlength="50"
										<s:if test="claimSubmitEntity.contactMail != null and claimSubmitEntity.contactMail !=''">value="${claimSubmitEntity.contactMail}"</s:if>
								        <s:else>value=""</s:else> 
								    /></td>
								<td>
									<div class="tips" >
										<p id="erroClaimEmail" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>索赔金额:</td>
								<td><input id="claimMoney" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test='claimSubmitEntity.claimsAmount != null and claimSubmitEntity.claimsAmount !="" and claimSubmitEntity.claimsAmount !="0"'>value="${claimSubmitEntity.claimsAmount}"</s:if>
								        <s:else>value="金额不得超过3000元" </s:else> ov="金额不得超过3000元" /></td>
								<td>
									<div class="tips" >
										<p id="erroClaimMoney" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>货物名称:</td>
								<td>
								<select id="cargoType" name="" style="width:255px; height:28px;">
										<option value="">请选择</option>
										<option value="1" <s:if test='claimSubmitEntity.cargoType  == "药品"'>selected="selected"</s:if>>药品</option>
										<option value="2" <s:if test='claimSubmitEntity.cargoType == "服装"'>selected="selected"</s:if>>服装</option>
										<option value="3" <s:if test='claimSubmitEntity.cargoType == "电脑"'>selected="selected"</s:if>>电脑</option>
										<option value="4" <s:if test='claimSubmitEntity.cargoType == "厨具"'>selected="selected"</s:if>>厨具</option>
										<option value="5" <s:if test='claimSubmitEntity.cargoType == "工具"'>selected="selected"</s:if>>工具</option>
										<option value="6" <s:if test='claimSubmitEntity.cargoType == "配件"'>selected="selected"</s:if>>配件</option>
										<option value="7" <s:if test='claimSubmitEntity.cargoType == "电器"'>selected="selected"</s:if>>电器</option>
										<option value="8" <s:if test='claimSubmitEntity.cargoType == "家具"'>selected="selected"</s:if>>家具</option>
										<option value="9" <s:if test='claimSubmitEntity.cargoType == "刀具"'>selected="selected"</s:if>>刀具</option>
										<option value="10" <s:if test='claimSubmitEntity.cargoType == "灯具"'>selected="selected"</s:if>>灯具</option>
										<option value="11" <s:if test='claimSubmitEntity.cargoType == "乐器"'>selected="selected"</s:if>>乐器</option>
										<option value="12" <s:if test='claimSubmitEntity.cargoType == "日用品"'>selected="selected"</s:if>>日用品</option>
										<option value="13" <s:if test='claimSubmitEntity.cargoType == "食品"'>selected="selected"</s:if>>食品</option>
										<option value="14" <s:if test='claimSubmitEntity.cargoType == "书"'>selected="selected"</s:if>>书</option>
										<option value="15" <s:if test='claimSubmitEntity.cargoType == "行李"'>selected="selected"</s:if>>行李</option>
										<option value="16" <s:if test='claimSubmitEntity.cargoType == "其它"'>selected="selected"</s:if>>其它</option>
									</select>
								</td>
								<td>
								    <div class="tips" >
										<p id="erroCargoType" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>异常件数:</td>
								<td><input id="exceptionPiece" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test='claimSubmitEntity.exceptionCount != null and claimSubmitEntity.exceptionCount !="" and claimSubmitEntity.exceptionCount !="0" '>value="${claimSubmitEntity.exceptionCount}"</s:if>
								        <s:else>value="不得大于运单实际件数"</s:else>  ov="不得大于运单实际件数" /></td>
								<td>
									<div class="tips" >
										<p id="erroExceptionPiece" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>出险类型:</td>
								<td>
									<select id="dangerType" name="" style="width:255px; height:28px;">
										<option value="">请选择出险类型</option>
										<option value="1" <s:if test='claimSubmitEntity.accidentType == "丢失"'>selected="selected"</s:if>>丢失</option>
										<!-- 增加类型破损 add huyuzhou 2015-01-15 -->
										<option value="2" <s:if test='claimSubmitEntity.accidentType == "破损"'>selected="selected"</s:if>>破损</option>
										<!-- end --> 
										<option value="3" <s:if test='claimSubmitEntity.accidentType == "火灾"'>selected="selected"</s:if>>火灾</option>
										<option value="4" <s:if test='claimSubmitEntity.accidentType == "肇事"'>selected="selected"</s:if>>肇事</option>
										<option value="6" <s:if test='claimSubmitEntity.accidentType == "其他"'>selected="selected"</s:if>>其他</option>
									</select>
								</td>
								<td>
									<div class="tips" >
										<p id="erroDangerType" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right" valign="top"><span class="f_f15a22">*</span>理赔原因及其他:</td>
								<td>
									<!-- update huyuzhou 2016年1月27日10:41:13 验证字数不能大于200 -->
									<textarea id="claimReason" rows="3" class="textarea-no w250" onfocus="initval()" wrap="virtual" ><s:if test="claimSubmitEntity.reason != null and claimSubmitEntity.reason !=''">${claimSubmitEntity.reason}</s:if><s:else>字数不得超过200字</s:else></textarea>
									<!-- end -->
								</td>
								<td>
									<div class="tips" >
										<p id="erroClaimReason" class="erro"></p>
									</div>
								</td>	
							</tr>
						</table>
					</div>
					<!-- 增加用户银行卡开户行的信息字段，田育林，2016-05-31 -->
					<div class="claim_info claim_info_m">
						<h3><b>开户行信息：</b></h3>
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td align="right"><span class="f_f15a22">*</span>开户名:</td>
								<td><input id="accountName" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test='claimSubmitEntity.accountName != null and claimSubmitEntity.accountName !="" and claimSubmitEntity.accountName !="0"'>value="${claimSubmitEntity.accountName}"</s:if>
								        <s:else>value="请输入银行开户名" </s:else> ov="请输入银行开户名" />
								</td>
								<td>
									<div class="tips" >
										<p id="errorAccountName" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>银行账号:</td>
								<td><input id="accountCode" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test='claimSubmitEntity.accountCode != null and claimSubmitEntity.accountCode !="" and claimSubmitEntity.accountCode !="0"'>value="${claimSubmitEntity.accountCode}"</s:if>
								        <s:else>value="请输入银行账号" </s:else> ov="请输入银行账号" />
								</td>
								<td>
									<div class="tips" >
										<p id="errorAccountCode" class="erro"></p>
									</div>
								</td>	
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>开户行所在省市:</td>
								<td><input id="accountCity" name="" autocomplete="off" type="text" 
								        <s:if test='claimSubmitEntity.accountCity != null and claimSubmitEntity.accountCity !="" and claimSubmitEntity.accountCity !="0"'>value="${claimSubmitEntity.accountCity}"</s:if>
								        <s:else>value="请选择省市区（县）" </s:else>
								        class="grays w250 input proCityQueryAll proCitySelAll inputFocus" ov="请选择省市区（县）" onchange="validAccountCity()"/>
								</td>
								<td>
									<div class="tips" >
										<p id="errorAccountCity" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>开户行名称:</td>
								<td><input id="accountBank" name="" type="text" class="input w250 inputFocus grays" 
										<s:if test='claimSubmitEntity.accountBank != null and claimSubmitEntity.accountBank !="" and claimSubmitEntity.accountBank !="0"'>value="${claimSubmitEntity.accountBank}"</s:if>
								        <s:else>value="请输入关键字搜索开户行" </s:else> ov="请输入关键字搜索开户行" onkeypress="if(event.keyCode==13)showBankInfo();"/>
								        <div style="width:50px;height:28px;margin-top:-27px;position:absolute;margin-left:210px;cursor:pointer;" onclick="showBankInfo()"></div>
								   	<ul id="bankInfo_ul"></ul>
								</td>
								<td>
									<div class="tips" >
										<p id="errorAccountBank" class="erro"></p>
									</div>
								</td>	
							</tr>
						</table>
					</div>
					<div class="claim_info claim_info_m" style="border:0;">
						<h3><b>附件信息：</b></h3>
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td align="right" width="220" valign="top"><span class="f_f15a22">*</span>身份证扫描件图片:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield01' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
										    <input type="file" name="upload" class="file_input" id="fileField_01" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield01').value=this.value"   /> 
									</div>
									<ul class="upload_annex">
									    <div id="fileField_01_showImg"></div>
									</ul>
									
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield01" class="erro"></p>
									</div>
								</td>						
							</tr>
							<tr>
								<td align="right" valign="top"><span class="f_f15a22">*</span>银行卡复印件:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield02' class='file_txt' placeholder=" 复印件需包含开户行信息" /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_02" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield02').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_02_showImg"></div>
									</ul>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield02" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right" valign="top"><span class="f_f15a22">*</span>到货签收凭证图:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield03' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_03" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield03').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_03_showImg"></div>
									</ul>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield03" class="erro"></p>
									</div>
								</td>							
							</tr>
							<tr>
								<td align="right" valign="top"><span class="f_f15a22">*</span>发票复印件图片:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield04' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_04" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield04').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_04_showImg"></div>
									</ul>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield04" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right" valign="top"><span id="danger_Type_2" class="f_f15a22">*</span>货物破损照片:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield05' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_05" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield05').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_05_showImg"></div>
									</ul>
								</td>
								<td></td>
							</tr>
							<%-- <tr>
								<td align="right" valign="top"><span id="isEntrust_y" class="f_f15a22">*</span>客户委托授权证明:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield06' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_06" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield06').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_06_showImg"></div>
									</ul>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield06" class="erro"></p>
									</div>
								</td>
							</tr> --%>
							<tr>
								<td align="right" valign="top"><span id="cusClaim_Money_1000" class="f_f15a22">*</span>客户委托授权证明/客户索赔函:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield07' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_07" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield07').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_07_showImg"></div>
									</ul>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield07" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right" valign="top"><span id="waybill_Money_1000" class="f_f15a22">*</span>发货运单图片:</td>
								<td>
									<div class="file_box">
											<input type='text' name='textfield' id='textfield08' class='file_txt' /> 
											<input type='button' class='file_btn' value='浏览...' /> 
											<input type="file" name="upload" class="file_input" id="fileField_08" size="28" accept="image/gif, image/jpeg, image/png" onchange="document.getElementById('textfield08').value=this.value" /> 
									</div>
									<ul class="upload_annex">
									  <div id="fileField_08_showImg"></div>
									</ul>
								</td>
								<td valign="top">
									<div class="tips">
										<p id="erroTextfield08" class="erro"></p>
									</div>
								</td>
							</tr>
							<tr>
							   <td></td>
							   <td align="left" colspan=2>
							       <div  class="tips" align="center">
									   <p id="errorMessageId" class="erro"></p>
									</div>	
							   </td>
							</tr>
						</table>
					</div>
						
					<div class="claim_btn">
						<a id="to_first" href="#" class="claim_btn_active">上一步</a>
						<a href="javascript:void(0)" class="claim_btn_active" id="saveDraft">存为草稿</a>
						<a href="javascript:void(0)" class="claim_btn_sav" id="saveSubmit">提交</a>
					</div>
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

<div class="easyDialog_wrapper" id="easyDialogWrapper" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>理赔协议
		</div>
    	<div class="lpxy_layer">
			<h2 class="f16 tc mb10">客户网上理赔规则</h2>

<p>理赔申请人应当仔细阅读本规则，并同意遵守本规则。使用后双方自动形成协议关系，并应当受本规则的约束。</p>
<p>一、目前，网上理赔仅适用于损失金额在人民币3000元以下的索赔。如果您的损失金额高于人民币3000元，请
与当地的天地华宇分公司联系办理索赔。</p>
<p>二、理赔申请人必须是该票货物的托运人或收货人，或者已经托运人、收货人特别委托授权的经办人。理赔申
情人必须如实申报各项信息，并提供客观、真实、完整的索赔材料。</p>
<p>三、理赔申请人所提出的索赔已包含了所有可能存在或发生的一切损失。</p>
<p>四、对于理赔申请人的索赔主张和材料，天地华宇有权查证核实，并依据如下不同标准核定最终的赔偿金额：</p>
<p>1、托运人声明保价并支付保价费情况下，如货物全部灭失，按货物保价金额赔偿；货物部分毁损或灭失，按保
价金额和损失比例赔偿，最高不超过保价金额。保价金额高于实际价值的，按实际价值赔偿。</p>
<p>2、未办理保价而发生货物毁损灭失的，在毁损灭失货物部分运费2倍的范围内赔偿。</p>
<p>五、代收货款金额不代表该票货物的实际价值，也不作为索赔的标准和依据。收货人签收后因货物品名、性质、
数量、型号不符等原因而不支付代收货款，天地华宇不承担代收货款无法收回的责任。</p>
<p>六、货运时效一般按照承运人的公布时效。时效不影响其他费用的结算和不可抗力免责权。</p>
<p>七、天地华宇对如下损失不承担赔偿责任：</p>
<p>1、因不可抗力（包括但不限于自然灾害、政府行为、战争等社会异常事件）造成货物损坏、短缺、灭失、污
染、变质或迟延交付；</p>
<p>2、因货物本身的自然性质、质量瑕疵或缺陷、合理损耗等造成的损失；</p>
<p>3、托运人自行包装或容器不良，但从外部无法发现；</p>
<p>4、托运人自行包装，到达时外包装完好而内件缺少或损坏；</p>
<p>5、承运人包装的非新品运输，外包装完好而内件缺少或损坏；</p>
<p>6、由于托运人或收货人的故意或过失导致损失；</p>
<p>7、承运过程中发生的一切间接损失（包括但不限于对所托运货物的收益、利润、实际用途、特殊商业价值）。</p>
<p>八、天地华宇核定最终赔偿金额并向理赔申请人支付赔偿金后，双方关于该票货物赔偿事宜结束。理赔申请
人保证并承诺托运人、收货人或其他权利人不再以任何理由向天地华宇主张任何权利。</p>
<p>九、天地华宇最终核定按全部保价金额向理赔申请人赔付的，天地华宇即取得所涉货物的追偿权和所有权。</p>
<p>十、丢失货物的赔偿，在天地华宇支付赔款之日起30日内，如货物被找到，天地华宇有权重新交付货物，理
申请人应将赔偿款退还天地华宇。</p>
<p>十一、天地华宇是指依法注册成立并经授权使用"天地华宇"商标的公司法人及其分公司。</p>
<p>十二、本规则自理赔申请人点击"同意并提交"后生效，即对理赔申请人具有法律约束力。如理赔申请人有赔
异议，可选择与当地的天地华宇分公司联系办理索赔。</p>
		</div>
		
	</div>
</div>



<script>
$(function(){	
	$("#demoBtn1").click(function(){
		easyDialog.open({
			container : 'easyDialogWrapper',
			fixed : true
		});
	});
});
function mtrmove(obj,s){  
    var evt = event || window.event;  
    if(s=='' || typeof(s)=='undefined'){  
        /* document.getElementById("ts").innerHTML = obj.innerHTML;   */
        document.getElementById("ts").innerHTML = "<p>友情提示：</p><p>如发货方申报，请填写运单上发货人的电话；</p><p color='red'>如收货方申报，请填写运单上收货人的电话。</p>";  
    }else{  
        document.getElementById("ts").innerHTML = s;  	
    }  
    document.getElementById("ts").style.display = '';  
}  
  
function mtrout(){  
    document.getElementById("ts").style.display = 'none';  
}
</script>
</body>
</html>
