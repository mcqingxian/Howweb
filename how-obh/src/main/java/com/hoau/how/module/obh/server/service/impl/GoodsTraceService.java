package com.hoau.how.module.obh.server.service.impl;

import com.hoau.how.module.bse.shared.vo.GoodsTraceResultVo;
import com.hoau.how.module.bse.shared.vo.Route;
import com.hoau.how.module.bse.shared.vo.RouteResponse;
import com.hoau.how.module.bse.shared.vo.TraceInfoVo;
import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.itf.server.service.IDcWaybillInfoService;
import com.hoau.how.module.itf.server.service.IGetYdTraceManager;
import com.hoau.how.module.itf.server.ws.goodstrace.TraceInfo;
import com.hoau.how.module.itf.server.ws.goodstrace.YdTrace;
import com.hoau.how.module.itf.server.ws.waybilldetail.WaybillInfo;
import com.hoau.how.module.itf.server.ws.waybilldetail.WptYdInfo;
import com.hoau.how.module.obh.server.dao.GoodsTraceMapper;
import com.hoau.how.module.obh.server.service.IGoodsTraceService;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.vos.AntTaskListResult;
import com.hoau.how.module.util.EmptyUtils;
import com.hoau.how.module.util.JsonUtils;
import com.hoau.how.module.util.StringUtil;
import com.hoau.how.module.util.http.HttpUtil;
import com.hoau.how.module.util.mail.IMailHelper;
import com.hoau.how.module.util.mail.impl.MailHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author 徐俊
 * @date 2015年6月17日
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class GoodsTraceService implements IGoodsTraceService{
	@Resource
	private IGetYdTraceManager  getYdTraceManager;
	@Resource
	private IDcWaybillInfoService dcWaybillInfoService;
	@Resource
	private IMailHelper mailHelper;
	@Resource
	private GoodsTraceMapper goodsTraceMapper;
	@Resource
	private RestTemplate restTemplate;
	
	@Override
	public List<GoodsTraceResultVo> goodsTrace(String transNos) {
		//校验运单号
		try {
			Pattern p = Pattern.compile("^([a-zA-Z0-9]|\\d{2})\\d{7}$"); // 正则表达式
			Matcher m = p.matcher(transNos);
			if(m.matches()){
				List<GoodsTraceResultVo> list = wrapGoodsTraceResult(transNos);
				return list;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void querySfGoodsTraceResult(List<String> noList,List<YdTrace> traceList,List<WptYdInfo> infos) throws Exception{
		if(noList == null || noList.size() == 0){
			return;
		}
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < noList.size(); i++) {
			String wayBill = noList.get(i);
			if(wayBill == null){
				continue;
			}
			//网厅订单号为NO开头，顺丰运单号大于等于12位，则调用OMS查询货物轨迹接口
			if(wayBill.startsWith("NO") || wayBill.length() >= 12){
				list.add(wayBill);
			}
		}
		try{
			String params = StringUtil.join(list.toArray(), ",");
			String result = "";
			if(params != null && params.length() > 0){
			//调用OMS接口获取货物轨迹
				result = HttpUtil.httpGet(ItfConifgConstant.SF_OMS_TRANS_URL + "?params=" + params);
			}
			//查询订单信息
			List<NetOrderEntity> netOrders = new ArrayList<NetOrderEntity>();
			if(list.size() > 0){
				netOrders = this.goodsTraceMapper.queryOrderInfo(list);
			}
			if(result != null && !result.equals("")){
				List<RouteResponse> rsList = JsonUtils.toList(result, RouteResponse.class);
				if(rsList != null){
					for (int i = 0; i < rsList.size(); i++) {
						RouteResponse rs = rsList.get(i);
						YdTrace ydTrace = new YdTrace();
						if(rs.getMailno() != null && !rs.getMailno().equals("")){
							//设置订单号|运单号
							ydTrace.setConsignmentID(rs.getMailno());
						}else if(rs.getOrderid() != null && !rs.getOrderid().equals("")){
							//设置订单号|运单号
							ydTrace.setConsignmentID(rs.getOrderid());
						}
						
						List<TraceInfo> tranceInfos = new ArrayList<TraceInfo>();
						//设置货物状态，运输中、已签收、已发货等等
						for (int j = 0; j < netOrders.size(); j++) {
							NetOrderEntity netOrderEntity = netOrders.get(j);
							if(netOrderEntity.getEinoContractNo().equals(ydTrace.getConsignmentID())){
								TraceInfo traceInfo = new TraceInfo();
								traceInfo.setTraceInfo(netOrderEntity.getEinoStatus());
								tranceInfos.add(traceInfo);
							}
						}
						
						List<Route> routes = rs.getRoutes();
						//OMS回传的订单状态信息
						for (int j = 0; j < routes.size(); j++) {
							Route route = routes.get(j);
							TraceInfo traceInfo = new TraceInfo();
							traceInfo.setTraceInfo(route.getRemark());
							traceInfo.setTraceTime(route.getAcceptTime());
							tranceInfos.add(traceInfo);
						}
						
						//设置状态记录
						ydTrace.setTraceInfos(tranceInfos);
						//设置起运地和目的地
						for(int j = 0 ; j < netOrders.size() ; j ++){
							NetOrderEntity netOrderEntity = netOrders.get(j);
							if(netOrderEntity.getEinoContractNo().equals(ydTrace.getConsignmentID())){
								ydTrace.setQydmc(netOrderEntity.getEinoShipperEbplNameCn());
								ydTrace.setMddmc(netOrderEntity.getEinoConsigneeEbplNameCn());
								break;
							}
						}
						traceList.add(ydTrace);
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public String queryOneWaybill(String mobile,String date){
		WaybillInfo waybillInfo = dcWaybillInfoService.queryOneWaybill(mobile, date);
		return waybillInfo.getYDBH();
	}
	private List<GoodsTraceResultVo> wrapGoodsTraceResult(String transNos) {
		List<GoodsTraceResultVo> goodsTraceResultVos = new ArrayList<GoodsTraceResultVo>();
		if (EmptyUtils.isNotEmpty(transNos)){
			List<String> noList = StringUtil.textarea2List(transNos);
			//运单跟踪
			List<YdTrace> list =null;
			//货物信息
			List<WptYdInfo> infos = null;
			list = getYdTraceManager.getYdTraceList(noList);
			infos = dcWaybillInfoService.getYdinfos(noList);
			try{
				//查询顺丰货物轨迹
				querySfGoodsTraceResult(noList, list, infos);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			//提货公司信息
			if(list == null){
				return null;
			}
			for(YdTrace ydTrace : list){
				String waybill = ydTrace.getConsignmentID();
				waybill = translateWaybill(waybill);
				GoodsTraceResultVo resultVo = new GoodsTraceResultVo();
				//运单号
				resultVo.setWaybillNo(waybill);
				//查询安装平台服务类型2016年8月25日19:43:34 King
				try{
					//如果是易安装的运单，则调用安装服务系统获取该运单的服务类型2016年8月25日19:43:34 King
					if(ydTrace.getYslx() != null && ydTrace.getYslx().equals("易-安装")){
						String url = ItfConifgConstant.ANT_TASKLIST_INFO_URL;
						AntTaskListResult result = restTemplate.getForObject(url,AntTaskListResult.class, waybill);
						if(result != null && result.getErrorCode() != null && result.getErrorCode().equals("1000")){
							//设置易安装服务类型2016年8月25日19:43:34 King
							resultVo.setServiceType(result.getResult());
						}
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
				//跟踪记录,对跟踪记录进行数据处理
				List<TraceInfoVo> traceInfoVos = traceInfo(ydTrace.getTraceInfos(),resultVo.getServiceType());
				resultVo.setTraceInfos(traceInfoVos);
				//---------------货物基本信息				
				resultVo.setFromCity(ydTrace.getQydmc());
				resultVo.setToCity(ydTrace.getMddmc());
				resultVo.setTransMethod(ydTrace.getYslx());
				resultVo.setPickUpMethod(ydTrace.getThfs());
				if(infos!=null){
					//  重量 体积 货物名称 件数
					for(WptYdInfo wptYdInfo : infos){
						String wptYDBH = wptYdInfo.getYDBH();
						double weight = wptYdInfo.getZL();
						double volumn = wptYdInfo.getTJ();
						double pieces = wptYdInfo.getJS();
						String goodName = wptYdInfo.getHWMC();
						if(translateWaybill(wptYDBH).equalsIgnoreCase(waybill)){
							resultVo.setWeight(weight+"KG");
							resultVo.setVolume(volumn+"方");
							resultVo.setGoodsName(goodName);
							resultVo.setPieces(pieces+"件");
						}
					}
				}
				//---------------提货公司信息
				resultVo.setPickUpCompanyName(ydTrace.getThgsmc());
				resultVo.setPickUpCompanyAddress(ydTrace.getThgsdz());
				resultVo.setPickUpCompanyPhone(ydTrace.getThgsdh());
				resultVo.setCustomerServicePhone(ydTrace.getThgskfDh());
				goodsTraceResultVos.add(resultVo);
			}
		}
		return goodsTraceResultVos;
	}

	private String translateWaybill(String waybill) {
		int length = waybill.length();
		if(length == 9){
			int a = Integer.valueOf(waybill.substring(0, 2))+64;
			char c = (char)a;
			return c+waybill.substring(2);
		}else{
			return waybill;
		}
	}
	
	/**
	 * 
	 * 
	 * @param traceInfos 跟踪记录
	 * @param serviceType 服务类型（支装一体，支装分离）
	 * @return
	 * @author 莫涛
	 * @date 2016年8月25日21:28:11
	 * @update
	 * 
	 * A01 收件扫描
		A02 上门提货录单
		A03 客户自送录单
		A04 运单录入后删除
		B04 发货一级公司接上转
		C01 发货公司发货
		C02 发货公司发货（前往中转）
		C03 中转公司发货
		C04 中转公司发货（前往中转）
		C05 货物外发
		D01 中转公司到车
		D02 到货公司到车
		D03 中转公司到货
		D04 到货公司到货
		E04 分单确认公司接下转
		D05 取消发车后的中转
		F03 到货
		F04 送货上门签收
		G01 平台已经认领
		G02 平台预约安装完成
		G04 安装已完成
	 */
	private List<TraceInfoVo> traceInfo(List<TraceInfo> traceInfos,String serviceType) {
		List<TraceInfoVo> infoVos = new ArrayList<TraceInfoVo>();
		List<TraceInfoVo> resultVos = new ArrayList<TraceInfoVo>();
		int size = traceInfos.size();
		boolean flag = true;
		boolean isWaybill = true;
		Map<String,TraceInfo> map = new HashMap<String,TraceInfo>();
		//将所有状态封装到map中，以code作为key
		try{
			for(int i = 0 ; i < traceInfos.size() ; i ++){
				TraceInfo info = traceInfos.get(i);
				map.put(info.getTrackType(), info);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		TraceInfoVo g01Info = null;
		TraceInfoVo g02Info = null;
		TraceInfoVo h01Info = null;
		for(int i = size-1; i >= 0 ;i--){
			TraceInfo t =  traceInfos.get(i);
			TraceInfoVo traceInfoVo = new TraceInfoVo();
			String trackType = t.getTrackType();
			//将编码保留
			traceInfoVo.setTrackType(trackType);
			/**************易安装，货物轨迹逻辑展示处理开始，主要处理，客户签收状态，如果是易安装的，则显示需要改变***************/
			if(serviceType != null){
				if(serviceType.equals("支装一体") && (trackType.equals("F03") || trackType.equals("F04"))){
					//【在番禺已派安装师傅】，并已提货出库，待送货安装中
					if(map.get("G01")!=null) {
						String str = map.get("G01").getTraceInfo();
						str = str.replace("已派", "");
						//【在番禺安装师傅】已提货出库，待送货安装中
						String info = str + "已提货出库，待送货安装中";    //认领
						t.setTraceInfo(info);
					}
				}else if(serviceType.equals("支装分离") && (trackType.equals("F03") || trackType.equals("F04"))){
					t.setTraceInfo(t.getTraceInfo() + "，待上门安装中");
				}
			}
			/**************易安装，货物轨迹逻辑展示处理结束，主要处理，客户签收状态，如果是易安装的，则显示需要改变***************/
			String trace = t.getTraceInfo();
			//顺丰货物轨迹中，该描述不在这里传递，主要是怕数据被覆盖，所以做非空判断
			if(trace != null && !trace.equals("")){
				traceInfoVo.setDesc(trace);
			}
			//G04 G02 H01显示他的remark
			if(trackType.equals("G04") || trackType.equals("G02") || trackType.equals("H01")){
				traceInfoVo.setDesc(t.getRemark());
			}
			//顺丰货物轨迹中，该时间不在这里传递，主要是怕数据被覆盖，所以做非空判断
			if(t.getTraceTime() != null && !t.getTraceTime().equals("")){
				traceInfoVo.setTime(t.getTraceTime());
			}
			//只留一个运输中
			String transStatus = getStatus(trace,flag,isWaybill,trackType);
			if(transStatus.equals("运输中")){
				flag = false;
			}
			if(transStatus.equals("已开单")){
				isWaybill = false;
			}
			traceInfoVo.setStatus(transStatus);//TODO 运输状态 定义
			//如果当前状态为【已派安装师傅】，但是没有签收状态，则不将该已派安装师傅跟踪记录加进去
			if(trackType.equals("G01")){
				//否则将这条记录暂存，直接追加到签收后面
				if(map.containsKey("F04") == false && map.containsKey("F03") == false){
					continue;
				}else{
					g01Info = traceInfoVo;
					continue;
				}
			}
			if(trackType.equals("G02")){
				//否则将这条记录暂存，直接追加到签收后面
				if(map.containsKey("F04") == false && map.containsKey("F03") == false){
					continue;
				}else{
					g02Info = traceInfoVo;
					continue;
				}
			}
			//安装已完成状态，不加入集合中，因为如果存在的话，是固定要加到最后一个状态中的
			if(!trackType.equals("H01") && !trackType.equals("G04")){
				infoVos.add(traceInfoVo);
			}else{
				h01Info = traceInfoVo;
			}
		}
		//安装已完成不为空的情况下，始终加到最后一条记录
		if(h01Info != null){
			resultVos.add(h01Info);
		}
		/********************已派安装师傅这条记录始终要加到签收后面，存在签收的情况下***********************/
		for(int i = 0; i < infoVos.size() ;i++){
			TraceInfoVo vo = infoVos.get(i);
			String trackType = vo.getTrackType();
			if(g01Info != null && (trackType.equals("F04") || trackType.equals("F03"))){
				//如果存在预约记录，先把预约加进来
				if(g02Info != null){
					resultVos.add(g02Info);
				}
				g01Info.setDesc("已指派安装师傅");
				resultVos.add(g01Info);
			}
			resultVos.add(vo);
		}
		return resultVos;
	}

	//TODO 垃圾代码
	private String getStatus(String trace,boolean isTrans,boolean isWaybill,String trackType) {
		String result = "";
		if(isTrans && trace.contains("到达")){
			result = "运输中";
		}
		if(trace.contains("录单") || trace.contains("收件扫描") || trace.contains("办理托运")){
			if(isWaybill){
				result = "已开单";
			}else{
				result = "";
			}
		}/*else if(trace.contains("签收")){
			result = "已签收";
		}*/else if(trace.contains("到达") && (trace.contains("分公司") || trace.contains("平台"))){
			result = "已到达";
		}else if(trackType.equals("F04") || trackType.equals("F03")){
			result = "已签收";
		}else if(trackType.equals("H01") || trackType.equals("G04")){
			result = "已安装";
		}
		return result;
	}


	@Override
	public void sendEmail(String waybills, String emailAddress) {
		mailHelper.sendSimpleMail(MailHelper.FROM_USER,emailAddress,"运单跟踪", waybills);
	}

}
