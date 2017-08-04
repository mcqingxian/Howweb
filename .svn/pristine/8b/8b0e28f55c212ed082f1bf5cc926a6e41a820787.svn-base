package com.hoau.how.module.obh.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.obh.server.dao.UnpayMentEntityMapper;
import com.hoau.how.module.obh.server.service.IUnpayMentService;
import com.hoau.how.module.obh.shared.domain.UnpayMentEntity;
/**
 * 常用待收货款信息服务类
 * 
 * @author 潘强
 * @date 2015年12月17日
 */
@Service
public class UnpayMentService implements IUnpayMentService {
	@Resource
	private UnpayMentEntityMapper unpayMentEntityMapper;

	public List<UnpayMentEntity> queryUnpayMentByFid(String contactsIds) {
		return unpayMentEntityMapper.queryUnpayMentByFid(contactsIds);
	}

}
