package com.hoau.wechat.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.ISurveyService;
import com.hoau.wechat.vo.SurveyVo;

/**
 * 
 * @ClassName: SurveyAction 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月29日 下午2:33:29 
 *
 */
@Controller
@Scope("prototype")
public class SurveyAction extends BasicAction{
	//题目编号
	String codes;
	//选择的结果
	String values;
	
	@Resource
	private ISurveyService surveyService;
	
	/**
	 * 进行页面切换，跳转到下个题目
	
	public void gotoPage(){
		try {
			String val = "";
			if(!values.equals("null")){
				val = values + "," + value;
			}else{
				val = value;
			}
			request.setAttribute("values", val);
			request.getRequestDispatcher("pages/survey/survey_"+page+".jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 */
	public void submitSurvey(){
		try {
			SurveyVo vo = new SurveyVo();
			String v = values.substring(1);
			String c = codes.substring(1);
			vo.setValues(v);
			vo.setCodes(c);
			System.out.println("最终结果为："+c + "  :  " + v);
			surveyService.saveSurvey(vo);
			request.getRequestDispatcher("pages/survey/survey_detail.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setValues(String values) {
		this.values = values;
	}
	
	public void setCodes(String codes) {
		this.codes = codes;
	}

	public void setSurveyService(ISurveyService surveyService) {
		this.surveyService = surveyService;
	}
}
