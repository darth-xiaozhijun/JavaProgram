package com.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试异常
 * @author Administrator
 *
 */
public class TestExecption2 {

	public static void main(String[] args) {
		
		FileReader fileReader = null;
		
		try {
			
			fileReader = new FileReader("D:\\b.txt");
			System.out.println("step1");
			char c1 = (char) fileReader.read();
			System.out.println("step2");
			System.out.println(c1);
			
		} catch (FileNotFoundException e) {
			System.out.println("step3");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("step3");
			e.printStackTrace();
		}finally {
			System.out.println("step4");
			if(fileReader != null){
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
