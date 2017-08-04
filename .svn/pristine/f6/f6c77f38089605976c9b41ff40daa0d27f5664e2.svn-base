<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@taglib uri="http://javatag.hoau.net/tags/pager" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>发货人管理</title>
<%@include file="../head.jsp" %>
<link href="${styles}/shipperManager.css?version=0.0.1" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${scripts}/easydialog.min.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/shipper_contacts.js?version=20150908"></script>
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
.consigner_layer .select_ui{
	width:243px;
}
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
				<h1 class="news_title">发货人管理</h1>
				<div class="consignee_list  pt30">
					<div class="filter">
						<span class="consignee_search fr">
							<input name="queryKeyword" type="text" class="w135 input inputFocus grays" 
								<s:if test='queryKeyword=="" or queryKeyword==null'>value="搜索姓名或联系方式"</s:if>
								<s:else>value="<s:property value="queryKeyword"/>"</s:else> 
								ov="搜索姓名或联系方式" />
							<input id="search" type="button" class="tosnmiddle_btn" value="搜索" style="width:60px;"/>
						</span>
						<span class="fl">
							<label class="mr10 f666">
								<input id="selectAll" class="mr5" name="" type="checkbox" value="" />全选
							</label>
							<a href="javascript:void(0)" class="btn-action" id="delQuery"><span class="ui-btn-txt">删除所选</span></a>
							<!-- 
							<a class="btn-action" id="exportQuery"><span class="ui-btn-txt">导出选中</span></a>
							 -->
							<a href="javascript:void(0)" class="btn-action" id="exportAll"><span class="ui-btn-txt">导出所有</span></a>
							<a href="javascript:void(0)" class="btn-action" id="addReceiver"><span class="ui-btn-txt">新增</span></a>
						</span>	
						<div class="clearfix"></div>			
					</div>
					
					<ul class="consignee_box">
						<s:iterator var="contacts" value="paging.data">
							<li>
								<div class="widget-card">
									<div class="widget-card-caption clearfix">
										<span class="fl">
											<label class="addressName">
												<input class="mr5" name="checkItem" type="checkbox" value="" />
												<span style="display: none;"><s:property value="ebsaId"/></span>
												<!-- 姓名 -->
												<s:property value="ebsaContact"/>
											</label>
										</span>
										<span class="fr mt5">
											<span class="addressbook-action">
												<a href="javascript:void(0)" <s:if test='ebsaIsDefault=="Y"'>class="btn-setdefault-yes"</s:if><s:else>class="btn-setdefault"</s:else> title="设为默认寄件地址"></a>
												<a href="javascript:void(0)" class="btn-edite" title="编辑"></a>
												<a href="javascript:void(0)" class="btn-delete" title="删除"></a>
												<span style="display: none;"><s:property value="ebsaId"/></span>
											</span>
										</span>
									</div>
									<div class="widget-card-c">
										<dl class="card-list">
											<dt class="mobilephone"><s:property value="ebsaMobile"/></dt>
											<dd class="phone">
												<s:if test='ebsaContactTel!=null && ebsaContactTel!=""'>
													<s:property value="ebsaContactAreaCode"/>-<s:property value="ebsaContactTel"/>
												</s:if>
											</dd>
										</dl>
										<div class="card-info">
											<div class="companyName mb5">公司名称：<s:property value="ebsaCompany"/></div>
											<div class="companyName mb5"><strong>发货地址:
											<s:property value="ebsaEbpvName"/><!-- 省 -->
											&nbsp;
											<s:property value="ebsaEbplName"/><!-- 市 -->
											&nbsp;
											<s:property value="ebsaEbcoName"/><!-- 区 -->
											&nbsp;
											<s:property value="ebsaAddress"/><!-- 详细地址 -->
											</strong></div>
											<p>发货网点:
											<s:if test="ebsaEscoSecondName!=null">
												<s:property value="ebsaEscoSecondName"/><!-- 营业网点名称信息 -->
											</s:if>
											<s:else>
												&nbsp;
											</s:else>
											</p>
										</div>
									</div>
								</div>
							</li>
						</s:iterator>
						
						<div class="clearfix"></div>
					</ul>
				</div>

				
				<div class="scott mt15">					
					<w:pager pageSize="${paging.pageSize}" pageNo="${paging.pageNo}" url="contacts_shipperManage.action" recordCount="${paging.rowsCount}" />
				</div>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>

