<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增值服务</title>
<%@include file="../head.jsp" %>
</head>

<body>
<%@include file="../top.jsp" %>
<div class="content">
	<div class="p_w">
		<%@include file="leftNavigation.jsp" %>
		<div class="col_right fr">
			<div class="drd_pic"><img src="${images}/150602_img02.jpg" width="796" /></div>
			<div class="news_detail">
				<h1 class="news_title">送货服务</h1>
				<div class="news_content">
					<p style="color:#000;">定时、定点，送到家</p>
					<p>　　不论货物大小，由我司将客户的货物护送至客户指定地址的楼梯口或一楼室内，安全卸下交付给客户的服务</p><br />
					<p style="color:#000;">　　1）标准送货</p>
					<p>　　标准送货指客户所在地距离送货网点距离不超过30公里，根据货物重量体积以及送货网点所在城市类别进行收费</p>
					<br />
					<div style="width:500px;" class="mb15">
					<table border="0" cellspacing="0" cellpadding="0" width="100%" class="zzfu_tab f12">
						<tr bgcolor="#eeeeee">
							<td width="46%">货物单票重量M（公斤）/体积V(立方)</td>
							<td width="18%">一类城市</td>
							<td width="18%">二类城市</td>
							<td width="18%">三类城市</td>
						</tr>
						<tr>
							<td>M＜=300  且  V＜=1.5</td>
							<td>70</td>
							<td>60</td>
							<td>50</td>
						</tr>
						<tr>
							<td>300＜M＜=600  或  1.5＜V＜=3</td>
							<td>100</td>
							<td>90</td>
							<td>80</td>
						</tr>
						<tr>
							<td>600＜M＜=1000  或  3＜V＜=5</td>
							<td>120</td>
							<td>110</td>
							<td>100</td>
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
					</table>
					</div>
					<div style="width:500px;">
					<table border="0" cellspacing="0" cellpadding="0" width="100%" class="zzfu_tab f12">
						<tr bgcolor="#eeeeee">
							<td width="18%">城市级别</td>
							<td width="64%">到达网点城市名称</td>
						</tr>
						<tr>
							<td>一类城市</td>
							<td align="left">
								1）北京、上海、广州、深圳、南京、杭州、佛山
								<br/>
								2）偏线代理点(港澳台除外)
							</td>
						</tr>
						<tr>
							<td>二类城市</td>
							<td align="left">地级市(地级市所管辖的县级市及县除外)</td>
						</tr>
						<tr>
							<td>三类城市</td>
							<td align="left">县级市及县(一类二类城市之外的所有城市及和地区)</td>
						</tr>
					</table>
					</div>
					<br />
					<p>　　备注：城市分级：将我司所有送货网点所在区域分为三类城市。</p>
					<br />
				</div>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
<%@include file="../bottom.jsp" %>
</body>
</html>
