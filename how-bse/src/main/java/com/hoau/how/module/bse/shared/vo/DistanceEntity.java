package com.hoau.how.module.bse.shared.vo;

import java.io.Serializable;

public class DistanceEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private double value;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
