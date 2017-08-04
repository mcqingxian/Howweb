package com.hoau.how.module.common.shared.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 271755 on 2015/4/13.
 */
public class FileUtil {
    public static byte[] getByteArrayFromFile(String fileName) {
        File file = null;
        try {
            file = new File(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (!file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }

        byte[] byteArray = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int count;
            byte buffer[] = new byte[1024];
            while ((count = fis.read(buffer)) > 0) {
                baos.write(buffer, 0, count);
            }
            byteArray = baos.toByteArray();
            fis.close();
            baos.flush();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }
    public static void saveByteArrayToFile(String fileName, byte[] data) {
    	if(data == null || data.length == 0){
    		return;
    	}
        if (null != fileName) {
            String name = fileName;
            int count = 0;
            File file = new File(name);
            while (file.exists()) {
                count++;
                name = fileName + count;
                file = new File(name);
            }
            file.getParentFile().mkdirs();
            try {
                FileOutputStream fs = new FileOutputStream(fileName);
                fs.write(data);
                fs.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
}
