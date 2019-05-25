package com.gof.facade;

public interface Bank {
	void  openAccount();  //开户
}


class ICBC implements Bank {

	@Override
	public void openAccount() {
		System.out.println("在中国工商银行开户！");
	}

}
