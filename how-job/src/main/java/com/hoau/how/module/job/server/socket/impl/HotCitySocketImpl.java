package com.hoau.how.module.job.server.socket.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.hoau.how.module.job.server.socket.IHotCitySocket;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * @author：莫涛
 * @create：2015年7月7日 上午11:24:47
 * @description：
 */
@Component
public class HotCitySocketImpl implements Runnable,IHotCitySocket{
	private static final Log LOG = LogFactory.getLog(HotCitySocketImpl.class);
	
	private ConcurrentMap<String, Long> concurrentMap = new ConcurrentHashMap<String, Long>();
	private ServerSocket serverSocket;
	private Lock lock = new ReentrantLock();
	
	public HotCitySocketImpl(){
		//启动线程
		new Thread(this).start();
		try {
			Properties properties = ConfigUtils.getConfig(ConfigConstants.HOT_CITY.CONFIG_NAME);
			Integer socket_port = Integer.parseInt(properties.getProperty(ConfigConstants.HOT_CITY.HOT_CITY_SOCKET_PORT));
			serverSocket = new ServerSocket(socket_port);
		} catch (IOException e) {
			LOG.error("HotCitySocketImpl IOException errorInfo : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void put(String key,Long value){
		try{
			lock.lock();
			if(concurrentMap.containsKey(key)){
				Long val = concurrentMap.get(key);
				val = val + value;
				concurrentMap.put(key, val);
			}else{
				concurrentMap.put(key, value);
			}
		}catch(Exception ex){
			LOG.error("HotCitySocketImpl put errorInfo : " + ex.getMessage());
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	@Override
	public void run() {
		Socket socket = null;
		BufferedReader bufferedReader = null;
		String key;
		Long value;
		while(true){
			try{
				if(serverSocket == null){
					continue;
				}
				socket = serverSocket.accept();
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(bufferedReader.ready()){
					String line = bufferedReader.readLine();
					if(line != null && !line.equals("")){
						String[] datas = line.split("\\|");
		                if(datas.length > 0){
		                	key = datas[0];
		                	value = Long.parseLong(datas[1]);
		                	this.put(key, value);
		                }
					}
				}
			}catch(Exception ex){
				LOG.error("HotCitySocket error : "+ex.getMessage());
				ex.printStackTrace();
			}finally{
				try{
					if(bufferedReader != null){
						bufferedReader.close();
					}
					if(socket != null){
						socket.close();
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}

	public Lock getLock() {
		return lock;
	}

	public ConcurrentMap<String, Long> getConcurrentMap() {
		return concurrentMap;
	}
	
	public void clearMap(){
		concurrentMap.clear();
	}
}