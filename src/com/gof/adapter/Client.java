package com.gof.adapter;

/**
 * 客户端类
 * (相当于例子中的笔记本，只有USB接口)
 * @author Administrator
 *
 */
public class Client {
	
	public void test1(Target t) {
		t.handleReq();
	}

	public static void main(String[] args) {
		
		Client client = new Client();
		
//		Target target = new Adapter();
		
		Target target = new Adapter2(new Adaptee());
		
		client.test1(target);
	}
}
