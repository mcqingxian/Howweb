package com.hoau.wechat.mq.service;

/**
 * 
 * @ClassName: UserInfoMqService 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 下午3:58:49 
 *
 */
public interface UserInfoMqService {
	/**
	 * 发送
	 * @param priceInfoEntity
	 */
	public void send(Object object);
}
