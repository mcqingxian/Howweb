package com.hoau.how.module.bse.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.api.server.service.IDownLoadService;
import com.hoau.how.module.bse.api.server.service.IQuestionService;
import com.hoau.how.module.bse.api.shared.domain.DownLoadEntity;
import com.hoau.how.module.bse.api.shared.domain.QuestionEntity;

/**
 * 帮助与支持Action
 * @author：张爱萍
 * @create：2015年6月18日 上午10:22:48
 * @description：
 */
@Controller
@Scope("prototype")
public class HelpAndSupportAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 5565618901685961775L;
	@Resource
	private IDownLoadService iDownLoadService;
	private List<DownLoadEntity> downLoadResList;
	
	@Resource
	private IQuestionService iQuestionService;
	private List<QuestionEntity> questionList;
	private String questionKey;
	private String categoryName;
	
	/**
	 * 获取资料下载资源
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月18日
	 * @update
	 */
	public String getDownLoadRes(){
		try {
			downLoadResList = iDownLoadService.queryAllDownLoadRes();
		} catch (Exception e) {
			return ERROR;
		}
		return returnSuccess();
	}

	/**
	 * 获取常见问题
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年7月14日
	 * @update
	 */
	public String getCommonQuestion(){
		try {
			questionList = iQuestionService.queryQuestions(questionKey);
		} catch (Exception e) {
			return ERROR;
		}
		return returnSuccess();
	}
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<DownLoadEntity> getDownLoadResList() {
		return downLoadResList;
	}

	public void setDownLoadResList(List<DownLoadEntity> downLoadResList) {
		this.downLoadResList = downLoadResList;
	}

	public List<QuestionEntity> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionEntity> questionList) {
		this.questionList = questionList;
	}

	public String getQuestionKey() {
		return questionKey;
	}

	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}
	
	
	
}
