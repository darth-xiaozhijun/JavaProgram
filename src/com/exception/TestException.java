package com.exception;

/**
 * 运行时异常处理
 * @author Administrator
 *
 */
public class TestException {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 1;
		if(a != 0){
			System.out.println(b/a);
		}
		
		String str = null;
		if(str != null){
			System.out.println(str.length());
		}
		
		Animal d = new Dog();
		if(d instanceof Cat){
			Cat cat = (Cat) d;
		}
		
	}
}

class Animal{
	
}

class Dog extends Animal{
	
}

class Cat extends Animal{
	
}
