package com.instance;

/**
 * 静态内部类虽然保证了单例在多线程并发下的线程安全性，
 * 但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的
 * @author Administrator
 *
 */
public class SingleInstance5 {

	private SingleInstance5(){}
	
	private static class InnerObject{
		private static SingleInstance5 singleInstance5 = new SingleInstance5();
	}
	
	public SingleInstance5 getSingleInstance5(){
		return InnerObject.singleInstance5;
	}
}
