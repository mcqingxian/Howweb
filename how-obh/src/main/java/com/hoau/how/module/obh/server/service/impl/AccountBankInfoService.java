package com.hoau.how.module.obh.server.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.itf.server.ws.bank.AccountBankInfo;
import com.hoau.how.module.itf.server.ws.bank.BaseAccountInfoServices;
import com.hoau.how.module.itf.server.ws.bank.BaseAccountInfoServices_Service;
import com.hoau.how.module.obh.server.service.IAccountBankInfoService;
import com.hoau.how.module.obh.shared.vos.AccountBankInfoVo;

/**
 * @author 田育林
 *
 */
@Service
public class AccountBankInfoService implements IAccountBankInfoService {
	
	private static BaseAccountInfoServices accountInfoService = null;
	
	static{
		try {
			BaseAccountInfoServices_Service service = new BaseAccountInfoServices_Service(new URL(ItfConifgConstant.BANK_INFO_URL));
			accountInfoService = service.getBaseAccountInfoServicesPort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AccountBankInfoVo> queryBankInfo(String bankKey) {
		List<AccountBankInfoVo> abvos = new ArrayList<AccountBankInfoVo>();
		if(bankKey!=null && !"".equals(bankKey)){
			List<AccountBankInfo> abis = accountInfoService.getAccountBankInfoList(bankKey);
			if(abis!=null && abis.size()>0){
				int cnt = abis.size() > 15 ? 15 : abis.size();
				for(int i=0; i<cnt; i++){
					AccountBankInfoVo abvo = new AccountBankInfoVo();
					abvo.setBankInfoCode(abis.get(i).getAccountBankInfoCode());
					abvo.setBankInfoName(abis.get(i).getAccountBankInfoName());
					abvos.add(abvo);
				}
			}
		}
		return abvos;
	}

}
