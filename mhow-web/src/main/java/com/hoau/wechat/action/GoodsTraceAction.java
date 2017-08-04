package com.hoau.wechat.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.mhow.module.bse.api.shared.vo.GoodsTraceResultVo;
import com.hoau.mhow.module.bse.api.shared.vo.TraceInfoVo;
import com.hoau.wechat.service.IGoodsService;
import com.opensymphony.xwork2.Action;

@Controller
@Scope("prototype")
public class GoodsTraceAction implements Action{

	private String waybill;
	private String code;
	
	@Resource
	private IGoodsService goodsService;
	
	private GoodsTraceResultVo goodsTraceInfo;
	
	private List<String> waybills;
	
	private String noticeMsg;
	
	private List<TraceInfoVo> traceInfos;
	
	private String openId;
	
	@Override
	public String execute() throws Exception {
		try {
			goodsTraceInfo = goodsService.queryGoodsTrack(waybill);
			if(goodsTraceInfo.getTraceInfos() != null && goodsTraceInfo.getTraceInfos().size() > 0){
				traceInfos = goodsTraceInfo.getTraceInfos();
			}
			//traceInfos = goodsService.trans(goodsTraceInfo,true);
		} catch (Exception e) {
			noticeMsg = "运单号输入有误！";
			e.printStackTrace();
		}
		return SUCCESS;
	}
 
	public String waybillTrace() throws Exception {
		try {
			goodsTraceInfo = goodsService.queryGoodsTrack(waybill);
			if(goodsTraceInfo.getTraceInfos() != null && goodsTraceInfo.getTraceInfos().size() > 0){
				traceInfos = goodsTraceInfo.getTraceInfos();
			}
			//traceInfos = goodsService.trans(goodsTraceInfo,false);
		} catch (Exception e) {
			noticeMsg = "运单号输入有误！";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	public String toPage() throws Exception {
		//String openId = WeixinUtil.getOpenIdFromSession();
		//waybills = goodsService.latestWaybill(openId);
		return SUCCESS;
	}
	
	/*public String getLatestWaybill() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		waybills = goodsService.latestWaybill(openId);
		return SUCCESS;
	}*/
	
	public String getWaybill() {
		return waybill;
	}

	public void setWaybill(String waybill) {
		this.waybill = waybill;
	}


	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getWaybills() {
		return waybills;
	}

	public void setWaybills(List<String> waybills) {
		this.waybills = waybills;
	}

	public String getNoticeMsg() {
		return noticeMsg;
	}

	public void setNoticeMsg(String noticeMsg) {
		this.noticeMsg = noticeMsg;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public List<TraceInfoVo> getTraceInfos() {
		return traceInfos;
	}

	public void setTraceInfos(List<TraceInfoVo> traceInfos) {
		this.traceInfos = traceInfos;
	}
}
