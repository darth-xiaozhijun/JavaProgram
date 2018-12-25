package com.io;

import java.io.File;
import java.io.IOException;

public class FileDemo6 {
	
	public static void main(String[] args) throws IOException {
		
		File src = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.txt");
		
		boolean flag = src.createNewFile();
		System.out.println(flag);
		
		//不是文件夹
		src = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO");
		flag = src.createNewFile();
		System.out.println(flag);
		
		flag = src.delete();
		System.out.println(flag);
	}

}
