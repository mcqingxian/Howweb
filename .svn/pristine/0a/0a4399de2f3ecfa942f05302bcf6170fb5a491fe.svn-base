package com.hoau.how.module.util;

import com.hoau.how.module.util.bank.BankVo;
import com.hoau.how.module.util.net.NetUtil;
/**
 * 根据卡号获取银行信息
 *
 * @author 莫涛
 * @date 2016年2月25日下午4:09:42
 */
public class BankUtil {
	public static String getNameOfBank(String card){
		String json = NetUtil.requestBaiDuApi("cardnum="+card);
		BankVo vo = JsonUtils.toObject(json, BankVo.class);
		if(vo != null && vo.getData() != null){
			return vo.getData().getBankname();
		}else{
			return "";
		}
	}
}