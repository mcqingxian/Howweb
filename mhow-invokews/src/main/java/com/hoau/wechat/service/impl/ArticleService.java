package com.hoau.wechat.service.impl;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.NetRequestConstant;
import com.hoau.wechat.service.IArticleService;
import com.hoau.wechat.utils.NetUtil;

@Service
public class ArticleService implements IArticleService{

	@Override
	public String getArticles() {
		return NetUtil.getData(NetRequestConstant.ARTICLE);
	}
	
}
