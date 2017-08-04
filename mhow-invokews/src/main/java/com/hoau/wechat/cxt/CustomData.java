package com.hoau.wechat.cxt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import com.hoau.wechat.util.JsonUtils;


public class CustomData {
	private int count;
	private List<Custom> data;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Custom> getData() {
		return data;
	}
	public void setData(List<Custom> data) {
		this.data = data;
	}
	
	public static void main(String[] args) throws IOException {
//		for(int i = 1; i< 23 ;i++){
//			ex(i);
//		}
//		ex(21);
		ex(22);
	}
	private static void ex(int i) throws FileNotFoundException, IOException {
		String file = "queryCustomer ("+i+").json";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = br.readLine())!=null){
			sb.append(line);
		}
		String jsonStr = sb.toString();
		CustomData customData = JsonUtils.toObject(jsonStr, CustomData.class);
		System.out.println(customData.getData().size());
		
		PrintWriter pw = new PrintWriter(new FileOutputStream("result.txt", true));
		for(Custom custom : customData.getData()){
			pw.print(custom.getCustomerInfoVO());
			pw.print("\r\n");
		}
		pw.close();
		br.close();
	}
	
}
