<%@page language="java" import="java.net.URLDecoder" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>个人资料管理</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/user/personalData.js"></script>
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
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="../obh_nav.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/my_banner.jpg" width="770" /></div>
			<div class="news_detail pb20">				
				<h1 class="news_title">个人资料管理</h1>
				<div class="profile_login">
					<div class="profile_tit"><i class="profile_tit_icon01"></i>账户信息</div>
					<p>
						登录用户：<s:if test="#session.USER_INFO.ebccContactName != null && #session.USER_INFO.ebccContactName != \"\"">
							<s:property value="#session.USER_INFO.ebccContactName"/>
						</s:if>
						<s:elseif test="#session.USER_INFO.ebccNetLogin != null && #session.USER_INFO.ebccNetLogin != \"\"">
							<s:property value="#session.USER_INFO.ebccNetLogin"/>
						</s:elseif>
						<s:elseif test="#session.USER_INFO.ebccMobile != null && #session.USER_INFO.ebccMobile != \"\"">
							<s:property value="#session.USER_INFO.ebccMobile"/>
						</s:elseif>
					</p>
					<p>上次登录时间：<s:property value="#request.entity.modifyTime"/> 　　　若您的登录信息与实际不符，建议您及时<a href="personalDataAction!resetPassword.action" class="f_f15a22">修改密码</a></p>
				</div>
				<div class="profile_info">
					<div class="profile_tit"><i class="profile_tit_icon02"></i>基本信息</div>
					<form action="personalDataAction!modifyPersonalData.action" method="post" id="personDataForm">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td width="138" align="right"><span class="f_f15a22">*</span>用户名：</td>
								<td width="325">
									<input id="entity.ebccNetLogin" name="entity.ebccNetLogin" type="text" 
									<s:if test="#request.entity.ebccNetLogin != null and #request.entity.ebccNetLogin != \"\"">class="input w250 inputFocus"</s:if>
									<s:else>class="input w250 inputFocus grays"</s:else> 
									<s:if test="#request.entity.ebccNetLogin != null and #request.entity.ebccNetLogin != \"\"">value='<s:property value="#request.entity.ebccNetLogin"/>' </s:if>
									<s:else>value="请输入用户名"</s:else> ov="请输入用户名" /></td>
								<td>
									<div class="tips" id="loginName_tips">
										<c:if test="${errorType eq 'userName'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>姓名：</td>
								<td>
									<input id="entity.ebccContactName" name="entity.ebccContactName" type="text" 
										<s:if test="#request.entity.ebccContactName != null and #request.entity.ebccContactName != \"\"">class="input w250 inputFocus"</s:if>
										<s:else>class="input w250 inputFocus grays"</s:else> 
										<s:if test="#request.entity.ebccContactName != null and #request.entity.ebccContactName != \"\"">value='<s:property value="#request.entity.ebccContactName"/>' </s:if>
										<s:else>value="请输入姓名"</s:else> ov="请输入姓名" />
								</td>
								<td>
									<div class="tips" id="contactName_tips">
										<c:if test="${errorType eq 'contactName'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">性别：</td>
								<td>
									<label class="mr10">
										<input type="radio" name="entity.ebccSex" class="mr5" value="男" <s:if test="#request.entity.ebccSex == \"男\"">checked="checked"</s:if>/>男</label>
									<label>
										<input type="radio" name="entity.ebccSex" class="mr5" value="女" <s:if test="#request.entity.ebccSex == \"女\"">checked="checked"</s:if>/>女</label>
								</td>
								<td>
									<div class="tips" id="sex_tips">
										<c:if test="${errorType eq 'sex'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">公司：</td>
								<td>
									<input id="entity.ebccCompany" name="entity.ebccCompany" type="text" 
										<s:if test="#request.entity.ebccCompany != null and #request.entity.ebccCompany != \"\""> class="input w250 inputFocus" </s:if>
										<s:else> class="input w250 inputFocus grays" </s:else> 
										<s:if test="#request.entity.ebccCompany != null and #request.entity.ebccCompany != \"\"">value='<s:property value="#request.entity.ebccCompany"/>' </s:if>
										<s:else>value="请输入公司全称"</s:else> ov="请输入公司全称" />
								</td>
								<td>
									<div class="tips" id="company_tips">
										<c:if test="${errorType eq 'company'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">固定电话：</td>
								<td>
									<input id="entity.ebccTel" name="entity.ebccTel" type="text" 
										<s:if test="#request.entity.ebccTel != null and #request.entity.ebccTel != \"\"">class="input w250 inputFocus" value='<s:property value="#request.entity.ebccTel"/>' </s:if>
										<s:else> class="input w250 inputFocus grays" value="固话格式为：xxx-xxxxxxx-xxx"</s:else> ov="固话格式为：xxx-xxxxxxx-xxx" />
								</td>
								<td>
									<div class="tips" id="tel_tips">
										<c:if test="${errorType eq 'tel'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>手机号：</td>
								<td>
									<div id="modify_mobile_div" <s:if test="#request.errorType != \"mobile\"">style="display:none;"</s:if>>
										<input style="width:100px;" id="entity.ebccMobile" name="entity.ebccMobile" 
											type="text" 
											<s:if test="#request.entity.ebccMobile != null and #request.entity.ebccMobile != \"\"">class="input w250 inputFocus" value='<s:property value="#request.entity.ebccMobile"/>' </s:if>
											<s:else> class="input w250 inputFocus grays" value="请输入11位手机号码"</s:else> ov="请输入11位手机号码"/>
										<input id="phoneVerCode" name="phoneVerCode" type="text" class="input w95 inputFocus grays" value="请输入验证码" ov="请输入验证码" />
										<input type="button" id="getPhoneVerCodeBtn" disabled="disabled" class="btn_sub xz1" style="padding:0 10px;" value="获取验证码" onclick="sendPhoneVerCode()"/>
									</div>
									<div id="show_mobile_div" <s:if test="#request.errorType == \"mobile\"">style="display:none;"</s:if>>
										<span class="mr10"><s:property value="#request.entity.ebccMobile"/></span><a href="javascript:$('#show_mobile_div').hide();$('#modify_mobile_div').show()" class="f_f15a22">修改</a>
									</div>
								</td>
								<td>
									<div class="tips" id="mobile_tips">
										<c:if test="${errorType eq 'mobile'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">邮箱地址：</td>
								<td><input id="entity.ebccEmail" name="entity.ebccEmail" type="text" 
									<s:if test="#request.entity.ebccEmail != null and #request.entity.ebccEmail != \"\"">class="input w250 inputFocus"</s:if>
									<s:else>class="input w250 inputFocus grays"</s:else> 
									<s:if test="#request.entity.ebccEmail != null and #request.entity.ebccEmail != \"\"">value='<s:property value="#request.entity.ebccEmail"/>' </s:if>
									<s:else>value="建议填写，便于找回密码时使用"</s:else> ov="建议填写，便于找回密码时使用" />
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
								<td align="right" valign="top"><span class="f_f15a22">*</span>所在省市：</td>
								<td>
									<p class="mb10">
									<input id="entity.ebccDistrict"  autocomplete="off" type="text" 
										<s:if test="#request.entity.ebccDistrict == null or #request.entity.ebccDistrict == \"\"">class="w135 input grays send_input proCityQueryAll proCitySelAll inputFocus" </s:if>
										<s:else>class="w135 input send_input proCityQueryAll proCitySelAll inputFocus" </s:else> 
										name="entity.ebccDistrict" ov="请选择所在省市"<s:if test="#request.entity.ebccDistrict == null or #request.entity.ebccDistrict == \"\""> value="请选择所在省市" </s:if>
										<s:else> value="<s:property value="#request.entity.ebccDistrict"/>"</s:else> />—<input id="entity.ebccAddress" name="entity.ebccAddress" class="w135 input inputFocus" type="text" <s:if test="#request.entity.ebccAddress != null and #request.entity.ebccAddress != \"\""> value='<s:property value="#request.entity.ebccAddress"/>' </s:if>/></p>
								</td>
								<td>
									<div class="tips" id="district_tips">
										<c:if test="${errorType eq 'district'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right" valign="top">发货备注：</td>
								<td>
									<input id="entity.ebccRemark" name="entity.ebccRemark" type="text" 
										<s:if test="#request.entity.ebccRemark != null and #request.entity.ebccRemark != \"\"">class="input w250 inputFocus"</s:if>
										<s:else>class="input w250 inputFocus grays"</s:else> <s:if test="#request.entity.ebccRemark != null and #request.entity.ebccRemark != \"\"">value='<s:property value="#request.entity.ebccRemark"/>' </s:if>
										<s:else>value="地址备注（比如xx路口，附近），非必填"</s:else> ov="地址备注（比如xx路口，附近），非必填" />
								</td>
								<td>
									<div class="tips" id="remark_tips">
										<c:if test="${errorType eq 'remark'}">
											${errorMsg}
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<div class="tips" id="success_tips">
										<%
											String msg = "";
											try{
												Object obj = request.getParameter("errorMsg");
												if(obj != null){
													String errorMsg = obj.toString();
													msg = URLDecoder.decode(errorMsg);
												}
											}catch(Exception ex){
												ex.printStackTrace();
											}
										%>
										<%= msg %>
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td>
									<input onclick="saveInfo();" type="button" class="submit xz1" value="保 存" />
								</td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</form>
				</div>
				<%--
				<div class="profile_acconut">
					<div class="profile_tit"><i class="profile_tit_icon03"></i>合作账号信息</div>
					<p><span class="w150">绑定微博账号 <img src="images/sina.jpg" width="16" style="vertical-align:middle" /></span>您还没有绑定，现在去<a href="#" class="f_f15a22">绑定账号</a></p>
					<p><span class="w150">绑定Q Q账号 <img src="images/qq.jpg" width="15" style="vertical-align:middle" /></span>您还没有绑定，现在去<a href="#" class="f_f15a22">绑定账号</a></p>
				</div>
				 --%>
			</div>
		</div>
		<div class="clearfix"></div>
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
</body>
</html>
