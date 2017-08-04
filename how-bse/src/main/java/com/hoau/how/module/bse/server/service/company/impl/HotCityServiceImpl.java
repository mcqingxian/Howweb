package com.hoau.how.module.bse.server.service.company.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.hoau.how.module.bse.server.service.company.IHotCityService;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;

/**
 * @author：莫涛
 * @create：2015年7月7日 下午4:51:31
 * @description：
 */
@Component
public class HotCityServiceImpl implements Runnable,IHotCityService {
	private ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100000);
	private static final Log LOG = LogFactory.getLog(HotCityServiceImpl.class);
	private Socket socket;
	Properties properties = ConfigUtils.getConfig(ConfigConstants.HOT_CITY.CONFIG_NAME);
	String socketUrl = properties.getProperty(ConfigConstants.HOT_CITY.HOT_CITY_SOCKET_URL);
	Integer socket_port = Integer.parseInt(properties.getProperty(ConfigConstants.HOT_CITY.HOT_CITY_SOCKET_PORT));
	private Integer length = 100;
	private Lock lock = new ReentrantLock();
	public HotCityServiceImpl(){
		try {
			new Thread(this).start();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true){
			try{
				if(queue.size() >= length){
					sendHotCityData();
				}
				Thread.sleep(1000 * 10);
			}catch(Exception ex){
				LOG.error("HotCityServiceImpl run error : " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 拼接数据，并发送
	 * @author 莫涛
	 * @date 2015年7月7日
	 * @update
	 */
	private void sendHotCityData(){
		StringBuffer sb = new StringBuffer();
		OutputStream output = null;
		try{
			for(int i=0 ; i < length ; i ++){
				String data = queue.poll();
				if(data != null){
					sb.append(data).append("\r\n");
				}
			}
			if(socket == null || socket.isClosed()){
				socket = new Socket(socketUrl, socket_port);
			}
			output = socket.getOutputStream();
			output.write(sb.toString().getBytes());
		}catch(Exception ex){
			LOG.error("HotCityServiceImpl sendHotCityData error : " + ex.getMessage());
			ex.printStackTrace();
		}finally{
			try {
				if(output != null){
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void putHotCity(String districtCode) {
		try{
			lock.lock();
			queue.put(districtCode + "|" + 1);
		}catch(Exception ex){
			LOG.error("HotCityServiceImpl putHotCity error : " + ex.getMessage());
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}