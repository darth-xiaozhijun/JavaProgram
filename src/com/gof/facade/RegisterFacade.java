package com.gof.facade;

/**
 * 办理注册公司流程的门面对象
 * @author Administrator
 *
 */
public class RegisterFacade {
	public void register(){
		AIC  a = new HaiDianAIC();
		a.checkName();
		QID b = new HaiDianQID();
		b.orgCodeCertificate();
		SAT  c  = new HaiDianSAT();
		c.taxCertificate();
		Bank  d = new ICBC();
		d.openAccount();
	}
}
