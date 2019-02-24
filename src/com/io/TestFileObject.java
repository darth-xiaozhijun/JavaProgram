package com.io;

import java.io.File;

public class TestFileObject {

	public static void main(String[] args) {
		
		String path = "D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.png";
		
		File src = new File(path);
		System.out.println(src.length());
		
		src = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io/", "IO.png");
		System.out.println(src.length());
		
		src = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/","io/IO.png");
		System.out.println(src.length());
		
		src = new File(new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io/"), "IO.png");
		System.out.println(src.length());
	}
}
