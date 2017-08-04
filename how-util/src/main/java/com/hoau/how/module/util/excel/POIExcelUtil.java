package com.hoau.how.module.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExcelUtil {
	public static final String FILE_EXTENSION_XLS = "xls";
	public static final String FILE_EXTENSION_XLSX = "xlsx";

	public static SimpleDateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @param Map
	 *            <String,String> maps 属性表，成员属性age为KEY，中文名称为VALUE
	 * @param List
	 *            <T> list 需要导出的数据列表对象
	 * @param File
	 *            file 指定输出文件位置，只能导出excel2003以上版本
	 * 
	 * @return true 导出成功 false 导出失败
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> boolean excelExport(Map<String, String> maps,
			List<T> list, File file) {
		try {
			Workbook wb = null;
			String filename = file.getName();
			String type = filename.substring(filename.lastIndexOf(".") + 1)
					.toLowerCase();
			if (type.equals(FILE_EXTENSION_XLS)) {
				wb = new HSSFWorkbook();
			}
			if (type.equals(FILE_EXTENSION_XLSX)) {
				wb = new XSSFWorkbook();
			}
			CreationHelper createHelper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet("sheet1");
			Set<String> sets = maps.keySet();
			Row row = sheet.createRow(0);
			int i = 0;
			// 定义表头
			for (Iterator<String> it = sets.iterator(); it.hasNext();) {
				String key = it.next();
				Cell cell = row.createCell(i++);
				cell.setCellValue(createHelper.createRichTextString(maps
						.get(key)));
			}
			// 填充表单内容
			System.out.println("--------------------100%");
			float avg = list.size() / 20f;
			int count = 1;
			for (int j = 0; j < list.size(); j++) {
				T p = list.get(j);
				Class classType = p.getClass();
				int index = 0;
				Row row1 = sheet.createRow(j + 1);
				for (Iterator<String> it = sets.iterator(); it.hasNext();) {
					String key = it.next();
					String firstLetter = key.substring(0, 1).toUpperCase();
					// 获得和属性对应的getXXX()方法的名字
					String getMethodName = "get" + firstLetter
							+ key.substring(1);
					// 获得和属性对应的getXXX()方法
					Method getMethod = classType.getMethod(getMethodName,
							new Class[] {});
					// 调用原对象的getXXX()方法
					Object value = getMethod.invoke(p, new Object[] {});
					if (value instanceof Date) {
						value = df.format(value);  
					}
					Cell cell = row1.createCell(index++);
					cell.setCellValue(value == null ? "" : value.toString());
				}
				if (j > avg * count) {
					count++;
					System.out.print("I");
				}
				if (count == 20) {
					System.out.print("I100%");
					count++;
				}
			}
			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return false;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// Map<String, String> maps = new LinkedHashMap<String, String>();
		// maps.put("id", "ID");
		// maps.put("name", "姓名");
		// maps.put("age", "年龄");
		// maps.put("birthday", "生日");
		//
		// Properties props = System.getProperties();
		// String USER_HOME = props.getProperty("user.home");
		// System.out.println(USER_HOME);
		// File file = new File(USER_HOME + "/Desktop/excelExport.xlsx");
		//
		// List<User> demo = new ArrayList<User>();
		//
		// for (int i = 0; i < 100; i++) {
		// User user = new User();
		// user.setAge(10 + i);
		// user.setBirthday(new Date());
		// user.setId("001" + i);
		// user.setName("name" + i);
		// demo.add(user);
		// }
		// POIExcelUtil.excelExport(maps, demo, file);
	}
}
