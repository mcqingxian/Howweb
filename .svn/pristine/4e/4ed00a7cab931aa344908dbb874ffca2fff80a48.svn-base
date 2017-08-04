package com.hoau.mhow.module.bse.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hoau.mhow.module.bse.api.shared.domain.NewsEntity;
import com.hoau.mhow.module.bse.api.shared.vo.PropagandaNewsIndexVo;

/**
 * 静态展示页面
 * @author：张爱萍
 * @create：2015年6月4日 下午4:22:47
 * @description：
 */
@Repository
public interface NewsMapper {
	
	/**
	 * 查询首页展示新闻
	 * 
	 * @param params
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月12日
	 * @update
	 */
	public List<NewsEntity> queryIndexNewsList(Map<String,Object> params);
	
	/**
	 * 查询首页展示促销活动
	 * 
	 * @param params
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月26日
	 * @update
	 */
	public List<NewsEntity> queryIndexMarketNewsList(Map<String,Object> params);
	
	/**
	 * 查询首页展示带图新闻
	 * 
	 * @param params
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月12日
	 * @update
	 */
	public List<PropagandaNewsIndexVo> queryIndexProNewsList(Map<String,Object> params);
	
	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月9日
	 * @update
	 */
	public List<NewsEntity> queryNewsList(Map<String,Object> params);
	
	
	/**
	 * 查询具体某新闻内容
	 * 
	 * @param newsId
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月4日
	 * @update
	 */
	public NewsEntity getNewsDetail(String newsId);
	
	/**
	 * @param query
	 * @return
	 */
	public NewsEntity getNewsDetailForJump(Map<String, Object> query);
	
	/**
	 * 更新新闻点击次数
	 * 
	 * @param newsId
	 * @author 张爱萍
	 * @date 2015年6月4日
	 * @update
	 */
	public void updateClickCount(String newsId);
	
	/**
	 * 计算某类目新闻列表总数
	 * 
	 * @param categoryName
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	public long countNews(Map<String, Object> query);

}
