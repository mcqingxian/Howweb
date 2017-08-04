package com.hoau.how.module.bse.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.api.server.service.IBannerService;
import com.hoau.how.module.bse.api.shared.domain.BannerEntity;
import com.hoau.how.module.bse.server.dao.BannerMapper;

/**
 * 首页Banner Service层实现
 * @author：张爱萍
 * @create：2015年6月10日 上午9:49:44
 * @description：
 */
@Service
public class BannerService implements IBannerService {
	@Resource
	private BannerMapper bannerMapper;
	
	/* (non-Javadoc)
	 * @see com.hoau.how.module.bse.server.service.impl.IBannerService#queryBanner()
	 */
	@Override
	public List<BannerEntity> queryBanner(){
		List<BannerEntity> bannerList = new ArrayList<BannerEntity>();
		bannerList = bannerMapper.queryBannerList();
		return bannerList;
	}
}
