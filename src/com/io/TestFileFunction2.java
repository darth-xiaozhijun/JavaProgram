package com.io;

import java.io.File;

public class TestFileFunction2 {

	public static void main(String[] args) {
		
		String path = "D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.png";
		
		File src = new File(path);
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
	}
}
