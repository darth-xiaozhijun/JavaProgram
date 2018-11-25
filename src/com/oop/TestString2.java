package com.oop;

public class TestString2 {
	
	public static void main(String[] args) {
		
		String s1 = "core Java";
		String s2 = "Core Java";
		
		System.out.println(s1.charAt(3));
		
		System.out.println(s2.length());
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		
		System.out.println(s1.indexOf("Java"));
		System.out.println(s1.indexOf("apple"));
		
		System.out.println(s1.replace(' ', '&'));
		
		
		String s3 = "";
		String s4 = "How are you?";
		
		System.out.println(s4.startsWith("How"));
		System.out.println(s4.endsWith("you"));
		
		System.out.println(s4.substring(4));
		System.out.println(s4.substring(4, 7));
		
		System.out.println(s4.toLowerCase());
		System.out.println(s4.toUpperCase());
		
		String s5 = " How are you ";
		System.out.println(s5.trim());
	}
}
