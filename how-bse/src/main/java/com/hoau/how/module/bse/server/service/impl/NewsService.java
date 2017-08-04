package com.hoau.how.module.bse.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.bse.api.server.service.INewsService;
import com.hoau.how.module.bse.api.shared.domain.NewsEntity;
import com.hoau.how.module.bse.api.shared.exception.NewsException;
import com.hoau.how.module.bse.api.shared.vo.MarketVo;
import com.hoau.how.module.bse.api.shared.vo.NewsListVo;
import com.hoau.how.module.bse.api.shared.vo.PropagandaNewsIndexVo;
import com.hoau.how.module.bse.server.dao.NewsMapper;
import com.hoau.how.module.util.EmptyUtils;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * 新闻Service层实现
 * @author：张爱萍
 * @create：2015年6月5日 下午2:37:31
 * @description：
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class NewsService implements INewsService {
	@Resource
	private NewsMapper newsMapper;
	
	Properties properties = ConfigUtils.getConfig(ConfigConstants.IMAGE.CONFIG_NAME);
	String imageSrc = properties.getProperty(ConfigConstants.IMAGE.IMAGE_SRC);
	/**
	 * 首页展示新闻列表
	 * 
	 * @param newsCategoryList
	 * @param showNumber
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月11日
	 * @update
	 */
	public List<NewsListVo> queryIndexNewsList(List<String> newsCategoryList,Integer showNumber){
				Map<String, Object> params = new HashMap<String, Object>();
				if(EmptyUtils.isEmpty(newsCategoryList)){
					newsCategoryList = new ArrayList<String>();
					newsCategoryList.add("新闻稿");
				}
				params.put("showNumber", showNumber==null?7:showNumber);
				params.put("categoryNamesArray", newsCategoryList);
				return getNewsListIndexVo(newsMapper.queryIndexNewsList(params));		
	}
	/**
	 * 获取首页带图新闻宣传列表
	 * 
	 * @param newsCategoryList
	 * @param showNumber
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月12日
	 * @update
	 */
	public List<PropagandaNewsIndexVo> queryIndexPropagandaNewsList(List<String> newsCategoryList,Integer showNumber){
		Map<String, Object> params = new HashMap<String, Object>();
		if(EmptyUtils.isEmpty(newsCategoryList)){
			newsCategoryList = new ArrayList<String>();
			newsCategoryList.add("市场推广");
		}
		params.put("showNumber", showNumber==null?4:showNumber);
		params.put("categoryNamesArray", newsCategoryList);
		List<PropagandaNewsIndexVo> s = newsMapper.queryIndexProNewsList(params);
		if(EmptyUtils.isNotEmpty(s)){
			for(PropagandaNewsIndexVo news:s){
				news.setSltSrc(news.getSltSrc().replaceAll("/upload", imageSrc+"upload"));
			}
		}
		return s;
	}
	
	/**
	 * 首页查询市场活动
	 * todo 改成top
	 * @param categoryName
	 * @param showNumber
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月11日
	 * @update
	 */
	public List<MarketVo> queryIndexMarketList(String categoryName,Integer showNumber){
		if(EmptyUtils.isEmpty(categoryName)){
			throw new NewsException(NewsException.CATEGORY_NULL);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("showNumber", showNumber==null?4:showNumber);
		params.put("categoryName", categoryName);
		if("市场推广".equals(categoryName)){
			params.put("filterTime","2014-05-01 00:00:00.000");
		}
		List<NewsEntity> newsList= newsMapper.queryIndexMarketNewsList(params);
		return getMarketVo(newsList);
	}
	
	/**
	 * 二级页面分页查询新闻列表
	 */
	@Override
	public List<NewsListVo> queryNewsList(String categoryName,Integer pageNo, Integer pageSize){
		// 判断分页参数是否为空
		if(pageNo ==null || pageSize ==null){
			throw new NewsException(NewsException.RB_NULL);
		}
		if(EmptyUtils.isEmpty(categoryName)){
			throw new NewsException(NewsException.CATEGORY_NULL);
		}
		// 查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageStart", (pageNo-1) * pageSize + 1 );
		params.put("pageEnd",pageNo * pageSize);
		params.put("categoryName", categoryName);
		return getNewsListVo(newsMapper.queryNewsList(params));
	}
	
	/**
	 * 二级页面分页查询带缩略图市场活动
	 * 
	 * @param categoryName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月11日
	 * @update
	 */
	public List<MarketVo> queryMarketList(String categoryName,Integer pageNo, Integer pageSize){
		// 判断分页参数是否为空
		if(pageNo ==null || pageSize ==null){
			throw new NewsException(NewsException.RB_NULL);
		}
		if(EmptyUtils.isEmpty(categoryName)){
			throw new NewsException(NewsException.CATEGORY_NULL);
		}
		// 查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageStart", (pageNo-1) * pageSize + 1 );
		params.put("pageEnd",pageNo * pageSize);
		params.put("categoryName", categoryName);
		if("市场推广".equals(categoryName)){
			params.put("filterTime","2014-05-01 00:00:00.000");
		}
		List<NewsEntity> newsList= newsMapper.queryNewsList(params);
		return getMarketVo(newsList);
	}
	@Override
	public NewsEntity queryNewsDetail(String newsId){
		if(EmptyUtils.isEmpty(newsId)){
			throw new NewsException(NewsException.NEWSID_NULL);
		}
		NewsEntity newsDetail = newsMapper.getNewsDetail(newsId);
		if(newsDetail!=null){
			String content = newsDetail.getContent();
			if(content.contains("src")){
				newsDetail.setContent(content.replaceAll("src=\"/upload", "src=\""+imageSrc+"upload"));
			}
			String shortTitle = newsDetail.getShortTitile();
			if(StringUtil.isNotEmpty(shortTitle) && shortTitle.contains("】")){
				newsDetail.setShortTitile(shortTitle.substring(shortTitle.lastIndexOf("】")+1, shortTitle.length()));
			}
		}
		return newsDetail;
	}
	
	
	
	@Override
	public NewsEntity queryNewsDetail(Integer rowNum, String forJump,
			String keyPoint) {
		if(rowNum == null || StringUtil.isEmpty(forJump) || StringUtil.isEmpty(keyPoint)){
			throw new NewsException(NewsException.NEWSID_NULL);
		}
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("rowNum", rowNum);
		query.put("categoryName", forJump);
		if("市场推广".equals(forJump)){
			query.put("filterTime","2014-05-01 00:00:00.000");
		}
		NewsEntity newsDetail = newsMapper.getNewsDetailForJump(query);
		if(newsDetail!=null){
			String content = newsDetail.getContent();
			if(content.contains("src")){
				newsDetail.setContent(content.replaceAll("src=\"/upload", "src=\""+imageSrc+"upload"));
			}
			String shortTitle = newsDetail.getShortTitile();
			if(StringUtil.isNotEmpty(shortTitle) && shortTitle.contains("】")){
				newsDetail.setShortTitile(shortTitle.substring(shortTitle.lastIndexOf("】")+1, shortTitle.length()));
			}
		}
		return newsDetail;
	}
	@Override
	public void addClickCount(String newsId){
		if(EmptyUtils.isEmpty(newsId)){
			throw new NewsException(NewsException.NEWSID_NULL);
		}
		newsMapper.updateClickCount(newsId);
	}
	
	
	public long countNews(String categoryName){
		if(EmptyUtils.isNotEmpty(categoryName)){
			Map<String, Object> query = new HashMap<String, Object>();
			query.put("categoryName", categoryName);
			if("市场推广".equals(categoryName)){
				query.put("filterTime","2014-05-01 00:00:00.000");
			}
			return newsMapper.countNews(query);
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 将数据库查到新闻实体转换成促销活动实体
	 * 
	 * @param newsList
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月12日
	 * @update
	 */
	private List<MarketVo> getMarketVo(List<NewsEntity> newsList){
		List<MarketVo> marketList = new ArrayList<MarketVo>();
		if(EmptyUtils.isEmpty(newsList)){
			return marketList;
		}
		for(NewsEntity news : newsList){
			MarketVo marketVo = new MarketVo();
			marketVo.setId(news.getNewsId());
			marketVo.setShortTitile(news.getShortTitile());
			marketVo.setTitle(news.getTitle());
			marketVo.setClickCount(news.getClickCount());
			marketVo.setDescription(news.getDescription());
			marketVo.setCreatedAt(news.getCreatedAt());
			marketVo.setDisableTime(news.getDisableTime());
			marketVo.setRowNum(news.getRowNum());
			marketVo.setCategoryName(news.getCategoryName());
			//拼接缩略图路径
			String sltSrc = news.getSltSrc();
			if(sltSrc != null && !sltSrc.equals("")){
				marketVo.setSltSrc(sltSrc.replaceAll("/upload", imageSrc+"upload"));
			}
			//拼接有效期以及判断是否过期
			SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy.MM.dd");
			Date newsGuoqi = news.getDisableTime();
			if(newsGuoqi == null || "".equals(newsGuoqi) || 
					"1900.01.01".equals(sdfDay.format(newsGuoqi))){
				marketVo.setIsDisable(false);
			}else{
				String strStartDate = sdfDay.format(news.getCreatedAt());
				String strEndDate = sdfDay.format(newsGuoqi);
				marketVo.setValidityPeriod(strStartDate + "-" + strEndDate);//拼接有效期
				if(newsGuoqi.before(new Date())){
					marketVo.setIsDisable(true);
				}
			}
			marketList.add(marketVo);
		}
		return marketList;
	}
	
	/**
	 * 将数据库查到新闻实体转换成首页展示新闻实体
	 * 
	 * @param newsList
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月12日
	 * @update
	 */
	private List<NewsListVo> getNewsListIndexVo(List<NewsEntity> newsList){
		List<NewsListVo> newsListVos = new ArrayList<NewsListVo>();
		if(EmptyUtils.isEmpty(newsList)){
			return newsListVos;
		}
		for (NewsEntity news : newsList) {
			NewsListVo newsListVo = new NewsListVo();
			newsListVo.setId(news.getNewsId());
			newsListVo.setCategoryId(news.getCategoryId());
			newsListVo.setCategoryName(news.getCategoryName());
			newsListVo.setCreateAt(news.getCreatedAt());
			newsListVo.setRowNum(news.getRowNum());
			//封装首页展示标题
			String shortitle = news.getShortTitile();
			String indexTitle = shortitle.replaceFirst("【\\d{4}-\\d{2}-\\d{2}】", "").trim();
//			String indexTitle = shortitle.substring(shortitle.indexOf("】")+1).trim();
			newsListVo.setTipTitle(indexTitle);
			if(indexTitle.length() > 18){  
				indexTitle = indexTitle.substring(0,18)+"...";  
		    } 
			newsListVo.setTitle(indexTitle);
			newsListVos.add(newsListVo);
		}
		return newsListVos;
	}
	
	/**
	 * 将数据库查询到的新闻实体转换成二级页面需要展示实体
	 * 
	 * @param newsList
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月16日
	 * @update
	 */
	private List<NewsListVo> getNewsListVo(List<NewsEntity> newsList){
		List<NewsListVo> newsListVos = new ArrayList<NewsListVo>();
		if(EmptyUtils.isEmpty(newsList)){
			return newsListVos;
		}
		for (NewsEntity news : newsList) {
			NewsListVo newsListVo = new NewsListVo();
			newsListVo.setId(news.getNewsId());
			newsListVo.setRowNum(news.getRowNum());
			newsListVo.setCategoryName(news.getCategoryName());
			newsListVo.setCreateAt(news.getCreatedAt());
			String shortTitle = news.getShortTitile().trim();
			shortTitle =shortTitle.replaceFirst("【\\d+-\\d+-\\d+】", "").trim();
			if(shortTitle.length() > 41){
				shortTitle = shortTitle.substring(0,40)+"..."; 
			}
			newsListVo.setTitle(shortTitle);
			newsListVos.add(newsListVo);
		}
		return newsListVos;
	}
}
