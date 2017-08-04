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
import com.hoau.how.module.itf.server.dao.deptquery.OutBranchDao;
import com.hoau.how.module.itf.server.service.IOutBranchSyncService;
import com.hoau.how.module.itf.shared.domain.OutBranchEntity;

/**
 * @author 莫涛
 * @date 2015年8月18日
 */
@Service
public class OutBranchSyncService implements IOutBranchSyncService {
	private static final Log LOG = LogFactory.getLog(OutBranchSyncService.class);
	@Resource
	private OutBranchDao outBranchDao;
	@Resource
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void outBranchSync() {
		long versionNo = outBranchDao.getLastVersionNo();
		String url;
		String reponseStr;
		if(versionNo == 0){
			url = ItfConifgConstant.OUTBRANCH_ALL;
			reponseStr = restTemplate.getForObject(url,String.class);
		}else{
			url = ItfConifgConstant.OUTBRANCH_INCREMENT;
			reponseStr = restTemplate.getForObject(url,String.class, versionNo);
		}
		
		ResponseBaseEntity<List<OutBranchEntity>> result = 
				JsonUtils.toObject(reponseStr, 
								   ResponseBaseEntity.class, 
								   List.class,
								   OutBranchEntity.class);
		
		if (RestErrorCodeConstants.STATUS_SUCCESS.equals(result.getErrorCode())) {
			List<OutBranchEntity> outBranchEntitys = result.getResult();
			if (!CollectionUtils.isEmpty(outBranchEntitys)) {
				updateDepts(versionNo, outBranchEntitys);
			}
			LOG.info("同步偏线门店信息结束");
		} else {
			LOG.error("同步偏线门店信息异常：" + result.getErrorMessage());
			throw new BusinessException("调用接口失败" + result.getErrorMessage());
		}
	}

	private void updateDepts(long versionNo,
			List<OutBranchEntity> outBranchEntitys) {
		for (OutBranchEntity entity : outBranchEntitys) {
			if(versionNo == 0){//全量 同步 ，不用判断是否存在，直接插入
				outBranchDao.addBranchs(entity);
			}else{// 增量  要先判断是否存在，存在更新，不存在插入
				if(outBranchDao.queryOutBranchByCode(entity.getCode()) == null){
					outBranchDao.addBranchs(entity);
				}else{
					outBranchDao.updateOutBranch(entity);
				}
			}
		}
	}

}
