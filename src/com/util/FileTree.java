package com.util;

import java.io.File;

/**
 * 使用递归打印文件目录结构
 * @author Administrator
 *
 */
public class FileTree {

	public static void main(String[] args) {
		
		File file = new File("E:\\尚学堂\\01. java300集【北京尚学堂·百战程序员】");
		printFileTree(file, 0);
	}
	
	public static void printFileTree(File file,int level){
		
		for(int i=0; i<level; i++){
			System.out.print("-");
		}
		
		System.out.println(file.getName());
		
		if(file.isDirectory()){
			
			File[] files = file.listFiles();
			for (File file2 : files) {
				printFileTree(file2, level+1);
			}
		}
	}
}
