package com.hoau.how.module.bse.server.action.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.how.module.bse.server.service.company.ICompanyScreenService;
import com.hoau.how.module.bse.shared.utils.LatLngConvertUtil;
import com.hoau.how.module.bse.shared.vo.*;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.server.service.company.GisServer;
import com.hoau.how.module.bse.server.service.company.QueryGisServer;
import com.hoau.how.module.itf.shared.domain.DepartmentEntity;

/**
 * 到货网点查询
 * @author 莫涛
 * @date 2015年6月25日
 */
@Controller
@Scope("prototype")
public class CompanyQueryAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(CompanyQueryAction.class);
	List<NewExcelDataVo> destinationVos;
	private String destination;
	private String categoryName;
	@Resource
	private GisServer gisServer;
	@Resource
	private QueryGisServer queryGisServer;
	//到货网点匹配 地图详情
	private DepartmentVo departmentEntity;
	private String code;

	@Resource
	private ICompanyScreenService companyScreenService;

	public String index() throws Exception {
		return "index";
	}
	
	public String queryDestination(){
		try{
			if(destination != null && !destination.equals("")){
				List<OldExcelDataVo> list = new ArrayList<OldExcelDataVo>();
				OldExcelDataVo vo = new OldExcelDataVo();
				vo.setDestinationAddress(destination);
				list.add(vo);
				destinationVos = gisServer.getGisResult(list, null);
				if(destinationVos != null && destinationVos.size() > 0){
					NewExcelDataVo newExcelDataVo = destinationVos.get(0);
					DepartmentEntity dispatchCompany = queryGisServer.queryDeptName(newExcelDataVo.getDispatchCompany());
					if(dispatchCompany != null){
						//设置派送公司名称
						newExcelDataVo.setDispatchCompanyName(dispatchCompany.getDeptName());
						//设置派送公司电话
						newExcelDataVo.setDispatchPhone(dispatchCompany.getPhone());
						//设置派送公司地址
						newExcelDataVo.setDispatchAddress(dispatchCompany.getAddressDetail());
						newExcelDataVo.setServiceType(convertServiceName(dispatchCompany));
					}
					if(newExcelDataVo.getTakeTheirCompany() != null && newExcelDataVo.getTakeTheirCompany().size() > 0 &&
							newExcelDataVo.getSelfTakeDistance() != null && newExcelDataVo.getSelfTakeDistance().size() > 0){
						List<DepartmentEntity> deptList = queryGisServer.queryDeptNames(newExcelDataVo.getTakeTheirCompany());
						handleData(newExcelDataVo, deptList);
					}
				}
			}
		}catch(Exception ex){
			logger.error(ex);
			ex.printStackTrace();
		}
		return "index";
	}
	private String convertServiceName(DepartmentEntity vo){
		StringBuffer serviceName = new StringBuffer("");
		if(vo.getIsShipment().equals("Y")){
			serviceName.append("发货").append("、");
		}
		if(vo.getIsPickUp().equals("Y")){
			serviceName.append("自提").append("、");
		}
		if(vo.getIsDelivery().equals("Y")){
			serviceName.append("送货").append("、");
		}
		if(serviceName.length() > 0){
			serviceName.delete(serviceName.length()-1, serviceName.length());
		}
		return serviceName.toString();
	}

	private void handleData(NewExcelDataVo newExcelDataVo,List<DepartmentEntity> deptList){
		List<NewExcelDataVo> list = new ArrayList<NewExcelDataVo>();
		int row=0;
		//派送
		NewExcelDataVo vo = new NewExcelDataVo();
		vo.setCompanyCode(newExcelDataVo.getDispatchCompany());
		vo.setCompanyName(newExcelDataVo.getDispatchCompanyName());
		vo.setCompanyPhone(newExcelDataVo.getDispatchPhone());
		vo.setCompanyAddress(newExcelDataVo.getDispatchAddress());
		vo.setDistance(newExcelDataVo.getDispatchDistance());
		vo.setDispatchMsg(newExcelDataVo.getDispatchMsg());
		vo.setServiceType(newExcelDataVo.getServiceType());
		vo.setRownumber(row);
		list.add(vo);

		//自提
		for (int i = 0 ,lenth=newExcelDataVo.getTakeTheirCompany().size(); i < lenth; i++) {
			if(i == 4){
				break;
			}
			NewExcelDataVo vo2 = new NewExcelDataVo();
			vo2.setDistance(newExcelDataVo.getSelfTakeDistance().get(i));
			String takeTheirCompany = newExcelDataVo.getTakeTheirCompany().get(i);
			for (int j = 0; j < deptList.size(); j++) {
				if(deptList.get(j).getLogistCode().equals(takeTheirCompany)){
					vo2.setCompanyCode(deptList.get(j).getLogistCode());
					vo2.setCompanyName(deptList.get(j).getDeptName());
					vo2.setCompanyPhone(deptList.get(j).getPhone());
					vo2.setCompanyAddress(deptList.get(j).getAddressDetail());
					vo2.setServiceType(convertServiceName(deptList.get(j)));
					break;
				}
			}
			if (!takeTheirCompany.equals(newExcelDataVo.getDispatchCompany())){
				vo2.setRownumber(++row);
				list.add(vo2);
			}
		}
		this.destinationVos = list;
	}
