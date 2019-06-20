package com.thread;

/**
 * 线程下载
 * @author Administrator
 *
 */
public class RunnableDownloader implements Runnable {
	
	private String url;
	
	private String name;
	
	

	public RunnableDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		
		RunnableDownloader td1 =new RunnableDownloader("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg","src/com/thread/phone.jpg");
		RunnableDownloader td2 =new RunnableDownloader("http://p1.pstatp.com/large/403c00037462ae2eee13","src/com/thread/spl.jpg");
		RunnableDownloader td3 =new RunnableDownloader("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg","src/com/thread/success.jpg");
		
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}
}
