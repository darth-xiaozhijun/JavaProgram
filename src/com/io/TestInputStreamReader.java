package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流 ：InputStreamReader、OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本）
 * 2、指定字符集
 * @author Administrator
 *
 */
public class TestInputStreamReader {
	
	public static void main(String[] args) {
		//操作System.in和System.in
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			
			//循环获取键盘的输入（exit退出），输出此内容
			String msg = "";
			while(!msg.equals("exit")){
				msg = br.readLine();//循环读取
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
