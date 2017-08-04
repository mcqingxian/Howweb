package com.hoau.how.module.obh.server.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.common.constants.ContactsType;
import com.hoau.how.module.common.constants.ItfConifgConstant;
import com.hoau.how.module.obh.server.dao.ContactsEntityMapper;
import com.hoau.how.module.obh.server.dao.UnpayMentEntityMapper;
import com.hoau.how.module.obh.server.service.IContactsService;
import com.hoau.how.module.obh.shared.domain.ContactsDcEntity;
import com.hoau.how.module.obh.shared.domain.ContactsEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.domain.UnpayMentEntity;
import com.hoau.how.module.obh.shared.exception.OBHException;
import com.hoau.how.module.obh.shared.util.Paging;
import com.hoau.how.module.util.HowPayeeAccountInfoReMes;
import com.hoau.how.module.util.JsonUtils;
import com.hoau.how.module.util.excel.POIExcelUtil;
import com.hoau.how.module.util.http.HttpUtil;

/**
 * 常用联系人管理服务类
 * 
 * @author 徐俊
 * @date 2015年7月22日
 */
@Service
public class ContactsService implements IContactsService {
	private Logger logger = Logger.getLogger(ContactsService.class);
	@Resource
	private ContactsEntityMapper contactsEntityMapper;
	
	@Resource
	private UnpayMentEntityMapper unpayMentEntityMapper;
	
	@Override
	public ContactsEntity queryContact(ContactsEntity contactsEntity) {
		return contactsEntityMapper.queryContact(contactsEntity);
	}

	@Override
	@Transactional
	public NetOrderEntity setDefaultContacts(Long userId, boolean isBatchOrder) {
		NetOrderEntity entity = new NetOrderEntity();
		List<ContactsEntity> contacts = contactsEntityMapper.findDefualt(userId, ContactsType.SHIPPER);
		if(contacts != null && contacts.size()>0){
			ContactsEntity shipper = contacts.get(0);
			//shipper
			entity.setEinoShipperEbsaContact(shipper.getEbsaContact());
			entity.setEinoShipperEbsaMobile(shipper.getEbsaMobile());
			String shipperTel = "";
			if(StringUtil.isNotEmpty(shipper.getEbsaContactAreaCode()) &&  StringUtil.isNotEmpty(shipper.getEbsaContactTel())){
				shipperTel = shipper.getEbsaContactAreaCode()+"-"+shipper.getEbsaContactTel();
			}
			entity.setEinoShipperEbsaTel(shipperTel);
			entity.setShipperDistrict(shipper.getEbsaEbpvName()+"-"+shipper.getEbsaEbplName()+"-"+shipper.getEbsaEbcoName());
			entity.setEinoShipperEbsaAddress(shipper.getEbsaAddress());
			entity.setEinoSecondDistrict(shipper.getEbsaDeptDistrict());
			entity.setEinoEscoSecondCode(shipper.getEbsaEscoSecondCode());
			entity.setEinoEscoSecondName(shipper.getEbsaEscoSecondName());
		}
		//consignee
		if(!isBatchOrder){
			contacts = contactsEntityMapper.findDefualt(userId, ContactsType.CONSIGNEE);
			if(contacts != null && contacts.size()>0){
				ContactsEntity consignee = contacts.get(0);
				entity.setEinoConsigneeEbsaMobile(consignee.getEbsaMobile());
				entity.setEinoConsigneeEbsaContact(consignee.getEbsaContact());
				entity.setEinoConsigneeEbsaMobile(consignee.getEbsaMobile());
				
				String consigneeTel = "";
				if(StringUtil.isNotEmpty(consignee.getEbsaContactAreaCode()) && StringUtil.isNotEmpty(consignee.getEbsaContactTel())){
					consigneeTel = consignee.getEbsaContactAreaCode()+"-"+consignee.getEbsaContactTel();
				}
				entity.setEinoConsigneeEbsaTel(consigneeTel);
				entity.setConsigneeDistrict(consignee.getEbsaEbpvName()+"-"+consignee.getEbsaEbplName()+"-"+consignee.getEbsaEbcoName());
				entity.setEinoConsigneeEbsaAddress(consignee.getEbsaAddress());
				
			}
		}
		return entity;
	}


