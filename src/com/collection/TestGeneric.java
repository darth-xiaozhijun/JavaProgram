package com.collection;

/**
 * 泛型学习
 * @author Administrator
 *
 */
public class TestGeneric {

	public static void main(String[] args) {
		
		MyCollection myCollection = new MyCollection();
		myCollection.set("hello", 0);
		myCollection.set(8888, 1);
		
		String str = (String) myCollection.get(0);
		System.out.println(str);
		Integer integer = (Integer) myCollection.get(1);
		System.out.println(integer);
		
		TheCollection<String> theCollection = new TheCollection<>();
		theCollection.set("Hello World", 0);
		String string = theCollection.get(0);
		System.out.println(string);
	}
}

class MyCollection{
	
	Object[] objects = new Object[5];
	
	public void set(Object object,int index){
		objects[index] = object;
	}
	
	public Object get(int index){
		return objects[index];
	}
}

class TheCollection<T>{
	
	Object[] objects = new Object[5];
	
	public void set(T t,int index){
		objects[index] = t;
	}
	
	public T get(int index){
		return (T) objects[index];
	}
}
