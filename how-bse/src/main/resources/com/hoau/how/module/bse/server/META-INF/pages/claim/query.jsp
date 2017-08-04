<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的理赔</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
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
			 <div class="news_detail pb20">
			 <form action="queryclaim.action" method="post" id="queryClarmForm">	
				<h1 class="news_title">理赔查询</h1>
				<div class="order_search pt30">
					<label class="tr">理赔运单号：</label>
					<input id="queryBillNoId" name="claimSubmitEntity.billNo" type="text" class="input w135" 
						value="<s:if test="claimSubmitEntity.billNo != null and claimSubmitEntity.billNo !=''"><s:property value="claimSubmitEntity.billNo"/></s:if>"
					/>
					<label class="tr">理赔状态：</label>
					<span class="mr40">
						<select id="queryStatusId" name="claimSubmitEntity.status">
							<option value="all">全部</option>
							<option value="UN_SUBMIT" <s:if test="claimSubmitEntity.status == 'UN_SUBMIT'">selected="selected"</s:if>>未提交</option>
							<option value="-4" <s:if test='claimSubmitEntity.status == "-4"'>selected="selected"</s:if>>理赔金额待确认</option>
							<option value="-3" <s:if test='claimSubmitEntity.status == "-3"'>selected="selected"</s:if>>汇款中</option>
							<option value="-2" <s:if test='claimSubmitEntity.status == "-2"'>selected="selected"</s:if>>已退回</option>
							<option value="-1" <s:if test='claimSubmitEntity.status == "-1"'>selected="selected"</s:if>>审核中</option>
							<option value="0,1,3,5" <s:if test='claimSubmitEntity.status == "0,1,3,5"'>selected="selected"</s:if>>已受理</option>
							<option value="2" <s:if test='claimSubmitEntity.status == "2"'>selected="selected"</s:if>>已作废</option>
							<option value="6,8" <s:if test='claimSubmitEntity.status == "6,8"'>selected="selected"</s:if>>已完成</option>
							<option value="7" <s:if test='claimSubmitEntity.status == "7"'>selected="selected"</s:if>>理赔单作废</option>
						</select>
					</span>
					<input id="queryClaim" name="" type="button" value="查询" class="xz1" />
				</div>
				</form>
				<s:if test="paging.rowsCount != null and paging.rowsCount>0">
				<div class="consignee_list pt30">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="7%">序 号</td>
							<td width="13%">运单编号</td>
							<td width="13%">理赔受理号</td>
							<td width="10%">理赔人</td>
							<td width="10%">索赔金额</td>
							<td width="10%">理赔状态</td>
							<td width="20%">申请时间</td>
							<td width="17%">操 作</td>
						</tr>
						<s:iterator  value="paging.data" status="st">
							<tr>
							<td width="7%"><s:property value="#st.count"/></td>
							<td width="13%"><s:property value="billNo"/></td>
							<td width="13%"><s:property value="claimNo"/></td>
							<td width="10%"><s:property value="contactName"/></td>
							<td width="10%">
								<s:if test='claimsAmount != null and claimsAmount !="0"'><s:property value="claimsAmount"/></s:if>
							</td>
							<td width="10%">
								<s:property value="status"/>
								
							</td>
							<td width="20%">
								<s:if test='modifyTime !=null'><s:date name="modifyTime" format="yyyy-MM-dd HH:mm:ss"/></s:if>
								<s:else><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/></s:else>
							</td>
							<s:if test="status == '未提交'">
								<td width="17%">
									<a href="#" onclick="viewUnSubmit('<s:property value="billNo"/>')">查看</a>
									<a href="#" onclick="updateClaimRecord('<s:property value="billNo"/>')">修改</a>
									<a href="#" onclick="delClaimRecord('<s:property value="billNo"/>')">删除</a>
								</td>
							</s:if>
							<s:else>
								<td width="17%">
									<a href="#" onclick="view('<s:property value="billNo"/>','<s:property value="claimNo"/>')">查看</a>
									<s:if test="showmodifyBtn == true"><a href="#" onclick="remodify('<s:property value="billNo"/>','<s:property value="claimNo"/>')">修改</a></s:if>
									<s:if test='status == "理赔金额待确认"'><a href="#" onclick="claimAmountConfirm('<s:property value="claimNo"/>')">理赔金额确认</a></s:if>
								</td>
							</s:else>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div class="scott mt15">					
					<w:pager pageSize="${paging.pageSize}" pageNo="${paging.pageNo}" url="queryclaim.action" recordCount="${paging.rowsCount}" />
				</div>
			</s:if>
			<s:else>
			   <div>
			     <p  style="padding: 0 1px 0 15px;padding-top: 15px;">您好,暂无查询记录</p>
			   </div>
			</s:else>
				
				
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
					<%-- <tr>
						<td align="right">理赔方：</td>
						<td>
							<span id="claimSubmitEntity.claimParty"></span>
						</td>
					</tr> --%>
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
			<!-- 理赔银行卡开户信息，田育林，2016-06-13 -->
			<div class="Order_layer_box" style="line-height: 30px;">
				<p class="mb5"><b>开户行信息</b></p>
			
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="180" align="right">开户名：</td>
						<td><span id="claimSubmitEntity.accountName"></span></td>
					</tr>
					<tr>
						<td align="right">银行账号：</td>
						<td><span id="claimSubmitEntity.accountCode"></span></td>
					</tr>
					<tr>
						<td align="right">开户行所在省市：</td>
						<td><span id="claimSubmitEntity.accountCity"></span></td>
					</tr>
					<tr>
						<td align="right">开户行名称：</td>
						<td><span id="claimSubmitEntity.accountBank"></span></td>
					</tr>
				</table>
			</div>
			<!-- --------------end-------------- -->
			<div class="Order_layer_box">
				<p class="mb5"><b>附件信息</b></p>
				<div id="gallery">
				    <ul id="allImage">
				    <!-- 所有附件   <li>
				            <a href="${images }/image1.jpg">
				                <img src="${images }/thumb_image1.jpg" width="72" alt="" />
				            </a>
				        </li>
				        <li>
				            <a href="${images }/image2.jpg">
				                <img src="${images }/thumb_image2.jpg" width="72" alt="" />
				            </a>
				        </li>
				         -->
				       
				    </ul>
				    <div class="clearfix"></div>
				</div>
			</div>
			<div class="Order_layer_box" style="border:0">
				<p class="mb5"><b>历史记录</b></p>
				<div class="consignee_list pt10" id="operationRecord">
