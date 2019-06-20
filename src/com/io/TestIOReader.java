package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 四个步骤：分段读取 字符输入流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 *
 */
public class TestIOReader {

	public static void main(String[] args) {
		
		//1、创建源
		File file = new File("src/com/io/abc.txt");
		
		Reader reader = null;
			
		//2、选择流
		try {
			reader = new FileReader(file);
			
			//3、操作（分段读取）
			char[] flush = new char[1024];//缓冲容器
			int len = -1;//接收长度
			try {
				while((-1) != (len = reader.read(flush))){
					
					String str = new String(flush, 0, len);
					System.out.println(str);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}finally {
			 if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
}
