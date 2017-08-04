<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网点匹配</title>
<meta name="Keywords" content="公路快运,物流货运,天地华宇,天地华宇物流,天地华宇物流查询,华宇物流,华宇物流查询,天地华宇俱乐部,华宇俱乐部，中信产业基金" />
<meta name="Description" content='天地华宇是中信产业投资基金管理有限公司（简称中信产业基金）旗下的全资公司，也是国家第一批"AAAAA"级资质的物流企业。天地华宇的前身华宇物流1995年成立于广州，总部设在上海，拥有中国最大的公路快运网络之一。截止2013年10月，天地华宇在全国600个大中城市拥有56个货物转运中心、1500家营业网点和16000名员工,全国客服热线400-808-6666' />
<link rel="Shortcut Icon" href="${images}/ico.png" type="image/x-icon"/>
<link href="${styles}/base.css" rel="stylesheet" type="text/css" />
<link href="${styles}/master.css" rel="stylesheet" type="text/css" />
<link href="${styles}/addition.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${scripts}/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
<script type="text/javascript" src="${scripts}/public.js"></script>
<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=C5aeb021e01e3f7bdb8d38530dc517f0&s=1"></script>
<script type="text/javascript" src="https://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="https://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<script type="text/javascript" src="${scripts}/company/clusterMarker.js"></script>
<script type="text/javascript" src="${scripts}/company/matching.js"></script>
<script type="text/javascript">
$(function(){
	$(".subNav").click(function(){
		$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
		// 修改数字控制速度， slideUp(500)控制卷起速度
		$(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
	})
	$('.letter_tab').jtabs('.letter_list', {fx: 'fade', activeClass: 'active', event: 'click', initIdx: 0});
})
</script>
</head>

<body>
<%@include file="../../top.jsp" %>
<div class="content">
	<div class="p_w">		
		<div class="map_box">
			<div class="map_top">
				<div class="map_t_tab fr">
					<a href="companyScreenAction!queryAll.action" class="map_t_tab_one">网点筛选</a>
					<a href="javascript:void(0)" class="map_t_tab_two active">网点匹配</a>
					<%--<a href="companyBatchQueryAction!index.action" class="map_t_tab_three">批量到货网点匹配</a>--%>
					<a href="companyQueryAction!index.action" class="map_t_tab_fove">到货网点匹配</a>
				</div>
				<span class="map_top_tit">
					网点匹配
				</span>
				<div class="clearfix"></div>
			</div>
		
		<div class="map_main areaQuery">
			<div class="query-form clearfix" style="text-align:right">
				<table style="width:100%">
					<tr>
						<td>
							<label class="newprocitySel">
								<input id="leavedCityName" readonly="readonly" autocomplete="off" type="text" 
									name="leavedCity" ov="请选择省市区" mold="mold"<s:if test="typeValue == null"> value="请选择省市区" class="grays send_input proCityQueryAll proCitySelAll inputFocus"  </s:if><s:else> class="send_input proCityQueryAll proCitySelAll inputFocus"  value="<s:property value="typeValue"/>"</s:else>/>
							</label>
						</td>
						<td>
							<label class="newprocitySel">
								<input id="arrivedCityName" autocomplete="off" type="text" class="grays send_input inputFocus" name="arrivedCity" ov="街道路名..." value="街道路名..."/>
							</label>
						</td>
						<td align="center">
							<table cellpadding=0 cellspacing=0 style="width:100%;">
								<tr>
									<td><span id="msg_span" style="color:red;display:none;">请选择城市！</span></td>
									<td><input type="button" style="padding:0px;margin:0px;" class="submit tosnmiddle_btn" onclick="findDeptDistance();" value="查询" /></td>
								</tr>
							</table>
						</td>
						<td align="left">
							<div style="padding-left:20px">
								<p><img src="${images}/index_red.png" height="15px" width="15px;" alt="可发货"/>：可发货 </p>
								<p><img src="${images}/index_violet.png" height="15px" width="15px;" alt="可发货/自提"/>：可发货/自提 </p>
								<p><img src="${images}/index_orange.png" height="15px" width="15px;" alt="可发货/送货"/>：可发货/送货 </p>
								<p><img src="${images}/index_yellow.png" height="15px" width="15px;" alt="可发货/自提/送货"/>：可发货/自提/送货 </p>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="zt_letter">
				<div id="map" class="zt_letterleft">
				</div>
				<div class="zt_letterright">
					<%-- 所有省市 --%>
					<div id="province_div">
						<div id="screening_province_div" class="letter_tab">
							<a href="#">按省筛选</a>
							<a href="#">按城市拼音首字母筛选</a>
						</div>
						<div class="letter_list">
							<div id="province_list_div" class="provinceListsA">
							</div>
						</div>
						<div class="letter_list">
							<div id="pinYin_list_div" class="zt_letterbox">
							</div>
						</div>
					</div>
					<%-- 所有市区 --%>
					<div id="city_div" class="zt_letterright" style="display:none;">					
						<div class="zt_letterbox">
							<p class="zt_letterleftp"> 筛选结果</p>
							<a href="javascript:loadChina();">中国</a>
							<a href="javascript:void(0)" class="provinceName"></a>
							<a href="javascript:void(0)" class="cityName"></a>
							<span class="areaName"></span>
						</div>
						<div id="district_div">
							<div class="zt_letterbox">
								<p class="zt_letterleftp" id="p_1"><span class="screeningName"></span>的以下城市设有网点</p>
							</div>
							<div id="cityList">
								<table id="cityTable">
								</table>
							</div>
						</div>
					</div>
					<div id="screen_div" class="zt_letterright" style="display:none;">
						<div class="zt_letterbox">
							<p class="zt_letterleftp"> 筛选结果</p>
							<span><span style="color:#726f90">关键字：&nbsp;</span><span id="keyword_span"></span></span><br />
							<span><span style="color:#726f90">匹配地址：&nbsp;</span><span id="address_span"></span></span><br />
						</div>
					</div>
					<%-- 热门城市 --%>
					<div id="hotCity_div">
						<p class="zt_letterleftp">热门城市</p>
						<ul class="zt_returnlist">
							<li>
								<div class="zt_letterbox" id="hot_cityList" style="display: block;">
								</div>
							</li>
						</ul>
					</div>
					<div id="deptList_div" style="display:none;">
						<p class="zt_letterleftp">网点列表</p>
						<div id="deptList">
						</div>
						<div class="zt_changepage">
							<p class="zt_changered"></p>
							<ul>
								<li class="prev"><a id="deptPrev" style="cursor: pointer;" title="上一页"></a></li>
								<li class="num"><span class="thisPage"></span></li>
								<li class="next"><a id="downPage" style="cursor: pointer;" title="下一页"></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		</div>
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
<%@include file="../../bottom.jsp" %>
</body>
</html>