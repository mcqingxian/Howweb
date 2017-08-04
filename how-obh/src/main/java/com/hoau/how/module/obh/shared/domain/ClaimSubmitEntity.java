package com.hoau.how.module.obh.shared.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hoau.how.module.itf.server.ws.claim.ClaimsTrack;

/**
 * @author：张贞献
 * @create：2015年8月19日 上午9:19:46
 * @description：
 */
public class ClaimSubmitEntity implements Serializable{

	    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	    /**
	     * id
	     */
	    private String id;
	    
	    /**
	     * 客户id
	     */
	    private Long ebccId;
	    
	    /**
	     * 查询理赔系统中的用户ID，这里使用的是ebcuId，与网厅中的理赔数据不一致，切记
	     * King 2016年1月4日16:12:47
	     */
	    private Long ebcuId;
	    
		/**
		 * 理赔运单编号
		 */
	    private String billNo;
		
	    /**
		 * 理赔编号
		 */
	    private String claimNo;
	    
		/**
		 * 理赔方
		 */
		private String claimParty;
		
	    /**
	     * 运单上联系电话
	     */
	    private String billTel;
		
		/**
		 * 理赔公司所在地
		 */
		private String claimCompanyAddr;
		
		/**
		 * 是否委托办理
		 */
		private String isEntrust;
	   
	    /**
	     * 索赔人姓名或公司名称
	     */
	    private String contactName;
	    
	    /**
	     * 索赔人手机号
	     */
	    private String contactTel;
	    
	    /**
	     * 索赔人邮箱
	     */
	    private String contactMail;
	    
	    /**
	     * 理赔金额
	     */
	    private BigDecimal claimsAmount;

	    /**
	     * 货物类型
	     */
	    private String cargoType;
	    
	    /**
	     * 异常件数
	     */
	    private Long exceptionCount;
	    
	    /**
	     * 出险类型
	     */
	    private String accidentType;

	    /**
	     *理赔原因及其他
	     */
	    private String reason;
        
        /**
         * 提交的所有图片
         */
        private String imgMapString;
        
        /**
         * 草稿 UN_SUBMIT,已提交  SUBMIT
         */
        private String status;
        
        /**
         *  创建时间
         */
        private Date createTime;
        
        /**
         * 修改时间
         */
        private Date modifyTime;

        private List<String> zipDir;
        
        /**
         * 操作明细
         */
        private List<ClaimsTrack> claimsTrackList;
        
        private boolean showmodifyBtn;
        
        /** 
         * 客户拒绝理赔金额状态（0 未拒绝，1 已拒绝）
         * @author 田育林 2016-05-04
         */
    	private int refuseStatus;
    	
    	/**用户银行卡开户信息，田育林，2016-06-03**/
    	private String accountName; //开户名
    	private String accountCode; //银行卡号
    	private String accountCity; //开户行所在省市区
    	private String accountBank; //开户行名称
    	/**end**/
      
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

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

		public String getClaimCompanyAddr() {
			return claimCompanyAddr;
		}

		public void setClaimCompanyAddr(String claimCompanyAddr) {
			this.claimCompanyAddr = claimCompanyAddr;
		}

		public String getIsEntrust() {
			return isEntrust;
		}

		public void setIsEntrust(String isEntrust) {
			this.isEntrust = isEntrust;
		}

		public String getContactName() {
			return contactName;
		}

		public void setContactName(String contactName) {
			this.contactName = contactName;
		}

		public String getContactTel() {
			return contactTel;
		}

		public void setContactTel(String contactTel) {
			this.contactTel = contactTel;
		}

		public String getContactMail() {
			return contactMail;
		}

		public void setContactMail(String contactMail) {
			this.contactMail = contactMail;
		}

		public BigDecimal getClaimsAmount() {
			return claimsAmount;
		}

		public void setClaimsAmount(BigDecimal claimsAmount) {
			this.claimsAmount = claimsAmount;
		}

		public String getCargoType() {
			return cargoType;
		}

		public void setCargoType(String cargoType) {
			this.cargoType = cargoType;
		}

		public Long getExceptionCount() {
			return exceptionCount;
		}

		public void setExceptionCount(Long exceptionCount) {
			this.exceptionCount = exceptionCount;
		}

		public String getAccidentType() {
			return accidentType;
		}

		public void setAccidentType(String accidentType) {
			this.accidentType = accidentType;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}
		
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getImgMapString() {
			return imgMapString;
		}

		public void setImgMapString(String imgMapString) {
			this.imgMapString = imgMapString;
		}

		public Long getEbccId() {
			return ebccId;
		}

		public void setEbccId(Long ebccId) {
			this.ebccId = ebccId;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Date getModifyTime() {
			return modifyTime;
		}

		public void setModifyTime(Date modifyTime) {
			this.modifyTime = modifyTime;
		}

		public String getClaimNo() {
			return claimNo;
		}

		public void setClaimNo(String claimNo) {
			this.claimNo = claimNo;
		}

		public List<String> getZipDir() {
			return zipDir;
		}

		public void setZipDir(List<String> zipDir) {
			this.zipDir = zipDir;
		}

		public List<ClaimsTrack> getClaimsTrackList() {
			return claimsTrackList;
		}

		public void setClaimsTrackList(List<ClaimsTrack> claimsTrackList) {
			this.claimsTrackList = claimsTrackList;
		}

		public boolean isShowmodifyBtn() {
			return showmodifyBtn;
		}

		public void setShowmodifyBtn(boolean showmodifyBtn) {
			this.showmodifyBtn = showmodifyBtn;
		}

		public Long getEbcuId() {
			return ebcuId;
		}

		public void setEbcuId(Long ebcuId) {
			this.ebcuId = ebcuId;
		}

		public int getRefuseStatus() {
			return refuseStatus;
		}

		public void setRefuseStatus(int refuseStatus) {
			this.refuseStatus = refuseStatus;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public String getAccountCode() {
			return accountCode;
		}

		public void setAccountCode(String accountCode) {
			this.accountCode = accountCode;
		}

		public String getAccountCity() {
			return accountCity;
		}

		public void setAccountCity(String accountCity) {
			this.accountCity = accountCity;
		}

		public String getAccountBank() {
			return accountBank;
		}

		public void setAccountBank(String accountBank) {
			this.accountBank = accountBank;
		}
}
