package com.hoau.how.module.util;



import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * Description: 判断非空帮助类
 * </p>
 * @author mx.yu
 * @version 1.0
 */
public class EmptyUtils {

  /**
   * 判断是否非空字符串
   * @param str 需要判断的字符串
   * @return boolean
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  /**
   * 判断是否为空字符串
   * @param str 需要判断的字符串
   * @return boolean
   */
  public static boolean isEmpty(String str) {
    return str == null || str.length() < 1 || str.equals("undefined");
  }

  /**
   * 判断参数中是否全为空字符串
   * @param args 需要判断的字符串
   * @return boolean
   */
  public static boolean isAllEmpty(String[] args) {
    if (args == null)
      return true;
    for (int i = 0; i < args.length; i++) {
      if (!isEmpty(args[i]))
        return false;
    }
    return true;
  }

  /**
   * 判断参数中是否有一个为空字符串
   * @param args 需要判断的字符串
   * @return boolean
   */
  public static boolean hasOneEmpty(String[] args) {
    if (args == null)
      return false;
    for (int i = 0; i < args.length; i++) {
      if (isEmpty(args[i]))
        return true;
    }
    return false;
  }

  /**
   * Trim后是否还是空的字符串
   * @param str 需要判断的字符串
   * @return boolean
   */
  public static boolean isTrimEmpty(String str) {
    return (isEmpty(str)) ? true : str.trim().length() < 1;
  }

  /**
   * 判断数组是否 非空并且数组长度不为零
   * @param arrs 需要判断的对象数组
   * @return boolean
   */
  public static boolean isNotEmpty(Object[] arrs) {
    return !isEmpty(arrs);
  }

  /**
   * 判断对象数组是否为null 或则为 0个记录的兑现数组
   * @param arrs 需要判断的对象数组
   * @return boolean
   */
  public static boolean isEmpty(Object[] arrs) {
    return arrs == null || arrs.length < 1;
  }

  /**
   * 判断Collection是否 不为null且长度大于零
   * @param colls 需要判断的Collection
   * @return boolean
   */
  public static boolean isNotEmpty(Collection colls) {
    return !isEmpty(colls);
  }

  /**
   * 判断Collection是否为null 或则为 0个记录的兑现数组
   * @param colls 需要判断的Collection
   * @return boolean
   */
  public static boolean isEmpty(Collection colls) {
    return colls == null || colls.isEmpty();
  }

  
  /**
   * 判断Map不为空，即不为null，size大于0
   * @param map 需要判断的Map实例
   * @return boolean
   */
  public static boolean isNotEmpty(Map map) {
    return ! isEmpty(map);
  }
  /**
   * 判断Map是否为null 或则为 0个记录
   * @param map 需要判断的Map实例
   * @return boolean
   */
  public static boolean isEmpty(Map map) {
    return map == null || map.isEmpty();
  }

  /**
   * 判断两个对象是否相等
   * @param obj1
   * @param obj2
   * @return
   */
  public static boolean isEqual(Object obj1, Object obj2) {
    if (obj1 == null && obj2 == null) {
      return true;
    } else if (obj1 == null && obj2 != null) {
      return false;
    } else if (obj2 == null && obj1 != null) {
      return false;
    } else {
      return obj1.equals(obj2);
    }
  }

  /**
   * 判断两个对象是否不相等
   * @param obj1
   * @param obj2
   * @return
   */
  public static boolean isNotEqual(Object obj1, Object obj2) {
    return !isEqual(obj1, obj2);
  }

}
