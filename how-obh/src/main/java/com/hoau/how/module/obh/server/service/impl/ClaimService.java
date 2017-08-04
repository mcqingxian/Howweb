package com.hoau.how.module.obh.server.service.impl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.bse.server.dao.goodstrace.CompanyEntityMapper;
import com.hoau.how.module.common.constants.ClaimEnum;
import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.common.shared.domain.CompanyEntity;
import com.hoau.how.module.itf.server.service.IDcWaybillInfoService;
import com.hoau.how.module.itf.server.ws.claim.ClaimsInfo;
import com.hoau.how.module.itf.server.ws.claim.ClaimsWBService;
import com.hoau.how.module.itf.server.ws.claim.ClaimsWBServiceImplService;
import com.hoau.how.module.itf.server.ws.claim.QueryClaimsDetail;
import com.hoau.how.module.itf.server.ws.claim.QueryClaimsInfo;
import com.hoau.how.module.itf.server.ws.claim.QueryCorpResult;
import com.hoau.how.module.itf.server.ws.claim.ResponseClaimsObject;
import com.hoau.how.module.itf.server.ws.claim.ResponseQueryClaims;
import com.hoau.how.module.itf.server.ws.claim.ResponseQueryFiles;
import com.hoau.how.module.itf.server.ws.waybilldetail.WptYdInfo;
import com.hoau.how.module.obh.server.dao.CustomerClaimDao;
import com.hoau.how.module.obh.server.service.IClaimService;
import com.hoau.how.module.obh.shared.domain.ClaimSubmitEntity;
import com.hoau.how.module.obh.shared.domain.ClaimValidEntity;
import com.hoau.how.module.obh.shared.exception.OBHException;
import com.hoau.how.module.obh.shared.util.ClaimImageManage;
import com.hoau.how.module.obh.shared.util.Paging;


/**
 * 理赔服务
 * @author 徐俊
 * @date 2015年8月19日
 */
@Service
public class ClaimService implements IClaimService {
	
	private Logger log = Logger.getLogger(ClaimService.class);
	private static ClaimsWBService claimsWBService = null;
	
	@Resource
	private IDcWaybillInfoService dcWaybillInfoService;
	@Resource
	private CustomerClaimDao customerClaimDao;
	@Resource
	private CompanyEntityMapper companyEntityMapper;
	
