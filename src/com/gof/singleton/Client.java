package com.gof.singleton;

public class Client {

	public static void main(String[] args) {
		
		HungrySingleton hungrySingleton = HungrySingleton.getInstance();
		HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
		System.out.println(hungrySingleton);
		System.out.println(hungrySingleton2);
		
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
		System.out.println(enumSingleton);
		System.out.println(enumSingleton2);
	}
}
