package com.gof.prototype;

import java.util.Date;

/**
 * 原型模式(浅克隆)
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {
		
		Date date = new Date(1234721384728L);
		Sheep sheep = new Sheep("多利", date);
		System.out.println(sheep);
		System.out.println(sheep.getName());
		System.out.println(sheep.getBirthday());
		
		date.setTime(234182341423L);
		
		System.out.println(sheep.getBirthday());
		
		Sheep sheep2 = (Sheep) sheep.clone();
		sheep2.setName("多利克隆");
		System.out.println(sheep2);
		System.out.println(sheep2.getName());
		System.out.println(sheep2.getBirthday());
	}
}
