package com.hoau.wechat.vo;

/**
 * 
 * @ClassName: SurveyVo 
 * @Description: TODO vo
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月29日 下午2:29:49 
 *
 */
public class SurveyVo {
	//题目编号  1,2,3,4
	public String codes;
	//题目结果  A,B,C,D
	public String values;
	
	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}
}
