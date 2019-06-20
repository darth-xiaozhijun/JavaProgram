package com.server.basic.servlet;

import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlUtils {

	public static void main(String[] args) throws Exception {
		
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2、从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		
		//3、编写处理器
		//4、加载文档 Document 注册处理器
		WebHandler webHandler = new WebHandler();
		
		//5、解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(
				"com/server/basic/servlet/web.xml"),webHandler);
		
		List<Entity> entities = webHandler.getEntities();
		for (Entity entity : entities) {
			System.out.println(entity);
		}
		List<Mapping> mappings = webHandler.getMappings();
		for (Mapping mapping : mappings) {
			System.out.println(mapping);
		}
		
		WebContext webContext = new WebContext(entities, mappings);
		String className = webContext.getClz("/g");
		Class<?> clz =  Class.forName(className);
		Servlet servlet =  (Servlet) clz.newInstance();
		servlet.Service(null, null);
	}
}

