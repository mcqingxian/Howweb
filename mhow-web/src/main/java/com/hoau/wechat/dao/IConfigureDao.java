package com.hoau.wechat.dao;

import java.util.List;

import com.hoau.wechat.vo.Configure;

public interface IConfigureDao {
	
	public void save(Configure configure);
	
	public List<Configure> findConfigureByType(String type);
	
	public List<Configure> findConfigureActive(String type);
	
	public Configure findConfigure(String key, String type);
}
