<%@page language="java" pageEncoding="UTF-8" import="java.io.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta name="baidu-site-verification" content="ARj7VVPRUH" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>天地华宇,公路快运,物流货运—中国公路快运领跑者!</title>

	<%@include file="head.jsp" %>
	<script type="text/javascript" src="${scripts}/jquery.kinMaxShow-1.1.min.js"></script>
	<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
	<script type="text/javascript" src="${scripts}/goodstrace.js"></script>
	<script type="text/javascript" src="${scripts}/public.js"></script>
	<script type="text/javascript" src="${scripts}/queryDistrict.js"></script>
	<script type="text/javascript" src="${scripts}/queryPriceTime.js"></script>
	<script type="text/javascript">
        $(function(){
            $("#kinMaxShow").kinMaxShow();
            $("#newsMaxShow").kinMaxShow();
            $('.friend_tab').jtabs('.friend_list', {fx: 'fade', activeClass: 'active', event: 'mouseover', initIdx: 0});
            $('.serve_tab_cont').jtabs('.serve_list', {fx: 'fade', activeClass: 'active', event: 'click', initIdx: 0});
        });
        function hideCityControl(){
            $(".provinceCityAll").hide();
        }
        function hiden(i){
            $(i).hide();
        }
	</script>
	<%--监控客服 PV UV--%>
	<script>
        //声明_czc对象:
        var _czc = _czc || [];
        //绑定siteid，请用您的siteid替换下方"XXXXXXXX"部分
        _czc.push(["_setAccount", "1262570488"]);
	</script>
</head>
<body>
<%@include file="top.jsp" %>
<div class="in_show">
	<div id="kinMaxShow">
		<c:choose>
			<c:when test="${!empty bannerList}">
				<c:forEach var="banner" items="${bannerList}">
					<div><a href="${banner.picLink}"><img src="${banner.picSrc}" alt="最新动态"/></a></div>
					<%-- 					<div><a href="${banner.picLink}"><img src="${images}/1.jpg" /></a></div> --%>
					<%-- 					<div><a href="${banner.picLink}"><img src="${images}/2.jpg" /></a></div> --%>
				</c:forEach>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="serve_shadow">
	<div class="p_w pr">
		<div class="serve_tab">
			<div class="serve_tab_cont">
				<ul class="quick-tools">
					<li>
						<a class="quick-tool-title" href="#"><i class="waybill_icon01"></i><span>货物追踪</span></a>
						<div class="serve_list">
							<div class="arrow"></div>
							<div class="serve_hwzz">
								<form name="traceTransForm" id="traceTransForm" action="traceTransByNo.action#cxjg" method="post">
									<!-- update huyuzhou 2016年3月8日09:52:26 -->
									<input id="transNos" name="transNos" type="text"  style="ime-mode:disabled"  class="serve_hwzz_input inputFocus grays" ov="在此输入运单号进行查询" value="在此输入运单号进行查询" /><input name=""  id="indexQueryBill" type="button" value="查询" class="xz1" style="display: none;"/>
									<div id="phoneImg" class="serve_hwzz_icon" style="cursor: pointer;"></div>
									<!-- end -->
									<p class="erro" style="display: none;color: #f00;padding-left: 5px;text-align: left;"><span class="icon_del"></span><span class="erro_msg"></span></p>
								</form>
							</div>
						</div>
					</li>
					<li>
						<a class="quick-tool-title" href="javascript:void(0)"><i class="waybill_icon02"></i><span>时效价格</span></a>
						<div class="serve_list" style="left:-101px;" ><!-- onmouseover="hideCityControl();"> -->
							<div class="arrow" style="left:50%;"></div>
							<div class="serve_sxjg">
								<form name="priceTimeForm" id="priceTimeForm" action="showPriceTime.action" method="post">
									<p>
										<label>始发地：</label><input name="leavedCityName" id="leavedCityName" type="text" value="出发城市" class="serve_hwzz_input proCityQueryAll proCitySelAll inputFocus current2 grays" ov="出发城市"/><input id="queryPricTime" name="" type="button" value="查询" class="xz1" />
									</p>
									<p>
										<label>目的地：</label><input name="arrivedCityName" id="arrivedCityName" type="text" value="到达城市" class="serve_hwzz_input proCityQueryAll proCitySelAll inputFocus grays" ov="到达城市"/>
									</p>
								</form>
							</div>
						</div>
					</li>
					<li>
						<a class="quick-tool-title" href="javascript:void(0)"><i class="waybill_icon03"></i><span>网点查询</span></a>
						<div class="serve_list" style="right:0;" ><!-- onmouseover="hideCityControl();"> -->
							<div class="arrow" style="left:81%;"></div>
							<div class="serve_wdcx">
								<form id="districtForm" action="companyMatchAction!index.action" method="post">
									<input id="typeValue" name="typeValue"
										   autocomplete="off" type="text" class="grays serve_hwzz_input proCityQueryAll proCitySelAll inputFocus"
										   name="leavedCity" ov="请选择城市名称" value="请选择城市名称"/>
									<input name="" type="button" id="queryDistrictBtn" value="查询" class="xz1" />
								</form>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="in_product">
	<div class="p_w">
		<h2 class="in_title"><span>产品业务</span><i></i></h2>
		<ul>

			<li>
				<a href="drdIntroduction.action" class="in_product_icon01">
					<i></i>
					<b>定日达</b>
					<span>说到做到、定日必达</span>
				</a>
			</li>
			<li>
				<a href="highway.action" class="in_product_icon02">
					<i></i>
					<b>经济快运</b>
					<span>运输快捷，经济实用</span>
				</a>
			</li>
			<li>
				<a href="easyHome.action" class="in_product_icon04">
					<i></i>
					<b>易到家</b>
					<span>便捷高效，温馨到家</span>
				</a>
			</li>
			<li>
				<a href="vehicle.action" class="in_product_icon03">
					<i></i>
					<b>专车达</b>
					<span>专车保运，放心承运</span>
				</a>
			</li>
			<li>
				<a href="collectingMoney.action" class="in_product_icon05">
					<i></i>
					<b>代收货款</b>
					<span>货款回收，便捷安全</span>
				</a>
			</li>
			<li>
				<a href="insuredTransport.action" class="in_product_icon06">
					<i></i>
					<b>保价运输</b>
					<span>安全保价，放心托运</span>
				</a>
			</li>
			<li>
				<a href="safePackaging.action" class="in_product_icon07">
					<i></i>
					<b>安全包装</b>
					<span>专业打包，暖心服务</span>
				</a>
			</li>
		</ul>
	</div>
