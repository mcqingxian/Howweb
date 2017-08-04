package com.hoau.how.module.obh.server.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.itf.server.service.IDcWaybillInfoService;
import com.hoau.how.module.obh.shared.vos.ClaimWaybillInfoVo;

/**
 * 获取运单相关信息
 * @author 徐俊
 * @date 2015年8月13日
 */
@Controller
@Scope("prototype")
public class WayBillInfoAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 运单号和电话是否匹配
	 */
	private String isMatch;
	
	private ClaimWaybillInfoVo claimWaybillInfoVo;
	
	@Resource
	private IDcWaybillInfoService dcWaybillInfoService;
	
	public String execute() throws Exception {
		return super.execute();
	}
	
	public String isMatch() throws Exception {
		return super.execute();
	}

	public String getIsMatch() {
		return isMatch;
	}

	public void setIsMatch(String isMatch) {
		this.isMatch = isMatch;
	}

	public ClaimWaybillInfoVo getClaimWaybillInfoVo() {
		return claimWaybillInfoVo;
	}

	public void setClaimWaybillInfoVo(ClaimWaybillInfoVo claimWaybillInfoVo) {
		this.claimWaybillInfoVo = claimWaybillInfoVo;
	}
}
