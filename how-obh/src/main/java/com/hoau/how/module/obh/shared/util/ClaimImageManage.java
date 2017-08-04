package com.hoau.how.module.obh.shared.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hoau.how.module.common.constants.ClaimEnum;
import com.hoau.how.module.common.constants.SysConfigConstants;
import com.hoau.how.module.obh.shared.domain.ClaimSubmitEntity;
import com.hoau.how.module.obh.shared.domain.ImageEntity;
import com.hoau.how.module.util.ZipUtil;

public class ClaimImageManage {
	/**
	 * 
	* @Title: iamgeStore 
	* @Description: 查询理赔数据时，保存图片 
	* @param @param waybill
	* @param @param type    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void iamgeStore(byte[] byteArray,String waybill,String type) {
		String parentPath = getParent(waybill, type);
		ZipUtil.unzip(byteArray, parentPath); 
	}

	/**
	 * 
	* @Title: getImages 
	* @Description: 从文件系统获取图片
	* @param @param waybill
	* @param @param type    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static byte[] getImages(String waybill,String type) {
		String parentPath = getParent(waybill, type);
		return ZipUtil.zip(parentPath).toByteArray();
	}
	
	public static byte[] getImages(String waybill,String type,String type1) {
		String parentPath = getParent(waybill, type);
		String parentPath1 = getParent(waybill, type1);
		return ZipUtil.zip(parentPath,parentPath1).toByteArray();
	}
	
	
	public static void transferFile(String oldPath,String newPath){  
		 
         int byteread = 0;  
         File oldFile = new File(SysConfigConstants.CLAIM_IMG_DIR+oldPath);  
       
             if(oldFile.exists()){  
            	 FileInputStream fin = null;  
                 FileOutputStream fout = null;  
                 try {
                	  
					fin = new FileInputStream(SysConfigConstants.CLAIM_IMG_DIR+oldFile);  
					 fout = new FileOutputStream(SysConfigConstants.CLAIM_IMG_DIR+newPath);  
					 
					 byte[] buffer = new byte[fin.available()];  
					 while( (byteread = fin.read(buffer)) != -1){  
					     fout.write(buffer,0,byteread);  
					 }  
	 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						fin.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						fout.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					oldFile.delete();
				}
          
             }
     }  
	
	/**
	 * 判断文件是否存在
	 * @param path
	 * @return
	 * @author 张贞献
	 * @date 2015年8月25日
	 * @update 
	 */
	public static boolean exist(String path) {
		String imagePath = SysConfigConstants.CLAIM_IMG_DIR + path;
		return new File(imagePath).exists();
	}

