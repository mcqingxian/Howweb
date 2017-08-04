package com.hoau.how.module.bse.server.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.api.shared.domain.BankInfoEntity;
import com.hoau.how.module.bse.server.service.impl.BankInfoService;

/**
 * 查询银行卡开户行action
 *
 * @author 莫涛
 * @date 2016年3月28日下午5:29:12
 */
@Controller
@Scope("prototype")
public class BankInfoAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 8362402092125523491L;
	private Logger logger = Logger.getLogger(BankInfoAction.class);
	@Autowired
	BankInfoService bankInfoService;
	private String bankName;
	List<BankInfoEntity> bankInfoList;
	
	public String queryBankInfoJson(){
		try{
			bankInfoList = bankInfoService.queryBankInfoList(bankName);
		}catch(Exception ex){
			logger.error("BankInfoAction Exception : " + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return "queryBankInfoJson";
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<BankInfoEntity> getBankInfoList() {
		return bankInfoList;
	}
}
