package com.hoau.wechat.service.impl;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.TemplateConstant;
import com.hoau.wechat.service.ITemplateService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.net.WeixinUtil;
import com.hoau.wechat.vos.templates.Field;
import com.hoau.wechat.vos.templates.ReturnMsg;
import com.hoau.wechat.vos.templates.data.ConData;
import com.hoau.wechat.vos.templates.data.DelivData;
import com.hoau.wechat.vos.templates.data.IData;
import com.hoau.wechat.vos.templates.data.SignData;
import com.hoau.wechat.vos.templates.msg.ConMsg;
import com.hoau.wechat.vos.templates.msg.DelivMsg;
import com.hoau.wechat.vos.templates.msg.SignMsg;
import com.hoau.wechat.vos.templates.tmp.Template;

/**
 * 
 * @ClassName: TemplateService 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 上午9:10:48 
 *
 */
@Service
public class TemplateService implements ITemplateService {
	private static Log log = LogFactory.getLog(TemplateService.class);
	
	/**
	 * 收件成功通知
	 */
	@Override
	public void sendConTemplate(ConMsg conMsg) {
		Field waybillNo = new Field();
		waybillNo.setColor("#F15A22");
		waybillNo.setValue(conMsg.getWaybillNo());
		
		Field remark = new Field();
		remark.setColor("#000000");
		remark.setValue(conMsg.getRemark());
		
		Field first = new Field();
		first.setValue(conMsg.getFirst());
		first.setColor("#000000");
		ConData data = new ConData(first, waybillNo, remark);
		//发送消息
		this.sendMessage(data, conMsg.getOpenId(), conMsg.getWaybillNo());
	}
	
	/**
	 * 提货通知
	 */
	@Override
	public void sendDelivTemplate(DelivMsg delivMsg) {
		Field keyword1 = new Field();
		keyword1.setValue(delivMsg.getKeyword1());
		keyword1.setColor("#F15A22");
		
		Field keyword2 = new Field();
		keyword2.setValue(delivMsg.getKeyword2());
		keyword2.setColor("#F15A22");
		
		Field keyword3 = new Field();
		keyword3.setValue(delivMsg.getKeyword3());
		keyword3.setColor("#F15A22");
		
		Field remark = new Field();
		remark.setValue(delivMsg.getRemark());
		remark.setColor("#000000");
		
		Field first = new Field();
		first.setValue(delivMsg.getFirst());
		first.setColor("#000000");
		
		DelivData data = new DelivData(first,keyword1,keyword2,keyword3,remark);
		//发送消息
		this.sendMessage(data, delivMsg.getOpenId(),delivMsg.getKeyword1());
	}

	/**
	 * 订单状态通知(签收成功)
	 */
	@Override
	public void sendSignTemplate(SignMsg signMsg) {
		Field keyword1 = new Field();
		keyword1.setColor("#F15A22");
		keyword1.setValue(signMsg.getKeyword1());
		
		Field keyword2 = new Field();
		keyword2.setColor("#F15A22");
		keyword2.setValue(signMsg.getKeyword2());
		
		Field remark = new Field();
		remark.setColor("#000000");;
		remark.setValue(signMsg.getRemark());
		
		Field first = new Field();
		first.setValue(signMsg.getFirst());
		first.setColor("#000000");
		
		SignData data = new SignData(first,keyword1,keyword2,remark);
		//发送消息
		this.sendMessage(data, signMsg.getOpenId(),signMsg.getKeyword1());
	}
	
	private void sendMessage(IData data,String openId,String wayBill){
		Template template = new Template();
		template.setData(data);
		template.setTemplate_id(data.queryTemplateID());
		template.setTouser(openId);
		//格式化获取运单详细数据URL
		MessageFormat mftdu = new MessageFormat(TemplateConstant.TMP_URL.TEMPLATE_DETAIL_URL);
		String detailUrl = mftdu.format(new String[]{wayBill,openId});
		template.setUrl(detailUrl);
		String json = JsonUtils.toJson(template);
		//获取accessToken,
		String accessToken = WeixinUtil.queryAccessToken(false);
		
		//格式化发送URL
		MessageFormat format = new MessageFormat(TemplateConstant.TMP_URL.TEMPLATE_SEND_URL);
		String sendUrl = format.format(new String[]{accessToken});
		String msg = WeixinUtil.httpRequest(sendUrl, "POST", json);
		ReturnMsg returnMsg = JsonUtils.toObject(msg, ReturnMsg.class);
		log.info("template msg : "+msg);
		//目前只处理access_token超时
		if(returnMsg.getErrcode().equals("41006")){
			accessToken = WeixinUtil.queryAccessToken(true);
			sendUrl = format.format(new String[]{accessToken});
			msg = WeixinUtil.httpRequest(sendUrl, "POST", json);
			log.info("template msg : "+msg);
		}
	}
}
