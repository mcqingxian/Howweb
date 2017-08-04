package com.hoau.wechat.service.msgHandler;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.utils.MsgUtils;

public class MsgDispatcher {
	protected static final Log LOG = LogFactory.getLog(MsgDispatcher.class);
	private static final Map<String, String> SERVICE_MAP = new HashMap<String, String>();
	static{
		// --------------------------消息----------------------------------
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT, "textMsgHandler");//文本消息

		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT_YDJ, "replyRedPacketMsg");//易到家文本消息
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT_WAYBILL, "wayBillMsgHandler");//定日达抽奖文本消息
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT_SEND_VOUCHERS, "sendVouchersHandler");//运单送抵用券文本消息
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT_JD_JZJ, "jdActiveHandler");//京东家装节活动
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT_SCREENSAVER, "screensaverTextHandler");//京东家装节活动
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_IMAGE, "imageMsgHandler");//图片消息
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_LOCATION, "locationMsgHandler");//地理位置消息
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_LINK, "linkMsgHandler");//链接消息
		
		SERVICE_MAP.put(MsgUtils.REQ_MESSAGE_TYPE_VOICE, "voiceMsgHandler");//音频消息
		
		
		// --------------------------事件----------------------------------
		SERVICE_MAP.put(MsgUtils.EVENT_TYPE_SUBSCRIBE, "subscribeEventHandler");//订阅事件
		
		SERVICE_MAP.put(MsgUtils.EVENT_TYPE_UNSUBSCRIBE, "");//取消订阅
		
		
		SERVICE_MAP.put(Constant.EVENT_KEY_INC_PRODUCT, "clickEventIncInfoAndBusinessHandler");//自定义菜单点击事件（公司产品和业务）
		
		SERVICE_MAP.put(Constant.EVENT_KEY_ACTIVE_INFO, "clickEventActiveInfoHandler");//自定义菜单点击事件（最新活动）
		
		SERVICE_MAP.put(Constant.EVENT_KEY_HIS_WAYBILL_QUERY, "clickEventHisWaybillHandler");//自定义菜单点击事件（历史查询运单）
	}
	
	public static String dispatch(Map<String, String> requestMap,ApplicationContext context) {
		String msgType = requestMap.get(MsgKey.KEY_MSGTYPE);
		if (msgType.equals(MsgUtils.REQ_MESSAGE_TYPE_EVENT)){
			String mapKey = null;
			// 事件类型  
			String event = requestMap.get(MsgKey.KEY_EVENT); 
			if(event.equals(Constant.SUBSCRIBE) || event.equals(Constant.UNSUBSCRIBE)){
				mapKey = event;
			}else{
				mapKey = requestMap.get(MsgKey.KEY_EVENTKEY); 
				//跳转事件
				if(!SERVICE_MAP.keySet().contains(mapKey)){
					return "";
				}
			}
            LOG.info("eventType:"+mapKey);
			IMsgHandler handler = (IMsgHandler)context.getBean(SERVICE_MAP.get(mapKey));
			return handler.handleMsg(requestMap, context);
		}/*else{
			LOG.info("msgType:"+msgType);
			IMsgHandler handler = (IMsgHandler)context.getBean(SERVICE_MAP.get(msgType));
			return handler.handleMsg(requestMap);
		}*/
		else{
			LOG.info("msgType:"+msgType);
			IMsgHandler handler = null;
			//文本类型
			if(MsgUtils.REQ_MESSAGE_TYPE_TEXT.equals(msgType)){
				TextHandler dispatch = new TextHandler();
				String handlerType = dispatch.matchHandler(requestMap);
				//如果是易到家 就走对应的处理类
				handler = (IMsgHandler)context.getBean(SERVICE_MAP.get(handlerType));
			}else {
				//其他类型
				handler = (IMsgHandler)context.getBean(SERVICE_MAP.get(msgType));
			}
			return handler.handleMsg(requestMap, context);
		}
	}
}
