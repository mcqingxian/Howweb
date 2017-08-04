<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>理赔综合查询</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/claim.js"></script>
<script type="text/javascript" src="${scripts}/jquery.lightbox-0.5.min.js"></script>
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

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/my_banner.jpg" width="770" /></div>
			 <div class="news_detail pb20 pr">
				<h1 class="news_title">理赔说明</h1>
				
				<div class="p20 f12 pr">
					<p class="mb5">如果您是新用户请点击"我要理赔"，注册后，即可申请3000元以下理赔。</p>
					<p class="mb5">如果您已经是注册用户，请在登录后点击理赔申请，即可申请3000元以下理赔。</p>
					<p>官方APP可申请1000元以下理赔，详情可下载最新官方APP注册登录后进行申请。</p>
					
					<a href="#" class="xz1 pa" style="bottom:20px; right:79px;width:90px; text-align:center; padding:0;">我要理赔</a>
				</div>
				
				<h1 class="news_title">理赔综合查询<span class="f14">(针对天地华宇所有理赔)</span></h1>
				<div class="">
					<div class="border-all">
						<div class="order_search01 f12">
							<form action="">
								<table border="0" cellspacing="0" cellpadding="0" width="100%">
									<tbody><tr>
										<td width="100" align="right">运单起始地：</td> 
										<td width="150">
											<input name="" type="text" class="input w135 inputFocus grays" ov="请输入运单起始地" value="请输入运单起始地">
											
										</td>
										<td width="100" align="right">运单目的地：</td>
										<td width="250">
											<input name="" type="text" class="input w135 inputFocus grays" ov="请输入运单目的地" value="请输入运单目的地">
										</td>
										<td></td>
									</tr>
									<tr>
										<td align="right"> 运单号：</td>
										<td>
											<input type="text" name="" class="input w135 inputFocus grays" ov="请输入运单号" value="请输入运单号">	
										</td>
										<td align="right">验证码：</td>
										<td>
											<input name="" id="validateCode_input" class="input" style="width:70px;" type="text">
											<img id="validateCode_img" src="genCheckCode.action" width="90" height="28" style="vertical-align: middle;">
											<a href="javascript:changeCode();">换一组</a>
										</td>
										<td><input id="queryOrders" name="" type="button" value="查询" class="xz1" style="width:90px; text-align:center; padding:0;"></td>
									</tr>
								</tbody></table>
							</form>
						</div>
						<div class="consignee_list p10 pt20">
							<table border="0" cellspacing="0" cellpadding="0" width="100%">
								<tbody>
									<tr>
										<td width="15%">运单编号</td>
										<td width="15%">理赔受理号</td>
										<td width="10%">理赔人</td>
										<td width="10%">索赔金额</td>
										<td width="20%">理赔状态</td>
										<td width="20%">申请时间</td>
										<td width="10%">明细</td>
									</tr>
									<tr>
										<td>F1234567</td>
										<td>00111942</td>
										<td>理赔人</td>
										<td>3000</td>
										<td>系统受理中</td>
										<td>2015-09-02 15:33:59</td>
										<td><a href="javascript:void(0)" id="demoBtn01">查看</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="pt10 f12"> *运单起始地和运单结束地说明： 运单起始地指华宇公司划分的发货所在地，结束地指华宇公司划分的目的地所在城市，如上海201发往北京28的货物，运单起始地、结束地分别为上海、北京。</div>
				</div>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>

<div class="easyDialog_wrapper" id="easyDialogWrapper" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>理赔详情

		</div>
    	<div class="Order_layer" id="Order_layer_m">
			<div class="Order_layer_box" style="line-height: 30px;">
				<p class="mb5"><b>理赔单申请信息</b></p>
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="180" align="right">理赔运单编号：</td>
						<td><span id="claimSubmitEntity.billNo"></span></td>
					</tr>
					<tr>
						<td align="right">理赔方：</td>
						<td>
							<span id="claimSubmitEntity.claimParty"></span>
						</td>
					</tr>
					<tr>
						<td align="right">运单上联系电话：</td>
						<td><span id="claimSubmitEntity.billTel"></span></td>
					</tr>
					<tr>
						<td align="right">理赔公司所在地：</td>
						<td><span id="claimSubmitEntity.claimCompanyAddr"></span></td>
					</tr>
				</table>
			</div>
			<div class="Order_layer_box" style="line-height: 30px;">
				<p class="mb5"><b>理赔基础信息</b></p>
			
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="180" align="right">索赔人姓名或公司名称：</td>
						<td><span id="claimSubmitEntity.contactName"></span></td>
					</tr>
					<tr>
						<td align="right">索赔人联系电话：</td>
						<td><span id="claimSubmitEntity.contactTel"></span></td>
					</tr>
					<tr>
						<td align="right">索赔人邮箱：</td>
						<td><span id="claimSubmitEntity.contactMail"></span></td>
					</tr>
					<tr>
						<td align="right">索赔金额：</td>
						<td><span id="claimSubmitEntity.claimsAmount"></span></td>
					</tr>
					<tr>
						<td align="right">货物类型：</td>
						<td><span id="claimSubmitEntity.cargoType"></span></td>
					</tr>
					<tr>
						<td align="right">异常件数：</td>
						<td><span id="claimSubmitEntity.exceptionCount"></span></td>
					</tr>
					<tr>
						<td align="right">出险类型：</td>
						<td><span id="claimSubmitEntity.accidentType"></span></td>
					</tr>
					<tr>
						<td align="right">理赔原因及其他：</td>
						<td><span id="claimSubmitEntity.reason"></span></td>
					</tr>
				</table>
			</div>
			<div class="Order_layer_box">
				<p class="mb5"><b>附件信息</b></p>
				<div id="gallery">
				    <ul id="allImage">
				    </ul>
				    <div class="clearfix"></div>
				</div>
			</div>
			<div class="Order_layer_box" style="line-height: 30px;">
				<p class="mb5"><b>历史记录</b></p>
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="25%">时间</td>
						<td width="35%">状态</td>
						<td width="40%">操作说明</td>
					</tr>
					<tr>
						<td>2015-09-02 10:09</td>
						<td>您所申请的理赔金额已确认</td>
						<td>理赔金额：800  审批意见：同意</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="${scripts}/toolbar.js"></script>
<script>
$(function(){
	$("#demoBtn01").click(function(){
		easyDialog.open({
			container : 'Dialog_tips',
			fixed : true
		});
	});
	$(function(){
		$.each($(".inputFocus"),function(index,input){
			   if($(input).val()==$(input).attr("ov")){
				   $(input).addClass("grays");		
			   }
		});
	});
	$(".inputFocus").live("focus",function(){
		var ov=$.trim($(this).attr("ov"));
		var val=$.trim($(this).val());
		$(this).removeClass("grays");
		if(val==ov){
			$(this).val("");
		}

	});
 	$(".inputFocus").live("blur",function(){
		var ov=$.trim($(this).attr("ov"));
		var val=$.trim($(this).val());
		if(val==""){
			$(this).val(ov).addClass("grays");
		}
	 });
});
</script>
</body>
</html>
