package com.hoau.wechat.service.msgHandler;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SubscribeEventHandler extends AbstractResponseText{

	@Override
	protected String genContent(Map<String, String> inputParams, ApplicationContext context) {
		StringBuilder sb = new StringBuilder();
		sb.append("感谢关注，华宇这就给您奉上10元运费抵用券一张 /微笑 \r\n\r\n");
		sb.append("请回复[抵用券]字样领用。\r\n\r\n ");
		sb.append("更多市场活动 ，详情请见 '华宇助手 -> 最新活动'");
		sb.append("直接回复运单号，如：“F1234567”，可查询运单状态 ");
		return sb.toString();
	}
	
}
