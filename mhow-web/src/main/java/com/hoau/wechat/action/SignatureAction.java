package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.impl.SignatureService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.JSRegisterVo;

@Controller
@Scope("prototype")
public class SignatureAction{
	Logger logger = Logger.getLogger(SignatureAction.class);
	
	private String targetUrl;
	private String openid;
	private String registInfo;
	@Resource
	private SignatureService signatureService;
	
	
	
	public String signature(){
		JSRegisterVo vo = signatureService.gainSignature(targetUrl);
		vo.setOpenid(openid);
		registInfo = JsonUtils.toJson(vo);
		logger.info(registInfo);
		System.out.println(registInfo);
		return "success";
	}

	public String getRegistInfo() {
		return registInfo;
	}

	public void setRegistInfo(String registInfo) {
		this.registInfo = registInfo;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
	

}
