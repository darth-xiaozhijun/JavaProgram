package com.io;

import java.io.File;

public class DirDemo2 {
	
	public static void main(String[] args) {
		
		File dir = new File("D:/workspace/xiaozhijun/JavaProgram/src/com/io");
		
		String[] subNames = dir.list();
		for (String string : subNames) {
			System.out.println(string);
		}
		
		File[] files = dir.listFiles();
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
		File[] files2 = dir.listRoots();
		for (File file : files2) {
			System.out.println(file.getAbsolutePath());
		}
	}

}
