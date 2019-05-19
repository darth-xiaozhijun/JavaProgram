package com.gof.factory.abstractfactory;

public class LuxuryTyre implements Tyre{

	@Override
	public void revolve() {
		System.out.println("旋转不磨损");
	}

}
