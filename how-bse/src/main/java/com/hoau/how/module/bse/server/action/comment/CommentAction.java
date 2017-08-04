package com.hoau.how.module.bse.server.action.comment;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.how.module.bse.api.server.service.ICommentService;
import com.hoau.how.module.bse.api.shared.domain.CommentEntity;
import com.hoau.how.module.bse.api.shared.vo.CommentQueryVo;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;

/**
 * 客户留言Action
 * @author：张爱萍
 * @create：2015年5月30日 下午3:51:02
 * @description：
 */
@Controller
@Scope("prototype")
public class CommentAction extends AbstractAction {
	private static final long serialVersionUID = -4857238206469887471L;

	private Logger logger = Logger.getLogger(CommentAction.class);
	
	/**
	 * 查询条件
	 */
	private CommentQueryVo commentQueryVo;
	private String categoryName;
	private Integer pageNo =1;
	private Integer pageSize;
	private long recordCount;
	// 用户输入验证码
	private String vercode;
	/**
	 * 客户输入留言信息
	 */
	private CommentEntity commentEntity;
	
	/**
	 * 查询留言信息结果List
	 */
	private List<CommentEntity> commentList;
	
	@Resource
	private ICommentService iCommentService;
	
	/**
	 * 校验验证码是否正确
	 * 
	 * @return
	 */
	private boolean checkVercode() {
		// 从Session中获取验证码
		ActionContext ctx = ActionContext.getContext();
		// 先根据session记录的imgCode检查用户输入的验证码
		String imgCode = (String) ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.VERCODE);
		ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.VERCODE, null);
		if (null != vercode && vercode.equalsIgnoreCase(imgCode)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 分页查询留言信息
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月1日
	 * @update
	 */
	public String queryComment(){
		try{
			commentList = iCommentService.queryCommentList(commentQueryVo, pageNo, pageSize);
			this.setRecordCount(iCommentService.countComment(commentQueryVo));
		}catch(BusinessException e){
			logger.info(e);
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 * 异步请求,返回json
	 * 增加留言信息
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月1日
	 * @update
	 */
	@JSON
	public String addComment(){
		if (checkVercode()) {
			try{
				HttpServletRequest request = ServletActionContext.getRequest();
//				String customerIp =  request.getLocalAddr();
				String customerIp = getIp(request);
				iCommentService.insertComment(commentEntity,customerIp);
			}catch(BusinessException e){
				return returnError(e);
			}
			return returnSuccess();
		}
		return returnError("验证码错误！");
	}
	
	public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
	

	public CommentQueryVo getCommentQueryVo() {
		return commentQueryVo;
	}

	public void setCommentQueryVo(CommentQueryVo commentQueryVo) {
		this.commentQueryVo = commentQueryVo;
	}

	public List<CommentEntity> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentEntity> commentList) {
		this.commentList = commentList;
	}

	public CommentEntity getCommentEntity() {
		return commentEntity;
	}

	public void setCommentEntity(CommentEntity commentEntity) {
		this.commentEntity = commentEntity;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	
	
}
