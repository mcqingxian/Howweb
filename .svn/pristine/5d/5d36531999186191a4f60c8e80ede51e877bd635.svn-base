package com.hoau.wechat.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.hoau.wechat.dao.ISurveyDao;
import com.hoau.wechat.service.ISurveyService;
import com.hoau.wechat.vo.SurveyVo;

/**
 * 
 * @ClassName: SurveyService 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月29日 下午2:31:11 
 *
 */
@Service
public class SurveyService implements ISurveyService{

	@Resource
	private ISurveyDao surveyDao;
	
	@Override
	public void saveSurvey(SurveyVo vo) {
		surveyDao.saveSurvey(vo);
	}
}
