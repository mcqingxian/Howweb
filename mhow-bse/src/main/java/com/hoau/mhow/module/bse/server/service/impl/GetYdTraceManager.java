package com.hoau.mhow.module.bse.server.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.mhow.invokews.server.ws.goodstrace.TNTService;
import com.hoau.mhow.invokews.server.ws.goodstrace.TNTServiceService;
import com.hoau.mhow.invokews.server.ws.goodstrace.TraceInfo;
import com.hoau.mhow.invokews.server.ws.goodstrace.YdTrace;
import com.hoau.mhow.invokews.server.ws.goodstrace.YdTraceResponse;
import com.hoau.mhow.invokews.server.ws.waybilldetail.WptYdInfo;
import com.hoau.mhow.module.bse.api.server.service.IDcWaybillInfoService;
import com.hoau.mhow.module.bse.api.server.service.IGetYdTraceManager;
import com.hoau.mhow.module.bse.api.shared.vo.GoodsTraceResultVo;
import com.hoau.mhow.module.bse.api.shared.vo.TraceInfoVo;
import com.hoau.wechat.constant.PropertyConstant;

@Service
public class GetYdTraceManager implements IGetYdTraceManager{
	
	@Resource
	private IDcWaybillInfoService dcWaybillInfoService;
	
	protected static TNTService service = null;
	static{
		try {
			service = new TNTServiceService(new URL(PropertyConstant.TTQ_URL)).getTNTServicePort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取货物追踪数据
	 */
	@Override
	public GoodsTraceResultVo getYdTraceList(List<String> transNos) {
		YdTraceResponse resp = service.getWebYdTrace(transNos,null,null,null);
		//运单跟踪
		List<YdTrace> list =null;
		//货物信息
		List<WptYdInfo> infos = null;
		list = resp.getYdTraces();
		infos = dcWaybillInfoService.getYdinfos(transNos);
		GoodsTraceResultVo resultVo = new GoodsTraceResultVo();
		// 货物跟踪信息
		if(list != null && list.size() > 0){
			YdTrace ydTrace = list.get(0);
			String waybill = ydTrace.getConsignmentID();
			waybill = translateWaybill(waybill);
			//运单号
			resultVo.setWaybillNo(waybill);
			//跟踪记录
			resultVo.setTraceInfos(traceInfo(ydTrace.getTraceInfos()));
			//---------------货物基本信息				
			resultVo.setFromCity(ydTrace.getQydmc());
			resultVo.setToCity(ydTrace.getMddmc());
			resultVo.setTransMethod(ydTrace.getYslx());
			resultVo.setPickUpMethod(ydTrace.getThfs());
			if(infos!=null){
				//  重量 体积 货物名称 件数
				for(WptYdInfo wptYdInfo : infos){
					String wptYDBH = wptYdInfo.getYDBH();
					double weight = wptYdInfo.getZL();
					double volumn = wptYdInfo.getTJ();
					double pieces = wptYdInfo.getJS();
					String goodName = wptYdInfo.getHWMC();
					if(translateWaybill(wptYDBH).equalsIgnoreCase(waybill)){
						resultVo.setWeight(weight+"KG");
						resultVo.setVolume(volumn+"方");
						resultVo.setGoodsName(goodName);
						resultVo.setPieces(pieces+"件");
					}
				}
			}
			//---------------提货公司信息
			resultVo.setPickUpCompanyName(ydTrace.getThgsmc());
			resultVo.setPickUpCompanyAddress(ydTrace.getThgsdz());
			resultVo.setPickUpCompanyPhone(ydTrace.getThgsdh());
			resultVo.setCustomerServicePhone(ydTrace.getThgskfDh());
		}
		return resultVo;
	}
	
	private List<TraceInfoVo> traceInfo(List<TraceInfo> traceInfos) {
		List<TraceInfoVo> infoVos = new ArrayList<TraceInfoVo>();
		
		int size = traceInfos.size();
		
		boolean flag = true;
		boolean isWaybill = true;
		for(int i = size-1; i >= 0 ;i--){
			TraceInfo t =  traceInfos.get(i);
			TraceInfoVo traceInfoVo = new TraceInfoVo();
			
			String trace = t.getTraceInfo();
			
			traceInfoVo.setDesc(trace);
			traceInfoVo.setTime(t.getTraceTime());

			//只留一个运输中
			String transStatus = getStatus(trace,flag,isWaybill);
			if(transStatus.equals("运输中")){
				flag = false;
			}
			if(transStatus.equals("已开单")){
				isWaybill = false;
			}
			traceInfoVo.setStatus(transStatus);//TODO 运输状态 定义
			
			infoVos.add(traceInfoVo);
		}
		
		return infoVos;
	}
	
	/**
	 * 转换状态
	 * 
	 * @param trace
	 * @param isTrans
	 * @param isWaybill
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-10
	 * @update
	 */
	private String getStatus(String trace,boolean isTrans,boolean isWaybill) {
		String result = "";
		if(isTrans){
			result = "运输中";
		}
		if(trace.contains("录单") || trace.contains("收件扫描") || trace.contains("办理托运")){
			if(isWaybill){
				result = "已开单";
			}else{
				result = "";
			}
		}else if(trace.contains("签收")){
			result = "已签收";
		}else if(trace.contains("到达") && trace.contains("分公司")){
			result = "已到达";
		}
		return result;
	}
	
	private String translateWaybill(String waybill) {
		int length = waybill.length();
		if(length == 9){
			int a = Integer.valueOf(waybill.substring(0, 2))+64;
			char c = (char)a;
			return c+waybill.substring(2);
		}else{
			return waybill;
		}
	}
	
	/*public static void main(String[] args) {
		GetYdTraceManager getYdTraceManager = new GetYdTraceManager();
		List<String> wbs = new ArrayList<String>();
		wbs.add("F3574261");
		List<YdTrace> test  = getYdTraceManager.getYdTraceList(wbs);
		System.out.println(test);
	}*/
}
