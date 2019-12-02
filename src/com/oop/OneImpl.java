package com.oop;

public class OneImpl implements OneInterface {

	@Override
	public void test01() {
		System.out.println(MAX_AGE);
	}
	
	public static void main(String[] args) {
		
		OneInterface oneInterface = new OneImpl();
		oneInterface.test01();
	}

}
