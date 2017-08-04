package com.hoau.mhow.module.bse.api.server.service;

import java.util.List;

import com.hoau.mhow.invokews.server.ws.waybilldetail.WptYdInfo;

public interface IDcWaybillInfoService {
	public List<WptYdInfo> getYdinfos(List<String> waybills);
}
