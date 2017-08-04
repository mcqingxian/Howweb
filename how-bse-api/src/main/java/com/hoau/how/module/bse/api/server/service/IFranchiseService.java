package com.hoau.how.module.bse.api.server.service;

import java.util.List;

import com.hoau.how.module.bse.api.shared.domain.FranchiseCityEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseInfoEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseProvinceEntity;
import com.hoau.how.module.bse.api.shared.vo.FranchiseRegistrationVo;

/**
 * @author：张爱萍
 * @create：2015年6月23日 下午2:09:05
 * @description：
 */
public interface IFranchiseService {
	/**
	 * 查询所有的特许经营开放省
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public List<FranchiseProvinceEntity> queryAllFranchiseProvince();
	
	/**
	 * 根据省id查找该省对应的市
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public List<FranchiseCityEntity> queryCityByPid(Integer pid);
	
	/**
	 * 增加报名信息
	 * 
	 * @param registrationInfo
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public void saveFranchiseRegistInfo(FranchiseRegistrationVo registrationInfo,String customerIp);
	
	/**
	 * 查询特许经营区域信息
	 * @param franchiseInfoEntity
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午8:07:37
	 * @update
	 */
	public FranchiseInfoEntity queryFranchiseInfo(FranchiseInfoEntity franchiseInfoEntity);
	
	/**
	 * 查询特许经营省份
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午8:55:55
	 * @update
	 */
	public List<FranchiseProvinceEntity> queryFranchiseProvince();
	
	/**
	 * 根据省份信息查询特许经营市区
	 * @param province
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午8:55:59
	 * @update
	 */
	public List<FranchiseCityEntity> queryFranchiseCity(String province);
}
