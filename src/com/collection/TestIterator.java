package com.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用迭代器遍历set list map
 * @author Administrator
 *
 */
public class TestIterator {

	public static void main(String[] args) {
		
		testIteratorList();
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
}
