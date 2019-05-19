package com.gof.builder;

/**
 * 逃逸塔
 * @author Administrator
 *
 */
public class EscapeTower {
	
	public EscapeTower(String name){
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
