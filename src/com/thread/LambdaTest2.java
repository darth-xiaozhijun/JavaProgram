package com.thread;

/**
 * Lambda表达式 + 参数
 * @author Administrator
 *
 */
public class LambdaTest2 {
	//静态内部类
	static class Love2 implements ILove{

		@Override
		public void lambda(int a) {
			System.out.println("i love lambda2 ---> " + a);
		}
		
	}
	
	public static void main(String[] args) {
		
		new Love().lambda(1);
		
		new Love2().lambda(2);
		
		//局部内部类
		class Love3 implements ILove{

			@Override
			public void lambda(int a) {
				System.out.println("i love lambda3 ----> " + a);
			}
		}
		
		new Love3().lambda(3);
		
		//匿名内部类
		new ILove() {
			
			@Override
			public void lambda(int a) {
				System.out.println("i love lambda4 ----> " + a);
			}
		}.lambda(4);
		
		//lambda表达式
		ILove love = (int a)->{
			System.out.println("i love lambda5 ----> " + a);
		};
		love.lambda(5);
		
		love = (a)->{
			System.out.println("i love lambda6 ----> " + a);
		};
		love.lambda(6);
		
		love = a->{
			System.out.println("i love lambda7 ----> " + a);
		};
		love.lambda(7);
		
		love = a->System.out.println("i love lambda8 ----> " + a);
		love.lambda(8);
	}

}

interface ILove{
	void lambda(int a);
}

class Love implements ILove{

	@Override
	public void lambda(int a) {

		System.out.println("i love lambda ---> " + a);
	}
	
}