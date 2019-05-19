package com.gof.prototype;

import java.util.Date;

public class Sheep implements Cloneable{

	private String name;
	
	private Date birthday;
	
	public Sheep() {
	}

	public Sheep(String name,Date birthday){
		this.name = name;
		this.birthday = birthday;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();//直接调用object对象的clone()方法！
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
