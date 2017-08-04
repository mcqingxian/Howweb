package com.hoau.how.module.itf.server.dao.deptquery;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.itf.shared.domain.FranchiseEntity;

/**
 *
 * @author 莫涛
 * @date 2015年8月18日
 */
@Repository
public interface FranchiseDao {

	public void addFranchises(FranchiseEntity franchiseEntity);

	public List<FranchiseEntity> queryDeptsByVersion(long versionNo);

	public void deleteAllFranchise();
	
	public long getLastVersionNo();
	
	public void updateFranchise(FranchiseEntity franchiseEntity);
	
	public FranchiseEntity queryFranchiseByCode(String deptCode);
}
