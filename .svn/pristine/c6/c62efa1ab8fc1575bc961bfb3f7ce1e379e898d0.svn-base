package com.hoau.wechat.vos.templates.data;

import com.hoau.wechat.vos.templates.Field;

/**
 * 
 * @ClassName: DelivData 
 * @Description: TODO 提货通知Data
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月14日 下午2:22:04 
 *
 */
public class DelivData implements IData{
	/**
	 * 欢迎语
	 * 尊敬的客户: \n 您好，您的运单物品已抵达目的地，请做好提货准备。
	 */
	Field first;
	/**
	 * 运单号
	 * F000000
	 */
	Field keyword1;
	/**
	 * 应付款
	 * 100.00元
	 */
	Field keyword2;
	/**
	 * 提货地点
	 * 闵行区华翔路2239号，联系人（张三），手机：1381928931
	 */
	Field keyword3;
	/**
	 * 备注
	 * 请凭证件提货，联系电话：400-808-6666
	 */
	Field remark;
	public DelivData(Field first,Field keyword1,Field keyword2,Field keyword3,Field remark){
		this.first = first;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
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
	public Field getKeyword3() {
		return keyword3;
	}
	public Field getRemark() {
		return remark;
	}

	@Override
	public String queryTemplateID() {
		return "PYLCYw2iLLYKlYLUstzVDvo9qA8Jc5eAWnur9TwSfAw";
	}
}
