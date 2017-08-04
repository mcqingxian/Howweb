package com.hoau.how.module.itf.server.service;

import java.util.List;

import com.hoau.how.module.itf.server.ws.waybilldetail.WaybillInfo;
import com.hoau.how.module.itf.server.ws.waybilldetail.WptYdInfo;

public interface IDcWaybillInfoService {
	public List<WptYdInfo> getYdinfos(List<String> waybills);
	public WaybillInfo queryOneWaybill(String mobile,String date);
}
