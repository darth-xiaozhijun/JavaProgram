package com.exception;

/**
 * 自定义异常
 * @author Administrator
 *
 */
public class TestException4 {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setAge(-10);
	}
}

class Person{
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		
		if(age < 0){
			throw new IllegalAgeException("年龄不能为负数");
		}
		this.age = age;
	}
	
}

class IllegalAgeException extends RuntimeException{
	
	public IllegalAgeException(){
		
	}
	
	public IllegalAgeException(String msg){
		super(msg);
	}
}