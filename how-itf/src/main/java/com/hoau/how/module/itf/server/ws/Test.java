package com.hoau.how.module.itf.server.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.hoau.how.module.itf.server.ws.omsorder.CustomerService;
import com.hoau.how.module.itf.server.ws.omsorder.CustomerServicePortType;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.how.module.itf.server.ws.omsorder.ObjectFactory;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * @author：莫涛
 * @create：2015年7月30日 下午4:27:02
 * @description：
 */
public class Test {
	public static void main(String[] args) {
		Properties properties = ConfigUtils.getConfig(ConfigConstants.OMS_ORDER.CONFIG_NAME);
        String omsOrderUrl = properties.getProperty(ConfigConstants.OMS_ORDER.OMS_ORDER_URL);
		try {
			CustomerService ss = new CustomerService(new URL(omsOrderUrl));
			CustomerServicePortType port = ss.getCustomerServiceHttpPort();  
			EiNetOrderReqModel m = new EiNetOrderReqModel();
			ObjectFactory objectFactory = new ObjectFactory();
			m.setEinoCargoName(objectFactory.createEiNetOrderReqModelEinoCargoName("bbbbbbbbbbbb"));
			EiNetOrderReqModel model = port.saveNetOrder(m);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
