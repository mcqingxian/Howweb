package com.hoau.wechat.service.msgHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.exception.XmlTranslateException;
import com.hoau.wechat.service.IActivitiesService;
import com.hoau.wechat.service.IArticleService;
import com.hoau.wechat.servlet.CoreService;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.vo.ActiveInfo;
import com.hoau.wechat.weixin.msg.response.Article;
import com.hoau.wechat.weixin.msg.response.ArticleList;
import com.hoau.wechat.weixin.msg.response.ResNewsMsg;

/** 
* @ClassName  :ClickEventActiveInfoHandler 
* @Description:响应活动信息的点击
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:22:20 
*  
*/
@Service
public class ClickEventActiveInfoHandler implements IMsgHandler {

	@Resource
	private IArticleService articleService;
	
	@Resource
	private IActivitiesService activitiesService;
	
	@Override
	public String handleMsg(Map<String, String> inputParas, ApplicationContext context) {
		String rtn = "";
		ResNewsMsg newsMsg = new ResNewsMsg();
		newsMsg.setToUserName(inputParas.get("FromUserName"));  
		newsMsg.setFromUserName(inputParas.get("ToUserName"));  
		newsMsg.setCreateTime(new Date().getTime());  
		newsMsg.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_NEWS);  
		List<Article> effectiveArticles = getArticles();
		ArticleList articleList = new ArticleList();
		articleList.setItem(effectiveArticles);
		newsMsg.setArticleCount(effectiveArticles.size());
		newsMsg.setArticle(articleList);
		try {
			if(!effectiveArticles.isEmpty()){
				rtn = JaxbUtil.marshToXmlBinding(ResNewsMsg.class, newsMsg);
			}else{
				rtn = CoreService.exception(inputParas, "您好，当前没有活动信息，尽请期待！");
			}
		} catch (JAXBException e) {
			throw new  XmlTranslateException("XML转换异常",e);
		}
		return rtn;
	}

	private List<Article> getArticles() {
		List<Article> e = new ArrayList<Article>();
		List<ActiveInfo> activeInfos = activitiesService.getActiveInfos();
		Collections.sort(activeInfos);
		for(ActiveInfo activeInfo:activeInfos){
			Article article = new Article();
			article.setDescription(activeInfo.getDescription());
			article.setPicUrl(activeInfo.getPic_url());
			article.setTitle(activeInfo.getTitle());
			article.setUrl(activeInfo.getUrl());
			e.add(article);
		}
		return e;
	}
	
	
}
