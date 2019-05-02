package com.server.basic.servlet;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler {
	
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
