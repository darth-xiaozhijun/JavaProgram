package com.gof.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 原型模式(深复制,使用序列化和反序列化的方式实现深复制)
 * @author Administrator
 *
 */
public class serialClient {

	public static void main(String[] args) throws Exception {
		
		Date date = new Date(1234721384728L);
		Sheep sheep = new Sheep("多利", date);
		System.out.println(sheep);
		System.out.println(sheep.getName());
		System.out.println(sheep.getBirthday());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(sheep);
		
		byte[] bytes = bos.toByteArray();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep sheep2 = (Sheep) ois.readObject();
		
		date.setTime(234182341423L);
		
		System.out.println(sheep.getBirthday());
		
		sheep2.setName("多利克隆");
		System.out.println(sheep2);
		System.out.println(sheep2.getName());
		System.out.println(sheep2.getBirthday());
	}
}
