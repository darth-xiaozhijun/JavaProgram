package com.io;

import java.io.File;

public class DirDemo4 {

	public static void main(String[] args) {
		
		File file = new File("D:/workspace/xiaozhijun/JavaProgram");
		printName(file, 0);
	}
	
	public static void printName(File file,int deep){
		
		for(int i=0; i<deep; i++){
			System.out.print("-");
		}
		
		System.out.println(file.getName());
		
		if(file == null || !file.exists()){
			return;
			
		}else if(file.isDirectory()){
			
			for (File f : file.listFiles()) {
				printName(f, deep++);
			}
		}
	}
}
