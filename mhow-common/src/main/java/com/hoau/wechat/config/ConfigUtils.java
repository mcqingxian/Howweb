package com.hoau.wechat.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.hoau.hbdp.framework.shared.util.ConfigFileLoadUtil;
/**
 * 
 *
 * @author 莫涛
 * @date 2015年5月26日
 */
public class ConfigUtils {
	public static Properties getConfig(String configName){
		Properties properties = null;
		try {
			properties = ConfigFileLoadUtil.getPropertiesForClasspath(configName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
