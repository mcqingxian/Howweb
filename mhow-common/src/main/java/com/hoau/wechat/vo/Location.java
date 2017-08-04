package com.hoau.wechat.vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class Location {
	
	@JsonProperty("Lng")
	private String lon;
	@JsonProperty("Lat")
	private String lat;
	
	
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
}
