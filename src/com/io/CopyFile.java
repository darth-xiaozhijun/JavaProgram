package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件复制：使用输入、输出流
 * @author Administrator
 *
 */
public class CopyFile {
	
	public static void main(String[] args) {
		
		copy("src/com/io/CopyFile.java", "CopyFile.txt");
		
	}
	
	public static void copy(String srcPath,String destPath){
		//创建源
		File src = new File(srcPath);//源头
		File dest = new File(destPath);//目的地
		
		//选择流
		InputStream inputStream = null;//输入流
		OutputStream outputStream = null;//输出流
		
		//操作
		try {
			
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			
			byte[] flush = new byte[1024];//缓冲容器
			int len = -1;//接收长度
			try {
				while((-1) != (len = inputStream.read(flush))){
					
					outputStream.write(flush, 0, len);
					outputStream.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			//释放资源 先打开的后关闭
			if(null != outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
