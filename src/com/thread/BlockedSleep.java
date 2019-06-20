package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedSleep {
	
	public static void main(String[] args) throws InterruptedException {
		
		Date endTime = new Date(System.currentTimeMillis() + 1000*10);
		long end = endTime.getTime();
		while(true){
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime = new Date(endTime.getTime() - 1000);
			if(end - 10000 > endTime.getTime()){
				break;
			}
		}
	}

	/**
	 * 倒计时的方法
	 * @param args
	 * @throws InterruptedException
	 */
	public static void test(String[] args) throws InterruptedException {
		
		int num = 10;
		while(num>0){
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}
}
