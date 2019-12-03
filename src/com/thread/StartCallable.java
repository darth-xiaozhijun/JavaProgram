package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 有返回值的任务必须实现Callable接口，
 * 类似的，无返回值的任务必须Runnable接口。
 * 执行Callable任务后，可以获取一个Future的对象，
 * 在该对象上调用get就可以获取到Callable任务返回的Object了，
 * 再结合线程池接口ExecutorService就可以实现传说中有返回结果的多线程了。
 * @author xiaozhijun
 *
 */
public class StartCallable implements Callable<Integer> {

	private int i;

	public StartCallable() {
	}

	StartCallable(int i) {
		this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		return i + 1;
	}

	public static void main(String[] args) {

		StartCallable startCallable = new StartCallable();
		try {
			Integer call = startCallable.call();
			System.out.println(call);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		// 创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < 10; i++) {
			
			Callable c = new StartCallable(3);
			
			// 执行任务并获取Future对象
			Future f = pool.submit(c);
			list.add(f);
			
		}
		
		// 关闭线程池
		pool.shutdown();
		
		// 获取所有并发任务的运行结果
		for (Future f : list) {
			
			// 从Future对象上获取任务的返回值，并输出到控制台
			try {
				System.out.println("res：" + f.get().toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
