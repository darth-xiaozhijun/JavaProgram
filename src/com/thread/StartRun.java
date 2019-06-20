package com.thread;

/**
 * 创建线程方式之二：
 * 1、创建：实现Runnable+重写run方法
 * 2、启动:创建实现类对象+Thread对象+start
 * 
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 * @author Administrator
 *
 */
public class StartRun implements Runnable {
	
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
		
		//创建实现类类对象
		StartRun sr = new StartRun();
		
		//创建代理类对象
		Thread t = new Thread(sr);
		
		//线程启动
		t.start();//不保证立即运行 CPU调用
		
		for(int i=0; i<20; i++){
			System.out.println("一遍写代码");
		}
	}

}
