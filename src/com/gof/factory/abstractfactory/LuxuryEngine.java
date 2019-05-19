package com.gof.factory.abstractfactory;

public class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("转得快");
	}

	@Override
	public void start() {
		System.out.println("启动快，可以自动启停");
	}

}
