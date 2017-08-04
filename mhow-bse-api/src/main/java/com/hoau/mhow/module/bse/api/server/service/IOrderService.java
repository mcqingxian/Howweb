package com.hoau.mhow.module.bse.api.server.service;

import java.util.List;

import com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.mhow.invokews.server.ws.omsorder.ObjectFactory;
import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;
import com.hoau.mhow.module.bse.api.shared.domain.QuickOrderEntity;
import com.hoau.mhow.module.bse.api.shared.vo.MyOrdersVo;

/**
 * @author：莫涛
 * @create：2015年7月27日 上午9:37:32
 * @description：
 */
public interface IOrderService {
	public void updateOrder(NetOrderEntity entity);
	public void saveDraft(NetOrderEntity entity);
	public void updateDraft(NetOrderEntity entity);
	public void createOrder(NetOrderEntity entity);
	public void createBatchOrder(NetOrderEntity entity);
	public List<MyOrdersVo> queryQuickOrder(QuickOrderEntity entity);
	public Integer countQuickOrder(QuickOrderEntity entity);
	public NetOrderEntity queryOneOrder(Integer cbccId);
	public void copyNetOrderToEiNetOrder(NetOrderEntity entity,EiNetOrderReqModel reqModel,ObjectFactory objectFactory,int batchOrder);
	
	/**
	 * 自动保存收发货人
	 * @param entity
	 * @author 龙海仁
	 * @date 2015年9月7日
	 * @update 
	 */
	public void saveContacts(NetOrderEntity entity);
}
