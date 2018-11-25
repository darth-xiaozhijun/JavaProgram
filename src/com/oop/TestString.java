package com.oop;

public class TestString {

	public static void main(String[] args) {
		
		String str = "abc";
		String str1 = new String("abc");
		
		String str2 = "abc" + "def";
		String str3 = "18" + 19;
		System.out.println(str3);
		
		String str4 = "gaoqi";
		String str5 = "gaoqi";
		String str6 = new String(str5);
		
		System.out.println(str4 == str5);
		System.out.println(str5 == str6);
		
		System.out.println(str5.equals(str6));
	}
}
