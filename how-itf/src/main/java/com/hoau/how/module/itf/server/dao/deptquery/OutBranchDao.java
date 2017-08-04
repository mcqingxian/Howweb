package com.hoau.how.module.itf.server.dao.deptquery;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.itf.shared.domain.OutBranchEntity;

/**
 *
 * @author 莫涛
 * @date 2015年8月18日
 */
@Repository
public interface OutBranchDao {

	public void addBranchs(OutBranchEntity outBranchEntity);

	public List<OutBranchEntity> queryDeptsByVersion(long versionNo);

	public void deleteAllBranch();
	
	public long getLastVersionNo();
	
	public void updateOutBranch(OutBranchEntity outBranchEntity);
	
	public OutBranchEntity queryOutBranchByCode(String deptCode);
}
