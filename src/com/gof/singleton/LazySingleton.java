package com.gof.singleton;

/**
 * 懒汉式单例模式
 * @author xiaozhijun
 *
 */
public class LazySingleton {

	//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
	private static LazySingleton instance;
	
	//私有化构造器
	private LazySingleton(){
		
	}
	
	//方法同步，调用效率低！
	public static synchronized LazySingleton getInstance(){
		
		if(null == instance){
			instance = new LazySingleton();
		}
		
		return instance;
	}
}
