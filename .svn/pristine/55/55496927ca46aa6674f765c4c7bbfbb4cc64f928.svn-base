package com.hoau.mhow.module.bse.server.service.impl;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hoau.mhow.module.bse.api.server.service.IMailHelper;

/**
 * 
 * @author 徐俊
 * @date 2015年6月17日
 */
@Service
public class MailHelper implements IMailHelper {
	public static final String FROM_USER = "guanwang@hoau.net";
	
	@Resource(name="mailSender")
	JavaMailSender mailSender;

	/**
	 * 发送简单文本邮件
	 */
	@Override
	public void sendSimpleMail(String fromUser, String toUser, String subject,String content) {
		SimpleMailMessage mail = new SimpleMailMessage(); 
		try {
			mail.setTo(toUser);// 接受者
			mail.setFrom(fromUser);// 发送者,这里还可以另起Email别名，不用和xml里的username一致
			mail.setSubject(subject);// 主题
			mail.setText(content);// 邮件内容
			mailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 发送html格式内容邮件
	 * 
	 * @param fromUser
	 * @param toUser
	 * @param subject
	 * @param htmlContentText
	 * @author 张爱萍
	 * @date 2015年6月24日
	 * @update
	 */
	public void sendSimpleHtmlMail(String fromUser, String toUser, String subject,String htmlContentText){
		MimeMessage mailMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(mailMessage,true, "utf-8");
			messageHelper.setFrom(fromUser);
			messageHelper.setTo(toUser);
			messageHelper.setSubject(subject);
			messageHelper.setText(htmlContentText, true);
			mailSender.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");
		System.out.println(sender);
		SimpleMailMessage mail = new SimpleMailMessage(); // <span
		MimeMessage mailMessage = sender.createMimeMessage();
		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(mailMessage,true);
			messageHelper.setFrom("guanwang@hoau.net");
			messageHelper.setTo("hyssmt@vip.qq.com");
			messageHelper.setSubject("天地华宇 运单跟踪信息");
			messageHelper.setText("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>"
					+ "<body align='left'><h1>天地华宇特许经营申请信息</h1>"
					+ "<p><h4>申请省市：XX省XX市</h4></p>"
					+ "<p><h4>申请地区：XXX</h4></p>"
					+ "<p><h4>公司/个人名称：XXX</h4></p>	"
					+ "<p><h4>公司注册资金：</h4></p>"
					+ "<p><h4>员工人数：</h4></p>"
					+ "<p><h4>联系人：</h4></p>"
					+ "<p><h4>联系方式：</h4></p>"
					+ "<p><h4>email：</h4></p>"
					+ "<p><h4>场地面积(㎡)：</h4></p>"
					+ "<p><h4>自有车辆：</h4></p>"
					+ "<p><h4>留言：</h4></p></body></html>", true);
			sender.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}												// style="color: #ff0000;">注意SimpleMailMessage只能用来发送text格式的邮件</span>
//		try {
//			mail.setTo("519097614@qq.com");// 接受者
//			mail.setFrom("guanwang@hoau.net");// 发送者,这里还可以另起Email别名，不用和xml里的username一致
//			mail.setSubject("天地华宇 运单跟踪信息");// 主题
//			mail.setText("springMail的简单发送测试");// 邮件内容
//			sender.send(mail);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
