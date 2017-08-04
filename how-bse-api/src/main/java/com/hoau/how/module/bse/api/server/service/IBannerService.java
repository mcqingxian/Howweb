package com.hoau.how.module.bse.api.server.service;

import java.util.List;

import com.hoau.how.module.bse.api.shared.domain.BannerEntity;

/**
 * @author：张爱萍
 * @create：2015年6月10日 上午10:08:37
 * @description：
 */
public interface IBannerService {

	public abstract List<BannerEntity> queryBanner();

}