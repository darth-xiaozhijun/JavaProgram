package com.gof.factory.simplefactory;

/**
 * 简单工厂类
 * @author Administrator
 *
 */
public class CarFactory2 {

	public static Car createAudi(){
		return new Audi();
	}
	
	public static Car createByd(){
		return new Byd();
	}
}
