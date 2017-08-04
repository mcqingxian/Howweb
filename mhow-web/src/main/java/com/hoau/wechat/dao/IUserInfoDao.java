package com.hoau.wechat.dao;

import com.hoau.wechat.vo.UserInfo;

public interface IUserInfoDao {
	public void bind(UserInfo userInfo);
	public UserInfo findOne(String openId);
	
	public void updatePhone(String openId,String phone);
	
	public void saveValidate(String openId, String valCode);
	public String getValiteCode(String openId);
	public void updateValiCode(String openId, String valCode);
}
