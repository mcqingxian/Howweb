package com.hoau.how.module.obh.server.service;

import java.io.InputStream;
import java.util.List;

import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.vos.MyOrdersVo;
import com.hoau.how.module.obh.shared.vos.QueryOrderVo;

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
	 * 查询订单数量
	 * @param customer
	 * @param queryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月3日
	 * @update 
	 */
	public Long queryMyOrdersCount(CustomerContactEntity customer, QueryOrderVo queryVo);
	
	/**
	 * 导出订单
	 * @param customer
	 * @param queryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月4日
	 * @update 
	 */
	public InputStream getExcel(CustomerContactEntity customer, QueryOrderVo queryVo);
	
	/**
	 * 查询订单的详细信息
	 * @param orderId
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月4日
	 * @update 
	 */
	public NetOrderEntity queryOrderDetail(Integer orderId,Long long1);
	
	/**
	 * 打印订单
	 * @param orderIdList
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月6日
	 * @update 
	 */
	public List<MyOrdersVo> getPrintOrders(String orderIdList,Long long1);
	
	/**
	 * 删除订单
	 * @param orderId
	 * @author 龙海仁
	 * @date 2015年8月7日
	 * @update 
	 */
	public void deleteOrder(Integer orderId,Long long1);
	
	/**
	 * 修改订单状态
	 * @param orderId
	 * @author 龙海仁
	 * @date 2015年8月7日
	 * @update 
	 */
	public void updateOrderStatus(Integer orderId,Long long1);
	
	/**
	 * 
	 * @param netOrders
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月16日
	 * @update 
	 */
	public List<MyOrdersVo> toMyOrderVo(List<NetOrderEntity> netOrders);
}
