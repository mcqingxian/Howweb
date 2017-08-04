package com.hoau.how.module.bse.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.FranchiseCityEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseInfoEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseProvinceEntity;
import com.hoau.how.module.bse.api.shared.vo.FranchiseRegistrationVo;

/**
 * 特许经营DAO
 * @author：张爱萍
 * @create：2015年6月23日 下午5:23:55
 * @description：
 */
@Repository
public interface FranchiseMapper {
	/**
	 * 查找所有的特许经营开发省份
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public List<FranchiseProvinceEntity>  selectAllProvince();
	
	/**
	 * 按照省份id查找城市
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public List<FranchiseCityEntity> selectCitysByPid(int pid);
	
	/**
	 * 增加特许经营报名信息
	 * 
	 * @param registrationInfo
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public void insertFranchiseInfo(FranchiseRegistrationVo registrationInfo);
	
	/**
	 * 根据城市id查找对应负责邮箱
	 * 联合公共邮箱
	 * @param cid
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月23日
	 * @update
	 */
	public List<String> selectEmailsByCid(int cid);
	
	/**
	 * 根据省市区查询特许经营区域管理人员信息
	 * @param franchiseInfoEntity
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午8:08:25
	 * @update
	 */
	public List<FranchiseInfoEntity> queryFranchiseInfo(FranchiseInfoEntity franchiseInfoEntity);
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
