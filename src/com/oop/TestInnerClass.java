package com.oop;

/**
 * 测试内部类
 * Java类中不仅可以定义变量和方法，
 * 还可以定义类，这样定义在类内部的类就被称为内部类。
 * 根据定义的方式不同，内部类分为静态内部类，
 * 成员内部类，局部内部类，匿名内部类四种。
 * @author Administrator
 *
 */
public class TestInnerClass {

	public static void main(String[] args) {

		// 实例化内部类对象
		Outer.Inner inner = new Outer().new Inner();

		inner.show();
	}
}

/**
 * 外部类
 * 
 * @author Administrator
 *
 */
class Outer {

	int age = 10;

	/**
	 * 内部类
	 * 
	 * @author Administrator
	 *
	 */
	class Inner {

		/**
		 * 定义在类内部的非静态类，就是成员内部类。 成员内部类不能定义静态方法和变量（final修饰的除外）。
		 * 这是因为成员内部类是非静态的，类初始化的时候先初始化静态成员，
		 * 如果允许成员内部类定义静态变量，那么成员内部类的静态变量初始化顺序是有歧义的。
		 */
		int age = 20;

		public void show() {

			int age = 30;

			System.out.println("外部类的成员变量：" + Outer.this.age);// 10
			System.out.println("内部类的成员变量：" + this.age);// 20
			System.out.println("内部类的局部变量：" + age);// 30
		}
	}

	/**
	 * 定义在方法中的类，就是局部类。如果一个类只在某个方法中使用，则可以考虑使用局部类。
	 * @param c
	 */
	public void test(int c) { 
		int d = 1; 
		
		/**
		 * 局部内部类
		 * @author Administrator
		 *
		 */
		class Inner { 
			public void print() { 
				System.out.println(c); 
			} 
		}
	}
	
}
