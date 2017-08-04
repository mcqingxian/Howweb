package com.hoau.how.module.bse.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.how.module.bse.api.server.service.IBannerService;
import com.hoau.how.module.bse.api.shared.domain.BannerEntity;

/**
 *首页banner显示图片以及链接Action
 * @author：张爱萍
 * @create：2015年6月10日 上午9:41:45
 * @description：
 */
@Controller
@Scope("prototype")
public class BannerAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 3835376294673639456L;

	private List<BannerEntity> banner;
	
	@Resource
	private IBannerService iBannerService;
	
	@JSON
	public String queryBanner(){
		banner = iBannerService.queryBanner();
		return returnSuccess();
	}

	public List<BannerEntity> getBanner() {
		return banner;
	}

	public void setBanner(List<BannerEntity> banner) {
		this.banner = banner;
	}
	
}
