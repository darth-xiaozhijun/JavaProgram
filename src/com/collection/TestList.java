package com.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 测试Collection中list集合
 */
public class TestList {

	public static void main(String[] args) {
		
		Collection<String> collection = new ArrayList<>();
		
		System.out.println(collection.size());
		System.out.println(collection.isEmpty());
		
		collection.add("1");
		collection.add("2");
		System.out.println(collection.size());
		System.out.println(collection);
		System.out.println(collection.contains("1"));
		
		Object object = collection.toArray();
		System.out.println(object);
		
		collection.remove("1");
		System.out.println(collection);
		
		collection.clear();
		System.out.println(collection);
		System.out.println(collection.size());
		
	}
}
