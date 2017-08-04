package com.hoau.wechat.service.msgHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.service.IGoodsService;
import com.hoau.wechat.service.IPhoneBindService;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.vo.UserInfo;

/** 
* @ClassName  :ClickEventHisWaybillHandler 
* @Description:响应运单查询历史单击事件
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:24:57 
*  
*/
@Service
public class ClickEventHisWaybillHandler extends AbstractResponseText {

	@Resource
	private IGoodsService goodsService;
	
	@Resource
	private IPhoneBindService phoneBindService;
	
	@Override
	protected String genContent(Map<String, String> inputParams, ApplicationContext context) {
		String openId = inputParams.get("FromUserName");
		StringBuilder sb = new StringBuilder(); 
		List<String> waybills = new ArrayList<String>();
		try {
			//判断是否绑定手机  PhoneBindService
			UserInfo userInfo = phoneBindService.findOneUserInfo(openId);
			if(userInfo == null || (userInfo != null && StringUtil.isEmpty(userInfo.getPhone()))){
				sb.append("需要进行手机绑定之后，才能使用该功能。（绑定手机之后能够保存您最近运单查询记录和进行常用联系人管理，给您带来更多方便）");
				return sb.toString();
			}
			
			//waybills = goodsService.latestWaybill(openId);
			if(waybills == null || waybills.size() == 0){
				sb.append("你最近没有运单查询记录");
			}else{
				sb.append("以下是您最近运单查询历史，点你查看跟踪记录\r\n");
				sb.append("\r\n");
				for(int i = 0; i < waybills.size(); i++){
					String wb = waybills.get(i);
					String url = "http://wechat.hoau.net/wechat/waybillTrace.action?waybill="+ wb+"&openId="+openId;
					sb.append(1+i+"、").append(MsgUtils.toHyperlink(url,"【  查询  】", Constant.LINK_TYPE_URL)).append(wb).append("\r\n");
					sb.append("\r\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
