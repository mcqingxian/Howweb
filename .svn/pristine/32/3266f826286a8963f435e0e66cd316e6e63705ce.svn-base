package com.hoau.wechat.dao.impl;

import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.ISurveyDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.vo.SurveyVo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
/**
 * 
 * @ClassName: SurveyDao 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月29日 下午2:33:08 
 *
 */
@Repository
public class SurveyDao extends BaseDao implements ISurveyDao{

	@Override
	public void saveSurvey(SurveyVo vo) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(SURVEY_INFO);
			DBObject object = BeanUtil.bean2DBObject(vo);
			coll.save(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}
}
