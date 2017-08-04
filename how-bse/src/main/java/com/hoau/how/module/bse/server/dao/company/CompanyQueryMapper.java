package com.hoau.how.module.bse.server.dao.company;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.itf.shared.domain.DepartmentEntity;


/**
 *
 * @author 莫涛
 * @date 2015年6月25日
 */
@Repository
public interface CompanyQueryMapper{
	public List<DepartmentEntity> queryDeptName(String logistName);
	public List<DepartmentEntity> queryDeptNames(List<String> logistNames);
}