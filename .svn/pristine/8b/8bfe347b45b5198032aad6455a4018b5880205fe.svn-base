/**
 * 
 */
package com.hoau.wechat.utils;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceFeature;

import org.springframework.stereotype.Component;

import com.hoau.wechat.constant.PropertyConstant;
import com.hoau.wechat.dao.IWechatDictionaryDao;
import com.hoau.wechat.ws.oms.MobileService;
import com.hoau.wechat.ws.oms.MobileServicePortType;
import com.hoau.wechat.ws.oms.ObjectFactory;

/**
 * @author gaojia
 *
 */
@Component
public class OMSMobileFactory{
	@Resource
	private IWechatDictionaryDao wechatDictionaryDao;
	
	private static MobileService mobileService;
	
	private static ObjectFactory objectFactory;
	/*static{
		try {
			mobileService = new MobileService(new URL(PropertyConstant.OMS_URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		objectFactory = new ObjectFactory();
	}*/
	private OMSMobileFactory(){
		
	}
	public static ObjectFactory getObjectFactory(){
		return objectFactory;
	}
	public static MobileServicePortType getMobileServicePortType(){
		//return mobileService.getMobileServiceHttpPort();
		return null;
	}
	
	public  static MobileServicePortType getMobileServicePortType(WebServiceFeature... features){
		//return mobileService.getMobileServiceHttpPort(features);
		return null;
	}
	public void setWechatDictionaryDao(IWechatDictionaryDao wechatDictionaryDao) {
		this.wechatDictionaryDao = wechatDictionaryDao;
	}
	
}
