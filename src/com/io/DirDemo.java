package com.io;

import java.io.File;

public class DirDemo {
	
	public static void main(String[] args) {
		
		File dir = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io/test");
		
		//创建目录
		boolean flag = dir.mkdir();
		System.out.println(flag);
		
		dir = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io/dir/test");
		flag = dir.mkdir();
		System.out.println(flag);
		
		flag = dir.mkdirs();
		System.out.println(flag);
	}

}
