package com.hoau.wechat.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;





import com.hoau.wechat.constant.OmsResourceConfig;
import com.hoau.wechat.cxt.HttpInvoke;
import com.hoau.wechat.entity.OrderEntity;
import com.hoau.wechat.service.IWechatOMS;
import com.hoau.wechat.util.JsonUtils;

/** 
* @ClassName: WechatOMS 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xujun jun.xu@hoau.net
* @date 2014年8月9日 下午5:30:19 
*  
*/
public class WechatOMS implements IWechatOMS {

	@Override
	public OrderEntity queryOrder(String orderNo) {
		OrderEntity orderEntity = null;
		String base_url = OmsResourceConfig.BASE_URL;
		String resouce_path = MessageFormat.format(OmsResourceConfig.QUERY_ORDER_BYNO,new Object[]{orderNo});
		String url = base_url + resouce_path;
		String rtn = HttpInvoke.getMethod(url);
		System.out.println(url);
		System.out.println(rtn);
		orderEntity = JsonUtils.toObject(rtn, OrderEntity.class);
		return orderEntity;
	}

	@Override
	public List<OrderEntity> queryOrdersByUserNo(String userNo, String startTime) {
		List<OrderEntity> entities = new ArrayList<OrderEntity>();
		String base_url = OmsResourceConfig.BASE_URL;
		String resouce_path = MessageFormat.format(OmsResourceConfig.QUERY_ORDERS_BYCUSTOMNO,new Object[]{userNo,startTime});
		String url = base_url + resouce_path;
		System.out.println(url);
		String rtn = null;
		try {
			rtn = HttpInvoke.getMethod(url);
			System.out.println("rtn:"+rtn);
			entities = JsonUtils.toList(rtn, OrderEntity.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return entities;
	}
	
	public static void main(String[] args) {
		WechatOMS oms = new WechatOMS();
//		oms.queryOrder("NO201104180012");
		oms.queryOrdersByUserNo("100010", "1407820947720");
	} 
	
}
