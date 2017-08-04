/**
 * 
 */
package com.hoau.wechat.dao;

import com.hoau.wechat.entity.UserEntity;

/**
 * @author gaojia
 *
 */
public interface IRegisterDao {
	/**
	 * 注册用户
	 * @param user
	 */
	void register(UserEntity user);
	/**
	 * 校验是否做过注册
	 * @param userName
	 * @return
	 */
	boolean checkRegister(String userName);
}
