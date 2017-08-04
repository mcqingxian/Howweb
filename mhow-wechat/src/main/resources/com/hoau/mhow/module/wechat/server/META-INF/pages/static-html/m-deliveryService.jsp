<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ include file="../../bse/common.jsp" %> 
<title>送货服务</title> 
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
						<h1 class="innertitle">送货服务</h1>
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
					<p style="color:#000;">定时、定点，送到家</p>
					<p>　　不论货物大小，由我司将客户的货物护送至客户指定地址的楼梯口或一楼室内，安全卸下交付给客户的服务</p><br>
					<p style="color:#000;">　　1）标准送货</p>
					<p>　　标准送货指客户所在地距离送货网点距离不超过30公里，根据货物重量体积以及送货网点所在城市类别进行收费</p>
					<br>
					
					<table border="0" cellspacing="0" cellpadding="0" width="100%" class="zzfu_tab f12">
						<tbody><tr bgcolor="#eeeeee">
							<td width="46%">货物单票重量M（公斤）/体积V(立方)</td>
							<td width="18%">一类城市</td>
							<td width="18%">二类城市</td>
							<td width="18%">三类城市</td>
						</tr>
						<tr>
							<td>M＜=300  且  V＜=1.5</td>
							<td>60</td>
							<td>50</td>
							<td>40</td>
						</tr>
						<tr>
							<td>300＜M＜=600  或  1.5＜V＜=3</td>
							<td>90</td>
							<td>80</td>
							<td>70</td>
						</tr>
						<tr>
							<td>600＜M＜=1000  或  3＜V＜=5</td>
							<td>110</td>
							<td>100</td>
							<td>90</td>
						</tr>
						<tr>
							<td>1000＜M＜=2000  或  5＜V＜=10</td>
							<td colspan="3">200</td>
						</tr>
						<tr>
							<td>2000＜M＜=3000  或  10＜V＜=15</td>
							<td colspan="3">300</td>
						</tr>
						<tr>
							<td>M＞3000  或  V ＞15</td>
							<td colspan="3">400</td>
						</tr>
					</tbody></table>
					
					<br>
					<table border="0" cellspacing="0" cellpadding="0" width="100%" class="zzfu_tab">
						<tbody><tr bgcolor="#eeeeee">
							<td width="18%">城市级别</td>
							<td width="64%">到达网点城市名称</td>
							<td width="18%">最低收费</td>
						</tr>
						<tr>
							<td>一类城市</td>
							<td>北京、上海、广州、深圳、南京、杭州</td>
							<td>60元/票</td>
						</tr>
						<tr>
							<td>二类城市</td>
							<td>地级市(地级市所管辖的县级市及县除外)</td>
							<td>50元/票</td>
						</tr>
						<tr>
							<td>三类城市</td>
							<td>县级市及县(一类二类城市之外的所有城市及和地区)</td>
							<td>40元/票</td>
						</tr>
					</tbody></table>
					
					<br>
					<p>　　备注：城市分级：将我司所有送货网点所在区域分为三类城市。</p>
					<br>
					<p style="color:#000;">　　2）远距离送货</p>
					<p>　　远距离送货指客户所在地距离送货网点距离超过30公里不超过60公里，若超过60公里，不提供此服务。</p>
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