package com.io;

import java.io.File;

public class DirDemo5 {
	
	private static Long allLenth = 0L;

	public static void main(String[] args) {
		
		File file = new File("D:/workspace/xiaozhijun/JavaProgram");
		getAllLength(file);
		System.out.println(allLenth);
	}
	
	public static void getAllLength(File file){
		
		if(file != null && file.exists()){
			
			if(file.isFile()){
				allLenth += file.length();
			}else{
				
				for(File f : file.listFiles()){
					
					getAllLength(f);
				}
			}
		}
	}
}
