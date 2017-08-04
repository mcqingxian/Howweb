package com.hoau.how.module.obh.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSONObject;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.common.constants.ClaimEnum;
import com.hoau.how.module.common.constants.ControllConstants;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.common.constants.SysConfigConstants;
import com.hoau.how.module.itf.server.service.IDcWaybillInfoService;
import com.hoau.how.module.obh.server.service.IAccountBankInfoService;
import com.hoau.how.module.obh.server.service.IClaimService;
import com.hoau.how.module.obh.shared.domain.ClaimSubmitEntity;
import com.hoau.how.module.obh.shared.domain.ClaimValidEntity;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.exception.OBHException;
import com.hoau.how.module.obh.shared.util.ClaimImageManage;
import com.hoau.how.module.obh.shared.util.Paging;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.obh.shared.vos.AccountBankInfoVo;
import com.hoau.how.module.util.UUIDUtil;
import com.hoau.how.module.util.date.DateUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * 理赔操作
 * @author 徐俊
 * @date 2015年8月10日
 */
@Controller
@Scope("prototype")
public class ClaimAction extends AbstractAction{

	private int pageSize;
	private int pageNo = 1;
	private String categoryName;
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String controllType;	

	
	//图片上传
	private File upload;
	private String uploadFileName;
	private boolean staute;
    private String message = "成功上传文件";
    private String imagePath;
    private boolean isDeleted=false;
	
    private ClaimSubmitEntity claimSubmitEntity;
    private ClaimValidEntity claimValidEntity;
     
    private List<ClaimSubmitEntity> claimSubmitEntities;
    
    private Paging<ClaimSubmitEntity> paging;
    
    /**
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年1月15日
	 * @auth:短信确认action参数
	 */
    private String params;//
    private String claimNo;//理赔号
    
    //开户行信息，田育林
    private List<AccountBankInfoVo> bankInfos;
    //查询关键字，田育林
    private String bankKey;
    
    @Resource
    private IClaimService claimService;
    
    //田育林
    @Resource
	private IDcWaybillInfoService dcWaybillInfoService;
    @Resource
    private IAccountBankInfoService accountBankInfoService;
    /**
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年2月23日
	 * @auth:增加日志
	 */
    private Logger log = Logger.getLogger(ClaimAction.class);
    /**
     * end
     */
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	/**
	 * 图片上传
	 * @return 
	 * @throws Exception
	 * @author 张贞献
	 * @date 2015年8月17日
	 * @update 
	 */

	public String upload() throws Exception {
		imagePath = imagePath.toUpperCase();
		String path = SysConfigConstants.CLAIM_IMG_DIR + imagePath + "/";
		File file = this.getUpload();
		FileInputStream in = null;
		FileOutputStream out = null;
		//String temp = "";
		try {
			ClaimImageManage.existDri(path);
			if(ClaimImageManage.exist(path + "/" + this.getUploadFileName())){
				staute = false;
				message = ClaimEnum.CLAIM_RESULT_REPEAT;
				uploadFileName = imagePath + "/" + this.getUploadFileName();
				imagePath = SysConfigConstants.CLAIM_IMG_PATH + this.getUploadFileName();
				return returnSuccess();
			}
			
			in = new FileInputStream(file);
			if(ClaimImageManage.isMoreSize(in)){
				staute = false;
				uploadFileName="";
				message = ClaimEnum.CLAIM_RESULT_OVERSIZE;
				return returnSuccess();
			}
			
			//委托授权特殊处理在文件名前
			/*if(ClaimEnum.IMAGE_TYPE_AUTHORIZATION_CERTIFICATE.equals(imagePath.substring(imagePath.lastIndexOf('/')+1))){
				temp = ClaimEnum.AUTHORIZATION_CERTIFICATE;
			}*/
			out = new FileOutputStream(path + this.getUploadFileName());
			//out = new FileOutputStream(path + temp+this.getUploadFileName());
			ClaimImageManage.saveImg(in, out);
			
		} catch (Exception e) {
			e.printStackTrace();
			staute = false;
			uploadFileName="";
			message = ClaimEnum.CLAIM_RESULT_UPLOAD_FAIL;
		}finally{
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
			
		}
		staute = true;
		uploadFileName = imagePath + "/" + this.getUploadFileName();
		//uploadFileName = imagePath + "/" +temp+ this.getUploadFileName();
		imagePath = SysConfigConstants.CLAIM_IMG_PATH + uploadFileName;
		return returnSuccess();
	}
	
