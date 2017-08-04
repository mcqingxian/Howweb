package com.hoau.wechat.dao;

import java.util.List;

import com.hoau.wechat.vo.WayBillInfoEntity;


public interface IWayBillInfoDao {
	
	public void saveWayBill(WayBillInfoEntity wayill);
	
	public WayBillInfoEntity findWayBillInfo(String openid, String wayBill);
	
	public List<WayBillInfoEntity> findWayBillInfos(String openid);
	
	public void updateWayBill(WayBillInfoEntity info);
	
}
