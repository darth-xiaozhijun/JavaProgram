package com.io;

/**
 * 实现放大器对声音的放大功能
 * @author Administrator
 *
 */
public class DecorateTest01 {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.say();
		
		//装饰器
		Amplifier amplifier = new Amplifier(person);
		amplifier.say();
	}
}

interface Say{
	void say();
}

class Person implements Say{
	
	private int voice = 10;

	@Override
	public void say() {
		System.out.println("人的声音是：" + voice);
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	
}

//放大器
class Amplifier implements Say{
	
	private Person p;
	
	public Amplifier(Person p) {
		this.p = p;
	}

	@Override
	public void say() {
		System.out.println("人的声音是：" + p.getVoice()*100);
	}
	
}