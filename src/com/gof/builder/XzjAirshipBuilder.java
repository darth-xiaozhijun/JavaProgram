package com.gof.builder;

public class XzjAirshipBuilder implements AirshipBuilder{

	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建xzj牌发动机");
		return new OrbitalModule("xzj牌发动机");
	}

	@Override
	public Engine builderEngine() {
		System.out.println("构建xzj牌引擎");
		return new Engine("xzj牌引擎");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		System.out.println("构建xzj牌逃逸舱");
		return new EscapeTower("xzj牌逃逸舱");
	}

}