	/**
	 * 删除图片
	 * @return
	 * @author 张贞献
	 * @date 2015年8月17日
	 * @update 
	 */
	public String deleteImg() {
		imagePath = imagePath.toUpperCase();
		try {
			isDeleted = ClaimImageManage.imageDelete(imagePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnSuccess();
	}

	/**
	 * 删除理赔单信息
	 * @return
	 * @author 徐俊
	 * @date 2015年8月24日
	 * @update 
	 */
	public String delete() {
		try {
			claimService.deleteClaimRecord(claimSubmitEntity.getBillNo());
		} catch (OBHException e) {
			e.printStackTrace();
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 * 更新理赔单信息
	 * @return
	 * @author 徐俊
	 * @date 2015年8月24日
	 * @update 
	 */
	public String update() {
		try {
			if(claimSubmitEntity.getClaimNo()!=null && !claimSubmitEntity.getClaimNo().equals("")){
				claimSubmitEntity = claimService.queryClaimsInfo(claimSubmitEntity.getBillNo(), claimSubmitEntity.getClaimNo());
				if(claimSubmitEntity!=null){
					claimSubmitEntity.setId(UUIDUtil.getUUID());
					if(!StringUtil.isEmpty(claimSubmitEntity.getImgMapString())){
						claimSubmitEntity.setImgMapString(ClaimImageManage.AllImagePathByWaybill(claimSubmitEntity.getImgMapString()));
					}	
			        if(ClaimImageManage.existIstrust(claimSubmitEntity.getBillNo())){
			        	claimSubmitEntity.setIsEntrust("YES");
			        }else{
			        	claimSubmitEntity.setIsEntrust("NO");
			        	}
				}
			}else{
				claimSubmitEntity = claimService.findLocalClaimRecord(claimSubmitEntity.getBillNo());	
			}
			
		} catch (OBHException e) {
			e.printStackTrace();
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 *  校验理赔单号
	 * @return
	 * @author 张贞献
	 * @date 2015年8月19日
	 * @update 
	 */
	public String validBillNo() {
		try {
			//将运单号中的小写字母全部转换为大写，田育林，2016-05-30
			String billNo = claimValidEntity.getBillNo();
			if(billNo!=null && !"".equals(billNo)){
				billNo = billNo.toUpperCase();
				claimValidEntity.setBillNo(billNo);
			}
			claimValidEntity = claimService.validBillNo(claimValidEntity.getBillNo());
//			if(!"FAIL".equals(claimValidEntity.getStatus())){
//				//查询此运单是否已经提交了理赔申请，田育林，2016-05-05
//				CustomerContactEntity contactEntity = getCurrentUser();
//				String valid = claimService.validExistBillNo(contactEntity.getEbccEbcuId().toString(), billNo);
//				if("EXIST_CLAIM".equals(valid)){
//					claimValidEntity.setStatus("FAIL");
//					claimValidEntity.setErrroInfo("此运单已经提交过理赔申请，请勿重复提交");
//				}
//			}
		} catch (OBHException e) {	
			e.printStackTrace();
			staute = false;
			message = ClaimEnum.CLAIM_RESULT_VALID_FAIL;
		}
		return returnSuccess();
	}
	

	/**
	 * 校验运单联系人
	 * @return
	 * @author 张贞献
	 * @date 2015年8月19日
	 * @update 
	 */
	public String validClaimTel() {
		try {
			//将运单号中的小写字母全部转换为大写，田育林，2016-05-30
			String billNo = claimValidEntity.getBillNo();
			if(billNo!=null && !"".equals(billNo)){
				billNo = billNo.toUpperCase();
				claimValidEntity.setBillNo(billNo);
			}
			claimValidEntity =  claimService.validBillTel(claimValidEntity);
		} catch (OBHException e) {
			if(claimValidEntity==null){
				claimValidEntity = new ClaimValidEntity();
			}
			claimValidEntity.setStatus("2");
			claimValidEntity.setErrroInfo(e.getErrorCode());
			staute = false;
			return returnError(e);
		}
		return returnSuccess();
	}
	/**
	 * @throws ParseException 
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年1月15日
	 * @auth:跳转到短信理赔确认页面
	 */
	public String toAmountConfirm(){
		message = ClaimEnum.CLAIM_RESULT_SMS_STATUS;
		long startDate = new Date().getTime();
		try {
			JSONObject jsonObj = JSONObject.parseObject(params);
			String sendDate = jsonObj.getString("sendDate");//短信发送时间
			String billNo = jsonObj.getString("billNo");//订单号
			String userID = jsonObj.getString("userID");//用户ID
			log.info("sendDate:" + sendDate);
			log.info("billNo:" + billNo);
			log.info("userID:" + userID);
			if(claimSubmitEntity == null){
				claimSubmitEntity = new ClaimSubmitEntity();
			}
			claimSubmitEntity.setEbcuId(Long.parseLong(userID));
			claimSubmitEntity.setBillNo(billNo);
			long jxDate = new Date().getTime();
			log.info("解析完json时间：" + jxDate+ " 时间差=" + (jxDate-startDate));
			paging = claimService.queryClaimsByUserId(claimSubmitEntity,9999,1);
			long dyDate = new Date().getTime();
			log.info("调用完接口时间：" + dyDate+ " 时间差=" + (dyDate-jxDate));
			List<ClaimSubmitEntity> claims = paging.getData();
			if(null != claims && claims.size() > 0){
				claimSubmitEntity = claims.get(0);
			}
			if(null == claimSubmitEntity.getStatus()){
				return "error";
			}
			log.info("claimSubmitEntity.getStatus():"+claimSubmitEntity.getStatus());
			//判断状态是否是理赔金额确认状态，田育林修改，2016-05-04
			if(!claimSubmitEntity.getStatus().equals(ClaimEnum.ALLSTATUS.get(ClaimEnum.CLAIM_STATUS_UNCONFIRMEDCLAIMSAMOUNT)) || claimSubmitEntity.getRefuseStatus() == 1){
				int refuseStatus = claimSubmitEntity.getRefuseStatus();
				log.info("claimSubmitEntity.getRefuseStatus():"+refuseStatus);
				if(refuseStatus == ClaimEnum.CLAIM_REFUSE_AGREE){ //用户已经点击“同意”按钮
					return "alreadConfirm";
				}else if(refuseStatus == ClaimEnum.CLAIM_REFUSE_NOTAGREE){ //用户已经点击“不同意”按钮
					return "alreadRefuse";
				}
			}
			long pdDate = new Date().getTime();
			log.info("判断完状态时间：" + pdDate+ " 时间差=" + (pdDate-dyDate));
			Date date = DateUtils.parseDateYmdshms(sendDate);
			long diffDate = new Date().getTime() - date.getTime();
			long num1 = diffDate/(60*60*1000);
			//判断当前点击时间是否超过短信发送时间4个小时
			if(num1 >= 4){
				return "timeOut";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		long wcDate = new Date().getTime();
		log.info("结束时间：" + wcDate+ " 整体时间差=" + (wcDate-startDate));
		return returnSuccess();
	}
	/**
	 * end 
	 */
	
	/**
	 * 理赔查询
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年8月10日
	 * @update 
	 */
	@PermissionCheck
	public String query() throws Exception {
		controllType = ControllConstants.CONTROLL_MY_HOAU.CLAIM_QUERY;// 控制菜单展开
		try {
			if(claimSubmitEntity == null){
				claimSubmitEntity = new ClaimSubmitEntity();
			}
			CustomerContactEntity contactEntity = getCurrentUser();
			claimSubmitEntity.setEbccId(contactEntity.getEbccId());
			claimSubmitEntity.setEbcuId(contactEntity.getEbccEbcuId());
			paging = claimService.queryClaimsByUserId(claimSubmitEntity,pageSize,pageNo);
		} catch (OBHException e) {
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 * 理赔金额确认
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年8月25日
	 * @update 
	 */
	@PermissionCheck
	public String amountConfirm() throws Exception {
		try {
			claimService.confirmClaimsAmount(claimSubmitEntity.getBillNo());
		} catch (OBHException e) {
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年1月18日
	 * @auth:短信理赔金额确认
	 */
	public String amountConfirmSMS() throws Exception {
		try {
			claimService.confirmClaimsAmount(claimSubmitEntity.getBillNo());
		} catch (OBHException e) {
			return returnError(e);
		}
		return returnSuccess();
	}
	/**
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年1月18日
	 * @auth:不同意理赔
	 */
	public String refuseClaimsAmount() throws Exception {
		try {
			claimService.refuseClaimsAmount(claimSubmitEntity.getBillNo());
		} catch (OBHException e) {
			return returnError(e);
		}
		return returnSuccess();
	}
	/**
	 * end
	 */
	
	
	/**
	 * 提交理赔申请
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年8月11日
	 * @update 
	 */
	@PermissionCheck
	public String submit() throws Exception {
		
		CustomerContactEntity userInfo = getCurrentUser();
		claimSubmitEntity.setEbccId(userInfo.getEbccId());
		claimSubmitEntity.setEbcuId(userInfo.getEbccEbcuId());
		claimSubmitEntity.setImgMapString(claimSubmitEntity.getImgMapString().replace("\n", ""));
		ClaimImageManage.dealImgs(claimSubmitEntity.getImgMapString(),claimSubmitEntity);
		//将运单号中的小写字母全部转换为大写，田育林，2016-05-30
		String billNo = claimSubmitEntity.getBillNo();
		if(billNo!=null && !"".equals(billNo)){
			billNo = billNo.toUpperCase();
			claimSubmitEntity.setBillNo(billNo);
		}
		try {
			claimService.uploadClaim(claimSubmitEntity);
		} catch (OBHException e) {
		//	e.getErrorCode()
			staute = false;
			message = e.getErrorCode();
			return returnSuccess();
		} 
		
		staute = true;
		message = ClaimEnum.CLAIM_RESULT_SUBMIT_SUCCESS;
		return returnSuccess();
	}
	
	/**
	 * 查看理赔申请明细
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年8月11日
	 * @update 
	 */
	@PermissionCheck
	public String view() throws Exception {
		claimSubmitEntity = claimService.queryClaimsInfo(claimSubmitEntity.getBillNo(), claimSubmitEntity.getClaimNo());
		return returnSuccess();
	}

	/**
	 * 查看未提交理赔申请明细
	 * @return
	 * @throws Exception
	 * @author 潘强
	 * @date 2015年11月17日
	 * @update 
	 */
	@PermissionCheck
	public String viewUnSubmit() throws Exception{
		claimSubmitEntity=claimService.queryClaim(claimSubmitEntity);
		String s=claimSubmitEntity.getImgMapString();
		String [] array=s.split(";");
		for (int i=0;i<array.length;i++) {
			String s1=array[i];
			int paramInt1=s1.indexOf("=");
			array [i]=s1.substring(paramInt1+1, s1.length());
		}
	    //将字符数组转换成字符串
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < array.length; i++){
		sb. append(array[i]+";");
		}
		String newStr = sb.toString();
		claimSubmitEntity.setImgMapString(newStr);
		
		return returnSuccess();
	}
	/**
	 * 理赔请求
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年8月10日
	 * @update 
	 */
	@PermissionCheck
	public String request() throws Exception {	
		controllType = ControllConstants.CONTROLL_MY_HOAU.CLAIM_REQUEST;// 控制菜单展开
		return super.execute();
	}

	/**
	 * 根据关键字查询开户行信息
	 * @author 田育林
	 * @date 2016年6月28日
	 */
	@PermissionCheck
	public String queryBankInfo() throws Exception {
		if(bankKey!=null && !"".equals(bankKey)){
			bankInfos = accountBankInfoService.queryBankInfo(bankKey);
		}
		return returnSuccess();
	}
	
	public String getControllType() {
		return controllType;
	}

	public void setControllType(String controllType) {
		this.controllType = controllType;
	}

	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isStaute() {
		return staute;
	}

	public void setStaute(boolean staute) {
		this.staute = staute;
	}

	public ClaimSubmitEntity getClaimSubmitEntity() {
		return claimSubmitEntity;
	}

	public void setClaimSubmitEntity(ClaimSubmitEntity claimSubmitEntity) {
		this.claimSubmitEntity = claimSubmitEntity;
	}

	public ClaimValidEntity getClaimValidEntity() {
		return claimValidEntity;
	}

	public void setClaimValidEntity(ClaimValidEntity claimValidEntity) {
		this.claimValidEntity = claimValidEntity;
	}
	private CustomerContactEntity getCurrentUser(){
		ActionContext ctx = ActionContext.getContext();
		Object o = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		if(o == null){
			throw new OBHException(OBHException.NOT_LOGIN,"notLogin");
		}
		CustomerContactEntity po = (CustomerContactEntity)o;
		return po;
	}

	public List<ClaimSubmitEntity> getClaimSubmitEntities() {
		return claimSubmitEntities;
	}

	public void setClaimSubmitEntities(List<ClaimSubmitEntity> claimSubmitEntities) {
		this.claimSubmitEntities = claimSubmitEntities;
	}

	public Paging<ClaimSubmitEntity> getPaging() {
		return paging;
	}

	public void setPaging(Paging<ClaimSubmitEntity> paging) {
		this.paging = paging;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

 	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public List<AccountBankInfoVo> getBankInfos() {
		return bankInfos;
	}

	public void setBankInfos(List<AccountBankInfoVo> bankInfos) {
		this.bankInfos = bankInfos;
	}

	public String getBankKey() {
		return bankKey;
	}

	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}

}
