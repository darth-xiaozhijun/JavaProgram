package com.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlTest02 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2、从解析工厂获取解析器
		SAXParser parser = factory.newSAXParser();
		
		//3、编写处理器
		//4、加载文档 Document 注册处理器
		PersonV2Handler personHandler = new PersonV2Handler();
		
		//5、解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/server/basic/p.xml"), 
				personHandler);
		
		List<Person> persons = personHandler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName() + " " + person.getAge()); 
		}
	}
}

class PersonV2Handler extends DefaultHandler{
	
	private List<Person> persons;
	
	private Person person;
	
	private String tag;//储存标签
	
	public List<Person> getPersons() {
		return persons;
	}

	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(null != qName){
			tag = qName;
			if(qName.equals("person")){
				person = new Person();
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch,start,length).trim();
		
		if(null != tag){
			if(contents.length()>0) {
				if(tag.equals("name")){
					person.setName(contents);
					
				}else if (tag.equals("age")){
					person.setAge(Integer.valueOf(contents));
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(null != qName){
			if(qName.equals("person")){
				persons.add(person);
			}
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
	}
	
}
