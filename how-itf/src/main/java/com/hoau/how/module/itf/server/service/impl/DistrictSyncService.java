package com.hoau.how.module.itf.server.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.hbdp.webservice.components.rest.define.RestErrorCodeConstants;
import com.hoau.hbdp.webservice.components.rest.entity.ResponseBaseEntity;
import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.itf.server.dao.deptquery.DistrictDao;
import com.hoau.how.module.itf.server.service.IDistrictSyncService;
import com.hoau.how.module.itf.shared.domain.DistrictEntity;

/**
 *
 * @author 徐俊
 * @date 2015年6月24日
 */
@Service
public class DistrictSyncService implements IDistrictSyncService{
	private static final Logger log = LoggerFactory.getLogger(DistrictSyncService.class);
	@Resource
	private DistrictDao districtDao;
	
	@Resource
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void districtSync(){
		log.info("同步行政区域信息开始");
		long versionNo = districtDao.getLastVersionNo();
		String url;
		String reponseStr;
		if(versionNo == 0){
			url = ItfConifgConstant.DISTRICT_ALL;
			reponseStr = restTemplate.getForObject(url,String.class);
		}else{
			url = ItfConifgConstant.DISTRICT_INCREMENT;
			reponseStr = restTemplate.getForObject(url,String.class, versionNo);
		}
		ResponseBaseEntity<List<DistrictEntity>> result = JsonUtils.toObject(reponseStr, ResponseBaseEntity.class, List.class, DistrictEntity.class);
		if(RestErrorCodeConstants.STATUS_SUCCESS.equals(result.getErrorCode())){
			List<DistrictEntity> districts = result.getResult();
			if(!CollectionUtils.isEmpty(districts)){
				updateDistricts(versionNo, districts);
			}
			log.info("同步行政区域信息结束");
		}else{
			log.error("同步行政区域信息异常："+result.getErrorMessage());
			throw new BusinessException("调用接口失败"+result.getErrorMessage());
		}
	}

	private void updateDistricts(long versionNo, List<DistrictEntity> districts) {
		for (DistrictEntity entity : districts) {
			if(versionNo == 0){//全量 同步 ，不用判断是否存在，直接插入
				districtDao.addDistricts(entity);
			}else{// 增量  要先判断是否存在，存在更新，不存在插入
				if(districtDao.queryDistrictByCode(entity.getDistrictCode()) == null){
					districtDao.addDistricts(entity);
				}else{
					districtDao.updateDistrict(entity);
				}
			}
		}
	}
	
	/**
	 * 更新热门城市
	 */
	@Override
	public void updateHotCityNum(ConcurrentMap<String, Long> concurrentMap) {
		Set<Entry<String,Long>> entrySet = concurrentMap.entrySet();
		Iterator<Entry<String,Long>> it = entrySet.iterator();
		Map<String,Object> map = null;
		while(it.hasNext()){
			Entry<String,Long> entry = it.next();
			map = new HashMap<String,Object>();
			map.put("districtCode", entry.getKey());
			map.put("hotCityNum", entry.getValue());
			districtDao.updateHotCityNum(map);
		}
	}
}
