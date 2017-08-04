package com.hoau.how.module.obh.server.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.common.constants.ContactsType;
import com.hoau.how.module.common.constants.ControllConstants;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.obh.server.service.IContactsService;
import com.hoau.how.module.obh.server.service.IUnpayMentService;
import com.hoau.how.module.obh.shared.domain.ContactsEntity;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.UnpayMentEntity;
import com.hoau.how.module.obh.shared.exception.OBHException;
import com.hoau.how.module.obh.shared.util.Paging;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.util.JsonUtils;
import com.hoau.how.module.util.date.DateUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author 徐俊
 * @date 2015年8月3日
 */
@Controller
@Scope("prototype")
public class ContactsManageAction extends AbstractAction{
	//在struts.xml中配置
	private int pageSize;
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String queryKeyword;
	
	private List<ContactsEntity> contactsEntities; 

	private ContactsEntity contactsEntity;
	
	//待收货款信息
    private List<UnpayMentEntity> unpayMentList;
    
    //待收货款信息String
    private String unpayMentString;
    
	private String contactsIds;
	
	private String contactsType;
	
	private InputStream excelStream;
	
	private String filePath;
	
	private String categoryName;
	
	
	private String fileName;
	
	private String controllType;
	private int pageNo = 1;
	//搜索关键字
	private String value;
	
	private Paging<ContactsEntity> paging;
	
	@Resource
	private IContactsService contactsService;
	
