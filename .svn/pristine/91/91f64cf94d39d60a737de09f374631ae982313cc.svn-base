package com.hoau.wechat.service.impl;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.mhow.module.bse.api.server.service.IGetYdTraceManager;
import com.hoau.mhow.module.bse.api.shared.vo.GoodsTraceResultVo;
import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.service.IDeptService;
import com.hoau.wechat.service.IGoodsService;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.vo.GoodsTraceInfo;
import com.hoau.wechat.vo.TraceInfo;
import com.hoau.wechat.vo.TrackRecords;

@Service
public class GoodsService implements IGoodsService {

	//@Resource
	//private IGoodsTraceService goodsTraceService;
	
	/*@Resource
	private IGoodsTraceDao goodsTraceDao;*/
	
	@Resource
	private IDeptService deptService;
	
	@Resource
	private IGetYdTraceManager  getYdTraceManager;
	
	@Override
	public GoodsTraceResultVo queryGoodsTrack(String waybill) {
		//String wb = charTrans(waybill);
		//String traceInfoJsonStr = goodsTraceService.queryGoodsTrack(wb);
		List<String> transNos = new ArrayList<String>();
		transNos.add(waybill);
		GoodsTraceResultVo result = getYdTraceManager.getYdTraceList(transNos);
		//GoodsTraceInfo goodsTraceInfo = JsonUtils.toObject("", GoodsTraceInfo.class);
		
		//添加到最近查询运单列表
		//addWayBillToLatest(openId,waybill);
		return result;
	}
	
	/** 
	* @Title      :charTrans 
	* @Description:运单转换，如果为9位纯数字，将前2位转化为字母  01--A  02 ---B  26 --Z
	* @param      :@param waybill
	* @param      :@return   
	* @return     :String 
	* @date       :2014年6月11日 下午4:27:17   
	* @throws 
	*/
	private static String charTrans(String waybill) {
		String rtn = "";
		char first = waybill.charAt(0);
		char second = waybill.charAt(1);
		boolean isNumber = ('0' <= first && first <= '9') && ('0' <= second && second <= '9');
		if(waybill.length() == 9 && isNumber){
			//如果第一位为0，则去掉
			String sub = waybill.substring(0, 2);
			rtn = digital2letter(sub)+waybill.substring(2);
		}else{
			rtn = waybill;
		}
		return rtn.toUpperCase();
	}

	/** 
	* @Title      :digital2letter 
	* @Description:数字转换为 字母  1-A  26-Z
	* @param      :@param fs
	* @param      :@return   
	* @return     :String 
	* @date       :2014年6月11日 下午4:31:52   
	* @throws 
	*/
	private static String digital2letter(String fs) {
		String f = fs.charAt(0) == '0'? fs.substring(1):fs;
		char c = (char)(Integer.parseInt(f)+64);
		return ('A'<= c && c <='Z') ? String.valueOf(c):fs;
	}

	/*@Override
	public List<String> latestWaybill(String openId) {
		return goodsTraceDao.queryLatest(openId);
	}

	@Override
	public void addWayBillToLatest(String openId, String waybill) {
		goodsTraceDao.addWayBillToLatest(openId, waybill);
	}*/

	@Override
	public List<TraceInfo> trans(GoodsTraceInfo goodsTraceInfo2,boolean bool) {
		List<TraceInfo> infos = new ArrayList<TraceInfo>();
		List<TrackRecords> list = goodsTraceInfo2.getRecords();
		for(TrackRecords record : list){
			TraceInfo tinfo = new TraceInfo();
			tinfo.setTime(record.getTimeStamp());
			tinfo.setPostion(record.getCheckpoint());
			tinfo.setTraceInfo(parse(record,bool));
			infos.add(tinfo);
		}
		return infos;
	}

	private String parse(TrackRecords record,boolean bool) {
		//参数个数
		int pNum = Constant.paramNum.get(record.getStatusCode());
		//模板
		String template = Constant.msgTemplate.get(record.getStatusCode());
		//当前点
		String checkPoint = record.getCheckpoint();
		//下一个点
		String nextCheckpoint = record.getNextCheckpoint();
		//公司名
		String companyName = record.getCompanyName();
		//电话号码
		String phone = deptService.getPhoneByCompanyCode(record.getCompanyCode());
		String company_phone_Link = null;
		if(bool){
			company_phone_Link = "".equals(phone)?companyName:MsgUtils.toHyperlink(phone, companyName, Constant.LINK_TYPE_TEL);
		}else{
			company_phone_Link = companyName;
		}
		
		String rtn = "";
		switch (pNum) {
		case 0:
			rtn = template;
			break;
		case 1:
			rtn = MessageFormat.format(template, company_phone_Link);
			break;
		case 2:
			rtn = MessageFormat.format(template, checkPoint,nextCheckpoint);
			break;
		default:
			break;
		}
		return rtn;
	}

	public static void main(String[] args) throws ParseException {
//		String s = charTrans("112345678");
//		System.out.println(s);
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String strDate = "2014-04-25T08:00:00+08:00";
//		String[] a = strDate.split("T");
//		String strDate1 = a[0]+" "+a[1].split("\\+")[0];
//		
//		Date  date1 = df.parse(strDate1);
//		System.out.println(date1);
//		System.out.println(df.format(date1));
		System.out.println(charTrans("022345678"));
	}
}
