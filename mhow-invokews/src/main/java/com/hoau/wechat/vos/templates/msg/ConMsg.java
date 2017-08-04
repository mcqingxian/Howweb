package com.hoau.wechat.vos.templates.msg;

import java.io.Serializable;

/**
 * 
 * @ClassName: ConMsg 
 * @Description: TODO 收件成功通知ConMsg
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 上午11:18:27 
 *
 */
public class ConMsg implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -598658655175592796L;
	/**
	 * 欢迎语 
	 * 尊敬的客户: \n 您的货物已揽收成功。
	 */
	String first;
	/**
	 * 运单号
	 * F000000
	 */
	String waybillNo;
	/**
	 * 备注
	 * 点击详情可查看最新运单状态。
	 */
	String remark;
	/**
	 * OpenId
	 */
	String openId;
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getWaybillNo() {
		return waybillNo;
	}
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
