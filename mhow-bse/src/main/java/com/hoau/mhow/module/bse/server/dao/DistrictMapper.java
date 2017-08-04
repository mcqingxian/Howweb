package com.hoau.mhow.module.bse.server.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.mhow.module.bse.api.shared.domain.DistrictEntity;

@Repository
public interface DistrictMapper {
	
	public List<DistrictEntity> queryAllAreas(String type);
	
	public String maxVersionNo();

}