</div>
<div class="in_promotion">
	<div class="p_w">
		<h2 class="in_title"><span>市场活动</span><i></i><a href="marketActivity.action" class="in_more"></a></h2>
		<div class="promotion_list">
			<ul>
				<c:choose>
					<c:when test="${!empty marketList}">
						<c:forEach var="market" items="${marketList}">
							<li>
								<form action="queryNewsDetail.action" name="huodong${market.id}" id="huodong${market.id}" method="post">
									<input name="newsId" value="${market.id}" style="display: none;"/>
									<input name="rowNum" value="${market.rowNum}" style="display: none;"/>
									<input name="forJump" value="${market.categoryName}" style="display: none;"/>
								</form>
								<a href="javascript:void(0)" onclick="$('#huodong${market.id}').submit()" class="go-dynamic">
							<span class="promotion_pic">
							<c:choose>
								<c:when test="${market.isDisable==true}"><img src="${market.sltSrc}" class="finished" alt="市场活动"/></c:when>
								<c:otherwise><img src="${market.sltSrc }" alt="市场活动"/></c:otherwise>
							</c:choose>
							</span>
									<div class="event_content">
										<h5 class="promotion-title">${market.shortTitile }</h5>
										<c:choose>
											<c:when test="${market.isDisable==false}">
												<span class="promotion_status_label hot_in">进行中</span></c:when>
											<c:otherwise><span class="promotion_status_label finished">已结束</span></c:otherwise>
										</c:choose>
										<div class="date">
											<c:choose>
												<c:when test="${empty market.validityPeriod}">&nbsp;</c:when>
												<c:otherwise>${market.validityPeriod}</c:otherwise>
											</c:choose>
										</div>
										<div class="range">
											<c:choose>
												<c:when test="${market.id eq 164107 or market.id eq 164114 or market.id eq 163858 or market.id eq 164016 or market.id eq 164019 or market.id eq 164041 or market.id eq 164050}">
													所有直营网点　适用
												</c:when>
												<c:otherwise>
													全国所有网点　适用
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</a>
							</li>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</ul>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<div class="in_news">
	<div class="p_w">
		<h2 class="in_title"><span>新闻</span><i></i><a href="hoauDynamic.action" class="in_more"></a></h2>
		<div class="in_news_list fl pt30">
			<ul>
				<c:choose>
					<c:when test="${!empty newsIndexVoList}">
						<c:forEach var="news" items="${newsIndexVoList}">
							<li><span class="fr"><fmt:formatDate value="${news.createAt}" pattern="yyyy-MM-dd"/></span>
								<form action="queryNewsDetail.action" method="post" name="hoauDynamic${news.id}" id="hoauDynamic${news.id}">
									<input name="newsId" value="${news.id}" style="display:none;"/>
									<input name="rowNum" value="${news.rowNum}" style="display:none;"/>
									<input name="forJump" value="${news.categoryName}" style="display:none;"/>
								</form>
								<a href="javascript:void(0)" onclick="$('#hoauDynamic${news.id}').submit();" title="${news.tipTitle}">${news.title}</a></li>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div class="in_news_pic fr pt30">
			<div id="newsMaxShow">
				<c:choose>
					<c:when test="${!empty propagandaNewsList}">
						<c:forEach var="proNews" items="${propagandaNewsList}">
							<form action="queryNewsDetail.action" name="newsMaxShowForm${proNews.id}" id="newsMaxShowForm${proNews.id}" method="post">
								<input name="newsId" value="${proNews.id}" style="display:none;"/>
								<input name="rowNum" value="${proNews.rowNum}" style="display:none;"/>
								<input name="forJump" value="${proNews.categoryName}" style="display:none;"/>
							</form>
							<div><a href="javascript:void(0)" onclick="$('#newsMaxShowForm${proNews.id}').submit();"><img src="${proNews.sltSrc}" alt="详情"/></a></div>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>

