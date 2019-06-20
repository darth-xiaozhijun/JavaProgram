package com.gof.prototype;

import java.util.Date;

/**
 * 原型模式(深克隆)
 * @author Administrator
 *
 */
public class DeepClient {

	public static void main(String[] args) throws Exception {
		
		Date date = new Date(1234721384728L);
		DeepSheep deepSheep = new DeepSheep("多利", date);
		DeepSheep deepSheep2 = (DeepSheep) deepSheep.clone();//实现深复制。s2对象的birthday是一个新对象！
		System.out.println(deepSheep);
		System.out.println(deepSheep.getName());
		System.out.println(deepSheep.getBirthday());
		
		date.setTime(234182341423L);
		
		System.out.println(deepSheep.getBirthday());
		
		deepSheep2.setName("多利克隆");
		System.out.println(deepSheep2);
		System.out.println(deepSheep2.getName());
		System.out.println(deepSheep2.getBirthday());
	}
}
