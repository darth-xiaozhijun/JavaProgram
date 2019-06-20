package com.gof.factory.simplefactory;

/**
 * 简单工厂类
 * @author Administrator
 *
 */
public class CarFactory {

	public static Car createCar(String carName){
		
		Car car = null;
		if("奥迪".equals(carName)){
			car = new Audi();
		}else if("比亚迪".equals(carName)){
			car = new Byd();
		}
		
		return car;
	}
}
