package com.hoau.how.module.bse.server.service.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.api.server.service.IDownLoadService;
import com.hoau.how.module.bse.api.shared.domain.DownLoadEntity;
import com.hoau.how.module.bse.server.dao.DownLoadMapper;
import com.hoau.how.module.util.EmptyUtils;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * 资料下载中心Service层实现
 * @author：张爱萍
 * @create：2015年6月18日 下午1:59:40
 * @description：
 */
@Service
public class DownLoadService implements IDownLoadService {
	@Resource
	private DownLoadMapper downLoadMapper;
	
	Properties properties = ConfigUtils.getConfig(ConfigConstants.IMAGE.CONFIG_NAME);
	String uploadSrc = properties.getProperty(ConfigConstants.IMAGE.IMAGE_SRC);
	
	public List<DownLoadEntity> queryAllDownLoadRes(){
		List<DownLoadEntity> downloads = downLoadMapper.selectAllDownLoadRes();
		if(EmptyUtils.isNotEmpty(downloads)){
			for(DownLoadEntity d:downloads){
				d.setUrl(d.getUrl().replaceAll("/upload", uploadSrc+"upload"));
			}
		}
		return downloads;
	}
}
