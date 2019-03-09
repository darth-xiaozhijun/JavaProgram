package com.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * 文件字符输出流,加入缓冲流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author Administrator
 */
public class TestBufferedWriter {

	public static void main(String[] args) {
		
		//创建源
		File dest = new File("src/com/io/efg.txt");
		
		//选择流
		BufferedWriter writer = null;
		
		//操作
		try {
			
			writer = new BufferedWriter(new FileWriter(dest));
			
			//方式一
			/*String msg = "I am going to school!\r\n我爱北京天安门，天安门上太阳升";
			char[] cs = msg.toCharArray();
			writer.write(cs, 0, cs.length);
			writer.flush();*/
			
			//方式二
			/*String msg = "I am going to school!\r\n我爱北京天安门，天安门上太阳升,方式二";
			writer.write(msg);
			writer.flush();*/
			
			//方式三
			writer.append("我爱北京天安门");
			writer.newLine();
			writer.append("天安门上太阳升");
			writer.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			//释放资源
			if(null != writer){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
