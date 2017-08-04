<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp" %> 
<title>安全包装</title> 
</head>

<body>
<div data-role="page">
	<div id="wrapper">
			<div id="wrapper-in">
				<div id="main-page">
					<div class="header">
						<span class="btn-topl">
							<a class="link-back" href="javascript:history.go(-1);">
								<span class="ui-ico ui-ico-back"></span>
							</a>
						</span>
						<h1 class="innertitle">安全包装</h1>
						<span class="btn-topr">
							<a class="link-home" href="<%=request.getContextPath()%>/bse/index.action" title="主页" data-ajax='false'>
								<span class="ui-ico ui-ico-home"></span>
							</a>
							<a class="link-nav" href="javascript:void(0);" data-toggle="map-toggle">
								<span class="ui-ico ui-ico-nav"></span>
							</a>
						</span>
					</div>
					<div class="hoau_news">
				<div class="drd_pic"><img src="../images/wechat/150602_img02.jpg" width="100%"></div>
				<div class="news_content">
					<p style="color:#000;">安全包装360°      全方位的安全运输</p>
					<p>　　安全的包装是完美运送的第一步，天地华宇提供抗压纸箱、防水编织袋等包装材料，同时也提供专用的木架、木箱打包服务，以确保货物的安全运输。</p>
					<br>
					<p class="mb10" style="color:#000;">收费标准</p>
					<table border="0" cellspacing="0" cellpadding="0" width="100%" class="zzfu_tab f12">
						<tbody><tr bgcolor="#eeeeee">
							<td width="15%">收费项目</td>
							<td width="25%">包装名称</td>
							<td width="30%">收费标准</td>
							<td width="30%">说明（单位为CM）</td>
						</tr>
						<tr>
							<td rowspan="4">木包装</td>
							<td>木架</td>
							<td>200元/方，最低40元/票</td>
							<td>半封闭</td>
						</tr>
						<tr>
							<td>木箱</td>
							<td>300元/方，最低60元/票</td>
							<td>全封闭</td>
						</tr>
						<tr>
							<td rowspan="2">木托盘</td>
							<td>不超过标准托盘尺寸，80元/个</td>
							<td rowspan="2">标准托盘尺寸为120*100</td>
						</tr>
						<tr>
							<td>超过标准托盘尺寸，160元/个</td>
						</tr>
						<tr>
							<td rowspan="4">纤袋包装</td>
							<td>普通编织袋（小号）</td>
							<td>5元/个</td>
							<td>100*80</td>
						</tr>
						<tr>
							<td>普通编织袋（大号）</td>
							<td>8元/个</td>
							<td>140*100</td>
						</tr>
						<tr>
							<td>防水编织袋（小号）</td>
							<td>8元/个</td>
							<td>100*80</td>
						</tr>
						<tr>
							<td>防水编织袋（大号）</td>
							<td>10元/个</td>
							<td>140*100</td>
						</tr>
						<tr>
							<td rowspan="3">纸箱包装</td>
							<td>小号纸箱<br></td>
							<td>8元/个<br></td>
							<td>40*40*25</td>
						</tr>
						<tr>
							<td>中号纸箱<br></td>
							<td>10元/个</td>
							<td>55*45*35</td>
						</tr>
						<tr>
							<td>大号纸箱<br></td>
							<td>12元/个</td>
							<td>60*45*47</td>
						</tr>
						<tr>
							<td>缓冲物</td>
							<td>缠绕膜</td>
							<td>20元/立方,最低10元/票</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>其他包装</td>
							<td>打包带</td>
							<td>2元/条</td>
							<td>&nbsp;</td>
						</tr>
					</tbody></table>
					<br>
					<p>备注：1、北京地区打木架最低收费60元/票。</p>
					<p>　　　2、打木架/木箱货物，按照货物打完木架/木箱后体积收取包装费。打完木架/木箱后体积= 货物打包前体积*1.4。</p>
				</div>
			</div>
					<%@ include file="../../bse/footer.jsp" %> 			
				</div>
				<div id="map-page">
					<%@ include file="../../bse/nav-map.jsp" %>  
		    	</div>
			</div>
		</div>

</div>
</body>
</html>