package com.hoau.how.module.bse.server.action;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.api.server.service.IBannerService;
import com.hoau.how.module.bse.api.server.service.INewsService;
import com.hoau.how.module.bse.api.shared.domain.BannerEntity;
import com.hoau.how.module.bse.api.shared.vo.MarketVo;
import com.hoau.how.module.bse.api.shared.vo.NewsListVo;
import com.hoau.how.module.bse.api.shared.vo.PropagandaNewsIndexVo;

/**
 * @author：张爱萍
 * @create：2015年6月10日 下午1:46:05
 * @description：
 */
@Controller
@Scope("prototype")
public class IndexAction extends AbstractAction{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 7932378566955049021L;
	private String categoryName;
	/**
	 * 取出banner图片和链接路径
	 */
	@Resource
	private IBannerService iBannerService;
	private List<BannerEntity> bannerList;
	
	@Resource
	private INewsService iNewsService;
	/**
	 * 取出新闻列表
	 */
	private List<String> newsCategoryList = Arrays.asList(new String[]{"天地华宇动态","新闻稿","媒体报道"});
	private List<NewsListVo> newsIndexVoList;
	/**
	 * 带图新闻列表
	 */
	private List<PropagandaNewsIndexVo> propagandaNewsList;
	private List<String> newsPropagandaCategoryList = Arrays.asList(new String[]{"天地华宇动态","新闻稿","媒体报道","华宇公告"});
	
	/**
	 * 市场活动
	 */
	private List<MarketVo> marketList;
	
	public String index(){
		try {
			bannerList = iBannerService.queryBanner();
			marketList = iNewsService.queryIndexMarketList("市场推广",  4);
			newsIndexVoList = iNewsService.queryIndexNewsList(newsCategoryList,7);
			propagandaNewsList = iNewsService.queryIndexPropagandaNewsList(newsPropagandaCategoryList, 4);
		} catch (BusinessException e) {
			returnError(e);
		}
		return returnSuccess();
	}

	public List<BannerEntity> getBannerList() {
		return bannerList;
	}

	public void setBannerList(List<BannerEntity> bannerList) {
		this.bannerList = bannerList;
	}

	
	public List<String> getNewsCategoryList() {
		return newsCategoryList;
	}

	public void setNewsCategoryList(List<String> newsCategoryList) {
		this.newsCategoryList = newsCategoryList;
	}

	public List<NewsListVo> getNewsIndexVoList() {
		return newsIndexVoList;
	}

	public void setNewsIndexVoList(List<NewsListVo> newsIndexVoList) {
		this.newsIndexVoList = newsIndexVoList;
	}

	public List<MarketVo> getMarketList() {
		return marketList;
	}

	public void setMarketList(List<MarketVo> marketList) {
		this.marketList = marketList;
	}

	public List<String> getNewsPropagandaCategoryList() {
		return newsPropagandaCategoryList;
	}

	public void setNewsPropagandaCategoryList(
			List<String> newsPropagandaCategoryList) {
		this.newsPropagandaCategoryList = newsPropagandaCategoryList;
	}

	public List<PropagandaNewsIndexVo> getPropagandaNewsList() {
		return propagandaNewsList;
	}

	public void setPropagandaNewsList(List<PropagandaNewsIndexVo> propagandaNewsList) {
		this.propagandaNewsList = propagandaNewsList;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}
