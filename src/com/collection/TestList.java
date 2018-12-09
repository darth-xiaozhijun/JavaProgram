package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 测试Collection中list集合
 */
public class TestList {

	public static void main(String[] args) {
		
//		test2();
		test3();
		
	}
	
	public static void test3(){
		
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println(list);
		
		list.add(2, "Hello");
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		list.set(2, "高老庄");
		System.out.println(list);
		
		System.out.println(list.get(2));
		
		list.add("C");
		list.add("B");
		list.add("A");
		System.out.println(list);
		
		System.out.println(list.indexOf("B"));
		System.out.println(list.lastIndexOf("B"));
	}
	
	public static void test2(){
		
		List<String> list1 = new ArrayList<>();
		list1.add("aa");
		list1.add("bb");
		list1.add("cc");
		
		List<String> list2 = new ArrayList<>();
		list2.add("aa");
		list2.add("dd");
		list2.add("ee");
		
		System.out.println("list1: " + list1);
		
//		list1.addAll(list2);//把list2中的所有元素添加到list1
		
//		list1.removeAll(list2);//删除和list2中相同的元素
		
		list1.retainAll(list2);//取交集
		
		System.out.println("list1: " + list1);
		
		System.out.println("list1中是否全部包含list2中的元素：" + list1.containsAll(list2));
	}
	
	public static void test1(){
		
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
