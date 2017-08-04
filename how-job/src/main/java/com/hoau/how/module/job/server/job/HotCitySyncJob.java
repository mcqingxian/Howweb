package com.hoau.how.module.job.server.job;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hoau.how.module.itf.server.service.IDistrictSyncService;
import com.hoau.how.module.job.server.socket.IHotCitySocket;

/**
 * @author：莫涛
 * @create：2015年7月7日 上午10:13:00
 * @description：
 */
@Component
public class HotCitySyncJob {
	private static final Log LOG = LogFactory.getLog(HotCitySyncJob.class);
	@Resource
	private IDistrictSyncService districtSyncService;
	
	
	@Resource
	private IHotCitySocket hotCitySocket;
	
//	@Scheduled(cron="*/5 * * * * ?")
	
	@Scheduled(cron="0 30 1 * * ?")
    public void hotCitySync(){
		try {
			LOG.info("the HotCitySyncJob start");
			hotCitySocket.getLock().lock();
			if(hotCitySocket.getConcurrentMap().size() > 0){
				//更新热门城市
				districtSyncService.updateHotCityNum(hotCitySocket.getConcurrentMap());
			}
			//更新完成后，清空
			hotCitySocket.clearMap();
			LOG.info("the HotCitySyncJob end");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			hotCitySocket.getLock().unlock();
		}
    }
}