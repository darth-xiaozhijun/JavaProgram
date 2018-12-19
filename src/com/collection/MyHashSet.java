package com.collection;

import java.util.HashMap;

public class MyHashSet {

	HashMap hashMap;
	
	private static final Object PRESENT = new Object();
	
	public MyHashSet() {
		
		hashMap = new HashMap<>();
	}
	
	public void add(Object o){
		hashMap.put(o, PRESENT);
	}
	
	public int size(){
		return hashMap.size();
	}
	
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder("[");
		
		for (Object key : hashMap.keySet()) {
			stringBuilder.append(key + ",");
		}
		
		stringBuilder.setCharAt(stringBuilder.length()-1, ']');
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add("aaa");
		myHashSet.add(111);
		myHashSet.add("sda");
		
		System.out.println(myHashSet);
	}
}
