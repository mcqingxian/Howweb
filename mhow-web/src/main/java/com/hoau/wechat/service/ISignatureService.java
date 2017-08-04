package com.hoau.wechat.service;

import com.hoau.wechat.vo.JSRegisterVo;

public interface ISignatureService {
	
	public JSRegisterVo gainSignature(String targetUrl);
}
