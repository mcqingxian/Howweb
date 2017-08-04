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
import com.hoau.how.module.itf.server.dao.deptquery.DepartmentDao;
import com.hoau.how.module.itf.server.service.ICompanySyncService;
import com.hoau.how.module.itf.shared.domain.DepartmentEntity;

/**
 * 
 * @author 徐俊
 * @date 2015年6月24日
 */
@Service
public class CompanySyncService implements ICompanySyncService {
	private static final Log LOG = LogFactory.getLog(CompanySyncService.class);
	@Resource
	private DepartmentDao departmentDao;

	@Resource
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void companySync() {
		long versionNo = departmentDao.getLastVersionNo();
		String url;
		String reponseStr;
		if(versionNo == 0){
			url = ItfConifgConstant.DEPT_ALL;
			reponseStr = restTemplate.getForObject(url,String.class);
		}else{
			url = ItfConifgConstant.DEPT_INCREMENT;
			reponseStr = restTemplate.getForObject(url,String.class, versionNo);
		}
		
		ResponseBaseEntity<List<DepartmentEntity>> result = 
				JsonUtils.toObject(reponseStr, 
								   ResponseBaseEntity.class, 
								   List.class,
								   DepartmentEntity.class);
		
		if (RestErrorCodeConstants.STATUS_SUCCESS.equals(result.getErrorCode())) {
			List<DepartmentEntity> departmentEntitys = result.getResult();
			if (!CollectionUtils.isEmpty(departmentEntitys)) {
				updateDepts(versionNo, departmentEntitys);
			}
			LOG.info("同步行部门信息结束");
		} else {
			LOG.error("同步部门信息异常：" + result.getErrorMessage());
			throw new BusinessException("调用接口失败" + result.getErrorMessage());
		}
	}

	private void updateDepts(long versionNo,
			List<DepartmentEntity> departmentEntitys) {
		for (DepartmentEntity entity : departmentEntitys) {
			if(versionNo == 0){//全量 同步 ，不用判断是否存在，直接插入
				departmentDao.addDepartments(entity);
			}else{// 增量  要先判断是否存在，存在更新，不存在插入
				if(departmentDao.queryDepartmentByCode(entity.getDeptCode()) == null){
					departmentDao.addDepartments(entity);
				}else{
					departmentDao.updateDepartment(entity);
				}
			}
		}
	}

}
