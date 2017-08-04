package com.hoau.how.module.obh.server.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.itf.server.service.IOmsOrderService;
import com.hoau.how.module.itf.server.ws.omsorder.CustomerServicePortType;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.how.module.obh.server.service.IBatchOrderService;
import com.hoau.how.module.obh.server.service.IContactsService;
import com.hoau.how.module.obh.server.service.IOrderService;
import com.hoau.how.module.obh.shared.constants.Constants;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.util.Paging;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.util.EmptyUtils;
import com.hoau.how.module.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;

/**
 * 批量下单ACTION
 * @author 莫涛
 * @date 2015年7月20日
 */
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class BatchOrderAction extends AbstractAction{
	private static final long serialVersionUID = 9125540121651748362L;
	private static final int MAX_POST_SIZE = 9 * 1024 * 1024;

	private Logger logger = Logger.getLogger(BatchOrderAction.class);
	public static final int PAGE_SIZE = 10;
	public static final int MAX_ROW_SIZE = 100;
	/**模板类型**/
	//天猫
	public static final String TMALL = "TMALL";
	//顺丰
	public static final String SF = "SF";
	
	private int pageNo = 1;
	private Paging<NetOrderEntity> paging;
	@Resource
	IOrderService orderService;
	@Resource
	IOmsOrderService omsOrderService;
	@Resource
	IBatchOrderService batchOrderService;
	@Resource
	private IContactsService contactsService;
	
	private NetOrderEntity entity;
	private String errorMsg;
	private String errorType;
	private File uploadFile;
	private String uploadFileFileName;
	private String categoryName;
	
	
	@PermissionCheck
	public String index(){
		ActionContext ctx = ActionContext.getContext();
		Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		CustomerContactEntity userInfo = (CustomerContactEntity) obj;
		entity = contactsService.setDefaultContacts(userInfo.getEbccId(),true);
		ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_SHIPPER_ORDER_INFO,this.entity);
		return "index";
	}
	
	/**
	 * 执行下一步操作
	 * @return
	 * @author 莫涛
	 * @date 2015年8月4日
	 * @update
	 */
	@PermissionCheck
	public String next(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_SHIPPER_ORDER_INFO,this.entity);
		return "singleOrder";
	}
	
	/**
	 * 逐个增加订单，未来提交，仅仅放缓存
	 * @return
	 * @author 莫涛
	 * @date 2015年8月6日
	 * @update
	 */
	@PermissionCheck
	public String singleOrder(){
		try{
			if(this.entity == null){
				this.errorMsg = "参数为空!";
				return "singleOrder";
			}
			//验证订单数据,普通订单传空
			this.putBatchOrder(this.entity,"",true);
			if(this.errorMsg == null){
				setThisSuccessMsg("逐个新增订单成功！");
			}else{
				paging = new Paging<NetOrderEntity>();
				paging.setPageSize(PAGE_SIZE);
			}
		}catch(Exception ex){
			logger.error("BatchOrderAction singleOrder error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "singleOrder";
	}
	
	/**
	 * 批量新增订单
	 * @param entity
	 * @author 莫涛
	 * @date 2015年8月10日
	 * @update
	 */
	private String putBatchOrder(NetOrderEntity entity,String modelType,boolean isPutShipperInfo){
		ActionContext ctx = ActionContext.getContext();
		Object obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
		Object shipperObj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_SHIPPER_ORDER_INFO);
		NetOrderEntity shipperEntity = (NetOrderEntity)shipperObj;
		String resultMsg = null;
		//设置发货人信息
		if(isPutShipperInfo){
			putShipperInfo(shipperEntity, entity);
		}
		if(modelType.equals(BatchOrderAction.TMALL)){
			//使用天猫验证规则
			this.checkTmallOrder(entity);
		}else if(modelType.equals(BatchOrderAction.SF)){
			//使用顺丰验证规则
			this.checkSfOrder(entity);
		}else{
			//验证订单数据
			this.checkEiNetOrder(entity);
		}
		if(this.errorMsg == null){
			entity.setValidate("SUCCESS");
		}else{
			entity.setValidate("ERROR");
		}
		//如果不为空，则获取缓存中订单，并且保存
		if(obj != null){
			List<NetOrderEntity> orderList = (List<NetOrderEntity>) obj;
			if(orderList.size() < MAX_ROW_SIZE){
				long id = orderList.size() + 1;
				entity.setEinoId(id);
				if(entity.getValidate().equals("SUCCESS")){
					orderList.add(entity);
				}else{
					orderList.add(0,entity);
				}
			}else{
				setThisErrorMsg("下单数据已经超出30条范围，请勿继续添加订单！");
			}
		}else{
			List<NetOrderEntity> orderList = new ArrayList<NetOrderEntity>();
			entity.setEinoId(1L);
			if(entity.getValidate().equals("SUCCESS")){
				orderList.add(entity);
			}else{
				orderList.add(0,entity);
			}
			ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, orderList);
		}
		return resultMsg;
	}
	
	@PermissionCheck
	public String pagingQuery(){
		try{
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
			if(obj != null){
				List<NetOrderEntity> orderList = (List<NetOrderEntity>) obj;
				this.paging = this.batchOrderService.pageQuery(orderList, PAGE_SIZE, pageNo);
			}else{
				paging = new Paging<NetOrderEntity>();
				paging.setPageSize(PAGE_SIZE);
			}
		}catch(Exception ex){
			logger.error("BatchOrderAction pagingQuery error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "orderList";
	}
	
	//将发货人信息保存至订单里
	private void putShipperInfo(NetOrderEntity shipperEntity,NetOrderEntity entity){
		entity.setEinoShipperEbsaContact(shipperEntity.getEinoShipperEbsaContact());
		entity.setEinoShipperEbsaMobile(shipperEntity.getEinoShipperEbsaMobile());
		entity.setEinoShipperEbsaTel(shipperEntity.getEinoShipperEbsaTel());
		entity.setShipperDistrict(shipperEntity.getShipperDistrict());
		entity.setEinoShipperEbsaAddress(shipperEntity.getEinoShipperEbsaAddress());
		entity.setEinoSecondDistrict(shipperEntity.getEinoSecondDistrict());
		entity.setEinoEscoSecondCode(shipperEntity.getEinoEscoSecondCode());
		entity.setEinoEscoSecondName(shipperEntity.getEinoEscoSecondName());
		entity.setEinoShipperEbspNameCn(shipperEntity.getEinoShipperEbspNameCn());
		if(shipperEntity.getEinoDoorCanvass() != null && !shipperEntity.getEinoDoorCanvass().equals("")){
			entity.setEinoDoorCanvass(shipperEntity.getEinoDoorCanvass());
		}
	}
	
	@PermissionCheck
	public String createBatchOrder(){
		try{
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			CustomerContactEntity userInfo = (CustomerContactEntity) obj;
			//获取订单信息
			obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
			Object shipperObj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_SHIPPER_ORDER_INFO);
			if(obj != null && shipperObj != null){
				//保存订单
				CustomerServicePortType port = omsOrderService.getCustomerService();
				EiNetOrderReqModel netOrder = new EiNetOrderReqModel();
				List<NetOrderEntity> orderList = (List<NetOrderEntity>) obj;
				//验证失败订单
				boolean errorCount = true;
				for (int i = 0; i < orderList.size(); i++) {
					NetOrderEntity entity = orderList.get(i);
					if(entity.getValidate() == null || entity.getValidate().equals("ERROR")){
						errorCount = false;
						break;
					}
				}
				if(!errorCount){
					setThisErrorMsg("请先处理异常订单，批量下单失败！");
				}else{
					for (int i = 0; i < orderList.size(); i++) {
						orderList.get(i).setEinoEbccId(userInfo.getEbccId().longValue());
						orderService.createBatchOrder(orderList.get(i));
						//值转换
						orderService.copyNetOrderToEiNetOrder(orderList.get(i), netOrder,omsOrderService.getObjectFactory(),1);
						port.saveNetOrder(netOrder);
					}
					orderList.clear();
					ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO,null);
					this.errorType = "cbos";
				}
			}else{
				setThisErrorMsg("批量下单失败，无订单数据！");
			}
		}catch(Exception ex){
			logger.error("BatchOrderAction createOrder error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "singleOrder";
	}
	
	@PermissionCheck
	public String removeOrderJson(){
		try{
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
			if(obj != null && this.entity.getEinoId() != null){
				List<NetOrderEntity> orderList = (List<NetOrderEntity>) obj;
				for (int i = 0; i < orderList.size(); i++) {
					if(orderList.get(i).getEinoId().equals(this.entity.getEinoId())){
						orderList.remove(i);
						setThisSuccessMsg("删除订单，操作成功！");
						break;
					}
				}
			}else{
				setThisErrorMsg("订单列表为空，或订单信息为空！");
			}
		}catch(Exception ex){
			logger.error("BatchOrderAction removeOrder error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "removeOrderJson";
	}
	
	@PermissionCheck
	public String findOrderByIdJson(){
		try{
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
			if(obj != null && this.entity.getEinoId() != null){
				List<NetOrderEntity> orderList = (List<NetOrderEntity>) obj;
				for (int i = 0; i < orderList.size(); i++) {
					if(orderList.get(i).getEinoId().equals(this.entity.getEinoId())){
						this.entity = orderList.get(i);
						break;
					}
				}
			}
		}catch(Exception ex){
			logger.error("BatchOrderAction findOrderByIdJson error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "findOrderByIdJson";
	}
	
	@PermissionCheck
	public String modifyOrder(){
		try{
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO);
			if(obj != null && this.entity.getEinoId() != null){
				List<NetOrderEntity> orderList = (List<NetOrderEntity>) obj;
				for (int i = 0; i < orderList.size(); i++) {
					if(orderList.get(i).getEinoId().equals(this.entity.getEinoId())){
						orderList.set(i, this.entity);
						setThisSuccessMsg("修改订单，操作成功！");
						break;
					}
				}
			}
		}catch(Exception ex){
			logger.error("BatchOrderAction modifyOrder error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "singleOrder";
	}
	
	@PermissionCheck
	public String batchUploadOrder(){
		try{
			String directory = "/upload/batchOrder";
			String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
			//生成上传的文件对象
			File target = new File(targetDirectory,this.uploadFileFileName);
			String fileName = target.getName();
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			long length = target.length();
			if (length > MAX_POST_SIZE) {
				setThisErrorMsg("系统异常：文件上传不能大于9M");
				return "singleOrder";
			}
			if (suffix.equals("xls")  || suffix.equals("xlsx")){
				//如果文件已经存在，则删除原有文件
				if(target.exists()){
					target.delete();
				}
				//复制file对象，实现上传
				try {
					FileUtils.copyFile(this.uploadFile, target);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//加载excel数据
				loadOrderInfo();
				setThisSuccessMsg("批量上传订单信息成功，请点击立刻下单确认下单！");
			}else {
				setThisErrorMsg("系统异常：上传文件格式不正确");
				return "singleOrder";
			}

		}catch(Exception ex){
			logger.error("BatchOrderAction batchUploadOrder error : " + ex.getMessage());
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "singleOrder";
	}
	
	/**
	 * 把Excele表读出的数据，组装成一个List,统一导入数据库
	 * @param uploadFileFileName
	 */
	private void loadOrderInfo(){
		String directory = "/upload/batchOrder"; 
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		File target = new File(targetDirectory,this.uploadFileFileName);
		try{
			FileInputStream fi = new FileInputStream(target);
			Workbook wb = new HSSFWorkbook(fi);
			Sheet sheet = wb.getSheetAt(0);
			boolean isNull = false;
			//每次导入，先将之前的数据清空
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put(SessionConstants.SESSION_BATCH_ORDER_INFO.BATCH_ORDER_INFO, null);
			
			//天猫订单模板，和普通批量订单模板
			if(this.uploadFileFileName.startsWith("天猫")){
				tmallOrder(sheet,isNull);
			}else if(this.uploadFileFileName.startsWith("顺丰")){
				sfOrder(sheet,isNull);
			}else{
				ordinaryOrder(sheet,isNull);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 天猫订单处理逻辑
	 * @author 莫涛
	 * @date 2015年10月15日
	 * @update
	 */
	private void tmallOrder(Sheet sheet,boolean isNull){
		Map<String,Integer> map = null;
		//最大
		for(int i=0;i<MAX_ROW_SIZE;i++){
			NetOrderEntity netOrderEntity = new NetOrderEntity();
			Row row = sheet.getRow(i);
			if(row == null){
				break;
			}
			int cellNum = row.getLastCellNum();
			if(isNull == true){
				break;
			}
			if(i == 0){
				map = queryTitle(row);
				continue;
			}
			for(int j=0;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = "";
				if(cell == null){
					continue;
				}
				switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
					case 1 : cellValue = cell.getStringCellValue(); break;
					case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
					case 3 : cellValue = ""; break;
					case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
					case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
				}
				if(j == 0 && cellValue.equals("")){
					isNull = true;
					break;
				}
				if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_CONTACT))){
					//收货人
					netOrderEntity.setEinoConsigneeEbsaContact(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_ADDRESS))){
					//详细地址
					netOrderEntity.setEinoConsigneeEbsaAddress(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_TEL))){
					//收货人座机
					try{
						if(cell.getCellType() == 1){
							netOrderEntity.setEinoConsigneeEbsaTel(cellValue);
						}else{
							DecimalFormat df = new DecimalFormat("0");  
							String mobile = df.format(cell.getNumericCellValue());
							if(mobile == null || mobile.equals("0")){
								mobile = null;
							}
							netOrderEntity.setEinoConsigneeEbsaTel(mobile);
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_MOBILE))){
					//收货人手机
					try{
						if(cell.getCellType() == 1){
							netOrderEntity.setEinoConsigneeEbsaMobile(cellValue);
						}else{
							DecimalFormat df = new DecimalFormat("0");  
							String mobile = df.format(cell.getNumericCellValue());
							if(mobile == null || mobile.equals("0")){
								mobile = null;
							}
							netOrderEntity.setEinoConsigneeEbsaMobile(mobile);
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.CARGO_NAME))){
					//货物名称
					netOrderEntity.setEinoCargoName(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.PRODUCT_TYPE_NAME))){
					//运输方式
					netOrderEntity.setEinoProductTypeName(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.SHIPPER_METHOD))){
					if(cellValue.equals("门店自提")){
						cellValue = "SELF_TAKE";
					}else if(cellValue.equals("送货上门")){
						cellValue = "DOORSTEP";
					}else if(cellValue.equals("送货上楼")){
						cellValue = "UPSTAIR";
					}else if(cellValue.equals("安装")){
						cellValue = "INSTALL";
					}
					netOrderEntity.setEinoShipperMethod(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.PAYMENT_METHOD))){
					if(cellValue.equals("到付")){
						cellValue = "ARRIVE_PAYMENT";
					}else if(cellValue.equals("现付")){
						cellValue = "CASH";
					}else if(cellValue.equals("月结")){
						cellValue = "Monthly_Statement";
					}
					netOrderEntity.setEinoPaymentMethod(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.NUMBER))){
					//货物件数
					if(StringUtil.isNumber(cellValue) && Long.parseLong(cellValue) > 0){
						netOrderEntity.setEinoNumber(Long.parseLong(cellValue));
					}else{
						netOrderEntity.setEinoNumber(0L);
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.TOTAL_WEIGHT))){
					//重量
					if(StringUtil.isNumber(cellValue)){
						DecimalFormat df = new DecimalFormat("0.00");  
						String totalWeight = df.format(cell.getNumericCellValue());
						netOrderEntity.setEinoTotalWeight(Double.parseDouble(totalWeight));
					}else{
						netOrderEntity.setEinoTotalWeight(0D);
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.TOTAL_VOLUME))){
					//体积
					if(StringUtil.isNumber(cellValue)){
						DecimalFormat df = new DecimalFormat("0.00");  
						String totalVolume = df.format(cell.getNumericCellValue());
						netOrderEntity.setEinoTotalVolume(Double.parseDouble(totalVolume));
					}else{
						netOrderEntity.setEinoTotalVolume(0D);
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.PACKAGE))){
					//包装类型
					netOrderEntity.setEinoPackage(cellValue);
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.INSURANCE))){
					//保价声明
					if(StringUtil.isNumber(cellValue)){
						DecimalFormat df = new DecimalFormat("0.00");  
						String insurance = df.format(cell.getNumericCellValue());
						netOrderEntity.setEinoInsurance(Double.parseDouble(insurance));
					}else{
						netOrderEntity.setEinoInsurance(0D);
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.SIGN_BACK))){
					if(cellValue.equals("无需返单")){
						netOrderEntity.setEinoSignBack("NOBACK");
					}else if(cellValue.equals("客户出库单原件返回")){
						netOrderEntity.setEinoSignBack("CUSTORIGINAL");
					}else if(cellValue.equals("客户出库单传真返回")){
						netOrderEntity.setEinoSignBack("CUSTCOPY");
					}else if(cellValue.equals("客户签收单传真返回")){
						netOrderEntity.setEinoSignBack("SIGNCOPY");
					}else if(cellValue.equals("客户签收单原件返回")){
						netOrderEntity.setEinoSignBack("SIGNORIGINAL");
					}
				}else if(compare(j,map.get(Constants.BATCH_ORDER_TMALL_FIELD.REMARK))){
					netOrderEntity.setEinoRemark(cellValue);
				}
			}
			if(isNull != true){
				if(netOrderEntity.getEinoShipperEbpvName() == null || netOrderEntity.getEinoShipperEbpvName().equals("") || 
						netOrderEntity.getEinoShipperEbplNameCn() == null || netOrderEntity.getEinoShipperEbplNameCn().equals("") || 
						netOrderEntity.getEinoShipperAreaName() == null || netOrderEntity.getEinoShipperAreaName().equals("")){
					netOrderEntity.setConsigneeDistrict(null);
				}else{
					netOrderEntity.setConsigneeDistrict(netOrderEntity.getEinoShipperEbpvName()+"-"+
							netOrderEntity.getEinoShipperEbplNameCn()+"-"+
							netOrderEntity.getEinoShipperAreaName());
				}
				this.putBatchOrder(netOrderEntity,BatchOrderAction.TMALL,true);
				this.errorMsg = null;
			}
		}
	}
	
	private boolean compare(int i,Integer index){
		if(index == null){
			return false;
		}else{
			return i == index;
		}
	}
	
	private Map<String,Integer> queryTitle(Row row){
		Map<String,Integer> map = new HashMap<String,Integer>();
		int cellNum = row.getLastCellNum();
		for (int i = 0; i < cellNum; i++) {
			Cell cell = row.getCell(i);
			String cellValue = cell.getStringCellValue();
			if(cellValue.startsWith("收货人姓名")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_CONTACT,i);
			}else if(cellValue.startsWith("收货地址")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_ADDRESS,i);
			}else if(cellValue.startsWith("联系电话")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_TEL,i);
			}else if(cellValue.startsWith("联系手机")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.CONSIGNEE_EBSA_MOBILE,i);
			}else if(cellValue.startsWith("宝贝标题")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.CARGO_NAME,i);
			}else if(cellValue.startsWith("运输方式")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.PRODUCT_TYPE_NAME,i);
			}else if(cellValue.startsWith("送货方式")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.SHIPPER_METHOD,i);
			}else if(cellValue.startsWith("付款方式")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.PAYMENT_METHOD,i);
			}else if(cellValue.startsWith("货物件数")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.NUMBER,i);
			}else if(cellValue.startsWith("货物重量")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.TOTAL_WEIGHT,i);
			}else if(cellValue.startsWith("货物体积")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.TOTAL_VOLUME,i);
			}else if(cellValue.startsWith("货物包装")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.PACKAGE,i);
			}else if(cellValue.startsWith("保价声明")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.INSURANCE,i);
			}else if(cellValue.startsWith("签收单")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.SIGN_BACK,i);
			}else if(cellValue.startsWith("备注")){
				map.put(Constants.BATCH_ORDER_TMALL_FIELD.REMARK,i);
			}
		}
		return map;
	}
	
	/**
	 * 顺丰订单处理逻辑
	 * @author 莫涛
	 * @date 2015年12月9日11:31:40
	 * @update
	 */
	private void sfOrder(Sheet sheet,boolean isNull){
		//最大
		for(int i=1;i<MAX_ROW_SIZE;i++){
			NetOrderEntity netOrderEntity = new NetOrderEntity();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			if(isNull == true){
				break;
			}
			for(int j=1;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = null;
				if(cell == null){
					continue;
				}
				switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
					case 1 : cellValue = cell.getStringCellValue(); break;
					case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
					case 3 : cellValue = ""; break;
					case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
					case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
				}
				if(j == 1 && cellValue.equals("")){
					isNull = true;
					break;
				}
				switch(j){//通过列数来判断对应插如的字段
					case 1 : 
						//发件人公司*
						netOrderEntity.setEinoShipperEbspNameCn(cellValue);
						break;
					case 2 : 
						//发件人姓名*
						netOrderEntity.setEinoShipperEbsaContact(cellValue);
						break;
					case 3 : 
						//发件人联系方式
						if(cellValue.indexOf("-") > 0){
							netOrderEntity.setEinoShipperEbsaTel(cell.getStringCellValue());
						}else{
							try{
								if(cell.getCellType() == 1){
									netOrderEntity.setEinoShipperEbsaMobile(cellValue);
								}else{
									DecimalFormat df = new DecimalFormat("0");  
									String mobile = df.format(cell.getNumericCellValue());
									if(mobile == null || mobile.equals("0")){
										mobile = null;
									}
									netOrderEntity.setEinoShipperEbsaMobile(mobile);
								}
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						break;
					case 4 : 
						//发货省
						netOrderEntity.setEinoShipperEbpvName(cellValue);
						break;
					case 5 : 
						//发货市
						netOrderEntity.setEinoShipperEbplNameCn(cellValue);
						break;
					case 6 : 
						//发货区
						netOrderEntity.setEinoShipperAreaName(cellValue);
						break;
					case 7 : 
						//发货详细地址
						netOrderEntity.setEinoShipperEbsaAddress(cellValue);
						break;
					case 8 : 
						//收货人公司
						netOrderEntity.setEinoConsigneeEbsaMobile(cellValue);
						break;
					case 9 :
						//收货人名称
						netOrderEntity.setEinoConsigneeEbsaContact(cellValue);
						netOrderEntity.setEinoConsigneeEbspNameCn(cellValue);
						break;
					case 10 : 
						//收货人联系方式
						if(cellValue.indexOf("-") > 0){
							netOrderEntity.setEinoConsigneeEbsaTel(cell.getStringCellValue());
						}else{
							try{
								if(cell.getCellType() == 1){
									netOrderEntity.setEinoConsigneeEbsaMobile(cellValue);
								}else{
									DecimalFormat df = new DecimalFormat("0");  
									String mobile = df.format(cell.getNumericCellValue());
									if(mobile == null || mobile.equals("0")){
										mobile = null;
									}
									netOrderEntity.setEinoConsigneeEbsaMobile(mobile);
								}
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						break;
					case 11 : 
						//收货省
						netOrderEntity.setEinoConsigneeEbpvName(cellValue);
						break;
					case 12 : 
						//收货市
						netOrderEntity.setEinoConsigneeEbplNameCn(cellValue);
						break;
					case 13 :
						//收货区
						netOrderEntity.setEinoConsigneeEbrgNameCn(cellValue);
						break;
					case 14 : 
						//收货详细地址
						netOrderEntity.setEinoConsigneeEbsaAddress(cellValue);
						break;
					case 15 : 
						if(cellValue != null && !cellValue.equals("")){
							if(cellValue.equals("现付")){
								cellValue = "1";
							}else if(cellValue.equals("到付")){
								cellValue = "2";
							}else if(cellValue.equals("第三方结算")){
								cellValue = "3";
							}
							//付款方式
							netOrderEntity.setEinoPaymentMethod(cellValue);
						}
						break;
					case 16 : 
						//运输方式
						if(cellValue != null && !cellValue.equals("")){
							if(cellValue.equals("标准快递")){
								cellValue = "1";
							}else if(cellValue.equals("顺丰特惠")){
								cellValue = "2";
							}else if(cellValue.equals("电商特惠")){
								cellValue = "3";
							}else if(cellValue.equals("顺丰次晨")){
								cellValue = "5";
							}else if(cellValue.equals("即日件")){
								cellValue = "6";
							}else if(cellValue.equals("物流普运")){
								cellValue = "13";
							}else if(cellValue.equals("行邮专列")){
								cellValue = "20";
							}
							netOrderEntity.setEinoProductTypeName(cellValue);
						}
						break;
					case 17 : 
						//备注
						netOrderEntity.setEinoRemark(cellValue);
						break;
				}
			}
			if(isNull != true){
				//设置渠道名称
				netOrderEntity.setEinoOrign("SF_ORDER");
				this.putBatchOrder(netOrderEntity,BatchOrderAction.SF,false);
				this.errorMsg = null;
			}
		}
	}
	
	/**
	 * 普通订单处理逻辑
	 * @author 莫涛
	 * @date 2015年10月15日
	 * @update
	 */
	private void ordinaryOrder(Sheet sheet,boolean isNull){
		//最大
		for(int i=1;i<MAX_ROW_SIZE;i++){
			NetOrderEntity netOrderEntity = new NetOrderEntity();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			if(isNull == true){
				break;
			}
			for(int j=1;j<cellNum;j++){
				Cell cell = row.getCell(j);
				String cellValue = null;
				if(cell == null){
					continue;
				}
				switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
					case 1 : cellValue = cell.getStringCellValue(); break;
					case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
					case 3 : cellValue = ""; break;
					case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
					case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
				}
				if(j == 2 && cellValue.equals("")){
					isNull = true;
					break;
				}
				switch(j){//通过列数来判断对应插如的字段
					case 1 : 
						netOrderEntity.setEinoProductTypeName(cellValue);
						break;
					case 2 : 
						if(cellValue.equals("自提")){
							cellValue = "SELF_TAKE";
						}else if(cellValue.equals("送货上门")){
							cellValue = "DOORSTEP";
						}else if(cellValue.equals("送货上楼")){
							cellValue = "UPSTAIR";
						}else if(cellValue.equals("安装")){
							cellValue = "INSTALL";
						}
						netOrderEntity.setEinoShipperMethod(cellValue);
						break;
					case 3 : 
						if(cellValue.equals("到付")){
							cellValue = "ARRIVE_PAYMENT";
						}else if(cellValue.equals("现付")){
							cellValue = "CASH";
						}else if(cellValue.equals("月结")){
							cellValue = "Monthly_Statement";
						}
						netOrderEntity.setEinoPaymentMethod(cellValue);
						break;
					case 4 : 
						//收货人
						netOrderEntity.setEinoConsigneeEbsaContact(cellValue);
						break;
					case 5 : 
						//收货人联系方式
						if(cellValue.indexOf("-") > 0){
							netOrderEntity.setEinoConsigneeEbsaTel(cell.getStringCellValue());
						}else{
							try{
								if(cell.getCellType() == 1){
									netOrderEntity.setEinoConsigneeEbsaMobile(cellValue);
								}else{
									DecimalFormat df = new DecimalFormat("0");  
									String mobile = df.format(cell.getNumericCellValue());
									if(mobile == null || mobile.equals("0")){
										mobile = null;
									}
									netOrderEntity.setEinoConsigneeEbsaMobile(mobile);
								}
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
						break;
					case 6 : 
						//省
						netOrderEntity.setEinoConsigneeEbpvName(cellValue);
						break;
					case 7 : 
						//市
						netOrderEntity.setEinoConsigneeEbplNameCn(cellValue);
						break;
					case 8 : 
						//区
						netOrderEntity.setEinoConsigneeEbrgNameCn(cellValue);
						break;
					case 9 : 
						//详细地址
						netOrderEntity.setEinoConsigneeEbsaAddress(cellValue);
						break;
					case 10 : 
						//货物名称
						netOrderEntity.setEinoCargoName(cellValue);
						break;
					case 11 :
						//货物件数
						if(StringUtil.isNumber(cellValue) && Long.parseLong(cellValue) > 0){
							netOrderEntity.setEinoNumber(Long.parseLong(cellValue));
						}else{
							netOrderEntity.setEinoNumber(0L);
						}
						break;
					case 12 : 
						//重量
						if(StringUtil.isNumber(cellValue)){
							DecimalFormat df = new DecimalFormat("0.00");  
							String totalWeight = df.format(cell.getNumericCellValue());
							netOrderEntity.setEinoTotalWeight(Double.parseDouble(totalWeight));
						}else{
							netOrderEntity.setEinoTotalWeight(0D);
						}
						break;
					case 13 : 
						//体积
						if(StringUtil.isNumber(cellValue)){
							DecimalFormat df = new DecimalFormat("0.00");  
							String totalVolume = df.format(cell.getNumericCellValue());
							netOrderEntity.setEinoTotalVolume(Double.parseDouble(totalVolume));
						}else{
							netOrderEntity.setEinoTotalVolume(0D);
						}
						break;
					case 14 : 
						//包装类型
						netOrderEntity.setEinoPackage(cellValue);
						break;
					case 15 :
						//保价声明
						if(StringUtil.isNumber(cellValue)){
							DecimalFormat df = new DecimalFormat("0.00");  
							String insurance = df.format(cell.getNumericCellValue());
							netOrderEntity.setEinoInsurance(Double.parseDouble(insurance));
						}else{
							netOrderEntity.setEinoInsurance(0D);
						}
						break;
					case 16 : 
						if(cellValue.equals("无需返单")){
							netOrderEntity.setEinoSignBack("NOBACK");
						}else if(cellValue.equals("客户出库单原件返回")){
							netOrderEntity.setEinoSignBack("CUSTORIGINAL");
						}else if(cellValue.equals("客户出库单传真返回")){
							netOrderEntity.setEinoSignBack("CUSTCOPY");
						}else if(cellValue.equals("客户签收单传真返回")){
							netOrderEntity.setEinoSignBack("SIGNCOPY");
						}else if(cellValue.equals("客户签收单原件返回")){
							netOrderEntity.setEinoSignBack("SIGNORIGINAL");
						}
						break;
					case 17 : 
						netOrderEntity.setEinoRemark(cellValue);
						break;
				}
			}
			if(isNull != true){
				if(netOrderEntity.getEinoConsigneeEbpvName() == null || netOrderEntity.getEinoConsigneeEbpvName().equals("") || 
						netOrderEntity.getEinoConsigneeEbplNameCn() == null || netOrderEntity.getEinoConsigneeEbplNameCn().equals("") || 
						netOrderEntity.getEinoConsigneeEbrgNameCn() == null || netOrderEntity.getEinoConsigneeEbrgNameCn().equals("")){
					netOrderEntity.setConsigneeDistrict(null);
				}else{
					netOrderEntity.setConsigneeDistrict(netOrderEntity.getEinoConsigneeEbpvName()+"-"+
							netOrderEntity.getEinoConsigneeEbplNameCn()+"-"+
							netOrderEntity.getEinoConsigneeEbrgNameCn());
				}
				this.putBatchOrder(netOrderEntity,"",true);
				this.errorMsg = null;
			}
		}
	}
	
	/**
	 * 校验网上订单信息
	 * @param model
	 * @return
	 */
	private void checkEiNetOrder(NetOrderEntity entity){
		if(entity.getEinoId() != null){
			setThisErrorMsg("请勿重复提交订单！");
		}else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //发货人为null 或 “”时
			setThisErrorMsg("发货人不能为空！");
		}else if((EmptyUtils.isEmpty(entity.getEinoShipperEbsaMobile()) || 
				"".equals(entity.getEinoShipperEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoShipperEbsaTel()) || 
						"".equals(entity.getEinoShipperEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("发货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getShipperDistrict()) || 
				"".equals(entity.getShipperDistrict())){
			setThisErrorMsg("发货人省市区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaAddress()) || 
				"".equals(entity.getEinoShipperEbsaAddress())){ //发货地址为null 或 “”时
			setThisErrorMsg("发货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //收货人为null 或 “”时
			setThisErrorMsg("收货人不能为空！");
		}  else if((EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaMobile()) || 
				"".equals(entity.getEinoConsigneeEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaTel()) || 
						"".equals(entity.getEinoConsigneeEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("收货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getConsigneeDistrict()) || 
				"".equals(entity.getConsigneeDistrict())){
			setThisErrorMsg("收货人省市区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaAddress()) ||
				"".equals(entity.getEinoConsigneeEbsaAddress())){ //收货地址为null 或 “”时
			setThisErrorMsg("收货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoCargoName()) || 
				"".equals(entity.getEinoCargoName())){ //货物名称为null 或 “”时
			setThisErrorMsg("货物名称不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoNumber().toString()) || 
				"".equals(entity.getEinoNumber()) || entity.getEinoNumber() <=0 ){ //货物件数为null 或 “”时或为零
			setThisErrorMsg("货物件数不能为空/不能小于等于零！");
		} else if(EmptyUtils.isEmpty(entity.getEinoProductTypeName()) || 
				"".equals(entity.getEinoProductTypeName())){ //运输方式为null 或 “”时
			setThisErrorMsg("运输方式不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperMethod()) || 
				"".equals(entity.getEinoShipperMethod())){ //送货方式为null 或 “”时
			setThisErrorMsg("送货方式不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoPaymentMethod()) || 
				"".equals(entity.getEinoPaymentMethod())){ //付款方式为null 或 “”时
			setThisErrorMsg("付款方式不能为空！");
		}
	}
	
	/**
	 * 校验天猫订单信息
	 * @param model
	 * @return
	 */
	private void checkTmallOrder(NetOrderEntity entity){
		if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //发货人为null 或 “”时
			setThisErrorMsg("发货人不能为空！");
		}else if((EmptyUtils.isEmpty(entity.getEinoShipperEbsaMobile()) || 
				"".equals(entity.getEinoShipperEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoShipperEbsaTel()) || 
						"".equals(entity.getEinoShipperEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("发货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getShipperDistrict()) || 
				"".equals(entity.getShipperDistrict())){
			setThisErrorMsg("发货人省市区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaAddress()) || 
				"".equals(entity.getEinoShipperEbsaAddress())){ //发货地址为null 或 “”时
			setThisErrorMsg("发货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //收货人为null 或 “”时
			setThisErrorMsg("收货人不能为空！");
		}  else if((EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaMobile()) || 
				"".equals(entity.getEinoConsigneeEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaTel()) || 
						"".equals(entity.getEinoConsigneeEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("收货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaAddress()) ||
				"".equals(entity.getEinoConsigneeEbsaAddress())){ //收货地址为null 或 “”时
			setThisErrorMsg("收货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoCargoName()) || 
				"".equals(entity.getEinoCargoName())){ //货物名称为null 或 “”时
			setThisErrorMsg("货物名称不能为空！");
		}
	}
	
	/**
	 * 校验顺丰订单信息
	 * @param model
	 * @return
	 */
	private void checkSfOrder(NetOrderEntity entity){
		if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //发货人为null 或 “”时
			setThisErrorMsg("发货人不能为空！");
		}else if((EmptyUtils.isEmpty(entity.getEinoShipperEbspNameCn()) || 
				"".equals(entity.getEinoShipperEbspNameCn()))){ //发货人公司为null 或 “”时
			setThisErrorMsg("发货人公司为空！");
		}else if((EmptyUtils.isEmpty(entity.getEinoShipperEbsaMobile()) || 
				"".equals(entity.getEinoShipperEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoShipperEbsaTel()) || 
						"".equals(entity.getEinoShipperEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("发货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbpvName()) || 
				"".equals(entity.getEinoShipperEbpvName())){
			setThisErrorMsg("发货人省不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbplNameCn()) || 
				"".equals(entity.getEinoShipperEbplNameCn())){
			setThisErrorMsg("发货人市不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperAreaName()) || 
				"".equals(entity.getEinoShipperAreaName())){
			setThisErrorMsg("发货人区县不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaAddress()) || 
				"".equals(entity.getEinoShipperEbsaAddress())){ //发货地址为null 或 “”时
			setThisErrorMsg("发货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //收货人为null 或 “”时
			setThisErrorMsg("收货人不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbspNameCn()) || 
				"".equals(entity.getEinoConsigneeEbspNameCn())){  //收货人公司为null 或 “”时
			setThisErrorMsg("收货公司不能为空！");
		}  else if((EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaMobile()) || 
				"".equals(entity.getEinoConsigneeEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaTel()) || 
						"".equals(entity.getEinoConsigneeEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("收货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbpvName()) ||
				"".equals(entity.getEinoConsigneeEbpvName())){ //收货省为null 或 “”时
			setThisErrorMsg("收货省不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbplNameCn()) ||
				"".equals(entity.getEinoConsigneeEbplNameCn())){ //收货市为null 或 “”时
			setThisErrorMsg("收货市不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbrgNameCn()) ||
				"".equals(entity.getEinoConsigneeEbrgNameCn())){ //收货区为null 或 “”时
			setThisErrorMsg("收货区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaAddress()) ||
				"".equals(entity.getEinoConsigneeEbsaAddress())){ //收货地址为null 或 “”时
			setThisErrorMsg("收货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoPaymentMethod()) || 
				"".equals(entity.getEinoPaymentMethod())){ //付款方式为null 或 “”时
			setThisErrorMsg("付款方式不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoProductTypeName()) || 
				"".equals(entity.getEinoProductTypeName())){ //运输方式为null 或 “”时
			setThisErrorMsg("运输方式不能为空！");
		}
	}
	
	private void setThisErrorMsg(String msg){
		String elsemessages = "";
		try {
			elsemessages = URLEncoder.encode("<p class='erro'><span class='icon_del'></span>"+msg+"</p>", "utf-8");
			this.errorMsg = elsemessages;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private void setThisSuccessMsg(String msg){
		String elsemessages = "";
		try {
			elsemessages = URLEncoder.encode("<p class='succ'><span class='icon_succ'></span>"+msg+"</p>", "utf-8");
			this.errorMsg = elsemessages;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public NetOrderEntity getEntity() {
		return entity;
	}

	public void setEntity(NetOrderEntity entity) {
		this.entity = entity;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErrorType() {
		return errorType;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Paging<NetOrderEntity> getPaging() {
		return paging;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}