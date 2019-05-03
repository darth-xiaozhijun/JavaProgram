package com.annotation;

import java.util.Date;

@SuppressWarnings("all")
public class TestOverride {

	@Override
	public String toString() {
		return "";
	}
	
	@Deprecated
	public static void test01(){
		System.out.println("test01");
	}
	
	public static void main(String[] args) {
		
		Date d = new Date();
		d.parse("2019-05-03 12:00:00");
		test01();
	}
}
