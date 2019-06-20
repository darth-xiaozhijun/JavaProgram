package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 操作步骤：
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 *
 */
public class TestIO {

	public static void main(String[] args) {
		
		//1、创建源
		File file = new File("src/com/io/test.txt");
		System.out.println(file.getAbsolutePath());//打印绝对路径
		
//		File file2 = new File("gg.txt");
//		System.out.println(file2.getAbsolutePath());
		
		try {
			
			//2、选择流
			InputStream inputStream = new FileInputStream(file);
			
			//3、操作（读取）
			int data1 = inputStream.read();//第一个数据x
			int data2 = inputStream.read();//第二个数据z
			int data3 = inputStream.read();//第三个数据j
			int data4 = inputStream.read();//第四个数据（无，为 -1）
			
			System.out.println((char)data1);
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);
			
			//4、释放资源
			inputStream.close();
			
		} catch (Exception e) {
			
		}
	}
}
