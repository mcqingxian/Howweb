package com.hoau.how.module.bse.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.DownLoadEntity;

/**
 * @author：张爱萍
 * @create：2015年6月18日 上午10:24:02
 * @description：
 */
@Repository
public interface DownLoadMapper {
	/**
	 * 查询所有的下载资料
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月18日
	 * @update
	 */
	public List<DownLoadEntity> selectAllDownLoadRes();
}
