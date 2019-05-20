package com.gof.proxy.staticproxy;

/**
 * 静态代理
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		
		Star realStar = new RealStar();
		
		Star proxyStar = new ProxyStar(realStar);
		
		proxyStar.confer();
		proxyStar.signContract();
		proxyStar.bookTicket();
		proxyStar.sing();
		proxyStar.collectMoney();
	}
}
