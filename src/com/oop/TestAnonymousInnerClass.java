package com.oop;

/**
 * 匿名内部类
 * 我们必须要继承一个父类或者实现一个接口，
 * 当然也仅能只继承一个父类或者实现一个接口。
 * 同时它也是没有class关键字，
 * 这是因为匿名内部类是直接使用new来生成一个对象的引用。
 * @author Administrator
 *
 */
public class TestAnonymousInnerClass {

	public static void test01(AA a){
		a.aa();
	}
	
	public static void main(String[] args) {
		/**
		 * 匿名内部类
		 */
		TestAnonymousInnerClass.test01(new AA() {
			
			@Override
			public void aa() {
				
				System.out.println("TestAnonymousInnerClass.main(...).new AA() {...}.aa()");
			}
		});
	}
}

interface AA{
	void aa();
}
