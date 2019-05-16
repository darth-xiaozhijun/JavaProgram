package com.gof.singleton;

/**
 * 双重检查锁实现单例模式
 * @author xiaozhijun
 *
 */
public class DoubleCheckSingleton {

	private static DoubleCheckSingleton instance = null;
	
	private DoubleCheckSingleton(){
		
	}
	
	private static DoubleCheckSingleton getInstance(){
		
		if(instance == null){
			
			DoubleCheckSingleton singleton;
			synchronized (DoubleCheckSingleton.class) {
				singleton = instance;
				if(singleton == null){
					synchronized (DoubleCheckSingleton.class) {
						if(singleton == null){
							singleton = new DoubleCheckSingleton();
						}
					}
					
					instance = singleton;
				}
			}
		}
		
		return instance;
	}
}
