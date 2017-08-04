package com.hoau.wechat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.weixin.msg.response.Article;
import com.hoau.wechat.weixin.msg.response.ResBaseMsg;
import com.hoau.wechat.weixin.msg.response.ResNewsMsg;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @ClassName:   MsgUtils 
 * @Description: 消息工具类
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月2日 下午5:56:04
 */
public class MsgUtils {
	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
    
    /** 
     * 请求消息类型：文本  易到家 
     */  
   public static final String REQ_MESSAGE_TYPE_TEXT_YDJ = "text_ydj";  
   
   /**
    * 请求消息类型：文本  定日达
    */
   public static final String REQ_MESSAGE_TYPE_TEXT_WAYBILL = "text_Waybill";  
   
   /**
    * 请求消息类型：文本  运单送抵用券
    */
   public static final String REQ_MESSAGE_TYPE_TEXT_SEND_VOUCHERS = "text_vouchers";
   
   /**
    * 请求消息类型：文本  京东家装节活动
    */
   public static final String REQ_MESSAGE_TYPE_TEXT_JD_JZJ = "text_jd_jzj";
   
   /**
    * 请求消息类型：文本  推送屏保图文消息
    */
   public static final String REQ_MESSAGE_TYPE_TEXT_SCREENSAVER = "text_screensaver";
   
    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
  
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String processRequest(HttpServletRequest request)
			throws IOException {
		InputStream is = request.getInputStream();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String line = "";
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		return sb.toString();
	}  
	
	
	
	@SuppressWarnings("unchecked")  
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
	    // 将解析结果存储在HashMap中  
	    Map<String, String> map = new HashMap<String, String>();  
	  
	    // 从request中取得输入流  
	    InputStream inputStream = request.getInputStream();  
	    // 读取输入流  
	    SAXReader reader = new SAXReader();  
	    Document document = reader.read(inputStream);  
	    // 得到xml根元素  
	    Element root = document.getRootElement();  
	    // 得到根元素的所有子节点  
	    List<Element> elementList = root.elements();  
	  
	    // 遍历所有子节点  
	    for (Element e : elementList)  
	        map.put(e.getName(), e.getText());  
	    // 释放资源  
	    inputStream.close();  
	    inputStream = null;  
	    return map;  
	}  
	
	/** 
	 * 文本消息对象转换成xml 
	 *  
	 * @param textMessage 文本消息对象 
	 * @return xml 
	 */  
	public static String textMessageToXml(ResBaseMsg textMessage) {  
	    xstream.alias("xml", textMessage.getClass());  
	    return xstream.toXML(textMessage);  
	}  
	  
//	/** 
//	 * 音乐消息对象转换成xml 
//	 *  
//	 * @param musicMessage 音乐消息对象 
//	 * @return xml 
//	 */  
//	public static String musicMessageToXml(MusicMessage musicMessage) {  
//	    xstream.alias("xml", musicMessage.getClass());  
//	    return xstream.toXML(musicMessage);  
//	}  
	  
	/** 
	 * 图文消息对象转换成xml 
	 *  
	 * @param newsMessage 图文消息对象 
	 * @return xml 
	 */  
	public static String newsMessageToXml(ResNewsMsg newsMessage) {  
	    xstream.alias("xml", newsMessage.getClass());  
	    xstream.alias("item", new Article().getClass());  
	    return xstream.toXML(newsMessage);  
	}  
	
	public static String toHyperlink(String linkAddress,String text,int type){
		String result = "";
		String link = "<a href=\"%s\">%s</a>";
		switch (type) {
		case Constant.LINK_TYPE_TEL:
			result = String.format(link, "tel:"+linkAddress,text);
			break;
		case Constant.LINK_TYPE_URL:
			result = String.format(link, linkAddress,text);
			break;
		default:
			break;
		}
		return result;
	}
	  
	public static void main(String[] args) {
		System.out.println(toHyperlink("www.baidu.com","123",1));
		
		System.out.println(toHyperlink("13817878878","234",0));
	}
	/** 
	 * 扩展xstream，使其支持CDATA块 
	 *  
	 * @date 2013-05-19 
	 */  
	private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // 对所有xml节点的转换都增加CDATA标记  
	            boolean cdata = true;  
	            public void startNode(String name, Class clazz) {  
	                super.startNode(name, clazz);  
	            }  
	            protected void writeText(QuickWriter writer, String text) {  
	                if (cdata) {  
	                    writer.write("<![CDATA[");  
	                    writer.write(text);  
	                    writer.write("]]>");  
	                } else {  
	                    writer.write(text);  
	                }  
	            }  
	        };  
	    }  
	});  
}	
