package com.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、图片读取到字节数组
 * 2、字节数组写出到文件
 * @author Administrator
 *
 */
public class TestStreamTransform {
	
	public static void main(String[] args) {
		
		byte[] bs = fileToByteArray("src/com/io/IO.png");
		System.out.println(bs.length);
		byteArrayToFile(bs, "src/com/io/IO-copy.png");
		
	}
	
	/**
	 * 1、图片读取到字节数组
	 * @param filePath
	 */
	public static byte[] fileToByteArray(String filePath){
		
		byte[] bs = null;
		
		//创建源
		File file = new File(filePath);
		
		//选择流
		InputStream inputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		
		try {
			
			inputStream = new FileInputStream(file);
			byteArrayOutputStream = new ByteArrayOutputStream();
			
			byte[] flush = new byte[1024*10];//缓冲容器
			int len = -1;//接收长度
			
			while((-1) != (len = inputStream.read(flush))){
				
				byteArrayOutputStream.write(flush, 0, len);
			}
			
			byteArrayOutputStream.flush();
			
			bs = byteArrayOutputStream.toByteArray();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}finally {
			
			if(null != inputStream){
				
				try {
					inputStream.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		return bs;
		
	}
	
	/**
	 * 字节数组写出到文件
	 * @param src
	 * @param filePath
	 */
	public static void byteArrayToFile(byte[] src,String filePath){
		
		//创建源
		File file = new File(filePath);
		
		//选择流
		ByteArrayInputStream byteArrayInputStream = null;
		OutputStream outputStream = null;
		
		try {
			
			byteArrayInputStream = new ByteArrayInputStream(src);
			outputStream = new FileOutputStream(file);
			
			byte[] flush = new byte[1024*10];//缓冲容器
			int len = -1;//接收长度
			
			while((-1) != (len = byteArrayInputStream.read(flush))) {
				
				outputStream.write(flush, 0, len);
			}
			outputStream.flush();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}finally {
			
			if(null != outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
