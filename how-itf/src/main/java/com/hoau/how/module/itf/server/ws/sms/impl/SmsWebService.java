package com.hoau.how.module.itf.server.ws.sms.impl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.Constants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * 发送短信
 * @author 莫涛
 * @date 2015年7月16日
 */
public class SmsWebService  {
	public static SmsWebService instantce = new SmsWebService();
	private static String smsUrl;
	private SmsWebService(){
		Properties pro = ConfigUtils.getConfig(ConfigConstants.SMS.CONFIG_NAME);
		smsUrl = pro.getProperty(ConfigConstants.SMS.SMS_URL);
	}
	public static SmsWebService getInstance(){
		return instantce;
	}
	
	public boolean sendSms (String _execTime,
			String _deptNo, String _serviceType, String _mobile,
			String _content, String _lineId, String _spnoExt,
			String _clientSeqid) throws Exception {
		boolean i = false;
		Service localService = new Service();
		Call localCall = (Call) localService.createCall();
		localCall.setTargetEndpointAddress(new URL(smsUrl));
		localCall.setOperationName(new QName("http://tempuri.org/",
				"sendSms"));
		localCall.addParameter(
				new QName("http://tempuri.org/", "_execTime"),
				Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(new QName("http://tempuri.org/", "_deptNo"),
				Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(new QName("http://tempuri.org/",
				"_serviceType"), Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(new QName("http://tempuri.org/", "_mobile"),
				Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(
				new QName("http://tempuri.org/", "_content"),
				Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(new QName("http://tempuri.org/", "_lineId"),
				Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(
				new QName("http://tempuri.org/", "_spnoExt"),
				Constants.XSD_STRING, ParameterMode.IN);
		localCall.addParameter(new QName("http://tempuri.org/",
				"_clientSeqid"), Constants.XSD_STRING, ParameterMode.IN);
		localCall.setUseSOAPAction(true);
		localCall.setSOAPActionURI("http://tempuri.org/sendSms");
		localCall.setReturnType(Constants.XSD_STRING);

		String str = (String) localCall.invoke(new Object[] { _execTime,
				_deptNo, _serviceType, _mobile, _content,
				_lineId, _spnoExt, _clientSeqid });
		if (str.indexOf("000") > -1)
			i = true;
		
		return i;
	}
	
	public static void main(String[] args) throws Exception{
		SmsWebService service = new SmsWebService();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean b = service.sendSms(sdf.format(new Date()), "obh", 
				"sms","18200537093", 
				"天地华宇找回密码验证号：4579889，请您在30分钟内完成验证！", "1", 
				"", "04000000000000000000");
		System.out.println(b);
	}
}