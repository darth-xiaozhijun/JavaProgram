package com.gof.proxy.dynamicproxy.enjoy;

/**
 * 真实对象
 * @author Administrator
 *
 */
public class WangMeiLi implements Girl{

	@Override
	public void date() {
		System.out.println("约会");
	}

	@Override
	public void watchMovie() {
		System.out.println("看电影");
	}

}
