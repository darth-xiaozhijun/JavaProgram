package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件读取的标准操作步骤：
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 *
 */
public class TestIO2 {

	public static void main(String[] args) {
		
		//1、创建源
		File file = new File("src/com/io/test.txt");
		
		InputStream inputStream = null;
			
		//2、选择流
		try {
			inputStream = new FileInputStream(file);
			
			//3、操作（读取）
			int temp;
			
			try {
				while((-1) != (temp = inputStream.read())){
					
					System.out.println((char)temp);
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
