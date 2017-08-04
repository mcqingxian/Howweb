
package com.hoau.wechat.ws.oms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hoau.wechat.ws.oms package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterUserResModelResult_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "result");
    private final static QName _RegisterUserResModelUserId_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "userId");
    private final static QName _RegisterUserResModelResultCode_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "resultCode");
    private final static QName _RegisterUserResModelResultInfo_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "resultInfo");
    private final static QName _CancelOrderResModelOrderNo_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "orderNo");
    private final static QName _ResetPwdReqModelEmail_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "email");
    private final static QName _ResetPwdReqModelMobile_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "mobile");
    private final static QName _ResetPwdReqModelPassword_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "password");
    private final static QName _QueryOrderModelConsigneeAddress_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeAddress");
    private final static QName _QueryOrderModelConsigneeName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeName");
    private final static QName _QueryOrderModelStatus_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "status");
    private final static QName _QueryOrderModelTransNo_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "transNo");
    private final static QName _PhoneOrderResModelPhoneOrderReqModel_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "phoneOrderReqModel");
    private final static QName _PhoneOrderResModelUserid_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "userid");
    private final static QName _PhoneOrderReqModelShipperTel_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperTel");
    private final static QName _PhoneOrderReqModelShipperEbrgNameCn_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperEbrgNameCn");
    private final static QName _PhoneOrderReqModelConsigneeProv_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeProv");
    private final static QName _PhoneOrderReqModelShipperAddress_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperAddress");
    private final static QName _PhoneOrderReqModelEscoSecondName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "escoSecondName");
    private final static QName _PhoneOrderReqModelSmsNotify_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "smsNotify");
    private final static QName _PhoneOrderReqModelConsigneeAreaCode_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeAreaCode");
    private final static QName _PhoneOrderReqModelOrderVer_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "orderVer");
    private final static QName _PhoneOrderReqModelCargoVolume_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "cargoVolume");
    private final static QName _PhoneOrderReqModelConsigneeMobile_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeMobile");
    private final static QName _PhoneOrderReqModelCollDeliveryAmount_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "collDeliveryAmount");
    private final static QName _PhoneOrderReqModelConsigneeCompanyName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeCompanyName");
    private final static QName _PhoneOrderReqModelShipperCompanyName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperCompanyName");
    private final static QName _PhoneOrderReqModelShipperMobile_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperMobile");
    private final static QName _PhoneOrderReqModelShipperName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperName");
    private final static QName _PhoneOrderReqModelShipperCity_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperCity");
    private final static QName _PhoneOrderReqModelCargoNumber_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "cargoNumber");
    private final static QName _PhoneOrderReqModelOrderId_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "orderId");
    private final static QName _PhoneOrderReqModelConsigneeMethod_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeMethod");
    private final static QName _PhoneOrderReqModelCargoWeight_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "cargoWeight");
    private final static QName _PhoneOrderReqModelEscoSecondCode_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "escoSecondCode");
    private final static QName _PhoneOrderReqModelOrderOrign_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "orderOrign");
    private final static QName _PhoneOrderReqModelShipperProv_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperProv");
    private final static QName _PhoneOrderReqModelRemark_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "remark");
    private final static QName _PhoneOrderReqModelConsigneeEbrgNameCn_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeEbrgNameCn");
    private final static QName _PhoneOrderReqModelConsigneeTel_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeTel");
    private final static QName _PhoneOrderReqModelShipperAreaCode_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperAreaCode");
    private final static QName _PhoneOrderReqModelShipperMethod_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "shipperMethod");
    private final static QName _PhoneOrderReqModelProductType_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "productType");
    private final static QName _PhoneOrderReqModelConsigneeCity_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "consigneeCity");
    private final static QName _PhoneOrderReqModelCargoName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "cargoName");
    private final static QName _RegisterUserReqModelName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "name");
    private final static QName _ModifyOrderReqModelModifyOrder_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "modifyOrder");
    private final static QName _UpdateCacheResModelSupportingDataModel_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "supportingDataModel");
    private final static QName _UpdateCacheResModelErrMsg_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "errMsg");
    private final static QName _UpdateCacheResModelSuccess_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "success");
    private final static QName _QueryOrdersReqModelRecordStart_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "recordStart");
    private final static QName _QueryOrdersReqModelRecordEnd_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "recordEnd");
    private final static QName _QueryOrdersReqModelCustomerID_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "customerID");
    private final static QName _QueryOrdersResModelQueryOrderModel_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "queryOrderModel");
    private final static QName _LoginUserReqModelLoginName_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "loginName");
    private final static QName _SupportingDataModelLevel_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "level");
    private final static QName _SupportingDataModelCode_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "code");
    private final static QName _SupportingDataModelValue_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "value");
    private final static QName _SupportingDataModelType_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "type");
    private final static QName _SupportingDataModelParentCode_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "parentCode");
    private final static QName _GetPhoneOrderResModelQueryOrder_QNAME = new QName("http://model.mobile.interfaces.sinotrans.com", "queryOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hoau.wechat.ws.oms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateCacheReqModel }
     * 
     */
    public UpdateCacheReqModel createUpdateCacheReqModel() {
        return new UpdateCacheReqModel();
    }

    /**
     * Create an instance of {@link PhoneOrderReqModel }
     * 
     */
    public PhoneOrderReqModel createPhoneOrderReqModel() {
        return new PhoneOrderReqModel();
    }

    /**
     * Create an instance of {@link RegisterUserResModel }
     * 
     */
    public RegisterUserResModel createRegisterUserResModel() {
        return new RegisterUserResModel();
    }

    /**
     * Create an instance of {@link ModifyOrderReqModel }
     * 
     */
    public ModifyOrderReqModel createModifyOrderReqModel() {
        return new ModifyOrderReqModel();
    }

    /**
     * Create an instance of {@link CancelOrderReqModel }
     * 
     */
    public CancelOrderReqModel createCancelOrderReqModel() {
        return new CancelOrderReqModel();
    }

    /**
     * Create an instance of {@link ArrayOfSupportingDataModel }
     * 
     */
    public ArrayOfSupportingDataModel createArrayOfSupportingDataModel() {
        return new ArrayOfSupportingDataModel();
    }

    /**
     * Create an instance of {@link CancelOrderResModel }
     * 
     */
    public CancelOrderResModel createCancelOrderResModel() {
        return new CancelOrderResModel();
    }

    /**
     * Create an instance of {@link RegisterUserReqModel }
     * 
     */
    public RegisterUserReqModel createRegisterUserReqModel() {
        return new RegisterUserReqModel();
    }

    /**
     * Create an instance of {@link ModifyOrderResModel }
     * 
     */
    public ModifyOrderResModel createModifyOrderResModel() {
        return new ModifyOrderResModel();
    }

    /**
     * Create an instance of {@link LoginUserResModel }
     * 
     */
    public LoginUserResModel createLoginUserResModel() {
        return new LoginUserResModel();
    }

    /**
     * Create an instance of {@link LoginUserReqModel }
     * 
     */
    public LoginUserReqModel createLoginUserReqModel() {
        return new LoginUserReqModel();
    }

    /**
     * Create an instance of {@link PhoneOrderResModel }
     * 
     */
    public PhoneOrderResModel createPhoneOrderResModel() {
        return new PhoneOrderResModel();
    }

    /**
     * Create an instance of {@link GetPhoneOrderResModel }
     * 
     */
    public GetPhoneOrderResModel createGetPhoneOrderResModel() {
        return new GetPhoneOrderResModel();
    }

    /**
     * Create an instance of {@link ResetPwdReqModel }
     * 
     */
    public ResetPwdReqModel createResetPwdReqModel() {
        return new ResetPwdReqModel();
    }

    /**
     * Create an instance of {@link QueryOrderModel }
     * 
     */
    public QueryOrderModel createQueryOrderModel() {
        return new QueryOrderModel();
    }

    /**
     * Create an instance of {@link SupportingDataModel }
     * 
     */
    public SupportingDataModel createSupportingDataModel() {
        return new SupportingDataModel();
    }

    /**
     * Create an instance of {@link ResetPwdResModel }
     * 
     */
    public ResetPwdResModel createResetPwdResModel() {
        return new ResetPwdResModel();
    }

    /**
     * Create an instance of {@link UpdateCacheResModel }
     * 
     */
    public UpdateCacheResModel createUpdateCacheResModel() {
        return new UpdateCacheResModel();
    }

    /**
     * Create an instance of {@link ArrayOfQueryOrderModel }
     * 
     */
    public ArrayOfQueryOrderModel createArrayOfQueryOrderModel() {
        return new ArrayOfQueryOrderModel();
    }

    /**
     * Create an instance of {@link GetPhoneOrderReqModel }
     * 
     */
    public GetPhoneOrderReqModel createGetPhoneOrderReqModel() {
        return new GetPhoneOrderReqModel();
    }

    /**
     * Create an instance of {@link QueryOrdersReqModel }
     * 
     */
    public QueryOrdersReqModel createQueryOrdersReqModel() {
        return new QueryOrdersReqModel();
    }

    /**
     * Create an instance of {@link QueryOrdersResModel }
     * 
     */
    public QueryOrdersResModel createQueryOrdersResModel() {
        return new QueryOrdersResModel();
    }

    /**
     * Create an instance of {@link CancelPhoneOrdeResponse }
     * 
     */
    public CancelPhoneOrdeResponse createCancelPhoneOrdeResponse() {
        return new CancelPhoneOrdeResponse();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link CancelPhoneOrde }
     * 
     */
    public CancelPhoneOrde createCancelPhoneOrde() {
        return new CancelPhoneOrde();
    }

    /**
     * Create an instance of {@link QueryOrderDetail }
     * 
     */
    public QueryOrderDetail createQueryOrderDetail() {
        return new QueryOrderDetail();
    }

    /**
     * Create an instance of {@link LoginByPhoneResponse }
     * 
     */
    public LoginByPhoneResponse createLoginByPhoneResponse() {
        return new LoginByPhoneResponse();
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link ResetPwd }
     * 
     */
    public ResetPwd createResetPwd() {
        return new ResetPwd();
    }

    /**
     * Create an instance of {@link ResetPwdResponse }
     * 
     */
    public ResetPwdResponse createResetPwdResponse() {
        return new ResetPwdResponse();
    }

    /**
     * Create an instance of {@link QueryOrder }
     * 
     */
    public QueryOrder createQueryOrder() {
        return new QueryOrder();
    }

    /**
     * Create an instance of {@link UpdateCache }
     * 
     */
    public UpdateCache createUpdateCache() {
        return new UpdateCache();
    }

    /**
     * Create an instance of {@link QueryOrderResponse }
     * 
     */
    public QueryOrderResponse createQueryOrderResponse() {
        return new QueryOrderResponse();
    }

    /**
     * Create an instance of {@link LoginByPhone }
     * 
     */
    public LoginByPhone createLoginByPhone() {
        return new LoginByPhone();
    }

    /**
     * Create an instance of {@link QueryOrderDetailResponse }
     * 
     */
    public QueryOrderDetailResponse createQueryOrderDetailResponse() {
        return new QueryOrderDetailResponse();
    }

    /**
     * Create an instance of {@link ModifyOrderResponse }
     * 
     */
    public ModifyOrderResponse createModifyOrderResponse() {
        return new ModifyOrderResponse();
    }

    /**
     * Create an instance of {@link ModifyOrder }
     * 
     */
    public ModifyOrder createModifyOrder() {
        return new ModifyOrder();
    }

    /**
     * Create an instance of {@link UpdateCacheResponse }
     * 
     */
    public UpdateCacheResponse createUpdateCacheResponse() {
        return new UpdateCacheResponse();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = RegisterUserResModel.class)
    public JAXBElement<Boolean> createRegisterUserResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, RegisterUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userId", scope = RegisterUserResModel.class)
    public JAXBElement<String> createRegisterUserResModelUserId(String value) {
        return new JAXBElement<String>(_RegisterUserResModelUserId_QNAME, String.class, RegisterUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = RegisterUserResModel.class)
    public JAXBElement<String> createRegisterUserResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, RegisterUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = RegisterUserResModel.class)
    public JAXBElement<String> createRegisterUserResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, RegisterUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderNo", scope = CancelOrderResModel.class)
    public JAXBElement<String> createCancelOrderResModelOrderNo(String value) {
        return new JAXBElement<String>(_CancelOrderResModelOrderNo_QNAME, String.class, CancelOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = CancelOrderResModel.class)
    public JAXBElement<Boolean> createCancelOrderResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, CancelOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = CancelOrderResModel.class)
    public JAXBElement<String> createCancelOrderResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, CancelOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = CancelOrderResModel.class)
    public JAXBElement<String> createCancelOrderResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, CancelOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "email", scope = ResetPwdReqModel.class)
    public JAXBElement<String> createResetPwdReqModelEmail(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelEmail_QNAME, String.class, ResetPwdReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "mobile", scope = ResetPwdReqModel.class)
    public JAXBElement<String> createResetPwdReqModelMobile(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelMobile_QNAME, String.class, ResetPwdReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "password", scope = ResetPwdReqModel.class)
    public JAXBElement<String> createResetPwdReqModelPassword(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelPassword_QNAME, String.class, ResetPwdReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderNo", scope = QueryOrderModel.class)
    public JAXBElement<String> createQueryOrderModelOrderNo(String value) {
        return new JAXBElement<String>(_CancelOrderResModelOrderNo_QNAME, String.class, QueryOrderModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeAddress", scope = QueryOrderModel.class)
    public JAXBElement<String> createQueryOrderModelConsigneeAddress(String value) {
        return new JAXBElement<String>(_QueryOrderModelConsigneeAddress_QNAME, String.class, QueryOrderModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeName", scope = QueryOrderModel.class)
    public JAXBElement<String> createQueryOrderModelConsigneeName(String value) {
        return new JAXBElement<String>(_QueryOrderModelConsigneeName_QNAME, String.class, QueryOrderModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "status", scope = QueryOrderModel.class)
    public JAXBElement<String> createQueryOrderModelStatus(String value) {
        return new JAXBElement<String>(_QueryOrderModelStatus_QNAME, String.class, QueryOrderModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "transNo", scope = QueryOrderModel.class)
    public JAXBElement<String> createQueryOrderModelTransNo(String value) {
        return new JAXBElement<String>(_QueryOrderModelTransNo_QNAME, String.class, QueryOrderModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = LoginUserResModel.class)
    public JAXBElement<Boolean> createLoginUserResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, LoginUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userId", scope = LoginUserResModel.class)
    public JAXBElement<String> createLoginUserResModelUserId(String value) {
        return new JAXBElement<String>(_RegisterUserResModelUserId_QNAME, String.class, LoginUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = LoginUserResModel.class)
    public JAXBElement<String> createLoginUserResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, LoginUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = LoginUserResModel.class)
    public JAXBElement<String> createLoginUserResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, LoginUserResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = PhoneOrderResModel.class)
    public JAXBElement<Boolean> createPhoneOrderResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, PhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "phoneOrderReqModel", scope = PhoneOrderResModel.class)
    public JAXBElement<PhoneOrderReqModel> createPhoneOrderResModelPhoneOrderReqModel(PhoneOrderReqModel value) {
        return new JAXBElement<PhoneOrderReqModel>(_PhoneOrderResModelPhoneOrderReqModel_QNAME, PhoneOrderReqModel.class, PhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userid", scope = PhoneOrderResModel.class)
    public JAXBElement<String> createPhoneOrderResModelUserid(String value) {
        return new JAXBElement<String>(_PhoneOrderResModelUserid_QNAME, String.class, PhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = PhoneOrderResModel.class)
    public JAXBElement<String> createPhoneOrderResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, PhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = PhoneOrderResModel.class)
    public JAXBElement<String> createPhoneOrderResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, PhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperTel", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperTel(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperTel_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderNo", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelOrderNo(String value) {
        return new JAXBElement<String>(_CancelOrderResModelOrderNo_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperEbrgNameCn", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperEbrgNameCn(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperEbrgNameCn_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeProv", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeProv(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeProv_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperAddress", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperAddress(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperAddress_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "escoSecondName", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelEscoSecondName(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelEscoSecondName_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "smsNotify", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelSmsNotify(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelSmsNotify_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeAreaCode", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeAreaCode(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeAreaCode_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderVer", scope = PhoneOrderReqModel.class)
    public JAXBElement<Integer> createPhoneOrderReqModelOrderVer(Integer value) {
        return new JAXBElement<Integer>(_PhoneOrderReqModelOrderVer_QNAME, Integer.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeAddress", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeAddress(String value) {
        return new JAXBElement<String>(_QueryOrderModelConsigneeAddress_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "cargoVolume", scope = PhoneOrderReqModel.class)
    public JAXBElement<Double> createPhoneOrderReqModelCargoVolume(Double value) {
        return new JAXBElement<Double>(_PhoneOrderReqModelCargoVolume_QNAME, Double.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeName", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeName(String value) {
        return new JAXBElement<String>(_QueryOrderModelConsigneeName_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeMobile", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeMobile(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeMobile_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "collDeliveryAmount", scope = PhoneOrderReqModel.class)
    public JAXBElement<Double> createPhoneOrderReqModelCollDeliveryAmount(Double value) {
        return new JAXBElement<Double>(_PhoneOrderReqModelCollDeliveryAmount_QNAME, Double.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeCompanyName", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeCompanyName(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeCompanyName_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperCompanyName", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperCompanyName(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperCompanyName_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperMobile", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperMobile(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperMobile_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userId", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelUserId(String value) {
        return new JAXBElement<String>(_RegisterUserResModelUserId_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperName", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperName(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperName_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperCity", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperCity(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperCity_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "cargoNumber", scope = PhoneOrderReqModel.class)
    public JAXBElement<Double> createPhoneOrderReqModelCargoNumber(Double value) {
        return new JAXBElement<Double>(_PhoneOrderReqModelCargoNumber_QNAME, Double.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderId", scope = PhoneOrderReqModel.class)
    public JAXBElement<Integer> createPhoneOrderReqModelOrderId(Integer value) {
        return new JAXBElement<Integer>(_PhoneOrderReqModelOrderId_QNAME, Integer.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeMethod", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeMethod(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeMethod_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "cargoWeight", scope = PhoneOrderReqModel.class)
    public JAXBElement<Double> createPhoneOrderReqModelCargoWeight(Double value) {
        return new JAXBElement<Double>(_PhoneOrderReqModelCargoWeight_QNAME, Double.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "escoSecondCode", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelEscoSecondCode(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelEscoSecondCode_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderOrign", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelOrderOrign(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelOrderOrign_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperProv", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperProv(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperProv_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "remark", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelRemark(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelRemark_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeEbrgNameCn", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeEbrgNameCn(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeEbrgNameCn_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeTel", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeTel(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeTel_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperAreaCode", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperAreaCode(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperAreaCode_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "shipperMethod", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelShipperMethod(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelShipperMethod_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "productType", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelProductType(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelProductType_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "consigneeCity", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelConsigneeCity(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelConsigneeCity_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "cargoName", scope = PhoneOrderReqModel.class)
    public JAXBElement<String> createPhoneOrderReqModelCargoName(String value) {
        return new JAXBElement<String>(_PhoneOrderReqModelCargoName_QNAME, String.class, PhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = ResetPwdResModel.class)
    public JAXBElement<Boolean> createResetPwdResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, ResetPwdResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userId", scope = ResetPwdResModel.class)
    public JAXBElement<Integer> createResetPwdResModelUserId(Integer value) {
        return new JAXBElement<Integer>(_RegisterUserResModelUserId_QNAME, Integer.class, ResetPwdResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = ResetPwdResModel.class)
    public JAXBElement<String> createResetPwdResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, ResetPwdResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = ResetPwdResModel.class)
    public JAXBElement<String> createResetPwdResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, ResetPwdResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderNo", scope = CancelOrderReqModel.class)
    public JAXBElement<String> createCancelOrderReqModelOrderNo(String value) {
        return new JAXBElement<String>(_CancelOrderResModelOrderNo_QNAME, String.class, CancelOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userid", scope = CancelOrderReqModel.class)
    public JAXBElement<String> createCancelOrderReqModelUserid(String value) {
        return new JAXBElement<String>(_PhoneOrderResModelUserid_QNAME, String.class, CancelOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "name", scope = RegisterUserReqModel.class)
    public JAXBElement<String> createRegisterUserReqModelName(String value) {
        return new JAXBElement<String>(_RegisterUserReqModelName_QNAME, String.class, RegisterUserReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "email", scope = RegisterUserReqModel.class)
    public JAXBElement<String> createRegisterUserReqModelEmail(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelEmail_QNAME, String.class, RegisterUserReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "mobile", scope = RegisterUserReqModel.class)
    public JAXBElement<String> createRegisterUserReqModelMobile(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelMobile_QNAME, String.class, RegisterUserReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "password", scope = RegisterUserReqModel.class)
    public JAXBElement<String> createRegisterUserReqModelPassword(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelPassword_QNAME, String.class, RegisterUserReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "modifyOrder", scope = ModifyOrderReqModel.class)
    public JAXBElement<PhoneOrderReqModel> createModifyOrderReqModelModifyOrder(PhoneOrderReqModel value) {
        return new JAXBElement<PhoneOrderReqModel>(_ModifyOrderReqModelModifyOrder_QNAME, PhoneOrderReqModel.class, ModifyOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userid", scope = ModifyOrderReqModel.class)
    public JAXBElement<String> createModifyOrderReqModelUserid(String value) {
        return new JAXBElement<String>(_PhoneOrderResModelUserid_QNAME, String.class, ModifyOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = ModifyOrderResModel.class)
    public JAXBElement<Boolean> createModifyOrderResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, ModifyOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "phoneOrderReqModel", scope = ModifyOrderResModel.class)
    public JAXBElement<PhoneOrderReqModel> createModifyOrderResModelPhoneOrderReqModel(PhoneOrderReqModel value) {
        return new JAXBElement<PhoneOrderReqModel>(_PhoneOrderResModelPhoneOrderReqModel_QNAME, PhoneOrderReqModel.class, ModifyOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userid", scope = ModifyOrderResModel.class)
    public JAXBElement<String> createModifyOrderResModelUserid(String value) {
        return new JAXBElement<String>(_PhoneOrderResModelUserid_QNAME, String.class, ModifyOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = ModifyOrderResModel.class)
    public JAXBElement<String> createModifyOrderResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, ModifyOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = ModifyOrderResModel.class)
    public JAXBElement<String> createModifyOrderResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, ModifyOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSupportingDataModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "supportingDataModel", scope = UpdateCacheResModel.class)
    public JAXBElement<ArrayOfSupportingDataModel> createUpdateCacheResModelSupportingDataModel(ArrayOfSupportingDataModel value) {
        return new JAXBElement<ArrayOfSupportingDataModel>(_UpdateCacheResModelSupportingDataModel_QNAME, ArrayOfSupportingDataModel.class, UpdateCacheResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "errMsg", scope = UpdateCacheResModel.class)
    public JAXBElement<String> createUpdateCacheResModelErrMsg(String value) {
        return new JAXBElement<String>(_UpdateCacheResModelErrMsg_QNAME, String.class, UpdateCacheResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "success", scope = UpdateCacheResModel.class)
    public JAXBElement<Boolean> createUpdateCacheResModelSuccess(Boolean value) {
        return new JAXBElement<Boolean>(_UpdateCacheResModelSuccess_QNAME, Boolean.class, UpdateCacheResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderNo", scope = QueryOrdersReqModel.class)
    public JAXBElement<String> createQueryOrdersReqModelOrderNo(String value) {
        return new JAXBElement<String>(_CancelOrderResModelOrderNo_QNAME, String.class, QueryOrdersReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "recordStart", scope = QueryOrdersReqModel.class)
    public JAXBElement<Integer> createQueryOrdersReqModelRecordStart(Integer value) {
        return new JAXBElement<Integer>(_QueryOrdersReqModelRecordStart_QNAME, Integer.class, QueryOrdersReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "recordEnd", scope = QueryOrdersReqModel.class)
    public JAXBElement<Integer> createQueryOrdersReqModelRecordEnd(Integer value) {
        return new JAXBElement<Integer>(_QueryOrdersReqModelRecordEnd_QNAME, Integer.class, QueryOrdersReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "customerID", scope = QueryOrdersReqModel.class)
    public JAXBElement<String> createQueryOrdersReqModelCustomerID(String value) {
        return new JAXBElement<String>(_QueryOrdersReqModelCustomerID_QNAME, String.class, QueryOrdersReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = QueryOrdersResModel.class)
    public JAXBElement<Boolean> createQueryOrdersResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, QueryOrdersResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQueryOrderModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "queryOrderModel", scope = QueryOrdersResModel.class)
    public JAXBElement<ArrayOfQueryOrderModel> createQueryOrdersResModelQueryOrderModel(ArrayOfQueryOrderModel value) {
        return new JAXBElement<ArrayOfQueryOrderModel>(_QueryOrdersResModelQueryOrderModel_QNAME, ArrayOfQueryOrderModel.class, QueryOrdersResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = QueryOrdersResModel.class)
    public JAXBElement<String> createQueryOrdersResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, QueryOrdersResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = QueryOrdersResModel.class)
    public JAXBElement<String> createQueryOrdersResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, QueryOrdersResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "loginName", scope = LoginUserReqModel.class)
    public JAXBElement<String> createLoginUserReqModelLoginName(String value) {
        return new JAXBElement<String>(_LoginUserReqModelLoginName_QNAME, String.class, LoginUserReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "password", scope = LoginUserReqModel.class)
    public JAXBElement<String> createLoginUserReqModelPassword(String value) {
        return new JAXBElement<String>(_ResetPwdReqModelPassword_QNAME, String.class, LoginUserReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "orderNo", scope = GetPhoneOrderReqModel.class)
    public JAXBElement<String> createGetPhoneOrderReqModelOrderNo(String value) {
        return new JAXBElement<String>(_CancelOrderResModelOrderNo_QNAME, String.class, GetPhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userid", scope = GetPhoneOrderReqModel.class)
    public JAXBElement<String> createGetPhoneOrderReqModelUserid(String value) {
        return new JAXBElement<String>(_PhoneOrderResModelUserid_QNAME, String.class, GetPhoneOrderReqModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "level", scope = SupportingDataModel.class)
    public JAXBElement<Integer> createSupportingDataModelLevel(Integer value) {
        return new JAXBElement<Integer>(_SupportingDataModelLevel_QNAME, Integer.class, SupportingDataModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "code", scope = SupportingDataModel.class)
    public JAXBElement<String> createSupportingDataModelCode(String value) {
        return new JAXBElement<String>(_SupportingDataModelCode_QNAME, String.class, SupportingDataModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "value", scope = SupportingDataModel.class)
    public JAXBElement<String> createSupportingDataModelValue(String value) {
        return new JAXBElement<String>(_SupportingDataModelValue_QNAME, String.class, SupportingDataModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "type", scope = SupportingDataModel.class)
    public JAXBElement<String> createSupportingDataModelType(String value) {
        return new JAXBElement<String>(_SupportingDataModelType_QNAME, String.class, SupportingDataModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "parentCode", scope = SupportingDataModel.class)
    public JAXBElement<String> createSupportingDataModelParentCode(String value) {
        return new JAXBElement<String>(_SupportingDataModelParentCode_QNAME, String.class, SupportingDataModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "queryOrder", scope = GetPhoneOrderResModel.class)
    public JAXBElement<PhoneOrderReqModel> createGetPhoneOrderResModelQueryOrder(PhoneOrderReqModel value) {
        return new JAXBElement<PhoneOrderReqModel>(_GetPhoneOrderResModelQueryOrder_QNAME, PhoneOrderReqModel.class, GetPhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "result", scope = GetPhoneOrderResModel.class)
    public JAXBElement<Boolean> createGetPhoneOrderResModelResult(Boolean value) {
        return new JAXBElement<Boolean>(_RegisterUserResModelResult_QNAME, Boolean.class, GetPhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "userid", scope = GetPhoneOrderResModel.class)
    public JAXBElement<String> createGetPhoneOrderResModelUserid(String value) {
        return new JAXBElement<String>(_PhoneOrderResModelUserid_QNAME, String.class, GetPhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultCode", scope = GetPhoneOrderResModel.class)
    public JAXBElement<String> createGetPhoneOrderResModelResultCode(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultCode_QNAME, String.class, GetPhoneOrderResModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.mobile.interfaces.sinotrans.com", name = "resultInfo", scope = GetPhoneOrderResModel.class)
    public JAXBElement<String> createGetPhoneOrderResModelResultInfo(String value) {
        return new JAXBElement<String>(_RegisterUserResModelResultInfo_QNAME, String.class, GetPhoneOrderResModel.class, value);
    }

}