	static{
		try {
			ClaimsWBServiceImplService service = null;
			service = new ClaimsWBServiceImplService(new URL(ItfConifgConstant.CLAIM_URL));
			claimsWBService = service.getClaimsWBServiceImplPort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private ClaimValidEntity wrap(WptYdInfo wptYdInfo) {
		
		ClaimValidEntity claimValidEntity = new ClaimValidEntity();
		if(wptYdInfo != null && !wptYdInfo.isSTATUS()){
			claimValidEntity.setErrroInfo(wptYdInfo.getERROR());
			claimValidEntity.setStatus("FAIL");
			return claimValidEntity;
		}
		claimValidEntity.setBillNo(wptYdInfo.getYDBH());
		claimValidEntity.setPieces(wptYdInfo.getJS());
		CompanyEntity qydGsjcCompanyEntity = companyEntityMapper.selectCompanyByCode(wptYdInfo.getQYDSSYJGS());
		CompanyEntity mddGsjcCompanyEntity = companyEntityMapper.selectCompanyByCode(wptYdInfo.getMDDSSYJGS());
		
		if(qydGsjcCompanyEntity != null) {
			//发货理赔公司所在地
			claimValidEntity.setDepartCompanyAddr(qydGsjcCompanyEntity.getCity());
		}
		if(mddGsjcCompanyEntity != null) {
			//收货理赔公司所在地
			claimValidEntity.setDestCompanyAddr(mddGsjcCompanyEntity.getCity());
		}
		
		return claimValidEntity;
	}

	/**
	 * 验证电话是否正确
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	@Override
	public ClaimValidEntity validBillTel(ClaimValidEntity vo) {
		ClaimValidEntity claimValidEntity = new ClaimValidEntity();
		
		//运单号
		String waybill = vo.getBillNo();
		//电话
		String phone = vo.getBillTel();
		
		/*2015、12、4List<QueryCorpResult>  re = claimsWBService.findClaimsPlace(waybill,phone);
	
		if(re != null && re.size()>0){
			claimValidEntity.setStatus("1");
			claimValidEntity.setDepartCompanyAddr(re.get(0).getCsmc());
		}else{
			claimValidEntity.setStatus("2");
			claimValidEntity.setErrroInfo("运单号和电话号码不匹配");
		}*/
		
		List<QueryCorpResult> corpResults = claimsWBService.findClaimsPlace(waybill, phone);
		//通过电话和运单号没有查询到信息
		if(corpResults == null || corpResults.size() == 0){
			claimValidEntity.setStatus("2");
			claimValidEntity.setErrroInfo("运单号和电话号码不匹配");
		}else if(corpResults.size() == 2){ //发货人和收货人是同一人 自己给自己寄货
			claimValidEntity.setStatus("1");
			for (int i = 0; i < corpResults.size(); i++){
				if(claimValidEntity.getDepartCompanyAddr()==null){
					String s=corpResults.get(i).getCsmc()+",";
					claimValidEntity.setDepartCompanyAddr(s);
				}else if(claimValidEntity.getDepartCompanyAddr()!=null){
					String s=corpResults.get(i).getCsmc();
					claimValidEntity.setDepartCompanyAddr(claimValidEntity.getDepartCompanyAddr()+s);
				}
			}
		}else if(corpResults.size() == 1){//只有一条记录  收货地公司信息  或者  发货地公司信息
			//查询此运单是否已经过期（运单创建时间超过6个月就为过期），田育林，2016-05-17
			if(corpResults.get(0).isOverDue()==true){
				claimValidEntity.setStatus("FAIL");
				claimValidEntity.setErrroInfo("此运单已经过期，不能再进行理赔申请");
			}else{
				claimValidEntity.setStatus("1");
				claimValidEntity.setDepartCompanyAddr(corpResults.get(0).getCsmc());
			}
		}
			
		
		/*WptYdInfo ydInfo  = getWaybillFromDc(waybill);
		String qydGsjc = null;
		String mddGsjc = null;
		if(ydInfo != null){
			CompanyEntity qydGsjcCompanyEntity = companyEntityMapper.selectCompanyByCode(ydInfo.getQYDSSYJGS());
			if(qydGsjcCompanyEntity != null){
				qydGsjc = qydGsjcCompanyEntity.getShortName();
			}
			CompanyEntity mddGsjcCompanyEntity = companyEntityMapper.selectCompanyByCode(ydInfo.getMDDSSYJGS());
			if(mddGsjcCompanyEntity != null){
				mddGsjc = mddGsjcCompanyEntity.getShortName();
			}
			
		}
		
		
		List<QueryCorpResult> corpResults = queryCorp(waybill,phone);
		//通过电话和运单号没有查询到信息
		if(corpResults == null || corpResults.size() == 0){
			claimValidEntity.setStatus("2");
			claimValidEntity.setErrroInfo("运单号和电话号码不匹配");
		}else if(corpResults.size() == 2){ //发货人和收货人是同一人 自己给自己寄货
			claimValidEntity.setStatus("1");
			claimValidEntity.setClaimParty("DEPART");
		}else if(corpResults.size() == 1){ //只有一条记录  收货地公司信息  或者  发货地公司信息
			QueryCorpResult corpResult= corpResults.get(0);
			//理赔方， 是发货人
			if(corpResult.getGsjc().equalsIgnoreCase(qydGsjc)){
				claimValidEntity.setStatus("1");
				claimValidEntity.setClaimParty("DEPART");
			}else if(corpResult.getGsjc().equalsIgnoreCase(mddGsjc)){//理赔方 是收货人
				claimValidEntity.setStatus("1");
				claimValidEntity.setClaimParty("DEST");
			} 
		}*/
		return claimValidEntity;
	}

/*	@SuppressWarnings("unchecked")
	private List<QueryCorpResult> queryCorp(String waybill, String phone) {
		QueryCorpRequest corpRequest = new  QueryCorpRequest();
		corpRequest.setYdbh(waybill);
		corpRequest.setLxrdh(phone);
		List<QueryCorpResult> result = null;
		try {
			result  = (List<QueryCorpResult>)NetUtil.sendObjToServer(corpRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}*/

	/**
	 * 理赔上报校验 （通过运单号获取一些运单信息：出发部门所属一级公司，到达部门所属一级工，件数）
	 * @return
	 * @author xujun
	 * @date 2015年8月21日
	 * @update
	 */
	@Override
	public ClaimValidEntity validBillNo(String waybill/*,boolean isupdate*/) {
		//1、是否已经理赔,如果已近生成了理赔信息
		/*
		if(!isupdate){
			ClaimValidEntity claimValidEntity = new ClaimValidEntity();
			claimValidEntity.setStatus("FAIL");
			claimValidEntity.setErrroInfo("该单号已经存在理赔信息");
			return claimValidEntity;
		}
		*/
		//2、如果可以理赔，返回运单相关信息
		ClaimValidEntity claimValidEntity = new ClaimValidEntity();
		claimValidEntity = wrap(getWaybillFromDc(waybill));
		return claimValidEntity;
	}

	/*private boolean existClaimInfo(String waybill) {
		int count = customerClaimDao.queryClaimCount(waybill);
		if(count>0){
			return true;
		}
		return false;
	}*/

	/**
	 * 提交理赔单
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	@Override
	@Transactional(rollbackFor = OBHException.class)
	public void uploadClaim(ClaimSubmitEntity claimSubmitEntity) {
		//保存数据库
		if(claimSubmitEntity.getStatus().equals("UN_SUBMIT")){
			ResponseQueryClaims queryClaims = claimsWBService.getClaims(String.valueOf(claimSubmitEntity.getEbccId()));
			List<QueryClaimsInfo> claimsInfos = queryClaims.getQueryClaimsInfos();
			if(claimsInfos != null && claimsInfos.size()>0){
				List<ClaimSubmitEntity> claimSubmitEntities = wrapClaimSubmitEntities(claimsInfos,claimSubmitEntity.getStatus());
				for (ClaimSubmitEntity submitEntity : claimSubmitEntities) {
					if(submitEntity.getBillNo().equals(claimSubmitEntity.getBillNo()) 
							&& !submitEntity.getStatus().equals("已退回") 
							&& !submitEntity.getStatus().equals("已作废")){
						throw new OBHException("该订单已提交过理赔，请不要保存草稿！");
					}
				}
			}
			
			if(customerClaimDao.queryClaimCount(claimSubmitEntity.getBillNo()) > 0 ){
				customerClaimDao.modifyClaim(claimSubmitEntity);
			}else{
				customerClaimDao.saveClaim(claimSubmitEntity);
			}
			return;
		}
		
		//调用webservcie 接口
		ClaimsInfo claimsInfo = wrapClaimsInfo(claimSubmitEntity);
		ResponseClaimsObject claimsObject = claimsWBService.uploadClaims(claimsInfo);
		if(claimsObject.isSuccess()){
			//更新状态
			if(customerClaimDao.queryClaimCount(claimSubmitEntity.getBillNo()) > 0 ){
				//customerClaimDao.modifyClaim(claimSubmitEntity);
				customerClaimDao.updateStatus(claimSubmitEntity.getBillNo(),ClaimEnum.LOCAL_CLAIM_STATUS_DELETE);
			}/*else{
				customerClaimDao.saveClaim(claimSubmitEntity);
			}*/
		}else{
			throw new OBHException(claimsObject.getErrorMessage());
		}
	}

	@Override
	public ClaimSubmitEntity queryClaim(ClaimSubmitEntity claimSubmitEntity) {
		List<ClaimSubmitEntity> list =customerClaimDao.queryClaims(claimSubmitEntity);
		if(list!=null && list.size()>0){
			ClaimSubmitEntity cse=list.get(0);
			cse.setCargoType(ClaimEnum.CARGO_TYPE.get(cse.getCargoType()));
			cse.setAccidentType(ClaimEnum.ACCIDENT_TYPE.get(cse.getAccidentType()));
			return cse;
		}
		return null;
	}  

	//TODO XUJUN
	private ClaimsInfo wrapClaimsInfo(ClaimSubmitEntity claimSubmitEntity) {
		String billNo = claimSubmitEntity.getBillNo();
		ClaimsInfo claimsInfo = new ClaimsInfo();
		claimsInfo.setAccidentType(claimSubmitEntity.getAccidentType());
		claimsInfo.setBillNo(billNo);
		claimsInfo.setBillTel(claimSubmitEntity.getBillTel());
		claimsInfo.setCargoType(claimSubmitEntity.getCargoType());
		claimsInfo.setClaimsAmount(claimSubmitEntity.getClaimsAmount());
		claimsInfo.setClaimsOwner(claimSubmitEntity.getContactName());
		claimsInfo.setContactMail(claimSubmitEntity.getContactMail());
		claimsInfo.setContactName(claimSubmitEntity.getContactName());
		claimsInfo.setContactTel(claimSubmitEntity.getContactTel());
		claimsInfo.setCreateBy(String.valueOf(claimSubmitEntity.getEbcuId()));
		claimsInfo.setExceptionCount(claimSubmitEntity.getExceptionCount());
		claimsInfo.setPayeeName(claimSubmitEntity.getClaimCompanyAddr());
		claimsInfo.setReason(claimSubmitEntity.getReason());
		/**设置开户行信息，田育林，2016-06-06**/
		claimsInfo.setBankAccount(claimSubmitEntity.getAccountCode()); //银行卡账号
		claimsInfo.setBankAccountName(claimSubmitEntity.getAccountName()); //开户名
		claimsInfo.setBankName(claimSubmitEntity.getAccountBank()); //开户行
		String proAndCity = claimSubmitEntity.getAccountCity();
		String province = "";
		String city = "";
		if(proAndCity!=null && !"".equals(proAndCity)){
			String[] pcs = proAndCity.split("-");
			province = pcs[0] == "" ? "" : pcs[0];
			city = pcs[1] == "" ? "" : pcs[1];
		}
		claimsInfo.setBankProvince(province); //开户行省份
		claimsInfo.setBankCity(city); //开户行市县
		
		/**
		 * 设置理赔渠道为为官网理赔
		 * add
		 * huyuzhou 2015-01-15
		 */
		claimsInfo.setChannel(ClaimEnum.CLAIM_CHANNEL_OFFICIAL);
		/**
		 * end
		 */
		
		//七张图片 (少一张 客户委托)

        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_ID_CARDS)){
        	//身份证
    		claimsInfo.setIdentificationCardFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_ID_CARDS));
        }
		
        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_BANK_CARDS)){
        	//银行卡
        	claimsInfo.setBankCardFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_BANK_CARDS));
        }
		
        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_ARRIVE_SIGN_VOUCHER)){
        	//到货签收凭证图
        	claimsInfo.setCargoReceiptFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_ARRIVE_SIGN_VOUCHER));
        }
        
        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_INVOICE_COPY)){
			//*发票复印件图片
			claimsInfo.setInvoiceFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_INVOICE_COPY));
        }
        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_GOODS_DAMAGED)){
	        //*发票复印件图片
			claimsInfo.setDamageFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_GOODS_DAMAGED));
        }
        
        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_CLAIM_LETTER) 
        		|| claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_AUTHORIZATION_CERTIFICATE)){
	        //索赔函   共用 客户委托授权证明
			claimsInfo.setClaimOrderFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_CLAIM_LETTER,ClaimEnum.IMAGE_TYPE_AUTHORIZATION_CERTIFICATE));
        }
        if(claimSubmitEntity.getZipDir().contains(ClaimEnum.IMAGE_TYPE_WAYBILL_IMAGE)){
	        //发货运单图片
			claimsInfo.setShippingOrderFiles(ClaimImageManage.getImages(billNo, ClaimEnum.IMAGE_TYPE_WAYBILL_IMAGE));
        }
        return claimsInfo;
	}

	private WptYdInfo getWaybillFromDc(String waybill){
		List<String> waybills = new ArrayList<String>();
		waybills.add(waybill);
		List<WptYdInfo> ydInfo  = dcWaybillInfoService.getYdinfos(waybills);
		if(ydInfo == null || ydInfo.size() == 0){
			throw new OBHException("waybill incorrect or not exist");
		}else{
			return ydInfo.get(0);
		}
	}
	/**
	 * 理赔金额确认
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	@Override
	public void confirmClaimsAmount(String claimNo) {
		ResponseClaimsObject claimsObject = claimsWBService.confirmClaimsAmount(claimNo);
		log.info("提交理赔返回信息："+claimsObject.getErrorMessage()+" "+claimsObject.isSuccess());
	}
	/**
	 * 不同意理赔
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	@Override
	public void refuseClaimsAmount(String claimNo) {
		ResponseClaimsObject claimsObject = claimsWBService.refuseClaimsAmount(claimNo);
		log.info("不同意理赔返回信息："+claimsObject.getErrorMessage()+" "+claimsObject.isSuccess());
	}

	private Paging<ClaimSubmitEntity> pageData(List<ClaimSubmitEntity> all,
			int pageSize, int pageNo) {
		int rowCount = all.size();
		//当总条数 小于开始条数，默认第一页  默认最后一页
		/*	if(rowCount < (pageNo - 1)*pageSize){
				pageNo = 1;
			}*/
		Paging<ClaimSubmitEntity> paging  = new Paging<ClaimSubmitEntity>();
		paging.setPageNo(pageNo);
		paging.setPageSize(pageSize);
		paging.setRowsCount(rowCount);
		//总页数
		int totalPages = rowCount/pageSize;
		paging.setPageCount(rowCount%pageSize == 0 ? totalPages:totalPages+1);
		int start = (pageNo - 1)*pageSize;
		int end = pageNo * pageSize;
		List<ClaimSubmitEntity> claimSubmitEntities = new ArrayList<ClaimSubmitEntity>();
		for(int i = start ; i < end ; i++){
			if(i > rowCount-1){
				break;
			}
			claimSubmitEntities.add(all.get(i));
		}
		paging.setData(claimSubmitEntities);
		return paging;
	}

	private List<ClaimSubmitEntity> wrapClaimSubmitEntities(
			List<QueryClaimsInfo> claimsInfos,String s) {
		List<ClaimSubmitEntity> claimSubmitEntities = new ArrayList<ClaimSubmitEntity>();
		for(QueryClaimsInfo claimsInfo:claimsInfos){
			ClaimSubmitEntity claimSubmitEntity = new ClaimSubmitEntity();
			claimSubmitEntity.setStatus(ClaimEnum.ALLSTATUS.get(claimsInfo.getDcEvent()));
			claimSubmitEntity.setBillNo(claimsInfo.getBillNo());
			claimSubmitEntity.setClaimNo(claimsInfo.getClaimsNo());
			claimSubmitEntity.setClaimsAmount(new BigDecimal(claimsInfo.getPayAmount()));
			claimSubmitEntity.setContactName(claimsInfo.getContactName());
			claimSubmitEntity.setCreateTime(new Date(claimsInfo.getCreateTime()));
			claimSubmitEntity.setClaimCompanyAddr(claimsInfo.getCityName());
			claimSubmitEntity.setClaimsTrackList(claimsInfo.getClaimsTrackList());
			claimSubmitEntity.setShowmodifyBtn(claimsInfo.isShowmodifyBtn());
			claimSubmitEntity.setRefuseStatus(claimsInfo.getRefuseStatus());
			/**
			 * @type:add
			 * @user:huyuzhou
			 * @date:2016年1月18日
			 * @auth:短信理赔需要字段
			 */
			claimSubmitEntity.setReason(claimsInfo.getReason());
			claimSubmitEntity.setContactTel(claimsInfo.getContactTel());
			/**
			 * end
			 */
			/**设置开户行信息，田育林，2016-06-07**/
			claimSubmitEntity.setAccountName(claimsInfo.getBankAccountName()); //设置开户名
			claimSubmitEntity.setAccountCode(claimsInfo.getBankAccount()); //设置银行卡号
			if(!StringUtil.isBlank(claimsInfo.getBankProvince()) && !StringUtil.isBlank(claimsInfo.getBankCity())){
				claimSubmitEntity.setAccountCity(claimsInfo.getBankProvince()+"-"+claimsInfo.getBankCity()); //设置开户行所在省市
			}
			claimSubmitEntity.setAccountBank(claimsInfo.getBankName()); //设置开户行名称
			/**-----------end--------------**/
			claimSubmitEntities.add(claimSubmitEntity);
			//释放图片的本地
			try {
//				if(s==null && !s.equals(ClaimEnum.LOCAL_CLAIM_STATUS_UN_SUBMIT)){
				   releaseImage(claimsInfo);
//				}
			} catch (Exception e) {
				//图片释放异常//TODO  XUJUN
				e.printStackTrace();
			}
		}
		return claimSubmitEntities;
	}

	private void releaseImage(QueryClaimsInfo claimsInfo) {
		String billNo = claimsInfo.getBillNo();
		String claimsNo = claimsInfo.getClaimsNo();
		//TODO  运单号 和 理赔单号不存在时，该接口存在异常。
		ResponseQueryFiles files = claimsWBService.findByClaimsPic(billNo, claimsNo);
		if(files != null && files.isSuccess()){
			//删除运单文件
			ClaimImageManage.deleteFile(billNo);
			QueryClaimsDetail claimsDetial = files.getQueryClaimsDetail();
			List<byte[]> bankCardpicFiles = claimsDetial.getBankCardPicFiles();//银行卡数据
			if(bankCardpicFiles !=null && bankCardpicFiles.size()>0){
				for(byte[] bt:bankCardpicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_BANK_CARDS);
				}
			}
			List<byte[]> shippingOrderPicFiles = claimsDetial.getShippingOrderPicFiles();//多张运单图片
			if(shippingOrderPicFiles !=null && shippingOrderPicFiles.size()>0){
				for(byte[] bt:shippingOrderPicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_WAYBILL_IMAGE);
				}
			}
			List<byte[]> damagePicFiles = claimsDetial.getDamagePicFiles();
			if(damagePicFiles !=null && damagePicFiles.size()>0){
				for(byte[] bt:damagePicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_GOODS_DAMAGED);
				}
			}
			List<byte[]> identificationCardPicFiles = claimsDetial.getIdentificationCardPicFiles();
			
			if(identificationCardPicFiles !=null && identificationCardPicFiles.size()>0){
				for(byte[] bt:identificationCardPicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_ID_CARDS);
				}
			}
			
			List<byte[]>  invoicePicFiles = claimsDetial.getInvoicePicFiles();

			if(invoicePicFiles !=null && invoicePicFiles.size()>0){
				for(byte[] bt:invoicePicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_INVOICE_COPY);
				}
			}
			
			List<byte[]> claimOrderPicFiles = claimsDetial.getClaimOrderPicFiles();//企业客户授权书，索赔函
			if(claimOrderPicFiles !=null && claimOrderPicFiles.size()>0){
				for(byte[] bt:claimOrderPicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_CLAIM_LETTER);
				}

			}
			
			List<byte[]> cargoReceiptPicFiles = claimsDetial.getCargoReceiptPicFiles();//到货签收凭证图片
			if(cargoReceiptPicFiles !=null && cargoReceiptPicFiles.size()>0){
				for(byte[] bt:cargoReceiptPicFiles){
					ClaimImageManage.iamgeStore(bt, billNo, ClaimEnum.IMAGE_TYPE_ARRIVE_SIGN_VOUCHER);
				}
			}
			
		}else{
			System.out.println(files.getErrorMessage());//TODO  //XUJUN
		}
	}

	/**
	 * 查询理赔信息
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	@Override
	public ClaimSubmitEntity queryClaimsInfo(String billNo, String claimsNo) {
		ResponseQueryFiles responseQueryFiles = claimsWBService.findByClaimsPic(billNo, claimsNo);
		String errMsg = responseQueryFiles.getErrorMessage();
		if(!StringUtil.isBlank(errMsg)){
			throw new OBHException(errMsg);
		}
		QueryClaimsDetail claimsDetial = responseQueryFiles.getQueryClaimsDetail();
		QueryClaimsInfo claimsInfo =responseQueryFiles.getQueryClaimsInfo();
		ClaimSubmitEntity claimSubmitEntity = wrapClaimSubmitEntity(claimsDetial,claimsInfo);
		return claimSubmitEntity;
	}

	private ClaimSubmitEntity wrapClaimSubmitEntity(
			QueryClaimsDetail claimsDetial, QueryClaimsInfo claimsInfo) {
		ClaimSubmitEntity claimSubmitEntity = new ClaimSubmitEntity();
		claimSubmitEntity.setAccidentType(ClaimEnum.ACCIDENT_TYPE.get(claimsInfo.getAccidentType()));
		claimSubmitEntity.setBillNo(claimsInfo.getBillNo());
		claimSubmitEntity.setBillTel(claimsInfo.getBillTel());
		claimSubmitEntity.setCargoType(ClaimEnum.CARGO_TYPE.get(claimsInfo.getGoodsName()));//
		claimSubmitEntity.setClaimCompanyAddr(claimsInfo.getCityName());//地址
		claimSubmitEntity.setClaimNo(claimsInfo.getClaimsNo());
		claimSubmitEntity.setClaimsAmount(new BigDecimal(claimsInfo.getPayAmount()));
		claimSubmitEntity.setContactMail(claimsInfo.getEmail());//联系人邮件    
		claimSubmitEntity.setContactName(claimsInfo.getContactName());
		claimSubmitEntity.setContactTel(claimsInfo.getContactTel());
		claimSubmitEntity.setCreateTime(new Date(claimsInfo.getCreateTime()));
		claimSubmitEntity.setExceptionCount(claimsInfo.getExceptionCount());
		claimSubmitEntity.setReason(claimsInfo.getReason());
		claimSubmitEntity.setClaimCompanyAddr(claimsInfo.getCityName());
		claimSubmitEntity.setClaimsTrackList(claimsInfo.getClaimsTrackList());
		/**设置开户行信息，田育林，2016-06-07**/
		claimSubmitEntity.setAccountName(claimsInfo.getBankAccountName()); //设置开户名
		claimSubmitEntity.setAccountCode(claimsInfo.getBankAccount()); //设置银行卡号
		claimSubmitEntity.setAccountCity(claimsInfo.getBankProvince()+"-"+claimsInfo.getBankCity()); //设置开户行所在省市
		claimSubmitEntity.setAccountBank(claimsInfo.getBankName()); //设置开户行名称
		/**-----------end--------------**/
		claimSubmitEntity.setImgMapString(ClaimImageManage.getAllImagePathByWaybill(claimsInfo.getBillNo()));
		return claimSubmitEntity;
	}

	@Override
	public void deleteClaimRecord(String waybill) {
		customerClaimDao.updateStatus(waybill,ClaimEnum.LOCAL_CLAIM_STATUS_DELETE);
	}

	@Override
	public void update(ClaimSubmitEntity claimSubmitEntity) {
		customerClaimDao.modifyClaim(claimSubmitEntity);
	}

	@Override
	public ClaimSubmitEntity findLocalClaimRecord(String billNo) {
		ClaimSubmitEntity claimSubmitEntity = new ClaimSubmitEntity();
		claimSubmitEntity.setBillNo(billNo);
		return queryClaim(claimSubmitEntity);
	}

	@Override
	public Paging<ClaimSubmitEntity> queryClaimsByUserId(
			ClaimSubmitEntity claimSubmitEntity, int pageSize, int pageNo) {
	List<ClaimSubmitEntity> all = new ArrayList<ClaimSubmitEntity>();
	    if(claimSubmitEntity.getStatus()==null||claimSubmitEntity.getStatus().equals("all")||claimSubmitEntity.getStatus().equals(ClaimEnum.LOCAL_CLAIM_STATUS_UN_SUBMIT)){
	    	//查询本地数据库中 状态未待提交的数据，这部分数据可以编辑 和 删除
	    	ClaimSubmitEntity claimEntity = new ClaimSubmitEntity();
			claimEntity.setEbccId(claimSubmitEntity.getEbccId());
			claimEntity.setBillNo(claimSubmitEntity.getBillNo());
			claimEntity.setStatus(ClaimEnum.LOCAL_CLAIM_STATUS_UN_SUBMIT);	
			List<ClaimSubmitEntity> localUnSubmit = customerClaimDao.queryClaims(claimEntity);
			if(localUnSubmit != null && localUnSubmit.size() > 0){
				for(int i= 0 ; i<localUnSubmit.size();i++){
					localUnSubmit.get(i).setStatus(ClaimEnum.ALLSTATUS.get(localUnSubmit.get(i).getStatus())); 
				}
				all.addAll(localUnSubmit);
			}
	    }
		//通过理赔接口查询数据
	    if(claimSubmitEntity.getStatus()==null || 
	    		(claimSubmitEntity.getStatus()!=null && !claimSubmitEntity.getStatus().equals(ClaimEnum.LOCAL_CLAIM_STATUS_UN_SUBMIT))){
	    	ResponseQueryClaims queryClaims = claimsWBService.getClaims(String.valueOf(claimSubmitEntity.getEbcuId()));
	    	String errMsg = queryClaims.getErrorMessage();
			if(!StringUtil.isBlank(errMsg)){
				throw new OBHException(errMsg);
			}
			List<QueryClaimsInfo> claimsInfos = queryClaims.getQueryClaimsInfos();
			if(claimsInfos != null && claimsInfos.size()>0){
				List<ClaimSubmitEntity> claimSubmitEntities = wrapClaimSubmitEntities(claimsInfos,claimSubmitEntity.getStatus());
				all.addAll(claimSubmitEntities);
			}
	    }
		//查询条件过滤(运单编号，状态)
		all = filter(all,claimSubmitEntity);
		//查询列表数据按照时间倒序排列，田育林，2016-05-24
		Collections.sort(all, new Comparator<ClaimSubmitEntity>() {
			@Override
			public int compare(ClaimSubmitEntity c1, ClaimSubmitEntity c2) {
				long t1 = c1.getCreateTime().getTime();
				long t2 = c2.getCreateTime().getTime();
				if(t1 > t2){
					return -1;
				}else if(t1 == t2){
					return 0;
				}else{
					return 1;
				}
			}
			
		});
		return pageData(all,pageSize,pageNo);
	}

	private List<ClaimSubmitEntity> filter(List<ClaimSubmitEntity> all,ClaimSubmitEntity claimSubmitEntity) {
		String waybill = claimSubmitEntity.getBillNo();
		String status = claimSubmitEntity.getStatus();
		/*********如果出现已退回、和未提交，只显示未提交 莫涛 2015年12月31日19:15:56*********/
		Map<String,ClaimSubmitEntity> map = new HashMap<String,ClaimSubmitEntity>();
		String key = "";
		for(int i = 0 ;i < all.size();i++){
			ClaimSubmitEntity entity = all.get(i);
			key = entity.getBillNo();
			if(map.get(key) == null){
				map.put(key, entity);
			}else{
				if(entity.getStatus() != null && entity.getStatus().equals("未提交")){
					map.put(key, entity);
				}
			}
		}
		if(map.size() > 0 && all.size() > 0){
			all.clear();
		}
		Set<Entry<String,ClaimSubmitEntity>> set = map.entrySet();
		Iterator<Entry<String,ClaimSubmitEntity>> it = set.iterator();
		while(it.hasNext()){
			Entry<String,ClaimSubmitEntity> entry = it.next();
			all.add(entry.getValue());
		}
		/*********如果出现已退回、和未提交，只显示未提交 莫涛 2015年12月31日19:15:56*********/
		
		if(StringUtil.isBlank(waybill) && StringUtil.isBlank(status)){
			return all;
		}
		
		if(StringUtil.isBlank(waybill) && status.equals("all")){
			return all;
		}
		
		List<ClaimSubmitEntity> claimSubmitEntities = new ArrayList<ClaimSubmitEntity>();
		//运单号过滤
		if(!StringUtil.isBlank(waybill)){
			for(ClaimSubmitEntity submitEntity:all){
				String bill = submitEntity.getBillNo();
				if(bill.equals(waybill)){
					claimSubmitEntities.add(submitEntity);
				}
			}
		}else{
			claimSubmitEntities = all;
		}
		
		//状态过滤s
		if(!StringUtil.isBlank(status) && !status.equals("all")){
			List<ClaimSubmitEntity> delEntities = new ArrayList<ClaimSubmitEntity>();
			String s[]=status.split(",");
			for(int i = 0; i < claimSubmitEntities.size(); i++){
				String sts = claimSubmitEntities.get(i).getStatus();
				for(int j=0;j<s.length;j++){
					status = ClaimEnum.ALLSTATUSQUERY.get(s[j]);
					if(sts == null || !sts.equals(status)){
						delEntities.add(claimSubmitEntities.get(i));
					}
				}
				
			}
			claimSubmitEntities.removeAll(delEntities);
		}
		return claimSubmitEntities;
	}

	/**
	 * 根据运单号校验此运单是否已经提交过理赔申请
	 * @param ebcuId, billNo
	 * @author 田育林
	 * @date 2016年5月9日
	 */
	@Override
	public String validExistBillNo(String ebcuId, String billNo) {
		String msg = "";
		ResponseQueryClaims queryClaims = claimsWBService.getClaims(ebcuId);
		String errMsg = queryClaims.getErrorMessage();
		if(!StringUtil.isBlank(errMsg)){
			throw new OBHException(errMsg);
		}
		List<QueryClaimsInfo> claimsInfos = queryClaims.getQueryClaimsInfos();
		if(claimsInfos!=null && claimsInfos.size()>0){
			for(QueryClaimsInfo claimsInfo : claimsInfos){
				if(billNo.equals(claimsInfo.getBillNo()) && !ClaimEnum.CLAIM_STATUS_CANCEL.toString().equals(claimsInfo.getDcEvent())){
					msg = "EXIST_CLAIM";
					break;
				}
			}
		}
		return msg;
	}

}
