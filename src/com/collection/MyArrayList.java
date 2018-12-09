package com.collection;

/**
 * 自定义ArrayList，实现基本功能
 * @author Administrator
 *
 */
public class MyArrayList<E> {

	private Object[] elementData;
	
	private int size;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList(){
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity){
		elementData = new Object[capacity];
	}
	
	public void add(E object){
		elementData[size++] = object;
	}
	
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for(int i=0; i<size; i++){
			stringBuilder.append(elementData[i] + ",");
		}
		stringBuilder.setCharAt(stringBuilder.length() -1 , ']');
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		
		MyArrayList<String> arrayList = new MyArrayList<>(20);
		arrayList.add("AA");
		arrayList.add("BB");
		
		System.out.println(arrayList);
	}
}
