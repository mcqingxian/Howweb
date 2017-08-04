package com.hoau.how.module.bse.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.BannerEntity;

/**
 * banner Dao 层实现
 * @author：张爱萍
 * @create：2015年6月10日 上午9:52:19
 * @description：
 */
@Repository
public interface BannerMapper {
	/**
	 * 查询首页banner
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月10日
	 * @update
	 */
	public List<BannerEntity> queryBannerList();
}
