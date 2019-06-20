package com.gof.factory.simplefactory;

/**
 * 简单工厂情况下
 * @author Administrator
 *
 */
public class Client2 {//调用者

	public static void main(String[] args) {
		
		Car audi = CarFactory.createCar("奥迪");
		Car byd = CarFactory.createCar("比亚迪");
		
		audi.run();
		byd.run();
		
		audi = CarFactory2.createAudi();
		byd = CarFactory2.createByd();
		
		audi.run();
		byd.run();
	}
}
