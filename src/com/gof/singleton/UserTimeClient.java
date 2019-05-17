package com.gof.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程环境下五种创建单例模式的效率
 * @author Administrator
 *
 */
public class UserTimeClient {

	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();
		int threadSize = 10;
		final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
		
		for (int i = 0; i< threadSize; i++) {
			
			new Thread(()->{
				for(int j = 0; j< 10000000; j++){
					LazySingleton lazySingleton = LazySingleton.getInstance();
				}
				countDownLatch.countDown();
			}).start();
		}
		
		countDownLatch.await();
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
