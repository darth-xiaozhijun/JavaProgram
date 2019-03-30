package com.thread;

/**
 * join
 * 合并线程
 * 插队线程
 * @author Administrator
 *
 */
public class BlockedJoin {

	public static void main(String[] args) {
		
		Thread t = new Thread(()->{
			
			for(int i=0; i<100; i++){
				System.out.println("lambda..." + "-->" + i);
			}
			
		});
		t.start();
		
		for(int i=0; i<100; i++){
			
			if(i==20){
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main..." + "-->" + i);
		}
	}
}
