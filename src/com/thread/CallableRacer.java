package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 龟兔赛跑
 * @author Administrator
 *
 */
public class CallableRacer implements Callable<Integer>{

	private static String winner;//胜利者
	
	@Override
	public Integer call() throws Exception {
		
		for(int i=0; i<=100; i++){
			
			//模拟休息
			if(Thread.currentThread().getName().equals("pool-1-thread-1") && i%10==0){
				Thread.sleep(10);
			}
			
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			
			//比赛是否结束
			if(gameOver(i)){
				return i;
			}
		}
		
		return null;
	}
	
	private boolean gameOver(int stage){
		
		//已经有胜利者
		if(winner != null){
			return true;
		}else{
			if(stage == 100){
				winner = Thread.currentThread().getName();
				System.out.println("winner===>" + winner);
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CallableRacer racer = new CallableRacer();
		
		//创建执行服务: 
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		//提交执行: 
		Future<Integer> result1 = executorService.submit(racer);
		Future<Integer> result2 = executorService.submit(racer);
		
		//获取结果:  
		Integer r1 = result1.get();
		Integer r2 = result2.get();
		
		System.out.println(r1+"===>"+r2);
		
		//关闭服务
		executorService.shutdown();
	}

}
