package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStudy {

	public static void main(String[] args) {
		
		String regex1 = "\\w+";//匹配字母数字下划线字符
		Pattern pattern = Pattern.compile(regex1);
		
		String testString = "asbdfksdhfks$$sdkfjsisda2123412";
		Matcher matcher = pattern.matcher(testString);
		
//		boolean isMatch = matcher.matches();//是否匹配,将整个字符串进行匹配
//		
//		System.out.println(isMatch);
		
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
//		
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
//		
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
		
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
}
