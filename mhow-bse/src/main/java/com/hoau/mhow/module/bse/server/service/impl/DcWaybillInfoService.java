package com.hoau.mhow.module.bse.server.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.mhow.invokews.server.ws.waybilldetail.WptServices;
import com.hoau.mhow.invokews.server.ws.waybilldetail.WptServices_Service;
import com.hoau.mhow.invokews.server.ws.waybilldetail.WptYdInfo;
import com.hoau.mhow.module.bse.api.server.service.IDcWaybillInfoService;
import com.hoau.wechat.constant.PropertyConstant;

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
			service = new WptServices_Service(new URL(PropertyConstant.DC_WAYBILL_INFO_URL)).getWptServicesPort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<WptYdInfo> getYdinfos(List<String> waybills) {
		return service.getWptYdInfo(waybills);
	}

}
