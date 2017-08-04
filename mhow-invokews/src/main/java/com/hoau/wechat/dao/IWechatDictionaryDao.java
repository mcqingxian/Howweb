/**
 * 
 */
package com.hoau.wechat.dao;

import com.hoau.wechat.entity.SmsEntity;

/**
 * @author gaojia
 *
 */
public interface IWechatDictionaryDao {
	/**
	 * SMS webService url
	 * @return
	 */
	String querySMSURL();
	/**
	 * 发送短信模板
	 * @return
	 */
	String querySMSTemplate();
	String queryServerUrl();
	
	void saveMsgSendRecord(SmsEntity smsEntity);
}
