package com.hoau.how.module.obh.shared.vos;

import java.io.Serializable;
import java.util.Date;

public class EiNetOrderReqModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//网上营业厅订单主键
	private Integer einoId;
	//系统订单号
	private String einoOrderNo;
	//客户合同号
	private String einoContractNo;
	//客户联系人表主键
	private Integer einoEbccId;
	//下单人名称
	private String einoEbccName;
	//下单时间
	private Date einoOrderDate;
	//订单状态
	private String einoStatus;
	//发货公司
	private String einoShipperEbspNameCn;
	//发货人联系人
	private String einoShipperEbsaContact;
	//发货人联系电话
	private String einoShipperEbsaTel;
	//发货地址
	private String einoShipperEbsaAddress;
	//发货城市ID、发货市ID
	private Integer einoShipperEbplId;
	//发货城市、发货市
	private String einoShipperEbplNameCn;
	//收货公司
	private String einoConsigneeEbspNameCn;
	//收货人联系人
	private String einoConsigneeEbsaContact;
	//收货人联系电话
	private String einoConsigneeEbsaTel;
	//收货人地址
	private String einoConsigneeEbsaAddress;
	//收货市ID
	private Integer einoConsigneeEbplId;
	//收货市
	private String einoConsigneeEbplNameCn;
	//备注
	private String einoRemark;
	//创建人
	private String creator;
	//创建时间
	private Date createTime;
	//修改人
	private String modifier;
	//修改时间
	private Date modifyTime;
	//时间戳
	private Integer recVer;
	//运单号
	private String einoTransNo;
	//产品类型名称
	private String einoProductTypeName;
	//二级公司ID
	private String einoEscoSecondCode;
	//二级公司名称
	private String einoEscoSecondName;
	//发货省ID
	private Integer einoShipperEbpvId;
	//发货省
	private String einoShipperEbpvName;
	//发货手机
	private String einoShipperEbsaMobile;
	//收货省ID
	private Integer einoConsigneeEbpvId;
	//收货省
	private String einoConsigneeEbpvName;
	//收货手机
	private String einoConsigneeEbsaMobile;
	//异常类型
	private String einoExceptionType;
	//发货人区号
	private String einoShipperEbsaAreaCode;
	//收货人区号
	private String einoConsigneeEbsaAreaCode;
	//上门揽货
	private String einoDoorCanvass;
	//付款方式
	private String einoPaymentMethod;
	//送货方式
	private String einoShipperMethod;
	//签收回单
	private String einoSignBack;
	//包装
	private String einoPackage;
	//代收货款金额
	private Double einoCollDeliveryAmount;
	//短信通知
	private String einoSmsNotif;
	//保价
	private Double einoInsurance;
	//费用合计
	private Double einoChargeTotal;
	//货物名称
	private String einoCargoName;
	//货物重量
	private Double einoTotalWeight;
	//货物体积
	private Double einoTotalVolume;
	//货物件数
	private Integer einoNumber;
	//是否导入OMS
	private Integer einoIsImport;
	//订单来源
	private String einoOrign;
	//受邀人状态
	private Integer einoInvitedStatus;
	//收货区县
	private String einoConsigneeEbrgNameCn;
	//提货区县
	private String einoShipperAreaName;
	//重量单价
	private Double einoHeavyPrice;
	//体积单价
	private Double einoLightPrice;
	//要求提货时间 从
	private Date einoReqDeliveryDate;
	//要求收货时间 到
	private Date einoReqDeliveryDateE;
	//标签einoTagetNos
	private String einoTagetNos;
	//到货网点
	private String einoConsigneeBranchesName;
    //大客户代码
    private String einoCustomerCode;
    //付款账号
    private String einoPayerAccount;
    
    //增加一个批量下单标识 张兰红2015-07-1
 	private Integer einoBatchOrder;
 	
 	public Integer getEinoBatchOrder() {
 		return einoBatchOrder;
 	}

 	public void setEinoBatchOrder(Integer einoBatchOrder) {
 		this.einoBatchOrder = einoBatchOrder;
 	}
    
    
    //大客户付款方式 0、 1、  2
    private Integer einoPayerObject;
	public Integer getEinoPayerObject() {
		return einoPayerObject;
	}
	public void setEinoPayerObject(Integer einoPayerObject) {
		this.einoPayerObject = einoPayerObject;
	}
	public Integer getEinoId() {
		return einoId;
	}
	public void setEinoId(Integer einoId) {
		this.einoId = einoId;
	}
	public String getEinoOrderNo() {
		return einoOrderNo;
	}
	public void setEinoOrderNo(String einoOrderNo) {
		this.einoOrderNo = einoOrderNo;
	}
	public String getEinoContractNo() {
		return einoContractNo;
	}
	public void setEinoContractNo(String einoContractNo) {
		this.einoContractNo = einoContractNo;
	}
	public Integer getEinoEbccId() {
		return einoEbccId;
	}
	public void setEinoEbccId(Integer einoEbccId) {
		this.einoEbccId = einoEbccId;
	}
	public String getEinoEbccName() {
		return einoEbccName;
	}
	public void setEinoEbccName(String einoEbccName) {
		this.einoEbccName = einoEbccName;
	}
	public Date getEinoOrderDate() {
		return einoOrderDate;
	}
	public void setEinoOrderDate(Date einoOrderDate) {
		this.einoOrderDate = einoOrderDate;
	}
	public String getEinoStatus() {
		return einoStatus;
	}
	public void setEinoStatus(String einoStatus) {
		this.einoStatus = einoStatus;
	}
	public String getEinoShipperEbspNameCn() {
		return einoShipperEbspNameCn;
	}
	public void setEinoShipperEbspNameCn(String einoShipperEbspNameCn) {
		this.einoShipperEbspNameCn = einoShipperEbspNameCn;
	}
	public String getEinoShipperEbsaContact() {
		return einoShipperEbsaContact;
	}
	public void setEinoShipperEbsaContact(String einoShipperEbsaContact) {
		this.einoShipperEbsaContact = einoShipperEbsaContact;
	}
	public String getEinoShipperEbsaTel() {
		return einoShipperEbsaTel;
	}
	public void setEinoShipperEbsaTel(String einoShipperEbsaTel) {
		this.einoShipperEbsaTel = einoShipperEbsaTel;
	}
	public String getEinoShipperEbsaAddress() {
		return einoShipperEbsaAddress;
	}
	public void setEinoShipperEbsaAddress(String einoShipperEbsaAddress) {
		this.einoShipperEbsaAddress = einoShipperEbsaAddress;
	}
	public Integer getEinoShipperEbplId() {
		return einoShipperEbplId;
	}
	public void setEinoShipperEbplId(Integer einoShipperEbplId) {
		this.einoShipperEbplId = einoShipperEbplId;
	}
	public String getEinoShipperEbplNameCn() {
		return einoShipperEbplNameCn;
	}
	public void setEinoShipperEbplNameCn(String einoShipperEbplNameCn) {
		this.einoShipperEbplNameCn = einoShipperEbplNameCn;
	}
	public String getEinoConsigneeEbspNameCn() {
		return einoConsigneeEbspNameCn;
	}
	public void setEinoConsigneeEbspNameCn(String einoConsigneeEbspNameCn) {
		this.einoConsigneeEbspNameCn = einoConsigneeEbspNameCn;
	}
	public String getEinoConsigneeEbsaContact() {
		return einoConsigneeEbsaContact;
	}
	public void setEinoConsigneeEbsaContact(String einoConsigneeEbsaContact) {
		this.einoConsigneeEbsaContact = einoConsigneeEbsaContact;
	}
	public String getEinoConsigneeEbsaTel() {
		return einoConsigneeEbsaTel;
	}
	public void setEinoConsigneeEbsaTel(String einoConsigneeEbsaTel) {
		this.einoConsigneeEbsaTel = einoConsigneeEbsaTel;
	}
	public String getEinoConsigneeEbsaAddress() {
		return einoConsigneeEbsaAddress;
	}
	public void setEinoConsigneeEbsaAddress(String einoConsigneeEbsaAddress) {
		this.einoConsigneeEbsaAddress = einoConsigneeEbsaAddress;
	}
	public Integer getEinoConsigneeEbplId() {
		return einoConsigneeEbplId;
	}
	public void setEinoConsigneeEbplId(Integer einoConsigneeEbplId) {
		this.einoConsigneeEbplId = einoConsigneeEbplId;
	}
	public String getEinoConsigneeEbplNameCn() {
		return einoConsigneeEbplNameCn;
	}
	public void setEinoConsigneeEbplNameCn(String einoConsigneeEbplNameCn) {
		this.einoConsigneeEbplNameCn = einoConsigneeEbplNameCn;
	}
	public String getEinoRemark() {
		return einoRemark;
	}
	public void setEinoRemark(String einoRemark) {
		this.einoRemark = einoRemark;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getRecVer() {
		return recVer;
	}
	public void setRecVer(Integer recVer) {
		this.recVer = recVer;
	}
	public String getEinoTransNo() {
		return einoTransNo;
	}
	public void setEinoTransNo(String einoTransNo) {
		this.einoTransNo = einoTransNo;
	}
	public String getEinoProductTypeName() {
		return einoProductTypeName;
	}
	public void setEinoProductTypeName(String einoProductTypeName) {
		this.einoProductTypeName = einoProductTypeName;
	}
	public String getEinoEscoSecondCode() {
		return einoEscoSecondCode;
	}
	public void setEinoEscoSecondCode(String einoEscoSecondCode) {
		this.einoEscoSecondCode = einoEscoSecondCode;
	}
	public String getEinoEscoSecondName() {
		return einoEscoSecondName;
	}
	public void setEinoEscoSecondName(String einoEscoSecondName) {
		this.einoEscoSecondName = einoEscoSecondName;
	}
	public Integer getEinoShipperEbpvId() {
		return einoShipperEbpvId;
	}
	public void setEinoShipperEbpvId(Integer einoShipperEbpvId) {
		this.einoShipperEbpvId = einoShipperEbpvId;
	}
	public String getEinoShipperEbpvName() {
		return einoShipperEbpvName;
	}
	public void setEinoShipperEbpvName(String einoShipperEbpvName) {
		this.einoShipperEbpvName = einoShipperEbpvName;
	}
	public String getEinoShipperEbsaMobile() {
		return einoShipperEbsaMobile;
	}
	public void setEinoShipperEbsaMobile(String einoShipperEbsaMobile) {
		this.einoShipperEbsaMobile = einoShipperEbsaMobile;
	}
	public Integer getEinoConsigneeEbpvId() {
		return einoConsigneeEbpvId;
	}
	public void setEinoConsigneeEbpvId(Integer einoConsigneeEbpvId) {
		this.einoConsigneeEbpvId = einoConsigneeEbpvId;
	}
	public String getEinoConsigneeEbpvName() {
		return einoConsigneeEbpvName;
	}
	public void setEinoConsigneeEbpvName(String einoConsigneeEbpvName) {
		this.einoConsigneeEbpvName = einoConsigneeEbpvName;
	}
	public String getEinoConsigneeEbsaMobile() {
		return einoConsigneeEbsaMobile;
	}
	public void setEinoConsigneeEbsaMobile(String einoConsigneeEbsaMobile) {
		this.einoConsigneeEbsaMobile = einoConsigneeEbsaMobile;
	}
	public String getEinoExceptionType() {
		return einoExceptionType;
	}
	public void setEinoExceptionType(String einoExceptionType) {
		this.einoExceptionType = einoExceptionType;
	}
	public String getEinoShipperEbsaAreaCode() {
		return einoShipperEbsaAreaCode;
	}
	public void setEinoShipperEbsaAreaCode(String einoShipperEbsaAreaCode) {
		this.einoShipperEbsaAreaCode = einoShipperEbsaAreaCode;
	}
	public String getEinoConsigneeEbsaAreaCode() {
		return einoConsigneeEbsaAreaCode;
	}
	public void setEinoConsigneeEbsaAreaCode(String einoConsigneeEbsaAreaCode) {
		this.einoConsigneeEbsaAreaCode = einoConsigneeEbsaAreaCode;
	}
	public String getEinoDoorCanvass() {
		return einoDoorCanvass;
	}
	public void setEinoDoorCanvass(String einoDoorCanvass) {
		this.einoDoorCanvass = einoDoorCanvass;
	}
	public String getEinoPaymentMethod() {
		return einoPaymentMethod;
	}
	public void setEinoPaymentMethod(String einoPaymentMethod) {
		this.einoPaymentMethod = einoPaymentMethod;
	}
	public String getEinoShipperMethod() {
		return einoShipperMethod;
	}
	public void setEinoShipperMethod(String einoShipperMethod) {
		this.einoShipperMethod = einoShipperMethod;
	}
	public String getEinoSignBack() {
		return einoSignBack;
	}
	public void setEinoSignBack(String einoSignBack) {
		this.einoSignBack = einoSignBack;
	}
	public String getEinoPackage() {
		return einoPackage;
	}
	public void setEinoPackage(String einoPackage) {
		this.einoPackage = einoPackage;
	}
	public Double getEinoCollDeliveryAmount() {
		return einoCollDeliveryAmount;
	}
	public void setEinoCollDeliveryAmount(Double einoCollDeliveryAmount) {
		this.einoCollDeliveryAmount = einoCollDeliveryAmount;
	}
	public String getEinoSmsNotif() {
		return einoSmsNotif;
	}
	public void setEinoSmsNotif(String einoSmsNotif) {
		this.einoSmsNotif = einoSmsNotif;
	}
	public Double getEinoInsurance() {
		return einoInsurance;
	}
	public void setEinoInsurance(Double einoInsurance) {
		this.einoInsurance = einoInsurance;
	}
	public Double getEinoChargeTotal() {
		return einoChargeTotal;
	}
	public void setEinoChargeTotal(Double einoChargeTotal) {
		this.einoChargeTotal = einoChargeTotal;
	}
	public String getEinoCargoName() {
		return einoCargoName;
	}
	public void setEinoCargoName(String einoCargoName) {
		this.einoCargoName = einoCargoName;
	}
	public Double getEinoTotalWeight() {
		return einoTotalWeight;
	}
	public void setEinoTotalWeight(Double einoTotalWeight) {
		this.einoTotalWeight = einoTotalWeight;
	}
	public Double getEinoTotalVolume() {
		return einoTotalVolume;
	}
	public void setEinoTotalVolume(Double einoTotalVolume) {
		this.einoTotalVolume = einoTotalVolume;
	}
	public Integer getEinoNumber() {
		return einoNumber;
	}
	public void setEinoNumber(Integer einoNumber) {
		this.einoNumber = einoNumber;
	}
	public Integer getEinoIsImport() {
		return einoIsImport;
	}
	public void setEinoIsImport(Integer einoIsImport) {
		this.einoIsImport = einoIsImport;
	}
	public String getEinoOrign() {
		return einoOrign;
	}
	public void setEinoOrign(String einoOrign) {
		this.einoOrign = einoOrign;
	}
	public Integer getEinoInvitedStatus() {
		return einoInvitedStatus;
	}
	public void setEinoInvitedStatus(Integer einoInvitedStatus) {
		this.einoInvitedStatus = einoInvitedStatus;
	}
	public String getEinoConsigneeEbrgNameCn() {
		return einoConsigneeEbrgNameCn;
	}
	public void setEinoConsigneeEbrgNameCn(String einoConsigneeEbrgNameCn) {
		this.einoConsigneeEbrgNameCn = einoConsigneeEbrgNameCn;
	}
	public String getEinoShipperAreaName() {
		return einoShipperAreaName;
	}
	public void setEinoShipperAreaName(String einoShipperAreaName) {
		this.einoShipperAreaName = einoShipperAreaName;
	}
	public Double getEinoHeavyPrice() {
		return einoHeavyPrice;
	}
	public void setEinoHeavyPrice(Double einoHeavyPrice) {
		this.einoHeavyPrice = einoHeavyPrice;
	}
	public Double getEinoLightPrice() {
		return einoLightPrice;
	}
	public void setEinoLightPrice(Double einoLightPrice) {
		this.einoLightPrice = einoLightPrice;
	}
	public Date getEinoReqDeliveryDate() {
		return einoReqDeliveryDate;
	}
	public void setEinoReqDeliveryDate(Date einoReqDeliveryDate) {
		this.einoReqDeliveryDate = einoReqDeliveryDate;
	}
	public Date getEinoReqDeliveryDateE() {
		return einoReqDeliveryDateE;
	}
	public void setEinoReqDeliveryDateE(Date einoReqDeliveryDateE) {
		this.einoReqDeliveryDateE = einoReqDeliveryDateE;
	}
	public String getEinoTagetNos() {
		return einoTagetNos;
	}
	public void setEinoTagetNos(String einoTagetNos) {
		this.einoTagetNos = einoTagetNos;
	}
	public String getEinoConsigneeBranchesName() {
		return einoConsigneeBranchesName;
	}
	public void setEinoConsigneeBranchesName(String einoConsigneeBranchesName) {
		this.einoConsigneeBranchesName = einoConsigneeBranchesName;
	}
	public String getEinoCustomerCode() {
		return einoCustomerCode;
	}
	public void setEinoCustomerCode(String einoCustomerCode) {
		this.einoCustomerCode = einoCustomerCode;
	}
	public String getEinoPayerAccount() {
		return einoPayerAccount;
	}
	public void setEinoPayerAccount(String einoPayerAccount) {
		this.einoPayerAccount = einoPayerAccount;
	}
}
