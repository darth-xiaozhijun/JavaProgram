package com.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.annotation.Filed;
import com.annotation.Table;

/**
 * 通过反射获取注解信息
 * @author Administrator
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		
		try {
			
			//获得类的所有有效注解
			Class<?> clazz = Class.forName("com.annotation.Student");
			Annotation[] annotations = clazz.getAnnotations();
			
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			//获得类的指定的注解
			Table table = (Table) clazz.getAnnotation(Table.class);
			System.out.println(table.value());
			
			//获得类的属性的注解
			Field filed = clazz.getDeclaredField("studentName");
			Filed f = filed.getAnnotation(Filed.class);
			System.out.println(f.columnName()+"--"+f.type()+"--"+f.length());
			
			//根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
