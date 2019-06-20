package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.reflection.bean.User;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 * @author Administrator
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		
		String path = "com.reflection.bean.User";
		
		try {
			
			Class<?> clazz = Class.forName(path);
			
			//通过反射API调用构造方法，构造对象
			User user = (User) clazz.newInstance();
			System.out.println(user);//其实是调用了User的无参构造方法
			
			Constructor<User> constructor = (Constructor<User>) clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User user2 = constructor.newInstance(1001,18,"一");
			System.out.println(user2.getUname());
			
			//通过反射API调用普通方法
			User user3 = (User) clazz.newInstance();
			//u3.setUname("二");
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(user3, "二");
			System.out.println(user3.getUname());
			
			//通过反射API操作属性
			User user4 = (User) clazz.newInstance();
			Field field = clazz.getDeclaredField("uname");
			field.setAccessible(true);
			field.set(user4, "三");
			System.out.println(user4.getUname());
			System.out.println(field.get(user4));
			
		}catch (Exception e) {
				e.printStackTrace();
		}
	}
}