	@Override
	public Paging<ContactsEntity> queryMyContactsPage(ContactsEntity contactsEntity, String type,int pageSize,int pageNo) {
		Paging<ContactsEntity> paging = new Paging<ContactsEntity>();
		paging.setPageSize(pageSize);
		paging.setPageNo(pageNo);
		
		List<ContactsEntity> data = contactsEntityMapper.queryMyContactsPage(contactsEntity, type,pageSize,(pageNo - 1)*pageSize);
		paging.setData(data);
		
		int contactsTotals = contactsEntityMapper.contactsTotals(contactsEntity.getEbsaId(),type);
		paging.setRowsCount(contactsTotals);
		//总页数
		int totalPages = contactsTotals/pageSize;
		paging.setPageCount(contactsTotals%pageSize == 0 ? totalPages:totalPages+1);
		return paging;
	}

	
	/**
	 * 新增联系人
	 * 
	 * @param contactsEntity
	 * @author 徐俊
	 * @date 2015年7月23日
	 * @update
	 */
	@Transactional
	public void addContacts(ContactsEntity contactsEntity) {
		paramCheck(contactsEntity);
		contactsEntity.setEbsaIsDefault("N");
		contactsEntityMapper.insert(contactsEntity);
	}

	@Transactional
	public void addContacts(ContactsEntity contactsEntity,List<UnpayMentEntity> unpayMentList) {
		ContactsDcEntity cde=new ContactsDcEntity();
		List<UnpayMentEntity> list=new ArrayList<UnpayMentEntity>();
		UnpayMentEntity unpayment=new UnpayMentEntity();
		paramCheck(contactsEntity);
		contactsEntity.setEbsaIsDefault("N");
		contactsEntityMapper.insert(contactsEntity);
		//获取新生成数据的主键值
		String ebsaId=contactsEntity.getEbsaId()+"";
		if(unpayMentList.get(0).getPayeeAccount()!=""){
			String ascriptionCity = "";
			String province = "";
			String city = "";
			for(int i=0;i<unpayMentList.size();i++){
				unpayment=unpayMentList.get(i);
				unpayment.setEbuEbsaId(ebsaId);
				ascriptionCity = unpayment.getDistrict();
				if(ascriptionCity != null && !ascriptionCity.equals("")){
					String[] district = ascriptionCity.split("-");
					if(district.length > 2){
						province = district[0];
						//如果选择的是县级市，则获取县级市名称，否则获取市区名称
						if(district[2].endsWith("市")){
							city = district[2];
						}else{
							city = district[1];
						};
					}
				}
				unpayment.setProvince(province);
				unpayment.setCity(city);
				//保存本地
				unpayMentEntityMapper.saveUnpayMent(unpayment);
				list.add(unpayment);
			}
		}
		cde.setEbsaMobile(contactsEntity.getEbsaMobile());
		if(cde.getEbsaMobile()!=null){
			//把ContactsDcEntity数据保存到DC
			cde.setUnpayMentList(list);
			String reqStr = JsonUtils.toJson(cde);
		    HttpUtil hu=new HttpUtil(ItfConifgConstant.HOW_DC_PAYEE_ACCOUNT_URL);
		    reqStr=hu.post(reqStr, "add");
		    HowPayeeAccountInfoReMes str=JsonUtils.toObject(reqStr, HowPayeeAccountInfoReMes.class);
		    logger.info("ContactsService.addContacts,HowPayeeAccountInfoReMes Status = " + str.getStatus() + ",Message = " + str.getMessage());
	    }
	}
	
