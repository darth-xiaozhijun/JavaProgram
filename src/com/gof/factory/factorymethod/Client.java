package com.gof.factory.factorymethod;

/**
 * 测试在没有工厂模式的情况下
 * @author Administrator
 *
 */
public class Client {//调用者

	public static void main(String[] args) {
		
		Car audi = new AudiFactory().createCar();
		Car byd = new BydFactory().createCar();
		
		audi.run();
		byd.run();
		
		Car benz = new BenzFactory().createCar();
		benz.run();
	}
}
