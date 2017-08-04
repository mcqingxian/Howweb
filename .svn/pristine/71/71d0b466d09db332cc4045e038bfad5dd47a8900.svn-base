package com.hoau.mhow.module.bse.api.server.service;

import java.util.List;

import com.hoau.mhow.module.bse.api.shared.domain.ContactsEntity;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;
import com.hoau.mhow.module.bse.api.shared.vo.MyOrdersVo;
import com.hoau.mhow.module.bse.api.shared.vo.QueryOrderVo;

/**
 * @author：龙海仁
 * @create：2015年8月3日 下午1:37:13
 * @description：
 */
public interface IMyOrdersService {
	
	/**
	 * 查询订单列表
	 * @param queryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月3日
	 * @update 
	 */
	public List<MyOrdersVo> queryMyOrders(CustomerContactEntity customer, QueryOrderVo queryVo, Integer pageNo, Integer pageSize);
	
	/**
	 * 
	 * @param customer
	 * @param queryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月3日
	 * @update 
	 */
	public Long queryMyOrdersCount(CustomerContactEntity customer, QueryOrderVo queryVo);
	
	/**
	 * 
	 * @param customer
	 * @param queryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月4日
	 * @update 
	 */
	//public InputStream getExcel(CustomerContactEntity customer, QueryOrderVo queryVo);
	
	/**
	 * 
	 * @param orderId
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月4日
	 * @update 
	 */
	public NetOrderEntity queryOrderDetail(Integer orderId);
	
	/**
	 * 
	 * @param orderIdList
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月6日
	 * @update 
	 */
	public List<MyOrdersVo> getPrintOrders(String orderIdList);
	
	/**
	 * 
	 * @param orderId
	 * @author 龙海仁
	 * @date 2015年8月7日
	 * @update 
	 */
	public void deleteOrder(Integer orderId);
	
	/**
	 * 
	 * @param orderId
	 * @author 龙海仁
	 * @date 2015年8月7日
	 * @update 
	 */
	public void updateOrderStatus(Integer orderId	);
	
	/**
	 * 
	 * @param netOrders
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月16日
	 * @update 
	 */
	public List<MyOrdersVo> toMyOrderVo(List<NetOrderEntity> netOrders);
	
	/***********调试开始*************/
	/**
	 * 查询订单列表
	 * 2015年12月22日
	 * @author Dy
	 */
	public List<MyOrdersVo> selectOrdersList(QueryOrderVo queryOrderVo);
	
	/**
	 * 联系人快速下单
	 * 2015年12月26日
	 * @author Dy
	 */
	public NetOrderEntity createOrderByContact(ContactsEntity contactEntity);
	/**********调试结束**************/
}
