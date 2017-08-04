package com.hoau.how.module.bse.shared.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hoau.how.module.bse.shared.vo.NewExcelDataVo;

public class ExportExcel {
	public static void exportExcel(List<List<NewExcelDataVo>> resultList, String outputPath){
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet();
		sheet.setDefaultColumnWidth((int) 15);
		HSSFCellStyle style = workBook.createCellStyle(); 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCell cell;
		for (int i = 0; i < NewExcelDataVo.title.length; i++){
			cell = row.createCell((int) i);
			cell.setCellValue(NewExcelDataVo.title[i]);
			cell.setCellStyle(style);
		}
		int size = resultList.size();
		for (int i = 0; i < size; i++){
			int cnt = 0;
			row = sheet.createRow( i + 1);
			List<NewExcelDataVo> list = resultList.get(i);
			if(list != null && list.size() > 0){
				NewExcelDataVo bean = list.get(0);
				row.createCell(cnt++).setCellValue(bean.getDestinationAddress());
				row.createCell(cnt++).setCellValue(bean.getDispatchCompany());
				row.createCell(cnt++).setCellValue(bean.getDispatchCompanyName());
				row.createCell(cnt++).setCellValue(bean.getDispatchPhone());
				row.createCell(cnt++).setCellValue(bean.getDispatchAddress());
				row.createCell(cnt++).setCellValue(bean.getDispatchDistance());
				row.createCell(cnt++).setCellValue(bean.getDispatchMsg());
				for (int j = 0; j < list.size(); j++) {
					row.createCell(cnt++).setCellValue(list.get(j).getStCompanyCode());
					row.createCell(cnt++).setCellValue(list.get(j).getStCompanyName());
					row.createCell(cnt++).setCellValue(list.get(j).getStCompanyPhone());
					row.createCell(cnt++).setCellValue(list.get(j).getStCompanyAddress());
					row.createCell(cnt++).setCellValue(list.get(j).getStDistance());
				}
			}else{
				for (int j = 0; j < NewExcelDataVo.title.length; j++) {
					row.createCell(cnt++);
				}
			}
		}
		
		FileOutputStream output = null;
		try{
			output = new FileOutputStream(new File(outputPath));
			workBook.write(output);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				if(output != null){
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
