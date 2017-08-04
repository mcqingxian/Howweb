package com.hoau.wechat.service.msgHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.context.ApplicationContext;

import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.exception.BusinessException;
import com.hoau.wechat.exception.XmlTranslateException;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.weixin.msg.response.Article;
import com.hoau.wechat.weixin.msg.response.ArticleList;
import com.hoau.wechat.weixin.msg.response.ResNewsMsg;

/**
 * @author：龙海仁
 * @create：2015年11月22日 下午3:20:21
 * @description：推送屏保图文
 */
public class ScreensaverTextHandler   implements IMsgHandler{
	@Override
	public String handleMsg(Map<String, String> inputParams, ApplicationContext context) throws BusinessException {
		String respContent;
		ResNewsMsg newsMsg = new ResNewsMsg();
		newsMsg.setToUserName(inputParams.get(MsgKey.KEY_FROMUSER));  
		newsMsg.setFromUserName(inputParams.get(MsgKey.KEY_TOUSER));  
		newsMsg.setCreateTime(new Date().getTime());  
		newsMsg.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_NEWS);  
		List<Article> articles = new ArrayList<Article>();
		//易到家红包
		Article inc = new Article();
		inc.setTitle("易到家给您派送红包");
		inc.setDescription("查看红包(截止时间2015-6-30)");
		inc.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsh7Y6kaASXGmrhHtt9O4laicR8W61mzEtdXcc3QC8J8MOWvpUPlZNptMH7N9XickibMG2ZM4nhucefXg/0?wxfmt=png");
		inc.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/lotteryShow.action?response_type=code&scope=snsapi_base&state=1#wechat_redirect");
	
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
		return respContent;
	}
}
