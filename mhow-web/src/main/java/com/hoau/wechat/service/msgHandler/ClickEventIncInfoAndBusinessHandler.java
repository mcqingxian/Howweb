package com.hoau.wechat.service.msgHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;






import javax.xml.bind.JAXBException;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.exception.XmlTranslateException;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.weixin.msg.response.Article;
import com.hoau.wechat.weixin.msg.response.ArticleList;
import com.hoau.wechat.weixin.msg.response.ResNewsMsg;

/** 
* @ClassName  :ClickEventIncInfoAndBusinessHandler 
* @Description:响应公司信息及业务单击事件
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:31:46 
*  
*/
@Service
public class ClickEventIncInfoAndBusinessHandler implements IMsgHandler {

	@Override
	public String handleMsg(Map<String, String> inputParams,ApplicationContext context) {
		String rtn = "";
		ResNewsMsg newsMsg = new ResNewsMsg();
		newsMsg.setToUserName(inputParams.get(MsgKey.KEY_FROMUSER));  
		newsMsg.setFromUserName(inputParams.get(MsgKey.KEY_TOUSER));  
		newsMsg.setCreateTime(new Date().getTime());  
		newsMsg.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_NEWS);  
		List<Article> articles = new ArrayList<Article>();
		//公司文章
		Article inc = new Article();
		inc.setTitle("欢迎关注天地华宇官方微信服务号！");
		inc.setDescription("天地华宇是中信产业投资基金管理有限公司（简称中信产业基金）旗下的全资公司，也是国家第一批“AAAAA”级资质的物流企业。");
		inc.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200188765&idx=1&sn=61f1715a026cc3ce88601836862b023c#rd");
		inc.setPicUrl("http://mmbiz.qpic.cn/mmbiz/Blr7KsGiaAshKyI3mC93LDiaRJK5wI2v28fL24pBpe8FohzJVUn9RfdLTcoibYhEicBJhaVBrcwsz4lKMwwoGexZPw/0");
		//定日达文章
		Article drd = new Article();
		drd.setTitle("定日达业务");
		drd.setDescription("“定日达”是天地华宇面向企业客户提供的高端公路快运服务");
		drd.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200188765&idx=2&sn=fe7d2acf61bded9a891d7932e48d1018#rd");
		drd.setPicUrl("http://mmbiz.qpic.cn/mmbiz/Blr7KsGiaAshKyI3mC93LDiaRJK5wI2v2859PvdglpSlzaIOEniaKo280TOkKJakYibEoKC8xJ78JJZoQ5hkcyI4bg/0");
		
		//零担文章
		Article ld = new Article();
		ld.setDescription("经济实惠，为客户提供经济实用的全国性标准零担公路运输服务");
		ld.setTitle("零担运输业务");
		ld.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200188765&idx=3&sn=5acfa4beae6417a4eb5c5d0f01df8b5b#rd");
		ld.setPicUrl("http://mmbiz.qpic.cn/mmbiz/Blr7KsGiaAshKyI3mC93LDiaRJK5wI2v2859PvdglpSlzaIOEniaKo280TOkKJakYibEoKC8xJ78JJZoQ5hkcyI4bg/0");
		//整车
		Article zc = new Article();
		zc.setDescription("专车为您服务，门到门一站式公路运输，在全国600个城市的1500家网点提供取送货服务");
		zc.setTitle("整车特运业务");
		zc.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200188765&idx=4&sn=ab027a282aaa1bacb472d648d6777b2e#rd");
		zc.setPicUrl("http://mmbiz.qpic.cn/mmbiz/Blr7KsGiaAshKyI3mC93LDiaRJK5wI2v2859PvdglpSlzaIOEniaKo280TOkKJakYibEoKC8xJ78JJZoQ5hkcyI4bg/0");
		
		Article zz = new Article();
		zz.setDescription("代收货款、货物保价、签单返回");
		zz.setTitle("增值服务");
		zz.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200188765&idx=5&sn=b23602a477fedc078b38dbb3c06c0f64#rd");
		zz.setPicUrl("http://mmbiz.qpic.cn/mmbiz/Blr7KsGiaAshKyI3mC93LDiaRJK5wI2v2859PvdglpSlzaIOEniaKo280TOkKJakYibEoKC8xJ78JJZoQ5hkcyI4bg/0");
		
		
		Article e_b = new Article();
		e_b.setDescription("天地华宇电子商务物流服务（简称天地华宇e服务）是以传统物流为基础，可通过天地华宇官方网站网上营业厅、掌上华宇及国内各大知名电子商务平台实现网上下单、订单管理、价格查询、网点查询、客户资料管理及发货历史清单查询等功能。电子商务物流服务是提升电商客户体验、提高物流效率、助力电商客户成功的有效渠道。");
		e_b.setTitle("电子商务合作");
		e_b.setUrl("http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200188765&idx=6&sn=cc363f21cf2367cdc3febc101c952eed#rd");
		e_b.setPicUrl("http://mmbiz.qpic.cn/mmbiz/Blr7KsGiaAshKyI3mC93LDiaRJK5wI2v2859PvdglpSlzaIOEniaKo280TOkKJakYibEoKC8xJ78JJZoQ5hkcyI4bg/0");
		
		articles.add(inc);
		articles.add(drd);
		articles.add(ld);
		articles.add(zc);
		articles.add(zz);
		articles.add(e_b);
		ArticleList articleList = new ArticleList();
		articleList.setItem(articles);
		newsMsg.setArticleCount(articles.size());
		newsMsg.setArticle(articleList);
		try {
			rtn = JaxbUtil.marshToXmlBinding(ResNewsMsg.class, newsMsg);
		} catch (JAXBException e) {
			throw new  XmlTranslateException("XML转换异常",e);
		}
		return rtn;
	}

}
