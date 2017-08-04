package com.hoau.how.module.job.server.job;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoau.how.module.itf.server.service.IOutBranchSyncService;
/**
 *
 * @author 莫涛
 * @date 2015年8月18日18:29:19
 */
@Component
public class OutBranchSyncJob {
	
	private static final Log LOG = LogFactory.getLog(OutBranchSyncJob.class);
	@Resource
	private IOutBranchSyncService outBranchSyncService;
	
	@Scheduled(cron="0 40 1 * * ?")
    public void outBranchSync(){
		try {
			LOG.info("the OutBranchSyncJob start");
			outBranchSyncService.outBranchSync();
			LOG.info("the OutBranchSyncJob end");
		} catch (Exception e) {
			LOG.error("the OutBranchSyncJob Exception : " + e.getMessage());
			e.printStackTrace();
		}
    }
}