<!-- 新增联系人 -->
<div class="easyDialog_wrapper" id="easyDialogWrapper" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>新增发货人
		</div>
    	<div class="consigner_layer">
			<div id="newshipper_div" class="consignor_Mess f12" style="border:0;height:375px;overflow: auto;padding-bottom: 0;">
				<ul>
					<li>
						<label class="zt_widthlabel"><b>*</b>发货人：</label>
						<input id="shipper_name" type="text" name="" value="" class="input w170" />
					</li>
					<li>
						<label class="zt_widthlabel">手机：</label>
						<input id="shipper_mobile" type="text" name="" value="" class="input w170"/>
						<label class="zt_widthlabel">固定电话：</label>
						<input id="shipper_telephone_area_no" type="text" value="" name="" class="input w40"/> - <input id="shipper_telephone" type="text" value="" name="" class="input w100"/>
					</li>
					<li>
						<label class="zt_widthlabel"></label>
						<b class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
					</li>
					<li>
						<label class="zt_widthlabel">公司名称：</label>
						<input id="shipper_company" type="text" name="" maxlength="50" autocomplete="off" 
						value="若需开票，需必填，与开票公司抬头保持一致" class="input inputFocus" style="width:419px;"
						ov="若需开票，需必填，与开票公司抬头保持一致"/>
					</li>
					<li>
						<label class="zt_widthlabel"><b>*</b>发货地址：</label>
						<label class="newprocitySel">
							<input id="shipper_district" autocomplete="off" type="text" readonly="readonly" 
									class="grays input proCityQueryAll proCitySelAll inputFocus w170" 
									name="leavedCity" value="请选择城市名称" ov="请选择城市名称"<s:if test="typeValue == null"></s:if><s:else> value="<s:property value="typeValue"/>"</s:else>/>
							 
						</label>
						<input id="shipper_address_detail" type="text" value="" name="" class="input" style="width:240px;"/>
					</li>
					<li>
						<label class="zt_widthlabel"><!-- <b>*</b> --> 发货网点：</label>
						<label class="newprocitySel"> 
							<input id="shipper_dept_district" autocomplete="off" type="text" readonly="readonly"
									onchange="loadShapperContacts();" class="grays input proCityQueryAll proCitySelAll inputFocus w170"  
									name="leavedCity" value="请选择城市名称" ov="请选择城市名称"<s:if test="typeValue == null"></s:if><s:else> value="<s:property value="typeValue"/>"</s:else>/>
						</label>							
						<select id="shipper_dept_name" name="" style="width:245px;height:28px;">
							<option value="">请选择</option>
						</select>
					</li>					
				</ul>
				<div id="append-out">
					<div class="pt10" style="padding-left:69px">
						<label><input id="unpayment_message" name="" type="checkbox" value="" class="mr5" /><span style="vertical-align: middle;">代收货款信息维护</span><span class="unpayment_message_error1"></span></label>
					</div>
					<div id="unpayment_message_checked" class="receivables_info_box border-all" style="display:none">
						<ul>
							<li><label class="zt_widthlabel"><b>*</b>户名：</label><select class="payee_name1"></select><!-- <input id="" type="text" name="" value="" class="input w160"> --></li>
							<li><label class="zt_widthlabel"><b>*</b>账号：</label><input class="shipper_account1 input w160" type="text" name="" value="" /></li>
							<li>
								<label class="zt_widthlabel"><b>*</b>银行：</label><input  class="bank_name1 input w160" type="text" name="" value="" readonly="readonly" />
							</li>
							<li><label class="zt_widthlabel"><b>*</b>开户行：</label>
								<input type="text" class="branch_message1 input w160" onkeyup="startComplete(this,'newshipper_div',event)" />
								<div class="auto_hidden"><!--自动完成 DIV--></div>
							</li>
							<li>
								<label class="zt_widthlabel"><b>*</b>所属地：</label>
								<input autocomplete="off" type="text" readonly="readonly" 
									class="ascriptionCity1 grays input proCityQueryAll proCitySelAll inputFocus w170" 
									value="请选择城市名称" ov="请选择城市名称" />
							</li>
						</ul>
						<div class="easyDialog_footer" style="padding:10px 0 5px;">
							<a href="javascript:void(0)" id="continue_add" class="btn_highlight" style="width:76px">继续添加</a> 
							<a href="javascript:void(0)" class="btn_normal" style="width:76px">取消</a>
						</div>
					</div>
				</div>
				<div class="tips mt5" style="display:block;padding-left:130px;">
					<p class="erro" style="display: none;"><span class="icon_del"></span><span class="erro_msg"></span></p>
				</div> 
			</div>		
		</div>
		<div class="easyDialog_footer">
			<a href="javascript:void(0)" id="shipper_add_btn" class="btn_highlight">新增</a> 
			<a href="javascript:void(0)" class="btn_normal" onclick="easyDialog.close();">取消</a>
		</div>
	</div>
