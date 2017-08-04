<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<script  type="text/javascript" src="${scripts}/public.js"></script>

<%--监控客服 PV UV--%>
<script>
    //声明_czc对象:
    var _czc = _czc || [];
    //绑定siteid，请用您的siteid替换下方"XXXXXXXX"部分
    _czc.push(["_setAccount", "1262570488"]);
</script>


<div class="header">
	<div class="p_w">
		<a href="index.action" class="fl logo"></a>
		<div class="topnav fr f14">
			<div class="tdhy_toolbar">
				<ul class="btns">
					<li class="registOrExit">
						<c:if test="${sessionScope.USER_INFO == null or sessionScope.LOGIN_TYPE == null}">
							<a href="regist.action">注册</a>
						</c:if>
						<c:if test="${sessionScope.USER_INFO != null and sessionScope.LOGIN_TYPE != null}">
							<a href="loginAction!exit.action">退出</a>
						</c:if>
					</li>
					<li class="login">
						<c:if test="${sessionScope.USER_INFO == null or sessionScope.LOGIN_TYPE == null}">
							<a href="login.action">登录</a>
						</c:if>
						<c:if test="${sessionScope.USER_INFO != null and sessionScope.LOGIN_TYPE != null}">
							欢迎您：
							<a href="personalDataAction!index.action">
								<s:if test="#session.USER_INFO.ebccContactName != null && #session.USER_INFO.ebccContactName != \"\"">
									<s:property value="#session.USER_INFO.ebccContactName"/>
								</s:if>
								<s:elseif test="#session.USER_INFO.ebccNetLogin != null && #session.USER_INFO.ebccNetLogin != \"\"">
									<s:property value="#session.USER_INFO.ebccNetLogin"/>
								</s:elseif>
								<s:elseif test="#session.USER_INFO.ebccMobile != null && #session.USER_INFO.ebccMobile != \"\"">
									<s:property value="#session.USER_INFO.ebccMobile"/>
								</s:elseif>
							</a>
						</c:if>
						<%-- 
						<div class="login_layerbox">
							<div class="login_layerbox_left tc">
								<div class="login_layerbox_tl">用官方APP扫描安全登录</div>
								<div class="login_layerbox_code"><img src="${images}/150602_img01.png" width="122" /></div>
							</div>
							<div class="login_layerbox_right">
								<div class="login_layerbox_tl">手机账号、邮箱账号，请直接登录</div>
								<p class="login_error_tips" style="visibility: visible;">请输入登录名</p>
								<ul class="loginformlist">
									<li class="loginname_box border-all">
										<span class="loginname_icon"></span><input type="text" value="手机号/邮箱/用户名" name="" class="inputFocus grays" ov="手机号/邮箱" />
									</li>
									<li class="loginname_box border-all">
										<span class="loginpwd_icon"></span><input type="text" value="6-16个字符" name="" class="inputFocus grays" ov="6-16个字符" /></li>
									<li>
										<a href="javascript:;" class="login_btn">登录</a>
										<label class="rmb_login">
											<input name="" type="checkbox" class="auto_checkbox" checked="checked"><span>下次自动登录</span></label>
									</li>
									<li>
										<a href="#" class="f_f15a22 mr10" target="_blank">忘记密码</a>
										<a href="#" class="f_f15a22" target="_blank">立即注册</a>
									</li>
									<li>
										使用合作账号登入：<a href="#"><img src="${images}/qq.jpg" width="15" class="mr10" style="vertical-align: middle;" /></a><a href="#"><img src="${images}/sina.jpg" width="16"  style="vertical-align: middle;" /></a>
									</li>
								</ul>
							</div>			
						</div>
						--%>
					</li>		
				</ul>
			</div>
			<p class="tr">
				<!-- -
				<span><a href="javascript:addFavorite();">收藏华宇</a></span>
				 -->
				<span><a href="http://club.hoau.net/" target="view_window" class="f_f15a22">进入橙色俱乐部</a></span>
				<span><a href="orderAction!index.action"><i class="single_icon"></i>网上下单</a></span>
				<span><a href="http://chat32.live800.com/live800/chatClient/chatbox.jsp?companyID=131736&configID=16306&jid=3012363085&enterurl=http%3A%2F%2Fwww%2Ehoau%2Enet%2Fkhfw%2F&timestamp=1320893435803&pagereferrer=http%3A%2F%2Fwww%2Ehoau%2Enet%2F" target="_blank" onclick="_czc.push(['_trackPageview','在线客服','https://www.hoau.net'])"><i class="ser_icon"></i>在线客服</a></span>
				<span><a href="advisorySuggestion.action"><i class="mage_icon"></i>留言</a></span>
				<span><a href="requestclaim.action"><i class="claims_icon"></i>理赔</a></span>
				<span>服务热线：400-808-6666</span>
			</p>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="nav">
	<div class="p_w">
		<ul>
			<!-- 首页 -->
			<li><a href="index.action" <c:if test="${(!empty categoryName) && ('首页' eq categoryName)}">class="navcurrent"</c:if>>首页</a></li>
			<!-- 我的华宇 -->
			<li><a href="orderAction!index.action"<c:if test="${(!empty categoryName) && ('网上下单' eq categoryName ||'批量下单' eq categoryName ||'所有订单' eq categoryName || '我的运单' eq categoryName || '我的理赔' eq categoryName || '理赔申请' eq categoryName ||'理赔查询' eq categoryName || '个人资料管理' eq categoryName || '订单模板管理' eq categoryName || '发货人管理' eq categoryName || '收货人管理' eq categoryName)}">class="navcurrent"</c:if>>我的华宇</a>
				<ul class="navlist01">
					<li><a href="orderAction!index.action" class="navlist02_menu01"><span>网上下单</span><i></i></a></li>
					<li><a href="batchOrderAction!index.action" class="navlist02_menu02"><span>批量下单</span><i></i></a></li>
					<li><a href="myOrdersAction!queryMyOrders.action" class="navlist01_menu01"><span>我的订单</span><i></i></a></li>
					<li><a href="requestclaim.action" class="navlist01_menu02"><span>我的理赔</span><i></i></a></li>
					<%--<li><a href="http://online.hoau.net/THOMS/logining.do" target="_blank" class="navlist01_menu02"><span>我的理赔</span><i></i></a></li> --%>
					<li><a href="personalDataAction!index.action" class="navlist01_menu04"><span>我的资料管理</span><i></i></a></li>
				</ul>
			</li>
			<!-- 自助服务 -->
			<li><a href="traceTransByNo.action"<c:if test="${(!empty categoryName) && ('货物追踪' eq categoryName || '网点匹配' eq categoryName || '网点筛选' eq categoryName || '到货网点匹配' eq categoryName || '批量到货网点匹配' eq categoryName || '价格时效' eq categoryName)}"> class="navcurrent"</c:if>>自助服务</a>
				<ul class="navlist02">					
					<li><a href="traceTransByNo.action" class="navlist02_menu03"><span>货物追踪</span><i></i></a></li>
					<li><a href="companyMatchAction!index.action" class="navlist02_menu04"><span>网点查询</span><i></i></a></li>
					<li><a href="showPriceTime.action" class="navlist02_menu05"><span>价格时效查询</span><i></i></a></li>
					<!-- <li><a href="#" class="navlist02_menu06"><span>理赔综合查询</span><i></i></a></li> -->
				</ul>
			</li>
			<!-- 产品与服务 -->
			<li><a href="drdIntroduction.action" <c:if test="${(!empty categoryName) && ('定日达' eq categoryName || '经济快运' eq categoryName || '专车达' eq categoryName || '易到家' eq categoryName || '代收货款' eq categoryName || '保价运输' eq categoryName || '安全包装' eq categoryName || '送货服务' eq categoryName || '其他' eq categoryName || '市场推广' eq categoryName)}">class="navcurrent"</c:if>>产品与服务</a>
				<ul class="navlist03">
					<li><a href="drdIntroduction.action" class="navlist03_menu01"><span>主营产品</span><i></i></a></li>
					<li><a href="collectingMoney.action" class="navlist03_menu02"><span>增值服务</span><i></i></a></li>
					<li><a href="marketActivity.action" class="navlist03_menu03"><span>市场活动</span><i></i></a></li>
				</ul>
			</li>
			<!-- 企业服务 -->
			<li><a href="e-commerce.action" <c:if test="${(!empty categoryName) && ('电商合作' eq categoryName || '开放平台' eq categoryName || '采购平台' eq categoryName || '投标报名' eq categoryName)}">class="navcurrent"</c:if>>企业服务</a>
				<ul class="navlist04">
					<li><a href="e-commerce.action" class="navlist04_menu02"><span>电商合作</span><i></i></a></li>
					<li><a href="terrace.action" class="navlist04_menu05"><span>开放平台</span><i></i></a></li>
					<li><a href="http://sou.hoau.net" target="_blank" class="navlist04_menu03"><span>采购平台</span><i></i></a></li>
					<li><a href="http://114.141.133.241:8080/bid/toLogin.do" target="_blank" class="navlist04_menu04"><span>投标报名</span><i></i></a></li>					
				</ul>
			</li>
			<!-- 特许经营 -->
			<li><a href="franchise.action?newsId=12903" <c:if test="${(!empty categoryName) && ('经营资质' eq categoryName || '招商区域' eq categoryName ||  '特许动态' eq categoryName || '在线报名' eq categoryName)}">class="navcurrent"</c:if>>特许经营</a>
				<ul class="navlist07">
					<li><a href="franchise.action?newsId=12903" class="navlist07_menu01"><span>经营资质</span><i></i></a></li>
					<li><a href="franchiseArea.action" class="navlist07_menu02"><span>招商区域</span><i></i></a></li>
					<li><a href="franchiseDynamic.action" class="navlist07_menu03"><span>特许动态</span><i></i></a></li>
					<li><a href="franchiseRegist.action" class="navlist07_menu04"><span>在线报名</span><i></i></a></li>
				</ul>
			</li>
			<!-- 帮助与支持 -->
			<li><a href="#" <c:if test="${(!empty categoryName) && ('新手指南' eq categoryName || '常见答疑' eq categoryName || '资料下载中心' eq categoryName || '咨询建议' eq categoryName || '投诉' eq categoryName || '在线客服' eq categoryName)|| '禁运品' eq categoryName}">class="navcurrent"</c:if>>帮助与支持</a>
				<ul class="navlist05">
					<%-- <li><a href="#" class="navlist05_menu01"><span>新手指南</span><i></i></a></li> --%>
					<li><a href="commonQuestions.action" class="navlist05_menu02"><span>常见答疑</span><i></i></a></li>
					<li><a href="download.action" class="navlist05_menu03"><span>资料下载中心</span><i></i></a></li>
					<li><a href="advisorySuggestion.action" class="navlist05_menu04"><span>咨询|建议|投诉</span><i></i></a></li>
					<li><a href="http://chat32.live800.com/live800/chatClient/chatbox.jsp?companyID=131736&configID=16306&jid=3012363085&enterurl=http%3A%2F%2Fwww%2Ehoau%2Enet%2Fkhfw%2F&timestamp=1320893435803&pagereferrer=http%3A%2F%2Fwww%2Ehoau%2Enet%2F" target="__blank" class="navlist05_menu05" onclick="_czc.push(['_trackPageview','在线客服','https://www.hoau.net'])"><span>在线客服</span><i></i></a></li>
					<li><a href="contraband.action" class="navlist05_menu06"><span>禁运品</span><i></i></a></li>
				</ul>
			</li>
			<!-- 关于华宇 -->
			<li><a href="companyProfile.action" <c:if test="${(!empty categoryName) && ('公司简介' eq categoryName|| '大事记' eq categoryName || '资质荣誉' eq categoryName || '社会责任' eq categoryName 
			|| '新闻中心' eq categoryName || '天地华宇动态' eq categoryName || '华宇公告' eq categoryName || '媒体报道' eq categoryName || '物流资讯' eq categoryName  
			|| '人才招聘' eq categoryName || '联系我们' eq categoryName)}">class="navcurrent"</c:if>>关于华宇</a>
				<ul class="navlist06">
					<li><a href="companyProfile.action" class="navlist06_menu01"><span>华宇概述</span><i></i></a></li>
					<li><a href="hoauDynamic.action" class="navlist06_menu02"><span>华宇新闻</span><i></i></a></li>
					<li><a href="http://www.itiaoling.com/" target="_blank" class="navlist06_menu05"><span>跳羚科技</span><i></i></a></li>
					<li><a href="http://zhaopin.hoau.net" target="_blank" class="navlist06_menu03"><span>人才招聘</span><i></i></a></li>
					<li><a href="contactUs.action" class="navlist06_menu04"><span>联系我们</span><i></i></a></li>
				</ul>
			</li>
		</ul>
		<div class="clearfix"></div>
	</div>
</div>