package com.server.basic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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

class WebHandler extends DefaultHandler{
	
	private List<Entity> entities = new ArrayList<>();
	
	private List<Mapping> mappings = new ArrayList<>();
	
	private Entity entity;
	
	private Mapping mapping;
	
	private String tag;//储存标签
	
	private boolean isMapping;
	
	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(null != qName){
			tag = qName;
			if(qName.equals("servlet")){
				entity = new Entity();
			}else if(qName.equals("servlet-mapping")){
				mapping = new Mapping();
				isMapping = true;
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		
		if(null != tag){
			if(contents.length()>0) {
				if(isMapping){
					if(tag.equals("servlet-name")){
						mapping.setName(contents);
					}else if (tag.equals("url-pattern")){
						mapping.addPattern(contents);
					}
				}else{
					if(tag.equals("servlet-name")){
						entity.setName(contents);
					}else if (tag.equals("servlet-class")){
						entity.setClz(contents);
					}
				}
				
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(null != qName){
			if(qName.equals("servlet")){
				entities.add(entity);
			}else if(qName.equals("servlet-mapping")){
				mappings.add(mapping);
			}
		}
	}
	
}
