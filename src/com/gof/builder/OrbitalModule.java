package com.gof.builder;

/**
 * 轨道舱
 * @author Administrator
 *
 */
public class OrbitalModule {
	
	public OrbitalModule(String name){
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
