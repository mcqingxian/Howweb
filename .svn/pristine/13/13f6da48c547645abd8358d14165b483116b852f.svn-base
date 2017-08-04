package com.hoau.how.module.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    static final int BUFFER = 2048;

    private static byte[] buffer = new byte[1024 * 10];
    
    private ZipUtil() {
        // empty
    }
 
    /**
     * 压缩文件
     * 
     * @param filePath
     *            待压缩的文件路径
     * @return 压缩后的文件
     */
    public static ByteArrayOutputStream zip(String filePath) {
        File source = new File(filePath);
        ByteArrayOutputStream fos = null;
        if (source.exists()) {
            // 压缩文件名=源文件名.zip
            ZipOutputStream zos = null;
            try {
                fos = new ByteArrayOutputStream();
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // 添加对应的文件Entry
                addEntry("/", source, zos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                closeQuietly(zos, fos);
            }
        }
        return fos;
    }
 
    public static ByteArrayOutputStream zip(String filePath,String filePath1) {
        File source = new File(filePath);
        File source1 = new File(filePath1);
        ByteArrayOutputStream fos = null;
        if (source.exists() || source1.exists()) {
            // 压缩文件名=源文件名.zip
            ZipOutputStream zos = null;
            try {
                fos = new ByteArrayOutputStream();
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // 添加对应的文件Entry
                if(source.exists()){
                	addEntry("/", source, zos);
                }
                
                if(source1.exists()){
                	addEntry("/", source1, zos);
                }
                
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                closeQuietly(zos, fos);
            }
        }
        return fos;
    }
    
    /**
     * 扫描添加文件Entry
     * 
     * @param base
     *            基路径
     * 
     * @param source
     *            源文件
     * @param zos
     *            Zip文件输出流
     * @throws IOException
     */
    private static void addEntry(String base, File source, ZipOutputStream zos)
            throws IOException {
        // 按目录分级，形如：/aaa/bbb.txt
        String entry = base + source.getName();
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                // 递归列出目录下的所有文件，添加文件Entry
                addEntry(entry + "/", file, zos);
            }
        } else {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(source);
                bis = new BufferedInputStream(fis, buffer.length);
                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            } finally {
                closeQuietly(bis, fis);
            }
        }
    }
 
    /**
     * 解压文件
     * 
     * @param filePath
     *            压缩文件路径
     */
    public static void unzip(byte[] byteArray,String targetPath) {
    	ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        ZipInputStream zis = null;
        BufferedOutputStream bos = null;
        try {
            zis = new ZipInputStream(inputStream);
            ZipEntry entry = null;
            while ((entry = zis.getNextEntry()) != null && !entry.isDirectory()) {
                File target = new File(targetPath, entry.getName());
                if (!target.getParentFile().exists()) {
                    // 创建文件父目录
                    target.getParentFile().mkdirs();
                }
                // 写入文件
                bos = new BufferedOutputStream(new FileOutputStream(target));
                int read = 0;
                while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, read);
                }
                bos.flush();
            }
            zis.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(zis, bos);
        }
    }
    
    public static void main(String[] args) {
        String targetPath = "D:\\Ebook\\First\\";
        ByteArrayOutputStream file = ZipUtil.zip(targetPath);
        ZipUtil.unzip(file.toByteArray(),"E:\\cxf");
    }
    
    
    
    /**
     * 关闭一个或多个流对象
     * 
     * @param closeables
     *            可关闭的流对象列表
     * @throws IOException
     */
    public static void close(Closeable... closeables) throws IOException {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }
 
    /**
     * 关闭一个或多个流对象
     * 
     * @param closeables
     *            可关闭的流对象列表
     */
    public static void closeQuietly(Closeable... closeables) {
        try {
            close(closeables);
        } catch (IOException e) {
        }
    }
}