//	private void handleData(NewExcelDataVo newExcelDataVo,List<DepartmentEntity> deptList){
//		List<NewExcelDataVo> list = new ArrayList<NewExcelDataVo>();
//		for (int i = 0; i < newExcelDataVo.getTakeTheirCompany().size(); i++) {
//			if(i == 3){
//				break;
//			}
//			NewExcelDataVo vo = new NewExcelDataVo();
//			vo.setSerial(String.valueOf(i));
//			vo.setDispatchCompany(newExcelDataVo.getDispatchCompany());
//			vo.setDestinationAddress(newExcelDataVo.getDestinationAddress());
//			vo.setDispatchCompanyName(newExcelDataVo.getDispatchCompanyName());
//			vo.setDispatchPhone(newExcelDataVo.getDispatchPhone());
//			vo.setDispatchAddress(newExcelDataVo.getDispatchAddress());
//			vo.setDispatchDistance(newExcelDataVo.getDispatchDistance());
//			vo.setDispatchMsg(newExcelDataVo.getDispatchMsg());
//			vo.setStDistance(newExcelDataVo.getSelfTakeDistance().get(i));
////			vo.setDispatchServiceType("送货");
//			String takeTheirCompany = newExcelDataVo.getTakeTheirCompany().get(i);
//			for (int j = 0; j < deptList.size(); j++) {
//				if(deptList.get(j).getLogistCode().equals(takeTheirCompany)){
//					vo.setStCompanyCode(deptList.get(j).getLogistCode());
//					vo.setStCompanyName(deptList.get(j).getDeptName());
//					vo.setStCompanyPhone(deptList.get(j).getPhone());
//					vo.setStCompanyAddress(deptList.get(j).getAddressDetail());
//					vo.setServiceType("自提");
//					break;
//				}
//			}
//			list.add(vo);
//		}
//		this.destinationVos = list;
//	}
	/**
	 * @author 唐征征
	 * @date 2017/7/24 下午5:05
	 * @description 到货网点匹配 查询地图详情
	 */
	public String queryArriveCompanyDetail(){
		try{
//			code = new String(code.getBytes("ISO-8859-1"),"UTF-8");
			departmentEntity = companyScreenService.queryCompanyDetail(code);
			if (departmentEntity.getServiceName().indexOf("送货")>0) {
				GisDestinationQueryResultDto boundsResult =gisServer.queryDestinationBoundsFromGis(departmentEntity.getAddressDetail(),String.valueOf(departmentEntity.getLat()),String.valueOf(departmentEntity.getLng()));
				List<GisOrgDto> boundsOrgDtos = boundsResult.getData().getResult();
				GisOrgDto boundsOrgDto=null;
				if (boundsOrgDtos.size()>0){
					boundsOrgDto=boundsOrgDtos.get(0);
				}
				if (boundsOrgDto != null) {
					String[] boundArray = boundsOrgDto.getBound().split(";");
					List<String> bounds = Arrays.asList(boundArray);
					for (int i = 0; i < bounds.size(); i++) {
						try {
							String bound = bounds.get(i);
							String[] latLngArray = bound.split(",");
							latLngArray[0] = String.valueOf(LatLngConvertUtil.latG2B(Double.valueOf(latLngArray[0])));
							latLngArray[1] = String.valueOf(LatLngConvertUtil.lngG2B(Double.valueOf(latLngArray[1])));
							bounds.set(i, latLngArray[0] + "_" + latLngArray[1]);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					// 服务范围
					departmentEntity.setBounds(bounds);
					// 背景颜色
					departmentEntity.setColor(boundsOrgDto.getColor());
				}
			}

		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "queryArriveCompanyDetail";
	}
	public List<NewExcelDataVo> getDestinationVos() {
		return destinationVos;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public DepartmentVo getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentVo departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}