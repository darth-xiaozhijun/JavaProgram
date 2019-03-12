package com.thread;

/**
 * 龟兔赛跑
 * @author Administrator
 *
 */
public class Racer implements Runnable{

	private static String winner;//胜利者
	
	@Override
	public void run() {
		
		for(int i=0; i<=100; i++){
			
			//模拟休息
			if(Thread.currentThread().getName().equals("兔子") && i%10==0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			
			//比赛是否结束
			if(gameOver(i)){
				break;
			}
		}
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
	
	public static void main(String[] args) {
		
		Racer racer = new Racer();
		new Thread(racer,"兔子").start();
		new Thread(racer,"乌龟").start();
	}

}
