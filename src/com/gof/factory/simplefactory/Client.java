package com.gof.factory.simplefactory;

/**
 * 测试在没有工厂模式的情况下
 * @author Administrator
 *
 */
public class Client {//调用者

	public static void main(String[] args) {
		
		Car audi = new Audi();
		Car byd = new Byd();
		
		audi.run();
		byd.run();
	}
}
