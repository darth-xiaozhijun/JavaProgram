package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建线程方式之三：
 * @author Administrator
 *
 */
public class CallableDownloader implements Callable<Boolean> {
	
	private String url;
	
	private String name;
	
	public CallableDownloader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception {
		
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
			
		CallableDownloader cd1 =new CallableDownloader("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg","src/com/thread/phone.jpg");
		CallableDownloader cd2 =new CallableDownloader("http://p1.pstatp.com/large/403c00037462ae2eee13","src/com/thread/spl.jpg");
		CallableDownloader cd3 =new CallableDownloader("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg","src/com/thread/success.jpg");
		
		//创建执行服务: 
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		//提交执行: 
		Future<Boolean> result1 = executorService.submit(cd1);
		Future<Boolean> result2 = executorService.submit(cd2);
		Future<Boolean> result3 = executorService.submit(cd3);
		
		//获取结果:  
		boolean r1 = result1.get();
		boolean r2 = result2.get();
		boolean r3 = result3.get();
		
		System.out.println(r3);
		
		//关闭服务
		executorService.shutdown();
	}

}
