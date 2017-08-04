/**
 * 
 */
package com.hoau.wechat.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.hoau.wechat.constant.PropertyConstant;
import com.hoau.wechat.constant.SmsConfig;
import com.hoau.wechat.dao.IWechatDictionaryDao;
import com.hoau.wechat.entity.SmsEntity;
import com.hoau.wechat.entity.SmsGroup;
import com.hoau.wechat.entity.SmsItem;
import com.hoau.wechat.entity.SmsTask;
import com.hoau.wechat.exception.BusinessException;
import com.hoau.wechat.service.ISMSservice;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.util.UUIDUtil;

/**
 * @author tntadmin
 *
 */
@Component
public class SMSNetUtil /*implements ApplicationContextAware*/{
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Log log = LogFactory.getLog(SMSNetUtil.class);
	/**
	 * 连接超时时间
	 */
	private static final int CONNECTION_TIME_OUT = 1000 * 30;
	/**
	 * 返回超时时间
	 */
	private static final int RESPONSE_TIME_OUT = 1000 * 60;
	/**
	 * 外部系统接口ip
	 * "http://10.39.109.39/IWsms/sms.asmx/sendSms1?_deptNo=&_serviceType=SMS_WECHAT&_lineId=3&_spnoExt=&_clientSeqid="
	 */
	private static String BASE_URL;

	/**
	 * 网络get请求
	 * 
	 * @param url
	 *            请求路径
	 * @return 返回json字符串
	 */

	public static String getData(String mobile,String content){
		log.info(content);
		String result = null;
		StringBuffer url = new StringBuffer(BASE_URL+"?_deptNo=&_serviceType=SMS_WECHAT&_lineId=3&_spnoExt=&_clientSeqid=&_priority=0");
		url.append("&_mobile=").append(mobile);
		url.append("&_content=").append(URLEncoder.encode(content));
		url.append("&_execTime=").append(URLEncoder.encode(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
		log.info(url);
		HttpGet httpGet = new HttpGet(url.toString());
		HttpClient httpClient = new DefaultHttpClient();
		// 设置连接超时时间
		httpClient.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECTION_TIME_OUT);
		// 设置返回超时时间
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				RESPONSE_TIME_OUT);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
			result = EntityUtils
						.toString(httpResponse.getEntity(), "UTF-8");
				log.info(result);
				return result;
			} else {
				log.error("请求错误" + statusCode);
				throw new BusinessException("请求错误" + statusCode,
						new Throwable());
			}
		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
			throw new BusinessException("服务器连接超时", e.getCause());
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			throw new BusinessException("服务器响应超时", e.getCause());
		} catch (HttpHostConnectException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage(), e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage(), e.getCause());
		}
	}

	/*@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		BASE_URL = PropertyConstant.SMS_URL;
		String sms_template = PropertyConstant.SMS_TEMPLATE;
		log.info("短信接口url:"+BASE_URL);
		log.info("短信模板:"+sms_template);
	}*/
	
	
	/** 
	* @Title: sendMsg 
	* @Description: 发送短信
	* @param @param smsEntity    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public static void sendMsg(SmsEntity smsEntity){
		SmsGroup t = new SmsGroup();
		t.seteTime(df.format(smsEntity.getSendTime()));
		t.setInterFaceID(SmsConfig.INTERFACEID);
		t.setLoginName(SmsConfig.LOGIN_NAME);
		t.setLoginPwd(SmsConfig.LOGIN_PWD);
		t.setOpKind(SmsConfig.OPKIND);
		t.setSerType(SmsConfig.SERTYPE);
		
		SmsTask smsTask = new SmsTask();
		smsTask.setContent(smsEntity.getContent());
		smsTask.setRecivePhoneNumber(smsEntity.getMobile());
		smsTask.setSearchID(smsEntity.getSearchID());

		SmsItem item = new SmsItem();
		
		List<SmsTask> items = new ArrayList<SmsTask>();
		items.add(smsTask);
		item.setTasks(items);
		t.setItem(item);
		
		String xml;
		CloseableHttpClient client = null;
		try {
			xml = JaxbUtil.marshToXmlBinding(SmsGroup.class, t);
			client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(SmsConfig.URL);
//			System.out.println(xml);
			StringEntity requestEntity = new StringEntity(xml,"GB2312");
			httpPost.setEntity(requestEntity);
			CloseableHttpResponse response = client.execute(httpPost);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				log.info("entity:"+EntityUtils.toString(response.getEntity()));
				log.info("message send sucess:mobile->"+smsEntity.getMobile()+",content->"+smsEntity.getContent());
			}else{
				new RuntimeException("短信发送失败！");
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SmsEntity entity = new SmsEntity();
		entity.setContent("微信验证码：123456");
		entity.setMobile("13916078704");
		entity.setSearchID(UUIDUtil.getUUID());
		entity.setSendTime(sdf.parse("2014-12-04 08:10:53"));
		sendMsg(entity);
		/*
		String file = "E:\\King\\【工作】\\天地华宇【短信】\\优惠券\\mobile.txt";
		String content = "关注微信（id:Hoau4008086666）即可下单查询，轻轻松松，再送10元现金抵用券，就是这么任性，等什么呢！回复TD退订！";
//		String content = "test";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		PrintWriter pw = new PrintWriter(new FileOutputStream("E:\\King\\【工作】\\天地华宇【短信】\\优惠券\\msgId.txt", true));
		String phone = null;
		while((phone = br.readLine()) != null){
			SmsEntity entity = new SmsEntity();
			entity.setContent(content);
			entity.setMobile(phone);
			String msgId = UUIDUtil.getUUID();
			entity.setSearchID(msgId);
			entity.setSendTime(new Date());
			sendMsg(entity);
			pw.write(msgId+"@"+phone);
			pw.write("\r\n");
			System.out.println(phone+"---"+content);
			Thread.sleep(50);
		}
		pw.flush();
		pw.close();
		br.close();
		*/
	}
}