<div class="friend_box">
	<div class="p_w">
		<div class="friend_tab">
			<a href="javascript:void(0)" class="active">合作伙伴</a>
			<a href="javascript:void(0)">快速导航</a>
		</div>
		<div class="friend_list">
			<div class="friend_link">
				<ul>
					<li><a href="http://www.1688.com/" target="_blank" class="friend_menu1"></a></li>
					<li><a href="http://www.taobao.com/" target="_blank" class="friend_menu2"></a></li>
					<li><a href="http://www.tmall.com" target="_blank" class="friend_menu3"></a></li>
					<li><a href="http://www.jd.com" target="_blank" class="friend_menu4"></a></li>
					<li><a href="http://56.hc360.com/" target="_blank" class="friend_menu5"></a></li>
					<li><a href="http://www.yhd.com/" target="_blank" class="friend_menu6"></a></li>
					<li><a href="http://www.suning.com" target="_blank" class="friend_menu7"></a></li>
					<li><a href="http://www.kuaidi100.com" target="_blank" class="friend_menu8"></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<%--解决重新刷新页面,快速导航 tab 会闪现再隐藏掉 bug--%>
		<div class="friend_list"  style="display: none">
			<div class="site_map">
				<div class="link_row">
					<ul>
						<li><a href="myOrdersAction!queryMyOrders.action">我的订单</a></li>
						<li><a href="requestclaim.action">我的理赔</a></li>
						<li><a href="personalDataAction!index.action">我的资料管理</a></li>
					</ul>
				</div>
				<div class="link_row">
					<ul>
						<li><a href="orderAction!index.action">网上下单</a></li>
						<li><a href="batchOrderAction!index.action">批量下单</a></li>
						<li><a href="traceTransByNo.action">货物追踪</a></li>
						<li><a href="companyScreenAction!queryAll.action">网点查询</a></li>
						<li><a href="showPriceTime.action">价格/时效查询</a></li>
					</ul>
				</div>
				<div class="link_row">
					<ul>
						<li><a href="drdIntroduction.action">主营产品</a></li>
						<li><a href="safePackaging.action">增值服务</a></li>
						<li><a href="marketActivity.action">市场活动</a></li>
					</ul>
				</div>
				<div class="link_row">
					<ul>
						<li><a href="franchise.action">特许经营</a></li>
						<li><a href="e-commerce.action">电商合作</a></li>
						<li><a href="http://sou.hoau.net" target="_blank">采购平台</a></li>
						<li><a href="http://114.141.133.241:8080/bid/toLogin.do" target="_blank">投标报名</a></li>
					</ul>
				</div>
				<div class="link_row">
					<ul>
						<li><a href="#">新手指南</a></li>
						<li><a href="commonQuestions.action">常见答疑</a></li>
						<li><a href="download.action">资料下载中心</a></li>
						<li><a href="advisorySuggestion.action">咨询|建议|投诉</a></li>
						<li><a href="http://chat32.live800.com/live800/chatClient/chatbox.jsp?companyID=131736&configID=16306&jid=3012363085&enterurl=http%3A%2F%2Fwww%2Ehoau%2Enet%2Fkhfw%2F&timestamp=1320893435803&pagereferrer=http%3A%2F%2Fwww%2Ehoau%2Enet%2F" target="__blank" onclick="_czc.push(['_trackPageview','在线客服','https://www.hoau.net'])">在线客服</a></li>
						<li><a href="contraband.action">禁运品</a></li>
					</ul>
				</div>
				<div class="link_row">
					<ul>
						<li><a href="companyProfile.action">华宇概述</a></li>
						<li><a href="hoauDynamic.action">华宇新闻</a></li>
						<li><a href="http://zhaopin.hoau.net" target="_blank">人才招聘</a></li>
						<li><a href="contactUs.action">联系我们</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<!--弹出省省市-->
