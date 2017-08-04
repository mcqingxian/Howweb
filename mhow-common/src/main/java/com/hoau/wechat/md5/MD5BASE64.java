package com.hoau.wechat.md5;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

/**
 * @author：莫涛
 * @create：2015年7月15日 下午5:17:49
 * @description：
 */
public class MD5BASE64 {
	/**
	 * 
	 * @Title: base64MD5 
	 * @Description: TODO 
	 * @param @param plainText
	 * @param @param charset
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String base64MD5(String plainText,String charset){
		String result = "";
      try {
         MessageDigest md = MessageDigest.getInstance("MD5");
         md.update(plainText.getBytes(charset));
         byte b[] = md.digest();
         int i;
         StringBuffer buf = new StringBuffer("");
         for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
               i += 256;
            if (i < 16)
               buf.append("0");
            buf.append(Integer.toHexString(i));
         }
         result = new String(Base64.encodeBase64(buf.toString().getBytes(charset)), charset);
      } catch (Exception e) {
    	  e.printStackTrace();
      }
      return result;
   }
	
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(MD5BASE64.base64MD5("1234","UTF-8"));
	}
}
