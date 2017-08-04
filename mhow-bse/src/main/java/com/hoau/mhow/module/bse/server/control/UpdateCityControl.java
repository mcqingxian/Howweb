package com.hoau.mhow.module.bse.server.control;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoau.mhow.module.bse.api.server.service.IDistrictInfoService;

/**
 * @author：龙海仁
 * @create：2015年8月31日 上午10:43:04
 * @description：
 */
@Component
public class UpdateCityControl {
	private static final Log LOG = LogFactory.getLog(UpdateCityControl.class);
	
	@Resource
	private IDistrictInfoService iDistrictInfoService;
	
	@Scheduled(cron="0 0 2 * * ?")
    public void franchiseSync(){
		try {
			LOG.info("the UpdateCityControl start");
			iDistrictInfoService.DistrictInfoInit();
			LOG.info("the UpdateCityControl end");
		} catch (Exception e) {
			LOG.error("the UpdateCityControl Exception : " + e.getMessage());
			e.printStackTrace();
		}
    }
}