	@Transactional
	@Override
	public void delete(List<String> contactsIds, Long userId) {
		// TODO 修改为逻辑删除
		ContactsDcEntity cde=new ContactsDcEntity();
		List<UnpayMentEntity> list=new ArrayList<UnpayMentEntity>();
		List<String> li=new ArrayList<String>();
		
		if (userId == 0 || contactsIds == null || contactsIds.size() == 0) {
			throw new OBHException("用户信息为空");
		}
		for (String id : contactsIds) {
			String s= contactsEntityMapper.selectMobileById(Long.valueOf(id));
			cde.setEbsaMobile(s);
			contactsEntityMapper.deleteByPrimaryKey(Long.valueOf(id), userId);
			li=unpayMentEntityMapper.selectEsuId(id);
			unpayMentEntityMapper.deleteByForeignKey(id);
			//取出DC需要删除的数据标识
			if(li.size()!=0){
				for (String st : li) {
					UnpayMentEntity unpayment=new UnpayMentEntity();
					unpayment.setEbuEbsaId(st);
					list.add(unpayment);
				}
			}
			cde.setUnpayMentList(list);
			//DC删除待收货款信息
			if(cde.getUnpayMentList()!=null && cde.getEbsaMobile()!=null){
				String reqStr = JsonUtils.toJson(cde);
			    HttpUtil hu=new HttpUtil(ItfConifgConstant.HOW_DC_PAYEE_ACCOUNT_URL);
			    reqStr=hu.post(reqStr, "delete");
			    HowPayeeAccountInfoReMes str=JsonUtils.toObject(reqStr, HowPayeeAccountInfoReMes.class);
			    logger.info("ContactsService.delete,HowPayeeAccountInfoReMes Status = " + str.getStatus() + ",Message = " + str.getMessage());
			}
		}
	}

	private void paramCheck(ContactsEntity contactsEntity) {
		if (contactsEntity == null) {
			throw new OBHException("联系人实体不能为空");
		}
		// 手机
		String mobile = contactsEntity.getEbsaMobile();
		// 座机
		String tel = contactsEntity.getEbsaContactTel();
		// 姓名
		String name = contactsEntity.getEbsaContact();
		if (StringUtil.isBlank(name)) {
			throw new OBHException("姓名不能为空");
		}
		if (StringUtil.isBlank(mobile) && StringUtil.isBlank(tel)) {
			throw new OBHException("手机号码与固定电话必须填写一项");
		}
		String shipperAddress = contactsEntity.getEbsaAddress();
		if (StringUtil.isBlank(shipperAddress)) {
			throw new OBHException("发货地址必填");
		}
	}

	@Override
	public InputStream getExcelIs(long userId, String type) {
		contactsEntityMapper.queryMyContacts(userId, type);
		String path = genFile(userId, type);
		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}

	private String genFile(long userId, String type) {
		String rtn = null;
		Map<String, String> maps = new LinkedHashMap<String, String>();
		maps.put("ebsaContact", "姓名");
		maps.put("ebsaMobile", "手机号码");
		maps.put("ebsaContactAreaCode", "区号");
		maps.put("ebsaContactTel", "电话号码");
		maps.put("ebsaAddress", "地址");
		maps.put("ebsaEbpvName", "省份");
		maps.put("ebsaEbplName", "城市");
		maps.put("ebsaEbcoName", "区县");
		maps.put("ebsaEscoSecondName", "网点");
		Properties props = System.getProperties();
		String USER_HOME = props.getProperty("user.home");
		rtn = USER_HOME + "/excelExport.xlsx";
		File file = new File(rtn);
		List<ContactsEntity> demo = contactsEntityMapper.queryMyContacts(userId, type);
		POIExcelUtil.excelExport(maps, demo, file);
		return rtn;
	}

	@Override
	public ContactsEntity queryContactsById(String contactsIds,Long long1) {
 		return contactsEntityMapper.selectByPrimaryKey(Long.valueOf(contactsIds),long1);
	}

	@Override
	public void setDefault(long userId, long contactsIds,String contactsType) {
		//将选中设为默认联系人
		contactsEntityMapper.setDefault(userId, contactsIds);
		//将其它的侍卫非默认联系人
		contactsEntityMapper.setNotDefault(userId, contactsIds,contactsType);
	}

	@Override
	public List<ContactsEntity> queryMyContacts(long userId, String type) {
		return contactsEntityMapper.queryMyContacts(userId, type);
	}

