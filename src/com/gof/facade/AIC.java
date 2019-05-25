package com.gof.facade;

public interface AIC  {
	void checkName();  //核名
}

class HaiDianAIC implements AIC {

	@Override
	public void checkName() {
		System.out.println("检查名字是否有冲突！");
	}

}
