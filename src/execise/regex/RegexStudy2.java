package execise.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStudy2 {

	public static void main(String[] args) {
		
		String regex1 = "([a-z]+)([0-9]+)";//匹配字母数字下划线字符
		Pattern pattern = Pattern.compile(regex1);
		
		String testString = "aa123412**ba2341";
		Matcher matcher = pattern.matcher(testString);
		
		while(matcher.find()){
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}
	}
}
