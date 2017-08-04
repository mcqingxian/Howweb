package com.hoau.how.module.bse.shared.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

/**
 * 
* <p>Title: RouteResponse</p>
* <p>Description: </p>
* <p>Company: HOAU</p> 
* @author lanhong zhang
* @date 2015年12月20日
 */
@XmlType
public class RouteResponse {
	/**
	 * 顺丰运单号
	 */
	private String mailno;
	/**
	 * 客户订单号，按客户订单号查询时为
	 *	必填。按顺丰运单号查询时为空。
	 */
	private String orderid;  
	/**
	 * 物流轨迹
	 */
	private List<Route> routes;
	
	@XmlAttribute(name="mailno")
	public String getMailno() {
		return mailno;
	}
	public void setMailno(String mailno) {
		this.mailno = mailno;
	}
	@XmlAttribute(name="orderid")
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@XmlElements(value = { @XmlElement(name = "Route", type = Route.class) })
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
}
