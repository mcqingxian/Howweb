/**
 * 
 */
package com.hoau.wechat.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.PropertyConstant;
import com.hoau.wechat.dao.IWechatDictionaryDao;
import com.hoau.wechat.entity.SmsEntity;
import com.hoau.wechat.service.ISMSservice;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.utils.SMSNetUtil;

/**
 * @author gaojia
 *
 */
@Service("ismSservice")
public class SMSservice implements ISMSservice{
	@Resource
	private IWechatDictionaryDao wechatDictionaryDao;
	@Override
	public void sendWechatCheckCode(String mobile, String content) {
		try {
			String sms_template = PropertyConstant.SMS_TEMPLATE;
			content = String.format(sms_template, content);
			
			SmsEntity smsEntity = new SmsEntity();
			smsEntity.setContent(content);
			smsEntity.setMobile(mobile);
			smsEntity.setSearchID(UUIDUtil.getUUID());
			smsEntity.setSendTime(new Date());
			
//			SMSNetUtil.getData(mobile, content);
			SMSNetUtil.sendMsg(smsEntity);
			//保存消息发送记录
			wechatDictionaryDao.saveMsgSendRecord(smsEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public IWechatDictionaryDao getWechatDictionaryDao() {
		return wechatDictionaryDao;
	}
	public void setWechatDictionaryDao(IWechatDictionaryDao wechatDictionaryDao) {
		this.wechatDictionaryDao = wechatDictionaryDao;
	}
}
