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
	
	private static String test = "test";

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
				
				System.out.println(test+" TestAnonymousInnerClass.main(...).new AA() {...}.aa()");
			}
		});
	}
}

/**
 * 为什么需要内部类？
 * java内部类有什么好处？为什么需要内部类？
 * 首先举一个简单的例子，如果你想实现一个接口，
 * 但是这个接口中的一个方法和你构想的这个类中的一个方法的名称，参数相同，你应该怎么办？
 * 这时候，你可以建一个内部类实现这个接口。
 * 由于内部类对外部类的所有内容都是可访问的，所以这样做可以完成所有你直接实现这个接口的功能。
 * 不过你可能要质疑，更改一下方法的不就行了吗？
 * 的确，以此作为设计内部类的理由，实在没有说服力。
 * 真正的原因是这样的，java中的内部类和接口加在一起，
 * 可以的解决常被C++程序员抱怨java中存在的一个问题 没有多继承。
 * 实际上，C++的多继承设计起来很复杂，而java通过内部类加上接口，可以很好的实现多继承的效果。
 * @author Administrator
 *
 */
interface AA{
	void aa();
}
