package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 使用迭代器遍历set list map
 * @author Administrator
 *
 */
public class TestIterator {

	public static void main(String[] args) {
		
//		testIteratorList();
//		testIteratorSet();
		testIteratorMap();
	}
	
	public static void testIteratorList(){
		
		List<String>  list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		for(Iterator<String> iterator = list.iterator();iterator.hasNext();){
			
			String temp = iterator.next();
			System.out.println(temp);
//			list.remove(temp);  //报错java.util.ConcurrentModificationException
			
			iterator.remove();
			System.out.println(list);
		}
		
	}
	
	public static void testIteratorSet(){
		
		Set<String> set = new HashSet<>();
		
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			
			String temp = iterator.next();
			System.out.println(temp);
//			list.remove(temp);  //报错java.util.ConcurrentModificationException
			
			iterator.remove();
			System.out.println(set);
		}
	}
	
	public static void testIteratorMap(){
		
		Map<Integer,String> map = new HashMap<>();
		map.put(100, "aa");
		map.put(200, "bb");
		map.put(300, "cc");
		
		Set<Entry<Integer, String>> mapSet = map.entrySet();
		for(Iterator<Entry<Integer, String>> iterator=mapSet.iterator();iterator.hasNext();){
			Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() + "---" + entry.getValue()); 
			iterator.remove();
			System.out.println(map); 
		}
		
		System.out.println("----------------------------------");
		
		Set<Integer> set = map.keySet();
		for(Iterator<Integer> iterator = set.iterator(); iterator.hasNext();){
			
			Integer key = iterator.next();
			System.out.println(key + "---" + map.get(key)); 
			iterator.remove();
			System.out.println(map); 
		}
	}
}
