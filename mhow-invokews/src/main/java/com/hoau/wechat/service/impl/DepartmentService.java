package com.hoau.wechat.service.impl;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.NetRequestConstant;
import com.hoau.wechat.service.IDepartmentService;
import com.hoau.wechat.utils.NetUtil;
import com.hoau.wechat.utils.WTDistrictFactory;

/**
 * 
 * @author gaojia
 * 
 */
@Service
public class DepartmentService implements IDepartmentService {
	/**
	 * 根据经纬度及门店数量查询门店
	 * 
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param count
	 *            门店数量
	 */
	@Override
	public String queryDepartmentByTude(String province, String city, String county,String longitude, String latitude,String cond,
			String count) {
		// TODO Auto-generated method stub
//		return NetUtil.getData(NetRequestConstant.STATION_REQ + "/"
//				+ longitude + "/" + latitude + "/" +cond+"/"+ count);
		/**
		 * 掉调用网厅接口查询门店信息
		 * 2015-10-26
		 * @author 275636
		 * */
		return WTDistrictFactory.getDistrictServicePortType().queryDeptByDistrict(province, city, county, longitude, latitude, count);
	}
	
	public String queryDeartmentByDistance(String longitude, String latitude,
			String count ){
		return null;
	}

	@Override
	public String queryDepartmentPhone(String department) {
		
		return  NetUtil.getData(NetRequestConstant.STATION_REQ + "/"
				+ department);
	}
}
