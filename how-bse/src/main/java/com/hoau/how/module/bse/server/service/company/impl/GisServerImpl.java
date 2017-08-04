package com.hoau.how.module.bse.server.service.company.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.how.module.bse.shared.utils.*;
import com.hoau.how.module.bse.shared.vo.*;
import com.hoau.how.module.common.constants.ItfConifgConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.server.service.company.GisServer;

/**
 * GisServer
 * 
 * @author Guixing Lv guixing.lv@hoau.net
 * @Time 2015年6月18日 上午8:54:38
 * @Description GIS服务类
 * @version 1.0.0
 */
@Service
public class GisServerImpl implements GisServer{
	private static final Logger log = LoggerFactory
			.getLogger(GisServerImpl.class);
	private String dispthName = "派送版图";
	private String takeTheirName = "自提版图";
	static int batNum = 80;
	
	@Override
	public List<NewExcelDataVo> getGisResult(List<OldExcelDataVo> list, String outputPath) {
		List<NewExcelDataVo> newList = new ArrayList<NewExcelDataVo>();
		List<RequestParam> addressList = new ArrayList<RequestParam>();
		for (int i = 0; i < list.size(); i++) {
			RequestParam requestParam = new RequestParam();
			String pcode = UUID.randomUUID().toString();
			requestParam.setO_pcode(pcode);
			list.get(i).setPcode(pcode);
			//固定值，G7平台使用
			requestParam.setT_orgcode("100282");
			requestParam.setO_string1("DC");
			requestParam.setO_string2("上海0");
			requestParam.setT_tasktype(3);
			requestParam.setO_consigneeaddr(list.get(i).getDestinationAddress());
			requestParam.setO_shipperaddr("");
			List<DictName>dictNameList = new ArrayList<DictName>();
			DictName dict1 = new DictName();
			dict1.setSs_dictname("\u81EA\u63D0\u7248\u56FE");
			DictName dict2 = new DictName();
			dict2.setSs_dictname("\u6D3E\u9001\u7248\u56FE");
			dictNameList.add(dict1);
			dictNameList.add(dict2);
			requestParam.setSs_dictname(dictNameList);
			addressList.add(requestParam);
		}
		int size = list.size();
		int cnt = 0;
		while (cnt < size) {
			List<RequestParam> subList = addressList.subList(cnt, (cnt + batNum) < size ? cnt + batNum : size);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("data", ApiUtil.toJson(subList));
			ApiResult apiResult = null;
			try {
				apiResult = ApiUtil.getResult("ips2.api.multipleorderaddrs",
						paramsMap);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
//				if(outputPath != null){
//					ExportExcel.exportExcel(newList,outputPath);
//				}
			}

			if (apiResult == null){
				throw new RuntimeException("系统异常");
			}

			if (StrUtil.equalsString(apiResult.getCode(), "0")) {
				Comparator<DeptEntity> comparator = new Comparator<DeptEntity>() {
					public int compare(DeptEntity o1, DeptEntity o2) {
						if(o1==null && o2!=null){
							return -1;
						}
						if(o1==null && o2==null){
							return 0;
						}
						if(o1!=null && o2==null){
							return 1;
						}else{
							if(o1.getDriver_distance()>o2.getDriver_distance()){
								return 1;
							}
							if(o1.getDriver_distance()==o2.getDriver_distance()){
								return 0;
							}else{
								return -1;
							}
						}
					}
				};
				Map<String, Map<String, DataEntity>> data = apiResult.getData();
				for (int index = cnt; index < ((cnt + batNum) < size ? cnt + batNum : size); index++) {
					Map<String, DataEntity> dispatchMap = data.get(list.get(
							index).getPcode());
					Map<String, DataEntity> takeTheirMap = data.get(list.get(
							index).getPcode());
					NewExcelDataVo newBean = new NewExcelDataVo();
					newBean.setDestinationAddress(list.get(index)
							.getDestinationAddress());
					if (dispatchMap.get(dispthName).getResult() != null && dispatchMap.get(dispthName).getResult().size() > 0){
						getDriverDistance(dispatchMap.get(dispthName));
						newBean.setDispatchCompany("N"
								+ dispatchMap.get(dispthName).getResult()
										.get(0).getSs_code());
						newBean.setDispatchMsg(0 == dispatchMap.get(dispthName)
								.getStatus() ? "否" : "是");
						newBean.setDispatchDistance(dispatchMap.get(dispthName).getResult().get(0).getDriver_distance_text());
					} else {
						newBean.setDispatchMsg(dispatchMap.get(dispthName)
								.getParams().get(0).getMessage());
					}
					if (takeTheirMap.get(takeTheirName).getResult() != null && takeTheirMap.get(takeTheirName).getResult().size() > 0){
						getDriverDistance(takeTheirMap.get(takeTheirName));
						Collections.sort(takeTheirMap.get(takeTheirName).getResult(),comparator);
						List<String> company = new ArrayList<String>();
						List<String> distance = new ArrayList<String>();
						for (int i = 0; i < takeTheirMap.get(takeTheirName).getResult().size(); i++) {
							company.add("N"
								+ takeTheirMap.get(takeTheirName).getResult()
								.get(i).getSs_code());
							distance.add(takeTheirMap.get(takeTheirName).getResult()
								.get(i).getDriver_distance_text());
						}
						newBean.setTakeTheirCompany(company);
						newBean.setSelfTakeDistance(distance);
					} else {
						newBean.setTakeTheirMsg(takeTheirMap.get(takeTheirName)
								.getParams().get(0).getMessage());
					}
					newBean.setErrMsg("");
					newList.add(newBean);
				}
			}
			cnt += batNum;
		}
		return newList;
	}
	private static void getDriverDistance(DataEntity dataEntity) {
		if(dataEntity!=null&&dataEntity.getResult()!=null&&dataEntity.getResult().size()>0){
	       /* CountDownLatch countDownLatch = new CountDownLatch(dataEntity.getResult()
					.size());*/
			for (DeptEntity deptEntity : dataEntity.getResult()) {
				new BaiduMapDriverDistanceThread(deptEntity, dataEntity.getLat()+","+dataEntity.getLng()).driverDistanceFromBaidu();
			}
			/*try {
				countDownLatch.await(1,TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}

	@Override
	public GisDestinationQueryResultDto queryDestinationBoundsFromGis(String address,String latitude,String longitude) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("o_pcode", UUID.randomUUID().toString());
		// 固定值，G7平台使用
		params.put("t_orgcode", "100282");
		params.put("o_string1", "DC");
		params.put("o_string2", "特许经营");
		// 为3 收货人地址必填
		params.put("t_tasktype", 3);
		params.put("o_consigneeaddr", address);
		params.put("ss_dictname", dispthName);//派送版图 自提版图
		params.put("app_key", ItfConifgConstant.GIS_APP_KEY);
		params.put("method", "ips2.api.getorderaddrfeipai");
//		params.put("o_lat", latitude);
//		params.put("o_lng", longitude);
		params.put("o_lat", latitude);
		params.put("o_lng", longitude);
		//0谷歌，1百度
		params.put("o_geotype", 0);
		// 时间戳
		params.put("timestamp",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		params.remove("sign");
		// 参数签名
		params.put("sign",
				GisInterfaceUtil.sign(params, ItfConifgConstant.GIS_APP_SECRET));

		String content = GisInterfaceUtil.createGisRequestParam(params);
		log.info(ItfConifgConstant.GIS_APP_URL + "?" + content);
		String response = GisInterfaceUtil.httpRequest(ItfConifgConstant.GIS_APP_URL,
				content);
		log.info(response);
		GisDestinationQueryResultDto result = JsonUtils.toObject(response,
				GisDestinationQueryResultDto.class);
		if (result.getCode() == 0) {
			List<GisExceptionMsgDto> exceptionMsgs = result.getData()
					.getParams();
			GisDestinationResultDto gisDestinationResultDto = result.getData();
			if (gisDestinationResultDto == null
					|| CollectionUtils.isEmpty(gisDestinationResultDto
					.getResult())) {
				throw new BusinessException(exceptionMsgs.get(0).getMessage()
						+ ",错误码：[" + exceptionMsgs.get(0).getResultcode() + "]");
			}
		} else {
			throw new BusinessException(result.getMessage());
		}
		return result;

	}






}
