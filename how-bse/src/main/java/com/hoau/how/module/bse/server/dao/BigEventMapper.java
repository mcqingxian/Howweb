package com.hoau.how.module.bse.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.BigEventEntity;

/**
 * @author：张爱萍
 * @create：2015年6月17日 下午2:04:08
 * @description：
 */
@Repository
public interface BigEventMapper {
	/**
	 *
	 * 按年份查找大事记
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月17日
	 * @update
	 */
	public List<BigEventEntity> selectBigEventByYear(int year);
	
	/**
	 * 查找大事记所有年份
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月17日
	 * @update
	 */
	@SuppressWarnings("rawtypes")
	public List selectAllYear();
	
}
