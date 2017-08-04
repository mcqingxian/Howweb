/**
 * 
 */
package com.hoau.wechat.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.NetRequestConstant;
import com.hoau.wechat.entity.DistrictEntity;
import com.hoau.wechat.service.IDistrictService;
import com.hoau.wechat.utils.NetUtil;
import com.hoau.wechat.utils.WTDistrictFactory;
import com.hoau.wechat.ws.wt.ArrayOfDistrictModel;
import com.hoau.wechat.ws.wt.DistrictModel;

/**
 * @author gaojia
 * 
 */
@Service
public class DistrictService implements IDistrictService {

	@Override
	public List<DistrictEntity> queryProvince() {
		ArrayOfDistrictModel rs = WTDistrictFactory.getDistrictServicePortType().queryProvince();
		return getDistrictModelToDistrictEntity(rs.getDistrictModel());
//		return NetUtil.getData(NetRequestConstant.DISTRICT_PROVINCE_REQ);
	}
	
	private List<DistrictEntity> getDistrictModelToDistrictEntity(List<DistrictModel> districtModels){
		List<DistrictEntity> entities = new ArrayList<DistrictEntity>();
		if(districtModels.size() > 0){
			for(int index= 0,len=districtModels.size();index<len;index++){
				DistrictModel districtModel = districtModels.get(index);
				DistrictEntity districtEntity = new DistrictEntity();
				districtEntity.setDistrictCode(districtModel.getDistrictCode().getValue());
				districtEntity.setDistrictName(districtModel.getDistrictName().getValue());
				districtEntity.setTotal(districtModel.getTotal().getValue());
				entities.add(districtEntity);
			}
		}
		return entities;
	}

	@Override
	public List<DistrictEntity> queryCityByProvince(String province) {
		List<DistrictModel> rs = WTDistrictFactory.getDistrictServicePortType().queryCityByProvince(province).getDistrictModel();
		return getDistrictModelToDistrictEntity(rs);
		// TODO Auto-generated method stub
//		return NetUtil.getData(NetRequestConstant.DISTRICT_PROVINCE_REQ + "/"
//				+ province + "/" + NetRequestConstant.DISTRICT_CITY_REQ);
	}

	@Override
	public List<DistrictEntity> queryCountyByCity(String city) {
		List<DistrictModel> rs = WTDistrictFactory.getDistrictServicePortType().queryCountyByCity(city).getDistrictModel();
		return getDistrictModelToDistrictEntity(rs);
//		// TODO Auto-generated method stub
//		return NetUtil.getData(NetRequestConstant.DISTRICT_PROVINCE_REQ + "/"
//				+ province + "/" + NetRequestConstant.DISTRICT_CITY_REQ + "/"
//				+ city + "/" + NetRequestConstant.DISTRICT_COUNTY_REQ);
		
	}

	@Override
	public String queryStation(String province, String city, String county) {
//		return NetUtil.getData(NetRequestConstant.DISTRICT_PROVINCE_REQ + "/"
//				+ province + "/" + NetRequestConstant.DISTRICT_CITY_REQ + "/"
//				+ city + "/" + NetRequestConstant.DISTRICT_COUNTY_REQ+"/"+county+"/"+NetRequestConstant.DISTRICT_STATION_REQ);
		/**
		 * 调用网厅接口查询门店信息
		 * 2015-10-26
		 * @author 275636
		 * */
		return WTDistrictFactory.getDistrictServicePortType().queryDeptByDistrict(province, city, county, null, null, String.valueOf(30));
	}

}
