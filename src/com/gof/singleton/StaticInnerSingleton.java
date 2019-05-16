package com.gof.singleton;

/**
 * 静态内部类实现单例模式
 * 这种方式：线程安全，调用效率高，并且实现了延时加载！
 * @author Administrator
 *
 */
public class StaticInnerSingleton {

	private static class SingletonClassInstance{
		private static final StaticInnerSingleton instance = new StaticInnerSingleton();
	}
	
	//方法没有同步，调用效率高！
	public static StaticInnerSingleton getInstance(){
		return SingletonClassInstance.instance;
	}
	
	private StaticInnerSingleton(){
		
	}
}
