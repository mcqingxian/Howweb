package com.hoau.how.module.bse.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.api.server.service.IQuestionService;
import com.hoau.how.module.bse.api.shared.domain.QuestionEntity;
import com.hoau.how.module.bse.server.dao.QuestionMapper;
import com.hoau.how.module.util.EmptyUtils;

/**
 * @author：张爱萍
 * @create：2015年7月14日 下午4:04:23
 * @description：
 */
@Service
public class QuestionService implements IQuestionService{
	@Resource
	private QuestionMapper questionMapper;
	
	public List<QuestionEntity> queryQuestions(String key) {
		List<QuestionEntity> questionList = new ArrayList<QuestionEntity>();
		if(EmptyUtils.isEmpty(key)){
			questionList = questionMapper.selectAllQuestions();
		}else{
			key = "%" + key + "%";
			questionList = questionMapper.selectQuestionsByKey(key);
		}
		return questionList;
	}
}
