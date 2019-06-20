package com.thread;

public class InfoTest {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().isAlive());
		
		MyInfo myInfo = new MyInfo("战斗机");
		Thread thread = new Thread(myInfo);
		thread.setName("公鸡");
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread.isAlive());
		
	}
}

class MyInfo implements Runnable{

	private String name;
	
	public MyInfo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + "-->" + name);
	}
}
