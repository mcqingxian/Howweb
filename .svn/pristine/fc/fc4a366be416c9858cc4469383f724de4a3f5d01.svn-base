package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.IPhoneBindService;
import com.hoau.wechat.service.ISMSservice;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.ValidateCodeGen;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.UserInfo;
import com.opensymphony.xwork2.Action;

/** 
* @ClassName  :PhoneBindAction 
* @Description:手机号绑定 
* @author     :xujun cometzb@126.com	
* @date       :2014年4月15日 下午3:07:52 
*  
*/
@Controller
@Scope("prototype")
public class PhoneBindAction implements Action{

	private Log log = LogFactory.getLog(PhoneBindAction.class);
	/**
	 * 微信传入的换取access_token  code
	 */
	private String code;
	/**
	 * 绑定的电话号码
	 */
	private String phone;
	
	/**
	 * 处理之后加星的电话号码
	 */
	private String star_phone;
	
	private String noticeMsg;
	
	private String validateCode;
	
	@Resource
	private IPhoneBindService phoneBindService;
	
	@Resource
	private ISMSservice ismSservice;
	
	@Override
	public String execute() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		String vCode = phoneBindService.getValiteCode(openId);
		//绑定成功跳转到信息界面
		if(vCode.equals(validateCode)){
			toStarPhone(phone);
			phoneBindService.phoneBind(phone,openId);
			return SUCCESS;
		}else{
			noticeMsg = "error";
			return SUCCESS;
		}
	}

	public String bindSuccess() throws Exception {
		toStarPhone(phone);
		return SUCCESS;
	}
	
	public String getValiteCode() throws Exception {
		String valCode = ValidateCodeGen.genCode();
		log.info(valCode);
		
//		ServletActionContext.getServletContext().setAttribute("validateCode", valCode);
		String openId = WeixinUtil.getOpenIdFromSession();
		
		phoneBindService.saveValidate(openId,valCode);
		
		ismSservice.sendWechatCheckCode(phone, valCode);
		noticeMsg = "验证码已下发到您的手机";
		return SUCCESS;
	}
	
	public String changeBind() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		String vCode = phoneBindService.getValiteCode(openId);
		//2）输入的验证码是否正确
		if(!vCode.equals(validateCode)){
			noticeMsg = "validateCode_error";
			return SUCCESS;
		}
		//3）重新绑定
		phoneBindService.changeBind(phone, openId);
		return SUCCESS;
	}
	
	public String toChangeBindPage() throws Exception {
		//获取用户信息
		String openId = WeixinUtil.getOpenIdFromSession();
		UserInfo userInfo = phoneBindService.findOneUserInfo(openId);
		if(userInfo!= null){
			toStarPhone(userInfo.getPhone());
		}
		//设置加星手机号
		return SUCCESS;
	}
	
	public String toMobileBindPage() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		UserInfo userInfo = phoneBindService.findOneUserInfo(openId);
		if(userInfo != null && !StringUtil.isEmpty(userInfo.getPhone())){
			toStarPhone(userInfo.getPhone());
			return "change_page";
		}else{
			return "bind_page";
		}
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public String getNoticeMsg() {
		return noticeMsg;
	}

	public void setNoticeMsg(String noticeMsg) {
		this.noticeMsg = noticeMsg;
	}

	public void setPhoneBindService(IPhoneBindService phoneBindService) {
		this.phoneBindService = phoneBindService;
	}

	public void setIsmSservice(ISMSservice ismSservice) {
		this.ismSservice = ismSservice;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getStar_phone() {
		return star_phone;
	}

	public void setStar_phone(String star_phone) {
		this.star_phone = star_phone;
	}
	
	public void toStarPhone(String phoneNum){
		if(phoneNum.length() == 11){
			String sub1 = phoneNum.substring(0, 3);
			String sub2 = phoneNum.substring(7);
			star_phone = sub1 +"****"+sub2;
			//绑定手机
		}else{
			throw new IllegalArgumentException("手机号输入有误");
		}
	}
}
