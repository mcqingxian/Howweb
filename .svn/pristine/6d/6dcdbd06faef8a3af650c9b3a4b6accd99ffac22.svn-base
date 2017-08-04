package com.hoau.how.module.job.server.job;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoau.how.module.itf.server.service.ICompanySyncService;
/**
 *
 * @author 徐俊
 * @date 2015年6月24日
 */
@Component
public class DepartmentSyncJob {
	
	private static final Log LOG = LogFactory.getLog(DepartmentSyncJob.class);
	@Resource
	private ICompanySyncService companySyncService;
	
	@Scheduled(cron="0 0 1 * * ?")
    public void companySync(){
		try {
			LOG.info("the CompanySyncJob start");
			companySyncService.companySync();
			LOG.info("the CompanySyncJob end");
		} catch (Exception e) {
			LOG.error("the CompanySyncJob Exception : " + e.getMessage());
			e.printStackTrace();
		}
    }
}
