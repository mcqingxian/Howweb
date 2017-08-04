package com.hoau.how.module.itf.server.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;






import org.springframework.stereotype.Service;

import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.itf.server.service.IGetYdTraceManager;
import com.hoau.how.module.itf.server.ws.goodstrace.TNTService;
import com.hoau.how.module.itf.server.ws.goodstrace.TNTServiceService;
import com.hoau.how.module.itf.server.ws.goodstrace.YdTrace;
import com.hoau.how.module.itf.server.ws.goodstrace.YdTraceResponse;

@Service
public class GetYdTraceManager implements IGetYdTraceManager{
	
	protected static TNTService service = null;
	static{
		try {
			service = new TNTServiceService(new URL(ItfConifgConstant.GOODS_TRACE_URL)).getTNTServicePort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取货物追踪数据
	 */
	@Override
	public List<YdTrace> getYdTraceList(List<String> transNos) {
		YdTraceResponse resp = service.getWebYdTrace(transNos,null,null,null);
		List<YdTrace> list = resp.getYdTraces();
		return list;
	}
	
	public static void main(String[] args) {
		GetYdTraceManager getYdTraceManager = new GetYdTraceManager();
		List<String> wbs = new ArrayList<String>();
		wbs.add("F3574261");
		List<YdTrace> test  = getYdTraceManager.getYdTraceList(wbs);
		System.out.println(test);
	}
}
