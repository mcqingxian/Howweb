package com.hoau.how.module.bse.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.api.server.service.IBigEventService;
import com.hoau.how.module.bse.api.shared.exception.BigEventException;
import com.hoau.how.module.bse.api.shared.vo.BigEventVo;
import com.hoau.how.module.bse.server.dao.BigEventMapper;
import com.hoau.how.module.util.EmptyUtils;

/**
 * @author：张爱萍
 * @create：2015年6月17日 下午2:02:54
 * @description：
 */
@Service
@SuppressWarnings("rawtypes")
public class BigEventService implements IBigEventService{
	@Resource
	private BigEventMapper bigEventMapper;
	
	public List queryAllBigEventYears() {
		return bigEventMapper.selectAllYear();
	}
	
	@Override
	public List<BigEventVo> queryBigEvents() {
		List<BigEventVo> eventVoList = new ArrayList<BigEventVo>();
		List years = queryAllBigEventYears();
		if(EmptyUtils.isEmpty(years)){
			throw new BigEventException(BigEventException.BIGEVENT_YEARESNULL_EXCEPTION);
		}
		for(int i=0;i<years.size();i++){
			BigEventVo vo = new BigEventVo();
			int year = (Integer)years.get(i);
			vo.setYear(year);
			vo.setEvents(bigEventMapper.selectBigEventByYear(year));
			eventVoList.add(vo);
		}
		return eventVoList;
	}
}
