package com.hoau.wechat.util;

public class LogUtil
{
  public static String logFormat(Exception e)
  {
    StringBuffer buf = new StringBuffer();
    logFormat(e, buf);
    return buf.toString();
  }
  
  private static String logFormat(Throwable e, StringBuffer buf)
  {
    StackTraceElement[] exTrace = e.getStackTrace();
    buf.append(e.getClass()).append(":").append(e.getMessage()).append("\r\n");
    if (exTrace != null) {
      for (int i = 0; i < exTrace.length; i++) {
        buf.append("\t").append(exTrace[i].toString()).append("\r\n");
      }
    }
    if (e.getCause() != null)
    {
      buf.append("Caused by: ");
      logFormat(e.getCause(), buf);
    }
    return buf.toString();
  }
}

