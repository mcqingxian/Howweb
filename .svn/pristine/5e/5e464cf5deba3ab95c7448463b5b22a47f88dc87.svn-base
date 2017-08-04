package com.hoau.mhow.module.bse.server.service.impl;

import java.net.URL;

import org.springframework.stereotype.Service;

import com.hoau.mhow.invokews.server.ws.omsorder.CustomerService;
import com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType;
import com.hoau.mhow.invokews.server.ws.omsorder.ObjectFactory;
import com.hoau.mhow.invokews.server.ws.omsorder.utils.OMSInterfaceService;
import com.hoau.mhow.module.bse.api.server.service.IOmsOrderService;
import com.hoau.wechat.constant.PropertyConstant;

/**
 * OMS订单接口SERVICE
 *
 * @author 蒋落琛
 * @date 2015-12-14
 */
@Service
public class OmsOrderService extends OMSInterfaceService implements IOmsOrderService {
	private CustomerServicePortType port;
	public OmsOrderService(){
		try {
			CustomerService ss = new CustomerService(new URL(PropertyConstant.OMS_ORDER_URL));
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