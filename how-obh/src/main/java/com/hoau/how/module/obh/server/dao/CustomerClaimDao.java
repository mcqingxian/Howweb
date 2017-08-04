package com.hoau.how.module.obh.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hoau.how.module.obh.shared.domain.ClaimSubmitEntity;

/**
 * @author：张贞献
 * @create：2015年8月20日 下午4:26:41
 * @description：
 */
@Repository
public interface CustomerClaimDao {
    /**
     *  根据单号修改
     * @param claimSubmitEntity
     * @author 张贞献
     * @date 2015年8月20日
     * @update 
     */
    void modifyClaim(ClaimSubmitEntity claimSubmitEntity);
    
    /**
     * 新增理赔
     * @param claimSubmitEntity
     * @author 张贞献
     * @date 2015年8月20日
     * @update 
     */
    void saveClaim(ClaimSubmitEntity claimSubmitEntity);
    
    /**
     * 查询用户下未提交的理赔记录
     * @param claimSubmitEntity
     * @return
     * @author 张贞献
     * @date 2015年8月20日
     * @update 
     */
    List<ClaimSubmitEntity> queryClaims(ClaimSubmitEntity claimSubmitEntity);
    
    /**
     * 删除未提交的理赔单记录（逻辑删除）
     * @param claimSubmitEntity
     * @return
     * @author 张贞献
     * @date 2015年8月20日
     * @update 
     */
    void updateStatus(@Param("waybill")String waybill,@Param("status")String status);
    
    /**
     * 更加单号查是否存在
     * @param billNo
     * @return
     * @author 张贞献
     * @date 2015年8月21日
     * @update 
     */
    int queryClaimCount(String billNo);
    
    
}
