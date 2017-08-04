package com.hoau.wechat.service.msgHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.dao.ILotteryRecordDao;
import com.hoau.wechat.exception.BusinessException;
import com.hoau.wechat.exception.XmlTranslateException;
import com.hoau.wechat.service.impl.PhoneBindService;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.UserInfo;
import com.hoau.wechat.weixin.msg.response.Article;
import com.hoau.wechat.weixin.msg.response.ArticleList;
import com.hoau.wechat.weixin.msg.response.ResNewsMsg;
import com.hoau.wechat.weixin.msg.response.ResTextMsg;

/**
* @ClassName: JdActiveHandler
* @Description:京东家装节活动
* @author hairen.long@hoau.net
* @date 2015年7月18日 上午10:06:00
*/
@Service
public class JdActiveHandler implements IMsgHandler{
	
	@Resource
	private PhoneBindService phoneBindService;
	@Resource
	private ILotteryRecordDao lotteryRecordDao;

	@Override
	public String handleMsg(Map<String, String> inputParams,
			ApplicationContext context) throws BusinessException {
		String respContent = "";
		//请求消息信息
		String fromUser = inputParams.get(MsgKey.KEY_FROMUSER);
		
		//是否满足条件
		int isSatisfied = 0;
		
		//是否绑定手机号
		UserInfo userInfo = phoneBindService.findOneUserInfo(fromUser);
		if(userInfo == null || StringUtil.isEmpty(userInfo.getPhone())){
			isSatisfied = 1;
		}else{
			//一个手机号可最多可以领取3张抵用卷
			List<LotteryRecord> records = lotteryRecordDao.queryLotteryRecord(fromUser, Constant.JD_JZJ_ACTIVE_TYPE, userInfo.getPhone());
			if(records.size() >= 3){
				isSatisfied = 2;
			}
		}
		
		if(isSatisfied == 0){
			long versionNo = UUIDUtil.getVersion();
			//返回消息信息
			ResNewsMsg newsMsg = new ResNewsMsg();
			newsMsg.setToUserName(inputParams.get(MsgKey.KEY_FROMUSER));  
			newsMsg.setFromUserName(inputParams.get(MsgKey.KEY_TOUSER));  
			newsMsg.setCreateTime(new Date().getTime());  
			newsMsg.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_NEWS);  
			List<Article> articles = new ArrayList<Article>();
			//京东家装节送优惠券 红包链接
			Article inc = new Article();
			inc.setTitle("京东家装节，华宇送红包");
			inc.setDescription("京东家装节,华宇送红包。");
			
			inc.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsh7Y6kaASXGmrhHtt9O4laicR8W61mzEtdXcc3QC8J8MOWvpUPlZNptMH7N9XickibMG2ZM4nhucefXg/0?wxfmt=png");
			inc.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/jdActiveAction.action?versionNo="+versionNo+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
			
			articles.add(inc);
			ArticleList articleList = new ArticleList();
			articleList.setItem(articles);
			newsMsg.setArticleCount(articles.size());
			newsMsg.setArticle(articleList);
			
			try {
				respContent = JaxbUtil.marshToXmlBinding(ResNewsMsg.class, newsMsg);
			} catch (JAXBException e) {
				throw new  XmlTranslateException("XML转换异常",e);
			}
		}else{
			ResTextMsg textMessage = new ResTextMsg();
			textMessage.setToUserName(inputParams.get("FromUserName"));  
		    textMessage.setFromUserName(inputParams.get("ToUserName"));  
		    textMessage.setCreateTime(new Date().getTime());  
		    textMessage.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_TEXT);  
		    textMessage.setFuncFlag(0); 
		    if(isSatisfied == 1){
		    	textMessage.setContent("请绑定手机号,天地华宇微信公众号右下角【华宇助手】->【手机绑定】");
		    }else if(isSatisfied == 2){
		    	textMessage.setContent("该手机号最多只能领三张优惠券/::)");
		    }
		    
		    try {
		    	respContent = JaxbUtil.marshToXmlBinding(ResTextMsg.class, textMessage);
			} catch (JAXBException e) {
				throw new XmlTranslateException("XML转换异常", e);
			}
		}
		
		return respContent;
	}

}
