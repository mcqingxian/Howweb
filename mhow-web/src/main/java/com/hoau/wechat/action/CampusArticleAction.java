package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.ICompusActivityService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.utils.TimeUtils;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.ShareRecode;

@Controller
@Scope("prototype")
public class CampusArticleAction extends BasicAction{
	private Logger logger = Logger.getLogger(CampusArticleAction.class);
	@Resource
	private ICompusActivityService compusActivityService;
	
	private String openid;
	private String today;
	
	private ShareRecode shareRecode;
	
	private String articleid = "article20150609";
	private String state;
	private String respMsg;
	
	public String execute(){
		//跳转至转发文章时获取到openid
		openid = WeixinUtil.getOpenIdFromSession();
		today = TimeUtils.getFormatToday();
		state = request.getParameter("state");
		logger.info("openid:"+openid+",articleid:"+articleid+",state:"+state );
		return "success";
	}

	public String recordShared(){
		compusActivityService.saveSharedRecord(shareRecode);
		logger.info(JsonUtils.toJson(shareRecode));
		respMsg = "success";
		return "success";
	}
	
	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public ShareRecode getShareRecode() {
		return shareRecode;
	}

	public void setShareRecode(ShareRecode shareRecode) {
		this.shareRecode = shareRecode;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
}
