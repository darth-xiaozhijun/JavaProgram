package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 转换流 ：InputStreamReader、OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本）
 * 2、指定字符集
 * @author Administrator
 *
 */
public class TestOutputStreamReader {

	public static void main(String[] args) {
		
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new URL("http://www.baidu.com").openStream(),"UTF-8"));
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("src/com/io/baidu.html")))){
			
			String msg;
			while((msg = reader.readLine()) != null){
//				System.out.println(msg);
				writer.write(msg);
				writer.newLine();
			}
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
