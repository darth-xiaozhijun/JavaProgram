package com.io;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节-->字符串
 * @author Administrator
 *
 */
public class TestContentDecode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String msg = "性命生命使命a";
		
		//使用项目本身的编码格式，UTF-8，一个汉字三个字节
		byte[] datas = msg.getBytes();
		
		//解码
		msg = new String(datas, 0, datas.length, "utf8");
		System.out.println(msg);
		
		//乱码
		//字节数不够
		msg = new String(datas, 0, datas.length-2, "utf8");
		System.out.println(msg);
		msg = new String(datas, 0, datas.length-1, "utf8");
		System.out.println(msg);
		
		//编码格式不对
		msg = new String(datas, 0, datas.length, "gbk");
		System.out.println(msg);
	}

}
