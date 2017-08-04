$(document).on(
		"pageinit",
		"#mapPattern",
		function() {
			// 地图容器
			var map = new BMap.Map("l-map");
			var currentPoint;
			// 获取当前位置
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(show);
			} else {
				alert("Geolocation is not supported by this browser.");
			}

			function show(position) {
				lat = position.coords.latitude;
				lon = position.coords.longitude;
				currentPoint = new BMap.Point(lon, lat);
				map.centerAndZoom(currentPoint, 13);
				map.addControl(new BMap.ZoomControl());
				// 自定义图片
				var myIcon = new BMap.Icon(
						"https://api.map.baidu.com/mapCard/img/location.gif",
						new BMap.Size(14, 23), {
							anchor : new BMap.Size(7, 25)
						});
				// 创建标注
				var marker = new BMap.Marker(currentPoint, {
					icon : myIcon
				});
				// 将标注添加到地图中
				map.addOverlay(marker);
			}

			// 进入附近网点列表界面
			$("#departmentList").click(
					function() {
						var url = "/wechat/departmentList.action?lon=" + lon
								+ "&lat=" + lat + "&number=5" + "&cond=dis";
						window.location.href = url;
					});
			// 获取附近网点
			$("#nearbyDepartments").click(function() {
				var url = "/wechat/departmentListJson.action";
				var data = {
					lon : lon,
					lat : lat,
					number : 5,
					cond : "dis"
				};
				$.getJSON(url, data, nearbyDepartmentsCallback);
			});

			var lat, lon;
			// 将请求的获得坐标添加到地图上
			function nearbyDepartmentsCallback(data, status) {
				for (var i = 0; i < data.length; i++) {
					var lo = data[i].location.lon;
					var la = data[i].location.lat;
					// 在百度 map中显示地址
					var point = new BMap.Point(lo, la); // 创建点坐标
					var marker = new BMap.Marker(point);
					map.addOverlay(marker);
				}
			}
		});