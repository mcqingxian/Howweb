package com.hoau.how.module.itf.server.dao.deptquery;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.itf.shared.domain.DepartmentEntity;

/**
 *
 * @author 徐俊
 * @date 2015年6月24日
 */
@Repository
public interface DepartmentDao {

	public void addDepartments(DepartmentEntity departmentEntity);

	public List<DepartmentEntity> queryDeptsByVersion(long versionNo);

	public void deleteAllDepartment();
	
	public long getLastVersionNo();
	
	public void updateDepartment(DepartmentEntity departmentEntity);
	
	public DepartmentEntity queryDepartmentByCode(String deptCode);
}
