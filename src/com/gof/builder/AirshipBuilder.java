package com.gof.builder;

public interface AirshipBuilder {

	OrbitalModule builderOrbitalModule();
	
	Engine builderEngine();
	
	EscapeTower builderEscapeTower();
}
