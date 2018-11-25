package com.instance;

/**
 * 内部枚举类实现
 * @author Administrator
 *
 */
public class SingleInstanceFactory {

	private enum SingleInstanceEnum{
		
		SINGLE_INSTANCE;
		
		private SingleIntance7 singleIntance7;
		
		private SingleInstanceEnum(){
			singleIntance7 = new SingleIntance7();
		}
		
		public SingleIntance7 getSingleInstance7(){
			return singleIntance7;
		}
	}
	
	public static SingleIntance7 getSingleInstance7(){
		return SingleInstanceEnum.SINGLE_INSTANCE.getSingleInstance7();
	}
}

class SingleIntance7{
	public SingleIntance7(){}
}
