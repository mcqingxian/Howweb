package com.hoau.wechat.vos.templates.msg;

import java.io.Serializable;

/**
 * 
 * @ClassName: DelivMsg 
 * @Description: TODO 提货通知DelivMsg
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 上午11:17:22 
 *
 */
public class DelivMsg implements Serializable{
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -7623680570283663282L;
	/**
	 * 欢迎语
	 * 尊敬的客户: \n 您好，您的运单物品已抵达目的地，请做好提货准备。
	 */
	String first;
	/**
	 * 运单号
	 * F000000
	 */
	String keyword1;
	/**
	 * 应付款
	 * 100.00元
	 */
	String keyword2;
	/**
	 * 提货地点
	 * 闵行区华翔路2239号，联系人（张三），手机：1381928931
	 */
	String keyword3;
	/**
	 * 备注
	 * 请凭证件提货，联系电话：400-808-6666
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
	public String getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}
	public String getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}
	public String getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
