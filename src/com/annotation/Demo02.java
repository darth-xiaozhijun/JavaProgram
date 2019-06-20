package com.annotation;

@MyAnnotation01(studentName = "test",age = 18)
public class Demo02 {

	@MyAnnotation01(studentName = "test",schools = {"江西财大","南昌大学"})
	private void test() {
	}

	@MyAnnotation02("test02")
	private void test02() {
	}
}
