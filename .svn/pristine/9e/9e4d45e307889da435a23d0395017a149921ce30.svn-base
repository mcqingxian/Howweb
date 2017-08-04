package com.hoau.how.module.bse.server.service.pricetime;

import java.io.IOException;
import java.util.List;

import com.hoau.how.module.bse.shared.vo.District;

public interface IDistrictService {
	
	public void loadDistrict() throws IOException;
	
	/**
	 * 从MDM接口拿到省的数据
	 * @throws IOException 
	 */
	public List<District> queryProvincesFromMDM() throws IOException;
	/**
	 * 从MDM接口拿到市的数据
	 * @throws IOException 
	 */
	public List<District> queryCitysFromMDM() throws IOException;
	/**
	 * 从MDM接口拿到区县的数据
	 * @throws IOException 
	 */
	public List<District> queryCountyFromMDM() throws IOException;
}
