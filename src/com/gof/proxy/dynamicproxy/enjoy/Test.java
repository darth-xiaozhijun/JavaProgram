package com.gof.proxy.dynamicproxy.enjoy;

public class Test {
	
	public static void main(String[] args) {
		
		Girl girl = new WangMeiLi();
		
		WangMeiLiProxy family = new WangMeiLiProxy(girl);
		
		Girl mother = (Girl) family.getProxyInstance();
		
		mother.date();
		
		System.out.println();
		
		mother.watchMovie();
	}

}
