package com.hoau.how.module.job.server.job;


import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoau.how.module.itf.server.service.IDistrictSyncService;

/**
 *
 * @author 徐俊
 * @date 2015年6月24日
 */
@Component
public class DistrictSyncJob {
	private static final Log LOG = LogFactory.getLog(DistrictSyncJob.class);
	@Resource
	private IDistrictSyncService districtSyncService;
	
	@Scheduled(cron="0 10 1 * * ?")
    public void districtSync(){
		try {
			LOG.info("the DistrictSyncJob start");
			districtSyncService.districtSync();
			LOG.info("the DistrictSyncJob end");
		} catch (Exception e) {
			LOG.error("the DistrictSyncJob Exception : " + e.getMessage());
			e.printStackTrace();
		}
    }
}
