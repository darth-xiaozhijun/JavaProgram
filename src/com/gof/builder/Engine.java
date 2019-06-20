package com.gof.builder;

/**
 * 发动机
 * @author Administrator
 *
 */
public class Engine {
	
	public Engine(String name){
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
