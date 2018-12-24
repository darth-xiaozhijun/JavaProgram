package com.io;

import java.io.File;

public class FileDemo2 {

	public static void main(String[] args) {
		

		String path = "D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.png";
		
		//绝对路径
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//相对路径
		System.out.println(System.getProperty("user.dir"));
		src = new File("IO.png");
		System.out.println(src.getAbsolutePath());
		
		//构建一个不存在的路径
		src = new File("aaa/IO.png");
		System.out.println(src.getAbsolutePath());
	}
}
