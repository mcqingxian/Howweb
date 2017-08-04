package com.hoau.mhow.module.bse.server.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.hoau.mhow.module.bse.api.server.service.IDistrictInfoService;

/**
 * 省市区信息初始化类
 *
 * @author 蒋落琛
 * @date 2015-12-16
 */
@Service
public class DistrictInfoInit implements InitializingBean{
	
	@Resource
	private IDistrictInfoService iDistrictInfoService;

	@Override
	public void afterPropertiesSet() throws Exception {
		iDistrictInfoService.DistrictInfoInit();
	}

}
