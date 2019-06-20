package com.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流
 * @author Administrator
 *
 */
public class TestPrintStream {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream ps = System.out;
		ps.println("打印流");
		ps.println(true);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/com/io/print.txt")),true);
		ps.println("打印流");
		ps.println(true);
//		ps.close();
		
		//重定向输出端
		System.setOut(ps);
		System.out.println("Change");
		
		//重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("Back");
	}
}
