package com.hoau.how.module.util.mail;

/**
 *
 * @author 徐俊
 * @date 2015年6月17日
 */
public interface IMailHelper {
	public void sendSimpleMail(String fromUser, String toUser, String subject,String content);
	public void sendSimpleHtmlMail(String fromUser, String toUser, String subject,String htmlContentText);
}
