package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * 四个步骤：分段读取 字符输入流,加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 *
 */
public class TestBufferedReader {

	public static void main(String[] args) {
		
		//1、创建源
		File file = new File("src/com/io/abc.txt");
		
		BufferedReader reader = null;
			
		//2、选择流
		try {
			reader = new BufferedReader(new FileReader(file));
			
			//3、操作（分段读取）
			try {
				String line = null;
				while((line = reader.readLine()) != null){
					
					System.out.println(line);
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
