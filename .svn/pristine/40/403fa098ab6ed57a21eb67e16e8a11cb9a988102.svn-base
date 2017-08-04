package com.hoau.mhow.module.obh.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;
import com.hoau.mhow.module.bse.api.shared.domain.QuickOrderEntity;
import com.hoau.mhow.module.bse.api.shared.vo.QueryOrderVo;

/**
 * 
 * @author 莫涛
 * @date 2015年7月16日
 */
@Repository
public interface NetOrderDao{
	public void saveOrder(NetOrderEntity entity);
	public void updateOrder(NetOrderEntity entity);
	
	/**
	 * 查询订单列表
	 * @param qeuryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月3日
	 * @update 
	 */
	public List<NetOrderEntity> queryOrderList(QueryOrderVo qeuryVo);
	
	/**
	 * 统计订单数量
	 * @param queryVo
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月3日
	 * @update 
	 */
	public Long queryOrderCount(QueryOrderVo queryVo);
	
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
	 * @param orderId
	 * @author 龙海仁
	 * @date 2015年8月7日
	 * @update 
	 */
	public void deleteOrder(Integer orderId);
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月16日
	 * @update 
	 */
	public List<NetOrderEntity> queryQuickOrder(QuickOrderEntity entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月16日
	 * @update 
	 */
	public Integer countQuickOrder(QuickOrderEntity entity);
	
}