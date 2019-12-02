package com.oop;

/**
 * 测试静态内部类
 * @author Administrator
 *
 */
public class TestStaticInnerClass {

	
	public static void main(String[] args) {
		//实例化静态内部类
		Outer2.Inner2 inner2 = new Outer2.Inner2();
		inner2.show();
	}
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
		
		/**
		 * 1. 静态内部类可以访问外部类所有的静态变量和方法，即使是private的也一样。
		 * 2. 静态内部类和一般类一致，可以定义静态变量、方法，构造方法等。 
		 * 3. 其它类使用静态内部类需要使用“外部类.静态内部类”方式，
		 * 	如下所示：Out.Inner inner = new Out.Inner();inner.print(); 
		 * 4. Java集合类HashMap内部就有一个静态内部类Entry。Entry是HashMap存放元素的抽象，
		 * 	HashMap内部维护Entry数组用了存放元素，但是Entry对使用者是透明的。
		 * 	像这种和外部类关系密切的，且不依赖外部类实例的，都可以使用静态内部类。
		 */
		public void show(){
			
			int age = 30;
			
//			System.out.println("外部类的成员变量：" + Outer2.this.age);//静态内部类不能访问外部类的成员变量
			System.out.println("内部类的成员变量：" + this.age);//20
			System.out.println("内部类的局部变量：" + age);//30
		}
	}
}

