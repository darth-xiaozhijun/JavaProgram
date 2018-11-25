package com.oop;

/**
 * 测试静态内部类
 * @author Administrator
 *
 */
public class TestStaticInnerClass {

	//实例化静态内部类
	Outer2.Inner2 inner2 = new Outer2.Inner2();
}

/**
 * 外部类
 * @author Administrator
 *
 */
class Outer2 {
	
	int age = 10;
	
	/**
	 * 静态内部类
	 * @author Administrator
	 *
	 */
	static class Inner2 {
		
		int age = 20;
		
		public void show(){
			
			int age = 30;
			
//			System.out.println("外部类的成员变量：" + Outer2.this.age);//不能访问外部类的成员变量
			System.out.println("内部类的成员变量：" + this.age);
			System.out.println("内部类的局部变量：" + age);
		}
	}
}

