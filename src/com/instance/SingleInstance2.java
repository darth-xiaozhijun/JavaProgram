package com.instance;

/**
 * 单例模式-懒汉式
 * 该示例虽然用延迟加载方式实现了懒汉式单例，但在多线程环境下会产生多个single对象
 * @author Administrator
 *
 */
public class SingleInstance2 {

	private static SingleInstance2 singleInstance2 = null;
	
	private SingleInstance2(){}
	
	public static SingleInstance2 getSingleInstace2(){
		if(singleInstance2 == null){
			singleInstance2 = new SingleInstance2();
		}
		return singleInstance2;
	}
}
