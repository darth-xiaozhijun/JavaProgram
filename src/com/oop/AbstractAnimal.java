package com.oop;

public abstract class AbstractAnimal {

	public abstract void shout();
	
	public void shut(){
		System.out.println("开枪");
	}
	
	public static void main(String[] args) {
		
		AbstractAnimal abstractAnimal = new Dog();
	}
}
