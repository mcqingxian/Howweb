package com.hoau.how.module.itf.server.service.impl;

import java.net.URL;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.hoau.how.module.itf.server.service.IOmsOrderService;
import com.hoau.how.module.itf.server.ws.omsorder.CustomerService;
import com.hoau.how.module.itf.server.ws.omsorder.CustomerServicePortType;
import com.hoau.how.module.itf.server.ws.omsorder.ObjectFactory;
import com.hoau.how.module.itf.server.ws.omsorder.utils.OMSInterfaceService;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * @author：莫涛
 * @create：2015年7月30日 下午7:22:17
 * @description：
 */
@Service
public class OmsOrderService extends OMSInterfaceService implements IOmsOrderService {
	private CustomerServicePortType port;
	public OmsOrderService(){
		Properties properties = ConfigUtils.getConfig(ConfigConstants.OMS_ORDER.CONFIG_NAME);
        String omsOrderUrl = properties.getProperty(ConfigConstants.OMS_ORDER.OMS_ORDER_URL);
		try {
			CustomerService ss = new CustomerService(new URL(omsOrderUrl));
			port = ss.getCustomerServiceHttpPort();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public CustomerServicePortType getCustomerService() {
		return port;
	}

	@Override
	public ObjectFactory getObjectFactory() {
		return super.objectFactory;
	}
}