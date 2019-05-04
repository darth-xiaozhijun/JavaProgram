package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo03 {

	public static void main(String[] args) {
		
		try {
			
			Class clazz = Class.forName("com.annotation.Student");
			Annotation[] annotations = clazz.getAnnotations();
			
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			Table table = (Table) clazz.getAnnotation(Table.class);
			System.out.println(table.value());
			
			Field filed = clazz.getDeclaredField("studentName");
			Filed f = filed.getAnnotation(Filed.class);
			System.out.println(f.columnName()+"--"+f.type()+"--"+f.length());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
