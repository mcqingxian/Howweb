package com.hoau.how.module.obh.server.service;

import com.hoau.how.module.itf.server.ws.sms.impl.SMS;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;

/**
 * @author：莫涛
 * @create：2015年7月16日 上午11:22:29
 * @description：
 */
public interface IForgotService {
	public void sendSms(SMS sms);
	public void sendMail(String verCode,String toUser);
	public CustomerContactEntity findCustomer(CustomerContactEntity customerContactEntity);
	public void modifyCustomerPwdById(CustomerContactEntity entity);
}
