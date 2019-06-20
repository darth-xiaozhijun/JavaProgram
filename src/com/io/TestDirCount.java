package com.io;

import java.io.File;

public class TestDirCount {

	private long len;
	
	private String path;
	
	private File file;
	
	private int dirSize;
	
	private int fileSize;
	
	public TestDirCount(String path) {
		
		this.path = path;
		file = new File(path);
		getAllLength(file);
	}
	
	private void getAllLength(File file){
		
		if(file != null && file.exists()){
			
			if(file.isFile()){
				len += file.length();
				fileSize++;
				
			}else{
				
				dirSize++;
				for(File f : file.listFiles()){
					
					getAllLength(f);
				}
			}
		}
	}

	public long getLen() {
		return len;
	}
	
	public int getDirSize() {
		return dirSize;
	}

	public int getFileSize() {
		return fileSize;
	}

	public static void main(String[] args) {
		
		TestDirCount dirCount = new TestDirCount("D:/workspace/xiaozhijun/JavaProgram");
		System.out.println(dirCount.getLen());
		System.out.println(dirCount.getDirSize());
		System.out.println(dirCount.getFileSize());
	}

}
