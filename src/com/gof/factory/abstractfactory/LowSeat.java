package com.gof.factory.abstractfactory;

public class LowSeat implements Seat{

	@Override
	public void message() {
		System.out.println("不能按摩");
	}

}
