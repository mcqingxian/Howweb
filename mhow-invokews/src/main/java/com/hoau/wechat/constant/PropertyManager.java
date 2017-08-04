package com.hoau.wechat.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hoau.wechat.util.LogUtil;
import com.hoau.wechat.utils.NetUtil;

public class PropertyManager {
	private static Log log = LogFactory.getLog(NetUtil.class);
	private Properties property = new Properties();

	public static PropertyManager load(String[] configFileNames,
			Class loaderClass) {
		return new PropertyManager(configFileNames, loaderClass);
	}

	private PropertyManager(String[] configFileNames, Class loaderClass) {
		for (int i = 0; i < configFileNames.length; i++) {
			loadFile(configFileNames[i], loaderClass);
		}
	}

	private void loadFile(String p_fileName, Class loaderClass) {
		InputStream fin = null;
		try {
			fin = loaderClass.getResourceAsStream(p_fileName);
			this.property.load(fin);
			return;
		} catch (IOException ex) {
			log.error(LogUtil.logFormat(ex));
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					log.error(LogUtil.logFormat(e));
				}
			}
		}
	}

	public String getString(String p_itemName) {
		return this.property.getProperty(p_itemName);
	}

	public String getString(String p_itemName, String... args) {
		String value = getString(p_itemName);
		if ((value != null) && (args != null)) {
			for (int i = 0; i < args.length; i++) {
				value = value.replace("{" + i + "}", args[i] == null ? ""
						: args[i]);
			}
		}
		return value;
	}

	public int getInt(String p_itemName) {
		String value = getString(p_itemName);
		int intValue = 0;
		try {
			intValue = new Integer(value).intValue();
		} catch (NumberFormatException e) {
			log.error(LogUtil.logFormat(e));
		}
		return intValue;
	}

	public Properties getProperties() {
		return this.property;
	}
}
