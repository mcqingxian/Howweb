/**
 * 
 */
package com.hoau.wechat.utils;

import javax.xml.ws.WebServiceFeature;

import org.springframework.stereotype.Component;

import com.hoau.wechat.ws.wt.DistrictService;
import com.hoau.wechat.ws.wt.DistrictServicePortType;
import com.hoau.wechat.ws.wt.ObjectFactory;

/**
 * @author 275636
 *网厅省市区接口工厂
 */
@Component
public class WTDistrictFactory{
	
	private static DistrictService districtService;
	
	private static ObjectFactory objectFactory;
	/*static{
		try {
			districtService = new DistrictService(new URL(PropertyConstant.WT_URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		objectFactory = new ObjectFactory();
	}*/
	private WTDistrictFactory(){
		
	}
	public static ObjectFactory getObjectFactory(){
		return objectFactory;
	}
	public static DistrictServicePortType getDistrictServicePortType(){
		//return districtService.getDistrictServiceHttpPort();
		return null;
	}
	
	public  static DistrictServicePortType getDistrictServicePortType(WebServiceFeature... features){
		//return districtService.getDistrictServiceHttpPort(features);
		return null;
	}
	
}
