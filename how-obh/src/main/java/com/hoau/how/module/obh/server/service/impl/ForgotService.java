package com.hoau.how.module.obh.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.itf.server.ws.sms.ISmsServices;
import com.hoau.how.module.itf.server.ws.sms.impl.SMS;
import com.hoau.how.module.obh.server.dao.CustomerContactDao;
import com.hoau.how.module.obh.server.service.IForgotService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.util.mail.IMailHelper;
import com.hoau.how.module.util.mail.impl.MailHelper;

/**
 * @author：莫涛
 * @create：2015年7月16日 上午11:22:58
 * @description：
 */
@Service
public class ForgotService implements IForgotService {
	@Resource
	ISmsServices smsServices;
	@Resource
	IMailHelper mailHelper;
	@Resource
	CustomerContactDao customerContactDao;
	
	@Override
	public void sendSms(SMS sms) {
		this.smsServices.put(sms);
	}
	
	@Override
	public void sendMail(String verCode,String toUser) {
		StringBuffer htmlContentText = new StringBuffer();
		htmlContentText.append("<p>尊敬的用户您好！您的邮箱验证码为："+verCode+"，为了保障您帐号的安全性，该验证码有效期为30分钟！</p><br/>");
		htmlContentText.append("<p>请您妥善保管。</p><br/>");
		htmlContentText.append("<p>此邮件不需回复。</p><br/>");
		this.mailHelper.sendSimpleHtmlMail(MailHelper.FROM_USER, toUser, "天地华宇网上营业厅密码找回", htmlContentText.toString());
	}

	@Override
	public CustomerContactEntity findCustomer(
			CustomerContactEntity customerContactEntity) {
		List<CustomerContactEntity> list = this.customerContactDao.findCustomer(customerContactEntity);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public void modifyCustomerPwdById(CustomerContactEntity entity) {
		this.customerContactDao.modifyCustomerPwdById(entity);
	}
}
