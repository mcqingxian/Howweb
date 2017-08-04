package com.hoau.how.module.itf.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.hbdp.webservice.components.rest.define.RestErrorCodeConstants;
import com.hoau.hbdp.webservice.components.rest.entity.ResponseBaseEntity;
import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.itf.server.dao.deptquery.FranchiseDao;
import com.hoau.how.module.itf.server.service.IFranchiseSyncService;
import com.hoau.how.module.itf.shared.domain.FranchiseEntity;

/**
 * @author 莫涛
 * @date 2015年8月18日
 */
@Service
public class FranchiseSyncService implements IFranchiseSyncService {
	private static final Log LOG = LogFactory.getLog(FranchiseSyncService.class);
	@Resource
	private FranchiseDao franchiseDao;

	@Resource
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void franchiseSync() {
		long versionNo = franchiseDao.getLastVersionNo();
		String url;
		String reponseStr;
		if(versionNo == 0){
			url = ItfConifgConstant.FRANCHISE_ALL;
			reponseStr = restTemplate.getForObject(url,String.class);
		}else{
			url = ItfConifgConstant.FRANCHISE_INCREMENT;
			reponseStr = restTemplate.getForObject(url,String.class, versionNo);
		}
		
		ResponseBaseEntity<List<FranchiseEntity>> result = 
				JsonUtils.toObject(reponseStr, 
								   ResponseBaseEntity.class, 
								   List.class,
								   FranchiseEntity.class);
		
		if (RestErrorCodeConstants.STATUS_SUCCESS.equals(result.getErrorCode())) {
			List<FranchiseEntity> franchiseEntitys = result.getResult();
			if (!CollectionUtils.isEmpty(franchiseEntitys)) {
				updateDepts(versionNo, franchiseEntitys);
			}
			LOG.info("同步特许经营门店信息结束");
		} else {
			LOG.error("同步特许经营门店信息异常：" + result.getErrorMessage());
			throw new BusinessException("调用接口失败" + result.getErrorMessage());
		}
	}

	private void updateDepts(long versionNo,
			List<FranchiseEntity> franchiseEntitys) {
		for (FranchiseEntity entity : franchiseEntitys) {
			if(versionNo == 0){//全量 同步 ，不用判断是否存在，直接插入
				franchiseDao.addFranchises(entity);
			}else{// 增量  要先判断是否存在，存在更新，不存在插入
				if(franchiseDao.queryFranchiseByCode(entity.getCode()) == null){
					franchiseDao.addFranchises(entity);
				}else{
					franchiseDao.updateFranchise(entity);
				}
			}
		}
	}
}
