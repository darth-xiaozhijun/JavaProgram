package com.thread;

/**
 * Lambda表达式学习1
 * @author Administrator
 *
 */
public class LambdaTest1 {
	
	//静态内部类
	static class Like2 implements ILike{

		@Override
		public void lambda() {
			System.out.println("i like lambda2");
		}
		
	}
	
	public static void main(String[] args) {
		
		new Like().lambda();
		
		new Like2().lambda();
		
		//局部内部类
		class Test3 implements ILike{

			@Override
			public void lambda() {
				System.out.println("i like lambda3");
			}
		}
		
		new Test3().lambda();
		
		//匿名内部类
		new ILike() {
			
			@Override
			public void lambda() {
				System.out.println("i like lambda4");
			}
		}.lambda();
		
		//lambda表达式
		ILike like = ()->{
			System.out.println("i like lambda5");
		};
		like.lambda();
	}

}

interface ILike{
	void lambda();
}

class Like implements ILike{

	@Override
	public void lambda() {

		System.out.println("i like lambda");
	}
	
}