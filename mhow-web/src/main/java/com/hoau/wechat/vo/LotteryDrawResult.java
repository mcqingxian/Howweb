package com.hoau.wechat.vo;

/** 
* @ClassName: LotteryDrawResult 
* @Description: 抽奖结果实体
* @author xujun jun.xu@hoau.net
* @date 2014年7月31日 上午10:36:33 
*  
*/
public class LotteryDrawResult {
	// 1 中间 0 未中奖
	private int status;
	// 奖券
	private Vouchers vouchers;
	// 备注
	private String remark;
	// 是否有抽奖资格 0 无资格
	private boolean qualification;
	// 图片名称
	private String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Vouchers getVouchers() {
		return vouchers;
	}

	public void setVouchers(Vouchers vouchers) {
		this.vouchers = vouchers;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isQualification() {
		return qualification;
	}

	public void setQualification(boolean qualification) {
		this.qualification = qualification;
	}
}
