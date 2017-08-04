package com.hoau.mhow.module.bse.server.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.module.bse.api.server.service.IForgotService;
import com.hoau.mhow.module.bse.api.server.service.INewsService;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.vo.MarketVo;
import com.hoau.wechat.constants.SessionConstants;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Dy
 * 2015年12月8日
 * 首页功能action
 */
@Controller
@Scope("prototype")
public class BseAction  extends AbstractAction{

	private static final long serialVersionUID = 7772243530005155664L;
	
	@Resource
	private INewsService iNewsService;
	@Resource
	private  IForgotService iForgotService;
	/**
	 * 异常信息
	 */
	private String errorMsg;
	
	/**
	 * 市场活动
	 */
	private List<MarketVo> marketList;
	
	public String index(){
		List<MarketVo> list = iNewsService.queryIndexMarketList("市场推广",  10);
		marketList = new ArrayList<MarketVo>();
		// 市场推广图片路径改变
		if(list != null && list.size() > 0){
			for (int i=0; i<list.size(); i++){
				if(!list.get(i).getIsDisable()){
					String oldImgUrl = list.get(i).getSltSrc();
					if(!StringUtil.isEmpty(oldImgUrl) && oldImgUrl.lastIndexOf("/") > 0){
						String fileName = oldImgUrl.substring(oldImgUrl.lastIndexOf("/") + 1, oldImgUrl.length());
						list.get(i).setSltSrc(fileName);
						marketList.add(list.get(i));
					}
				}
			}
		}
		if(marketList.size() == 0){
			marketList = null;
		}
		ActionContext ctx = ActionContext.getContext();
		Object userInfoObj =  ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		if(userInfoObj!=null){
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO, iForgotService.findCustomer((CustomerContactEntity) userInfoObj));
		}
		return returnSuccess();
	}
	
	public String notLogin(){
		ActionContext ctx = ActionContext.getContext();
		Object userInfoObj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		if(userInfoObj==null){
			errorMsg = "请先登录";
			return "error";
		}
		return returnSuccess();
	}
	
	public String toPage(){
		return SUCCESS;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<MarketVo> getMarketList() {
		return marketList;
	}

	public void setMarketList(List<MarketVo> marketList) {
		this.marketList = marketList;
	}
}

