package com.oop;

/**
 * 接口和抽象类有什么区别？
 * 	实现：抽象类的子类使用 extends 来继承；接口必须使用 implements 来实现接口。
 * 	构造函数：抽象类可以有构造函数；接口不能有。
 * 	实现数量：类可以实现很多个接口；但是只能继承一个抽象类。
 * 	访问修饰符：接口中的方法默认使用 public 修饰；抽象类中的方法可以是任意访问修饰符。
 * @author Administrator
 *
 */
public interface OneInterface {

	/**
	 * 常量
	 */
	/*public static final*/ int MAX_AGE = 50;
	
	/**
	 * 抽象方法
	 */
	/*public abstract*/ void test01();
}
