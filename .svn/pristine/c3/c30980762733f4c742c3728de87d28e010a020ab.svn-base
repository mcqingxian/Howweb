package com.hoau.how.module.job.server.job;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoau.how.module.itf.server.service.IFranchiseSyncService;
/**
 *
 * @author 莫涛
 * @date 2015年8月18日18:29:09
 */
@Component
public class FranchiseSyncJob {
	
	private static final Log LOG = LogFactory.getLog(FranchiseSyncJob.class);
	@Resource
	private IFranchiseSyncService franchiseSyncService;
	
	@Scheduled(cron="0 20 1 * * ?")
    public void franchiseSync(){
		try {
			LOG.info("the FranchiseSyncJob start");
			franchiseSyncService.franchiseSync();
			LOG.info("the FranchiseSyncJob end");
		} catch (Exception e) {
			LOG.error("the FranchiseSyncJob Exception : " + e.getMessage());
			e.printStackTrace();
		}
    }
}
