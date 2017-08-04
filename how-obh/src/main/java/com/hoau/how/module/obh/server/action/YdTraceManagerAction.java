package com.hoau.how.module.obh.server.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.bse.shared.vo.GoodsTraceResultVo;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.itf.server.ws.sms.ISmsServices;
import com.hoau.how.module.itf.server.ws.sms.impl.SMS;
import com.hoau.how.module.obh.server.service.IGoodsTraceService;
import com.hoau.how.module.util.Utils;
import com.hoau.how.module.util.date.DateUtils;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class YdTraceManagerAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryName;
	// 用户输入验证码
	private String vercode;
	// 运单跟踪时的运单号
	private String transNos;
	// 运单查询结果
	private List<GoodsTraceResultVo> ydTraceList = new ArrayList<GoodsTraceResultVo>();
	@Resource
	private IGoodsTraceService goodsTraceService;
	private String errorMsg;
	private String emailAddress;
	private Logger logger = Logger.getLogger(RegistAction.class);

	/**
	 * 倒计时 add huyuzhou
	 */
	private Long countdown;
	private static final Long COUNT_DOWN = 60L;
	// 用户输入手机号 add huyuzhou
	private String ebccMobile;
	private String searchType;// 查询类型 1订单 2手机
	private String sendDate;// 发货时间
	private String isIndexSikp;//是否主页跳转过来

	@Resource
	private ISmsServices smsServices;

	/**
	 * end
	 */
	// 运单跟踪
	public String traceTransByNo() {
		searchType = "1";
		if (vercode == null && transNos == null) {
			return returnSuccess();
		}
		if (checkVercode()) {
			try {
				
				ydTraceList = goodsTraceService.goodsTrace(transNos);
				if (ydTraceList.size() > 10) {
					ydTraceList = ydTraceList.subList(0, 9);
				}
				// 保存本次查询运单号到session
				ActionContext ctx = ActionContext.getContext();
				transNos = transNos.replace("<br/>", "\r\n");
				ctx.getSession().put("waybills", transNos);
			} catch (BusinessException e) {
				this.setErrorMsg("查询轨迹异常，请重新查询！");
				return returnError(e);
			} catch (Exception e) {
				this.setErrorMsg("查询轨迹异常，请重新查询！");
				e.printStackTrace();
			}
		}
		// 最近查询记录
		return returnSuccess();
	}

	/**
	 * add huyuzhou 2016年3月8日15:01:27 检查查询时验证码是否相同
	 * 
	 * @return
	 */
	public String checkInfo() {
		searchType = "2";
		ActionContext ctx = ActionContext.getContext();
		Object obj = ctx.getSession().get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_SMS_VERCODE);
		String registSmsVerCode = null;
		if (ebccMobile == null || "".equals(ebccMobile)) {
			setErrorMsg("请先填写手机号！ ");
			return "checkInfo";
		}
		if (obj == null) {
			setErrorMsg("请先获取短信验证码！ ");
			return "checkInfo";
		} else {
			registSmsVerCode = obj.toString();
		}
		if (this.vercode == null || this.vercode.equals("")) {
			setErrorMsg("短信验证码不能为空！ ");
			return "checkInfo";
		} else if (!this.vercode.equals(registSmsVerCode)) {
			setErrorMsg("短信验证码错误！ ");
			return "checkInfo";
		}
		setErrorMsg("");
		return "checkInfo";
	}

	/**
	 * add huyuzhou 2016年3月4日10:27:49 根据手机号查询订单信息
	 * 
	 * @return
	 */
	public String tracePhoneByNo() {
		searchType = "2";
		// 从主页过来
		String referer = ServletActionContext.getRequest().getHeader("Referer");
		if (StringUtil.isNotEmpty(referer) && referer.contains("index.action")) {
			setIsIndexSikp("1");
			return returnSuccess();
		}
		//调用DC接口获取该手机号时间内最新订单
		transNos = goodsTraceService.queryOneWaybill(ebccMobile, sendDate);
		logger.info("transNos:"+transNos + " ebccMobile:" + ebccMobile + " sendDate:"+sendDate );
		// 根据手机号和时间查询订单号
		if (transNos == null || transNos.equals("")) {
			return returnSuccess();
		}
		ActionContext ctx = ActionContext.getContext();
		try {
			ydTraceList = goodsTraceService.goodsTrace(transNos);
			if (ydTraceList.size() > 10) {
				ydTraceList = ydTraceList.subList(0, 9);
			}
			// 保存本次查询运单号到session
			transNos = transNos.replace("<br/>", "\r\n");
			ctx.getSession().put("waybills", transNos);
		} catch (BusinessException e) {
			this.setErrorMsg("查询轨迹异常，请重新查询！");
			return returnError(e);
		} catch (Exception e) {
			this.setErrorMsg("查询轨迹异常，请重新查询！");
			e.printStackTrace();
		}
		// 最近查询记录
		return returnSuccess();
	}

	/**
	 * 校验验证码是否正确
	 * 
	 * @return
	 */
	private boolean checkVercode() {
		// 从主页过来不需要验证码
		String referer = ServletActionContext.getRequest().getHeader("Referer");
		if (StringUtil.isNotEmpty(referer) && referer.contains("index.action")) {
			return true;
		}
		// 从Session中获取验证码
		ActionContext ctx = ActionContext.getContext();
		// 先根据session记录的imgCode检查用户输入的验证码
		String imgCode = (String) ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.VERCODE);
		ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.VERCODE, null);
		if (null != vercode && vercode.equalsIgnoreCase(imgCode)) {
			return true;
		} else {
			return false;
		}
	}

	// 运单跟踪
	public String sendEmail() {
		try {
			ActionContext ctx = ActionContext.getContext();
			String waybills = (String) ctx.getSession().get("waybills");
			goodsTraceService.sendEmail(waybills, emailAddress);
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
	}

	public static List<String> duplicateRemoval(List<String> source) {
		Set<String> s = new HashSet<String>(source);
		return new ArrayList<String>(s);
	}

	/**
	 * 发送手机验证码
	 * 
	 * @return
	 * @author huyuzhou
	 * @date 2016年3月3日17:03:32
	 * @update add
	 */
	public String sendPhoneVerCodeJson() {
		try {
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession()
					.get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME);
			boolean sendMsg = false;
			if (obj == null) {
				// 倒计时为60秒
				this.setCountdown(COUNT_DOWN);
				// 将第一次获取验证码时间保存
				ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME,
						DateUtils.getCurYmdhms());
				sendMsg = true;
			} else {
				// 第一次获取验证码时间
				Long phoneVercodeSendTime = Long.parseLong(obj.toString());
				// 当前时间
				Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
				this.setCountdown(curDate - phoneVercodeSendTime);
				this.setCountdown(COUNT_DOWN - this.getCountdown());
				// 超过60秒后，可重新发送,并且清空session
				if (this.getCountdown() <= 0) {
					sendMsg = true;
					this.setCountdown(COUNT_DOWN);
					ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME,
							DateUtils.getCurYmdhms());
				} else {
					this.setErrorMsg("请在" + this.getCountdown() + "秒后进行操作！");
				}
			}
			if (sendMsg && ebccMobile != null && !ebccMobile.equals("")) {
				String phoneSmsVercode = Utils.randomNum(6);
				logger.info(phoneSmsVercode);
				SMS sms = new SMS(this.ebccMobile, "【您的验证码为：" + phoneSmsVercode + "，感谢您使用天地华宇】（验证码有效时间:10min）");
				smsServices.put(sms);
				// 将手机验证码保存至session
				ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_SMS_VERCODE,
						phoneSmsVercode);
				this.setThisSuccessMsg("短信已发送，请注意查收！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("RegistAction sendPhoneVerCodeJson error : " + ex.getMessage());
		}
		logger.info("手机号：" + this.ebccMobile + "，验证码发送结果：" + this.getErrorMsg());
		return "sendPhoneVerCodeJson";
	}

	/**
	 * 检测发送验证码时间是超过指定时间
	 * 
	 * @return add
	 * @author huyuzhou
	 * @date 2016年3月3日17:03:46
	 * @update
	 */
	public String checkCountDownPhoneJson() {
		try {
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession()
					.get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME);
			if (obj != null) {
				// 第一次获取验证码时间
				Long phoneVercodeSendTime = Long.parseLong(obj.toString());
				// 当前时间
				Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
				this.setCountdown(curDate - phoneVercodeSendTime);
				this.setCountdown(COUNT_DOWN - this.getCountdown());
				// 超过60秒后，可重新发送,并且清空session
				if (this.getCountdown() <= 0) {
					ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME,
							null);
				} else {
					this.setErrorMsg("请在" + this.getCountdown() + "秒后进行操作！");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("RegistAction checkCountDownPhoneJson error : " + ex.getMessage());
		}
		return "checkCountDownPhoneJson";
	}

	/**
	 * end
	 */

	private void setThisSuccessMsg(String msg) {
		this.setErrorMsg("<p class='succ'><span class='icon_succ'></span>" + msg + "</p>");
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getTransNos() {
		return transNos;
	}

	public void setTransNos(String transNos) {
		this.transNos = transNos;
	}

	public List<GoodsTraceResultVo> getYdTraceList() {
		return ydTraceList;
	}

	public void setYdTraceList(List<GoodsTraceResultVo> ydTraceList) {
		this.ydTraceList = ydTraceList;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getEbccMobile() {
		return ebccMobile;
	}

	public void setEbccMobile(String ebccMobile) {
		this.ebccMobile = ebccMobile;
	}

	public Long getCountdown() {
		return countdown;
	}

	public void setCountdown(Long countdown) {
		this.countdown = countdown;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getIsIndexSikp() {
		return isIndexSikp;
	}

	public void setIsIndexSikp(String isIndexSikp) {
		this.isIndexSikp = isIndexSikp;
	}

}
