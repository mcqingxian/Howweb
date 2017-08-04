package com.hoau.how.module.bse.api.server.service;

import java.util.List;

import com.hoau.how.module.bse.api.shared.vo.BigEventVo;

/**
 * 大事记Service接口
 * @author：张爱萍
 * @create：2015年6月17日 下午1:42:52
 * @description：
 */
public interface IBigEventService {
	/**
	 * 查找公司大事记
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月17日
	 * @update
	 */
	public List<BigEventVo> queryBigEvents(); 
}
