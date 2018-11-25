package execise.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {

	public static void main(String[] args) {
		
		String netEase = "http://www.163.com";
		String charset = "gbk";
		
//		String regex = "<a[\\s\\S]+?</a>";
//		String regex = "href=\".+?\"";
//		String regex = "href=\"(.+?)\"";
		String regex = "href=\"([\\w\\s./:]+?)\"";
		
		List<String> urlList = getWebUrl(netEase, charset, regex);
		for (String string : urlList) {
			System.out.println(string);
		}
	}
	
	public static List<String> getWebUrl(String urlAddr,String charset,String regex){
		
		List<String> list = new ArrayList<>();
		
		String urlContent = getWebContent(urlAddr,charset);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(urlContent);
		
		while(matcher.find()){
//			System.out.println(matcher.group());
//			System.out.println(matcher.group(1));
			list.add(matcher.group(1));
		}
		
		return list;
	}
	
	public static String getWebContent(String urlAddr,String charset){
		
		StringBuilder stringBuilder = new StringBuilder();
		try {
			
			URL url = new URL(urlAddr);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
			String temp = "";
			while((temp = bufferedReader.readLine()) != null) {
				stringBuilder.append(temp);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
}
