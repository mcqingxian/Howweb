package com.hoau.mhow.module.bse.api.server.service;

import java.util.List;

import com.hoau.mhow.module.bse.api.shared.domain.NewsEntity;
import com.hoau.mhow.module.bse.api.shared.vo.MarketVo;
import com.hoau.mhow.module.bse.api.shared.vo.NewsListVo;
import com.hoau.mhow.module.bse.api.shared.vo.PropagandaNewsIndexVo;

/**
 * @author：张爱萍
 * @create：2015年6月5日 下午2:53:56
 * @description：
 */
public interface INewsService {
	/**
	 * 首页展示新闻列表
	 * 
	 * @param categoryName
	 * @param showNumber
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月11日
	 * @update
	 */
	public List<NewsListVo> queryIndexNewsList(List<String> newsCategoryList,Integer showNumber);
	
	/**
	 * 首页展示带图新闻轮播图
	 * 
	 * @param newsCategoryList
	 * @param showNumber
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月12日
	 * @update
	 */
	public List<PropagandaNewsIndexVo> queryIndexPropagandaNewsList(List<String> newsCategoryList,Integer showNumber);
	
	/**
	 * 首页查询市场活动
	 * 
	 * @param categoryName
	 * @param showNumber
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月11日
	 * @update
	 */
	public List<MarketVo> queryIndexMarketList(String categoryName,Integer showNumber);
	
	/**
	 * 自定义分页查询二级页面新闻列表
	 * 
	 * @param categoryName 类目名
	 * @param pageIndex 页索引
	 * @param pageSize 页大小
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月9日
	 * @update
	 */
	public List<NewsListVo> queryNewsList(String categoryName,Integer pageIndex, Integer pageSize);
	
	
	/**
	 * 分页查询市场活动
	 * 
	 * @param categoryName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月11日
	 * @update
	 */
	public List<MarketVo> queryMarketList(String categoryName,Integer pageIndex, Integer pageSize);
	/**
	 * 查询具体新闻内容
	 * 
	 * @param newsId
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	public abstract NewsEntity queryNewsDetail(String newsId);
	
	/**
	 * 翻新闻详细内容
	 * @param rowNum
	 * @param forJump
	 * @param keyPoint
	 * @return
	 */
	public abstract NewsEntity queryNewsDetail(Integer rowNum, String forJump, String keyPoint);

	/**
	 * 增加新闻点击次数
	 * 
	 * @param newsId
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	public abstract void addClickCount(String newsId);

	/**
	 * 某类目新闻总数
	 * 
	 * @param categoryName
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	public long countNews(String categoryName);

}