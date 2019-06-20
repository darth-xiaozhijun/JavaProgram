package com.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	
	public static void main(String[] args) {
		
		FileUtils.copyFile("src/com/io/IO.png", "src/com/io/IO-copy2.png");
		try {
			FileUtils.copy(new FileInputStream("src/com/io/IO.png"), new FileOutputStream("src/com/io/IO-copy3.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 复制文件的方法
	 * @param srcPath 源文件路径
	 * @param destPath 目的文件路径
	 */
	public static void copyFile(String srcPath,String destPath){
		
		//创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		//选择流
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		//操作
		try {
			
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			
			byte[] bs = new byte[1024*10];
			int len = -1;
			
			while((-1) != (len = inputStream.read(bs))){
				
				outputStream.write(bs, 0, len);
			}
			
			outputStream.flush();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {

			e.printStackTrace();
		
		}finally {
			
			close(inputStream, outputStream);
		}
		
	}
	
	/**
	 * 复制文件的方法
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is,OutputStream os){
		
		try {
			
			byte[] bs = new byte[1024*10];
			int len = -1;
			
			while((-1) != (len = is.read(bs))){
				
				os.write(bs, 0, len);
			}
			
			os.flush();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {

			e.printStackTrace();
		
		}finally {
			
//			close(is, os);
			close2(is,os);
		}
	}

	/**
	 * 释放资源
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is,OutputStream os){
		
		try {
			
			if(null != os) {
				os.close();
			}
			
			if(null != is){
				is.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 * @param closeables
	 */
	public static void close2(Closeable... closeables){
		for (Closeable closeable : closeables) {
			
			if(closeable != null){
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
