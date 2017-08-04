package com.hoau.how.module.bse.shared.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hoau.how.module.bse.shared.vo.OldExcelDataVo;

/**
 * ReadExcelUtil
 * 
 * @author Guixing Lv guixing.lv@hoau.net
 * @Time 2015年6月16日 下午6:58:44
 * @Description 读取Excel内容
 * @version 1.0.0
 */
public class ReadExcelUtil{
	public static List<OldExcelDataVo> readExcel(File file , String excelType) throws Exception{
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			if (StrUtil.equalsString("xlsx", excelType)){
				return new ReadExcelUtil().readXlsx(is);
			} else if (StrUtil.equalsString("xls", excelType)) {
				return new ReadExcelUtil().readXls(is);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("读取Excel异常");
		} catch (Exception ex){
			throw ex;
		}finally{
			if(is != null){
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private List<OldExcelDataVo> readXlsx(InputStream is) {
		OPCPackage pkg;
		XSSFWorkbook wb;
		try {
			pkg = OPCPackage.open(is);
			wb = new XSSFWorkbook(pkg);
		} catch (Exception e) {
			throw new RuntimeException("Excel读取失败");
		}
		Sheet sheet = wb.getSheetAt(0);
		int numberOfRow = sheet.getPhysicalNumberOfRows();
		int numberOfCell = sheet.getRow(numberOfRow - 1).getPhysicalNumberOfCells();  
		check(numberOfRow, numberOfCell);
		List<OldExcelDataVo> list = new ArrayList<OldExcelDataVo>();
		for (int i = 1; i < numberOfRow; i++) {
			if (sheet.getRow(i) == null) {
				continue;
			}
			
			OldExcelDataVo data = new OldExcelDataVo();
			Map<Integer, String> tempMap = new HashMap<Integer, String>();
			boolean flag = false;
			for (int j = 0; j < numberOfCell; j++) {
				String cellValue = getCellValue(sheet.getRow(i).getCell(j), 0);
				if (StrUtil.isEmpty(cellValue)) {
					flag = true;
					break;
				}
				tempMap.put(j, cellValue);
			}
			if(flag){
				continue;
			}
			data.setDestinationAddress(tempMap.get(0));
			list.add(data);
		}
		return list;
	}
	
	private List<OldExcelDataVo> readXls(InputStream is) {
		POIFSFileSystem fs;
		HSSFWorkbook wb;
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (Exception e) {
			throw new RuntimeException("Excel读取失败");
		}
		Sheet sheet = wb.getSheetAt(0);
		int numberOfRow = sheet.getPhysicalNumberOfRows();
		int numberOfCell = sheet.getRow(numberOfRow - 1).getPhysicalNumberOfCells();  
		check(numberOfRow, numberOfCell);
		List<OldExcelDataVo> list = new ArrayList<OldExcelDataVo>();
		for (int i = 1; i < numberOfRow; i++) {
			if (sheet.getRow(i) == null) {
				continue;
			}
			OldExcelDataVo data = new OldExcelDataVo();
			Map<Integer, String> tempMap = new HashMap<Integer, String>();
			boolean flag = false;
			for (int j = 0; j < numberOfCell; j++) {
				String cellValue = getCellValue(sheet.getRow(i).getCell(j), 0);
				if (StrUtil.isEmpty(cellValue)) {
					flag = true;
					break;
				}
				tempMap.put(j, cellValue);
			}
			if (flag) {
				continue;
			}
			data.setDestinationAddress(tempMap.get(0));
			list.add(data);
		}
		return list;
	}
	
	private static void check(int rowNum, int columnNum) {
		if (rowNum > 51) {
			throw new RuntimeException("数据量超过50行，请减少数据");
		}
		if (columnNum != 1) {
			throw new RuntimeException("表格只能有一列，应为：目的地地址（省市区县街单元）");
		}
	}
	
	private static String getCellValue(Cell cell, int digit) {
		String ret = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case 0:
				// 如果是日期格式的
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = cell.getDateCellValue();
					ret = dateFormat.format(date);
				} else // 数字格式
				{
					if (digit >= 0) {
						ret = getScaledValue(cell.getNumericCellValue(), digit,
								true);
					} else {
						ret = String.valueOf(cell.getNumericCellValue());
					}
				}
				break;
			case 1:
				ret = cell.getStringCellValue().trim();
				break;
			case 4:
				ret = String.valueOf(cell.getBooleanCellValue()).trim();
				break;
			case 5:
				ret = String.valueOf(cell.getErrorCellValue()).trim();
				break;
			// 读出公式储存格计算後的值
			case 2:
				ret = getScaledValue(cell.getNumericCellValue(), 8, true);
				break;
			default:
				ret = "";
			}
		}
		return ret;
	}

	private static String getScaledValue(double original, int scale,
			boolean cutZero) {
		BigDecimal bd = new BigDecimal(original);
		bd = bd.divide(new BigDecimal("1"), scale >= 0 ? scale : 0, 4);
		String str = bd.toString();
		if (cutZero && scale > 0) {
			for (StringBuffer sb = new StringBuffer(str); sb.length() > 0;) {
				char c = sb.charAt(sb.length() - 1);
				if (c == '0' || c == '.') {
					sb.deleteCharAt(sb.length() - 1);
					if (c == '.')
						return sb.toString();
				} else {
					return sb.toString();
				}
			}

		}
		return str;
	}
}
