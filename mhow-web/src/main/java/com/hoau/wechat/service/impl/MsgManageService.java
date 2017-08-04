package com.hoau.wechat.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.wechat.dao.IMsgManageDao;
import com.hoau.wechat.service.IMsgManageService;

@Service
public class MsgManageService implements IMsgManageService {

	@Resource
	private IMsgManageDao msgManageDao;
	
	@Override
	public void insertMsg(Map<String, String> msgMap) {
		msgManageDao.insertMsg(msgMap);
	}

}
