package com.regex;

import java.util.Arrays;

public class RegexStudy3 {

	public static void main(String[] args) {
		
		String regex1 = "\\d+";//匹配字母数字下划线字符
		
		String testString = "a12412b21421c8823d";
		
		String[] newString = testString.split(regex1);
		System.out.println(Arrays.toString(newString));
	}
}
