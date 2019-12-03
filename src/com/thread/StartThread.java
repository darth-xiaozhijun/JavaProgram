package com.thread;

/**
 * 创建线程方式之一：
 * 1、创建：继承Thread+重写run方法
 * 2、启动:创建子类对象+start
 * 
 * Thread类本质上是实现了Runnable接口的一个实例，代表一个线程的实例。
 * 启动线程的唯一方法就是通过Thread类的start()实例方法。
 * start()方法是一个native方法，它将启动一个新线程，并执行run()方法。
 * @author Administrator
 *
 */
public class StartThread extends Thread {

	/**
	 * 线程入口点
	 */
	@Override
	public void run(){
		
		for(int i=0; i<20; i++){
			System.out.println("一遍听歌");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建子类对象
		StartThread startThread = new StartThread();
		
		//线程启动
		startThread.start();//不保证立即运行 CPU调用
		
		//普通方法调用
//		startThread.run();
		
		for(int i=0; i<20; i++){
			System.out.println("一遍写代码");
		}
	}
}
