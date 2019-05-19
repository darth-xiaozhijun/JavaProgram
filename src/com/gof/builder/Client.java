package com.gof.builder;

public class Client {

	public static void main(String[] args) {
		
		AirshipDirector airshipDirector = new XzjAirshipDirector(new XzjAirshipBuilder());
		Airship airship = airshipDirector.directAirship();
		System.out.println(airship.getEngine().getName());
		
		airship.launch();
	}
}
