package com.thread;

/**
 * yield,礼让线程，暂停线程，直接进入就绪状态，不是阻塞状态
 * @author Administrator
 *
 */
public class Yield {

	public static void main(String[] args) {
		
		new Thread(()->{
			
			for(int i=0; i<100; i++){
				System.out.println("lambda..." + "-->" + i);
			}
			
		}).start();
		
		for(int i=0; i<100; i++){
			
			if(i%10==0){
				Thread.yield();
			}
			System.out.println("main..." + "-->" + i);
		}
	}
}
