package com.hoau.how.module.itf.server.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.itf.server.service.IDcWaybillInfoService;
import com.hoau.how.module.itf.server.ws.waybilldetail.WaybillInfo;
import com.hoau.how.module.itf.server.ws.waybilldetail.WptServices;
import com.hoau.how.module.itf.server.ws.waybilldetail.WptServices_Service;
import com.hoau.how.module.itf.server.ws.waybilldetail.WptYdInfo;

/**
 *
 * @author 徐俊
 * @date 2015年6月16日
 */
@Service
public class DcWaybillInfoService implements IDcWaybillInfoService {
	public static final Log LOG = LogFactory.getLog(DcWaybillInfoService.class);
	protected static WptServices service = null;
	static{
		try {
			service = new WptServices_Service(new URL(ItfConifgConstant.DC_WAYBILL_INFO_URL)).getWptServicesPort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<WptYdInfo> getYdinfos(List<String> waybills) {
		return service.getWptYdInfo(waybills);
	}
	@Override
	public WaybillInfo queryOneWaybill(String mobile,String date) {
		return service.queryOneWaybill(mobile,date);
	}

}
