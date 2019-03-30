package com.thread;

/**
 * 守护线程
 * 是为用户线程服务的
 * jvm停止不用等待守护线程执行完毕
 * 默认都是用户线程
 * jvm等待用户线程全部执行完毕才会停止
 * @author Administrator
 *
 */
public class Daemon {
	
	public static void main(String[] args) {
		
		God god = new God();
		Me me = new Me();
		Thread thread = new Thread(god);
		thread.setDaemon(true);
		thread.start();
		new Thread(me).start();
	}

}

class Me extends Thread{
	
	@Override
	public void run() {
		
		for(int i=0; i<365*100; i++){
			System.out.println("happy life....");
		}
		System.out.println("ooooo....");
	}
}

class God extends Thread{
	
	@Override
	public void run() {
		for(;true;){
			System.out.println("bless you....");
		}
	}
}