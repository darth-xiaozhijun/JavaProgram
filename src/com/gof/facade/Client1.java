package com.gof.facade;

public class Client1 {
	public static void main(String[] args) {
//		AIC  a = new HaiDianAIC();
//		a.checkName();
//		QID b = new HaiDianQID();
//		b.orgCodeCertificate();
//		SAT  c  = new HaiDianSAT();
//		c.taxCertificate();
//		Bank  d = new ICBC();
//		d.openAccount();
		
		new RegisterFacade().register();
		
	}
}
