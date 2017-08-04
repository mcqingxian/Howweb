<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>到货网点匹配</title>
	<meta name="Keywords" content="公路快运,物流货运,天地华宇,天地华宇物流,天地华宇物流查询,华宇物流,华宇物流查询,天地华宇俱乐部,华宇俱乐部，中信产业基金" />
	<meta name="Description" content='天地华宇是中信产业投资基金管理有限公司（简称中信产业基金）旗下的全资公司，也是国家第一批"AAAAA"级资质的物流企业。天地华宇的前身华宇物流1995年成立于广州，总部设在上海，拥有中国最大的公路快运网络之一。截止2013年10月，天地华宇在全国600个大中城市拥有56个货物转运中心、1500家营业网点和16000名员工,全国客服热线400-808-6666' />
	<link rel="Shortcut Icon" href="${images}/ico.png" type="image/x-icon"/>
	<script type="text/javascript" src="${scripts}/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="${scripts}/jquery.jtabs.js"></script>
	<link href="${styles}/base.css" rel="stylesheet" type="text/css" />
	<link href="${styles}/master.css" rel="stylesheet" type="text/css" />
	<link href="${styles}/addition.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
        $(function(){
            $(".subNav").click(function(){
                $(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
                // 修改数字控制速度， slideUp(500)控制卷起速度
                $(this).next(".navContent").slideToggle(100).siblings(".navContent").slideUp(100);
            })
            $('.letter_tab').jtabs('.letter_list', {fx: 'fade', activeClass: 'active', event: 'click', initIdx: 0});

            //批量到货网点匹配
            $(".tosnmiddle_btn").click(function(){
                var fileField = $("#fileField").val();
                if(fileField != ""){
                    $(".black_overlay").css("display","block");
                    $("#msg_div").html("");
                    $("#uploadForm").submit();
                    //启动定时器监控数据
                    setInterval(queryDownLoadStatus, "1000");
                }else{
                    alert("请选择文件！");
                }
            });

            function queryDownLoadStatus(){
                $.post("companyBatchQueryAction!queryDownLoadStatusJson.action",{
                    },
                    function(data, status) {
                        if(data.errorMsg != null){
                            $(".black_overlay").css("display","none");
                            $("#msg_div").html(data.errorMsg);
                            clearTimeout(downloadTimer);
                        }
                    }
                );
            }
        });
        //到货网点匹配
        function queryCompany(){
            var destination = $("#destination").val();
            //新增地址文本校验 肖聪
            var reg = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
            if(!reg.test(destination) && destination != ""){
                alert("提示:地址格式输入有误");
                return;
            }
            if(destination == ""){
                alert("请输入目的地址！");
                return;
            }else{
                $("#queryDestinationForm").submit();
            }
        }


	</script>
</head>

<body>
<%@include file="../../top.jsp" %>
<div class="arriveUpContent">
	<div class="p_w">
		<div class="map_box">
			<div class="map_top">
				<div class="map_t_tab fr">
					<a href="companyScreenAction!queryAll.action" class="map_t_tab_one">网点筛选</a>
					<a href="companyMatchAction!index.action" class="map_t_tab_two">网点匹配</a>
					<%--<a href="companyBatchQueryAction!index.action" class="map_t_tab_three">批量到货网点匹配</a>--%>
					<a href="javascript:void(0)" class="map_t_tab_fove active">到货网点匹配</a>
				</div>
				<span class="map_top_tit">
					到货网点匹配
				</span>
				<div class="clearfix"></div>
			</div>
			<div class="selectTypeArrive">
				<form action="companyQueryAction!queryDestination.action" method="post" id="queryDestinationForm" name="queryDestinationForm">
					目的地址：
					<input id="destination" name="destination" type="text" class="inputFocus" value="<s:property value="destination"/>"/>
					<input type="button" onclick="queryCompany();" class="tosnmiddle_btn2" value="查询" />
				</form>
			</div>
			<div class="resultList">
				<s:if test="#request.destinationVos != null">
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td>公司代码</td>
							<td>公司名称</td>
							<td>到货公司电话</td>
							<td>到货公司地址</td>
							<td>到货公司距离</td>
							<%--<td>是否在服务范围内</td>--%>
							<td>服务方式</td>
							<td>地图详情</td>
						</tr>

						<s:iterator id="item" value="#request.destinationVos">
							<tr>
								<td style="word-wrap: break-word;"><s:property value="#item.companyCode"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.companyName"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.companyPhone"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.companyAddress"/></td>
								<td style="word-wrap: break-word;"><s:property value="#item.distance"/></td>
								<%--<td style="word-wrap: break-word;" ><s:property value="#item.dispatchMsg"/></td>--%>
								<td style="word-wrap: break-word;" ><s:property value="#item.serviceType"/></td>
								<td style="word-wrap: break-word;">
									<form id="detailForm<s:property value="#item.rownumber"/>" name="detailForm<s:property value="#item.rownumber"/>" action="companyQueryAction!queryArriveCompanyDetail.action" method="post">
										<input name="code" id="code2" value="<s:property value="#item.companyCode"/>" style="display:none"/>
										<a href="javascript:void(0)" onclick="$('#detailForm<s:property value="#item.rownumber"/>').submit();" class="f_f15a22">更多详情</a>
									</form>
								</td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
			</div>
		</div>
	</div>
</div>
<%--批量到货网点匹配--%>
<div class="arriveBelowContent">
	<div class="p_w">
		<div class="map_box">
			<div class="map_top">
				<span class="map_top_tit">
					批量到货网点匹配
				</span>
				<div class="clearfix"></div>
			</div>
			<div class="map_main areaQuery">
				<div class="consignor_Mess">
					<div class="pl35 ">
						<a href="https://114.141.133.235:9080/download/%c5%fa%c1%bf%b5%bd%bb%f5%cd%f8%b5%e3%c6%a5%c5%e4%c4%a3%b0%e5.xls" target="_blank" class="f_f15a22">批量到货网点匹配模板.xls</a>
						<p>
							操作说明：<br />
							1.下载并填写批量到货网点匹配模板<br />
							2.上传模板 3.等待页面自动下载匹配好的数据<br />
							（页面响应时间较慢，请耐心等待；一次最多能匹配50条数据）
						</p>
					</div>
				</div>
				<div class="letters from_wrapper">
					<form action="companyBatchQueryAction!batchUploadCompany.action" method="post" enctype="multipart/form-data" name="uploadForm" id="uploadForm">
						<div class="file_box mb30">
							<input type="text" id="textfield01" class="file_txt" readonly="readonly" />
							<input type="button" class="file_btn" value="浏览..." />
							<input type="file" style="width:260px; left:0; right:0;" name="uploadFile" class="file_input" id="fileField" size="28" onchange="document.getElementById('textfield01').value=this.value" />
						</div>
						<div id="msg_div" class="mb30">
						</div>
						<div style="padding-left: 60px;">
							<input type="button" class="tosnmiddle_btn" value="提交"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="black_overlay" style="display:none;">
	<div style="background:#fff url(${images}/151026_load.gif) no-repeat 5px 50%; left:50%; top:50%; margin:-15px 0 0 -45px; width:55px; height:30px; line-height:30px; padding-left:33px;" class="pa">请稍后</div>
</div>
<%@include file="../../bottom.jsp" %>
</body>
</html>