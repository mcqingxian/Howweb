package com.hoau.wechat.dao;

import com.hoau.wechat.vo.SurveyVo;

/**
 * 
 * @ClassName: ISurveyDao 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月29日 下午2:32:32 
 *
 */
public interface ISurveyDao {
	/**
	 * 
	 * @Title: saveSurvey 
	 * @Description: TODO 
	 * @param @param vo    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void saveSurvey(SurveyVo vo);
}
