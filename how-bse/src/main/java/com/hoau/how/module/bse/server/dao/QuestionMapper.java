package com.hoau.how.module.bse.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.QuestionEntity;

/**
 * @author：张爱萍
 * @create：2015年7月14日 下午4:06:40
 * @description：
 */
@Repository
public interface QuestionMapper {
	public List<QuestionEntity> selectQuestionsByKey(String key);
	
	public List<QuestionEntity> selectAllQuestions();
}
