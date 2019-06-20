package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节输出流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 */
public class TestIOFileOutputStream {

	public static void main(String[] args) {
		
		//创建源
		File dest = new File("src/com/io/dest.txt");
		
		//选择流
		OutputStream outputStream = null;
		
		//操作
		try {
			
			outputStream = new FileOutputStream(dest,true);
			
			String msg = "I am going to school!\r\n";
			byte[] bs = msg.getBytes();
			
			outputStream.write(bs, 0, bs.length);
			outputStream.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			//释放资源
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
