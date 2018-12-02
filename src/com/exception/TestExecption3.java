package com.exception;

import java.io.FileReader;
import java.io.IOException;

/**
 * 使用throws声明异常
 * @author Administrator
 *
 */
public class TestExecption3 {

	public static void main(String[] args) throws IOException {
		
		readFile();
	}
	
	public static void readFile() throws IOException{
		
		FileReader fileReader = new FileReader("D:\\b.txt");
		char c1 = (char) fileReader.read();
		System.out.println(c1);
		if(fileReader != null){
			fileReader.close();
		}
	}
}
