package com.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 四个步骤：分段读取 字节输入流，加入缓存流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 *
 */
public class TestBufferedInputStream {

	public static void main(String[] args) {
		
		//1、创建源
		File file = new File("src/com/io/test.txt");
		
		InputStream inputStream = null;
		
		//2、选择流
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			//3、操作（分段读取）
			byte[] flush = new byte[1024];//缓冲容器
			int len = -1;//接收长度
			try {
				while((-1) != (len = inputStream.read(flush))){
					
					String str = new String(flush, 0, len);
					System.out.println(str);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}finally {
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
