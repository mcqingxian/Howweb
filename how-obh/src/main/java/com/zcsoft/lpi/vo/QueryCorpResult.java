package com.zcsoft.lpi.vo;

public class QueryCorpResult implements java.io.Serializable
{

	private static final long serialVersionUID = 1498864803904163785L;
	private String gsbh;
	private String gsjc;
	private String csmc;
	private int js;
	private boolean isOverDue;

	public String getGsbh() {
		return gsbh;
	}

	public void setGsbh(String gsbh) {
		this.gsbh = gsbh;
	}

	public String getGsjc() {
		return gsjc;
	}

	public void setGsjc(String gsjc) {
		this.gsjc = gsjc;
	}

	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public boolean isOverDue() {
		return isOverDue;
	}

	public void setOverDue(boolean isOverDue) {
		this.isOverDue = isOverDue;
	}

}
