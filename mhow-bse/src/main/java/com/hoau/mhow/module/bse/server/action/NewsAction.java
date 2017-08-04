package com.hoau.mhow.module.bse.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.module.bse.api.server.service.INewsService;
import com.hoau.mhow.module.bse.api.shared.domain.NewsEntity;
import com.hoau.mhow.module.bse.api.shared.vo.NewsListVo;

/**
 * @author：张爱萍
 * @create：2015年6月5日 下午2:54:59
 * @description：
 */
@Controller
@Scope("prototype")
public class NewsAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private String categoryName;

	private Integer pageNo = 1;
	private Integer pageSize;
	private long recordCount;

	private String newsId;
	private Integer rowNum;
	private String forJump;
	private String keyPoint;
	private String backToListAction;
	// 查询新闻列表结果集
	private List<NewsListVo> newsList;
	// 查询新闻详细内容
	private NewsEntity newDetail;

	@Resource
	private INewsService iNewsService;

	/**
	 * 分页查询新闻列表
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	public String queryNewsList() {
		try {
			newsList = iNewsService.queryNewsList(categoryName, pageNo,
					pageSize);
			this.setRecordCount(iNewsService.countNews(categoryName));
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
	}

	/**
	 * 查询某新闻详细内容
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	public String queryNewsDetail() {
		try {
			recordCount = iNewsService.countNews(forJump);
			this.setRecordCount(recordCount);
			if (StringUtil.isNotEmpty(newsId)) {
				newDetail = iNewsService.queryNewsDetail(newsId);
			} else {
				if ("previous".equals(keyPoint)) {
					rowNum = (rowNum - 1) == 0 ? 1 : (rowNum - 1);
				} else if ("next".equals(keyPoint)) {
					rowNum = (rowNum + 1) > recordCount ? (int) recordCount
							: (rowNum + 1);
				}
				;
				newDetail = iNewsService.queryNewsDetail(rowNum, forJump,
						keyPoint);
			}
		} catch (BusinessException e) {
			return returnError(e);
		}
		if (newDetail != null
				&& !StringUtil.isEmpty(newDetail.getCategoryName())) {
			// 返回当前新闻类目，struts.xml配置文件判断加入哪个二级页面，以及显示二级页左部导航选择样式
			String categoryBack = newDetail.getCategoryName();
			// 兼容老官网的新闻稿类目(备注：新官网无新闻稿类别)
			if ("天地华宇动态".equals(categoryBack) || "新闻稿".equals(categoryBack)
					|| "华宇公告".equals(categoryBack)
					|| "媒体报道".equals(categoryBack)
					|| "物流资讯".equals(categoryBack)) {
				this.setCategoryName("新闻中心");
			} else {
				this.setCategoryName(categoryBack);
			}
			handlerBackToListAction(forJump);
			return categoryName;
		} else {
			return ERROR;
		}
	}

	private void handlerBackToListAction(String forJump) {
		if ("天地华宇动态".equals(forJump) || "新闻稿".equals(forJump)) {
			backToListAction = "hoauDynamic.action";
		} else if ("华宇公告".equals(forJump)) {
			backToListAction = "hoauNotice.action";
		} else if ("媒体报道".equals(forJump)) {
			backToListAction = "mediaReports.action";
		} else if ("物流资讯".equals(forJump)) {
			backToListAction = "logisticsInfo.action";
		} else if ("社会责任".equals(forJump)) {
			backToListAction = "socialResponsibility.action";
		} else if ("市场推广".equals(forJump)) {
			backToListAction = "marketActivity.action";
		}

	}

	/**
	 * 增加新闻点击次数
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月5日
	 * @update
	 */
	@JSON
	public String addClickCount() {
		try {
			iNewsService.addClickCount(newsId);
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public List<NewsListVo> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsListVo> newsList) {
		this.newsList = newsList;
	}

	public NewsEntity getNewDetail() {
		return newDetail;
	}

	public void setNewDetail(NewsEntity newDetail) {
		this.newDetail = newDetail;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public String getForJump() {
		return forJump;
	}

	public void setForJump(String forJump) {
		this.forJump = forJump;
	}

	public String getKeyPoint() {
		return keyPoint;
	}

	public void setKeyPoint(String keyPoint) {
		this.keyPoint = keyPoint;
	}

	public String getBackToListAction() {
		return backToListAction;
	}

	public void setBackToListAction(String backToListAction) {
		this.backToListAction = backToListAction;
	}

}
