<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>理赔金额确认</title>
<link rel="stylesheet" href="${styles}/claimSMS/jquery.mobile-1.4.5.min.css">
<link href="${styles}/claimSMS/master.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${scripts}/claimSMS/jquery.min.js"></script>
<script type="text/javascript" src="${scripts}/claimSMS/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/claimSMS/claimSMS.js"></script>
</head>

<body>
<div data-role="page" id="claim">
	<div id="wrapper">
		<div class="header">
			<h1><a href="#"><img src="${images}/hoaulogo.png" alt=""></a></h1>
		</div>
		<div class="claim_box">
			<h2>理赔方案的确认</h2>
			<p>索赔人：${claimSubmitEntity.contactName }</p>
			<p>理赔金额：${claimSubmitEntity.claimsAmount }</p>
			<p>索赔人联系电话：${claimSubmitEntity.contactTel }</p>
			<p>运单编号：${claimSubmitEntity.billNo }</p>
			<p>理赔受理号：${claimSubmitEntity.claimNo }</p>
			<p>申请时间：<s:date name="claimSubmitEntity.createTime" format="yyyy-MM-dd HH:mm:ss"/></p>
			<p>理赔原因及其他：${claimSubmitEntity.reason }</p>
			<div id="btnDiv" class="tc sui-btn" style="border:0;">
				<a href="#dialog_ok" class="ui-btn" onclick="claimAmountConfirmSMS('<s:property value="claimSubmitEntity.claimNo"/>')" id="confirm_btn" >同意</a>
				<a href="#dialog_no" class="ui-btn" onclick="refuseClaimsAmount('<s:property value="claimSubmitEntity.claimNo"/>')" id="refuse_btn" >不同意</a>
			</div>
		</div>
	</div>
</div>

<div data-role="dialog" id="dialog_ok" data-close-btn="right">  
	<div data-role="header">
		<h1 id="dialg_header">提示</h1>
	</div>  
    <div data-role="content" class="error_info">
		<p>尊敬的客户：</p> 
		<p>　　您申请的理赔单，已确认成功，我司会继续进行赔付工作</p>
    </div>
</div>

<div data-role="dialog" id="dialog_no"  data-close-btn="right">
	<div data-role="header">
		<h1 id="dialg_header">提示</h1>
	</div>    
    <div data-role="content" class="error_info">
		<p>尊敬的客户：</p> 
		<p>　　鉴于您不同意我公司提供的理赔方案，请您速联系我公司工作人员，退回线上理赔申请，并通过其他合法途径处理。否则我公司将在4个小时后自动退回您的线上理赔申请。</p>
    </div>
</div>

</body>
</html>