	@Transactional
	@Override
	public void updateContacts(ContactsEntity contactsEntity) {
		long id = contactsEntity.getEbsaId();
		if(id == 0){
			throw new OBHException("联系人ID不能为空");
		}
		ContactsEntity entity = contactsEntityMapper.selectByPrimaryKey(id,Long.valueOf(contactsEntity.getModifier()));
		paramCheck(contactsEntity);
		contactsEntity.setModifyTime(new Date());
		contactsEntity.setCreateTime(entity.getCreateTime());
		contactsEntityMapper.updateByPrimaryKey(contactsEntity);
	}

	@Override
	public void updateContacts(ContactsEntity contactsEntity,List<UnpayMentEntity> unpayMentList) {
		ContactsDcEntity cde=new ContactsDcEntity();
		//根据主键修改ContactsEntity的数据
		long id = contactsEntity.getEbsaId();
		if(id == 0){
			throw new OBHException("联系人ID不能为空");
		}
		ContactsEntity entity = contactsEntityMapper.selectByPrimaryKey(id,Long.valueOf(contactsEntity.getModifier()));
		paramCheck(contactsEntity);
		contactsEntity.setModifyTime(new Date());
		contactsEntity.setCreateTime(entity.getCreateTime());
		contactsEntityMapper.updateByPrimaryKey(contactsEntity);
		//修改待收货款信息数据，先根据外键删除，后新增
		if(unpayMentList.get(0).getPayeeAccount()==""){
		   unpayMentEntityMapper.deleteByForeignKey(contactsEntity.getEbsaId()+"");
		}else{
			 unpayMentEntityMapper.deleteByForeignKey(contactsEntity.getEbsaId()+"");
			 String ascriptionCity = "";
				String province = "";
				String city = "";
			 for (UnpayMentEntity unpayMentEntity : unpayMentList) {
			 	ascriptionCity = unpayMentEntity.getDistrict();
				if(ascriptionCity != null && !ascriptionCity.equals("")){
				String[] district = ascriptionCity.split("-");
				if(district.length > 2){
					province = district[0];
					//如果选择的是县级市，则获取县级市名称，否则获取市区名称
				if(district[2].endsWith("市")){
							city = district[2];
						}else{
							city = district[1];
						};
					}
				}
				unpayMentEntity.setProvince(province);
				unpayMentEntity.setCity(city);
				unpayMentEntityMapper.saveUnpayMent(unpayMentEntity);
			 }
		}
		//修改DC数据
		if(unpayMentList.get(0).getOldEsuId()==""){
			    cde.setEbsaMobile(contactsEntity.getEbsaMobile());
				//把ContactsDcEntity数据保存到DC
				cde.setUnpayMentList(unpayMentList);
				String reqStr = JsonUtils.toJson(cde);
			    HttpUtil hu=new HttpUtil(ItfConifgConstant.HOW_DC_PAYEE_ACCOUNT_URL);
			    reqStr=hu.post(reqStr, "add");
			    HowPayeeAccountInfoReMes str=JsonUtils.toObject(reqStr, HowPayeeAccountInfoReMes.class);
			    logger.info("ContactsService.updateContacts,HowPayeeAccountInfoReMes Status = " + str.getStatus() + ",Message = " + str.getMessage());
		}else{
			cde.setEbsaMobile(contactsEntity.getEbsaMobile());
			//把ContactsDcEntity数据保存到DC
			cde.setUnpayMentList(unpayMentList);
			String reqStr = JsonUtils.toJson(cde);
		    HttpUtil hu=new HttpUtil(ItfConifgConstant.HOW_DC_PAYEE_ACCOUNT_URL);
		    reqStr=hu.post(reqStr, "update");
		    HowPayeeAccountInfoReMes str=JsonUtils.toObject(reqStr, HowPayeeAccountInfoReMes.class);
		    logger.info("ContactsService.updateContacts,HowPayeeAccountInfoReMes Status = " + str.getStatus() + ",Message = " + str.getMessage());
		}
	}
	
}
