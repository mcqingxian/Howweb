package com.hoau.how.module.obh.server.service;

import com.hoau.how.module.obh.shared.domain.ClaimSubmitEntity;
import com.hoau.how.module.obh.shared.domain.ClaimValidEntity;
import com.hoau.how.module.obh.shared.util.Paging;

public interface IClaimService {
	/**
	 * 根据理赔单号，理赔方，校验 联系人电话是否匹配，
	 * @param claimValidEntity
	 * @return
	 * @author 张贞献
	 * @date 2015年8月19日
	 * @update 
	 */
	ClaimValidEntity validBillTel(ClaimValidEntity claimValidEntity);
	
	/**
	 * 根据理赔单号校验： 1：如果本地以及存在，状态为2(失败)，提示信息，理赔运单已提交或暂存
	 *             2：如果本地没有，掉接口校验也没有，状态为2  提示信息：理赔运单不存在
	 *             3：如果本地没有。调用接口有，返回  发货方公司所在地，收货方公司所在地，货物名称
	 *  
	 * @param billNo
	 * @return
	 * @author 张贞献
	 * @date 2015年8月19日
	 * @update 
	 */
	ClaimValidEntity validBillNo(String billNo/*,boolean isupdate*/);
	
	/**
	 * 提交(存为草稿怎知保存，不调用webservice接口)
	 * @param claimSubmitEntity
	 * @return
	 * @author 张贞献
	 * @date 2015年8月19日
	 * @update 
	 */
	void uploadClaim(ClaimSubmitEntity claimSubmitEntity);
	
	ClaimSubmitEntity queryClaim(ClaimSubmitEntity claimSubmitEntity);
		
	/**
	 * 理赔金额确认
	 * @param claimNo 理赔单号
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	public void confirmClaimsAmount(String claimNo);
	
	/**
	 * 不同意理赔
	 * add huyuzhou 2016年4月14日11:22:13
	 * @param claimNo
	 */
	public void refuseClaimsAmount(String claimNo);
	
	/**
	 * 获取用户理赔信息
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	public Paging<ClaimSubmitEntity> queryClaimsByUserId(ClaimSubmitEntity claimSubmitEntity,int pageSize,int pageNo);
	
	/**
	 * 删除未提交的理赔记录
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	public void deleteClaimRecord(String waybill);
	
	/**
	 * 查询理赔信息
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	public ClaimSubmitEntity queryClaimsInfo(String billNo,String claimsNo);

	/**
	 * 更新理赔单信息
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	void update(ClaimSubmitEntity claimSubmitEntity);


	/**
	 * 查询理赔单信息
	 * @param String amount
	 * @return
	 * @author 徐俊
	 * @date 2015年8月21日
	 * @update 
	 */
	ClaimSubmitEntity findLocalClaimRecord(String billNo);
	
	/**
	 * 根据运单号校验此运单是否已经提交过理赔申请
	 * @param billNo
	 * @author 田育林
	 * @date 2016年5月9日
	 */
	String validExistBillNo(String ebcuId, String billNo);
	
}