	public static boolean existIstrust(String billNo){
		String imagePath = SysConfigConstants.CLAIM_IMG_DIR + billNo+"/"+ClaimEnum.IMAGE_TYPE_AUTHORIZATION_CERTIFICATE;
		return new File(imagePath).exists();
	}
	
	
	/**
	 * 如果目录不存在创建目录
	 * @param path
	 * @author 张贞献
	 * @date 2015年8月25日
	 * @update 
	 */
	public static void existDri(String path) {
		File dir = new File(path);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}
	}
	
	/**
	 *  判断文件是否超过2M
	 * @param in
	 * @return
	 * @throws IOException
	 * @author 张贞献
	 * @date 2015年8月25日
	 * @update 
	 */
	public static boolean isMoreSize(FileInputStream in) throws IOException{
		if (in.available() / (1024 * 1024) > 2) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 保存图片到文件系统
	 * @param in
	 * @param out
	 * @throws IOException
	 * @author 张贞献
	 * @date 2015年8月25日
	 * @update 
	 */
	public static void saveImg(FileInputStream in,FileOutputStream out) throws IOException{
		byte[] b = new byte[1024];
		int length = 0;
		while ((length = in.read(b)) != -1) {
			out.write(b, 0, length);
		}
	}
	
	
	public static boolean imageDelete(String imagePath) {
		boolean isDeleted = false;
		imagePath = SysConfigConstants.CLAIM_IMG_DIR + imagePath;
		File file = new File(imagePath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			isDeleted = true;
		} else {
			isDeleted = false;
		}
		return isDeleted;
	}

	public static String getParent(String waybill, String type) {
		String root = SysConfigConstants.CLAIM_IMG_DIR;
		String path = root + File.separatorChar + waybill + File.separatorChar
				+ type;
		return path;
	}
	
	public static void dealImgs(String imgsStr,ClaimSubmitEntity claimSubmitEntity) {
	    if(imgsStr == null || "".equals(imgsStr)){
	    	return ;
	    }
		ImageEntity imgEntity = null;
		String[] img = imgsStr.split(";");
		
		List<String> imgs = new ArrayList<String>();
		
		List<String>  allImgs = new ArrayList<String>();
		
		List<String> zipDir = new ArrayList<String>();
		String waybill = "";
		for(String entity:img) {
			imgEntity = new ImageEntity();
			String[] imgSing = entity.split("=");
			String imgNo = imgSing[0].substring(imgSing[0].indexOf("/")+1,imgSing[0].indexOf("/")+3);			
			imgEntity.setImgNo(imgNo);
			imgEntity.setImgdir(imgSing[0]);
			imgEntity.setUrl(imgSing[1]);
			//保存
			imgs.add(imgSing[0]);
			if(waybill==""){
				waybill= imgSing[0].substring(0,imgSing[0].indexOf("/"));
			}
			if(!zipDir.contains(imgNo)){
				zipDir.add(imgNo);
			}
		}
		
		//读取所有曾经上传过的图片
		if(zipDir.size()>0){
			List<String> files=null;
			for(String dir:zipDir){
				files = getFileNames(waybill+"/"+dir+"/");
				if(files!=null && files.size()>0){
					allImgs.addAll(files);
				}
			}
		}
		//移除垃圾图片
		if(imgs != null && imgs.size()>0){
			allImgs.removeAll(imgs);
		}
		
		if(allImgs.size()>0){
			for(String s:allImgs){
				imageDelete(s);
			}
		}
	
		claimSubmitEntity.setZipDir(zipDir);
	}
	
	public static List<String> getFileNames(String dir){
		
		File file=new File(SysConfigConstants.CLAIM_IMG_DIR+dir);
		 List<String> list = null;
		String [] res = null;
		if(file.exists()) {
			res=file.list();
			if(res.length>0){
				list = new ArrayList<String>();
				for(String s : res){
					list.add(dir+s);
				}
			}
		}
		return list;
	}
	
	
	//删除目录
	public static void deleteFile(String waybill){
		String dir = SysConfigConstants.CLAIM_IMG_DIR+waybill+"/";
		File del = new File(dir);
		deleteDir(del);
	}
	
	private static boolean deleteDir(File dir) {
	        if (dir.isDirectory()) {
	            String[] children = dir.list();
	            //递归删除目录中的子目录下
	            for (int i=0; i<children.length; i++) {
	                boolean success = deleteDir(new File(dir, children[i]));
	                if (!success) {
	                    return false;
	                }
	            }
	        }
	        // 目录此时为空，可以删除
	        return dir.delete();
	 }
	
	
	public static void main(String[] args) throws Exception {

		String strsss="http://localhost/upload/F1362132/01/file1441718968477.jpg;http://localhost/upload/F1362132/01/file1441718968740.jpg;http://localhost/upload/F1362132/03/file1441718968632.jpg;http://localhost/upload/F1362132/04/file1441718968837.jpg";
		 
		String imgstr="";
		String[] img = strsss.split(";");
		for(String s:img){
			String key = s.substring("http://localhost/upload/".length());
			if("".equals(imgstr)){
				imgstr+=key+"="+s;
			}else{
				imgstr+=";"+key+""+s;
			}
			
		}
		
	System.out.println(imgstr);
		
		
      /*  int byteread = 0;  
        File oldFile = new File("D:/test/img.jpg");  
      
            if(oldFile.exists()){  
           	 FileInputStream fin = null;  
                FileOutputStream fout = null;  
                try {
               	  
					fin = new FileInputStream("D:/test/img.jpg");  
					 fout = new FileOutputStream("D:/test1/img.jpg");  
					 
					 byte[] buffer = new byte[fin.available()];  
					 while( (byteread = fin.read(buffer)) != -1){  
					     fout.write(buffer,0,byteread);  
					 }  
					 
					 
					
					
					 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						fin.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						fout.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					oldFile.delete();
					
				}
         
            }
         
		 */
            
/*		
		File file=new File("D:/imgUpload/F1362112");
		 List<String> list = null;
		String [] res = null;
		if(file.exists()) {
			res=file.list();
			if(res.length>0){
				list = new ArrayList<String>();
				for(String s : res){
					list.add(s);
				}
			}
		}
		
		if(list!= null){
			for(String s:list){
				System.out.println(s);
			}
		}
		*/
		
		
		
		
		/*
		FileInputStream fis = new FileInputStream("E:\\cxf\\build.xml");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		while(fis.read(buff) != -1){
			bos.write(buff);
		}
		System.out.println(bos.size());
		
		fis.close();*/
	}
	

	public static String AllImagePathByWaybill(String imgs){
		String imgstr="";
		String[] img = imgs.split(";");
		for(String s:img){
			String key = s.substring(SysConfigConstants.CLAIM_IMG_PATH.length());
			if("".equals(imgstr)){
				imgstr+=key+"="+s;
			}else{
				imgstr+=";"+key+"="+s;
			}
			
		}
		
		return imgstr;
	}
	
	public static String getAllImagePathByWaybill(String waybill){
		String resultImgs = "";
		List<String> dir = getFileNames(waybill+"/");
		
		if(dir != null){
			for(String seDir:dir){
				List<String> imgNames =  getFileNames(seDir+"/");
				
				if(imgNames!=null){
					for(String imgName:imgNames){
						if(resultImgs.equals("")){
							resultImgs = SysConfigConstants.CLAIM_IMG_PATH+imgName;
						}else{
							resultImgs += ";"+SysConfigConstants.CLAIM_IMG_PATH+imgName;
						}
					}
				}
			}
		}
		return resultImgs;
	}
	
	
	
}
