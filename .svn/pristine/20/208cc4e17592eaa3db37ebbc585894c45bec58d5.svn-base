package com.hoau.how.module.bse.server.service.company.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.server.dao.company.CompanyQueryMapper;
import com.hoau.how.module.bse.server.service.company.GisServer;
import com.hoau.how.module.bse.server.service.company.QueryGisServer;
import com.hoau.how.module.bse.shared.utils.ExportExcel;
import com.hoau.how.module.bse.shared.utils.ReadExcelUtil;
import com.hoau.how.module.bse.shared.vo.NewExcelDataVo;
import com.hoau.how.module.bse.shared.vo.OldExcelDataVo;
import com.hoau.how.module.itf.shared.domain.DepartmentEntity;

/**
 * QueryGisServer
 * 
 * @author Guixing Lv guixing.lv@hoau.net
 * @Time 2015年6月17日 下午5:59:14
 * @Description 批量查询Server
 * @version 1.0.0
 */
@Service
public class QueryGisServerImpl implements QueryGisServer {
	@Resource
	GisServer gisServer;
	@Resource
	CompanyQueryMapper companyQueryMapper;
	@Override
	public void queryGisServer(String filePath, String excelType, String outputPath) throws Exception{
		File file = new File(filePath);
		List<OldExcelDataVo> oldDataList;
		if (file.exists()) {
			oldDataList = ReadExcelUtil.readExcel(file, excelType);
			
			List<NewExcelDataVo> newList = new ArrayList<NewExcelDataVo>();
			newList = gisServer.getGisResult(oldDataList,outputPath);
			List<List<NewExcelDataVo>> resultList = new ArrayList<List<NewExcelDataVo>>();
			if(newList.size() > 0){
				for (int i = 0; i < newList.size(); i++) {
					NewExcelDataVo newExcelDataVo = newList.get(i);
					DepartmentEntity dispatchCompany = queryDeptName(newExcelDataVo.getDispatchCompany());
					if(dispatchCompany != null){
						//设置派送公司名称
						newExcelDataVo.setDispatchCompanyName(dispatchCompany.getDeptName());
						//设置派送公司电话
						newExcelDataVo.setDispatchPhone(dispatchCompany.getPhone());
						//设置派送公司地址
						newExcelDataVo.setDispatchAddress(dispatchCompany.getAddressDetail());
					}
					if(newExcelDataVo.getTakeTheirCompany() != null && newExcelDataVo.getTakeTheirCompany().size() > 0 &&
							newExcelDataVo.getSelfTakeDistance() != null && newExcelDataVo.getSelfTakeDistance().size() > 0){
						List<DepartmentEntity> deptList = queryDeptNames(newExcelDataVo.getTakeTheirCompany());
						handleData(newExcelDataVo, deptList,resultList);
					}
				}
			}
			
			//如果未匹配到的数据，进行相应处理
			for (int i = 0; i < oldDataList.size(); i++) {
				OldExcelDataVo vo = oldDataList.get(i);
				boolean exists = false;
				for (int j = 0; j < resultList.size(); j++) {
					List<NewExcelDataVo> nedvList = resultList.get(j);
					if(nedvList != null && nedvList.size() > 0){
						try{
							String address = nedvList.get(0).getDestinationAddress();
							//存在，则表示GIS中有匹配到
							if(address.equals(vo.getDestinationAddress())){
								exists = true;
								break;
							}
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
				}
				//如果未匹配到，则添加一条未匹配到的数据到数据库中
				if(exists == false){
					List<NewExcelDataVo> nedvList = new ArrayList<NewExcelDataVo>();
					NewExcelDataVo nedVo = new NewExcelDataVo();
					nedVo.setDestinationAddress(vo.getDestinationAddress());
					nedVo.setDispatchCompanyName("该地址未匹配到对应网点！");
					nedvList.add(nedVo);
					resultList.add(nedvList);
				}
			}
			ExportExcel.exportExcel(resultList,outputPath);
		} else {
			throw new Exception("文件不存在");
		}
	}
	
	private void handleData(NewExcelDataVo newExcelDataVo,List<DepartmentEntity> deptList,List<List<NewExcelDataVo>> resultList){
		List<NewExcelDataVo> list = new ArrayList<NewExcelDataVo>();
		for (int i = 0; i < newExcelDataVo.getTakeTheirCompany().size(); i++) {
			if(i == 3){
				break;
			}
			NewExcelDataVo vo = new NewExcelDataVo();
			vo.setSerial(String.valueOf(i));
			vo.setStartCompany(newExcelDataVo.getStartCompany());
			vo.setDispatchCompany(newExcelDataVo.getDispatchCompany());
			vo.setDestinationAddress(newExcelDataVo.getDestinationAddress());
			vo.setDispatchCompanyName(newExcelDataVo.getDispatchCompanyName());
			vo.setDispatchPhone(newExcelDataVo.getDispatchPhone());
			vo.setDispatchAddress(newExcelDataVo.getDispatchAddress());
			vo.setDispatchDistance(newExcelDataVo.getDispatchDistance());
			vo.setDispatchMsg(newExcelDataVo.getDispatchMsg());
			vo.setStDistance(newExcelDataVo.getSelfTakeDistance().get(i));
			String takeTheirCompany = newExcelDataVo.getTakeTheirCompany().get(i);
			for (int j = 0; j < deptList.size(); j++) {
				if(deptList.get(j).getLogistCode().equals(takeTheirCompany)){
					vo.setStCompanyCode(deptList.get(j).getLogistCode());
					vo.setStCompanyName(deptList.get(j).getDeptName());
					vo.setStCompanyPhone(deptList.get(j).getPhone());
					vo.setStCompanyAddress(deptList.get(j).getAddressDetail());
					break;
				}
			}
			list.add(vo);
		}
		resultList.add(list);
	}
	
	@Override
	public List<DepartmentEntity> queryDeptNames(List<String> logistNames){
		return companyQueryMapper.queryDeptNames(logistNames);
	}
	
	@Override
	public DepartmentEntity queryDeptName(String logistName){
		List<DepartmentEntity> list = companyQueryMapper.queryDeptName(logistName);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
