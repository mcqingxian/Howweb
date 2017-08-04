package com.hoau.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @ClassName :BeanUtil
 * @Description:object <--> bean
 * @author :xujun cometzb@126.com
 * @date :2014年4月27日 下午10:40:01
 * 
 */
public class BeanUtil {
	
	/** 
	* @Title      :bean2DBObject 
	* @Description:把实体bean对象转换成DBObject 
	* @param      :@param bean
	* @param      :@return
	* @param      :@throws IllegalArgumentException
	* @param      :@throws IllegalAccessException   
	* @return     :DBObject 
	* @date       :2014年4月27日 下午10:42:52   
	* @throws 
	*/
	public static <T> DBObject bean2DBObject(T bean)
			throws IllegalArgumentException, IllegalAccessException {
	
		if (bean == null) {
			return null;
		}
		DBObject dbObject = new BasicDBObject();
		// 获取对象对应类中的所有属性域
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			// 获取属性名
			String varName = field.getName();
			if(varName.equals("serialVersionUID")){
				continue;
			}
			// 修改访问控制权限
			boolean accessFlag = field.isAccessible();
			if (!accessFlag) {
				field.setAccessible(true);
			}
			Object param = field.get(bean);
			if (param == null) {
				continue;
			} else if (param instanceof Integer) {// 判断变量的类型
				int value = ((Integer) param).intValue();
				dbObject.put(varName, value);
			} else if (param instanceof String) {
				String value = (String) param;
				dbObject.put(varName, value);
			} else if (param instanceof Double) {
				double value = ((Double) param).doubleValue();
				dbObject.put(varName, value);
			} else if (param instanceof Float) {
				float value = ((Float) param).floatValue();
				dbObject.put(varName, value);
			} else if (param instanceof Long) {
				long value = ((Long) param).longValue();
				dbObject.put(varName, value);
			} else if (param instanceof Boolean) {
				boolean value = ((Boolean) param).booleanValue();
				dbObject.put(varName, value);
			} else if (param instanceof Date) {
				Date value = (Date) param;
				dbObject.put(varName, value);
			}
			// 恢复访问控制权限
			field.setAccessible(accessFlag);
		}
		return dbObject;
	}

	
	/**
	 * @throws InstantiationException  
	* @Title      :dbObject2Bean 
	* @Description:把DBObject转换成bean对象
	* @param      :dbObject
	* @param      :bean
	* @param      :@return
	* @param      :@throws IllegalAccessException
	* @param      :@throws InvocationTargetException
	* @param      :@throws NoSuchMethodException   
	* @return     :T 
	* @date       :2014年4月27日 下午10:42:16   
	* @throws 
	*/
	public static <T> T dbObject2Bean(DBObject dbObject, Class<T> clazz)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {
		T bean = clazz.newInstance();
		if (bean == null) {
			return null;
		}
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			String varName = field.getName();
			Object object = dbObject.get(varName);
			if (object != null) {
				BeanUtils.setProperty(bean, varName, object);
			}
		}
		return bean;
	}
}
