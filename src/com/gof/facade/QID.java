package com.gof.facade;

public interface QID {
	void  orgCodeCertificate();  //办理组织机构代码证
}



class HaiDianQID implements QID {

	@Override
	public void orgCodeCertificate() {
		System.out.println("在海淀区质检局办理组织机构代码证！");
	}

}
