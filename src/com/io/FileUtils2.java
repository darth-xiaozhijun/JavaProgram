package com.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * try ...with...resource
 *
 */
public class FileUtils2 {

	/**
	 * 对接输入输出流
	 * try ...with...resource
	 * @param is
	 * @param os
	 */
	public static void copy(String srcPath,String destPath) {
		
		//创建源
		File src = new File(srcPath);
		File dest = new File(destPath);
		try(InputStream is = new FileInputStream(src);
				OutputStream os = new FileOutputStream(dest)) {			
			//3、操作 (分段读取)
			byte[] flush = new byte[1024]; //缓冲容器
			int len = -1; //接收长度
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len); //分段写出
			}			
			os.flush();
		}catch(FileNotFoundException e) {		
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
