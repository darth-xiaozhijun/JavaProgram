package com.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节数组输出流
 * 1、创建源：内部维护
 * 2、选择流：不关联源
 * 3、操作
 * 4、释放资源：可以不用
 * 
 * 获取数据：toByteArray()
 * 
 * @author Administrator
 */
public class TestIOByteArrayOutputStream {

	public static void main(String[] args) {
		
		//创建源
		byte[] dest = null;
		
		//选择流
		ByteArrayOutputStream byteArrayOutputStream = null;
		
		//操作
		try {
			
			byteArrayOutputStream = new ByteArrayOutputStream();
			
			String msg = "I am going to school!\r\n";
			byte[] datas = msg.getBytes();
			
			byteArrayOutputStream.write(datas, 0, datas.length);
			byteArrayOutputStream.flush();
			
			//获取数据
			dest = byteArrayOutputStream.toByteArray();
			System.out.println(new String(dest, 0, byteArrayOutputStream.size()));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			//释放资源
			if(null != byteArrayOutputStream){
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
