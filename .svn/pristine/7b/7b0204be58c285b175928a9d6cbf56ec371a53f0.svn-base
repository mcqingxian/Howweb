package com.hoau.how.module.bse.shared.utils;

import java.util.Random;

import com.hoau.how.module.bse.shared.vo.BaiduMapDriverDistanceResult;
import com.hoau.how.module.bse.shared.vo.DeptEntity;

public class BaiduMapDriverDistanceThread{
	public static String url = "http://api.map.baidu.com/direction/v1/routematrix?";

	// 计算行车距离接口每个ak每天只能调用10万次
	public static String[] aks = new String[] { "9g2XGuQqhWKoVym0FfZNlvvX",
			"1l9RMdXlnOgdywm7yhlDBgx5", "xVS31eF6Tj519THH1AGfiE5a",
			"7GBLDUarrZ4wqiALak8PCZsA", "8C4AsvLfBRVHwGTajztTM0SG",
			"44x5bagxY2lMgUKyHmlFGo9a", "I7ZOnLOXsW2xfnnDgn8f5zAU",
			"TF33O9pDfy2l1nemw1QEPEWB", "y81mpbAVBjsrWjP8NdsV63AN",
			"iCk4sGrdqmIc26Idha45wsbK", "aN9GltOqtBaGO1ziSnTUnnDf"};

	private DeptEntity dept;
	private String origins;

	public BaiduMapDriverDistanceThread(
			DeptEntity dept, String origins) {
		this.dept = dept;
		this.origins = origins;
	}

	public void driverDistanceFromBaidu() {
		Random r=new Random(); 
		String ak = aks[r.nextInt(11)];
		String destinations = dept.getO_lat() + "," + dept.getO_lng();
		String param = "output=json&origins="
				+ origins + "&destinations=" + destinations+"&ak="+ak;
		String res = ApiUtil.getResult(url + param);
		BaiduMapDriverDistanceResult result = JsonUtils.toObject(res,
				BaiduMapDriverDistanceResult.class);
		if ("0".equals(result.getStatus())) {
			dept.setDriver_distance(result.getResult().getElements().get(0)
					.getDistance().getValue());
			dept.setDriver_distance_text(result.getResult().getElements()
					.get(0).getDistance().getText());
		}
	}
}
