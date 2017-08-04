package com.hoau.wechat.service;

import java.util.List;

import com.hoau.wechat.entity.OrderEntity;

/**
 * 订单管理接口服务类
 * @author gaojia
 *
 */
public interface IOrderManagerService {
	public OrderEntity submitOrder(OrderEntity order,String userId);
	
	public OrderEntity queryOrderDetail(String orderNo,String userId);
	
	public void cancelOrder(String orderNo,String userId);
	
	public void modifyOrder(OrderEntity order,String userId);
	
	public List<OrderEntity> queryOrder(String userId, int days);
	
	public OrderEntity queryOrderByNo(String orderNo,String userId);
	/*public String queryUndoneOrder(String mobile);
	public String queryDoneOrder(String mobile);
	public String queryOrderByOrderNo(String mobile);*/
	
	
	public OrderEntity hcSubmitOrder(OrderEntity order,String userId);
}
