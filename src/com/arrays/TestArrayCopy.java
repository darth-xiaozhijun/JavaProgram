package com.arrays;

/**
 * 测试数组的拷贝
 * @author Administrator
 *
 */
public class TestArrayCopy {

	public static void main(String[] args) {
		
		testBasicCopy();
		testDelByCopy();
		
		String[] s = {"a","b","c","d","e"};
		s = removeElement(s, 1);
		s = extendArray(s);
		for(int i=0; i<s.length; i++){
			System.out.println(i+"---"+s[i]);
		}
		
	}
	
	/**
	 * 数组拷贝的基本方法
	 */
	public static void testBasicCopy(){
		
		String[] s1 = {"aa","bb","cc","dd","ee"};
		String[] s2 = new String[10];
		System.arraycopy(s1, 2, s2, 6, 3);
		
		for(int i=0; i<s2.length; i++){
			System.out.println(i+"---"+s2[i]);
		}
	}
	
	/**
	 * 通过数组拷贝实现删除
	 */
	public static void testDelByCopy(){
		
		String[] s1 = {"aa","bb","cc","dd","ee"};
		System.arraycopy(s1, 3, s1, 3-1, s1.length-3);
		s1[s1.length -1] = null;
		
		for(int i=0; i<s1.length; i++){
			System.out.println(i+"---"+s1[i]);
		}
	}
	
	/**
	 * 删除数组中的一个元素
	 * @param s
	 * @param index
	 * @return
	 */
	public static String[] removeElement(String[] s,int index){
		
		System.arraycopy(s, index+1, s, index, s.length-index-1);
		s[s.length -1] = null;
		
		return s;
	}
	
	public static String[] extendArray(String[] array){
		
		String[] newArray = new String[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		
		return newArray;
	}
}
