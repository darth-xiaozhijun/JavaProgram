package execise.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStudy4 {

	public static void main(String[] args) {
		
		String regex1 = "[0-9]";//匹配字母数字下划线字符
		Pattern pattern = Pattern.compile(regex1);
		
		String testString = "asbdfksdhfks$$sdkfjsisda2123412";
		Matcher matcher = pattern.matcher(testString);
		
		String repalce = "#";
		String newString = matcher.replaceAll(repalce);
		System.out.println(newString);
	}
}
