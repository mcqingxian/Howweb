package com.hoau.how.module.bse.server.service.company.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.server.dao.company.CompanyMatchMapper;
import com.hoau.how.module.bse.server.service.company.ICompanyMatchService;
import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.bse.shared.vo.DistrictVo;

/**
 * @author：莫涛
 * @create：2015年6月25日 下午2:57:07
 * @description：
 */
@Service
public class CompanyMatchService implements ICompanyMatchService{
	@Resource
	CompanyMatchMapper companyMatchMapper;

	@Override
	public List<DistrictVo> queryProvinceCount(){
		List<DistrictVo> proVos = companyMatchMapper.queryProvinceCount();
		String provinceName = "";
		for (int i = 0; i < proVos.size(); i++) {
			provinceName = proVos.get(i).getDistrictName();
			if(provinceName.equals("内蒙古自治区")){
				provinceName="内蒙古";
			}else if(provinceName.equals("宁夏回族自治区")){
				provinceName="宁夏";
			}else if(provinceName.equals("广西壮族自治区")){
				provinceName="广西";
			}else if(provinceName.equals("新疆维吾尔自治区")){
				provinceName="新疆";
			}else if(provinceName.equals("西藏自治区")){
				provinceName="西藏";
			}else if(provinceName.equals("香港特别行政区")){
				provinceName="香港";
			}else if(provinceName.equals("澳门特别行政区")){
				provinceName="澳门";
			}
			proVos.get(i).setDistrictName(provinceName);
		}
		return proVos;
	}

	@Override
	public List<DistrictVo> queryCityCount(Map<String,String> map) {
		return companyMatchMapper.queryCityCount(map);
	}

	@Override
	public List<DistrictVo> queryCountyCount(String districtCode) {
		return companyMatchMapper.queryCountyCount(districtCode);
	}

	@Override
	public List<DepartmentVo> queryCounty(Map<String,String> map) {
		List<DepartmentVo> vos = companyMatchMapper.queryCounty(map);
		for (int i = 0; i < vos.size(); i++) {
			DepartmentVo vo = vos.get(i);
			vo.setServiceName(convertServiceName(vo));
		}
		return vos;
	}
	
	private String convertServiceName(DepartmentVo vo){
		StringBuffer serviceName = new StringBuffer("");
		if(vo.getIsShipment().equals("Y")){
			serviceName.append("发货").append("、");
		}
		if(vo.getIsPickUp().equals("Y")){
			serviceName.append("自提").append("、");
		}
		if(vo.getIsDelivery().equals("Y")){
			serviceName.append("送货").append("、");
		}
		if(serviceName.length() > 0){
			serviceName.delete(serviceName.length()-1, serviceName.length());
		}
		return serviceName.toString();
	}

	@Override
	public List<DepartmentVo> queryDeptByDistrictName(Map<String, String> map) {
		List<DepartmentVo> vos = companyMatchMapper.queryDeptByDistrictName(map);
		/**
		 * @author 唐征征
		 * @date 2017/7/14 下午1:39
		 * @description 模糊匹配增加条件  如果输入了详细地址而查不到网点,那么忽略详细地址,依次类推,忽略 县,市,省,忽略方式为条件置空字符串
		 */

		if(vos.size()==0){
			if(map.containsKey("addressDetail")){
				map.put("addressDetail","");
				vos = companyMatchMapper.queryDeptByDistrictName(map);
				if(vos.size()==0){
					if(map.containsKey("county")){
						map.put("county","");
						vos = companyMatchMapper.queryDeptByDistrictName(map);
						if(vos.size()==0){
							if(map.containsKey("city")){
								map.put("city","");
								vos = companyMatchMapper.queryDeptByDistrictName(map);
								if(vos.size()==0){
									if(map.containsKey("province")){
										map.put("province","");
										vos = companyMatchMapper.queryDeptByDistrictName(map);
									}
								}
							}
						}
					}
				}
			}
		}



		for (int i = 0; i < vos.size(); i++) {
			DepartmentVo vo = vos.get(i);
			vo.setServiceName(convertServiceName(vo));
		}
		return vos;
	}

	@Override
	public List<DistrictVo> queryHotCity() {
		return companyMatchMapper.queryHotCity();
	}
}