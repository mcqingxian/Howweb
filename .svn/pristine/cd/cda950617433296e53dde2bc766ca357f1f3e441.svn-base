package com.hoau.wechat.service;

import com.hoau.wechat.vo.UserInfo;

/** 
* @ClassName  :IPhoneBindService 
* @Description:手机绑定服务接口
* @author     :xujun cometzb@126.com	
* @date       :2014年4月15日 下午3:13:42 
*  
*/
public interface IPhoneBindService {
	
	void phoneBind(String phone,String openId);
	
	void changeBind(String phone,String openId);
	
	UserInfo findOneUserInfo(String openId);

	void saveValidate(String openId, String valCode);

	String getValiteCode(String openId);
	
}
