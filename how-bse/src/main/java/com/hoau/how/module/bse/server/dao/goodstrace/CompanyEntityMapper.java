package com.hoau.how.module.bse.server.dao.goodstrace;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.common.shared.domain.CompanyEntity;



/**
 *
 * @author 徐俊
 * @date 2015年6月16日
 */
@Repository
public interface CompanyEntityMapper {
	

	/**
	 * 
	 * @param shortName
	 * @return
	 * @author 徐俊
	 * @date 2015年6月16日
	 * @update 
	 */
	public CompanyEntity selectCompanyByShortName(String shortName);
	
	
	/**
	 * 
	 * @param shortName
	 * @return
	 * @author 徐俊
	 * @date 2015年6月16日
	 * @update 
	 */
	public CompanyEntity selectCompanyByCode(String code);
}
