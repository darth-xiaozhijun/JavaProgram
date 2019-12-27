package com.gof.proxy.dynamicproxy.enjoy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象
 * @author Administrator
 *
 */
public class WangMeiLiProxy implements InvocationHandler{
	
	private Girl girl;
	
	public WangMeiLiProxy(Girl girl) {
		this.girl = girl;
	}
	
	private void before(){
		System.out.println("前置");
	}
	
	private void after(){
		System.out.println("后置");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object object = method.invoke(girl, args);
		after();
		return object;
	}

	public Object getProxyInstance(){
		return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
	}
}
