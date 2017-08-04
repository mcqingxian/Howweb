package com.hoau.how.module.bse.server.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.api.server.service.IBankInfoService;
import com.hoau.how.module.bse.api.shared.domain.BankInfoEntity;
import com.hoau.how.module.bse.server.dao.BankInfoMapper;
import com.hoau.how.module.itf.server.ws.bank.AccountBankInfo;
import com.hoau.how.module.itf.server.ws.bank.BaseAccountInfoServices;
import com.hoau.how.module.itf.server.ws.bank.BaseAccountInfoServices_Service;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * @author：莫涛
 * @create：2016年3月28日 下午5:40:51
 * @description：
 */
@Service
public class BankInfoService implements IBankInfoService {
	@Resource
	private BankInfoMapper bankInfoMapper;
	Logger logger = Logger.getLogger(BankInfoService.class);
	BaseAccountInfoServices port;
	
	public BankInfoService(){
		Properties properties = ConfigUtils.getConfig(ConfigConstants.BANK_INFO.CONFIG_NAME);
        String bankInfoUrl = properties.getProperty(ConfigConstants.BANK_INFO.BANK_INFO_URL);
		try {
			logger.info(bankInfoUrl);
			BaseAccountInfoServices_Service ss = new BaseAccountInfoServices_Service(new URL(bankInfoUrl));
			port = ss.getBaseAccountInfoServicesPort();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public List<BankInfoEntity> queryBankInfoList(String bankName){
		List<BankInfoEntity> resultList = new ArrayList<BankInfoEntity>();
		List<AccountBankInfo> list = port.getAccountBankInfoList(bankName);
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				AccountBankInfo bankInfo = list.get(i);
				BankInfoEntity entity = new BankInfoEntity();
				entity.setCode(bankInfo.getAccountBankInfoCode());
				entity.setName(bankInfo.getAccountBankInfoName());
				resultList.add(entity);
				if(resultList.size() == 10){
					break;
				}
			}
		}
		
		return resultList;
	}
}