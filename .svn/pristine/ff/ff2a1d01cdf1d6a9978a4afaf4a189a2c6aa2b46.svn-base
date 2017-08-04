package com.hoau.how.module.bse.server.action;

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
import com.hoau.how.module.bse.api.server.service.IFranchiseService;
import com.hoau.how.module.bse.api.server.service.INewsService;
import com.hoau.how.module.bse.api.shared.domain.FranchiseCityEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseInfoEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseProvinceEntity;
import com.hoau.how.module.bse.api.shared.domain.NewsEntity;
import com.hoau.how.module.bse.api.shared.vo.FranchiseRegistrationVo;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.util.JsonUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * 特许经营Action
 * @author：张爱萍
 * @create：2015年6月23日 下午2:06:58
 * @description：
 */
@Controller
@Scope("prototype")
public class FranchiseAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = -1471022022285733897L;
	private Logger logger = Logger.getLogger(FranchiseAction.class);
	@Resource
	private IFranchiseService  iFranchiseService;
	@Resource
	private INewsService newsService;
	private String categoryName; 
	private FranchiseRegistrationVo registrationVo;
	private Integer pid;
	private List<FranchiseProvinceEntity> provinces;
	private List<FranchiseCityEntity> citys;
	// 用户输入验证码
	private String vercode;
	
	private String newsId;
	private NewsEntity newsDetail;
	
	//特许经营区域划分实体
	private FranchiseInfoEntity franchiseInfoEntity;
	private List<FranchiseProvinceEntity> franchiseInfoProvinces;
	private List<FranchiseCityEntity> franchiseInfoCitys;
	private String province;
	
	public String index(){
		try {
			newsDetail = newsService.queryNewsDetail(newsId);
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	/**
	 * 招商区域
	 * @return
	 * @author 莫涛
	 * @date 2016年6月24日下午3:18:39
	 * @update
	 */
	public String franchiseArea(){
		return SUCCESS;
	}
	
	/**
	 * 根据省市获取特许经营区域管理人员信息
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午9:04:29
	 * @update
	 */
	public String queryFranchiseInfoJson(){
		try{
			this.franchiseInfoEntity = iFranchiseService.queryFranchiseInfo(this.franchiseInfoEntity);
		}catch(Exception ex){
			logger.error("FranchiseAction Exception : " + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return "queryFranchiseInfoJson";
	}
	
	/**
	 * 获取特许经营省份
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午9:04:47
	 * @update
	 */
	public String queryFranchiseProvinceJson(){
		try{
			this.franchiseInfoProvinces = iFranchiseService.queryFranchiseProvince();
		}catch(Exception ex){
			logger.error("FranchiseAction Exception : " + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return "queryFranchiseProvinceJson";
	}
	
	/**
	 * 获取特许经营市区
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午9:04:58
	 * @update
	 */
	public String queryFranchiseCityJson(){
		try{
			this.franchiseInfoCitys = iFranchiseService.queryFranchiseCity(province);
		}catch(Exception ex){
			logger.error("FranchiseAction Exception : " + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return "queryFranchiseCityJson";
	}
	
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
	 * 获取省对应城市
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月24日
	 * @update
	 */
	@JSON
	public String getCity(){
		try {
			citys = iFranchiseService.queryCityByPid(pid);
			logger.info(JsonUtils.toJson(citys));
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 * 获取所有的省份
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月24日
	 * @update
	 */
	public String getAllProvice(){
		try {
			provinces = iFranchiseService.queryAllFranchiseProvince();
			logger.info(JsonUtils.toJson(provinces));
		} catch (BusinessException e) {
			return returnError(e);
		}
		return returnSuccess();
	}
	
	/**
	 * 保存报名信息
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月24日
	 * @update
	 */
	public String saveRigistInfo(){
		if(checkVercode()){
			try {
				logger.info(JsonUtils.toJson(registrationVo));
				HttpServletRequest request = ServletActionContext.getRequest();
				String customerIp =  request.getLocalAddr();
				iFranchiseService.saveFranchiseRegistInfo(registrationVo,customerIp);			
			} catch (BusinessException e) {
				return returnError(e);
			}
			return returnSuccess();
		}
		return returnError("验证码错误！");
	}

	public FranchiseRegistrationVo getRegistrationVo() {
		return registrationVo;
	}

	public void setRegistrationVo(FranchiseRegistrationVo registrationVo) {
		this.registrationVo = registrationVo;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<FranchiseProvinceEntity> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<FranchiseProvinceEntity> provinces) {
		this.provinces = provinces;
	}

	public List<FranchiseCityEntity> getCitys() {
		return citys;
	}

	public void setCitys(List<FranchiseCityEntity> citys) {
		this.citys = citys;
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

	public NewsEntity getNewsDetail() {
		return newsDetail;
	}

	public void setNewsDetail(NewsEntity newsDetail) {
		this.newsDetail = newsDetail;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public FranchiseInfoEntity getFranchiseInfoEntity() {
		return franchiseInfoEntity;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setFranchiseInfoEntity(FranchiseInfoEntity franchiseInfoEntity) {
		this.franchiseInfoEntity = franchiseInfoEntity;
	}

	public List<FranchiseProvinceEntity> getFranchiseInfoProvinces() {
		return franchiseInfoProvinces;
	}

	public List<FranchiseCityEntity> getFranchiseInfoCitys() {
		return franchiseInfoCitys;
	}
}