</div>

<!-- 修改联系人 -->
<div class="easyDialog_wrapper" id="easyDialogWrapper_update" style="width:680px;">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>修改发货人信息
		</div>
    	<div class="consigner_layer">
			<div id="update_shipper_div" class="consignor_Mess f12" style="border:0;height:375px;overflow: auto;padding-bottom: 0;">
				<ul>
					<li>
						<label class="zt_widthlabel"><b>*</b>发货人：</label><span id="ebsa_id" style="display: none;"></span>
						<input id="shipper_update_name" type="text" class="input w170"/>
					</li>
					<li>
						<label class="zt_widthlabel">手机：</label>
						<input id="shipper_update_mobile" type="text" name="" value="" class="input w170"/>
						<label class="zt_widthlabel">固定电话：</label>
						<input id="shipper_update_telephone_area_no" type="text" value="" name="" class="input w40"/> - <input id="shipper_update_telephone" type="text" value="" name="" class="input w100"/>
					</li>
					<li>
						<label class="zt_widthlabel"></label>
						<b class="f_f15a22">*</b><font color="#aeaeae">手机号码与固定电话必须填写一项</font>
					</li>
					<li>
						<label class="zt_widthlabel">公司名称：</label>
						<input id="shipper_update_company" type="text" maxlength="50"
						value="若需开票，需必填，与开票公司抬头保持一致" class="input inputFocus" style="width:419px;"
						ov="若需开票，需必填，与开票公司抬头保持一致"/>
					</li>
					<li>
						<label class="zt_widthlabel"><b>*</b>发货地址：</label>
						<label class="newprocitySel">
							<!-- <input type="text" value="请选择/输入城市名称" name="" class="input inputFocus grays w135" ov="请选择/输入城市名称"/> -->
							<input id="shipper_update_district" autocomplete="off" type="text" readonly="readonly"
									class="grays input proCityQueryAll proCitySelAll inputFocus w170" 
									name="leavedCity" value="请选择城市名称" ov="请选择城市名称"<s:if test="typeValue == null"></s:if><s:else> value="<s:property value="typeValue"/>"</s:else>/>
							 
						</label>
						<input id="shipper_update_address_detail" type="text" value="" name="" class="input" style="width:240px;"/>
					</li>
					<li>
						<label class="zt_widthlabel"> 发货网点：</label>
						<label class="newprocitySel"> 
							<input id="shipper_update_dept_district" autocomplete="off" type="text" readonly="readonly" disabled="disabled"
									onchange="loadUpdateShapperContacts();" class="grays input proCityQueryAll proCitySelAll inputFocus w170" 
									name="leavedCity" value="请选择城市名称" ov="请选择城市名称"<s:if test="typeValue == null"></s:if><s:else> value="<s:property value="typeValue"/>"</s:else>/>
						</label>							
						<select id="shipper_update_dept_name" name="" style="width:245px;height:28px;">
							<option value="">请选择</option>
						</select>
					</li>
				</ul>
				<div id="append_update">
					<div class="pt10" style="padding-left:69px">
						<label><input id="unpayment_message2" type="checkbox" value="" class="mr5" /><span style="vertical-align: middle;">代收货款信息维护</span><span class="unpayment_message_error2"></span></label>
					</div>
					<div id="unpayment_message_checked2" class="receivables_info_box border-all" style="display:none">
						<ul>
							<li><label class="zt_widthlabel"><b>*</b>户名：</label><select class="payee_name2"></select><span class="ebsa_id2" style="display: none;"></span></li>
							<li><label class="zt_widthlabel"><b>*</b>账号：</label><input class="shipper_account2 input w160" type="text" name="" value="" /></li>
							<li>
								<label class="zt_widthlabel"><b>*</b>银行：</label><input  class="bank_name2 input w160" type="text" name="" value="" readonly="readonly" />
							</li>
							<li><label class="zt_widthlabel"><b>*</b>开户行：</label>
								<input type="text" class="branch_message2 input w160" onkeyup="startComplete(this,'update_shipper_div',event)" />
								<div class="auto_hidden"><!--自动完成 DIV--></div>
							</li>
							
							<li>
								<label class="zt_widthlabel"><b>*</b>所属地：</label>
								<input autocomplete="off" type="text" readonly="readonly" 
									class="ascriptionCity2 grays input proCityQueryAll proCitySelAll inputFocus w170" 
									value="请选择城市名称" ov="请选择城市名称" <s:if test="typeValue == null"></s:if><s:else> value="<s:property value="typeValue"/>"</s:else>/>
							</li>
						</ul>
						<div class="easyDialog_footer" style="padding:10px 0 5px;">
							<a href="javascript:void(0)" id="continue_add2" class="btn_highlight" style="width:76px">继续添加</a> 
							<a href="javascript:void(0)" class="btn_normal" style="width:76px">取消</a>
						</div>
					</div>
				</div>
				<div class="tips mt5" style="display:block;padding-left:130px;">
					<p class="erro" style="display: none;"><span class="icon_del"></span><span class="erro_msg"></span></p>
				</div> 
			</div>		
		</div>
		<div class="easyDialog_footer">
			<a href="javascript:void(0);" id="shipper_update_save_btn" class="btn_highlight">保存</a> 
			<a href="javascript:void(0);" class="btn_normal" onclick="easyDialog.close();">取消</a>
			<!-- <input type="submit" class="btn_highlight" value="新增"/>
			<input type="reset" class="btn_normal" value="重置"/> --> 
		</div>
	</div>
</div>

<!-- 提示框 -->
<div class="easyDialog_wrapper" id="DelWrapper">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>删除收货人
		</div>
    	<div class="del_consignee tc" style="width:380px;">
			<div class="aui_icon aui_icon_q"></div>
			<div class="aui_content" style="padding: 20px;">确定要删除吗?</div>
		</div>
		<div class="easyDialog_footer">
			<a href="#" id="shipper_add_btn_confirm" class="btn_highlight">确定</a> 
			<a href="#" class="btn_normal" onclick="easyDialog.close();">取消</a>
			<!-- <input type="submit" class="btn_highlight" value="新增"/>
			<input type="reset" class="btn_normal" value="重置"/> --> 
		</div>
	</div>
</div>

<!-- 提示框 -->
<!-- <div class="easyDialog_wrapper" id="DelWrapper">
	<div class="from_wrapper">
		<div class="from_wrapper_t">
			<a href="javascript:void(0)" title="关闭窗口" onclick="easyDialog.close()" class="from_close"></a>发货人手机号和座机号不能同时为空
		</div>
</div> -->

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
<script>
$(function(){
	
	$("#addReceiver").click(function(){
		easyDialog.open({
			container : 'easyDialogWrapper',
			fixed : false
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
