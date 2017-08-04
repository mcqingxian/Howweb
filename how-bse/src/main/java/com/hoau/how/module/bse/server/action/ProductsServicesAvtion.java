package com.hoau.how.module.bse.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.api.server.service.INewsService;
import com.hoau.how.module.bse.api.shared.vo.MarketVo;

/**
 * 产品与服务action
 * @author：张爱萍
 * @create：2015年6月13日 下午4:05:56
 * @description：
 */
@Controller
@Scope("prototype")
public class ProductsServicesAvtion extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = -6899946899724379824L;
	private Integer pageNo =1;
	private Integer pageSize;
	private long recordCount;
	private String categoryName;
	@Resource
	private INewsService iNewsService;
	
	 //市场活动列
	private List<MarketVo> marketList;
	

	/**
	 * 最新活动
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月15日
	 * @update
	 */
	public  String marketActivity(){
		try {
			marketList = iNewsService.queryMarketList(categoryName, pageNo, pageSize);
			this.setRecordCount(iNewsService.countNews(categoryName));
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
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
	public List<MarketVo> getMarketList() {
		return marketList;
	}
	public void setMarketList(List<MarketVo> marketList) {
		this.marketList = marketList;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
