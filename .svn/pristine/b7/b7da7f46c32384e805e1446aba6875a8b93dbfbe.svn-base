package com.hoau.how.module.obh.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.obh.shared.domain.UnpayMentEntity;

/**
 * @author：潘强
 * @create：2015年12月14日14:49
 * @description：
 */
@Repository
public interface UnpayMentEntityMapper {
 
	/**
     * 保存待收收货款信息
     * @param unpayMentEntity
     * @author 潘强
     * @date 2015年12月14日
     * @update 
     */
     void saveUnpayMent(UnpayMentEntity unpayMentEntity);
     /**
      * 删除待收收货款信息（根据外键）
      * @param unpayMentEntity
      * @author 潘强
      * @date 2015年12月14日
      * @update 
      */
	void deleteByForeignKey(String id);
	/**
     * 根据外键查找主键
     * @param unpayMentEntity
     * @author 潘强
     * @date 2015年12月14日
     * @update 
     */
	List<String> selectEsuId(String id);
	/**
     * 根据外键查找实体信息
     * @param contactsIds
     * @author 潘强
     * @date 2015年12月17日
     * @update 
     */
	List<UnpayMentEntity> queryUnpayMentByFid(String contactsIds);
	/**
     * 根据主键修改实体信息
     * @param contactsIds
     * @author 潘强
     * @date 2015年12月20日
     * @update 
     */
	void updateByPrimaryKey(UnpayMentEntity unpayMentEntity);
}
