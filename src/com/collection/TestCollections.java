package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * @author Administrator
 *
 */
public class TestCollections {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			list.add("gao"+i);
		}
		
		System.out.println(list);
		Collections.shuffle(list);//随机排列
		System.out.println(list);
		
		Collections.reverse(list);//倒置排列
		System.out.println(list);
		
		Collections.sort(list);//递增排序
		System.out.println(list);
		
		int index = Collections.binarySearch(list, "gao3");//二分查找
		System.out.println(index);
	}
}
