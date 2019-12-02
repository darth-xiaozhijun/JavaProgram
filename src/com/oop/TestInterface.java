package com.oop;

/**
 * 接口的多实现
 * @author Administrator
 *
 */
public class TestInterface {

	public static void main(String[] args) {
		
		Volant volant = new Angel();
		volant.fly();
		System.out.println(volant.FLY_HEIGHT);
		
		Honest honest = new GoodMan();
		honest.helpOther();
	}
}

/**
 * 飞行接口
 * @author Administrator
 *
 */
interface Volant {
	
	int FLY_HEIGHT = 100;
	void fly();
}

/**
 * 善良接口
 * @author Administrator
 *
 */
interface Honest {
	
	void helpOther();
}

/**
 * 实现多个接口，天使类
 * @author Administrator
 *
 */
class Angel implements Volant,Honest {

	@Override
	public void helpOther() {
		System.out.println("Angel.helpOther()");
	}

	@Override
	public void fly() {
		System.out.println("Angel.fly()");
	}
	
}

/**
 * 实现单接口（好人类）
 * @author Administrator
 *
 */
class GoodMan implements Honest {

	@Override
	public void helpOther() {
		System.out.println("GoodMan.helpOther()");
	}
	
}

/**
 * 实现单接口（鸟人类）
 * @author Administrator
 *
 */
class BirdMan implements Volant {

	@Override
	public void fly() {
		System.out.println("BirdMan.fly()");
	}
	
}
