package com.server;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.server.basic.servlet.Servlet;
import com.server.basic.servlet.WebContext;
import com.server.basic.servlet.WebHandler;


public class WebApp {
	
	private static WebContext webContext;

	static{
		try {
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			SAXParser parser = factory.newSAXParser();
			
			WebHandler webHandler = new WebHandler();
			
			parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(
					"com/server/basic/servlet/web.xml"),webHandler);
			
			webContext = new WebContext(webHandler.getEntities(), webHandler.getMappings());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("解析配置文件出错");
		}
	}
	
	public static Servlet getServletFromUrl(String url){
		
		String className = webContext.getClz("/" + url);
		Class<?> clz;
		try {
			clz = Class.forName(className);
			Servlet servlet =  (Servlet) clz.newInstance();
			return servlet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
