<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的运单</title>
<%@include file="../head.jsp"%>
<script language="javascript" type="text/javascript"
	src="${scripts}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/waybill/myWaybills.js"></script>
<script type="text/javascript">
	$(function() {$(".subNav").click(function() {
					$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
					// 修改数字控制速度， slideUp(500)控制卷起速度
					$(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
				})
	});
</script>
</head>
<body>
	<%@include file="../top.jsp"%>

	<div class="content">
		<div class="p_w">
			<%@include file="../obh_nav.jsp"%>
			<div class="col_right fr">
				<div class="drd_pic"><img src="${images}/my_banner.jpg" width="770" /></div>
				<div class="news_detail pb20">
					<h1 class="news_title">我的运单</h1>

					<div class="waybill_search01">
					<form action="myWaybillsAction!queryWaybillsByCondititons.action" method="post" id="queryForm">	
							<table border="0" cellspacing="0" cellpadding="0" width="100%">
								<tr>
									<td width="100" align="right">关键字：</td>
									<td width="278"><select id="fieldType"
										class="field" name="fieldType">
											<option value="TRANS_NO" <s:if test="fieldType == 'TRANS_NO'">selected="selected"</s:if>>运单号</option>
											<option value="CONSIGNEE" <s:if test="fieldType == 'CONSIGNEE'">selected="selected"</s:if>>收货人</option>
											<option value="CARGO_NAME" <s:if test="fieldType == 'CARGO_NAME'">selected="selected"</s:if>>货物名称</option>
									</select> 
									 <s:elseif test=""></s:elseif>
									<input id="fieldValue" name="fieldValue" type="text"
										class="input w125 inputFocus grays" 
										<s:if test="fieldValue != null or fieldValue != ''">value="${fieldValue}"</s:if>
										<s:elseif test="fieldType == 'TRANS_NO'">value="请输入运单号"</s:elseif>
										<s:elseif test="fieldType == 'CONSIGNEE'">value="请输入收货人"</s:elseif>
										<s:elseif test="fieldType == 'CARGO_NAME'">value="请输入货物名称"</s:elseif>			
										 />
									</td>
									<td width="100" align="right">付款方式：</td>
									<td>
									<select id="paymentWay" name="queryVo.queryWaybillEntity.paymentWay">
											<option value="">全部</option>
											<option value="CASH" <s:if test="queryVo.queryWaybillEntity.paymentWay == 'CASH'">selected="selected"</s:if>>现付</option>
											<option value="ARRIVE_PAYMENT" <s:if test="queryVo.queryWaybillEntity.paymentWay == 'ARRIVE_PAYMENT'">selected="selected"</s:if>>到付</option>
											<option value="Monthly_Statement" <s:if test="queryVo.queryWaybillEntity.paymentWay == 'ARRIVE_PAYMENT'">selected="selected"</s:if>>月结</option>
									</select>
									</td>
									<td></td>
								</tr>
								<tr>
									<td align="right">时间范围：</td>
									<td>
									
									<s:if test=""></s:if>
									
									<input id="startTime" type="text"
									    value="${queryVo.queryWaybillEntity.startQueryTime}" 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd', onpicked:function(){endTime.focus();},maxDate:'#F{$dp.$D(\'endTime\')||\'%y-%M-%d\'}'})"
										name="queryVo.queryWaybillEntity.startQueryTime" readonly="readonly" class="input w125 sel_time_input" /> - 
										<input id="endTime" type="text" 
										value="${queryVo.queryWaybillEntity.endQueryTime}" 
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'#F{$dp.$D(\'startTime\')}',maxDate:fmtzCurDate()})"
									    name="queryVo.queryWaybillEntity.endQueryTime" readonly="readonly" class="input w125 sel_time_input" /></td>
									<td align="right">物流状态：</td>
									<td>
										<select id="logisticsStatus" name="queryVo.queryWaybillEntity.logisticsStatus">
												<option value="">全部</option>
												<option value="UNDELIVER" <s:if test="queryVo.queryWaybillEntity.logisticsStatus!=null and queryVo.queryWaybillEntity.logisticsStatus != '' 
												        and queryVo.queryWaybillEntity.logisticsStatus != 'DELIVER' 
												        and queryVo.queryWaybillEntity.logisticsStatus != 'SENDFAIL'">
												selected="selected"</s:if>>未签收</option>
												<option value="DELIVER" <s:if test="queryVo.queryWaybillEntity.logisticsStatus == 'DELIVER'">selected="selected"</s:if>>已签收</option>
												<option value="SENDFAIL" <s:if test="queryVo.queryWaybillEntity.logisticsStatus == 'SENDFAIL'">selected="selected"</s:if>>签收失败</option>
										</select>
										<input id="logisticsStatusReback" value="${queryVo.queryWaybillEntity.logisticsStatus}"  type="hidden" />
									</td>
									<td><input id="queryWaybill" name="queryWaybill"
										type="button" value="查询" class="xz1" /></td>
								</tr>


							</table>
						</form>
						<p style="padding-left: 30px;">						
							默认加载最近一个月的订单，如需查看<span class="f_f15a22" style="cursor: pointer;">一个月前的订单</span>，请使用时间范围搜索
						</p>
					</div>

					<div class="waybill_none">
						<h3>
							<span class="f16">运单信息：</span>
						</h3>
						<s:if test="queryVo.waybillResultEntitys == null or queryVo.waybillResultEntitys.size == 0">
                        	<p>您好,暂无查询记录</p>
                        </s:if>
					</div>
					
				<s:if test="queryVo.waybillResultEntitys != null and queryVo.waybillResultEntitys.size>0">
					<div class="consignee_list">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
								<tr>
									<td width="16%">订单号</td>
									<td width="10%">运单号</td>
									<td width="17%">下单日期</td>
									<td width="12%">收货人</td>
									<td width="13%">货物名称</td>
									<td width="7%">件数</td>
									<!-- <td width="10%">总费用(元)</td> -->
									<td width="8%">物流状态</td>
									<td width="7%">操 作</td>
								</tr>
							<s:iterator value="queryVo.waybillResultEntitys">
								<tr>
								    <td width="16%">${orderNo}</td>
									<td width="10%">${transNo}</td>
									<td width="16%">${orderDate}</td>
									<td width="9%">${consignee}</td>
									<td width="15%">${goodsName}</td>
									<td width="7%">${pieces}</td>
									<%-- <td width="10%">${chargeTotal}</td> --%>
									<td width="10%">
									    <s:if test="status == 'DELIVER'">已签收</s:if>
										<s:elseif test="paymentWay == 'SENDFAIL'">签收失败</s:elseif>
									    <s:else>未签收</s:else>
									</td>						
									<td width="9%">
											<a href="javascript:void(0)" onclick="showWaybill('${transNo}')">查看</a>			
									</td>
								</tr>
							</s:iterator>
						</table>
						<w:pager pageSize="${pageSize}" pageNo="${pageNo}" url="myWaybillsAction!queryWaybillsByCondititons.action"
						recordCount="${totalCount}" />
					</div>
				</s:if>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<%@include file="../bottom.jsp"%>

 <div class="easyDialog_wrapper" id="easyDialogWrapper" style="width: 700px;">
		<div class="from_wrapper">
			<div class="from_wrapper_t" style="margin-bottom:0;">
				<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>运单详情
			</div>
			<s:if test="queryVo.waybillResultEntitys != null and queryVo.waybillResultEntitys.size>0">
			</s:if>
			<s:iterator var="trace" value="queryVo.waybillResultEntitys">
				<div class="hwzz_b_list" style="overflow:auto;height:500px;" id=<s:property value='goodsTraceResult.waybillNo'/>>
					 <s:if test="goodsTraceResult.goodsName == null or goodsTraceResult.goodsName ==''">
			             <div class="hwzz_b_info tc" style="padding:60px 0 0 0px;">
			             	<p>您好,暂无该运单详细信息</p>
			             </div>
				     </s:if>
				     <s:else>
				        <div class="hwzz_b_info" style="padding:0 0 0 30px;">
						<div class="hwzz_b_hwjbxinfo">					
							<h3>货物基本信息：</h3>
							<p>
								<span>出发城市：<s:property value="goodsTraceResult.fromCity"/></span>
								<span>到达城市：<s:property value="goodsTraceResult.toCity"/></span>
							</p>
							<p>
								<span>运输方式：<s:property value="goodsTraceResult.transMethod"/></span>
								<span>取货方式：<s:property value="goodsTraceResult.pickUpMethod"/></span>
							</p>
							<p>
								<span>货物名称：<s:property value="goodsTraceResult.goodsName"/></span>
								<span>件数：<s:property value="goodsTraceResult.pieces"/></span>
							</p>
							<p>
								<span>重量：<s:property value="goodsTraceResult.weight"/> </span>
								<span>体积：<s:property value="goodsTraceResult.volume"/></span>
							</p>
						</div>
						
						<div class="hwzz_b_hwjbxinfo">
							<h3>提货公司信息：</h3>
							<p>提货公司名称： <s:property value="goodsTraceResult.pickUpCompanyName"/></p> 
							<p>提货公司电话： <s:property value="goodsTraceResult.pickUpCompanyPhone"/></p> 
							<p>提货公司地址：<s:property value="goodsTraceResult.pickUpCompanyAddress"/></p>
							<p>提货公司客服电话： <s:property value="goodsTraceResult.customerServicePhone"/></p> 
						</div>
					</div>
					<div class="log_de" style="padding-left: 33px;">
						<ul>
							<span class="log_b1"></span>
							<s:iterator value="goodsTraceResult.traceInfos" var="traceinfo" status="s">
								<li <s:if test="#s.first">class="log_active"</s:if>>
									<dl>
										<dt><h4><s:property value="status"/></h4></dt>
										<dd style="width:470px;">
											<p class="log_time"><s:property value="time"/></p>
											<p><s:property value="desc"/></p>
										</dd>
									</dl>
								</li>
							</s:iterator>
													
						</ul>
						<div class="clearfix"></div>
					</div>
				     </s:else>
				</div>
			</s:iterator>

		</div>
	</div>
</body>
</html>
