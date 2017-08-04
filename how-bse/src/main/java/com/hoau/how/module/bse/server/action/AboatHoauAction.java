package com.hoau.how.module.bse.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.api.server.service.IBigEventService;
import com.hoau.how.module.bse.api.shared.vo.BigEventVo;

/**
 * 关于华宇Action
 * @author：张爱萍
 * @create：2015年6月13日 下午3:31:04
 * @description：
 */
@Controller
@Scope("prototype")
public class AboatHoauAction extends AbstractAction{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 6113774053707813837L;

	private String categoryName;
	
	@Resource
	private IBigEventService iBigEventService;
	private List<BigEventVo> bigEventList;

	/**
	 * 大事记
	 */
	public String companyBigEvent() {
		try {
			bigEventList = iBigEventService.queryBigEvents();
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


	public List<BigEventVo> getBigEventList() {
		return bigEventList;
	}


	public void setBigEventList(List<BigEventVo> bigEventList) {
		this.bigEventList = bigEventList;
	}

}