<div class="provinceCityAll" ><!-- onmouseover="this.style.display='block'" onmouseout="this.style.display='none'"> -->
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
<%@include file="bottom.jsp" %>
<div class="right-bottom-box" id="right-bottom-box">
	<%--live-800在线客服--%>
	<div class="right-bottom-float live_800" style="display: block;width: 50px; height: 80px; margin: 0px auto">
		<span><a href="http://chat32.live800.com/live800/chatClient/chatbox.jsp?companyID=131736&configID=16306&jid=3012363085&enterurl=http%3A%2F%2Fwww%2Ehoau%2Enet%2Fkhfw%2F&timestamp=1320893435803&pagereferrer=http%3A%2F%2Fwww%2Ehoau%2Enet%2F" onclick="_czc.push(['_trackPageview','在线客服','https://www.hoau.net'])" target="_blank"><i class="ser_icon"></i><img src="${images}/kefu.jpg"/></a></span>
	</div>
	<div class="layer-header"><a href="javascript:void(0)" onclick="hiden('#right-bottom-box')" class="in-layer-close">关闭</a></div>
	<div class="right-bottom-float weixin mb10" style="display: block;">
		<div class="layer-content">
			<div class="layer-img"><img src="${images }/hoau-weixin-qr-code120-120.jpg" alt="官方微信二维码"/></div>
			<div class="layer-intro">关注微信 立减10元</div>
		</div>
	</div>
	<div class="right-bottom-float web_code" style="display: block;">
		<div class="layer-content">
			<div class="layer-img"><img src="${images }/hoau-web-qr-code120-120.jpg" alt="官方APP二维码"/></div>
			<div class="layer-intro">扫描下载官方APP</div>
		</div>
	</div>
</div>
<script  type="text/javascript">
    $(function(){
        var $bottomTools = $('.right-bottom-box');
        $(window).scroll(function () {
            var scrollHeight = $(document).height();
            var scrollTop = $(window).scrollTop();
            var $footerHeight = $('.footer').outerHeight(true);
            var $windowHeight = $(window).height();
            scrollTop > 50 ? $("#scrollUp").fadeIn(200).css("display","block") : $("#scrollUp").fadeOut(200);
            $bottomTools.css("bottom", scrollHeight - scrollTop - $footerHeight > $windowHeight ? 70 : $windowHeight + scrollTop + $footerHeight + 70 - scrollHeight);
        });
    });
</script>
</body>
</html>
