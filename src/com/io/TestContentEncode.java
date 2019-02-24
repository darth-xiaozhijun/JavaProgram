package com.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串-->字节
 * @author Administrator
 *
 */
public class TestContentEncode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String msg = "性命生命使命a";
		
		//使用项目本身的编码格式，UTF-8，一个汉字三个字节
		byte[] datas = msg.getBytes();
		System.out.println(datas.length);
		
		//所有的都是两个字节
		datas = msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
		
		//一个汉字两个字节
		datas = msg.getBytes("GBK");
		System.out.println(datas.length);
	}

}
