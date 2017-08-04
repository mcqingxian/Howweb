package com.hoau.mhow.module.bse.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.mhow.invokews.server.ws.sms.ISmsServices;
import com.hoau.mhow.invokews.server.ws.sms.impl.SMS;
import com.hoau.mhow.module.bse.api.server.service.IForgotService;
import com.hoau.mhow.module.bse.api.server.service.IMailHelper;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.domain.QueryWaybillEntity;
import com.hoau.mhow.module.bse.api.shared.vo.QueryOrderVo;
import com.hoau.mhow.module.obh.server.dao.ContactsEntityMapper;
import com.hoau.mhow.module.obh.server.dao.CustomerContactDao;
import com.hoau.mhow.module.obh.server.dao.NetOrderDao;
import com.hoau.mhow.module.obh.server.dao.NetWaybillDao;
import com.hoau.wechat.constants.ContactsType;
import com.hoau.wechat.util.DateUtils;

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
	
	@Resource
	ContactsEntityMapper contactEntityMapper;
	
	@Resource
	NetOrderDao netOrderDao;
	
	@Resource
	NetWaybillDao netWaybillDao;
	
	/**
	 * 短信数量
	 */
	private int smsNum;
	
	/**
	 * 最近一次统计时间
	 */
	private Long countDate;
	
	@Override
	public void sendSms(SMS sms) {
		if(countDate == null){
			countDate = Long.parseLong(DateUtils.getCurYmdhms());
			smsNum = smsNum + 1;
		} else {
			Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
			// 间隔时间起过了60秒
			if((curDate - countDate - 60L) > 0 && smsNum > 50){
				countDate = curDate;
				smsServices.put(new SMS("13774202749", "最近一分钟" + countDate + "发送短信数量:" + smsNum));
				smsNum = 1;
			} else if((curDate - countDate - 60L) > 0){
				countDate = curDate;
				System.out.println("最近一分钟发送短信数量：" + smsNum);
				smsNum = 1;
			} else {
				smsNum = smsNum + 1;
			}
		}
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
	public CustomerContactEntity findCustomer(CustomerContactEntity customerContactEntity) {
		List<CustomerContactEntity> list = this.customerContactDao.findCustomer(customerContactEntity);
		QueryOrderVo queryOrder = new QueryOrderVo();
		QueryWaybillEntity queryWaybill = new QueryWaybillEntity();
		if(list != null && list.size() > 0){
			CustomerContactEntity customerComplexInfo = list.get(0);
			//地址簿联系人数量
			customerComplexInfo.setCountContacts(contactEntityMapper.contactsTotals(customerComplexInfo.getEbccId(), ContactsType.SHIPPER)+contactEntityMapper.contactsTotals(customerComplexInfo.getEbccId(), ContactsType.CONSIGNEE));
			//客户订单数量
			queryOrder.setCustomerId(customerComplexInfo.getEbccId());
			customerComplexInfo.setCountOrders(Integer.valueOf(netOrderDao.queryOrderCount(queryOrder).toString()));
			//客户运单数量
			queryWaybill.setCustomerId(customerComplexInfo.getEbccId());
			customerComplexInfo.setCountWaybill((int)netWaybillDao.queryWaybillCount(queryWaybill));
			return customerComplexInfo;
		}else{
			return null;
		}
	}
	
	@Override
	public void modifyCustomerPwdById(CustomerContactEntity entity) {
		this.customerContactDao.modifyCustomerPwdById(entity);
	}
}
