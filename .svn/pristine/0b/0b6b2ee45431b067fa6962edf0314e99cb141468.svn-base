package com.hoau.how.module.obh.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hoau.how.module.obh.server.service.IBatchOrderService;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.util.Paging;

/**
 * @author：莫涛
 * @create：2015年8月6日 上午11:20:28
 * @description：
 */
@Service
public class BatchOrderService implements IBatchOrderService {

	@Override
	public Paging<NetOrderEntity> pageQuery(List<NetOrderEntity> list,
			int pageSize, int pageNo) {
		Paging<NetOrderEntity> paging = new Paging<NetOrderEntity>();
		paging.setPageSize(pageSize);
		paging.setPageNo(pageNo);
		List<NetOrderEntity> data = new ArrayList<NetOrderEntity>();
		int start = (pageNo - 1) * pageSize;
		int end = pageNo * pageSize;
		if(start >= list.size()){
			start = list.size() - 1;
		}
		if(start < 0){
			start = 0;
		}
		if(end >= list.size()){
			end = list.size();
		}
		for(int i = start,index=1; i < end; i ++,index++){
			list.get(i).setNumber(index);
			data.add(list.get(i));
		}
		paging.setData(data);
		paging.setRowsCount(list.size());
		//总页数
		int totalPages = list.size()/pageSize;
		paging.setPageCount(list.size()%pageSize == 0 ? totalPages:totalPages+1);
		return paging;
	}
}
