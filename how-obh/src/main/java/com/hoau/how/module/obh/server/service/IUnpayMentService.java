package com.hoau.how.module.obh.server.service;

import java.util.List;

import com.hoau.how.module.obh.shared.domain.UnpayMentEntity;

/**
*
* @author 潘强
* @date 2015年12月17日
*/
public interface IUnpayMentService {
     public List<UnpayMentEntity> queryUnpayMentByFid(String contactsIds);
}
