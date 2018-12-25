package com.io;

import java.io.File;

public class FileDemo5 {
	
	public static void main(String[] args) {
		
		String path = "D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.png";
		
		File src = new File(path);
		System.out.println(src.length());
		
		src = new File("D:/workspace/xiaozhijun/JavaProgram/src"); 
		System.out.println(src.length());
	}

}
