package com.hoau.how.module.obh.shared.domain;

import java.io.Serializable;

/**
 * @author：张贞献
 * @create：2015年8月19日 下午3:29:48
 * @description：
 */
public class ClaimValidEntity implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 理赔运单编号
	 */
    private String billNo;
    
    /**
	 * 理赔方(发货方：DEPART; 收货方： 收货方  DEST)
	 */
	private String claimParty;
	
	 /**
     * 运单上联系电话
     */
    private String billTel;
	
	/**
	 * 理赔公司所在地(收货方)
	 */
	private String destCompanyAddr;
	
	/**
	 * 理赔公司所在地(发货方)
	 */
	private String departCompanyAddr;
	
	
	/**
     * 货物名称:(例如：服装)
     */
	
    private String cargoType;
    
	/**
	 * 校验（1：成功，2：失败）
	 */
	private String status;
	/**
	 * 校验失败提示信息
	 */
	private String errroInfo;
	/**
	 * 运单件数
	 */
	private int pieces;


	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getClaimParty() {
		return claimParty;
	}

	public void setClaimParty(String claimParty) {
		this.claimParty = claimParty;
	}

	public String getBillTel() {
		return billTel;
	}

	public void setBillTel(String billTel) {
		this.billTel = billTel;
	}

	public String getDestCompanyAddr() {
		return destCompanyAddr;
	}

	public void setDestCompanyAddr(String destCompanyAddr) {
		this.destCompanyAddr = destCompanyAddr;
	}

	public String getDepartCompanyAddr() {
		return departCompanyAddr;
	}

	public void setDepartCompanyAddr(String departCompanyAddr) {
		this.departCompanyAddr = departCompanyAddr;
	}

	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrroInfo() {
		return errroInfo;
	}

	public void setErrroInfo(String errroInfo) {
		this.errroInfo = errroInfo;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

}
