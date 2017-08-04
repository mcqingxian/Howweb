package com.hoau.mhow.module.bse.api.server.service;

import com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType;
import com.hoau.mhow.invokews.server.ws.omsorder.ObjectFactory;

/**
 * @author：莫涛
 * @create：2015年7月30日 下午7:21:20
 * @description：
 */
public interface IOmsOrderService {
	public CustomerServicePortType getCustomerService();
	public ObjectFactory getObjectFactory();
}
