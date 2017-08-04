package com.hoau.wechat.vos.templates.data;

import com.hoau.wechat.vos.templates.Field;

/**
 * 
 * @ClassName: SignData 
 * @Description: TODO 订单状态通知(签收成功)Data
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月14日 下午2:22:04 
 *
 */
public class SignData implements IData{
	/**
	 * 欢迎语
	 * 尊敬的客户，您好
	 */
	Field first;
	/**
	 * 运单号
	 * F000000
	 */
	Field keyword1;
	/**
	 * 最新状态
	 * 已签收成功，签收人为：李四。
	 */
	Field keyword2;
	/**
	 * 备注
	 * 签收时间为：2014年11月17日13:59:23
	 */
	Field remark;
	public SignData(Field first,Field keyword1,Field keyword2,Field remark){
		this.first = first;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.remark = remark;
	}
	public Field getFirst() {
		return first;
	}
	public Field getKeyword1() {
		return keyword1;
	}
	public Field getKeyword2() {
		return keyword2;
	}
	public Field getRemark() {
		return remark;
	}
	
	@Override
	public String queryTemplateID() {
		return "ZJWafyQDxdhoYsNsryKqAjFQaQ57Zj4AzTUg45nKdqA";
	}
}
