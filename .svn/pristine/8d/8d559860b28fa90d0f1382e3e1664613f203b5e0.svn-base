//package com.hoau.wechat.action;
//
//public class TransUtil {
//	
//	
//	String[]  infoStruct={
//		    {"A01","TraveInfo_A01",1,record.Checkpoint,NULL,""},
//		    {"A02","TraveInfo_A02",1,record.Checkpoint,NULL,""},
//		    {"A03","TraveInfo_A03",1,record.Checkpoint,NULL,""},
//		    {"A04","TraveInfo_A04",0,NULL,NULL,""},
//			{"B04","TraveInfo_B04",1,record.Checkpoint,NULL,""},
//			{"C01","TraveInfo_C01",2,record.Checkpoint, record.NextCheckpoint,""},
//			{"C02","TraveInfo_C02",2,record.Checkpoint, record.NextCheckpoint,""},
//			{"C03","TraveInfo_C03",2,record.Checkpoint, record.NextCheckpoint,""},
//			{"C04","TraveInfo_C04",2,record.Checkpoint, record.NextCheckpoint,""},
//			{"D01","TraveInfo_D01",1,record.Checkpoint,NULL,""},
//			{"D02","TraveInfo_D02",1,record.Checkpoint,NULL,""},
//			{"D03","TraveInfo_D03",1,record.Checkpoint,NULL,""},
//			{"D04","TraveInfo_D04",1,record.Checkpoint,NULL,""},
//			{"D05","TraveInfo_D05",0,NULL,NULL,""},
//			{"E04","TraveInfo_E04",1,record.Checkpoint,NULL,""},
//			{"F03","TraveInfo_F03",1,record.Checkpoint,NULL,""},
//			{"F04","TraveInfo_F04",1,record.Checkpoint,NULL,""},
//			{"End","End",0,NULL,NULL,""}};	
//}
//	    
//class  TraceInfoStruct{
//	String  traceType;
//	String  traceKey;
//	int type;  //0: key  1: str1  2:str1&str2
//	String str1;
//	String str2;
//	String detail;
//}
//
//class TraceInfoFormatUtil
//{
//    public static String format(CsgnTrackRecordEntity record)
//    throws NoSuchTraceTypeException
//	  {
//	if (record == null) {
//	  return "";
//	 }
// PropertyManager pm = PropertyManager.getInstance();
// String traceType = record.getTrackType();
// int i=0;
//while(1)
//{
//if(infoStruct[i].traceType.equals(traceType))
//{
// String key = infoStruct[i].traceKey;
// swich (infoStruct[i].type)
// {
//   case 0:
//    return pm.getValueByItemName(key);
//   case 1:
//    return pm.getValueByItemName(key, new String[] {infoStruct[i].str1});
//   case 2:
//    return pm.getValueByItemName(key, new String[] {infoStruct[i].str1,infoStruct[i].str2});
// }
// break;
//}
//else if(infoStruct[i].traceType.equals("End"))
//{
//  throw new NoSuchTraceTypeException("跟踪类型traceType=" + traceType + "没有匹配到错误！");
//  break;
//}
//i++;
//}
