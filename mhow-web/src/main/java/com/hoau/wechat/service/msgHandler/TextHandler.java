package com.hoau.wechat.service.msgHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.MsgUtils;


/**
* @ClassName: TextHandler
* @Description:文本消息分发处理
* @author hairen.long@hoau.net
* @date 2015年5月31日 下午7:41:29
*/
public class TextHandler {
	
	public String matchHandler(Map<String, String> inputParams){
		String respContent = MsgUtils.REQ_MESSAGE_TYPE_TEXT;
		String requestMsg = inputParams.get(MsgKey.KEY_CONTENT);
		if(requestMsg.contains(Constant.YDJ)){
			//易到家
			respContent = MsgUtils.REQ_MESSAGE_TYPE_TEXT_YDJ;
		}else if(!StringUtil.isEmpty(TextMsgHandler.extractWaybill(requestMsg))){ 
			//运单
			respContent = MsgUtils.REQ_MESSAGE_TYPE_TEXT_WAYBILL;
		}else if("1".equals(requestMsg)){
			//运单送抵用券
			respContent = MsgUtils.REQ_MESSAGE_TYPE_TEXT_SEND_VOUCHERS;
		}else if(Constant.JD_JZJ_ACTIVE.equals(requestMsg) && activDate()){
			//京东家装节活动 活动日期：7月21日、7月22日
			respContent = MsgUtils.REQ_MESSAGE_TYPE_TEXT_JD_JZJ;
		}else if(requestMsg.equals(Constant.SEND_SCREENSAVER_MPNEW)){
			//推送屏保
			respContent = MsgUtils.REQ_MESSAGE_TYPE_TEXT_JD_JZJ;
		}
		return respContent;
	}
	
	/**
	 * @Title: activDate
	 * @Description:京东家装节活动时间
	 * @return
	 */
	private boolean activDate(){
		boolean isOk = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//TODO
			if(sdf.parse("2015-07-18 00:00:00").getTime() < sdf.parse(sdf.format(new Date())).getTime()
					&& sdf.parse("2015-07-22 23:59:59").getTime() > sdf.parse(sdf.format(new Date())).getTime()){
				isOk = true;
			}
		} catch (ParseException e) {
			return false;
		}
		return isOk;
	}
	
}
