package com.hoau.how.module.obh.server.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.util.BankUtil;

@Controller
@Scope("prototype")
public class QueryBankAction extends AbstractAction {

	private static final long serialVersionUID = 1126811292429804143L;
	
    //传入的银行卡号
	private String idCard;
	//返回的银行名称
	private String bankName;

	public String query(){
		
		try {
			 bankName=BankUtil.getNameOfBank(idCard);
			 return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
}
