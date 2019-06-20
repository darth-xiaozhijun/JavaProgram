package com.gof.singleton;

/**
 * 饿汉式单例模式
 * @author xiaozhijun
 *
 */
public class HungrySingleton {

	//类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的！
	private static HungrySingleton instance = new HungrySingleton();
	
	private HungrySingleton(){
		
	}
	
	//方法没有同步，调用效率高！
	public static HungrySingleton getInstance(){
		
		return instance;
	}
}