	@Resource
	private IUnpayMentService unpayMentService;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	/**
	 * 发货人管理
	 * 
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月20日
	 * @update 
	 */ 
	@PermissionCheck
	public String shipperManage() throws Exception {
		try {
			controllType = ControllConstants.CONTROLL_MY_HOAU.SHIPPER_MANAGE;// 控制菜单展开
			getContacts(ContactsType.SHIPPER);
			return returnSuccess();	
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	
	private void getContacts(String type) {
		CustomerContactEntity po = getCurrentUser();
		ContactsEntity contactsEntity = new ContactsEntity();
		contactsEntity.setEbsaId((long)po.getEbccId());
		
		//是否带查询条件
		if(!StringUtil.isEmpty(queryKeyword)){
			try {
				queryKeyword = new String(queryKeyword.getBytes("iso8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//设置关键字到电话字段中， 实际客户输入的关键字可能是电话 也 可能是手机，也可能是姓名，在查询时，使用这个字段去匹配（手机、电话、姓名）
			contactsEntity.setEbsaMobile(queryKeyword);
		}
		paging = contactsService.queryMyContactsPage(contactsEntity,type, pageSize , pageNo);
	}
	
	public String pagingQuery() throws Exception {
		try {
			controllType = ControllConstants.CONTROLL_MY_HOAU.SHIPPER_MANAGE;
			getContacts(contactsType);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	
	@PermissionCheck
	public String search() throws Exception {
		try {
			getContacts(contactsType);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	
	/**
	 * 收货人管理
	 * 
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月20日
	 * @update
	 */
	@PermissionCheck
	public String consigneeManage() throws Exception {
		try {
			controllType = ControllConstants.CONTROLL_MY_HOAU.CONSIGNEE_MANAGE;
			getContacts(ContactsType.CONSIGNEE);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	
	/**
	 * 新增联系人
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月21日
	 * @update 
	 */
	@PermissionCheck
	public String add() throws Exception {
		try {
			CustomerContactEntity po = getCurrentUser();
			contactsEntity.setCreator(String.valueOf(po.getEbccId()));
			contactsEntity.setModifier(String.valueOf(po.getEbccId()));
			contactsEntity.setEbsaEbcuId(Long.valueOf(po.getEbccId()));
			//unpayMentString
			if(contactsEntity.getEbsaType().equals("consignee")){
				contactsService.addContacts(contactsEntity);
			}else{
				unpayMentList=JsonUtils.toList(unpayMentString,UnpayMentEntity.class);
				contactsService.addContacts(contactsEntity,unpayMentList);
			}
			
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	/**
	 * 更新联系人
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年8月4日
	 * @update 
	 */
	public String update() throws Exception {
		try {
			CustomerContactEntity po = getCurrentUser();
			contactsEntity.setCreator(String.valueOf(po.getEbccId()));
			contactsEntity.setModifier(String.valueOf(po.getEbccId()));
			contactsEntity.setEbsaEbcuId(Long.valueOf(po.getEbccId()));
			if(contactsEntity.getEbsaType().equals("consignee")){
				contactsService.updateContacts(contactsEntity);
			}else{
				unpayMentList=JsonUtils.toList(unpayMentString,UnpayMentEntity.class);
				contactsService.updateContacts(contactsEntity,unpayMentList);
			}
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	
	/**
	 * 删除联系人
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月21日
	 * @update 
	 */
	@PermissionCheck
	public String delete() throws Exception {
		CustomerContactEntity po = getCurrentUser();
		try {
			contactsService.delete(getIds(),Long.valueOf(po.getEbccId()));
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	/**
	 * 导出联系人数据
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月27日
	 * @update 
	 */
	@PermissionCheck(isExport=true)
	public String export() throws Exception {
		CustomerContactEntity po = getCurrentUser();
		try {
			String dateStr = DateUtils.formatDateYYYYMMDD(new Date());
			if(contactsType.equals("shipper")){
				fileName = "发货人管理"+dateStr+".xls";
			}else{
				fileName = "收货人管理"+dateStr+".xls";
			}
			//文件名中文乱码
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			
			excelStream = contactsService.getExcelIs(Long.valueOf(po.getEbccId()),contactsType);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	
	/**
	 * 设置默认联系人
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月30日
	 * @update 
	 */
	@PermissionCheck
	public String setDefault() throws Exception {
		CustomerContactEntity po = getCurrentUser();
		try {
			contactsService.setDefault(Long.valueOf(po.getEbccId()),Long.valueOf(contactsIds),contactsType);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	/**
	 * 通过联系人ID查询联系人
	 * @return
	 * @throws Exception
	 * @author 徐俊
	 * @date 2015年7月27日
	 * @update 
	 */
	@PermissionCheck
	public String queryById() throws Exception {
		try {
			Long long1 = getCurrentUser().getEbccId();
			System.out.println(long1);
			contactsEntity = contactsService.queryContactsById(contactsIds,long1);
			unpayMentList=unpayMentService.queryUnpayMentByFid(contactsIds);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	private CustomerContactEntity getCurrentUser(){
		ActionContext ctx = ActionContext.getContext();
		Object o = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		if(o == null){
			throw new OBHException(OBHException.NOT_LOGIN,"notLogin");
		}
		CustomerContactEntity po = (CustomerContactEntity)o;
		return po;
	}
	
	private List<String> getIds(){
		String[] ids = contactsIds.split(";");
		return Arrays.asList(ids);
	}
	
	public List<ContactsEntity> getContactsEntities() {
		return contactsEntities;
	}
	public void setContactsEntities(List<ContactsEntity> contactsEntities) {
		this.contactsEntities = contactsEntities;
	}
	public ContactsEntity getContactsEntity() {
		return contactsEntity;
	}
	public void setContactsEntity(ContactsEntity contactsEntity) {
		this.contactsEntity = contactsEntity;
	}
	public String getContactsIds() {
		return contactsIds;
	}
	public void setContactsIds(String contactsIds) {
		this.contactsIds = contactsIds;
	}
	public String getContactsType() {
		return contactsType;
	}
	public void setContactsType(String contactsType) {
		this.contactsType = contactsType;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Paging<ContactsEntity> getPaging() {
		return paging;
	}
	public void setPaging(Paging<ContactsEntity> paging) {
		this.paging = paging;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getControllType() {
		return controllType;
	}
	public void setControllType(String controllType) {
		this.controllType = controllType;
	}
	public String getQueryKeyword() {
		return queryKeyword;
	}
	public void setQueryKeyword(String queryKeyword) {
		this.queryKeyword = queryKeyword;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<UnpayMentEntity> getUnpayMentList() {
		return unpayMentList;
	}
	public void setUnpayMentList(List<UnpayMentEntity> unpayMentList) {
		this.unpayMentList = unpayMentList;
	}
	public void setUnpayMentString(String unpayMentString) {
		this.unpayMentString = unpayMentString;
	}
	
	
}
