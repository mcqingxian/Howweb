package com.hoau.wechat.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.service.ISignatureService;
import com.hoau.wechat.utils.net.TokenCache;
import com.hoau.wechat.vo.JSRegisterVo;

@Service
public class SignatureService implements ISignatureService {

	private String nonceStr;
	private String timeStamp;

	@Override
	public JSRegisterVo gainSignature(String targetUrl) {
		String jsTicket = TokenCache.genTicket();
		String signature = sign(jsTicket,targetUrl);
		JSRegisterVo vo = new JSRegisterVo();
		vo.setAppId(Constant.APPID);
		vo.setNonceStr(nonceStr);
		vo.setSignature(signature);
		vo.setTimestamp(timeStamp);
		return vo;
	}

	public String sign(String jsapi_ticket, String url) {
		nonceStr = TokenCache.create_nonce_str();
		timeStamp = TokenCache.create_timestamp();

		String jsapi = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr
				+ "&timestamp=" + timeStamp + "&url=" + url;

		String signature = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(jsapi.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return signature;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
