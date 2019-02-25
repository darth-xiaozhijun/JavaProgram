package com.io;

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
			
			try {
				
				if(null != outputStream) {
					outputStream.close();
				}
				
				if(null != inputStream){
					inputStream.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