<%-- 					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="16%">日期</td>
							<td width="14%">时间</td>
							<td width="35%">状态</td>
							<td width="35%">操作说明</td>
						</tr>
						<tr>
							<td>2015-09-02</td>
							<td>10:09</td>
							<td>你所申请的理赔金额已确认</td>
							<td><span class="mr5">赔偿金额:同意</span><span>审批意见:同意</span></td>
						</tr>
					</table> --%>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 提示框 -->
<div class="easyDialog_wrapper" id="calimAmount">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>理赔金额确认
		</div>
    	<div class="del_consignee tc" style="width:380px;">
			<div class="aui_icon aui_icon_q"></div>
			<div class="aui_content" style="padding: 20px;">是否理赔金额确认?</div>
		</div>
		<div class="easyDialog_footer">
			<a href="#" id="claim_btn_confirm" class="btn_highlight">确定</a> 
			<a href="#" class="btn_normal" onclick="easyDialog.close();">取消</a>
			<!-- <input type="submit" class="btn_highlight" value="新增"/>
			<input type="reset" class="btn_normal" value="重置"/> --> 
		</div>
	</div>
</div>


<!-- 提示框 -->
<div class="easyDialog_wrapper" id="calimDel">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>理赔删除
		</div>
    	<div class="del_consignee tc" style="width:380px;">
			<div class="aui_icon aui_icon_q"></div>
			<div class="aui_content" style="padding: 20px;">是否删除理赔草稿?</div>
		</div>
		<div class="easyDialog_footer">
			<a href="#" id="claim_btn_del" class="btn_highlight">确定</a> 
			<a href="#" class="btn_normal" onclick="easyDialog.close();">取消</a>
			<!-- <input type="submit" class="btn_highlight" value="新增"/>
			<input type="reset" class="btn_normal" value="重置"/> --> 
		</div>
	</div>
</div>

<script type="text/javascript" src="${scripts}/toolbar.js"></script>
<script>
$(function(){
	
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
