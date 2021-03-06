package com.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 四个步骤：字节数组输入流
 * 1、创建源：字节数组，不要太大
 * 2、选择流
 * 3、操作
 * 4、释放资源：可以不用处理
 * @author Administrator
 *
 */
public class TestIOByteArrayInputStream {

	public static void main(String[] args) {
		
		//1、创建源
		byte[] src = "talk is cheap,show me the code".getBytes();
		
		InputStream inputStream = null;
			
		//2、选择流
		try {
			inputStream = new ByteArrayInputStream(src);
			
			//3、操作（分段读取）
			byte[] flush = new byte[5];//缓冲容器
			int len = -1;//接收长度
			try {
				while((-1) != (len = inputStream.read(flush))){
					
					String str = new String(flush, 0, len);
					System.out.println(str);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} finally {
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
