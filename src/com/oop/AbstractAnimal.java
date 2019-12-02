package com.oop;

/**
 * 1、普通类和抽象类有哪些区别？
 * 	普通类不能包含抽象方法，抽象类可以包含抽象方法。
 * 	抽象类不能直接实例化，普通类可以直接实例化。
 * 
 * 2、抽象类能使用 final 修饰吗？
 * 	不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承，这样彼此就会产生矛盾，所以 final 不能修饰抽象类
 * @author Administrator
 *
 */
public abstract class AbstractAnimal {

	public abstract void shout();
	
	/**
	 * 抽象类不一定非要有抽象方法。
	 */
	public void shut(){
		System.out.println("开枪");
	}
	
	/**
	 * 抽象类不能被实例化,只有具体类才能被实例化。
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractAnimal abstractAnimal = new Dog();
		abstractAnimal.shout();
		abstractAnimal.shut();
	}
}
