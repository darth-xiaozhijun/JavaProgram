package com.gof.facade;

public interface SAT {
	void taxCertificate();  //办理税务登记证
}


class HaiDianSAT implements SAT {

	@Override
	public void taxCertificate() {
		System.out.println("在海淀税务局办理税务登记证！");
	}

}
