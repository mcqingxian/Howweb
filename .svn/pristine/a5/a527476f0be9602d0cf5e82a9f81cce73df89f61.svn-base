package com.hoau.how.module.bse.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.how.module.bse.api.server.service.IFranchiseService;
import com.hoau.how.module.bse.api.shared.domain.FranchiseCityEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseInfoEntity;
import com.hoau.how.module.bse.api.shared.domain.FranchiseProvinceEntity;
import com.hoau.how.module.bse.api.shared.exception.FranchiseException;
import com.hoau.how.module.bse.api.shared.vo.FranchiseRegistrationVo;
import com.hoau.how.module.bse.server.dao.FranchiseMapper;
import com.hoau.how.module.util.mail.IMailHelper;
import com.hoau.how.module.util.mail.impl.MailHelper;

/**
 * 特许经营Service实现
 * @author：张爱萍
 * @create：2015年6月23日 下午2:08:21
 * @description：
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class FranchiseService implements IFranchiseService{
	
	@Resource
	private IMailHelper iMailHelper;
	
	@Resource
	private FranchiseMapper franchiseMapper;
	
	@Override
	public List<FranchiseProvinceEntity> queryAllFranchiseProvince() {
		return franchiseMapper.selectAllProvince();
	}
	@Override
	public List<FranchiseCityEntity> queryCityByPid(Integer pid) {
		if(pid == null){
			throw new FranchiseException(FranchiseException.FRANCHISE_PIDNULLXCEPTION);
		}
		return franchiseMapper.selectCitysByPid(pid);
	}
	/**
	 * 保存客户报名特许经营信息并发送邮件
	 */
	@Override
	public void saveFranchiseRegistInfo(FranchiseRegistrationVo registrationInfo,String customerIp) {
		if(registrationInfo==null){
			throw new FranchiseException(FranchiseException.FRANCHISE_REGISTINFONULLEXCEPTION);
		}
		//保存到数据库
		registrationInfo.setIp(customerIp);
		franchiseMapper.insertFranchiseInfo(registrationInfo);
		//封装邮件主题和内容
		String mailText = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>"
			+ "<body align='left'><h1>天地华宇特许经营申请信息</h1>"
			+ "<p><strong>申请省市：</strong><span style=\"color:#f00\">"+registrationInfo.getPname()+registrationInfo.getCname()+ "</span></p>"
			+ "<p><strong>申请地区：</strong><span style=\"color:#f00\">"+registrationInfo.getDistrict()+ "</span></p>"
			+ "<p><strong>公司/个人名称：</strong><span style=\"color:#f00\">"+registrationInfo.getName()+"</span></p>"
			+ "<p><strong>公司注册资金：</strong><span style=\"color:#f00\">"+registrationInfo.getMoney()+"</span></p>"
			+ "<p><strong>员工人数：</strong><span style=\"color:#f00\">"+registrationInfo.getEmployeeno()+"</span></p>"
			+ "<p><strong>联系人：</strong><span style=\"color:#f00\">"+registrationInfo.getContacts()+"</span></p>"
			+ "<p><strong>联系方式：</strong><span style=\"color:#f00\">"+registrationInfo.getTel()+"</span></p>"
			+ "<p><strong>email：</strong><span style=\"color:#f00\">"+registrationInfo.getEmail()+"</span></p>"
			+ "<p><strong>场地面积(㎡)：</strong><span style=\"color:#f00\">"+registrationInfo.getArea()+"</span></p>"
			+ "<p><strong>自有车辆：</strong><span style=\"color:#f00\">"+registrationInfo.getCar()+"</span></p>"
			+ "<p><strong>留言：</strong><span style=\"color:#f00\">"+registrationInfo.getMessage()+"</span></p></body></html>";
		String subject =  "【来自官网特许经营报名信息】"+registrationInfo.getPname()+registrationInfo.getCname()+"——"+registrationInfo.getContacts();
		//根据报名市id查找对应收邮件人
		List<String> emails = franchiseMapper.selectEmailsByCid(registrationInfo.getCid());
		for(String toUser:emails){
			//发送邮件
			iMailHelper.sendSimpleHtmlMail(MailHelper.FROM_USER, toUser, subject, mailText);
		}	
	}
	@Override
	public FranchiseInfoEntity queryFranchiseInfo(
			FranchiseInfoEntity franchiseInfoEntity) {
		List<FranchiseInfoEntity> list = franchiseMapper.queryFranchiseInfo(franchiseInfoEntity);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 查询特许经营省份
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午8:55:55
	 * @update
	 */
	public List<FranchiseProvinceEntity> queryFranchiseProvince(){
		return this.franchiseMapper.queryFranchiseProvince();
	}
	/**
	 * 根据省份信息查询特许经营市区
	 * @param province
	 * @return
	 * @author 莫涛
	 * @date 2015年12月29日下午8:55:59
	 * @update
	 */
	public List<FranchiseCityEntity> queryFranchiseCity(String province){
		return this.franchiseMapper.queryFranchiseCity(province);
	}
}
	
