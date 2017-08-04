package com.hoau.wechat.vos.templates.data;

import com.hoau.wechat.vos.templates.Field;

/**
 * 
 * @ClassName: ConData 
 * @Description: TODO 收件成功通知Data
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月14日 下午2:22:04 
 *
 */
public class ConData implements IData{
	/**
	 * 欢迎语 
	 * 尊敬的客户: \n 您的货物已揽收成功。
	 */
	Field first;
	/**
	 * 运单号
	 * F000000
	 */
	Field waybillNo;
	/**
	 * 备注
	 * 点击详情可查看最新运单状态。
	 */
	Field remark;
	public ConData(Field first,Field waybillNo,Field remark){
		this.first = first;
		this.waybillNo = waybillNo;
		this.remark = remark;
	}
	public Field getFirst() {
		return first;
	}
	public Field getWaybillNo() {
		return waybillNo;
	}
	public Field getRemark() {
		return remark;
	}
	
	@Override
	public String queryTemplateID() {
		return "DoBOe_UcaK3_E7Nv1YZSs0vwSV1Jz_sy3_BHV82WTK0";
	}
}
