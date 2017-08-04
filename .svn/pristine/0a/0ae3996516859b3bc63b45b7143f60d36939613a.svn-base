package com.hoau.how.module.bse.server.service.pricetime.impl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.server.service.pricetime.IDistrictService;

@Service
public class StartedExecutionProcessor implements ApplicationListener<ContextRefreshedEvent> {

	@Resource
	private IDistrictService districtService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		 if(event.getApplicationContext().getParent() == null){
	           //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			 try {
				districtService.queryCitysFromMDM();
				districtService.queryProvincesFromMDM();
				districtService.queryCountyFromMDM();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	      }		
	}

}
