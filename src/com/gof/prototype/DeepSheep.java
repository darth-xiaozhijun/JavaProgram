package com.gof.prototype;

import java.util.Date;

public class DeepSheep implements Cloneable{

	private String name;
	
	private Date birthday;
	
	public DeepSheep() {
	}

	public DeepSheep(String name,Date birthday){
		this.name = name;
		this.birthday = birthday;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object object =  super.clone();//直接调用object对象的clone()方法！
		
		//添加如下代码实现深复制(deep Clone)
		DeepSheep deepSheep = (DeepSheep) object;
		deepSheep.birthday = (Date) this.birthday.clone();//把属性也进行克隆！
		
		return object;
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
