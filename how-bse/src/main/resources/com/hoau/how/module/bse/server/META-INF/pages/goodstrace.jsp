<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>货物追踪</title>
<%@include file="head.jsp" %>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/goodstrace.js"></script>
<script type="text/javascript" src="${scripts}/common.js"></script>
<script type="text/javascript">
$(function(){
	var w = getCookie('importList');
	$("#importList").text(w);
	
	$(".subNav").click(function(){		
		$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
		// 修改数字控制速度， slideUp(500)控制卷起速度
		$(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
	})	
	$('.hwzz_b_cxjg').jtabs('.hwzz_b_list', {fx: 'fade', activeClass: 'active', event: 'click', initIdx: 0});
})
</script>
</head>

<body>
<%@include file="top.jsp" %>
<div class="content">
	<div class="p_w">
		<div class="col_left fl">
			<div class="content_second_nav">
				<h3>自助服务</h3>
				<ul>
					<li class="current"><a href="#">货物追踪</a></li>
					<li><a href="companyMatchAction!index.action">网点查询</a></li>					
					<li><a href="showPriceTime.action">价格/时效查询</a></li>
				</ul>
			</div>
			
		</div>
		<!-- start update huyuzhou 2016年3月3日14:56:55 -->
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/order_banner.jpg" width="770" /></div>
			<div class="hwzz_box">
			<!-- update huyuzhou 2016年3月8日09:52:50 -->
				<ul class="hwzz_box_tabs">
					<li><a href="javascript:void(0)" class="current" id="orderBtn">按运单号查询</a></li>
					<li><a href="javascript:void(0)" id="phoneBtn">按手机号查询</a></li>
				</ul>
				<input type="hidden" id="searchType" value="${searchType}"/>
				<input type="hidden" id="transNos" value="${transNos }"/>
				<input type="hidden" id="sendDateValue" value="${sendDate }"/>
				<div class="hwzz_box_content" id="phoneDiv" style="display: none;">
					<ul>
						<li>
							<dl class="clearfix">
								<dt><font color="red">*</font>手机号码</dt>
								<dd class="long"><input id="ebccMobile" type="text" value="<s:if test="ebccMobile!=null and ebccMobile!='' and ebccMobile !='null'"><s:property value="ebccMobile"/></s:if><s:else>请输入运单上的手机号码</s:else>" ov="请输入运单上的手机号码" class="input inputFocus grays" style="width:310px;" /></dd>
								<dd>
									<div class="tips" id="phone_tips">
										<c:if test="${errorType eq 'phone'}">
											${errorMsg}
										</c:if>
									</div>
								</dd>
							</dl>
							<div class="clearfix"></div>
						</li>
						<li>
							<dl class="clearfix">
								<dt>发货时间</dt>
								<dd class="long sel-date-input">
									<select name="" id="sendDate">
										<option value="">---请选择---</option>
									</select>
								</dd>
							</dl>
							<div class="clearfix"></div>
						</li>
						<li>
							<dl>
								<dt><font color="red">*</font>验证码</dt>
								<dd>
									<span>
										<input id="validateCode_search" name="" type="text" class="input mr10">
										<input type="button" id="getPhoneVerCodeBtn" disabled="disabled" class="btn_sub xz1" style="padding:0 10px;" value="获取验证码" onclick="sendPhoneVerCode()"/>
									</span>
								</dd>
							</dl>
							<div class="clearfix"></div>
						</li>
						<li>
							<div class="f_f15a22" style="height: 20px;">
									<span id="codePhoneNotice" style="display: inline;"><s:property value="errorMsg"/></span>
							</div>
						</li>
						<li>
							<div class="yzm_box" style="padding-left:87px;">
								<button type="button" id="wayPhoneQuery_btn" class="primary-button pull-left">查询</button>
							</div>
						</li>
					</ul>
				</div>
				<div class="dxqf_sms_list p10 fl" id="orderDiv">
					 <p class="f14">					
					  <textarea  id="waybillVale_input" class="textarea-no" wrap="virtual" onfocus="initval(1)" onblur="initval(2)"><s:if test="transNos!=null and transNos!='' and transNos !='null' and transNos != '在此输入运单号进行查询'"><s:property value="transNos"/></s:if><s:else>请输入单号,最多可同时查询10个运单,多单号间用回车或逗号隔开</s:else></textarea>
					</p>
						<div style="height: 42px;">
						    <div class="error" id="isOverMaxlength" data-error="limit-exceeded">您已输入超过10条运单号</div>
							<!-- <div class="error" data-error="bill-number-format">运单号只能为8位数字，且不能重复。</div>
							<div class="error" data-error="limit-exceeded">您已输入超过10条运单号，系统将自动截取并显示前10条运单号的追踪信息。</div> -->
						</div>
						<div class="yzm_box">
							<button type="button" id="wayBillQuery_btn"
								class="primary-button pull-left fr">查询</button>
							<span> <input id="validateCode_input" name="" type="text"
								class="mr10" /><img id="validateCode_img"
								src="genCheckCode.action" width="90" height="25" class="mr10"
								style="vertical-align: middle;" /><a
								href="javascript:changeCode();">换一组</a> <br />
								<div class="f_f15a22" style="height: 20px;">
									<span id="codeNotice" style="display: inline;"></span>
								</div>
							</span>
						</div>
					</div>
				<div class="fr import_user_panels" id="clearDiv">
					<p class="record-tit"><a id="clearQueryRecord" href="#" class="fr f_0b00ba">清空记录</a>最近查询的记录:</p>
					<div id="importList">
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- end update huyuzhou -->
			<div class="main-content-row content-page" id="cxxzDiv">
					<h3>查询须知</h3>
				  	<p>1、为了确保您的信息安全，目前仅提供发货人留有的手机号码的运单号查询</p>
				  	<p>2、目前仅提供交易完成后7天内的查询</p>
				  	<p>3、*号为必填项</p>
				</div>				
			<!-- end -->
			<div class="hwzz_b_info">
				<div class="hwzz_b_cxjg">
					<h3 id="cxjg">查询结果：<span style="font-color:red"><s:property value="message"/></span></h3>
					<s:if test="ydTraceList == null or ydTraceList.size == 0 " >
						<s:if test="searchType == 1 or isIndexSikp == 1">
							<p style="padding-left: 13px;">您好,暂无查询记录</p>
						</s:if>
						<s:elseif test="searchType == 2 and isIndexSikp != 1">
							<p style="padding-left: 13px;color: red;">很抱歉，暂未查询到与您提供的信息相匹配的运单号码，如需要获得更多的信息，请咨询华宇当地网点或致电400-808-6666。</p>
						</s:elseif>
					</s:if>
					<s:elseif test="errorMsg != null && errorMsg != ''">
						<p class='erro'><span class='icon_del'></span><s:property value="errorMsg"/></p>
					</s:elseif>
					<ul>
						<s:iterator var="trace" value="ydTraceList" status="s">
							<li><a href="#" <s:if test="#s.first">class="active"</s:if> ><s:property value="waybillNo"/></a></li>
						</s:iterator>
					</ul>
					<div class="clearfix"></div>
				</div>
				
				<s:iterator var="trace" value="ydTraceList">
					<div class="hwzz_b_list">
					<div class="log_de">
						<ul>
							<span class="log_b1"></span>
							
							<s:iterator value="traceInfos" var="traceinfo" status="s">
								<li <s:if test="#s.first">class="log_active"</s:if>>
									<dl>
										<dt><h4><s:property value="status"/></h4></dt>
										<dd>
											<p class="log_time"><s:property value="time"/></p>
											<p><s:property value="desc"/></p>
										</dd>
									</dl>
								</li>
							</s:iterator>
													
						</ul>
						<div class="clearfix"></div>
					</div>
				
					<div class="hwzz_b_hwjbxinfo">					
						<h3>货物基本信息：</h3>
						<p>
							<span>起运地：<s:property value="fromCity"/></span>
							<span>目的地：<s:property value="toCity"/></span>
						</p>
						<p>
							<span>运输方式：<s:property value="transMethod"/></span>
							<span>取货方式：<s:property value="pickUpMethod"/></span>
						</p>
						<p>
							<span>货物名称：<s:property value="goodsName"/></span>
							<span>件数：<s:property value="pieces"/></span>
						</p>
						<p>
							<span>重量：<s:property value="weight"/> </span>
							<span>体积：<s:property value="volume"/></span>
						</p>
						<c:if test="${!empty serviceType}">
							<p>
								<span>易安装服务方式：<s:property value="serviceType"/></span>
							</p>
						</c:if>
					</div>
					
					<div class="hwzz_b_hwjbxinfo">
						<h3>提货公司信息：</h3>
						<p>提货公司名称： <s:property value="pickUpCompanyName"/></p> 
						<p>提货公司电话： <s:property value="pickUpCompanyPhone"/></p> 
						<p>提货公司地址：<s:property value="pickUpCompanyAddress"/></p>
						<p>提货公司客服电话： <s:property value="customerServicePhone"/></p> 
					</div>
				</div>
				</s:iterator>
				<div class="hwzz_b_mail">
						<h3>将查询信息发送至邮箱：</h3>
						<input id="emails_input" name="" type="text" placeholder="请输入您要发送的邮箱地址" />
						<a id="send_email_link" href="javascript:void(0);" class="xz1">发送</a>
				</div>				
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="bottom.jsp" %>

<script data-main="${scripts}/main.js" src="${scripts}/require.js"></script>
<script type="text/javascript">
    require.config({
        waitSeconds: 0
    });
</script>
</body>
</html>
