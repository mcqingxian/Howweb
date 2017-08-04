package com.hoau.how.module.obh.shared.vos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * 任务列表实体
 *
 * @author 莫涛
 * @date 2016年4月18日下午5:10:03
 */
public class TaskListEntity extends BaseEntity{

	/**
	 * 序列化ID
	 */
    private static final long serialVersionUID = -3967231350438160812L;
    
    String id;
    //订单号
    String orderNo;
    //订单来源
    String orgin;
    //服务类型
    String serviceType;
    //是否到货
    String arrival;
	/** 预计到达时间 */
	private String planDate;
    //到达门店时间
    Date arrivalTime;
    //到达门店
    String arrivalCompany;
    //下派时间
    Date sendTime;
    //下派供应商ID
    String sendMasterId;
    //下派供应商
    String sendMasterName;
    //订单状态
    String orderStatus;
    //是否需要核销
    String verification;
    //预约安装时间
    Date appointInstallTime;
    //安装师傅ID
    String installMasterId;
    //安装师傅名称
    String installMasterName;
    //安装师傅电话
    String installMasterPhone;
    //货物名称
    String goodsName;
    //运单编号
    String transNo;
    //门店电话
    String companyPhone;
    //门店地址
    String companyAddress;
    //件数
    BigDecimal number;
    //体积
    BigDecimal volume;
    //重量
    BigDecimal weight;
    //是否送货上楼
    String upstairs;
    //收货人姓名
    String consigneeName;
    //收货人手机
    String consigneeMobile;
    //收货人详细地址
    String consigneeAddress;
    //是否需要预约
    String whetherAppointInstall;
    //安装件数
    BigDecimal installNumber;
    //OMS订单号
    String omsOrderNo;
    //天猫订单号
    String tmallOrderNo;
    //推送环节，1：上转移审核，2：下转移审核，3：直装一体发货
    String step;
    //提货时间
    Date pickupTime;
    //安装明细字符串
    String installDetailStr;
    //安装明细集合
    List<InstallDetailEntity> installDetailList;
    /**
     * 签收类型
     * 正常：1，异常：2，拒签：3
     */
    private String signType;
    /**
     * 签收时间
     */
    private Date signTime;
    //创建时间至
    private Date createDate2;
	public List<InstallDetailEntity> getInstallDetailList() {
		return installDetailList;
	}

	public void setInstallDetailList(List<InstallDetailEntity> installDetailList) {
		this.installDetailList = installDetailList;
	}

	public Date getCreateDate2() {
		return createDate2;
	}

	public void setCreateDate2(Date createDate2) {
		this.createDate2 = createDate2;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrgin() {
		return orgin;
	}
	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getArrivalCompany() {
		return arrivalCompany;
	}
	public void setArrivalCompany(String arrivalCompany) {
		this.arrivalCompany = arrivalCompany;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getSendMasterId() {
		return sendMasterId;
	}
	public void setSendMasterId(String sendMasterId) {
		this.sendMasterId = sendMasterId;
	}
	public String getSendMasterName() {
		return sendMasterName;
	}
	public void setSendMasterName(String sendMasterName) {
		this.sendMasterName = sendMasterName;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getVerification() {
		return verification;
	}
	public void setVerification(String verification) {
		this.verification = verification;
	}
	public Date getAppointInstallTime() {
		return appointInstallTime;
	}
	public void setAppointInstallTime(Date appointInstallTime) {
		this.appointInstallTime = appointInstallTime;
	}
	public String getInstallMasterId() {
		return installMasterId;
	}
	public void setInstallMasterId(String installMasterId) {
		this.installMasterId = installMasterId;
	}
	public String getInstallMasterName() {
		return installMasterName;
	}
	public void setInstallMasterName(String installMasterName) {
		this.installMasterName = installMasterName;
	}
	public String getInstallMasterPhone() {
		return installMasterPhone;
	}
	public void setInstallMasterPhone(String installMasterPhone) {
		this.installMasterPhone = installMasterPhone;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getTransNo() {
		return transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public String getUpstairs() {
		return upstairs;
	}
	public void setUpstairs(String upstairs) {
		this.upstairs = upstairs;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeMobile() {
		return consigneeMobile;
	}
	public void setConsigneeMobile(String consigneeMobile) {
		this.consigneeMobile = consigneeMobile;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getWhetherAppointInstall() {
		return whetherAppointInstall;
	}
	public void setWhetherAppointInstall(String whetherAppointInstall) {
		this.whetherAppointInstall = whetherAppointInstall;
	}
	public BigDecimal getInstallNumber() {
		return installNumber;
	}
	public void setInstallNumber(BigDecimal installNumber) {
		this.installNumber = installNumber;
	}
	public String getOmsOrderNo() {
		return omsOrderNo;
	}
	public void setOmsOrderNo(String omsOrderNo) {
		this.omsOrderNo = omsOrderNo;
	}
	public String getTmallOrderNo() {
		return tmallOrderNo;
	}
	public void setTmallOrderNo(String tmallOrderNo) {
		this.tmallOrderNo = tmallOrderNo;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	public String getInstallDetailStr() {
		return installDetailStr;
	}
	public void setInstallDetailStr(String installDetailStr) {
		this.installDetailStr = installDetailStr;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	
}