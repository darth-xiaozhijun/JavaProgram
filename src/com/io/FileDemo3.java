package com.io;

import java.io.File;

public class FileDemo3 {

	public static void main(String[] args) {
		
		String path = "D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.png";
		
		File src = new File(path);
		System.out.println(src.getPath());
		System.out.println(src.getName());
		
		String path2 = "src/com/io/IO.png";
		File src2 = new File(path2);
		System.out.println(src2.getPath());
		System.out.println(src2.getName());
		System.out.println(src2.getAbsolutePath());
		System.out.println(src2.getParent());
		System.out.println(src.getParentFile().getName());
	}
}
