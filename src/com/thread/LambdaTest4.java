package com.thread;

public class LambdaTest4 {

	public static void main(String[] args) {
		
		new Thread(()->{
			for(int i=0; i<10; i++){
				System.out.println("一边学习一边lambda");
			}
		}).start();
		
		new Thread(()->System.out.println("一边学习一边崩溃")).start();
	}
}
