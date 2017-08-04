package com.hoau.how.module.bse.api.server.service;

import java.util.List;

import com.hoau.how.module.bse.api.shared.domain.QuestionEntity;

/**
 * 常见答疑Service层接口
 * @author：张爱萍
 * @create：2015年7月14日 下午4:00:28
 * @description：
 */
public interface IQuestionService {
	/**
	 * 根据关键字搜索获取常见答疑
	 * 
	 * @param key
	 * @return
	 * @author 张爱萍
	 * @date 2015年7月14日
	 * @update
	 */
	public List<QuestionEntity> queryQuestions(String key);
	
}
