package com.hoau.wechat.service;

import com.hoau.wechat.weixin.msg.request.ReqBaseMsg;
import com.hoau.wechat.weixin.msg.response.ResBaseMsg;

public interface IMsgProcessService<I extends ReqBaseMsg,O extends ResBaseMsg> {
	
	public O process(I ReqMsg);
	
}
