package com.hoau.mhow.module.bse.server.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.module.bse.api.server.service.ICompanyMatchService;
import com.hoau.mhow.module.bse.api.server.service.IContactsService;
import com.hoau.mhow.module.bse.api.shared.domain.ContactsEntity;
import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;
import com.hoau.mhow.module.bse.api.shared.exception.OBHException;
import com.hoau.mhow.module.bse.api.shared.vo.DepartmentVo;
import com.hoau.mhow.module.obh.server.dao.ContactsEntityMapper;
import com.hoau.wechat.constants.ContactsType;

/**
 * 常用联系人管理服务类
 *
 * @author 蒋落琛
 * @date 2015-12-14
 */
@Service
public class ContactsService implements IContactsService {

	@Resource
	private ContactsEntityMapper contactsEntityMapper;
	@Resource
	private ICompanyMatchService companyMatchService;
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
//			String shipperTel = "";
//			if(StringUtil.isNotEmpty(shipper.getEbsaContactAreaCode()) &&  StringUtil.isNotEmpty(shipper.getEbsaContactTel())){
//				shipperTel = shipper.getEbsaContactAreaCode()+"-"+shipper.getEbsaContactTel();
//			}
			entity.setEinoShipperEbsaTel(shipper.getEbsaContactTel());
			entity.setEinoShipperEbsaAreaCode(shipper.getEbsaContactAreaCode());
			entity.setShipperDistrict(shipper.getEbsaEbpvName()+"-"+shipper.getEbsaEbplName()+"-"+shipper.getEbsaEbcoName());
			entity.setEinoShipperEbsaAddress(shipper.getEbsaAddress());
			entity.setEinoSecondDistrict(shipper.getEbsaDeptDistrict());
			entity.setEinoEscoSecondCode(shipper.getEbsaEscoSecondCode());
			entity.setEinoEscoSecondName(shipper.getEbsaEscoSecondName());
			entity.setEinoShipperEbspNameCn(shipper.getEbsaCompany());
			String secondDistrict = entity.getEinoSecondDistrict();
			if(secondDistrict != null && secondDistrict != ""){
				Map<String,String> map = new HashMap<String,String>();
				if(!StringUtil.isEmpty(secondDistrict)){
					String[] params = secondDistrict.split("-");
					if(params.length>1){
						map.put("province", params[0]);
						map.put("city",params[1]);
						if(params.length > 2){
							map.put("county",params[2]);
						}
						List<DepartmentVo> departmentVos = companyMatchService.queryDeptByDistrictName(map);
						for(DepartmentVo vo : departmentVos){
							if(vo.getLogistCode().equals(entity.getEinoEscoSecondCode())){
								entity.setCompanyMsg(vo.getAddressDetail() + "|" + vo.getPhone());
								break;
							}
						}
					}
				}
			}else{
				entity.setCompanyMsg("");
			}
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


	/*@Override
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
	}*/

	
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
	@Override
	public void delete(List<String> contactsIds, Long userId) {
		// TODO 修改为逻辑删除
		if (userId == 0 || contactsIds == null || contactsIds.size() == 0) {
			throw new OBHException("用户信息为空");
		}
		for (String id : contactsIds) {
			contactsEntityMapper.deleteByPrimaryKey(Long.valueOf(id), userId);
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

		// long pvId = contactsEntity.getEbsaEbpvId();
		// long cityId = contactsEntity.getEbsaEbplId();
		// long districtId = contactsEntity.getEbsaEbcoId();
		String shipperAddress = contactsEntity.getEbsaAddress();
		if (StringUtil.isBlank(shipperAddress)) {
			throw new OBHException("发货地址必填");
		}
	}

	/*@Override
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
	}*/

	/*private String genFile(long userId, String type) {
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
		System.out.println(USER_HOME);
		
		rtn = USER_HOME + "/excelExport.xlsx";
		File file = new File(rtn);

		List<ContactsEntity> demo = contactsEntityMapper.queryMyContacts(userId, type);

		POIExcelUtil.excelExport(maps, demo, file);
		return rtn;
	}*/

	@Override
	public ContactsEntity queryContactsById(String contactsIds,String customerId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("ebsaId",contactsIds);
        map.put("customerId",customerId);
		return contactsEntityMapper.selectByPrimaryKey(map);
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
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("ebsaId",id);
		ContactsEntity entity = contactsEntityMapper.selectByPrimaryKey(map);
		paramCheck(contactsEntity);
		contactsEntity.setModifyTime(new Date());
		contactsEntity.setCreateTime(entity.getCreateTime());
		
		contactsEntityMapper.updateByPrimaryKey(contactsEntity);
	}

	@Override
	public int countContact(long userId) {
		if(userId == 0){
			throw new OBHException("用户id不能为空");
		}
		return contactsEntityMapper.contactsTotals(userId,ContactsType.SHIPPER)+contactsEntityMapper.contactsTotals(userId,ContactsType.CONSIGNEE);
	}
}
