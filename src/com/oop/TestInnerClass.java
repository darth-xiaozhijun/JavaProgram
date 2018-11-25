package com.oop;

/**
 * 测试内部类
 * @author Administrator
 *
 */
public class TestInnerClass {
	
	public static void main(String[] args) {
		
		//实例化内部类对象
		Outer.Inner inner = new Outer().new Inner();
		
		inner.show();
	}
}

/**
 * 外部类
 * @author Administrator
 *
 */
class Outer{
	
	int age = 10;
	
	class Inner{
		
		int age = 20;
		
		public void show(){
			
			int age = 30;
			
			System.out.println("外部类的成员变量：" + Outer.this.age);
			System.out.println("内部类的成员变量：" + this.age);
			System.out.println("内部类的局部变量：" + age);
		}
	}
	
}
