<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>特许经营报名</title>
<%@include file="../head.jsp" %>
<script type="text/javascript" src="${scripts}/companyservice.js"></script>
<style>
<!--
.tips {
  display: none;
}
-->
</style>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="franchiseLeftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/busin_banner.jpg" width="770" /></div>
			<div class="news_detail">
				<h1 class="news_title">特许经营报名</h1>
				<div class="txjy_layer_tab">
				
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tbody>
							<tr>
								<td width="150" align="right"><span class="f_f15a22">*</span>特许经营申请区域：</td>
								<td width="430">
									<select class="add_sel" id="selectProvince" name="pid" onchange="javascript:showCitys();">
										<option value="">请选择省</option>
										<c:forEach var="province" items="${provinces}">
											<option value="${province.pid}">${province.pname}</option>
										</c:forEach>
									</select>
									<select name="cid" class="add_sel" id="selectCity">
										<option value="">请选择市</option>
									</select>
									<input id="sqqy" name="district" type="text" value="请输入详细地址" ov="请输入详细地址" class="input inputFocus grays" style="width:137px;"/>
								</td>
								
								<td>
								<div class="tips" id="sqqyTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="sqqyWarning"></span>
										</p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>公司/个人名称：</td>
								<td><input id="gsmc" name="name" type="text" value="请输入公司/个人名称" ov="请输入公司/个人名称" class="input inputFocus grays"/></td>
								<td>
								<div class="tips" id="gsmcTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="gsmcWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>公司/个人地址：</td>
								<td><input id="gsdz" name="address" type="text" value="请输入公司/个人地址" ov="请输入公司/个人地址" class="input inputFocus grays"/></td>
								<td><div class="tips" id="gsdzTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="gsdzWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>公司注册资金(万元)：</td>
								<td><input id="zczj" name="money" type="text" ov="请输入公司注册资金" value="请输入公司注册资金" class="input inputFocus grays"/></td>
								<td><div class="tips" id="zczjTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="zczjWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>员工人数：</td>
								<td><input id="ygrs" name="employeeno" type="text" value="请输入员工人数" ov="请输入员工人数" class="input inputFocus grays"/></td>
								<td><div class="tips" id="ygrsTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="ygrsWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>联系人：</td>
								<td><input id="lxr" name="contacts" type="text" value="请输入联系人" ov="请输入联系人" class="input inputFocus grays"/></td>
								<td><div class="tips" id="lxrTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="lxrWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>联系方式：</td>
								<td><input id="lxfs" name="tel" type="text" value="请输入联系方式" ov="请输入联系方式" class="input inputFocus grays"/></td>
								<td><div class="tips" id="lxfsTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="lxfsWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>E-mail：</td>
								<td><input id="dzyj" name="email" type="text" value="请输入E-mail" ov="请输入E-mail" class="input inputFocus grays"/></td>
								<td><div class="tips" id="dzyjTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="dzyjWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>场地面积(㎡)：</td>
								<td><input id="cdmj" name="area" type="text" value="请输入场地面积" ov="请输入场地面积" class="input inputFocus grays"/></td>
								<td><div class="tips" id="cdmjTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="cdmjWarning"></span>
										</p>
									</div></td>
							</tr>
							<tr>
								<td align="right"><span class="f_f15a22">*</span>自有车辆：</td>
								<td><input id="zycl" name="car" type="text" value="请输入自有车辆" class="input inputFocus grays" ov="请输入自有车辆"/></td>
								<td>
									<div class="tips" id="zyclTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="zyclWarning"></span>
										</p>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right" valign="top">留言内容：</td>
								<td><textarea id="lynr" name="message" rows="3"></textarea></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right">验证码：</td>
								<td>
								<input name="" id="validateCode_input" class="input" style="width:90px;" type="text" class="Codeinput" />
								<img id="validateCode_img" src="genCheckCode.action" width="90" height="28" style="vertical-align: middle;" />
								<a href="javascript:changeCode();">看不清？换一组</a>
							</td>
								<td>
									<div class="tips" id="codeTips">
										<p class="erro">
											<span class="icon_del"></span>
											<span id="codeNotice"></span>
										</p>
									</div>
								</td>
						</tr>
						</tbody>
					</table>
				
					<div class="easyDialog_footer">
						<a id="txtijiao" class="btn_highlight">确定</a>
						<a id="cancel" class="btn_normal" onclick="javascript:txregistCancel();">取消</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
