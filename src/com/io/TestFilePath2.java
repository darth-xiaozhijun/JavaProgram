package com.io;

import java.io.File;

public class TestFilePath2 {

	public static void main(String[] args) {
		
		String path = "D:\\workspace\\xiaozhijun\\JavaProgram\\src\\com\\io\\IO.png";
		System.out.println(File.separator);
		
		path = "D:/workspace/xiaozhijun/JavaProgram/src/com/io/IO.png";
		
		path = "D:"+File.separator+"workspace"+File.separator+"xiaozhijun"+File.separator+
				"JavaProgram"+File.separator+"src"+File.separator+"com"+File.separator+
				"io"+File.separator+"IO.png";
		
		System.out.println(path);
	}
}
