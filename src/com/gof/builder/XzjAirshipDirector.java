package com.gof.builder;

public class XzjAirshipDirector implements AirshipDirector{
	
	private AirshipBuilder builder;
	
	public XzjAirshipDirector(AirshipBuilder builder) {
		this.builder = builder;
	}

	@Override
	public Airship directAirship() {
		Engine engine = builder.builderEngine();
		OrbitalModule orbitalModule = builder.builderOrbitalModule();
		EscapeTower escapeTower = builder.builderEscapeTower();
		
		//装配成飞船对象
		Airship airship = new Airship();
		airship.setEngine(engine);
		airship.setEscapeTower(escapeTower);
		airship.setOrbitalModule(orbitalModule);
		return airship;
	}

}
