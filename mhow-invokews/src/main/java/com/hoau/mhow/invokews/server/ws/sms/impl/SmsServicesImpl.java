package com.hoau.mhow.invokews.server.ws.sms.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.hoau.mhow.invokews.server.ws.sms.ISmsServices;
import com.hoau.wechat.util.DateUtils;

/**
 * @author：莫涛
 * @create：2015年7月16日 上午10:16:42
 * @description：
 */
@Component
public class SmsServicesImpl implements Runnable,ISmsServices{
	private Logger logger = Logger.getLogger(SmsServicesImpl.class);
	private ArrayBlockingQueue<SMS> queue = new ArrayBlockingQueue<SMS>(20000);
	private Lock lock = new ReentrantLock();
	public SmsServicesImpl(){
		new Thread(this).start();
	}
	
	public void put(SMS sms){
		try{
			lock.lock();
			queue.put(sms);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("SmsServices put : " + ex.getMessage());
		}finally{
			lock.unlock();
		}
	}

	@Override
	public void run() {
		SMS sms = null;
		while(true){
			try{
				sms = queue.take();
				//重发，仅限3次
				if(sms.getSendTotal() == 3){
					continue;
				}
				boolean rs = SmsWebService.getInstance().sendSms(DateUtils.getCurDateTime(), "OBH", 
						"sms",sms.getPhone(), 
						sms.getContent(), "1", 
						"", "04000000000000000000");
				try {
					//如果发送结果为false，则重新发送一次。
					if(rs == false){
						//发送次数加1
						sms.setSendTotal(sms.getSendTotal() + 1);
						queue.put(sms);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("传递结果："+ rs +"，短信手机号："+sms.getPhone() + "，内容："+sms.getContent());
			}catch(Exception ex){
				logger.error("SmsServices run error : " + ex.getMessage());
				ex.printStackTrace();
				try {
					//发送次数加1
					sms.setSendTotal(sms.getSendTotal() + 1);
					queue.put(sms);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}