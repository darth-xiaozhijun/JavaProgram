package com.gof.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒汉式单例模式(如何防止反射和反序列化漏洞)
 * @author xiaozhijun
 *
 */
public class ReflectionLazySingleton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）。
	private static ReflectionLazySingleton singleton;
	
	//私有化构造器
	private ReflectionLazySingleton(){
		if(singleton != null){
			throw new RuntimeException();
		}
	}
	
	//方法同步，调用效率低！
	public static synchronized ReflectionLazySingleton getInstance(){
		
		if(singleton == null){
			singleton = new ReflectionLazySingleton();
		}
		
		return singleton;
	}
	
	//反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！
	private Object readResolve() throws ObjectStreamException{

		return singleton;
	}
}
