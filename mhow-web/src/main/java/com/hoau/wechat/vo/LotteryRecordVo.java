package com.hoau.wechat.vo;

/** 
* @ClassName: LotteryRecordVo 
* @Description: 最新中奖记录  每一条记录的实体
* @author xujun jun.xu@hoau.net
* @date 2014年7月31日 下午5:31:33 
*  
*/
public class LotteryRecordVo {
	private String phone;
	private String detail;
	private String time;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
