package com.hoau.wechat.vo;

import java.util.List;


import org.codehaus.jackson.annotate.JsonProperty;

/** 
* @ClassName  :GoodsTraceInfo 
* @Description:货物跟踪信息 
* @author     :xujun cometzb@126.com	
* @date       :2014年4月25日 上午11:01:35 
*  
*/
public class GoodsTraceInfo {
	@JsonProperty("TicketID")
	private String ticketID;
	@JsonProperty("TrackRecords")
	private List<TrackRecords> records;
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public List<TrackRecords> getRecords() {
		return records;
	}
	public void setRecords(List<TrackRecords> records) {
		this.records = records;
	}
}
