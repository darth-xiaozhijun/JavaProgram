package com.thread;

/**
 * yield,礼让线程，暂停线程，直接进入就绪状态，不是阻塞状态
 * @author Administrator
 *
 */
public class YieldThread {

	public static void main(String[] args) {
		
		MyThread mt = new MyThread();
		new Thread(mt,"a").start();
		new Thread(mt,"b").start();
	}
	
}

class MyThread implements Runnable{

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + "-->" + "运行");
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + "-->" + "停止");
		
	}
	
}
