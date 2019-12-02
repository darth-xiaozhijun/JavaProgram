package com.oop;

public class TestInterface2 implements C{

	@Override
	public void testA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testC() {
		// TODO Auto-generated method stub
		
	}

	
}

interface A{
	void testA();
}

interface B{
	void testB();
}

/**
 * 接口的多继承
 * @author Administrator
 *
 */
interface C extends A,B{
	void testC();
}
